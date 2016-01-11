<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
    <div class="ad p2pBanner1" value="1">
		<a href="#">
	    	<img  width="100%" height="144" />
	    </a>
	</div>
    <div class="main pb30">
	    <div class="successPage wrapp">
	        <s:if test="showIsActivate"><em class="tipsPic mt40"></em></s:if>
	        <s:else><em class="tipsPicError mt40"></em></s:else>
	        <div class="tipsInfo mt40">
	        	<s:if test="showIsActivate">
	        		<h4>恭喜邮箱认证成功！</h4>
		            <h5>感谢来到华镇社区金融，我们将尽心为您提供更好的服务。</h5>
		            <a href="${paymentAccountSecurityUrl}" class="mt30"><span id="second">6</span>秒后跳转页面</a>
	            </s:if>
	            <s:else>
	            	<h4>邮箱认证失败！</h4>
		            <h5>可能是您的链接已经过期，请到安全设置页面重新发送认证邮件。</h5>
		            <a href="${paymentAccountSecurityUrl}" class="mt30"><span id="second">10</span>秒后跳转页面</a>
	            </s:else>
	        </div>
	    </div>
	</div>
	</m:Content>
</m:ContentPage>