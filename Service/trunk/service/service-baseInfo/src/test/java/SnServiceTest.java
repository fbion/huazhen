import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.caucho.hessian.client.HessianProxyFactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.baseInfo.model.Sms;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.baseInfo.service.SmsService;
import com.hzfh.api.baseInfo.service.SnService;
import com.hzfh.service.baseInfo.helper.SnHelper;
import com.hzframework.helper.DateHelper;

/**
 * Created by Administrator on 2015/6/3.
 */
public class SnServiceTest {
    @Test
    public void getSnTest() throws Exception {
        String url =
                "http://customerservice.hzfh.com:8080/service-customer/paymentCustomerBank";
        HessianProxyFactory factory = new HessianProxyFactory();
        SnService snService = (SnService)
                factory.create(SnService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        SnService snService = (SnService) context.getBean("snService");
        String a = snService.getSn(SnEnum.SN_RECHARGE);
        System.out.println(a);


    }
    /*@Test
    public void getInfoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SmsService smsService = (SmsService) context.getBean("smsService");
        Sms sms = new Sms();
    sms.setCellnumber("13548");
    sms.setSmscontent("xsdfhdfiv");
    smsService.add(sms);
}

    @Test
    public void verificationTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SmsService smsService = (SmsService) context.getBean("smsService");
        String vfCode = smsService.verification("13716498307");
        System.out.println(vfCode);
    }
    
    
    @Test
    public void snTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SnService snService = (SnService) context.getBean("snService");
        
        String temp = snService.getSn(SnEnum.SN_ENTERPRISEREGISTER);
        System.out.println(temp);
    }*/
	@Test
	public void sntest1(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss.SSS");  
		String tempTime=sdf.format(new Date(System.currentTimeMillis()));  
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(tempTime);  
		tempTime = m.replaceAll("").trim();
		System.out.println(tempTime);
	}
    
}
