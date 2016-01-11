package com.hzfh.fmp.controller.permission.ajax;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.ElementModel;
import com.hzfh.fmp.model.permission.RoleElementModel;
import com.hzfh.fmp.model.permission.RoleModel;

import java.util.List;


public class AjaxElementAction extends JqGridBaseAction<Element> {

    private int elementId;

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private int parentNo;


    public int getParentNo() {
        return parentNo;
    }

    public void setParentNo(int parentNo) {
        this.parentNo = parentNo;
    }

    private int priority;


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private Element elementInfo;

    public Element getElementInfo() {
        return elementInfo;
    }

    public void setElementInfo(Element elementInfo) {
        this.elementInfo = elementInfo;
    }

    private int isShow;

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public String edit() {
        //return SUCCESS;
        Element element = new Element();

        element.setName(this.name);
        element.setValue(this.value);
        element.setAlias(this.alias);
        element.setPriority(this.priority);
        element.setIsShow(this.isShow);
        element.setEditComment(this.getEditComment());
        element.setEditUserNo(UserHelper.getEditUserNo());
        element.setLevel(Byte.valueOf(this.level));
        if (this.getOper().equalsIgnoreCase("add")) {

            element.setInUserNo(UserHelper.getEditUserNo());

            element.setParentNo(this.elementId);

            int id = ElementModel.add(element);
            //Element ele = ElementModel.getElementByAlias(this.alias);
            if (id <= 0) {
                this.setErrCode("add element failed");
                this.setErrDesc("add element failed");
            } else {

                List<Role> roleList = RoleModel.getList();
                for (Role role : roleList) {

                    RoleElement roleElement = new RoleElement();
                    roleElement.setEleNo(id);
                    roleElement.setRoleNo(role.getId());
                    roleElement.setEditUserNo(UserHelper.getEditUserNo());
                    roleElement.setNewItem((byte) 0);
                    roleElement.setQuery((byte) 0);
                    roleElement.setDel((byte) 0);
                    roleElement.setEdit((byte) 0);

                    if (RoleElementModel.add(roleElement) <= 0) {
                        this.setErrCode("add roleElementfailed");
                        this.setErrDesc("add roleElement failed");
                    }
                }


            }
        } else {
            if (this.getElementId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    element.setId(elementId);
                    Element ele = ElementModel.getInfo(elementId);
                    element.setEditUserNo(UserHelper.getEditUserNo());
                    element.setParentNo(ele.getParentNo());
                    //element.setEditTime(ele.getEditTime());
                    int n;
                    try {
                        n = ElementModel.update(element);
                        if (n <= 0) {
                            this.setErrCode("update failed");
                            this.setErrDesc("update failed");
                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

        return SUCCESS;
    }


    public String delete() {
        Element element = ElementModel.getInfo(elementId);
        int n = ElementModel.delete(this.elementId);
        if (n <= 0) {
            this.setErrCode("delete element failed");
            this.setErrDesc("delete element failed");
        } else {
            List<Role> roleList = RoleModel.getList();
            for (Role role : roleList) {
                RoleElement roleElement = RoleElementModel.getRoleElementByEleIdAndRoleId(element.getId(), role.getId());
                if (RoleElementModel.delete(roleElement.getId()) <= 0) {
                    this.setErrCode("delete roleElement failed");
                    this.setErrDesc("delete roleElement failed");
                }
            }

        }
        return SUCCESS;
    }
    
   /* public String getElementTree()throws Exception{
            String xml = ElementModel.getElementTree(elementId);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/xml;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print(xml);
			return null;
    }*/

    public String getInfo() {
        Element element = ElementModel.getInfo(this.parentNo);
        element.setSwitchIsShow("否");
        if (element.getIsShow() == 1) {
            element.setSwitchIsShow("是");
        }
        this.elementInfo = element;
        return SUCCESS;
    }

    public String checkAliasExist() {

        Element element = ElementModel.getElementByAlias(alias);

        if (element != null) {
            setErrCode("已存在");
            setErrDesc("PageAlias已存在,请重新填写！");
            return SUCCESS;
        }
        return SUCCESS;
    }
}
