package com.hzfh.fmp.model.common.helper;

import com.hzfh.api.employee.model.*;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.employee.*;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.report.PaymentReportDeatilModel;
import com.hzfh.fmp.model.report.PaymentReportModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.helper.MathHelper;

import java.util.ArrayList;
import java.util.List;

public class WorkFlowHelper {
    public static int updateActivitiStatuts(String workFlowType, String activitiNo) {

        int result = 0;
        switch (workFlowType) {
            case "attendanceApplicationProcessForPersonnel":
                AttendanceApplicationModel.updateStatusByActivitiNo(activitiNo);
                break;
            case "attendanceApplicationProcessForBackOffice":
                AttendanceApplicationModel.updateStatusByActivitiNo(activitiNo);
                break;
            case "attendanceApplicationProcessForSales":
                AttendanceApplicationModel.updateStatusByActivitiNo(activitiNo);
                break;
            case "attendanceApplicationProcess_New":
                AttendanceApplicationModel.updateStatusByActivitiNo(activitiNo);
                break;
            case "attendanceApplicationProcess_NewTwo":
                AttendanceApplicationModel.updateStatusByActivitiNo(activitiNo);
                break;
            case "repaymentExaminationProcess":
//                AttendanceApplicationModel.updateStatusByActivitiNo(activitiNo);
            	PaymentReport report = new PaymentReport();
            	report = PaymentReportModel.getInfoByActivitiNo(activitiNo);
            	if(report!=null){
            		List<PaymentReportDeatil> list = new ArrayList<PaymentReportDeatil>();
            		list = PaymentReportDeatilModel.getListByReportNo(report.getId());
            		if(list.size()>0){
            			String ids = "";
            			for (PaymentReportDeatil paymentReportDeatil : list) {
            				ids = ids+paymentReportDeatil.getPaymentNo()+",";
    					}
        				PaymentRefundModel.updateExamineStatusByIds(ids.substring(0, ids.length()-1), 2);
            		}
            	}
                break;
            case "productAuditProcess":
                Product product = ProductModel.getInfoByActivitiNo(activitiNo);
                ProductModel.updateStatus(product.getId(), ProductStatus.PREHEAT);
                break;
            case "deptYearNeedProcess":
                result = DeptYearNeedModel.updateStatusByActivitiNo(activitiNo);
                if (result > 0) {
                    //根据activitiNo查出deptYearNeed实体
                    DeptYearNeed deptYearNeed = DeptYearNeedModel.getByActivitiNo(activitiNo);
                    //根据deptYearNeed实体id查出detail
                    List<DeptYearNeedDetail> deptYearNeedDetails = DeptYearNeedDetailModel.getInfoByNeedNo(deptYearNeed.getId());
                    //添加
                    YearNeedTotal yearNeedTotal = YearNeedTotalModel.getInfoByYear(deptYearNeed.getFinancialYear());
                    YearNeed yearNeed = new YearNeed();
                    if (yearNeedTotal == null) {
                        YearNeedTotal yearTotal = new YearNeedTotal();
                        yearTotal.setFinancialYear(deptYearNeed.getFinancialYear());
                        yearTotal.setInUserNo(UserHelper.getEditUserNo());
                        int totalNo = YearNeedTotalModel.add(yearTotal);
                        yearNeed.setYearNeedTotalNo(totalNo);
                    } else {
                        yearNeed.setYearNeedTotalNo(yearNeedTotal.getId());
                    }
                    yearNeed.setFinancialYear(deptYearNeed.getFinancialYear());
                    yearNeed.setCompanyNo(deptYearNeed.getCompanyNo());
                    yearNeed.setDeptNo(deptYearNeed.getDeptNo());
                    yearNeed.setDeptName(deptYearNeed.getDeptName());
                    yearNeed.setInUserNo(UserHelper.getEditUserNo());
                    yearNeed.setAddEmpTotal(deptYearNeed.getAddEmpTotal());
                    int yearNeedNo = YearNeedModel.add(yearNeed);
                    for (int i = 0; i < deptYearNeedDetails.size(); i++) {
                        YearNeedDetail yearNeedDetail = new YearNeedDetail();
                        yearNeedDetail.setYearNeedNo(yearNeedNo);
                        yearNeedDetail.setPositionNo(deptYearNeedDetails.get(i).getPositionNo());
                        yearNeedDetail.setEmpRequire(deptYearNeedDetails.get(i).getEmpRequire());
                        yearNeedDetail.setAddEmp(deptYearNeedDetails.get(i).getAddEmp());
                        yearNeedDetail.setWorkDate(deptYearNeedDetails.get(i).getWorkDate());
                        yearNeedDetail.setMark(deptYearNeedDetails.get(i).getMark());
                        yearNeedDetail.setInUserNo(UserHelper.getEditUserNo());
                        YearNeedDetailModel.add(yearNeedDetail);
                    }
                }
                break;
            case "extendProbationApplicationProcesss":
                break;
            case "yearNeedProcess":
                break;
            case "personalChangeProcess":
                PersonalChange personalChange = PersonalChangeModel.getByActivitiNo(activitiNo);
                Employee employee = EmployeeModel.getInfo(personalChange.getEmpNo());
                employee.setDeptNo(personalChange.getAfterDept());
                employee.setPositionNo(personalChange.getAfterPosition());
                EmployeeModel.update(employee);
                break;
            case "resignApplicationProcess":
                break;
            case "tempRecruitNeedProcess":
                break;
            case "probationEvaluationProcess":
                ProbationEvaluationModel.updateActivitiStatusByActivitiNo(activitiNo);
                //通过Python实现员工自动转正，代码废弃 by/ulei/2015-11-24
//                EmployeeModel.updateStatusByEmpNo(ProbationEvaluationModel.getInfoByActivitiNo(activitiNo).getEmpNo());
                break;
            case "managerEvaluationProcess":
                ManagerEvaluationModel.updateActivitiStatusByActivitiNo(activitiNo);
                break;
            case "salesAuditProcess":
                Sales sales = SalesModel.getInfoByActivitiNo(activitiNo);
                if(sales.getType()==2){
                    double payMoney = MathHelper.subtract(PaymentRefundModel.getHonourBySalesNo(sales.getRelationSalesNo()).getPayMoney(),sales.getMoney());
                    PaymentRefundModel.updatePayMoneyBySalesNoAndHonour(sales.getRelationSalesNo(),MathHelper.round(payMoney,2));
                }
                if(sales.getType()==3){
                    PaymentRefundModel.updatePayMoneyBySalesNoAndHonour(sales.getRelationSalesNo(),0);
                }
                PaymentRefundModel.updatePaymentTypeBySalesNoAndHonour(sales.getRelationSalesNo(),sales.getType());
                break;
            default:
                break;
        }
        return result;
    }
}
