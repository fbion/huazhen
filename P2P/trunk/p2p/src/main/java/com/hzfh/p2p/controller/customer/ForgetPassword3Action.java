package com.hzfh.p2p.controller.customer;

import java.sql.Date;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.controller.common.JsonBaseAction.MessageType;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzframework.helper.DateHelper;

/**
 * Created by paul on 15-3-19.
 */
public class ForgetPassword3Action extends CommonAction {
    private String key;
    private String ci;
	private String cn;
	private String t;
	
    public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }
	
	private String customerInfo;
    public String getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}
	private String message;
	
	public String getMessage() {
		return message;
	}

	@Override
    public String execute(){
        this.setPageAlias(PageAlias.resetPassword);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        if(key==null){
        	int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
        	Date sendTime = new Date(Long.parseLong(t));
        	System.out.println(DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).after(new Date(System.currentTimeMillis())));
        	/*if (DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).before(new Date(System.currentTimeMillis()))){
        		message = "链接已过期！";
        		return "forgetPasswordError";
        	}*/
        	P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
        	if(p2pCustomer==null){
        		message = "用户信息错误！";
            	return "forgetPasswordError";
        	}
        	String secretKey = p2pCustomer.getSecretKey();
        	String customerName = p2pCustomer.getUserName();
        	String secretInfo=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), secretKey);
        	if(!secretInfo.equals(ci)){
        		message = "用户信息错误！";
            	return "forgetPasswordError";
        	}
        }else{
        	
        	String[] strings = key.split(",");
        	if (strings.length != 3){
        		message = "链接错误！请核对链接！";
            	return "forgetPasswordError";
        	}
        	
        	int customerId = Integer.valueOf(strings[1]);
        	Date sendTime = new Date(Long.parseLong(strings[2]));
        	
        	if (DateHelper.addHour(sendTime, ParamHelper.RESET_EMAIL_EXPIRE_HOUR).before(new Date(System.currentTimeMillis()))){
        		message = "链接已过期！";
        		return "forgetPasswordError";
        	}
        	
        	P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerId);
        	if (p2pCustomer == null){
        		message = "用户信息错误！";
            	return "forgetPasswordError";
        	}
        	
        	String cipherText = EncodeHelper.encryptPWD(p2pCustomer.getEmail()+strings[2], p2pCustomer.getUserName(), p2pCustomer.getSecretKey());
        	
        	if (!cipherText.equals(strings[0])){
        		message = "用户信息错误！";
            	return "forgetPasswordError";
        	}
        }
        
        
        
        
        /*this.t= String.valueOf(System.currentTimeMillis());
		this.ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);*/
        redirectUrl = this.buildWWWSiteUrl(PageAlias.resetSuccess);

        return SUCCESS;
    }
}