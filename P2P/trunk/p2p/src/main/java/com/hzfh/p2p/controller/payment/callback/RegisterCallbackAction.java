package com.hzfh.p2p.controller.payment.callback;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.response.gateway.RegisterCallback;
import com.hzfh.p2p.controller.common.CallBackAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;

public class RegisterCallbackAction extends CallBackAction<RegisterCallback> {
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private int rns;
	public int getRns() {
		return rns;
	}
	public void setRns(int rns) {
		this.rns = rns;
	}
	@Override
	    public String execute(){
		msg="实名认证失败了，请重新认证！";
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
        if(Integer.parseInt(this.getResp().getCode())==StatusCode.SUCCESS){
        	int customerNo = AuthenticationModel.getCustomerId();
        	if(customerNo!=0){
        		int authenticationName = PaymentAccountInformationModel.getInfoByCustomerNo(customerNo).getAuthenticationName();
        		if(authenticationName==0){
        			msg="实名认证中...";
        			this.rns = 2;
        		}else{
        			msg="恭喜你实名认证成功了！";
        			this.rns = 1;
        		}
        	}
        }
        return SUCCESS;
   }
}
