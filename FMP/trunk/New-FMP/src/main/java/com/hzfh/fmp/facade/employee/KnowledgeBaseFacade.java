package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.KnowledgeBase;
import com.hzfh.api.employee.model.query.KnowledgeBaseCondition;
import com.hzfh.api.employee.service.KnowledgeBaseService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class KnowledgeBaseFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<KnowledgeBase> getPagingList(KnowledgeBaseCondition knowledgeBaseCondition) {
        KnowledgeBaseService knowledgeBaseService = (KnowledgeBaseService) context.getBean("knowledgeBaseService");

        return  knowledgeBaseService.getPagingList(knowledgeBaseCondition);
    }

    public static int add(KnowledgeBase knowledgeBase){
        KnowledgeBaseService knowledgeBaseService = (KnowledgeBaseService) context.getBean("knowledgeBaseService");

        return knowledgeBaseService.add(knowledgeBase);
    }

    public static int update(KnowledgeBase knowledgeBase){
        KnowledgeBaseService knowledgeBaseService = (KnowledgeBaseService) context.getBean("knowledgeBaseService");

        return knowledgeBaseService.update(knowledgeBase);
    }

    public static List<KnowledgeBase> getList(){
        KnowledgeBaseService knowledgeBaseService = (KnowledgeBaseService) context.getBean("knowledgeBaseService");

        return knowledgeBaseService.getList();
    }

    public static KnowledgeBase getInfo(int id){
        KnowledgeBaseService knowledgeBaseService = (KnowledgeBaseService) context.getBean("knowledgeBaseService");

        return knowledgeBaseService.getInfo(id);
    }
}
