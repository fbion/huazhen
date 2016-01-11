package com.hzfh.p2p.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.SmsModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.MoneyHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.MathHelper;
import com.hzframework.helper.PropertyHelper;

/**
 * Created by paul on 15-2-5.
 */
public class IndexAction extends CommonAction {
    private String captchaUrl;

    public String getCaptchaUrl() {
        return captchaUrl;
    }

    private PagedList<P2pProduct> p2pProductList;

  

     public PagedList<P2pProduct> getP2pProductList() {
		return p2pProductList;
	}

	public void setP2pProductList(PagedList<P2pProduct> p2pProductList) {
		this.p2pProductList = p2pProductList;
	}

    private int size;
    public int getSize() {
		return size;
	}
    

	@Override
    public String execute() {
        this.setPageAlias(PageAlias.index);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.captchaUrl = this.buildWWWSiteUrl(PageAlias.captcha);
        P2pProductCondition p2pProductCondition = new P2pProductCondition();
        p2pProductCondition.setPageIndex(1);


        //  InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("properties/params.properties");
       /* InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/params.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        String productNumber = PropertyHelper.getParamProperty("product.number");
       // String productNumber = p.getProperty("product.number");
        p2pProductCondition.setPageSize(Integer.parseInt(productNumber));
        p2pProductCondition.getStartIndex();
        p2pProductCondition.setStatus1(20);
        p2pProductCondition.setStatus2(30);
        p2pProductCondition.setIsTest((byte) 0);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("level");
        sortItem.setSortType(SortType.DESC);
        sortItemList.add(sortItem);

        p2pProductCondition.setSortItemList(sortItemList);

        p2pProductList = P2pProductModel.getPagingList(p2pProductCondition);
        if (p2pProductList.getResultList().size() > 0 && p2pProductList != null) {
            for (P2pProduct p2pProduct : p2pProductList.getResultList()) {
                p2pProduct.setSwitchTotalAmout(MoneyHelper.getMoney(p2pProduct.getTotalAmout()));
                p2pProduct.setSwitchRemainAmout(MoneyHelper.getMoney(p2pProduct.getRemainAmout()));
                double salesMoney = p2pProduct.getTotalAmout()-p2pProduct.getRemainAmout();
                double progress = MathHelper.divide(salesMoney,p2pProduct.getTotalAmout(),2)*100;
                p2pProduct.setProgress(progress);
            }
        }
        this.size = p2pProductList.getResultList().size();
        return SUCCESS;
    }

    /*public String ceshi(){
        //SmsModel.smsHolidayWishes("13716498307","端午"); //节日问候
        SmsModel.smsCaptcha("13716498307","632196");//发送验证码
        // SmsModel.smsInvestmentSuccess("13716498307","何鑫","现房宝","20万"); 模板缓存错误 没有测试 投资成共
        //SmsModel.smsWithdrawalsApply("13716498307","2015年6月","现房宝","100万","201-13264564"); 提现申请
        return SUCCESS;
    }*/
	
	public String error(){
		this.setPageAlias(PageAlias.errorPage);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
		return ERROR;
	}
}