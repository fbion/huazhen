<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">条件和奖励</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="activitiesAddDetail" style="z-index:9999;">
                                <ul>
    								<li>
                                    	<span><strong class="color fn">*</strong>条件规则：</span>
                                        <!-- <input type="text" class="data" id="conditionDescription" name="conditionDescription" disabled="disabled"/> -->
                                        
                                        <select class="data" id="conditionDescription" name="conditionDescription" disabled="disabled"></select>
                                    	 <select class="data" id="conditionRelation" name="conditionRelation" disabled="disabled"></select>
                                    </li>
                                </ul>
                                <ul class="ml100 pl30">
                                    <li class="ml15" id="investmentprojects" >
                                        <input type="text"  class="data" id="conditionValue" name="conditionValue" disabled="disabled"/>
                                        <div class="Validform_checktip"></div>
                                        <input type="text"  disabled="disabled" value="投资项目："/>
                                        <select class="data" id="productType" name="productType" disabled="disabled">
                                        </select>
                                        <select class="data" id="productName" name="productName" disabled="disabled">
                                        </select>
                                        <p class="pl30 mt10 ml10">
                                        <!-- <textarea cols="5" rows="2" class="ml100" ></textarea> -->
                                        </p>
                                    </li>
                                </ul>
                                <ul style="display: none;">
    								<li>
                                    	<span><strong class="color fn">*</strong>条件奖励：</span>
                                    </li>
                                </ul>
								<div class="addRule" style="display: none;">
                                	<div id="addRuleCont1" class="addRule_cont">
                                    	<p>
                                            <select class="w100 activityRewardType" class="data">
                                                <option value="0">体验金</option>
                                                <option value="1">现金</option>
                                                <option value="2">优惠券</option>
                                                <option value="3">积分</option>
                                                <option value="4">礼品</option>
                                            </select>
                                            <i class="icon2 addDeleteIron"></i>
                                        </p>
                                    	<div class="rewardTypeDiv rewardTypeDiv1"><input type="text"  class="data"/><span>元，</span><span>投资项目规则以投资项目条件为准，项目到期后利息可提现。</span></div>
                                    	<div class="rewardTypeDiv rewardTypeDiv2"><span>面值：</span><input type="text" class="w50 ml10 data" /><span>元</span><span class="ml20">限制张数<=</span><input type="text" class="w50 data" />
                                        张<%-- <span class="ml20">使用规则：</span>
                                        <select class="data">
                                        	<option value="不限">不限</option>
                                            <option value="现房宝">现房宝</option>
                                            <option value="信托">信托</option>
                                            <option value="资管">资管</option>
                                        </select>
                                        <select class="data">
                                        	<option value="现房宝1号">现房宝1号</option>
                                            <option value="现房宝2号">现房宝2号</option>
                                            <option value="现房宝3号">现房宝3号</option>
                                        </select> --%>
                                        <span class="ml20">有效期：</span>
                                        <select class="data">
                                        	<option value="不限">不限</option>
                                        </select>
                                        <select class="data">
                                        	<option value="a"></option>
                                            <option value="v"></option>
                                            <option value="c"></option>
                                        </select></div>
                                    	<div class="rewardTypeDiv rewardTypeDiv3"><span>每人个数：</span><input type="text" class="w50 ml10 data" /><span class="ml20">限制积分<=</span><input type="text" class="w50 data" />个
                                        <span class="ml20">有效期：</span>
                                        <select  class="data">
                                        	<option value="不限">不限</option>
                                        </select>
                                        <select class="data">
                                        	<option value=""></option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select></div>
                                    	<div class="rewardTypeDiv rewardTypeDiv4"><span>礼品名称：</span><input type="text" class="w50 ml10 data" /><span>个</span><span class="ml20">礼品总数<=</span><input type="text" class="w50 data" />个
                                        <span class="ml20">领取规则：</span>
                                        <select  class="data">
                                        	<option value="2015-10-12">2015-10-12</option>
                                            <option value="2015-11-12">2015-11-12</option>
                                            <option value="2015-12-12">2015-12-12</option>
                                        </select>
                                        <span>完善收货地址，7日内为您发货，未收到货请联系客服。</span></div>
                                	</div>
                                </div> 
                              
                               
                                <p id="btn" class="mt20">
                                    <em id="msg"></em>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style"/>                                        
                                    </s:if>
                                    <s:if test="showSubmitButton">
                                        <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="btn_style"/>
                                </p>
                                
                                <!-- 条件规则：
                               <table id="rowed4"></table> 
                               <div id="prowed4" style="display: none;"></div> -->
                               <div class="ml50 pl20">条件奖励：</div>
							   <table id="rowed3"></table> 
                               <div id="prowed3" style="display: none;"></div>
                            </form>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>