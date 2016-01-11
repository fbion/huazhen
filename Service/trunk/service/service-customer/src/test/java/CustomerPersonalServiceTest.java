import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.ActivityCondition;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.customer.service.ActivitiesService;
import com.hzfh.api.customer.service.ActivityAwardRelationService;
import com.hzfh.api.customer.service.ActivityConditionService;
import com.hzfh.api.customer.service.CustomerPersonalService;
import com.hzframework.contract.PagedList;
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
 * Created by paul on 14-12-23.
 */
public class CustomerPersonalServiceTest {
    @Test
    public void getListTest()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        List<CustomerPersonal> CustomerPersonalList = customerPersonalService.getList();

        System.out.println("getListTest");
        for (CustomerPersonal customerPersonal : CustomerPersonalList)
        {
            System.out.println(customerPersonal.getId()+":"+customerPersonal.getName()+":"+customerPersonal.getCode());
        }
    }

    @Test
    public void getPagingListTest() throws MalformedURLException {
    	String url = "http://172.16.26.8:8080/service-customer/customerPersonal";
        HessianProxyFactory factory = new HessianProxyFactory();
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) factory.create(CustomerPersonalService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        CustomerPersonalCondition customerPersonalCondition = new CustomerPersonalCondition();
        customerPersonalCondition.setPageIndex(3);
        customerPersonalCondition.setPageSize(10);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        customerPersonalCondition.setSortItemList(sortItemList);
        PagedList<CustomerPersonal> customerPersonalPagedList = customerPersonalService.getPagingList(customerPersonalCondition);
        System.out.println("getPagingListTest");
        System.out.print(customerPersonalPagedList.getResultList().size());
    }
    @Test
    public void getMyPagingListTest() throws MalformedURLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        CustomerPersonalCondition customerPersonalCondition = new CustomerPersonalCondition();
        customerPersonalCondition.setMyCustomer(true);
        customerPersonalCondition.setPageIndex(1);
        customerPersonalCondition.setPageSize(10);
        customerPersonalCondition.setWorkMateString("4");
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("name");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        customerPersonalCondition.setSortItemList(sortItemList);
        PagedList<CustomerPersonal> customerPersonalPagedList = customerPersonalService.getPagingList(customerPersonalCondition);
        System.out.println("getPagingListTest");

        for (CustomerPersonal customerPersonal : customerPersonalPagedList.getResultList())
        {
            System.out.println(customerPersonal.getId()+":"+customerPersonal.getName()+":"+customerPersonal.getCode());
        }
    }
  /*  @Test
    public void getMyTotalCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        CustomerPersonalCondition customerPersonalCondition = new CustomerPersonalCondition();
        customerPersonalCondition.setPageIndex(1);
        customerPersonalCondition.setPageSize(10);
        customerPersonalCondition.setWorkMateString("4");
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("name");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        customerPersonalCondition.setSortItemList(sortItemList);
        int result = customerPersonalService.getMyTotalCount(customerPersonalCondition);
        System.out.println(result);
    }*/
    @Test
    public void getInfoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        CustomerPersonal  customerPersonal =  customerPersonalService.getInfo(1);
        System.out.println("getInfoTest");
        System.out.println(customerPersonal.getId()+":"+customerPersonal.getName()+":"+customerPersonal.getCode());
    }
    @Test
    public void getCustomerByCardNumberTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
    	CustomerPersonal  customerPersonal =  customerPersonalService.getCustomerByCardNumber("510723199007195415");
    	System.out.println("getInfoTest");
    	System.out.println(customerPersonal.getId()+":"+customerPersonal.getName()+":"+customerPersonal.getCode());
    }

    @Test
    public void addTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        CustomerPersonal customerPersonal = new CustomerPersonal();
        customerPersonal.setName("name22222");
        customerPersonal.setCode("阿的时尚大方");

        int id = customerPersonalService.add(customerPersonal);

        System.out.println("addTest");
        System.out.println(id);
    }

    @Test
    public void updateTest() throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        String url = "http://customerservice.hzfh.com:8080/service-customer/customerPersonal";

       // http://customerservice.hzfh.com:8080/service-customer/customerPersonal
        HessianProxyFactory factory = new HessianProxyFactory();
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) factory.create(CustomerPersonalService.class, url);
        CustomerPersonal customerPersonal = new CustomerPersonal();
        customerPersonal.setName("name33312211");
        customerPersonal.setCode("1ff312");
        customerPersonal.setId(1);

        int ret = customerPersonalService.update(customerPersonal);

        System.out.println(ret);
    }

    @Test
    public void deleteTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        int ret = customerPersonalService.delete(5);

        System.out.println(ret);
    }

    @Test
    public void  getMyCustomerList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        List<Integer> workmate = new ArrayList<Integer>();
        workmate.add(115);
        workmate.add(110);
        String workMateString = StringHelper.listToString(workmate);
        List<CustomerPersonal> customerPersonalList = customerPersonalService.getMyCustomerPersonalList(workMateString);
        for(CustomerPersonal customerPersonal:customerPersonalList){
            System.out.println(customerPersonal.getName());
        }
    }
    
    
 /*   @Test
    public void cardCheck(){
    	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
         String cardNumber = "999";
         int id  = 0;
         List<CustomerPersonal> customerPersonalList = customerPersonalService.cardCheck(cardNumber, id,"");
         for(CustomerPersonal customerPersonal:customerPersonalList){
             System.out.println(customerPersonal.getName()+"=====>>>"+customerPersonal.getId());
         }
    }*/

    @Test
    public void getCustomerPersonalByNameAndCellphone() throws MalformedURLException {
        String url = "http://192.168.1.232:8080/service-customer/customerPersonal";
        HessianProxyFactory factory = new HessianProxyFactory();
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) factory.create(CustomerPersonalService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        ArrayList<CustomerPersonal> customerPersonalList = (ArrayList<CustomerPersonal>) customerPersonalService.checkCustomerPersonalByNameAndCellphone(0,"胡磊磊", "13366868447","");
        System.out.print(customerPersonalList.size());
    }

    @Test
    public void updateTradeTotalByIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        System.out.print(customerPersonalService.updateTradeTotalById(58, -99999));
    }

    @Test
    public void updateLoginByP2pCustoemrNoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        System.out.print(customerPersonalService.updateLoginByP2pCustoemrNo(382));
    }
    @Test
    public void deletesssTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ActivityAwardRelationService activityConditionService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");
    	ActivityAwardRelation activityCondition  = activityConditionService.getInfoByRelatedNo(1,9);
        System.out.println(activityCondition);
    }
}
