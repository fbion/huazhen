 <%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">安全设置</m:Content>
    <m:Content contentPlaceHolderId="customerCenter">
	   <div class="accountCont">
           <h3> <em class="pl15">安全设置</em><i></i> </h3>
            <ul class="acountSafe">
            	<li>
                	<div class="safeSet_Tit">
                	<s:if test="#request.paymentAccountInformation.authenticationName==1">
                        <i class="ml50"></i>
                	</s:if><s:else>
                        <i class="wrong ml50"></i>
                	</s:else>
                        <strong class="ml40">实名认证</strong>
                        <span></span>
                        <s:if test="#request.paymentAccountInformation.authenticationName!=1">
	                        <p>
	                       		<s:if test="#request.paymentAccountInformation.authenticationTel==1&&#request.paymentAccountInformation.authenticationEmail==1"> 
	                            	<a href="javascript:void(0)" id="open" class="red">认证</a>
	                            </s:if>
		                        <s:else>
	                            	<a href="javascript:void(0)" id="realNameAut" class="red">认证</a>
	                            </s:else>
	                        </p>
                        </s:if>
                        <s:else>
                        	<p style="color: #5CD756">认证后不能修改</p>
                        </s:else>
                    </div>
                    	<s:if test="#request.rns==1">
		                   <div class="safeSet_Cont none" id="authenticationRealNameOk">
		                   	<p class="mt30 pb50">
		                       	<i class="mr30"></i>您的身份已认证成功。
		                           <em>快来投资理财吧。</em>
		                       </p>
		                   </div>
                        </s:if> 
                    	<s:if test="#request.rns==2">
		                   <div class="safeSet_Cont none" id="authenticationRealNameOk">
		                   	<p class="mt30 pb50">
		                       	<i class="mr30"></i>您的身份实名认证中...
		                           <em>请您稍后...</em>
		                       </p>
		                   </div>
                        </s:if> 
                    
                	<div class="safeSet_Cont none" id="realnameAuthenticationDiv">
                	<s:if test="#request.paymentAccountInformation.authenticationTel==1&&#request.paymentAccountInformation.authenticationEmail==1">
                	<form class="validform realnameAuthenticationFrom" id="realnameAuthenticationFrom">
                    	<dl>
                        	<dt>您的姓名：</dt>
                            <dd>
                            	<input type="text" id="realName" placeholder="中文名" <%-- value='${p2pCustomer.realName}' --%> />
                            </dd>
                            <dd>
                            	<span class="Validform_checktip name"></span>
                       		</dd>
                        </dl>
                        <dl>
                        	<dt>身份证号码：</dt>
                            <dd>
                            	<input type="text" id="cardNumber" placeholder="二代身份证" <%-- value="${p2pCustomer.cardNumber}" --%> />
                            </dd>
                           	<dd>
                           		<span class="Validform_checktip card"></span>
                          	</dd>
                        </dl>
                        <dl class="clear" id="input_captcha">
			                <dt>图形验证码：</dt>
			                <dd>
			                    <input type="text" name="captcha" tabindex="5" class="captcha input" id="verifyCode" placeholder="不区分大小写">
			                    <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');">
			                        <img width="78" height="28" ref1="${captchaUrl}?type=register" id="imgVerifyCode"
			                             alt="请输入验证码" src="${captchaUrl}?type=register">
			                    </a><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="validformRegister_tips">换一张</a>
			                </dd>
			                <dd>
                            	<span class="Validform_wrong Validform_checktip" id="msg" style="display:-none"></span>
                            </dd>
			            </dl>
                        <dl>
                        	<dt>手机验证码：</dt>
                            <dd>
                            	<input type="text" class="phoneVerify" id="smsCaptcha" placeholder="6位有效数字"/>
                                <input type="button" class="getPhone_verify" id="getSmsCaptcha" value="获取手机验证码"/>
                            </dd>
                            <dd>
                            	<span class="Validform_wrong "  style="display:none"></span>
                            </dd>
                        </dl>
                        <%-- <dl>
	                       <dt></dt>
	                       <dd>
                            <span class="Validform_wrong " id="msg" style="display:none"></span>
	                       </dd>
                        </dl> --%>
                        <dl class="mt10">
                        	<dt></dt>
                            <dd>
                            	<input type="submit" value="保存" class="btnStyle saveBtn1" />
                            </dd>
                        </dl>
                        </form>
                        </s:if>
                    </div>
                </li>
                <li>
                	<div class="safeSet_Tit">
                	<s:if test="#request.paymentAccountInformation.authenticationTel==1">
                		<i class="ml50"></i>
                        <em>已完成</em>
                        <strong class="ml40">手机认证</strong>
                        <span></span>
                        <%-- <s:if test="#request.paymentAccountInformation.authenticationIdcard==0&&#request.paymentAccountInformation.authenticationName==0">
	                        <p style="color: #5CD756">实名认证后修改</p>
                        </s:if><s:else>
	                        <p>
	                            <a href="javascript:void(0)" id="editTel" class="green">修改</a>
	                        </p>
                        </s:else> --%>
	                        <p style="color: #5CD756">手机已认证</p>
                	</s:if><s:else>
                        <i class="wrong ml50"></i>
                        <strong class="ml40">手机认证</strong>
                        <span></span>
                        <p>
                            <a href="javascript:void(0)" id="addTel" class="red">添加</a>
                        </p>
                	</s:else>
                	</div>
                	<s:if test="#request.paymentAccountInformation.authenticationTel!=1">
                	<div class="safeSet_Cont none" id="addTelephoneDiv">
                    <form class="validform addTelephoneFrom" id="addTelephoneFrom">
                    	<dl>
                        	<dt>手机号：</dt>
                            <dd>
                            	<input id="tel"  type="text" />
                            </dd>
                            <dd>
                                <div class="desc Validform_checktip mt10 ml10"></div>
                            </dd>
                        </dl>
                       <dl class="clear" id="input_captcha">
			                <dt>图形验证码：</dt>
			                <dd>
			                    <input type="text" name="captcha" tabindex="5" class="captcha input" id="verifyCode">
			                    <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');">
			                        <img width="78" height="28" ref1="${captchaUrl}?type=register" id="imgVerifyCode"
			                             alt="请输入验证码" src="${captchaUrl}?type=register">
			                    </a><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="validformRegister_tips">换一张</a>
			                </dd>
			                
			            </dl>
                        <dl>
                        	<dt>手机验证码：</dt>
                            <dd>
                            	<input type="text" class="phoneVerify" id="smsCaptchatel" />
                                <input type="button" class="getPhone_verify" id="getSmsCaptcha" value="获取手机验证码"/>
                            </dd>

                            <dd>
                            </dd>
                        </dl>
                        <dl>
                        	<dt>
                        	</dt>
                            <dd>
                                <span id="msg"></span>
                        	
                            </dd>
                        </dl>
                        <dl>
                        	<dt>
                        	</dt>
                            <dd>
                            	<input type="submit" value="保存" class="btnStyle saveBtn1" />
                            </dd>
                        </dl>
                    </form>
                    </div>
                        </s:if>
                    	<s:if test="#request.status==1">
		                    <div class="safeSet_Cont none" id="authenticationTelOk">
		                    	<p class="mt30 pb50">
		                        	<i class="mr30"></i>您的手机已认证成功。
		                        </p>
		                    </div>
                    	</s:if>
                </li>
                <li>
                	<div class="safeSet_Tit">
                		<s:if test="paymentAccountInformation.authenticationEmail==1">
                			<i class="ml50"></i>
                        	<em>已完成</em>
                		</s:if>
                		<s:else>
	                        <i class="wrong ml50"></i>
                		</s:else>
                        <strong class="ml40">电子邮箱</strong>
                        <span id="showEmail">
                        	<s:if test="paymentAccountInformation.authenticationEmail==1">
	                			${showEmail}
	                		</s:if>
                        </span>
                        <s:if test="paymentAccountInformation.authenticationEmail==1">
	                        <p>
	                        	<a href="javascript:void(0)" class="green" id="editEmail">修改</a>
	                        </p>
                        </s:if>
                        <s:else>
                        	<p>
	                            <a href="javascript:void(0)" class="red" id="verifyEmail">认证</a>
	                        </p>
                        </s:else>
                    </div>
                    <div class="safeSet_Cont" style="display: none" id="editEmailDiv">
	                    <!-- 第一种状态 ：未实名认证 -->
                    	<s:if test="paymentAccountInformation.authenticationName!=1">
	                    	<div id="firstStatus">
		                    	<form id="valEmail" class="validform">
			                    	<dl>
			                        	<dt>请输入新邮箱：</dt>
			                            <dd>
			                            	<input type="text" name="email" placeholder="邮箱" tabindex="2" id="email"<%--  value="${p2pCustomer.email}"  --%>/>
			                            </dd>
			                            <dd>
			                            	<span id="reSendMsg"></span>
			                            </dd>
			                        </dl>
			                        <dl>
			                        	<dt></dt>
			                            <dd>
			                            	<input type="submit" id="valEmailBtn" value='发送验证邮件' class="btnStyle sendBtn" />
			                            	<div style="color: green;width: 350px;">温馨提示：新邮箱未验证通过，旧邮箱依旧能正常使用！</div>
			                            </dd>
			                        </dl>
		                        </form>
	                        </div>
                    	</s:if>
                    	<s:if test="true">
                    	<s:if test="paymentAccountInformation.authenticationName==1">
                    	<!-- 第二种状态  ：已实名认证,未激活新邮箱-->
                    		<s:if test="newEmail!=null && newEmail!=''">
		                    	<div id="firstStatus">
			                    	<form id="remindEmail" class="validform">
				                    	<dl>
				                        	<dt id="emailTitle">待审核邮箱：</dt>
				                            <dd>
				                            	<input type="text" name="email" placeholder="邮箱" tabindex="2" id="email" value='<s:property value="newEmail"/>' disabled="disabled"/>
				                            </dd>
				                            <dd>
				                            	<span id="reSendMsg"></span>
				                            </dd>
				                        </dl>
				                        <dl>
				                        	<dt></dt>
				                            <dd style="width: 350px;">
				                            	<input type="submit" id="valEmailBtn" value='提醒审核' class="btnStyle sendBtn" />
				                            	<%-- <span id="mind">您还可以<a id="cancle"><u>取消审核</u></a>或<a id="update"><u>修改邮箱</u></a>？</span>
				                            	<input type="button" id="updateEmailBtn" value='确认修改' class="btnStyle sendBtn" hidden="hidden"/> --%>
				                            	<div style="color: green;width: 350px;">温馨提示：新邮箱未验证通过，旧邮箱依旧能正常使用！</div>
				                            </dd>
				                            <!-- <dd>
				                            	<em style="color: green;">温馨提示：新邮箱未验证通过，旧邮箱依然能正常使用！</em>
				                            </dd> -->
				                        </dl>
			                        </form>
		                        </div>
                    		</s:if>
                    		<s:else>
                    			<!-- 第三种状态 ：已实名认证,已激活-->
		                        <form id="editEmailForm">
			                        <dl>
			                        	<dt>原认证邮箱：</dt>
			                            <dd>
			                            	<input type="text" id="oldEmail" placeholder="原邮箱"/>
			                            </dd>
			                        </dl>
			                        <dl>
			                        	<dt>新邮箱地址：</dt>
			                            <dd>
			                            	<input type="text" id="newEmail" placeholder="新邮箱"/>
			                            </dd>
			                        </dl>
			                        <div class="upload mt20">
			                        	<h3>您已实名认证，修改邮箱需要上传如下图片：</h3>
			                            <ul>
			                            	<!-- <li>
			                                	<img src="img/uploadPic1.png" width="152" height="152" />
			                                	<a href="#" class="f18 mt10">上传</a>
			                                </li>
			                                <li class="ml40">
			                                	<img src="img/uploadPic2.png" width="152" height="152" />
			                                	<a href="#" class="f18 mt10">上传</a>
			                                </li> -->
			                                <li>
				                                <!-- <a id="aCardPath">
		                                            <img alt="上传身份证" id="cardPathImg" src="" style="height: 152px;width: 152px">
		                                        </a> -->
		                                        <img src='<s:if test="cardPath!=null">${cardPath}</s:if><s:else>${instanCardPath}</s:else>' width="152" height="152" id="cardPathImg"/>
		                                        <a class="uploadW f18 mt10" id="cardPathUpload"></a>
		                                        <input type="hidden" id="cardPath" name="cardPath" value="<s:property value='p2pCustomer.cardPath'/>"/>
			                                </li>
			                                <li class="ml40">
				                                <!-- <a id="aPortraitPath">
		                                            <img alt="上传头像" id="portraitPathImg" src="" height="152" width="152">
		                                        </a> -->
		                                        <img src="<s:if test="portraitPath!=null">${portraitPath}</s:if><s:else>${instanPortraitPath}</s:else>" height="152" width="152" id="portraitPathImg">
		                                        <a class="uploadW f18 mt10" id="portraitPathUpload"> </a>
		                                        <input type="hidden" id="portraitPath" name="portraitPath" value="<s:property value='p2pCustomer.portraitPath'/>"/>
			                                </li>
			                            </ul>
			                        </div>
			                        <dl>
			                        	<dt></dt>
			                        	<dd>
			                            	<span id="editEmailMsg" style="color:red;"></span>
			                            </dd>
			                        </dl>
			                        <dl>
			                        	<dt></dt>
			                            <dd>
			                            	<input type="submit" id="editEmailSubmit" class="btnStyle applyBtn mt5" value="立即申请"/>
			                            </dd>
			                        </dl>
		                        </form>
                    		</s:else>
                    	</s:if>
                        </s:if>
                    </div>
                    <div class="safeSet_Cont" style="display: none" id="verifyEmailSuccessDiv">
                    	<p class="mt30 pb50">
                        	<i class="mr30"></i>您的修改邮箱申请已提交成功！
                            <em>我们将1-2个工作日内进行审核。</em> 
                         </p> 
                    </div>
                    <div class="safeSet_Cont none" style="display: none" id="verifyEmailMind">
                            <h5 style="color: green">  温馨提示：     </h5><br>
						     <h6> 修改邮箱，需要提供以下信息发送到hzservice@bestinvestor.com.cn：</h6>
						     1.  用户名<br>
						     2.  新邮箱<br>
						     3.【附件】清晰地手持身份证照片+半身照片<br><br>
                    </div>
                </li>
                <li>
                	<div class="safeSet_Tit">
               			<s:if test="#request.paymentAccountInformation.accountPwd==1">
                        	<i class="ml50"></i>
                        	<em>已完成</em>
                        </s:if>
                        <s:else>
                        	<i class="wrong ml50"></i>
                        </s:else>
                        <strong class="ml40">交易密码</strong>
                        <span></span>
                        <p>
                        <s:if test="#request.paymentAccountInformation.accountPwd==1">
                            <a href="javascript:void(0)" class="green" id="tradePwd">重置</a>
                        </s:if><s:else>
                            <a href="javascript:void(0)" class="red" id="addPwd">重置</a>
                        </s:else>
                        </p>
                    </div>
                   		<s:if test="#request.rps==1">
	                    <div class="safeSet_Cont none" id="authenticationResetPwdOk">
	                    	 <p class="mt30 pb50">
	                        	<i class="mr30"></i>您的修改交易密码申请已经成功。
	                            <em>我们会在1~2个工作日内给您回复，请您注意 我们的短信通知。</em> 
	                         </p> 
	                    </div>
                        </s:if>

                </li>
                <li>
                	<div class="safeSet_Tit">
                        <i class="ml50"></i>
                        <strong class="ml40">登录密码</strong>
                        <span>
                        <s:if test="lastLoginTime != null">上次登录时间：${lastLoginTime}</s:if>
                        	<%-- <s:date name="p2pCustomer.lastLoginTime"/> --%>
                        </span>
                        <s:if test="isPwdExist">
	                        <p class="green">
	                            <a href="javascript:void(0)" class="green " id="editLoginPassword">修改</a>
	                            |
	                            <a href="${forgetPasswordUrl}" class="green" >找回</a>
	                        </p>
                        </s:if><s:else>
	                        <p class="green">
	                            <a href="javascript:void(0)" class="green " id="setLoginPassword">设置密码</a>
	                        </p>
                        </s:else>
                    </div>
                        <s:if test="isPwdExist">
		                    <div class="safeSet_Cont none" id="editLoginPasswordDiv">
		                    <form class="validform editPasswordFrom" id="editPasswordFrom">
		                    	<dl>
		                        	<dt>原登录密码：</dt>
		                            <dd>
		                            	<input id="oldPwd" name="oldPwd" type="password" />
		                            </dd>
		                            <dd>
		                                <div class="desc Validform_checktip mt10 ml10" style="display: none"></div>
		                            </dd>
		                        </dl>
		                        <dl>
		                        	<dt>新登录密码：</dt>
		                            <dd>
		                            	<input id="pwd" name="pwd" type="password" />
		                            </dd>
		                            <dd>
		                                <div class="desc Validform_checktip mt10 ml10" style="display: none"></div>
		                            </dd>
		                        </dl>
		                        <dl>
		                        	<dt>再次输入新密码：</dt>
		                            <dd>
		                            	<input id="rePwd" name="rePwd" type="password" />
		                            </dd>
		                            <dd>
		                               <div class="desc Validform_checktip mt10 ml10" style="display: none"></div>
		                           </dd>
		                        </dl>
		                        <dl>
		                        	<dt></dt>
		                            <dd>
		                            	<input type="submit" value="保存" class="btnStyle saveBtn1 confirm_eidt" />
		                            </dd>
		                        </dl>
		                    </form>
		                    </div>
                        </s:if><s:else>
		                    <div class="safeSet_Cont none" id="setLoginPasswordDiv">
		                    <form class="validform setPasswordFrom" id="setPasswordFrom">
		                        <dl>
		                        	<dt>新登录密码：</dt>
		                            <dd>
		                            	<input id="pwd2" name="pwd" type="password" />
		                            </dd>
		                            <dd>
		                                <div class="desc Validform_checktip mt10 ml10" style="display: none"></div>
		                            </dd>
		                        </dl>
		                        <dl>
		                        	<dt>再次输入新密码：</dt>
		                            <dd>
		                            	<input id="rePwd2" name="rePwd" type="password" />
		                            </dd>
		                            <dd>
		                               <div class="desc Validform_checktip mt10 ml10" style="display: none"></div>
		                           </dd>
		                        </dl>
		                        <dl>
		                        	<dt></dt>
		                            <dd>
		                            	<input type="submit" value="保存" class="btnStyle saveBtn1 confirm_eidt" />
		                            </dd>
		                        </dl>
		                    </form>
		                    </div>
                        </s:else>
                    <div class="safeSet_Cont none" id="editLoginPasswordSuccessDiv">
                        <p class="mt30 pb50">
                        	<i class="mr30"></i>您的新登录密码已修改成功，请您妥善保存。
                        </p> 
                    </div>
                </li>
            </ul> 
            
            <input id="tel"  type="hidden" value="${telephone}"/>
			<input type="hidden" id="pageAlias" value="${pageAlias}">   
        </div>
    </m:Content>
</m:ContentPage>