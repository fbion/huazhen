<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">

        <div id="toolbar">
            <div>
            	<label>部门名称:</label>
                <input id="txtName" class="easyui-searchbox"
                       data-options="prompt:'部门名称',searcher:DepartmentList.InitQuery"/>
                <label>所属公司:</label>
                <select id="selectCompany" class="easyui-combobox" data-options="prompt:'所属公司',searcher:DepartmentList.InitQuery"/>
                </select>
                
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">Search</a>
            </div>
            <s:if test="showAddButton">
                <a id="btnAdd" href="javascript:void(0)" class="easyui-linkbutton" text="New" data-options="iconCls:'icon-add',plain:true"></a>
            </s:if>
            <s:if test="showEditButton">
                <a id="btnEdit" href="javascript:void(0)" class="easyui-linkbutton" text="Edit" data-options="iconCls:'icon-edit',plain:true"></a>
            </s:if>
        </div>
        <table id="gridTable"></table>
    </m:Content>
</m:ContentPage>
