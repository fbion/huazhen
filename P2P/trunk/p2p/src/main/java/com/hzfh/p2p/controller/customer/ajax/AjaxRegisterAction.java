package com.hzfh.p2p.controller.customer.ajax;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.customer.model.Activities;
import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.ActivityCashBonus;
import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.ActivityCoupons;
import com.hzfh.api.customer.model.ActivityCustomerCashBonus;
import com.hzfh.api.customer.model.ActivityCustomerCoupons;
import com.hzfh.api.customer.model.ActivityCustomerDetail;
import com.hzfh.api.customer.model.ActivityCustomerExperienceGold;
import com.hzfh.api.customer.model.ActivityCustomerInvitation;
import com.hzfh.api.customer.model.ActivityCustomerPresent;
import com.hzfh.api.customer.model.ActivityCustomerTask;
import com.hzfh.api.customer.model.ActivityExperienceGold;
import com.hzfh.api.customer.model.ActivityIntegral;
import com.hzfh.api.customer.model.ActivityIntegralDetail;
import com.hzfh.api.customer.model.ActivityPresent;
import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.p2p.controller.common.DateUtil;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.model.baseInfo.CaptchaModel;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.baseInfo.EmailModel;
import com.hzfh.p2p.model.baseInfo.LetterModel;
import com.hzfh.p2p.model.baseInfo.SmsModel;
import com.hzfh.p2p.model.baseInfo.SnModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.helper.CommonHelper;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.parameter.ActivitiesInfo;
import com.hzfh.p2p.model.common.properties.MailHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.ActivitiesModel;
import com.hzfh.p2p.model.customer.ActivityAwardRelationModel;
import com.hzfh.p2p.model.customer.ActivityCashBonusModel;
import com.hzfh.p2p.model.customer.ActivityConditionModel;
import com.hzfh.p2p.model.customer.ActivityCouponsModel;
import com.hzfh.p2p.model.customer.ActivityCustomerCashBonusModel;
import com.hzfh.p2p.model.customer.ActivityCustomerCouponsModel;
import com.hzfh.p2p.model.customer.ActivityCustomerDetailModel;
import com.hzfh.p2p.model.customer.ActivityCustomerExperienceGoldModel;
import com.hzfh.p2p.model.customer.ActivityCustomerInvitationModel;
import com.hzfh.p2p.model.customer.ActivityCustomerPresentModel;
import com.hzfh.p2p.model.customer.ActivityCustomerTaskModel;
import com.hzfh.p2p.model.customer.ActivityExperienceGoldModel;
import com.hzfh.p2p.model.customer.ActivityIntegralModel;
import com.hzfh.p2p.model.customer.ActivityPresentModel;
import com.hzfh.p2p.model.customer.EmailChangeModel;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzframework.helper.PropertyHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class AjaxRegisterAction extends JsonBaseAction<P2pCustomer> {
    private String userName;//用户名
    private String verifyCode;//验证码
    private P2pCustomer p2pCustomer;//p2p客户对象
    private String telephone;
    private String email;
    private String smsCaptcha;
    private String inviterNo;
    private String activityId;
    private String isCellphoneLogin;

	public String getIsCellphoneLogin() {
		return isCellphoneLogin;
	}

	public void setIsCellphoneLogin(String isCellphoneLogin) {
		this.isCellphoneLogin = isCellphoneLogin;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public void setInviterNo(String inviterNo) {
		this.inviterNo = inviterNo;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setSmsCaptcha(String smsCaptcha) {
		this.smsCaptcha = smsCaptcha;
	}

	public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public void setP2pCustomer(String p2pCustomer) {
        this.p2pCustomer = JSON.parseObject(p2pCustomer, P2pCustomer.class);
    }

    public String checkUserName() {
        this.message = new Message();  
        P2pCustomer p2pCustomerForCheckUserName = P2pCustomerModel.selectByUserName(userName.trim());
        if (p2pCustomerForCheckUserName == null) {
            this.message.setType(MessageType.Info);   
            this.message.setDescription("尚未注册");   
        } else {                                        
            this.message.setType(MessageType.Warning);  
            this.message.setDescription("该用户名已被注册，请更换");
        }
        return SUCCESS; 
    }

   public String checkEmail() {
        this.message = new Message();
        int id=AuthenticationModel.getCustomerId();
 	   	P2pCustomer customer=P2pCustomerModel.getInfo(id);
 	   	if(!StringHelper.isNullOrEmpty(customer.getEmail())&&customer.getEmail().equals(this.email.trim())){
 	   		this.message.setType(MessageType.Info);
 	   		return SUCCESS;
 	   	}
        P2pCustomer p2pCustomerForCheckEmail = P2pCustomerModel.selectByEmail(this.email.trim());
        if (p2pCustomerForCheckEmail == null) {
            this.message.setType(MessageType.Info);
            this.message.setDescription("尚未验证");
        } else {
            this.message.setType(MessageType.Warning);
            this.message.setDescription("该邮箱已经已验证过，请更换邮箱");
        }
        return SUCCESS;
    }
   
   /**
    * 添加邮箱
    * @return
    */
   public String regEmail(){
	   if(StringHelper.isNullOrEmpty(p2pCustomer.getEmail())){
		   this.message.setType(MessageType.Warning);
           this.message.setDescription("请填写邮箱");
           return SUCCESS;
	   }
	   if(!CharacterFilter.isEmailAddress(p2pCustomer.getEmail())){
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("请输入正确的邮箱");
		   return SUCCESS;
	   }
	   
	   this.message = new Message();
	   int id=AuthenticationModel.getCustomerId();
	   P2pCustomer customer=P2pCustomerModel.getInfo(id);
	   //1.用户本身已有邮箱
	   if(!StringHelper.isNullOrEmpty(customer.getEmail())){
		   //旧邮箱跟新邮箱不一致
		   int emailChangeFlag  = 0 ;
		   if(!customer.getEmail().equals(p2pCustomer.getEmail())){
			   P2pCustomer p2pCustomerForCheckEmail = P2pCustomerModel.selectByEmail(p2pCustomer.getEmail());
			   if(p2pCustomerForCheckEmail!=null){
				   this.message.setType(MessageType.Warning);
				   this.message.setDescription("该邮箱已被注册，请更换邮箱");
				   return SUCCESS;
			   }
			   //插入邮箱变动表
			   emailChangeFlag  = emailChangeAdd(customer);
			   if (emailChangeFlag<=0) {
		           this.message.setType(MessageType.Warning);
		           this.message.setDescription("修改邮箱操作失败");
		           return SUCCESS;
		       }
		   }
		   PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(id);
		   //未激活，旧邮箱跟新邮箱一致
		   if(customer.getEmail().equals(p2pCustomer.getEmail())){
			   if(paymentAccountInformation.getAuthenticationEmail()==1){
				   this.message.setType(MessageType.Warning);
				   this.message.setDescription("填写的新邮箱跟旧邮箱一致");
				   return SUCCESS;
			   }else{
				   emailChangeFlag  = emailChangeAdd(customer);
				   EmailModel.add(p2pCustomer.getEmail(), MailHelper.MAIL_ACTIVATE_SUBJECT, CommonHelper.setMailValidationContent(customer,p2pCustomer.getEmail(),emailChangeFlag), id);
				   if(emailChangeFlag>0){
					   this.message.setType(MessageType.Info);
					   this.message.setDescription("验证邮件已发送，赶紧去激活邮箱吧");
					   return SUCCESS;
				   }
			   }
		   }
		   //频繁发送
		   if(CommonHelper.isFrequentlySendMail(p2pCustomer.getEmail())){
			   this.message.setType(MessageType.Warning);
			   this.message.setDescription("重新发送过于频繁，请稍后");
			   return SUCCESS;
		   }
		   
		   //1.1未实名认证
		   if(paymentAccountInformation.getAuthenticationIdcard()!=1){
			   //发激活邮件
			   /*paymentAccountInformation.setAuthenticationEmail(0);
			   PaymentAccountInformationModel.update(paymentAccountInformation);*/
			   EmailModel.add(p2pCustomer.getEmail(), MailHelper.MAIL_ACTIVATE_SUBJECT, CommonHelper.setMailValidationContent(customer,p2pCustomer.getEmail(),emailChangeFlag), id);
			   this.message.setType(MessageType.Info);
	           this.message.setDescription("验证邮件已发送，赶紧去激活邮箱吧");
	           return SUCCESS;
		   }
		   //1.2已实名认证，未激活  remindEmail()方法
		   
		   //1.3已实名认证已激活     在AjaxPaymentAccountSecurityAction中
		   
	   }else{
		   //2.用户本身没有邮箱
		   P2pCustomer p2pCustomerForCheckEmail = P2pCustomerModel.selectByEmail(p2pCustomer.getEmail());
		   if(p2pCustomerForCheckEmail!=null){
			   this.message.setType(MessageType.Warning);
			   this.message.setDescription("该邮箱已被注册，请更换邮箱");
			   return SUCCESS;
		   }
		   if(CommonHelper.isFrequentlySendMail(p2pCustomer.getEmail())){
			   this.message.setType(MessageType.Warning);
			   this.message.setDescription("重新发送过于频繁，请稍后");
			   return SUCCESS;
		   }
		   
		   //插入邮箱变动表
		   int emailChangeFlag = emailChangeAdd(customer);
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("操作失败，请稍后重试");
		   if (emailChangeFlag>0) {
			   //发激活邮件
			   int  vaildEmailFlag = EmailModel.add(p2pCustomer.getEmail(), MailHelper.MAIL_ACTIVATE_SUBJECT, CommonHelper.setMailValidationContent(customer,p2pCustomer.getEmail(),emailChangeFlag), id);
			   if(vaildEmailFlag>0){
				   this.message.setType(MessageType.Info);
				   this.message.setDescription("验证邮件已发送，赶紧去激活邮箱吧！");
			   }
		   }
/*		   customer.setEmail(p2pCustomer.getEmail());
		   if (P2pCustomerModel.update(customer)>0&&vaildEmail>0) {
			   this.message.setType(MessageType.Info);
			   this.message.setDescription("验证邮件已发送，赶紧去激活邮箱吧！");
		   } else {
			   this.message.setType(MessageType.Warning);
			   this.message.setDescription("添加邮箱失败或验证邮件发送失败");
		   }
*/	   }
       
       //注意此时更改邮箱的认证状态，虽然发出邮件，但用户需激活后将认证状态改为1
	   return SUCCESS;
   }
   
   /**
    * 发送提醒审核邮件
    * @return
    */
   public String remindEmail(){
	   this.message = new Message();
	   int id=AuthenticationModel.getCustomerId();
	   P2pCustomer customer=P2pCustomerModel.getInfo(id);
	   
	   //频繁发送
	   if(CommonHelper.isFrequentlySendMail(customer.getEmail())){
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("提醒审核过于频繁，请稍后");
		   return SUCCESS;
	   }
	   
	   PaymentAccountInformation paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(id);
	   //1.2已实名认证，未激活
	   if(paymentAccountInformation.getAuthenticationEmail()!=1){
		   EmailModel.add(MailHelper.MAIL_AUDITOR, MailHelper.MAIL_AUDIT_SUBJECT, CommonHelper.setAuditMailUpdateContent(customer));
		   this.message.setType(MessageType.Info);
           this.message.setDescription("提醒审核邮寄已发送，请耐心等待处理");
           return SUCCESS;
	   }
	   return SUCCESS;
   }
   
   /**
    * 往邮箱变动表插变动记录
    * @param customer
    * @return
    */
   public int emailChangeAdd(P2pCustomer customer){
	   EmailChange emailChange = new EmailChange();
	   emailChange.setCustomerNo(customer.getId());
	   emailChange.setOldEmail(customer.getEmail());
	   emailChange.setNewEmali(p2pCustomer.getEmail());
	   emailChange.setPathStatus((byte) 1);
	   int emailChangeFlag = EmailChangeModel.add(emailChange);
	   return emailChangeFlag;
   }
   
   /**
    * 重新发送邮件
    * @return
    */
   /*
   public String reSendEmail(){
	   CacheManager.set(CachePrefix.EMAIL_SEND_LIMIT_TIME, cacheName+telephone, ParamHelper.SMS_CODE_EXPIRE_MINUTE * 60, new Date());
	   CacheManager.get(CachePrefix.EMAIL_SEND_LIMIT_TIME,"CaptchaNumberByTel"+telephone);
	   this.message = new Message();
	   int id=AuthenticationModel.getCustomerId();
	   P2pCustomer customer=P2pCustomerModel.getInfo(id);
	   if(!StringHelper.isNullOrEmpty(customer.getEmail()))
		   this.sendEmail(customer.getEmail(),message);
       //注意此时更改邮箱的认证状态，虽然发出邮件，但用户需激活后将认证状态改为1
	   return SUCCESS;
   }*/
   
   /*public void sendEmail(String email1,Message message){
	   
	   int id=AuthenticationModel.getCustomerId();
	   P2pCustomer customer=P2pCustomerModel.getInfo(id);
	   String key = EncodeHelper.initKey(customer.getUserName());
       String cipherText = EncodeHelper.encryptPWD(customer.getUserName(), customer.getUserName(), key);
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append(cipherText);
       stringBuilder.append(",");
       stringBuilder.append(String.valueOf(id));
       stringBuilder.append(",");
       stringBuilder.append(String.valueOf(System.currentTimeMillis()));

       String cipherTextUrl = this.buildWWWSiteUrl(PageAlias.emailValidation) + "?key=" + stringBuilder.toString();
	   String mailContent = String.format(MailHelper.MAIL_ACTIVATE_BODY, cipherTextUrl,ParamHelper.ACTIVATE_EMAIL_EXPIRE_DAY, customer.getUserName());

	   EmailModel.add(email1, MailHelper.MAIL_ACTIVATE_SUBJECT, mailContent, id);
       customer.setEmail(email1);
       if (P2pCustomerModel.update(customer)<=0) {
           this.message.setType(MessageType.Warning);
           this.message.setDescription("绑定邮箱操作失败");
       } else {
           this.message.setType(MessageType.Info);
           this.message.setDescription("还差一步即可绑定成功，快去激活邮箱吧！");
       }
   }*/
   
   public String checkCellphone(){
	   this.message = new Message();
	   this.message.setType(MessageType.Info);
	   if(StringHelper.isNullOrEmpty(this.telephone)){
		   this.message.setType(MessageType.Warning);
		   this.message.setDescription("请输入手机号码");
		   return SUCCESS;
	   }
	   if(!CharacterFilter.isVaildCellphone(this.telephone)){
		   this.message.setType(MessageType.Error);
		   this.message.setDescription("请输入正确的手机号码");
		   return SUCCESS;
	   }
	   if(isCellphoneLogin.equals("1")){
		   if(P2pCustomerModel.getInfoByCellphone(this.telephone)==null){
	       	   this.message.setType(MessageType.Error);
	       	   this.message.setDescription("该手机号还没注册");
	       	   return SUCCESS;
	       }
	   }else{
		   if(P2pCustomerModel.getInfoByCellphone(this.telephone)!=null){
	       	   this.message.setType(MessageType.Error);
	       	   this.message.setDescription("该手机号码已被注册，请更换其他手机号码");
	       	   return SUCCESS;
	       }
	   }
	   return SUCCESS;
   }
   
   public String checkInviteCellphone(){
	   this.message = new Message();
	   this.message.setType(MessageType.Info);
	  
	   if(!CharacterFilter.isVaildCellphone(this.inviterNo)){
       	this.message.setType(MessageType.Error);
           this.message.setDescription("请输入正确的手机号码");
           return SUCCESS;
       }
	   if(P2pCustomerModel.getInfoByCellphone(inviterNo) == null){
       	   this.message.setType(MessageType.Warning);
       	   this.message.setDescription("邀请人手机号码未注册，请更换其他手机号码");
       	   return SUCCESS;
       }
	   if(activityId==null||("").endsWith(activityId)){
			Activities  activities = ActivitiesModel.getInfoByActivitytype(ActivitiesInfo.ACTIVITY_CASH_TYPE);
			activityId =activities.getId()+"";
		}
/*	   P2pCustomer  customer= P2pCustomerModel.getInfoByCellphone(inviterNo);
	   ActivityCustomerTask activityCustomerTask = ActivityCustomerTaskModel.getInfoByCondition(customer.getId(),Integer.parseInt(activityId));
	   if(activityCustomerTask==null){
		   this.message.setType(MessageType.Warning);
       	   this.message.setDescription(inviterNo+"该用户未参加邀请活动");
       	   return SUCCESS;
	   }*/
	   return SUCCESS;
   }
    @SuppressWarnings("static-access")
	@Override
    public String execute() {   
        this.message = new Message();

        //验证正则
        if (!CharacterFilter.isVaildVerifyCode(verifyCode)){
            this.message.setType(MessageType.Error);
            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }
        if (!CharacterFilter.isVaildCustomerName(p2pCustomer.getUserName())){
        	this.message.setType(MessageType.Error);
        	this.message.setDescription("userError:" + "用户名必须为4~20位字符，支持字母或字母、数字和下划线的组合");
        	return SUCCESS;
        }
        if (!CharacterFilter.isVaildPwd(p2pCustomer.getPassword())){
            this.message.setType(MessageType.Error);
            //this.message.setDescription("pwdError:" + "6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号");
            this.message.setDescription("pwdError:" + "密码必须为6~20位字符");
            return SUCCESS;
        }
        if(!CharacterFilter.isVaildCellphone(p2pCustomer.getCellphone())){
        	this.message.setType(MessageType.Error);
            this.message.setDescription("cellphoneError:" + "请输入正确的手机号码");
            return SUCCESS;
        }
        if(!CharacterFilter.isVaildSmsCaptcha(this.smsCaptcha)){
        	this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "请输入6位数字的手机验证码");
        	return SUCCESS;
        }
        
        //验证数据
        if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null){
            this.message.setType(MessageType.Error);

            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }
        CaptchaModel.delete(StateValues.getCaptchaKey());

        if (P2pCustomerModel.selectByUserName(p2pCustomer.getUserName()) != null){
            this.message.setType(MessageType.Error);
            this.message.setDescription("该用户名已被注册，请更换");
            return SUCCESS;
        }
        if(P2pCustomerModel.getInfoByCellphone(p2pCustomer.getCellphone())!=null){
        	this.message.setType(MessageType.Error);
        	this.message.setDescription("cellphoneError:" + "该手机号码已被其他用户认证，请更换其他手机号码");
        	return SUCCESS;
        }
        String vfCode = SmsModel.getCaptchaFromMenCache("captcha", p2pCustomer.getCellphone());
		if(StringHelper.isNullOrEmpty(vfCode)){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "请重新获取手机验证码（可能已过期）");
			return SUCCESS;
		}
		if(!vfCode.equals(this.smsCaptcha)){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "手机验证码不正确");
			return SUCCESS;
		}
		
    
        String key = EncodeHelper.initKey(p2pCustomer.getUserName());

        String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(p2pCustomer.getPassword()), key);

        p2pCustomer.setPassword(pwd);
        p2pCustomer.setSecretKey(key);
        p2pCustomer.setStatus((byte) 1);
        
        int id = P2pCustomerModel.add(p2pCustomer); 
        if (id <= 0)    
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("Error:" + "注册失败请稍后再试");
            return SUCCESS;
        }
        
        int empNo = p2pCustomer.getEmpNo();
        if(empNo > 0){
        	/*Letter info = new Letter();
        	info.setRecipient(empNo);
	    	info.setSubject("新的客户");
	    	String content = "您已被52touzi网站的新用户选为理财顾问,新用户的手机号码为"+p2pCustomer.getCellphone();
	    	info.setContent(content);
	    	info.setSendTime(DateHelper.getCurrentTime());
	    	info.setInUserNo(10000);
	    	info.setType((byte)2);
	    	info.setStatus(1);
	    	info.setImportantDegree(2);
	    	LetterModel.add(info);*/
	    	String subject= "新的客户";
	    	String content = "您已被52touzi网站的新用户选为理财顾问,用户账号："+p2pCustomer.getUserName()+" 新用户的手机号码为"+p2pCustomer.getCellphone();
	    	LetterModel.addReminds(subject, content, empNo);
        }else{
        	String subject= "新的客户";
	    	String content = "有新的52touzi网站客户注册,用户账号："+p2pCustomer.getUserName()+" 新用户的手机号码为"+p2pCustomer.getCellphone();
	    	
	        String customerServiceNo =PropertyHelper.getParamProperty("customer.service.no");
	        if(!StringHelper.isNullOrEmpty(customerServiceNo)){
	        	LetterModel.addReminds(subject, content, Integer.parseInt(customerServiceNo));
	        }
        }
        
        if(!StringHelper.isNullOrEmpty(inviterNo)){
        	Activities  activities = null;
        	P2pCustomer  customer= P2pCustomerModel.getInfoByCellphone(inviterNo);
        	if(customer!=null){
        		if(StringHelper.isNullOrEmpty(activityId)){
        			//根据活动的类型和活动最新发布时间
        			DicData dic =  DicDataModel.getCodeByTypeNoAndName(53,"普通邀请活动");//邀请活动Code
        			activities = ActivitiesModel.getInfoByActivitytype(dic.getCode());
        			activityId = activities.getId()+"";
        		}else{
        			activities = ActivitiesModel.getInfo(Integer.parseInt(activityId));
        			activityId = activities.getId()+"";
        		}
        		//插入我的邀请表
        		ActivityCustomerInvitation invitation = new ActivityCustomerInvitation();
        		//invitation.setRewardsMoney(ActivitiesInfo.ACTIVITY_REWARDS_MONEY);
        		invitation.setP2pCustomerNo(customer.getId());
        		invitation.setInvitedNo(id);
        		invitation.setRegisterTime(DateUtil.getNowTimestamp());
        		invitation.setInviteTime(DateUtil.getNowTimestamp());
        		invitation.setActivityNo(Integer.parseInt(activityId));
        		invitation.setStatus(ActivitiesInfo.ACTIVITY_STATUS_DISABLE);
        		invitation.setRequestNo(SnModel.getSn(SnEnum.SN_TRANSFER_REQUEST_NO));//请求流水号
    			ActivityCustomerTask activityCustomerTask = ActivityCustomerTaskModel.getInfoByCondition(customer.getId(),Integer.parseInt(activityId));
    			//插入我的活动详情
    			ActivityCustomerDetail activityCustomerDetail = new ActivityCustomerDetail();
    			if(activityCustomerTask==null){
    				ActivityCustomerTask activityCustTask = new ActivityCustomerTask();
    				activityCustTask.setP2pCustomerNo(customer.getId());
    				activityCustTask.setActivityNo(Integer.parseInt(activityId));
    				int activityCustomerTaskId = ActivityCustomerTaskModel.add(activityCustTask);
    				activityCustomerDetail.setActivityCustomerTaskNo(activityCustomerTaskId);//我的活动外键ID
    			}else{
    				activityCustomerDetail.setActivityCustomerTaskNo(activityCustomerTask.getId());//我的活动外键ID
    			}
    			activityCustomerDetail.setTaskStatus((byte) 0);
    			activityCustomerDetail.setInvitedNo(id);//新用户注册的id
    			/**
    			 * 根据活动id查询活动条件信息 ，获得活动的奖励单号和奖励方式
    			 */
    			List<ActivityAwardRelation> list = new ArrayList<ActivityAwardRelation>();
    			list = ActivityAwardRelationModel.getInfoByActId(Integer.parseInt(activityId));//活动条件
    				activityCustomerDetail.setActivityAwardId(list.get(0).getId());
    				int actCustomerId = ActivityCustomerDetailModel.add(activityCustomerDetail);
    				int actRewardType = list.get(0).getActivityRewardType();
    				invitation.setActivityRewardType(actRewardType);//奖励相关单号（现金ID，礼品ID，优惠券ID）
    				int relatedNo =0;
    				boolean isOrdinaryInvite = true;
    				if(actRewardType==1){
    					//插入我的体验金
    					relatedNo = this.addCustomerExperienceGold(customer,activities,actCustomerId,isOrdinaryInvite);
    					int experienceGoldNo = ActivityCustomerExperienceGoldModel.getInfo(relatedNo).getExperienceGoldNo();
    					double expMoney = ActivityExperienceGoldModel.getInfo(experienceGoldNo).getGoldMoney();
    					double rate = 0;
    					int cid = ActivityAwardRelationModel.getInfoByRelatedNo(1,ActivityExperienceGoldModel.getInfo(experienceGoldNo).getId()).getConditionId();
    					ActivityCondition activityCondition = ActivityConditionModel.getInfo(cid);
    					if(activityCondition!=null){
    						if(activityCondition.getProductType()==5){
    							rate = P2pProductModel.getP2pByProductNo(activityCondition.getProductName()).getIncome();
    						}
    					}
    					invitation.setRewardsMoney((expMoney)*(rate/100)*(ActivityExperienceGoldModel.getInfo(experienceGoldNo).getDay())/365);
    				}else if(actRewardType==2){
    					//插入我的现金奖励
    	    			relatedNo = this.addCustomerCashBonus(customer,activities,actCustomerId,isOrdinaryInvite);
    	    			int cashBonusNo = (int) ActivityCustomerCashBonusModel.getInfo(relatedNo).getCashBonusNo();
    	    			invitation.setRewardsMoney(ActivityCashBonusModel.getInfo(cashBonusNo).getMoney());
    			}
				invitation.setActivityRewardType(actRewardType);//奖励方式（1.现金，2.礼品，3.优惠券）
				invitation.setRelatedNo(relatedNo);//奖励相关单号（现金ID，礼品ID，优惠券ID）
        		ActivityCustomerInvitationModel.add(invitation);
        	}
        	
        }
        PaymentAccountInformation paymentAccountInfo=new PaymentAccountInformation();
		paymentAccountInfo.setCustomerNo(id);
		String dateStr = "";
		Date date = new Date();   
	    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    dateStr = sdf.format(date); 
	    Timestamp ts = new Timestamp(System.currentTimeMillis());   
        try {   
            ts = Timestamp.valueOf(dateStr);   
			paymentAccountInfo.setAccrualTimePeriod(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
        paymentAccountInfo.setAuthenticationTel(1);
        paymentAccountInfo.setAccountType((byte)1);
		PaymentAccountInformationModel.add(paymentAccountInfo);
		
        return SUCCESS;
    }
     /**
      * 添加我的体验金
      * @author guojia 
      */
     public static int addCustomerExperienceGold(P2pCustomer  customer,Activities  activities,int actCustomerId,boolean isOrdinaryInvite){
    	 int resultno =0;
    	 if(isOrdinaryInvite){
    		 ActivityExperienceGold actExperienceGoldModel = ActivityExperienceGoldModel.getActExperienceGoldModelByActId(activities.getId()).get(0);
        	 ActivityCustomerExperienceGold actCutExpGold = new ActivityCustomerExperienceGold();
    			actCutExpGold.setP2pCustomerNo(customer.getId());
    			actCutExpGold.setGainTime(DateUtil.getNowTimestamp());
    			actCutExpGold.setStartTime(activities.getStartTime());
    			actCutExpGold.setEndTime(activities.getEndTime());
    			actCutExpGold.setStatus((byte) 0);
    			actCutExpGold.setExperienceGoldNo(actExperienceGoldModel.getId());//体验金奖励外键
    			actCutExpGold.setMyActivityNo(actCustomerId);//我的活动详情外键
    			resultno = ActivityCustomerExperienceGoldModel.add(actCutExpGold);
    	 }else {
    		 List<ActivityExperienceGold> actExperienceGoldModel = 
        			 ActivityExperienceGoldModel.getActExperienceGoldModelByActId(activities.getId());//根据活动id查询体验金奖励(普通活动时需要遍历)
    		 for(int i=0;i<actExperienceGoldModel.size();i++){
    			ActivityCustomerExperienceGold actCutExpGold = new ActivityCustomerExperienceGold();
     			actCutExpGold.setP2pCustomerNo(customer.getId());
     			actCutExpGold.setGainTime(DateUtil.getNowTimestamp());
     			actCutExpGold.setStartTime(activities.getStartTime());
     			actCutExpGold.setEndTime(activities.getEndTime());
     			actCutExpGold.setStatus((byte) 0);
     			actCutExpGold.setExperienceGoldNo(actExperienceGoldModel.get(i).getId());//体验金奖励外键
     			actCutExpGold.setMyActivityNo(actCustomerId);//我的活动详情外键
     			ActivityCustomerExperienceGoldModel.add(actCutExpGold);
    		 }
    	 }
    	 return resultno;
    	
     }
     /**
      * 添加我的现金奖励
      * @author guojia 
      */
     public static int addCustomerCashBonus(P2pCustomer  customer,Activities  activities,int actCustomerId,boolean isOrdinaryInvite){
    	int resultno =0;
    	if(isOrdinaryInvite){
    		ActivityCashBonus activityCashBonus =  ActivityCashBonusModel.getActivityCashBonusByActId(activities.getId()).get(0);
			int actCashBonusId = activityCashBonus.getId();
			ActivityCustomerCashBonus activityCustomerCashBonus = new ActivityCustomerCashBonus();
			activityCustomerCashBonus.setP2pCustomerNo(customer.getId());
			activityCustomerCashBonus.setCashBonusNo(actCashBonusId);//现金奖励外键
			activityCustomerCashBonus.setMyActivityNo(actCustomerId);//我的活动详情外键
			activityCustomerCashBonus.setEditTime(DateUtil.getNowTimestamp());
			activityCustomerCashBonus.setInTime(DateUtil.getNowTimestamp());
			activityCustomerCashBonus.setEditUserNo(customer.getId());
			activityCustomerCashBonus.setAcquisitionTime(DateUtil.getNowTimestamp());
			activityCustomerCashBonus.setStatus((byte) 0);
			resultno = ActivityCustomerCashBonusModel.add(activityCustomerCashBonus); 
    	}else{
    		List<ActivityCashBonus> activityCashBonus = 
					ActivityCashBonusModel.getActivityCashBonusByActId(activities.getId());//根据活动id查询现金奖励(普通活动时需要遍历)
    		for(int i=0;i<activityCashBonus.size();i++){
    			int actCashBonusId = activityCashBonus.get(i).getId();
    			ActivityCustomerCashBonus activityCustomerCashBonus = new ActivityCustomerCashBonus();
    			activityCustomerCashBonus.setP2pCustomerNo(customer.getId());
    			activityCustomerCashBonus.setCashBonusNo(actCashBonusId);//现金奖励外键
    			activityCustomerCashBonus.setMyActivityNo(actCustomerId);//我的活动详情外键
    			activityCustomerCashBonus.setEditTime(DateUtil.getNowTimestamp());
    			activityCustomerCashBonus.setInTime(DateUtil.getNowTimestamp());
    			activityCustomerCashBonus.setEditUserNo(customer.getId());
    			activityCustomerCashBonus.setAcquisitionTime(DateUtil.getNowTimestamp());
    			activityCustomerCashBonus.setStatus((byte) 0);
    			ActivityCustomerCashBonusModel.add(activityCustomerCashBonus); 
    		}
    	}
    	return resultno;
     }
     /**
      * 添加我的优惠券
      * @author guojia
      */
     public static int addCustomerCoupons(P2pCustomer  customer,Activities  activities,int actCustomerId,boolean isOrdinaryInvite){
    	 int resultNo = 0;
    	 List<ActivityCoupons> listCopons = ActivityCouponsModel.getActivityCouponsByActId(activities.getId());
    	 for(int i=0;i<listCopons.size();i++){
    		 ActivityCustomerCoupons activityCustomerCoupons = new ActivityCustomerCoupons();
    		 activityCustomerCoupons.setCode(gentRandom());
    		 activityCustomerCoupons.setP2pCustomerNo(customer.getId());
    		 activityCustomerCoupons.setCouponsNo(listCopons.get(i).getId());
    		 activityCustomerCoupons.setSendTime(DateUtil.getNowTimestamp());
    		 activityCustomerCoupons.setStartTime(listCopons.get(i).getCouponsStartTime());
    		 activityCustomerCoupons.setEndTime(listCopons.get(i).getCouponsEndTime());
    		 activityCustomerCoupons.setStatus((byte) 0);
    		 activityCustomerCoupons.setMyActivityNo(actCustomerId);
    		 activityCustomerCoupons.setCouponsCdkeyStatus((byte) 0);
    		 ActivityCustomerCouponsModel.add(activityCustomerCoupons);
    		 resultNo =i;
    	 }
    	 return resultNo;
     }
     public static String gentRandom(){
	    String numberChar = "ABCDEF0123456789";
        Long seed = System.currentTimeMillis();// 获得系统时间，作为生成随机数的种子
        StringBuffer sb = new StringBuffer();// 装载生成的随机数
        Random random = new Random(seed);// 调用种子生成随机数
        for (int i = 0; i < 6; i++) {
            sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
        }
        return sb.toString();
     }
     /**
      * 添加我的的礼品
      * @author guojia
      */
     public static int addPresent(P2pCustomer  customer,Activities  activities,int actCustomerId,boolean isOrdinaryInvite){
    	 int resultNo = 0;
    	 List<ActivityPresent> activityPresent = ActivityPresentModel.getActivityPresentByactId(activities.getId());
    	 for(int i=0;i<activityPresent.size();i++){
    		 ActivityCustomerPresent actCustomerPresent  = new 	 ActivityCustomerPresent();
    		 actCustomerPresent.setPresentNo(activityPresent.get(i).getId());
    		 actCustomerPresent.setP2pCustomerNo(customer.getId());
/*    		 actCustomerPresent.setRecipient(recipient);//收件人
    		 actCustomerPresent.setPhone(phone);
    		 actCustomerPresent.setEmail(email);
    		 actCustomerPresent.setProvinceNo(provinceNo);
    		 actCustomerPresent.setCityNo(cityNo);
    		 actCustomerPresent.setDistrictNo(districtNo);
    		 actCustomerPresent.setComment(comment);
    		 actCustomerPresent.setAddress(address);*/
    		 actCustomerPresent.setStatus((byte) 0);
    		 actCustomerPresent.setMyActivityNo(actCustomerId);
    		 ActivityCustomerPresentModel.add(actCustomerPresent);
    		 resultNo =i;
    	 }
    	 return resultNo;
     }
     /**
      * 添加我的积分
      * @param customer
      * @param activities
      * @param actCustomerId
      * @param isOrdinaryInvite
      * @return
      */
     public static int addIntegral(P2pCustomer  customer,Activities  activities,int actCustomerId,boolean isOrdinaryInvite){
    	 int resultNo = 0;
    	 List<ActivityIntegral> activityIntegral = ActivityIntegralModel.getActivityIntegralByActid(activities.getId());
    	 for(int i=0;i<activityIntegral.size();i++){
    		 ActivityIntegralDetail actIntegralDetail = new ActivityIntegralDetail();
    		 actIntegralDetail.setP2pCustomerNo(customer.getId());
    		 actIntegralDetail.setStartTime(activityIntegral.get(i).getInTime());
    		 actIntegralDetail.setEndTime(activityIntegral.get(i).getExpireTime());
/*    		 actIntegralDetail.setIntegralSatus(integralSatus);
    		 actIntegralDetail.setComment(comment);
    		 actIntegralDetail.setRelatedNo(relatedNo);
    		 actIntegralDetail.setIntegraNo(integraNo);
    		 actIntegralDetail.setGainTime(gainTime);*/
    		 actIntegralDetail.setMyActivityNo(actCustomerId);
    	 }
    	 
    	 return resultNo;
     } 
}
