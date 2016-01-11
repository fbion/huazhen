package com.hzfh.fmp.controller.product.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;
import com.hzframework.helper.StringHelper;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class AjaxP2pProductAction extends JqGridBaseAction<P2pProduct> {

    private P2pProduct info;

    public P2pProduct getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, P2pProduct.class);
    }

    private String byProductName;
    private String byStatus;
    private String byLevel;
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getByLevel() {
        return byLevel;
    }

    public void setByLevel(String byLevel) {
        this.byLevel = byLevel;
    }

    public String getByProductName() {
        return byProductName;
    }

    public void setByProductName(String byProductName) {
        this.byProductName = byProductName;
    }

    public String getByStatus() {
        return byStatus;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }

    private String fileName;
    private String filePath;
    private String fileType;
    private String message;

    public String getFilePath() {
        return filePath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private String logoPath;

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getLogoPath() {
        return logoPath;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String execute() throws Exception {
        P2pProductCondition p2pProductCondition = new P2pProductCondition();
        p2pProductCondition.setPageSize(this.getPageSize());
        p2pProductCondition.setPageIndex(this.getPageIndex());

        if (!StringHelper.isNullOrEmpty(this.byProductName)) {
            p2pProductCondition.setByProductName(this.byProductName);
        }
        if (!StringHelper.isNullOrEmpty(this.byStatus)) {
            p2pProductCondition.setByStatus(Integer.parseInt(this.byStatus));
        }
        if (!StringHelper.isNullOrEmpty(this.type)) {
            p2pProductCondition.setType(Byte.parseByte(this.type));
        }
        if (!StringHelper.isNullOrEmpty(this.startTime)) {
            p2pProductCondition.setStartTime(this.startTime);
        }
        if (!StringHelper.isNullOrEmpty(this.endTime)) {
            p2pProductCondition.setEndTime(this.endTime);
        }
        if (!StringHelper.isNullOrEmpty(this.byLevel)) {
            p2pProductCondition.setByLevel(Integer.parseInt(this.byLevel));
        }
        p2pProductCondition.setSortItemList(getSort());
        PagedList<P2pProduct> p2pProductPagedList = P2pProductModel.getPagingList(p2pProductCondition);

        List<P2pProduct> p2pProductList = p2pProductPagedList.getResultList();
        for (P2pProduct p2pProduct : p2pProductList) {
            if (p2pProduct.getEnd() != null) {
                int days = DateHelper.daysBetween(DateHelper.getTodayDate(), p2pProduct.getEnd());
                p2pProduct.setEditComment(String.valueOf(days));
                if (days < 0) {
                    p2pProduct.setEditComment("已结束");
                }
            } else {
                p2pProduct.setEditComment("");
            }
            double salesMoney = p2pProduct.getTotalAmout() - p2pProduct.getRemainAmout();
            double progress = MathHelper.multiply(MathHelper.divide(salesMoney, p2pProduct.getTotalAmout(), 2), 100);

            p2pProduct.setDescription(ProductModel.getInfo(p2pProduct.getProductNo()).getName());
            p2pProduct.setProgress(progress);
        }
        this.setResultList(p2pProductPagedList.getResultList());
        this.setPageCount(p2pProductPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(p2pProductPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(p2pProductPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public List<SortItem> getSort() {
        List<SortItem> sortItemList = new ArrayList<SortItem>();

        SortItem sortItem = new SortItem();
        if (this.getSidx().equals("editComment")) {
            sortItem.setSortFeild("end");
        } else if (this.getSidx().equals("totalAmout")) {
            sortItem.setSortFeild("total_amout");
        } else if (this.getSidx().equals("remainAmout")) {
            sortItem.setSortFeild("remain_amout");
        } else if (this.getSidx().equals("orderCount")) {
            sortItem.setSortFeild("order_count");
        } else if (this.getSidx().equals("repaymentIssue")) {
            sortItem.setSortFeild("repayment_issue");
        } else {
            sortItem.setSortFeild(this.getSidx());
        }
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);

        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("start");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);

        return sortItemList;
    }

    public String edit() throws Exception {
        info.setEditUserNo(UserHelper.getEditUserNo());
        double remainAmount = info.getRemainAmout();
        double totalAmount = info.getTotalAmout();
        String progress = String.valueOf((1.00 - remainAmount / totalAmount) * 100);
        BigDecimal bg = new BigDecimal(progress);
        progress = bg.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        info.setProgress(Double.parseDouble(progress));
        Product product = ProductModel.getInfo(info.getProductNo());
        product.setStart(info.getStart());
        product.setEnd(info.getEnd());
        ProductModel.update(product);
        info.setType(product.getType());
        info.setDuration(String.valueOf(DateHelper.daysBetween(info.getStart(),info.getEnd())));
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            int p2pId = P2pProductModel.add(info);
            if (p2pId <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            } else
                this.setId(String.valueOf(p2pId));
        } else {
            if (this.info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                P2pProduct tProduct = new P2pProduct();
                tProduct = P2pProductModel.getInfo(this.info.getId());
                this.info.setLogoPath(tProduct.getLogoPath());
                if (P2pProductModel.update(this.info) <= 0) {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                }
            }
        }
        return SUCCESS;
    }

    @SuppressWarnings("unused")
    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NOID");
            this.setErrDesc("NOID");
        } else {
            P2pProduct p2p = new P2pProduct();
            p2p = P2pProductModel.getInfo(Integer.valueOf(this.getId()));
            p2p.setLogoPath(UrlHelper.buildUploadSiteUrl(p2p.getLogoPath()));
            if (p2p == null) {
                this.setErrCode("NOP2P");
                this.setErrDesc("NOP2P");
            } else
                this.info = p2p;
        }
        return SUCCESS;
    }

    public String uploadFile() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NOID");
            this.setErrDesc("NOID");
            return SUCCESS;
        }
        P2pProduct p2pVideo = new P2pProduct();
        p2pVideo.setId(Integer.valueOf(this.getId()));
        p2pVideo.setVideoUrl(this.filePath);
        int fileId = P2pProductModel.addP2pVideo(p2pVideo);
        if (fileId <= 0) {
            this.setErrCode("upload failed");
            this.setErrDesc("NOID");
            return SUCCESS;
        }
        this.setErrDesc(this.fileName);
        this.setFilePath(this.message);
        String msg = "tools/vcastr2.swf";
        this.setMessage(UrlHelper.buildUploadSiteUrl(msg));
        return SUCCESS;
    }

    public String updateLogpPathById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NOID");
            this.setErrDesc("NOID");
            return SUCCESS;
        }
        if (StringHelper.isNullOrEmpty(this.getLogoPath())) {
            this.setErrCode("NOLogoPath");
            this.setErrDesc("NOLogoPath");
            return SUCCESS;
        }
        String path = "";
        path = this.getLogoPath();
        if (!StringHelper.isNullOrEmpty(path) && path.indexOf("files") > 0) {
            path = path.split("files")[1];
        }
        int fileId = P2pProductModel.updateLogpPathById(Integer.parseInt(this.getId()), path);
        if (fileId <= 0) {
            this.setErrCode("upload failed");
            this.setErrDesc("upload failed");
            return SUCCESS;
        }
        return SUCCESS;
    }

    public String getFileList() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NOID");
            this.setErrDesc("NOID");
            return SUCCESS;
        }
        P2pProduct p2p = P2pProductModel.getInfo(Integer.valueOf(this.getId()));
        this.setFilePath((UrlHelper.buildUploadSiteUrl(p2p.getVideoUrl())));
        String msg = "tools/vcastr2.swf";
        this.setMessage(UrlHelper.buildUploadSiteUrl(msg));
        return SUCCESS;
    }

    public String updateStatus() {
        if(StringHelper.isNullOrEmpty(this.getId()) || StringHelper.isNullOrEmpty(this.byStatus)){
            this.setErrCode("failure");
            this.setErrDesc("系统出现异常，请刷新页面后重新操作。");
            return SUCCESS;
        }
        P2pProduct p2pProduct = P2pProductModel.getInfo(Integer.valueOf(this.getId()));
        if(Byte.valueOf(this.byStatus)==40){
            List<Sales> salesList = SalesModel.getSalesListByProductAndStates(p2pProduct.getProductNo(), "1,2,8,9");
            if(salesList.size()>0){
                this.setErrCode("failure");
                this.setErrDesc("有未完成审核的打款，不允许存续操作");
                return SUCCESS;
            }
        }
        if(P2pProductModel.updateStatusById(Integer.valueOf(this.getId()),Byte.valueOf(this.byStatus)) <= 0){
            this.setErrCode("failure");
            this.setErrDesc("系统出现异常，请刷新页面后重新操作。");
        }


        if(ProductModel.updateStatus(p2pProduct.getProductNo(), Byte.valueOf(this.byStatus)) <= 0){
            this.setErrCode("failure");
            this.setErrDesc("系统出现异常，请刷新页面后重新操作。");
        }
        return SUCCESS;
    }

}
