package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.query.ProductTaskCondition;
import com.hzfh.api.sales.service.ProductTaskService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductTaskFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<ProductTask> getPagingList(ProductTaskCondition productTaskCondition) {
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");

        return  productTaskService.getPagingList(productTaskCondition);
    }

    public static int add(ProductTask productTask){
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");

        return productTaskService.add(productTask);
    }

    public static int update(ProductTask productTask){
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");

        return productTaskService.update(productTask);
    }

    public static List<ProductTask> getList(){
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");

        return productTaskService.getList();
    }

    public static ProductTask getInfo(int id){
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");

        return productTaskService.getInfo(id);
    }
    public static List<ProductTask> getListByProductNo(int productNo){
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");

        return productTaskService.getListByProductNo(productNo);
    }

    public static int updateStatus(ProductTask productTask){
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");

        return productTaskService.updateStatus(productTask);
    }

	public static int updateAmount(ProductTask productTask) {
		ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");
		
		return productTaskService.updateAmount(productTask);
	}

	public static int updateReAmount(ProductTask productTask) {
		ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");
		return productTaskService.updateReAmount(productTask);
	}

    public static int updateAddCurrentAmount(int productNo, Long currentAmount, int deptNo) {
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");
        return productTaskService.updateAddCurrentAmount(productNo,currentAmount,deptNo);
    }

    public static int updateReduceCurrentAmount(int productNo, Long currentAmount, int deptNo) {
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");
        return productTaskService.updateReduceCurrentAmount(productNo,currentAmount,deptNo);
    }
}
