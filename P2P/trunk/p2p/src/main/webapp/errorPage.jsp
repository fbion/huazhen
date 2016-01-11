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
	        <em class="tipsPicError mt40"></em>
	        <div class="tipsInfo mt40">
            	<h4>页面不存在！</h4>
	            <h6>您收藏夹中的链接可能已过期或页面地址错误</h6>
	            <a href="${homeUrl}" class="mt30"><span id="second">5</span>秒后跳转首页</a>
	        </div>
	    </div>
	</div>
	</m:Content>
</m:ContentPage>