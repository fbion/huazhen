<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>		
<s:if test="#request.paymentMoneyRechargeList.resultList.size>0">
    <li class="hd borderBott">
        <span class="span1">流水号</span>
        <span class="span2">创建时间</span>
        <span class="span3">状态</span>
        <!-- <th width="80">充值方式</th> -->
        <span class="span4">充值金额（元）</span>
        <!-- <th width="70">手续费（元）</th> -->
                <!-- <th width="100">实际到账金额（元）</th> -->
                <!--<th width="80">备注</th>-->
    </li>
    <s:iterator value="#request.paymentMoneyRechargeList.resultList" var="paymentMoneyRecharge">
	    <li class="bd borderBott">
	        <span class="span1"><s:property value="#request.paymentMoneyRecharge.sn"/></span>                                
	        <span class="span2"><s:date name="#request.paymentMoneyRecharge.timeCreate" format="yyyy-MM-dd HH:mm:ss"/></span>
	        <span class="span3"><s:if test="#request.paymentMoneyRecharge.state==00">充值中</s:if>
                <s:if test="#request.paymentMoneyRecharge.state==01">充值成功</s:if>
                <s:if test="#request.paymentMoneyRecharge.state==02">充值失败</s:if>
            </span>
            <%-- <td><s:property value="#request.paymentMoneyRecharge.rechargeType"/></td> --%>
	        <span class="span4"><s:property value="#request.paymentMoneyRecharge.amount"/></span>
	        <%--  <td align="center"><s:property value="#request.paymentMoneyRecharge.moneyFactorage"/></td> --%>
              <%-- <td align="center"><s:property value="#request.paymentMoneyRecharge.amount"/></td> --%>
              <!--<td><s:property value="#request.paymentMoneyRecharge.note"/></td>-->
	    </li>
    </s:iterator>                           
    <div class="myInvestment_page mt50" >
        <%@include file="/common/pageFoot.jsp"%>
    </div> 
</s:if>
<s:else>
 <center> 没找到记录，请重新选择查询条件。</center>
</s:else>

