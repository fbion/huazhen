package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Registration;
import com.hzfh.api.employee.model.query.RegistrationCondition;
import com.hzfh.fmp.facade.employee.RegistrationFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class RegistrationModel {
    public static PagedList<Registration> getPagingList(RegistrationCondition registrationCondition) {
        return RegistrationFacade.getPagingList(registrationCondition);
    }

    public static int add(Registration registration) {
        return RegistrationFacade.add(registration);
    }

    public static int update(Registration registration) {
        return RegistrationFacade.update(registration);
    }

    public static List<Registration> getList() {
        return RegistrationFacade.getList();
    }

    public static Registration getInfo(int id) {
        return RegistrationFacade.getInfo(id);
    }
}
