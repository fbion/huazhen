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

import com.hzfh.weixin.model.common.helper.UrlHelper;

/**
 * 多图片消息的实现
 * @author Administrator
 *
 */
public class NewsMessageProcess {
	public static String newsMessageProcess(Map<String ,String > requestMap){
		String fromUserName = requestMap.get("FromUserName");
		String toUserName = requestMap.get("ToUserName");
		
		Article article1 = new Article();
		article1.setTitle("这条通往“财富”的天梯，拿走，不谢！");
		article1.setDescription("");
		article1.setPicUrl(UrlHelper.bulidWebUploadPath("weixin_reply/image/huazhen.jpg"));
		//String url = Constant.OAUTH_URL;
		
		String url= Constant.OAUTH_URL;
		
		String redirectUrl = HandleHelper.urlEncodeUTF8(UrlHelper.bulidWinXinBackUrl("customer/newRegister"));
	
		System.out.println(redirectUrl);
		url = url.replace("APPID",Constant.APPID).replace("SCOPE", Constant.SNSAPI_USERINFO).replace("REDIRECT_URI", redirectUrl);
		article1.setUrl(url);
		
		Article article2 = new Article();
		article2.setTitle("多种理财产品");
		article2.setDescription("");
		article2.setPicUrl(UrlHelper.bulidWebUploadPath("weixin_reply/image/index.jpg"));
		article2.setUrl(UrlHelper.bulidWinXinBackUrl("index"));
		
		Article article3 = new Article();
		article3.setTitle("华镇社区金融,您身边的理财专家");
		article3.setDescription("");
		article3.setPicUrl(UrlHelper.bulidWebUploadPath("weixin_reply/image/introduce.jpg"));
		article3.setUrl(UrlHelper.bulidWinXinBackUrl("product/productFeatures?name=introduce"));
		
		List<Article> articleList = new ArrayList<Article>();
		articleList.add(article1);
		articleList.add(article2);
		articleList.add(article3);
		
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
