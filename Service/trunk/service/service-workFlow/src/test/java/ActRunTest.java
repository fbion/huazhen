import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.service.EmployeeService;
import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.service.ActHiProcinstService;
import com.hzfh.api.workFlow.service.ActHiTaskinstService;
import com.hzfh.api.workFlow.service.ActRuTaskService;
import com.hzfh.api.workFlow.service.ApprovalHistoriaService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ulei0 on 2015/10/10.
 */
public class ActRunTest {

    @Test
    public void deleteByActivitiNoTest() throws Exception{

        String url =
                "http://employeeservice.hzfh.com:8080/service-workFlow/actRuTask";
        HessianProxyFactory factory = new HessianProxyFactory();
        ActRuTaskService actRuTaskService = (ActRuTaskService)
                factory.create(ActRuTaskService.class, url);

//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");
//        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");
        ActRuTask actRuTask = actRuTaskService.getInfoByAciIdAndUserId("657501",258);
        System.out.println(actRuTask);
    }

    @Test
    public void completeHistoryTaskByActivitiNoTest() throws Exception{

        String url =
                "http://employeeservice.hzfh.com:8080/service-workFlow/actHiTaskinst";
        HessianProxyFactory factory = new HessianProxyFactory();
        ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService)
                factory.create(ActHiTaskinstService.class, url);

//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");
//        ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService) context.getBean("actHiTaskinstService");
        List<ActHiTaskinst> actHiTaskinstList = actHiTaskinstService.getListByActivitiNo("560241");
        System.out.print(actHiTaskinstList);
    }

    @Test
    public void Test(){
        String value = "123.0";
        String val = value.split(".")[0];
        System.out.println(val);
    }
}
