package com.hzfh.fmp.facade.permission;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.ElementCondition;
import com.hzfh.api.permission.service.ElementService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ElementFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-permission.xml");

    public static PagedList<Element> getPagingList(ElementCondition elementCondition) {
        ElementService elementService = (ElementService) context.getBean("elementService");

        return  elementService.getPagingList(elementCondition);
    }

    public static int add(Element element){
        ElementService elementService = (ElementService) context.getBean("elementService");

        return elementService.add(element);
    }

    public static int update(Element element){
        ElementService elementService = (ElementService) context.getBean("elementService");

        return elementService.update(element);
    }

    public static List<Element> getList(){
        ElementService elementService = (ElementService) context.getBean("elementService");

        return elementService.getList();
    }

    public static Element getInfo(int id){
        ElementService elementService = (ElementService) context.getBean("elementService");

        return elementService.getInfo(id);
    }

	public static Element getRoot() {
		ElementService elementService = (ElementService) context.getBean("elementService");
		return elementService.getRoot();
	}

	public static List<Element> getChildNodes(int id) {
		ElementService elementService = (ElementService) context.getBean("elementService");
		return elementService.getChildNodes(id);
	}

	public static int delete(int elementId) {
		ElementService elementService = (ElementService) context.getBean("elementService");
		return elementService.delete(elementId);
	}

	public static Element getElementByAlias(String alias) {
		ElementService elementService = (ElementService) context.getBean("elementService");
		return elementService.getElementByAlias(alias);
	}

	public static List<Element> get1stLevelMenuList() {
		ElementService elementService = (ElementService) context.getBean("elementService");
		return elementService.get1stLevelMenuList();
	}

    public static List<Element> getMenuListByLevel(int level,int elementId) {
        ElementService elementService = (ElementService) context.getBean("elementService");
        return elementService.getMenuListByLevel(level,elementId);
    }
}
