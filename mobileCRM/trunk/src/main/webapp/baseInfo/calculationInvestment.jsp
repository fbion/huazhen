<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<!-- 视图窗口，移动端特属的标签。 -->
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
    <!-- 是否启动webapp功能，会删除默认的苹果工具栏和菜单栏。 -->
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <!-- 这个主要是根据实际的页面设计的主体色为搭配来进行设置。 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <!-- 忽略页面中的数字识别为电话号码,email识别 -->
    <meta name="format-detection"content="telephone=no, email=no" />
    <!-- 启用360浏览器的极速模式(webkit) -->
    <meta name="renderer" content="webkit">
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
    <meta name="HandheldFriendly" content="true">
    <!-- 微软的老式浏览器 -->
    <meta name="MobileOptimized" content="320">
    <!-- uc强制竖屏 -->
    <meta name="screen-orientation" content="portrait">
    <!-- QQ强制竖屏 -->
    <meta name="x5-orientation" content="portrait">
    <!-- UC强制全屏 -->
    <meta name="full-screen" content="yes">
    <!-- QQ强制全屏 -->
    <meta name="x5-fullscreen" content="true">
    <!-- UC应用模式 -->
    <meta name="browsermode" content="application">
    <!-- QQ应用模式 -->
    <meta name="x5-page-mode" content="app">
    <!-- windows phone 点击无高光 -->
    <meta name="msapplication-tap-highlight" content="no">
	${pageHead}
	<title>汽车金融计算器</title>
</head>
<body style="background-color:#fff;">
<header>
     	 <span class="carimg">
            <img src="${carHeaderUrl}">
        </span>
        </header> 
	<div id="calcontent">
	<form id="calculationInvestment" class="validform" >
	    <ul>
            <li>
                <span class="caramount">车款金额:</span>
                <span class="carmoney">
                    <span><input type="text" id="finishedAutomobile" /></span>
                    <span>元</span>
                </span>

            </li>
            <li>
                <span class="caramount">首付比例：</span>
                <span class="carmoney">
                    <span><input type="text" id="downPayment"/></span>
                    <span>%</span>
                </span>

            </li>
            <li>
                <span class="caramount">贷款利率:</span>
                <span class="carmoney">
                    <span><input type="text" id="loanRates"/></span>
                    <span>%</span>
                </span>

            </li>
            <li>
                <span class="caramount">期　　限:</span>
                <span class="carmoney">
                    <span><input type="text" id="n"/></span>
                    <span>月</span>
                </span>

            </li>
            
        </ul>
        <p class="negate Validform_checktip" id="message"></p>
        <div class="registerSubmit pt20 pb20 calcontent20">
               <input type="submit" value="开始计算" class="submit_btn btn p5"/>
        </div>
	         </form>

    <div class="terminterest">
        <ul>
            <li class="calnoborder">
                <span class="caramount">投资金额:</span>
                <span class="carmoney">
                    <span class="totalloan"><em id="x"></em></span>
                    <span class="totalmoney">元</span>
                </span>

            </li>
            <li class="calnoborder">
                <span class="caramount">定期利息：</span>
                <span class="carmoney">
                    <span class="totalloan"><em id="rente"></em></span>
                    <span class="totalmoney">元</span>
                </span>
            </li>
            <li class="calnoborder">
                <span class="caramount">总贷款利息:</span>
                <span class="carmoney">
                    <span class="totalloan"><em id="totalLoanInterest"></em></span>
                    <span class="totalmoney">元</span>
                </span>

            </li>
        </ul>
     </div>      
    </div>
</body>
</html>

