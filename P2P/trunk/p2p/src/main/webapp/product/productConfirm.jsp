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
	        
	        <em class="orderStep1 mt50"></em>
	        <ul>
	        	<li class="confirmInfo red">确认信息</li>
	            <li class="">确认合同</li>
	            <li class="confirmPay">确认支付</li>
	            <li class="paySuccess">支付成功</li>
	        </ul>
	       	<h5>项目信息</h5>
	        <ul class="itemInfo">
	        	<li class="hd borderBott">
	            	<span class="span1">项目名称</span>
	                <span class="span2">投资日期</span>
	                <span class="span3">年化收益</span>
	                <span class="span4">产品结束日期</span>
	                <span class="span5">投资金额</span>
	            </li>
	            <li class="bd">
	            <input type="text" id="p2pProductNo" hidden="hidden" value="${p2pProduct.id}">
	            	<span class="span1">${p2pProduct.name}</span>
	                <span class="span2">${investTime}</span>
	                <span class="span3"><em class="red">
	                	<s:property value="p2pProduct.income"/>%
                        <s:if test="p2pProduct.floatingIncome!=0">
                            +<s:property value="p2pProduct.floatingIncome"/>%
                        </s:if>
	                </em></span>
	                <span class="span4">${productEndTime}</span>
	                <span class="span5"><em class="red">${investmentMoney}</em>元</span>
	                <input type="text" id="investmentMoney" hidden="hidden" value="${investmentMoney}">
	            </li>
	        </ul>
	        <p class="mt50">
	        <input id="next" type="button" value="下一步" class="next_step btnStyle mt30 orderNext">
	        <!-- <a href="#" class="orderNext btnStyle">下一步</a> -->
	        </p>
	    </div>
	</div>
	</m:Content>
</m:ContentPage>