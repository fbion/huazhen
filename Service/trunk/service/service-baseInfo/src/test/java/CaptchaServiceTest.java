import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.api.baseInfo.service.CaptchaService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

public class CaptchaServiceTest{
	@Test 
	public void addTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");
		Captcha captcha = new Captcha();
		Timestamp indate = new Timestamp(new Date().getTime());
		String code = "abc";
		captcha.setCode(code);
		captcha.setIndate(indate);
        captcha.setExpireTime(indate);
		int n = captchaService.add(captcha);

		System.out.println("addTest");
		System.out.println(n);
	}
	@Test
	public void selectByIdAndCodeTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CaptchaService captchaService = (CaptchaService) context.getBean("captchaService");
		int id = 1;
		String code = "abc";
		Captcha captcha = captchaService.selectByIdAndCode(id,code);
		
		System.out.println("selectByIdAndCodeTest");
		System.out.println(captcha.getStatus());
	}
	
}
