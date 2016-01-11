<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 14-10-31
  Time: 下午7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>


<m:MasterPage id="layout">
	<!DOCTYPE html>
	<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="keywords" content="现房宝,华镇社区金融,华镇金融控股集团,互联网金融资产交易,华镇金融社区,P2P华镇,华镇p2p,社区金融,华镇现房宝,现房宝微信公众平台,我爱投资" /> 
<meta name="description" content="华镇社区金融，是华镇金融控股集团下属的创新金融业务，华镇互联网金融平台拥有大数据优势资源，多年来在金融行业形成了成熟、完善的线上线下相结合的服务体系。通过专业的投资管理团队联合精干的IT技术团队，运用先进的信息网络技术，倾力打造了集“互联网金融资产交易”和“走入社区全方位贴身服务”于一体的金融创新服务平台。" />
<title>${title}</title> ${pageHead}

</head>
<body>
	<header>
		<div id="header">
			<h2>
				<a href="${homeUrl}"><img id="logo" src="${logoUrl}" width='92'
					height='30' /><span>华镇社区金融
					</span>
				</a>
			</h2>
			<div class="login_register">
				<s:if test="showLoginUrl">
				<a href="${loginUrl}" class="login">登录</a>|<a id="link" href="${registerUrl}"
						class="register">注册</a>
				</s:if>
				<s:else>
					<s:if test="currentUser.length"></s:if>
					<%-- <a href="${personalInfoUrl}"><s:property value="%{currentUser.substring(0,3)}" />...您好!</a> --%>
					<a href="${personalInfoUrl}">${currentUser}</a>
                        |<a href="${logoutUrl}" class="pl5">注销</a>
				</s:else>
			</div>
			 
		</div>
		<p class="header_tips">您身边的理财专家</p>
	</header>

	<m:ContentPlaceHolder id="center" />

	<footer>
		<div id="footer">
			<p>
				<a href="${personalInfoUrl}">个人信息</a> 
				 <a href="${reservationUrl}">预约投资</a> 
				<%--<a href="${investmentUrl}">我的投资</a>  --%>
			    <a href="${myInvite}">我的邀请</a> 
				<a href="${storeUrl}">联系我们</a> 
				<a href="${productFeaturesUrl}?name=introduce">关于我们</a> 
			</p>
			<p>	<span>客服热线：400-0340-668</span>
			</p>
			<div class="copyRight">
		    	<p>Copyright © 2015 华镇社区金融&nbsp;&nbsp;版权所有 <a rel="nofollow" href="http://www.miitbeian.gov.cn" style="color:#646464" target="_blank">京ICP备14022276号-1</a></p>
		    </div>
		</div>
	</footer>

</body>
	</html>
</m:MasterPage>