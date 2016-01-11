package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.ActivityConditionRelation;
import com.hzfh.api.customer.model.ActivityCoupons;
import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.ActivityIntegral;
import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.ActivityRuleRelation;
import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.ActivitiesCondition;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.constant.CardStatus;
import com.hzfh.api.payment.model.common.constant.ServiceStates;
import com.hzfh.api.payment.model.common.constant.TransferStatus;
import com.hzfh.api.payment.model.common.entity.Detail;
import com.hzfh.api.payment.model.common.entity.Details;
import com.hzfh.api.payment.model.common.entity.Repayment;
import com.hzfh.api.payment.model.request.controller.CompleteTransactionReq;
import com.hzfh.api.payment.model.request.gateway.CpTransactionReq;
import com.hzfh.api.payment.model.response.controller.CompleteTransactionResp;
import com.hzfh.api.product.model.Product;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.controller.payment.ajax.AjaxPaymentRefundAction;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.baseInfo.DicTypeModel;
import com.hzfh.fmp.model.customer.ActivitiesModel;
import com.hzfh.fmp.model.customer.ActivityAwardRelationModel;
import com.hzfh.fmp.model.customer.ActivityCashBonusModel;
import com.hzfh.fmp.model.customer.ActivityConditionModel;
import com.hzfh.fmp.model.customer.ActivityConditionRelationModel;
import com.hzfh.fmp.model.customer.ActivityCouponsModel;
import com.hzfh.fmp.model.customer.ActivityCustomerCashBonusModel;
import com.hzfh.fmp.model.customer.ActivityCustomerInvitationModel;
import com.hzfh.fmp.model.customer.ActivityExperienceGoldModel;
import com.hzfh.fmp.model.customer.ActivityIntegralModel;
import com.hzfh.fmp.model.customer.ActivityPresentModel;
import com.hzfh.fmp.model.customer.ActivityRuleRelationModel;
import com.hzfh.fmp.model.customer.CustomerCompanyModel;
import com.hzfh.fmp.model.customer.PaymentAccountInformationModel;
import com.hzfh.fmp.model.common.enumeration.PaymentType;
import com.hzfh.fmp.model.common.helper.LogHelper;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.payment.ControllerModel;
import com.hzfh.fmp.model.payment.GatewayModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.ActivityModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.INTERNAL;


public class AjaxActivitiesAction extends JqGridBaseAction<Activities> {
    public static final LogHelper logger = LogHelper.getLogger(AjaxActivitiesAction.class);
    
    private PaymentData paymentData;

    public PaymentData getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }
    
	private String byActivityType;
	private String byStatus;
	private Timestamp byStartTime;
	private Timestamp byEndTime;
	
	public void setByActivityType(String byActivityType) {
		this.byActivityType = byActivityType;
	}
	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}
	public void setByStartTime(Timestamp byStartTime) {
		this.byStartTime = byStartTime;
	}
	public void setByEndTime(Timestamp byEndTime) {
		this.byEndTime = byEndTime;
	}
	private String a;
	private String b;
	private String c;
	private String d;
	
	public void setA(String a) {
		this.a = a;
	}
	public void setB(String b) {
		this.b = b;
	}
	public void setC(String c) {
		this.c = c;
	}
	public void setD(String d) {
		this.d = d;
	}
	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}
	private String aId;
	
	public void setAId(String aId) {
		this.aId = aId;
	}
	private String condID;
	private String actID;
	private String condDescription;
	private String editComment;
	private String status;
	private String accID;
	private String aciID;
	
	public void setAciID(String aciID) {
		this.aciID = aciID;
	}
	public void setAccID(String accID) {
		this.accID = accID;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEditComment() {
		return editComment;
	}
	public String getCondDescription() {
		return condDescription;
	}
	public void setCondID(String condID) {
		this.condID = condID;
	}
	public String getCondID() {
		return condID;
	}
	public void setActID(String actID) {
		this.actID = actID;
	}
	private int activityRewardType;
	private int relatedNo;
	
	public void setActivityRewardType(int activityRewardType) {
		this.activityRewardType = activityRewardType;
	}
	public void setRelatedNo(int relatedNo) {
		this.relatedNo = relatedNo;
	}

	private ActivityAwardRelation aarInfo;
	public ActivityAwardRelation getAarInfo() {
		return aarInfo;
	}
	public void setAarInfo(String aarInfo) {
		this.aarInfo = JSON.parseObject(aarInfo, ActivityAwardRelation.class);
	}
	
	private ActivityCondition acInfo;
	public ActivityCondition getAcInfo() {
        return acInfo;
    }

    public void setAcInfo(String acInfo) {
        this.acInfo = JSON.parseObject(acInfo, ActivityCondition.class);
    }
	private int gridId;
	
	
	public int getGridId() {
		return gridId;
	}

	public void setGridId(int gridId) {
		this.gridId = gridId;
	}
	private Activities info;
	public Activities getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Activities.class);
    }
    public int count;
    
    public int getCount() {
		return count;
	}
    public int type;
    
	public void setType(int type) {
		this.type = type;
	}

	@Override
    public String execute(){
    	ActivitiesCondition activitiesCondition = new ActivitiesCondition();
        activitiesCondition.setPageSize(this.getPageSize());
        activitiesCondition.setPageIndex(this.getPageIndex());
        if (!StringHelper.isNullOrEmpty(this.byActivityType)) {
        	activitiesCondition.setActivityType((byte)Integer.parseInt(this.byActivityType));
        }
        if (!StringHelper.isNullOrEmpty(this.byStatus)) {
        	activitiesCondition.setStatus((byte)Integer.parseInt(this.byStatus));
        }else{
        	activitiesCondition.setStatus((byte)2);
        }
        if(this.byStartTime!=null){
        	if (!StringHelper.isNullOrEmpty(this.byStartTime.toString())) {
            	activitiesCondition.setStartTime(this.byStartTime);
            }
        }
        if(this.byEndTime!=null){
        	if (!StringHelper.isNullOrEmpty(this.byEndTime.toString())) {
            	activitiesCondition.setEndTime(this.byEndTime);
            }
        }
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activitiesCondition.setSortItemList(sortItemList);

        PagedList<Activities> activitiesPagedList= ActivitiesModel.getPagingList(activitiesCondition);
        this.setResultList(activitiesPagedList.getResultList());
        this.setPageCount(activitiesPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activitiesPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activitiesPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String saveGrid(){
    	acInfo.setEditUserNo(UserHelper.getEditUserNo());
    	List<ActivityCondition> tlisList = new ArrayList<ActivityCondition>();
    	boolean flag = false; 
    	int acId=acInfo.getId();
		int id = 0;
		tlisList = ActivityConditionModel.getList();
		for (int i = 0; i < tlisList.size(); i++) {
			if(tlisList.get(i).getId()==acId){
				flag=true;
				break;
			}
		}
		if (!flag) {
			acInfo.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityConditionModel.add(acInfo);
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
                
        }else
        {
            if (acInfo.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                    if (ActivityConditionModel.update(acInfo) > 0){
						this.setErrDesc(String.valueOf(acId));
                    }else{
						this.setErrCode("update failed");
                        this.setErrDesc("update failed");
					}
            }
        }
        return SUCCESS;
    }
    public String saveGridTwo(){
    	aarInfo.setEditUserNo(UserHelper.getEditUserNo());
    	List<ActivityAwardRelation> tlisList = new ArrayList<ActivityAwardRelation>();
    	boolean flag = false; 
    	boolean typeFlag=false;
    	int acId=aarInfo.getId();
		int id = 0;
		tlisList = ActivityAwardRelationModel.getList();
		for (int i = 0; i < tlisList.size(); i++) {
			if(tlisList.get(i).getId()==acId){
				flag=true;
				if(tlisList.get(i).getActivityRewardType()!=aarInfo.getActivityRewardType()){
					typeFlag=true;
				}
				break;
			}
		}
		int endID=0;
		if(!StringHelper.isNullOrEmpty(this.actID) && !("0".equals(this.actID))){
			endID = Integer.parseInt(this.actID);
		}else{
			aarInfo.setConditionId(Integer.parseInt(this.condID));
			ActivityConditionRelation relation = new ActivityConditionRelation();
			relation = ActivityConditionRelationModel.getInfoByConditionid(Integer.parseInt(this.condID));
			ActivityRuleRelation relation2 = new ActivityRuleRelation();
			relation2 = ActivityRuleRelationModel.getInfoByRuleid(relation.getId());
			endID = relation2.getActivityNo();
		}
    	if(aarInfo.getActivityRewardType()==1){//体验金
    		//参数两个a,b,分别代表金额,天数
    		/*缺少前台的产品类型,产品名称*/
    		if(!flag || typeFlag){
    			ActivityExperienceGold gold = new ActivityExperienceGold();
    			gold.setInUserNo(UserHelper.getEditUserNo());
    			gold.setEditUserNo(UserHelper.getEditUserNo());
    			gold.setGoldMoney(Double.parseDouble(this.a));
    			gold.setDay(Integer.parseInt(this.b));
    			gold.setActivityNo(endID);
    			int aID=ActivityExperienceGoldModel.add(gold);
    			aarInfo.setRelatedNo(aID);
    			aarInfo.setEditComment(this.a+"元，"+this.b+"天投资项目规则以投资项目条件为准，项目到期后利息可提现。");
    		}else{
    			ActivityExperienceGold gold = new ActivityExperienceGold();
    			gold.setEditUserNo(UserHelper.getEditUserNo());
    			gold.setGoldMoney(Double.parseDouble(this.a));
    			gold.setDay(Integer.parseInt(this.b));
    			gold.setId(aarInfo.getRelatedNo());
    			gold.setActivityNo(endID);
    			ActivityExperienceGoldModel.update(gold);
    			aarInfo.setEditComment(this.a+"元，"+this.b+"天投资项目规则以投资项目条件为准，项目到期后利息可提现。");
    		}
    	}else if(aarInfo.getActivityRewardType()==2){//现金
    		//参数一个a,代表金额
    		/*缺少activityId*/
    		if(!flag || typeFlag){
    			ActivityCashBonus gold = new ActivityCashBonus();
    			gold.setInUserNo(UserHelper.getEditUserNo());
    			gold.setEditUserNo(UserHelper.getEditUserNo());
    			gold.setMoney(Double.parseDouble(this.a));
    			gold.setIsTake(1);
    			gold.setActivityNo(endID);
    			int aID=ActivityCashBonusModel.add(gold);
    			aarInfo.setRelatedNo(aID);
    			aarInfo.setEditComment(this.a+"元投资项目规则以投资项目条件为准，项目到期后利息可提现。");
    		}else{
    			ActivityCashBonus gold = new ActivityCashBonus();
    			gold.setEditUserNo(UserHelper.getEditUserNo());
    			gold.setMoney(Double.parseDouble(this.a));
    			gold.setIsTake(1);
    			gold.setId(aarInfo.getRelatedNo());
    			gold.setActivityNo(endID);
    			ActivityCashBonusModel.update(gold);
    			aarInfo.setEditComment(this.a+"元投资项目规则以投资项目条件为准，项目到期后利息可提现。");
    		}
    	}else if(aarInfo.getActivityRewardType()==3 || typeFlag){//优惠券
    		//参数六个a,b,c,d,分别代表面值,张数,有效期开始,有效期结束
    		/*缺少activityId*/
    		if(!flag){
    			ActivityCoupons gold = new ActivityCoupons();
    			gold.setInUserNo(UserHelper.getEditUserNo());
    			gold.setEditUserNo(UserHelper.getEditUserNo());
    			gold.setCouponsValue(Integer.parseInt(this.a));
    			gold.setCouponsTotal(Integer.parseInt(this.b));
    			gold.setCouponsStartTime(Timestamp.valueOf(this.c));
    			gold.setCouponsEndTime(Timestamp.valueOf(this.d));
    			gold.setActivityNo(endID);
    			int aID=ActivityCouponsModel.add(gold);
    			aarInfo.setRelatedNo(aID);
    			aarInfo.setEditComment("面值"+this.a+"元,限制张数<="+this.b+"张，有效期:"+this.c+"-"+this.d);
    		}else{
    			ActivityCoupons gold = new ActivityCoupons();
    			gold.setEditUserNo(UserHelper.getEditUserNo());
    			gold.setCouponsValue(Integer.parseInt(this.a));
    			gold.setCouponsTotal(Integer.parseInt(this.b));
    			gold.setCouponsStartTime(Timestamp.valueOf(this.c));
    			gold.setCouponsEndTime(Timestamp.valueOf(this.d));
    			gold.setId(aarInfo.getRelatedNo());
    			gold.setActivityNo(endID);
    			ActivityCouponsModel.update(gold);
    			aarInfo.setEditComment("面值"+this.a+"元，限制张数<="+this.b+"张，有效期:"+this.c+"-"+this.d);
    		}
    	}else if(aarInfo.getActivityRewardType()==4 || typeFlag){//积分
    		//参数三个a,b,c,分别代表每人积分个数，有效期开始,有效期结束
    		/*缺少activityId*/
    		if(!flag){
    			ActivityIntegral gold = new ActivityIntegral();
    			gold.setIntegralCount(Integer.parseInt(this.a));
    			gold.setInTime(Timestamp.valueOf(this.b));
    			gold.setExpireTime(Timestamp.valueOf(this.c));
    			gold.setActivityNo(endID);
    			int aID=ActivityIntegralModel.add(gold);
    			aarInfo.setRelatedNo(aID);
    			aarInfo.setEditComment("每人"+this.a+"积分，有效期:"+this.b+"-"+this.c);
    		}else{
    			ActivityIntegral gold = new ActivityIntegral();
    			gold.setIntegralCount(Integer.parseInt(this.a));
    			gold.setInTime(Timestamp.valueOf(this.b));
    			gold.setExpireTime(Timestamp.valueOf(this.c));
    			gold.setId(aarInfo.getRelatedNo());
    			gold.setActivityNo(endID);
    			ActivityIntegralModel.update(gold);
    			aarInfo.setEditComment("每人"+this.a+"积分，有效期:"+this.b+"-"+this.c);
    		}
    	}else if(aarInfo.getActivityRewardType()==5 || typeFlag){//礼包
    		//参数三个a,b,c,d,分别代表礼包名称,礼品价值,礼包个数,日期
    		/*缺少activityId*/
    		if(!flag){
    			ActivityPresent gold = new ActivityPresent();
    			gold.setInUserNo(UserHelper.getEditUserNo());
    			gold.setEditUserNo(UserHelper.getEditUserNo());
    			gold.setPresentName(this.a);
    			gold.setPresentPrice(Double.parseDouble(this.b));
    			gold.setPresentCount(Integer.parseInt(this.c));
    			gold.setGetPresentTime(Timestamp.valueOf(this.d));
    			gold.setActivityNo(endID);
    			int aID=ActivityPresentModel.add(gold);
    			aarInfo.setRelatedNo(aID);
    			aarInfo.setEditComment("礼品名称"+this.a+"，礼品价值"+this.b+"，礼包个数"+this.c+"，领取时间："+this.d);
    		}else{
    			ActivityPresent gold = new ActivityPresent();
    			gold.setEditUserNo(UserHelper.getEditUserNo());
    			gold.setPresentName(this.a);
    			gold.setPresentPrice(Double.parseDouble(this.b));
    			gold.setPresentCount(Integer.parseInt(this.c));
    			gold.setGetPresentTime(Timestamp.valueOf(this.d));
    			gold.setId(aarInfo.getRelatedNo());
    			gold.setActivityNo(endID);
    			ActivityPresentModel.update(gold);
    			aarInfo.setEditComment("礼品名称"+this.a+"，礼品价值"+this.b+"，礼包个数"+this.c+"，领取时间："+this.d);
    		}
    	}
		if (!flag) {
			aarInfo.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityAwardRelationModel.add(aarInfo);
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
                
        }else
        {
            if (aarInfo.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                    if (ActivityAwardRelationModel.update(aarInfo) > 0){
						this.setErrDesc(String.valueOf(acId));
                    }else{
						this.setErrCode("update failed");
                        this.setErrDesc("update failed");
					}
            }
        }
        return SUCCESS;
    }
    public String deleteGrid(){
		if (this.getOper().equalsIgnoreCase("delete")) {
			ActivityConditionModel.delete(this.gridId);
            if (this.gridId > 0){
				this.setErrDesc(String.valueOf(this.gridId));                
            }else{
				this.setErrCode("delete failed");
                this.setErrDesc("delete failed");
			}
                
        }
        return SUCCESS;
    }
    public String deleteGridTwo(){
    	ActivityAwardRelation relation = new ActivityAwardRelation();
    	relation = ActivityAwardRelationModel.getInfo(this.gridId);
		if (this.getOper().equalsIgnoreCase("delete")) {
			if(relation.getActivityRewardType()==1){
				ActivityExperienceGoldModel.deleteInfo(this.relatedNo);
			}else if (relation.getActivityRewardType()==2){
				ActivityCashBonusModel.deleteInfo(this.relatedNo);
			}else if (relation.getActivityRewardType()==3){
				ActivityCouponsModel.deleteInfo(this.relatedNo);
			}else if (relation.getActivityRewardType()==4){
				ActivityIntegralModel.deleteInfo(this.relatedNo);
			}else if (relation.getActivityRewardType()==5){
				ActivityPresentModel.deleteInfo(this.relatedNo);
			}
			ActivityAwardRelationModel.deleteInfo(this.gridId);
            if (this.gridId > 0){
				this.setErrDesc(String.valueOf(this.gridId));                
            }else{
				this.setErrCode("delete failed");
                this.setErrDesc("delete failed");
			}
                
        }
        return SUCCESS;
    }
    public String editDetail(){
		acInfo.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
			acInfo.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityConditionModel.add(acInfo);
			
			ActivityConditionRelation relation = new ActivityConditionRelation();
			relation.setConditionNo(id);
			relation.setEditUserNo(UserHelper.getEditUserNo());
			relation.setInUserNo(UserHelper.getEditUserNo());
			int rulNo = ActivityConditionRelationModel.add(relation);
			
			ActivityRuleRelation relation2 = new ActivityRuleRelation();
			relation2.setActivityNo(Integer.parseInt(this.aId));
			relation2.setEditUserNo(UserHelper.getEditUserNo());
			relation2.setInUserNo(UserHelper.getEditUserNo());
			relation2.setRuleNo(rulNo);
			ActivityRuleRelationModel.add(relation2);
			
			if(!StringHelper.isNullOrEmpty(ids)){
				String[] ides = ids.split("@");
				for (int i = 1; i < ides.length; i++) {
					int mId = Integer.parseInt(ides[i]);
					ActivityAwardRelationModel.updateCidById(mId,id);
				}
			}
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
                
        }
        else
        {
            if (acInfo.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                	if(!StringHelper.isNullOrEmpty(ids)){
        				String[] ides = ids.split("@");
        				for (int i = 1; i < ides.length; i++) {
        					int mId = Integer.parseInt(ides[i]);
        					ActivityAwardRelationModel.updateCidById(mId,acInfo.getId());
        				}
        			}
                    if (ActivityConditionModel.update(acInfo) > 0){
						this.setErrDesc(String.valueOf(acInfo.getId()));
                    }else{
						this.setErrCode("update failed");
                        this.setErrDesc("update failed");
					}
                        
                }
            }
        }

        return SUCCESS;
    }
    public String getAllConditions(){
		if(!StringHelper.isNullOrEmpty(this.actID) && !("0".equals(this.actID))){
			List<ActivityCondition> list = new ArrayList<ActivityCondition>();
			list = ActivityConditionModel.getInfoByActId(Integer.parseInt(this.actID));
	    	for (int i = 0; i < list.size(); i++) {
	    		String cond1 = "";
	    		String cond2 = "";
	    		String cond3 = "";
	    		if(list.get(i).getConditionRelation()!=0){
	    			cond1 = DicDataModel.getDicDataByTypeAndCode(56, list.get(i).getConditionRelation()).getValue();
	    		}else{
	    			cond1 = list.get(i).getConditionRelation()+"";
	    		}
	    		if(list.get(i).getProductType()!=0){
	    			cond2 = DicDataModel.getDicDataByTypeAndCode(4, list.get(i).getProductType()).getValue();
	    		}else{
	    			cond2 = list.get(i).getProductType()+"";
	    		}
	    		if(list.get(i).getProductName()!=0){
	    			cond3 = ProductModel.getInfo(list.get(i).getProductName()).getName();
//	    			List<Product> list2 = new ArrayList<Product>();
//	    			list2 = ProductModel.getListByType((byte)list.get(i).getProductType());
//	    			cond3 = list2.get(list.get(i).getProductName()).getName();
	    		}else{
	    			cond3 = list.get(i).getProductName()+"";
	    		}
	    		condDescription = condDescription + "@" +list.get(i).getConditionDescription()
	    				+cond1
	    				+list.get(i).getConditionValue()+","
	    				+cond2+","
	    				+cond3;
	    		condID = condID + "@" +list.get(i).getId()+"";
			}
	    	if (Integer.parseInt(this.actID) > 0){
				this.setErrDesc(String.valueOf(this.actID));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
    	}
    	
    	return SUCCESS;
    }
    public String deleteContentByCondId(){
		if(!StringHelper.isNullOrEmpty(this.condID) && !("0".equals(this.condID))){
			int condtID = Integer.parseInt(this.condID);
			ActivityAwardRelationModel.deleteInfoByCondId(condtID);
			ActivityConditionRelation relation = new ActivityConditionRelation();
			relation = ActivityConditionRelationModel.getInfoByConditionid(condtID);
			ActivityRuleRelationModel.deleteInfoByCondId(relation.getId());
			ActivityConditionRelationModel.deleteInfoByCondId(condtID);
			
			ActivityConditionModel.delete(condtID);
			
	    	if (condtID > 0){
				this.setErrDesc(this.condID);                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
    	}
    	
    	return SUCCESS;
    }
    public String updateActivitiesByIdAndStatus(){
		if(!StringHelper.isNullOrEmpty(this.actID) && !("0".equals(this.actID))){
			ActivitiesModel.updateActivitiesByIdAndStatus(Integer.parseInt(this.actID),Integer.parseInt(this.status));
    	}
    	
    	return SUCCESS;
    }
    public String updateActivityCustomerCashBonusById(){
    	logger.info("确认活动打款操作");
    	ActivityCustomerInvitation activityCustomerInvitation = new ActivityCustomerInvitation();
    	
//        CustomerCompany customerCompany = CustomerCompanyModel.getInfoByP2pCustomerNo(this.info.getPayerNo());
    	PaymentAccountInformation payer = new PaymentAccountInformation();
 		payer = PaymentAccountInformationModel.getInfoByCustomerNo(PaymentType.YYID);/**/
    	 
    	 PaymentAccountInformation payee = new PaymentAccountInformation();
        if(!StringHelper.isNullOrEmpty(this.aciID) && !("0".equals(this.aciID))){
        	activityCustomerInvitation = ActivityCustomerInvitationModel.getInfo(Integer.parseInt(this.aciID));
            payee = PaymentAccountInformationModel.getInfoByCustomerNo(activityCustomerInvitation.getP2pCustomerNo());
        }
        if (payer == null) {
            this.setErrDesc("此付款方尚未注册易宝平台账户");
            this.setErrCode("paymentAccountInformation is null");
            logger.error("此付款方尚未注册易宝平台账户");
            return SUCCESS;
        }
        if (payee == null) {
            this.setErrDesc("此收款方尚未注册易宝平台账户");
            this.setErrCode("accountInformation is null");
            logger.error("此收款方尚未注册易宝平台账户");
            return SUCCESS;
        }
        CpTransactionReq<Repayment> cpTransactionReq = new CpTransactionReq<Repayment>();
        cpTransactionReq.setRequestNo(activityCustomerInvitation.getRequestNo()+"@"+this.type);
        cpTransactionReq.setPlatformNo("default");
        cpTransactionReq.setPlatformUserNo(String.valueOf(PaymentType.YYID));/**/
        cpTransactionReq.setUserType(String.valueOf(CardStatus.MEMBER));
        cpTransactionReq.setBizType(String.valueOf(ServiceStates.TRANSFER));
//        cpTransactionReq.setExpired(String.valueOf(this.info.getPayEndTime()));

        Detail detail = new Detail();
        detail.setAmount(String.valueOf(activityCustomerInvitation.getRewardsMoney()));
        detail.setTargetUserType(String.valueOf(CardStatus.MEMBER));
        detail.setTargetPlatformUserNo(String.valueOf(activityCustomerInvitation.getP2pCustomerNo()));
        detail.setBizType(String.valueOf(ServiceStates.TRANSFER));
        List<Detail> detailList = new ArrayList<>();
        detailList.add(detail);
        Details details = new Details();
        details.setDetails(detailList);
        cpTransactionReq.setDetails(details);

        Repayment repayment = new Repayment();
        //repayment.setTenderOrderNo(String.valueOf(this.info.getP2pProductNo()));
        cpTransactionReq.setExtend(repayment.getExtend());
        cpTransactionReq.setNotifyUrl(UrlHelper.buildCustomerSiteUrl("/customer/activities/repaymentNotify"));
        cpTransactionReq.setCallbackUrl(UrlHelper.buildCustomerSiteUrl("/customer/activities/repaymentCallback"));
        cpTransactionReq.setRemark("活动打款操作");
        try {
            this.paymentData = GatewayModel.repayment(cpTransactionReq);
        } catch (Exception e) {
            logger.error("活动打款操作出现异常", e);
        }
        
    	if(!StringHelper.isNullOrEmpty(this.aciID) && !("0".equals(this.aciID))){
    		ActivityCustomerInvitationModel.updateApproverNoById(Integer.parseInt(this.aciID),UserHelper.getEditUserNo());
    	}
//		if(!StringHelper.isNullOrEmpty(this.accID) && !("0".equals(this.accID))){
//			ActivityCustomerCashBonusModel.updateStatusById(Integer.parseInt(this.accID),1);
//    	}
    	
    	return SUCCESS;
    }
    public String checkPayment() {
        logger.info("审核活动打款操作");
        try {
        	ActivityCustomerInvitation activityCustomerInvitation = new ActivityCustomerInvitation();
            CompleteTransactionReq completeTransactionReq = new CompleteTransactionReq();
            completeTransactionReq.setPlatformNo("default");
            if(!StringHelper.isNullOrEmpty(this.aciID) && !("0".equals(this.aciID))){
            	activityCustomerInvitation = ActivityCustomerInvitationModel.getInfo(Integer.parseInt(this.aciID));
                completeTransactionReq.setRequestNo(activityCustomerInvitation.getRequestNo()+"@"+this.type);
            }else{
                completeTransactionReq.setRequestNo(String.valueOf(0));
            }
            completeTransactionReq.setMode(TransferStatus.CONFRIM);
            completeTransactionReq.setNotifyUrl(UrlHelper.buildCustomerSiteUrl("/customer/activities/confirmTransactionNotify"));
            
            CompleteTransactionResp a = ControllerModel.getCompleteTransaction(completeTransactionReq);
            
        } catch (Exception e) {
            logger.error("审核活动打款确认出现异常", e);
            this.setErrCode("failed");
        }

        return SUCCESS;
    }

    public String cancelRefundPayment() {
        logger.info("取消活动打款确认操作");
        try {
        	ActivityCustomerInvitation activityCustomerInvitation = new ActivityCustomerInvitation();
            CompleteTransactionReq completeTransactionReq = new CompleteTransactionReq();
            completeTransactionReq.setPlatformNo("default");
            if(!StringHelper.isNullOrEmpty(this.aciID) && !("0".equals(this.aciID))){
            	activityCustomerInvitation = ActivityCustomerInvitationModel.getInfo(Integer.parseInt(this.aciID));
                completeTransactionReq.setRequestNo(activityCustomerInvitation.getRequestNo()+"@"+this.type);
            }else{
                completeTransactionReq.setRequestNo(String.valueOf(0));
            }
            completeTransactionReq.setMode(TransferStatus.CANCEL);
            completeTransactionReq.setNotifyUrl(UrlHelper.buildCustomerSiteUrl("/customer/activities/cancelTransactionNotify"));
            ControllerModel.getCompleteTransaction(completeTransactionReq);
        } catch (Exception e) {
            logger.error("取消活动打款确认出现异常", e);
            this.setErrCode("failed");
        }
        return SUCCESS;
    }
    public String getInfoByConId(){
		if(!StringHelper.isNullOrEmpty(this.condID) && !("0".equals(this.condID))){
			List<ActivityAwardRelation> list = new ArrayList<ActivityAwardRelation>();
			list = ActivityAwardRelationModel.getInfoByConId(Integer.parseInt(this.condID));
			for (int i = 0; i < list.size(); i++) {
				this.editComment = editComment +"奖励："+ list.get(i).getEditComment()+ "<br />";
			}
    	}
    	
    	return SUCCESS;
    }
    public String getActivitiesTypeById(){
			this.count = ActivitiesModel.getActivitiesTypeCountById(1);
    	
    	return SUCCESS;
    }
    public String getConds(){
			this.count = ActivitiesModel.getConds(Integer.parseInt(this.getId()),1);
			
    	return SUCCESS;
    }
    public String getBouns(){
		this.count = ActivitiesModel.getBouns(Integer.parseInt(this.condID),1);
		
	return SUCCESS;
}
    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivitiesModel.add(info);
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
                    if (ActivitiesModel.update(info) > 0){
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
            this.info = ActivitiesModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
