<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutAboutUsCenter">
	<m:Content contentPlaceHolderId="aboutUsNavigation">网站公告</m:Content>
	<m:Content contentPlaceHolderId="helpCenterBanner" >
	<div class="ad p2pBanner1 cor2" value="1"></div>
	</m:Content>
    <m:Content contentPlaceHolderId="helpCenter">
    	<div class="aboutUs_cont" id="bulletinList">
	        <h4>
	            <span>BULLETIN</span>
	            <em>网站公告</em>
	        </h4>
	        <s:if test="announcementList!=null and announcementList.size>0">
            	<ul>
	        	<s:iterator value="announcementList" var="announcement">
	        		<li>
		                <a href="javascript:void(0)" value="${announcement.id}"><i></i><em>【${announcement.typeValue}】</em>${announcement.subject}</a>
		                <span><s:date name="#announcement.startTime" format="yyyy-MM-dd"/> </span>
		            </li>
	        	</s:iterator>
                </ul>
	        </s:if>
	        <s:else>
	        	暂无公告
	        </s:else>
	        <!-- 页码 -->
			<div class="productList_page mt30 pb30">
				<div class="myInvestment_page">
					<div id="pagination"></div>
					<s:if test="pageIndex!=0">
						第<span class="pl5 pr5">${pageIndex}</span>页&nbsp;
						共<span class="pl5 pr5" >${pageCount}</span>页
					</s:if>
					共<span class="pl5 pr5" id="totalCount">${totalCount}</span>条记录
					<input type="hidden" id="pageIndex" value="${pageIndex}"/>
					<input type="hidden" id="pageUrl" value="${pageUrl}"/>
				</div>
			</div>
    	</div>
    	<div class="aboutUs_cont" id="bulletinCont" style="display: none"></div>
    	<input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
    	<input type="hidden" id="id" value="${id}">
	</m:Content>
</m:ContentPage>