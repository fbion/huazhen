package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.model.query.TaskDecisionCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.enumeration.TaskStatus;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.ProductTaskModel;
import com.hzfh.fmp.model.sales.TaskDecisionModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class AjaxTaskDecisionAction extends JqGridBaseAction<TaskDecision> {

    private String productTaskNo;

    public String getProductTaskNo() {
        return productTaskNo;
    }

    public void setProductTaskNo(String productTaskNo) {
        this.productTaskNo = productTaskNo;
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

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    private String productNo;

    @Override
    public String execute() throws Exception {
        TaskDecisionCondition taskDecisionCondition = new TaskDecisionCondition();
        taskDecisionCondition.setPageSize(this.getPageSize());
        taskDecisionCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        taskDecisionCondition.setSortItemList(sortItemList);

        PagedList<TaskDecision> taskDecisionPagedList = TaskDecisionModel.getPagingList(taskDecisionCondition);
        this.setResultList(taskDecisionPagedList.getResultList());
        this.setPageCount(taskDecisionPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(taskDecisionPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(taskDecisionPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() throws ParseException {
        TaskDecision taskDecision = new TaskDecision();
		taskDecision.setEditUserNo(UserHelper.getEditUserNo());

        taskDecision.setProductTaskNo(Integer.parseInt(this.productTaskNo));
        taskDecision.setDepNo(Integer.parseInt(this.depNo));
        taskDecision.setIsOk(Byte.parseByte(this.isOk));
        //taskDecision.setCheckTime(DateHelper.parse(this.checkTime));
        taskDecision.setEmpNo(UserHelper.getEditUserNo());
        //taskDecision.setSort(Integer.parseInt(this.sort));
        taskDecision.setEditComment(this.getEditComment());

        if (this.getOper().equalsIgnoreCase("add")) {
        	taskDecision.setInUserNo(UserHelper.getEditUserNo());
            if (TaskDecisionModel.add(taskDecision )<=0){
               this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        } else {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    taskDecision.setId(Integer.parseInt(this.getId()));
                    taskDecision.setEditUserNo(UserHelper.getEditUserNo());
                    if (TaskDecisionModel.update(taskDecision) <= 0) {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    } else {
                        if (taskDecision.getDepNo() == DeptHelper.DEPT_PRESIDENT && taskDecision.getIsOk() == 1) {
                            //int id = Integer.parseInt(this.getId());
                            if (!StringHelper.isNullOrEmpty(this.productNo)) {
                                int productNo = Integer.parseInt(this.productNo);
                                ProductTask productTask = new ProductTask();
                                productTask.setId(taskDecision.getProductTaskNo());
                                productTask.setStatus(TaskStatus.AUDIT);
                                productTask.setEditUserNo(UserHelper.getEditUserNo());
                                if (ProductTaskModel.updateStatus(productTask) > 0) {
                                    this.setErrDesc(String.valueOf(TaskStatus.AUDIT));
                                    if (this.needUpdateStatus(taskDecision.getProductTaskNo(), productNo)) {
                                        if (ProductModel.updateStatus(Integer.parseInt(this.productNo), ProductStatus.PREHEAT) <= 0) {
                                            this.setErrCode("update failed");
                                            this.setErrDesc("update failed");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return SUCCESS;
    }

    private boolean needUpdateStatus(int taskNo, int productNo) {
        boolean bUpdate = true;
        List<ProductTask> productTaskList = ProductTaskModel.getListByProductNo(productNo);
        if (productTaskList != null) {
            for (ProductTask productTask : productTaskList) {
                if (productTask.getStatus() != TaskStatus.AUDIT) {
                    bUpdate = false;
                    break;
                }
            }
        }
        return bUpdate;
    }

    public String getListByTaskNo() {
        if (StringHelper.isNullOrEmpty(this.productTaskNo)) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.setResultList(TaskDecisionModel.getListByTaskNo(Integer.parseInt(this.productTaskNo)));
        }
        return SUCCESS;
    }
}
