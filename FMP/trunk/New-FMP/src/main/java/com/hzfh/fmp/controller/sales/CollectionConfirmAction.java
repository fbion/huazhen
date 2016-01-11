package com.hzfh.fmp.controller.sales;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.sales.SalesModel;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2015/11/20.
 */
public class CollectionConfirmAction extends CommonAction {
    private int saleNo;
    private Sales saleInfo;
    private String purchaseDate;
    private String capitalMoney;
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCapitalMoney() {
        return capitalMoney;
    }

    public void setCapitalMoney(String capitalMoney) {
        this.capitalMoney = capitalMoney;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Sales getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(Sales saleInfo) {
        this.saleInfo = saleInfo;
    }

    public int getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(int saleNo) {
        this.saleNo = saleNo;
    }

    public String execute() throws Exception {
        this.setPageAlias(PageAlias.collectionConfirm);
        this.saleInfo = SalesModel.getInfo(this.saleNo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        this.purchaseDate = simpleDateFormat.format(saleInfo.getPurchaseDate());
        this.capitalMoney = digitUppercase(saleInfo.getMoney());
        this.accountNumber = formatAccountNumber(saleInfo.getAccountNumber());
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        return SUCCESS;
    }
    public static String formatAccountNumber(String accountNumber){
        String result = "";
        while(accountNumber.length()>4){
            String i = accountNumber.substring(0,4);
            result = String.format(result+"%s ",i);
            accountNumber = accountNumber.substring(4);
        }
        result = String.format(result+"%s",accountNumber);
        return result;
    }
    public static String digitUppercase(double n){
        String fraction[] = {"角", "分"};
        String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String unit[][] = {{"元", "万", "亿"},
                {"", "拾", "佰", "仟"}};
        String head = n < 0? "负": "";
        n = Math.abs(n);
        String s = "";
        for (int i = 0; i < fraction.length; i++) {
            s += (digit[(int)(Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
        }
        if(s.length()<1){
            s = "整";
        }
        int integerPart = (int)Math.floor(n);
        for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
            String p ="";
            for (int j = 0; j < unit[1].length && n > 0; j++) {
                p = digit[integerPart%10]+unit[1][j] + p;
                integerPart = integerPart/10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
    }
}
