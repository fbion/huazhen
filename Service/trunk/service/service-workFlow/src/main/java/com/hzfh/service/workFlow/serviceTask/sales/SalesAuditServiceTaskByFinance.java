package com.hzfh.service.workFlow.serviceTask.sales;

import com.hzfh.api.employee.model.Employee;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.service.workFlow.model.baseInfo.EmailModel;
import com.hzfh.service.workFlow.model.common.constant.SalesStatus;
import com.hzfh.service.workFlow.model.employee.EmployeeModel;
import com.hzfh.service.workFlow.model.sales.SalesModel;
import com.hzfh.service.workFlow.model.common.email.SalesEmail;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created by ulei0 on 2015/9/10.
 */
public class SalesAuditServiceTaskByFinance extends SalesAudit implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int userNo = (int) this.getUserId().getValue(execution);
        int salesNo = (int) this.getSalesId().getValue(execution);
        String link = (String) this.getUrl().getValue(execution);
        SalesModel.updateStatus(salesNo, SalesStatus.account);

        Employee employee = EmployeeModel.getEmpByUserId(userNo);
        Sales sales = SalesModel.getInfo(salesNo);
        String subject="您有一笔打款需要审核";
        String content = SalesEmail.sendEmail(sales, link);
        int admin = 10000;
        EmailModel.add(employee.getEmail(), subject, content, admin);
    }

}
