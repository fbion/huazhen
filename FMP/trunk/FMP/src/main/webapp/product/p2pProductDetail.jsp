<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">新金融产品</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="p2pProductDetail" style="z-index:9999;">
                                <ul>
                                    <li><span class="fw">产品</span><a id="productNo" name="productNo" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">产品名称</span><a id="name" name="name" class="ml20" target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">收益</span><a id="income" name="income" class="ml20" target="_blank"></a>%</li>
                                    <li><span class="fw">浮动收益</span><a id="floatingIncome" name="floatingIncome" class="ml20" target="_blank"></a>%</li>
                                </ul>

                                <ul>
                                    <li><span class="fw">总额度</span><a id="totalAmout" name="totalAmout" class="ml20" target="_blank"></a>元</li>
                                    <li><span class="fw">剩余额度</span><a id="remainAmout" name="remainAmout" class="ml20" target="_blank"></a>元</li>
                                </ul>
                                <ul>
                                    <li><span class="fw">优先级</span><a id="level" name="level" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">打款个数</span><a id="orderCount" name="orderCount" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">项目期限</span><a id="duration" name="duration" class="ml20" target="_blank"></a>天</li>
                                    <li><span class="fw">状态</span><a id="status" name="status" class="ml20" target="_blank"></a></li>

                                </ul>

                                <ul>
                                    <li><span class="fw">成立日期</span><a id="start" name="start" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">债权到期日</span><a id="end" name="end" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">起步价</span><a id="minMoney" name="minMoney" class="ml20" target="_blank"></a>元</li>
                                    <li><span class="fw">付息方式</span><a id="repaymentIssue" name="repaymentIssue" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">测试产品</span><a id="isTest" name="isTest" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ol>
                                    <li><span class="fw">产品描述</span><a id="description" name="description" class="ml20" target="_blank"></a></li>
                                </ol>
                                <ol>
                                    <li><span class="fw">产品合同</span><a id="contract" name="contract" class="ml20" target="_blank"></a></li>
                                 </ol>
                                <ol>
                                    <li><span class="fw">产品优势</span><a id="productAdvantage" name="productAdvantage" class="ml20" target="_blank"></a></li>
                                    </ol>

                                <p id="btn" class="mt20">
                                    <em id="msg"></em>
                                    <s:if test="showExamineButton">
                                        <input id="examine"  type="button" value="审批" class="examine submit_Btn btn_style"/>
                                    </s:if>
                                    <s:if test="showDurationButton">
                                        <input id="updateToDuration"  type="button" value="存续" class="submit_Btn btn_style"/>
                                    </s:if>
                                    <%--<s:if test="showCancelButton">
                                        <input id="cancel"  type="button" value="取消" class="submit_Btn btn_style"/>
                                    </s:if>--%>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                </p>
                                <div id="w1" class="easyui-window" title="新金融产品发布审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
                                    <div>
                                        <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
                                        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                                            <input id="submit1" name="submit" type="submit" value="下一步" oper="next"class="submit_Btn  btn_style audit"/>
                                            <input id="submit2" name="" type="submit" value="驳回" oper="back" class="submit_Btn  btn_style audit"/>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="trackBtn"></div>
                        <div class="pic mt20 detail_pic">
                            <table id="p2pProductExamineTable" class="gridTable">
                            </table>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>