package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeAdviser;
import com.hzfh.api.baseInfo.model.query.CodeAdviserCondition;
import com.hzfh.api.baseInfo.service.CodeAdviserService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeAdviserFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeAdviser> getPagingList(CodeAdviserCondition codeAdviserCondition) {
        CodeAdviserService codeAdviserService = (CodeAdviserService) context.getBean("codeAdviserService");

        return  codeAdviserService.getPagingList(codeAdviserCondition);
    }

    public static int add(CodeAdviser codeAdviser){
        CodeAdviserService codeAdviserService = (CodeAdviserService) context.getBean("codeAdviserService");

        return codeAdviserService.add(codeAdviser);
    }

    public static int update(CodeAdviser codeAdviser){
        CodeAdviserService codeAdviserService = (CodeAdviserService) context.getBean("codeAdviserService");

        return codeAdviserService.update(codeAdviser);
    }

    public static List<CodeAdviser> getList(){
        CodeAdviserService codeAdviserService = (CodeAdviserService) context.getBean("codeAdviserService");

        return codeAdviserService.getList();
    }

    public static CodeAdviser getInfo(int id){
        CodeAdviserService codeAdviserService = (CodeAdviserService) context.getBean("codeAdviserService");

        return codeAdviserService.getInfo(id);
    }
}
