<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h3>
    <span>审核流程跟踪</span><i class="close">关闭</i>
</h3>
<ul class="mt20">
    <s:iterator value="#request.actHiTaskinstList" id="task" status="index">
        <s:if test="#task.description != null">
            <li>
                <i class="iconActive"></i>
                <span><s:property value="#task.assignee"/></span>
                <strong><s:property value="#task.description"/></strong>
            </li>
        </s:if>
        <s:else>
            <li>
                <i class="icon"></i>
                <span><s:property value="#task.assignee"/></span>
                <strong><s:property value="#task.description"/></strong>
            </li>
        </s:else>
        <s:if test="!#index.last">
            <li class="checkPoint">
                <p class="mt50 ml10"></p>
            </li>
        </s:if>
    </s:iterator>
</ul>