package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Registration;
import com.hzfh.api.employee.model.query.RegistrationCondition;
import com.hzfh.api.employee.service.RegistrationService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RegistrationFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Registration> getPagingList(RegistrationCondition registrationCondition) {
        RegistrationService registrationService = (RegistrationService) context.getBean("registrationService");

        return  registrationService.getPagingList(registrationCondition);
    }

    public static int add(Registration registration){
        RegistrationService registrationService = (RegistrationService) context.getBean("registrationService");

        return registrationService.add(registration);
    }

    public static int update(Registration registration){
        RegistrationService registrationService = (RegistrationService) context.getBean("registrationService");

        return registrationService.update(registration);
    }

    public static List<Registration> getList(){
        RegistrationService registrationService = (RegistrationService) context.getBean("registrationService");

        return registrationService.getList();
    }

    public static Registration getInfo(int id){
        RegistrationService registrationService = (RegistrationService) context.getBean("registrationService");

        return registrationService.getInfo(id);
    }
}
