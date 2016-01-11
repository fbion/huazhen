<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">

        <div id="toolbar">
            <div>
                <label>打款状态:</label>
                <select  id="status" class="easyui-combobox" data-options="prompt:'',searcher:SalesList.InitQuery"></select>
                <label>产品类型:</label>
                <select  id="productType" class="easyui-combobox" data-options="prompt:'',searcher:SalesList.InitQuery"></select>
                <label>产品:</label>
                <select  id="productNo" class="easyui-combobox" data-options="prompt:'',searcher:SalesList.InitQuery"></select>
                <label>销售类型:</label>
                <select  id="peopleType" class="easyui-combobox" data-options="prompt:'',searcher:SalesList.InitQuery"></select>
                <label>销售:</label>
                <select  id="peopleNo" class="easyui-combobox" data-options="prompt:'',searcher:SalesList.InitQuery"></select>
                <label>部门:</label>
                <input id="departmentSel" type="text" value="" class="w80 rounded"/>
                <input id="deptNo" type="text" style="display:none"/>
                <label>销售经理:</label>
                <input id="employeeSel" type="text" value="" class="w80 rounded"/>
                <input type="text" id="empNo" style="display: none"/>
                <label>客户名:</label>
                <input id="customerName" class="easyui-searchbox" data-options="prompt:'',searcher:SalesList.InitQuery"/>
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                <s:if test="showExcelButton">
                    <a id="btnExcel" href="javascript:void(0)" class="easyui-linkbutton" iconCls="">导出Excel</a>
                </s:if>
                <input type="checkbox" id="isExpire" class="ml50"/>筛选即将到期
            </div>
            <s:if test="showAddButton">
                <a id="btnAddSalesForProduct" href="javascript:void(0)" class="easyui-linkbutton" text="新建普通产品打款" data-options="iconCls:'icon-add',plain:true"></a>
                <a id="btnAddSalesForP2pProduct" href="javascript:void(0)" class="easyui-linkbutton" text="新建新金融产品打款" data-options="iconCls:'icon-add',plain:true"></a>
            </s:if>
            <s:if test="showEditButton">
                <a id="btnEdit" href="javascript:void(0)" class="easyui-linkbutton" text="Edit" data-options="iconCls:'icon-edit',plain:true"></a>
            </s:if>
            <s:if test="showDetailButton">
                <a id="btnDetail" href="javascript:void(0)" class="easyui-linkbutton" text="Detail" data-options="iconCls:'icon-remove',plain:true"></a>
            </s:if>
        </div>
        <table id="gridTable"></table>
        ${pageVar}
    </m:Content>
</m:ContentPage>
