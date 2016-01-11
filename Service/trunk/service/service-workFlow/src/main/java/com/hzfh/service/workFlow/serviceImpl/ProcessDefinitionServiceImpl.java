package com.hzfh.service.workFlow.serviceImpl;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.workFlow.service.ProcessDefinitionService;
@Service("processDefinitionService")
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService{
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
}
