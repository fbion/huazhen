package com.hzfh.p2p.controller.customer.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.PaymentMoneyRecharge;
import com.hzfh.api.customer.model.query.PaymentMoneyRechargeCondition;
import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.constant.FeeMode;
import com.hzfh.api.payment.model.common.constant.QueryType;
import com.hzfh.api.payment.model.request.gateway.RechargeReq;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.controller.common.JsonBaseAction.Message;
import com.hzfh.p2p.controller.common.JsonBaseAction.MessageType;
import com.hzfh.p2p.model.baseInfo.SnModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentMoneyRechargeModel;
import com.hzfh.p2p.model.payment.ExamineCallbackRecordModel;
import com.hzfh.p2p.model.payment.GatewayModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;


public class AjaxPaymentMoneyRechargeAction extends JsonBaseAction<PaymentMoneyRecharge> {
	public static final LogHelper logger = LogHelper.getLogger(AjaxPaymentMoneyRechargeAction.class.getName());
	private PaymentMoneyRecharge info;
	public PaymentMoneyRecharge getInfo() {
		return info;
	}

	private int pageIndex;
	private PagedList<PaymentMoneyRecharge> paymentMoneyRechargeList;
	private int pageCount;
	private int totalCount;
	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public PagedList<PaymentMoneyRecharge> getPaymentMoneyRechargeList() {
		return paymentMoneyRechargeList;
	}

	public void setPaymentMoneyRechargeList(
			PagedList<PaymentMoneyRecharge> paymentMoneyRechargeList) {
		this.paymentMoneyRechargeList = paymentMoneyRechargeList;
	}

	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	private String id;
	private String errCode;
	private String errDesc;
	public String getId() {
		return id;
	}
	public String getErrCode() {
		return errCode;
	}
	public String getErrDesc() {
		return errDesc;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	private String byCreateTime;
	private String state0;
	private String state1;
	private String state2;
	public void setByCreateTime(String byCreateTime) {
		this.byCreateTime = byCreateTime;
	}

	public void setState0(String state0) {
		this.state0 = state0;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

	public void setState2(String state2) {
		this.state2 = state2;
	}
	private String amount;
	private PaymentData paymentData;
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public PaymentData getPaymentData() {
		return paymentData;
	}

	public PaymentMoneyRechargeCondition getCondition(){
		PaymentMoneyRechargeCondition paymentMoneyRechargeCondition = new PaymentMoneyRechargeCondition();
		paymentMoneyRechargeCondition.setPageIndex(pageIndex);
		paymentMoneyRechargeCondition.setPageSize(5);
		paymentMoneyRechargeCondition.setCustomerNo(AuthenticationModel.getCustomerId());
		paymentMoneyRechargeCondition.getStartIndex();
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("sn");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);

		paymentMoneyRechargeCondition.setSortItemList(sortItemList);
		
		List<Integer> stateList = new ArrayList<Integer>();
		if(!StringHelper.isNullOrEmpty(state0)){
			stateList.add(Integer.valueOf(state0));
		}
		if(!StringHelper.isNullOrEmpty(state1)){
			stateList.add(Integer.valueOf(state1));
		}
		if(!StringHelper.isNullOrEmpty(state2)){
			stateList.add(Integer.valueOf(state2));
		}
		if(stateList.size()>0){
			paymentMoneyRechargeCondition.setState(StringHelper.listToString(stateList));
		}
		
		int year = Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()));
		int month = Integer.valueOf(new SimpleDateFormat("MM").format(new Date()));
		int day = Integer.valueOf(new SimpleDateFormat("dd").format(new Date()));
		if(!StringHelper.isNullOrEmpty(this.byCreateTime)&&!"".equals(this.byCreateTime)){
    		if("0".equals(this.byCreateTime)){//全部
    			paymentMoneyRechargeCondition.setDateUp(null);
    			paymentMoneyRechargeCondition.setDateDown(null);
    		}
			if("1".equals(byCreateTime)){//最近3个月
	    		paymentMoneyRechargeCondition.setDateUp(year+"-"+(month+1)+"-"+"01");//上限（不包括），当前日期的下个月1号
	    		if(month>2){
	    			month-=2;
	    		}else{
	    			year-=1;
	    			month=12+month-2;
	    		}
	    		paymentMoneyRechargeCondition.setDateDown(year+"-"+month+"-"+"01");
	    	}
	    	if("2".equals(byCreateTime)){//最近1个月
	    		paymentMoneyRechargeCondition.setDateUp(year+"-"+(month+1)+"-"+"01");//上限（不包括），当前日期的下个月1号
	    		if(month>1){
	    			month-=1;
	    		}else{
	    			year-=1;
	    			month=12+month-1;
	    		}
	    		paymentMoneyRechargeCondition.setDateDown(year+"-"+month+"-"+"01");
	    	}
	    	if("3".equals(byCreateTime)){//最近7天
	    		paymentMoneyRechargeCondition.setDateUp(year+"-"+month+"-"+(day+1));//上限（不包括），当前日期的明天
	    		if(day>7){
	    			day-=7;
	    		}else{
	    			month-=1;
	    			day=31+day-7;
	    		}
	    		paymentMoneyRechargeCondition.setDateDown(year+"-"+month+"-"+day);
	    	}
	    }else{//默认为最近7天
	    	paymentMoneyRechargeCondition.setDateUp(year+"-"+month+"-"+(day+1));//上限（不包括），当前日期的明天
    		if(day>7){
    			day-=7;
    		}else{
    			month-=1;
    			day=31+day-7;
    		}
    		paymentMoneyRechargeCondition.setDateDown(year+"-"+month+"-"+day);
	    }
		
		return paymentMoneyRechargeCondition;
	}
	

	@Override
	public String execute(){
		
		
		paymentMoneyRechargeList = PaymentMoneyRechargeModel.getPagingList(this.getCondition());
		totalCount = paymentMoneyRechargeList.getPagingInfo().getTotalCount();
		pageCount = paymentMoneyRechargeList.getPagingInfo().getPageCount();
		
        return SUCCESS;
	}

	public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = PaymentMoneyRechargeModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
	public String paymentMoneyRecharge(){
		this.message = new Message<String>();
		int customerNo = AuthenticationModel.getCustomerId();
		PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(customerNo);
		if(paymentAccountInformation.getAuthenticationName()==0){
			this.setErrCode("Not AuthenticationName");
            this.setErrDesc("请先实名认证，再进行充值！");
			return SUCCESS;
		}
		
		RechargeReq rechargeReq = new RechargeReq();
		rechargeReq.setAmount(amount);
		rechargeReq.setCallbackUrl(UrlHelper.bulidWebBackUrl("customer/paymentRecharge/rechargeCallback"));
		if(ParamHelper.PAY_RECHARGE_TYPE == 1){
			rechargeReq.setFeeMode(FeeMode.PLATFORM);
		}
		if(ParamHelper.PAY_RECHARGE_TYPE == 0){
			rechargeReq.setFeeMode(FeeMode.USER);
		}
		rechargeReq.setNotifyUrl(UrlHelper.bulidWebBackUrl("customer/paymentRecharge/rechargeNotify"));
		rechargeReq.setPlatformNo(rechargeReq.getPlatformNo());
		rechargeReq.setPlatformUserNo(String.valueOf(customerNo));
		String sn=SnModel.getSn(SnEnum.SN_RECHARGE);
		rechargeReq.setRequestNo(sn);
		try{
			paymentData = GatewayModel.recharge(rechargeReq);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		ExamineCallbackRecord examineCallbackRecord = new ExamineCallbackRecord();
		examineCallbackRecord.setSn(sn);
		examineCallbackRecord.setServiceName(QueryType.QUERY_RECHARGE);
		examineCallbackRecord.setStatus(QueryType.QUERY_NO_NOTIFY);
		examineCallbackRecord.setOperationType(QueryType.QUERY_RECHARGE);
		examineCallbackRecord.setComment("充值");
		ExamineCallbackRecordModel.add(examineCallbackRecord);
		
		PaymentMoneyRecharge paymentMoneyRecharge = new PaymentMoneyRecharge();
		paymentMoneyRecharge.setCustomerNo(String.valueOf(customerNo));
		paymentMoneyRecharge.setSn(sn);
		paymentMoneyRecharge.setAmount(Double.parseDouble(amount));
		paymentMoneyRecharge.setCustomerMoneyFactorage(FeeMode.PLATFORM);
		paymentMoneyRecharge.setState(PaymentType.RECHARGE_RECHARGEING);
		paymentMoneyRecharge.setResultNote("充值中");
		PaymentMoneyRechargeModel.add(paymentMoneyRecharge);
		
		return SUCCESS;
	}
}
