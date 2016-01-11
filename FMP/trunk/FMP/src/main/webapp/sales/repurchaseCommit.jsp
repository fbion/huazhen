<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	${pageHead }
    <link rel="stylesheet" type="text/css" href="http://webresource.hzfh.dev/css/base.css">
    <link rel="stylesheet" type="text/css" href="http://webresource.hzfh.dev/css/common.css">
    <link rel="stylesheet" type="text/css" href="http://webresource.hzfh.dev/css/page.css">
    <script type="text/javascript" src="http://webresource.hzfh.dev/js/jquery-1.11.1.min.js"></script> 
    <script type="text/javascript" src="../../js/sales/loanSituation.js"></script> 
    <title></title>
</head>
<body>
    <div class="recommitment">
    	<h2>河北燕阳建筑集团有限公司债权回购承诺函</h2>
    	<p class="customername">客户姓名：
            <span><s:property value="saleInfo.customerName" /></span>（债权受让人）
        </p>
    	<p class="customername">身份证号：
            <span><s:property value="customerInfo.cardNumber" /></span>
        </p>
    	<p class="onreason">根据贵方与北京华镇股权投资基金管理有限公司
            （“现房宝”产品的理财中介服务平台）签署的《个人出借咨询与服务合同》
            （简称“原合同”）约定及《债权转让及受让确认函》中所载明的成功转让给贵方的债权。
        </p>
		<p class="arrangements">本公司特此确认如下事宜：</p>
		<p>
            1、为确保债权受让人的预期合法经济利益，当出借人的受让债权到期后，
            借款人未在约定的有效偿还期限内履行偿还义务，根据贵方在原合同第六条第6.9款中选择的风险处理方式（方案二），
            河北燕阳建筑集团有限公司无条件在5个工作日内回购《债权转让及受让确认函》
            中指定的债权，将回购款作为偿还该笔受让债权本金和收益的来源，
            并由河北燕阳建筑集团有限公司直接将回购债权所对应的本金和收益支付到债权受让人指定的银行账户。
        </p>
		<p class="arrangements1">
            2、贵方债权出借编号为：  <span><s:property value="loanNumber" /></span> ;<br/>
　　        该笔债权出借期限届满后本金及收益总额为:
            <span>￥<s:property value="expireMoney"/></span>
            （大写：<span>人民币<s:property value="capitalMoney"/></span>）。
        </p>
		<p>3、本承诺函为《个人出借咨询与服务合同》之附件，与该合同具有同等法律效力，内容若有不一致处，以本承诺函为准。</p>
		<p class="arrangements2 arrangements3">河北燕阳建筑集团有限公司（公章）</p>
		<p class="arrangements2 arrangements4"><span><s:property value="today"/></span></p>
    </div>
</body>
</html>
