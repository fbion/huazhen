<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">p2p充值记录</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="paymentMoneyRechargeAdd" style="z-index:9999;">
                                <ul>
                                    <li>
										<span>流水号</span> 
										<input id="sn" name="sn" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>账户编号</span> 
										<input id="accountNo" name="accountNo" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>客户编号</span> 
										<select id="customerNo" name="customerNo" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>账户号类型</span> 
										<input id="accountType" name="accountType" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>客户名</span> 
										<input id="customerName" name="customerName" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>充值类型</span> 
										<input id="rechargeType" name="rechargeType" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>支付方式</span> 
										<input id="bankType" name="bankType" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>充值金额（元）</span> 
										<input id="amount" name="amount" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>备注</span> 
										<input id="note" name="note" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>状态</span> 
										<select id="state" name="state" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>返回码</span> 
										<input id="resultCode" name="resultCode" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>返回说明</span> 
										<input id="resultNote" name="resultNote" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>创建时间</span> 
										<input id="timeCreate" name="timeCreate" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>第三方支付平台回执更新时间</span> 
										<input id="bankTime" name="bankTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>平台编号</span> 
										<input id="channelNo" name="channelNo" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>监管批次</span> 
										<input id="monitorBatched" name="monitorBatched" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>对账状态</span> 
										<input id="checkState" name="checkState" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>会计日期</span> 
										<input id="dateWork" name="dateWork" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>结算日期</span> 
										<input id="dateSettle" name="dateSettle" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>渠道结算日期</span> 
										<input id="checkDate" name="checkDate" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>手续费（元）</span> 
										<input id="moneyFactorage" name="moneyFactorage" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>付手续费方</span> 
										<input id="customerMoneyFactorage" name="customerMoneyFactorage" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>手续费状态</span> 
										<input id="factorageState" name="factorageState" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>

                                <p id="btn">
                                    <em id="msg"></em>
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