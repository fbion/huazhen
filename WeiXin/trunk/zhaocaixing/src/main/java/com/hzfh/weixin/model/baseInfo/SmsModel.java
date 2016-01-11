package com.hzfh.weixin.model.baseInfo;

import java.util.Date;
import java.util.List;

import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.SmsCaptcha;
import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.baseInfo.model.query.SmsCondition;
import com.hzfh.weixin.controller.baseInfo.SmsTempleteType;
import com.hzfh.weixin.facade.baseInfo.SmsFacade;
import com.hzfh.weixin.model.common.cache.CacheManager;
import com.hzfh.weixin.model.common.cache.CachePrefix;
import com.hzfh.weixin.model.common.properties.ParamHelper;
import com.hzframework.contract.PagedList;


public class SmsModel {
    public static PagedList<Sms> getPagingList(SmsCondition smsCondition) {
        return SmsFacade.getPagingList(smsCondition);
    }

    public static int add(Sms sms) {
        return SmsFacade.add(sms);
    }

    public static int update(Sms sms) {
        return SmsFacade.update(sms);
    }

    public static List<Sms> getList() {
        return SmsFacade.getList();
    }

    public static Sms getInfo(int id) {
        return SmsFacade.getInfo(id);
    }

    public static String verification(String telephone){
        return SmsFacade.verification(telephone);
    }

    public static int smsCaptcha(String telephone,String vfCode){
        Smstemplete smstemplete = templeteCache("smstempleteCaptcha", SmsTempleteType.SMS_CAPTCHA);//获取短信模板
        //addCaptcha(telephone,vfCode);//插入短信验证码
        String content = smstemplete.getContent();
        content = content.replace("${CAPTCHA}",vfCode);
        Sms sms = new Sms();
        sms.setSmscontent(content);
        sms.setCellnumber(telephone);
        sms.setStatus((byte)1);
        return SmsModel.add(sms);//插入短信
    }

    public static int smsWithdrawalsApply(String telephone,String currentTime,String websiteName,String bankCardName,String bankCardNo,String amount,String phoneNumber){

        Smstemplete smstemplete = templeteCache("smstempleteWithdrawalsApply",SmsTempleteType.SMS_WITHDRAWALS_APPLY);
        String content = smstemplete.getContent();
        content = content.replace("${CURRENT_TIME}",currentTime);
        content = content.replace("${WEBSITE_NAME}",websiteName);
        content = content.replace("${BANKCARD_NAME}",bankCardName);
        content = content.replace("${BANKCARD_NO}",bankCardNo);
        content = content.replace("${MONEY}",amount);
        content = content.replace("${PHONE_NUMBER}",phoneNumber);
        return addSms(content,telephone);
    }
    
    public static int smsRechargeSuccess(String telephone,String websiteName,String amount,String phoneNumber){
    	
    	Smstemplete smstemplete = templeteCache("smstempleteRechargeSuccess",SmsTempleteType.SMS_RECHARGE_SUCCESS);
    	String content = smstemplete.getContent();
    	content = content.replace("${WEBSITE_NAME}",websiteName);
    	content = content.replace("${MONEY}",amount);
    	content = content.replace("${PHONE_NUMBER}",phoneNumber);
    	return addSms(content,telephone);
    }

    public static int smsInvestmentApply(String telephone,String productName,String websiteName,String amount,String phoneNumber){
    	Smstemplete smstemplete = templeteCache("smstempleteInvestmentSuccess",SmsTempleteType.SMS_INVESTMENT_APPLY);
    	String content = smstemplete.getContent();
    	content = content.replace("${PRODUCT_NAME}",productName);
    	content = content.replace("${WEBSITE_NAME}",websiteName);
    	content = content.replace("${MONEY}",amount);
    	content = content.replace("${PHONE_NUMBER}",phoneNumber);
    	
    	return addSms(content,telephone);
    }
    
    public static int smsInvestmentSuccess(String telephone,String userName,String productName,String amount){
        Smstemplete smstemplete = templeteCache("smstempleteInvestmentSuccess",SmsTempleteType.SMS_INVESTMENT_SUCCESS);
        String content = smstemplete.getContent();
        content = content.replace("${USER_NAME}",userName);
        content = content.replace("${PRODUCT_NAME}",productName);
        content = content.replace("${AMOUNT}",amount);

        return addSms(content,telephone);
    }

    public static int smsHolidayWishes(String telephone,String festivalName){
        Smstemplete smstemplete = templeteCache("smstempleteholidayWishes",SmsTempleteType.SMS_HOLODAY_WISHES);
        String content = smstemplete.getContent();
        content = content.replace("${FESTIVAL_NAME}",festivalName);
        return addSms(content,telephone);
    }

    public static Smstemplete templeteCache(String cacheName,int type){
        Smstemplete smstemplete = null;
        Object obj = CacheManager.get(CachePrefix.SMS_TEMPLETE, cacheName);
        if(obj==null){
            smstemplete = SmstempleteModel.getInfo(type);
            CacheManager.set(CachePrefix.SMS_TEMPLETE, cacheName, 60 * 60 * 24, smstemplete);
        }else{
            smstemplete = (Smstemplete)obj;
        }
        return smstemplete;
    }


    public static int addSms(String content,String telephone){
        Sms sms = new Sms();
        sms.setSmscontent(content);
        sms.setCellnumber(telephone);
        sms.setStatus((byte)1);
        return SmsModel.add(sms);
    }

    public static int  addCaptcha(String telephone,String vfCode){
        SmsCaptcha smsCaptcha = new SmsCaptcha();
        smsCaptcha.setTelephone(telephone);
        smsCaptcha.setStatus(1);
        smsCaptcha.setCode(vfCode);
        return  SmsCaptchaModel.add(smsCaptcha);
    }
    
    @Deprecated
    public static Date getAddCaptchaTime(String cacheName,String telephone,Date nowTime){
    	Date addAptchaTime  = (Date) CacheManager.get(CachePrefix.SMS_CAPTCHA_TIME,cacheName+telephone);
    	if(addAptchaTime==null){
    		addAptchaTime = nowTime;//当前时间
    		CacheManager.set(CachePrefix.SMS_CAPTCHA_TIME, cacheName+telephone, ParamHelper.SMS_CODE_EXPIRE_MINUTE * 60, addAptchaTime);
    	}
    	return addAptchaTime;
    }
    @Deprecated
    public static Date getCaptchaTime(String cacheName,String telephone){
    	Date addAptchaTime  = (Date) CacheManager.get(CachePrefix.SMS_CAPTCHA_TIME,cacheName+telephone);
    	return addAptchaTime;
    }

    public static String getCaptchaFromMenCache(String cacheName,String telephone){
    	String aptcha=null;
    	Object aptchaCache =CacheManager.get(CachePrefix.SMS_CAPTCHA,cacheName+telephone);
    	if(aptchaCache!=null){
    		aptcha=aptchaCache.toString();
    	}
    	return aptcha;
    }

    public static void setCaptchaToMenCache(String cacheName,String telephone,String Captcha) {
        CacheManager.set(CachePrefix.SMS_CAPTCHA, cacheName + telephone, ParamHelper.SMS_CODE_EXPIRE_MINUTE * 60, Captcha);
    }
    @Deprecated
	public static Date getAgainCaptchaTime(String cacheName, String telephone) {
        Date againCaptchaTime = (Date) CacheManager.get(CachePrefix.SMS_AGAIN_CAPTCHA_TIME, cacheName + telephone);
        return againCaptchaTime;
    }
    @Deprecated
	public static void setAgainCaptchaTime(String cacheName, String telephone) {
    	CacheManager.set(CachePrefix.SMS_AGAIN_CAPTCHA_TIME, cacheName+telephone, ParamHelper.SMS_CODE_EXPIRE_MINUTE * 60, new Date());
	}
    public static void setCaptchaNumberByIP(String ip,String number) {
    	CacheManager.set(CachePrefix.SMS_CAPTCHA, "CaptchaNumberByIP"+ip, ParamHelper.SMS_CODE_IP_EXPIRE_TIME * 60,number);
	}
	public static void setCaptchaNumberByTel(String telephone,String number) {
		CacheManager.set(CachePrefix.SMS_CAPTCHA, "CaptchaNumberByTel"+telephone, ParamHelper.SMS_CODE_TEL_EXPIRE_TIME * 60,number);
	}
	public static String getCaptchaNumberByIP(String ip) {
    	String number = (String) CacheManager.get(CachePrefix.SMS_CAPTCHA,"CaptchaNumberByIp"+ip);
    	return number;
	}
	public static String getCaptchaNumberByTel(String telephone) {
		String number = (String) CacheManager.get(CachePrefix.SMS_CAPTCHA,"CaptchaNumberByTel"+telephone);
		return number;
	}
	

	/**
	 * 获取验证码生产时间
	 * liyh
	 * @param string
	 * @param telephone
	 * @return
	 * 上午11:56:05
	 */
	public static Date getCreateCaptchaTimeFromMenCache(String str,String telephone) {
		Date createCaptchaTime  = (Date) CacheManager.get(CachePrefix.SMS_CAPTCHA_TIME,str+telephone);
		return createCaptchaTime;
	}

	/**
	 * 插入验证码生产时间
	 * liyh
	 * @param str
	 * @param telephone
	 * @param currentTime
	 * 上午11:59:49
	 */
	public static void setCreateCaptchaTimeToMenCache(String str, String telephone, Date currentTime) {
		CacheManager.set(CachePrefix.SMS_CAPTCHA_TIME, str+telephone, ParamHelper.SMS_CODE_EXPIRE_MINUTE * 60, currentTime);
	}
}
