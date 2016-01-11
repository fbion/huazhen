package com.hzfh.fmp.controller.baseInfo;

import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.LogHelper;

/**
 * Created by Administrator on 2015/8/21.
 */
public class MailListAction extends CommonAction {

    public static final LogHelper logger = LogHelper.getLogger(LetterAction.class.getName());

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.mailList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        return SUCCESS;
    }
}
