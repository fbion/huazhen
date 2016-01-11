package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.FamilyMembers;
import com.hzfh.api.employee.model.query.FamilyMembersCondition;
import com.hzfh.fmp.facade.employee.FamilyMembersFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class FamilyMembersModel {
    public static PagedList<FamilyMembers> getPagingList(FamilyMembersCondition familyMembersCondition) {
        return FamilyMembersFacade.getPagingList(familyMembersCondition);
    }

    public static int add(FamilyMembers familyMembers) {
        return FamilyMembersFacade.add(familyMembers);
    }

    public static int update(FamilyMembers familyMembers) {
        return FamilyMembersFacade.update(familyMembers);
    }

    public static List<FamilyMembers> getList() {
        return FamilyMembersFacade.getList();
    }

    public static FamilyMembers getInfo(int id) {
        return FamilyMembersFacade.getInfo(id);
    }

    public static List<FamilyMembers> getFamilyMembersByEmpNo(int empNo){
        return FamilyMembersFacade.getFamilyMembersByEmpNo(empNo);
    }
}
