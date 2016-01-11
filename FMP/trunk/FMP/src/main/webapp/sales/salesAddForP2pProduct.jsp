<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">打款基本信息</a><s:if test="showCommonView">
                    <a href="javascript:;">附件</a></s:if>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="salesAddForP2pProduct" style="z-index:9999;">
                                <ul>
                                    <li><span>订单编号</span> <input id="code" name="code" type="text" class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span>合同编号</span><input id="contractCode" type="text"
                                                                name="contractCode" class="ml20 data"/>（只填写后四位编号）
                                        <div class="Validform_checktip"></div>
                                    </li>


                                </ul>
                                <ul>
                                    <li><span>新金融产品</span> <select id="productNo"
                                                                name="productNo" class="ml20 data"></select></li>
                                    <li><span>销售经理</span>
                                        <input id="employeeSel" type="text" value="" class="ml20 data"/>
                                        <input type="text" id="empNo" value="" style="display: none"/>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span>到期日期</span>
                                        <input id="repaymentDate" name="repaymentDate" type="text" class="ml20 data">

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span>打款金额<em class='color'>*</em></span> <input id="money" type="text"
                                                                                         name="money"
                                                                                         class="ml20 data"/>元
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span>年化收益率</span>
                                        <input id="income" name="income" type="text" class="ml20 data">%
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span>购买日期<em class='color'>*</em></span> <input id="purchaseDate"
                                                                                         name="purchaseDate" type="text"
                                                                                         class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span>客户类型</span> <select id="customerType"
                                                                  name="customerType" class="ml20 data"></select></li>
                                    <li><span id="customer">客户</span>
                                        <select id="customerNo"  name="customerNo"class="ml20 data"></select>(只显示身份证填写完整的客户)
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span>销售类型</span> <select id="peopleType"
                                                                  name="peopleType" class="ml20 data"></select></li>
                                    <li><span>渠道</span> <select id="peopleNo"
                                                                name="peopleNo" class="ml20 data"></select></li>
                                </ul>

                                <ul>
                                    <li><span>打款状态</span> <select id="status" name="status"
                                                                  class="ml20 data"></select></li>

                                    <li><span>协议状态</span> <select id="protocolStatus"
                                                                  name="protocolStatus" class="ml20 data"></select></li>
                                </ul>

                                <ul>
                                    <li><span>开户行</span>
                                        <input id="bankAddress" name="bankAddress" type="text" class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span>开户名</span>
                                        <input id="bankName" name="bankName" type="text" class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span>银行账号</span>
                                        <input id="accountNumber" name="accountNumber" type="text" class="ml20 data">

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span>成立日期</span>
                                        <input id="establishDate" name="establishDate" type="text" class="ml20 data">

                                        <div class="Validform_checktip"></div>
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
                                        <span>备注</span>
                                        <textarea id="editComment" name="editComment" class="ml20 data"></textarea>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <ul>
                                    <li style="display: none">
                                        <span>payType</span>
                                        <input id="payType" name="payType" type="text" disabled="disabled"
                                               class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li style="display: none">
                                        <span>p2pCustomerNo</span>
                                        <input id="p2pCustomerNo" name="p2pCustomerNo" type="text" disabled="disabled"
                                               class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <p id="btn" class="mt50">
                                    <em id="msg"></em>
                                    <s:if test="showExamineButton">
                                        <input id="examine"  type="button" value="审批" class="submit_Btn btn_style"/>
                                    </s:if>
                                    <s:if test="showBuildButton">
                                        <input type="button" id="build" value="匹配债权"
                                               class="cancel_Btn btn_style"/>
                                    </s:if>
                                    <s:if test="showEditButton">
                                        <input type="button" id="abandoned" value="废弃" class="submit_Btn  none btn_style"/>
                                        <input type="button" id="submitExamine" value="提交审核" class="submit_Btn  none btn_style"/>
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style"/>
                                        <input type="submit" id="submit" value="保存"
                                               class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回"
                                           class="cancel_Btn btn_style"/>
                                </p>
                                <div id="w1" class="easyui-window" title="打款审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
                                    <div>
                                        <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
                                        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                                            <input id="submit1" name="submit" type="submit" value="下一步"class="submit_Btn  btn_style examine"/>
                                            <input id="submit2" name="" type="submit" value="驳回" class="submit_Btn  btn_style examine"/>
                                            <input id="cancelSales" name="cancleSales" type="submit" value="取消订单" class="submit_Btn  btn_style"/>
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
                                <div class="upload"></div>
                            </div>
                        </li>
                    </s:if>
                </ul>
            </div>
        </div>
        <div id="w" class="easyui-window" title="保存提醒" data-options="closed:true,iconCls:'icon-save'" style="width:580;height:600px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <ul class="pb30">
                        <li class="f16">合同编号：<span id="scode" class="f16 fw"></span></li>
                        <li class="f16">产品：<span id="sproductNo" class="f16 fw"></span></li>
                        <li class="f16">客户：<span id="scustomerNo" class="f16 fw"></span></li>
                        <li class="f16">打款金额：<span id="smoney" class="f16 fw"></span>元</li>
                        <li class="f16">购买日期：<span id="spurchaseDate" class="f16 fw"></span></li>
                        <li class="f16">年化收益率：<span id="sincome" class="f16 fw"></span>%</li>
                        <li class="f16">到期日期：<span id="srepaymentDate" class="f16 fw"></span></li>
                        <li>打款凭证<img alt="打款凭证" id="img" class="ml20 img" src="" height="300" width="200"></li>
                    </ul>
                    <p class="fw color f16 tr">请再次核对录入信息，保证数据正确性</p>

                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <span id="message" style="width:80px"></span>
                    <a class="easyui-linkbutton" id="ok"  style="width:80px">确定</a>
                    <a class="easyui-linkbutton"  href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px" id="close">关闭</a>
                </div>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>


