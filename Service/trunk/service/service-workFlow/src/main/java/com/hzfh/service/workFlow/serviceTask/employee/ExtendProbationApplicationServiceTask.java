package com.hzfh.service.workFlow.serviceTask.employee;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.service.workFlow.model.baseInfo.LetterModel;
import com.hzfh.service.workFlow.model.common.helper.LetterHelper;
import com.hzfh.service.workFlow.model.employee.EmployeeModel;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.impl.el.Expression;

/**
 * Created by 磊 on 2015/11/23.
 */
public class ExtendProbationApplicationServiceTask implements JavaDelegate {
    private Expression positiveUser;

    public void setPositiveUser(Expression positiveUser) {
        this.positiveUser = positiveUser;
    }

    public Expression getPositiveUser() {
        return positiveUser;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        int userId = (int) this.getPositiveUser().getValue(execution);
        Employee employee = EmployeeModel.getEmpByUserId(userId);
        String content = "员工"+employee.getName()+",您好，您的转正延迟申请已通过。";
        String[] recipientArray = LetterHelper.LETTER_PROBATIONEVALUATION.split(",");
        for(String recipient:recipientArray ){
            LetterModel.addReminds("员工延迟转正通知", content,Integer.valueOf(recipient));
        }
    }
}
