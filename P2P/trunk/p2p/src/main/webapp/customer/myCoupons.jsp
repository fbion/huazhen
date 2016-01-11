<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layoutCustomerCenter">
<m:Content contentPlaceHolderId="customerCenterNavigation">我的优惠券
	</m:Content>
<m:Content contentPlaceHolderId="customerCenter">
<div class="main wrapp pb30">	
        <div class="accountCont">
            <div class="tradeRecord">
            	<h3>
                	<em class="pl5">我的优惠券</em>
                	<i></i>
                </h3>
                <div class="couponsInfo mt10">
                    <ul>
                        <li class="ml40">
                        	<span>优惠券总张数：</span>
                            <em class="em1 f18">3</em>
                        </li>
                    	<li class="ml40">
                        	<span>优惠券总金额：</span>
                            <em class="f18 red">￥880.00</em>
                        </li>
                        <li class="ml40">
                        	<span>已使用优惠券：</span>
                            <em class="f18 red">￥80.00</em>
                        </li>
                    </ul>
                    <div class="exchangeCoupons">
                    	<h4>奖券兑换：</h4>
                        <input type="text" placeholder='输入奖券兑换码' />
                        <a href="#" class="receiveBtn btnStyle">立即领取</a>
                    </div>
                </div>
                
                <h3 class="mt40">
                	<em class="pl5">获取优惠券</em>
                	<i></i>
                </h3>
                <div class="getCoupons mt15">
                	<ul>
                    	<li>
                            <i class="icon1"></i>
                            <div class="getCoupons_cont ml15">
                                <h4>参与红包接力活动</h4>
                                <p>
                                    <a href="#" class="tit">邀请好友</a>
                                    <a href="javascript:;" class="ml10 ruleBtn">
                                        活动规则<i></i>
                                    </a>
                                </p>
                            </div>
                        </li>
                        <li class="ml10">
                            <i class="icon2"></i>
                            <div class="getCoupons_cont ml15">
                                <h4>积分兑换</h4>
                                <p>
                                    <a href="#" class="tit">积分兑换</a>
                                    <a href="javascript:;" class="ml10 ruleBtn">
                                        活动规则<i></i>
                                    </a>
                                </p>
                            </div>
                        </li>
                        <li class="ml10">
                            <i class="icon3"></i>
                            <div class="getCoupons_cont ml15">
                                <h4>向好友索要红包</h4>
                                <p>
                                    <a href="#" class="tit">索要红包</a>
                                  <a href="javascript:;" class="ml10 ruleBtn">
                                        活动规则<i></i>
                                    </a>
                                </p>
                            </div>
                        </li>
                    </ul> 
                    <div class="activeRule mt5">
                        <div class="actRule_cont actRule_cont1">
                            <div class="arrow-up arrow-up1"></div>
                            <p>开心红包接力：分享接力海报图，其他客户看到后可通过加油打气到52touzi网站（或微信），每一人成功注册奖励一元，每一人实名认证绑手机绑卡再累计一元，每一人单笔（在春节期间所有投资中的任意一笔）投资超过2万元以上（包括2万）奖励2元（有且只有一次），累计100元现金可取现，不够100元（或超过100元的剩余部分）并超过50元在活动规定时间内换取50元优惠券（可用于投资），否则逾期不予受理。</p>
                        </div>
                        <div class="actRule_cont actRule_cont2">
                            <div class="arrow-up arrow-up2"></div>
                            <p>邀请3名客户注册即可有1次抽奖机会，红包0元到10元不等，用户成功实名认证即可激活红包。</p>
                        </div>
                        <div class="actRule_cont actRule_cont3">
                            <div class="arrow-up arrow-up3"></div>
                            <p>分享接力海报图，其他客户看到后可通过加油打气到52touzi网站（或微信），每一人成功注册奖励一元，每一人实名认证绑手机绑卡再累计一元，每一人单笔（在春节期间所有投资中的任意一笔）投资超过2万。</p>
                        </div>
                    </div>
                </div>

                <div class="profitTitle tab_title mt40">
                	<a href="#" class="active">未使用</a>
                    <a href="#">已使用</a>
                    <a href="#">已失效</a>
                </div>
                
                <div class="profitCont">
                    <div class="tabContent" style="display:block;">
                        <ul class="mt20">
                            <li class="hd borderBott">
                                <span class="span9">编号</span>
                                <span class="span9">面值(元)</span>
                                <span class="span10">有效时间</span>
                                <span class="span7">来源</span>
                                <span class="span7">使用规则</span>
                                <span class="span8">发放日期</span>
                            </li>
                            <li class="bd borderBott">
                                <span class="span9">yhq001</span>                                
                                <span class="span9">50</span>
                                <span class="span10">2015-10-22至2015-11-22</span>
                                <span class="span7">推广用户注册获得</span>
                                <span class="span7">单笔投资抵扣现房宝1号</span>
                                <span class="span2">2015-07-01</span>
                            </li>
                            <li class="bd borderBott">
                                <span class="span9">yhq001</span>                                
                                <span class="span9">50</span>
                                <span class="span10">2015-10-22至2015-11-22</span>
                                <span class="span7">推广用户注册获得</span>
                                <span class="span7">单笔投资抵扣现房宝1号</span>
                                <span class="span2">2015-07-01</span>
                            </li>
                            <li class="bd">
                                <span class="span9">yhq001</span>                                
                                <span class="span9">50</span>
                                <span class="span10">2015-10-22至2015-11-22</span>
                                <span class="span7">推广用户注册获得</span>
                                <span class="span7">单笔投资抵扣现房宝1号</span>
                                <span class="span2">2015-07-01</span>
                            </li>
                        </ul>
                    </div>
                    
                    <div class="tabContent">
                        <ul class="mt20">
                            <li class="hd borderBott">
                                <span class="span9">编号</span>
                                <span class="span9">面值(元)</span>
                                <span class="span10">有效时间</span>
                                <span class="span7">来源</span>
                                <span class="span7">使用规则</span>
                                <span class="span8">发放日期</span>
                            </li>
                            <li class="bd borderBott">
                                <span class="span9">yhq001</span>                                
                                <span class="span9">50</span>
                                <span class="span10">2015-10-22至2015-11-22</span>
                                <span class="span7">推广用户注册获得</span>
                                <span class="span7">单笔投资抵扣现房宝1号</span>
                                <span class="span2">2015-07-01</span>
                            </li>
                            <li class="bd">
                                <span class="span9">yhq001</span>                                
                                <span class="span9">50</span>
                                <span class="span10">2015-10-22至2015-11-22</span>
                                <span class="span7">推广用户注册获得</span>
                                <span class="span7">单笔投资抵扣现房宝1号</span>
                                <span class="span2">2015-07-01</span>
                            </li>
                        </ul>
                    </div>
                   
                    <div class="tabContent">
                        <ul class="mt20">
                            <li class="hd borderBott">
                                <span class="span9">编号</span>
                                <span class="span9">面值(元)</span>
                                <span class="span10">有效时间</span>
                                <span class="span7">来源</span>
                                <span class="span7">使用规则</span>
                                <span class="span8">发放日期</span>
                            </li>
                            <li class="bd">
                                <span class="span9">yhq001</span>                                
                                <span class="span9">50</span>
                                <span class="span10">2015-10-22至2015-11-22</span>
                                <span class="span7">推广用户注册获得</span>
                                <span class="span7">单笔投资抵扣现房宝1号</span>
                                <span class="span2">2015-07-01</span>
                            </li>
                        </ul>
                    </div>
                </div>
                
            </div>
        </div>
    <input type="hidden" id="pageAlias" value="${pageAlias}">
</div>

    </m:Content>
</m:ContentPage>