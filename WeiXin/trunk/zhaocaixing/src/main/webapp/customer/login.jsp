<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<!-- 登录弹层 -->
		<%-- <s:include value="../common/loginArea.jsp"/> --%>
		<div class="tab_title selectStyle mt20 tc">
			<a href="javascript:;" class="active f16">登录</a> <a
				href="javascript:;" class="f16">手机登录</a>
		</div>
		<div class="">
			<div class="tabContent" style="display:block;">
				<s:include value="../common/loginArea.jsp" />
			</div>

			<div class="tabContent" style="display:none;">
				<div id="content" class="mt20">
					<form class="validform registerInfo pt10 pb20"
						id="loginWithCellphoneForm">
						<dl class="" id="input_telephone">
							<dt>手机号:</dt>
							<dd>
								<input type="text" name="telephone" tabindex="4" class="input"
									id="telephone" placeholder="手机号码">
							</dd>
						</dl>
						<div class="desc Validform_checktip"></div>

						<dl class="input_captcha clear" id="input_captcha">
							<dt>验证码:</dt>
							<dd>
								<input type="text" name="captcha" tabindex="4"
									class="captcha input" id="verifyCode2" placeholder="请输入验证码"><a
									href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode2','#verifyCode2');">
									<img width="78" height="28" ref1="${captchaUrl}?type=login"
									id="imgVerifyCode2" alt="请输入验证码" src="${captchaUrl}?type=login">
								</a><a
									href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode2','#verifyCode2');"
									class="validator_tips">换一张</a>
							</dd>
						</dl>
						<div class="desc Validform_checktip"></div>

						<dl class="getVerCode" id="input_sms_captcha">
							<dt></dt>
							<dd>
								<input type="text" class="input" name="smsCaptcha"
									id="smsCaptcha" tabindex="6" placeholder="输入手机验证码"> <input
									id="getSmsCaptcha" value="获取手机验证码" type="button" />
							</dd>
						</dl>
						<div class="desc Validform_checktip"></div>
						<div class="registerSubmit pt20 pb20">
							<input type="submit" value="手机登录" class="submit_btn btn p5">
						</div>
					</form>
				</div>
			</div>

		</div>
		<input id="needVerifyCode" type="hidden">
		<input type="hidden" id="redirectUrl" value="${redirectUrl}">
		<input type="hidden" id="landedUrl" value="${landedUrl}">
		<input type="hidden" id="landedStatus" value="${landedStatus}">
	</m:Content>
</m:ContentPage>