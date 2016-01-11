<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:iterator value="#request.employeeList" id="item">
    <div class="col-md-3">
        <p class="adviser1" style="background: url('<s:property value="#item.portraitPath"/>');"></p>
        <label class="w260 text-center pl15 normal"><input type="radio" value='<s:property value="#item.userNo"/>' name="choose_customers"><s:property value="#item.name"/></label>
    </div>
</s:iterator>	