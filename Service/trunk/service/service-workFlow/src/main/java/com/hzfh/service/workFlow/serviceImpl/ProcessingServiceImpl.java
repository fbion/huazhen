package com.hzfh.service.workFlow.serviceImpl;

import java.util.List;
import java.util.Map;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.product.model.Product;
import com.hzfh.service.workFlow.model.baseInfo.EmailModel;
import com.hzfh.service.workFlow.model.common.constant.StatusType;
import com.hzfh.service.workFlow.model.common.email.Email;
import com.hzfh.service.workFlow.model.common.helper.MailHelper;
import com.hzfh.service.workFlow.model.employee.EmployeeModel;
import com.hzfh.service.workFlow.model.product.ProductModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.workFlow.service.ProcessingService;

@Service("processingService")
public class ProcessingServiceImpl implements ProcessingService {

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
    public List<HistoricProcessInstance> getHistoricProcessInstanceListByUserNo(String userNo, int startIndex, int pageSize) {
        return historyService.createHistoricProcessInstanceQuery()
                .orderByProcessInstanceStartTime()
                .desc().startedBy(userNo)
                .listPage(startIndex, pageSize);
    }

    @Override
    public ProcessDefinition getProcessDefinitionByProDefId(String proDefId) {
        return repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(proDefId)
                .singleResult();
    }

    @Override
    public int getProcessingTotalCountByUserNo(String userNo) {
        return (int) historyService.createHistoricProcessInstanceQuery()
                .startedBy(userNo)
                .count();
    }

    @Override
    public String startFlowProcess(String type, String userNo, Map<String, Object> variables, String comment, String uri) {
        //根据类型 ，查询流程定义
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(type)
                .latestVersion()
                .singleResult();
        // 启动流程
        identityService.setAuthenticatedUserId(userNo);
        ProcessInstance pi = this.runtimeService.startProcessInstanceByKey(pd.getKey(), variables);
        runtimeService.updateBusinessKey(pi.getId(), uri);
        // 查询第一个任务
        Task firstTask = this.taskService.createTaskQuery()
                .processInstanceId(pi.getId())
                .singleResult();
        // 完成任务
        taskService.addComment(firstTask.getId(), pi.getId(), comment);
        //保存评论
        taskService.complete(firstTask.getId());

        return firstTask.getProcessInstanceId();
    }

    @Override
    public String startFlowProcessForNoApplicant(String type, String userNo, Map<String, Object> variables, String comment, String uri) {
        //根据类型 ，查询流程定义
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(type)
                .latestVersion()
                .singleResult();
        // 启动流程
        identityService.setAuthenticatedUserId(userNo);
        ProcessInstance pi = this.runtimeService.startProcessInstanceByKey(pd.getKey(), variables);
        runtimeService.updateBusinessKey(pi.getId(), uri);
        // 查询第一个任务
        Task firstTask = this.taskService.createTaskQuery()
                .processInstanceId(pi.getId())
                .singleResult();
        return firstTask.getProcessInstanceId();
    }

    @Override
    public String startFlowProcessWithEmail(String type, String userNo, Map<String, Object> variables, String comment, String uri) {
        //根据类型 ，查询流程定义
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(type)
                .latestVersion()
                .singleResult();
        // 启动流程
        identityService.setAuthenticatedUserId(userNo);
        ProcessInstance pi = this.runtimeService.startProcessInstanceByKey(pd.getKey(), variables);
        runtimeService.updateBusinessKey(pi.getId(), uri);
        // 查询第一个任务
        Task firstTask = this.taskService.createTaskQuery()
                .processInstanceId(pi.getId())
                .singleResult();
        // 完成任务
        taskService.addComment(firstTask.getId(), pi.getId(), comment);
        //保存评论
        taskService.complete(firstTask.getId());
        List<Task> nextTask = taskService.createTaskQuery().processInstanceId(firstTask.getProcessInstanceId()).list();
        if("productAuditProcess".equals(type)){
            String id = historyService.createHistoricVariableInstanceQuery().processInstanceId(firstTask.getProcessInstanceId()).variableName("productId").singleResult().getValue().toString();
            Email.sendProductEmail(nextTask, id);
        }else if("p2pProductAuditProcess".equals(type)){
            String id = historyService.createHistoricVariableInstanceQuery().processInstanceId(firstTask.getProcessInstanceId()).variableName("p2pProductId").singleResult().getValue().toString();
            Email.sendP2pProductEmail(nextTask,id);
        }

        return firstTask.getProcessInstanceId();
    }

    @Override
    public List<Comment> getCommnetsByProcessInsId(String avtiviNo) {
        return taskService.getProcessInstanceComments(avtiviNo);
    }

    @Override
    public HistoricTaskInstance getHistoricTaskInstanceByTaskId(String taskNo) {
        return historyService.createHistoricTaskInstanceQuery().taskId(taskNo).singleResult();
    }

    @Override
    public Task getBackTask(String proId, String userNo) {
        return taskService.createTaskQuery().taskDefinitionKey("usertask1").processInstanceId(proId).taskAssignee(userNo).singleResult();
    }

}
