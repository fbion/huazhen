package com.hzfh.fmp.model.sales;

import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.api.sales.model.query.SalesCreditorCondition;
import com.hzfh.fmp.facade.sales.SalesCreditorFacade;
import com.hzfh.fmp.facade.sales.SalesFacade;
import com.hzframework.contract.PagedList;
import com.hzframework.helper.MathHelper;

import java.util.List;

public class SalesCreditorModel {
    public static PagedList<SalesCreditor> getPagingList(SalesCreditorCondition salesCreditorCondition) {
        return SalesCreditorFacade.getPagingList(salesCreditorCondition);
    }

    public static int add(SalesCreditor salesCreditor) {
        return SalesCreditorFacade.add(salesCreditor);
    }

    public static int update(SalesCreditor salesCreditor) {
        return SalesCreditorFacade.update(salesCreditor);
    }

    public static List<SalesCreditor> getList() {
        return SalesCreditorFacade.getList();
    }

    public static SalesCreditor getInfo(int id) {
        return SalesCreditorFacade.getInfo(id);
    }
    public static int delete(int id){
        return SalesCreditorFacade.delete(id);
    }
    public static List<SalesCreditor> getListBySalesNo(int salesNo){
        return SalesCreditorFacade.getListBySalesNo(salesNo);
    }
    public static List<SalesCreditor> getListBySalesNoNotRepeat(int salesNo){
        return SalesCreditorFacade.getListBySalesNoNotRepeat(salesNo);
    }


    public static int distributionCreditor(int salesNo){
        Sales sales = SalesModel.getInfo(salesNo);
        double surplusSalesMoney = sales.getMoney();
        double salesCreditorMoney = 0;
        while(surplusSalesMoney!=0){
            Creditor creditor = CreditorModel.getInfoEffectiveByProductNo(sales.getProductNo());
            if(surplusSalesMoney > creditor.getRemainAmount()){ //未分配债权的金额 大于 房子可抵用的金额 （即不够分配）
                salesCreditorMoney = creditor.getRemainAmount(); //分配金额 为 房子的全款
                surplusSalesMoney = MathHelper.subtract(surplusSalesMoney,creditor.getRemainAmount()); //
            }else{ //未分配债权金额大于 房子可抵用的金额 （够分配）
                salesCreditorMoney = surplusSalesMoney; //分配金额为未分配全部债权的金额
                surplusSalesMoney = 0;
            }
            CreditorModel.updateRemainAmountById(creditor.getId(),salesCreditorMoney);
            SalesCreditor salesCreditor = new SalesCreditor();
            salesCreditor.setCreditorNo(creditor.getId());
            salesCreditor.setSalesNo(salesNo);
            salesCreditor.setMoney(salesCreditorMoney);
            salesCreditor.setCreditorName(creditor.getProjectName()+creditor.getRoomNumber());
            SalesCreditorModel.add(salesCreditor);
        }
        return 1;
    }


    public static int deleteBySalesNo(int salesNo) {
        return SalesCreditorFacade.deleteBySalesId(salesNo);
    }
}
