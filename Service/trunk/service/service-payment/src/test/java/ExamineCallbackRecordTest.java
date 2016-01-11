import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.payment.model.ExamineCallbackRecord;
import com.hzfh.api.payment.model.common.constant.QueryType;
import com.hzfh.api.payment.model.query.ExamineCallbackRecordCondition;
import com.hzfh.api.payment.model.request.controller.QueryReq;
import com.hzfh.api.payment.model.response.controller.QueryCpTransactionRecordResp;
import com.hzfh.api.payment.model.response.controller.QueryFreezereRecordResp;
import com.hzfh.api.payment.model.response.controller.QueryRechargeRecordResp;
import com.hzfh.api.payment.model.response.controller.QueryWithdrawRecordResp;
import com.hzfh.api.payment.service.AutoCheckingService;
import com.hzfh.api.payment.service.ControllerService;
import com.hzfh.api.payment.service.ExamineCallbackRecordService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;


public class ExamineCallbackRecordTest {

	@Test
	public void autoAccountCheckTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");
		ExamineCallbackRecord examineCallbackRecord = new ExamineCallbackRecord();
		examineCallbackRecord.setSn("201510191532126");
		examineCallbackRecord.setStatus((byte)0);
		int n = examineCallbackRecordService.add(examineCallbackRecord);
		System.out.println(n);
	}
	@Test
	public void getListByStatusTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");
		List<ExamineCallbackRecord>  examineCallbackRecords = examineCallbackRecordService.getListByStatus((byte)0);
		for (ExamineCallbackRecord ecr : examineCallbackRecords) {
			System.out.println(ecr.getId()+" - "+ ecr.getSn()+" - "+ ecr.getStatus()+" - "+ecr.getComment());
		}
	}
	@Test
	public void getExamineCallbackRecordsTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ExamineCallbackRecordService examineCallbackRecordService = (ExamineCallbackRecordService) context.getBean("examineCallbackRecordService");
		ExamineCallbackRecordCondition examineCallbackRecordCondition = new ExamineCallbackRecordCondition();
		int pageSize = 10;
		int pageIndex = 1;
        examineCallbackRecordCondition.setPageSize(pageSize);
        examineCallbackRecordCondition.setPageIndex(pageIndex);
        byte status = 0 ;//没有notify
        examineCallbackRecordCondition.setStatus(status);
        int minute = 5;//5分钟
        examineCallbackRecordCondition.setMinute(minute);
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("in_time");
        sortItem.setSortType(SortType.ASC);
        sortItemList.add(sortItem);
        examineCallbackRecordCondition.setSortItemList(sortItemList);
        
        PagedList<ExamineCallbackRecord> examineCallbackRecordPagedList = examineCallbackRecordService.getPagingList(examineCallbackRecordCondition);
        List<ExamineCallbackRecord> examineCallbackRecords = examineCallbackRecordPagedList.getResultList();
        for (ExamineCallbackRecord examineCallbackRecord : examineCallbackRecords) {
			System.out.println(examineCallbackRecord.getInTime());
		}
	}
	@Test
	public void rechargeNotifyTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ControllerService controllerService=(ControllerService) context.getBean("controllerService");
		QueryReq queryReq = new QueryReq();
		queryReq.setMode(QueryType.QUERY_RECHARGE_RECORD);
    	queryReq.setRequestNo("2015063011344166701472");
    	queryReq.setPlatformNo(queryReq.getPlatformNo());
    	QueryRechargeRecordResp rechargeRecord = controllerService.getRechargeRecord(queryReq);
    	System.out.println(rechargeRecord);
	}
	@Test
	public void withdrawNotifyTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ControllerService controllerService=(ControllerService) context.getBean("controllerService");
		QueryReq queryReq = new QueryReq();
		queryReq.setMode(QueryType.QUERY_WITHDRAW_RECORD);
		queryReq.setRequestNo("2015070112193357102567");
		queryReq.setPlatformNo(queryReq.getPlatformNo());
		QueryWithdrawRecordResp withdrawRecordResp = controllerService.getWithdrawRecord(queryReq);
		System.out.println(withdrawRecordResp);
	}
	@Test
	public void cpTransactionNotifyTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ControllerService controllerService=(ControllerService) context.getBean("controllerService");
		QueryReq queryReq = new QueryReq();
		queryReq.setMode(QueryType.QUERY_CP_TRANSACTION_RECORD);
		queryReq.setRequestNo("268017");
		queryReq.setPlatformNo(queryReq.getPlatformNo());
		QueryCpTransactionRecordResp cpTransactionRecordResp = controllerService.getCpTransactionRecord(queryReq);
		System.out.println(cpTransactionRecordResp);
	}
	@Test
	public void freezeNotifyTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ControllerService controllerService=(ControllerService) context.getBean("controllerService");
		QueryReq queryReq = new QueryReq();
		queryReq.setMode(QueryType.QUERY_FREEZERE_RECORD);
		queryReq.setRequestNo("268017");
		queryReq.setPlatformNo(queryReq.getPlatformNo());
		QueryFreezereRecordResp freezereRecordResp= controllerService.getFreezereRecord(queryReq);
		System.out.println(freezereRecordResp);
	}
	@Test
	public void autoExamineNotifyTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		AutoCheckingService autoCheckingService=(AutoCheckingService) context.getBean("autoCheckingService");
		autoCheckingService.autoExamineNotify();
		
	}
		

}
