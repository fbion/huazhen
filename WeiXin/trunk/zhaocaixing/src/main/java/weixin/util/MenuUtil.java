package weixin.util;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.pojo.Menu;

/**
 * 自定义菜单工具类
 * @author Administrator
 * @date 2015-11-19
 */
public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);
	/**
	 * 创建菜单
	 * @param menu 菜单实例
	 * @param accessToken	凭证
	 * @return true 成功  false 失败
	 */
	public static boolean createMenu(Menu menu,String accessToken){
		boolean result = false;
		String requestUrl = Constant.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		//将菜单对象转换成JSON字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		//发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, Constant.REQUEST_METHOD_POST, jsonMenu);
		
		if(jsonObject!=null){
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if(errorCode==0){
				result =true;
			}else{
				result =false;
				log.error("创建菜单失败  error:{} errmsg:{}",errorCode,errorMsg);
			}
		}
		return result;
	}
	/**
	 * 查询菜单
	 * @param accessToken 凭证
	 * @return 菜单 String
	 */
	public static String getMenu(String accessToken){
		String result = null;
		String requestUrl = Constant.MENU_GET_URL.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, Constant.REQUEST_METHOD_GET, null);
		if(jsonObject!=null){
			result = jsonObject.toString();
		}
		return result;
	}
}
