package com.hzfh.fmp.model.permission;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.api.permission.model.query.RoleElementCondition;
import com.hzfh.fmp.facade.permission.ElementFacade;
import com.hzfh.fmp.facade.permission.RoleElementFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class RoleElementModel {
    public static PagedList<RoleElement> getPagingList(RoleElementCondition roleElementCondition) {
        return RoleElementFacade.getPagingList(roleElementCondition);
    }

    public static int add(RoleElement roleElement) {
        return RoleElementFacade.add(roleElement);
    }

    public static int update(RoleElement roleElement) {
        return RoleElementFacade.update(roleElement);
    }

    public static List<RoleElement> getList() {
        return RoleElementFacade.getList();
    }

    public static RoleElement getInfo(int id) {
        return RoleElementFacade.getInfo(id);
    }

    public static RoleElement getRoleElementByRoleIdAndAlias(String alias, int roleId){
        //return RoleElementFacade.getRoleElementByRoleIdAndAlias(alias,roleId);
//        RoleElement roleElement = new RoleElement();
//        roleElement.setNewItem((byte)1);
//        roleElement.setQuery((byte)1);
//        roleElement.setDel((byte)1);
//        roleElement.setEdit((byte) 1);
//        roleElement.setEleNo(1);
//        return roleElement;
    	return RoleElementFacade.getRoleElementByRoleIdAndAlias(alias,roleId);
    }
    public static List<RoleElement> getSubRoleElementsByRoleIdAndParentEleId(int parentEleId, int roleId){
        return RoleElementFacade.getSubRoleElementsByRoleIdAndParentEleId(parentEleId,roleId);
        /*RoleElement roleElement = new RoleElement();
        roleElement.setNewItem((byte)1);
        roleElement.setQuery((byte)1);
        roleElement.setDel((byte)1);
        roleElement.setEdit((byte) 1);
        roleElement.setName("recipient");
        List<RoleElement> roleElementList = new ArrayList<RoleElement>();
        roleElementList.add(roleElement);
        return roleElementList;*/
    }

	public static int delete(int id) {
		return RoleElementFacade.delete(id);
	}

	public static RoleElement getRoleElementByEleIdAndRoleId(int elementId, int roleId) {
		return RoleElementFacade.getRoleElementByEleIdAndRoleId(elementId,roleId);
	}
	
	public static String getElementTree() {
		StringBuilder xml = new StringBuilder(100);
		xml.append("<?xml version='1.0' encoding='utf-8'?> ");
		xml.append("<tree id='0'>");
		Element root = ElementFacade.getRoot();
		getElementTree(root, xml);
		xml.append("</tree>");
		System.out.println(xml);
		return xml.toString();
	}

	private static void getElementTree(Element element, StringBuilder xml) {
		xml.append("<item text='" + element.getName() + "' id='" + element.getId() + "' ");
		if(element.getParentNo()==0){
			xml.append("open='1'");
		}
		xml.append(">");
		List<Element> childNodes;
		try {
			childNodes = ElementFacade.getChildNodes(element.getId());
			if (childNodes.size()!= 0) {
				for (Element childNode : childNodes) {
					getElementTree(childNode, xml);
				}
				xml.append("</item>");
			}else{
				
				xml.append("</item>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
