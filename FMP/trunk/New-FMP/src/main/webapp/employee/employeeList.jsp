<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">
		<div id="toolbar">
            <div>
            	<label>员工姓名:</label>
                <input id="txtName" class="easyui-searchbox"
                       data-options="prompt:'员工姓名',searcher:EmployeeList.InitQuery"/>
                <label>员工性别:</label>
                <select id="selectDicData" class="easyui-combobox" data-options="prompt:'员工性别',searcher:EmployeeList.InitQuery"/>
                </select>
                <label>在职状态:</label>
                <select id="byStatus" class="easyui-combobox" data-options="prompt:'在职状态',searcher:EmployeeList.InitQuery"/>
                </select>
                <label>审核状态:</label>
                <select id="selectVerify" class="easyui-combobox" data-options="prompt:'审核状态',searcher:EmployeeList.InitQuery"/>
                </select>
           	 	所属部门：<input id="departmentSel" type="text" value="" class="w80"/>
                         <input id="selectDept" type="text" style="display: none"/>
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">Search</a>
            </div>
            <s:if test="showAddButton">
                <a id="btnAdd" href="javascript:void(0)" class="easyui-linkbutton" text="New" data-options="iconCls:'icon-add',plain:true"></a>
            </s:if>
            <s:if test="showEditButton">
                <a id="btnEdit" href="javascript:void(0)" class="easyui-linkbutton" text="Edit" data-options="iconCls:'icon-edit',plain:true"></a>
            </s:if>
            <s:if test="showPositiveButton">
                <a id="btnPositive" href="javascript:void(0)" class="easyui-linkbutton" text="通知转正" data-options="iconCls:'icon-man',plain:true"></a>
                <a id="btnDelay" href="javascript:void(0)" class="easyui-linkbutton" text="通知延迟" data-options="iconCls:'icon-man',plain:true"></a>
            </s:if>
            <s:if test="showExcelButton">
            	<a id="btnExcel" href="javascript:void(0)" class="easyui-linkbutton" text="导出员工信息" data-options="iconCls:'icon-redo',plain:true"></a>
            	<a id="btnExcelEmployee" href="javascript:void(0)" class="easyui-linkbutton" text="导出人事报表" data-options="iconCls:'icon-redo',plain:true"></a>
            	<a id="btnExcelWxEmployee" href="javascript:void(0)" class="easyui-linkbutton" text="导出微信通讯录" data-options="iconCls:'icon-redo',plain:true"></a>
           </s:if>
        </div>
            <table id="gridTable" class="gridTable">
            </table>

        <div id="w" class="easyui-window" title="选择日期" data-options="closed:true,iconCls:'icon-save'"
             style="width:240;height:160px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <select id="year"></select>年
                    <select id="month"></select>月
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <span id="message" style="width:80px"></span>
                    <a class="easyui-linkbutton" id="ok" style="width:80px">确定</a>
                    <a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#w').window('close')"
                       style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
