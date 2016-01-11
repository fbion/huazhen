package weixin.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

public class HandleHelper {
	public static String urlEncodeUTF8(String source){
		String result = source;
		try {
			result = URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String getParamProperty(String key){
    	InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/params.properties");
    	Properties p = new Properties();
    	try {
    		p.load(inputStream);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return p.getProperty(key);
    }
}
