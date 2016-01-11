<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">还款管理</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="paymentRefundAdd" style="z-index:9999;">
                                <ul>
                                    <li>
                                        <span>p2p产品</span>
                                        <input id="p2pProductName" name="p2pProductName" type="text" disabled="disabled"
                                               class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>客户</span>
                                        <input id="customerName" name="customerName" type="text"
                                               disabled="disabled" class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>付款人</span>
                                        <input id="payerName" name="payerName" type="text" disabled="disabled"
                                               class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>投资金额</span>
                                        <input id="salesMoney" name="salesMoney" type="text" disabled="disabled"
                                               class="ml20 data"/>&nbsp;元

                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>利息</span>
                                        <input id="interest" name="interest" type="text" disabled="disabled"
                                               class="ml20 data"/>&nbsp;元

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>还款金额</span>
                                        <input id="payMoney" name="payMoney" type="text" disabled="disabled"
                                               class="ml20 data"/>&nbsp;元

                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>手续费</span>
                                        <input id="serviceCharge" name="serviceCharge" type="text" disabled="disabled"
                                               class="ml20 data"/>&nbsp;元

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>还款日期</span>
                                        <input id="payStartTime" name="payStartTime" type="text" disabled="disabled"
                                               class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>还款截止日期</span>
                                        <input id="payEndTime" name="payEndTime" type="text" disabled="disabled"
                                               class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>还款状态</span>
                                        <select id="status" name="status" disabled="disabled" class="ml20 data"></select>

                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>产品类型</span>
                                        <select id="productType" name="productType" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>支付类型</span>
                                        <select id="payType" name="payType" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>实际还款时间</span>
                                        <input id="actualPayTime" name="actualPayTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <p id="btn">
                                    <em id="msg"></em>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <s:if test="showSubmitButton">
                                        <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <s:if test="showPaymentCkButton">
                                        <input type="button" id="paymentCheck" value="审核通过" class="submit_Btn none btn_style"/>
                                        <input type="button" id="paymentCancelRefund" value="审核失败" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <s:if test="showPaymentRefundButton">
                                        <input type="button" id="paymentRefund" value="还款" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
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