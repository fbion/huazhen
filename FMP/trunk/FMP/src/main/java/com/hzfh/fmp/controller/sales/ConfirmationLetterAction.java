package com.hzfh.fmp.controller.sales;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.product.FinancierBusinessModel;
import com.hzfh.fmp.model.product.FinancierPersonalModel;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.CreditorModel;
import com.hzfh.fmp.model.sales.SalesCreditorModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2015/8/24.
 */
public class ConfirmationLetterAction extends CommonAction {

    private int saleNo;

    public int getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(int saleNo) {
        this.saleNo = saleNo;
    }

    private Sales saleInfo;
    private P2pProduct productInfo;
    private String IDCard;

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public P2pProduct getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(P2pProduct productInfo) {
        this.productInfo = productInfo;
    }

    public Sales getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(Sales saleInfo) {
        this.saleInfo = saleInfo;
    }

    private String loanNumber;

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    private String loanName;

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    private String creditorName;

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    private double totalmoney;

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    private int day;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private String pageVar;

    public String getPageVar() {
        return pageVar;
    }

    public void setPageVar(String pageVar) {
        this.pageVar = pageVar;
    }

    private double expireMoney;

    public double getExpireMoney() {
        return expireMoney;
    }

    public void setExpireMoney(double expireMoney) {
        this.expireMoney = expireMoney;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.confirmactionLetter);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.saleInfo = SalesModel.getInfo(this.saleNo);
        if(saleInfo.getPayType()==1){
            this.IDCard = P2pCustomerModel.getInfo(saleInfo.getP2pCustomerNo()).getCardNumber();
        }else{
            this.IDCard = CustomerPersonalModel.getInfo(saleInfo.getCustomerNo()).getCardNumber();
        }
        if(saleInfo.getPurchaseDate()!=null&&saleInfo.getRepaymentDate()!=null){
            this.day = DateHelper.daysBetween(saleInfo.getPurchaseDate(),saleInfo.getRepaymentDate())+1;
        }else{
            saleInfo.setEditComment("(购买日期或到期日期为空)");
        }

        this.productInfo = P2pProductModel.getP2pByProductNo(saleInfo.getProductNo());
        Product product = ProductModel.getInfo(saleInfo.getProductNo());
        if(product.getFinancierType()==1){
            this.loanName = FinancierBusinessModel.getInfo(product.getFinancierNo()).getName();
        }else{
            this.loanName = FinancierPersonalModel.getInfo(product.getFinancierNo()).getName();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        this.loanNumber = "86" + sdf.format(saleInfo.getPurchaseDate()) + saleInfo.getContractCode();

        List<SalesCreditor> salesCreditorList = SalesCreditorModel.getListBySalesNoNotRepeat(this.saleNo);

        this.creditorName = "";
        this.totalmoney = 0;
        for(SalesCreditor salesCreditor:salesCreditorList){
            creditorName = creditorName +CreditorModel.getInfo(salesCreditor.getCreditorNo()).getProjectName()+
                    CreditorModel.getInfo(salesCreditor.getCreditorNo()).getRoomNumber()+ "/";
            totalmoney = MathHelper.add(totalmoney,CreditorModel.getInfo(salesCreditor.getCreditorNo()).getTotalMoney());
        }
        totalmoney = MathHelper.round(MathHelper.multiply(totalmoney,2),2);
        expireMoney = PaymentRefundModel.getTotalValue(saleNo);
        initPageVar();
        return SUCCESS;
    }
    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));
        sb.append("};");

        sb.append("var ElementVar={");
        for(TagPermissionView tagPermissionView: this.getPagePermissionView().getTagPermissionViewList()){
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");

        sb.append("</script>");

        this.pageVar = sb.toString();
    }
}
