package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.PersonalChange;
import com.hzfh.api.employee.model.query.PersonalChangeCondition;
import com.hzfh.fmp.facade.employee.PersonalChangeFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class PersonalChangeModel {
    public static PagedList<PersonalChange> getPagingList(PersonalChangeCondition personalChangeCondition) {
        return PersonalChangeFacade.getPagingList(personalChangeCondition);
    }

    public static int add(PersonalChange personalChange) {
        return PersonalChangeFacade.add(personalChange);
    }

    public static int update(PersonalChange personalChange) {
        return PersonalChangeFacade.update(personalChange);
    }

    public static List<PersonalChange> getList() {
        return PersonalChangeFacade.getList();
    }

    public static PersonalChange getInfo(int id) {
        return PersonalChangeFacade.getInfo(id);
    }

	public static PersonalChange getByActivitiNo(String activitiNo) {
		// TODO Auto-generated method stub
		return PersonalChangeFacade.getByActivitiNo(activitiNo);
	}
}
