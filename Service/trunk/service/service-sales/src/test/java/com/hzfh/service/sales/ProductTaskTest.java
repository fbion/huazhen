package com.hzfh.service.sales;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.service.ProductTaskService;

public class ProductTaskTest {
	
	@Test
	public void updateAmount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");
		ProductTask productTask = new ProductTask();
		productTask.setProductNo(1);
		productTask.setDeptNo(1);
		productTask.setTaskAmout(200);
		int result = productTaskService.updateAmount(productTask);
		if(result > 0){
			System.out.println(result);
		}
		
		System.out.println("认购成功！");
		ProductTask productTask2 = productTaskService.getInfo(productTask.getProductNo());
		System.out.println(productTask2.getTaskAmout());
		
	}
	
	
	@Test
	public void updateReAmount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");
		ProductTask productTask = new ProductTask();
		productTask.setProductNo(1);
		productTask.setDeptNo(1);
		productTask.setTaskAmout(200);
		int result = productTaskService.updateReAmount(productTask);
		if(result > 0){
			System.out.println(result);
		}
		
		System.out.println("已退款！");
		ProductTask productTask2 = productTaskService.getInfo(productTask.getProductNo());
		System.out.println(productTask2.getTaskAmout());
	}

    @Test
    public void updateCurrentAmountTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");
        int productNo = 65;
        int deptNo = 11 ;
        long currentAmount=1000;
        int result = productTaskService.updateAddCurrentAmount(productNo,currentAmount,deptNo);
//        int result = productTaskService.updateReduceCurrentAmount(productNo,currentAmount,deptNo);
        System.out.print(result);
    }
	
	
	
	
	
}
