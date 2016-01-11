<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
	<div class="main pt30">
		<div class="fogetPaw wrapp">
	    	<div class="idStep2"></div>
	        <ul class="idStepTit pb50">
	        	<li class="idStepTit1 red">验证身份</li>
	            <li class="idStepTit2 red">重置登录密码</li>
	            <li class="idStepTit3">完成</li>
	        </ul>
	        <form class="col-md-8 pt30 text-center create_password validform">
	        <dl class="mt40">
	        
	        	<dt>新的登录密码</dt>
	            <dd>
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
	           <!--  <dd>
                    <div style="display: none;" class="desc desc2 Validform_checktip"></div>
                </dd> -->
	        </dl>
	        
	        <dl class="mt20">
	        	<dt>确认新的登录密码</dt>
	            <dd>
	            	<input type="password" name="repassword" tabindex="4" class="input" id="pwd_confirm">
	            	<div></div>
	            </dd>
	            <dd>
                    <div style="display: none;" class="desc Validform_checktip"></div> 
                </dd>
	        </dl>
	        <dl class="mt20">
	        	<dt></dt>
	        	<div id="msg"></div>
	            <dd>
	            	<input type="submit" value="重设密码" class="btnStyle comverify" />
	            </dd>
	        </dl>
	        </form>
	    </div>
	</div>
    <input type="hidden" id="key" value="${key}">
    <input type="hidden" id="redirectUrl" value="${redirectUrl}">
  </m:Content>
</m:ContentPage>