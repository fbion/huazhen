package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.employee.model.query.KnowledgeAttachmentCondition;
import com.hzfh.fmp.facade.employee.KnowledgeAttachmentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class KnowledgeAttachmentModel {
    public static PagedList<KnowledgeAttachment> getPagingList(KnowledgeAttachmentCondition knowledgeAttachmentCondition) {
        return KnowledgeAttachmentFacade.getPagingList(knowledgeAttachmentCondition);
    }

    public static int add(KnowledgeAttachment knowledgeAttachment) {
        return KnowledgeAttachmentFacade.add(knowledgeAttachment);
    }

    public static int update(KnowledgeAttachment knowledgeAttachment) {
        return KnowledgeAttachmentFacade.update(knowledgeAttachment);
    }

    public static List<KnowledgeAttachment> getList() {
        return KnowledgeAttachmentFacade.getList();
    }

    public static KnowledgeAttachment getInfo(int id) {
        return KnowledgeAttachmentFacade.getInfo(id);
    }

	public static int updateStatus(int id,byte status) {
		// TODO Auto-generated method stub
		return KnowledgeAttachmentFacade.updateStatus(id,status);   
	}

	public static List<KnowledgeAttachment> getListByKnowledgeNo(int knowledgeNo) {
		// TODO Auto-generated method stub
		return KnowledgeAttachmentFacade.getListByKnowledgeNo(knowledgeNo);
	}
}
