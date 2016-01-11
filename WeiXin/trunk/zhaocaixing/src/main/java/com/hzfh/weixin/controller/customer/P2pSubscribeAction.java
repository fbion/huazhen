package com.hzfh.weixin.controller.customer;

import com.hzfh.weixin.controller.common.CommonAction;
import com.hzfh.weixin.model.common.PageAlias;

/**
 * Created by paul on 15-2-5.
 */
public class P2pSubscribeAction extends CommonAction{
    @Override
	public String execute(){
        this.setPageAlias(PageAlias.myReservation);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        	
            return SUCCESS;
	}
}
