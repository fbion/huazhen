<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
               标题：<select id="selectTitle"></select>
             <!--    申请日期：<input id="date"> -->
               状态：<select id="status"><option value="" selected="selected">全部</option><option value="nuFinish">未结束</option><option value="finish">结束</select>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
    </m:Content>
</m:ContentPage>
