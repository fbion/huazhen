<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>
		<li class="hd borderBott">
	    	<span class="span5">交易时间</span>
	        <span class="span2">交易类型</span>
	        <span class="span3">交易详情</span>
	        <span class="span4">交易总金额</span>
	        <span class="span8">交易状态</span>
	    </li>
	    <s:iterator value="#request.paymentMoneyChangeList.resultList" id="item">
		    <li class="bd borderBott">
		    	<span class="span5">${item.timeCreateStr}</span>
		    	<%-- <span class="span1">${item.moneyChangeType==2}</span> --%>
		    	
		    	<s:if test="#item.moneyChangeType==1"><span class="span2">充值</span><span class="span3">向账号充值${item.moneyWithdraw}元</span></s:if>
		    	<s:if test="#item.moneyChangeType==2"><span class="span2">冻结</span><span class="span3">账号冻结资金${item.moneyWithdraw}元</span></s:if>
		    	<s:if test="#item.moneyChangeType==3"><span class="span2">提现</span><span class="span3">向绑定银行卡提现${item.moneyWithdraw}元</span></s:if>
		    	<s:if test="#item.moneyChangeType==9"><span class="span2">收款</span><span class="span3">从【${item.p2pProductName}】收款${item.moneyWithdraw}元</span></s:if>
		    	<s:if test="#item.moneyChangeType==10"><span class="span2">付款</span><span class="span3">向【${item.p2pProductName}】投资${item.moneyWithdraw}元</span></s:if>
		    	<s:if test="#item.moneyChangeType==8"><span class="span2">解冻</span><span class="span3">账号解冻资金${item.moneyWithdraw}元</span></s:if>
		        <span class="span4">￥${item.moneyWithdraw}</span>
		        <span class="span8">
		        <s:if test="#item.moneyChangeType==1">充值</s:if>
		        <s:if test="#item.moneyChangeType==2">冻结</s:if>
		        <s:if test="#item.moneyChangeType==3">提现</s:if>
		        <s:if test="#item.moneyChangeType==9">收款</s:if>
		        <s:if test="#item.moneyChangeType==8">收款</s:if>
		        <s:if test="#item.moneyChangeType==10">付款</s:if>
		        </span>
		    </li>
	    </s:iterator>
	<div class="myInvestment_page mt50" >
		<%@include file="/common/pageFoot.jsp"%>
	</div> 
	<div>&nbsp</div>
                