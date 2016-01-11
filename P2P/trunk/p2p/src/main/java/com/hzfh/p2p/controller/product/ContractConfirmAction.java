package com.hzfh.p2p.controller.product;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.sales.model.Contract;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.MoneyHelper;
import com.hzfh.p2p.model.customer.P2pCustomerModel;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.sales.ContractModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/6/10.
 */
public class ContractConfirmAction extends CommonAction{
    private P2pProduct p2pProduct;
    private int p2pProductNo;
    private int investmentMoney;
    private int contractNo;

	public int getContractNo() {
		return contractNo;
	}

	public int getInvestmentMoney() {
        return investmentMoney;
    }

    public void setInvestmentMoney(int investmentMoney) {
        this.investmentMoney = investmentMoney;
    }

    public P2pProduct getP2pProduct() {
        return p2pProduct;
    }

    public void setP2pProduct(P2pProduct p2pProduct) {
        this.p2pProduct = p2pProduct;
    }

    public int getP2pProductNo() {
        return p2pProductNo;
    }

    public void setP2pProductNo(int p2pProductNo) {
        this.p2pProductNo = p2pProductNo;
    }

    @Override
    public String execute(){
    	
        p2pProduct = P2pProductModel.getInfo(this.p2pProductNo);
        String content = p2pProduct.getContract();
        int customerNo = AuthenticationModel.getCustomerId();
        P2pCustomer p2pCustomer = P2pCustomerModel.getInfo(customerNo);
        
        Contract contract = new Contract();
        contractNo = ContractModel.add(contract);
        contract.setId(contractNo);
        
        String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(DateHelper.getToday());  
		String code = m.replaceAll("").trim()+contractNo;
        contract.setCode(code);
        
        if(!StringHelper.isNullOrEmpty(content)){
        	content = content.replace("${PRODUCT_NAME}",p2pProduct.getName());
        	content = content.replace("${PROTOCOL_CODE}",code);
        	content = content.replace("${CUSTOMER_NAME}",p2pCustomer.getRealName());  
        	content = content.replace("${CARD_NUMBER}",p2pCustomer.getCardNumber());
        	content = content.replace("${AMOUNT}",String.valueOf(MoneyHelper.getMoney(investmentMoney)));
        	content = content.replace("${INTEREST_RATE}",p2pProduct.getIncome()+"+"+p2pProduct.getFloatingIncome());
        	content = content.replace("${DURATION}",p2pProduct.getDuration());
        	content = content.replace("${CUSTOMER_NAME}",p2pCustomer.getRealName());
        	content = content.replace("${SIGN_DATE}",DateHelper.getToday());
        	p2pProduct.setContract(content);
        	contract.setContent(content);
        }
        
        ContractModel.update(contract);
        
        this.setPageAlias(PageAlias.contractConfirm);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        
        return SUCCESS;
    }
}
