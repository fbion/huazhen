package com.hzfh.p2p.controller.customer;

import java.sql.Date;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzframework.helper.DateHelper;

/**
 * Created by paul on 15-3-19.
 */
public class ForgetPassword4Action extends CommonAction {
	
	private String ci;
	private String cn;
	private String t;
	
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
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
	private String email;
	public String getEmail() {
		return email;
	}
	private String message;
	
	public String getMessage() {
		return message;
	}
	@Override
    public String execute(){
		this.setPageAlias(PageAlias.byEmailPassword);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
        int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
        Date sendTime = new Date(Long.parseLong(t));
        System.out.println(DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).after(new Date(System.currentTimeMillis())));
        if (DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).before(new Date(System.currentTimeMillis()))){
        	message = "链接已过期！";
        	return "forgetPasswordError";
        }
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
    	
    	/*this.t= String.valueOf(System.currentTimeMillis());
 		this.ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), secretKey);*/
    	email = p2pCustomer.getEmail().substring(0,2)+"***"+p2pCustomer.getEmail().substring(p2pCustomer.getEmail().indexOf("@")-2);
        return SUCCESS;
    }
}