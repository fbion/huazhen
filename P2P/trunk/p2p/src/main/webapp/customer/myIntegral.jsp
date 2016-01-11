<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layoutCustomerCenter">
<m:Content contentPlaceHolderId="customerCenterNavigation">我的积分 </m:Content>
<m:Content contentPlaceHolderId="customerCenter">
        <div class="accountCont">
            <div class="tradeRecord">
            	<h3>
                	<em class="pl15">我的积分</em>
                	<i></i>
                </h3>
                <div class="couponsInfo mt10 pb30">
                    <ul>
                    	<li class="ml40">
                        	<span>可用积分：</span>
                            <em class="f18 red">10000</em>
                        </li>
                        <li class="ml40">
                        	<span>已使用积分：</span>
                            <em class="f18 red ml10">1000</em>
                        </li>
                    </ul>
                    <div class="exchangeCoupons">
                    	<h4>积分兑换：</h4>
                        <input type="text" placeholder='输入流量，100积分=1KB ' />
                        <input type="text" placeholder='请输入需充值的手机号' class="mt10" />
                        <a href="#" class="receiveBtn btnStyle">立即领取</a>
                    </div>
                </div>
                
                <h3 class="mt40">
                	<em class="pl15">获取积分</em>
                	<i></i>
                </h3>
                <div class="getCoupons mt15">
                	<ul>
                    	<li>
                            <i class="icon4"></i>
                            <div class="getCoupons_cont ml15">
                                <h4>分享理财项目</h4>
                                <p>
                                    <a href="#" class="tit">马上分享</a>
                                    <a href="javascript:;" class="ml10 ruleBtn">
                                        活动规则<i></i>
                                    </a>
                                </p>
                            </div>
                        </li>
                        <li class="ml10">
                            <i class="icon5"></i>
                            <div class="getCoupons_cont ml15">
                                <h4>给网站提议</h4>
                                <p>
                                    <a href="#" class="tit">去提建议</a>
                                    <a href="javascript:;" class="ml10 ruleBtn">
                                        活动规则<i></i>
                                    </a>
                                </p>
                            </div>
                        </li>
                        <li class="ml10">
                            <i class="icon6"></i>
                            <div class="getCoupons_cont ml15">
                                <h4>兑换积分</h4>
                                <p>
                                    <a href="#" class="tit">兑换积分</a>
                                  <a href="javascript:;" class="ml10 ruleBtn">
                                        活动规则<i></i>
                                    </a>
                                </p>
                            </div>
                        </li>
                    </ul>
                    <div class="activeRule mt5">
                        <div class="actRule_cont actRule_cont1 tabContent">
                            <div class="arrow-up arrow-up1"></div>
                            <p>开心红包接力：分享接力海报图，其他客户看到后可通过加油打气到52touzi网站（或微信），每一人成功注册奖励一元，每一人实名认证绑手机绑卡再累计一元，每一人单笔（在春节期间所有投资中的任意一笔）投资超过2万元以上（包括2万）奖励2元（有且只有一次），累计100元现金可取现，不够100元（或超过100元的剩余部分）并超过50元在活动规定时间内换取50元优惠券（可用于投资），否则逾期不予受理。</p>
                        </div>
                        <div class="actRule_cont actRule_cont2 tabContent">
                            <div class="arrow-up arrow-up2"></div>
                            <p>给网站提意见或者建议，奖励10积分，每天累计积分不超过100积分。</p>
                        </div>
                        <div class="actRule_cont actRule_cont3 tabContent">
                            <div class="arrow-up arrow-up3"></div>
                            <p>分享接力海报图，其他客户看到后可通过加油打气到52touzi网站（或微信），每一人成功注册奖励一元，每一人实名认证绑手机绑卡再累计一元，每一人单笔（在春节期间所有投资中的任意一笔）投资超过2万。</p>
                        </div>
                    </div>
                </div>

				<h3 class="mt40">
                	<em class="pl5">兑换优惠券</em>
                	<i></i>
                </h3>
                <div class="mt30">
                	<ul>
                    	<li>
                        	<div class=""></div>
                            
                        </li>
                    </ul>
                </div>
                
                <div class="profitTitle tab_title mt40">
                	<a href="#" class="active">未使用</a>
                    <a href="#">已使用</a>
                </div>
                
                <div class="profitCont">
                    <div class="tabContent" style="display:block;">
                        <ul class="mt20">
                            <li class="hd borderBott">
                                <span class="span8">时间</span>
                                <span class="span3">来源</span>
                                <span class="span8">积分数量</span>
                                <span class="span11">来源详情备注</span>
                            </li>
                            <li class="bd borderBott">
                                <span class="span8">2015-10-20</span>                                
                                <span class="span3">认证获得</span>
                                <span class="span8">10</span>
                                <span class="span11">手机认证获得</span>
                            </li>
                            <li class="bd borderBott">
                                <span class="span8">2015-10-20</span>                                
                                <span class="span3">建议获得</span>
                                <span class="span8">20</span>
                                <span class="span11">成功给予网站建议获得</span>
                            </li>
                            <li class="bd">
                                <span class="span8">2015-10-20</span>                                
                                <span class="span3">分享获得</span>
                                <span class="span8">1000</span>
                                <span class="span11">通过新浪成功分享现房宝1号获得</span>
                            </li>
                        </ul>
                    </div>
                    
                    <div class="tabContent">
                        <ul class="mt20">
                            <li class="hd borderBott">
                                <span class="span8">时间</span>
                                <span class="span11">使用详情</span>
                                <span class="span8">积分数量</span>
                                <span class="span3">状态</span>
                            </li>
                            <li class="bd borderBott">
                                <span class="span8">2015-10-20</span>                                
                                <span class="span11">15701277633流量充值1KM</span>
                                <span class="span8">10</span>
                                <span class="span3">已成功</span>
                            </li>
                            <li class="bd">
                                <span class="span8">2015-10-20</span>                                
                                <span class="span11">兑换优惠券10元</span>
                                <span class="span8">10</span>
                                <span class="span3">进行中</span>
                            </li>
                        </ul>
                    </div>
                </div>
                
                <div class="warm ml50">
                	<h4 class="ml40 mt15">温馨提示</h4>
                    <p class="ml40">1. 邮箱认证<em class="ml10"></em>通过邮箱认证，即可一次性获得1000积分。</p>
                    <p class="ml40">2. 实名认证<em class="ml10"></em>通过实名认证，即可一次性获得1000积分。</p>
                    <p class="ml40">3. 手机认证<em class="ml10"></em>通过手机认证，即可一次性获得1000积分。</p>
                    <p class="ml40">4. 风险测评<em class="ml10"></em>完成风险测评，即可一次性获得1000积分。</p>
                </div>
            </div>
        </div>
    <input type="hidden" id="pageAlias" value="${pageAlias}">

    </m:Content>
</m:ContentPage>