package com.hzfh.service.sales;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.service.ProductTaskService;

public class ProductTest {

	@Test
	public void getListByProductNo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductTaskService productTaskService = (ProductTaskService) context.getBean("productTaskService");
		
		ProductTask productTask = new ProductTask();
        productTask.setId(2);
        productTask.setStatus((byte)2);
        productTask.setEditUserNo(4);
		productTaskService.updateStatus(productTask);
		
//		for (ProductTask productTask : productTasksList) {
//
//
//			System.out.println(
//			productTask.getId()+"=======>>"+
//			productTask.getDeptNo()+"=======>>"+
//			productTask.getProductNo()+"=======>>"+
//			productTask.getTaskAmout()+"=======>>"
//					);
//		}
		
	}
	
	
}
