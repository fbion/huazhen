package weixin.core;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import weixin.process.NewsMessageProcess;
import weixin.process.message.TextMessageProcess;
import weixin.response.message.TextMessage;
import weixin.util.Constant;
import weixin.util.MessageUtil;

/**
 * 核心服务类
 * @author Administrator
 *
 */
public class CoreService {
	public static String processRequest(HttpServletRequest request){
		String respXml = null;
		String respCount = "/微笑欢迎您关注华镇金控！";
		try {
			Map<String ,String > requestMap = MessageUtil.parseXml(request);
			String fromUserName = requestMap.get("FromUserName");
			String toUserName = requestMap.get("ToUserName");
			String msgType = requestMap.get("MsgType");
			
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(Constant.RESP_MESSAGE_TYPE_TEXT);
			if(msgType.equals(Constant.REQ_MESSAGE_TYPE_TEXT)){
				return TextMessageProcess.textMessageProcess(requestMap);
			}
			else if(msgType.equals(Constant.REQ_MESSAGE_TYPE_EVENT)){
				String eventType = requestMap.get("Event");
				if(eventType.equals(Constant.EVENT_TYPE_SUBSCRIBE)){
					return  NewsMessageProcess.newsMessageProcess(requestMap);
				}								
			}
			textMessage.setContent(respCount);
			respXml = MessageUtil.messageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
