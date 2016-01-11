import com.hzfh.api.product.model.*;
import com.hzfh.api.product.model.query.FinancierPersonalCondition;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.api.product.service.*;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paul on 14-12-23.
 */
public class ProductTest {
	@Test
	public void getListTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");

		List<Product> productList = productService.getList();

		System.out.println("getListTest");
		for (Product product : productList) {
			System.out.println(product.getId() + ":" + product.getName() + ":"
					+ product.getCode());
		}
	}

	@Test
	public void getPagingListTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");

		ProductCondition productCondition = new ProductCondition();
		// productCondition.setId(1);
		productCondition.setPageIndex(1);
		productCondition.setPageSize(20);

		productCondition.setName("4");

		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("name");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);

		SortItem sortItem2 = new SortItem();
		sortItem2.setSortFeild("code");
		sortItem2.setSortType(SortType.DESC);
		sortItemList.add(sortItem2);

		productCondition.setSortItemList(sortItemList);

		PagedList<Product> productPagedList = productService
				.getPagingList(productCondition);
		System.out.println("getPagingListTest");
		for (Product product : productPagedList.getResultList()) {
			System.out.println(product.getId() + ":" + product.getName() + ":"
					+ product.getCode());
		}
	}

	@Test
	public void getInfoTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		P2pProductService p2pProductService = (P2pProductService) context
				.getBean("p2pProductService");

		P2pProduct p2pProduct = p2pProductService.getInfo(54);

		System.out.println("getInfoTest");
		System.out.println(p2pProduct);
	}

	@Test
	public void addTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");

		Product product = new Product();
		product.setName("name22222");
		product.setCode("阿的时尚大方");

		int id = productService.add(product);

		System.out.println("addTest");
		System.out.println(id);
	}

	@Test
	public void updateTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");

		Product product = new Product();
		product.setName("name33312211");
		product.setCode("1ff312");
		product.setId(1);

		int ret = productService.update(product);

		System.out.println(ret);
	}

	@Test
	public void deleteTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");

		int ret = productService.delete(5);

		System.out.println(ret);
	}

	@Test
	public void getListByType() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");

		List<Product> productList = productService.getListByType(Byte
				.parseByte("1"));

		System.out.println("getListByType");
		for (Product product : productList) {
			System.out.println(product.getId() + ":" + product.getName() + ":"
					+ product.getType());
		}
	}
	
	@Test
	public void getProductListByStatus() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");

		List<Product> productList = productService.getProductListByStatus((byte)20,(byte)30);

		System.out.println("getListByType");
		for (Product product : productList) {
			System.out.println(product.getId() + ":" + product.getName() + ":"
					+ product.getType());
		}
	}
	
	
	
	

	@Test
	// 测试个人融资方管理
	public void getFinancierPersonalPagingListTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		FinancierPersonalService financierPersonalService = (FinancierPersonalService) context
				.getBean("financierPersonalService");

		FinancierPersonalCondition financierPersonalCondition = new FinancierPersonalCondition();
		// productCondition.setId(1);
		financierPersonalCondition.setPageIndex(1);
		financierPersonalCondition.setPageSize(20);
		financierPersonalCondition.setName("3");
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("name");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);

		SortItem sortItem2 = new SortItem();
		sortItem2.setSortFeild("code");
		sortItem2.setSortType(SortType.DESC);
		sortItemList.add(sortItem2);

		financierPersonalCondition.setSortItemList(sortItemList);

		PagedList<FinancierPersonal> financierPersonalPagedList = financierPersonalService
				.getPagingList(financierPersonalCondition);
		System.out.println("getPagingListTest");
		for (FinancierPersonal financierPersonal : financierPersonalPagedList
				.getResultList()) {
			System.out.println(financierPersonal.getId() + ":"
					+ financierPersonal.getName() + ":"
					+ financierPersonal.getCode());
		}
	}

	@Test
	// 修改
	public void updateProductTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");
		Product product = new Product();
		product.setName("修改的名字B");
		product.setCode("0018");
		product.setId(18);
		int ret = productService.updateBasicInfo(product);
		System.out.println(ret);
	}

	@Test
	// 修改状态
	public void updateProductStatusTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");
		int id = 1;
		byte status = (byte) 1;
		int ret = productService.updateStatus(id, status);
		System.out.println(ret);
	}

	@Test
	// 修改负责人
	public void updateProductManagerTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");
		int ret1 = productService.updateManager(1, 1);
		System.out.println(ret1);

	}

	@Test
	// 根据产品no 查询附件list
	public void getListByProductNo() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductAttachmentService productService = (ProductAttachmentService) context
				.getBean("productAttachmentService");
		int productNo = 0;
		List<ProductAttachment> productList = productService
				.getListByProductNo(productNo);

		System.out.println("getListByProductNo");
		for (ProductAttachment product : productList) {
			System.out.println("id:=>" + product.getId() + "姓名:=>"
					+ product.getName() + "类型:=>" + product.getType() + "状态:=>"
					+ product.getStatus());
		}
	}

	@Test
	// 修改负责人
	public void updateStatus() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductAttachmentService productService = (ProductAttachmentService) context
				.getBean("productAttachmentService");
		int id = 1;
		byte status = 0;
		int ret1 = productService.updateStatus(id, status);

		ProductAttachment productAttachment = productService.getInfo(id);
		System.out.println("I D：=》" + productAttachment.getId() + "名称：=》"
				+ productAttachment.getName() + "路径：=》"
				+ productAttachment.getPath() + "状态：=》"
				+ productAttachment.getType() + "是否有效：=》"
				+ productAttachment.getStatus());

	}

	@Test
	// getPartnerRate
	public void getPartnerRate() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		PartnerRateService partnerRateService = (PartnerRateService) context
				.getBean("partnerRateService");
		int productNo = 12;
		Long money = Long.parseLong("200");
		PartnerRate partnerRate = partnerRateService.getPartnerRate(productNo, money);
		System.out.println("getPartnerRate:======>>>"+partnerRate.getId());
		}
	
	
	@Test
	public void updateStatusAndTime() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context.getBean("productService");
		
		int id = 1;
		byte status = 1;
		
		Product product = new Product();
		product.setId(id);
		product.setStatus(status);
		product.setStart(null);
		product.setEnd(null);
		
		int ret1 = productService.updateStatusAndTime(product);

		Product product1 = productService.getInfo(id);
		System.out.println("I D：=》" + product1.getId() + "名称：=》"
				+ product1.getName() + "路径：=》"
				+ product1.getPath() + "状态：=》"
				+ product1.getType() + "是否有效：=》"
				+ product1.getStatus());

	}
	//更新剩余额度
	@Test
	public void updateRemain(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService) context.getBean("productService");
		Product product = new Product();
		product.setId(1);
		product.setRemainAmount(2000);
		product.setRemainSmall(1);
		int i = productService.updateRemain(product);
		if(i>0)
			System.out.println(i);
	}
	//mengchong 2015/03/02 
	@Test
	public void updateRemainAmountAndRemainSmall(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService) context.getBean("productService");
		int id = 154;
        Long remainAmount = 200l;
//		int i = productService.updateAddRemainAmountAndRemainSmall(id,remainAmount);
        int i = productService.updateReduceRemainAmountAndRemainSmall(id,remainAmount);
		System.out.print(i);
	}
	
	@Test
	public void getProductByTypeAndStatus(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService) context.getBean("productService");
		byte type=1;
		byte status=30;
		List<Product> productList=productService.getProductByTypeAndStatus(type, status);
        System.out.println(productList.size());
	}

    @Test
    public void updateStartTimeTest() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext(("applicationContext.xml"));
        ProductService productService = (ProductService) context.getBean("productService");
        int id = 1;
        Date start = DateHelper.parse("2014-11-12");
        int result=productService.updateStartTime(id,start);
        System.out.print(result);
    }

    @Test
    public void getProductListWithNoPagingTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) context.getBean("productService");
        ProductCondition productCondition = new ProductCondition();
        productCondition.setStatusLeft(20);
        productCondition.setStatusRight(60);
        List<Product> productList = productService.getProductListWithNoPaging(productCondition);
        System.out.print(productList.size());

    }

    @Test
    public void updateReduceRemainAmountTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) context.getBean("productService");
        int result = productService.updateAddRemainAmount(45,200);
        System.out.print(result);
    }
	
}
