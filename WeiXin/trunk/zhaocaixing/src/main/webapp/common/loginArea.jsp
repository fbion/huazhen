<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="content" class="mt20">
	<form class="validform pt10 pb20" id="loginForm">
	<div>
        <dl id="login_username" class="login_iconUser">
   <%--    <input id="code" type="hidden" name="code" value="<%=request.getQueryString().substring(5,request.getQueryString().indexOf('&'))%>">
        WEIXIN <input id="" type="hidde" name="weixin" value="${weixin}">  --%> 
               
                 <dt>用户名:</dt>
            <dd>
                <input id="username" type="text" tabindex="1" placeholder="用户名/邮箱地址/手机号码"
                    value="${currentUser }" name="username" class="Validform_error">
            </dd>
        </dl>
        <div class="desc Validform_checktip absolute"></div>
      </div>
      <div>
        <dl id="login_password" class="clear login_iconPass">
            <dt>
                密<span class="ml15" style="display: inline-block">码:</span>
            </dt>
            <dd>
                <input id="pwd" type="password" name="pwd" tabindex="2"
                    placeholder="请输入登录密码">
            </dd>
        </dl>
        <div class="desc Validform_checktip absolute"></div>
       </div>
      <div>
        <dl class="input_captcha clear" id="input_captcha">
            <dt>验证码:</dt>
            <dd style="width: 230px;">
                 <input type="text" name="captcha" 
                   tabindex="4" class="captcha input"
                     id="verifyCode"  placeholder="请输入验证码"><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');">
                        <img width="68" height="28" ref1="${captchaUrl}?type=login" id="imgVerifyCode"
                             alt="请输入验证码" src="${captchaUrl}?type=login"></a><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="validator_tips">换一张</a>
            </dd>
        </dl>
        <div class="desc Validform_checktip absolute"></div>
       </div>
        <p class="loginBtn pt20 pb20">
            <input type="submit" value="登录" class="submit_btn btn">
        </p>
        <%-- <p class="pt10 pb30">
            <a href="javascript:void(0)" class="no_account">没有账号？</a>
                <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa71a6c40b8350a9e&redirect_uri=${registerUrl}&
			response_type=code&scope=snsapi_base&state=1&connect_redirect=1#wechat_redirect"
						class="no_register mr50">立即注册</a>
        </p> --%>
	</form>
</div>
