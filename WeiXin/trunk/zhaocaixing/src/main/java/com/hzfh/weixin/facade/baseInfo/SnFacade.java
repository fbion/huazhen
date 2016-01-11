package com.hzfh.weixin.facade.baseInfo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.baseInfo.model.Sn;
import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.baseInfo.model.query.SnCondition;
import com.hzfh.api.baseInfo.service.SnService;
import com.hzframework.contract.PagedList;


public class SnFacade {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

	public static PagedList<Sn> getPagingList(SnCondition snCondition) {
		SnService snService = (SnService) context.getBean("snService");

		return snService.getPagingList(snCondition);
	}

	public static int add(Sn sn) {
		SnService snService = (SnService) context.getBean("snService");

		return snService.add(sn);
	}

	public static int update(Sn sn) {
		SnService snService = (SnService) context.getBean("snService");

		return snService.update(sn);
	}

	public static List<Sn> getList() {
		SnService snService = (SnService) context.getBean("snService");

		return snService.getList();
	}

	public static Sn getInfo(int id) {
		SnService snService = (SnService) context.getBean("snService");

		return snService.getInfo(id);
	}

	public static void truncateSn() {
		SnService snService = (SnService) context.getBean("snService");
		snService.truncateSn();
	}
	
	public static String getSn(SnEnum snEnum) {
		SnService snService = (SnService) context.getBean("snService");
		return snService.getSn(snEnum);
	}

//	public static String getSnHelper(SnEnum snEnum) {
//		SnService snService = (SnService) context.getBean("snService");
//		return snService.getSnHelper(snEnum);
//	}
	
	
	
}
