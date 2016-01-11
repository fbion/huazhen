package com.hzfh.service.workFlow.serviceImpl;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.workFlow.service.AuditTaskService;
import com.hzfh.service.workFlow.model.baseInfo.EmailModel;
import com.hzfh.service.workFlow.model.common.constant.StatusType;
import com.hzfh.service.workFlow.model.common.email.Email;
import com.hzfh.service.workFlow.model.common.helper.MailHelper;
import com.hzfh.service.workFlow.model.employee.EmployeeModel;
import com.hzfh.service.workFlow.model.product.ProductModel;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("auditTaskService")
public class AuditTaskServiceImpl implements AuditTaskService {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private RuntimeService runtimeService;

    @Override
    public List<Task> getAcceptTaskPagedListByUserNo(String userNo, int startIndex, int pageSize) {
        return taskService.createTaskQuery().taskAssignee(userNo).orderByTaskCreateTime().desc().listPage(startIndex, pageSize);
    }

    @Override
    public int getAcceptTaskTotalCountByUserNo(String userNo) {
        return (int) taskService.createTaskQuery().taskAssignee(userNo).count();
    }

    @Override
    public HistoricProcessInstance getHistoricProcessInstanceByProInsId(String processInstanceId) {
        return historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
    }

    @Override
    public void addComplete(String activitiNo, String comment, String userNo) {
        Task task = taskService.createTaskQuery().processInstanceId(activitiNo).taskAssignee(userNo).singleResult();
        // 根据任务查询流程实例
        this.identityService.setAuthenticatedUserId(userNo);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("pass", true);
        //this.taskService.deleteComments(task.getId(), pi.getId());
        //添加评论
        this.taskService.addComment(task.getId(), activitiNo, comment);
        // 完成任务
        //taskService.claim(task.getId(), userNo);
        taskService.complete(task.getId(), vars);
    }

    @Override
    public void addCancelComplete(String activitiNo, String comment, String userNo) {
        this.identityService.setAuthenticatedUserId(userNo);
        Task task = this.taskService.createTaskQuery().processInstanceId(activitiNo).taskAssignee(userNo).singleResult();
        ProcessInstance pi = this.runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        // 添加评论
        this.taskService.addComment(task.getId(), pi.getId(), comment);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("pass", false);
        this.taskService.complete(task.getId(), vars);
    }

    @Override
    public ProcessInstance getProcessInstanceByProInsId(String processInstanceId) {
        return runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
    }

    @Override
    public void addExamineWithEmail(String activitiNo, String comment, String userNo, boolean oper) {
        Task task = taskService.createTaskQuery().processInstanceId(activitiNo).taskAssignee(userNo).singleResult();
        // 根据任务查询流程实例
        this.identityService.setAuthenticatedUserId(userNo);
        //添加评论
        this.taskService.addComment(task.getId(), activitiNo, comment);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("pass", oper);
        // 完成任务
        taskService.complete(task.getId(), vars);
        String type = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult().getKey();
        List<Task> nextTask = taskService.createTaskQuery().processInstanceId(activitiNo).list();
        if("productAuditProcess".equals(type)){
            String id = historyService.createHistoricVariableInstanceQuery().processInstanceId(activitiNo).variableName("productId").singleResult().getValue().toString();
            Email.sendProductEmail(nextTask,id);
        }else if("p2pProductAuditProcess".equals(type)){
            String id = historyService.createHistoricVariableInstanceQuery().processInstanceId(task.getProcessInstanceId()).variableName("p2pProductId").singleResult().getValue().toString();
            Email.sendP2pProductEmail(nextTask,id);
        }
    }
}
