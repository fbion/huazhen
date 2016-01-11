package com.hzfh.fmp.controller;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 磊 on 2015/11/2.
 */
public class NewIndexAction extends CommonAction {
    public List<Integer> sumMoney = new ArrayList<>();
    public List<String> xDate = new ArrayList<>();
    public List<Integer> aCustomerPersonal = new ArrayList<>();
    public List<Integer> bCustomerPersonal = new ArrayList<>();
    public List<Integer> cCustomerPersonal = new ArrayList<>();
    public List<Integer> dCustomerPersonal = new ArrayList<>();
    public String showAllList;
    public String pageVar;

    public String getPageVar() {
        return pageVar;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    public List<Integer> getSumMoney() {
        return sumMoney;
    }

    public List<String> getxDate() {
        return xDate;
    }

    public List<Integer> getaCustomerPersonal() {
        return aCustomerPersonal;
    }

    public List<Integer> getbCustomerPersonal() {
        return bCustomerPersonal;
    }

    public List<Integer> getcCustomerPersonal() {
        return cCustomerPersonal;
    }

    public List<Integer> getdCustomerPersonal() {
        return dCustomerPersonal;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.newIndex);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;
        this.initPageVar();
        return SUCCESS;

    }
    private void initPageVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append("};");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }

    public String getIndexSales() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sfDate = new SimpleDateFormat("MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        SalesCondition salesCondition = new SalesCondition();
        if(!"query".equals(this.showAllList)){
            List<Integer> workMate = UserHelper.getUserCache().getWorkMate();
            if (workMate != null) {
                workMate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workMate);
                salesCondition.setWorkMateString(workMateString);
            } else {
                salesCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        List<Sales> currentWeekSales = SalesModel.getCurrentWeekSales(salesCondition);
        for (int i = 0; i < 7; i++) {
            int sum = 0;
            for (Sales sales : currentWeekSales) {
                if (sf.format(sales.getPurchaseDate()).equals(sf.format(calendar.getTime()))) {
                    sum += sales.getMoney();
                }
            }
            this.sumMoney.add(sum);
            this.xDate.add(sfDate.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        return SUCCESS;
    }

    public String getIndexCustomerPerson(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sfDate = new SimpleDateFormat("MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        CustomerPersonalCondition customerPersonalCondition = new CustomerPersonalCondition();
        if(!"query".equals(this.showAllList)){
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                customerPersonalCondition.setWorkMateString(workMateString);
            } else {
                customerPersonalCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        List<CustomerPersonal> currentWeekCustomerPersonals = CustomerPersonalModel.getCurrentWeekCustomerPerson(customerPersonalCondition);
        for (int i = 0; i < 7; i++) {
            int aTotal = 0;
            int bTotal = 0;
            int cTotal = 0;
            int dTotal = 0;
            for (CustomerPersonal customerPersonal: currentWeekCustomerPersonals) {
                if (sf.format(customerPersonal.getFindTime()).equals(sf.format(calendar.getTime()))) {
                    if(customerPersonal.getRelationLevel() == StatusType.A_CUSTOMERPERSONAL){
                        aTotal++;
                    }
                    else if (customerPersonal.getRelationLevel() == StatusType.B_CUSTOMERPERSONAL){
                        bTotal++;
                    }
                    else if (customerPersonal.getRelationLevel() == StatusType.C_CUSTOMERPERSONAL){
                        cTotal++;
                    }
                    else if (customerPersonal.getRelationLevel() == StatusType.D_CUSTOMERPERSONAL){
                        dTotal++;
                    }
                }
            }
            this.aCustomerPersonal.add(aTotal);
            this.bCustomerPersonal.add(bTotal);
            this.cCustomerPersonal.add(cTotal);
            this.dCustomerPersonal.add(dTotal);
            this.xDate.add(sfDate.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        return SUCCESS;
    }


}
