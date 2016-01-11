package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.employee.model.query.KnowledgeAttachmentCondition;
import com.hzfh.api.employee.service.KnowledgeAttachmentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class KnowledgeAttachmentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<KnowledgeAttachment> getPagingList(KnowledgeAttachmentCondition knowledgeAttachmentCondition) {
        KnowledgeAttachmentService knowledgeAttachmentService = (KnowledgeAttachmentService) context.getBean("knowledgeAttachmentService");

        return  knowledgeAttachmentService.getPagingList(knowledgeAttachmentCondition);
    }

    public static int add(KnowledgeAttachment knowledgeAttachment){
        KnowledgeAttachmentService knowledgeAttachmentService = (KnowledgeAttachmentService) context.getBean("knowledgeAttachmentService");

        return knowledgeAttachmentService.add(knowledgeAttachment);
    }

    public static int update(KnowledgeAttachment knowledgeAttachment){
        KnowledgeAttachmentService knowledgeAttachmentService = (KnowledgeAttachmentService) context.getBean("knowledgeAttachmentService");

        return knowledgeAttachmentService.update(knowledgeAttachment);
    }

    public static List<KnowledgeAttachment> getList(){
        KnowledgeAttachmentService knowledgeAttachmentService = (KnowledgeAttachmentService) context.getBean("knowledgeAttachmentService");

        return knowledgeAttachmentService.getList();
    }

    public static KnowledgeAttachment getInfo(int id){
        KnowledgeAttachmentService knowledgeAttachmentService = (KnowledgeAttachmentService) context.getBean("knowledgeAttachmentService");

        return knowledgeAttachmentService.getInfo(id);
    }

	public static int updateStatus(int id, byte status) {
		// TODO Auto-generated method stub
		  KnowledgeAttachmentService knowledgeAttachmentService = (KnowledgeAttachmentService) context.getBean("knowledgeAttachmentService");
		  return knowledgeAttachmentService.updateStatus(id,status);
	}

	public static List<KnowledgeAttachment> getListByKnowledgeNo(int knowledgeNo) {
		// TODO Auto-generated method stub
		KnowledgeAttachmentService knowledgeAttachmentService = (KnowledgeAttachmentService) context.getBean("knowledgeAttachmentService");
		return knowledgeAttachmentService.getListByKnowledgeNo(knowledgeNo);
	}
}
