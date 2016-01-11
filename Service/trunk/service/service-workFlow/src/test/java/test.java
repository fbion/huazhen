

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;










import com.hzfh.api.workFlow.model.ActHiProcinst;
import com.hzfh.api.workFlow.model.ActHiTaskinst;
import com.hzfh.api.workFlow.model.ActRuTask;
import com.hzfh.api.workFlow.model.query.ActHiProcinstCondition;
import com.hzfh.api.workFlow.model.query.ActHiTaskinstCondition;
import com.hzfh.api.workFlow.model.query.ActRuTaskCondition;
import com.hzfh.api.workFlow.service.ActHiProcinstService;
import com.hzfh.api.workFlow.service.ActHiTaskinstService;
import com.hzfh.api.workFlow.service.ActRuTaskService;
import com.hzfh.api.workFlow.service.ProcessingService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;





public class test {
//	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-workFlow.xml");
	/*public static ProcessEngineFactoryBean getProcessEngine(){
		ActIdUserService actIdUserService= (ActIdUserService) context.getBean("ActIdUserService");
	    return  actIdUserService.getProcessEngine();
	}*/
	
	/*@Test
	public void getUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActIdentityService actIdentityService =(ActIdentityService) context.getBean("actIdentityService");
//		System.out.println(actIdentityService.getActIdentityService().createUserQuery());
		List<User> userList =  actIdentityService.getUserListPage(0, 3);	
		for (User user : userList) {
			System.out.print(user.getId()+"er");
		}
	}*/
	@Test
	public void tempRecruitNeedProcess(){
	// 获取Spring的环境对象
			ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
			
			// 获取流程引擎对象
			ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
			
			// 部署流程定义
			Deployment d = pe.getRepositoryService()
			    .createDeployment()
			    .addClasspathResource("attendanceApplicationProcess_NewTwo.bpmn")
			    .deploy();
		System.out.print("成功");
	
	}
	
	@Test
	public void deptYearNeedProcess(){
		// 获取Spring的环境对象
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 获取流程引擎对象
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		// 部署流程定义
		Deployment d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("deptYearNeedProcess.bpmn")
				.deploy();
		
	}
	
	@Test
	public void extendProbationApplicationProcesss(){
		// 获取Spring的环境对象
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 获取流程引擎对象
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		// 部署流程定义
		Deployment d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("extendProbationApplicationProcess.bpmn")
				.deploy();
		
	}
	@Test
	public void personalChangeProcess(){
		// 获取Spring的环境对象
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 获取流程引擎对象
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		// 部署流程定义
		Deployment d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("personalChangeProcess.bpmn")
				.deploy();
		
	}
	@Test
	public void attendanceApplicationProcess(){
		// 获取Spring的环境对象
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 获取流程引擎对象
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		// 部署流程定义
		pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("attendanceApplicationProcessForPersonnel.bpmn")
				.deploy();
		pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("attendanceApplicationProcessForBackOffice.bpmn")
				.deploy();
		pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("attendanceApplicationProcessForSales.bpmn")
				.deploy();
		System.out.println("成功！");
	}
	@Test
	public void managerEvaluationProcess(){
		// 获取Spring的环境对象
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 获取流程引擎对象
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		// 部署流程定义
		Deployment d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("managerEvaluationProcess.bpmn")
				.deploy();
		System.out.println("成功！");
	}
	@Test
	public void probationEvaluationProcess(){
		// 获取Spring的环境对象
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 获取流程引擎对象
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		// 部署流程定义
		Deployment d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("probationEvaluationProcess.bpmn")
				.deploy();
		System.out.println("成功！");
	}
	@Test
	public void resignApplicationProcess(){
		// 获取Spring的环境对象
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 获取流程引擎对象
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		// 部署流程定义
		Deployment d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("resignApplicationProcess.bpmn")
				.deploy();
		
	}
	@Test
	public void vworkFlowAll(){
		// 获取Spring的环境对象
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 获取流程引擎对象
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		// 部署流程定义
		Deployment d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("attendanceApplicationProcessForBackOffice.bpmn")
				.deploy();
		 d = pe.getRepositoryService()
			    .createDeployment()
			    .addClasspathResource("attendanceApplicationProcessForPersonnel.bpmn")
			    .deploy();
		 d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("attendanceApplicationProcessForSales.bpmn")
				.deploy();
		 d = pe.getRepositoryService()
				.createDeployment()
				.addClasspathResource("productAuditProcess.bpmn")
				.deploy();
		 d = pe.getRepositoryService()
					.createDeployment()
					.addClasspathResource("salesAuditProcess.bpmn")
					.deploy();
		System.out.println("cehnggogn ");
		
	}
	
	/*@Test
	public void getUser2()throws Exception {
		//InputStream in = getAuditImgIntStream("724");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProcessEngine pe = context.getBean("processEngine", ProcessEngine.class);
		
		RepositoryService repositoryService = pe.getRepositoryService();
		
		//Deployment d = repositoryService.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
		
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId("tempRecruitNeedProcess:1:204")
		    .singleResult();
		
		BpmnModel Model = repositoryService.getBpmnModel("tempRecruitNeedProcess:1:204");
		
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceById("tempRecruitNeedProcess:1:204");
		
		SpringProcessEngineConfiguration processEngineConfiguration =
			(SpringProcessEngineConfiguration)context.getBean("processEngineConfiguration");
		
		Context.setProcessEngineConfiguration(processEngineConfiguration);
		
		InputStream in = ProcessDiagramGenerator.generateDiagram(Model, "png", pe.getRuntimeService().getActiveActivityIds(pi.getId()));

		OutputStream out = new FileOutputStream("c:/" +  pd.getDiagramResourceName());
		
		int i = 0;
		
		while ( ( i = in.read() ) != -1 ) {
			out.write(i);
		}
		
		out.close();
		System.out.println( "创建成功！" );
	}*/
	/*@Test
	public void getHiTaskbyUserNo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActHistoryService actHistoryService=(ActHistoryService) context.getBean("actHistoryService");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNo", "174");
        paramMap.put("startIndex",0);
        paramMap.put("pageSize",50);
        paramMap.put("type","attendanceApplicationProcess");
        paramMap.put("status", "");
		List<HistoricTaskInstance> HistoricTaskInstanceList  =  actHistoryService.getHiTaskPagedListbyUserNo(paramMap);
		System.out.println(HistoricTaskInstanceList.size());
		for (HistoricTaskInstance historicTaskInstance : HistoricTaskInstanceList) {
			System.out.println(historicTaskInstance.getProcessDefinitionId()+" - "+historicTaskInstance.getProcessInstanceId());
		}
		
	}*/
	@Test
	public void getHistoricProcessInstanceListByUserNo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProcessingService processingService = (ProcessingService) context.getBean("processingService");
		String userNo = "174";
		int startIndex = 1;
		int pageSize = 10;
		int count = processingService.getProcessingTotalCountByUserNo(userNo);
		System.out.println(count);
		List<HistoricProcessInstance> HistoricProcessInstanceList = processingService.getHistoricProcessInstanceListByUserNo(userNo,startIndex,pageSize);
		for (HistoricProcessInstance historicProcessInstance : HistoricProcessInstanceList) {
			System.out.println(historicProcessInstance.getBusinessKey());
		}
	}
	@Test
	public void getProcPageList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActHiProcinstService actHiProcinstService = (ActHiProcinstService) context.getBean("actHiProcinstService");
		ActHiProcinstCondition actHiProcinstCondition = new ActHiProcinstCondition();
		actHiProcinstCondition.setStartUserId(174);
		actHiProcinstCondition.setPageIndex(2);
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("START_TIME_");
		sortItem.setSortType(SortType.DESC);
		sortItemList.add(sortItem);
		actHiProcinstCondition.setSortItemList(sortItemList);
		System.out.println(actHiProcinstService.getPagingList(actHiProcinstCondition).getPagingInfo().getTotalCount());
//		actHiProcinstCondition.setPageSize(10);
		PagedList<ActHiProcinst> procList = actHiProcinstService.getPagingList(actHiProcinstCondition);
		System.out.println(procList.getResultList().size());
        for (ActHiProcinst actHiProc : procList.getResultList())
        {
        	System.out.println(actHiProc.getStartTime());
            System.out.println(actHiProc.getBusinessKey());
        }
	}
	@Test
	public void getRuTaskPageList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");
		ActRuTaskCondition actRuTaskCondition = new ActRuTaskCondition();
		actRuTaskCondition.setPageIndex(1);
		actRuTaskCondition.setPageSize(10);
    	List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("CREATE_TIME_");
		sortItem.setSortType(SortType.DESC);
		sortItemList.add(sortItem);
		actRuTaskCondition.setSortItemList(sortItemList);
		actRuTaskCondition.setAssignee("3");
		PagedList<ActRuTask> actRuTaskPagedList = actRuTaskService.getPagingList(actRuTaskCondition);
		for(ActRuTask actRuTask:actRuTaskPagedList.getResultList()){
			System.out.println(actRuTask.getProcInstId());
			System.out.println(actRuTask.getCreateTime());
		}
	}
	@Test
	public void getHiTaskinstPageList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActHiTaskinstService actHiTaskinstService = (ActHiTaskinstService)context.getBean("actHiTaskinstService");
		ActHiTaskinstCondition actHiTaskinstCondition = new ActHiTaskinstCondition();
		actHiTaskinstCondition.setPageIndex(1);
		actHiTaskinstCondition.setPageSize(10);
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("start_time_");
		sortItem.setSortType(SortType.DESC);
		sortItemList.add(sortItem);
		actHiTaskinstCondition.setSortItemList(sortItemList);
		actHiTaskinstCondition.setAssignee("3");
		PagedList<ActHiTaskinst> actHiTaskinstPagedList = actHiTaskinstService.getPagingList(actHiTaskinstCondition);
		for(ActHiTaskinst actHiTaskinst:actHiTaskinstPagedList.getResultList()){
			System.out.println(actHiTaskinst.getProcInstId());
			System.out.println(actHiTaskinst.getEndTime());
		}
		
	}
	
	@Test
	public void getHiTaskinstPaa(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProcessingService atHiProcinstService = (ProcessingService)context.getBean("processingService");
		Map<String, Object> variables = new HashMap<>();
		variables.put("productDirectorPosition", 4);
		variables.put("CEO", 80);
		variables.put("fortuneDirector", 83);
		variables.put("riskDirector", 81);
		variables.put("productId", 187);
		variables.put("financeDirector", 241);
		variables.put("productDirector", 121);
		variables.put("userPosition", 7);
		variables.put("creator", 118);
		variables.put("isXianFangBao", false);
		atHiProcinstService.startFlowProcessWithEmail("productAuditProcess", "118", variables, "", "productAuditProcess");
	}
	
	@Test
	public void getHiTaskinstPa(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActHiProcinstService atHiProcinstService = (ActHiProcinstService)context.getBean("actHiProcinstService");
		ActHiProcinst actHiProcinst = new ActHiProcinst();
		actHiProcinst = atHiProcinstService.getInfoString("712501");
		String bk = actHiProcinst.getBusinessKey();
		if(bk.indexOf("id")<0){
 			actHiProcinst.setBusinessKey(bk.replace("activitiNo", "id="+14+"&activitiNo"));
 			atHiProcinstService.update(actHiProcinst);
 		}
	}
	@Test
	public void getHiTaskinstP(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActHiTaskinstService atHiProcinstService = (ActHiTaskinstService)context.getBean("actHiTaskinstService");
		atHiProcinstService.updateAssigneeByActivitiNo("932553", "1111");
	}
}
