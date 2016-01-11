package com.hzfh.p2p.controller.customer.ajax;


import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.controller.common.JsonBaseAction.MessageType;
import com.hzfh.p2p.model.baseInfo.CaptchaModel;
import com.hzfh.p2p.model.baseInfo.SmsModel;
import com.hzfh.p2p.model.common.cache.CacheManager;
import com.hzfh.p2p.model.common.cache.CachePrefix;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.common.properties.ParamHelper;
import com.hzfh.p2p.model.common.properties.WebInfoHelper;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.HttpHelper;
import com.hzframework.helper.StringHelper;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

/**
 * Created by paul on 15-3-14.
 */
public class AjaxLoginAction extends JsonBaseAction{
    private String verifyCode;
    private String userName;
    private String password;
    private String isAutoLogin;
    
    private String code;
    private String state;
    private String qqLoginUrl; 

    private String cellphone;
	private String verifyCode2;
    private String smsCaptcha;

    public void setCellphone(String cellphone) {
    	this.cellphone = cellphone;
    }
    
    public void setVerifyCode2(String verifyCode2) {
    	this.verifyCode2 = verifyCode2;
    }
    
    public void setSmsCaptcha(String smsCaptcha) {
    	this.smsCaptcha = smsCaptcha;
    }
	public String getQqLoginUrl() {
		return qqLoginUrl;
	}

	public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsAutoLogin(String isAutoLogin) {
        this.isAutoLogin = isAutoLogin;
    }
	public void setCode(String code) {
		this.code = code;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Override
    public String execute() {
        this.message = new Message();
        this.password = EncodeHelper.decryptBASE64(this.password);
        int needVerifyCode = 0;
        Object obj = CacheManager.get(CachePrefix.LOGIN_FAILED_COUNT_PREFIX, userName);
        int loginCount = 0;
        if (obj != null)
            loginCount = (Integer)obj;
        if (loginCount >= ParamHelper.LOGIN_FAILED_COUNT) {
            if (!CharacterFilter.isVaildVerifyCode(verifyCode)) {
                needVerifyCode = setLoginFailedCount(userName, ++loginCount);
                this.message.setType(MessageType.Error);
                this.message.setDescription("validateError:" + "验证码错误，请重新输入" + ":"+ String.valueOf(needVerifyCode));
                return SUCCESS;
            }

            if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null) {
                needVerifyCode = setLoginFailedCount(userName, ++loginCount);
                this.message.setType(MessageType.Error);
                this.message.setDescription("validateError:" + "验证码错误，请重新输入" + ":"+ String.valueOf(needVerifyCode));
                return SUCCESS;
            }

            CaptchaModel.delete(StateValues.getCaptchaKey());
        }

        if (!CharacterFilter.isVaildLoginName(userName))//正则验证
        {
            needVerifyCode = setLoginFailedCount(userName, ++loginCount);
            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "请填写合法的用户名，可使用邮箱、手机号登录" + ":" + String.valueOf(needVerifyCode));
            insertLoginFailedCount(this.userName, this.password);
            return SUCCESS;
        }

        P2pCustomer p2pCustomer = P2pCustomerModel.selectByUserName(this.userName);
        
        
        //可使用用户名，手机号，邮箱登陆
        if (p2pCustomer == null) {
        	p2pCustomer = P2pCustomerModel.selectByEmail(this.userName);
        	if(p2pCustomer == null){
        		p2pCustomer = P2pCustomerModel.getInfoByCellphone(this.userName);
        		if(p2pCustomer == null){
        			needVerifyCode = setLoginFailedCount(userName, ++loginCount);

                    this.message.setType(MessageType.Error);
                    this.message.setDescription("userError:" + "您输入的用户名有误，请重新输入" + ":" + String.valueOf(needVerifyCode));
                    insertLoginFailedCount(this.userName, this.password);
                    return SUCCESS;
        		}
        	}
            
        }

        if (p2pCustomer.getStatus() == 0){
            needVerifyCode = setLoginFailedCount(userName, ++loginCount);

            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "您的账号尚未激活，请联系管理员" + ":" + String.valueOf(needVerifyCode));

            return SUCCESS;
        }


        String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(),this.password,p2pCustomer.getSecretKey());

        if(StringHelper.isNullOrEmpty(p2pCustomer.getPassword())){
        	this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "线下用户首次登陆，请先找回密码" + ":" + String.valueOf(needVerifyCode));
            insertLoginFailedCount(this.userName, this.password);
            return SUCCESS;
        }
        
        if (p2pCustomer.getPassword().equals(pwd)){
            setLoginFailedCount(userName, 0);

            P2pCustomerModel.SetLoginInfo(p2pCustomer, Integer.valueOf(isAutoLogin) == 1);

            this.message.setType(MessageType.Info);
            
            
            Date lastLoginTime = null;
            if(p2pCustomer.getCurrentLoginTime()!=null){
            	lastLoginTime = p2pCustomer.getCurrentLoginTime();
            }else{
            	lastLoginTime = DateHelper.getCurrentTime();
            }
            P2pCustomerModel.updateLastLoginTime(p2pCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
        }
        else {
            needVerifyCode = setLoginFailedCount(userName, ++loginCount);

            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "您输入的密码有误，请重新输入" + ":" + String.valueOf(needVerifyCode));
            insertLoginFailedCount(this.userName, this.password);//您输入的用户名或密码有误，请确认后再次输入
        }
        
        return SUCCESS;
    }

    private int setLoginFailedCount(String userName, int loginCount) {
        int needVerifyCode = loginCount >= ParamHelper.LOGIN_FAILED_COUNT ? 1 : 0;
        CacheManager.set(CachePrefix.LOGIN_FAILED_COUNT_PREFIX, userName, 60 * 3, loginCount);
        return needVerifyCode;
    }

    private void insertLoginFailedCount(String userName, String password) {
        LoginFailed loginFailed = new LoginFailed();
        loginFailed.setSite(WebInfoHelper.WEB_P2P_WWW);
        loginFailed.setUserName(userName);
        loginFailed.setPassword(password);
        loginFailed.setIp(this.getIp());
    }
    
    public String qqAuthorizattion(){
    	try {
			/*this.qqLoginUrl = new Oauth().getAuthorizeURL(ServletActionContext.getRequest());*/
    		this.qqLoginUrl = "http://openapi.qzone.qq.com/oauth/show?which=ConfirmPage&display=pc&client_id="+ParamHelper.APP_ID+"&redirect_uri="+ParamHelper.REDIRECT_URI+"customer/login/qqLoginCallBack.action&response_type=code&state=2b6ddd69ca6ed86f0bf2a0a9c3851da5&scope="+ParamHelper.SCOPE;
    		//this.qqLoginUrl = "https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id="+ParamHelper.APP_ID+"&redirect_uri="+ParamHelper.REDIRECT_URI+"&state=1&scope="+ParamHelper.SCOPE;
			
    		if(StringHelper.isNullOrEmpty(qqLoginUrl)){
				return ERROR;
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
    	
    	return SUCCESS;
    	
    }
    
    
    public String qqLoginCallBack(){
    	try {
    		/*String loginFlag = JSONObject.fromObject(JSONObject.fromObject(HttpHelper.doGet("http://hzp2p.tunnel.mobi/p2p/customer/login/ajaxLogin?userName=wangqk&password="+EncodeHelper.encryptBASE64("1234567").replace("\r", "").replace("\n", "")+"&isAutoLogin=0")).get("message")).getString("type");
    		if("Info".equals(loginFlag)){
    			return SUCCESS;
    		}*/
    		/*if(!"1".equals(state)){
    			return ERROR;
    		}
    		JSONObject jb1 = JSONObject.fromObject(HttpHelper.doGet("https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id="+ParamHelper.APP_ID+"&client_secret="+ParamHelper.APP_KEY+"&code="+this.code+"&redirect_uri="+ParamHelper.REDIRECT_URI));
    		String access_token = jb1.getString("access_token");*/
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//1.拿到accessToken对象
    		AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);

            String accessToken   = null,
                   openId        = null;
            long tokenExpireIn = 0L;
            if (accessTokenObj.getAccessToken().equals("")) {
            	//我们的网站被CSRF攻击了或者用户取消了授权
            	//做一些数据统计工作
                System.out.println("没有获取到响应参数");
                return ERROR;
            } else {
                accessToken = accessTokenObj.getAccessToken();
                tokenExpireIn = accessTokenObj.getExpireIn();

                request.getSession().setAttribute("demo_access_token", accessToken);
                request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));

                // 利用获取到的accessToken 去获取当前用的openid 
                OpenID openIDObj =  new OpenID(accessToken);
                openId = openIDObj.getUserOpenID();

                UserInfo userInfo = new UserInfo(accessToken, openId);
                UserInfoBean userInfoBean = userInfo.getUserInfo();
                
                //2.通过openid取p2p用户
                P2pCustomer p2pComCustomer = P2pCustomerModel.getInfoByQq(openId);
                if(p2pComCustomer!=null){
                	//3.用户不为空，就直接登录
                	P2pCustomerModel.SetLoginInfo(p2pComCustomer, false);
                	
                    Date lastLoginTime = null;
                    if(p2pComCustomer.getCurrentLoginTime()!=null){
                    	lastLoginTime = p2pComCustomer.getCurrentLoginTime();
                    }
                    P2pCustomerModel.updateLastLoginTime(p2pComCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
        			return SUCCESS;
                }
                
                //QQ用户已有p2p账户，但首次QQ联合登录的情况    ----暂时不考虑，直接开新的p2p用户
                
                //创建新p2p用户
                P2pCustomer newP2pComCustomer = new P2pCustomer();
                String username = UUID.randomUUID().toString();
                String key = EncodeHelper.initKey(username);
                newP2pComCustomer.setUserName(username);
                newP2pComCustomer.setSecretKey(key);
                newP2pComCustomer.setPassword(EncodeHelper.encryptPWD(newP2pComCustomer.getUserName(), EncodeHelper.decryptBASE64("123456"), key));//初始密码123456
                newP2pComCustomer.setStatus((byte)1);
                newP2pComCustomer.setQq(openId);
                newP2pComCustomer.setRealName(userInfoBean.getNickname());
                if(userInfoBean.getGender()=="男"){
                	newP2pComCustomer.setSex((byte)1);
                }else if(userInfoBean.getGender()=="女"){
                	newP2pComCustomer.setSex((byte)0);
                }
                if(P2pCustomerModel.add(newP2pComCustomer)<=0){
                	return ERROR;
                }
                //6.自动登录
        		P2pCustomerModel.SetLoginInfo(newP2pComCustomer, false);
        		Date lastLoginTime = null;
	            if(p2pComCustomer.getCurrentLoginTime()!=null){
	            	lastLoginTime = p2pComCustomer.getCurrentLoginTime();
	            }
	            P2pCustomerModel.updateLastLoginTime(p2pComCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
                
            }    
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return SUCCESS;
    }
    
    
    public String wbLoginCallBack(){
    	try {
    		if(!"1".equals(state)){
    			return ERROR;
    		}
			//1.获取授权过的Access Token 
			JSONObject jsonObject = JSONObject.fromObject(HttpHelper.doGet("https://api.weibo.com/oauth2/access_token?client_id=23719133&client_secret=70deb0825762e4877d4caa437c7b03ec&&grant_type=authorization_code&redirect_uri="+ParamHelper.REDIRECT_URI+"customer/login/wbLoginCallBack&code="+this.code));

			String wbId = jsonObject.getString("uid");
    		//2.通过wbid取p2p用户
			P2pCustomer p2pComCustomer = P2pCustomerModel.getInfoByWeibo(wbId);
			if(p2pComCustomer!=null){
				//3.用户不为空，就直接登录
				P2pCustomerModel.SetLoginInfo(p2pComCustomer, false);
				Date lastLoginTime = null;
	            if(p2pComCustomer.getCurrentLoginTime()!=null){
	            	lastLoginTime = p2pComCustomer.getCurrentLoginTime();
	            }
	            P2pCustomerModel.updateLastLoginTime(p2pComCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
    			return SUCCESS;
			}
			//4.根据用户ID获取用户信息
    		JSONObject json = JSONObject.fromObject(HttpHelper.doGet("https://api.weibo.com/2/users/show.json?uid="+wbId+"&access_token="+jsonObject.getString("access_token")));
    		
			//5.创建新p2p用户
			P2pCustomer newP2pComCustomer = new P2pCustomer();
			String username = UUID.randomUUID().toString();
			String key = EncodeHelper.initKey(username);
			newP2pComCustomer.setUserName(username);
			newP2pComCustomer.setSecretKey(key);
			newP2pComCustomer.setPassword(EncodeHelper.encryptPWD(newP2pComCustomer.getUserName(), EncodeHelper.decryptBASE64("123456"), key));//初始密码123456
			newP2pComCustomer.setStatus((byte)1);
			newP2pComCustomer.setWeibo(wbId);
			newP2pComCustomer.setRealName(json.getString("name"));
			newP2pComCustomer.setAddress(json.getString("location"));
			if(json.getString("gender")=="m"){
				newP2pComCustomer.setSex((byte)1);
			}else if(json.getString("gender")=="w"){
				newP2pComCustomer.setSex((byte)0);
			}
			if(P2pCustomerModel.add(newP2pComCustomer)<=0){
				return ERROR;
			}
			//6.自动登录
			P2pCustomerModel.SetLoginInfo(newP2pComCustomer, false);
			Date lastLoginTime = null;
            if(p2pComCustomer.getCurrentLoginTime()!=null){
            	lastLoginTime = p2pComCustomer.getCurrentLoginTime();
            }
            P2pCustomerModel.updateLastLoginTime(p2pComCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return SUCCESS;
    }
    
    public String loginWithCellphone(){
    	this.message = new Message();
    	
        if (!CharacterFilter.isVaildCellphone(cellphone)){
            this.message.setType(MessageType.Error);
            this.message.setDescription("cellphoneError:" + "请填写合法的手机号");
            return SUCCESS;
        }
        
        if (!CharacterFilter.isVaildVerifyCode(verifyCode2)){
            this.message.setType(MessageType.Error);
            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }
        
        if(!CharacterFilter.isVaildSmsCaptcha(this.smsCaptcha)){
        	this.message.setType(MessageType.Error);
        	this.message.setDescription("smsCaptchaError:" + "请输入6位数字的手机验证码");
        	return SUCCESS;
        }

        P2pCustomer p2pCustomer = P2pCustomerModel.getInfoByCellphone(this.cellphone);
		if(p2pCustomer == null){
            this.message.setType(MessageType.Error);
            this.message.setDescription("cellphoneError:" + "您输入的手机号有误，请重新输入");
            return SUCCESS;
		}
		
		if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode2) == null){
            this.message.setType(MessageType.Error);
            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }
        CaptchaModel.delete(StateValues.getCaptchaKey());
        
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

        if (p2pCustomer.getStatus() == 0){
            this.message.setType(MessageType.Error);
            this.message.setDescription("userError:" + "您的账号尚未激活，请联系管理员");
            return SUCCESS;
        }

        P2pCustomerModel.SetLoginInfo(p2pCustomer, Integer.valueOf(isAutoLogin) == 1);

        this.message.setType(MessageType.Info);
        
        
        Date lastLoginTime = null;
        if(p2pCustomer.getCurrentLoginTime()!=null){
        	lastLoginTime = p2pCustomer.getCurrentLoginTime();
        }else{
        	lastLoginTime = DateHelper.getCurrentTime();
        }
        P2pCustomerModel.updateLastLoginTime(p2pCustomer.getId(),new Timestamp(lastLoginTime.getTime()));
//            this.message.setType(MessageType.Error);
//            this.message.setDescription("userError:" + "您输入的密码有误，请重新输入" + ":" + String.valueOf(needVerifyCode));
    	return SUCCESS;
    }
}
