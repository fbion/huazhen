import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.baseInfo.service.EmailService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailServiceTest{
	//TODO  数据没有插入进去
	@Test
	public void addTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmailService emailService = (EmailService) context.getBean("emailService");

		Email email = new Email();
		email.setSubject("name22222");
		email.setHost("mail.bestinvestor.com.cn");
		email.setUser("administrator");
		email.setPassword("huazhen@123");
		email.setTo("huj@bestinvestor.com.cn");
		email.setBody("mengc");
		email.setSuffix("hzjkjt.cn");
		byte status = 1;
		email.setStatus(status);
		//email.setSendtime( new Timestamp(new Date().getTime()));
		//email.setInTime(new Timestamp(new Date().getTime()));
		int n= emailService.add(email);
		

		System.out.println("addTest");
		System.out.println(n);
	}
}