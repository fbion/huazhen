package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.query.ActivityCustomerInvitationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivitiesModel;
import com.hzfh.fmp.model.customer.ActivityAwardRelationModel;
import com.hzfh.fmp.model.customer.ActivityCashBonusModel;
import com.hzfh.fmp.model.customer.ActivityConditionModel;
import com.hzfh.fmp.model.customer.ActivityCustomerCashBonusModel;
import com.hzfh.fmp.model.customer.ActivityCustomerExperienceGoldModel;
import com.hzfh.fmp.model.customer.ActivityCustomerInvitationModel;
import com.hzfh.fmp.model.customer.ActivityExperienceGoldModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityCustomerInvitationAction extends JqGridBaseAction<ActivityCustomerInvitation> {
	private String byIsPayment;
	
	public void setByIsPayment(String byIsPayment) {
		this.byIsPayment = byIsPayment;
	}
	private String byIsType;

	public void setByIsType(String byIsType) {
		this.byIsType = byIsType;
	}
	private String actID;
	
	public void setActID(String actID) {
		this.actID = actID;
	}
	private String status;

	public void setStatus(String status) {
		this.status = status;
	}
	private ActivityCustomerInvitation info;
	public ActivityCustomerInvitation getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityCustomerInvitation.class);
    }

    @Override
    public String execute(){
    	ActivityCustomerInvitationCondition activityCustomerInvitationCondition = new ActivityCustomerInvitationCondition();
        activityCustomerInvitationCondition.setPageSize(this.getPageSize());
        activityCustomerInvitationCondition.setPageIndex(this.getPageIndex());
        boolean flag = false;
        if(!StringHelper.isNullOrEmpty(this.actID)){
        	if(Integer.parseInt(this.actID)==0){
        		flag = true;
                activityCustomerInvitationCondition.setActivityNo(99999999);
        	}else{
                activityCustomerInvitationCondition.setActivityNo(Integer.parseInt(this.actID));
                Activities activities = new Activities();
                activities = ActivitiesModel.getInfo(Integer.parseInt(this.actID));
                activityCustomerInvitationCondition.setAuthenticationTime(activities.getEndTime());
        	}
        }
        if(!StringHelper.isNullOrEmpty(this.status)){
            activityCustomerInvitationCondition.setStatus((byte)Integer.parseInt(this.status));
        }
        List<ActivityCustomerInvitation> list = new ArrayList<ActivityCustomerInvitation>();
        if(!StringHelper.isNullOrEmpty(this.byIsPayment)){
        	Activities activities = new Activities();
            activities = ActivitiesModel.getInfo(Integer.parseInt(this.actID));
            int type = 0;
            if(!StringHelper.isNullOrEmpty(this.byIsType)){
            	type = Integer.parseInt(this.byIsType);
            }
        	list = ActivityCustomerInvitationModel.getListByCashBonusStatusAndId(Integer.parseInt(this.actID),Integer.parseInt(this.status),Integer.parseInt(this.byIsPayment),activities.getEndTime(),type);
        }
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityCustomerInvitationCondition.setSortItemList(sortItemList);

        PagedList<ActivityCustomerInvitation> activityCustomerInvitationPagedList= ActivityCustomerInvitationModel.getPagingList(activityCustomerInvitationCondition);
        if(!StringHelper.isNullOrEmpty(this.byIsPayment) && !flag){
            this.setResultList(this.getRelationMoney(list));
        }else{
            this.setResultList(this.getRelationMoney(activityCustomerInvitationPagedList.getResultList()));
        }
        this.setPageCount(activityCustomerInvitationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityCustomerInvitationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityCustomerInvitationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public List<ActivityCustomerInvitation> getRelationMoney(List<ActivityCustomerInvitation> list){
    	for (ActivityCustomerInvitation activityCustomerInvitation : list) {
    		int relatedNo = activityCustomerInvitation.getRelatedNo();
			if(activityCustomerInvitation.getActivityRewardType()==1){
				int gold = ActivityCustomerExperienceGoldModel.getInfo(relatedNo).getExperienceGoldNo();
				ActivityExperienceGold activityExperienceGold = new ActivityExperienceGold();
				activityExperienceGold = ActivityExperienceGoldModel.getInfo(gold);
				if(activityExperienceGold!=null){
					
					activityCustomerInvitation.setMoney("体验金："+activityExperienceGold.getGoldMoney());
					activityCustomerInvitation.setType(1);
					
					activityCustomerInvitation.setTrueMoney(
							(activityCustomerInvitation.getRewardsMoney()));
				}
			}else if(activityCustomerInvitation.getActivityRewardType()==2){
				activityCustomerInvitation.setMoney("现金："+activityCustomerInvitation.getRewardsMoney());
				activityCustomerInvitation.setType(2);
				activityCustomerInvitation.setTrueMoney(activityCustomerInvitation.getRewardsMoney());
			}
		}
    	return list;
    }
    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityCustomerInvitationModel.add(info);
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
                    if (ActivityCustomerInvitationModel.update(info) > 0){
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
            this.info = ActivityCustomerInvitationModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
