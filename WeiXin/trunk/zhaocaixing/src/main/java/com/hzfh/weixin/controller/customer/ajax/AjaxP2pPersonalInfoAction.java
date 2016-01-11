package com.hzfh.weixin.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.weixin.controller.common.JsonBaseAction;
import com.hzfh.weixin.model.common.AuthenticationModel;
import com.hzfh.weixin.model.common.helper.CharacterFilter;
import com.hzfh.weixin.model.customer.P2pCustomerModel;
import com.hzframework.helper.StringHelper;



public class AjaxP2pPersonalInfoAction  extends JsonBaseAction<P2pCustomer> {
	
	private P2pCustomer p2pCustomer;//页面传过来的
	private P2pCustomer loginCustomer;//登陆的
	
	
    public void setP2pCustomer(String p2pCustomer) {
        this.p2pCustomer =JSON.parseObject(p2pCustomer,P2pCustomer.class);
    }
    
    public P2pCustomer getP2pCustomer() {
		return p2pCustomer;
	}

	public String execute(){
		this.message = new Message(); 
		if(!this.vaild()){
			return SUCCESS;
		}
		
		int id = AuthenticationModel.getCustomerId();
		loginCustomer  =  P2pCustomerModel.getInfo(id);
		String logincardNumber = loginCustomer.getCardNumber();
		
		if(!StringHelper.isNullOrEmpty(logincardNumber)){
			p2pCustomer.setId(loginCustomer.getId());
			p2pCustomer.setCardType((byte) 1);
			P2pCustomerModel.updateNotWithCardNumber(p2pCustomer);
			this.message.setType(MessageType.Info);
			this.message.setDescription("修改成功!");
			return SUCCESS;
		}

		String p2pcardNumber = p2pCustomer.getCardNumber();
		P2pCustomer customer = P2pCustomerModel.getP2pCustomerByCardNubmer(p2pcardNumber);//查数据库中的用户

		if(customer!=null){
			this.message.setType(MessageType.Warning);
  			this.message.setDescription("身份证号已经存在!");
  			return SUCCESS;
		}

		p2pCustomer.setId(loginCustomer.getId());
		p2pCustomer.setCardType((byte) 1);
		P2pCustomerModel.updateWithCardNumber(p2pCustomer);
		this.message.setType(MessageType.Info);
		this.message.setDescription("修改成功!");
		
	
    	return SUCCESS;

    }
    
    public boolean vaild(){
    	if (!CharacterFilter.isVaildRealName(p2pCustomer.getRealName()))//正则验证realName
        {
            this.message.setType(MessageType.Error);
            this.message.setDescription( "请填写合法的用户名!" );
            return false;
        }
		if (!CharacterFilter.isVaildCellphone(p2pCustomer.getCellphone()))//正则验证realName
		{
			this.message.setType(MessageType.Error);
			this.message.setDescription("请填写合法的手机号!" );
			return false;
		}
		if (!CharacterFilter.isVaildCardNumber(p2pCustomer.getCardNumber()))//正则验证cardNumber 存在
		{
			this.message.setType(MessageType.Error);
			this.message.setDescription("请填写合法的身份证号!" );
			return false;
		}
		return true;
    }
    
}
