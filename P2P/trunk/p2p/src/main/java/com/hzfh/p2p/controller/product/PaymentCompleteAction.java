package com.hzfh.p2p.controller.product;

import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.payment.model.request.controller.FreezeReq;
import com.hzfh.api.payment.model.response.controller.FreezeResp;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.P2pInvestment;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.controller.common.JsonBaseAction;
import com.hzfh.p2p.model.baseInfo.CaptchaModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.CharacterFilter;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.PaymentMoneyFreezeModel;
import com.hzfh.p2p.model.payment.ControllerModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.sales.P2pInvestmentModel;

/**
 * Created by Administrator on 2015/6/11.
 */
public class PaymentCompleteAction extends CommonAction{
    private int investmentMoney;

    public int getInvestmentMoney() {
        return investmentMoney;
    }

    public void setInvestmentMoney(int investmentMoney) {
        this.investmentMoney = investmentMoney;
    }

    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    private int p2pProductNo;

    public int getP2pProductNo() {
        return p2pProductNo;
    }

    public void setP2pProductNo(int p2pProductNo) {
        this.p2pProductNo = p2pProductNo;
    }
    private P2pProduct p2pProduct;

    public P2pProduct getP2pProduct() {
        return p2pProduct;
    }

    public void setP2pProduct(P2pProduct p2pProduct) {
        this.p2pProduct = p2pProduct;
    }

    public String execute(){
        FreezeReq freezeReq = new FreezeReq();
        freezeReq.setAmount(String.valueOf(this.investmentMoney));
        freezeReq.setRequestNo("");
        freezeReq.setExpired("");
        freezeReq.setPlatformUserNo("");
        //FreezeResp freezeResp = ControllerModel.getFreeze(freezeReq);
        String aa = "1";
        if(Integer.parseInt(aa)==1){

            p2pProduct = P2pProductModel.getInfo(this.p2pProductNo);
            P2pInvestment p2pInvestment = new P2pInvestment();
            p2pInvestment.setP2pCustomerNo(StateValues.getCustomerId());
            p2pInvestment.setP2pProductNo(p2pProduct.getId());
            p2pInvestment.setProductNo(p2pProduct.getProductNo());
            p2pInvestment.setIncome(p2pProduct.getIncome());
            p2pInvestment.setFloatingIncome(p2pProduct.getFloatingIncome());
            p2pInvestment.setIsTest((byte) 0);
            p2pInvestment.setName(p2pProduct.getName());
            p2pInvestment.setTotalAmout(investmentMoney);
            P2pInvestmentModel.add(p2pInvestment);
            PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
            //paymentMoneyFreeze.setAccountType();
           /* paymentMoneyFreeze.setCustomerNo(String.valueOf(StateValues.getCustomerId()));
            paymentMoneyFreeze.setCustomerName(StateValues.getUserName());
            paymentMoneyFreeze.setMoneyFreeze(-this.investmentMoney);
            paymentMoneyFreeze.setRefSn("");
            paymentMoneyFreeze.setOrderNo(123);
            paymentMoneyFreeze.setState("00");
            paymentMoneyFreeze.setSn("6783");*/
            PaymentMoneyFreezeModel.add(paymentMoneyFreeze);
            this.setPageAlias(PageAlias.paymentComplete);
            String ret = super.execute();
            if (!ret.equals(SUCCESS))
                return ret;
            return SUCCESS;
        }
        return "";
    }

}
