package com.hzfh.weixin.controller.customer.ajax;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.baseInfo.CaptchaModel;
import com.hzfh.weixin.model.baseInfo.LetterModel;
import com.hzfh.weixin.model.baseInfo.SmsModel;
import com.hzfh.weixin.model.common.cache.CacheManager;
import com.hzfh.weixin.model.common.cache.CachePrefix;
import com.hzfh.weixin.model.common.helper.CharacterFilter;
import com.hzfh.weixin.model.common.helper.EncodeHelper;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzfh.weixin.model.customer.PaymentAccountInformationModel;
import com.hzframework.helper.HttpHelper;
import com.hzframework.helper.StringHelper;
public class AjaxNewRegisterAction extends JsonBaseAction<P2pCustomer> {
	
	private String verifyCode;
	private String smsCaptcha;
	private P2pCustomer p2pCustomer;//p2p客户对象
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public void setP2pCustomer(String p2pCustomer) {
        this.p2pCustomer = JSON.parseObject(p2pCustomer, P2pCustomer.class);
    }

	public void setSmsCaptcha(String smsCaptcha) {
		this.smsCaptcha = smsCaptcha;
	}

	@Override
	public String execute() {
		
    	//注册主函数
        this.message = new Message();//同理 定义一个返回错误消息函数
        //验证码的 判断
        if (!CharacterFilter.isVaildVerifyCode(verifyCode))//验证码格式正则验证

        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }


        if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null) {//验证码是否过期
            this.message.setType(MessageType.Error);

            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }

        CaptchaModel.delete(StateValues.getCaptchaKey());//删除验证码

        if (!CharacterFilter.isVaildCallName(p2pCustomer.getRealName()))//用户名的格式
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "4-20位字符（限字母、数字的组合）");
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
		//String key = EncodeHelper.initKey(UUID.randomUUID().toString());//根据用户的姓名获得一个初始化的加密支付key
		//String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(p2pCustomer.getPassword()), key);
		p2pCustomer.setUserName(UUID.randomUUID().toString());
	    p2pCustomer.setSecretKey(EncodeHelper.initKey(UUID.randomUUID().toString()));
	    p2pCustomer.setStatus((byte) 1);
	    p2pCustomer.setLoginFrom((byte)1);
	    
	    /*String code = p2pCustomer.getWeixin(); 
        System.out.println(code);
        if(!StringHelper.isNullOrEmpty(code)){   
         String urlstr = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9d93a55d91f39b14&secret=13dfa2e9dde5fa8d7bb7ebdc322b62d6&code=" + code + "&grant_type=authorization_code";
    	    JSONObject json;
    	    try {
    	        json = JSONObject.fromObject(HttpHelper.doGet(urlstr));
    	        String  weixin = json.getString("openid");
    	        if (P2pCustomerModel.getP2pCustomerByWeixin(weixin) != null)//验证用户名时候存在
    	        {
    	            this.message.setType(MessageType.Error);
    	            this.message.setDescription("weixinError:" +"当前微信号已注册过，不能重复注册，试着登录吧！");
    	            return SUCCESS;
    	        }else{
    	        	p2pCustomer.setWeixin(weixin);
    	        }
    	    } catch (Exception e) {
    	        return ERROR;
    	    }
        }*/
	    //String number = (String) CacheManager.get(CachePrefix.WEIXIN_OPENID, openId);
	    String openId = StateValues.getWXOpenId();
		if(!StringHelper.isNullOrEmpty(openId)){
			if (P2pCustomerModel.getP2pCustomerByWeixin(openId) != null)//验证用户名时候存在
			{
				this.message.setType(MessageType.Error);
				this.message.setDescription("weixinError:" +"当前微信号已注册过，不能重复注册，试着登录吧！");
				return SUCCESS;
			}
			p2pCustomer.setWeixin(openId);
		}
    	int id = P2pCustomerModel.add(p2pCustomer); //然后把这些信息写入数据库  
        if (id <= 0)    //写入失败 提示 Error
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("Error:" + "注册失败请稍后再试");
            return SUCCESS;
        }
        int empNo = p2pCustomer.getEmpNo();
        if(empNo > 0){
	    	String subject= "新的客户";
	    	String content = "您已被52touzi网站的新用户选为理财顾问,新用户的姓名："+p2pCustomer.getRealName()+"  手机号码："+p2pCustomer.getCellphone();
	    	LetterModel.addReminds(subject, content, empNo);
        }
        PaymentAccountInformation paymentAccountInfo=new PaymentAccountInformation();
		paymentAccountInfo.setCustomerNo(id);
        paymentAccountInfo.setAuthenticationTel(1);
        paymentAccountInfo.setAccountType((byte)1);
        paymentAccountInfo.setCustomerName(p2pCustomer.getRealName());
		PaymentAccountInformationModel.add(paymentAccountInfo);

		P2pCustomerModel.SetLoginInfo(P2pCustomerModel.getInfo(id),true);
		
		this.message.setType(MessageType.Info);
		Date lastLoginTime = null;
		if(p2pCustomer.getCurrentLoginTime()!=null){
			lastLoginTime = p2pCustomer.getCurrentLoginTime();
		}
		P2pCustomerModel.updateLastLoginTime(p2pCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
        return SUCCESS;
	}
	
	
}
