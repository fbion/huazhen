import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.api.customer.service.P2pCustomerService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paul on 14-12-23.
 */
public class P2pCustomerServiceTest {
	@Test
	public void getListTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
        P2pCustomer p2pCustomer  = p2pCustomerService.getInfoByCellphone("13716498307");
        System.out.print(p2pCustomer.getCellphone());


	}

	@Test
	public void getPagingListTest() throws MalformedURLException {
		 String url =
		 "http://customerservice.hzfh.com:8080/service-customer/p2pCustomer";
		 HessianProxyFactory factory = new HessianProxyFactory();
		 P2pCustomerService p2pCustomerService = (P2pCustomerService)
		 factory.create(P2pCustomerService.class, url);
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
//				.getBean("p2pCustomerService");
		P2pCustomerCondition p2pCustomerCondition = new P2pCustomerCondition();

		p2pCustomerCondition.setPageIndex(1);
		p2pCustomerCondition.setPageSize(10);
		p2pCustomerCondition.setTotalCount(3);
		p2pCustomerCondition.setP2pCustomerName(null);
		p2pCustomerCondition.setByDeptNo(33);
		p2pCustomerCondition.setByEmpNo(0);
//		p2pCustomerCondition.setByStatus(0);
//        String a = "abc";
		
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);

		p2pCustomerCondition.setSortItemList(sortItemList);

		PagedList<P2pCustomer> p2pCustomerPagedList = p2pCustomerService
				.getPagingList(p2pCustomerCondition);
		System.out.println("getPagingListTest");
		for (P2pCustomer p2pCustomer : p2pCustomerPagedList.getResultList()) {
			System.out.println(p2pCustomer.getId() + ":"
					+ p2pCustomer.getUserName() + ":" + p2pCustomer.getEmpNo());
		}
	}

	@Test
	public void addTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");

		P2pCustomer p2pCustomer = new P2pCustomer();
		p2pCustomer.setUserName("张三");
		p2pCustomer.setEmpNo(103);
		p2pCustomer.setAddress("河北省保定市北市区");

		int id = p2pCustomerService.add(p2pCustomer);

		System.out.println("addTest");
		System.out.println(id);
	}

	@Test
	public void selectByUserNameTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		P2pCustomer p2pCustomer = new P2pCustomer();
		p2pCustomer = p2pCustomerService.selectByUserName("171697377@qq.com");
		System.out.println("selectByUserNameTest");
		System.out.println(p2pCustomer.getId() + "-"
				+ p2pCustomer.getUserName() + "-" + p2pCustomer.getAddress());

	}

	@Test
	public void updateLastLoginTimeTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		int id = 3;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date lastLoginTime=sdf.parse(sdf.format(new Date()));
		Date lastLoginTime = new Date();
//		p2pCustomerService.updateLastLoginTime(id, lastLoginTime);
		System.out.println("updateLastLoginTimeTest");
		System.out.println(lastLoginTime);
	}

	@Test
	public void updateTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		P2pCustomer p2pCustomer = new P2pCustomer();
		int id = 1;
		String phone = "13715652689";
		String qq = "230564895";
		String email = "zhangsan@126.com";
		p2pCustomer.setUserName("zhangsan");
		Timestamp lastLoginTime = new Timestamp(new Date().getTime());
		p2pCustomer.setPhone(phone);
		p2pCustomer.setQq(qq);
		p2pCustomer.setQq(email);
		p2pCustomer.setId(id);
		p2pCustomer.setLastLoginTime(lastLoginTime);
		p2pCustomerService.update(p2pCustomer);
		System.out.println("updateTest");
	}
	@Test
	public void updatecardTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		P2pCustomer p2pCustomer = new P2pCustomer();
		int id = 56;
		String phone = "77777777";
		String qq = "111111111";
		String email = "zhangsan@126.com";
		p2pCustomer.setUserName("zhangsan");
		Timestamp lastLoginTime = new Timestamp(new Date().getTime());
		p2pCustomer.setCellphone(phone);
		p2pCustomer.setQq(qq);
		p2pCustomer.setEmail(email);
		p2pCustomer.setId(id);
		p2pCustomer.setLastLoginTime(lastLoginTime);
		p2pCustomer.setCardNumber("12222");
		//p2pCustomerService.updateWithCardNumber(p2pCustomer);
		System.out.println("updateTest");
	}

	@Test
	public void updatePswdByIdTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		int id = 3;
		String password = "123456";
		p2pCustomerService.updatePswdById(id, password);
		System.out.println("updatePswdByIdTest");
	}

	// 查询密码
	@Test
	public void selectPswdTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		int id = 3;
		String pwsd = p2pCustomerService.selectPswd(id);
		System.out.println("selectPswdTest");
		System.out.println(pwsd);
	}

	@Test
	public void selectSecretKeyTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		int id = 3;
		String secretKey = p2pCustomerService.selectSecretKey(id);
		System.out.println("selectSecretKeyTest");
		System.out.println(secretKey);
	}

	@Test
	public void updateEmpNoByIdTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		int id = 3;
		int empNo = 2;
		int n = p2pCustomerService.updateEmpNoById(id, empNo);
		System.out.println("selectSecretKeyTest");
		System.out.println(n);
	}

	@Test
	public void updateStatusByIdTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		int id = 3;
		byte status = 2;
		int n = p2pCustomerService.updateStatusById(id, status);
		System.out.println("updateStatusByIdTest");
		System.out.println(n);
	}

	@Test
	public void selectByEmailTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		P2pCustomer p2pCustomer = new P2pCustomer();
		String email = "wangwu@126.com";
		p2pCustomer = p2pCustomerService.selectByEmail(email);
		System.out.println("selectByEmailTest");
		System.out.println(p2pCustomer.getId() + "-"
				+ p2pCustomer.getUserName() + "-" + p2pCustomer.getAddress());
	}

	@Test
	public void selectByEmailAndStatusTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context
				.getBean("p2pCustomerService");
		P2pCustomer p2pCustomer = new P2pCustomer();
		String email = "wangwu@126.com";
		byte status = 2;
		p2pCustomer = p2pCustomerService.selectByEmailAndStatus(email, status);
		System.out.println("selectByEmailAndStatusTest");
		System.out.println(p2pCustomer.getId() + "-"
				+ p2pCustomer.getUserName() + "-" + p2pCustomer.getAddress());
	}

    @Test
    public void updateP2pCustomerByIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context
                .getBean("p2pCustomerService");
        int result = p2pCustomerService.updateP2pCustomerById(26,8);
        System.out.println("updateP2pCustomerByIdTest");
        System.out.println(result);
    }

    @Test
    public void getP2pCustomerByCustomerNoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context
                .getBean("p2pCustomerService");

        P2pCustomer p2pCustoemr = p2pCustomerService.getP2pCustomerByCustomerNo(494);

        System.out.println(p2pCustoemr.getId());

    }

    @Test
    public void updateDeptNoAndEmpNoByIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context
                .getBean("p2pCustomerService");

//        int result = p2pCustomerService.updateDeptNoAndEmpNoById(97,1,5);
//        System.out.println(result);
    }
    @Test
    public void getInfoByCellphoneTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
    	P2pCustomerService p2pCustomerService = (P2pCustomerService) context
                .getBean("p2pCustomerService");
    	P2pCustomer p2pCustomer = p2pCustomerService.getInfoByCellphone("18810009094");
    	System.out.println(p2pCustomer.getId());
    }

}
