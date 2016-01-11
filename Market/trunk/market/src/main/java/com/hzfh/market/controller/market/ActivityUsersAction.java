package com.hzfh.market.controller.market;

import weixin.pojo.SNSUserInfo;
import weixin.pojo.WeiXinOauth2Token;
import weixin.util.AdvancedUtil;
import weixin.util.Constant;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.market.controller.common.CommonAction;
import com.hzfh.market.model.common.PageAlias;
import com.hzfh.market.model.market.ActivityUsersModel;

public class ActivityUsersAction extends CommonAction {
	private String code;
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	
	/*private ActivityUsers ActivityUsers;
    public ActivityUsers getActivityUsers() {
		return ActivityUsers;
	}*/


	private SNSUserInfo snsUserInfo;
	public SNSUserInfo getSnsUserInfo() {
		return snsUserInfo;
	}
	private ActivityUsers user;
	
	public ActivityUsers getUser() {
		return user;
	}

	private int res;
	public int getRes() {
		return res;
	}
	@Override
    public String execute(){
        this.setPageAlias(PageAlias.registrationLottery);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        if(!Constant.AUTHDENY.equals(code)){
			//获取网页授权access_token
			WeiXinOauth2Token weiXinOauth2Token = AdvancedUtil.getOauthAccessToken(Constant.APPID,Constant.APPSECRET, code);
			String accessToken = weiXinOauth2Token.getAccessToken();
			String openId = weiXinOauth2Token.getOpenId();
			//获取用户
			snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
			user = ActivityUsersModel.getInfoByOpenId(openId);//判断用户是否已参加
			if(user==null){
				return SUCCESS;
			}
			if("1".equals(user.getMark())){
				res=1;//已经参加
				return SUCCESS;
			}
		}
        /*SNSUserInfo snsUserInfo = new SNSUserInfo();
        snsUserInfo.setNickname("mcdf");
        this.snsUserInfo = snsUserInfo;
		System.out.println(code+"123");*/
        
        
		return SUCCESS;
    }
}
