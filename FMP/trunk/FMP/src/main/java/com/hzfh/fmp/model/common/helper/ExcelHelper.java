package com.hzfh.fmp.model.common.helper;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.employee.model.*;
import com.hzfh.api.employee.model.query.*;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.helper.GenerateExcelTemplate.XLSCallBack;
import com.hzfh.fmp.model.customer.*;
import com.hzfh.fmp.model.employee.*;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.permission.UserModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.ActivityModel;
import com.hzfh.fmp.model.sales.ApplyEmployeeModel;
import com.hzfh.fmp.model.sales.SalesModel;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class ExcelHelper {

    public void getExcelForCustomerPersonal(CustomerPersonalCondition condition, String showAllList) {

        List<CustomerPersonal> customerPersonalList = CustomerPersonalModel.getListForExcelT(condition);

        GenerateExcelTemplate<CustomerPersonal> generateExcelTemplate = new GenerateExcelTemplate<CustomerPersonal>(customerPersonalList);

        XLSCallBack<CustomerPersonal> xlscaCallBack = new XLSCallBack<CustomerPersonal>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "姓名", "证件号码", "性别", "邮箱", "微信",
                        "QQ", "电话", "手机1", "手机2", "生日",
                        "住址", "婚姻", "公司", "行业", "关系等级",
                        "风险偏好","部门", "负责人", "客户资产", "累计购买",
                        "增加时间","备注" };
                return headers;
            }

            @Override
            public String[] getValue(CustomerPersonal t)
                    throws RuntimeException {
                String managerName = "";
                if (t.getAgentNo()!=0) {
                    Employee e = EmployeeModel.getEmpByUserId(t.getAgentNo());
                    if (e!=null) {
                        managerName = e.getName();
                    }
                }
                String[] values = {
                        t.getName()==null?"":t.getName(),
                        t.getCardNumber()==null?"":t.getCardNumber(),
                        t.getSex()==0?"":DicDataModel.getDicDataByTypeAndCode(1, t.getSex()).getValue(),
                        t.getEmail()==null?"":t.getEmail(),
                        t.getWeixin()==null?"":t.getWeixin(),
                        t.getQq()==null?"":t.getQq(),
                        t.getPhone()==null?"":t.getPhone(),
                        t.getCellphone1()==null?"":t.getCellphone1(),
                        t.getCellphone2()==null?"":t.getCellphone2(),
                        t.getBirthday()==null?"":t.getBirthday().toString(),
                        t.getAddress()==null?"":t.getAddress(),
                        t.getMarry()==0?"":DicDataModel.getDicDataByTypeAndCode(9, t.getMarry()).getValue(),
                        t.getCompanyName()==null?"":t.getCompanyName(),
                        t.getField()==null?"":t.getField(),
                        t.getRelationLevel()==0?"":DicDataModel.getDicDataByTypeAndCode(11, t.getRelationLevel()).getValue(),
                        t.getRiskHobby()==0?"":DicDataModel.getDicDataByTypeAndCode(12, t.getRiskHobby()).getValue(),
                        DepartmentModel.getInfo(EmployeeModel.getEmpByUserId(t.getAgentNo()).getDeptNo()).getName(),
                        t.getAgentNo()==0?"":EmployeeModel.getEmpByUserId(t.getAgentNo()).getName(),
                        t.getWealth()==0?"":String.valueOf(t.getWealth()),
                        t.getTradeTotal()==0?"":String.valueOf(t.getTradeTotal()),
                        t.getFindTime()==null?"":String.valueOf(t.getFindTime()),
                        t.getEditComment()==null?"":t.getEditComment()
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "自然人客户";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "自然人客户 工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 30, 20, 10, 10, 10,
                        10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10,
                        10, 10, 10, 10, 20,
                        30 ,10, 10};
                return columnWidth;
            }
        };
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "自然人客户.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getExcelForCustomerCompany(CustomerCompanyCondition customerCompanyCondition, String showAllList) {

        List<CustomerCompany> customerCompanyList = CustomerCompanyModel.getListForExcelT(customerCompanyCondition);

        GenerateExcelTemplate<CustomerCompany> generateExcelTemplate = new GenerateExcelTemplate<CustomerCompany>(customerCompanyList);

        XLSCallBack<CustomerCompany> xlscaCallBack = new XLSCallBack<CustomerCompany>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {
                        "企业名称", "地址","电话", "邮箱","联系人", "行业",
                        "联系人电话", "联系人手机1","联系人手机2", "营业执照","税务证", "组织机构代码",
                        "关系等级", "风险偏好","负责人", "资产","购买额", "新增时间"
                };
                return headers;
            }
            @Override
            public String[] getValue(CustomerCompany t) throws RuntimeException {
                String[] values = {
                        t.getName()==null?"":t.getName(),
                        t.getAddress()==null?"":t.getAddress(),
                        t.getTelephone()==null?"":t.getTelephone(),
                        t.getEmail()==null?"":t.getEmail(),
                        t.getField()==null?"":t.getField(),
                        t.getContactName()==null?"":t.getContactName(),
                        t.getContactTelephone()==null?"":t.getContactTelephone(),
                        t.getContactCellphone1()==null?"":t.getContactCellphone1(),
                        t.getContactCellphone2()==null?"":t.getContactCellphone2(),
                        t.getCardLicense()==null?"":t.getCardLicense(),
                        t.getCardTax()==null?"":t.getCardTax(),
                        t.getCardNumber()==null?"":t.getCardNumber(),
                        t.getRelationLevel()==0?"":DicDataModel.getDicDataByTypeAndCode(11, t.getRelationLevel()).getValue(),
                        t.getRiskHobby()==0?"":DicDataModel.getDicDataByTypeAndCode(12, t.getRiskHobby()).getValue(),
                        t.getAgentNo()==0?"":EmployeeModel.getEmpByUserId(t.getAgentNo()).getName(),
                        t.getWealth()==0?"":String.valueOf(t.getWealth()),
                        t.getTradeTotal()==0?"":String.valueOf(t.getTradeTotal()),
                        t.getFindTime()==null?"":String.valueOf(t.getFindTime())
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "法人客户";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "法人客户 工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10 };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "法人客户.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getExcelForAgentAdviser(AgentAdviserCondition agentAdviserCondition, String showAllList) {

        List<AgentAdviser> agentAdviserList = AgentAdviserModel.getListForExcelT(agentAdviserCondition);

        GenerateExcelTemplate<AgentAdviser> generateExcelTemplate = new GenerateExcelTemplate<AgentAdviser>(agentAdviserList);

        XLSCallBack<AgentAdviser> xlscaCallBack = new XLSCallBack<AgentAdviser>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {
                        "姓名","邮箱","微信", "QQ","手机1", "手机2","电话","负责人", "住址" };
                return headers;
            }

            @Override
            public String[] getValue(AgentAdviser t) throws RuntimeException {
                String[] values = {
                        t.getName()==null?"":t.getName(),
                        t.getEmail()==null?"":t.getEmail(),
                        t.getWeixin()==null?"":t.getWeixin(),
                        t.getQq()==null?"":t.getQq(),
                        t.getCellphone1()==null?"":t.getCellphone1(),
                        t.getCellphone2()==null?"":t.getCellphone2(),
                        t.getTelephone()==null?"":t.getTelephone(),
                        t.getManagerNo()==0?"":EmployeeModel.getEmpByUserId(t.getManagerNo()).getName(),
                        t.getAddress()==null?"":t.getAddress()
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "投资顾问";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "投资顾问 工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "投资顾问.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void getExcelForAgentBusiness(AgentBusinessCondition agentBusinessCondition, String showAllList) {

        List<AgentBusiness> agentBusinesses = AgentBusinessModel.getListForExcelT(agentBusinessCondition);

        GenerateExcelTemplate<AgentBusiness> generateExcelTemplate = new GenerateExcelTemplate<AgentBusiness>(agentBusinesses);

        XLSCallBack<AgentBusiness> xlscaCallBack = new XLSCallBack<AgentBusiness>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "企业名称", "公司邮箱", "公司电话", "公司法人", "公司网站",
                        "公司地址", "联系人", "联系人职位", "微信", "QQ", "手机1", "手机2",
                        "联系人电话", "住址", "重要程度", "企业描述", "关系等级", "销售额", "负责人" };
                return headers;
            }

            @Override
            public String[] getValue(AgentBusiness t) throws RuntimeException {
                String[] values = {
                        t.getName()==null?"":t.getName(),
                        t.getEmail()==null?"":t.getEmail(),
                        t.getTelephone()==null?"":t.getTelephone(),
                        t.getOwner()==null?"":t.getOwner(),
                        t.getWebsite()==null?"":t.getWebsite(),
                        t.getAddress()==null?"":t.getAddress(),
                        t.getContactPrimary()==null?"":t.getContactPrimary(),
                        t.getContactPosition()==null?"":t.getContactPosition(),
                        t.getContactWeixin()==null?"":t.getContactWeixin(),
                        t.getContactQq()==null?"":t.getContactQq(),
                        t.getContactCellphone1()==null?"":t.getContactCellphone1(),
                        t.getContactCellphone2()==null?"":t.getContactCellphone2(),
                        t.getContactTelephone()==null?"":t.getTelephone(),
                        t.getContactAddress()==null?"":t.getContactAddress(),
                        t.getContactImportance()==0?"":DicDataModel.getDicDataByTypeAndCode(15, t.getContactImportance()).getValue(),
                        t.getComment()==null?"":t.getComment(),
                        t.getRelationLevel()==0?"":DicDataModel.getDicDataByTypeAndCode(11, t.getRelationLevel()).getValue(),
                        t.getSaleTotal()==0?"":String.valueOf(t.getSaleTotal()),
                        t.getManagerNo()==0?"":EmployeeModel.getEmpByUserId(t.getManagerNo()).getName()
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "下游代理商";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "下游代理商 工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10, 10 };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "下游代理商.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void getExcelForSales(SalesCondition salesCondition) {
        List<Sales> salesList = SalesModel.getListForExaclX(salesCondition);
        GenerateExcelTemplate<Sales> generateExcelTemplate = new GenerateExcelTemplate<Sales>(salesList);
        XLSCallBack<Sales> xlscaCallBack = new XLSCallBack<Sales>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {
                        "编号","产品类型",
                         "产品",
                        "客户类型",
                        "客户",
                        "订单状态", "订单金额",
                        "部门",
                        "渠道经理",
                        "协议状态",
                        "购买日期","到期日期", "收益金额", "佣金费率", "实际佣金费率",
                        "开户行地址","开户名","打款账号"
                };
                return headers;
            }

            @Override
            public String[] getValue(Sales t) throws RuntimeException {
                String customerName = "";
                if(t.getCustomerNo()!=0) {
                    if (t.getCustomerType() == 1) {
                        CustomerPersonal customerPersonal = CustomerPersonalModel.getInfo(t.getCustomerNo());
                        if (customerPersonal != null) {
                            customerName = customerPersonal.getName();
                        } else {
                            customerName = "异常";
                        }
                    }
                    if (t.getCustomerType() == 2) {
                        CustomerCompany customerCompany = CustomerCompanyModel.getInfo(t.getCustomerNo());
                        if (customerCompany != null) {
                            customerName = customerCompany.getName();
                        } else {
                            customerName = "异常";
                        }
                    }
                }
                String[] values = {
                        t.getCode()==null?"":t.getCode(),
                        t.getProductType()==0?"":DicDataModel.getDicDataByTypeAndCode(4, t.getProductType()).getValue(),
                        t.getProductNo()==0?"": ProductModel.getInfo(t.getProductNo()).getName(),
                        t.getCustomerType()==0?"":DicDataModel.getDicDataByTypeAndCode(5, t.getCustomerType()).getValue(),
                        customerName,
                        t.getStatus()==0?"":DicDataModel.getDicDataByTypeAndCode(7, t.getStatus()).getValue(),
                        t.getMoney()==0?"":String.valueOf(t.getMoney()),
                        t.getDeptNo()==0?"":DepartmentModel.getInfo(t.getDeptNo()).getName(),
                        t.getEmpNo()==0?"":EmployeeModel.getEmpByUserId(t.getEmpNo()).getName(),
                        t.getProtocolStatus()==0?"":DicDataModel.getDicDataByTypeAndCode(21, t.getProtocolStatus()).getValue(),
                        String.valueOf(t.getPurchaseDate()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(t.getPurchaseDate())),
                        String.valueOf(t.getRepaymentDate()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(t.getRepaymentDate())),
                        t.getIncomeMoney()==0?"":String.valueOf(t.getIncomeMoney()),
                        t.getAgentRate()==0?"":String.valueOf(t.getAgentRate()),
                        t.getAgentRateReal()==0?"":String.valueOf(t.getAgentRateReal()),
                        t.getBankAddress()==null?"":t.getBankAddress(),
                        t.getBankName()==null?"":t.getBankName(),
                        t.getAccountNumber()==null?"":String.valueOf(t.getAccountNumber()),
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "打款管理";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "打款管理 工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10
                };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "订单打款.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getExcelForAchievementCommission(AchievementCommissionCondition achievementCommissionCondition,String showAllList) {

        List<AchievementCommission> achievementCommissionList = AchievementCommissionModel
                .getListForExcel(achievementCommissionCondition);

        GenerateExcelTemplate<AchievementCommission> generateExcelTemplate = new GenerateExcelTemplate<AchievementCommission>(
                achievementCommissionList);

        XLSCallBack<AchievementCommission> xlscaCallBack = new XLSCallBack<AchievementCommission>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "员工编号", "员工姓名", "所属部门", "员工职位", "年份",
                        "月份", "标准(万元)", "销售总额(万元)", "完成比例(%)", "提成比例(%)",
                        "提成(元)" };
                return headers;
            }

            @Override
            public String[] getValue(AchievementCommission t)
                    throws RuntimeException {
                String[] values = {
                        String.valueOf(t.getEmpNo()),
                        t.getEmpName(),
                        DepartmentModel.getInfo(t.getDeptNo()).getName(),
                        PositionModel.getInfo(t.getPositionNo()).getName(),
                        String.valueOf(t.getYear()),
                        String.valueOf(t.getMonth()),
                        String.valueOf(t.getStandard()),
                        String.valueOf(t.getSalesMoney()),
                        String.valueOf(t.getFinishScale()),
                        String.valueOf(t.getCommissionScale()),
                        String.valueOf(t.getCommissionMoney()) };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "提成管理";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "提成管理 工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 10, 15, 15, 15, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10, 10 };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "提成管理.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getExcelCommissionWealthCenter(CommissionWealthCenterCondition commissionWealthCenterCondition,String showAllList){
        List<CommissionWealthCenter> commissionWealthCenterList = CommissionWealthCenterModel.getListForExcel(commissionWealthCenterCondition);

        GenerateExcelTemplate<CommissionWealthCenter> generateExcelTemplate = new GenerateExcelTemplate<CommissionWealthCenter>(
                commissionWealthCenterList);

        XLSCallBack<CommissionWealthCenter> xlscaCallBack = new XLSCallBack<CommissionWealthCenter>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "员工编号","员工姓名","所属部门","职位","类型","统计时间（年）","统计时间（月）","销售总额","提成比例","成立金额","提成工资" };
                return headers;
            }

            @Override
            public String[] getValue(CommissionWealthCenter c)
                    throws RuntimeException {
                String[] values = {
                        String.valueOf(c.getEmpNo()),
                        c.getEmpName(),
                        DepartmentModel.getInfo(c.getDeptNo()).getName(),
                        c.getPositionNo()==0?"":PositionModel.getInfo(c.getPositionNo()).getName(),
                        c.getType(),
                        String.valueOf(c.getYear()),
                        String.valueOf(c.getMonth()),
                        String.valueOf(c.getSalesMoney()),
                        String.valueOf(c.getCommissionScale()),
                        String.valueOf(c.getEstablishMoney()),
                        String.valueOf(c.getCommissionMoney())

                };
                return values;

            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "员工提成（财富管理中心）";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "员工提成（财富管理中心）工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = {15,15,15,15,15,15,15,15,15,15};
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "员工提成（财富管理中心）.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getExcelForSubsidy(SubsidyCondition subsidyCondition,String showAllList) {

        List<Subsidy> subsidyList = SubsidyModel.getListForExcel(subsidyCondition);

        GenerateExcelTemplate<Subsidy> generateExcelTemplate = new GenerateExcelTemplate<Subsidy>(
                subsidyList);

        XLSCallBack<Subsidy> xlscaCallBack = new XLSCallBack<Subsidy>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "员工编号","员工姓名","所属部门","员工职位","金额(元)","应发时间","是否发出" };
                return headers;
            }

            @Override
            public String[] getValue(Subsidy t)
                    throws RuntimeException {
                String[] values = {
                        String.valueOf(t.getEmpNo()),
                        t.getEmpName(),
                        DepartmentModel.getInfo(t.getDeptNo()).getName(),
                        PositionModel.getInfo(t.getPositionNo()).getName(),
                        String.valueOf(t.getMoney()),
                        //String.valueOf(t.getSource()),
                        String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(t.getSendTime())),
                        String.valueOf(t.getIsSend()==0?"否":"是") };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "员工津贴";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "员工津贴工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 10, 15, 15, 15, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10, 10 };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "员工津贴.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void getExcelForPaymentRefund(PaymentRefundCondition paymentRefundCondition) {

        List<PaymentRefund> paymentRefundList = PaymentRefundModel.getListForExcel(paymentRefundCondition);

        GenerateExcelTemplate<PaymentRefund> generateExcelTemplate = new GenerateExcelTemplate<PaymentRefund>(
                paymentRefundList);

        XLSCallBack<PaymentRefund> xlscaCallBack = new XLSCallBack<PaymentRefund>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {
                        "P2P产品","客户","付款人","投资金额（元）","利息(元)",
                        "还款金额（元）",
                                    "手续费（元）","还款时间"
,"交易状态","是否发送短信",
                                    "年化利率(%)"
                };
                return headers;
            }
            @Override
            public String[] getValue(PaymentRefund t)
                    throws RuntimeException {
                String income = "0";

                String[] values = {
                        t.getP2pProductName()==null?"":t.getP2pProductName(),
                        t.getCustomerName()==null?"":t.getCustomerName(),
                        t.getPayerName()==null?"":t.getPayerName(),
                        t.getSalesMoney()==0?"":String.valueOf(t.getSalesMoney()),
                        t.getInterest()==0?"":String.valueOf(t.getInterest()),
                        t.getPayMoney()==0?"":String.valueOf(t.getPayMoney()),
                        t.getServiceCharge()==0?"":String.valueOf(t.getServiceCharge()),
                        t.getActualPayTime()==null?"":String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(t.getActualPayTime())),
                        t.getStatus()==0?"":DicDataModel.getDicDataByTypeAndCode(39, t.getStatus()).getValue(),
                        t.getIsSendSms()==-1?"":DicDataModel.getDicDataByTypeAndCode(51, t.getIsSendSms()).getValue(),
                        t.getSalesNo()==0?"":String.valueOf(SalesModel.getInfo(t.getSalesNo()).getIncome())
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "线下还款管理";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "线下还款工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 40,20,20,20,20,
                        20,20,20,20,20,20
                };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "线下还款.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getExcelForSubsidyTotal(SubsidyTotalCondition subsidyTotalCondition, String showAllList) {

        List<SubsidyTotal> subsidyTotalList = SubsidyTotalModel.getListForExcel(subsidyTotalCondition);

        GenerateExcelTemplate<SubsidyTotal> generateExcelTemplate = new GenerateExcelTemplate<SubsidyTotal>(
                subsidyTotalList);

        XLSCallBack<SubsidyTotal> xlscaCallBack = new XLSCallBack<SubsidyTotal>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "员工编号","员工姓名","所属部门","员工职位","津贴比例(%)","销售总额(万元)","津贴(元)","获得时间","是否审核(1为待审核，2为已审核，3审核通过并已分月)" };
                return headers;
            }

            @Override
            public String[] getValue(SubsidyTotal t)
                    throws RuntimeException {
                String[] values = {
                        String.valueOf(t.getEmpNo()),
                        t.getEmpName(),
                        DepartmentModel.getInfo(t.getDeptNo()).getName(),
                        PositionModel.getInfo(t.getPositionNo()).getName(),
                        String.valueOf(t.getSubsidyScale()),
                        String.valueOf(t.getSalesMoney()),
                        String.valueOf(t.getSubsidy()),
                        String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(t.getAchieveTime())),
                        String.valueOf(t.getIsExamine()) };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "津贴管理";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "津贴管理 工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 15, 15, 15, 15, 15, 15, 15, 15, 55, 15,
                        10, 10, 10, 10, 10, 10, 10, 10, 10 };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "津贴管理.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getExcelForRecruitAskRecord(RecruitAskRecordCondition recruitAskRecordCondition, String showAllList) {
        List<RecruitAskRecord> recruitAskRecordList = RecruitAskRecordModel.getListForExcel(recruitAskRecordCondition);
        //recruitAskRecordList = new ArrayList<RecruitAskRecord>();
        GenerateExcelTemplate<RecruitAskRecord> generateExcelTemplate = new GenerateExcelTemplate<RecruitAskRecord>(
                recruitAskRecordList);

        XLSCallBack<RecruitAskRecord> xlscaCallBack = new XLSCallBack<RecruitAskRecord>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "序号","姓名","简历来源","首次联系时间","现公司（行业）和职位","应聘职位","移动电话","邮箱地址","邀约初试时间","面试与否","复试时间","是否录用","首次联系情况","回访记录","后续联系记录","录入人","录入时间","修改人","修改时间","修改备注"
                };
                return headers;
            }

            @Override
            public String[] getValue(RecruitAskRecord t)
                    throws RuntimeException {
                List<DicData> dicDataList = DicDataModel
                        .getDicDataListByType(36);//简历来源
                String[] values = {
                        String.valueOf(t.getId()),
                        t.getName()==null?"":t.getName(),
                        t.getResumeSource()==0?"":String.valueOf(dicDataList.get(t.getResumeSource()-1).getValue()),
                        t.getFirstContactTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(t.getFirstContactTime()),
                        t.getWorkCondition()==null?"":String.valueOf(t.getWorkCondition()),
                        t.getPositionNo()==0?"":PositionModel.getInfo(t.getPositionNo()).getName(),
                        t.getCellphone()==null?"":t.getCellphone(),
                        t.getEmail()==null?"":t.getEmail(),
                        t.getFirstTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(t.getFirstTime()),
                        t.getIsInterview()==0?"否":"是",
                        t.getSecondTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(t.getSecondTime()),
                        t.getIsEmploy()==0?"否":"是",
                        t.getFirstContactSituation()==null?"":String.valueOf(t.getFirstContactSituation()),
                        t.getVisitRecord()==null?"":String.valueOf(t.getVisitRecord()),
                        t.getLaterContactRecord()==null?"":String.valueOf(t.getLaterContactRecord()),
                        t.getInUserNo()==0?"":EmployeeModel.getEmpByUserId(t.getInUserNo()).getName(),
                        t.getInTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(t.getInTime()),
                        t.getEditUserNo()==0?"":EmployeeModel.getEmpByUserId(t.getEditUserNo()).getName(),
                        t.getEditTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(t.getEditTime()),
                        t.getEditComment()==null?"":t.getEditComment()
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "招聘邀约过程记录表";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "招聘邀约过程记录薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 15, 15
                        , 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15
                };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "招聘邀约过程记录表.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getExcelAttendanceApplication(AttendanceApplicationCondition attendanceApplicationCondition){
        List<AttendanceApplication> attendanceApplicationList = AttendanceApplicationModel.getListForExcel(attendanceApplicationCondition);

        GenerateExcelTemplate<AttendanceApplication> generateExcelTemplate = new GenerateExcelTemplate<AttendanceApplication>(attendanceApplicationList);

        XLSCallBack<AttendanceApplication> xlscaCallBack = new XLSCallBack<AttendanceApplication>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "编号","员工姓名"
                        ,"部门","职位","类型","请假开始时间","请假结束时间","合计（日）","合计（时）","事由","状态"
                };
                return headers;
            }

            @Override
            public String[] getValue(AttendanceApplication a)
                    throws RuntimeException {
                String[] values = {
                        String.valueOf(a.getId()),
                        a.getEmpNo()==0?"":EmployeeModel.getInfo(a.getEmpNo()).getName(),
                        a.getDeptNo()==0?"":DepartmentModel.getInfo(a.getDeptNo()).getName(),
                        a.getPositionNo()==0?"":PositionModel.getInfo(a.getPositionNo()).getName(),
                        a.getType()==0?"":DicDataModel.getDicDataByTypeAndCode(43,a.getType()).getValue(),
                        a.getStartTime()==null?"":String.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(a.getStartTime())),
                        a.getEndTime()==null?"":String.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(a.getEndTime())),
                        a.getTotalDay()==0?"":String.valueOf(a.getTotalDay()),
                        a.getTotalHour()==0?"":String.valueOf(a.getTotalHour()),
                        a.getReason()==null?"":a.getReason(),
                        a.getWorkFlowStatus()==0?"":DicDataModel.getDicDataByTypeAndCode(44,a.getWorkFlowStatus()).getValue(),
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "考勤记录表";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "考勤记录表工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 15, 15
                        , 15, 15, 15, 15, 15, 15, 15, 35, 15
                };
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "考勤记录表.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getExcelForEmpCompilePlan(EmpCompilePlanCondition empCompilePlanCondition, String showAllList) {
        List<EmpCompilePlan> empCompilePlanList = EmpCompilePlanModel.getListForExcel(empCompilePlanCondition);

        GenerateExcelTemplate<EmpCompilePlan> generateExcelTemplate = new GenerateExcelTemplate<EmpCompilePlan>(
                empCompilePlanList);

        XLSCallBack<EmpCompilePlan> xlscaCallBack = new XLSCallBack<EmpCompilePlan>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = { "编号","公司","部门","岗位名称","定编人数","现有人数","现有人员姓名","缺编人数","计划招聘时间","统计年份","统计月份" };
                return headers;
            }

            @Override
            public String[] getValue(EmpCompilePlan empCompilePlan)
                    throws RuntimeException {
                String[] values = {
                        String.valueOf(empCompilePlan.getId()),
                        CompanyModel.getInfo(empCompilePlan.getCompanyNo()).getName(),
                        DepartmentModel.getInfo(empCompilePlan.getDeptNo()).getName(),
                        PositionModel.getInfo(empCompilePlan.getPositionNo()).getName(),
                        String.valueOf(empCompilePlan.getDueEmpNumber()),
                        String.valueOf(empCompilePlan.getRealEmpNumber()),
                        empCompilePlan.getAllEmpName(),
                        String.valueOf(empCompilePlan.getLackEmpNumber()),
                        String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(empCompilePlan.getPlanTime())),
                        String.valueOf(empCompilePlan.getYear()),
                        String.valueOf(empCompilePlan.getMonth())
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "人员编制计划表";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "人员编制计划工作薄";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 15, 15, 15, 15, 15, 15, 80, 15, 55, 15, 10};
                return columnWidth;
            }
        };

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "人员编制计划.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void  getWxExcelForEmployeeInformation(EmployeeCondition employeeCondition){
        List<Employee> employeeList = EmployeeModel.getListForExcel(employeeCondition);

        GenerateExcelTemplate<Employee> generateExcelTemplate = new GenerateExcelTemplate<Employee>(employeeList);

        XLSCallBack<Employee> xlscaCallBack= new XLSCallBack<Employee>() {
            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {"姓名","账号","微信号","手机号","邮箱","电话",
                		 "部门" ,"性别","职位",
                         "qq","地址","入职时间"
                };
                return headers;
            }
            @Override
            public String[] getValue(Employee e) throws RuntimeException {

                String[] values = {
                        e.getName()==null?"":e.getName(),
                        e.getUserNo()==0?"":UserModel.getInfo(e.getUserNo()).getName(),
                        e.getWeixin()==null?"":e.getWeixin(),
                        e.getCellphone1()==null?"":e.getCellphone1(),
                        e.getEmail()==null?"":e.getEmail(),
                        e.getTelephone()==null?"":e.getTelephone(),
                        e.getDeptNo()==0?"":DepartmentModel.getInfo(e.getDeptNo()).getName(),
						e.getSex()==0?"":String.valueOf(e.getSex()),
                        e.getPositionNo()==0?"":PositionModel.getInfo(e.getPositionNo()).getName(),
					    e.getQq()==null?"":e.getQq(),
						e.getAddress()==null?"":e.getAddress(),
                        e.getStartTime()==null?"":String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(e.getStartTime())),
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                // TODO Auto-generated method stub
                String title="企业微信在职员工通讯录";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                // TODO Auto-generated method stub
                String sheetName="企业微信在职员工通讯录";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 15, 15, 15, 15, 15, 15, 15, 15, 55, 15, 15 , 15};
                return columnWidth;
            }
        };
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "企业微信在职员工通讯录.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String(fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlscaCallBack);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    public void getExcelForEmployeeInformation() {



        XLSCallBack<EmployeeInformation> xlscaCallBack1 = new XLSCallBack<EmployeeInformation>() {
            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {"序号","姓名","部门编号","员工编号","部门","职位","性别","名族" ,"入司日期","转正日期",
                        "协议起始","协议到期","出生日期","出生年份","身份证号码","家庭地址","第一学历","毕业学校","专业","户口所在地",
                        "出生地","任职资格证书1","获证日期","任职资格证书2","获证日期","政治面貌","备注"};
                return headers;
            }
            @Override
            public String[] getValue(EmployeeInformation e)
                    throws RuntimeException {

                Position position = PositionModel.getInfo(e.getPositionNo());
                String temp="";
                if (position!=null) {
                    temp = position.getName();
                }
                String[] values = {
                        String.valueOf(e.getId()==0?"":e.getId()),
                        e.getName(),
                        String.valueOf(e.getDeptNo()==0?"":e.getDeptNo()),
                        String.valueOf(e.getEmpNo()==0?"":e.getEmpNo()),
                        e.getDeptName()==null?"":e.getDeptName(),
                        temp,
                        e.getSex()==0?"":DicDataModel.getDicDataByTypeAndCode(1, e.getSex()).getValue(),
                        e.getNation(),
                        String.valueOf(e.getStartTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getStartTime())),
                        String.valueOf(e.getOfficalTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getOfficalTime())),
                        String.valueOf(e.getProtocolStartTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getProtocolStartTime())),
                        String.valueOf(e.getProtocolEndTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getProtocolEndTime())),
                        String.valueOf(e.getBirthday()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getBirthday())),
                        String.valueOf(e.getBirthdayYear()==0?"":e.getBirthdayYear()),
                        e.getIdCard(),
                        e.getHomeAddress(),
                        String.valueOf(e.getDegree1()==0?"":e.getDegree1()),
                        e.getGraduationSchool1(),
                        e.getMajor1(),
                        e.getPermanentPlace(),
                        e.getBirthPlace(),
                        e.getCertificate1(),
                        String.valueOf(e.getCertificateDate1()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getCertificateDate1())),
                        e.getCertificate2(),
                        String.valueOf(e.getCertificateDate2()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getCertificateDate2())),
                        e.getPoliticalStatus()==0?"":DicDataModel.getDicDataByTypeAndCode(34, e.getPoliticalStatus()).getValue(),
                        e.getComment()
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "实习人员信息";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "实习人员";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = {
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                };
                return columnWidth;
            }
        };

        XLSCallBack<EmployeeInformation> xlscaCallBack2 = new XLSCallBack<EmployeeInformation>() {




            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {"序号","姓名","部门编号","员工编号","部门","职位","性别","民族","婚姻状况","子女情况",
                        "入司日期","转正日期","合同起始","合同到期","出生日期","出生年份","身份证号码","家庭地址","第一学历","毕业学校",
                        "专业","第二学历","毕业学校","专业","户口所在地","出生地","任职资格证书1","获证日期","任职资格证书2","获证日期",
                        "政治面貌","备注"
                };
                return headers;
            }
            @Override
            public String[] getValue(EmployeeInformation e)
                    throws RuntimeException {

                Position position = PositionModel.getInfo(e.getPositionNo());
                String temp="";
                if (position!=null) {
                    temp = position.getName();
                }
                String[] values = {
                        String.valueOf(e.getId()==0?"":e.getId()),
                        e.getName(),
                        String.valueOf(e.getDeptNo()==0?"":e.getDeptNo()),
                        String.valueOf(e.getEmpNo()==0?"":e.getEmpNo()),
                        e.getDeptName()==null?"":e.getDeptName(),
                        temp,
                        e.getSex()==0?"":DicDataModel.getDicDataByTypeAndCode(1, e.getSex()).getValue(),
                        e.getNation(),
                        e.getMarry()==0?"":DicDataModel.getDicDataByTypeAndCode(9, e.getMarry()).getValue(),
                        e.getChildrenSitiatio(),
                        String.valueOf(e.getStartTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getStartTime())),
                        String.valueOf(e.getOfficalTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getOfficalTime())),
                        String.valueOf(e.getContractStartTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getContractStartTime())),
                        String.valueOf(e.getContractEndTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getContractEndTime())),
                        String.valueOf(e.getBirthday()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getBirthday())),
                        String.valueOf(e.getBirthdayYear()==0?"":e.getBirthdayYear()),
                        e.getIdCard(),
                        e.getHomeAddress(),
                        String.valueOf(e.getDegree1()==0?"":e.getDegree1()),
                        e.getGraduationSchool1(),
                        e.getMajor1(),
                        String.valueOf(e.getDegree2()==0?"":e.getDegree2()),
                        e.getGraduationSchool2(),
                        e.getMajor2(),
                        e.getPermanentPlace(),
                        e.getBirthPlace(),
                        e.getCertificate1(),
                        String.valueOf(e.getCertificateDate1()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getCertificateDate1())),
                        e.getCertificate2(),
                        String.valueOf(e.getCertificateDate2()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getCertificateDate2())),
                        e.getPoliticalStatus()==0?"":DicDataModel.getDicDataByTypeAndCode(34, e.getPoliticalStatus()).getValue(),
                        e.getComment()
                };

                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "在职人员信息";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "在职人员";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = {
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15
                };
                return columnWidth;
            }
        };

        XLSCallBack<EmployeeInformation> xlscaCallBack3 = new XLSCallBack<EmployeeInformation>() {
            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {"序号","姓名","部门编号","员工编号","部门","职位","性别","民族","婚姻状况","子女情况"
                        ,"离职日期","入司日期","转正日期","合同起始","合同到期","出生日期","出生年份","身份证号码","家庭地址","第一学历",
                        "毕业学校","专业","第二学历","毕业学校","专业","户口所在地","出生地","任职资格证书1","获证日期","任职资格证书2",
                        "获证日期","政治面貌","备注"
                };
                return headers;
            }
            @Override
            public String[] getValue(EmployeeInformation e)
                    throws RuntimeException {

                Position position = PositionModel.getInfo(e.getPositionNo());
                String temp="";
                if (position!=null) {
                    temp = position.getName();
                }
                String[] values = {
                        String.valueOf(e.getId()==0?"":e.getId()),
                        e.getName(),
                        String.valueOf(e.getDeptNo()==0?"":e.getDeptNo()),
                        String.valueOf(e.getEmpNo()==0?"":e.getEmpNo()),
                        e.getDeptName()==null?"":e.getDeptName(),
                        temp,
                        e.getSex()==0?"":DicDataModel.getDicDataByTypeAndCode(1, e.getSex()).getValue(),
                        e.getNation(),
                        e.getMarry()==0?"":DicDataModel.getDicDataByTypeAndCode(9, e.getMarry()).getValue(),
                        e.getChildrenSitiatio(),
                        String.valueOf(e.getEndTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getEndTime())),
                        String.valueOf(e.getStartTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getStartTime())),
                        String.valueOf(e.getOfficalTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getOfficalTime())),
                        String.valueOf(e.getContractStartTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getContractStartTime())),
                        String.valueOf(e.getContractEndTime()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getContractEndTime())),
                        String.valueOf(e.getBirthday()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getBirthday())),
                        String.valueOf(e.getBirthdayYear()==0?"":e.getBirthdayYear()),
                        e.getIdCard(),
                        e.getHomeAddress(),
                        String.valueOf(e.getDegree1()==0?"":e.getDegree1()),
                        e.getGraduationSchool1(),
                        e.getMajor1(),
                        String.valueOf(e.getDegree2()==0?"":e.getDegree2()),
                        e.getGraduationSchool2(),
                        e.getMajor2(),
                        e.getPermanentPlace(),
                        e.getBirthPlace(),
                        e.getCertificate1(),
                        String.valueOf(e.getCertificateDate1()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getCertificateDate1())),
                        e.getCertificate2(),
                        String.valueOf(e.getCertificateDate2()==null?"":new SimpleDateFormat("yyyy-MM-dd").format(e.getCertificateDate2())),
                        e.getPoliticalStatus()==0?"":DicDataModel.getDicDataByTypeAndCode(34, e.getPoliticalStatus()).getValue(),
                        e.getComment()
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "离职人员信息";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetName = "离职人员";
                return sheetName;
            }

            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = {
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15, 15, 15, 15, 15,
                        15, 15, 15, 15, 15, 15
                };
                return columnWidth;
            }
        };

        List<EmployeeInformation> employeeInformationList1 = EmployeeInformationModel.getListForExcelByType(4);
        List<EmployeeInformation> employeeInformationList2 = EmployeeInformationModel.getListForExcelByType(1);
        List<EmployeeInformation> employeeInformationList3 = EmployeeInformationModel.getListForExcelByType(2);
        List<List<EmployeeInformation>> listss = new ArrayList<List<EmployeeInformation>>();
        listss.add(employeeInformationList1);
        listss.add(employeeInformationList2);
        listss.add(employeeInformationList3);


        GenerateExcelTemplate<EmployeeInformation> generateExcelTemplate = new GenerateExcelTemplate<EmployeeInformation>(listss,3);
        List<XLSCallBack> xlsCallBackList = new ArrayList<XLSCallBack>();
        xlsCallBackList.add(xlscaCallBack1);
        xlsCallBackList.add(xlscaCallBack2);
        xlsCallBackList.add(xlscaCallBack3);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            String fileName = "员工信息表.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlsCallBackList);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getExcelForApplyEmployeeList(ApplyEmployeeCondition applyEmployeeCondition) {
        XLSCallBack<ApplyEmployee> xlscaCallBack = new XLSCallBack<ApplyEmployee>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {
                        "员工编号",
                        "员工姓名", "联系方式",
                        "所属部门", "职位",
                        "邀约人数","实到人数",
                        "签到"
                };
                return headers;
            }
            @Override
            public String[] getValue(ApplyEmployee t) throws RuntimeException {
                String deptName=DepartmentModel.getInfo(t.getDeptNo()).getName();
                String positionName=PositionModel.getInfo(t.getPositionNo()).getName();
                String[] values = {
                        String.valueOf(t.getEmpNo()),
                        t.getName(),t.getTel(),
                        deptName,positionName,
                        String.valueOf(t.getInviteNum()),String.valueOf(t.getArriveNum()),
                        String.valueOf(t.getIsSign()==0?"":"已签到"),
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "员工登记表";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetNames="员工登记工作薄";
                return sheetNames;
            }
            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10 };
                return columnWidth;
            }
        };
        List<ApplyEmployee> applyCustomers = ApplyEmployeeModel.getCustomerListForExcel(applyEmployeeCondition);
        XLSCallBack<ApplyEmployee> xlscaCallBack1 = new XLSCallBack<ApplyEmployee>() {

            @Override
            public String[] getHeaders() throws RuntimeException {
                String[] headers = {
                        "客户姓名","性别",
                        "联系方式1","负责人编号",
                        "负责人", "联系方式2","签到"
                };
                return headers;
            }
            @Override
            public String[] getValue(ApplyEmployee t) throws RuntimeException {
                String deptName=DepartmentModel.getInfo(t.getDeptNo()).getName();
                String empName=EmployeeModel.getEmpByUserId(t.getEmpNo()).getName();
                String[] values = {
                        t.getName(),String.valueOf(t.getSex()==2?"女":"男"),
                        t.getTel(),String.valueOf(t.getEmpNo()),
                        empName,String.valueOf(t.getMark()==null?"":t.getMark()),String.valueOf(t.getIsSign()==0?"":"已签到")
                };
                return values;
            }

            @Override
            public String getTitle() throws RuntimeException {
                String title = "客户登记表";
                return title;
            }

            @Override
            public String getSheetName() throws RuntimeException {
                String sheetNames="客户登记工作薄";
                return sheetNames;
            }
            @Override
            public int[] getColumnWidth() throws RuntimeException {
                int[] columnWidth = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10, 10, 10, 10 };
                return columnWidth;
            }
        };



        List<ApplyEmployee> applyEmployees1 = ApplyEmployeeModel.getListForExcel(applyEmployeeCondition);

        List<ApplyEmployee> applyEmployees2 = ApplyEmployeeModel.getCustomerListForExcel(applyEmployeeCondition);
        List<List<ApplyEmployee>> listss = new ArrayList<List<ApplyEmployee>>();
        listss.add(applyEmployees1);
        listss.add(applyEmployees2);


        GenerateExcelTemplate<ApplyEmployee> generateExcelTemplate = new GenerateExcelTemplate<ApplyEmployee>(listss,2);
        List<XLSCallBack> xlsCallBackList = new ArrayList<XLSCallBack>();
        xlsCallBackList.add(xlscaCallBack);
        xlsCallBackList.add(xlscaCallBack1);


        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/ms-excel;charset=UTF-8");
        try {
            Activity activity=ActivityModel.getInfo(applyEmployees1.get(0).getActivityNo());
            String fileName =activity.getTitle() +"登记表.xls";
            response.setHeader("Content-disposition","attachment; filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            generateExcelTemplate.generateExcel(out, xlsCallBackList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
