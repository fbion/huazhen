<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/22
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="#request.stepList" id="item">
    <li style="width:80%;" class="ml100 pl20">
        <s:property value="#item.editTime"/>
        <span style="width:auto;display: inline-block;text-align:left" class="ml30"><s:property value="#item.editName"/></span>
        <span style="width:50px;display: inline-block;text-align:left" class="ml30"><s:property value="#item.operate"/></span>
        <s:property value="#item.comment"/>
    </li>
</s:iterator>

