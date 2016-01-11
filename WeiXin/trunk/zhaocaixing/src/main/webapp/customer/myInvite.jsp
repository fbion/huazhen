<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
    <m:Content contentPlaceHolderId="customerCenter">
	<div id="content" class="mt20">
        <div class="shareBtn">
            <i class="icon2"></i>
            <a href="javascript:;" id="weixin">分享</a>
        </div>
        <div id="weixinlayer" style="display:none;">
            <div id="weixinlayer_cont">
            <span>分享到微信朋友圈</span>
            <a href="javascript:void(0)" id="winxinClose">×</a>
            <img id="weixinUrl" width="220" height="220">
            <p>打开微信，点击底部的“发现”，<br />使用“扫一扫”即可将网页分享至朋友圈。</p>
            </div>
        </div>
	
        <div class="reservation pb20">
            <div id="reservation"></div>
            <p class="mt30"><a class="btn" id="loadMore">查看更多</a></p>
         </div>
        <input id="tel"  type="hidden" value="${telephone}"/>
        <input type="hidden" id="pageAlias" value="${pageAlias}">   
        <input id="inviterNo"  type="hidden" value="${inviterNo}"/>
        <input id="activityId"  type="hidden" value="${activityId}"/>
	</div>
    </m:Content>
</m:ContentPage>


