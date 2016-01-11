package com.hzfh.fmp.model.common.helper;

import com.hzfh.api.log.model.ProductLog;
import com.hzfh.api.log.model.StackMsgBean;
import com.hzfh.fmp.model.log.ProductLogModel;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2015/12/28.
 */
public class ProductLogHelper {
    private ProductLog productLog;
    private Logger logger;

    public ProductLogHelper(Logger log4jLogger) {
        this.logger = log4jLogger;
    }

    public static ProductLogHelper getLogger(Class classObject) {
        return new ProductLogHelper(Logger.getLogger(classObject));
    }

    public static ProductLogHelper getLogger(String loggerName) {
        return new ProductLogHelper(Logger.getLogger(loggerName));
    }
    public void addProductLog(String description,String afterDate,int productNo){
        try{
            this.productLog = new ProductLog();
            productLog.setProductNo(productNo);
            productLog.setDescription(description);
            productLog.setAfterData(afterDate);
            productLog.setInUserNo(UserHelper.getUserCache().getUserId());
            StackUtils stackUtils = new StackUtils();
            StackMsgBean stackMsgBean = stackUtils.useTransaction(logger.getName().substring(logger.getName().lastIndexOf(".") + 1, logger.getName().length()));
            productLog.setAction(stackMsgBean.getClassName());
            productLog.setMethod(stackMsgBean.getMethodName());
            ProductLogModel.add(productLog);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void addProductLog(String description,String afterDate,int productNo,String exception){
        try{
            this.productLog = new ProductLog();
            productLog.setProductNo(productNo);
            productLog.setDescription(description);
            productLog.setAfterData(afterDate);
            productLog.setInUserNo(UserHelper.getUserCache().getUserId());
            StackUtils stackUtils = new StackUtils();
            StackMsgBean stackMsgBean = stackUtils.useTransaction(logger.getName().substring(logger.getName().lastIndexOf(".") + 1, logger.getName().length()));
            productLog.setAction(stackMsgBean.getClassName());
            productLog.setMethod(stackMsgBean.getMethodName());
            productLog.setException(exception);
            ProductLogModel.add(productLog);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
