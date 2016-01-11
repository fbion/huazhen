package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.api.product.service.ProductService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class ProductFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<Product> getPagingList(ProductCondition productCondition) {
        ProductService productService = (ProductService) context.getBean("productService");

        return productService.getPagingList(productCondition);
    }

    public static int add(Product product) {
        ProductService productService = (ProductService) context.getBean("productService");

        return productService.add(product);
    }

    public static int update(Product product) {
        ProductService productService = (ProductService) context.getBean("productService");

        return productService.update(product);
    }

    public static List<Product> getList() {
        ProductService productService = (ProductService) context.getBean("productService");

        return productService.getList();
    }

    public static Product getInfo(int id) {
        ProductService productService = (ProductService) context.getBean("productService");

        return productService.getInfo(id);
    }

    public static List<Product> getListByType(byte type) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.getListByType(type);
    }

    public static int updateStatus(int id, byte status){
    	ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateStatus(id,status);
    }

    public static int updateManager(int id, int emp){
    	 ProductService productService = (ProductService) context.getBean("productService");
         return productService.updateManager(id,emp);
    }

    public static int updateBasicInfo(Product product){
    	 ProductService productService = (ProductService) context.getBean("productService");
         return productService.updateBasicInfo(product);
    }

	public static int updateRemain(Product product) {
		ProductService productService = (ProductService) context.getBean("productService");
		return productService.updateRemain(product);
	}

    public static int updateStatusAndTime(Product product) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateStatusAndTime(product);
    }

	public static List<Product> getProductByTypeAndStatus(byte type, byte status) {
		ProductService productService = (ProductService) context.getBean("productService");
		return productService.getProductByTypeAndStatus(type,status);
	}

    public static List<Product> getProductListWithNoPaging(ProductCondition productCondition) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.getProductListWithNoPaging(productCondition);
    }

	public static int updateReRemain(Product product) {
		ProductService productService = (ProductService) context.getBean("productService");
		return productService.updateReRemain(product);
	}

	public static int updateStartTime(int id, Date start) {
		ProductService productService = (ProductService) context.getBean("productService");
		return productService.updateStartTime(id,start);
	}

    public static int updateAddRemainAmountAndRemainSmall(int id, long remainAmount) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateAddRemainAmountAndRemainSmall(id,remainAmount);
    }

    public static int updateReduceRemainAmountAndRemainSmall(int id, long remainAmount) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateReduceRemainAmountAndRemainSmall(id,remainAmount);
    }

	public static List<Product> getProductListByStatus(byte statusLeft,byte statusRight) {
		ProductService productService = (ProductService) context.getBean("productService");
		return productService.getProductListByStatus(statusLeft,statusRight);
	}

    public static int updateReduceRemainAmount(int productNo, long money) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateReduceRemainAmount(productNo,money);
    }

    public static int updateAddRemainAmount(int productNo, long money) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateAddRemainAmount(productNo,money);
    }

    public static Product getInfoByActivitiNo(String activitiNo) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.getInfoByActivitiNo(activitiNo);
    }
}
