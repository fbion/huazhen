<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
     <li class="hd borderBott">
    	 <span class="span2">投资产品</span>
         <span class="span8">投资时间</span>
         <span class="span6">投资金额</span>
         <span class="span9">支付方式</span>
         <span class="span8">还款方式</span>
<%--          <span class="span8">付息方式</span> --%>
         <span class="span9">投资状态</span>
         <span class="span9">理财顾问</span>
         <span class="span2">联系方式</span>
     </li>
     <s:iterator value="#request.pagedSalesList.resultList" id="item">
	     <li class="bd borderBott">
             <span class="span2 red"><s:if test="#item.status==6 and #item.paymentRefundList.size>0"><i class="on"></i></s:if><a href="${productDetailsUrl}?p2pProductId=<s:property value="#item.p2pProductNo"/>" class="red"><s:property value="#item.p2pProductName"/> </a></span>
             <span class="span8"><%-- <s:date name="#item.purchaseDate" format="yyyy-MM-dd"/> --%><s:property value="#item.purchaseDateStr"/></span>
             <span class="span6">￥<s:property value="#item.money"/></span>
             <span class="span9"><s:if test="#item.payType==0">线下</s:if><s:if test="#item.payType==1">线上</s:if>支付</span>
             <span class="span8"><s:if test="#item.paymentTypeDes!=null"><s:property value="#item.paymentTypeDes"/></s:if><s:else>未指定</s:else></span>
             <s:if test="#item.status==1 or #item.status==2 or #item.status==8 or #item.status==9" ><span class="span9">待审核</span></s:if>
             <%-- <s:if test="#item.status==3"><span class="span9">认购成功</span></s:if> --%>
             <s:if test="#item.status==4 or #item.status==5 or #item.status==0"><span class="span9">认购失败</span></s:if>
             <s:if test="#item.status==6 or #item.status==3"><span class="span9">还款中</span></s:if>
             <s:if test="#item.status==10"><span class="span9">付款中</span></s:if>
             <s:if test="#item.status==7"><span class="span9 green">已还款</span></s:if>
             <span class="span9">
	             <s:if test="#item.empName!=null and #item.empName!=''"><s:property value="#item.empName"/></s:if>
	             <s:else>无</s:else>
             </span>
             <span class="span2">
             <s:if test="#item.empCellphone!=null and #item.empCellphone!=''"><s:property value="#item.empCellphone"/></s:if>
             <s:else>无</s:else>
             </span>
             <s:if test="#item.paymentRefundList.size>0">
	             <div class="repayDetails mt40">
	             	<p>
	                 	<span>资金额：</span>
	                     <em>￥<s:property value="#item.money"/></em>
	                     <span>收益金额：</span>
	                     <em>￥<s:property value="#item.incomeMoney"/></em>
	                     <span>投资产品：</span>
	                     <em class="em1"><s:property value="#item.p2pProductName"/></em>
	                     <span>还款方式：</span>
	                     <em class="em2">按<s:property value="#item.paymentTypeDes"/>付息，到期还本</em>
	                 </p> 
	                 <dl>
	                 	 	 <dt>还款记录</dt>
	                 	 	 <s:iterator value="#item.paymentRefundList" var="paymentRefund">
			                     <dd class="borderBott1">
			                     	<span><s:date name="#paymentRefund.payEndTime" format="yyyy-MM-dd"/></span>
			                         <strong>您的第<em><s:property value="#paymentRefund.times"/></em>期还款返现金额【￥<em><s:property value="#paymentRefund.payMoney"/></em>】已经到账，请您注意查收</strong>
			                     </dd>
		                     </s:iterator>
	                     <s:else><dt>暂无还款记录</dt></s:else>
	                 </dl>
	             </div>
             </s:if>
         </li>
     </s:iterator>
	<div class="myInvestment_page mt50" >
		<div class="myInvestment_page mt50">
			<div id="pagination"></div>
			<s:if test="pageIndex!=0">
				第<span class="pl5 pr5">${pageIndex}</span>页&nbsp;
				共<span class="pl5 pr5" >${pageCount}</span>页
			</s:if>
			共<span class="pl5 pr5" id="totalCount">${totalCount}</span>条记录
		
		</div> 
	</div>
