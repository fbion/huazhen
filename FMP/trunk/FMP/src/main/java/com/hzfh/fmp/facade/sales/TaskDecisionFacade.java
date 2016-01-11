package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.api.sales.model.query.TaskDecisionCondition;
import com.hzfh.api.sales.service.TaskDecisionService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TaskDecisionFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<TaskDecision> getPagingList(TaskDecisionCondition taskDecisionCondition) {
        TaskDecisionService taskDecisionService = (TaskDecisionService) context.getBean("taskDecisionService");

        return  taskDecisionService.getPagingList(taskDecisionCondition);
    }

    public static int add(TaskDecision taskDecision){
        TaskDecisionService taskDecisionService = (TaskDecisionService) context.getBean("taskDecisionService");

        return taskDecisionService.add(taskDecision);
    }

    public static int update(TaskDecision taskDecision){
        TaskDecisionService taskDecisionService = (TaskDecisionService) context.getBean("taskDecisionService");

        return taskDecisionService.update(taskDecision);
    }

    public static List<TaskDecision> getList(){
        TaskDecisionService taskDecisionService = (TaskDecisionService) context.getBean("taskDecisionService");

        return taskDecisionService.getList();
    }

    public static TaskDecision getInfo(int id){
        TaskDecisionService taskDecisionService = (TaskDecisionService) context.getBean("taskDecisionService");

        return taskDecisionService.getInfo(id);
    }

    public static List<TaskDecision> getListByTaskNo(int taskNo){
        TaskDecisionService taskDecisionService = (TaskDecisionService)context.getBean("taskDecisionService");

        return taskDecisionService.getListByProductTaskNo(taskNo);
    }
}
