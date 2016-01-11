<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layoutCustomerCenter">
<m:Content contentPlaceHolderId="customerCenterNavigation">我的预约
		<!-- <h3 class="contCrumbs wrapp">
	    	<a href="index.html">首页</a>><a href="maAccount.html">我的账户</a>>我的预约
	    </h3> -->
	</m:Content>
	<m:Content contentPlaceHolderId="customerCenter">
       <div class="accountCont">
           <div class="tradeRecord">
           	<h3>
               	<em class="pl15">我的预约</em>
               	<i></i>
               </h3>
               <div class="reserSelect mt10">
               	<span class="mr5">预约产品</span>
                   <select id="reservationProductSelect">
                   </select>
                   <span class="mr5">预约时间</span>
                   <input type="text" id="reservationTime" class="laydate-icon-dahong"/>
                   <input id="seach" class="btnStyle ml30" type="button" style="display:inline-block; width:80px;height:33px; text-align:center;" value="查询">
               </div>
               <ul class="mt20" id="reservation">
               </ul>
           </div>
           <input type="hidden" id="pageAlias" value="${pageAlias}">
       </div>
	</m:Content>
</m:ContentPage>