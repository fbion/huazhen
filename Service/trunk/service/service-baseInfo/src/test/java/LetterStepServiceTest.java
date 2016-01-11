import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.baseInfo.model.LetterStep;
import com.hzfh.api.baseInfo.service.LetterStepService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/4/20.
 */
public class LetterStepServiceTest {
    @Test
    public void addTest() throws Exception {
        String url =
                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/letterStep";
        HessianProxyFactory factory = new HessianProxyFactory();
        LetterStepService letterStepService = (LetterStepService)factory.create(LetterStepService.class, url);

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        LetterStepService letterStepService = (LetterStepService) context.getBean("letterStepService");
        LetterStep letterStep = new LetterStep();
        letterStep.setEditNo(2);
        letterStep.setLetterNo(3);
        letterStep.setOperate(2);
        int result = letterStepService.add(letterStep);
        System.out.println(result);
    }
    @Test
    public void getListByLetterNoTest() throws Exception {
        String url =
                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/letterStep";
        HessianProxyFactory factory = new HessianProxyFactory();
        LetterStepService letterStepService = (LetterStepService)factory.create(LetterStepService.class, url);

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        LetterStepService letterStepService = (LetterStepService) context.getBean("letterStepService");
        List<LetterStep> letterStepList = letterStepService.getListByLetterNo(147);
        System.out.println(letterStepList.size());
    }
}
