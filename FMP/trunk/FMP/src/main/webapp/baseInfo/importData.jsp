<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
       <div class="importData mt10">
           选择类型：<select type="text" id="table" class="w100" ></select>
            <div class="dil">
                <span class="span1"></span>
                <%--<a id="aEmpHead">--%>
                    <%--<img alt="员工头像" id="emphead" class="ml20 emphead" src="" height="100" width="100">--%>
                <%--</a>--%>
                <input type="hidden" id="portraitPath" name="portraitPath" />
                <div class="upload uploadW"></div>
            </div>
            <input type="button" id="import" name="" src="" value="导入" class="btn_style mt10"/>
       </div>
    </m:Content>
</m:ContentPage>
