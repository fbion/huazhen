package com.hzfh.p2p.controller.payment.callback;

import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.RegisterCallback;
import com.hzfh.p2p.controller.common.CallBackAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.LogHelper;

public class ResetPwdCallbackAction extends CallBackAction<RegisterCallback> {
	public static final LogHelper logger = LogHelper.getLogger(RechargeCallbackAction.class.getName());
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private int rps;
	public int getRps() {
		return rps;
	}
	public void setRps(int rps) {
		this.rps = rps;
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
        	this.rps=1;
        }
        logger.info("重置密码callback结束");
        return SUCCESS;
    }
}
