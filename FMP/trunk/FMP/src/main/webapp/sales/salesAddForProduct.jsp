<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">

		<div class="detail mt20 pb30">
			<div class="tab">
				<div class="tab_title">
					<a href="javascript:;" class="active">打款基本信息</a><s:if test="showCommonView"><a href="javascript:;">附件</a></s:if>
				</div>
				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display:block;">
						<div class="basic_Info_content p15 info_All">
							<form id="salesAdd" style="z-index:9999;">
								<ul>
									<li><span>订单编号</span> <input id="code" name="code" type="text" class="ml20 data"/>
										<div class="Validform_checktip"></div></li>
									<li><span>合同编号</span><input id="contractCode" type="text"
										name="contractCode" class="ml20 data" /></li>
								</ul>
								<ul>
									<li><span>产品类型</span> <select id="productType"
										name="productType" class="ml20 data"></select></li>
									<li><span>产品</span> <select id="productNo"
										name="productNo" class="ml20 data"></select></li>
								</ul>
								<ul>
									<li><span>销售类型</span> <select id="peopleType"
										name="peopleType" class="ml20 data"></select></li>
									<li class="peopleNo"><span>渠道</span>
                                        <span style="width:150px" class="ml20">
                                            <input class="ml20 data form-control" id="peopleNo"/>
                                        </span>
                                    </li>
								</ul>
								<ul>
									<li><span>客户类型</span> <select id="customerType"
										name="customerType" class="ml20 data"></select></li>
									<li><span id="customer">客户</span> <select id="customerNo"
										name="customerNo" class="ml20 data"></select>(只显示身份证填写完整的客户)
									</li>
                                </ul>
								<ul>
									<li><span>打款状态</span> <select id="status" name="status"
										class="ml20 data"></select></li>
									<li><span>打款金额<em class='color'>*</em></span> <input id="money" type="text" name="money" class="ml20 data" />元
                                        <div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li><span>销售经理</span>
                                        <input id="employeeSel" type="text" value="" class="ml20 data"/>
                                        <input type="text" id="empNo" value="" style="display: none" />
                                    </li>
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
									 <li><span>是否测试</span>
                                        <select id="isTest" name="isTest" class="ml20 data">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                        <div class="Validform_checktip"></div>
                                    </li>
								</ul>
                                <p id="btn" class="mt50">
									<em id="msg"></em>
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
${pageVar}
</m:Content>
</m:ContentPage>


