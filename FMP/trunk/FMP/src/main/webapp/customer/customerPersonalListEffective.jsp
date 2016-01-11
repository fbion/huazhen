<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>

            <div class="wrappSearchContent">
                客户来源: <select id="sourceType"></select>
                姓名: <input type="text" id="txtName" style="width:100px">
                手机号: <input type="text" id="cellPhone1" style="width:100px">
                关系等级: <select id="selectRelationLevel"></select>
                偏好: <select id="selectRiskHobby"></select>
                部门：
                <input id="departmentSel" type="text" value="" class="w80"/>
                <input id="selectDepartment" type="text" style="display:none"/>
                负责人：<input id="employeeSel" type="text" value="" class="w80"/>
                <input type="text" id="selectEmpNo" style="display: none"/>
                开始时间：<input id="findTimeDown" type="text"/>
                结束时间：<input id="findTimeUp" type="text"/>
                跟踪结果：<select id="selectResultStatus"></select>
                <%--<span class="ml15"></span>是否打款：<select id="selectIsSales">--%>
                <%--<option value="-1">全部</option>--%>
                <%--<option value="1">是</option>--%>
                <%--<option value="0">否</option>--%>
            </select>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <s:if test="showExcelButton">
                    <input type="button" id="btnExcel" value="导出Excel" class="btn_style"/>
                </s:if>
            </div>
        </div>
        <p class="mt50">
            <s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if>
            <s:if test="showUpdateManagerNo">
                <input type="button" id="btnChangeManager" value="修改负责人" class="btn_style"/>
            </s:if>
        </p>

        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager"></div>
        </div>
        <div id="customerFollow" class="easyui-window" title="客户跟踪"
             data-options="closed:true" style="width: 1500px; height: 520px; padding: 5px;">
            <input type="text" hidden="hidden" id="customerId" value=""/>
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding: 10px;">
                    <div>
                        <h3></h3>
                        <div class="wrappSearchContent">
                        </div>
                    </div>
                    <p class="pl20">
                        <s:if test="showAddButton">
                            <input type="button" id="btnAddFollow" value="新建"
                                   class="btn_style" />
                        </s:if>
                    </p>
                    <div class="pic mt20 pl20">
                        <table id="gridTableFollow" class="gridTable">
                        </table>
                        <div id="gridPagerFollow" class="gridPager"></div>
                    </div>
                    <!-- <h1>内容分割！</h1>			 -->
                </div>
                <div data-options="region:'south',border:false"
                     style="text-align: right; padding: 5px 0 0;">
                    <span id="message" style="width: 80px"></span>
                    <!--  <a id="confirm" class="easyui-linkbutton"  href="javascript:void(0)" style="width:80px">确定</a> -->
                    <a class="easyui-linkbutton" href="javascript:void(0)"
                       onclick="$('#customerFollow').window('close')" style="width: 80px">关闭</a>
                </div>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
