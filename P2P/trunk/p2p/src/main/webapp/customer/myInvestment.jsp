<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
<m:Content contentPlaceHolderId="customerCenterNavigation">我的投资
		<!-- <h3 class="contCrumbs wrapp">
	    	<a href="index.html">首页</a>><a href="maAccount.html">我的账户</a>>我的投资
	    </h3> -->
	</m:Content>
    <m:Content contentPlaceHolderId="customerCenter">
		<div class="accountCont">
            <div class="tradeRecord">
            	<h3>
                	<em class="pl15">我的投资</em>
                	<i></i>
                </h3>
                <input type="hidden" id="hProductType" value="${productType}">
                <div class="investSelect mt10">
                	<dl class="borderBott1">
                    	<dt>产品类型</dt>
                        <dd id="productType">
                        	<a class="active" value="0">全部</a><%-- href="${productTypeUrl}"  --%>
                        	<s:if test="productTypeDicDataList!=null">
                        		<s:iterator value="productTypeDicDataList" var="productTypeD">
                        			<a style="cursor: pointer " value="${productTypeD.code}">${productTypeD.value}</a><%-- href="${productTypeUrl}?productType=${productTypeD.code}"  --%>
                        		</s:iterator>
                        	</s:if>
                            <!-- <a href="#" value="5">p2p</a>
                            <a href="#" value="1">信托</a>
                            <a href="#" value="2">资管</a>
                            <a href="#" value="3">基金</a> -->
                        </dd>
                    </dl>
                    <%-- <dl class="borderBott1">
                    	<dt>产品名称</dt>
                        <dd id="p2pProductNo">
                        	<a href="#" class="active" value="0">全部</a>
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
                            <!-- <a href="#" value="1">现房宝1号</a>
                            <a href="#" value="2">现房宝2号</a>
                            <a href="#" value="3">现房宝3号</a> -->
                        </dd>
                    </dl> --%>
                    <dl>
                    	<dt>交易状态</dt>
                        <dd id="statusStr">
                        	<a href="javascript:void(0)" class="active" value="">全部</a>
                            <a href="javascript:void(0)" value="10">付款中</a>
                            <a href="javascript:void(0)" value="1,2,8,9">待审核</a>
                            <!-- <a href="javascript:void(0)" value="3">认购成功</a> -->
                            <a href="javascript:void(0)" value="4,5,0">认购失败</a>
                            <a href="javascript:void(0)" value="3,6">还款中</a>
                            <a href="javascript:void(0)" value="7">已还款</a>
                        </dd>
                    </dl>
                </div>
                <ul class="mt20" id="investment">
                </ul>
            </div>
            <input type="hidden" id="pageAlias" value="${pageAlias}">
        </div>
    </m:Content>
</m:ContentPage>