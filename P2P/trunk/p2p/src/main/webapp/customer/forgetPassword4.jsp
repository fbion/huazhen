<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
	<div class="main pt30">
		<div class="fogetPaw wrapp">
	    	<div class="idStep2"></div>
	        <ul class="idStepTit pb50">
	        	<li class="idStepTit1 red">验证身份</li>
	            <li class="idStepTit2 red">重置登录密码</li>
	            <li class="idStepTit3">完成</li>
	        </ul>
	        <span id="msg">
	        <h4 class="borderBott">您正在使用邮箱验证身份</h4>
	        <h5 class="mt40">重置密码邮件已发送至您的邮箱：<span>${email}</span></h5>
	        </span>
	    </div>
	    <%-- <input id="customerInfo"  type="hidden" value="${ci}"/>
		<input id="customerNo"  type="hidden" value="${cn}"/>
		<input id="t"  type="hidden" value="${t}"/> --%>
	</div>
    </m:Content>
</m:ContentPage>