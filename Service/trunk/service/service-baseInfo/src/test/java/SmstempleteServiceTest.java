import com.hzfh.api.baseInfo.model.Smstemplete;
import com.hzfh.api.baseInfo.service.SmstempleteService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/3.
 */
public class SmstempleteServiceTest {
    @Test
    public void getInfoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SmstempleteService smstempleteService = (SmstempleteService) context.getBean("smstempleteService");
        Smstemplete smstemplete =  smstempleteService.getInfo(18);
        System.out.println(smstemplete.getContent());
    }
}
