<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
	<div class="main wrapp pb30">
	    <h3 class="contCrumbs wrapp">
	    	<a href="${homeUrl}">首页</a>><a href="${productDetailsUrl}?p2pProductId=${p2pProductNo}">产品详情</a>>订单确认
	    </h3>
	       
	    <div class="orderConfirm wrapp">
	    	<h4>订单确认 <i></i><span>您的睿智选择一定会带来回报</span></h4>
	        
	        <em class="orderStep3 mt50"></em>
	        <ul>
	        	<li class="confirmInfo red">确认信息</li>
	            <li class="red">确认合同</li>
	            <li class="confirmPay red">确认支付</li>
	            <li class="paySuccess">支付成功</li>
	        </ul>
	       	<h5>项目信息</h5>
	        <ul class="itemInfo">
	        	<li class="hd borderBott">
	            	<span class="span1">项目名称</span>
	                <span class="span2">投资日期</span>
	                <span class="span3">年化收益</span>
	                <span class="span4">产品结束日期</span>
	                <span class="span5">投资金额</span>
	            </li>
	            <li class="bd">
	            	<span class="span1">${p2pProduct.name}</span>
	                <span class="span2">${investTime}</span>
	                <span class="span3"><em class="red">
	                	<s:property value="p2pProduct.income"/>%
                        <s:if test="p2pProduct.floatingIncome!=0">
                            +<s:property value="p2pProduct.floatingIncome"/>%
                        </s:if>
	                </em></span>
	                <span class="span4">${productEndTime}</span>
	                <span class="span5"><em class="red">${investmentMoney}</em>元</span>
	                <input type="text" id="investmentMoney" hidden="hidden" value="${investmentMoney}">
	            </li>
	        </ul>
	        <div class="useCoupons mt20 none" >
	        	<h6 class="borderBott">
	            	<i class="mr10"></i>使用优惠券抵扣<span>（该项目暂不支持优惠券抵扣）</span>
	            </h6>
	            <ul class="mt15">
	                <li class="hd borderBott">
	                    <span class="span1"></span>
	                    <span class="span2">面值</span>
	                    <span class="span3">编号</span>
	                    <span class="span4">有效期至</span>
	                </li>
	                <li class="bd borderBott">
	                    <span class="span1"><input type="checkbox" /></span>
	                    <span class="span2">100元</span>
	                    <span class="span3">40013</span>
	                    <span class="span4">2015-07-01</span>
	                </li>
	                <li class="bd">
	                    <span class="span1"><input type="checkbox" checked="checked" /></span>
	                    <span class="span2">100元</span>
	                    <span class="span3">40013</span>
	                    <span class="span4">2015-07-01</span>
	                </li>
	            </ul>
	        </div>
	        <div class="couponsInfo mt20 none">
	            <ul>
	            	<li class="ml200">
	                	<span>投资金额：</span><em>${investmentMoney}</em>元
	                </li>
	                <li>
	                	<span>使用优惠券抵扣：</span><em>0<!-- 50.00 --></em>元
	                </li>
	                <li>
	                	<span>实际应付：</span><em>${investmentMoney}<!-- 950.00 --></em>元
	                </li>
	            </ul>
	        </div>
	        <dl class="mt10">
	        	<dt></dt>
	            <dd>
                   <input type="text"  name="captcha" tabindex="5" class="captcha input" id="verifyCode" style="width:105px" />
                   <a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');">
                       <img width="108" height="28" ref1="${captchaUrl}?type=register" id="imgVerifyCode"
                            alt="请输入验证码" src="${captchaUrl}?type=register">
                   </a><a href="javascript:$VerifyCode.refreshValidator('#imgVerifyCode','#verifyCode');" class="validformRegister_tips">换一张</a>
               </dd>
               <dd>
	        <span id="message"  style="display:none;color:red">验证码输入错误</span>
               </dd>
	        </dl>
	        <p class="toTrade mt30">
	        	<input type="button" value="前往交易" id="next" class="next_step btnStyle orderNext mt30">
	        </p>
             <input type="text" id="investmentMoney" hidden="hidden" value="<s:property value="investmentMoney"/>">
             <input type="text" id="p2pProductNo"  hidden="hidden" value="<s:property value="p2pProductNo"/>">
             <input type="text" id="contractNo"  hidden="hidden" value="<s:property value="contractNo"/>">
	    </div>
	</div>
	</m:Content>
</m:ContentPage>
