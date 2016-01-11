<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutAboutUsCenter">
	<m:Content contentPlaceHolderId="aboutUsNavigation">旗下门店</m:Content>
	<m:Content contentPlaceHolderId="helpCenterBanner" >
	<div class="ad p2pBanner1 cor2" value="1"></div>
	</m:Content>
    <m:Content contentPlaceHolderId="helpCenter">
    	<div class="aboutUs_cont" >
	        <h4>
	            <span>STORE</span>
	            <em>旗下门店</em>
	        </h4>
	        <s:if test="departmentList!=null and departmentList.size>0">
            	<ul id="allStoreList">
	        	<s:iterator value="departmentList" var="department">
	        		<li>
		                <a class="store" href="javascript:void(0)" value="${department.id}"><!-- <i></i> --><em>【${department.name}】</em></a>
		                <%-- <span><s:date name="#announcement.startTime" format="yyyy-MM-dd"/> </span> --%>
		                <p>${department.address}</p>
		            </li>
	        	</s:iterator>
                </ul>
	        </s:if>
	        <s:else>
	        	暂无门店
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
    	<!-- <div class="aboutUs_cont" id="storeCont" style="display: none"></div> -->
    	<input type="hidden" id="pageAlias" value="${pageAlias}" class="pageAlias">
    	<input type="hidden" id="id" value="${id}">
	</m:Content>
</m:ContentPage>