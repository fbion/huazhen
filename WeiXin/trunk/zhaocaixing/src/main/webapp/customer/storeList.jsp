<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="mt20 contentmt">
			<div class="aboutUs_cont">
				<h4>
					<span>COMPANY</span> <a href="${productFeaturesUrl}?name=connection"><em>北京华镇股权投资基金管理有限公司</em></a>
					<span>STORE</span> <em>旗下门店</em>
				</h4>
				<s:if test="departmentList!=null and departmentList.size>0">
					<ul id="allStoreList">
						<s:iterator value="departmentList" var="department">
							<li><a class="store" href="javascript:void(0)"
								value="${department.id}"> <em>【${department.name}】</em>
							</a>
								<p>${department.address}</p></li>
						</s:iterator>
					</ul>
				</s:if>
				<s:else>
	        	暂无门店
	        </s:else>
		        <%-- <div class="productList_page mt30 pb30">
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
				</div> --%>
			</div>
		</div>
		<input type="hidden" id="pageAlias" value="${pageAlias}"
			class="pageAlias">
		<input type="hidden" id="id" value="${id}">
	</m:Content>
</m:ContentPage>
