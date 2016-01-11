<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
	<div class="main pt30">
		<div class="fogetPaw wrapp">
	    	<h4>您正在为账户<span>${userName}<!-- emi****（135****7895） --></span>找回密码，请选择身份验证方式：</h4>
	        <p class="mt20 ml30">
	        	<i class="verifyStyle"></i>
	            <em class="ml15">通过邮箱验证<span id="emailCheckMsg" class="ml10"></span></em>
	            <span  id="emailCheckMsg"></span>
	            <a href="javascript:void(0)" class="btnStyle" id="emailCheck">立即验证</a>
	        </p>
	        <p class="mt10 ml30">
	        	<i class="verifyStyle1"></i>
	            <em class="ml15">通过手机验证<span id="cellphoneCheckMsg" class="ml10"></span></em>
	            <a href="javascript:void(0)" class="btnStyle" id="cellphoneCheck">立即验证</a>
	        </p>
	    </div>
		<%-- <input id="customerInfo"  type="hidden" value="${ci}"/>
		<input id="customerNo"  type="hidden" value="${cn}"/>
		<input id="t"  type="hidden" value="${t}"/> --%>
	</div>
    </m:Content>
</m:ContentPage>