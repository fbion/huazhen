import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.AttendanceApplication;
import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.AttendanceApplicationCondition;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzfh.api.employee.service.AttendanceApplicationService;
import com.hzfh.api.employee.service.EmpCompilePlanService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/13.
 */
public class AttendanceApplicationTest {

    @Test
    public void getPagingListTest() throws Exception{
        String url =
               "http://employeeservice.hzfh.com:8080/service-employee/attendanceApplication";
		 HessianProxyFactory factory = new HessianProxyFactory();
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService)factory.create(AttendanceApplicationService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");
//        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context
//                .getBean("attendanceApplicationService");

        AttendanceApplicationCondition attendanceApplicationCondition = new AttendanceApplicationCondition();
        // productCondition.setId(1);
        attendanceApplicationCondition.setPageIndex(1);
        attendanceApplicationCondition.setPageSize(10);
        attendanceApplicationCondition.setTotalCount(9);
        attendanceApplicationCondition.setByStatus(1);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        attendanceApplicationCondition.setSortItemList(sortItemList);
        List<AttendanceApplication> attendanceApplicationPagedList = attendanceApplicationService
                .getListForExcel(attendanceApplicationCondition);
        for(AttendanceApplication attendanceApplication:attendanceApplicationPagedList){
            System.out.println(attendanceApplication.getId()+","+attendanceApplication.getWorkFlowStatus());
        }
        System.out.println(attendanceApplicationPagedList.size());

    }
    @Test
    public void updateTest() throws Exception{
        String url =
               "http://employeeservice.hzfh.com:8080/service-employee/attendanceApplication";
		 HessianProxyFactory factory = new HessianProxyFactory();
        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService)factory.create(AttendanceApplicationService.class, url);

//        AttendanceApplicationService
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");
//        AttendanceApplicationService attendanceApplicationService = (AttendanceApplicationService) context
//                .getBean("attendanceApplicationService");
        int a = attendanceApplicationService.updateStatusByActivitiNo("132655");
        System.out.println(a);
    }
}
