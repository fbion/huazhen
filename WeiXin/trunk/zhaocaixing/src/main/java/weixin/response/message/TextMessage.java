package weixin.response.message;

/**
 * 文本消息
 * @author mengchong
 * @date 2015-10-27
 */
public class TextMessage extends BaseMessage {
	//回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
}
