package com.hzfh.p2p.controller.common;

import com.hzfh.api.baseInfo.model.Captcha;
import com.hzfh.p2p.model.baseInfo.CaptchaModel;
import com.hzfh.p2p.model.common.captcha.SecurityCode;
import com.hzfh.p2p.model.common.captcha.SecurityImage;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzframework.helper.DateHelper;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;

/**
 * Created by paul on 15-3-11.
 */
public class CaptchaImageAction extends ActionSupport {
    //图片流
    private ByteArrayInputStream imageStream;
    private String timestamp;//得到时间戳

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }


    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;

    }


    public String getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        //System.out.println("时间戳timestamp:"+this.timestamp);
    }


    @Override
    public String execute() throws Exception {
        //如果开启Hard模式，可以不区分大小写
        String securityCode = SecurityCode.getSecurityCode(4, SecurityCode.SecurityCodeLevel.Hard, false).toLowerCase();

        //获取默认难度和长度的验证码
        //String securityCode = SecurityCode.getSecurityCode();
        imageStream = SecurityImage.getImageAsInputStream(securityCode);

        Captcha captcha = new Captcha();
        captcha.setStatus((byte)0);
        captcha.setCode(securityCode);
        captcha.setIndate(DateHelper.getCurrentTime());
        captcha.setExpireTime(DateHelper.addMinute(captcha.getIndate(),10));

        int captchaKey = CaptchaModel.add(captcha);

        StateValues.setCaptchaKey(captchaKey);
        return SUCCESS;
    }
}
