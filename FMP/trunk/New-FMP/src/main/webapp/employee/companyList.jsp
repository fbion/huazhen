<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">

        <div id="toolbar">
            <div>
                <label>公司名称:</label><input id="name" class="easyui-searchbox" data-options="prompt:'公司',searcher:CompanyList.InitQuery"/>
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">Search</a>
            </div>
            <s:if test="showAddButton">
                <a id="btnAdd" href="javascript:void(0)" class="easyui-linkbutton" text="New" data-options="iconCls:'icon-add',plain:true"></a>
            </s:if>
            <s:if test="showEditButton">
                <a id="btnEdit" href="javascript:void(0)" class="easyui-linkbutton" text="Edit" data-options="iconCls:'icon-edit',plain:true"></a>
            </s:if>
            <s:if test="showDetailButton">
                <a id="btnDetail" href="javascript:void(0)" class="easyui-linkbutton" text="Detail" data-options="iconCls:'icon-remove',plain:true"></a>
            </s:if>
        </div>
        <table id="gridTable"></table>
    </m:Content>
</m:ContentPage>
