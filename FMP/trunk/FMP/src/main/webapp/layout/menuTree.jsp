<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 14-11-3
  Time: 下午12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<ul class="siderbarList">
    <s:iterator value="#request.treeLists" id="root">
        <li class="mainlevel" id="mainlevel_01"><a class="" href="javascript:;"><s:property value="#root.name"/></a>
            <div class="main_ul">
                <ul class="sub_nav_01">
                    <s:iterator value="#root.treeItems" id="item">
                        <li class="tc"><a class="action" href="<s:property value="#item.url"/>?navSub=<s:property value="#item.name" />"><s:property value="#item.name" /></a></li>
                    </s:iterator>
                </ul>
            </div>
        </li>
    </s:iterator>

    <%--<s:iterator value="#request.treeLists" id="root">
        <li class="mainlevel">
            <p class="borderBott">
                <i onclick="SwitchTab.SwitchTab();"></i>
                <a class="" href="javascript:void(0);"><s:property value="#root.name"/></a>
            </p>
            <div class="main_ul">
                <ul class="sub_nav_01">
                    <s:iterator value="#root.treeItems" id="item">
                        <li class="tc"><a class="action" href="<s:property value="#item.url"/>?navSub=<s:property value="#item.name" />"><s:property value="#item.name" /></a></li>
                    </s:iterator>
                </ul>
            </div>
        </li>
    </s:iterator>--%>
</ul>

