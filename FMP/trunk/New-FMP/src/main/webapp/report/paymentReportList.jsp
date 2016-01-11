<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
            </div>
        </div>
        <p class="mt50">
            <s:if test="showAddButton">
                <input type="button" id="btnAddSales" class="btnAdd btn_style none" value="新建"/>
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
