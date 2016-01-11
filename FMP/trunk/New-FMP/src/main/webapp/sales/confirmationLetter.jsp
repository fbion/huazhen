<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/8/24
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    ${pageHead}
    <title></title>
    <script>
        $(function () {
            $("#title").attr("src",$Url.BuildImgUrl("/picv.jpg"));
        });
    </script>
</head>
<body>
<!--债权明细确认及受让确认函-->
<div class="confirLetter_cont">
	<img id="title" src="" width="216" height="40">
    <p class="tr fb borderTop fw">债权编号：<s:property value="creditorNo"/></p>
    <h2 class="mt40 tc fw">债权明细及受让确认函</h2>
    <h3 class="mt30 fw">尊敬的<span><s:property value="saleInfo.customerName"/></span>先生/女士,您好：</h3>
    <p class="textIndent mt15">现房宝财富管理中心很高兴通知您，经过您与债权转让人（借款人）及债务人的协商，债权转让人已成功将其对债务人拥有的合法、有效、确定的债权转让给您，现该中心为您提供债权转让及受让明细：</p>
	<ul class="mt30">
    	<li>甲方（债权转让人）：<span>高明</span></li>
        <li>乙方（债权受让人）：<span><s:property value="saleInfo.customerName"/></span></li>
    </ul>
    <ul>
    	<li>身份证（护照）号码：<span>130203198204171537</span></li>
        <li>身份证（护照）号码：<span><s:property value="IDCard"/></span></li>
    </ul>
    <h4 class="mt20">一、该笔债权基本信息如下：</h4>
    <table border="1" class="mt30">
      <tr>
        <td width="92" align="center" valign="center" >出借编号</td>
        <td width="58" align="center" valign="center" >资金出<br/>借及回<br/>收方式</td>
        <td width="64" align="center" valign="center" >出借<br/>期限<br />(天)</td>
        <td width="85" align="center" valign="center" >初始出借<br/>日期</td>
        <td width="85" align="center" valign="center" >初始出借<br/>金额(元)</td>
        <td width="58" align="center" valign="center" >预期年<br/>化收益<br/>(%)</td>
        <td width="75" align="center" valign="center" >债权转让<br/>服务费率<br/>(%)</td>
        <td width="85" align="center" valign="center" >债权转让<br/>到期日</td>
        <td width="92" align="center" valign="center" >债权转让<br/>到期价值(元)</td>
      </tr>
      <tr><s:property value=""/>
        <td width="92" height="30" align="center" valign="center" ><s:property value="loanNumber"/></td>
        <td width="58" align="center" valign="center" >现房宝</td>
        <td width="64" align="center" valign="center" ><s:property value="day"/><s:property value="saleInfo.editComment"/></td>

        <td width="85" align="center" valign="center" ><s:date name="saleInfo.purchaseDate" format="yyyy-MM-dd"/></td>
        <td width="85" align="center" valign="center" ><s:property value="saleInfo.money"/></td>
        <td width="58" align="center" align="center" valign="center" ><s:property value="saleInfo.income"/></td>
        <td width="75" align="center" valign="center" ><s:property value="saleInfo.serviceRate"/></td>
        <td width="85" align="center" valign="center" ><s:date name="productInfo.end" format="yyyy-MM-dd"/></td>
        <td width="92" align="center" valign="center" ><s:property value="expireMoney"/></td>
      </tr>
    </table>
    <h4 class="mt20">二、该笔债权对应的承诺物明细：</h4>
    <table border="1" class="mt30">
      <tr>
        <td width="43" align="center" valign="center" >序号</td>
        <td width="54" align="center" valign="center" >借款<br/>用途</td>
        <td width="135" align="center" valign="center" >借款人</td>
        <td width="179" align="center" valign="center" >预售许可证号/他项权证号</td>
        <td width="87" align="center" valign="center" >借款总金额(元)</td>
        <td width="87" align="center" valign="center" >债权编号</td>
        <td width="95" align="center" valign="center" >本次债权<br/>转让价值(元)</td>
      </tr>
      <tr>
        <td width="43" height="30" align="center" valign="center" >1</td>
        <td width="54" align="center" valign="center" >经营</td>
        <td width="135" align="center" valign="center" ><s:property value="loanName"/></td>
        <td width="179" align="center" valign="center" ><s:property value="creditorName"/></td>
        <td width="87" align="center" valign="center" ><s:property value="totalmoney"/></td>
        <td width="87" align="center" valign="center" >HZJJ-2015-XFB-<s:property value="saleInfo.contractCode"/></td>
        <td width="95" align="center" valign="center" ><s:property value="totalmoney"/></td>
      </tr>
    </table>
    <ul class="mt50">
    	<li>债权转让方：<span>高明</span></li>
        <li>见证人：<span>北京华镇股权投资基金管理有限公司</span></li>
    </ul>
    <ul>
    	<li>签章：<span></span></li>
        <li>签字（盖章）</li>
    </ul>
    <ul>
    	<li>日期：<span></span></li>
        <li>日期：<span></span></li>
    </ul>
    <div class="contactUs_info mt30">
    	<p class="tc f12">地址：北京市朝阳区东三环中路5号FFC大厦30层&nbsp;&nbsp;电话：010-5921 9789</p>
        <p class="tc f12">传真：010-59219766&nbsp;&nbsp;服务热线：400-0340-668&nbsp;&nbsp;公司网址：http://www.hzjkjt.com</p>
    </div>
</div>
</body>
</html>
