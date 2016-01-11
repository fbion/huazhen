package com.hzfh.fmp.model.workFlow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.model.employee.PositionModel;
import com.hzframework.helper.DateHelper;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import com.hzfh.api.workFlow.model.CommentVO;
import com.hzfh.fmp.facade.workFlow.ProcessingFacade;
import com.hzfh.fmp.model.employee.EmployeeModel;


public class ProcessingModel {

	public static List<HistoricProcessInstance> getHistoricProcessInstanceList(String userNo, int startIndex, int pageSize) {
		return ProcessingFacade.getHistoricProcessInstanceListByUserNo(userNo,startIndex,pageSize);
	}

	public static ProcessDefinition getProcessDefinitionByProDefId(String proDefId) {
		return ProcessingFacade.getProcessDefinitionByProDefId(proDefId);
		
	}
	public static int getProcessingTotalCount(String userNo) {
		return ProcessingFacade.getProcessingTotalCountByUserNo(userNo);
	}

	public static String startFlowProcess(String type,String userNo, Map<String, Object> variables, String comment, String uri) {
		return ProcessingFacade.startFlowProcess(type,userNo,variables,comment,uri);
	}

	//
	public static String startFlowProcessForNoApplicant(String type,String userNo, Map<String, Object> variables, String comment, String uri) {
		return ProcessingFacade.startFlowProcessForNoApplicant(type,userNo,variables,comment,uri);
	}
	public static String startFlowProcessWithEmail(String type,String userNo, Map<String, Object> variables, String comment, String uri) {
		return ProcessingFacade.startFlowProcessWithEmail(type,userNo,variables,comment,uri);
	}

	public static List<CommentVO> getProintCommnets(String activitiNo) {
		List<Comment> commentList = ProcessingFacade.getCommnetsByProcessInsId(activitiNo);
		List<CommentVO> CommentVOList = new ArrayList<CommentVO>() ;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
		if(commentList.size()!=0&&commentList!=null){
			for (int i =  commentList.size()-1; i >=0; i--) {
				CommentVO commenVO = new CommentVO();
				commenVO.setCheckName(EmployeeModel.getEmpByUserId(Integer.parseInt(commentList.get(i).getUserId())).getName());
				commenVO.setCheckTime(sf.format(commentList.get(i).getTime()));
				String checkPosition = ProcessingFacade.getHistoricTaskInstanceByTaskId(commentList.get(i).getTaskId()).getName();
				commenVO.setCheckPosition(checkPosition);
				commenVO.setCheckComment(commentList.get(i).getFullMessage());
				CommentVOList.add(commenVO);
			}
		}
		return CommentVOList;
	}

	public static List<CommentVO> getProductAuditCommnets(String activitiNo) {
		List<Comment> commentList = ProcessingFacade.getCommnetsByProcessInsId(activitiNo);
		List<CommentVO> CommentVOList = new ArrayList<CommentVO>();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (commentList.size() != 0 && commentList != null) {
			for (int i = commentList.size() - 1; i >= 0; i--) {
				CommentVO commenVO = new CommentVO();
				Employee employee = EmployeeModel.getEmpByUserId(Integer.valueOf(Integer.parseInt(commentList.get(i).getUserId())));
				commenVO.setCheckName(employee.getName());
				commenVO.setCheckTime(sf.format(commentList.get(i).getTime()));
				commenVO.setCheckPosition(PositionModel.getInfo(employee.getPositionNo()).getName());
				commenVO.setCheckComment(commentList.get(i).getFullMessage().split("：")[0]);
				CommentVOList.add(commenVO);
			}
		}
		return CommentVOList;
	}

	public static Task getBackTask(String proId, String userNo) {
		return ProcessingFacade.getBackTask( proId,userNo);
		
	}
   
}
