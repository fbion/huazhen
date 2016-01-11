package com.hzfh.fmp.controller.product.ajax;

import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.query.DecisionCondition;
import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.product.DecisionModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.ProductTaskModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxDecisionAction extends JqGridBaseAction<Decision> {

    private String productNo;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    private String depNo;

    public String getDepNo() {
        return depNo;
    }

    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    private String isOk;

    public String getIsOk() {
        return isOk;
    }

    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }

    private String checkTime;

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    private String empNo;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String execute() throws Exception {
        DecisionCondition decisionCondition = new DecisionCondition();
        decisionCondition.setPageSize(this.getPageSize());
        decisionCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        decisionCondition.setSortItemList(sortItemList);

        PagedList<Decision> decisionPagedList = DecisionModel.getPagingList(decisionCondition);
        this.setResultList(decisionPagedList.getResultList());
        this.setPageCount(decisionPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(decisionPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(decisionPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        Decision decision = new Decision();
        //int productNo =  DecisionModel.getInfo(Integer.parseInt(this.getId())).getProductNo();
        decision.setProductNo(Integer.parseInt(this.productNo));
        decision.setDepNo(Integer.parseInt(this.depNo));
        decision.setIsOk(Byte.parseByte(this.isOk));
        //decision.setCheckTime(Timestamp.valueOf(this.checkTime));
        decision.setEmpNo(UserHelper.getEditUserNo());
        //decision.setSort(Integer.parseInt(this.sort));
        decision.setEditComment(this.getEditComment());
        decision.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
            decision.setInUserNo(UserHelper.getEditUserNo());
            if (DecisionModel.add(decision) <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        } else {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    decision.setId(Integer.parseInt(this.getId()));
                    decision.setEditUserNo(UserHelper.getEditUserNo());
                    if (DecisionModel.update(decision) <= 0) {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    } else {
                        List<Decision> decisionList = DecisionModel.getListByProductNo(decision.getProductNo());
                        boolean bAllOK = true;
                        for(Decision decision1 : decisionList){
                            if (decision1.getIsOk() != 1){
                                bAllOK = false;
                                break;
                            }
                        }
                        if (bAllOK) {
                            //int id = Integer.parseInt(this.getId());
                            if (ProductModel.updateStatus(decision.getProductNo(), ProductStatus.PREPARE) <= 0) {
                                this.setErrCode("update failed");
                                this.setErrDesc("update failed");
                            } else {
                                this.setErrDesc(String.valueOf(ProductStatus.PREPARE));
                                for (int i : DeptHelper.DEPT_SALES_CHANNEL) {
                                    this.insertTask(decision.getProductNo(), i);
                                }
                                for (int j : DeptHelper.DEPT_SALES_DIRECT) {
                                    this.insertTask(decision.getProductNo(), j);
                                }
                            }
                        }
                    }
                }
            }
        }

        return SUCCESS;
    }

    public String getListByProductNo() {
        if (StringHelper.isNullOrEmpty(this.productNo)) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.setResultList(DecisionModel.getListByProductNo(Integer.parseInt(this.productNo)));
        }
        return SUCCESS;
    }

    private int insertTask(int productNo, int departmentNo) {
        ProductTask productTask = new ProductTask();
        productTask.setProductNo(productNo);
        productTask.setDeptNo(departmentNo);
        productTask.setStatus((byte) 0);
        return ProductTaskModel.add(productTask);
    }

}
