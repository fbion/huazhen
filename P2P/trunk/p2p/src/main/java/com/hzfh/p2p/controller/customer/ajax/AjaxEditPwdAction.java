package com.hzfh.p2p.controller.customer.ajax;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzframework.helper.StringHelper;

/**
 * Created by tony on 15-3-18.
 */
public class AjaxEditPwdAction extends JsonBaseAction<P2pCustomer> {

    private String oldPwd;
    private String pwd;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String execute() {
        this.message = new Message();
        if (!CharacterFilter.isVaildPwd(EncodeHelper.decryptBASE64(this.oldPwd.trim())))
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("oldPwdError:" + "6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号");
            return SUCCESS;
        }

        if (!CharacterFilter.isVaildPwd(EncodeHelper.decryptBASE64(this.pwd.trim())))
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("pwdError:" + "6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号");
            return SUCCESS;
        }

        int cId = AuthenticationModel.getCustomerId();

        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(cId);
        String truePwd = p2pCustomer.getPassword(); 

        if (!truePwd.equals(EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.oldPwd.trim()), p2pCustomer.getSecretKey()))) {
            this.message.setType(MessageType.Error);
            this.message.setDescription("oldPwdError:" + "旧密码输入有误，请重新输入！");
            return SUCCESS;
        }


        String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.pwd.trim()), p2pCustomer.getSecretKey());

        int id = P2pCustomerModel.updatePswdById(cId, pwd); 
        if (id <= 0)    
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("pwdError:" + "密码修改失败请稍后再试");
            return SUCCESS;
        }

        this.message.setType(MessageType.Info);
        this.message.setDescription("密码修改成功！");
        return SUCCESS;
    }


    public String checkOldPwd() {
        this.message = new Message(); 


        int cId = AuthenticationModel.getCustomerId();
        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(cId);
        if (p2pCustomer == null) {
            this.message.setType(MessageType.Warning);    
            this.message.setDescription("登录状态异常");
            return SUCCESS;
        }
        String truePassword = p2pCustomer.getPassword();
        if (StringHelper.isNullOrEmpty(this.oldPwd.trim())) {
            this.message.setType(MessageType.Warning);   
            this.message.setDescription("请输入原始密码");    
            return SUCCESS;
        }

        if (!truePassword.equals(EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.oldPwd.trim()), p2pCustomer.getSecretKey()))) {//数据库中的密码和用户输入的相等
            this.message.setType(MessageType.Warning);   
            this.message.setDescription("请输入正确的原始密码");
            return SUCCESS;
        }

        this.message.setType(MessageType.Info);   

        return SUCCESS;
    }
    
    public String setPassword(){
    	this.message = new Message();
    	
    	if (!CharacterFilter.isVaildPwd(EncodeHelper.decryptBASE64(this.pwd.trim()))){
		     this.message.setType(MessageType.Error);
		     this.message.setDescription("pwdError:" + "6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号");
		     return SUCCESS;
		}
		 
		int cId = AuthenticationModel.getCustomerId();
		
		P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(cId);
		
		String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.pwd.trim()), p2pCustomer.getSecretKey());
		
		int id = P2pCustomerModel.updatePswdById(cId, pwd); 
		if (id <= 0){
		     this.message.setType(MessageType.Error);
		     this.message.setDescription("pwdError:" + "密码修改失败请稍后再试");
		     return SUCCESS;
		}
		
		this.message.setType(MessageType.Info);
		this.message.setDescription("密码修改成功！");
    	return SUCCESS;
    }	
}
