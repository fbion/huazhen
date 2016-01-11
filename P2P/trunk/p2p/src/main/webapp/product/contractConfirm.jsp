<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
	<div class="main wrapp pb30">
	    <h3 class="contCrumbs wrapp">
	    	<a href="${homeUrl}">首页</a>><a href="${productDetailsUrl}?p2pProductId=${p2pProduct.id}">产品详情</a>>订单确认
	    </h3>
	       
	    <div class="orderConfirm wrapp">
	    	<h4>订单确认 <i></i><span>您的睿智选择一定会带来回报</span></h4>
	        
	        <em class="orderStep2 mt50"></em>
	        <ul>
	        	<li class="confirmInfo red">确认信息</li>
	            <li class="red">确认合同</li>
	            <li class="confirmPay">确认支付</li>
	            <li class="paySuccess">支付成功</li>
	        </ul>
	       	<h5>您有一份协议需要您阅读并同意：</h5>
	        <input type="text" id="p2pProductNo" hidden="hidden" value="${p2pProduct.id}">
            <input type="text" id="investmentMoney" hidden="hidden" value="${investmentMoney}">
            <input type="text" id="contractNo" hidden="hidden"  value="${contractNo}">
	        <div class="agreeContent">
	            <p id="contract">${p2pProduct.contract}</p>
	        </div>
	        <p class="agreement mt20 " >
	           <input type="checkbox" id="checkbox">
	           <span>我已阅读并同意《${p2pProduct.name}投资管理协议》的协议内容。</span>
	        </p>
	        <p class="mt50">
	        	<input id="next" type="button" value="下一步" class=" orderNext next_step btnStyle mt30">
	        </p>
	    </div>
	</div>
	</m:Content>
</m:ContentPage>