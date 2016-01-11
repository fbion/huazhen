package com.hzfh.p2p.model.customer;

import com.hzfh.api.customer.model.EmailChange;
import com.hzfh.api.customer.model.query.EmailChangeCondition;
import com.hzfh.p2p.facade.customer.EmailChangeFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmailChangeModel {
    public static PagedList<EmailChange> getPagingList(EmailChangeCondition emailChangeCondition) {
        return EmailChangeFacade.getPagingList(emailChangeCondition);
    }

    public static int add(EmailChange emailChange) {
        return EmailChangeFacade.add(emailChange);
    }

    public static int update(EmailChange emailChange) {
        return EmailChangeFacade.update(emailChange);
    }

    public static List<EmailChange> getList() {
        return EmailChangeFacade.getList();
    }

    public static EmailChange getInfo(int id) {
        return EmailChangeFacade.getInfo(id);
    }

	public static List<EmailChange> getListByCondition(EmailChangeCondition emailChangeCondition) {
		return EmailChangeFacade.getListByCondition(emailChangeCondition);
	}
}
