<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <h3 class="choose_titile">请指定<span>${realName}</span>的理财经理</h3>
        <input type="text" id="p2pCustomer" class="p2pCustomer" value="${p2pCustomer}" hidden="hidden">
        <%-- <input type="text" id="p2pSubscribe" class="p2pSubscribe" value="${p2pSubscribe}" hidden="hidden"> --%>
        <div id="myChoose">
            <div class="text-center choose_area">
                <dl>
                    <dt>
                        省：<select id="province" class="province"></select>
                    </dt>
                    <dd></dd>
                </dl>
                <dl>
                    <dt>
                        市：<select id="city" class="city"> </select></dt>
                    <dd></dd>
                </dl>
                <dl>
                    <dt>区/县：<select id="district" class="district">
                    </select></dt>
                    <dd></dd>
                </dl>
                <dl>
                    <dt>
                        门店：<select id="department" class="department"></select></dt>
                    <dd></dd>
                </dl>
                <dl>
                    <dt>
                        理财经理：<select id="employee" class="employee"></select>
                    </dt>
                </dl>
            </div>
            <input id="commintAssign" class="commintAssign btn_style" type="submit" />
        </div>
    </m:Content>
</m:ContentPage>
