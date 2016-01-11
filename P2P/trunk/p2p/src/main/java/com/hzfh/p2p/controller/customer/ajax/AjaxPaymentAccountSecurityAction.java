package com.hzfh.p2p.controller.customer.ajax;

import java.util.List;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.model.baseInfo.EmailModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.helper.CommonHelper;
import com.hzfh.p2p.model.common.properties.MailHelper;
import com.hzfh.p2p.model.customer.EmailChangeModel;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class AjaxPaymentAccountSecurityAction extends JsonBaseAction<P2pCustomer> {
   private String oldEmail;
   private String newEmail;
   private String cardPath;
   private String portraitPath;

   public void setOldEmail(String oldEmail) {
	   this.oldEmail = oldEmail;
   }
   public void setNewEmail(String newEmail) {
	   this.newEmail = newEmail;
   }
   public void setCardPath(String cardPath) {
	   this.cardPath = cardPath;
   }
   public void setPortraitPath(String portraitPath) {
	   this.portraitPath = portraitPath;
   }
   /**
    * 验证旧邮箱
    * @return
    */
   public String checkOldEmail() {
	   this.ajaxCheckOldEmail();
       return SUCCESS;
   }
   public String ajaxCheckOldEmail(){
	   this.message = new Message();
	   if(StringHelper.isNullOrEmpty(oldEmail.trim())){
		   this.message.setType(MessageType.Warning);
           this.message.setDescription("请填写原邮箱");
           return "ERROR";
	   }
	   if(!CharacterFilter.isEmailAddress(oldEmail.trim())){
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("请输入正确的原邮箱");
		   return "ERROR";
	   }
        
       int id=AuthenticationModel.getCustomerId();
 	   P2pCustomer customer=P2pCustomerModel.getInfo(id);
 	   if(StringHelper.isNullOrEmpty(customer.getEmail())){
	 	   this.message.setType(MessageType.Warning);
	       this.message.setDescription("您还没有验证邮箱");
	       return "ERROR";
 	   }
 	   if(!customer.getEmail().equals(this.oldEmail)){
	 	   this.message.setType(MessageType.Warning);
	       this.message.setDescription("填写的原邮箱不正确");
	       return "ERROR";
 	   }
 	   return "SUCCESS";
   }
   /**
    * 验证新邮箱
    * @return
    */
   public String checkNewEmail() {
	   this.ajaxCheckNewEmail();
	   return SUCCESS;
   }
   public String ajaxCheckNewEmail(){
	   this.message = new Message();
	   if(StringHelper.isNullOrEmpty(newEmail.trim())){
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("请填写新邮箱");
		   return "ERROR";
	   }
	   if(!CharacterFilter.isEmailAddress(newEmail.trim())){
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("请输入正确的新邮箱");
		   return "ERROR";
	   }
	   
	   int id=AuthenticationModel.getCustomerId();
	   P2pCustomer customer=P2pCustomerModel.getInfo(id);
	   if(StringHelper.isNullOrEmpty(customer.getEmail())){
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("您还没有验证邮箱");
		   return "ERROR";
	   }
	   if(customer.getEmail().equals(this.newEmail)){
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("填写的新邮箱与原邮箱一致");
		   return "ERROR";
	   }
	   P2pCustomer p2pCustomerForCheckEmail = P2pCustomerModel.selectByEmail(this.newEmail.trim());
	   if (p2pCustomerForCheckEmail != null) {
	       this.message.setType(MessageType.Warning);
	       this.message.setDescription("新邮箱已被其他用户验证，请更换");
	       return "ERROR";
	   }
	   return "SUCCESS";
   }
   
    @Override
    public String execute() {
    	if("ERROR".equals(this.ajaxCheckOldEmail())){
    		return SUCCESS;
    	}
    	if("ERROR".equals(this.ajaxCheckNewEmail())){
    		return SUCCESS;
    	}
    	if(StringHelper.isNullOrEmpty(cardPath)){
    		this.message.setType(MessageType.Warning);
 	       	this.message.setDescription("请上传身份证照片");
 	       	return SUCCESS;
    	}
    	if(StringHelper.isNullOrEmpty(portraitPath)){
    		this.message.setType(MessageType.Warning);
    		this.message.setDescription("请上传头像");
    		return SUCCESS;
    	}
    	if(!CharacterFilter.isVaildPicPath(cardPath)){
    		this.message.setType(MessageType.Warning);
 	       	this.message.setDescription("请上传正确格式的身份证照片");
 	       	return SUCCESS;
    	}
    	if(!CharacterFilter.isVaildPicPath(portraitPath)){
    		this.message.setType(MessageType.Warning);
    		this.message.setDescription("请上传正确格式的头像");
    		return SUCCESS;
    	}
    	if(CommonHelper.isFrequentlySendMail(this.oldEmail)){
			   this.message.setType(MessageType.Warning);
			   this.message.setDescription("邮箱修改过于频繁，请稍后");
			   return SUCCESS;
		   }
    	int id = AuthenticationModel.getCustomerId();
    	/*PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(id);
 	   	paymentAccountInformation.setAuthenticationEmail(0);
 	   	if(PaymentAccountInformationModel.update(paymentAccountInformation)<=0){//修改邮箱的认证状态
	 	   	this.message.setType(MessageType.Warning);
		    this.message.setDescription("邮箱修改失败，请稍后重试");
		    return SUCCESS;
 	   	}*/
 	   	
 	   	//已实名认证的话，审核通过之后并给用户发验证邮件激活后 才会去修改p2pCustomer
 	   	P2pCustomer customer=P2pCustomerModel.getInfo(id); 
 	   	EmailChange emailChange = new EmailChange();
	   	emailChange.setCustomerNo(id);
	   	emailChange.setOldEmail(customer.getEmail());
	   	emailChange.setNewEmali(this.newEmail);
	   	emailChange.setCardPath(cardPath);
	   	emailChange.setPortraitPath(portraitPath);
	   	emailChange.setPathStatus((byte) 0);
	   	int emailChangeFlag  = EmailChangeModel.add(emailChange);
	   	if (emailChangeFlag<=0) {
   			this.message.setType(MessageType.Info);
   			this.message.setDescription("邮箱修改失败，请稍后重试");
   			return SUCCESS;
	   	}
 	   	
 	   	//发邮件,应该是后台审核上传的身份证、头像后发
 	   	int remindEmailFlag = EmailModel.add(MailHelper.MAIL_AUDITOR, MailHelper.MAIL_AUDIT_SUBJECT, CommonHelper.setAuditMailUpdateContent(customer));
 	   	if(remindEmailFlag<=0){
	 	   	this.message.setType(MessageType.Warning);
			this.message.setDescription("提醒审核失败，刷新页面后重试");
			return SUCCESS;
 	   	}
 	   	
 	   	this.message.setType(MessageType.Info);
 	   	this.message.setDescription("您的修改邮箱申请已提交成功，1-2个工作日内将审核通过");
        return SUCCESS;
    }
    
    /**
     * 取消邮箱审核
     * @return
     */
    /*public String cancleEmailExamine(){
    	this.message = new Message();
    	this.message.setType(MessageType.Warning);
		this.message.setDescription("取消审核失败");
    	EmailChangeCondition emailChangeCondition = new EmailChangeCondition();
    	emailChangeCondition.setCustomerNo(AuthenticationModel.getCustomerId());
    	emailChangeCondition.setPathStatus((byte) 0);
    	List<EmailChange> emailChangeList = EmailChangeModel.getListByCondition(emailChangeCondition);
    	if(emailChangeList.size()<=0){
			return SUCCESS;
    	}
    	EmailChange emailChange = emailChangeList.get(0);
    	if(!newEmail.endsWith(emailChange.getNewEmali())){
    		return SUCCESS;
    	}
    	emailChange.setPathStatus((byte) 3);
    	if(EmailChangeModel.update(emailChange)<=0){
    		return SUCCESS;
    	}
    	this.message.setType(MessageType.Info);
		this.message.setDescription("取消审核成功");
    	return SUCCESS;
    }*/
    
    /**
     * 修改审核邮箱
     * @return
     */
    /*public String updateExamineEmail(){
    	this.message = new Message();
    	if("ERROR".equals(this.ajaxCheckNewEmail())){
    		return SUCCESS;
    	}
    	this.message.setType(MessageType.Warning);
		this.message.setDescription("修改审核邮箱失败");
    	EmailChangeCondition emailChangeCondition = new EmailChangeCondition();
    	emailChangeCondition.setCustomerNo(AuthenticationModel.getCustomerId());
    	emailChangeCondition.setPathStatus((byte) 0);
    	List<EmailChange> emailChangeList = EmailChangeModel.getListByCondition(emailChangeCondition);
    	if(emailChangeList.size()<=0){
			return SUCCESS;
    	}
    	EmailChange emailChange = emailChangeList.get(0);
    	emailChange.setNewEmali(newEmail);
    	if(EmailChangeModel.update(emailChange)<=0){
    		return SUCCESS;
    	}
    	this.message.setType(MessageType.Info);
		this.message.setDescription("修改审核邮箱成功");
    	return SUCCESS;
    }*/
}
