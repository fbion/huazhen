<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<s:if test="#request.paymentMoneyWithdrawList.resultList.size>0">
    <li class="hd borderBott">
        <span class="span1">流水号</span>
        <span class="span2">创建时间</span>
        <span class="span3">状态</span>
        <!-- <th width="80">提现类型</th> -->
        <span class="span4">提现金额（元）</span>
        <!-- <th width="70">手续费（元）</th> -->
               <!--  <th width="100">实际到账金额（元）</th> -->
                <!--<th width="80">备注</th>-->
    </li>
    <s:iterator value="#request.paymentMoneyWithdrawList.resultList" var="paymentMoneyWithdraw">
	    <li class="bd borderBott">
	        <span class="span1"><s:property value="#request.paymentMoneyWithdraw.sn"/></span>                                
	        <span class="span2"><s:date name="#request.paymentMoneyWithdraw.timeCreate" format="yyyy-MM-dd HH:mm:ss"/></span>
	        <span class="span3">
   				<s:if test="#request.paymentMoneyWithdraw.state==00">提现申请登记</s:if>
                <s:if test="#request.paymentMoneyWithdraw.state==01">登记成功</s:if>
                <s:if test="#request.paymentMoneyWithdraw.state==02">登记失败</s:if>
                <s:if test="#request.paymentMoneyWithdraw.state==03">提现中</s:if>
                <s:if test="#request.paymentMoneyWithdraw.state==04">提现成功</s:if>
                <s:if test="#request.paymentMoneyWithdraw.state==05">提现失败</s:if>
            </span>
            <%-- <td><s:property value="#request.paymentMoneyWithdraw.withdrawType"/></td> --%>
	        <span class="span4"><s:property value="#request.paymentMoneyWithdraw.amount"/></span>
	        <%-- <td align="center"><s:property value="#request.paymentMoneyWithdraw.moneyFactorage"/></td> --%>
                 <%--  <td align="center"><s:property value="#request.paymentMoneyWithdraw.amount"/></td> --%>
                  <!--<td><s:property value="#request.paymentMoneyWithdraw.note"/></td>-->
	    </li>
    </s:iterator>
    <div class="myInvestment_page mt50" >
            <%@include file="/common/pageFoot.jsp"%>
    </div>
</s:if>
<s:else>
	<center>没找到记录，请重新选择查询条件。</center>
</s:else>