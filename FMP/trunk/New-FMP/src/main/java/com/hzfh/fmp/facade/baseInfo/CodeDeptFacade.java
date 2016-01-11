package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeDept;
import com.hzfh.api.baseInfo.model.query.CodeDeptCondition;
import com.hzfh.api.baseInfo.service.CodeDeptService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeDeptFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeDept> getPagingList(CodeDeptCondition codeDeptCondition) {
        CodeDeptService codeDeptService = (CodeDeptService) context.getBean("codeDeptService");

        return  codeDeptService.getPagingList(codeDeptCondition);
    }

    public static int add(CodeDept codeDept){
        CodeDeptService codeDeptService = (CodeDeptService) context.getBean("codeDeptService");

        return codeDeptService.add(codeDept);
    }

    public static int update(CodeDept codeDept){
        CodeDeptService codeDeptService = (CodeDeptService) context.getBean("codeDeptService");

        return codeDeptService.update(codeDept);
    }

    public static List<CodeDept> getList(){
        CodeDeptService codeDeptService = (CodeDeptService) context.getBean("codeDeptService");

        return codeDeptService.getList();
    }

    public static CodeDept getInfo(int id){
        CodeDeptService codeDeptService = (CodeDeptService) context.getBean("codeDeptService");

        return codeDeptService.getInfo(id);
    }
}
