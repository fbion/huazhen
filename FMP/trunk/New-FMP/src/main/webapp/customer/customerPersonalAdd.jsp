<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="detail mt20 pb30">

			<div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">自然人客户</a>
                    <a href="javascript:;">打款详情</a>
                </div>
				<ul class="tab_content">
					<li class="tab_content1 tabContent" style="display: block;">
						<div class="basic_Info_content p15 info_All">
							<form id="customerPersonalAdd" style="z-index: 9999;">
								<ul>
									<li><span>姓名<em class='color'>*</em></span> <input id="name" name="name"
										type="text"  class="ml20 data" />
										<div class="Validform_checktip"></div></li>

									<li><span>证件号码</span> <input id="cardNumber"
										name="cardNumber" type="text"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>性别</span> <select id="sex" name="sex"
										 class="ml20 data" ></select>
										<div class="Validform_checktip"></div></li>
									<li><span>邮件</span> <input id="email" name="email"
										type="text" class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>微信</span> <input id="weixin" name="weixin"
										type="text" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>QQ</span> <input id="qq" name="qq" type="text"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>

									<li><span>手机1<em id="cellphone1Class" class='color'>*</em></span> 
									<input id="cellphone1" name="cellphone1" type="text" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>手机2</span> <input id="cellphone2"
																name="cellphone2" type="text"
																class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>固定电话<em id="phoneClass" class='color'>*</em></span>
                                        <input id="phone" name="phone" type="text"class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>生日</span> <input id="birthday"
										name="birthday" type="text"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>地址</span> <input id="address"
										name="address" type="text"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>婚姻</span> <select id="marry" name="marry"
										 class="ml20 data" ></select>
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>所属公司</span> <input id="companyName"
										name="companyName" type="text"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>所属行业</span> <input id="field" name="field"
										type="text" class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>关系等级<em class='color'>*</em></span> <select id="relationLevel"
										name="relationLevel"
										class="ml20 data" ></select>
										<div class="Validform_checktip"></div></li>
									<li><span>风险偏好</span> <select id="riskHobby"
										name="riskHobby"
										class="ml20 data" ></select>
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>新增时间<em class='color'>*</em></span> <input id="findTime"
										name="findTime" type="text"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>负责人</span>
                                        <input id="employeeSel" type="text" value="" class="ml20 data" />
                                        <input type="text" id="agentNo" value="" style="display: none" class="data"/>

										<div class="Validform_checktip"> </div>
                                  </li>

								</ul>
								<ul>
									<li><span>可配置资产</span> <input id="wealth" name="wealth"
										type="text" class="ml20 data" />万
										<div class="Validform_checktip"></div></li>
									<li><span>累计购买</span> <input id="tradeTotal"
										name="tradeTotal" type="text"
										class="ml20 data" />元
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
                                    <li><span>是否测试</span>
                                        <select id="isTest" name="isTest" class="ml20 data" >
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                        <div class="Validform_checktip"></div></li>
                                    <li><span>客户来源</span>
                                    <select id="sourceType" name="sourceType" class="ml20 data">
                                    </select>
                                    <div class="Validform_checktip"></div></li>
								</ul>
								<ol>
									<li><span>备注</span> <textarea id="editComment"
										name="editComment"
										class="ml20 data" ></textarea>
										<div class="Validform_checktip"></div></li>
								</ol>

								<p id="btn">
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
                                <div id="gridPagerFollow" class="gridPagerFollow">
                                </div>
                            </div>
							<br>
							<p class="pl20">
								<input type="button" id="btnAddFollow" value="新建跟踪"
									class="btn_style" />
							</p>


							<form id="customerFollowAdd" hidden="hidden">
								<input type="text" id="hideId" hidden="hidden" />
								<ul>
									<li><span>推荐产品<em class='color'>*</em></span> <select
										id="product_no" name="product_no"  class="ml20 follow"></select>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪类型</span> <select id="followType"
										name="followType"  class="ml20 follow" ></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>跟踪时间</span> <input id="followTime"
										name="followTime" type="text" class="ml20 follow" />
										<div class="Validform_checktip"></div></li>
									<li><span>下次跟踪</span> <input id="nexttime" name="nexttime"
										type="text" class="ml20 follow" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>跟踪内容<em class='color'>*</em></span> <textarea
										id="contentFollow" name="contentFollow"
										class="ml20 follow" ></textarea>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪结果</span>
										<select id="resultStatus" name="resultStatus" class="ml20 follow"></select>
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
                    <li class="tab_content1 tabContent">

                        <div class="wrappSearch mt30">
                            <h3></h3>
                            <div class="wrappSearchContent">
                                打款状态:<select id="selectStatus"></select>
                                产品类型：<select id="selectProductType"></select>
                                产品：<select id="selectProduct"></select>
                                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
                                <s:if test="showExcelButton">
                                    <input type="button" id="btnExcel" value="导出Excel" class="btn_style" />
                                </s:if>
                            </div>
                        </div>
                        <p class="btnSales mt50">
                            <s:if test="showAddButton">
                                <input type="button" id="btnAddSales" class="btnAdd btn_style" value="新建"/>
                            </s:if>

                        </p>
                        <div class="pic mt20">
                            <table id="gridTable" class="gridTable">
                            </table>
                            <div id="gridPager" class="gridPager">
                            </div>
                        </div>

                    </li>
				</ul>
			</div>
		</div>
        ${pageVar}
    </m:Content>
</m:ContentPage>