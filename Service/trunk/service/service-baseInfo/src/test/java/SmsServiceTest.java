import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.baseInfo.model.Sn;
import com.hzfh.api.baseInfo.service.SnService;

/**
 * Created by Administrator on 2015/6/3.
 */
public class SmsServiceTest {
    @Test
    public void addTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SnService snService = (SnService) context.getBean("snService");
        Sn sn = new Sn();
        sn.setBizCode("00");
        sn.setTimeCode("时间编号");
        sn.setCode("流水字符串");
        snService.add(sn);
}

    @Test
    public void truncateSnTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SnService snService = (SnService) context.getBean("snService");
        snService.truncateSn();
    }
}
