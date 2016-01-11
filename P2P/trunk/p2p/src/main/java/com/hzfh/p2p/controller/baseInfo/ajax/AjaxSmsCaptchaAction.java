package com.hzfh.p2p.controller.baseInfo.ajax;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.p2p.controller.common.BaseAction;
import com.hzfh.p2p.model.baseInfo.CaptchaModel;
import com.hzfh.p2p.model.baseInfo.SmsModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.cache.CacheManager;
import com.hzfh.p2p.model.common.cache.CachePrefix;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;


public class AjaxSmsCaptchaAction extends BaseAction {
    private List  resultList;

	public List getResultList() {
		return resultList;
	}
	private String telephone;
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}
	private String errCode="0000";
	private int time;
	public int getTime() {
		return time;
	}

	public String getErrCode() {
		return errCode;
	}
	
	private String smsCaptcha;
	public String getSmsCaptcha() {
		return smsCaptcha;
	}

	public void setSmsCaptcha(String smsCaptcha) {
		this.smsCaptcha = smsCaptcha;
	}
	
	private String paymentAccountSecurityUrl;
	public String getPaymentAccountSecurityUrl() {
		return paymentAccountSecurityUrl;
	}

	private String verifyCode;
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	private String cn;
	private String ci;
	private String t;

	
	public void setCn(String cn) {
		this.cn = cn;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	private String isCellphoneLogin;
	
	public String getIsCellphoneLogin() {
		return isCellphoneLogin;
	}

	public void setIsCellphoneLogin(String isCellphoneLogin) {
		this.isCellphoneLogin = isCellphoneLogin;
	}

	@Override
	public String execute() {
		
		if(!StringHelper.isNullOrEmpty(cn)&&!StringHelper.isNullOrEmpty(ci)&&!StringHelper.isNullOrEmpty(t)){
			int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
			P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
			if(p2pCustomer==null){
				this.errCode= "用户信息错误";
		        return SUCCESS;
			}
			String key = p2pCustomer.getSecretKey();
			String customerName = p2pCustomer.getUserName();
			Timestamp sendTime = new Timestamp(Long.parseLong(t));
			
			if (DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).before(new Date(System.currentTimeMillis()))){
				this.errCode= "链接过期，请重新申请！";
	            return SUCCESS;
	        }
			String SecretInfo=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
			if(!SecretInfo.equals(ci)){
				this.errCode= "用户信息错误";
		        return SUCCESS;
			}
			this.telephone = p2pCustomer.getCellphone();
			//验证手机号等信息
			if(ERROR.equals(validMessage())){
        		return SUCCESS;
        	}
        }else{
        	//验证手机号等信息
        	if(ERROR.equals(validMessage())){
        		return SUCCESS;
        	}
        	//注册的时候，验证手机号是否被注册了
	        if(AuthenticationModel.getCustomerId()==0){
	        	P2pCustomer p = P2pCustomerModel.getInfoByCellphone(telephone);
	    		if(isCellphoneLogin.equals("1")){
	    			if(p==null){
	    				errCode="该手机号还没注册,请注册后再登录";
	    				return SUCCESS;
	    			}
	    		}else{
	    			if(p!=null){
	    				errCode="该手机号码已被其他用户认证，请更换其他手机号码";
	    				return SUCCESS;
	    			}
	    		}
	        }
        }
		
        String telNum = SmsModel.getCaptchaNumberByTel(telephone);
        int telMaxNum = ParamHelper.SMS_CODE_TEL_NUMBER;
        if(StringHelper.isNullOrEmpty(telNum)){
        	SmsModel.setCaptchaNumberByTel(telephone, String.valueOf(telMaxNum-1));
        }
        if(!StringHelper.isNullOrEmpty(telNum)&&(!("0").equals(telNum))){
        	SmsModel.setCaptchaNumberByTel(telephone, String.valueOf(Integer.parseInt(telNum)-1));
        }
        if(!StringHelper.isNullOrEmpty(telNum)&&("0").equals(telNum)){
        	this.errCode="您已连续发送短信验证码，为了保证您的账户安全，我们暂时禁此操作，如有疑问请联系客服：400-0340-668";
        	return SUCCESS;
        }
        HttpServletRequest request = this.getRequest();
        String ip = request.getRemoteAddr();
        String ipNum = SmsModel.getCaptchaNumberByIP(ip);
        int ipMAxNum = ParamHelper.SMS_CODE_IP_NUMBER;
        if(StringHelper.isNullOrEmpty(ipNum)){
        	SmsModel.setCaptchaNumberByIP(ip, String.valueOf(ipMAxNum-1));
        }
        if(!StringHelper.isNullOrEmpty(ipNum)&&(!("0").equals(ipNum))){
        	SmsModel.setCaptchaNumberByTel(telephone, String.valueOf(Integer.parseInt(ipNum)-1));
        }
        if(!StringHelper.isNullOrEmpty(ipNum)&&("0").equals(ipNum)){
        	this.errCode="您已连续发送短信验证码，为了保证您的账户安全，我们暂时禁此操作，如有疑问请联系客服：400-0340-668";
        	return SUCCESS;
        }
        
        
        Date currentTime = new Date();
        //获取验证码生产时间
        Date createCaptchaTime = SmsModel.getCreateCaptchaTimeFromMenCache("createCaptchaTime",telephone);
        if(createCaptchaTime==null){
        	//时间为空，为改手机号首次生产验证码
        	SmsModel.setCreateCaptchaTimeToMenCache("createCaptchaTime",telephone,currentTime);
        	createCaptchaTime = currentTime;
        }
        String vfCode = null;
        double intervalTime = (currentTime.getTime()-createCaptchaTime.getTime()) / (1000);
        //间隔时间大于等于60秒
        if(intervalTime>=60 || intervalTime==0){
        	vfCode = newCaptcha();
        	SmsModel.setCaptchaToMenCache("captcha", telephone, vfCode);
        	SmsModel.setCreateCaptchaTimeToMenCache("createCaptchaTime",telephone,currentTime);
        	
        	SmsModel.addCaptcha(telephone, vfCode);//插入验证码
        	SmsModel.smsCaptcha(telephone, vfCode);//插入短信
        }else{
        	time = (int) intervalTime;
        }
		return SUCCESS;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String newCaptcha(){
		String vfCode = "";
		for(int i=0;i<6;i++){
    		int num = RandomUtils.nextInt(10);
    		vfCode+=num;
    	}
		return vfCode;
	}
	
	public String refreshJsp(){
		if(StringHelper.isNullOrEmpty(telephone)){
			errCode="0001";
			return SUCCESS;
		}
		Date currentTime = new Date();
        //获取验证码生产时间
        Date createCaptchaTime = SmsModel.getCreateCaptchaTimeFromMenCache("createCaptchaTime",telephone);
		if(createCaptchaTime == null){
			errCode="0001";
			return SUCCESS;
		}
		double intervalTime = (currentTime.getTime()-createCaptchaTime.getTime()) / (1000);
        if(intervalTime<60&&intervalTime>0){//缓存中的短信验证码有效
        	time = (int) intervalTime;
        	return SUCCESS;
        }
        if(time==0){
        	errCode="0001";
        }
		return SUCCESS;
	}
	
	public String identy(){
		if(StringHelper.isNullOrEmpty(telephone)){
			errCode="请输入手机号码";
			return SUCCESS;
		}
		if(StringHelper.isNullOrEmpty(this.smsCaptcha)){
			errCode="请输入手机验证码";
			return SUCCESS;
		}
		/*if(!checkTelephoneById(AuthenticationModel.getCustomerId(),telephone)){
			errCode="该手机号码已被其他用户认证，请更换其他手机号码!";
			return SUCCESS;
		}*/
		/*String vfCode = SmsModel.getCaptchaFromMenCache("captcha", telephone);
		if(StringHelper.isNullOrEmpty(vfCode)){
			errCode="验证码已过期!";
			return SUCCESS;
		}
		if(!vfCode.equals(this.smsCaptcha)){
			errCode="验证码不正确!";
			return SUCCESS;
		}*/
		checkTelephoneById();
		checkSmsCaptcha();
		int id1 = P2pCustomerModel.updateCellphoneByCustomerNo(this.telephone,AuthenticationModel.getCustomerId());
		int id = PaymentAccountInformationModel.updateAuthenticationTelByCustomerNo(1,AuthenticationModel.getCustomerId());
		if(id<=0||id1<=0){
			errCode="fail!";
		}
		this.paymentAccountSecurityUrl = UrlHelper.buildWWWSiteUrl(PageAlias.paymentAccountSecurity);
		return SUCCESS;
	}
	
	public String checkTelephoneById(){
		P2pCustomer p = P2pCustomerModel.checkTelephoneById(AuthenticationModel.getCustomerId(),telephone);
		if(p!=null){
			errCode="该手机号码已被其他用户认证，请更换其他手机号码";
		}
		return SUCCESS;
	}
	public String checkSmsCaptcha(){
		if(!StringHelper.isNullOrEmpty(cn)&&!StringHelper.isNullOrEmpty(ci)&&!StringHelper.isNullOrEmpty(t)){
			int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
			P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
			if(p2pCustomer==null){
				this.errCode= "用户信息错误";
		        return SUCCESS;
			}
			String key = p2pCustomer.getSecretKey();
			String customerName =p2pCustomer.getUserName();
			String SecretInfo=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
			if(!SecretInfo.equals(ci)){
				this.errCode= "用户信息错误";
		        return SUCCESS;
			}
			this.telephone = p2pCustomer.getCellphone();
        }
		String vfCode = SmsModel.getCaptchaFromMenCache("captcha", telephone);
		if(StringHelper.isNullOrEmpty(vfCode)){
			errCode="请重新获取手机验证码（可能已过期）";
			return SUCCESS;
		}
		if(!vfCode.equals(this.smsCaptcha)){
			errCode="手机验证码不正确";
			return SUCCESS;
		}
		return SUCCESS;
	}
	private HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return request;
        }
        return null;
    }
	
	public String validMessage(){
		if(StringHelper.isNullOrEmpty(telephone)){
			errCode="请填写手机号码";
			return ERROR;
		}
		if (!CharacterFilter.isVaildCellphone(telephone)){
	        this.errCode= "请填写正确的手机号码";
	        return ERROR;
		}
		if(StringHelper.isNullOrEmpty(verifyCode)){
    		errCode="请输入图形验证码";
    		return ERROR;
    	}
		if (!CharacterFilter.isVaildVerifyCode(verifyCode)){
	        this.errCode= "图形验证码错误，请重新输入";
	        return ERROR;
		}
        if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null) {
            this.errCode="图形验证码错误，请重新输入";
            return ERROR;
        }
        return SUCCESS;
	}
}

