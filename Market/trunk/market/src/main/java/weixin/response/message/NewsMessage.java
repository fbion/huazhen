package weixin.response.message;

import java.util.List;

/**
 * 图文消息
 * @author Administrator
 *
 */
public class NewsMessage extends BaseMessage {

	private int ArticleCount;//图文消息个数，限制为10条以内 
	private List<Article> Articles;//多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
}
