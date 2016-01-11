package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.EmailFiles;
import com.hzfh.api.baseInfo.model.query.EmailFilesCondition;
import com.hzfh.fmp.facade.baseInfo.EmailFilesFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class EmailFilesModel {
    public static PagedList<EmailFiles> getPagingList(EmailFilesCondition emailFilesCondition) {
        return EmailFilesFacade.getPagingList(emailFilesCondition);
    }

    public static int add(EmailFiles emailFiles) {
        return EmailFilesFacade.add(emailFiles);
    }

    public static int update(EmailFiles emailFiles) {
        return EmailFilesFacade.update(emailFiles);
    }

    public static List<EmailFiles> getList() {
        return EmailFilesFacade.getList();
    }

    public static EmailFiles getInfo(int id) {
        return EmailFilesFacade.getInfo(id);
    }
}
