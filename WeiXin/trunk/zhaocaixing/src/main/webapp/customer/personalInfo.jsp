<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
    <m:Content contentPlaceHolderId="customerCenter">
        <div id="content" class="mt20">
			<form class="validform pt10 pb20">
	            <span id="returnUrl" hidden="hidden">${returnUrl}</span>
	            <span id="provinceNo" hidden="hidden">${p2pCustomer.provinceNo}</span>
	            <span id="cityNo" hidden="hidden">${p2pCustomer.cityNo}</span>
	            <span id="districtNo" hidden="hidden">${p2pCustomer.districtNo}</span>
				<dl class="idCard">
	            	<dt>身份证号:</dt>
	                <dd><input type="text" id="cardNumber" value="${p2pCustomer.cardNumber}" placeholder="请输入身份证号" datatype="idcard" nullmsg="请填写信息！" errormsg="请输入正确的身份证号！" sucmsg=" " class="Validform_error"></dd>
	            </dl>
	            
	            <div class="desc Validform_checktip card"></div>
                
	            <dl class="phoneNumber">
	            	<dt>手机号码:</dt>
	                <dd><input type="text" id="cellPhone" value="${p2pCustomer.cellphone}" datatype="m" placeholder="请输入您的手机号码"  nullmsg="请填写信息！" errormsg="请输入您的手机号码！" sucmsg=" "></dd>
	            </dl>
	            <div class="desc Validform_checktip phone"></div>
	            <dl class="realName">
	            	<dt>真实姓名:</dt>
	                <dd><input type="text" id="realName" value="${p2pCustomer.realName}" datatype="/^[一-龥]{2,4}$/" placeholder="请输入真实姓名" nullmsg="请填写中文名！" errormsg="请输入2到4个中文字符！" sucmsg=" "></dd>
	            </dl>
	            
	            <div class="desc Validform_checktip name"></div>
                
	            <p class="choose_area pb20">
	                <span class="chooseArea">省：</span>
	                <select class="province">
	                </select>
	                <span class="chooseArea">市：</span>
	                <select class="city">
	                </select>
	                <span class="chooseArea">区/县：</span>
	                <select class="district">
	                </select>
	            </p>
	            <dl class="detailsAddress">
	           	  <dt>详细地址:</dt>
	                <dd>
	                <!--<input type="text" id="address" value="">-->
	                	<textarea rows="3"  id="address" cols="50">${p2pCustomer.address}</textarea><input id="cardNo" type="text" readonly="readonly" value="" type="hidden">
	                </dd>
	            </dl>
	            <span class="Validform_checktip"></span>
	            <span class="msg"></span>
	            <p class="submitInfo pb30"><input type="submit" value="提交" class="personalInfoSubmit mt10 btn"></p>
		        
		     </form>
		</div>
    </m:Content>
</m:ContentPage>