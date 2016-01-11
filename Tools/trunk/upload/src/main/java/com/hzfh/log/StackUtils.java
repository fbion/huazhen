package com.hzfh.log;

import com.hzfh.api.log.model.StackMsgBean;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2015/6/15.
 */
public class StackUtils {
    private static final Logger logger = Logger.getLogger(StackUtils.class);
    public StackMsgBean useTransaction(String className){
        StackMsgBean stackMsgBean = new StackMsgBean();
        Throwable ex = new Throwable();
        StackTraceElement[] stackTraceElements = ex.getStackTrace();
        if(stackMsgBean != null){
            for (int j = 0; j < stackTraceElements.length; j++) {
                String classNam = stackTraceElements[j].getFileName();
                if(classNam.equals(className+".java")){
                    stackMsgBean.setMethodName(stackTraceElements[j].getMethodName());//得到执行方法名称
                    stackMsgBean.setClassName(stackTraceElements[j].getClassName());//得到执行类名称
                    break;
                }
            }
        }
        return stackMsgBean;
    }
}
