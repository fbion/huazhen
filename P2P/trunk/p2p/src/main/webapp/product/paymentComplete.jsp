   <%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
    <div class="main wrapp pb30">
	    <h3 class="contCrumbs wrapp">
	    	<a href="${homeUrl}">首页</a>><a href="${productDetailsUrl}?p2pProductId=${p2pProductNo}">产品详情</a>>订单确认
	    </h3>
    <div class="orderConfirm wrapp">
    	<h4>订单确认 <i></i><span>您的睿智选择一定会带来回报</span></h4>
        
        <em class="orderStep4 mt50"></em>
        <ul>
            <li class="confirmInfo red">确认信息</li>
            <li class="red">确认合同</li>
            <li class="confirmPay red">确认支付</li>
            <li class="paySuccess red">支付成功</li>
        </ul>
        <dl class="paySuccessInfo mt50">
        	<dt></dt>
            <dd class="ml20">
            	<h5>投资申请已提交！</h5>
                <p>您申请投资的金额已经被暂时冻结，通过后将进行计息 </p><p>如果投资失败，该笔资金将返还到您的华镇金融账户</p>
                <p class="mt10">您稍后可以通过查看<a href="${investmentUrl}" class="ml5 mr5">我的投资</a>|<a href="${accountUrl}" class="ml5 mr5">我的账户</a>是否投资成功</p>
            </dd>
        </dl>
    </div>
       <%--  <div class="content container border-line">
            <div class="row pb50 pt50">
                <div class="col-md-12 text-center confirmInfo">
                    <div class="confirmStep">
                        <ul>
                            <li>确认信息</li>
                            <li>确认合同</li>
                            <li>支付确认</li>
                            <li class="noMargin active">完成</li>
                        </ul>
                        <p class="step4 mt30"></p>
                    </div>
                    <p class="tips mt50">投资申请已提交</p>
                    <p class="tipsInfo mt30 pb30">
                        <span>您申请投资的金额已冻结，通过后将进行计息</span>
                        <span>如果投资失败，该笔资金将返还到您的华镇金融账户</span>
                    </p>
                    <a href="${accountUrl}" class="checkAcount mr20">查看我的账户</a>|<a href="${p2pProductListUrl}" class="viewItem ml20">浏览投资项目</a>
                </div>
            </div>--%>
        </div> 
    </m:Content>
</m:ContentPage>