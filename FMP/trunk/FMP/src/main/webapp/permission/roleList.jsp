<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>

            <div class="wrappSearchContent">
                名称：<input type="text" id="txtName">
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <p class="mt50"><input type="button" id="btnAdd" value="新建" class="btn_style"/></p>

        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
        <!-- 权限分配-->
        <div id="w" class="easyui-window" title="权限分配" data-options="closed:true,iconCls:'icon-save'"
             style="width:1000;height:800px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div class="basic_Info_content p15 info_All">
                    <div id="userName"></div>
                    <input type="hidden" id="roleElementId">

                    <div id="treeboxbox_tree" class="dhtmlxTree"
                         style="width: 30%; height: 800px; background-color: #f5f5f5; border: 1px solid Silver;float:left">

                    </div>
                    <div class="dhtmlxTreeContent" style="float:left; border:1px solid red; width:60%; height:800px;">
                        <p style="text-align:right;">
                            <em id="flush_msg"></em>
                            <input type="button" id="flushMenuTree" value="刷新MenuTree"
                                   class="submit_Btn -none btn_style" style="cursor:pointer"/>
                        </p>

                        <div id="roleElement" class="basic_Info_content p15 info_All">
                            <form id="roleElementFrom">
                                <div id="roleElementDiv">
                                    <ul>
                                        <li id="newItem1">
                                            <input id="newItem" name="newItem" type="checkbox" class="ml20" value="1"/>添加
                                        </li>
                                        <li id="edit1">
                                            <input id="edit" name="edit" type="checkbox" class="ml20" value="1"/>修改
                                        </li>
                                    </ul>
                                    <ul>
                                        <li id="query1">
                                            <input id="query" name="query" type="checkbox" class="ml20" value="1"/>查看
                                        </li>
                                        <li id="del1">
                                            <input id="del" name="del" type="checkbox" class="ml20" value="1"/>删除
                                        </li>
                                    </ul>
                                </div>
                                <p id="btn1">
                                    <em id="msg"></em>
                                    <input type="submit" id="roleElementSubmit" value="提交"
                                           class="submit_Btn -none btn_style"/>
                                </p>
                                <input id="elementId" name="elementId" type="text" class="ml20" hidden="hidden"/>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </m:Content>
</m:ContentPage>