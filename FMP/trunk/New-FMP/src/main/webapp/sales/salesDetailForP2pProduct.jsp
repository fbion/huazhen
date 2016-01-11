<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">

        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">打款基本信息</a><s:if test="showCommonView"><a
                        href="javascript:;">附件</a></s:if>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="salesAdd" style="z-index:9999;">
                                <ul>
                                    <li><span class="fw">订单编号</span><a id="code" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">合同编号</span><a id="contractCode" class="ml20"
                                                                       target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">产品</span><a id="productNo" class="ml20" target="_blank"></a>
                                    </li>
                                    <li><span class="fw">销售经理</span><a id="empNo" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">销售类型</span><a id="peopleType" class="ml20" target="_blank"></a>
                                    </li>
                                    <li><span class="fw" id="peopleNoa">渠道</span><a id="peopleNo" class="ml20"
                                                                                    target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">客户类型</span><a id="customerType" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">客户</span><a id="customerNo" class="ml20" target="_blank"></a>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="fw">打款状态</span><a id="status" class="ml20" target="_blank"></a>
                                    </li>
                                    <li><span class="fw">打款金额</span><a id="money" class="ml20" target="_blank"></a>元
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="fw">协议状态</span><a id="protocolStatus" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">购买日期</span><a id="purchaseDate" class="ml20"
                                                                       target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">开户行</span><a id="bankAddress" class="ml20" target="_blank"></a>
                                    </li>
                                    <li><span class="fw">开户名</span><a id="bankName" class="ml20" target="_blank"></a>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="fw">银行账号</span><a id="accountNumber" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">是否测试</span><a id="isTest" class="ml20" target="_blank"></a>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="fw">成立日期</span><a id="establishDate" class="ml20"
                                                                       target="_blank"></a></li>
                                    <li><span class="fw">到期日期</span><a id="repaymentDate" class="ml20"
                                                                       target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">年化收益率</span><a id="income" class="ml20"
                                                                       target="_blank"></a>%
                                    </li>
                                    <li><span class="fw">服务费率</span><a id="serviceRate" class="ml20"
                                                                       target="_blank"></a>%
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="fw">备注</span><a id="editComment" class="ml20"
                                                                        target="_blank"></a>
                                    </li>
                                </ul>
                                <ul>
                                    <li style="display: none"><span class="fw">payType</span><a id="payType"
                                                                                                class="ml20"
                                                                                                target="_blank"></a>
                                    </li>
                                    <li style="display: none"><span class="fw">p2p客户</span><a id="p2pCustomerNo"
                                                                                              class="ml20"
                                                                                              target="_blank"></a></li>
                                </ul>
                                <s:if test="showCreditor">
                                    <table id="dg" title="对应债权" class="easyui-datagrid "
                                           style="width:700px;height:250px" url="ajaxGetSalesCreditorBySaleNo.action?salesNo=${id}"
                                           toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true">
                                        <thead>
                                        <tr>
                                            <th field="creditorName" width="50">房屋</th>
                                            <th field="money" width="50">抵用金额</th>
                                        </tr>
                                        </thead>
                                    </table>
                                    <s:if test="showCreditorButton">
                                        <div id="toolbar">
                                            <a href="javascript:void(0)" class="easyui-linkbutton"
                                               iconCls="icon-add" plain="true" onclick="SalesDetailForP2pProduct.newUser()">添加债权</a>
                                            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove"
                                               plain="true" onclick="SalesDetailForP2pProduct.destroyUser()">删除债权</a>
                                        </div>
                                    </s:if>
                                    <div id="dlg" class="easyui-dialog"
                                         style="width:400px;height:280px;padding:10px 20px"
                                         closed="true" buttons="#dlg-buttons">
                                        <form id="fm" method="post" novalidate>
                                            <div class="fitem" style="height: 50px;margin-top: 20px"><label>房屋</label>
                                                <select class="creditor" id="creditorNo" name="creditorNo"></select>
                                            </div>
                                            <div class="fitem" style="height: 50px"><label>抵用金额</label>
                                                <input type="text" class="money data" id="money" name="money"/>
                                            </div>
                                        </form>
                                    </div>

                                    <div id="dlg-buttons">
                                        <a href="javascript:void(0)" class="easyui-linkbutton c6"
                                           iconCls="icon-ok" onclick="SalesDetailForP2pProduct.saveUser()"
                                           style="width:90px">保存
                                        </a>
                                        <a href="javascript:void(0)" class="easyui-linkbutton"
                                           iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
                                           style="width:90px">取消</a>
                                    </div>
                                </s:if>
                                <p id="btn" class="mt50">
                                    <em id="msg"></em>
                                    <s:if test="showExamineButton">
                                        <input id="examine" type="button" value="审批" class="submit_Btn btn_style"/>
                                    </s:if>
                                    <s:if test="showPaymentRefundButton">
                                        <input id="paymentRefund" type="button" value="生成还款" class="submit_Btn btn_style" />
                                    </s:if>
                                    <s:if test="showBuildButton">
                                        <input type="button" id="build" value="匹配债权" class="cancel_Btn btn_style"/>
                                        <input type="button" id="modifyIncome" value="修改利率" class="cancel_Btn btn_style"/>
                                        <input id="cancelSales" name="cancelSales" type="submit" value="取消订单" class="cancelSales submit_Btn  btn_style"/>

                                    </s:if>
                                    <s:if test="showRecoveryButton">
                                        <input id="recovery" type="button" value="恢复订单" class="submit_Btn none btn_style">
                                    </s:if>
                                    <s:if test="showConfirmButton">
                                        <input type="button" id="confirm" value="债权确认函"
                                               class="cancel_Btn btn_style"/>
                                        <input type="button" id="loanSituation" value="资金出借情况"
                                               class="cancel_Btn btn_style"/>
                                        <input type="button" id="collectionConfirm" value="收款确认书"
                                               class="cancel_Btn btn_style"/>
                                        <input type="button" id="repurchaseCommit" value="回购承诺函"
                                               class="cancel_Btn btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                </p>

								<div class="trackBtn"></div>
                                <div id="w1" class="easyui-window" title="打款审批"
                                     data-options="modal:true,closed:true,iconCls:'icon-save'"
                                     style="width:500px;height:200px;padding:10px;">
                                    <div>
                                        <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>

                                        <div data-options="region:'south',border:false"
                                             style="text-align:right;padding:5px 0 0;">
                                            <input id="submit1" name="submit" type="submit" value="下一步"
                                                   class="submit_Btn  btn_style examine"/>
                                            <input id="submit2" name="" type="submit" value="驳回"
                                                   class="submit_Btn  btn_style examine"/>
                                            <input id="cancelSales1" name="cancelSales" type="submit" value="取消订单"
                                                   class="cancelSales submit_Btn  btn_style"/>
                                        </div>
                                    </div>
                                </div>
                                <div id="income_dialog" class="easyui-window" title="修改打款年华利率" data-options="closed:true,iconCls:'icon-save'" style="width:400px;height:150px;padding:5px;">
                                    <div class="easyui-layout" data-options="fit:true">
                                        <div data-options="region:'center'" style="padding:10px;">
                                            修改后的利率：<input id="newIncome" type="text">%
                                        </div>
                                        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                                            <span id="message" style="width:80px"></span>
                                            <a class="easyui-linkbutton" id="ok"  style="width:80px">确定</a>
                                            <a class="easyui-linkbutton"  href="javascript:void(0)" onclick="$('#income_dialog').window('close')" style="width:80px" id="close">关闭</a>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div class="pic mt20 detail_pic">
                                <table id="salesExamineTable" class="gridTable"></table>
                            </div>
                        </div>
                    </li>
                    <s:if test="showCommonView">
                        <li class="tab_content2  tabContent">
                            <div class="details_Info_content p15 info_All" id="uploadDiv">
                            </div>
                        </li>
                    </s:if>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
