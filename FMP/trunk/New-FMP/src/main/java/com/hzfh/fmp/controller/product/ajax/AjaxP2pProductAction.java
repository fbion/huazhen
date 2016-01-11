package com.hzfh.fmp.controller.product.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.log.model.ProductLog;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.controller.common.AjaxBaseAction;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.enumeration.SalesStatus;
import com.hzfh.fmp.model.common.helper.ProductLogHelper;
import com.hzfh.fmp.model.common.helper.SalesLogHelper;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.CreditorModel;
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


public class AjaxP2pProductAction extends AjaxBaseAction {

    private P2pProduct info;

    public P2pProduct getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, P2pProduct.class);
    }

    private String byStatus;
    private String startTime;
    private String endTime;
    private String fileName;
    private String filePath;
    private String fileType;
    private String message;
    private long totalAmout;
    private String logoPath;

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

    public String getByStatus() {
        return byStatus;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }

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


    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setTotalAmout(long totalAmout) {
        this.totalAmout = totalAmout;
    }

    private static final ProductLogHelper productLogHelper = ProductLogHelper.getLogger(AjaxP2pProductAction.class.getName());

    public String ajaxEditAmont() {
        P2pProduct p2pProduct = P2pProductModel.getInfo(Integer.valueOf(this.getId()));
        if (CreditorModel.getInfoEffectiveByProductNo(p2pProduct.getProductNo()) == null) {

            this.setErrCode("该产品没有匹配债权");
            this.setErrDesc("该产品没有匹配债权");
            productLogHelper.addProductLog("修改产品额度", String.valueOf(this.totalAmout), Integer.valueOf(this.getId()), "该产品没有匹配债权");
            return SUCCESS;
        }
        long addMoney = (long) MathHelper.subtract(this.totalAmout, p2pProduct.getTotalAmout());
        long remainAmout = (long) MathHelper.add(p2pProduct.getRemainAmout(), addMoney);
        if (CreditorModel.getRemainAmountByProductNo(p2pProduct.getProductNo()) < remainAmout) {
            this.setErrCode("债权金额小于产品总额度，请修改");
            this.setErrDesc("债权金额小于产品总额度，请修改");
            productLogHelper.addProductLog("修改产品额度", String.valueOf(this.totalAmout), Integer.valueOf(this.getId()), "债权金额小于产品总额度");
            return SUCCESS;
        }
        p2pProduct.setTotalAmout(this.totalAmout);
        p2pProduct.setRemainAmout(remainAmout);
        int p2pResult = P2pProductModel.update(p2pProduct);
        Product product = ProductModel.getInfo(p2pProduct.getProductNo());
        product.setSumMoney(this.totalAmout);
        product.setRemainAmount(remainAmout);
        int result = ProductModel.update(product);
        if (p2pResult < 0 || result < 0) {
            this.setErrCode("更新失败，请联系管理员");
            this.setErrDesc("更新失败，请联系管理员");
            productLogHelper.addProductLog("修改产品额度", String.valueOf(this.totalAmout), Integer.valueOf(this.getId()), "更新失败");
        }
        productLogHelper.addProductLog("修改产品额度", String.valueOf(this.totalAmout), Integer.valueOf(this.getId()));
        return SUCCESS;
    }

    public String edit() throws Exception {
        info.setEditUserNo(UserHelper.getUserCache().getUserId());
        double remainAmount = info.getRemainAmout();
        double totalAmount = info.getTotalAmout();
        String progress = String.valueOf((1.00 - remainAmount / totalAmount) * 100);
        BigDecimal bg = new BigDecimal(progress);
        progress = bg.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        info.setProgress(Double.parseDouble(progress));
        Product product = ProductModel.getInfo(info.getProductNo());
        info.setType(product.getType());
        if (info.getType() == 5) {
            if (info.getStart() == null || info.getEnd() == null) {
                this.setErrCode("请填写成立日期和债权到期日");
                this.setErrDesc("请填写成立日期和债权到期日");
                return SUCCESS;
            }
            product.setStart(info.getStart());
            product.setEnd(info.getEnd());
            ProductModel.update(product);
            info.setDuration(String.valueOf(DateHelper.daysBetween(info.getStart(), info.getEnd())));
        }
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
                this.info.setLogoPath(P2pProductModel.getInfo(this.info.getId()).getLogoPath());
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
        if (StringHelper.isNullOrEmpty(this.getId()) || StringHelper.isNullOrEmpty(this.byStatus)) {
            this.setErrCode("failure");
            this.setErrDesc("系统出现异常，请刷新页面后重新操作。");
            return SUCCESS;
        }
        P2pProduct p2pProduct = P2pProductModel.getInfo(Integer.valueOf(this.getId()));
        if (Byte.valueOf(this.byStatus) == 40) {
            List<Sales> salesList = SalesModel.getSalesListByProductAndStates(p2pProduct.getProductNo(), "1,2,8,9");
            if (salesList.size() > 0) {
                if (SalesModel.getAllAccountMoney(p2pProduct.getProductNo(), SalesStatus.success) < p2pProduct.getTotalAmout()) {
                    this.setErrCode("failure");
                    this.setErrDesc("有未完成审核的打款，不允许存续操作");
                    return SUCCESS;
                }
            }
        }
        if (P2pProductModel.updateStatusById(Integer.valueOf(this.getId()), Byte.valueOf(this.byStatus)) <= 0) {
            this.setErrCode("failure");
            this.setErrDesc("系统出现异常，请刷新页面后重新操作。");
        }
        if (ProductModel.updateStatus(p2pProduct.getProductNo(), Byte.valueOf(this.byStatus)) <= 0) {
            this.setErrCode("failure");
            this.setErrDesc("系统出现异常，请刷新页面后重新操作。");
        }
        return SUCCESS;
    }

}
