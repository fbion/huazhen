import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.qq.connect.oauth.Oauth;


public class Help {

	@Test
	public void test() {
		System.out.println(EncodeHelper.decryptBASE64("123456"));
		System.out.println(EncodeHelper.encryptBASE64("123456"));
		JSONObject jo = JSONObject.fromObject("{message:{'type':'error'}}");
		System.out.println(JSONObject.fromObject(jo.get("message")).get("type"));
	}
	
	@Test
	public void testOauth(){
		Oauth o = new Oauth();
		System.out.println(o.toString());
	}
     
	@Test
	public void testMath(){
		String str="86.64466666";  
        BigDecimal bd = new BigDecimal(Double.parseDouble(str));  
        System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());  
        System.out.println("=================");  
         DecimalFormat df = new DecimalFormat("#.00");   
         System.out.println(df.format(Double.parseDouble(str)));   
         System.out.println("=================");  
         System.out.println(String.format("%.2f", Double.parseDouble(str)));  
         System.out.println("=================");  
         NumberFormat nf = NumberFormat.getNumberInstance();   
         nf.setMaximumFractionDigits(2);   
         System.out.println(nf.format(Double.parseDouble(str)));   
	}
}
