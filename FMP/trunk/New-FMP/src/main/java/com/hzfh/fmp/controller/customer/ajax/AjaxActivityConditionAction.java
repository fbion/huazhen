package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.query.ActivityConditionCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivitiesModel;
import com.hzfh.fmp.model.customer.ActivityConditionModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityConditionAction extends JqGridBaseAction<ActivityCondition> {
	private ActivityCondition info;
	public ActivityCondition getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityCondition.class);
    }
    
    private int aId;
    
    public void setaId(int aId) {
		this.aId = aId;
	}
    
    private int actType;

	public int getActType() {
		return actType;
	}

	@Override
    public String execute(){
		System.out.println(aId);
    	ActivityConditionCondition activityConditionCondition = new ActivityConditionCondition();
        activityConditionCondition.setPageSize(this.getPageSize());
        activityConditionCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityConditionCondition.setSortItemList(sortItemList);

        PagedList<ActivityCondition> activityConditionPagedList= ActivityConditionModel.getPagingList(activityConditionCondition);
        this.setResultList(activityConditionPagedList.getResultList());
        this.setPageCount(activityConditionPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityConditionPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityConditionPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityConditionModel.add(info);
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
                    if (ActivityConditionModel.update(info) > 0){
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
            this.info = ActivityConditionModel.getInfo(Integer.parseInt(this.getId()));
            this.actType = ActivityConditionModel.getActInfoByAcId(Integer.parseInt(this.getId()));
//            if (this.info == null) {
//                this.setErrCode("No Info");
//                this.setErrDesc("No Info");
//            }
        }

        return SUCCESS;
    }

}
