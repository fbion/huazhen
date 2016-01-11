package com.hzfh.p2p.controller.payment.callback;

import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.RegisterCallback;
import com.hzfh.p2p.controller.common.CallBackAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.LogHelper;

public class ResetMobileCallbackAction extends CallBackAction<RegisterCallback> {
	public static final LogHelper logger = LogHelper.getLogger(RechargeCallbackAction.class.getName());
	private String msg;
	private int status;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	    public String execute(){
		logger.info("重置密码callback开始");
		msg="修改交易密码失败了，请重试！";
        this.setPageAlias(PageAlias.accountSuccess);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        if(!verifySign()){
	    	 logger.error("充值-callback验签失败");
	     }
	     if(getResp()==null){
	    	 logger.error("充值-callback is null！");
	     }
        if(verifySign()&&Integer.parseInt(this.getResp().getCode())==StatusCode.SUCCESS){
        	msg="恭喜你修改交易密码成功了！";
        }
        this.status = 1;
        logger.info("重置密码callback结束");
        return SUCCESS;
    }
}
