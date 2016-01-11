package com.hzfh.fmp.model.common.helper;

import com.hzfh.api.log.model.Log;
import com.hzfh.api.log.model.StackMsgBean;
import com.hzfh.fmp.model.common.enumeration.LogConstant;
import com.hzfh.fmp.model.log.LogModel;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/5/25.
 */
public class LogHelper {
    private Log log;
    private Logger logger;

    public LogHelper(Logger log4jLogger) {
        this.logger = log4jLogger;
    }

    public static LogHelper getLogger(Class classObject) {
        return new LogHelper(Logger.getLogger(classObject));
    }

    public static LogHelper getLogger(String loggerName) {
        return new LogHelper(Logger.getLogger(loggerName));
    }

    /**
     * @param logLevel    日志等级
     * @param operateName 功能名称
     * @Description: 系统日志log开始
     */
    public void sysLogStart(String logLevel, String operateName) {
        sysLogStart(logLevel, operateName, null, null,0);
    }

    /**
     *
     * @param logLevel
     * @param userId
     */
    public void sysLogStart(String logLevel,String operateName,int userId){
       sysLogStart(logLevel,operateName,null,null,userId);
    }

    /**
     *: 系统日志log开始
     */
    public void sysLogStart(String logLevel, String operateName, String supplement) {
        sysLogStart(logLevel, operateName, null, supplement,0);
    }
    /**
     * 系统日志log开始
     */
    /**
     * @param logLevel    日志等级
     * @param operateName 功能名称
     * @param paramIn     入参
     * @param supplement  功能名称补充
     */

    public void sysLogStart(String logLevel, String operateName, String paramIn, String supplement,int userId) {
        this.log = new Log();

        log.setLevel(logLevel);
        log.setOperateName(operateName);
        log.setSupplement(supplement);
        HttpServletRequest request = this.getRequest();
        if (request != null) {
            log.setRequestType(request.getMethod());
            log.setHostIp(request.getRemoteAddr());
            log.setBrowser(request.getHeader("User-Agent"));
            log.setAccessUrl(request.getRequestURL().toString());
            log.setProjectName(request.getContextPath());
            log.setStartTime(this.getNowTime());
            if (UserHelper.getUserCache() != null) {
                log.setUserNo(UserHelper.getUserCache().getUserId());
            }else{
                log.setUserNo(userId);
            }
            StackUtils stackUtils = new StackUtils();
            StackMsgBean stackMsgBean = stackUtils.useTransaction(logger.getName().substring(logger.getName().lastIndexOf(".") + 1, logger.getName().length()));
            log.setClassName(stackMsgBean.getClassName());
            log.setMethodName(stackMsgBean.getMethodName());
        }
        try{
            LogModel.add(log);
        }catch (Exception e){
            e.printStackTrace();
        }





    }

    /**
     * @param logLevel 日志等级
     * @param forward  跳转页面
     * @Description: 系统日志log结束
     */

    /*public void sysLogEnd(String logLevel, String forward) {
        sysLogEnd(logLevel, null, forward, null, null);
    }*/

    /**
     * @param logLevel 日志等级
     * @param errorMsg 错误信息
     * @Description:系统日志log开始
     */
    public void sysLogEnd(String logLevel, String errorMsg) {
        sysLogEnd(logLevel, null, null, errorMsg, null);
    }

    /**
     * @param logLevel 日志级别
     * @param errorMsg 错误信息
     * @param e        异常
     * @Description: 系统日志log结束
     */
    public void sysLogEnd(String logLevel, String errorMsg, Throwable e) {
        sysLogEnd(logLevel, null, null, errorMsg, e);

    }

    /**
     * @param logLevel 日志级别
     * @param paramOut 结果
     * @param errorMsg 错误信息
     * @param e        异常
     * @Description: 系统日志log结束
     */
    public void sysLogEnd(String logLevel, String paramOut, String errorMsg, Throwable e) {
        sysLogEnd(logLevel, paramOut, null, errorMsg, e);

    }


    /**
     * @param logLevel 日志级别
     * @param paramOut 结果信息
     * @param forward  转发路径
     * @param errorMsg 错误信息
     * @param e        异常
     * @Description: 系统日志log结束
     */
    public void sysLogEnd(String logLevel, String paramOut, String forward, String errorMsg, Throwable e) {
        this.log = new Log();

        log.setLevel(logLevel);
        log.setOperateName(errorMsg);
        HttpServletRequest request = this.getRequest();
        if (request != null) {
            log.setRequestType(request.getMethod());
            log.setHostIp(request.getRemoteAddr());
            log.setBrowser(request.getHeader("User-Agent"));
            log.setAccessUrl(request.getRequestURL().toString());
            log.setProjectName(request.getContextPath());
            log.setEndTime(this.getNowTime());
            log.setForwardUrl(forward);
            if (UserHelper.getUserCache() != null) {
                log.setUserNo(UserHelper.getUserCache().getUserId());
            }
            StackUtils stackUtils = new StackUtils();
            StackMsgBean stackMsgBean = stackUtils.useTransaction(logger.getName().substring(logger.getName().lastIndexOf(".") + 1, logger.getName().length()));
            log.setClassName(stackMsgBean.getClassName());
            log.setMethodName(stackMsgBean.getMethodName());
            if(e != null){
                log.setExceptionMsg(e.toString());
            }

        }
        try{
            LogModel.add(log);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void info(String msg, Throwable t) {
        sysLogEnd(LogConstant.LOG_LEVEL_INFO, msg, t);
    }

    public void info(String msg) {
        sysLogStart(LogConstant.LOG_LEVEL_INFO, msg);
    }

    public void info(String msg,int userId){
        sysLogStart(LogConstant.LOG_LEVEL_INFO,msg,userId);
    }

    public void debug(String msg, Throwable t) {
        sysLogEnd(LogConstant.LOG_LEVEL_DEBUG, msg, t);
    }

    public void debug(String msg) {
        sysLogStart(LogConstant.LOG_LEVEL_DEBUG, msg);
    }

    public void error(String msg, Throwable t) {
        sysLogEnd(LogConstant.LOG_LEVEL_ERROR, msg, t);
    }

    public void error(String msg) {
        sysLogStart(LogConstant.LOG_LEVEL_ERROR, msg);
    }

    public void warn(String msg, Throwable t) {

        sysLogEnd(LogConstant.LOG_LEVEL_WARN, msg, t);
    }

    public void warn(String msg) {
        sysLogStart(LogConstant.LOG_LEVEL_WARN, msg);
    }

    private HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return request;
        }
        return null;
    }

    private String getNowTime() {
        String nowTime = "";
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        nowTime = time.format(new Date());
        return nowTime;
    }
}
