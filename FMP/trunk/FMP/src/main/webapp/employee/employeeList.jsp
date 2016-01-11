<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>

            <div class="wrappSearchContent">
                员工姓名:<input type="text" id="txtName">
                员工性别:<select id="selectDicData"></select>
                <%--<input class="form-control" id="sexList" style="width: 100px"/>--%>
                在职状态:<select id="byStatus"></select>
                审核状态:<select id="selectVerify"></select>
                所属部门：<input id="departmentSel" type="text" value="" class="w80"/>
                         <input id="selectDept" type="text" style="display: none"/>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <s:if test="showExcelButton">
                    <input id="btnExcel" type="button" value="导出员工信息" class="btn_style"/>
                    <input id="btnExcelEmployee" type="button" value="导出人事报表" class="btn_style mr10"/>
                    <input id="btnExcelWxEmployee" type="button" value="导出微信通讯录" class="btn_style mr10"/>
                </s:if>

            </div>
        </div>
        <s:if test="showAddButton">
            <p class="mt50"><input type="button" id="btnAddNew" value="新建" class="btn_style"/></p>
        </s:if>

        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>

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
