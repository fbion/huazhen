import com.hzfh.api.baseInfo.model.LoginFailed;
import com.hzfh.api.baseInfo.service.LoginFailedService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

public class LoginFailedServiceTest{
	@Test 
	public void addTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginFailedService loginFailedService = (LoginFailedService) context.getBean("loginFailedService");
		LoginFailed loginFailed = new LoginFailed();
		Date loginTime = new Date();
		String userName = "zhangsan";
		loginFailed.setLoginTime(new Timestamp(new Date().getTime()));
		loginFailed.setUserName(userName);

		int n = loginFailedService.add(loginFailed);

		System.out.println("addTest");
		System.out.println(n);
	}
}
