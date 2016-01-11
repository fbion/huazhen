package com.hzfh.service.permission;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;
import com.hzfh.api.permission.service.MenuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class MenuTest {
	@Test
	public void getMenuTest() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		MenuService menuService=(MenuService) context.getBean("menuService");
//		MenuCondition menuCondition = new MenuCondition();
//		menuCondition.setUserNo(8);
//
//		List<Privilege> pagedList=menuService.getUserPrivilege(menuCondition);
//		for(Privilege privilege:pagedList){
//			System.out.println(privilege.getId()+","+privilege.getName()+","+privilege.getUrl()+","+privilege.getParentNo());
//		}
	}
	@Test
	public void getElementMenuTest() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MenuService menuService=(MenuService) context.getBean("menuService");
//		MenuCondition menuCondition = new MenuCondition();
//		menuCondition.setUserNo(116);
//		
//		List<Element> elementList = menuService.getUserElement(menuCondition);
//		for(Element element:elementList){
//			System.out.println(element.getId()+","+element.getName()+","+element.getValue()+","+element.getParentNo());
//		}
	}
	@Test
	public void charaTest(){
		byte[] bt=new byte[100];
		bt[0]=121;
		bt[1]=122;
		bt[2]=123;
		System.out.println(Arrays.toString(bt));
	}

	@Test
	public void getUserElementByRoleNoAndLevel() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MenuService menuService=(MenuService) context.getBean("menuService");
		List<Element> elementList = menuService.getUserElementByRoleNoAndLevel(1001,0, "1,2");
		System.out.print(elementList.size());
		for (Element element:elementList){
			System.out.println(element.getName());
		}
	}
}
