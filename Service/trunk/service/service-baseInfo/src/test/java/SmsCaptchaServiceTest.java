import com.hzfh.api.baseInfo.model.SmsCaptcha;
import com.hzfh.api.baseInfo.service.SmsCaptchaService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/3.
 */
public class SmsCaptchaServiceTest {

    @Test
    public void addTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SmsCaptchaService smsCaptchaService = (SmsCaptchaService) context.getBean("smsCaptchaService");
        SmsCaptcha smsCaptcha = new SmsCaptcha();
        smsCaptcha.setCode("326532");
        smsCaptcha.setStatus(1);
        smsCaptcha.setUserNo(2);
        smsCaptcha.setTelephone("1371648421");
        smsCaptchaService.add(smsCaptcha);
    }
}
