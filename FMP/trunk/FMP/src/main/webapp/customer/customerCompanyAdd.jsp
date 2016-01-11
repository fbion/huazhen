<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="detail mt20 pb30">

			<div class="tab">
				<div class="tab_title">
					<a href="javascript:;" class="active">法人客户</a>
				</div>
				<ul class="tab_content">
					<li class="tab_content1 tabContent" style="display: block;">
						<div class="basic_Info_content p15 info_All">
							<form id="customerCompanyAdd" style="z-index: 9999;">
								<ul>
									<li><span>企业客户名<em class='color'>*</em></span> <input id="name" name="name"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>企业类型</span> <select id="memberClassType" name="memberClassType"
										type="text" disabled="disabled" class="ml20 data" ></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>营业执照</span> <input id="cardLicense"
										name="cardLicense" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>组织机构代码</span> <input id="cardNumber"
										name="cardNumber" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>法人姓名</span> <input id="legal"
										name="legal" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>法人身份证</span> <input id="legalIdcard"
										name="legalIdcard" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>税务证</span> <input id="cardTax" name="cardTax"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>开户银行许可证</span> <input id="bankLicense"
										name="bankLicense" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>公司地址</span> <input id="address" name="address"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>公司固定电话</span> <input id="telephone" name="telephone"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>公司邮箱</span> <input id="email" name="email"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>所属行业</span> <input id="field" name="field"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>联系人姓名</span> <input id="contactName"
										name="contactName" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>联系人固定电话</span> <input id="contactTelephone"
										name="contactTelephone" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>联系人手机1</span> <input id="contactCellphone1"
										name="contactCellphone1" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>联系人手机2</span> <input id="contactCellphone2"
										name="contactCellphone2" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>关系等级</span> <select id="relationLevel"
										name="relationLevel" disabled="disabled" class="ml20 data"></select>
										<div class="Validform_checktip"></div></li>
									<li><span>风险偏好</span> <select id="riskHobby"
										name="riskHobby" disabled="disabled" class="ml20 data"></select>
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>新增时间</span> <input id="findTime" name="findTime" type="text"
										disabled="disabled" class="ml20 data"/>
										<div class="Validform_checktip"></div></li>
									<li><span>负责人</span>
                                        <input id="employeeSel" type="text" value="" class="ml20" disabled="disabled"/>
                                        <input type="text" id="agentNo" value="" style="display: none" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>可配置资产</span> <input id="wealth" name="wealth"
										type="text" disabled="disabled" class="ml20 data" />万
										<div class="Validform_checktip"></div></li>
									<li><span>购买额度</span> <input id="tradeTotal"
										name="tradeTotal" type="text" disabled="disabled"
										class="ml20 data" />元
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>修改备注</span> <input id="editComment"
										name="editComment" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>是否测试</span>
                                        <select id="isTest" name="isTest" class="ml20 data">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                        <div class="Validform_checktip"></div></li>
								</ul>
								
								<input id="customerNo" name="customerNo" type="hidden"/>
								<ul id="showP2pCustomer">
									<li><span>p2p账户名</span><input id="customerName"
										name="customerName" type="text" disabled="disabled"
										class="ml20" />
									</li>
								</ul>
								<p id="btn" class="mt20">
									<em id="msg"></em>
									<s:if test="showEditButton">
										<input type="button" id="edit" value="修改"
											class="submit_Btn none btn_style" />
									</s:if>
									<s:if test="showSubmitButton">
										<input type="submit" id="submit" value="提交"
											class="submit_Btn none btn_style" />
									</s:if>
									<input type="button" id="back" value="返回"
										class="cancel_Btn btn_style" />
								</p>
							</form>

							<hr />

							<!-- JqGrid start -->

							<div>
								<h3></h3>
							</div>
							<div class="pic mt20">
								<table id="gridTableFollow" class="gridTable">
								</table>
								<div id="gridPagerFollow" class="gridPager"></div>
							</div>
							<br>
							<p class="pl20">
								<input type="button" id="btnAddFollow" value="新建跟踪"
									class="btn_style" />
							</p>
							<form id="Follow" hidden="hidden">
								<input type="text" id="hideId" hidden="hidden" />
								<ul>
									<li><span>推荐产品<em class='color'>*</em></span> <select
										id="product_no" name="product_no" class="ml20"></select>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪类型</span> <select id="followType"
										name="followType" class="ml20"></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>跟踪时间</span> <input id="followTime"
										name="followTime" type="text" class="ml20" />
										<div class="Validform_checktip"></div></li>
									<li><span>下次跟踪</span> <input id="nexttime" name="nexttime"
										type="text" class="ml20" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>跟踪内容<em class='color'>*</em></span> <textarea
										id="contentFollow" name="contentFollow" 
										class="ml20" ></textarea>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪结果<em class='color'>*</em></span> <textarea
										id="result" name="result"  class="ml20" ></textarea>
										<div class="Validform_checktip"></div></li>
								</ul>
								<div style="margin-left: 43px">
									<p id="btn">
										<em id="showMsg" class='color'></em><em id="msg"></em> <input
											type="submit" id="submitFollow" value="跟踪"
											class="submit_Btn btn_style" /> <input type="button"
											id="editFollow" value="修改" class="submit_Btn btn_style" />
									</p>
								</div>
							</form>
							<hr />
						</div>
					</li>
				</ul>
			</div>
		</div>
        ${pageVar}
    </m:Content>
</m:ContentPage>