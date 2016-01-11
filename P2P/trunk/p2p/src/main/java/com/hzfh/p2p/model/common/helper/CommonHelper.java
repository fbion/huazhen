package com.hzfh.p2p.model.common.helper;

import java.util.Date;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.cache.CacheManager;
import com.hzfh.p2p.model.common.cache.CachePrefix;
import com.hzfh.p2p.model.common.properties.MailHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzframework.helper.StringHelper;

public class CommonHelper {
	/**
	 * 设置邮箱认证邮件内容
	 * @param customer
	 * @return
	 */
	public static String setMailValidationContent(P2pCustomer customer,String newEmail,int emailChangeFlag){
		   String key = customer.getSecretKey();
	       String cipherText = EncodeHelper.encryptPWD(customer.getUserName(), newEmail, key);
	       StringBuilder stringBuilder = new StringBuilder();
	       stringBuilder.append(cipherText);
	       stringBuilder.append(",");
	       stringBuilder.append(String.valueOf(customer.getId()));
	       stringBuilder.append(",");
	       stringBuilder.append(String.valueOf(System.currentTimeMillis()));
	       stringBuilder.append(",");
	       stringBuilder.append(String.valueOf(emailChangeFlag));

	       String cipherTextUrl = UrlHelper.buildWWWSiteUrl(PageAlias.emailValidation) + "?key=" + stringBuilder.toString();
	       
	       String mailMindUserName = null;
	        
	        String realName = customer.getRealName();
	        String userName = customer.getUserName();
	        String cellPhone = customer.getCellphone();
	        if(!StringHelper.isNullOrEmpty(realName))
	        	mailMindUserName = realName;
	        else if(userName.length()<36)
	        	mailMindUserName = userName;
	        else if(StringHelper.isNullOrEmpty(cellPhone))
	        	mailMindUserName = cellPhone;
		   String mailContent = String.format(MailHelper.MAIL_ACTIVATE_BODY, cipherTextUrl,ParamHelper.ACTIVATE_EMAIL_EXPIRE_DAY, mailMindUserName);
		    
		   return mailContent;
	}
	/**
	 * 设置审核邮箱修改邮件内容
	 * @param customer
	 * @return
	 */
	public static String setAuditMailUpdateContent(P2pCustomer customer){
		String mailMindUserName = null;
        
        String realName = customer.getRealName();
        String userName = customer.getUserName();
        String cellPhone = customer.getCellphone();
        if(!StringHelper.isNullOrEmpty(realName))
        	mailMindUserName = realName;
        else if(userName.length()<36)
        	mailMindUserName = userName;
        else if(StringHelper.isNullOrEmpty(cellPhone))
        	mailMindUserName = cellPhone;
		String mailContent = String.format(MailHelper.MAIL_AUDIT_BODY,mailMindUserName);
		
		return mailContent;
	}
	/**
	 * 验证邮件是否频繁发送
	 * @param email
	 * @return
	 */
	public static boolean isFrequentlySendMail(String email){
		Date d = (Date) CacheManager.get(CachePrefix.EMAIL_SEND_LIMIT_TIME,email);
		   if(d==null){//首次或过期
			   CacheManager.set(CachePrefix.EMAIL_SEND_LIMIT_TIME, email, ParamHelper.EMAIL_SEND_LIMIT_TIME * 60, new Date());
		   }else{
			   double s = (new Date().getTime()-d.getTime()) / (1000);
			   if(s<=ParamHelper.EMAIL_SEND_LIMIT_TIME * 60){
		           return true;
			   }
		   }
		return false;
	}
}
