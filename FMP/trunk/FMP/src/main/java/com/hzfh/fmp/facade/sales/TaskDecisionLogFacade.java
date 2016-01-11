package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.TaskDecisionLog;
import com.hzfh.api.sales.model.query.TaskDecisionLogCondition;
import com.hzfh.api.sales.service.TaskDecisionLogService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TaskDecisionLogFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<TaskDecisionLog> getPagingList(TaskDecisionLogCondition taskDecisionLogCondition) {
        TaskDecisionLogService taskDecisionLogService = (TaskDecisionLogService) context.getBean("taskDecisionLogService");

        return  taskDecisionLogService.getPagingList(taskDecisionLogCondition);
    }

    public static int add(TaskDecisionLog taskDecisionLog){
        TaskDecisionLogService taskDecisionLogService = (TaskDecisionLogService) context.getBean("taskDecisionLogService");

        return taskDecisionLogService.add(taskDecisionLog);
    }

    public static int update(TaskDecisionLog taskDecisionLog){
        TaskDecisionLogService taskDecisionLogService = (TaskDecisionLogService) context.getBean("taskDecisionLogService");

        return taskDecisionLogService.update(taskDecisionLog);
    }

    public static List<TaskDecisionLog> getList(){
        TaskDecisionLogService taskDecisionLogService = (TaskDecisionLogService) context.getBean("taskDecisionLogService");

        return taskDecisionLogService.getList();
    }

    public static TaskDecisionLog getInfo(int id){
        TaskDecisionLogService taskDecisionLogService = (TaskDecisionLogService) context.getBean("taskDecisionLogService");

        return taskDecisionLogService.getInfo(id);
    }
}
