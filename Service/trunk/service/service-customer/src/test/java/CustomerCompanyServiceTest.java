import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.api.customer.service.CustomerCompanyService;
import com.hzfh.api.customer.service.CustomerPersonalService;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/2/13.
 */
public class CustomerCompanyServiceTest {
    @Test
    public void getMyCustomerList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");
        List<Integer> workmate = new ArrayList<Integer>();
        workmate.add(115);
        workmate.add(110);
        String workMateString = StringHelper.listToString(workmate);
        List<CustomerCompany> customerCompanyList = customerCompanyService.getMyCustomerCompanyList(workMateString);
        for (CustomerCompany customerCompany : customerCompanyList) {
            System.out.println(customerCompany.getName());
        }
    }
    @Test
    public void getList() throws Exception {
        String url = "http://customerservice.hzfh.com:8080/service-customer/customerCompany";
        HessianProxyFactory factory = new HessianProxyFactory();
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) factory.create(CustomerCompanyService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");
        CustomerCompanyCondition customerCompanyCondition = new CustomerCompanyCondition();
        customerCompanyCondition.setPageIndex(1);
        customerCompanyCondition.setPageSize(10);
//        customerPersonalCondition.setRelationLevel(1);

//        customerPersonalCondition.setTotalCount(20);
//        customerPersonalCondition.setMyCustomer(false);
//        customerPersonalCondition.setWorkMateString("148");
        /*customerPersonalCondition.setP2pUserName("123");
        customerPersonalCondition.setCellphone("15011252651");
        customerPersonalCondition.setCardNumber("330205198410256224");*/

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);

        customerCompanyCondition.setSortItemList(sortItemList);
        customerCompanyCondition.setWorkMateString("192");
        customerCompanyCondition.setIsSales(1);
        List<CustomerCompany> customerCompanyList = customerCompanyService.getPagingList(customerCompanyCondition).getResultList();
        for (CustomerCompany customerCompany : customerCompanyList) {
            System.out.println(customerCompany.getName()+""+customerCompany.getTradeTotal());
        }
    }

    @Test
    public void cardCheck() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");
        String cardNumber = "xxx";
        int id = 37;
        List<CustomerCompany> customerCompanyList = customerCompanyService.cardCheck(cardNumber, id);
        for (CustomerCompany customerCompany : customerCompanyList) {
            System.out.println(customerCompany.getName());
        }
    }


    @Test
    public void getInfoByP2pCustomerNoTest() throws MalformedURLException {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");*/
        String url = "http://172.16.27.18:8080/service-customer/customerCompany";
        HessianProxyFactory factory = new HessianProxyFactory();
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) factory.create(CustomerCompanyService.class, url);
        CustomerCompany customerCompany = customerCompanyService.getInfoByP2pCustomerNo(249);
        System.out.print(customerCompany.getName());
    }
}
