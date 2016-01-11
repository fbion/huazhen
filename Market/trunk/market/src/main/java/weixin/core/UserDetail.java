package weixin.core;

import weixin.pojo.SNSUserInfo;
import weixin.pojo.WeiXinOauth2Token;
import weixin.process.BaseAction;
import weixin.util.AdvancedUtil;
import weixin.util.Constant;

public class UserDetail extends BaseAction{
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	private SNSUserInfo snsUserInfo;
	
	public SNSUserInfo getSnsUserInfo() {
		return snsUserInfo;
	}

	public void setSnsUserInfo(SNSUserInfo snsUserInfo) {
		this.snsUserInfo = snsUserInfo;
	}

	public String userDetail(){
		
		if(!Constant.AUTHDENY.equals(code)){
			//获取网页授权access_token
			WeiXinOauth2Token weiXinOauth2Token = AdvancedUtil.getOauthAccessToken(Constant.APPID,Constant.APPSECRET, code);
			String accessToken = weiXinOauth2Token.getAccessToken();
			String openId = weiXinOauth2Token.getOpenId();
			//获取用户ID
			snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
		}
		
		
		System.out.println(code+"123");
		return SUCCESS;
	}
}
