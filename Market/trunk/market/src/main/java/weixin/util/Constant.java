package weixin.util;

import com.hzfh.market.model.common.properties.WebInfoHelper;


public class Constant {
	//token_url
	public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//授权页面的token_url
	public final static String OAUTH2_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//刷新授权url
	public final static String REFRESH_OAUTH2_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	//获取用户信息    
	public final static String SNS_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//授权页面的url
	public final static String OAUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
	//请求方式
	public final static String REQUEST_METHOD_GET = "GET";
	public final static String REQUEST_METHOD_POST = "POST";
	
	//公众账号信息
	public final static String APPID  =WebInfoHelper.WEIXIN_APPID;
	public final static String APPSECRET  =WebInfoHelper.WEIXIN_APPSECRET;
	
	//应用授权作用域，
	//snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
	//snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
	public final static String SNSAPI_BASE = "snsapi_base";
	public final static String SNSAPI_USERINFO = "snsapi_userinfo";
	
	
	//拒接授权
	public final static String AUTHDENY="authdeny";
	
	//请求消息类型   事件类型  响应消息类型
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";//请求消息类型：文本
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";//请求消息类型：图片
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";//请求消息类型：语音
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";//请求消息类型：视频
	public static final String REQ_MESSAGE_TYPE_LOCATION ="location";//请求消息类型：地理位置
	public static final String REQ_MESSAGE_TYPE_LINK = "link";//请求消息类型：链接
	
	
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";//请求消息类型：事件推送
	
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";//事件类型：subscribe(订阅)
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";//事件类型：unsubscribe(取消订阅)
	public static final String EVENT_TYPE_SCAN = "scan";//事件类型：scan(关注用户扫描带参数二维码)
	public static final String EVENT_TYPE_LOCATION = "LOCATION";//事件类型：LOCATION(上报地理位置)
	public static final String EVENT_TYPE_CLICK = "CLICK";//事件类型：CLICK(自定义菜单) 点击菜单拉取消息时的事件推送 
	public static final String EVENT_TYPE_VIEW = "VIEW";//时间类型：VIEW 点击菜单跳转链接时的事件推送 

	
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";//响应消息类型：文本
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";//响应消息类型：图片
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";//响应消息类型：语音
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";//响应消息类型：视频
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";//响应消息类型：音乐
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";//响应消息类型：图文
	
	
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";//菜单创建 POST
	public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";//菜单查询 GET
	public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";//菜单删除 GET
}
