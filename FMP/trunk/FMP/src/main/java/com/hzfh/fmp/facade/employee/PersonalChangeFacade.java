package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.PersonalChange;
import com.hzfh.api.employee.model.query.PersonalChangeCondition;
import com.hzfh.api.employee.service.PersonalChangeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PersonalChangeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<PersonalChange> getPagingList(PersonalChangeCondition personalChangeCondition) {
        PersonalChangeService personalChangeService = (PersonalChangeService) context.getBean("personalChangeService");

        return  personalChangeService.getPagingList(personalChangeCondition);
    }

    public static int add(PersonalChange personalChange){
        PersonalChangeService personalChangeService = (PersonalChangeService) context.getBean("personalChangeService");

        return personalChangeService.add(personalChange);
    }

    public static int update(PersonalChange personalChange){
        PersonalChangeService personalChangeService = (PersonalChangeService) context.getBean("personalChangeService");

        return personalChangeService.update(personalChange);
    }

    public static List<PersonalChange> getList(){
        PersonalChangeService personalChangeService = (PersonalChangeService) context.getBean("personalChangeService");

        return personalChangeService.getList();
    }

    public static PersonalChange getInfo(int id){
        PersonalChangeService personalChangeService = (PersonalChangeService) context.getBean("personalChangeService");

        return personalChangeService.getInfo(id);
    }

	public static PersonalChange getByActivitiNo(String activitiNo) {
		  PersonalChangeService personalChangeService = (PersonalChangeService) context.getBean("personalChangeService");
	      return personalChangeService.getByActivitiNo(activitiNo);
	}
}
