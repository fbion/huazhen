<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<span id="productRecordFlag"></span>
<ul>
	<li class="hd">
	    <span class="span1">投资用户</span>
	    <span class="span2">投资金额(元)</span>
	    <span class="span3">预期年化收益率</span>
   <%-- <span class="span3">已收收益(元)</span> --%>
	    <span class="span4">投资时间</span>
	    <span class="span5">投资状态</span>
	</li>
	<s:if test="p2pProductRecordList.size>0">
		<s:iterator value="p2pProductRecordList" var="sales">
			<li class="bd">
				<span class="span1">${sales.p2pCustomerName}</span>
				<span class="span2">${sales.money}</span>
				<span class="span3">${sales.purchaseDateStr}</span>
				<span class="span4">${sales.purchaseDate}</span>
				 <span class="span5">
					<%-- <s:if test="#sales.status==1">待审核</s:if>
					<s:if test="#sales.status==2">已到账</s:if>
					<s:if test="#sales.status==3">认购成功</s:if>
					<s:if test="#sales.status==4">已退款</s:if>
					<s:if test="#sales.status==5">已取消</s:if>
					<s:if test="#sales.status==6">还款中</s:if>
					<s:if test="#sales.status==7">还款完成</s:if> --%>
					成功
				</span> 
			</li>
		</s:iterator>
	</s:if>               
</ul>
<!-- 页码 -->
<div class="productList_page mt50">
	<div class="myInvestment_page mt50">
		<div id="pagination"></div>
		<s:if test="pageIndex!=0">
			第<span class="pl5 pr5">${pageIndex}</span>页&nbsp;
			共<span class="pl5 pr5" >${pageCount}</span>页
		</s:if>
		共<span class="pl5 pr5" id="totalCount">${totalCount}</span>条记录
		<input type="hidden" id="pageIndex" value="${pageIndex}"/>
	</div>
</div>
                    
                