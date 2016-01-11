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
    <!--资金出借情况报告-->
    <div class="confirLetter_cont2">
        <img id="title" src="" width="216" height="40">
        <p class="tr fb borderTop fw">
        <h2 class="mt40 tc fw">收款确认书</h2>
        <h3 class="mt30 fw mtf">尊敬的
            <span><s:property value="saleInfo.customerName" /></span>先生/女士，您好：
        </h3>
        <p class="textIndent mt15 spanofp">本人确认于
            <span><s:property value="purchaseDate" /></span>收到您支付到本人委托并授权乙方指定的代收账户；
        </p>
        <p class="spanofp">开户行：
            <span><s:property value="saleInfo.bankAddress" /></span>
        </p>
        <p class="spanofp">账　号：
            <span><s:property value="accountNumber" /></span>
            用于购买本人债权的款项共计人民币<span><s:property value="capitalMoney" /></span>（RMB
            <span>¥<s:property value="saleInfo.money" /></span>）
        </p>
        <p class="spanofp">以上款项总计人民币
            <span><s:property value="capitalMoney" /></span>（RMB
            <span>¥<s:property value="saleInfo.money" /></span>）特此确认！
        </p>
	    <%--<br/><br/><br/><br/><br/><br/><br/><br/>--%>
        <div class="copyrightlf">
            <div class="copyleft">
                <ul>
                    <li>债权转让方：<span>高明</span></li>
                    <li>签章：<span></span></li>
                    <li>日期：<span></span></li>
                </ul>
            </div>
            <div class="copyright">
                <ul>
                    <li>见证人：<span>北京华镇股权投资基金管理有限公司</span></li>
                    <li class="signdate">签字（盖章）</li>
                    <li class="signdate">日期：<span></span></li>
                </ul>
            </div>
    	</div>

        <!--<ul class="mt200">
    	    <li class="mtname">债权转让方：<span>高明</span></li>
            <li>见证人：<span>北京华镇股权投资基金管理有限公司</span></li>
        </ul>
        <ul>
    	    <li>签章：<span></span></li>
            <li>签字（盖章）</li>
        </ul>
        <ul>
    	    <li>日期：<span></span></li>
            <li>日期：<span></span></li>
        </ul>!-->

        <div class="contactUs_info mt30">
            <p class="tc f12">地址：北京市朝阳区东三环中路5号FFC大厦30层&nbsp;&nbsp;电话：010-5921 9789</p>
            <p class="tc f12">传真：010-59219766&nbsp;&nbsp;服务热线：400-0340-668&nbsp;&nbsp;公司网址：http://www.hzjkjt.com</p>
        </div>
</div>
</body>
</html>
