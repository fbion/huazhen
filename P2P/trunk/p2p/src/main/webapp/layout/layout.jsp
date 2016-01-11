<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 14-10-31
  Time: 下午7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:MasterPage id="layout">
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="baidu-site-verification" content="r2TIiCA98h" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="现房宝,华镇社区金融,华镇金融控股集团,互联网金融资产交易,华镇金融社区,P2P华镇,华镇p2p,社区金融,华镇现房宝,现房宝微信公众平台,我爱投资" /> 
<meta name="description" content="华镇社区金融，是华镇金融控股集团下属的创新金融业务，华镇互联网金融平台拥有大数据优势资源，多年来在金融行业形成了成熟、完善的线上线下相结合的服务体系。通过专业的投资管理团队联合精干的IT技术团队，运用先进的信息网络技术，倾力打造了集“互联网金融资产交易”和“走入社区全方位贴身服务”于一体的金融创新服务平台。" />
<title>${title}</title>
<meta property="wb:webmaster" content="8e767e4059b0f63c" /><!-- 微博联合登录 -->
<meta property="qc:admins" content="24105705434652475216375716450" /><!-- QQ联合登录 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" href="${logoUrl}" type="image/x-icon">
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?a8103eb41778e15d9881d5f662207448";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
    ${pageHead}
</head>
<body>
<div id="top">
	<div class="topNav wrapp">
    	<span>
            <s:if test="showLoginUrl">
                <a href="${loginUrl}" class="pr5">登录</a>
				<a href="${registerUrl}" class="pl5">注册</a>
				<a href="${forgetPasswordUrl}" class="pl5">忘记密码</a>
            </s:if>
            <s:else>
                <a href="${accountUrl}">您好，${currentUser}</a>
                <a href="${logoutUrl}" class="pl5">安全退出</a>
            </s:else>
        </span>
        <ul>
        	<li>
            	<a href="${accountUrl}">我的账户</a>
            </li>
            <%-- <li>
            	<a href="${myInfoUrl}">消息</a>
            </li> --%>
            <li>
            	<a href="${helpCenterUrl}">帮助中心</a>
            </li>
            <li>
            	<a href="${contactUsUrl}" class="borderNone">联系我们</a>
            </li>
        </ul>
    </div>
</div>

<div id="header" class="wrapp" value="${pageAlias}">
	<a href="${homeUrl}" class="logo ml20"></a>
    <ul>
    	<li>
        	<a href="${homeUrl}" class="active" name='2' id="index">首页</a>
        </li>
        <%-- <li>
        	<a href="${noviceAreaUrl}" name='2' id="noviceArea">新手专区</a>
        </li> --%>
        <li>
        	<a href="${p2pProductListUrl}" name='2' id="product">财富产品</a>
        </li>
        <!-- <li>
        	<a href="#" name='2' id="finance">企业融资</a>
        </li> -->
        <li>
        	<a href="${securityAssuranceUrl}" name='2' id="security">安全保障</a>
        </li>
        <li>
        	<a href="${storeUrl}" name='2' id="storeList">旗下门店</a>
        </li>
    </ul>
</div> 
<m:ContentPlaceHolder id="center"/>

<!-- 网站底部 -->
<div id="footer">
	<div class="footerCont">
        <ul class="wrapp">
            <li class="aboutUs borderRight">
                <dl>
                    <dt>新手上路</dt>
                    <dd><a href="${registerUrl}">免费注册</a></dd>
                    <dd><a href="${knowledgeForumUrl}">知识讲堂</a></dd>
                    <dd><a href="${reservationHelpUrl}">如何投资</a></dd>
                    <dd><a href="${financingUrl}">如何融资</a></dd>
                </dl>
                <dl>
                    <dt>产品特点</dt>
                    <dd><a href="${p2pProductListUrl}">理财产品</a></dd>
                    <dd><a href="${securityAssuranceUrl}">安全保障</a></dd>
                    <dd><a href="${productSuperiorityUrl}">产品优势</a></dd>
                    <dd><a href="${lawsRegulationsUrl}">法律法规</a></dd>
                </dl>
                <dl>
                    <dt>关于我们</dt>
                    <dd><a href="${helpCenterUrl}">帮助中心</a></dd>
                    <dd><a href="${aboutCompanyUrl}">关于我们</a></dd>
                    <dd><a href="${contactUsUrl}">联系我们</a></dd>
                    <dd><a href="${mediaReportsUrl}">媒体报道</a></dd>
                </dl>
            </li>
            <li class="contact borderRight">
            	<p class="logo"></p>
            	<p>电 话：010-59219789</p>
                <p>传 真：010-59219766 </p>
                <p>邮 箱：hzjk@bestinvestor.com.cn</p>
                <p>地 址：北京市朝阳区东三环中路5号FFC大厦30层</p>
            </li>
            <li class="hotLine borderRight">
            	<p>
                	<i></i><span class="ml10">服务热线</span>
                </p>
                <em>400-0340-668</em>
                <p class="mt5 time">
                	工作日<strong class="ml15">9:00-18:00</strong>
                </p>
            </li>
            <li class="aboutWx">
            	<p></p>
                <em class="mt10">扫描二维码体验微信</em>
            </li>
        </ul>
	</div>
    <div class="copyRight">
    	<p>Copyright © 2015 华镇社区金融&nbsp;&nbsp;版权所有 <a rel="nofollow" href="http://www.miitbeian.gov.cn" style="color:#e0e0e0" target="_blank">京ICP备14022276号-1</a></p>
    </div>
</div>
    <div class="scroll" id="scroll" style="display:none;"></div>
</body>
</html>
</m:MasterPage>