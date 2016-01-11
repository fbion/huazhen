<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<s:if test="displayType==1">
    <ul class="mt20">
        <li class="hd borderBott">
            <span class="span2">投资时间</span>
            <span class="span2">收益时间</span>
            <span class="span4">产品名称</span>
            <span class="span4">投资金额</span>
            <span class="span4">收益金额</span>
            <span class="span2">投资状态</span>
        </li>
        <s:if test="paymentRefundPagedList!=null">
        	<s:iterator value="paymentRefundPagedList.resultList" var="paymentRefund">
        		<li class="bd borderBott">
		            <span class="span2">${paymentRefund.salesTime}</span>                                
		            <span class="span2"><s:date name="#paymentRefund.payStartTime" format="yyyy-MM-dd"/></span>
		            <span class="span4">【${paymentRefund.p2pProductName}】</span>
		            <span class="span4">￥${paymentRefund.salesMoney}</span>
		            <span class="span4">￥${paymentRefund.interest}</span>
		            <span class="span2"><s:if test="#paymentRefund.status==3">已还款</s:if><s:else>还款中</s:else> </span>
		        </li>
        	</s:iterator>
        </s:if>
    </ul>
</s:if>
<s:if test="displayType==2">
    <ul class="mt20">
        <li class="hd borderBott">
            <span class="span2">投资时间</span>
            <span class="span2">收益时间</span>
            <span class="span4">产品名称</span>
            <span class="span4">投资金额</span>
            <%-- <span class="span2">剩余期限</span> --%>
            <span class="span4">收益金额</span>
            <span class="span2">投资状态</span>
        </li>
        <s:if test="paymentRefundPagedList!=null">
        	<s:iterator value="paymentRefundPagedList.resultList" var="paymentRefund">
        		<li class="bd borderBott">
		            <span class="span2">${paymentRefund.salesTime}</span>                                
		            <span class="span2"><s:date name="#paymentRefund.payStartTime" format="yyyy-MM-dd"/></span>                                
		            <span class="span4">【${paymentRefund.p2pProductName}】</span>
		            <span class="span4">￥${paymentRefund.salesMoney}</span>
		            <span class="span4">￥${paymentRefund.interest}</span>
		            <span class="span2"><s:if test="#paymentRefund.status==1">还款中</s:if></span>
		        </li>
        	</s:iterator>
        </s:if>
    </ul>
</s:if>                   
<s:if test="displayType==3"> 
    <ul class="mt20">
        <li class="hd borderBott">
            <span class="span2">投资时间</span>
            <span class="span2">结款时间</span>
            <span class="span4">产品名称</span>
            <span class="span4">应收本金</span>
            <span class="span2">投资状态</span>
        </li>
        <s:if test="salesPagedList!=null">
        	<s:iterator value="salesPagedList.resultList" var="sales">
        		<li class="bd borderBott">
		            <span class="span2">${sales.purchaseDate}</span>                                
		            <span class="span2"><s:date name="#sales.repaymentDate" format="yyyy-MM-dd"/></span>                                
		            <span class="span4">【${sales.p2pProductName}】</span>
		            <span class="span4">￥${sales.money}</span>
		           <span class="span2">
			            <%-- <s:if test="#sales.status==1">待审核</s:if>
						<s:if test="#sales.status==2">已到账</s:if> --%>
						<s:if test="#sales.status==3">还款中</s:if>
						<%-- <s:if test="#sales.status==4">已退款</s:if>
						<s:if test="#sales.status==5">已取消</s:if>
						<s:if test="#sales.status==6">还款中</s:if>
						<s:if test="#sales.status==7">还款完成</s:if> --%>
		            </span>
		        </li>
        	</s:iterator>
        </s:if>
    </ul>
</s:if>                   
<div class="myReservation_page mt50"><%@include file="/common/pageFoot.jsp"%></div>
