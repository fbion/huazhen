package com.hzfh.service.workFlow.serviceTask.sales;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.service.workFlow.model.baseInfo.EmailModel;
import com.hzfh.service.workFlow.model.common.constant.SalesStatus;
import com.hzfh.service.workFlow.model.common.email.SalesEmail;
import com.hzfh.service.workFlow.model.employee.EmployeeModel;
import com.hzfh.service.workFlow.model.sales.SalesModel;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created by ulei0 on 2015/9/10.
 */
public class SalesAuditEndServiceTask extends SalesAudit implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int userNo = (int) this.getUserId().getValue(execution);
        int salesNo = (int) this.getSalesId().getValue(execution);
        SalesModel.updateStatus(salesNo, SalesStatus.success);
        Employee employee = EmployeeModel.getEmpByUserId(userNo);
        Sales sales = SalesModel.getInfo(salesNo);
        String subject="您的打款已通过审批";
        String content = SalesEmail.sendSuccessEmailNoLink(sales);
        int admin = 10000;
        EmailModel.add(employee.getEmail(), subject, content, admin);
    }

}
