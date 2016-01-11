package weixin.core;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hzfh.weixin.model.common.cache.CacheManager;
import com.hzfh.weixin.model.common.cache.CachePrefix;
import com.hzfh.weixin.model.common.properties.ParamHelper;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzframework.helper.StringHelper;

import weixin.process.NewsMessageProcess;
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
		String respCount = "感谢您关注现房宝公众号！";
		try {
			Map<String ,String > requestMap = MessageUtil.parseXml(request);
			String fromUserName = requestMap.get("FromUserName");
			String toUserName = requestMap.get("ToUserName");
			String msgType = requestMap.get("MsgType");
			
			//默认回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(Constant.RESP_MESSAGE_TYPE_TEXT);
			if(msgType.equals(Constant.REQ_MESSAGE_TYPE_EVENT)){
				//事件类型
				String eventType = requestMap.get("Event");
				//关注
				if(eventType.equals(Constant.EVENT_TYPE_SUBSCRIBE)){
					return NewsMessageProcess.newsMessageProcess(requestMap);
				}
			}
			
			String openId = fromUserName;///////////////////////////////////////////////
			String number = StateValues.getWXOpenId();
			if(!StringHelper.isNullOrEmpty(openId)){
				if(!openId.equals(number)){
					StateValues.setWXOpenId(openId);
				}
			}
			/*
			if(!StringHelper.isNullOrEmpty(openId)&&StringHelper.isNullOrEmpty(number)){
				if(!openId.equals(number)){
					StateValues.setWXOpenId(openId);
				}
			}*/
			System.out.println(openId);
			textMessage.setContent(respCount);
			respXml = MessageUtil.messageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
