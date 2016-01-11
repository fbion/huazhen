<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
	<div id="content" class="mt20">
            <form class="validform registerInfo pt10 pb20 newregisterInfo">
             <input id="code" type="hidden" value="">
                    <dl class="icon_user" id="input_username">
                        <dt>姓　名：</dt>
                        <dd>
                            <input type="text" name="username" placeholder="请输入姓名" tabindex="1" class="uiText input" id="username">
                        </dd>
                    </dl>
                    <div class="desc Validform_checktip"></div>                    
                    
                    <dl class="" id="input_telephone">
                        <dt>手机号：</dt>
                        <dd>
                          <input type="text" name="telephone" tabindex="4" class="input" id="telephone" placeholder="请输入手机号码" >
                        </dd>
                    </dl>
                    <div class="desc Validform_checktip"></div>
                    
                    
                    <dl class="input_captcha clear" id="input_captcha">
                        <dt>验证码：</dt>
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
                          <input type="text" class="input" name="smsCaptcha" id="smsCaptcha" tabindex="6" placeholder="输入手机验证码" >
                          <input id="getSmsCaptcha" value="获取手机验证码" type="button">
                        </dd>
                    </dl>
                    <div class="desc Validform_checktip"></div>

                    <dl class="icon_user" id="input_username">
                        <dt>门　店：</dt>
                        <dd>
                            <select name="stores" id="department" nullmsg="请选择门店"></select>
                        </dd>
                     </dl>
                <div class="desc Validform_checktip"></div>
                <div class="row mt30 text-center chooseAdviser employee rmt20"></div>
                <dl class="managingdirectordl none ">
                    <dt>理财经理:</dt>
             <!-- <dt class="managingdirector">理财经理 ：</dt></br> -->
                     <dd>
                        <ul>
                             <li>
                                
                                 <img src="http://xfbwebresource.hzfh.dev/img/new1.jpg" alt="" />
                                 <p>
                                    <input type="radio" value="276" name="choose_customers">
                                    <label class="pl5">杨利娜</label>
                                </p>
                             </li>
                             <li>
                                 <img src="http://xfbwebresource.hzfh.dev/img/new1.jpg" alt="" />
                                 <p>
                                    <input type="radio" value="276" name="choose_customers">
                                    <label class="pl5">杨利娜</label>
                                </p>
                             </li>
                             <li>
                                 <img src="http://xfbwebresource.hzfh.dev/img/new1.jpg" alt="" />
                                 <p>
                                    <input type="radio" value="276" name="choose_customers">
                                    <label class="pl5">杨利娜</label>
                                </p>
                             </li>
                             <li>
                                 <img src="http://xfbwebresource.hzfh.dev/img/new1.jpg" alt="" />
                                 <p>
                                    <input type="radio" value="276" name="choose_customers">
                                    <label class="pl5">杨利娜</label>
                                </p>
                             </li>
                             <li>
                                 <img src="http://xfbwebresource.hzfh.dev/img/new1.jpg" alt="" />
                                 <p>
                                    <input type="radio" value="276" name="choose_customers">
                                    <label class="pl5">杨利娜</label>
                                </p>
                             </li>
                             <li>
                                 <img src="http://xfbwebresource.hzfh.dev/img/new1.jpg" alt="" />
                                 <p>
                                    <input type="radio" value="276" name="choose_customers">
                                    <label class="pl5">杨利娜</label>
                                </p>
                             </li>
                             
                         </ul> 
                     </dd>
                     
                     <dd class="twoarrows">
                         <a href="###" class="twoarrows_leftarrow">&lt;</a>
                         <a href="###" class="twoarrows_rightarrow">&gt;</a>

                     </dd>
              </dl>
                  	 <div class="desc Validform_checktip"></div>
                    <div class="registerSubmit pt20 pb20">
                         <input type="submit" value="提交" class="submit_btn btn p5">
                    </div>
             </form>
                </div>
                <input type="hidden" id="redirectUrl" value="${redirectUrl}">
    </m:Content>
</m:ContentPage>