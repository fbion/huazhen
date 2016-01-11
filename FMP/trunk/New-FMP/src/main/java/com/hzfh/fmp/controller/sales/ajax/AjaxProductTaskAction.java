package com.hzfh.fmp.controller.sales.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.EmployeeEducation;
import com.hzfh.api.employee.model.ProbationWorkSummary;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.model.query.ProductTaskCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.sales.ProductTaskModel;
import com.hzfh.fmp.model.sales.TaskDecisionModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxProductTaskAction extends JqGridBaseAction<ProductTask> {

    private ProductTask info;

    public void setInfo(String info) {
        this.info = JSON.parseObject(info,ProductTask.class);
    }

    public ProductTask getInfo() {
        return info;
    }

    private String byProduct;
    private String byDept;
    private String byStatus;

    public void setByProduct(String byProduct) {
        this.byProduct = byProduct;
    }

    public void setByDept(String byDept) {
        this.byDept = byDept;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }

    private List<ProductTask> productExamineList;

    public List<ProductTask> getProductExamineList() {
        return productExamineList;
    }
    public void setProductExamineList(String productExamineList) {
        List<ProductTask> productExamineList1 = new ArrayList<>();
        for (int i = 0; i < JSON.parseArray(productExamineList).size(); i++) {
            String employeeStr = JSON.toJSONString(JSON.parseArray(productExamineList).get(i));
            ProductTask productTask = JSON.parseObject(employeeStr, ProductTask.class);
            productExamineList1.add(productTask);
        }
        this.productExamineList = productExamineList1;
    }
    @Override
    public String execute() throws Exception {
        ProductTaskCondition productTaskCondition = new ProductTaskCondition();
        productTaskCondition.setPageSize(this.getPageSize());
        productTaskCondition.setPageIndex(this.getPageIndex());
        if(StringHelper.isNullOrEmpty(this.byProduct)){
            productTaskCondition.setProduct(0);
        }else{
            productTaskCondition.setProduct(Integer.parseInt(this.byProduct));
        }
        if(StringHelper.isNullOrEmpty(this.byDept)){
            productTaskCondition.setDept(0);
        }else{
            productTaskCondition.setDept(Integer.parseInt(this.byDept));
        }
        if(StringHelper.isNullOrEmpty(this.byStatus)){
            productTaskCondition.setStatus((byte) -1);
        }else{
            productTaskCondition.setStatus(Byte.valueOf(this.byStatus));
        }
        if(StringHelper.isNullOrEmpty(this.getIsTest())){
        	productTaskCondition.setIsTest((byte)0);
        }else{
        	productTaskCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        productTaskCondition.setSortItemList(sortItemList);

        PagedList<ProductTask> productTaskPagedList = ProductTaskModel.getPagingList(productTaskCondition);
        this.setResultList(productTaskPagedList.getResultList());
        this.setPageCount(productTaskPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(productTaskPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(productTaskPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        for(ProductTask info:this.productExamineList){
            info.setEditUserNo(UserHelper.getEditUserNo());

            if (this.getOper().equalsIgnoreCase("add")) {
                info.setCurrAmout(0);
                info.setInUserNo(UserHelper.getEditUserNo());
                if (ProductTaskModel.add(info) <= 0) {
                    this.setErrCode("add failed");
                    this.setErrDesc("add failed");
                }
            } else {
                if (info.getId() == 0) {
                    this.setErrCode("NoID");
                    this.setErrDesc("NoID");
                } else {
                    if (this.getOper().equalsIgnoreCase("edit")) {
                        info.setId(info.getId());

                        if (info.getStatus() == 0){
                            info.setStatus((byte)1);
                            this.insertTaskReview(info.getId(), DeptHelper.DEPT_RISK_CONTROL);
                            this.insertTaskReview(info.getId(), DeptHelper.DEPT_FINANCE);
                            this.insertTaskReview(info.getId(), DeptHelper.DEPT_PRESIDENT);
                        }

                        if (ProductTaskModel.update(info) <= 0) {
                            this.setErrCode("update failed");
                            this.setErrDesc("update failed");
                        }
                    }
                }
            }

        }

        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = ProductTaskModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info== null) {
                this.setErrCode("NoProduct");
                this.setErrDesc("NoProduct");
            }else            {
                List<ProductTask> productTaskList = ProductTaskModel.getListByProductNo(this.info.getProductNo());
            }
        }

        return SUCCESS;
    }

    private int insertTaskReview(int taskNo,int departmentNo){
        TaskDecision taskDecision = new TaskDecision();
        taskDecision.setProductTaskNo(taskNo);
        taskDecision.setDepNo(departmentNo);
        taskDecision.setIsOk((byte)0);
        return TaskDecisionModel.add(taskDecision);
    }
    private String productNo;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getTaskByProductNo(){
        if (StringHelper.isNullOrEmpty(this.productNo)) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.productExamineList = ProductTaskModel.getListByProductNo(Integer.parseInt(this.productNo));
            if (this.productExamineList== null) {
                this.setErrCode("NoProduct");
                this.setErrDesc("NoProduct");
            }
//            else            {
//                List<ProductTask> productTaskList = ProductTaskModel.getListByProductNo(this.info.getProductNo());
//            }
        }

        return SUCCESS;
    }
}
