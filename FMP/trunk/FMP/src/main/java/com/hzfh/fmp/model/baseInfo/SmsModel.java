package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.baseInfo.model.query.SmsCondition;
import com.hzfh.fmp.facade.baseInfo.SmsFacade;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.controller.baseInfo.SmsTempleteType;
import com.hzframework.contract.PagedList;
import org.apache.commons.lang.math.RandomUtils;

import java.util.List;

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
    
    @Deprecated
    public static int addWithCellnumber(String cellnumber) {
    	Sms info = new Sms();
        info.setInUserNo(UserHelper.getEditUserNo());
        String smscontent = "您的验证码为：";
        String vfCode = "";
        for(int i=0;i<6;i++){
        	int num = RandomUtils.nextInt(10);
        	vfCode+=num;
        }
        smscontent+=vfCode;
        info.setCellnumber(cellnumber);
        info.setSmscontent(smscontent);
        info.setStatus((byte) 1);
		int id = SmsModel.add(info);
                
        return id;
    }

    public static int smsInterviewInvitation(String telephone,String title,String time,String address,String contact,String phone,String cellPhone){
        Smstemplete smstemplete = templeteCache("smsInterviewInvitation", SmsTempleteType.SMS_INTERVIEW_INVIATION);
        String content = smstemplete.getContent();
        content = content.replace("${TITLE}",title);
        content = content.replace("${TIME}",time);
        content = content.replace("${ADDRESS}",address);
        content = content.replace("${CONTACT}",contact);
        content = content.replace("${PHONE}",phone);
        content = content.replace("${CELLPHONE}",cellPhone);
        return addSms(content,telephone);
    }

    public static int smsProductExpire(String telephone,String time,String productName,String money){
        Smstemplete smstemplete = templeteCache("smsProductExpire", SmsTempleteType.SMS_PRODUCT_EXPIRE);
        String content = smstemplete.getContent();
        content = content.replace("${PRODUCT_NAME}",productName);
        content = content.replace("${TIME}",time);
        content = content.replace("${MONEY}",money);
        content = content.replace("${PHONE_NUMBER}","400-0340-668");
        return addSms(content,telephone);
    }
    public static int smsProductInterest(String telephone,String time,String productName,String money,String times){
        Smstemplete smstemplete = templeteCache("smsProductInterest", SmsTempleteType.SMS_PRODUCT_INTEREST);
        String content = smstemplete.getContent();
        content = content.replace("${PRODUCT_NAME}",productName);
        content = content.replace("${TIME}",time);
        content = content.replace("${NUMBER}",times);
        content = content.replace("${MONEY}",money);
        content = content.replace("${PHONE_NUMBER}","400-0340-668");
        return addSms(content,telephone);
    }
    public static int smsContinueInvestment(String telephone,String time,String productName,String money1,String money2){
        Smstemplete smstemplete = templeteCache("smsContinueInvestment", SmsTempleteType.SMS_CONTINUE_INVESTMENT);
        String content = smstemplete.getContent();
        content = content.replace("${PRODUCT_NAME}",productName);
        content = content.replace("${TIME}",time);
        content = content.replace("${MONEY1}",money1);
        content = content.replace("${MONEY2}",money2);
        content = content.replace("${PHONE_NUMBER}","400-0340-668");
        return addSms(content,telephone);
    }
    //活动邀约
    public static int smsActivityInvitation(String telephone,String title,String time,String address){
        Smstemplete smstemplete = templeteCache("smsActivityInvitation", SmsTempleteType.SMS_ACTIVITY_INVITATION);
        String content = smstemplete.getContent();
        content = content.replace("${ACTIVITY_NAME}",title);
        content = content.replace("${TIME}",time);
        content = content.replace("${ADDRESS}",address);
        return addSms(content,telephone);
    }

    public static int smsCreateP2pCustomer(String telephone){
        Smstemplete smstemplete = templeteCache("smsCreateP2pCustomer", SmsTempleteType.SMS_CREATE_P2PCUSTOMER);
        String content = smstemplete.getContent();
        content = content.replace("${CELLPHONE}",telephone);
        content = content.replace("${PHONE_NUMBER}","400-0340-668");
        return addSms(content,telephone);

    }
    public static int addSms(String content,String telephone){
        Sms sms = new Sms();
        sms.setSmscontent(content);
        sms.setCellnumber(telephone);
        sms.setStatus((byte)1);
        return SmsModel.add(sms);
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
}
