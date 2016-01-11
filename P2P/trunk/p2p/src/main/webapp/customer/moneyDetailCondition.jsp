<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="profitCont">  
	<s:if test="displayType==1">
		<div class="profitTotal">
		    <span>收益总计：</span>
		    <em class="f20">￥${income}</em>
		</div>
	</s:if>
	<s:if test="displayType==2">
		<div class="profitTotal">
		    <span>待收收益总计：</span>
		    <em class="f20">￥${unIncome}</em>
		</div>	
	</s:if>
	<s:if test="displayType==3"> 
		<div class="profitTotal">
	        <span>待收本金总计：</span>
	        <em class="f20">￥${principal}</em>
	    </div>
	</s:if>
	<div class="investSelect">
	    <dl class="borderBott1">
	        <dt>产品类型:</dt>
	        <dd id="productType">
	            <a href="javascript:void(0)" class="active">全部</a>
	            <s:iterator value="#request.productTypeList" id="item">
	            <a href="javascript:void(0)"  value="<s:property value="#item.code"/>"><s:property value="#item.value"/></a>
	            </s:iterator>
	        </dd>
	    </dl>
	    <%-- <dl>
	        <dt>产品名称:</dt>
	        <dd id="p2pProductNo">
	            <a href="javascript:void(0)" class="active" value="0">全部</a>
	          	 <s:if test="p2pProductList!=null">
	          		<s:iterator value="p2pProductList" var="p2pProduct">
	          			<a href="javascript:void(0)" value="${p2pProduct.id}">${p2pProduct.name}</a>
	          		</s:iterator>
	          	 </s:if>
	          	 <s:if test="productList!=null">
	          		<s:iterator value="productList" var="product">
	          			<a href="javascript:void(0)" value="${product.id}">${product.name}</a>
	          		</s:iterator>
	          	 </s:if>
	        </dd>
	    </dl> --%>
	    <dl>
	        <dt>收益时间:</dt>
	        <dd>
	           <input type="text" class="mr5 laydate-icon-dahong" id="startTime" value="${startTime}"/>—<input type="text" class="ml5 mr30 laydate-icon-dahong" id="endTime" value="${endTime}"/>
	           <input id="seach" class="btnStyle" type="button" style="display:inline-block; width:80px;height:33px; text-align:center;" value="查询">
	           <%-- <span>最近六个月</span> --%>
	        </dd>
	    </dl>
	</div>
	<div id="moneyDetailInner"></div>
</div>