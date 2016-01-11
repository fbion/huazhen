<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="tableCenter">
    <form id="productExamineAdd">
        <h5>产品上线审批表</h5>
        <table align="center" border="1" class="tc data">
            <tbody id="aduitComment">
            <tr>
                <td width="100" height="30" valign="center" >产品名称</td>
                <td valign="center" colspan="2" >
                    <input type="text" value="" id="productNo" class="productNo" style="display: none"/>
                    <input type="text" value="" style="width:680px;" id="name" class="name" disabled="disabled"/>
                </td>
            </tr>
            <tr>
                <td width="100" height="30" valign="center" >预期年化收益率%</td>
                <td valign="center" colspan="2" >
                    <textarea style="width:680px;" id="expectProfit" class="expectProfit" disabled="disabled"></textarea>
                </td>
            </tr>
            <tr>
                <td width="100" height="30" valign="center" >产品销售周期</td>
                <td valign="center" colspan="2" >
                    <input type="text" value="" id="sales_cycle"  class="data1" style="width:680px;"/>
                </td>
            </tr>
            <tr>
                <td width="100" height="30" valign="center" >产品要素、协议签署、费率、结算方式等信息的书面确认情况</td>
                <td valign="center" colspan="2" >
                    <textarea style="width:680px;" id="settlementType" class="settlementType" disabled="disabled"></textarea>
                </td>
            </tr>
            <tr>
                <td width="100" height="30" valign="center" >承销部门</td>
                <td width="350" valign="center" >机构<input type="text" value="" id="id1"  style="display: none"/></td>
                <td width="156" valign="center" >直销<input type="text" value="" id="id2"  style="display: none"/></td>
            </tr>
            <tr>
                <td width="100" height="30" valign="center" >承销额度</td>
                <td width="350" valign="center" >
                    <input type="text" value="" class="data1 task_amout1"  id="task_amout1"/>元
                    <div class="Validform_checktip"></div>
                </td>
                <td width="156" valign="center" >
                    <input type="text" value="" class="data1 task_amout2"  id="task_amout2"/>元
                    <div class="Validform_checktip"></div>
                </td>
            </tr>
            <tr>
                <td width="100" height="30" valign="center" >完成策略</td>
                <td width="350" valign="center" >
                    <textarea style="width:350px;" id="sales_policy1" class="data1 sales_policy1"></textarea>
                </td>
                <td width="156" valign="center" >
                    <textarea style="width:350px;" id="sales_policy2" class="data1 sales_policy2"></textarea>
                </td>
            </tr>
            <tr>
                <td width="100" valign="center" >服务费率</td>
                <td width="350" valign="center" >
                    <textarea style="width:350px;" id="quota1" class="data1 quota1"></textarea>
                    <div class="Validform_checktip"></div>
                </td>
                <td width="156" valign="center" >
                    <textarea style="width:350px;" id="quota2" class="data1 quota2"></textarea>
                    <div class="Validform_checktip"></div>
                </td>
            </tr>
            <tr>
                <td width="100" valign="center" >激励政策</td>
                <td width="350" valign="center" >
                    <textarea style="width:350px;" id="incentive_policy1" class="data1 incentive_policy1"></textarea>
                </td>
                <td width="156" valign="center" >
                    <textarea style="width:350px;" id="incentive_policy2" class="data1 incentive_policy2"></textarea>
                </td>
            </tr>
            </tbody>
        </table>
        <p id="btn" class="mt30">
            <s:if test="showExamineButton">
                <input id="examine"  type="button" value="审批" class="examine submit_Btn btn_style"/>
            </s:if>
            <s:if test="showExamineEditButton">
                <input type="submit" class="btn_style" value="保存" id="examine_submit"/>
                <input type="button" class="btn_style" value="修改" id="examine_edit"/>
            </s:if>
            <input type="button" class="cancel_Btn btn_style back"  value="返回" id="examine_back"/>
        </p>
    </form>
    <div class="trackBtn"></div>
</div>

<%--
<table id="productAuditComment" align="center" border="1" class="tc data mt30">
    <thead>
    <tr>
        <td width="160" valign="center" height="30">审核部门</td>
        <td width="160" valign="center">是否通过</td>
        <td width="160" valign="center">审核时间</td>
        <td width="160" valign="center">审核人</td>
    </tr>
    </thead>
</table>--%>

<div class="pic mt20 detail_pic">
    <table id="productExamineTable" class="gridTable">
    </table>
</div>
