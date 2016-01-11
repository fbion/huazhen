package com.hzfh.fmp.controller.sales.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.PaymentMoneyChange;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.common.constant.TransferStatus;
import com.hzfh.api.payment.model.request.controller.CompleteTransactionReq;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.enumeration.DeptType;
import com.hzfh.fmp.model.common.enumeration.ProductType;
import com.hzfh.fmp.model.common.enumeration.SalesStatus;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.*;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.customer.*;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.payment.ControllerModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.ActivityAttachmentModel;
import com.hzfh.fmp.model.sales.ProductTaskModel;
import com.hzfh.fmp.model.sales.SalesCreditorModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzfh.fmp.model.workFlow.ActHiProcinstModel;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.ArrayHelper;
import com.hzframework.helper.StringHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AjaxSalesAction extends JqGridBaseAction<Sales> {
    private Sales info;

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Sales.class);
    }

    public Sales getInfo() {
        return info;
    }
    private int salesNo;

    public int getSalesNo() {
        return salesNo;
    }

    public void setSalesNo(int salesNo) {
        this.salesNo = salesNo;
    }
    private String productStagesNo;

    public String getProductStagesNo() {
        return productStagesNo;
    }

    public void setProductStagesNo(String productStagesNo) {
        this.productStagesNo = productStagesNo;
    }

    private String byProductType;
    private String byProduct;
    private String byCustomerType;
    private String byCustomer;
    private String byAgentType;
    private String byAgent;
    private String byStatus;
    private String byCustomerName;

    public void setByCustomerName(String byCustomerName) {
        this.byCustomerName = byCustomerName;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }

    public void setByProductType(String byProductType) {
        this.byProductType = byProductType;
    }

    public void setByProduct(String byProduct) {
        this.byProduct = byProduct;
    }

    public void setByCustomerType(String byCustomerType) {
        this.byCustomerType = byCustomerType;
    }

    public void setByCustomer(String byCustomer) {
        this.byCustomer = byCustomer;
    }

    public void setByAgentType(String byAgentType) {
        this.byAgentType = byAgentType;
    }

    public void setByAgent(String byAgent) {
        this.byAgent = byAgent;
    }

    //upload file
    private String fileName;
    private String filePath;
    private String fileType;
    private Sales salesFile;

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

    public Sales getSalesFile() {
        return salesFile;
    }

    public void setSalesFile(Sales salesFile) {
        this.salesFile = salesFile;
    }

    private String productStatus;

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    private String dataId;
    private String dataEmpNo;

    public String getDataId() {
        return dataId;
    }

    public String getDataEmpNo() {
        return dataEmpNo;
    }

    public void setDataEmpNo(String dataEmpNo) {
        this.dataEmpNo = dataEmpNo;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getProductNo() {
        return productNo;
    }

    private String productNo;
    private String money;
    private String deptNo;
    private String status;
    private String peopleType;
    private String productType;
    private String customerType;
    private String customerNo;
    private String p2pCustomerNo;
    private String showAllList;
    private String showDirectList;
    private String showChannelList;
    private String showShopList;
    private String isP2PSales;
    private String payType;
    private String income;

    public void setIncome(String income) {
        this.income = income;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public void setP2pCustomerNo(String p2pCustomerNo) {
        this.p2pCustomerNo = p2pCustomerNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    public void setShowDirectList(String showDirectList) {
        this.showDirectList = showDirectList;
    }

    public void setShowChannelList(String showChannelList) {
        this.showChannelList = showChannelList;
    }

    public void setShowShopList(String showShopList) {
        this.showShopList = showShopList;
    }

    public void setIsP2PSales(String isP2PSales) {
        this.isP2PSales = isP2PSales;
    }

    private String baseNumber;

    public String getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(String baseNumber) {
        this.baseNumber = baseNumber;
    }

    public String getBsaeNumber() {
        this.baseNumber = String.valueOf(ProductModel.getInfo(Integer.parseInt(this.productNo)).getBaseNumber());
        return SUCCESS;
    }

    private String byDeptNo;
    private String byEmpNo;

    public String getByDeptNo() {
        return byDeptNo;
    }

    public void setByDeptNo(String byDeptNo) {
        this.byDeptNo = byDeptNo;
    }

    public String getByEmpNo() {
        return byEmpNo;
    }

    public void setByEmpNo(String byEmpNo) {
        this.byEmpNo = byEmpNo;
    }

    private String showSalesListForP2p;

    public String getShowSalesListForP2p() {
        return showSalesListForP2p;
    }

    public void setShowSalesListForP2p(String showSalesListForP2p) {
        this.showSalesListForP2p = showSalesListForP2p;
    }
    private String showSalesListForProduct;

    public String getShowSalesListForProduct() {
        return showSalesListForProduct;
    }

    public void setShowSalesListForProduct(String showSalesListForProduct) {
        this.showSalesListForProduct = showSalesListForProduct;
    }
    private String isExpire;
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public String getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(String isExpire) {
        this.isExpire = isExpire;
    }

    private SalesCondition getCondition() {
        SalesCondition salesCondition = new SalesCondition();
        salesCondition.setPageSize(this.getPageSize());
        salesCondition.setPageIndex(this.getPageIndex());
        if (!StringHelper.isNullOrEmpty(this.byCustomerName)) {
            salesCondition.setCustomerName(this.byCustomerName);
        } else {
            if ("query".equals(this.showAllList)) {
                salesCondition.setWorkMateString(null);
            } else if ("query".equals(this.showDirectList)) {
                salesCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_DIRECT));
            } else if ("query".equals(this.showChannelList)) {
                salesCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_CHANNEL));
            } else if ("query".equals(this.showShopList)) {
                salesCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_SHOP));
            } else if("query".equals(this.showSalesListForP2p)){
                salesCondition.setProductType(ProductType.P2P);
            }
            else {
                List<Integer> workMate = UserHelper.getUserCache().getWorkMate();
                if (workMate != null) {
                    workMate.add(UserHelper.getUserCache().getUserId());
                    String workMateString = StringHelper.listToString(workMate);
                    salesCondition.setWorkMateString(workMateString);
                } else {
                    salesCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
                }
            }
        }
        if (!StringHelper.isNullOrEmpty(this.byStatus)) {
            salesCondition.setStatus(Integer.parseInt(this.byStatus));
        }
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");

        if (!StringHelper.isNullOrEmpty(this.isExpire)&&this.isExpire.equals("true")) {
            salesCondition.setRepaymentDate(sdf.format(new Date()));
        }
        if (!StringHelper.isNullOrEmpty(this.byEmpNo)) {
            salesCondition.setByEmpNo(Integer.parseInt(this.byEmpNo));
        }
        if (!StringHelper.isNullOrEmpty(this.byDeptNo)) {
            List<Department> departmentList = new ArrayList<Department>();
            getWorkMateById(Integer.parseInt(this.byDeptNo), departmentList);
            List<Integer> workMate = new ArrayList<Integer>();
            for (Department department : departmentList) {
                workMate.add(department.getId());
            }
            workMate.add(Integer.parseInt(this.byDeptNo));
            salesCondition.setByDeptNo(StringHelper.listToString(workMate));
        }
        if (!StringHelper.isNullOrEmpty(this.byProductType)) {
            salesCondition.setProductType(Integer.parseInt(this.byProductType));
        }
        if (!StringHelper.isNullOrEmpty(this.byProduct)) {
            salesCondition.setProduct(Integer.parseInt(this.byProduct));
        }
        if (!StringHelper.isNullOrEmpty(this.byCustomerType)) {
            salesCondition.setCustomerType(Integer.parseInt(this.byCustomerType));
        }
        if (!StringHelper.isNullOrEmpty(this.byCustomer)) {
            salesCondition.setCustomer(Integer.parseInt(this.byCustomer));
        }
        if (!StringHelper.isNullOrEmpty(this.byAgentType)) {
            salesCondition.setAgentType(Integer.valueOf(this.byAgentType));
        }
        if (!StringHelper.isNullOrEmpty(this.byAgent)) {
            salesCondition.setAgent(Integer.valueOf(this.byAgent));
        }
        if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
            salesCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        } else {
            salesCondition.setIsTest((byte) 0);
        }
        if (!StringHelper.isNullOrEmpty(this.customerNo)) {
            salesCondition.setCustomer(Integer.parseInt(this.customerNo));
        }
        if (!StringHelper.isNullOrEmpty(this.payType)) {
            salesCondition.setPayType(Integer.parseInt(this.payType));
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        salesCondition.setSortItemList(sortItemList);
        return salesCondition;
    }

    private String getEmpStringByDeptType(int deptType) {
        List<String> empList = new ArrayList<>();
        List<Department> departmentList = DepartmentModel.getDeptListByType(deptType);
        if (!ArrayHelper.isNullOrEmpty(departmentList)) {
            for (Department department : departmentList) {
                List<Employee> employeeList = EmployeeModel.getEmpListByDept(department.getId());
                if (!ArrayHelper.isNullOrEmpty(employeeList)) {
                    for (Employee employee : employeeList) {
                        empList.add(String.valueOf(employee.getUserNo()));
                    }
                }
            }
        }
        return StringHelper.listToString(empList);
    }

    private void getWorkMateById(int id, List<Department> departmentList) {
        List<Department> departmentWorkMate = DepartmentModel.getDeptListByParentNo(id);
        if (departmentWorkMate != null && departmentWorkMate.size() > 0) {
            departmentList.addAll(departmentWorkMate);
            for (Department WorkMate : departmentWorkMate) {
                this.getWorkMateById(WorkMate.getId(), departmentList);
            }
        }
    }

    private static final LogHelper logger = LogHelper.getLogger(AjaxSalesAction.class.getName());
    private static final SalesLogHelper salesLog = SalesLogHelper.getLogger(AjaxSalesAction.class.getName());
    @Override
    public String execute() throws Exception {

        PagedList<Sales> salesPagedList = SalesModel.getPagingList(this.getCondition());
        List<Sales> tList = new ArrayList<Sales>();
        tList = salesPagedList.getResultList();
        Sales sales = new Sales();
        P2pProduct p2pProduct = new P2pProduct();
        Product product = new Product();
        for (int i = 0; i < tList.size(); i++) {
            sales=tList.get(i);
            if(sales.getProductType()==5){
                p2pProduct=P2pProductModel.getP2pByProductNo(sales.getProductNo());
                if(p2pProduct!=null){
                    sales.setEditComment(p2pProduct.getName());
                    sales.setP2pCustomerNo(p2pProduct.getId());
                }
            }else{
                product=ProductModel.getInfo(sales.getProductNo());
                sales.setEditComment(product.getName());
            }
        }
        this.setResultList(tList);
        this.setPageCount(salesPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(salesPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(salesPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String getListByCustomer() {
        PagedList<Sales> salesPagedList = SalesModel.getPagingList(this.getCondition());
        for(Sales sales:salesPagedList.getResultList()){
            if(sales.getProductType()==5){
                sales.setEditComment(P2pProductModel.getP2pByProductNo(sales.getProductNo()).getName());
                sales.setP2pCustomerNo(P2pProductModel.getP2pByProductNo(sales.getProductNo()).getId());
            }else{
                sales.setEditComment(ProductModel.getInfo(sales.getProductNo()).getName());
            }
        }
        this.setResultList(salesPagedList.getResultList());
        this.setPageCount(salesPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(salesPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(salesPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            Sales sales = SalesModel.getInfo(Integer.parseInt(this.getId()));
            if (sales == null) {
                this.setErrCode("NoSales");
                this.setErrDesc("NoSales");
                return SUCCESS;
            }
            Product product = ProductModel.getInfo(sales.getProductNo());
            this.setProductStatus(String.valueOf(product.getStatus()));
            this.info = sales;
        }
        return SUCCESS;
    }

    public String getRepaymentDate(){

        if (StringHelper.isNullOrEmpty(this.productNo)) {
            this.setErrCode("failed");
            this.setErrDesc("false");
            return SUCCESS;
        }else{
            this.p2pProduct = P2pProductModel.getP2pByProductNo(Integer.valueOf(this.productNo));
            if (p2pProduct != null) {
                this.setErrDesc("0000");
                this.setErrCode("0000");
            }
        }
        return SUCCESS;
    }
    public String edit() throws ParseException {
        info.setBaseNumber(ProductModel.getInfo(info.getProductNo()).getBaseNumber());
        //info.setEditComment(this.getEditComment());
        info.setEditUserNo(UserHelper.getEditUserNo());

        P2pProduct p2pProduct = P2pProductModel.getP2pByProductNo(info.getProductNo());
        if(p2pProduct!=null){
            info.setP2pProductNo(p2pProduct.getId());
            info.setP2pProductName(p2pProduct.getName());
            info.setPaymentType(p2pProduct.getRepaymentIssue());
        }
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            String r = CodeHelper.getCode("codeSales", "XS");
            if (!StringHelper.isNullOrEmpty(r)) {
                info.setCode(r);
            }
            info.setDeptNo(EmployeeModel.getEmpByUserId(info.getEmpNo()).getDeptNo());
            int salesID = SalesModel.add(info);
            if (salesID <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
                salesLog.addSalesLog("新建打款 异常",JSON.toJSONString(this.info),info.getId(),"add failed");
            } else {
                salesLog.addSalesLog("新建打款",JSON.toJSONString(this.info),info.getId());
                this.setDataId(String.valueOf(salesID));
                this.setDataEmpNo(String.valueOf(info.getEmpNo()));
            }
        } else {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    if (SalesModel.update(info) <= 0) {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                        salesLog.addSalesLog("修改打款 异常",JSON.toJSONString(this.info),info.getId(),"update failed");
                    }
                    salesLog.addSalesLog("修改打款",JSON.toJSONString(this.info),info.getId());
                }
            }
        }
        return SUCCESS;
    }

    public String updateStatusForProduct() throws Exception {
        if (this.getId().isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        Sales sales = SalesModel.getInfo(Integer.parseInt(this.getId()));
        int productNo = sales.getProductNo();
        long money = sales.getMoney();
        int deptNo = EmployeeModel.getEmpByUserId(sales.getEmpNo()).getDeptNo();
        if (DepartmentModel.getInfo(EmployeeModel.getEmpByUserId(sales.getEmpNo()).getDeptNo()).getDeptType() == DeptType.PRIVATE_BANK) {
            deptNo = DeptType.SALES_DIRECT;
        }
        if (deptNo == DeptType.SALES_CHANNEL || deptNo == DeptType.SALES_DIRECT) {
            if (ProductTaskModel.updateAddCurrentAmount(productNo, money, deptNo) <= 0) {
                this.setErrCode("updateProductTaskStatus failed");
                this.setErrDesc("updateProductTaskStatus failed");
                salesLog.addSalesLog("更新承销金额",JSON.toJSONString(money),Integer.parseInt(this.getId()),"updateProductTaskStatus failed");
                return SUCCESS;
            }
        }
        if (SalesModel.updateStatus(Integer.parseInt(this.getId()), SalesStatus.account) <= 0) {
            this.setErrCode("updateSalesStatus failed");
            this.setErrDesc("updateSalesStatus failed");
            salesLog.addSalesLog("更新打款状态",JSON.toJSONString(sales),SalesStatus.account,"updateSalesStatus failed");
            return SUCCESS;
        }
        if (money <= 3000000) {
            //审核通过减少小额剩余量和剩余额度
            if (ProductModel.updateReduceRemainAmountAndRemainSmall(productNo, money) <= 0) {
                this.setErrCode("updateReduceRemainAmountAndRemainSmall failed");
                this.setErrDesc("updateReduceRemainAmountAndRemainSmall failed");
                salesLog.addSalesLog("减少产品剩余额度和剩余小额",JSON.toJSONString(money),Integer.parseInt(this.getId()),"updateReduceRemainAmountAndRemainSmall failed");
                return SUCCESS;
            }
        } else {
            //审核通过减少剩余额度
            if (ProductModel.updateReduceRemainAmount(productNo, money) <= 0) {
                this.setErrCode("updateReduceRemainAmount failed");
                this.setErrDesc("updateReduceRemainAmount failed");
                salesLog.addSalesLog("减少产品剩余额度",JSON.toJSONString(money),Integer.parseInt(this.getId()),"updateReduceRemainAmount failed");
                return SUCCESS;
            }
        }

        salesLog.addSalesLog("更新打款状态",JSON.toJSONString(sales),Integer.parseInt(this.getId()));
        this.updateTradeTotalBySales(sales, money);
        return SUCCESS;
    }

    public void updateTradeTotalBySales(Sales sales, double money) {
        //更新(增加)客户的累计购买金额
        if (sales.getCustomerType() == StatusType.CUSTOMER_PERSONAL_TYPE) {
            if (CustomerPersonalModel.updateTradeTotalById(sales.getCustomerNo(), money) <= 0) {
                this.setErrCode("updateCustomerPersonal  tradeTotal failed");
                this.setErrDesc("updateCustomerPersonal tradeTotal failed");
                salesLog.addSalesLog("更新客户累计购买量 (自然人客户)",String.valueOf(money),sales.getId(),"updateCustomerPersonal  tradeTotal failed");
            }
        } else if (sales.getCustomerType() == StatusType.CUSTOMER_COMPANY_TYPE) {
            if (CustomerCompanyModel.updateTradeTotalById(sales.getCustomerNo(), money) <= 0) {
                this.setErrCode("updateCustomerCompany tradeTotal failed");
                this.setErrDesc("updateCustomerCompany tradeTotal failed");
                salesLog.addSalesLog("更新客户累计购买量（法人客户）",String.valueOf(money),sales.getId(),"updateCustomerPersonal  tradeTotal failed");
            }
        }
        if (sales.getPeopleType() == StatusType.AGENT_ADVISER_TYPE) {
            if (AgentAdviserModel.updateTradeTotalById(sales.getPeopleNo(), money) <= 0) {
                this.setErrCode("updateAgentAdviser tradeTotal failed");
                this.setErrDesc("updateAgentAdviser tradeTotal failed");
                salesLog.addSalesLog("更新客户累计购买量（兼职投顾）",String.valueOf(money),sales.getId(),"updateCustomerPersonal  tradeTotal failed");
            }
        } else if (sales.getPeopleType() == StatusType.AGENT_BUSINESS_TYPE) {
            if (AgentBusinessModel.updateTradeTotalById(sales.getPeopleNo(), money) <= 0) {
                this.setErrCode("updateAgentBusiness tradeTotal failed");
                this.setErrDesc("updateAgentBusiness tradeTotal failed");
                salesLog.addSalesLog("更新客户累计购买量（销售代理商）",String.valueOf(money),sales.getId(),"updateCustomerPersonal  tradeTotal failed");
            }
        }
        salesLog.addSalesLog("更新客户累计购买量",JSON.toJSONString(CustomerPersonalModel.getInfo(sales.getCustomerNo())),sales.getId());
    }

    public String updateStatusForOnLine() {
        //P2P打款审核通过后，进行转账确认
        CompleteTransactionReq completeTransactionReq = new CompleteTransactionReq();
        completeTransactionReq.setPlatformNo("");
        completeTransactionReq.setRequestNo(String.valueOf(this.getId()));
        completeTransactionReq.setMode(TransferStatus.CONFRIM);
        completeTransactionReq.setNotifyUrl(UrlHelper.buildBackUrl("/sales/sales/completeTransactionNotifyConfirm"));
        try {
            ControllerModel.getCompleteTransaction(completeTransactionReq);
        } catch (Exception e) {
            logger.error("转账授权确认失败", e);
        }
        return SUCCESS;
    }
    public String updateStatusCancelForOnLine() {
        try {
            //P2P打款失败后，进行转账确认取消
            CompleteTransactionReq completeTransactionReq = new CompleteTransactionReq();
            completeTransactionReq.setPlatformNo("");
            completeTransactionReq.setRequestNo(String.valueOf(this.getId()));
            completeTransactionReq.setMode(TransferStatus.CANCEL);
            completeTransactionReq.setNotifyUrl(UrlHelper.buildBackUrl("/sales/sales/completeTransactionNotifyCancel"));
            ControllerModel.getCompleteTransaction(completeTransactionReq);
        } catch (Exception e) {
            this.setErrCode("failed");
            logger.error("转账授权失败操作出现异常", e);
        }
        if (SalesModel.updateStatus(Integer.valueOf(this.getId()), SalesStatus.CANCEL) <= 0) {
            this.setErrCode("failed");
            this.setErrDesc("更新打款状态出现异常");
            salesLog.addSalesLog("更新打款状态 异常",JSON.toJSONString(SalesStatus.CANCEL),Integer.parseInt(this.getId()),"failed");
        }
        salesLog.addSalesLog("更新打款状态",JSON.toJSONString(SalesStatus.CANCEL),Integer.parseInt(this.getId()));
        return SUCCESS;
    }

    public static int insertPaymentMoneyChange(String p2pcustomerName,int p2pCustomerNo,byte moneyChangeType,byte moneyTransferType,
                             double moneyAmountLater,double moneyAmountPre,double moneyWinthdraw,String refSn,int orderNo){
        PaymentMoneyChange paymentMoneyChange = new PaymentMoneyChange();
        paymentMoneyChange.setP2pCustomerName(p2pcustomerName);
        paymentMoneyChange.setP2pCustomerNo(p2pCustomerNo);
        paymentMoneyChange.setMoneyChangeType(moneyChangeType);
        paymentMoneyChange.setMoneyTransferType(moneyTransferType);
        paymentMoneyChange.setMoneyAmountLater(moneyAmountLater);
        paymentMoneyChange.setMoneyAmountPre(moneyAmountPre);
        paymentMoneyChange.setMoneyWithdraw(moneyWinthdraw);
        paymentMoneyChange.setRefSn(refSn);
        paymentMoneyChange.setOrderNo(String.valueOf(orderNo));
        return PaymentMoneyChangeModel.add(paymentMoneyChange);
    }
    public String ajaxRecoveryBySalesNo(){
        if(SalesModel.updateStatus(this.salesNo,SalesStatus.Submit)<=0){
            this.setErrCode("failed");
            this.setErrDesc("恢复订单（更新状态）失败");
            salesLog.addSalesLog("恢复订单（更新状态）失败","",this.salesNo,"failed");
        }
        if(SalesModel.updateActivitiNoBySalesNo(this.salesNo,"")<=0){
            this.setErrCode("failed");
            this.setErrDesc("恢复订单（删除流程）失败");
            salesLog.addSalesLog("恢复订单（删除流程）失败","",this.salesNo,"failed");
        }
        salesLog.addSalesLog("恢复订单","",this.salesNo);
        return SUCCESS;
    }


    public String updateStatusCancelForProduct() {
        if (SalesModel.updateStatus(Integer.valueOf(this.getId()), SalesStatus.CANCEL) <= 0) {
            this.setErrCode("failed");
            this.setErrDesc("更新打款状态出现异常");
            salesLog.addSalesLog("更新打款状态 异常",JSON.toJSONString(SalesStatus.CANCEL),Integer.parseInt(this.getId()),"failed");
        }else{
            salesLog.addSalesLog("更新打款状态",JSON.toJSONString(SalesStatus.CANCEL),Integer.parseInt(this.getId()));
        }

        return SUCCESS;
    }

    public String cancelSalesForP2pProduct() {
        if (this.getId().isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        int id = Integer.valueOf(this.getId());
        Sales sales = SalesModel.getInfo(id);
        int productNo = sales.getProductNo();
        long money = sales.getMoney();
        if (ProductModel.updateAddRemainAmount(productNo, money) <= 0) {
            this.setErrCode("updateAddRemainAmount failed");
            this.setErrDesc("还原产品额度出现异常，请联系系统管理员");
            salesLog.addSalesLog("取消订单（还原产品额度）异常",JSON.toJSONString(money),id,"updateAddRemainAmount failed");
            return SUCCESS;
        }
        salesLog.addSalesLog("取消订单（还原产品额度）",JSON.toJSONString(money),id);
        if (P2pProductModel.updateRemainAmountByProductNo(productNo, money) <= 0) {
            this.setErrCode("updateRemainAmountByProductNo failed");
            this.setErrDesc("还原新金融产品额度出现异常，请联系系统管理员");
            salesLog.addSalesLog("取消订单（还原新金融产品额度）异常",JSON.toJSONString(money),id,"updateRemainAmountByProductNo failed");
            return SUCCESS;
        }
        salesLog.addSalesLog("取消订单（还原新产品额度）",JSON.toJSONString(money),id);
        if (sales.getCustomerType() == StatusType.CUSTOMER_PERSONAL_TYPE) {
            if (CustomerPersonalModel.updateTradeTotalById(sales.getCustomerNo(), -money) <= 0) {
                this.setErrCode("updateCustomerPersonal  tradeTotal failed");
                this.setErrDesc("还原自然人客户累积购买出现异常，请联系系统管理员");
                salesLog.addSalesLog("取消订单（还原自然人客户累计购买量）异常",JSON.toJSONString(money),id,"updateCustomerPersonal  tradeTotal failed");
                return SUCCESS;
            }
            salesLog.addSalesLog("取消订单（还原自然人客户累计购买量）",JSON.toJSONString(money),id);
        } else if (sales.getCustomerType() == StatusType.CUSTOMER_COMPANY_TYPE) {
            if (CustomerCompanyModel.updateTradeTotalById(sales.getCustomerNo(), -money) <= 0) {
                this.setErrCode("updateCustomerCompany tradeTotal failed");
                this.setErrDesc("还原法人客户累积购买出现异常，请联系系统管理员");
                salesLog.addSalesLog("取消订单（还原法人客户累计购买量）异常",JSON.toJSONString(money),id,"updateCustomerCompany tradeTotal failed");
                return SUCCESS;
            }
            salesLog.addSalesLog("取消订单（还原法人客户累计购买量）",JSON.toJSONString(money),id);
        }
        try {
            SalesModel.updateCreditorAndPaymentRefundBySaleNo(id);
            salesLog.addSalesLog("取消订单（还原债权及还款数据）","",id);
        }catch (Exception e){
            this.setErrCode("updateCreditorAndPaymentRefundBySaleNo failed");
            this.setErrDesc("还原债权出现异常，请联系系统管理员");
            salesLog.addSalesLog("取消订单（还原债权及还款数据）异常","",id,"updateCreditorAndPaymentRefundBySaleNo failed");
            return SUCCESS;
        }

        if(P2pProductModel.updateOrderCountByProductNo(productNo,-1) == 0){
            this.setErrCode("updateOrderCountByProductNo failed");
            this.setErrDesc("减少打款个数出现，请联系系统管理员");
            salesLog.addSalesLog("取消订单（还原打款个数）异常","",id,"updateOrderCountByProductNo failed");
        }
        salesLog.addSalesLog("取消订单（还原打款个数）",JSON.toJSONString(productNo),id);

        try {
            ActRuTaskModel.deleteByActivitiNo(sales.getActivitiNo());
        }catch (Exception e){
            this.setErrCode("deleteByActivitiNo failed");
            this.setErrDesc("删除流程出现异常，请联系系统管理员");
            salesLog.addSalesLog("取消订单（删除流程）异常",sales.getActivitiNo(),id,"deleteByActivitiNo failed");
            return SUCCESS;
        }
        salesLog.addSalesLog("取消订单（删除流程）",sales.getActivitiNo(),id);
        try {
            ActHiProcinstModel.completeHistoryTaskByActivitiNo(sales.getActivitiNo());
        }catch (Exception e){
            this.setErrCode("completeHistoryTaskByActivitiNo failed");
            this.setErrDesc("完成历史流程出现异常，请联系系统管理员");
            salesLog.addSalesLog("取消订单（完成历史流程）异常",sales.getActivitiNo(),id,"completeHistoryTaskByActivitiNo failed");
            return SUCCESS;
        }
        salesLog.addSalesLog("取消订单（完成历史流程）",sales.getActivitiNo(),id);
        if (SalesModel.updateStatus(id, SalesStatus.CANCEL) <= 0) {
            this.setErrCode("updateSalesStatus failed");
            this.setErrDesc("更改打款状态为已取消出现异常，请联系系统管理员");
            salesLog.addSalesLog("取消订单（更改打款状态）异常",JSON.toJSONString(SalesStatus.CANCEL),id,"updateSalesStatus failed");
            return SUCCESS;
        }
        salesLog.addSalesLog("取消订单（更改打款状态）",JSON.toJSONString(SalesStatus.CANCEL),id);
        return SUCCESS;
    }

    public String cancelSalesForProduct() {
        if (this.getId().isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        int id = Integer.parseInt(this.getId());
        byte status = Byte.parseByte(this.status);
        Sales sales = SalesModel.getInfo(id);
        if (SalesModel.updateStatus(id, status) <= 0) {
            this.setErrCode("updateSalesStatus failed");
            this.setErrDesc("updateSalesStatus failed");
            return SUCCESS;
        }
        //取消订单减少该部门的销售金额
        int productNo = sales.getProductNo();
        long money = sales.getMoney();
        int deptNo = EmployeeModel.getEmpByUserId(sales.getEmpNo()).getDeptNo();
        if (deptNo == DeptType.SALES_CHANNEL || deptNo == DeptType.SALES_DIRECT) {
            if (ProductTaskModel.updateReduceCurrentAmount(productNo, money, deptNo) <= 0) {
                this.setErrCode("updateReduceCurrentAmount failed");
                this.setErrDesc("updateReduceCurrentAmount failed");
                return SUCCESS;
            }
        }
        //更新(减少)客户的累计购买金额
        if (!StringHelper.isNullOrEmpty(this.customerType) && !StringHelper.isNullOrEmpty(this.customerNo)) {
            if (Byte.valueOf(this.customerType) == StatusType.CUSTOMER_PERSONAL_TYPE) {
                if (CustomerPersonalModel.updateTradeTotalById(Integer.valueOf(this.customerNo), -Double.valueOf(this.money)) <= 0) {
                    this.setErrCode("updateCustomerPersonal  tradeTotal failed");
                    this.setErrDesc("updateCustomerPersonal tradeTotal failed");
                }
            } else if (Byte.valueOf(this.customerType) == StatusType.CUSTOMER_COMPANY_TYPE) {
                if (CustomerCompanyModel.updateTradeTotalById(Integer.valueOf(this.customerNo), -Double.valueOf(this.money)) <= 0) {
                    this.setErrCode("updateCustomerCompany tradeTotal failed");
                    this.setErrDesc("updateCustomerCompany tradeTotal failed");
                }
            }
            if (sales.getPeopleType() == StatusType.AGENT_ADVISER_TYPE) {
                if (AgentAdviserModel.updateTradeTotalById(Integer.valueOf(this.customerNo), -Double.valueOf(this.money)) <= 0) {
                    this.setErrCode("updateAgentAdviser tradeTotal failed");
                    this.setErrDesc("updateAgentAdviser tradeTotal failed");
                }
            } else if (sales.getPeopleType() == StatusType.AGENT_BUSINESS_TYPE) {
                if (AgentBusinessModel.updateTradeTotalById(Integer.valueOf(this.customerNo), -Double.valueOf(this.money)) <= 0) {
                    this.setErrCode("updateAgentBusiness tradeTotal failed");
                    this.setErrDesc("updateAgentBusiness tradeTotal failed");
                }
            }
        }
        if (money < 3000000) {
            //取消订单增加该产品的小额剩余量和和剩余额度
            if (ProductModel.updateAddRemainAmountAndRemainSmall(productNo, money) <= 0) {
                this.setErrCode("updateAddRemainAmountAndRemainSmall failed");
                this.setErrDesc("updateAddRemainAmountAndRemainSmall failed");
                return SUCCESS;
            }
        } else {
            //取消订单增加和剩余额度
            if (ProductModel.updateAddRemainAmount(productNo, money) <= 0) {
                this.setErrCode("updateAddRemainAmount failed");
                this.setErrDesc("updateAddRemainAmount failed");
                return SUCCESS;
            }
        }
        return SUCCESS;
    }

    public String modifyP2PSalesStatus() {
        if (this.getId().isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        int id = Integer.parseInt(this.getId());
        byte status = Byte.parseByte(this.status);
        if (SalesModel.updateStatus(id, status) <= 0) {
            this.setErrCode("updateSalesStatus failed");
            this.setErrDesc("updateSalesStatus failed");
            return SUCCESS;
        }
        return SUCCESS;
    }


    public String exportExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.getExcelForSales(this.getCondition());
        return null;
    }
    public String ajaxAbandonedSales() {
        if(this.salesNo==0){
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        if(SalesModel.updateStatus(this.salesNo,SalesStatus.CANCEL)<=0){
            this.setErrCode("failed");
            this.setErrDesc("操作失败");
            salesLog.addSalesLog("废弃订单 （异常）",String.valueOf(SalesStatus.CANCEL),this.salesNo,"failed");
        }
        salesLog.addSalesLog("废弃订单",String.valueOf(SalesStatus.CANCEL),this.salesNo);
        return SUCCESS;
    }
    public String verifyMoney() {
        if (StringHelper.isNullOrEmpty(this.productNo) || StringHelper.isNullOrEmpty(this.money)) {
            this.setErrCode("failed");
            this.setErrDesc("false");
            return SUCCESS;
        }
        if (Byte.valueOf(this.productType) != ProductType.P2P) {
            Product product = ProductModel.getInfo(Integer.valueOf(this.productNo));
            if (Long.valueOf(this.money) > product.getRemainAmount()) {
                this.setErrCode("failed");
                this.setErrDesc("此产品剩余额度不足，仅剩" + product.getRemainAmount() + "元");
            }
        } else {
            P2pProduct p2pProduct = P2pProductModel.getP2pByProductNo(Integer.valueOf(this.productNo));
            if (Long.valueOf(this.money) > p2pProduct.getRemainAmout()) {
                this.setErrCode("failed");
                this.setErrDesc("此产品剩余额度不足，仅剩" + p2pProduct.getRemainAmout() + "元");
            }
        }
        return SUCCESS;
    }

    private P2pProduct p2pProduct;

    public P2pProduct getP2pProduct() {
        return p2pProduct;
    }

    public void setP2pProduct(P2pProduct p2pProduct) {
        this.p2pProduct = p2pProduct;
    }


    public String ajaxPaymentRefund() throws Exception{
        int salesId = Integer.valueOf(this.getId());
        PaymentRefundModel.deleteBySaleNo(salesId);
        Sales sales = SalesModel.getInfo(salesId);
        P2pProduct p2pProduct = P2pProductModel.getP2pByProductNo(sales.getProductNo());
        p2pProduct.setIncome(Double.valueOf(sales.getIncome()) / 100.00);
        p2pProduct.setEnd(sales.getRepaymentDate());
        Product product = ProductModel.getInfo(sales.getProductNo());
        PaymentRefund paymentRefund = new PaymentRefund();
        paymentRefund.setSalesNo(sales.getId());
        paymentRefund.setProductType(product.getType());
        paymentRefund.setP2pProductNo(p2pProduct.getId());
        paymentRefund.setP2pProductName(p2pProduct.getName());
        paymentRefund.setProductNo(sales.getProductNo());
        paymentRefund.setProductName(product.getName());
        paymentRefund.setCustomerNo(sales.getCustomerNo());
        paymentRefund.setCustomerName(sales.getCustomerName());
        paymentRefund.setPayerNo(p2pProduct.getBorrowerUserNo());
        paymentRefund.setPayerName(p2pProduct.getBorrowerUserName());
        paymentRefund.setPayStartTime(sales.getPurchaseDate());
        paymentRefund.setSalesMoney(sales.getMoney());
        paymentRefund.setStatus(StatusType.WAITPAYMENT);
        paymentRefund.setIsSendSms(1);
        try {
            PaymentRefundModel.calculatePaymentRefund(paymentRefund, p2pProduct);
            salesLog.addSalesLog("生成还款","",salesId);
        } catch (Exception e) {
            this.setErrCode("failure");
            this.setErrDesc("计算还款出现异常，请联系系统管理员");
            salesLog.addSalesLog("生成还款(异常)","",salesId,e.getMessage());
        }
        return SUCCESS;
    }
    public String buildPaymentRefund(){
        int salesId = Integer.valueOf(this.getId());
        SalesModel.updateCreditorAndPaymentRefundBySaleNo(salesId);
        Sales sales = SalesModel.getInfo(salesId);
        CustomerPersonal customerPersonal = CustomerPersonalModel.getInfo(sales.getCustomerNo());
        int productNo = sales.getProductNo();
        long money = sales.getMoney();
        //insert data into paymentRefund by sales detail
        P2pProduct p2pProduct = P2pProductModel.getP2pByProductNo(productNo);
        p2pProduct.setIncome(Double.valueOf(sales.getIncome()) / 100.00);
        p2pProduct.setEnd(sales.getRepaymentDate());
        Product product = ProductModel.getInfo(productNo);
        PaymentRefund paymentRefund = new PaymentRefund();
        paymentRefund.setSalesNo(sales.getId());
        paymentRefund.setProductType(product.getType());
        paymentRefund.setP2pProductNo(p2pProduct.getId());
        paymentRefund.setP2pProductName(p2pProduct.getName());
        paymentRefund.setProductNo(productNo);
        paymentRefund.setProductName(product.getName());
        paymentRefund.setCustomerNo(sales.getCustomerNo());
        paymentRefund.setP2pCustomerNo(customerPersonal.getP2pCustomerNo());
        paymentRefund.setCustomerName(sales.getCustomerName());
        paymentRefund.setPayerNo(p2pProduct.getBorrowerUserNo());
        paymentRefund.setPayerName(p2pProduct.getBorrowerUserName());
        paymentRefund.setPayStartTime(sales.getPurchaseDate());
        paymentRefund.setSalesMoney(money);
        paymentRefund.setStatus(StatusType.WAITPAYMENT);
        paymentRefund.setIsSendSms(1);
        try {
            PaymentRefundModel.calculatePaymentRefund(paymentRefund, p2pProduct);
            salesLog.addSalesLog("生成还款","",salesId);
        } catch (Exception e) {
            this.setErrCode("failure");
            this.setErrDesc("计算还款出现异常，请联系系统管理员");
            salesLog.addSalesLog("生成还款(异常)","",salesId,e.getMessage());
        }
        try {
            SalesCreditorModel.distributionCreditor(salesId);
            salesLog.addSalesLog("分配债权","",salesId);
        }catch (Exception e){
            this.setErrCode("failure");
            this.setErrDesc("分配债权出现异常，请联系系统管理员");
            salesLog.addSalesLog("分配债权(异常)","",salesId,e.toString());
        }
        return SUCCESS;
    }

    public String modifyIncome() throws  Exception{
        SalesModel.getInfo(Integer.valueOf(this.getId())).getMoney();
        if(SalesModel.updateIncomeById(Integer.valueOf(this.getId()),Double.valueOf(this.income))<= 0){
            this.setErrCode("failure");
            this.setErrDesc("修改利率出现异常，请联系系统管理员");
            salesLog.addSalesLog("修改费率(异常)",this.income,Integer.valueOf(this.getId()),"failure");
        }
        salesLog.addSalesLog("修改费率",this.income,Integer.valueOf(this.getId()));
        return SUCCESS;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEnclosureBySalesNo(){
        if(this.type==0){
            if(ActivityAttachmentModel.getListBySalesNoAndType(this.salesNo,1).size()>0 &&
                    ActivityAttachmentModel.getListBySalesNoAndType(this.salesNo,2).size()>0 &&
                    ActivityAttachmentModel.getListBySalesNoAndType(this.salesNo,3).size()>0){
                this.path = "ok";
            }
        }else{
           if(ActivityAttachmentModel.getListBySalesNoAndType(this.salesNo,4).size()>0){
               this.path = "ok";
           }
        }
        return SUCCESS;
    }

}

