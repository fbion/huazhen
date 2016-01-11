package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeEmp;
import com.hzfh.api.baseInfo.model.query.CodeEmpCondition;
import com.hzfh.api.baseInfo.service.CodeEmpService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeEmpFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeEmp> getPagingList(CodeEmpCondition codeEmpCondition) {
        CodeEmpService codeEmpService = (CodeEmpService) context.getBean("codeEmpService");

        return  codeEmpService.getPagingList(codeEmpCondition);
    }

    public static int add(CodeEmp codeEmp){
        CodeEmpService codeEmpService = (CodeEmpService) context.getBean("codeEmpService");

        return codeEmpService.add(codeEmp);
    }

    public static int update(CodeEmp codeEmp){
        CodeEmpService codeEmpService = (CodeEmpService) context.getBean("codeEmpService");

        return codeEmpService.update(codeEmp);
    }

    public static List<CodeEmp> getList(){
        CodeEmpService codeEmpService = (CodeEmpService) context.getBean("codeEmpService");

        return codeEmpService.getList();
    }

    public static CodeEmp getInfo(int id){
        CodeEmpService codeEmpService = (CodeEmpService) context.getBean("codeEmpService");

        return codeEmpService.getInfo(id);
    }
}
