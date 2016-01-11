<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<html>
<head>
    <title></title>
    ${pageHead}
</head>
<body>
<div class="amountmoney">
    <div id="salesMain" class="salesMain"></div>
    <div id="customerPersonalMain" class="customerPersonalMain"></div>
</div>

<div class="trustfund" data-options="fitColumns:true,border:false" style='width:96%'>
    <div id="productModel" class="easyui-panel  portal-column" title="" data-options="closable:true,fit:true,border:false,fitColumns:true">
        <div id="product" class="easyui-tabs" data-options="fit:true">
            <div title="现房宝">
                <table id="xianFangBaoList" status="5"></table>
            </div>
            <div title="信托">
                <table id="xinTuoList" status="1"></table>
            </div>
            <div title="资管">
                <table id="ziGuanList" status="2"></table>
            </div>
            <div title="基金">
                <table id="jiJinList" status="3"></table>
            </div>
             <a id="productMore" href="#" class="indexofmore">More</a>
        </div>
    </div>
</div>

<div class="news_notice">
    <div id="knowledgeBaseModel" class="easyui-panel portal-column" style="width: 48%;height: 185px; float:left;"  title="" data-options="closable:true,border:false">
        <div id="knowledgeBase" class="easyui-tabs" data-options="fit:true">
            <div title="公告">
                <table id="noticeList" status="1"></table>
            </div>
            <div title="新闻">
                <table id="newsList" status="2"></table>
            </div>
            <div title="常识">
                <table id="nousList" status="3"></table>
            </div>
            <div title="知识">
                <table id="knowledgeList" status="4"></table>
            </div>
            <div title="制度">
                <table id="systemList" status="5"></table>
            </div>
             <a id="knowledgeBaseMore" href="#" class="indexofmore">More</a>
        </div>
    </div>
    <div id="activityModel" class="easyui-panel portal-column" style="width: 48%;height: 185px; float:left;" title="" data-options="closable:true,border:false">
        <div id="activity" class="easyui-tabs" data-options="fit:true">
            <div title="活动通知">
                <table id="activityList"></table>
            </div>
             <a id="activityMore" href="#" class="indexofmore">More</a>
        </div>
    </div>

</div>

${pageVar}
</body>
</html>


