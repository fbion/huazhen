<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
<div class="content container border-line">
    <h3>邮箱验证<strong></strong></h3>
    <s:if test="showIsActivate">
     <div class="row">
        <div class="col-md-12 ml50 mt50 registerSuccess">
        	<p class="pb5">恭喜账号激活成功</p>
            <span>感谢您注册华镇新金融，我们将尽心为您提供更好的服务</span>
        </div>
     </div>
     <div class="row pb100">
     	<div class="col-md-3"></div>
     	<div class="col-md-6 mt50 text-center registerSuccess_layer">
        	<h4 class="pb30">账号激活成功</h4>
            <p class="pb100">您的账号已经可以正常使用,请先<a href="${loginUrl}">登录</a></p>
        </div>
        <div class="col-md-3"></div>
     </div>
    </s:if>
    <s:else>
        <div class="row">
            <div class="col-md-12 ml50 mt50 registerSuccess">
                <p class="pb5">恭喜注册成功</p>
                <span>感谢您注册华镇新金融，我们将尽心为您提供更好的服务</span>
            </div>
        </div>
        <div class="row pb100">
            <div class="col-md-6 mt50 text-center registerSuccess_layer">
                <h4 class="pb30">账号未能激活</h4>
                <p class="pb100">可能是您的链接已经过期，请重新<a id="resend" href="javascript:void(0)">发送</a>验证邮件</p>
            </div>
        </div>
    </s:else>
</div>
  </m:Content>
</m:ContentPage>