<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 15-1-15
  Time: 上午9:04
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
                <a href="javascript:;" class="active">基本信息</a>
            <s:if test="showCommonView">
                <a href="javascript:;">附件</a>
            </s:if>
            <s:if test="showCommonView && showIncomeRateView">
                <%--<a href="javascript:void(0)">佣金费率</a>--%>
                <a href="javascript:void(0)">产品分期</a>
            </s:if>
            <%--<s:if test="showCommonView && showAgentRateView">--%>
                <%--<a href="javascript:void(0)">成本费率</a>--%>
            <%--</s:if>--%>
            <%--<s:if test="showCommonView">--%>
                <%--<a href="javascript:;">立项审核</a>--%>
            <%--</s:if>--%>
            <s:if test="showProductExamine">
                <a href="javascript:;">产品审核</a>
            </s:if>
            <s:if test="showExamineDirect">
                <a href="javascript:;">直销承销</a>
            </s:if>
            <s:if test="showExamineChannel">
                <a href="javascript:;">渠道承销</a>
            </s:if>


        </div>
            <ul class="tab_content">
                <li class="tab_content1 tabContent" style="display:block;">
                    <div class="basic_Info_content p15 info_All">
                        <form id="productAdd">
                            <ul>
                                <li>
                                    <span>产品编号</span>
                                    <input id="code" name="code" type="text" class="ml20 data" disabled="true"/>自动生成
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            
                                <li>
                                    <span>产品名称</span>
                                    <input id="name" name="name" type="text" class="ml20 data"/>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>募集规模</span>
                                    <input id="sumMoney" name="sumMoney" type="text" class="ml20 data"/>&nbsp;元
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>产品类型</span>
                                    <select id="type" name="type" class="ml20 data">
                                    </select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>是否包销</span>
                                    <select id="isSaleAll" name="isSaleAll" class="ml20 data">
                                        <option value="0">否</option>
                                        <option value="1">是</option>
                                    </select>
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>打包价（选填）</span>
                                    <input id="pricePackage" name="pricePackage" type="text" class="ml20 data"/>&nbsp;%
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>付息方式</span>
                                    <select id="payType" name="payType" class="ml20 data">
                                    </select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>认购起点</span>
                                    <input id="baseLimit" name="baseLimit" type="text" class="ml20 data"/>&nbsp;元
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>存续期</span>
                                    <input id="deadLine" name="deadLine" type="text" class="ml20 data"/>&nbsp;月
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>发行机构</span>
                                    <select id="issuerNo" name="issuerNo" class="ml20 data">
                                    </select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>融资方类型</span>
                                    <select id="financierType" name="financierType" class="ml20 data">
                                    </select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>融资方</span>
                                    <select id="financierNo" name="financierNo" class="ml20 data">
                                    </select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                                <ul>
                                    <li>
                                        <span>上线日期</span>
                                           <input id="onlineTime" name="onlineTIme" class="ml20 data" />
                            
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                            <ul class="no_new">
                                <li>
                                    <span>成立日期</span>
                                    <input id="start" name="start" type="text" class="ml20 data"/>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>到期日期</span>
                                    <input id="end" name="end" type="text" class="ml20 data"/>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul class="no_new">
                                <li>
                                    <span>剩余额度</span>
                                    <input id="remainAmount" name="remainAmount" type="text" class="ml20 data"/>&nbsp;元
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>剩余小额</span>
                                    <input id="remainSmall" name="remainSmall" type="text" class="ml20 data"/>&nbsp;个
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>产品状态</span>
                                    <select id="status" name="status" class="ml20 data" disabled="disabled">
                                    </select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>产品投向</span>
                                    <select id="tendType" name="tendType" class="ml20 data">
                                    </select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>大小配额</span>
                                    <select id="quota" name="quota" class="ml20 data"></select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>打款截止日期</span>
                                    <input id="dueDate" name="dueDate" type="text" class="ml20 data"/>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>开户行地址</span>
                                    <input id="bankAddress" name="bankAddress" type="text" class="ml20 edit data"/>
                                </li>
                                <li>
                                    <span>开户名</span>
                                    <input id="bankName" name="bankName" type="text" class="ml20 edit data"/>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>打款账号</span>
                                    <input id="accountNumber" name="accountNumber" type="text" class="ml20 edit data"/>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>产品经理</span>
                                        <input id="employeeSel" type="text" value="" class="ml20" disabled="disabled"/>
                                        <input type="text" id="empNo" value="" style="display: none"/>
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>协议签署状态</span>
                                    <select id="agreementStatus" name="agreementStatus" class="ml20 data"></select>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                                <li>
                                    <span>测试产品</span>
                                       <select id="isTest" name="isTest" class="ml20 data">
                                           <option value="0">否</option>
                                           <option value="1">是</option>
                                       </select>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <span>基数<em class='color'>*</em></span>
                                    <input id="baseNumber" name="baseNumber" class="ml20 data" />
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ul>

                            <ol>
                                <li>
                                    <span>产品描述</span>
                                    <textarea id="comment" name="comment" class="ml20 data"></textarea>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ol>
                            <ol>
                                <li>
                                    <span>资金用途</span>
                                    <textarea id="purpose" name="purpose" class="ml20 data"></textarea>
                            
                                    <div class="Validform_checktip"></div>
                                </li>
                            </ol>
                            <ol>
                                <li>
                                    <span>预期年化收益</span>
                                    <textarea id="expectProfit" name="expectProfit" class="ml20 data"></textarea>

                                    <div class="Validform_checktip"></div>
                                </li>
                            </ol>
                            <ol>
                                <li>
                                    <span>结算方式</span>
                                    <textarea id="settlementType" name="settlementType" class="ml20 data"></textarea>

                                    <div class="Validform_checktip"></div>
                                </li>
                            </ol>
                            <p id="btn"><em id="msg"></em>
                                <s:if test="showStatusButton">
                                    <input type="button" id="publishP2P" value="发布网站产品" class="submit_Btn status none btn_style ml15"/>
                                    <input type="button" id="updateStatus" value="预上线" class="submit_Btn status none btn_style ml15"/>
                                    <%--<input id="stop" type="button" value="暂停" class="submit_Btn status none btn_style">--%>
                                    <input id="preFinsh" type="button" value="提前结束" class="submit_Btn none btn_style">
                                </s:if>
                                <s:if test="showCancelButton">
                                    <input type="button" id="cancel" value="取消产品" class="submit_Btn btn_style"/>
                                </s:if>
                                <s:if test="showExamineButton">
                                    <input id="examine"  type="button" value="审批" class="examine submit_Btn btn_style"/>
                                </s:if>

                                <s:if test="showEditButton">
                                    <input type="button" id="editBank" value="修改" class="submit_Btn none btn_style"/>
                                    <input type="button" id="commitCheck" value="提交审核" class="submit_Btn  none btn_style"/>
                                    <input type="button" id="edit" value="修改" class="submit_Btn none btn_style"/>
                                    <input type="submit" id="submit" value="保存" class="submit_Btn none btn_style"/>
                                </s:if>
                                <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                            </p>
                        </form>
                        
                        <div id="w" class="easyui-window" title="提前结束" data-options="closed:true" style="width:400;height:200px;padding:1px;">
                            <div class="easyui-layout" data-options="fit:true" style="background-color: white">
                                <div data-options="region:'center'" style="padding:10px; ">
                        
                                    提前结束：<input id="startTime" type="text">
                        
                                </div>
                                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                                    <span id="message" style="width:80px"></span>
                                    <a id="preFinshConfirm" class="easyui-linkbutton" href="javascript:void(0)" style="width:80px">确定</a>
                                    <a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">关闭</a>
                                </div>
                            </div>
                        </div>
                        <div id="c" class="easyui-window" title="分期成立" data-options="closed:true" style="width:400;height:200px;padding:1px;">
                            <div class="easyui-layout" data-options="fit:true" style="background-color: white">
                                <div data-options="region:'center'" style="padding:10px; ">
                        
                                    成立日期：<input id="startime" type="text">
                                    结束日期：<input id="endTime" type="text">
                                </div>
                                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                                    <span id="message1" style="width:80px"></span>
                                    <a id="preFinshConfirm1" class="easyui-linkbutton" href="javascript:void(0)" style="width:80px">确定</a>
                                    <a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">关闭</a>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </li>
                <s:if test="showCommonView">
                <li class="tab_content2  tabContent">
                    <div class="details_Info_content p15 info_All" id="uploadDiv">
                    </div>
                </li>
                </s:if>
                <s:if test="showCommonView && showIncomeRateView">
                <li class="tab_content4  tabContent">
                    <div class="pic mt20 detail_pic">
                        <table id="stagesGridTable" class="gridTable">
                        </table>
                    </div>
                </li>
                </s:if>
                <s:if test="showProductExamine">
                    <li class="tab_content7 tabContent">
                        <s:include value="productExamine.jsp"></s:include>
                    </li>
                </s:if>
                <div id="w1" class="easyui-window" title="产品上线审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
                    <div>
                        <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
                        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                            <input id="submit1" name="submit" type="submit" value="下一步" oper="next"class="submit_Btn  btn_style audit"/>
                            <input id="submit2" name="" type="submit" value="驳回" oper="back" class="submit_Btn  btn_style audit"/>
                        </div>
                    </div>
                </div>
                <s:if test="showExamineDirect">
                    <li class="tab_content8 tabContent">
                        <s:include value="productExamineForDirect.jsp"></s:include>
                    </li>
                </s:if>
                <s:if test="showExamineChannel">
                    <li class="tab_content9 tabContent">
                        <s:include value="productExamineForChannel.jsp"></s:include>
                    </li>
                </s:if>
         </ul>
    </div>
</div>
${pageVar}

</m:Content>
</m:ContentPage>