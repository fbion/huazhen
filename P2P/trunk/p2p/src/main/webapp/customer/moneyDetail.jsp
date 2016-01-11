<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layoutCustomerCenter">
	<m:Content contentPlaceHolderId="customerCenterNavigation">资产明细</m:Content>
    <m:Content contentPlaceHolderId="customerCenter">
    	<div class="accountCont">
    		<div class="tradeRecord">
            	<h3>
                	<em class="pl15">资产明细</em>
                	<i></i>
                </h3>
                <div class="fundDetails mt10">
                	<p>
                    	<span>账户总额：</span>
                        <em class="f20 ml15">￥${balance}</em>
                    </p>
                    <ul class="fundInfo">
                    	<li>
                        	<span>冻结总额：</span>
                            <em class="em1">￥${freezeAmount}</em>
                            <span>可用余额：</span>
                            <em ><span id="formatMoney">￥${availableAmount}</span></em>
                        </li>
                        <li>
                        	<span>已收收益：</span>
                            <em class="em1">￥${income}</em>
                            <span>可提现金额：</span>
                            <em class="em1">￥${withdrawMoney}</em>
                            <a href="${paymentMoneyRechargeUrl}" class="btnStyle">充值</a>
                            <a href="${paymentMoneyWithdrawUrl}" class="">提现</a>
                        </li>
                        <li>
                        	<span>待收收益：</span>
                            <em class="em1">￥${unIncome}</em>
                            <span>待收本金：</span>
                            <em>￥${principal}</em>
                        </li>
                    </ul>
                </div>
                <div class="profitTitle tab_title mt40" id="displayType">
                	<a href="javascript:void(0)" name="moneyDetail"  class="active" value="1">已收收益</a>
                    <a href="javascript:void(0)" name="moneyDetail" value="2">待收收益</a>
                    <a href="javascript:void(0)" name="moneyDetail" value="3">待收本金</a>
                </div>
                <div class="profitCont" id="moneyDetailCondiction"></div> 
     		</div>
     	</div>
     	<input id="pageAlias" type="hidden" value="${pageAlias}">
    </m:Content>
</m:ContentPage>