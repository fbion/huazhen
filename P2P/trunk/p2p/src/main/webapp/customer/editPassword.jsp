<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenter">
		<div class="col-md-9 text-center create_password">
		<form class="validform">
			<dl class="orginal_password">
				<dt>原始密码：</dt>
				<dd>
					<input id="oldPwd" name="oldPwd" type="password" placeholder="请输入原始密码" tabindex="1" class="input" >
				</dd>
				<dd>
					<div style="display: none;" class="desc Validform_checktip"></div>
                    <!-- <div style="display: none;" class="desc info">请填入您的原始密码</div> -->
				</dd>
			</dl>
			<dl class="new_password">
				<dt>新密码：</dt>
				<dd class="relative">
					<input id="pwd" name="pwd" type="password" tabindex="3"  class="input">
					<div class="secure_box passwordStrength">
						<div class="grey secure_title">安全程度：</div>
						<ul class="secure_grade">
							<li>弱</li>
							<li>中</li>
							<li>强</li>
						</ul>
						<div class="clear"></div>
					</div>
				</dd>
				<dd>
					<div style="display: none;" class="desc Validform_checktip"></div>
					<div style="display: none;" class="desc info">
						请填写密码
					</div>
				</dd>
			</dl>
			<dl class="confirm_passworde">
				<dt>密码确认：</dt>
				<dd>
					<input id="rePwd" name="rePwd" type="password"  tabindex="4" class="input" >
				</dd>
				<dd>
					<div style="display: none;" class="desc Validform_checktip"></div>
                  <!--   <div style="display: none;" class="desc info">请再次输入密码</div> -->
				</dd>
			</dl>
			<div id="editPwdOk"  class="mt20" style="padding: 5px 10px; margin:0px auto; width:160px;display:none; font-weight:bold;"></div>
			<input type="submit" value="确定修改" class="confirm_eidt">
        </form> 
		</div>
	</m:Content>
</m:ContentPage>