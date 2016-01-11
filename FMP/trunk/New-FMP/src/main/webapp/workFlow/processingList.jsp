<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">
            <div id="toolbar">
            <div>
            	<label>标题:</label>
                <select id="selectTitle" style="width:100px;" data-options="prompt:'标题',searcher:processingList.InitQuery">
                		<option value="">全部</option>
		    			<option value="tempRecruitNeedProcess">临时招聘</option>
		    			<option value="extendProbationApplicationProcesss">延长试用期</option>
		    			<option value="resignApplication">员工辞职</option>
		    			<option value="personalChangeProcess">人事变动</option>
		    			<option value="attendanceApplicationProcess">员工考勤</option>
		    			<option value="repaymentExaminationProcess">还款报表</option>
                </select>
                <label>申请日期:</label>
                <input id="requestDate" class="Wdate rounded" type="text" />
                <label>状态:</label>
                <select id="status"  data-options="prompt:'状态',searcher:processingList.InitQuery">
		                <option value="1">通过</option>
		    			<option value="2">不通过</option>
		    			<option value="3">删除</option>
                </select>
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">Search</a>
                <br />
               	<a id="btnDetails" href="javascript:void(0)" class="easyui-linkbutton" text="Detail" data-options="iconCls:'icon-remove',plain:true"></a>
                <a id="btnProcess" href="javascript:void(0)" class="easyui-linkbutton" text="查看流程图" data-options="iconCls:'icon-large-picture',plain:true"></a>
            </div>
            </div>
            <table id="gridTable" class="gridTable">
            </table>
        <div class="checkTrack"></div>
    </m:Content>
</m:ContentPage>
