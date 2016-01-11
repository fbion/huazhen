<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 14-10-31
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <h2 class="mt30"><s:property value="exception"/></h2>

        <h3>详细信息</h3>
    <pre>
        <s:property value="exceptionStack"/>
    </pre>
    </m:Content>
</m:ContentPage>
