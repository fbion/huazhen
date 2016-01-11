package com.hzfh.p2p.facade.product;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.api.product.service.ProductService;
import com.hzframework.contract.PagedList;

public class ProductFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static Product getInfo(int id) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.getInfo(id);
    }
    
    public static PagedList<Product> getPagingList(ProductCondition ProductCondition) {
        ProductService ProductService = (ProductService) context.getBean("productService");

        return  ProductService.getPagingList(ProductCondition);
    }

    public static int add(Product Product){
        ProductService ProductService = (ProductService) context.getBean("productService");

        return ProductService.add(Product);
    }

    public static int update(Product Product){
        ProductService ProductService = (ProductService) context.getBean("productService");

        return ProductService.update(Product);
    }

    public static List<Product> getList(){
        ProductService ProductService = (ProductService) context.getBean("productService");

        return ProductService.getList();
    }

	public static int updateReduceRemainAmount(int productNo, long money) {
		ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateReduceRemainAmount(productNo,money);
	}

}
