<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<span><s:property value="title"/> </span>
<table border="1" class="mt30">
    <thead>
    <td width="100">编号</td>
    <td width="100">客户姓名</td>
    <td width="100">产品名称</td>
    <td width="100">年利率</td>
    <td width="100">投资日期</td>

    <td width="100">到期日期</td>
    <td width="100">投资金额</td>
    <td width="100">收益</td>
    <td width="100">本次支付金额</td>
    <td width="100">本次回款日期</td>

    <td width="100">银行账号</td>
    <td width="100">开户行</td>
    <td width="100">分公司（部门）</td>
    <td width="100">负责人</td>
    <s:if test="showCardNumberAndCellphone">
        <td width="100">身份证号码</td>
        <td width="100">联系方式</td>
    </s:if>
    <td width="100">备注</td>
    </thead>
    <tbody>
    <s:iterator value="#request.paymentReportDeatilList" var="paymentReportDeatil">
        <tr>
            <td width="100"><s:property value="#paymentReportDeatil.id" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.customerName" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.productName" /></td>
            <td width="80"><s:property value="#paymentReportDeatil.income" /></td>
            <td width="100"><s:date name="#paymentReportDeatil.purchaseDate" format="yyyy-MM-dd"/></td>
            <td width="100"><s:date name="#paymentReportDeatil.purchaseDate" format="yyyy-MM-dd"/></td>
            <td width="80"><s:property value="#paymentReportDeatil.salesMoney" /></td>
            <td width="60"><s:property value="#paymentReportDeatil.interest" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.payMoney" /></td>
            <td width="100"><s:date name="#paymentReportDeatil.payDate" format="yyyy-MM-dd"/></td>
            <td width="150"><s:property value="#paymentReportDeatil.accountNumber" /></td>
            <td width="200"><s:property value="#paymentReportDeatil.bankAddress" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.deptName" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.empName" /></td>
            <s:if test="showCardNumberAndCellphone">
                <td width="150"><s:property value="#paymentReportDeatil.cardNumber" /></td>
                <td width="100"><s:property value="#paymentReportDeatil.cellphone" /></td>
            </s:if>
            <td width="100"><s:property value="#paymentReportDeatil.editComment" /></td>
        </tr>
    </s:iterator>
    </tbody>
</table>
