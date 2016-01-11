import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.CommissionWealthCenter;
import com.hzfh.api.employee.model.EmpCompilePlan;
import com.hzfh.api.employee.model.query.CommissionWealthCenterCondition;
import com.hzfh.api.employee.model.query.EmpCompilePlanCondition;
import com.hzfh.api.employee.service.CommissionWealthCenterService;
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
 * Created by Administrator on 2015/7/1.
 */
public class CommissionWealthCenterTest {
    @Test
    public void getPagingListTest() throws Exception{
        String url =
               "http://employeeservice.hzfh.com:8080/service-employee/commissionWealthCenter";
		 HessianProxyFactory factory = new HessianProxyFactory();
        CommissionWealthCenterService commissionWealthCenterService = (CommissionWealthCenterService)
                factory.create(CommissionWealthCenterService.class, url);
//                ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");
//        CommissionWealthCenterService commissionWealthCenterService = (CommissionWealthCenterService) context
//                .getBean("commissionWealthCenterService");

        CommissionWealthCenterCondition commissionWealthCenterCondition = new CommissionWealthCenterCondition();
        // productCondition.setId(1);
        commissionWealthCenterCondition.setPageIndex(1);
        commissionWealthCenterCondition.setPageSize(4);
        commissionWealthCenterCondition.setTotalCount(9);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        commissionWealthCenterCondition.setSortItemList(sortItemList);

        PagedList<CommissionWealthCenter> commissionWealthCenterPagedList = commissionWealthCenterService
                .getPagingList(commissionWealthCenterCondition);
        System.out.println("getPagingListTest");
        for (CommissionWealthCenter commissionWealthCenter : commissionWealthCenterPagedList.getResultList()) {
            System.out.println(commissionWealthCenter.getId());
        }
    }
}
