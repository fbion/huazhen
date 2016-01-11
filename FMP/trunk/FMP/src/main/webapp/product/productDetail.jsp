<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
        <div class="tab_title">
                <a href="javascript:void(0);" class="active">基本信息</a>
                <a href="javascript:void(0);">附件</a>
                <a href="javascript:void(0)">产品分期</a>
            <s:if test="showProductExamine">
                <a href="javascript:void(0);">产品审核</a>
            </s:if>
            <s:if test="showExamineDirect">
                <a href="javascript:void(0);">直销承销</a>
             </s:if>
            <s:if test="showExamineChannel">
                <a href="javascript:void(0);">渠道承销</a>
            </s:if>
        </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="productDetail" style="z-index:9999;">
                                <ul>

                                    <li><span class="fw">编号</span><a id="code" name="code" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">产品名称</span><a id="name" name="name" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">募集规模</span><a id="sumMoney" name="sumMoney" class="ml20" target="_blank"></a>元</li>
                                    <li><span class="fw">产品类型</span><a id="type" name="type" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>

                                    <li><span class="fw">是否包销</span><a id="isSaleAll" name="isSaleAll" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">打包价</span><a id="pricePackage" name="pricePackage" class="ml20" target="_blank"></a>%</li>
                                </ul>

                                <ul>
                                    <li><span class="fw">付息方式</span><a id="payType" name="payType" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">认购起点</span><a id="baseLimit" name="baseLimit" class="ml20" target="_blank"></a>元</li>

                                </ul>
                                <ul>
                                    <li><span class="fw">存续期</span><a id="deadLine" name="deadLine" class="ml20" target="_blank"></a>月</li>
                                    <li><span class="fw">发行机构</span><a id="issuerNo" name="issuerNo" class="ml20" target="_blank"></a></li>



                                </ul>
                                <ul>
                                    <li><span class="fw">融资方类型</span><a id="financierType" name="financierType" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">融资方</span><a id="financierNo" name="financierNo" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>

                                    <li><span class="fw">上线时间</span><a id="onlineTime" name="onlineTime" class="ml20" target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">成立日期</span><a id="start" name="start" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">到期日期</span><a id="end" name="end" class="ml20" target="_blank"></a></li>

                                </ul>
                                <ul>
                                    <li><span class="fw">剩余额度</span><a id="remainAmount" name="remainAmount" class="ml20" target="_blank"></a>元</li>
                                    <li><span class="fw">剩余小额</span><a id="remainSmall" name="remainSmall" class="ml20" target="_blank"></a></li>

                                </ul>
                                <ul>

                                    <li><span class="fw">产品状态</span><a id="status" name="status" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">产品投向</span><a id="tendType" name="tendType" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">大小配额</span><a id="quota" name="quota" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">打款截止日期</span><a id="dueDate" name="dueDate" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">开户行地址</span><a id="bankAddress" name="bankAddress" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">开户名</span><a id="bankName" name="bankName" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">打款账号</span><a id="accountNumber" name="accountNumber" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">产品经理</span><a id="empNo" name="empNo" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">协议签署状态</span><a id="agreementStatus" name="agreementStatus" class="ml20" target="_blank"></a></li>
                                    <li><span class="fw">是否测试</span><a id="isTest" name="isTest" class="ml20" target="_blank"></a></li>
                                </ul>
                                <ul>
                                    <li><span class="fw">基数</span><a id="baseNumber" name="baseNumber" class="ml20" target="_blank"></a></li>
                                </ul>

                                <ol>
                                    <li><span class="fw">结算方式</span><a id="settlementType" name="settlementType" class="ml20" target="_blank"></a></li>
                                </ol>
                                <ol>
                                    <li><span class="fw">资金用途</span><a id="purpose" name="purpose" class="ml20" target="_blank"></a></li>
                                </ol>
                                <ol>
                                    <li><span class="fw">产品描述</span><a id="comment" name="comment" class="ml20" target="_blank"></a></li>
                                </ol>

                                <ol>

                                    <li><span class="fw">预期年化收益</span><a id="expectProfit" name="expectProfit" class="ml20" target="_blank"></a></li>

                                </ol>
                                <p id="btn" class="mt20">
                                    <em id="msg"></em>
                                    <s:if test="showExamineButton">
                                        <input id="examine"  type="button" value="审批" class="examine submit_Btn btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                </p>
                            </form>
                        </div>
                    </li>
	                	<li class="tab_content2  tabContent">
	                    <div class="details_Info_content p15 info_All" id="uploadDiv">
	                
	                    </div>
	                	</li>
                <li class="tab_content4  tabContent">
                    <div class="pic mt20 detail_pic">
                        <table id="stagesGridTable" class="gridTable">
                        </table>
                    </div>
                </li>
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