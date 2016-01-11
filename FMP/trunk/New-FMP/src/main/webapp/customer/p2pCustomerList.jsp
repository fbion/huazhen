<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">

        <div id="toolbar">
            <div>
                <label>用户名:</label>
                <input id="userName" class="easyui-searchbox" data-options="prompt:'',searcher:P2pCustomerList.InitQuery" />
                <label>门店:</label>
                <input id="deptNo" class="easyui-combobox" data-options="prompt:'',searcher:P2pCustomerList.InitQuery" style="width: 100px"/>
                <label>理财经理</label>
                <input id="employeeSel" type="text" value="" class="rounded"/>
                <input type="text" id="empNo" style="display: none"/>
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                </div>
            <div>
                <s:if test="showBuildCustomerButton">
                    <a id="buildCustomer" href="javascript:void(0)" class="easyui-linkbutton" text="创建自然人客户" data-options="iconCls:'icon-add',plain:true"></a>
                </s:if>
                <s:if test="showAssignEmpButton">
                    <a id="assignEmp" href="javascript:void(0)" class="easyui-linkbutton" text="指定理财经理" data-options="iconCls:'icon-man',plain:true"></a>
                </s:if>
            </div>
        </div>
        <table id="gridTable"></table>
        <div id="assignDialog" class="easyui-window" title="指定理财经理" data-options="closed:true,iconCls:'icon-save'" style="width:400px;height:150px;padding:5px">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    请选定理财经理：<input id="assignEmployeeSel" type="text" value="" class="rounded"/>
                    <input type="text" id="assignEmpNo" style="display: none"/>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <span id="message" style="width:80px"></span>
                    <a class="easyui-linkbutton" id="assignOK"  style="width:80px">确定</a>
                    <a class="easyui-linkbutton"  href="javascript:void(0)" onclick="$('#assignDialog').window('close')" style="width:80px" id="close">关闭</a>
                </div>
            </div>
        </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
