package com.hzfh.p2p.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.request.gateway.RegisterReq;
import com.hzfh.api.payment.model.request.gateway.ResetMobileReq;
import com.hzfh.api.payment.model.request.gateway.ResetPasswordReq;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.model.baseInfo.SmsModel;
import com.hzfh.p2p.model.baseInfo.SnModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.payment.GatewayModel;
import com.hzframework.helper.StringHelper;

import freemarker.core.ReturnInstruction.Return;

public class AjaxP2pPersonalInfoAction  extends JsonBaseAction<P2pCustomer> {
	
	private P2pCustomer p2pCustomer;//页面传过来的
	private P2pCustomer loginCustomer;//登陆的
	private PaymentData paymentData;
	private String tel;
	private String smsCaptcha;
    public void setSmsCaptcha(String smsCaptcha) {
		this.smsCaptcha = smsCaptcha;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public PaymentData getPaymentData() {
		return paymentData;
	}

	public void setP2pCustomer(String p2pCustomer) {
        this.p2pCustomer =JSON.parseObject(p2pCustomer,P2pCustomer.class);
    }
    
    public P2pCustomer getP2pCustomer() {
		return p2pCustomer;
	}
    public String execute(){
    	this.message = new Message<String>();
    	String vaild = this.vaild();
		if(!StringHelper.isNullOrEmpty(vaild)){
			this.message.setType(MessageType.Error);
			this.message.setDescription(vaild);
			return SUCCESS;
		}
		int id = AuthenticationModel.getCustomerId();
		loginCustomer  =  P2pCustomerModel.getInfo(id);
		String p2pcardNumber = p2pCustomer.getCardNumber();
		P2pCustomer customer = P2pCustomerModel.getP2pCustomerByCardNubmer(p2pcardNumber);//查数据库中的用户
		PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(id);
		int authName = paymentAccountInformation.getAuthenticationName();
        if(customer!=null){
	        if(PaymentAccountInformationModel.getInfoByCustomerNo(customer.getId()).getAuthenticationIdcard() == 0){
	        	p2pCustomer.setId(id);
	    		P2pCustomerModel.updateRealNameCustomerNo(p2pCustomer);
	        }else{
				this.message.setType(MessageType.Warning);
	  			this.message.setDescription("身份证号已经存在!");
	  			return SUCCESS;
			}
        }
		
		RegisterReq registerReq=new RegisterReq();
		registerReq.setCallbackUrl(UrlHelper.bulidWebBackUrl("customer/registerCallback"));
		registerReq.setNotifyUrl(UrlHelper.bulidWebBackUrl("customer/paymentRegister/registerNotify"));
		registerReq.setPlatformUserNo(Integer.toString(id));
		registerReq.setRealName(p2pCustomer.getRealName());
		if(loginCustomer.getUserName().length() <= 20){
			registerReq.setNickName(loginCustomer.getUserName());
		}else{
			registerReq.setNickName(loginCustomer.getCellphone());
		}
		registerReq.setIdCardNo(p2pCustomer.getCardNumber());
		registerReq.setPlatformNo(registerReq.getPlatformNo());
		registerReq.setEmail(loginCustomer.getEmail());
		String sn=SnModel.getSn(SnEnum.SN_RECHARGE);
		registerReq.setRequestNo(sn);
		registerReq.setMobile(loginCustomer.getCellphone());
		registerReq.setIdCardType("G2_IDCARD");
		this.paymentData = GatewayModel.register(registerReq);
		p2pCustomer.setId(id);
		P2pCustomerModel.updateRealNameCustomerNo(p2pCustomer);
		//认证通过插入认证表
    	return SUCCESS;
    }
    //完善个人信息
    public String updateInfo(){
    	String vaild = this.vaild();
		if(!StringHelper.isNullOrEmpty(vaild)){
			this.message.setType(MessageType.Error);
			this.message.setDescription(vaild);
			return SUCCESS;
		}
		
		int id = AuthenticationModel.getCustomerId();
		loginCustomer  =  P2pCustomerModel.getInfo(id);
		/*loginCustomer.setProvinceNo(p2pCustomer.getProvinceNo());
		loginCustomer.setCityNo(p2pCustomer.getCityNo());
		loginCustomer.setDistrictNo(p2pCustomer.getDistrictNo());
		loginCustomer.setAddress(p2pCustomer.getAddress());*/
		loginCustomer.setAddress(p2pCustomer.getAddress());
		loginCustomer.setSex(p2pCustomer.getSex());
		loginCustomer.setCompanyAddress(p2pCustomer.getCompanyAddress());
		loginCustomer.setCompanyName(p2pCustomer.getCompanyName());
		loginCustomer.setMarry(p2pCustomer.getMarry());
		P2pCustomerModel.update(loginCustomer);
    	return SUCCESS;
    }
    //修改交易密码
    public String updatePwd(){
    	this.message = new Message<String>();
		int id = AuthenticationModel.getCustomerId();
		ResetPasswordReq resetPasswordReq=new ResetPasswordReq();
		resetPasswordReq.setCallbackUrl(UrlHelper.bulidWebBackUrl("customer/resetPwdCallback"));
		resetPasswordReq.setPlatformUserNo(Integer.toString(id));
		String sn=SnModel.getSn(SnEnum.SN_RECHARGE);
		resetPasswordReq.setPlatformNo(resetPasswordReq.getPlatformNo());
		resetPasswordReq.setRequestNo(sn);
		this.paymentData = GatewayModel.resetPassword(resetPasswordReq);
		this.message.setType(MessageType.Info);
		this.message.setDescription("交易密码设置成功" );
		//认证通过插入认证表
    	return SUCCESS;
    }
    //修改手机号
    public String updateCellphone(){
    	this.message = new Message<String>();
    	int id = AuthenticationModel.getCustomerId();
    	
    	
    	
    	
    	ResetMobileReq resetMobileReq=new ResetMobileReq();
    	resetMobileReq.setPlatformNo(resetMobileReq.getPlatformNo());
    	String sn=SnModel.getSn(SnEnum.SN_RESET_MOBILE);
    	resetMobileReq.setRequestNo(sn);
    	resetMobileReq.setPlatformUserNo(Integer.toString(id));
    	resetMobileReq.setCallbackUrl(UrlHelper.bulidWebBackUrl("customer/resetMobileCallback"));
    	resetMobileReq.setNotifyUrl(UrlHelper.bulidWebBackUrl("customer/paymentResetMobile/resetMobileNotify"));
    	this.paymentData = GatewayModel.resetMobile(resetMobileReq);
    	/*this.message.setType(MessageType.Info);
    	this.message.setDescription("交易密码设置成功" );*/
    	//认证通过插入认证表
    	return SUCCESS;
    }
	public String updateTelephone(){
		this.message = new Message<String>();
		
		
		String vfCode = SmsModel.getCaptchaFromMenCache("captcha", tel);
		if(StringHelper.isNullOrEmpty(vfCode)){
			message.setType(MessageType.Error);
			message.setDescription("请重新获取手机验证码（可能已过期）");
			return SUCCESS;
		}
		if(!vfCode.equals(this.smsCaptcha)){
			message.setType(MessageType.Error);
			message.setDescription("手机验证码不正确");
			return SUCCESS;
		}
		
		
    	int customerNo = AuthenticationModel.getCustomerId();
		int id = P2pCustomerModel.updateCellphoneByCustomerNo(tel, customerNo);
		if(id<=0){
			message.setType(MessageType.Error);
			message.setDescription("手机号保存失败！");
			return SUCCESS;
		}
		id =PaymentAccountInformationModel.updateAuthenticationTelByCustomerNo(1, customerNo);
		if(id<=0){
			message.setType(MessageType.Error);
			message.setDescription("手机号保存失败！");
			return SUCCESS;
		}
		message.setType(MessageType.Info);
		return SUCCESS;
	}
    
    private String vaild(){
    	//正则验证realName
    	if (!CharacterFilter.isVaildRealName(p2pCustomer.getRealName())){
            return "请填写合法的用户名!";
        }
		//正则验证cardNumber 存在
		if (!CharacterFilter.isVaildCardNumber(p2pCustomer.getCardNumber())){
			return "请填写合法的身份证号!";
		}
		return "";
    }
    
    public String getP2pCustomerInfo(){
    	int customerNo = AuthenticationModel.getCustomerId();
    	this.p2pCustomer = P2pCustomerModel.getInfo(customerNo);
    	return SUCCESS;
    }
}
