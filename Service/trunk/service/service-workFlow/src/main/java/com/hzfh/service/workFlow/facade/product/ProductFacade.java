package com.hzfh.service.workFlow.facade.product;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.api.product.service.ProductService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class ProductFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");

    public static Product getInfo(int id) {
        ProductService productService = (ProductService) context.getBean("productService");

        return productService.getInfo(id);
    }

    public static int updateReduceRemainAmount(int productNo, long money) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateReduceRemainAmount(productNo,money);
    }

    public static int updateStatus(int id, byte status){
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.updateStatus(id,status);
    }

    public static Product getInfoByActivitiNo(String activitiNo) {
        ProductService productService = (ProductService) context.getBean("productService");
        return productService.getInfoByActivitiNo(activitiNo);
    }

}
