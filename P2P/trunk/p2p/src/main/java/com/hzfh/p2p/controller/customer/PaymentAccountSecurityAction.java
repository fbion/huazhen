package com.hzfh.p2p.controller.customer;

import java.sql.Date;
import java.util.List;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.properties.WebInfoHelper;
import com.hzfh.p2p.model.customer.EmailChangeModel;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentCustomerBankModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class PaymentAccountSecurityAction extends CommonAction{
 
	private PaymentAccountInformation paymentAccountInformation;
	private P2pCustomer p2pCustomer;
    private PaymentCustomerBank paymentCustomerBank;
    
    private String instanCardPath;
    private String instanPortraitPath;
    private String cardPath;
    private String portraitPath;
    private String lastLoginTime;
    
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public String getInstanCardPath() {
		return instanCardPath;
	}
	public String getInstanPortraitPath() {
		return instanPortraitPath;
	}
	public String getCardPath() {
		return cardPath;
	}
	public void setCardPath(String cardPath) {
		this.cardPath = cardPath;
	}
	public String getPortraitPath() {
		return portraitPath;
	}
	public void setPortraitPath(String portraitPath) {
		this.portraitPath = portraitPath;
	}
	//private String ci;
    //private String cn;
	/*public String getCi() {
		return ci;
	}
	public String getCn() {
		return cn;
	}*/
	private boolean isPwdExist;
    
	public boolean getIsPwdExist() {
		return isPwdExist;
	}

	public void setPwdExist(boolean isPwdExist) {
		this.isPwdExist = isPwdExist;
	}
    private String telephone;
    
	public String getTelephone() {
		return telephone;
	}
	public PaymentAccountInformation getPaymentAccountInformation() {
		return paymentAccountInformation;
	}
	public P2pCustomer getP2pCustomer() {
		return p2pCustomer;
	}
	public PaymentCustomerBank getPaymentCustomerBank() {
		return paymentCustomerBank;
	}
	private String captchaUrl;
	public String getCaptchaUrl() {
		return captchaUrl;
	}
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int rns;
	public int getRns() {
		return rns;
	}
	public void setRns(int rns) {
		this.rns = rns;
	}
	private String showEmail;
	private String newEmail;
	public String getShowEmail() {
		return showEmail;
	}
	public String getNewEmail() {
		return newEmail;
	}
	@Override
	public String execute(){
        this.setPageAlias(PageAlias.paymentAccountSecurity);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        
        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
        int customerNo = AuthenticationModel.getCustomerId();
        this.paymentAccountInformation  =  PaymentAccountInformationModel.getInfoByCustomerNo(customerNo);
        if(paymentAccountInformation!=null){
        	this.p2pCustomer = P2pCustomerModel.getInfo(this.paymentAccountInformation.getCustomerNo());
        	
        	if(StringHelper.isNullOrEmpty(this.p2pCustomer.getPassword())){
        		this.setPwdExist(false);
        	}else{
        		this.setPwdExist(true);
        	}
        	
        	this.telephone = p2pCustomer.getCellphone();
        	if(paymentAccountInformation.getAuthenticationIdcard()!=0&&(!StringHelper.isNullOrEmpty(p2pCustomer.getCardNumber()))){
        		p2pCustomer.setCardNumber("**************"+p2pCustomer.getCardNumber().substring(14));
        	}
        	if(paymentAccountInformation.getAuthenticationTel()!=0&&(!StringHelper.isNullOrEmpty(p2pCustomer.getCellphone()))){
        		p2pCustomer.setCellphone(p2pCustomer.getCellphone().substring(0,3)+"****"+p2pCustomer.getCellphone().substring(7));
        	}
        	
        	
        	if(p2pCustomer.getLastLoginTime()!=null){
        		lastLoginTime = DateHelper.format(new Date(p2pCustomer.getLastLoginTime().getTime()),"yyyy-MM-dd HH:mm:ss");
        	}else {
        		lastLoginTime= null;
        	}
        	if(!StringHelper.isNullOrEmpty(p2pCustomer.getEmail())){
        		showEmail = p2pCustomer.getEmail().substring(0,1)+"***"+p2pCustomer.getEmail().substring(p2pCustomer.getEmail().indexOf("@")-1);
        	}

        	if(!StringHelper.isNullOrEmpty(p2pCustomer.getCardPath())){
        		cardPath = WebInfoHelper.WEB_IMG+p2pCustomer.getCardPath();
        	}else{
        		instanCardPath = WebInfoHelper.WEB_P2P_RESOURCE_IMG+"/uploadPic1.png";
        	}
        	if(!StringHelper.isNullOrEmpty(p2pCustomer.getPortraitPath())){
        		portraitPath = WebInfoHelper.WEB_IMG+p2pCustomer.getPortraitPath();
        	}else{
        		instanPortraitPath = WebInfoHelper.WEB_P2P_RESOURCE_IMG+"/uploadPic2.png";
        	}
        	//this.cn = EncodeHelper.generateRandomCustomerId(customerNo);
            //String key = p2pCustomer.getSecretKey();
            //String customerName = p2pCustomer.getUserName();
            //this.ci=EncodeHelper.encryptPWD(customerName, String.valueOf(customerNo), key);
        	List<PaymentCustomerBank> paymentCustomerBankList = PaymentCustomerBankModel.getListByCustomerNo(customerNo);
        	for(PaymentCustomerBank p:paymentCustomerBankList){
        		if(p.getState()==1){
        			this.paymentCustomerBank = p;
        			break;
        		}
        	}
        	if(paymentCustomerBank!=null){
        		//paymentCustomerBank.setBankCard(paymentCustomerBank.getBankCard().substring(15));//库中bankCard为int型 
        	}
        	EmailChangeCondition emailChangeCondition = new EmailChangeCondition();
        	emailChangeCondition.setCustomerNo(customerNo);
        	emailChangeCondition.setPathStatus((byte) 0);
        	List<EmailChange> emailChangeList = EmailChangeModel.getListByCondition(emailChangeCondition);
        	if(emailChangeList.size()>0){
        		newEmail = emailChangeList.get(emailChangeList.size()-1).getNewEmali();
        	}
        }
        
        
        
        return SUCCESS;
	}
}
