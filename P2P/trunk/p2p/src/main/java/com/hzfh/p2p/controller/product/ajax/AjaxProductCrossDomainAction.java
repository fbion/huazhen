package com.hzfh.p2p.controller.product.ajax;


import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.controller.common.JsonBaseAction.Message;
import com.hzfh.p2p.controller.common.JsonBaseAction.MessageType;
import com.hzfh.p2p.model.baseInfo.EmailModel;
import com.hzfh.p2p.model.common.properties.MailHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.sales.P2pSubscribeModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-5.
 */
public class AjaxProductCrossDomainAction extends JsonBaseAction<P2pProduct> implements ServletResponseAware{
	private String jsoncallback;
	private String msg;
	private int id;
	private int amount;
	private String telePhone;
	private String realName;
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	private List<P2pProduct> p2pProductList;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getJsoncallback() {
		return jsoncallback;
	}
	public void setJsoncallback(String jsoncallback) {
		this.jsoncallback = jsoncallback;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public List<P2pProduct> getP2pProductList() {
		return p2pProductList;
	}
	public void setP2pProductList(List<P2pProduct> p2pProductList) {
		this.p2pProductList = p2pProductList;
	}
	private HttpServletResponse response;
	public String getProductList(){
		System.out.println(amount);
		//System.out.println(p2pProductNo);
		this.p2pProductList = P2pProductModel.getList();
		for (P2pProduct p2pProduct : p2pProductList) {
			p2pProduct.setSwitchTotalAmout(DateHelper.format(new Date(p2pProduct.getInTime().getTime()),"yyyy-MM-dd HH:mm:ss"));
		}
        response.setContentType("text/json;charset=UTF-8");
        JSONArray jarray = JSONArray.fromObject(p2pProductList);
        System.out.println(jarray);
        this.msg=jsoncallback+ "(" + jarray + ")";
        try {
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	
	public String getProductDetail(){
		
		P2pProduct p2pProduct = P2pProductModel.getInfo(id);
		response.setContentType("text/json;charset=GBK");
        JSONArray jarray = JSONArray.fromObject(p2pProduct);
        System.out.println(jarray);
        this.msg=jsoncallback+ "(" + jarray + ")";
        try {
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getProductAppointment(){
		this.message = new Message();
		message.setType(MessageType.Error);
		if(!StringHelper.isNullOrEmpty(realName)&&!StringHelper.isNullOrEmpty(telePhone)){
			message.setType(MessageType.Info);
			P2pCustomer p2pCustomer = P2pCustomerModel.getInfoByCellphone(telePhone);
			P2pProduct p2pProduct =  P2pProductModel.getInfo(id);
			P2pSubscribe p2pSubscribe = new P2pSubscribe();
			if(p2pCustomer != null){
				p2pSubscribe.setP2pCustomer(p2pCustomer.getId());
			}
			p2pSubscribe.setCellphone(telePhone);
			p2pSubscribe.setRealName(realName);
			p2pSubscribe.setP2pProductNo(id);
			p2pSubscribe.setVisitTime(DateHelper.getCurrentTime());
			p2pSubscribe.setStatus((byte)1);
			p2pSubscribe.setIsTest(p2pProduct.getIsTest());
			if(P2pSubscribeModel.add(p2pSubscribe) > 0){
				this.message.setType(MessageType.Info);
				this.message.setDescription("预约成功！");
				String mailContent = String.format(MailHelper.MAIL_SUBSCRIBE_BODY, p2pSubscribe.getRealName(),
						p2pSubscribe.getVisitTime().toString(),p2pProduct.getName(),
						p2pSubscribe.getCellphone());
				
				EmailModel.add("huj@bestinvestor.com.cn", MailHelper.MAIL_SUBSCRIBE_SUBJECT, mailContent);
			}
		}
		response.setContentType("text/json;charset=GBK");
		JSONArray jarray = JSONArray.fromObject(message);
        //System.out.println(jarray);
        this.msg=jsoncallback+ "(" + jarray + ")";
        try {
			response.getWriter().print(this.msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
