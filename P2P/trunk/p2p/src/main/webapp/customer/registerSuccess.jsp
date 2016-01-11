<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <input type="hidden" value="${pageAlias}" class="pageAlias" />
		<div class="p2pBanner1" value="1">
			<a href="#">
		    	<img  width="100%" height="144" />
		    </a>
		</div>
		<div class="main pb30">
		    <div class="successPage wrapp">
		        <em class="tipsPic mt40"></em>
		        <div class="tipsInfo mt40">
		        	<h4>注册成功！</h4>
		            <h5>感谢注册华镇社区金融，我们将尽心为您提供更好的服务。</h5>
		            <a href="${loginUrl}" class="mt30"><span id="second">6</span>秒后自动跳到登录页</a>
		        </div>
		    </div>
		</div>
    </m:Content>
</m:ContentPage>