package com.hzfh.p2p.model.sales;

import java.util.List;

import com.hzfh.api.sales.model.Contract;
import com.hzfh.api.sales.model.query.ContractCondition;
import com.hzfh.p2p.facade.sales.ContractFacade;
import com.hzframework.contract.PagedList;

public class ContractModel {
    public static PagedList<Contract> getPagingList(ContractCondition contractCondition) {
        return ContractFacade.getPagingList(contractCondition);
    }

    public static int add(Contract contract) {
        return ContractFacade.add(contract);
    }

    public static int update(Contract contract) {
        return ContractFacade.update(contract);
    }

    public static List<Contract> getList() {
        return ContractFacade.getList();
    }

    public static Contract getInfo(int id) {
        return ContractFacade.getInfo(id);
    }
}
