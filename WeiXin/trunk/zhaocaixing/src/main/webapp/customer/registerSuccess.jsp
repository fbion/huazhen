<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="content border-line">
            <div class="mt30 registerSuccess">
                <p class="pb5 tc pt30">恭喜注册成功</p>
                <s:if test="newRegister==1">
                	<span style="">您下次可以通过手机和验证码即可成功登录!为了您的账户安全请设置登录密码!<br>电脑登陆www.52touzi.com账户中心，安全设置中设置密码。<a href="${homeUrl}" class="tr mt10">进入首页</a></span>
                </s:if><s:else>
                	<span style="">感谢您${currentUser}注册华镇新金融，我们将尽心为您提供更好的服务！<a href="${homeUrl}" style="display: block;;" class="tr mt10">进入首页</a></span>
                </s:else>
            </div>
        </div>
    </m:Content>
</m:ContentPage>