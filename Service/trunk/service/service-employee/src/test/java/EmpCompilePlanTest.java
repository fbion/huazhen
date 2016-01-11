import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
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
 * Created by Administrator on 2015/5/12.
 */
public class EmpCompilePlanTest {
    @Test
      public void getPagingListTest() throws Exception{
//        String url =
//               "http://employeeservice.hzfh.com:8080/service-employee/empCompilePlan";
//		 HessianProxyFactory factory = new HessianProxyFactory();
//        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService)factory.create(EmpCompilePlanService.class, url);
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService) context
                .getBean("empCompilePlanService");

        EmpCompilePlanCondition empCompilePlanCondition = new EmpCompilePlanCondition();
        // productCondition.setId(1);
        empCompilePlanCondition.setPageIndex(1);
        empCompilePlanCondition.setPageSize(4);
        empCompilePlanCondition.setTotalCount(9);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        empCompilePlanCondition.setSortItemList(sortItemList);

        //empCompilePlanCondition.setByPosition(2);
        //empCompilePlanCondition.setByYear(2015);
        PagedList<EmpCompilePlan> empCompilePlanList = empCompilePlanService
                .getPagingList(empCompilePlanCondition);
        System.out.println("getPagingListTest");
        for (EmpCompilePlan empCompilePlan : empCompilePlanList.getResultList()) {
            System.out.println(empCompilePlan.getId()+","+empCompilePlan.getYear());
        }
    }
    @Test
    public void getListForExcelTest() throws Exception{
        String url =
               "http://employeeservice.hzfh.com:8080/service-employee/empCompilePlan";
		 HessianProxyFactory factory = new HessianProxyFactory();
        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService)factory.create(EmpCompilePlanService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");
//        EmpCompilePlanService empCompilePlanService = (EmpCompilePlanService) context
//                .getBean("empCompilePlanService");

        EmpCompilePlanCondition empCompilePlanCondition = new EmpCompilePlanCondition();
        // productCondition.setId(1);
        empCompilePlanCondition.setPageIndex(1);
        empCompilePlanCondition.setPageSize(4);
        empCompilePlanCondition.setTotalCount(9);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        empCompilePlanCondition.setSortItemList(sortItemList);

        //empCompilePlanCondition.setByPosition(2);
        empCompilePlanCondition.setByYear(2015);
        List<EmpCompilePlan> empCompilePlanList = empCompilePlanService
                .getListForExcel(empCompilePlanCondition);
        System.out.println("getPagingListTest");
        System.out.println(empCompilePlanList.size());
    }

}
