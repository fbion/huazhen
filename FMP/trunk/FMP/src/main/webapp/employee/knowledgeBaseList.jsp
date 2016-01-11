
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3>
            <div class="wrappSearchContent">
                类型：<select id="byType"></select>
                标题：<input id="byTitle" />
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <p class="mt50">
            <s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if></p>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
       <input style="display: none" type="text" id="userId" value="<s:property value="userId"/>"/>
        ${pageVar}
    </m:Content>
</m:ContentPage>


<%--<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<%--<%@ taglib prefix="m" uri="/hz-tags" %>--%>

<%--<m:ContentPage materPageId="layout">--%>
    <%--<m:Content contentPlaceHolderId="center">--%>
        <%--<div class="wrappSearch mt30" >--%>
            <%--<h3></h3>--%>
            <%--<div class="wrappSearchContent">--%>
            <%--<input type="hidden" value="${byType}" id="byType"/>--%>
				<%--知识类型：<select id="type" name="type" ></select>--%>
                <%--关键字：<input id="key" value="${key}">--%>
                <%--<input id="btnSearch" type="button"  value="查询" class="btn_style"/>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%----%>
        <%--<ul class="konwledgeBase">--%>
        	<%--<p class="mt50 pl20 viewDetails" align="center"> --%>
                <%--<s:if test="showAddButton">--%>
                    <%--<input type="button" id="btnAdd" value="发布知识" class="btn_style"/>--%>
                <%--</s:if>--%>
            <%--</p>--%>
            <%--<s:iterator value="#request.knowledgeBasePagedList.resultList" id="item" >--%>
                <%--<li class="tab_content1 tabContent" style="display: block;">--%>
                    <%--<div class="recruitInfo">--%>
                        <%--<p class="mt10">--%>
                            <%--<span class="recruitTit">类别：</span><em id="typeName" class="mr30"><s:property value="#item.typeName"/></em>--%>
                            <%--<span class="recruitTit">发布时间：</span><strong class="mr30"><s:date name="#item.inTime" format="yyyy-MM-dd HH:mm:ss" /></strong>--%>
                            <%--<span class="recruitTit">发布人：</span><em class="mr30"><s:property value="#item.inUserName"/></em>--%>
                        <%--</p>--%>
                         <%--<p class="mt10">--%>
                             <%--<span class="recruitTit">标题：</span>--%>
                             <%--<s:property value="#item.title" /> --%>
                         <%--</p>--%>
                         <%--<div class="recruitConts mt10">--%>
                              <%--<span class="mt20 recruitTitle">正文：</span>--%>
                              <%--<div class="recruitContent"><s:property value="#item.content" escapeHtml="false" /></div>--%>
                         <%--</div>--%>
                        <%----%>
                        <%--<p class="viewDetails mt20">--%>
                        <%--<s:if test="showAddButton">--%>
                           <%--<s:if test="#item.userNo==#item.inUserNo">--%>
                            <%--<a href="${knowledgeBaseDetailUrl}<s:property value='#item.id'/>">查看修改>></a>--%>
                           <%--</s:if>--%>
                            <%--<s:else>--%>
                        	<%--<a target="_blank" href="${knowledgeBaseInfoUrl}<s:property value='#item.id'/>">查看详情>></a>--%>
                        <%--</s:else>--%>
                        <%--</s:if>--%>
                        <%--<s:else>--%>
                        	<%--<a href="${knowledgeBaseInfoUrl}<s:property value='#item.id'/>">查看详情>></a>--%>
                        <%--</s:else>--%>
                        <%--</p>--%>
                    <%--</div>--%>
                <%--</li>--%>
            <%--</s:iterator>--%>
        <%--</ul>--%>
        <%--<!-- 页码 -->--%>
        <%--<div class="productList_page mt50">--%>
            <%--<div class="myInvestment_page">--%>
                <%--共<span class="pl5 pr5" id="totalCount">${totalCount}</span>条记录--%>
                <%--<div id="pagination"></div>--%>
                <%--<s:if test="pageIndex!=0">--%>
                    <%--第<span class="pl5 pr5">${pageIndex}</span>页&nbsp共<span class="pl5 pr5" >${pageCount}</span>页--%>
                <%--</s:if>--%>
                <%--<input type="hidden" id="pageIndex" value="${pageIndex}"/>--%>
                <%--<input type="hidden" id="pageUrl" value="${knowledgeBaseList}"/>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</m:Content>--%>
<%--</m:ContentPage>--%>
