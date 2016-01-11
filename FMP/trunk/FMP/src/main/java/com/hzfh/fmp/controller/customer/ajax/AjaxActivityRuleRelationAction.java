package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.query.ActivityRuleRelationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivityConditionModel;
import com.hzfh.fmp.model.customer.ActivityRuleRelationModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityRuleRelationAction extends JqGridBaseAction<ActivityRuleRelation> {
	private ActivityRuleRelation info;
	public ActivityRuleRelation getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityRuleRelation.class);
    }

    private int count;
    
    public int getCount() {
		return count;
	}

	@Override
    public String execute(){
    	ActivityRuleRelationCondition activityRuleRelationCondition = new ActivityRuleRelationCondition();
        activityRuleRelationCondition.setPageSize(this.getPageSize());
        activityRuleRelationCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityRuleRelationCondition.setSortItemList(sortItemList);

        PagedList<ActivityRuleRelation> activityRuleRelationPagedList= ActivityRuleRelationModel.getPagingList(activityRuleRelationCondition);
        this.setResultList(activityRuleRelationPagedList.getResultList());
        this.setPageCount(activityRuleRelationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityRuleRelationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityRuleRelationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityRuleRelationModel.add(info);
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
                    if (ActivityRuleRelationModel.update(info) > 0){
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
            this.info = ActivityRuleRelationModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
	public String getInfoByActId() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
        	List<ActivityRuleRelation> list = new ArrayList<ActivityRuleRelation>();
        	list = ActivityRuleRelationModel.getInfoByActivityNo(Integer.parseInt(this.getId()));
            this.count = list.size();
//            if (this.info == null) {
//                this.setErrCode("No Info");
//                this.setErrDesc("No Info");
//            }
        }

        return SUCCESS;
    }

}
