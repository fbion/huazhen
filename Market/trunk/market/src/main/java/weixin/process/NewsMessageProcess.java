package weixin.process;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import weixin.response.message.Article;
import weixin.response.message.NewsMessage;
import weixin.util.Constant;
import weixin.util.HandleHelper;
import weixin.util.MessageUtil;

import com.hzfh.market.model.common.helper.UrlHelper;
import com.hzfh.market.model.common.properties.WebInfoHelper;

/**
 * 多图文消息的实现
 * @author Administrator
 *
 */
public class NewsMessageProcess {
	public static String newsMessageProcess(Map<String ,String > requestMap){
		String fromUserName = requestMap.get("FromUserName");
		String toUserName = requestMap.get("ToUserName");
		
		Article article1 = new Article();
		article1.setTitle("华镇金融   一家资金实力雄厚、多元化大型金融服务机构。启动报名参加活动！");
		article1.setDescription("华镇金控汇聚了大批有着多年投资经验和管理经验的业内高精尖人才，组成了一支具有高水准、高职业操守的专业投资管理团队，在商业投资、财务管理、资产管理、法律咨询及风险控制等方面均有丰富的实践经验。坚持以“为企业和个人寻找资本和财产增长之路”为己任，为投资者提供高质量且最具附加值的全方位金融服务，帮助投资者实现财富和资产的最大化和持续性增值。目前，已与国内多地政府、企业、商会、银行及其他金融机构建立了战略合作关系。");
		article1.setPicUrl(UrlHelper.bulidWebUploadPath("weixin_reply/image/lottery.jpg"));
		
		String url= Constant.OAUTH_URL;
		System.out.println(WebInfoHelper.WEB_MARKET_WWW+"/activityUsers/registrationLottery");
		String redirectUrl = HandleHelper.urlEncodeUTF8(WebInfoHelper.WEB_MARKET_WWW+"/activityUsers/registrationLottery");
		//String redirectUrl = HandleHelper.urlEncodeUTF8("http://bjltx.vicp.net/market/activityUsers/registrationLottery");
		System.out.println(redirectUrl);
		url = url.replace("APPID",Constant.APPID).replace("SCOPE", Constant.SNSAPI_USERINFO).replace("REDIRECT_URI", redirectUrl);
		article1.setUrl(url);
		
		List<Article> articleList = new ArrayList<Article>();
		articleList.add(article1);
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(Constant.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		System.out.println(MessageUtil.messageToXml(newsMessage));
		return MessageUtil.messageToXml(newsMessage);
		
	}
}
