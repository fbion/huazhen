package com.hzfh.fmp.controller.product.ajax;

import com.hzfh.api.product.model.PartnerRate;
import com.hzfh.api.product.model.query.PartnerRateCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.PartnerRateModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxPartnerRateAction extends JqGridBaseAction<PartnerRate> {

    private String productType;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    private String productNo;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    private String partnerType;

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
    }

    private String partnerNo;

    public String getPartnerNo() {
        return partnerNo;
    }

    public void setPartnerNo(String partnerNo) {
        this.partnerNo = partnerNo;
    }

    private String upperLimit;

    public String getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    private String lowerLimit;

    public String getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(String lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    private String cooperationType;

    public String getCooperationType() {
        return cooperationType;
    }

    public void setCooperationType(String cooperationType) {
        this.cooperationType = cooperationType;
    }

    private String rate;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    private String rateAdd;

    public String getRateAdd() {
        return rateAdd;
    }

    public void setRateAdd(String rateAdd) {
        this.rateAdd = rateAdd;
    }

    private String ByProductType;
    private String ByProduct;
    private String ByPartner;

    public String getByProductType() {
        return ByProductType;
    }

    public void setByProductType(String byProductType) {
        ByProductType = byProductType;
    }

    public String getByProduct() {
        return ByProduct;
    }

    public void setByProduct(String byProduct) {
        ByProduct = byProduct;
    }

    public String getByPartner() {
        return ByPartner;
    }

    public void setByPartner(String byPartner) {
        ByPartner = byPartner;
    }

    //get money from ajaxPartnerRate
    private String money;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String execute() throws Exception {
        PartnerRateCondition partnerRateCondition = new PartnerRateCondition();
        partnerRateCondition.setPageSize(this.getPageSize());
        partnerRateCondition.setPageIndex(this.getPageIndex());

        if (StringHelper.isNullOrEmpty(this.ByProductType)) {
            partnerRateCondition.setProductType(0);
        } else {
            partnerRateCondition.setProductType(Integer.parseInt(this.ByProductType));
        }
        if (StringHelper.isNullOrEmpty(this.ByProduct)) {
			partnerRateCondition.setProduct(0);
		}else{
			partnerRateCondition.setProduct(Integer.parseInt(this.ByProduct));
		}
        if (StringHelper.isNullOrEmpty(this.ByPartner)) {
            partnerRateCondition.setPartner(0);
        } else {
            partnerRateCondition.setPartner(Integer.parseInt(this.ByPartner));
        }

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        partnerRateCondition.setSortItemList(sortItemList);

        PagedList<PartnerRate> partnerRatePagedList = PartnerRateModel.getPagingList(partnerRateCondition);
        this.setResultList(partnerRatePagedList.getResultList());
        this.setPageCount(partnerRatePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(partnerRatePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(partnerRatePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        if (this.getOper().equalsIgnoreCase("del")) {
            if (StringHelper.isNullOrEmpty(this.getId())) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");

            } else {
                PartnerRateModel.delete(Integer.parseInt(this.getId()));
            }
            return SUCCESS;
        }

        PartnerRate partnerRate = new PartnerRate();

       // partnerRate.setProductType(Byte.valueOf(this.productType));
        partnerRate.setProductNo(Integer.valueOf(this.productNo));
        if(StringHelper.isNullOrEmpty(this.upperLimit))
            partnerRate.setUpperLimit(100000);
        else
            partnerRate.setUpperLimit(Long.valueOf(this.upperLimit));
        partnerRate.setLowerLimit(Long.valueOf(this.lowerLimit));
        partnerRate.setRate(Double.valueOf(this.rate));
        if (!StringHelper.isNullOrEmpty(this.rateAdd))
            partnerRate.setRateAdd(Double.valueOf(this.rateAdd));
        if (!StringHelper.isNullOrEmpty(this.getEditComment()))
            partnerRate.setEditComment(this.getEditComment());
        partnerRate.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add") || this.getId().startsWith("jqg")) {
            partnerRate.setInUserNo(UserHelper.getEditUserNo());
            if (PartnerRateModel.add(partnerRate) <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        } else {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    partnerRate.setId(Integer.parseInt(this.getId()));
                    if (PartnerRateModel.update(partnerRate) <= 0) {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

    public String getPartnerRate() {
        //Get incomeRate from Table(partner_rate) by product and partner
        PartnerRate partnerRate = PartnerRateModel.getPartnerRate(Integer.parseInt(this.productNo), Long.valueOf(this.money));
        if (partnerRate == null) {
            this.setErrCode("getPartnerRate failed");
            this.setErrDesc("getPartnerRate failed");
        } else {
            this.setRate(String.valueOf(partnerRate.getRate()));
        }
        return SUCCESS;
    }

    public String getListByProductNo() {
        if (StringHelper.isNullOrEmpty(this.productNo)) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.setResultList(PartnerRateModel.getListByProductNo(Integer.parseInt(this.productNo)));
        }
        return SUCCESS;
    }

}
