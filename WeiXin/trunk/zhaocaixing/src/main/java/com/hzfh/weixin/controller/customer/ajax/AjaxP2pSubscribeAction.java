package com.hzfh.weixin.controller.customer.ajax;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.baseInfo.EmailModel;
import com.hzfh.weixin.model.baseInfo.LetterModel;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.helper.CharacterFilter;
import com.hzfh.weixin.model.common.properties.MailHelper;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzfh.weixin.model.product.P2pProductModel;
import com.hzfh.weixin.model.sales.P2pSubscribeModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

public class AjaxP2pSubscribeAction extends JsonBaseAction<P2pSubscribe> {

	private int p2pProductNo;
	private int amount;

	private String callName;
	private String callPhone;
	public void setCallName(String callName) {
		this.callName = callName;
	}
	public void setCallPhone(String callPhone) {
		this.callPhone = callPhone;
	}
	public int getP2pProductNo() {
		return p2pProductNo;
	}
	public void setP2pProductNo(int p2pProductNo) {
		this.p2pProductNo = p2pProductNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
    public String execute() {
	int userId = AuthenticationModel.getCustomerId();
	//int userId = 51;
	 
	 this.message = new Message();
	 //userId
	 P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(userId);
	 P2pProduct p2pProduct =  P2pProductModel.getInfo(p2pProductNo);
	 long reservationMoney = p2pProduct.getRemainAmout();
	 int minMoney = p2pProduct.getMinMoney();
	 if(amount>reservationMoney){
		 this.message.setType(MessageType.Info);
		 this.message.setDescription("预约金额需小于产品剩余金额！");
		 return SUCCESS;
	 }
	 if(amount<minMoney){
		 this.message.setType(MessageType.Info);
		 this.message.setDescription("预约起购价为"+minMoney+ "元！");
		 return SUCCESS;
	 }
	 if(!StringHelper.isNullOrEmpty(p2pCustomer.getCardNumber())){
		 P2pSubscribe p2pSubscribe = new P2pSubscribe();
		 p2pSubscribe.setP2pCustomer(userId);
		 p2pSubscribe.setRealName(p2pCustomer.getRealName());
		 p2pSubscribe.setCellphone(p2pCustomer.getCellphone());
		 p2pSubscribe.setProvinceNo(p2pCustomer.getProvinceNo());
		 p2pSubscribe.setCityNo(p2pCustomer.getCityNo());
		 p2pSubscribe.setDistrictNo(p2pCustomer.getDistrictNo());
		 p2pSubscribe.setAddress(p2pCustomer.getAddress());
		 p2pSubscribe.setDeptNo(p2pCustomer.getDeptNo());
		 p2pSubscribe.setCardNumber(p2pCustomer.getCardNumber());
		 p2pSubscribe.setAmount(amount);
		 p2pSubscribe.setEmpNo(p2pCustomer.getEmpNo());
		 p2pSubscribe.setVisitTime(DateHelper.getTodayDate());
		 p2pSubscribe.setP2pProductNo(p2pProductNo);
		 p2pSubscribe.setStatus((byte) 1);
		 p2pSubscribe.setCardType((byte) 1);
		/*
		 //mengchong 2015/03/26 判断产品是否测试产品？ 1是测试 0不是测试
		 byte isTest = P2pProductModel.getInfo(p2pProductNo).getIsTest();
		 if(isTest == (byte)1){
			 p2pSubscribe.setIsTest((byte) 1);
		 }*/
		 p2pSubscribe.setCustomerNo(p2pCustomer.getCustomerNo());
		 
		 try {
			P2pSubscribeModel.add(p2pSubscribe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 this.message.setType(MessageType.Info);
		 this.message.setDescription("预约成功！");
		 
		 int empNo = p2pCustomer.getEmpNo();
	     if(empNo > 0){
	    	 String subject= "新的预约";
	    	 String name = p2pCustomer.getUserName();
	    	 if(!StringHelper.isNullOrEmpty(p2pCustomer.getRealName())){
	    		 name = p2pCustomer.getRealName();
	    	 }
	    	 String content = "您的客户在微信现房宝上有新的预约,客户姓名："+name +"   客户手机号码："+p2pCustomer.getCellphone()+"  预约金额："+amount+"元";
	    	 LetterModel.addReminds(subject, content, empNo);
	     }
	 }else{
		 this.message.setType(MessageType.Error);
	 }
	 return SUCCESS;
 }
	
	public String subscribeWithoutLogin(){
		this.message = new Message();
		
		if(StringHelper.isNullOrEmpty(callName)){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("nameError:"+"请填写姓名");
        	return SUCCESS;
		}
		if(StringHelper.isNullOrEmpty(callPhone)){
			this.message.setType(MessageType.Error);
			this.message.setDescription("phoneError:"+"请填写手机号码");
			return SUCCESS;
		}

		if (!CharacterFilter.isVaildCallName(callName)){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("nameError:"+"请填写正确的姓名");
        	return SUCCESS;
		}
		if (!CharacterFilter.isVaildCellphone(callPhone)){
			this.message.setType(MessageType.Error);
			this.message.setDescription("phoneError:"+"请填写正确格式的手机号码");
			return SUCCESS;
		}
		
		P2pCustomer p2pCustomer = P2pCustomerModel.getInfoByCellphone(callPhone);
		P2pProduct p2pProduct =  P2pProductModel.getInfo(p2pProductNo);
		P2pSubscribe p2pSubscribe = new P2pSubscribe();
		if(p2pCustomer != null){
			p2pSubscribe.setP2pCustomer(p2pCustomer.getId());
		}
		p2pSubscribe.setCellphone(callPhone);
		p2pSubscribe.setRealName(callName);
		p2pSubscribe.setP2pProductNo(p2pProductNo);
		p2pSubscribe.setVisitTime(DateHelper.getCurrentTime());
		p2pSubscribe.setStatus((byte)1);
		p2pSubscribe.setIsTest(p2pProduct.getIsTest());
		if(P2pSubscribeModel.add(p2pSubscribe) > 0){
			this.message.setType(MessageType.Info);
			this.message.setDescription("预约成功");
			if(p2pCustomer!=null){
				int empNo = p2pCustomer.getEmpNo();
				if(empNo > 0){
					String subject= "新的预约";
					String name = p2pCustomer.getUserName();
					if(!StringHelper.isNullOrEmpty(p2pCustomer.getRealName())){
						name = p2pCustomer.getRealName();
					}
					String content = "您的客户（未登录）在微信现房宝上有新的预约,客户姓名："+name +"   客户手机号码："+p2pCustomer.getCellphone();
					LetterModel.addReminds(subject, content, empNo);
				}
			}
			String mailContent = String.format(MailHelper.MAIL_SUBSCRIBE_BODY, p2pSubscribe.getRealName(),
					p2pSubscribe.getVisitTime().toString(),p2pProduct.getName(),
					p2pSubscribe.getCellphone());

	        EmailModel.add(MailHelper.MAIL_SUBSCRIBE_RECEIVER, MailHelper.MAIL_SUBSCRIBE_SUBJECT, mailContent);
		}
		return SUCCESS;
	}
}


