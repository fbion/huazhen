<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                负责人:<input id="employeeSel" type="text" value="" class="w80"/>
                <input type="text" id="byInUserNo" style="display: none"/>

                姓名:<input type="text" id="txtName"/>
	            应聘职位：<select id="selectPositionNo"></select>
	            面试与否：<select id="isInterview"><option value="" selected="selected">全部</option><option value="0">否</option><option value="1">是</option></select>
	            是否录用：<select id="isEmploy"><option value="" selected="selected">全部</option><option value="0">否</option><option value="1">是</option></select>
                邀约时间：<select id="year"></select>年<span id="showMonth" hidden="hidden"><select id="month"></select>月</span>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <input type="button" id="btnExcel" value="导出Excel" class="btn_style"/>
            </div>
        </div>
        <p class="mt50"> 
			<s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if></p>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>

        <div id="w" class="easyui-window" title="选择面试日期" data-options="closed:true,iconCls:'icon-save'" style="width:320;height:160px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <%--<select id="byYear" ></select>年--%>
                    <%--<select id="byMonth" ></select>月--%>
                    <%--<select id="byDay" ></select>日--%>
                    邀约时间：<input id="invitationTime" name="invitationTime" type="text"class="ml20 data"/>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <span id="message" style="width:80px"></span>
                    <a class="easyui-linkbutton" id="ok"  style="width:80px">确定</a>
                    <a class="easyui-linkbutton"  href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
