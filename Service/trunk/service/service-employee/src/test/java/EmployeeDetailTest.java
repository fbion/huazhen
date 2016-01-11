import com.hzfh.api.employee.model.EmployeeCredential;
import com.hzfh.api.employee.model.EmployeeDetail;
import com.hzfh.api.employee.service.EmployeeCredentialService;
import com.hzfh.api.employee.service.EmployeeDetailService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/5/13.
 */
public class EmployeeDetailTest {
    @Test
    public void getEmpDetailByEmpNoTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");
        EmployeeDetail employeeDetail = employeeDetailService.getEmpDetailByEmpNo(1103);
        System.out.print(employeeDetail);
    }

    @Test
    public void updateEmpDetailByEmpNoTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");
        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setEmpNo(1103);
        employeeDetail.setNation("hsldfjsl");
        int result = employeeDetailService.updateEmpDetailByEmpNo(employeeDetail);
        System.out.print(result);
    }

    @Test
    public void updateEmpDetailByOtherInfoTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDetailService employeeDetailService = (EmployeeDetailService) context.getBean("employeeDetailService");
        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setEmpNo(1110);
        employeeDetail.setBankAccount("2412341234123423");
        int result = employeeDetailService.updateEmpDetailByOtherInfo(employeeDetail);
        System.out.print(result);
    }

    @Test
    public void getEmpCredentialByEmpNoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeCredentialService employeeCredentialService = (EmployeeCredentialService) context.getBean("employeeCredentialService");
        List<EmployeeCredential> employeeCredentialList = employeeCredentialService.getEmpCredentialByEmpNo(1124);
        System.out.print(employeeCredentialList.size());
    }

}
