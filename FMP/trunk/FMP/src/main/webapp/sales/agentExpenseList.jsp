<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
               客户类型：<select id="selectCustomerType"></select>
               客户名称：<select id="selectCustomer"></select>
               下游类型：<select id="selectAgentType"></select>
               下游渠道：<select id="selectAgent"></select>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <p class="mt50"><input type="button" id="btnAdd" value="新建"  class="btn_style"/></p>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
    </m:Content>
</m:ContentPage>
