<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
    <form class="create_password">
		<div class="main pt30">
			<div class="fogetPaw wrapp">
		    	<h4 class="borderBott">请输入您需要找回登录密码的账号</h4>
		        <dl class="mt40">
		        	<dt>登录名</dt>
		            <dd>
		            	<input type="text" id="userInfo" placeholder="会员名/手机/邮箱" class="mr10" />忘记会员名？可使用手机号或邮箱
		            </dd>
		        </dl>
		        <dl class="verifyCode mt20">
		        	<dt>验证码</dt>
		            <dd>
		            	<input type="text" name="captcha" tabindex="5" placeholder="不区分大小写" class="captcha input validationCode" id="verifyCode" style="display:inline-block;" >
		            	<a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="ml10">
		                <img width="76" height="28" ref1="${captchaUrl}?type=forget" id="imgVerifyCode" alt="请输入验证码" src="${captchaUrl}?type=forget" class="mr10"></a>
		                <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="validator_tips validformForgetPassword_tips">换一张</a>
		            </dd>
                    <dd class="ml160 pl10">
                    	<em id="msg" style="display: none"></em>
                    </dd>
		        </dl>
		        <dl class="mt20">
		        	<dt></dt>
		            <dd>
		            	<input type="submit" id="submit" value="确定" class="comfirEidt btnStyle mt5" />
		            </dd>
		        </dl>
		    </div>
		</div>
		<input id="customerNo" type="hidden" value=""/>
		<input id="customerInfo" type="hidden" value=""/>
		<input id="t" type="hidden" value=""/>
	</form>
    </m:Content>
</m:ContentPage>