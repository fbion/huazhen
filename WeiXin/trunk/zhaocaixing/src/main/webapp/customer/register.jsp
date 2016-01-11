<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div id="content" class="mt20">
            <form class="validform registerInfo pt10 pb20">
			 <input id="code" type="hidden" value=""/>
          	 <dl class="icon_user" id="input_username">
                        <dt>用户名:</dt>
                        <dd>
                            <input type="text" name="username" 
                            placeholder="请输入用户名" tabindex="1" class="uiText input"
                             id="username" datatype="verifyUsername">
                        </dd>
                    </dl>
                    <div class="desc Validform_checktip"></div>
                    <dl class="clear icon_pass" id="input_password">
                        <dt>密<span class="ml15" style="display:inline-block">码:</span></dt>
                        <dd class="relative">
                            <input type="password" name="pwd" class="input" id="pwd" placeholder="请输入密码">
                        </dd>
                      </dl>
                    <div class="desc Validform_checktip"></div>
                      
                    <dl class="clear icon_pass" id="input_password_repeat">
                        <dt>确<span class="ml15" style="display:inline-block">认:</span></dt>
                        <dd>
                          <input type="password" name="repassword" tabindex="3" class="input" id="pwd_confirm" placeholder="请再次输入密码">
                        </dd>
                    </dl>
                    <div class="desc Validform_checktip"></div>
                    
                    <dl class="" id="input_telephone">
                        <dt>邀请人:</dt>
                        <dd>
                         <input type="text" class="input" id="inviteTelephone" placeholder="邀请人手机号码" value="${phoneNo}" >
                        </dd>
                    </dl>
                    <div class="desc Validform_checktip"></div>
                    
                    <dl class="" id="input_telephone">
                        <dt>手机号:</dt>
                        <dd>
                          <input type="text" name="telephone" tabindex="4" class="input" id="telephone" placeholder="手机号码">
                        </dd>
                    </dl>
                    
                    
                    <div class="desc Validform_checktip"></div>
                     
                    <dl class="input_captcha clear" id="input_captcha">
                        <dt>验证码:</dt>
                        <dd>
                            <input type="text" name="captcha" 
                           tabindex="4" class="captcha input"
                             id="verifyCode"  placeholder="请输入验证码"><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');">
                                <img width="78" height="28" ref1="${captchaUrl}?type=register" id="imgVerifyCode"
                                     alt="请输入验证码" src="${captchaUrl}?type=register"></a><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="validator_tips">换一张</a>
                        </dd>
                    </dl>
                    <div class="desc Validform_checktip"></div>
  
  					<dl class="getVerCode" id="input_sms_captcha">
		            	<dt></dt>
                        <dd>
                          <input type="text" class="input" name="smsCaptcha" id="smsCaptcha" tabindex="6" placeholder="输入手机验证码">
                          <input id="getSmsCaptcha" value="获取手机验证码" type="button"/>
                        </dd>
		         	</dl>
			        <div class="desc Validform_checktip"></div>
                    <dl class="serviceAgreement">
                        <dt></dt>
                        <dd> <input name="agree" value="1" class="input" type="checkbox" id="agree" checked="checked"><span class="ml10">我已阅读并同意<a href="${serviceContractUrl}">《华镇新金融服务协议》</a></span></dd>
                    </dl>
                    <div class="registerSubmit pt20 pb20">
                         <input type="submit" value="注册" class="submit_btn btn p5">
                    </div>
             </form>
                </div>  
                    <input type="hidden" id="redirectUrl" value="${redirectUrl}">
    </m:Content>
</m:ContentPage>