package com.hzfh.p2p.controller.customer;

import java.sql.Date;

import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.SnModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzframework.helper.StringHelper;



public class AccountAction extends CommonAction{

	@Override
	public String execute(){
        this.setPageAlias(PageAlias.account);
        
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        
        this.paymentMoneyRechargeUrl = this.buildWWWSiteUrl(PageAlias.myPaymentMoneyRechargeList);
        this.paymentMoneyWithdrawUrl = this.buildWWWSiteUrl(PageAlias.myPaymentMoneyWithdrawList);
        
        this.getUserAccountInfo();
        
        return SUCCESS;
	}
	
	
	
	private String name;
	private PaymentAccountInformation paymentAccountInformationl;
	private String lastTime;
	private int accountPwdCheck;
	private int loginPwdCheck;
	private String paymentMoneyRechargeUrl;
	private String paymentMoneyWithdrawUrl;
	private String accountSecurityUrl;
	private int authenticationAccountStatus;
	private int authenticationBankCardStatus;
	
	public int getAuthenticationBankCardStatus() {
		return authenticationBankCardStatus;
	}
	public int getAuthenticationAccountStatus() {
		return authenticationAccountStatus;
	}
	public String getAccountSecurityUrl() {
		return accountSecurityUrl;
	}
	public String getPaymentMoneyRechargeUrl() {
		return paymentMoneyRechargeUrl;
	}
	public String getPaymentMoneyWithdrawUrl() {
		return paymentMoneyWithdrawUrl;
	}
	public String getLastTime() {
		return lastTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PaymentAccountInformation getPaymentAccountInformationl() {
		return paymentAccountInformationl;
	}
	public int getAccountPwdCheck() {
		return accountPwdCheck;
	}
	public int getLoginPwdCheck() {
		return loginPwdCheck;
	}
	private String p2pProductListUrl;
	public String getP2pProductListUrl() {
		return p2pProductListUrl;
	}
	private void getUserAccountInfo(){
		int id = StateValues.getCustomerId();
		String name = StateValues.getUserName();
		long d = Long.valueOf(StateValues.getLoginTime());
		Date lastTime=new Date(d); 
		this.lastTime = lastTime.toString();
		if (id!= 0 && name!= null) {
			P2pCustomer p2pcustomer = P2pCustomerModel.getInfo(id);
			if (p2pcustomer!=null) {
				this.name = p2pcustomer.getRealName();	
				if(StringHelper.isNullOrEmpty(this.name)){
					this.name = name;
					if(this.name.length()>=36){
						this.name = p2pcustomer.getCellphone();
					}
				}
				if (!StringHelper.isNullOrEmpty(p2pcustomer.getPassword())) {
					this.loginPwdCheck=1;
				}else{
					this.loginPwdCheck=0;
				}
			}
		PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(id);
		this.p2pProductListUrl = UrlHelper.buildWWWSiteUrl(PageAlias.p2pProductList);
		if (paymentAccountInformation!=null) {
 			if(paymentAccountInformation.getAuthenticationName()==1&&paymentAccountInformation.getAuthenticationEmail()==1){//&&paymentAccountInformation.getAuthenticationBankCard()==1
				this.authenticationAccountStatus = 1;
			}else {
				this.authenticationAccountStatus = 0;
			}
 			if(paymentAccountInformation.getAuthenticationBankCard()==1){
 				this.authenticationBankCardStatus = 1;
 			}else{
 				this.authenticationBankCardStatus = 0;
 			}
			accountSecurityUrl  = this.buildWWWSiteUrl(PageAlias.paymentAccountSecurity);
			this.paymentAccountInformationl = paymentAccountInformation;
			if (paymentAccountInformation.getAuthenticationName()==1&&paymentAccountInformation.getAccountPwd()==1){
				this.accountPwdCheck= 1;
				}else{
					this.accountPwdCheck= 0;
				}
			}
		}
	}
	
}
