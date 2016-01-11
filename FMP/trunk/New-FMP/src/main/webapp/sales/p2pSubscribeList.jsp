<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="newLayout">
	<m:Content contentPlaceHolderId="center">
        <div id="toolbar">
            <div>
                <label>产品名称:</label>
                <input id="p2pProductNo" class="easyui-combobox" data-options="prompt:'产品'"/>
                <label>预约客户:</label>
                <input id="customerName" class="easyui-searchbox" data-options="prompt:'客户',searcher:P2pSubscribeList.InitQuery"/>
                <label>手机号:</label>
                <input id="phone" class="easyui-searchbox" data-options="prompt:'手机',searcher:P2pSubscribeList.InitQuery"/>
                <label>门店:</label>
                <select id="deptNo" class="easyui-combobox" data-options="prompt:'门店'"></select>
                理财经理：<input id="employeeSel" type="text" value="" class="rounded"/>
                <input type="text" id="empNo" style="display: none"/>
                <label>状态:</label>
                <select id="status" class="easyui-combobox" data-options="prompt:'状态'"></select>
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">Search</a>
            </div>
            <s:if test="showAssignEmpButton">
                <a id="assignEmp" href="javascript:void(0)" class="easyui-linkbutton" text="指定理财经理" data-options="iconCls:'icon-man',plain:true"></a>
            </s:if>
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
