package com.hzfh.fmp.controller.product.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.ProductStages;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.fmp.controller.common.AjaxBaseAction;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.enumeration.ProductType;
import com.hzfh.fmp.model.common.enumeration.SalesStatus;
import com.hzfh.fmp.model.common.helper.CodeHelper;
import com.hzfh.fmp.model.common.helper.FlushCacheHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.common.properties.ParamHelper;
import com.hzfh.fmp.model.product.DecisionModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.product.ProductStagesModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzfh.fmp.model.workFlow.ActHiProcinstModel;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class AjaxProductAction extends AjaxBaseAction {

    private Product info;
    private String editComment;
    private String fileName;
    private String filePath;
    private String fileType;
    private String status;
    private String start;
    private String end;

    public String getEditComment() {
        return editComment;
    }
    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Product.class);
    }
    public Product getInfo() {
        return info;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public void setEnd(String end) {
        this.end = end;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = ProductModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("NoProduct");
                this.setErrDesc("NoProduct");
            } else
                this.info.setPricePackage(this.info.getPricePackage() * 100);
        }

        return SUCCESS;
    }

    public String edit() throws ParseException {
        switch (this.info.getType()) {
            case 1:
                info.setCode(CodeHelper.getCode("codeProduct1", "A"));
                break;
            case 2:
                info.setCode(CodeHelper.getCode("codeProduct2", "B"));
                break;
            case 3:
                info.setCode(CodeHelper.getCode("codeProduct3", "C"));
                break;
            case 4:
                info.setCode(CodeHelper.getCode("codeProduct4", "D"));
                break;
            case 5:
                info.setCode(CodeHelper.getCode("codeProduct4", "E"));
                break;
            default:
                break;
        }
        info.setPricePackage(this.info.getPricePackage() / 100);
        info.setEditUserNo(UserHelper.getEditUserNo());
        info.setEditComment(this.getEditComment());
        
        
        if (this.getOper().equalsIgnoreCase("add")) {
            int count = 0;
            switch (info.getType()) {
                case ProductType.TRUST:
                    count = ParamHelper.PRODUCT_TYPE_TRUST_QUOTA;
                    break;
                case ProductType.ASSETS_CONTROL:
                    count = ParamHelper.PRODUCT_TYPE_ASSETS_CONTROL_QUOTA;
                    break;
                case ProductType.CONTRACTUAL:
                    count = ParamHelper.PRODUCT_TYPE_CONTRACTUAL_QUOTA;
                    break;
                case ProductType.PARTNER:
                    count = ParamHelper.PRODUCT_TYPE_PARTNER_QUATA;
                    break;
                default:
                    count = ParamHelper.PRODUCT_TYPE_OTHER_QUATA;
            }
            info.setRemainSmall(count);
            info.setRemainAmount(Long.valueOf(info.getSumMoney()));
            info.setInUserNo(UserHelper.getEditUserNo());

            int productID = ProductModel.add(info);
            if (productID <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
                return SUCCESS;
            }
            this.setErrDesc(String.valueOf(productID));
        } else {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
                return SUCCESS;
            }
            if (this.getOper().equalsIgnoreCase("edit")) {
                int row = 0;
                if (info.getStatus() == ProductStatus.DURATION) {
                    row = ProductModel.updateManager(info.getId(), info.getEmpNo());
                } else if (info.getStatus() == ProductStatus.ON_SALE)
                    row = ProductModel.updateBasicInfo(info);
                else {
                    row = ProductModel.update(info);
                }
                if (row <= 0) {
                    this.setErrCode("update failed");
                    this.setErrDesc("update failed");
                    return SUCCESS;
                }
            }
        }
        EnumListCacheModel.getProductList(false);
        return SUCCESS;
    }

    public String commitCheck() {
        this.insertReview(Integer.parseInt(this.getId()), DeptHelper.DEPT_PRODUCT);
        this.insertReview(Integer.parseInt(this.getId()), DeptHelper.DEPT_RISK_CONTROL);
        return SUCCESS;
    }

    private int insertReview(int productNo, int departmentNo) {
        Decision decision = new Decision();
        decision.setProductNo(productNo);
        decision.setDepNo(departmentNo);
        decision.setIsOk((byte) 0);
        return DecisionModel.add(decision);
    }

    public String modifyStatus() throws Exception {
        if (this.getId().isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        Product product = ProductModel.getInfo(Integer.parseInt(this.getId()));

        int id = Integer.parseInt(this.getId());
        byte status = Byte.parseByte(this.status);
        if (status == ProductStatus.DURATION) {
            if(product.getStart()==null){
                this.setErrCode("NoID");
                this.setErrDesc("请填写成立日期");
                return SUCCESS;
            }
            byte statusAccount = SalesStatus.account;
            if (SalesModel.updateStatusByProductionNoAndStatus(id, statusAccount) <= 0) {
                this.setErrCode("没有已到账的打款，产品不能成立!");
                this.setErrDesc("没有已到账的打款，产品不能成立!");
                return SUCCESS;
            }
            SalesModel.updateEstablishDateByProductNoAndisEstablish(Integer.parseInt(this.getId()),DateHelper.parse(this.start));
            String content = product.getName()+"项目，于"+product.getStart()+"成立";
            LetterModel.addNotice("产品成立公告",content);
        }
        if (ProductModel.updateStatus(id, status) <= 0) {
            this.setErrCode("updateProductStatus failed");
            this.setErrDesc("updateProductStatus failed");
            return SUCCESS;
        }


        return SUCCESS;
    }
    public String modifyStart() throws ParseException {
        if (this.getId().isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            int id = Integer.parseInt(this.getId());
            Date start = DateHelper.parse(this.start);
            if (ProductModel.updateStartTime(id, start) <= 0) {
                this.setErrCode("update failed");
                this.setErrDesc("update failed");
            }

        }
        return SUCCESS;
    }
    //分期成立
    public String build() throws ParseException {
        if (this.getId().isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            Product product = ProductModel.getInfo(Integer.parseInt(this.getId()));
            if(product.getStart()==null){
                this.setErrCode("NoID");
                this.setErrDesc("请填写成立日期");
                return SUCCESS;
            }
            int productNo = Integer.parseInt(this.getId());
            byte salesAccount = SalesStatus.account;
            //计算已到账的打款总数
            Long sumMoney = SalesModel.getAllAccountMoney(productNo, salesAccount);
            //将已到账的打款状态变为认购成功
            SalesModel.updateStatusByProductionNoAndStatus(productNo, salesAccount);
            //得到当前产品的最大分期数
            Integer stagesNumber = ProductStagesModel.getProductMaxStage(productNo);
            if (stagesNumber == null)
                stagesNumber = 1;
                //将数据写入到分期表中
            else
                stagesNumber += 1;
            ProductStages productStages = new ProductStages();
            productStages.setProductNo(productNo);
            productStages.setStage(stagesNumber);
            if (!StringHelper.isNullOrEmpty(this.start)) {
                productStages.setStart(Timestamp.valueOf(this.start + " 00:00:00"));
            }
            if (!StringHelper.isNullOrEmpty(this.end)) {
                productStages.setEnd(Timestamp.valueOf(this.end + " 00:00:00"));
            }
            productStages.setAmount(123456);
            productStages.setEditUserNo(UserHelper.getEditUserNo());
            productStages.setInUserNo(UserHelper.getEditUserNo());
            if (ProductStagesModel.add(productStages) <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
            //得到产品分期的ID
            int stageId = ProductStagesModel.getProductStageId(productNo, stagesNumber);
            byte nextStatus = SalesStatus.success;
            //将产品分期ID写入打款表中
            SalesModel.updateStagesByProductionNoAndStatus(stageId, productNo, nextStatus);

            Date start = DateHelper.parse(this.start);
            SalesModel.updateEstablishDateByProductNoAndisEstablish(productNo,start);
            String content = product.getName()+"项目，第"+ stagesNumber +"期，于"+product.getStart()+"成立";
            LetterModel.addNotice("产品成立公告",content);
        }
        return SUCCESS;
    }
    public String cancelProduct(){
        if(this.getId().isEmpty()){
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        int id = Integer.valueOf(this.getId());
        try {
            ProductModel.updateStatus(id,ProductStatus.CANCEL);
            Product product = ProductModel.getInfo(id);
            ActRuTaskModel.deleteByActivitiNo(product.getActivitiNo());
            ActHiProcinstModel.completeHistoryTaskByActivitiNo(product.getActivitiNo());
            this.setErrDesc("操作成功");
        }catch (Exception e){
            this.setErrCode("failed");
            this.setErrDesc("操作失败");
        }
        return SUCCESS;
    }
}
