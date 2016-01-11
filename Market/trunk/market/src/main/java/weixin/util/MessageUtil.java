package weixin.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import weixin.response.message.Article;
import weixin.response.message.NewsMessage;
import weixin.response.message.TextMessage;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtil {
	/**
	 * 解析微信发来的请求
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String , String> parseXml(HttpServletRequest request) throws Exception{
		Map<String,String> map = new HashMap<String , String >();
		InputStream inputStream = request.getInputStream();
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		for (Element element : elementList) {
			map.put(element.getName(),element.getText());
		}
		inputStream.close();
		inputStream = null;
		return map;
	}
	/**
	 * 扩展xstream 使其支持CDATA
	 */
	private static XStream xStream = new XStream(new XppDriver(){
		public HierarchicalStreamWriter createWriter(Writer out){
			return new PrettyPrintWriter(out){
				boolean cdata = true;
				@SuppressWarnings("rawtypes")
				public void startNode(String name,Class clazz){
					super.startNode(name,clazz);
				}
				protected void writeText(QuickWriter writer,String text){
					if(cdata){
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else {
						writer.write(text);
					}
				}
				
			};
		}
	});
	
	/**
	 * 响应文本消息转换成xml
	 * @param textMessage
	 * @return
	 */
	public static String messageToXml(TextMessage textMessage){
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}
	/**
	 * 响应图文消息转换成xml
	 * @param newsMessage
	 * @return 
	 */
	public static String messageToXml(NewsMessage newsMessage){
		xStream.alias("xml", newsMessage.getClass());
		xStream.alias("item",new Article().getClass());
		return xStream.toXML(newsMessage);
	}
}

