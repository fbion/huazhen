package com.hzfh.fmp.model.permission;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.ElementCondition;
import com.hzfh.fmp.facade.permission.ElementFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ElementModel {
	public static PagedList<Element> getPagingList(
			ElementCondition elementCondition) {
		return ElementFacade.getPagingList(elementCondition);
	}

	public static int add(Element element) {
		return ElementFacade.add(element);
	}

	public static int update(Element element) {
		return ElementFacade.update(element);
	}

	public static List<Element> getList() {
		return ElementFacade.getList();
	}

	public static Element getInfo(int id) {
		return ElementFacade.getInfo(id);
	}

	public static String getElementTree(int id) {
		StringBuilder xml = new StringBuilder(100);
		xml.append("<?xml version='1.0' encoding='utf-8'?> ");
		xml.append("<tree id='0'>");
		Element root = ElementFacade.getRoot();
		getElementTree(root, xml,id);
		xml.append("</tree>");
		//System.out.println(xml);
		return xml.toString();
	}

	private static void getElementTree(Element element, StringBuilder xml,int id) {
		xml.append("<item text='" + element.getName() + "' id='" + element.getId() + "' ");
		
		if(element.getId()==id){
			xml.append("open='1'");
		}
		xml.append(">");
		List<Element> childNodes;
		try {
			
			childNodes = ElementFacade.getChildNodes(element.getId());
			if (childNodes.size()!= 0) {
				for (Element childNode : childNodes) {
					getElementTree(childNode, xml,id);
				}
				xml.append("</item>");
			}else{
				
				xml.append("</item>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static int delete(int elementId) {
		return ElementFacade.delete(elementId);
		
	}

	public static Element getElementByAlias(String alias) {
		
		return ElementFacade.getElementByAlias(alias);
	}

	public static List<Element> get1stLevelMenuList() {
		return ElementFacade.get1stLevelMenuList();
	}

	public static List<Element> getMenuListByLevel(int level,int elementId){
		return ElementFacade.getMenuListByLevel(level,elementId);
	}
}
