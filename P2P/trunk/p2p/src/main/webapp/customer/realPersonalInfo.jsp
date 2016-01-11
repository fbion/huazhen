<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

        <form class="validform" id="valReal">
        	<span class="msg"></span>
            <span id="returnUrl" hidden="hidden">${returnUrl}</span>
        
        	<dl>
	        	<dt>您的姓名：</dt>
	            <dd>
	            	<input type="text" id="realName" value='${p2pCustomer.realName}'/><span class="Validform_checktip name"></span>
	            </dd>
	        </dl>
	        <dl>
	        	<dt>身份证号码：</dt>
	            <dd>
	            	<input type="text" id="cardNumber" value="${p2pCustomer.cardNumber}" /><span class="Validform_checktip card"></span>
	            </dd>
	        </dl>
	        <dl>
	        	<dt>手机验证码：</dt>
	            <dd>
	            	<input type="text" class="phoneVerify" />
	                <a href="#" class="getPhone_verify">获取手机验证码</a>
	            </dd>
	        </dl>
	        <dl class="mt10">
	        	<dt></dt>
	            <dd>
	            	<input type="button" value="保存" class="btnStyle saveBtn1" />
	            </dd>
	        </dl>
        </form>
        
        
 