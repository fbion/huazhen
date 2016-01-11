<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 微博联合登录 -->
<%-- <html xmlns:wb="http://open.weibo.com/wb">
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=23719133&debug=true" type="text/javascript" charset="utf-8"></script> --%>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=23719133" type="text/javascript" charset="utf-8"></script>

<!-- QQ联合登录 -->
<%-- <script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="101246654" data-redirecturi="http://hzp2p.tunnel.mobi/p2p/customer/login/qqLoginCallBack.action" charset="utf-8" ></script> --%>

<!-- 登录注册框 -->
<!-- <div class="logReg wrapp">
	<div class="wrapp_layer">
		<h4>欢迎来到华镇社区金融</h4> -->
		<span class="verifyMsg" id="msgdemo2" style="display: none"></span>
		<form class="validform loginValidform">
			<dl id="login_username" class="login_usr">
				<dt></dt>
				<dd>
					<input id="username" type="text" tabindex="1" placeholder="用户名/邮箱地址/手机号码"
					 value="" name="username" class="Validform_error">
				</dd>
				<!-- <dd>
					<div class="desc Validform_checktip absolute"></div>
				</dd> --> 
			</dl>
			<dl id="login_password" class="clear login_pwd ">
				<dt></dt>
				<dd>
					<input id="pwd" type="password" name="pwd" tabindex="2" 
						placeholder="请输入登录密码" >
				</dd>
				<!-- <dd>
					<div class="desc Validform_checktip absolute"></div>
				</dd> -->
			</dl>
			<dl class="clear" id="login_captcha" class="clear" style="display: none;">
				<dt>
					<input type="text" name="captcha" tabindex="5" class="captcha input" 
						id="verifyCode" style="display:inline-block;">
				</dt>
				<dd>
					<a
				href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');"
				class="ml50 pl10"> <img width="76" height="28"
				ref1="${captchaUrl}?type=login" id="imgVerifyCode" alt="请输入验证码"
				src="${captchaUrl}?type=login"></a><a
				href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');"
				class="validator_tips">换一张</a>
				</dd>
				<!-- <dd>
					<div class="desc Validform_checktip absolute"></div>
				</dd> -->
			</dl>
			<input type="submit" value="登录" class="submit_btn btnStyle"><a
				href="${forgetPasswordUrl}" class="forgetPwd pl10">忘记密码</a>
			<p>
				<%-- <a href="javascript:void(0)" onclick='qqtoLogin()'><img src="${qqLoginImg}"></a>
				  |  <span id="wb_connect_btn" ></span>  | --%>  <a href="${registerUrl}" class="no_register pl5">立即注册</a>
						
			</p>
			
		</form>
		
	<!-- </div> -->

	<!-- <div class="wrapp_layerWx1">
		<a href="javascript:;"> <img width="286" height="318" src="img/icon_wx2.png" />
		</a>
		<p></p>
	</div> -->
<!-- </div> -->

<script type="text/javascript">

   //微博联合登录
WB2.anyWhere(function(W){
    W.widget.connectButton({
        id: "wb_connect_btn",
        type:"3,4",
        callback : {
            login:function(o){	//登录后执行的回调函数，其参数为用户信息json对象;
            	if(WB2.checkLogin()){//检查登录状态
            		alert("login");
            	}
            },	
            logout:function(){	//退出登录后执行的回调函数;
            	alert("logout");
            }
        } 
    });
});

</script>