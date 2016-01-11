package com.hzfh.weixin.controller.customer.ajax;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.helper.CharacterFilter;
import com.hzfh.weixin.model.common.helper.EncodeHelper;
import com.hzfh.weixin.model.customer.P2pCustomerModel;

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
        if (!CharacterFilter.isVaildPwd(EncodeHelper.decryptBASE64(this.oldPwd.trim())))//验证用户的旧的密码的格式是否正确
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("oldPwdError:" + "6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号");
            return SUCCESS;
        }

        if (!CharacterFilter.isVaildPwd(EncodeHelper.decryptBASE64(this.pwd.trim())))//验证用户的密码的格式是否正确
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("pwdError:" + "6-20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号");
            return SUCCESS;
        }

        int cId = AuthenticationModel.getCustomerId();//获取当期用户的id
        //int cId=1;
        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(cId);//根据这个id 获取这个用户的信息
        String truePwd = p2pCustomer.getPassword(); //获取真实密码
        //但是要先判断旧密码是否输入正确
        if (!truePwd.equals(EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.oldPwd.trim()), p2pCustomer.getSecretKey()))) {//输入的旧密码等于真实的密码
            this.message.setType(MessageType.Error);
            this.message.setDescription("oldPwdError:" + "旧密码输入有误，请重新输入！");
            return SUCCESS;
        }
        //String key = EncodeHelper.initKey(p2pCustomer.getUserName());//根据用户的姓名获得一个初始化的加密支付key
        //根据上面的key 在可用户名 加密配置文件的编码字符串 再次进行加密
        String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.pwd.trim()), p2pCustomer.getSecretKey());
        //然后就修改数据库密码吧
        int id = P2pCustomerModel.updatePswdById(cId, pwd); //然后把这些信息写入数据库
        if (id <= 0)    //写入失败 提示 Error
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("pwdError:" + "密码修改失败请稍后再试");
            return SUCCESS;
        }

        this.message.setType(MessageType.Info);
        this.message.setDescription("密码修改成功！");
        return SUCCESS;
    }


   /* public String checkOldPwd() {//验证旧密码究竟对不对
        this.message = new Message();    //定义返回错误信息对象
        //根据输入的用户的旧密码进行判断
        //先查询出当前用的密码究竟是多少
        int cId = AuthenticationModel.getCustomerId();//获取当期用户的id
        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(cId);//根据这个id 获取这个用户的信息
        if (p2pCustomer == null) {//有对象
            this.message.setType(MessageType.Warning);    //返回的信息类型
            this.message.setDescription("登录状态异常");
            return SUCCESS;
        }
        String truePassword = p2pCustomer.getPassword();//所以得到了数据库中的密码
        if (StringHelper.isNullOrEmpty(this.oldPwd.trim())) {
            this.message.setType(MessageType.Warning);    //返回的信息类型
            this.message.setDescription("请输入原始密码");    //返回的信息内容
            return SUCCESS;
        }

        if (!truePassword.equals(EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.oldPwd.trim()), p2pCustomer.getSecretKey()))) {//数据库中的密码和用户输入的相等
            this.message.setType(MessageType.Warning);    //返回的错误信息类型
            this.message.setDescription("请输入正确的原始密码");    //返回的错误I信息内容
            return SUCCESS;
        }

        this.message.setType(MessageType.Info);    //返回的错误信息类型

        return SUCCESS;
    }*/
}
