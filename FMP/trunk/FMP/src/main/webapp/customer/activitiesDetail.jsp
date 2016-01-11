<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">发布活动</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="activitiesDetail" style="z-index:9999;">
                                <ol>
    								<li>
                                    	<span><strong class="color fn">*</strong>条件规则：</span>
                                        <em>插入</em>
                                        <select>
                                        	<option></option>
                                            <option></option>
                                        </select>
                                        <em>插入文本框</em>
                                        <input type="text" />
                                        <em>插入符号</em>
                                        <select>
                                        	<option>>=</option>
                                            <option>></option>
                                            <option><</option>
                                            <option><=</option>
                                            <option>=</option>
                                        </select>
                                        <p class="pl30 mt10 ml10">
                                        <textarea cols="5" rows="2" class="ml100" ></textarea>
                                        </p>
                                    </li>
                                </ol>
                                <ul>
    								<li>
                                    	<span><strong class="color fn">*</strong>条件奖励：</span>
                                    </li>
                                </ul>
								<div class="addRule">
                                	<div class="addRule_cont">
                                    	<p>
                                            <select class="w100">
                                                <option>体验金</option>
                                                <option>现金</option>
                                                <option>优惠券</option>
                                                <option>积分</option>
                                                <option>礼品</option>
                                            </select>
                                            <i class="icon1"></i>
                                        </p>
                                    	<input type="text" /><span>元，</span><span>投资项目规则以投资项目条件为准，项目到期后利息可提现。</span>
                                	</div>
                                    <div class="addRule_cont">
                                    	<p>
                                            <select class="w100">
                                                <option>体验金</option>
                                                <option>现金</option>
                                                <option selected="selected" >优惠券</option>
                                                <option>积分</option>
                                                <option>礼品</option>
                                            </select>
                                            <i class="icon1"></i>
                                        </p>
                                    	<span>面值：</span><input type="text" class="w50 ml10" /><span>元</span><span class="ml20">限制张数<=</span><input type="text" class="w50" />
                                        张<span class="ml20">使用规则：</span>
                                        <select>
                                        	<option value="不限">不限</option>
                                            <option value="现房宝">现房宝</option>
                                            <option value="信托">信托</option>
                                            <option value="资管">资管</option>
                                        </select>
                                        <select>
                                        	<option value="现房宝1号">现房宝1号</option>
                                            <option value="现房宝2号">现房宝2号</option>
                                            <option value="现房宝3号">现房宝3号</option>
                                        </select>
                                        <span class="ml20">有效期：</span>
                                        <select>
                                        	<option value="不限">不限</option>
                                        </select>
                                        <select>
                                        	<option value=""></option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                	</div>
                                    
                                    <div class="addRule_cont">
                                    	<p>
                                            <select class="w100">
                                                <option>体验金</option>
                                                <option>现金</option>
                                                <option>优惠券</option>
                                                <option selected="selected">积分</option>
                                                <option>礼品</option>
                                            </select>
                                            <i class="icon1"></i>
                                        </p>
                                    	<span>每人个数：</span><input type="text" class="w50 ml10" /><span class="ml20">限制积分<=</span><input type="text" class="w50" />个
                                        <span class="ml20">有效期：</span>
                                        <select>
                                        	<option value="不限">不限</option>
                                        </select>
                                        <select>
                                        	<option value=""></option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                	</div>
                                    <div class="addRule_cont">
                                    	<p>
                                            <select class="w100">
                                                <option>体验金</option>
                                                <option>现金</option>
                                                <option>优惠券</option>
                                                <option>积分</option>
                                                <option selected="selected">礼品</option>
                                            </select>
                                            <i class="icon2"></i>
                                        </p>
                                    	<span>礼品名称：</span><input type="text" class="w50 ml10" /><span>个</span><span class="ml20">礼品总数<=</span><input type="text" class="w50" />个
                                        <span class="ml20">领取规则：</span>
                                        <select>
                                        	<option value="2015-10-12">2015-10-12</option>
                                            <option value="2015-11-12">2015-11-12</option>
                                            <option value="2015-12-12">2015-12-12</option>
                                        </select>
                                        <span>完善收货地址，7日内为您发货，未收到货请联系客服。</span>
                                	</div>
                                    
                                </div>

                                <p id="btn">
                                    <em id="msg"></em>
                                    <input type="button" value="确定" class="btn_style"/>
                                </p>
                            </form>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>