<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="tableCenter mt50">
    <table align="center" border="1" class="tc data">
        <tbody id="aduitComment">
        <tr>
            <td width="100" height="30" valign="center" >产品名称</td>
            <td valign="center" colspan="2" >
                <input type="text" value="" style="width:680px;" id="name" class="name disabled"/>
            </td>
        </tr>
        <tr>
            <td width="100" height="30" valign="center" >预期年化收益率%</td>
            <td valign="center" colspan="2" >
                <textarea style="width:680px;" id="expectProfit" class="expectProfit disabled"></textarea>
            </td>
        </tr>
        <tr>
            <td width="100" height="30" valign="center" >产品销售周期</td>
            <td valign="center" colspan="2" >
                <input type="text" value="" style="width:680px;" class="sales_cycle disabled"/>
            </td>
        </tr>
        <tr>
            <td width="100" height="30" valign="center" >承销部门</td>
            <td valign="center" colspan="2" >直销</td>
        </tr>
        <tr>
            <td width="100" height="30" valign="center" >承销额度</td>
            <td valign="center"  colspan="2" ><input type="text" value=""  class="task_amout2 disabled"/>元</td>
        </tr>
        <tr>
            <td width="100" height="30" valign="center" >完成策略</td>
            <td valign="center" colspan="2" >
                <textarea style="width:680px;" class="sales_policy2 disabled"></textarea>
            </td>
        </tr>
        <tr>
            <td width="100" valign="center" >服务费率</td>
            <td valign="center" colspan="2" >
                <textarea style="width:680px;" class="quota2 disabled"></textarea>
            </td>
        </tr>
        <tr>
            <td width="100" valign="center" >激励政策</td>
            <td valign="center" colspan="2" >
                <textarea style="width:680px;" class="incentive_policy2 disabled"></textarea>
            </td>
        </tr>
        <tr>
            <td width="100" valign="center" >当前销售</td>
            <td valign="center" colspan="2" >
                <input type="text" value="" style="width:680px;" class="disabled currAmout2"/>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<p id="btn" class="mt30">
    <input type="button" class="cancel_Btn btn_style back"  value="返回"/>
</p>