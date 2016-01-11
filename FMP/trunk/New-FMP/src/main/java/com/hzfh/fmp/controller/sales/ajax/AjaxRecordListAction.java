package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.sales.ActivityModel;
import com.hzfh.fmp.model.sales.ApplyCustomerModel;
import com.hzfh.fmp.model.sales.ApplyEmployeeModel;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.common.view.ListItem;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import java.util.ArrayList;
import java.util.List;

public class AjaxRecordListAction extends JqGridBaseAction<ApplyCustomer> {
    private int pageCount;
    private int totalCount;
    private int pageIndex=1;
    private List<ListItem> listItems;
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getPageIndex() {
        return pageIndex <= pageCount?pageIndex:pageCount;
    }
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
    private int activityNo;

    public int getActivityNo() {
        return activityNo;
    }

    public void setActivityNo(int activityNo) {
        this.activityNo = activityNo;
    }
    private PagedList<ApplyEmployee> applyEmployeePagedList;

    public PagedList<ApplyEmployee> getApplyEmployeePagedList() {
        return applyEmployeePagedList;
    }

    public void setApplyEmployeePagedList(
            PagedList<ApplyEmployee> applyEmployeePagedList) {
        this.applyEmployeePagedList = applyEmployeePagedList;
    }

    private  List<ApplyCustomer> applyCustomerInfos;

    public List<ApplyCustomer> getApplyCustomerInfos() {
        return applyCustomerInfos;
    }
    public void setApplyCustomerInfos(List<ApplyCustomer> applyCustomerInfos) {
        this.applyCustomerInfos = applyCustomerInfos;
    }
    private Activity activity;
    private ApplyEmployeeCondition showAllList;

    public Activity getActivity() {
        return activity;
    }
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    private ApplyEmployeeCondition getCondition(){
        ApplyEmployeeCondition applyEmployeeCondition=new ApplyEmployeeCondition();
        applyEmployeeCondition.setPageIndex(pageIndex);
        applyEmployeeCondition.setPageSize(6);
        applyEmployeeCondition.getStartIndex();
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("id");
        sortItem.setSortType(SortType.ASC);
        sortItemList.add(sortItem);
        applyEmployeeCondition.setSortItemList(sortItemList);
        applyEmployeeCondition.setActivityNo(this.activityNo);
        applyEmployeeCondition.setSortItemList(sortItemList);
        return applyEmployeeCondition;
    }
    @Override
    public String execute() throws Exception{
        this.activity=ActivityModel.getInfo(activityNo);
        this.applyEmployeePagedList = ApplyEmployeeModel.getPagingList(this.getCondition());
        totalCount = applyEmployeePagedList.getPagingInfo().getTotalCount();
        pageCount = applyEmployeePagedList.getPagingInfo().getPageCount();
        try {
            this.applyCustomerInfos=new ArrayList<ApplyCustomer>();
            for (int i = 0; i < applyEmployeePagedList.getResultList().size(); i++) {
                int empNo=applyEmployeePagedList.getResultList().get(i).getEmpNo();
                ApplyCustomer applyCustomer=new ApplyCustomer();
                applyCustomer.setEmpNo(empNo);
                applyCustomer.setActivityNo(activityNo);
                List<ApplyCustomer> applyCustomers=ApplyCustomerModel.getListByEmpNo(applyCustomer);
                if(applyCustomers!=null){
                    for (int j = 0; j < applyCustomers.size(); j++) {
                        List<DicData> relationTypeList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_RELATION);
                        List<DicData> riskTypeList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_RISK);
                        applyCustomers.get(j).setLevelName(relationTypeList.get(applyCustomers.get(j).getLevel()-1).getValue());
                        applyCustomers.get(j).setHobby(riskTypeList.get(applyCustomers.get(j).getRiskAppetite()-1).getValue());
                    }
                    applyCustomerInfos.addAll(applyCustomers);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return SUCCESS;
    }

}
