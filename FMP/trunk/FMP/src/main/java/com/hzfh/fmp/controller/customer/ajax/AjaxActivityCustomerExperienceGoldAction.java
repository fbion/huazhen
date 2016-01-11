package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.query.ActivityCustomerExperienceGoldCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivityCustomerExperienceGoldModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityCustomerExperienceGoldAction extends JqGridBaseAction<ActivityCustomerExperienceGold> {
	private ActivityCustomerExperienceGold info;
	public ActivityCustomerExperienceGold getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityCustomerExperienceGold.class);
    }

    @Override
    public String execute(){
    	ActivityCustomerExperienceGoldCondition activityCustomerExperienceGoldCondition = new ActivityCustomerExperienceGoldCondition();
        activityCustomerExperienceGoldCondition.setPageSize(this.getPageSize());
        activityCustomerExperienceGoldCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityCustomerExperienceGoldCondition.setSortItemList(sortItemList);

        PagedList<ActivityCustomerExperienceGold> activityCustomerExperienceGoldPagedList= ActivityCustomerExperienceGoldModel.getPagingList(activityCustomerExperienceGoldCondition);
        this.setResultList(activityCustomerExperienceGoldPagedList.getResultList());
        this.setPageCount(activityCustomerExperienceGoldPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityCustomerExperienceGoldPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityCustomerExperienceGoldPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityCustomerExperienceGoldModel.add(info);
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
                    if (ActivityCustomerExperienceGoldModel.update(info) > 0){
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
            this.info = ActivityCustomerExperienceGoldModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
