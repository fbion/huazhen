<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
<div class="content container border-line">
    <h3>忘记密码<strong></strong></h3>
    <div class="row">
        <div class="col-md-12 mt50 text-center forget_password">
        	<p class="forget_password2"></p>
        </div>
     </div>
     <div class="row pb100 mt100 pt5">
     	<div class="col-md-2"></div>
     	<form class="col-md-8 pt30 text-center create_password">
            <dl class="clear icon_pass" id="input_password">
                <dt>登录密码：</dt>
                <dd class="relative">
                    <input type="password" tabindex="3" name="pwd" class="input" id="pwd">

                    <div class="secure_box passwordStrength">
                        <div class="grey secure_title">安全程度：</div>
                        <ul class="secure_grade">
                            <li>弱</li>
                            <li class="selected">中</li>
                            <li>强</li>
                        </ul>
                        <div class="clear"></div>
                    </div>
                </dd>
                <dd>
                    <div style="display: none;" class="desc desc2 Validform_checktip"></div>
                    <div style="display: none;" class="desc desc2 info validform_format">
                        6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号
                    </div>
                </dd>
            </dl>
            <dl class="clear icon_pass mt5" id="input_password_repeat">
                <dt>密码确认：</dt>
                <dd>
                    <input type="password" name="repassword" tabindex="4" class="input" id="pwd_confirm">
                </dd>
                <dd>
                    <div style="display: none;" class="desc Validform_checktip"></div>
                    <div style="display: none;" class="desc info">请再次输入密码</div>
                </dd>
            </dl>
            <input type="submit" value="重设密码" class="createBtn mt30">
        </form>
        <div class="col-md-2"></div>
     </div>
    <input type="hidden" id="key" value="${key}">
    <input type="hidden" id="redirectUrl" value="${redirectUrl}">
</div>  
  </m:Content>
</m:ContentPage>