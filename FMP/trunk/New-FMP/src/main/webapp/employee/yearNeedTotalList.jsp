<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <%--<div class="wrappSearch mt30">--%>
            <%--<h3></h3>--%>
            <%--<div class="wrappSearchContent">--%>

                <%--年份：<select id="year"></select>--%>
                <%--<input id="btnSearch" type="button" value="查询" class="btn_style"/>--%>

            <%--</div>--%>
        <%--</div>--%>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>

        <div class="btn tc mt30">
            <input id="btnBack" type="button" value="返回" class="btn_style" class="mt50"/>
        </div>

        ${pageVar}

    </m:Content>
</m:ContentPage>
