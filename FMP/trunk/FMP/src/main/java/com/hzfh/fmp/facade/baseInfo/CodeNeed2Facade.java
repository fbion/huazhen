package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeNeed2;
import com.hzfh.api.baseInfo.model.query.CodeNeed2Condition;
import com.hzfh.api.baseInfo.service.CodeNeed2Service;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeNeed2Facade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeNeed2> getPagingList(CodeNeed2Condition codeNeed2Condition) {
        CodeNeed2Service codeNeed2Service = (CodeNeed2Service) context.getBean("codeNeed2Service");

        return  codeNeed2Service.getPagingList(codeNeed2Condition);
    }

    public static int add(CodeNeed2 codeNeed2){
        CodeNeed2Service codeNeed2Service = (CodeNeed2Service) context.getBean("codeNeed2Service");

        return codeNeed2Service.add(codeNeed2);
    }

    public static int update(CodeNeed2 codeNeed2){
        CodeNeed2Service codeNeed2Service = (CodeNeed2Service) context.getBean("codeNeed2Service");

        return codeNeed2Service.update(codeNeed2);
    }

    public static List<CodeNeed2> getList(){
        CodeNeed2Service codeNeed2Service = (CodeNeed2Service) context.getBean("codeNeed2Service");

        return codeNeed2Service.getList();
    }

    public static CodeNeed2 getInfo(int id){
        CodeNeed2Service codeNeed2Service = (CodeNeed2Service) context.getBean("codeNeed2Service");

        return codeNeed2Service.getInfo(id);
    }
}
