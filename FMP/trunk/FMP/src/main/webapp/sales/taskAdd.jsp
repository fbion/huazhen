<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 15-1-26
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">销售任务</a><s:if test="showIncomeRateView"><a
                        href="javascript:void(0)">佣金费率</a></s:if><s:if test="showAgentRateView"><a
                        href="javascript:void(0)">成本费率</a></s:if><s:if test="showCommonView"><a
                        href="javascript:;">上线审核</a></s:if>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1 tabContent" style="display:block;">
                        <form id="taskAdd">
                            <div class="basic_Info_content p15 info_All">
                                <ul>
                                    <li>
                                        <span>产品</span>
                                        <select id="productNo" name="productNo" class="ml20 data">
                                        </select>
                                    </li>

                                    <li>
                                        <span>部门</span>
                                        <select id="deptNo" name="deptNo" class="ml20 data">
                                        </select>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>承销金额</span>
                                        <input id="taskAmout" name="taskAmout" type="text" class="ml20 data"/>&nbsp;元
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>销售周期</span>
                                        <input id="salesCycle" name="salesCycle" type="text" class="ml20 data"/>&nbsp;天
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>当前销售</span>
                                        <input id="currAmout" name="currAmout" type="text" class="ml20 data"/>&nbsp;元
                                    </li>
                                    <li>
                                        <span>领取状态</span>
                                        <select id="status" name="status" class="ml20 data">
                                        </select>
                                    </li>
                                </ul>
                                <ul>
                                	<li><span>是否测试</span>
                                        <select id="isTest" name="isTest" class="ml20 data">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ol>
                                    <li>
                                        <span>大小额配</span>
                                        <textarea id="quota" name="quota" class="ml20 data"></textarea>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <ol>
                                    <li>
                                        <span>激励政策和奖励方案</span>
                                        <textarea id="incentivePolicy" name="incentivePolicy"
                                                  class="ml20 data"></textarea>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <ol>
                                    <li>
                                        <span>销售策略</span>
                                        <textarea id="salesPolicy" name="salesPolicy" class="ml20 data"></textarea>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <p id="btn"><em id="msg"></em>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改" class="submit_Btn none btn_style"/>
                                        <input type="submit" id="submit" value="保存" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                </p>
                            </div>
                        </form>
                    </li>
                    <s:if test="showIncomeRateView">
                        <li class="tab_content2  tabContent">
                            <div class="details_Info_content p15 info_All">
                                <div class="pic mt20 detail_pic">
                                    <table id="incomeGridTable" class="gridTable">
                                    </table>
                                    <div id="incomeGridPager" class="gridPager"></div>
                                </div>
                            </div>
                        </li>
                    </s:if>
                    <s:if test="showAgentRateView">
                        <li class="tab_content3  tabContent">
                            <span id="message" style="color:red"></span>

                            <div class="details_Info_content p15 info_All">
                                <div class="pic mt20 detail_pic">
                                    <table id="expendGridTable" class="gridTable">
                                    </table>
                                    <div id="expendGridPager" class="gridPager"></div>
                                    <p class="mt50 pl20">
                                        <s:if test="showAgentRateAddButton">
                                            <input type="button" id="btnAgentRateAdd" value="添加"
                                                   class="btn_style"/>
                                        </s:if>
                                    </p>
                                </div>
                            </div>
                        </li>
                    </s:if>
                    <s:if test="showCommonView">
                        <li class="tab_content4 tabContent">
                            <div class="details_Info_content p15 info_All">
                                <div class="pic mt20 detail_pic">
                                    <table id="gridTable" class="gridTable">
                                    </table>
                                    <div id="gridPager" class="gridPager">
                                    </div>
                                </div>
                            </div>
                        </li>
                    </s:if>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>

