<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="content container border-line">
            <h3>忘记密码<strong></strong></h3>

            <div class="row">
                <div class="col-md-12 mt50 text-center forget_password">
                    <p class="forget_password1"></p>
                </div>
            </div>
            <div class="row sendMail send_email">
                <form class="col-md-12 text-center create_password">
                    <p class="text-center">
                        <span>您注册时使用的邮箱：</span>
                        <input type="text" name="email" placeholder="邮箱" tabindex="2" class="uiText input" id="email">
                        <span class="Validform_checktip"></span>
                    </p>
                    <p>
                        <span class="pl100">验证码：</span><input type="text" name="captcha" tabindex="5"
                        class="validationCode" id="verifyCode"><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');"> <img width="98" height="28" ref1="${captchaUrl}?type=forget" id="imgVerifyCode"
                                 alt="请输入验证码" src="${captchaUrl}?type=forget">
                        </a><span class="Validform_checktip"></span>
                    </p>
                    <input type="submit" value="发送验证邮件" class="sendEmail mt30">
                </form>
            </div>

            <div class="row pb100 none sendSuccess">
                <div class="col-md-9 mt50 ml100 text-center registerSuccess_layer">
                    <h4 class="pb30">发送成功</h4>
                    <p class="pb100">请您点击邮件中的链接重置密码</p>
                </div>
            </div>
        </div>
    </m:Content>
</m:ContentPage>