<%--
  Created by IntelliJ IDEA.
  User: ulei
  Date: 15-11-2
  Time: 下午12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="#request.accordionList" id="firstMenu">
    <s:if test="#firstMenu.level == 2">
        <div title="<s:property value="#firstMenu.name"/>" style="padding: 10px;">
            <ul class="easyui-tree">
                <s:iterator value="#request.accordionList" id="secondMenu">
                    <s:if test="#secondMenu.parentNo == #firstMenu.id">
                        <li>
                            <span><s:property value="#secondMenu.name"/></span>
                        </li>
                    </s:if>
                </s:iterator>
            </ul>
        </div>
    </s:if>
</s:iterator>
