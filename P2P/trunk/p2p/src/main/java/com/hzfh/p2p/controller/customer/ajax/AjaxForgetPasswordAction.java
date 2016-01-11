package com.hzfh.p2p.controller.customer.ajax;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.model.baseInfo.CaptchaModel;
import com.hzfh.p2p.model.baseInfo.EmailModel;
import com.hzfh.p2p.model.baseInfo.SmsModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.properties.MailHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.sql.Date;

/**
 * Created by paul on 15-3-19.
 */
public class AjaxForgetPasswordAction extends JsonBaseAction {
    public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
	private String email;
    private String verifyCode;
    private String key;
    private String password;
    private String ci;
    private String userInfo;
    private String cipherTextUrl;
    private String smsCaptcha;
    
    public void setSmsCaptcha(String smsCaptcha) {
		this.smsCaptcha = smsCaptcha;
	}

	public String getCipherTextUrl() {
		return cipherTextUrl;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	private String t;
	private String cn;
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
	public void setKey(String key) {
        this.key = key;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String sendMail(){
        this.message = new Message();
        int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
        
        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
        if(p2pCustomer==null){
        	this.message.setType(MessageType.Error);
        	this.message.setDescription("用户信息错误");
        	return SUCCESS;
        }
        String key = p2pCustomer.getSecretKey();
        String customerName = p2pCustomer.getUserName();
        Date sendTime = new Date(Long.parseLong(t));
		if (DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).before(new Date(System.currentTimeMillis()))){
			this.message.setType(MessageType.Error);
        	this.message.setDescription("链接已过期，请重新申请");
            return SUCCESS;
        }
        String secretInfo=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
        if(!secretInfo.equals(ci)){
        	this.message.setType(MessageType.Error);
        	this.message.setDescription("数据不一致，请返回重新尝试");
        	return SUCCESS;
        }
       String currentTime = String.valueOf(System.currentTimeMillis());

        String cipherText = EncodeHelper.encryptPWD(p2pCustomer.getEmail()+currentTime, p2pCustomer.getUserName(), p2pCustomer.getSecretKey());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cipherText);
        stringBuilder.append(",");
        stringBuilder.append(String.valueOf(p2pCustomer.getId()));
        stringBuilder.append(",");
        stringBuilder.append(currentTime);
        String cipherTextUrl = this.buildWWWSiteUrl(PageAlias.resetPassword) + "?key=" + stringBuilder.toString();

       /* 
        String cn = EncodeHelper.generateRandomCustomerId(customerNo);
		String t= String.valueOf(System.currentTimeMillis());
		String ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
		
		
        String cipherTextUrl = this.buildWWWSiteUrl(PageAlias.resetPassword) + "?ci="+ci+"&cn="+cn+"&t="+t;*/

        String mailMindUserName = null;
        
        String realName = p2pCustomer.getRealName();
        String userName = p2pCustomer.getUserName();
        String cellPhone = p2pCustomer.getCellphone();
        if(!StringHelper.isNullOrEmpty(realName))
        	mailMindUserName = realName;
        else if(userName.length()<36)
        	mailMindUserName = userName;
        else if(!StringHelper.isNullOrEmpty(cellPhone))
        	mailMindUserName = cellPhone;
        
        String mailContent = String.format(MailHelper.MAIL_RESET_BODY, mailMindUserName, cipherTextUrl);

        EmailModel.add(p2pCustomer.getEmail(), MailHelper.MAIL_RESET_SUBJECT, mailContent, p2pCustomer.getId());

        return SUCCESS;
    }

    public String resetPassword(){
        this.message = new Message();
		if(StringHelper.isNullOrEmpty(key)){
			if(StringHelper.isNullOrEmpty(ci)&&StringHelper.isNullOrEmpty(cn)&&StringHelper.isNullOrEmpty(t)){
				this.message.setType(MessageType.Error);
				this.message.setDescription("用户信息错误");
				return SUCCESS; 
			}
			int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
			P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
			if(p2pCustomer==null){
				this.message.setType(MessageType.Error);
				this.message.setDescription("用户信息错误");
				return SUCCESS; 
			}
			String secretKey = p2pCustomer.getSecretKey();
			String customerName = p2pCustomer.getUserName();
			Date sendTime = new Date(Long.parseLong(t));
			if (DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).before(new Date(System.currentTimeMillis()))){
				this.message.setType(MessageType.Error);
				this.message.setDescription("链接过期");
	            return SUCCESS;
	        }
			String secretInfo=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), secretKey);
			if(!secretInfo.equals(ci)){
				this.message.setType(MessageType.Error);
				this.message.setDescription("用户信息错误");
				return SUCCESS;
			}
			String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.password), p2pCustomer.getSecretKey());
			if (P2pCustomerModel.updatePswdById(customerNo, pwd)<=0){
				this.message.setType(MessageType.Error);
				this.message.setDescription("密码重置失败，请重试");
				return SUCCESS;
			}
	        this.message.setType(MessageType.Info);
	        return SUCCESS;
			
		}
			String[] strings = key.split(",");
			if (strings.length != 3){
				this.message.setType(MessageType.Error);
				this.message.setDescription("参数异常");
				return SUCCESS;
			}
			
			int customerId = Integer.valueOf(strings[1]);
			
			P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerId);
			if (p2pCustomer == null){
				this.message.setType(MessageType.Error);
				this.message.setDescription("没有此用户");
				return SUCCESS;
			}
			Date sendTime = new Date(Long.parseLong(strings[2]));
			
			if (DateHelper.addHour(sendTime, ParamHelper.RESET_EMAIL_EXPIRE_HOUR).before(new Date(System.currentTimeMillis()))){
				this.message.setType(MessageType.Error);
				this.message.setDescription("没有此用户");
				return SUCCESS;
			}
			
			String cipherText = EncodeHelper.encryptPWD(p2pCustomer.getEmail()+strings[2], p2pCustomer.getUserName(), p2pCustomer.getSecretKey());
			
			if (!cipherText.equals(strings[0])){
				this.message.setType(MessageType.Error);
				this.message.setDescription("参数异常，请重试");
				return SUCCESS;
			}
		String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.password), p2pCustomer.getSecretKey());
		if (P2pCustomerModel.updatePswdById(customerId, pwd)<=0){
			this.message.setType(MessageType.Error);
			this.message.setDescription("密码重置失败，请重试");
			return SUCCESS;
		}

        this.message.setType(MessageType.Info);
        return SUCCESS;
    }
    public String checkCustomerInfoExist(){
    	this.message = new Message();
    	if (CharacterFilter.isEmailAddress(userInfo)){
    		P2pCustomer p2pCustomer = P2pCustomerModel.selectByEmail(userInfo);
    		if(p2pCustomer!=null){
    			this.message.setType(MessageType.Info);
    			int customerNo=p2pCustomer.getId();
    			this.cn = EncodeHelper.generateRandomCustomerId(customerNo);
    			String key = p2pCustomer.getSecretKey();
    			String customerName = p2pCustomer.getUserName();
    			this.t= String.valueOf(System.currentTimeMillis());
    			this.ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
    			return SUCCESS;
    		}
    		this.message.setType(MessageType.Error);
    		this.message.setDescription("当前邮箱未注册，请输入正确的账户信息");
    		return SUCCESS;
    	}
    	if(CharacterFilter.isVaildUserName(userInfo)){
    		P2pCustomer p2pCustomer = P2pCustomerModel.selectByUserName(userInfo);
    		if(p2pCustomer!=null){
    			this.message.setType(MessageType.Info);
    			int customerNo=p2pCustomer.getId();
    			this.cn = EncodeHelper.generateRandomCustomerId(customerNo);
    			String key = p2pCustomer.getSecretKey();
    			String customerName = p2pCustomer.getUserName();
    			this.t= String.valueOf(System.currentTimeMillis());
    			this.ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
    			return SUCCESS;
    		}
    		this.message.setType(MessageType.Error);
    		this.message.setDescription("当前用户名未注册，请输入正确的账户信息");
    		return SUCCESS;
    	}
    	if(CharacterFilter.isVaildNumber(userInfo)){
    		P2pCustomer p2pCustomer = P2pCustomerModel.getInfoByCellphone(userInfo);
    		if(p2pCustomer!=null){
    			this.message.setType(MessageType.Info);
    			int customerNo=p2pCustomer.getId();
    			this.cn = EncodeHelper.generateRandomCustomerId(customerNo);
    			String key = p2pCustomer.getSecretKey();
    			String customerName = p2pCustomer.getUserName();
    			this.t= String.valueOf(System.currentTimeMillis());
    			this.ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
    			return SUCCESS;
    		}
	    		this.message.setType(MessageType.Error);
	    		this.message.setDescription("当前手机号未注册，请输入正确的账户信息");
	    		return SUCCESS;
    	}
    	
    		this.message.setType(MessageType.Error);
    		this.message.setDescription("没有此用户，请重新输入");
            return SUCCESS;
    }

	public String checkEmail(){
    	this.message = new Message();
    	int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
    	P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
    	
         Date sendTime = new Date(Long.parseLong(t));
         System.out.println(DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).after(new Date(System.currentTimeMillis())));
         if (DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).before(new Date(System.currentTimeMillis()))){
        	this.message.setType(MessageType.Warning);
     		return SUCCESS;
         }
    	if(p2pCustomer==null){
    		this.message.setType(MessageType.Error);
    		this.message.setDescription("用户信息错误");
    		return SUCCESS; 
    	}
    	String key = p2pCustomer.getSecretKey();
    	String customerName = p2pCustomer.getUserName();
		String secretInfo=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
		
    	if(!secretInfo.equals(ci)){
    		this.message.setType(MessageType.Error);
    		this.message.setDescription("用户信息错误");
    		return SUCCESS;
    	}
    	email = p2pCustomer.getEmail();
    	this.t= String.valueOf(System.currentTimeMillis());
		this.ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
    	cipherTextUrl = this.buildWWWSiteUrl(PageAlias.byEmailPassword)+"?ci="+ci+"&cn="+cn+"&t="+t;
    	if(StringHelper.isNullOrEmpty(email)){
    		this.message.setType(MessageType.Error);
    		this.message.setDescription("您未注册邮箱，请尝试其它验证方式");
    		return SUCCESS;
    	}
    	this.message.setType(MessageType.Info);
    	return SUCCESS;
    }
	public String chooseWayPassword(){
		this.message = new Message();
		if(ci==null&&cn==null&&t==null){
			this.message.setType(MessageType.Error);
			this.message.setDescription("用户信息错误");
			return SUCCESS;
		}
		if (!CharacterFilter.isVaildVerifyCode(verifyCode))
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("验证码错误，请重新输入");
            return SUCCESS;
        }
        if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null)
        {
            this.message.setType( MessageType.Error);

            this.message.setDescription("验证码错误，请重新输入");
            return SUCCESS;
        }
        CaptchaModel.delete(StateValues.getCaptchaKey());
        int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
		P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
		if(p2pCustomer==null){
			this.message.setType(MessageType.Error);
			this.message.setDescription("用户信息错误");
			return SUCCESS;
		}
		String key = p2pCustomer.getSecretKey();
		String customerName = p2pCustomer.getUserName();
		Date sendTime = new Date(Long.parseLong(t));
		if (DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).before(new Date(System.currentTimeMillis()))){
            this.message.setType(MessageType.Error);
            this.message.setDescription("链接已过期，请重新申请");
            return SUCCESS;
        }
		String secretInfo=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
		
		if(!secretInfo.equals(ci)){
			this.message.setType(MessageType.Error);
			this.message.setDescription("用户信息错误");
			return SUCCESS;
		}
		this.t= String.valueOf(System.currentTimeMillis());
		this.ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
		cipherTextUrl = this.buildWWWSiteUrl(PageAlias.chooseWayPassword)+ "?ci=" + ci+"&cn="+cn+"&t="+t;
		return SUCCESS;
	}
	public String getResetPasswordUrl(){
		this.message = new Message();
        if(StringHelper.isNullOrEmpty(ci)){
        	this.message.setType(MessageType.Error);
			this.message.setDescription("信息错误");
			return SUCCESS;
        }
        int customerNo = Integer.parseInt(EncodeHelper.extractRandomCustomerId(cn));
		P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
        if(p2pCustomer==null){
        	this.message.setType(MessageType.Error);
			this.message.setDescription("信息错误");
			return SUCCESS;
        }
		String key = p2pCustomer.getSecretKey();
		String customerName = p2pCustomer.getUserName();
		Date sendTime = new Date(Long.parseLong(t));
		if (DateHelper.addMinute(sendTime, ParamHelper.RESET_PWD_EXPIRE_MINUTE).before(new Date(System.currentTimeMillis()))){
            this.message.setType(MessageType.Warning);
            return SUCCESS;
        }
		String secretInfo=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
		if(!secretInfo.equals(ci)){
			this.message.setType(MessageType.Error);
			this.message.setDescription("信息错误");
			return SUCCESS;
		}
		String vfCode = SmsModel.getCaptchaFromMenCache("captcha", p2pCustomer.getCellphone());
		if(StringHelper.isNullOrEmpty(vfCode)){
			this.message.setType(MessageType.Error);
			this.message.setDescription("请重新获取手机验证码（可能已过期）");
			return SUCCESS;
		}
		if(!vfCode.equals(this.smsCaptcha)){
			this.message.setType(MessageType.Error);
			this.message.setDescription("手机验证码不正确");
			return SUCCESS;
		}
		String currentTime = String.valueOf(System.currentTimeMillis());
		this.t= String.valueOf(System.currentTimeMillis());
		this.ci=EncodeHelper.encryptPWD(customerName+t, String.valueOf(customerNo), key);
        cipherTextUrl = this.buildWWWSiteUrl(PageAlias.resetPassword) + "?ci=" + ci+"&cn="+cn+"&t="+t;
        this.message.setType(MessageType.Info);
		return SUCCESS;
	}
}
