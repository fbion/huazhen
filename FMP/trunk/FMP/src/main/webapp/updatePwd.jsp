<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="edit_passwordForm">
			<div class="edit_passwordContent">
				<div class="edit_password">
					<h3>
						<em></em> <strong>修改密码</strong> <span>为了您的信息安全，如果您是第一次登录，请修改登录密码！</span>
					</h3>
				</div>
				<div class="edit_passwordEdit">

					
						<span id="checkPwd"><span class="pr10"></span></span>
					
					<p>
						<span class="pr10 tl">原始密码:<span class="pr10"></span>
						</span> <input id="pwdOld" type="password" name="passwordOld" class="pwd"/>
					</p>
					<p>
						<span class="pr10 tl">修改密码:<span class="pr10"></span>
						</span> <input id="pwd" type="password" name="password"  class="pwd"/>
					</p>
					<p>
						<span class="pr10 tl">密码确认:<span class="pr10"></span>
						</span> <input id="pwdRe" type="password" name="passwordRe"  class="pwd"/>
					</p>
					<input type="submit" value="确认" class="btn_style comConfirm_btn" />
					<input type="submit" value="取消" class="btn_style backHome_btn" />
				</div>
			</div>
		</div>
	</m:Content>
</m:ContentPage>

