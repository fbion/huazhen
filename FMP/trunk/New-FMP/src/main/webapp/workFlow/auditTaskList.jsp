<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">
        <div id="toolbar">
            <div>
                <label>申请人:</label>
                <input id="requestUser" class="easyui-searchbox"
                       data-options="prompt:'申请人',searcher:auditTaskList.InitQuery"/>
                <label>标题:</label>
                <select id="title" style="width:100px;" data-options="prompt:'标题',searcher:auditTaskList.InitQuery">
                    <option value="">全部</option>
                    <option value="tempRecruitNeedProcess">临时招聘</option>
                    <option value="extendProbationApplicationProcesss">延长试用期</option>
                    <option value="resignApplication">员工辞职</option>
                    <option value="personalChangeProcess">人事变动</option>
                    <option value="attendanceApplicationProcess">员工考勤</option>
                    <option value="repaymentExaminationProcess">还款报表</option>
                </select>
                <label>申请日期:</label>
                <input id="requestDate" class="Wdate rounded" type="text"/>
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">Search</a>
                <br/>
                <a id="btnDetails" href="javascript:void(0)" class="easyui-linkbutton" text="Detail"
                   data-options="iconCls:'icon-remove',plain:true"></a>
                <a id="btnExamine" href="javascript:void(0)" class="easyui-linkbutton" text="审批"
                   data-options="iconCls:'icon-man',plain:true"></a>
                <a id="btnProcess" href="javascript:void(0)" class="easyui-linkbutton" text="查看流程图"
                   data-options="iconCls:'icon-large-picture',plain:true"></a>
            </div>
        </div>
        <table id="gridTable" class="gridTable">
        </table>
        <div id="w1" class="easyui-window" title="审批" data-options="modal:true,closed:true,iconCls:'icon-save'"
             style="width:500px;height:200px;padding:10px;">
            <div>
                <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>

                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <input id="submit1" name="submit" type="submit" value="通过" class="submit_Btn  btn_style examine"/>
                    <input id="submit2" name="" type="submit" value="不通过" class="submit_Btn  btn_style examine"/>
                </div>
            </div>
        </div>
        <div id="procImgWin" class="easyui-window" title="流程监控窗口"
             data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,draggable:false,resizable:false,iconCls:'icon-redo'"
             style="width:400px;height:400px;padding:10px;">
            <img id="procImg" src=""/>
        </div>
        <div class="checkTrack"></div>
    </m:Content>
</m:ContentPage>
