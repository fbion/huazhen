package com.hzfh.p2p.controller.customer.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.customer.model.PaymentMoneyWithdraw;
import com.hzfh.api.customer.model.query.PaymentMoneyWithdrawCondition;
import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.constant.FeeMode;
import com.hzfh.api.payment.model.common.constant.QueryType;
import com.hzfh.api.payment.model.common.constant.WithdrawalWay;
import com.hzfh.api.payment.model.request.gateway.WithdrawReq;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.controller.payment.notify.WithdrawNotifyAction;
import com.hzfh.p2p.model.baseInfo.SnModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.customer.PaymentMoneyWithdrawModel;
import com.hzfh.p2p.model.payment.ExamineCallbackRecordModel;
import com.hzfh.p2p.model.payment.GatewayModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;


public class AjaxPaymentMoneyWithdrawAction extends CommonAction {
	public static final LogHelper logger = LogHelper.getLogger(AjaxPaymentMoneyWithdrawAction.class.getName());
	private PaymentMoneyWithdraw info;
	public PaymentMoneyWithdraw getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, PaymentMoneyWithdraw.class);
    }

    private int pageIndex;
	private PagedList<PaymentMoneyWithdraw> paymentMoneyWithdrawList;
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

	public PagedList<PaymentMoneyWithdraw> getPaymentMoneyWithdrawList() {
		return paymentMoneyWithdrawList;
	}

	public void setPaymentMoneyWithdrawList(
			PagedList<PaymentMoneyWithdraw> paymentMoneyWithdrawList) {
		this.paymentMoneyWithdrawList = paymentMoneyWithdrawList;
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
	private String state3;
	private String state4;
	private String state5;
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
	
	public void setState3(String state3) {
		this.state3 = state3;
	}

	public void setState4(String state4) {
		this.state4 = state4;
	}

	public void setState5(String state5) {
		this.state5 = state5;
	}

	private String amount;
	private PaymentData paymentData;
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public PaymentData getPaymentData() {
		return paymentData;
	}
	public PaymentMoneyWithdrawCondition getCondition(){
		PaymentMoneyWithdrawCondition paymentMoneyWithdrawCondition = new PaymentMoneyWithdrawCondition();
		paymentMoneyWithdrawCondition.setPageIndex(pageIndex);
		paymentMoneyWithdrawCondition.setPageSize(5);
		paymentMoneyWithdrawCondition.setCustomerNo(AuthenticationModel.getCustomerId());
		paymentMoneyWithdrawCondition.getStartIndex();
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("sn");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);

		paymentMoneyWithdrawCondition.setSortItemList(sortItemList);
        
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
		if(!StringHelper.isNullOrEmpty(state3)){
			stateList.add(Integer.valueOf(state3));
		}
		if(!StringHelper.isNullOrEmpty(state4)){
			stateList.add(Integer.valueOf(state4));
		}
		if(!StringHelper.isNullOrEmpty(state5)){
			stateList.add(Integer.valueOf(state5));
		}
		if(stateList.size()>0){
			paymentMoneyWithdrawCondition.setState(StringHelper.listToString(stateList));
		}
		int year = Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()));
		int month = Integer.valueOf(new SimpleDateFormat("MM").format(new Date()));
		int day = Integer.valueOf(new SimpleDateFormat("dd").format(new Date()));
		if(!StringHelper.isNullOrEmpty(this.byCreateTime)&&!"".equals(this.byCreateTime)){
    		if("0".equals(this.byCreateTime)){//全部
    			paymentMoneyWithdrawCondition.setDateUp(null);
    			paymentMoneyWithdrawCondition.setDateDown(null);
    		}
			if("1".equals(byCreateTime)){//最近3个月
	    		paymentMoneyWithdrawCondition.setDateUp(year+"-"+(month+1)+"-"+"01");//上限（不包括），当前日期的下个月1号
	    		if(month>2){
	    			month-=2;
	    		}else{
	    			year-=1;
	    			month=12+month-2;
	    		}
	    		paymentMoneyWithdrawCondition.setDateDown(year+"-"+month+"-"+"01");
	    	}
	    	if("2".equals(byCreateTime)){//最近1个月
	    		paymentMoneyWithdrawCondition.setDateUp(year+"-"+(month+1)+"-"+"01");//上限（不包括），当前日期的下个月1号
	    		if(month>1){
	    			month-=1;
	    		}else{
	    			year-=1;
	    			month=12+month-1;
	    		}
	    		paymentMoneyWithdrawCondition.setDateDown(year+"-"+month+"-"+"01");
	    	}
	    	if("3".equals(byCreateTime)){//最近7天
	    		paymentMoneyWithdrawCondition.setDateUp(year+"-"+month+"-"+(day+1));//上限（不包括），当前日期的明天
	    		if(day>7){
	    			day-=7;
	    		}else{
	    			month-=1;
	    			day=31+day-7;
	    		}
	    		paymentMoneyWithdrawCondition.setDateDown(year+"-"+month+"-"+day);
	    	}
	    }else{//默认为最近7天
	    	paymentMoneyWithdrawCondition.setDateUp(year+"-"+month+"-"+(day+1));//上限（不包括），当前日期的明天
    		if(day>7){
    			day-=7;
    		}else{
    			month-=1;
    			day=31+day-7;
    		}
    		paymentMoneyWithdrawCondition.setDateDown(year+"-"+month+"-"+day);
	    }
        
        return paymentMoneyWithdrawCondition;
	}
	
    @Override
    public String execute(){
    	

        paymentMoneyWithdrawList = PaymentMoneyWithdrawModel.getPagingList(this.getCondition());
        totalCount = paymentMoneyWithdrawList.getPagingInfo().getTotalCount();
		pageCount = paymentMoneyWithdrawList.getPagingInfo().getPageCount();
        return SUCCESS;
    }

    /*public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = PaymentMoneyWithdrawModel.add(info);
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
                    if (PaymentMoneyWithdrawModel.update(info) > 0){
						this.setErrDesc(String.valueOf(info.getId()));
                    }else{
						this.setErrCode("update failed");
                        this.setErrDesc("update failed");
					}
                        
                }
            }
        }

        return SUCCESS;
    }*/

	public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = PaymentMoneyWithdrawModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

	public String paymentMoneyWithdraw(){
		logger.info("提现开始！");
		int customerNo = AuthenticationModel.getCustomerId();
		//String  userName = AuthenticationModel.getUserName(); 
		WithdrawReq withdrawReq = new WithdrawReq();
		withdrawReq.setAmount(amount);
		withdrawReq.setCallbackUrl(UrlHelper.bulidWebBackUrl("customer/paymentWithdraw/withdrawCallback"));
		if(ParamHelper.PAY_WITHDRAW_TYPE == 1){
			withdrawReq.setFeeMode(FeeMode.PLATFORM);
		}
		if(ParamHelper.PAY_WITHDRAW_TYPE == 0){
			withdrawReq.setFeeMode(FeeMode.USER);
		}
		withdrawReq.setNotifyUrl(UrlHelper.bulidWebBackUrl("customer/paymentWithdraw/withdrawCallback/withdrawNotify"));
		withdrawReq.setPlatformNo(withdrawReq.getPlatformNo());
		withdrawReq.setPlatformUserNo(String.valueOf(customerNo));
		String sn=SnModel.getSn(SnEnum.SN_WITHDRAW);
		withdrawReq.setRequestNo(sn);
		withdrawReq.setWithdrawType(WithdrawalWay.NORMAL);
		try {
			paymentData = GatewayModel.withdraw(withdrawReq);
			logger.info("提现-封装提现数据，xml、sign、url成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("提现-封装提现数据，xml、sign、url失败！");
		}
		
		ExamineCallbackRecord examineCallbackRecord = new ExamineCallbackRecord();
		examineCallbackRecord.setSn(sn);
		examineCallbackRecord.setServiceName(QueryType.QUERY_WITHDRAW);
		examineCallbackRecord.setStatus(QueryType.QUERY_NO_NOTIFY);
		examineCallbackRecord.setOperationType(QueryType.QUERY_WITHDRAW);
		examineCallbackRecord.setComment("提现");
		ExamineCallbackRecordModel.add(examineCallbackRecord);
		
		
		PaymentMoneyWithdraw paymentMoneyWithdraw = new PaymentMoneyWithdraw();
		paymentMoneyWithdraw.setCustomerNo(String.valueOf(customerNo));
		paymentMoneyWithdraw.setSn(sn);
		paymentMoneyWithdraw.setAmount(Double.parseDouble(amount));
		paymentMoneyWithdraw.setCustomerMoneyFactorage(FeeMode.PLATFORM);
		paymentMoneyWithdraw.setState(PaymentType.WITHDRA_WITHDRAWING);
		paymentMoneyWithdraw.setResultNote("提现中");
		try {
			PaymentMoneyWithdrawModel.add(paymentMoneyWithdraw);
			logger.info("提现-增加提现记录payment_money_withdraw成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("提现-增加提现记录payment_money_withdraw失败！");
		}
		
		return SUCCESS;
	}
}
