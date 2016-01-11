package weixin.util;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.pojo.WeiXinOauth2Token;

public class AdvancedUtil {
	private static Logger log =  LoggerFactory.getLogger(AdvancedUtil.class);
	/**
	 * 获取网页授权凭证
	 * @param appId 公众账号的唯一标识
	 * @param appSecret 公众账号的秘钥
	 * @param code 
	 * @return WeiXinOauth2Token
	 */
	public static WeiXinOauth2Token getOauthAccessToken(String appId,String appSecret, String code){
		WeiXinOauth2Token wat = null;
		//拼接请求地址
		String requestUrl = Constant.OAUTH2_TOKEN_URL;
		requestUrl = requestUrl.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
		//获取网页授权凭证
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, Constant.REQUEST_METHOD_GET, null);
		if(jsonObject!=null){
			try {
				wat = new WeiXinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
				//wat.setUnionId(jsonObject.getString("unionid"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取网页授权凭证失败 error:{} errmsg:{}",errorCode,errorMsg);
			}
		}
		return wat;
	}
	/**
	 * 刷新网页授权凭证
	 * @param appId 公众账号的唯一标识
	 * @param refreshToken
	 * @return WeiXinOauth2Token
	 */
	public static WeiXinOauth2Token refreshOauth2AccessToken(String appId,String refreshToken){
		WeiXinOauth2Token wat = null;
		//拼接请求地址
		String requestUrl = Constant.REFRESH_OAUTH2_TOKEN_URL;
		requestUrl = requestUrl.replace("APPID", appId).replace("REFRESH_TOKEN", refreshToken);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, Constant.REQUEST_METHOD_GET, null);
		if(jsonObject!=null){
			try {
				wat = new WeiXinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("刷新网页授权凭证失败 error:{} errmsg:{}",errorCode,errorMsg);
			}
		}
		return wat;
	}
}
