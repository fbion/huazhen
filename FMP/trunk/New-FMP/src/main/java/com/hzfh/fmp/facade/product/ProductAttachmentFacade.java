package com.hzfh.fmp.facade.product;

import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.api.product.model.query.ProductAttachmentCondition;
import com.hzfh.api.product.service.ProductAttachmentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductAttachmentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-product.xml");

    public static PagedList<ProductAttachment> getPagingList(ProductAttachmentCondition productAttachmentCondition) {
        ProductAttachmentService productAttachmentService = (ProductAttachmentService) context.getBean("productAttachmentService");

        return  productAttachmentService.getPagingList(productAttachmentCondition);
    }

    public static int add(ProductAttachment productAttachment){
        ProductAttachmentService productAttachmentService = (ProductAttachmentService) context.getBean("productAttachmentService");

        return productAttachmentService.add(productAttachment);
    }

    public static int update(ProductAttachment productAttachment){
        ProductAttachmentService productAttachmentService = (ProductAttachmentService) context.getBean("productAttachmentService");

        return productAttachmentService.update(productAttachment);
    }

    public static List<ProductAttachment> getList(){
        ProductAttachmentService productAttachmentService = (ProductAttachmentService) context.getBean("productAttachmentService");

        return productAttachmentService.getList();
    }

    public static ProductAttachment getInfo(int id){
        ProductAttachmentService productAttachmentService = (ProductAttachmentService) context.getBean("productAttachmentService");

        return productAttachmentService.getInfo(id);
    }
    
    public static List<ProductAttachment> getListByProductNo(int productNo){
        ProductAttachmentService productAttachmentService = (ProductAttachmentService) context.getBean("productAttachmentService");

        return productAttachmentService.getListByProductNo(productNo);
    }
    public static int updateStatus(int id,byte status){
        ProductAttachmentService productAttachmentService = (ProductAttachmentService) context.getBean("productAttachmentService");

        return productAttachmentService.updateStatus(id,status);
    }
    
    
	
    
    
    
    
    
    
    
    
    
    
    
    
}
