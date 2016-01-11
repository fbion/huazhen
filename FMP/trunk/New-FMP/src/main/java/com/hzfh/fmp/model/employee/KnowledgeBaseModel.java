package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.KnowledgeBase;
import com.hzfh.api.employee.model.query.KnowledgeBaseCondition;
import com.hzfh.fmp.facade.employee.KnowledgeBaseFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class KnowledgeBaseModel {
    public static PagedList<KnowledgeBase> getPagingList(KnowledgeBaseCondition knowledgeBaseCondition) {
        return KnowledgeBaseFacade.getPagingList(knowledgeBaseCondition);
    }

    public static int add(KnowledgeBase knowledgeBase) {
        return KnowledgeBaseFacade.add(knowledgeBase);
    }

    public static int update(KnowledgeBase knowledgeBase) {
        return KnowledgeBaseFacade.update(knowledgeBase);
    }

    public static List<KnowledgeBase> getList() {
        return KnowledgeBaseFacade.getList();
    }

    public static KnowledgeBase getInfo(int id) {
        return KnowledgeBaseFacade.getInfo(id);
    }
}
