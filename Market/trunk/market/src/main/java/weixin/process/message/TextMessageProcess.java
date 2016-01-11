package weixin.process.message;

import java.util.Date;
import java.util.List;
import java.util.Map;

import weixin.process.NewsMessageProcess;
import weixin.response.message.NewsMessage;
import weixin.response.message.TextMessage;
import weixin.util.Constant;
import weixin.util.HandleHelper;
import weixin.util.MessageUtil;

import com.hzfh.api.market.model.Lotteries;
import com.hzfh.market.model.common.helper.UrlHelper;

/**
 * 文本消息处理类
 * @author Administrator
 *
 */
public class TextMessageProcess {
	
	
	public static String textMessageProcess(Map<String ,String > requestMap){
		
		String fromUserName = requestMap.get("FromUserName");
		String toUserName = requestMap.get("ToUserName");
		String content = requestMap.get("Content");
		
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(Constant.RESP_MESSAGE_TYPE_TEXT);
		
		String respCount = "/微笑欢迎您关注华镇金控！";
		if("微抽奖".equals(content.trim())){
			return  NewsMessageProcess.newsMessageProcess(requestMap);
		}
		/*if("个人信息".equals(content.trim())){
			respCount= Constant.OAUTH_URL;
			System.out.println(UrlHelper.bulidWebBackUrl("baseInfo/userDetail"));
			String redirectUrl = HandleHelper.urlEncodeUTF8(UrlHelper.bulidWebBackUrl("baseInfo/userDetail"));
			System.out.println(redirectUrl);
			respCount = respCount.replace("APPID",Constant.APPID).replace("SCOPE", Constant.SNSAPI_USERINFO).replace("REDIRECT_URI", redirectUrl);
			respCount="点击<a href='"+respCount+"'>获取个人信息！</a>";
		}*/
		textMessage.setContent(respCount);
		//String respXml = MessageUtil.messageToXml(textMessage);
		return MessageUtil.messageToXml(textMessage);
	}
}
