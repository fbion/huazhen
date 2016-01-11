<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                打款状态:<select id="selectStatus"></select>
                产品类型：<select id="selectProductType"></select>
                产品：<select id="selectProduct"></select>
                客户类型：<select id="selectCustomerType"></select>
                客户：<select id="selectCustomer"></select>
                销售类型:<select id="selectAgentType"></select>
                <span>销售:</span><select id="selectAgent"></select>
                部门： <input id="departmentSel" type="text" value="" class="w80"/>
                <input id="byDeptNo" type="text" style="display:none"/>
                渠道经理：<input id="employeeSel" type="text" value="" class="w80"/>
                <input type="text" id="byEmpNo" style="display: none"/>
                <s:if test="showCustomerName">
                    客户名：<input id="customerName" type="text" value="" class="w80"/>
                </s:if>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <s:if test="showExcelButton">
                    <input type="button" id="btnExcel" value="导出Excel" class="btn_style" />
                </s:if>

                <input type="checkbox" id="isExpire" class="ml50"/>筛选即将到期
            </div>
        </div>
        <p class="mt50">
            <s:if test="showAddButton">
                <input type="button" id="btnAddSales" class="btnAdd btn_style none" value="新建"/>
                <input type="button" id="btnAddSalesForProduct" class="btnAdd btn_style" value="新建产品打款"/>
                <input type="button" id="btnAddSalesForP2pProduct" class="btnAdd btn_style" value="新建新金融产品打款"/>
            </s:if>
        </p>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
        ${pageVar}
        
    </m:Content>
</m:ContentPage>
