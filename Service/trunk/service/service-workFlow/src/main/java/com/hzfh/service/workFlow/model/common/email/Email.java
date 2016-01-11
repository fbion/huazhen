package com.hzfh.service.workFlow.model.common.email;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.Product;
import com.hzfh.service.workFlow.model.baseInfo.EmailModel;
import com.hzfh.service.workFlow.model.common.constant.StatusType;
import com.hzfh.service.workFlow.model.common.helper.MailHelper;
import com.hzfh.service.workFlow.model.employee.EmployeeModel;
import com.hzfh.service.workFlow.model.product.P2pProductModel;
import com.hzfh.service.workFlow.model.product.ProductModel;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * Created by ulei0 on 2015/9/12.
 */
public class Email {

    public static void sendProductEmail(List<Task> nextTask,String id) {
        Product product = ProductModel.getInfo(Integer.parseInt(id));
        for(Task task:nextTask){
            Employee employee = EmployeeModel.getEmpByUserId(Integer.valueOf(task.getAssignee()));
            String subject = "您有一个产品需要处理";
            String content = String.format(MailHelper.MAIL_PRODUCTAUDITNEXT_BODY, product.getName());
            EmailModel.add(employee.getEmail(), subject, content, StatusType.EMAIL_ADMIN);
        }
    }
    public static void sendP2pProductEmail(List<Task> nextTask,String id) {
        P2pProduct p2pProduct = P2pProductModel.getInfo(Integer.parseInt(id));
        for(Task task:nextTask){
            Employee employee = EmployeeModel.getEmpByUserId(Integer.valueOf(task.getAssignee()));
            String subject = "您有一个新金融产品需要处理";
            String content = String.format(MailHelper.MAIL_PRODUCTAUDITNEXT_BODY, p2pProduct.getName());
            EmailModel.add(employee.getEmail(), subject, content, StatusType.EMAIL_ADMIN);
        }
    }

}
