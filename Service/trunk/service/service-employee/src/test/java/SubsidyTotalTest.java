import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.service.EmployeeService;
import com.hzfh.api.employee.service.SubsidyService;
import com.hzfh.api.employee.service.SubsidyTotalService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/5/6.
 */
public class SubsidyTotalTest {
    @Test
    public void getEmplistTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        SubsidyTotalService subsidyTotalService = (SubsidyTotalService) context.getBean("subsidyTotalService");
        int result = subsidyTotalService.updateIsExamineById(180);
        System.out.println(result);
    }
}
