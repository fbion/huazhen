package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.CustomerFollow;
import com.hzfh.api.customer.model.query.CustomerFollowCondition;
import com.hzfh.api.product.model.Product;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.customer.CustomerFollowModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxCustomerFollowAction extends JqGridBaseAction<CustomerFollow> {
    private CustomerFollow info;
    public CustomerFollow getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, CustomerFollow.class);
    }

    private String customerId;
    private String customerType;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String execute(){
        CustomerFollowCondition customerFollowCondition = new CustomerFollowCondition();
        customerFollowCondition.setPageSize(this.getPageSize());
        customerFollowCondition.setPageIndex(this.getPageIndex());

        if (!StringHelper.isNullOrEmpty(this.customerId)) {
            customerFollowCondition.setCustomerId(Integer.parseInt(this.customerId));
        }else{
            customerFollowCondition.setCustomerId(0);
        }
        if (this.customerId=="0"||this.customerId.equals("0")) {
            customerFollowCondition.setCustomerId(-1);
        }

        if (!StringHelper.isNullOrEmpty(this.customerType)) {
            customerFollowCondition.setCustomerType(Integer.parseInt(this.customerType));
        }else{
            customerFollowCondition.setCustomerType(0);
        }

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        customerFollowCondition.setSortItemList(sortItemList);

        PagedList<CustomerFollow> customerFollowPagedList= CustomerFollowModel.getPagingList(customerFollowCondition);
        this.setResultList(customerFollowPagedList.getResultList());
        this.setPageCount(customerFollowPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(customerFollowPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(customerFollowPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = CustomerFollowModel.add(info);
            if (id > 0){
                this.setErrDesc(String.valueOf(id));
            }else{
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }

        }
        else
        {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    if (CustomerFollowModel.update(info) > 0){
                        this.setErrDesc(String.valueOf(info.getId()));
                    }else{
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

                }
            }
        }

        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = CustomerFollowModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
    private String followId;
    private CustomerFollow customerFollow;

    public String getFollowId() {
        return followId;
    }

    public void setFollowId(String followId) {
        this.followId = followId;
    }

    public CustomerFollow getCustomerFollow() {
        return customerFollow;
    }

    public void setCustomerFollow(CustomerFollow customerFollow) {
        this.customerFollow = customerFollow;
    }

    public String ajaxGetFollowInfoById() {
        int id = -1;
        if (!StringHelper.isNullOrEmpty(this.followId)) {
            id = Integer.parseInt(this.followId);
        }
        if (id != -1) {
            this.customerFollow = CustomerFollowModel.getInfo(id);
        } else {
            this.customerFollow = null;
        }

        return SUCCESS;
    }
    private List<CustomerFollow> customerFollowList;
    public List<CustomerFollow> getCustomerFollowList() {
        return customerFollowList;
    }
    public String customerFollowId;

    public String getCustomerFollowId() {
        return customerFollowId;
    }

    public void setCustomerFollowId(String customerFollowId) {
        this.customerFollowId = customerFollowId;
    }

    public String ajaxListCustomerFollowLastThree() {
        if (!StringHelper.isNullOrEmpty(this.customerFollowId)) {
            customerFollowList = CustomerFollowModel.getCustomerFollowListLastThree(customerFollowId);
        }
        if (customerFollowList == null || customerFollowList.size() == 0) {
            return SUCCESS;
        } else {
            if(customerFollowList.size()>3){
                this.customerFollowList = this.customerFollowList.subList(0, 3);
            }
            for (CustomerFollow customerFollow : customerFollowList) {
                if (customerFollow.getProductNo() != 0) {
                    customerFollow.setProductName(ProductModel.getInfo(customerFollow.getProductNo()).getName());
                } else {
                    customerFollow.setProductName("未推荐");
                }
                if (customerFollow.getType() != 0) {
                    customerFollow.setTypeName(DicDataModel.getDicDataByTypeAndCode(DictionaryHelper.DIC_FOLLOW_TYPE, customerFollow.getType()).getValue());
                } else {
                    customerFollow.setTypeName("");
                }
                if (customerFollow.getTime() != null) {
                    customerFollow.setTimeName(String.valueOf(customerFollow.getTime()));
                } else {
                    customerFollow.setTimeName("");
                }

                if (customerFollow.getNexttime() != null) {
                    customerFollow.setNextTimeName(String.valueOf(customerFollow.getNexttime()));
                } else {
                    customerFollow.setNextTimeName("");
                }
                if (customerFollow.getContent() != null) {
                    customerFollow.setContentName(customerFollow.getContent());
                } else {
                    customerFollow.setContentName("");
                }
                if (customerFollow.getResultStatus() != 0) {
                    customerFollow.setResultName(DicDataModel.getDicDataByTypeAndCode(StatusType.CUSTOMERFOLLOW_RESULTSTATUS, Integer.valueOf(customerFollow.getResultStatus())).getValue());
                } else {
                    customerFollow.setResultName("");
                }
            }
        }
        return SUCCESS;
    }


}
