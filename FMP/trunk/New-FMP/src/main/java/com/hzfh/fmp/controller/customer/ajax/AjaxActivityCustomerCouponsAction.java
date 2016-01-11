package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.ActivityCustomerCoupons;
import com.hzfh.api.customer.model.query.ActivityCustomerCouponsCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivityCustomerCouponsModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityCustomerCouponsAction extends JqGridBaseAction<ActivityCustomerCoupons> {
	private ActivityCustomerCoupons info;
	public ActivityCustomerCoupons getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityCustomerCoupons.class);
    }

    @Override
    public String execute(){
    	ActivityCustomerCouponsCondition activityCustomerCouponsCondition = new ActivityCustomerCouponsCondition();
        activityCustomerCouponsCondition.setPageSize(this.getPageSize());
        activityCustomerCouponsCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityCustomerCouponsCondition.setSortItemList(sortItemList);

        PagedList<ActivityCustomerCoupons> activityCustomerCouponsPagedList= ActivityCustomerCouponsModel.getPagingList(activityCustomerCouponsCondition);
        this.setResultList(activityCustomerCouponsPagedList.getResultList());
        this.setPageCount(activityCustomerCouponsPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityCustomerCouponsPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityCustomerCouponsPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityCustomerCouponsModel.add(info);
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
                
        }
        else
        {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {                    
                    if (ActivityCustomerCouponsModel.update(info) > 0){
						this.setErrDesc(String.valueOf(info.getId()));
                    }else{
						this.setErrCode("update failed");
                        this.setErrDesc("update failed");
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
            this.info = ActivityCustomerCouponsModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
