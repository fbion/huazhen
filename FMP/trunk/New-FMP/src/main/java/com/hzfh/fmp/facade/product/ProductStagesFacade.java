package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.ProductStages;
import com.hzfh.api.product.model.query.ProductStagesCondition;
import com.hzfh.api.product.service.ProductStagesService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductStagesFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<ProductStages> getPagingList(ProductStagesCondition productStagesCondition) {
        ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");

        return  productStagesService.getPagingList(productStagesCondition);
    }

    public static int add(ProductStages productStages){
        ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");

        return productStagesService.add(productStages);
    }

    public static int update(ProductStages productStages){
        ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");

        return productStagesService.update(productStages);
    }

    public static List<ProductStages> getList(){
        ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");

        return productStagesService.getList();
    }

    public static ProductStages getInfo(int id){
        ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");

        return productStagesService.getInfo(id);
    }

	public static Integer getProductMaxStage(int product_no) {
		ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");
		return productStagesService.getProductMaxStage(product_no);
	}

	public static int getProductStageId(int product_no, int stagesNumber) {
		ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");
		return productStagesService.getProductStageId(product_no,stagesNumber);
	}
}
