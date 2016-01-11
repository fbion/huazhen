package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Suppliers;
import com.hzfh.api.employee.model.query.SuppliersCondition;
import com.hzfh.fmp.facade.employee.SuppliersFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class SuppliersModel {
    public static PagedList<Suppliers> getPagingList(SuppliersCondition suppliersCondition) {
        return SuppliersFacade.getPagingList(suppliersCondition);
    }

    public static int add(Suppliers suppliers) {
        return SuppliersFacade.add(suppliers);
    }

    public static int update(Suppliers suppliers) {
        return SuppliersFacade.update(suppliers);
    }

    public static List<Suppliers> getList() {
        return SuppliersFacade.getList();
    }

    public static Suppliers getInfo(int id) {
        return SuppliersFacade.getInfo(id);
    }
}
