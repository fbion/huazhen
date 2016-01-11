package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.query.ActivityConditionRelationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivityConditionRelationModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityConditionRelationAction extends JqGridBaseAction<ActivityConditionRelation> {
	private ActivityConditionRelation info;
	public ActivityConditionRelation getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityConditionRelation.class);
    }

    @Override
    public String execute(){
    	ActivityConditionRelationCondition activityConditionRelationCondition = new ActivityConditionRelationCondition();
        activityConditionRelationCondition.setPageSize(this.getPageSize());
        activityConditionRelationCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityConditionRelationCondition.setSortItemList(sortItemList);

        PagedList<ActivityConditionRelation> activityConditionRelationPagedList= ActivityConditionRelationModel.getPagingList(activityConditionRelationCondition);
        this.setResultList(activityConditionRelationPagedList.getResultList());
        this.setPageCount(activityConditionRelationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityConditionRelationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityConditionRelationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityConditionRelationModel.add(info);
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
                    if (ActivityConditionRelationModel.update(info) > 0){
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
            this.info = ActivityConditionRelationModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
