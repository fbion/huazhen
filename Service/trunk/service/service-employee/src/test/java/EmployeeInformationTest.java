import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.query.EmployeeCondition;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzfh.api.employee.service.EmployeeInformationService;
import com.hzfh.api.employee.service.EmployeeService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
public class EmployeeInformationTest {

    @Test
    public void getListForExcelTest() throws  Exception{
        String url =
               "http://employeeservice.hzfh.com:8080/service-employee/employeeInformation";
		 HessianProxyFactory factory = new HessianProxyFactory();
        EmployeeInformationService employeeInformationService = (EmployeeInformationService)factory.create(EmployeeInformationService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");
//        EmployeeInformationService employeeInformationService  = (EmployeeInformationService) context.
//                getBean("employeeInformationService");

        EmployeeInformationCondition employeeInformationCondition = new EmployeeInformationCondition();
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        employeeInformationCondition.setSortItemList(sortItemList);

        List<EmployeeInformation> employeeInformationList = employeeInformationService.getListForExcel(employeeInformationCondition);
        for(EmployeeInformation employeeInformation :employeeInformationList){
            System.out.println(employeeInformation.getId()+"___"+employeeInformation.getPositionNo());
        }
    }
    @Test
    public void getListForExcelTest1() throws Exception{
        String url =
                "http://employeeservice.hzfh.com:8080/service-employee/employeeInformation";
        HessianProxyFactory factory = new HessianProxyFactory();
        EmployeeInformationService employeeInformationService = (EmployeeInformationService)factory.create(EmployeeInformationService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");
//        EmployeeInformationService employeeInformationService  = (EmployeeInformationService) context.
//                getBean("employeeInformationService");
        List<EmployeeInformation> employeeInformationList = employeeInformationService.getListForExcelByType(4);
        System.out.println(employeeInformationList.size());


    }
}
