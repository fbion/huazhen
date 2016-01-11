<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<span class="paymenttitle"><s:property value="title"/>明细表</span>

<table border="1" class="mt30 paymentdetailstab">
    <thead>
     <tr>
    <th width="100">编号</th>
    <th width="160">客户姓名</th>
    <th width="100">产品名称</th>
    <th width="100">年利率</th>
    <th width="100">投资日期</th>

    <th width="100">到期日期</th>
    <th width="100">投资金额</th>
    <th width="100">收益</th>
    <th width="140">本次支付金额</th>
    <th width="200">本次回款日期</th>

    <th width="170">银行账号</th>
    <th width="100">开户行</th>
    <th width="250">分公司（部门）</th>
    <th width="120">负责人</th>
    <s:if test="showCardNumberAndCellphone">
        <th width="120">身份证号码</th>
        <th width="100">联系方式</th>
    </s:if>
     </tr>
    </thead>
    <tbody>
    <s:iterator value="#request.paymentReportDeatilList" var="paymentReportDeatil" status='st'>
        <tr>
            <td width="100"><s:property value='#st.index+1'/> </td>
            <td width="100"><s:property value="#paymentReportDeatil.customerName" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.productName" /></td>
            <td width="80"><s:property value="#paymentReportDeatil.income" /></td>
            <td width="200"><s:date name="#paymentReportDeatil.purchaseDate" format="yyyy-MM-dd"/></td>
            <td width="200"><s:date name="#paymentReportDeatil.repaymentDate" format="yyyy-MM-dd"/></td>
            <td width="80"><s:property value="#paymentReportDeatil.salesMoney" /></td>
            <td width="60"><s:property value="#paymentReportDeatil.interest" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.payMoney" /></td>
            <td width="150"><s:date name="#paymentReportDeatil.payDate" format="yyyy-MM-dd"/></td>
            <td width="150"><s:property value="#paymentReportDeatil.accountNumber" /></td>
            <td width="300"><s:property value="#paymentReportDeatil.bankAddress" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.deptName" /></td>
            <td width="100"><s:property value="#paymentReportDeatil.empName" /></td>
            <s:if test="showCardNumberAndCellphone">
                <td width="180"><s:property value="#paymentReportDeatil.cardNumber" /></td>
                <td width="100"><s:property value="#paymentReportDeatil.cellphone" /></td>
            </s:if>
        </tr>
    </s:iterator>
    <tr>
        <td colspan="17" class="aggregate"><s:property value="title"/>总计：<span class="paymentmoney"><s:property value="totalPayMoney"/>元</span>
        </td>
     </tr>
    <!--<tr>
         <td colspan="3">制表人</td>
         <td colspan="14" class="adopt"> 
            <textarea name="" id="" colspan="14">通过：</textarea>
            <div class="signedby">签字：<input type="text" id="checkName2" readonly="readonly" value="何鑫">时间：<input type="text" id="checkTime2" readonly="readonly" value="2015-12-03 16:10:2" style="width: 200px;"></div>            
        </td> 
     </tr>
     <tr>
         <td colspan="3">复核人</td>
         <td colspan="14" class="adopt"> 
            <textarea name="" id="" colspan="14">通过：</textarea>
            <div class="signedby">签字：<input type="text" id="checkName2" readonly="readonly" value="何鑫">时间：<input type="text" id="checkTime2" readonly="readonly" value="2015-12-03 16:10:2" style="width: 200px;"></div>            
        </td> 
     </tr>
     <tr>
         <td colspan="3">部门负责人</td>
         <td colspan="14" class="adopt"> 
            <textarea name="" id="" colspan="14">通过：</textarea>
            <div class="signedby">签字：<input type="text" id="checkName2" readonly="readonly" value="何鑫">时间：<input type="text" id="checkTime2" readonly="readonly" value="2015-12-03 16:10:2" style="width: 200px;"></div>            
        </td> 
     </tr>
     <tr>
         <td colspan="3">总裁</td>
         <td colspan="14" class="adopt"> 
            <textarea name="" id="" colspan="14">通过：</textarea>
            <div class="signedby">签字：<input type="text" id="checkName2" readonly="readonly" value="何鑫">时间：<input type="text" id="checkTime2" readonly="readonly" value="2015-12-03 16:10:2" style="width: 200px;"></div>            
        </td> 
     </tr>-->
    </tbody>
</table>
