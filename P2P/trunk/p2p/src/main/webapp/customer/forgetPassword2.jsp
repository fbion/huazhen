<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
	<div class="main pt30">
		<form id="valTel">
		<div class="fogetPaw wrapp">
	    	<div class="idStep2"></div>
	        <ul class="idStepTit pb50">
	        	<li class="idStepTit1 red">验证身份</li>
	            <li class="idStepTit2 red">重置登录密码</li>
	            <li class="idStepTit3">完成</li>
	        </ul>
	        <h4 class="borderBott">您正在使用<span>手机验证码</span>验证身份，请完成以下操作</h4>
	        <dl class="mt40">
	        	<dt>手机号码</dt>
	            <dd>
	            	<span>${cellphone}</span><em class="ml10"></em>
	            </dd>
	        </dl>
        	<dl class="clear" id="input_captcha">
                <dt>图形验证码</dt>
                <dd>
                    <input type="text" name="captcha" tabindex="5" class="captcha input" id="verifyCode" placeholder="不区分大小写">
                    <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');">
                        <img width="98" height="28" ref1="${captchaUrl}?type=register" id="imgVerifyCode"
                             alt="请输入验证码" src="${captchaUrl}?type=register">
                    </a><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="validformRegister_tips">换一张</a>
                </dd>
                <dd>
                    <div style="display: none;" class="desc Validform_checktip"></div>
                </dd>
            </dl>
	        <%-- <dl>
	        	<dt></dt>
	            <dd>
	            	<!-- <a href="javascript:;" class="getFree" style="-display:none;">点此免费获取</a> -->
	                <!--<input type="button" class="getFree" value="点此免费获取" />-->
	                <div class="VerCodeTips">
	                	<em>49秒后，重新获取验证码</em>
	                    <span>
	                    	<i></i>
	                        验证码已发送到您的手机，15分钟内输入有效，验证码等同于密码，不能告诉别人
	                    </span>
	                </div>
	            </dd>
	        </dl> --%>
	        <dl class="verifyCode mt20">
	        	<dt>手机验证码</dt>
	            <dd>
	            	<input type="text" id="smsCaptcha" placeholder="6位有效数字"/>
	            	<input type="button"  id="getSmsCaptcha" value="获取手机验证码" /> 
	            	<!-- <a href="javascript:void(0)" class="getFree" style="-display:none;" id="getSmsCaptcha">点此免费获取</a> -->
	            	 <div class="VerCodeTips none" >
	                    <span><i></i>验证码已发送到您的手机，10分钟内输入有效，验证码等同于密码，不能告诉别人 </span>
	                </div>
	                <span class="VerCodeTips1" style="display:none;">
	                    <!-- <i></i> --><em class="ml10" id="msg"></em>
	                </span>
	            </dd>
	        </dl>
	        <dl class="mt20">
	        	<dt></dt>
	            <dd>
	            	<input type="submit" value="确定" class="btnStyle comverify" /><!-- <em class="ml10" id="msg"></em> -->
	            </dd>
	        </dl>
	        <div class="tipInfo">
	        	<h5 class="mt20">没收到短信验证码？</h5>
	        	<ul class="mt10">
	            	<li>1.网络通讯异常可能会造成短信丢失，请重新获取或稍后再试。</li>
	                <li>2.请核实手机是否已欠费停机，或者屏蔽了系统信息。</li>
	                <li>3.如果手机已丢失或停用，请选择其他验证方式。</li>
	            </ul>
	        </div>
	    </div>
	    <%-- <input id="customerInfo"  type="hidden" value="${ci}"/>
		<input id="customerNo"  type="hidden" value="${cn}"/>
		<input id="t"  type="hidden" value="${t}"/> --%>
		</form>
	</div>
    </m:Content>
</m:ContentPage>