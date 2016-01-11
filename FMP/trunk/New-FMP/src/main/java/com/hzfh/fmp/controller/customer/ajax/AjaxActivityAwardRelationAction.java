package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.ActivityAwardRelationShow;
import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.ActivityCoupons;
import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.ActivityIntegral;
import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivityAwardRelationModel;
import com.hzfh.fmp.model.customer.ActivityCashBonusModel;
import com.hzfh.fmp.model.customer.ActivityCouponsModel;
import com.hzfh.fmp.model.customer.ActivityExperienceGoldModel;
import com.hzfh.fmp.model.customer.ActivityIntegralModel;
import com.hzfh.fmp.model.customer.ActivityPresentModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityAwardRelationAction extends JqGridBaseAction<ActivityAwardRelationShow> {
	private String conditionID;
	
	public void setConditionID(String conditionID) {
		this.conditionID = conditionID;
	}

	private ActivityAwardRelation info;
	public ActivityAwardRelation getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityAwardRelation.class);
    }

    @Override
    public String execute(){
    	ActivityAwardRelationCondition activityAwardRelationCondition = new ActivityAwardRelationCondition();
        activityAwardRelationCondition.setPageSize(this.getPageSize());
        activityAwardRelationCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityAwardRelationCondition.setSortItemList(sortItemList);
        
        PagedList<ActivityAwardRelation> activityAwardRelationPagedList= ActivityAwardRelationModel.getPagingList(activityAwardRelationCondition);
        List<ActivityAwardRelation> tList = new ArrayList<ActivityAwardRelation>();
        List<ActivityAwardRelationShow> tList2 = new ArrayList<ActivityAwardRelationShow>();
        tList = ActivityAwardRelationModel.getList();
        for (int i = 0; i < tList.size(); i++) {
        	if(tList.get(i).getConditionId()==Integer.parseInt(this.conditionID)){
        		ActivityAwardRelation relation = new ActivityAwardRelation();
            	ActivityAwardRelationShow relation2 = new ActivityAwardRelationShow();
            	relation = tList.get(i);
            	int cId = relation.getRelatedNo();
            	String a  = "";String b  = "";String c  = "";String d  = "";
            	if(cId!=0){
            		if(relation.getActivityRewardType()==1){
            			ActivityExperienceGold gold = new ActivityExperienceGold();
            			gold = ActivityExperienceGoldModel.getInfo(cId);
            			a = gold.getGoldMoney()+"";
            			b = gold.getDay()+"";
            		}else if(relation.getActivityRewardType()==2){
            			ActivityCashBonus bonus = new ActivityCashBonus(); 
            			bonus = ActivityCashBonusModel.getInfo(cId);
            			a = bonus.getMoney()+"";
            		}else if(relation.getActivityRewardType()==3){
            			ActivityCoupons coupons = new ActivityCoupons();
            			coupons = ActivityCouponsModel.getInfo(cId);
            			a = coupons.getCouponsValue()+"";
            			b = coupons.getCouponsTotal()+"";
            			c = coupons.getCouponsStartTime()+"";
            			d = coupons.getCouponsEndTime()+"";
            		}else if(relation.getActivityRewardType()==4){
            			ActivityIntegral integral = new ActivityIntegral();
            			integral = ActivityIntegralModel.getInfo(cId);
            			a = integral.getIntegralCount()+"";
            			b = integral.getInTime()+"";
            			c = integral.getExpireTime()+"";
            		}else if(relation.getActivityRewardType()==5){
            			ActivityPresent present = new ActivityPresent();
            			present = ActivityPresentModel.getInfo(cId);
            			a = present.getPresentName();
            			b = present.getPresentPrice()+"";
            			c = present.getPresentCount()+"";
            			d = present.getGetPresentTime()+"";
            		}
            	}
            	relation2.setActivityRewardType(relation.getActivityRewardType());
            	relation2.setConditionId(relation.getConditionId());
            	relation2.setEditComment(relation.getEditComment());
            	relation2.setId(relation.getId());
            	relation2.setRelatedNo(relation.getRelatedNo());
            	relation2.setEditTime(relation.getEditTime());
            	relation2.setEditUserNo(relation.getEditUserNo());
            	relation2.setInTime(relation.getInTime());
            	relation2.setInUserNo(relation.getInUserNo());
            	relation2.setA(a);
            	relation2.setB(b);
            	relation2.setC(c);
            	relation2.setD(d);
            	tList2.add(relation2);
        	}
		}
        this.setResultList(tList2);
        this.setPageCount(activityAwardRelationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityAwardRelationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityAwardRelationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityAwardRelationModel.add(info);
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
                    if (ActivityAwardRelationModel.update(info) > 0){
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
            this.info = ActivityAwardRelationModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
