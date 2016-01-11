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
                            <form id="activitiesAdd" style="z-index:9999;">
                            <ul>
                                    <li>
										<span><strong class="color fn">*</strong>活动类型：</span> 
										<select class="ml20  data" id="activityType"  disabled="disabled">
                                        </select>                                        
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
										<span><strong class="color fn">*</strong>活动名称：</span> 
										<input id="activityName" name="activityName" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
								<ol>
                                    <li>
										<span><strong class="color fn">*</strong>活动规则：</span> 
                                        <textarea cols="5" rows="2" class="ml20 data" id="activityRule" disabled="disabled"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
								<ul>
                                    <li>
										<span><strong class="color fn">*</strong>活动条件：</span> 
                                        <input type="button" id="addCondition" value="添加规则" class="btn_style ml20  data" />
                                    </li>
                                </ul>
                                <div class="rule ml100 mt10" style="display: none;">
                                	<p class="pl60">
                                    	<i class="icon1"></i>
                                        <i class="icon2"></i>
                                        <span class="fw ml10 mr10">条件</span>
                                        <em>投资项目：</em>
                                        <select>
                                        	<option value="不限">不限</option>
                                            <option value="P2P">P2P</option>
                                            <option value="信托">信托</option>
                                            <option value="资管">资管</option>
                                        </select>
                                        <select>
                                        	<option value="现房宝1号">现房宝1号</option>
                                            <option value="现房宝2号">现房宝2号</option>
                                            <option value="现房宝3号">现房宝3号</option>
                                        </select>
                                    </p>
                                    <p class="pl60">
                                    	<i class="icon1"></i>
                                        <i class="icon2"></i>
                                        <span class="fw ml10 mr10">奖励</span>
                                        <input type="text" /><span>元，投资项目规则以投资项目条件为准，项目到期后利息可提现。</span>
                                    </p>
                                    <p class="pl60">
                                    	<i class="icon1"></i>
                                        <i class="icon2"></i>
                                        <span class="fw ml10 mr10">条件</span>
                                        <span>除体验金、优惠券外，单笔投资金额>=</span><input type="text" /><span>元</span>
                                    </p>
                                    <p class="pl60">
                                    	<i class="icon1"></i>
                                        <i class="icon2"></i>
                                        <span class="fw ml10 mr10">奖励</span>
                                        <span class="mr10">面值</span><input type="text" class="w50 mr20" /><span>限制张数<=</span><input type="text" class="w50" />
                                        <em class="ml20">使用规则：</em>
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
                                        <em class="ml20">有效期：</em>
                                        <select>
                                        	<option value="不限">不限</option>
                                        </select>
                                        <select>
                                        	<option value=""></option>
                                            <option value=""></option>
                                            <option value=""></option>
                                        </select>
                                    </p>
                                    <p class="pl60">
                                    	<i class="icon1"></i>
                                        <i class="icon2"></i>
                                        <span class="fw ml10 mr10">条件</span>
                                        <span>每月反馈次数<=</span><input type="text" class="w50" /><span>次</span>
                                    </p>
                                </div>
                                <div id="contentDiv"  class="rule ml100 mt10 pl60" >
                                    	
                                </div>
								<ul class="mt20">
                                    <li>
										<span><strong class="color fn">*</strong>新手专区显示：</span>
										<select class="ml20  data" id="isDisplay"  disabled="disabled">
                                        </select>
                                    </li>
                                </ul>
                                <ul style = "display: none;">
                                    <li>
										<span><strong class="color fn">*</strong>是否测试：</span>
										<select class="ml20  data" id="isTest"  disabled="disabled">
                                        	<option value="1">是</option>
                                            <option value="0">否</option>
                                        </select>
                                    </li>
                                </ul>
								<ol>
                                    <li>
										<span><strong class="color fn">*</strong>活动有效期：</span>
										<input id="radioDate1" name="radioDate" type="radio" class="ml20  data"  disabled="disabled"/>不限
                                        <input id="radioDate2" name="radioDate" type="radio" class="ml20  data" checked="checked"  disabled="disabled"/>有效期
                                        <p class="mt10 ml100 pl60">
                                        	<input id="startTime" type="text" id="startTime" class="data" disabled="disabled"/>时--
                                            <input id="endTime" type="text" id="endTime" class="data" disabled="disabled"/>时
                                        </p>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>

                                <p id="btn">
                                    <em id="msg"></em>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style"/>   
                                       	<input type="button" id="publish" value="发布" class="btn_style"/>                                     
                                    </s:if>
                                    <s:if test="showSubmitButton">
                                        <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="btn_style"/>
                                </p>
                            </form>
                            	打款状态：
                            <select class="ml20  data" id="byIsPayment">
                                        	<option value="0">未打款</option>
                                            <option value="2">打款中</option>
                                            <option value="3">已打款</option>
                                            <option value="4">打款取消</option>
                            </select>
                            	打款奖励类型：
                            <select class="ml20  data" id="byIsType">
                            				<option value="0">全部</option>
                                        	<option value="1">体验金</option>
                                        	<option value="2">现金</option>
                            </select>
                            <input id="btnSearch" type="button" value="查询" class="btn_style ml20"/>
                            <div class="pic mt20 pl20">
            					<table id="gridTable" class="gridTable">
            					</table>
            					<div id="gridPager" class="gridPager">
            					</div>
        					</div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>