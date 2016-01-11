<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">

        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">打款基本信息</a><s:if test="showCommonView"><a href="javascript:;">附件</a></s:if><s:if test="showP2pInvestmentView"><a href="javascript:;" id="p2pInvestmentStatus">附加信息</a></s:if>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="salesAdd" style="z-index:9999;">
                                <input id="p2pSalesPage" hidden="hidden" />
                                <ul>
                                    <li><span>订单编号</span> <input id="code" name="code" type="text" disabled="disabled" class="ml20 data" />
                                        <div class="Validform_checktip"></div></li>
                                    <li><span>合同编号</span> <input id="contractCode" type="text"
                                                                 name="contractCode" class="ml20 data" /></li>
                              	</ul>
                                <ul>
                                    <li><span>产品类型</span> <select id="productType"
                                                                  name="productType" class="ml20 data"></select></li>
                                    <li><span>产品</span> <select id="productNo"
                                                                name="productNo" class="ml20 data"></select></li>
                                </ul>
                                <ul>
                                    <li><span>客户类型</span> <select id="customerType"
                                                                  name="customerType" class="ml20 data"></select></li>
                                    <li><span>客户</span> <select id="customerNo"
                                                                name="customerNo" class="ml20 data"></select></li>
                                </ul>
                                <ul>
                                    <li><span>打款状态</span> <select id="status" name="status"
                                                                  class="ml20 data"></select></li>
                                    <li><span>打款金额<em class='color'>*</em></span> <input id="money" type="text" name="money" class="ml20 data" />万
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li><span>部门</span> <select id="deptNo" name="deptNo"
                                                                class="ml20 data"></select></li>
                                    <li><span>销售经理</span> <select id="empNo" name="empNo"
                                                                  class="ml20 data"></select></li>
                                </ul>
                                <ul>
                                    <li><span>协议状态</span> <select id="protocolStatus"
                                                                  name="protocolStatus" class="ml20 data"></select></li>
                                    <li><span>购买日期<em class='color'>*</em></span> <input id="purchaseDate"
                                                                                         name="purchaseDate" type="text" class="ml20 data"/>
                                        <div class="Validform_checktip"></div></li>
                                </ul>
                                <ul>
                                    <li><span>开户行</span>
                                        <input id="bankAddress" name="bankAddress" type="text" class="ml20 data" />
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span>开户名</span>
                                        <input id="bankName" name="bankName" type="text" class="ml20 data" />
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span>银行账号</span>
                                        <input id="accountNumber" name="accountNumber" type="text" class="ml20 data">
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <p id="btn">
                                    <em id="msg"></em>
                                    <s:if test="true">
                                        <input type="button" id="success" value="认购成功"
                                               class="submit_Btn status none btn_style" />
                                        <input type="button" id="cancel" value="取消订单"
                                               class="submit_Btn status none btn_style" />
                                    </s:if>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style" />
                                        <input type="submit" id="submit" value="保存"
                                               class="submit_Btn none btn_style" />
                                    </s:if>
                                    <input type="button" id="back" value="返回"
                                           class="cancel_Btn btn_style" />
                                </p>
                            </form>
                        </div>
                    </li>
                    <s:if test="showNewAdd">
                        <li class="tab_content2  tabContent">
                            <div class="details_Info_content p15 info_All">
                                <div class="upload">
                                    <span>产品合同</span>
                                    <s:if test="showUploadButton">
                                        <input id="upload" name="file" type="file" value="上传文件" />
                                    </s:if>
                                    <s:else>
                                        <input id="upload1" name="file" type="hidden" value="上传文件" />
                                    </s:else>
                                </div>
                                <div class="upload_end"></div>
                            </div>
                        </li>
                    </s:if>
                    <li class="tab_content3  tabContent" style="display:none;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="updateP2pInvestment" style="z-index:9999;">
                                <ul>
                                    <li><span>收益</span>
                                        <input id="income" name="income" type="text" class="ml20 data" />万
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <%-- <li ><span>浮动收益</span>
                                       <input id="floatIncome" name="floatIncome" type="text" class="ml20 data" />
                                        <div class="Validform_checktip"></div>
                                    </li>  --%>
                                    <li><span>付息时间</span>
                                        <input id="paymentTime" name="paymentTime" type="text" class="ml20 data" />
                                    </li>
                                    </ul><ul>
                                    <li><span>付息方式</span>
                                    <select id="paymentType" name="paymentType" class="ml20 data" >
                                    </select>
                                    </li>
                                </ul>
                                <p id="btn1">
                                    <em id="msg"></em>
                                    <s:if test="showSuccessButton">
                                        <input type="button" id="success" value="认购成功"
                                               class="submit_Btn status none btn_style" />
                                    </s:if>
                                    <s:if test="showStatusButton">
                                        <input type="button" id="cancel" value="取消订单"
                                               class="submit_Btn status none btn_style" />
                                    </s:if>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style" />
                                        <input type="submit" id="submit" value="保存"
                                               class="submit_Btn none btn_style" />
                                    </s:if>
                                    <input type="button" id="back" value="返回"
                                           class="cancel_Btn btn_style" />
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