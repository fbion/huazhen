<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
               	 用户昵称  <input id="userName">
               	 奖项 <select label="奖项"  id="drawAwards"/>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <input type="button" id="btnExcel" value="导出Excel" class="btn_style" />
            </div>
        </div>
        <p class="mt50 pl20"> 

        <div class="pic mt20 pl20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
    </m:Content>
</m:ContentPage>
