package com.hzfh.fmp.controller.workFlow.serviceTask;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.model.baseInfo.EmailModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.impl.el.Expression;

/**
 * Created by ulei0 on 2015/9/10.
 */
public class SalesServiceTaskAction implements JavaDelegate {
    private static int  id;
    private Expression user;

    public void setUser(Expression user) {
        this.user = user;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        id = (int) user.getValue(execution);
        Employee employee = EmployeeModel.getEmpByUserId(id);
        String subject="您有一笔打款需要审核";
        String content="您有一笔打款需要审核";
        int admin = 10000;
        EmailModel.add(employee.getEmail(),subject,content,admin);
    }
}
