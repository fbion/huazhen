<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
    
		<div class="loginCont">
			<!-- 登录注册框 -->
		    <div class="logReg wrapp">
		    	<s:if test="showLogin">
			        <div class="wrapp_layer">
			            <div class="tab_title selectStyle mt20 tc">
                        	<a href="javascript:;" class="active f16">登录</a>
                            <a href="javascript:;" class="f16">手机登录</a>
                        </div>
                        <div class="mt30 pt10">
                            <div class="tabContent mt20" style="display:block;">
                                <!--<h4>欢迎来到华镇社区金融</h4>-->
                                <s:include value="../common/loginArea.jsp" />
                            </div>
                            <div class="tabContent mt20">
                        	<!--<h4>欢迎来到华镇社区金融</h4>-->
                        	<span id="msgdemo" class="verifyMsg" style="display: none"></span>
                        	<form id="loginWithCellphoneForm" class="validform">
                        	<p>
                                <span>手机号：</span>
                                <input id="cellphone" type="text" tabindex="1" placeholder="手机号码" value="" name="cellphone" class="Validform_error">
                            </p>
                            <p class="verCode">
                                <span>图形验证码：</span>
                                <input type="text" name="captcha" tabindex="5" class="captcha input" id="verifyCode2" />
                                <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode2','#verifyCode2');"
                                class="mt5">
                                <img width="76" height="28"ref1="${captchaUrl}?type=login" id="imgVerifyCode2" alt="请输入验证码"
                                src="${captchaUrl}?type=login"></a>
                                <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode2','#verifyCode2');"
                                class="validator_tips mt10">换一张</a> 
                            </p>
                            <p class="verCode">
                                <span>手机验证码：</span>
                                <input type="text" name="captcha" tabindex="5" class="captcha input" id="smsCaptcha" />
                                <a href="javascript:;" class="btnStyle get_verCode" id="getSmsCaptcha">获取验证码</a>
                            </p>
                            <input type="submit" value="手机登录" class="submit_btn btnStyle ml50">
                            </form>
                        </div>
			            </div>
			        </div>
		    	</s:if>
		    	<div class="p2pBanner1 loginAd" value="1"></div>
		        <!-- <em></em> -->
			</div>
		</div>
		<input id="redirectUrl" value="${redirectUrl}" type="hidden"/>
		<input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
    </m:Content>
</m:ContentPage>
