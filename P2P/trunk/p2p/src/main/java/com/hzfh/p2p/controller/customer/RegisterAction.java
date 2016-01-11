package com.hzfh.p2p.controller.customer;

import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.customer.P2pCustomerModel;

/**
 * Created by paul on 15-2-5.
 */
public class RegisterAction extends CommonAction{
    private String captchaUrl;

    public String getCaptchaUrl() {
        return captchaUrl;
    }
    

    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }
    
    private String activityId;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}


	private String inviterNo;
    
	public String getInviterNo() {
		return inviterNo;
	}

	public void setInviterNo(String inviterNo) {
		this.inviterNo = inviterNo;
	}

	private String phoneNo;
	
	public String getPhoneNo() {
		return phoneNo;
	}




	@Override
	public String execute(){
        this.setPageAlias(PageAlias.register);
        
        if(inviterNo!=null){
        	String [] arrparam = inviterNo.split(",");
        	inviterNo = arrparam[0];
        	activityId = arrparam[1];
            //根据用户id查询用户信息 inviterNo
            if(inviterNo !=null){
            	phoneNo = P2pCustomerModel.getInfo(Integer.parseInt(inviterNo)).getCellphone();
            }
        }


        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
        this.redirectUrl = this.buildWWWSiteUrl(PageAlias.registerSuccess);


        return SUCCESS;
	}
}
