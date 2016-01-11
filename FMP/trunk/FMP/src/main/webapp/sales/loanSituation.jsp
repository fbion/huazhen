<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/8/24
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    ${pageHead }
    <%-- <link rel="stylesheet" type="text/css" href="http://webresource.hzfh.dev/css/base.css">
    <link rel="stylesheet" type="text/css" href="http://webresource.hzfh.dev/css/common.css">
    <link rel="stylesheet" type="text/css" href="http://webresource.hzfh.dev/css/page.css">
    <script type="text/javascript" src="http://webresource.hzfh.dev/js/jquery-1.11.1.min.js"></script> --%>
    <%-- <script type="text/javascript" src="../../js/sales/loanSituation.js"></script> --%>
    <title></title>
</head>
<body>
<!--资金出借情况报告-->
<div class="confirLetter_cont">
    <img id="title" src="" width="216" height="40">
    <p class="tr fb borderTop fw">债权编号：HZJJ-2015-XFB-<s:property value="saleInfo.contractCode"/></p>
    <h2 class="mt40 tc fw">资金出借情况报告</h2>
    <h3 class="mt30 fw">尊敬的<span><s:property value="saleInfo.customerName"/></span>先生/女士，您好：</h3>
    <p class="textIndent mt15">感谢您选择北京华镇股权投资基金管理有限公司的咨询服务，参考我司的推荐进行资金的出借增值，您目前出借的款项所产生的收益情况如下：</p>

	<table border="1" class="mt10" width="100%">
      <tr>
        <td width="101" height="26" align="center" valign="center" >报告周期</td>
        <td width="466" align="center" valign="center" colspan="4" ><s:property value="purchDate"/>至<s:property value="endDate"/></td>
      </tr>
      <tr>
        <td width="101" height="26" valign="center" class="pl10" >出借编号</td>
        <td width="125" align="center" valign="center" id="purchDateTemp" ><s:property value="purchDate"/><s:property value="saleInfo.contractCode"/></td>
        <td width="139" valign="center" class="pl10" >出借方式</td>
        <td width="103" align="center" valign="center" >现房宝（天）</td>
        <td width="97" align="center" valign="center" ><s:property value="pieriod"/></td>
      </tr>
      <tr>
        <td width="101" height="26" valign="center" class="pl10" >出借金额</td>
        <td width="125" id="salesMoneyTd" align="center" valign="center" ><s:property value="paymentRefund.salesMoney"/></td>
        <td width="139" valign="center" class="pl10" >年化收益率</td>
        <td width="201" id="incomeTd" align="center" valign="center" colspan="2" ><s:property value="saleInfo.income"/></td>
      </tr>
      <tr>
        <td width="101" height="26" valign="center" class="pl10" >实际收益</td>
        <td width="125" align="center" valign="center" ><s:property value="profit"/></td>
        <td width="139" valign="center" class="pl10" >到期日资产总额</td>
        <td width="201" align="center" valign="center" colspan="2" id="sumprofits"><s:property value="sumprofit"/></td>
      </tr>
    </table>
    <h4 class="mt10">您目前的每笔出借款项实际回收情况及出借收益如下：</h4>
    <table border="1" class="mt10" width="100%" height="auto" id="tableDitales">
      <tr >
        <td width="142" height="26" align="center" valign="center" >报告日</td>
        <td width="142" align="center" valign="center" >本月收益</td>
        <td width="142" align="center" valign="center" >报告日净收益</td>
        <td width="142" align="center" valign="center" >报告日资产总额</td>
      </tr>
      <s:if test="#request.productInfo.repaymentIssue==1">
      	<s:iterator value="#request.paymentRefundList" var="item">
      		<s:if test="#item.isUse==0">
	      		<tr id="tr" class="trDitales">
	        		<td width="142" id="td1" height="26" align="center" valign="center" >20<s:property value="#item.actualPayTime" /></td>
	        		<td width="142" id="td2" align="center" valign="center" ><s:property value="#item.interest" /></td>
	        		<td width="142" id="td3" align="center" valign="center" ><s:property value="#item." /></td>
	        		<td width="142" id="td4" align="center" valign="center" ><s:property value="#item.payMoney" /></td>
	      		</tr>
      		</s:if>
      	</s:iterator>	
      </s:if>
      <s:else>
      	<s:iterator value="#request.paymentRefundList" var="item">
      		<tr id="tr" class="trDitales">
        		<td width="142" id="td1" height="26" align="center" valign="center" >20<s:property value="#item.actualPayTime" /></td>
        		<td width="142" id="td2" align="center" valign="center" ><s:property value="#item.interest" /></td>
        		<td width="142" id="td3" align="center" valign="center" ><s:property value="#item." /></td>
        		<td width="142" id="td4" align="center" valign="center" ><s:property value="#item.payMoney" /></td>
      		</tr>
      	</s:iterator>	
      </s:else>
    </table>
    <p class="mt15">北京华镇股权投资基金管理有限公司竭诚为您提供最优质、高效的服务，如有任何问题请联系我司为您指定的客户服务人员。</p>
    <p>服务热线：400-0340-668</p>
    <p class="tr mt20 fw">北京华镇股权投资基金管理有限公司</p>
    <p class="tr fw" style="width:90%">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</p>
    <div class="contactUs_info mt30">
        <p class="tc f12">地址：北京市朝阳区东三环中路5号FFC大厦30层&nbsp;&nbsp;电话：010-5921 9789</p>
        <p class="tc f12">传真：010-59219766&nbsp;&nbsp;服务热线：400-0340-668&nbsp;&nbsp;公司网址：http://www.hzjkjt.com</p>
    </div>
</div>
</body>
</html>