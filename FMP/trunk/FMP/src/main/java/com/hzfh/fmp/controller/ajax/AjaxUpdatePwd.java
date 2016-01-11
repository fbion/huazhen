package com.hzfh.fmp.controller.ajax;


import com.hzfh.fmp.controller.common.BaseAction;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.permission.UserModel;


/**
 * Created by paul on 15-1-12.
 */
public class AjaxUpdatePwd extends BaseAction {
	private String msg;
	private String name;
	private String password;
	private String passwordRe; 
	private String passwordOld;

	public String getPasswordRe() {
		return passwordRe;
	}

	public void setPasswordRe(String passwordRe) {
		this.passwordRe = passwordRe;
	}

	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		int id = UserHelper.getUserCache().getUserId();
		String name = UserHelper.getUserCache().getUserName();
		String pwdOldSelect = UserModel.getPwdById(id);
		String pwdOld = EncodeHelper.encryptPWD(name, this.passwordOld);
		String pwd = EncodeHelper.encryptPWD(name, this.password);
		if (!pwdOld.equals(pwdOldSelect)) {
			msg = "<div style='color:red'>原始密码输入错误！</div>";
		}else{
			if(this.password.equals(this.passwordOld)){
				msg = "<div style='color:red'>新密码跟旧密码不能一样！</div>";
			}else{
				if (!this.password.equals(this.passwordRe)) {
					msg = "<div style='color:red'>两次密码输入不一致！</div>";
				}else{
					int ok = UserModel.updatePwd(id, pwd);
					if (ok != 1) {
						msg = "<div style='color:red'>密码修改失败！</div>";
					}else{
						msg="<div style='color:green'>恭喜您密码修改成功！</div>";
					}
				}
			}
			
		}
		return SUCCESS;
	}
}
