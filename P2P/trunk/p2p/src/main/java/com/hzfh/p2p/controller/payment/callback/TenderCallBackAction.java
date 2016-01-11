package com.hzfh.p2p.controller.payment.callback;

import com.hzfh.api.payment.model.response.gateway.TenderCallback;
import com.hzfh.p2p.controller.common.CallBackAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.UrlHelper;

/**
 * Created by Administrator on 2015/6/18.
 */
public class TenderCallBackAction extends CallBackAction<TenderCallback> {
	private String accountUrl;
	private String p2pProductListUrl;
	
    public String getAccountUrl() {
		return accountUrl;
	}
	public String getP2pProductListUrl() {
		return p2pProductListUrl;
	}

	public String execute() {
		this.setPageAlias(PageAlias.paymentComplete);
		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		accountUrl = UrlHelper.buildWWWSiteUrl(PageAlias.account);
	    p2pProductListUrl = UrlHelper.buildWWWSiteUrl(PageAlias.p2pProductList);
        /*if (Integer.parseInt(this.getResp().getCode()) == StatusCode.SUCCESS) {
        }*/
        return SUCCESS;
    }
}
