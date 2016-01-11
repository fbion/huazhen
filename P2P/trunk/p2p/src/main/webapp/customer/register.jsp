<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>


<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="main pb30">
        	<form class="validform">
				<div class="reg wrapp">
			        <h4>欢迎来到华镇社区金融</h4>
			        <div class="selectRole tab_title mt10">
			        	<span>选择角色</span>
			            <a href="#" class="active mr5">个人用户</a>
			            <!-- <a href="#">企业用户</a> -->
			        </div>
			        <div class="site_register">
			            <div class="tabContent" style="display:block;">
			                    <dl class="icon_user mt10" id="input_username">
			                        <dt>用户名</dt>
		                            <dd>
		                                <input type="text" name="username" placeholder="4~20位字符，支持字母、数字和下划线的组合" tabindex="1" class="uiText input" id="username">
		                            	<span style="color:red">*</span>
		                            </dd>
		                            <%-- <dd>
		                                <span style="display: none;" class="desc Validform_checktip"></span>
		                                <span style="display: none;" class="desc info"></span>
		                            </dd> --%>
			                    </dl>
			                    <dl class="icon_pass mt5" id="input_password">
			                        <dt>密码</dt>
			                        <dd class="relative">
			                            <input type="password" tabindex="3" name="pwd" class="input" id="pwd" placeholder="6~20位字符">
			                            <span style="color:red">*</span>
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
			                        <%-- <dd>
		                                <span style="display: none;" class="desc desc2 Validform_checktip"></span>
		                                <span style="display: none;" class="desc desc2 info"></span>
		                            </dd> --%>
			                    </dl>
			                    <dl class="icon_pass mt30" id="input_password_repeat">
			                        <dt>确认密码</dt>
			                        <dd>
			                            <input type="password" name="repassword" tabindex="4" class="input" id="pwd_confirm" placeholder="请再次输入密码" recheck="pwd">
			                            <span style="color:red">*</span>
			                        </dd>
			                        <%-- <dd>
		                                <span style="display: none;" class="desc Validform_checktip"></span>
		                                <span style="display: none;" class="desc info"></span>
		                            </dd> --%>
			                    </dl>
			                    <dl class="mt5">
			                        <dt>邀请人</dt>
			                        <dd>
			                            <input type="text" class="input" id="inviteTelephone" placeholder="邀请人手机号码" value="${phoneNo}" >
			                        </dd>
			                    </dl>
			                    <dl class="mt5">
			                        <dt>手机号码</dt>
			                        <dd>
			                            <input type="text" class="input" id="telephone" placeholder="手机号码">
			                            <span style="color:red">*</span>
			                        </dd>
			                        <%-- <dd>
		                                <span style="display: none;" class="desc Validform_checktip"></span>
		                                <span style="display: none;" class="desc info"></span>
		                            </dd> --%>
			                    </dl>
			                  
			                    <dl class="clear mt5" id="input_captcha">
		                            <dt>验 证 码 </dt>
		                            <dd>
		                                <input type="text" name="captcha" tabindex="5" class="captcha input" id="verifyCode" placeholder="不区分大小写" style="width: 138px;">
		                                <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');">
		                                    <img width="98" style="padding-top: 0px; height: 38px;" ref1="${captchaUrl}?type=register" id="imgVerifyCode"
		                                         alt="请输入验证码" src="${captchaUrl}?type=register" style="padding-top: 5px;">
		                                </a><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="validformRegister_tips">换一张</a>
		                            </dd>
		                            <%-- <dd>
		                                <span style="display: none;" class="desc Validform_checktip"></span>
		                                <span style="display: none;" class="desc info"></span>
		                            </dd> --%>
		                        </dl>
			                    <dl class="getVerCode mt5">
			                        <dt></dt>
			                        <dd>
			                            <input type="text" class="input"  id="smsCaptcha" placeholder="6位有效数字" style="width: 138px;">
			                            <!-- <a href="javascript:void(0)" id="getSmsCaptcha">获取手机验证码</a> -->
			                            <input id="getSmsCaptcha" value="获取手机验证码" type="button"/>
			                        </dd>
<!-- 			                        <dd id="msg" style="color: red;font-size: 12px;"></dd> -->
			                        <%-- <dd>
		                                <span style="display: none;" class="desc Validform_checktip" id="changMsg"></span>
		                                <span style="display: none;" class="desc info"></span>
		                            </dd> --%>
			                    </dl>
			                  	  
			            </div>
			        </div>
			        <div id="errMsg" style="color: red; margin-left: 80px; display: none"></div>
			        <h5 class="mt40">是否选择您专属的理财顾问？<a href="javascript:;" class="slideUpDown ml10"><!-- ∧ --></a></h5>
			        <div class="selectAdvisor">
			        	<p>您可以按您的意愿自由选择也可以由客服为您倾心推荐，从而为您的投资做出最准确的判断</p>
			            <label class="mt20"><input type="radio" value="0" name="choose" id="ownChoice">自己选择</label>
			            <label class="ml100"><input type="radio" value="1" name="choose" checked="checked" id="customerService">客服指定</label>
			            <div id="myChoose" style="display: block;">
			                <div class="mt30 choose_area">
			                    <dl>
			                    	<dt>省：<select class="province Validform_error" datatype="verifySelect" nullmsg="请选择省！" errormsg="请选择省！" sucmsg=" "><option value="">请选择</option><option value="111">北京</option></select>
			                    	</dt>
			                    	<dd><span class="Validform_checktip" style="color: red; display: none"></span></dd>
			                    </dl>
			                    
			                    <dl>
			                    	<dt>市：<select class="city" datatype="verifySelect" nullmsg="请选择市！" errormsg="请选择市！" sucmsg=" "><option value="">请选择</option></select></dt>
			                    	<dd><span class="Validform_checktip" style="color: red; display: none"></span></dd>
			                    </dl>
			                    <dl class="mr10">
			                    	<dt>区/县：<select class="district" datatype="verifySelect" nullmsg="请选择区/县！" errormsg="请选择区/县！" sucmsg=" "><option value="">请选择</option></select></dt>
			                    	<dd><span class="Validform_checktip ml20" style="color: red; display: none"></span></dd>
			                    </dl>
			                    <dl class="store">
			                    	<dt>门店：<select class="department" datatype="verifySelect" nullmsg="请选择门店！" errormsg="请选择门店！" sucmsg=" "><option value="">请选择</option></select></dt>
			                    	<dd><span class="Validform_checktip ml15" style="color: red; display: none"></span></dd>
			                    </dl>
			                </div>
			                <!-- 员工头像 -->
			                <div class="row mt30 text-center chooseAdviser employee"></div>
                           	<div class="desc Validform_checktip" id="remindEmployee" style="color: red; display: none" ></div> 
			            </div>
			        </div>
			        
			        <div class="register_agree">
			        	<p class="pt30">
			                <input name="agree" value="1" class="input" type="checkbox" id="agree" checked="checked">我已阅读并同意<a href="${serviceContractUrl}">《华镇新金融服务协议》</a>
			            </p>
			            <%-- <div>
	                        <span class="desc Validform_checktip" style="display: none;" style="padding-left: 210px; display: inline;"></span>
	                        <span class="desc info" style="display: none;color: red;padding-left: 0px;"></span>
	                    </div> --%>
			            <div class="compeletBtn mt20 pt5">
			                <input type="submit" value="完成注册并登录" class="mr15" id="submit">
			                <em>已有账号？<a href="${loginUrl}">立即登录</a></em>
			            </div>
			        </div>
			        <div class="registerPic p2pBanner1" value="1"></div>
				</div>
               <!--  <div class="registerPic"></div> -->
                
			</form>
			
		</div>
        <input type="hidden" id="redirectUrl" value="${redirectUrl}">
        <input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
     
         <input type="hidden" id="activityId" value="${activityId}">
    </m:Content>
</m:ContentPage>