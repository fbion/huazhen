<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">
         <div id="toolbar">
            <div>
            	<label>类型:</label>
                <select id="byType" class="easyui-combobox" data-options="prompt:'类型',searcher:AttendanceApplicationList.InitQuery"/>
                </select>
                <label>状态:</label>
                <select id="byStatus" class="easyui-combobox" data-options="prompt:'状态',searcher:AttendanceApplicationList.InitQuery"/>
                </select>
                <label>部门:</label>
                <select id="byDept"/>
                </select>
                <label>姓名:</label>
                <select id="byName"/>
                </select>
                <label>请假开始时间：</label>
                <select id="byYear"/>
                </select>年
                <select id="byMonth"/>
                </select>月
            
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">Search</a>
            </div>
            <s:if test="showAddButton">
                <a id="btnAdd" href="javascript:void(0)" class="easyui-linkbutton" text="New" data-options="iconCls:'icon-add',plain:true"></a>
            </s:if>
            <s:if test="showEditButton">
                <a id="btnEdit" href="javascript:void(0)" class="easyui-linkbutton" text="Edit" data-options="iconCls:'icon-edit',plain:true"></a>
            </s:if>
            	<a id="btnExcel" href="javascript:void(0)" class="easyui-linkbutton" text="导出Excel" data-options="iconCls:'icon-redo',plain:true"></a>
        </div>
            <table id="gridTable" class="gridTable">
            </table>
        ${pageVar}
    </m:Content>
</m:ContentPage>
