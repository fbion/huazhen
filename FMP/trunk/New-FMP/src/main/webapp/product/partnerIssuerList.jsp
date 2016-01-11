<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
			机构名称<input type="text" id="txtName"/>
			机构类型<select id="selectPartnerIssuertype"></select>                        
			关系等级<select id="selectRelationLevel"></select>
                              重要程度<select id="selectImportance"></select>             
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <s:if test="showAddButton">
        <p class="mt50"><input type="button" id="btnAdd" value="新建" class="btn_style"/></p>
        </s:if>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
