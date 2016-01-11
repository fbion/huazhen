package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.FamilyMembers;
import com.hzfh.api.employee.model.query.FamilyMembersCondition;
import com.hzfh.api.employee.service.FamilyMembersService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FamilyMembersFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<FamilyMembers> getPagingList(FamilyMembersCondition familyMembersCondition) {
        FamilyMembersService familyMembersService = (FamilyMembersService) context.getBean("familyMembersService");

        return  familyMembersService.getPagingList(familyMembersCondition);
    }

    public static int add(FamilyMembers familyMembers){
        FamilyMembersService familyMembersService = (FamilyMembersService) context.getBean("familyMembersService");

        return familyMembersService.add(familyMembers);
    }

    public static int update(FamilyMembers familyMembers){
        FamilyMembersService familyMembersService = (FamilyMembersService) context.getBean("familyMembersService");

        return familyMembersService.update(familyMembers);
    }

    public static List<FamilyMembers> getList(){
        FamilyMembersService familyMembersService = (FamilyMembersService) context.getBean("familyMembersService");

        return familyMembersService.getList();
    }

    public static FamilyMembers getInfo(int id){
        FamilyMembersService familyMembersService = (FamilyMembersService) context.getBean("familyMembersService");

        return familyMembersService.getInfo(id);
    }

    public static List<FamilyMembers> getFamilyMembersByEmpNo(int empNo){
        FamilyMembersService familyMembersService = (FamilyMembersService) context.getBean("familyMembersService");
        return familyMembersService.getFamilyMembersByEmpNo(empNo);
    }

}
