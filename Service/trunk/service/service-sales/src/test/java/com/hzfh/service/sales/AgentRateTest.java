package com.hzfh.service.sales;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzfh.api.sales.service.AgentRateService;
import com.hzframework.helper.StringHelper;

public class AgentRateTest {
	@Test
	public void add(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AgentRateService agentService =(AgentRateService) context.getBean("agentRateService");
		AgentRate agentRate = new AgentRate();
		agentRate.setAgentNo(1);
		agentRate.setAgentType((byte) 1);
		agentRate.setProductNo(1);
		agentRate.setProductType((byte) 1);
		int id=agentService.add(agentRate);
		System.out.println(id);
	}
	
	
	@Test
	public void getAgentRate() throws MalformedURLException{
		/*String url = "http://192.168.1.232:8080/service-sales/agentRate";
        HessianProxyFactory factory = new HessianProxyFactory();
        AgentRateService agentService = (AgentRateService) factory.create(AgentRateService.class, url);*/
        ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AgentRateService agentService =(AgentRateService) context.getBean("agentRateService");
		AgentRate agentRate = new AgentRate();
		agentRate.setProductNo(12);
		agentRate.setAgentType((byte) 1);
		agentRate.setAgentNo(1);
		int money = 100;
		
		AgentRate result=agentService.getAgentRate(agentRate,money);
		System.out.println(result.getRate());
	}
	
	/*@Test
	public void getListByProductNo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");
		List<AgentRate> agentRateList = agentRateService.getListByProductNo(12);
		for(AgentRate agentRate:agentRateList){
			System.out.println(agentRate.getRate());
		}
	}*/
    @Test
    public void delete(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");
       int delete = agentRateService.delete(20);
        System.out.print(delete);
    }

    @Test
    public void getAgentBusinessListByConditionTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgentRateService agentRateService = (AgentRateService) context.getBean("agentRateService");
        AgentRateCondition agentRateCondition = new AgentRateCondition();
        agentRateCondition.setProduct(175);
        agentRateCondition.setAgentType(3);
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        agentRateCondition.setAgentAllString(StringHelper.listToString(list));
        List<AgentRate> agentRateList = agentRateService.getAgentRateListByCondition(agentRateCondition);
        System.out.print(agentRateList.size());
    }
	
}
