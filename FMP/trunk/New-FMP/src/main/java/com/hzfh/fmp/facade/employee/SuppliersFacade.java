package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.Suppliers;
import com.hzfh.api.employee.model.query.SuppliersCondition;
import com.hzfh.api.employee.service.SuppliersService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SuppliersFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<Suppliers> getPagingList(SuppliersCondition suppliersCondition) {
        SuppliersService suppliersService = (SuppliersService) context.getBean("suppliersService");

        return  suppliersService.getPagingList(suppliersCondition);
    }

    public static int add(Suppliers suppliers){
        SuppliersService suppliersService = (SuppliersService) context.getBean("suppliersService");

        return suppliersService.add(suppliers);
    }

    public static int update(Suppliers suppliers){
        SuppliersService suppliersService = (SuppliersService) context.getBean("suppliersService");

        return suppliersService.update(suppliers);
    }

    public static List<Suppliers> getList(){
        SuppliersService suppliersService = (SuppliersService) context.getBean("suppliersService");

        return suppliersService.getList();
    }

    public static Suppliers getInfo(int id){
        SuppliersService suppliersService = (SuppliersService) context.getBean("suppliersService");

        return suppliersService.getInfo(id);
    }
}
