package com.hzfh.weixin.controller.baseInfo.ajax;

import java.util.ArrayList;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.api.sales.service.SalesService;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzfh.weixin.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AjaxProvinceActionTest {

	@Test
	public void test() {
		System.out.println("=======AjaxProvinceAction==========");
		String cardNumber="510723199007195415";
		P2pCustomer customerPersonal =  P2pCustomerModel.getP2pCustomerByCardNubmer("1");
		
		System.out.println(customerPersonal.getId());
		
	}
	
}
