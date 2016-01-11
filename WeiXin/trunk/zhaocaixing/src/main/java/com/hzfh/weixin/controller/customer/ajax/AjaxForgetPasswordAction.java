package com.hzfh.weixin.controller.customer.ajax;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.baseInfo.CaptchaModel;
import com.hzfh.weixin.model.baseInfo.EmailModel;
import com.hzfh.weixin.model.common.PageAlias;
import com.hzfh.weixin.model.common.helper.CharacterFilter;
import com.hzfh.weixin.model.common.helper.EncodeHelper;
import com.hzfh.weixin.model.common.properties.MailHelper;
import com.hzfh.weixin.model.common.properties.ParamHelper;
import com.hzfh.weixin.model.common.state.StateValues;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzframework.helper.DateHelper;

import java.sql.Date;

/**
 * Created by paul on 15-3-19.
 */
public class AjaxForgetPasswordAction extends JsonBaseAction {
    private String email;
    private String verifyCode;
    private String key;
    private String password;

    public void setKey(String key) {
        this.key = key;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String sendMail(){
        this.message = new Message();
        if (!CharacterFilter.isVaildVerifyCode(verifyCode))//验证码格式正则验证

        {
            this.message.setType(MessageType.Error);//类型  错误 不通过
            this.message.setDescription("validateError:" + "验证码错误，请重新输入");//消息内容按固定格式返回
            return SUCCESS;
        }


        if (CaptchaModel.selectByIdAndCode(StateValues.getCaptchaKey(), verifyCode) == null)
        {
            this.message.setType( MessageType.Error);//类型  错误 不通过

            this.message.setDescription("validateError:" + "验证码错误，请重新输入");
            return SUCCESS;
        }

        CaptchaModel.delete(StateValues.getCaptchaKey());

        if (!CharacterFilter.isEmailAddress(email))//正则验证邮箱的格式
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription("emailError:" + "请输入正确的邮箱");
            return SUCCESS;
        }

        P2pCustomer p2pCustomer = P2pCustomerModel.selectByEmail(email);
        if (p2pCustomer == null) {
            this.message.setType(MessageType.Error);
            this.message.setDescription("emailError:" + "该邮箱尚未注册，请确认后重试");
            return SUCCESS;
        }

        String currentTime = String.valueOf(System.currentTimeMillis());
        //最后终于成功了。。。
        String cipherText = EncodeHelper.encryptPWD(p2pCustomer.getEmail()+currentTime, p2pCustomer.getUserName(), p2pCustomer.getSecretKey());
        //des(id,encrypt( userName))
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.buildWWWSiteUrl(PageAlias.emailValidation));
//        stringBuilder.append("?key=");
        stringBuilder.append(cipherText);
        stringBuilder.append(",");
        stringBuilder.append(String.valueOf(p2pCustomer.getId()));
        stringBuilder.append(",");
        stringBuilder.append(currentTime);

        //String cipherTextUrl = this.buildWWWSiteUrl(PageAlias.emailValidation) + "?key=" + EncodeHelper.encryptDES(stringBuilder.toString());
        String cipherTextUrl = this.buildWWWSiteUrl(PageAlias.resetPassword) + "?key=" + stringBuilder.toString();

        String mailContent = String.format(MailHelper.MAIL_RESET_BODY, p2pCustomer.getUserName(), cipherTextUrl);

        EmailModel.add(p2pCustomer.getEmail(), MailHelper.MAIL_RESET_SUBJECT, mailContent, p2pCustomer.getId());

        return SUCCESS;
    }

    public String resetPassword(){
        this.message = new Message();

        String[] strings = key.split(",");
        if (strings.length != 3){
            this.message.setType(MessageType.Error);
            this.message.setDescription("参数异常");
            return SUCCESS;
        }

        int customerId = Integer.valueOf(strings[1]);

        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerId);
        if (p2pCustomer == null){
            this.message.setType(MessageType.Error);
            this.message.setDescription("没有此用户");
            return SUCCESS;
        }

        Date sendTime = new Date(Long.parseLong(strings[2]));

        if (DateHelper.addHour(sendTime, ParamHelper.RESET_EMAIL_EXPIRE_HOUR).before(new Date(System.currentTimeMillis()))){
            this.message.setType(MessageType.Error);
            this.message.setDescription("没有此用户");
            return SUCCESS;
        }

        String cipherText = EncodeHelper.encryptPWD(p2pCustomer.getEmail()+strings[2], p2pCustomer.getUserName(), p2pCustomer.getSecretKey());

        if (!cipherText.equals(strings[0])){
            this.message.setType(MessageType.Error);
            this.message.setDescription("参数异常，请重试");
            return SUCCESS;
        }

        String pwd = EncodeHelper.encryptPWD(p2pCustomer.getUserName(), EncodeHelper.decryptBASE64(this.password), p2pCustomer.getSecretKey());
        if (P2pCustomerModel.updatePswdById(customerId, pwd)<=0){
            this.message.setType(MessageType.Error);
            this.message.setDescription("密码重试失败，请重试");
            return SUCCESS;
        }

        this.message.setType(MessageType.Info);
        return SUCCESS;
    }
}
