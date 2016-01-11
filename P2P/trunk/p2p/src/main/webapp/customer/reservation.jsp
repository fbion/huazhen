<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
     <li class="hd borderBott">
         <span class="span1">预约产品</span>
         <span class="span6">预约时间</span>
         <span class="span6">预约金额</span>
         <span class="span2">理财顾问</span>
         <span class="span7">联系方式</span>
         <span class="span8">预约状态</span>
     </li>
     <s:iterator value="#request.p2pSubscribePagedList.resultList" id="item">
	     <li class="bd borderBott">
	     	 <span class="span1 red"><a href="${productDetailsUrl}?p2pProductId=<s:property value="#item.p2pProductNo"/>" class="red"><s:property value="#item.p2pProductName"/></a></span>
	         <span class="span6"><s:date name="#item.visitTime" format="yyyy-MM-dd"/> </span>
	         <span class="span6"><s:property value="#item.amount"/>元</span>
	         <span class="span2"><s:if test="#item.empName!=null&&#item.empName!=''">
	         <s:property value="#item.empName"/>
	         </s:if>
	         <s:else>无</s:else>
	         </span>
	         <span class="span7"><s:if test="#item.empCellphone!=null&&#item.empCellphone!=''">
	         	<s:property value="#item.empCellphone"/>
	         </s:if>
	         <s:else>无</s:else></span>
	         <s:if test="#item.status==1"><span class="span8">受理中</span></s:if><s:else><span class="span8 green">已成功</span></s:else>
	     </li>
     </s:iterator>
     
    <div class="myReservation_page mt50">
        <div class="myInvestment_page mt50">
		<div id="pagination"></div>
		<s:if test="pageIndex!=0">
			第<span class="pl5 pr5">${pageIndex}</span>页&nbsp;
			共<span class="pl5 pr5" >${pageCount}</span>页
		</s:if>
		共<span class="pl5 pr5" id="totalCount">${totalCount}</span>条记录
	</div>
    </div>
