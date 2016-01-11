<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                产品:<select id="byP2pProduct"></select>
                交易状态:<select id="byStatus"></select>
                还款区间:<input id="byStartRepayIssue" class="date" type="text"/>— —
                <input id="byEndRepayIssue" class="date" type="text" />
                短信状态:<select id="smsStatus" type="text" ></select>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <input id="btnExcel" type="button" value="导出Excel" class="btn_style"/>
                还款时间：<input type="text" id="honourDate" class="date" />
                <input type="button" id="honour" value="兑付报表" class="btn_style">
                <input type="button" id="interest" value="付息报表" class="btn_style">
            </div>
        </div>
        <p class="mt50">
            <input type="button" id="cancelSms" value="取消发送短信" class="btn_style">
            <input type="button" id="sendSms" value="完成还款，发送短信" class="btn_style">
            <input type="button" id="continueSms" value="发送续投短信" class="btn_style">
			<s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
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
