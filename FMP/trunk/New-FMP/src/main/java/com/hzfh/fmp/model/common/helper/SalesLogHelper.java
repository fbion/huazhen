package com.hzfh.fmp.model.common.helper;

import com.hzfh.api.log.model.SalesLog;
import com.hzfh.api.log.model.StackMsgBean;
import com.hzfh.fmp.model.log.SalesLogModel;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2015/11/3.
 */
public class SalesLogHelper {

    private SalesLog salesLog;
    private Logger logger;

    public SalesLogHelper(Logger log4jLogger) {
        this.logger = log4jLogger;
    }

    public static SalesLogHelper getLogger(Class classObject) {
        return new SalesLogHelper(Logger.getLogger(classObject));
    }

    public static SalesLogHelper getLogger(String loggerName) {
        return new SalesLogHelper(Logger.getLogger(loggerName));
    }


    public void addSalesLog(String description,String afterDate,int salesNo){
        try{
            this.salesLog = new SalesLog();
            salesLog.setSalesNo(salesNo);
            salesLog.setDescription(description);
            salesLog.setAfterData(afterDate);
            salesLog.setInUserNo(UserHelper.getUserCache().getUserId());
            StackUtils stackUtils = new StackUtils();
            StackMsgBean stackMsgBean = stackUtils.useTransaction(logger.getName().substring(logger.getName().lastIndexOf(".") + 1, logger.getName().length()));
            salesLog.setAction(stackMsgBean.getClassName());
            salesLog.setMethod(stackMsgBean.getMethodName());
            SalesLogModel.add(salesLog);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void addSalesLog(String description,String afterDate,int salesNo,String exception){
        try{
            this.salesLog = new SalesLog();
            salesLog.setSalesNo(salesNo);
            salesLog.setDescription(description);
            salesLog.setAfterData(afterDate);
            salesLog.setInUserNo(UserHelper.getUserCache().getUserId());
            StackUtils stackUtils = new StackUtils();
            StackMsgBean stackMsgBean = stackUtils.useTransaction(logger.getName().substring(logger.getName().lastIndexOf(".") + 1, logger.getName().length()));
            salesLog.setAction(stackMsgBean.getClassName());
            salesLog.setMethod(stackMsgBean.getMethodName());
            salesLog.setException(exception);
            SalesLogModel.add(salesLog);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
