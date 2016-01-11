<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                字典分类：<select id="selectDicType"></select>
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                <input type="button" id="btnFlushDicDataMemcached" value="刷新字典缓存" class="btn_style"/>
            </div>
        </div>
        <p class="mt50">
        <input type="button" id="btnAdd" value="新建" class="btn_style"/>
        </p>
        
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
    </m:Content>
</m:ContentPage>
