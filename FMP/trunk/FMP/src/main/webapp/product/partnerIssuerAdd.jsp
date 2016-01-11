<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="detail mt20 pb30">
			<div class="tab" style="height:420px">
				<div class="tab_title">
					<a href="javascript:;" class="active">产品发行方</a>
				</div>
				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display:block;">
						<div class="basic_Info_content p15 info_All">
							<form id="partnerIssuerAdd" style="z-index:9999;">
								<ul>
									<li>
                                    	<span>机构编码</span> <input id="code" name="code"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>机构类型</span> <select id="type" name="type"
										type="text" disabled="disabled" class="ml20 data"></select>
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>机构名称<em class='color'>*</em></span> <input
										id="name" name="name" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>法人代表</span> <input id="owner" name="owner"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>联系人<em class='color'>*</em></span> <input
										id="contactPrimary" name="contactPrimary" type="text"
										disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>联系人职位<em class='color'>*</em></span> <input
										id="contactPosition" name="contactPosition" type="text"
										disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>负责人</span>
                                        <input id="employeeSel" type="text" value="" class="ml20" disabled="disabled"/>
                                        <input type="text" id="empNo" value="" style="display: none" />

                                        <%--<select id="empNo" name="empNo"--%>
										<%--type="text" disabled="disabled" class="ml20 data"></select>--%>
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>联系人手机1<em class='color'>*</em></span> <input
										id="contactCellphone1" name="contactCellphone1" type="text"
										disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>联系人手机2</span> <input id="contactCellphone2"
										name="contactCellphone2" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>联系人固话</span> <input id="contactTelephone"
										name="contactTelephone" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>联系人微信</span> <input id="contactWeixin"
										name="contactWeixin" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>联系人QQ</span> <input id="contactQq"
										name="contactQq" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>机构网址</span> <input id="website" name="website"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>机构地址</span> <input id="address" name="address"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>关系等级</span> <select id="relationLevel"
										name="relationLevel" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>重要程度</span> <select id="importanceLevel"
										name="importanceLevel" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>机构邮箱</span> <input id="email" name="email"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li>
                                    	<span>是否发行机构</span> <select id="isIssuer"
										name="isIssuer" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>是否销售代理</span> <select id="isAgent"
										name="isAgent" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div>
                                    </li>
									<li>
                                    	<span>修改备注</span> <input id="editComment"
										name="editComment" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div>
                                    </li>
								</ul>
								<ul>
									<li>
                                    	<span>发行机构简介<em class='color'>*</em></span> <!--<input id="comment" name="comment" type="text" disabled="disabled" class="ml20 data"/>-->
										<textarea id="comment" name="comment" cols="60" rows="3"
											disabled="disabled" class="ml20 data"></textarea><div class="Validform_checktip"></div></li>
									<li>
                                    	<span>是否测试</span> <select id="isTest" name="isTest"
										class="ml20 data" disabled="disabled">
											<option value="0">否</option>
											<option value="1">是</option>
									</select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<p id="btn" class="mt100">
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
						</div>
					</li>
				</ul>
			</div>
		</div>

		<hr  class="mt100"/>
		
		<div id="followList">
		<div class="pic mt20 pl20">
			<table id="gridTableFollow" class="gridTableFollow">
			</table>
			<div id="gridPagerFollow" class="gridPagerFollow"></div>
		</div> 
		<p class="mt20 pl20" style="text-align:center;">
			<s:if test="showAddButton">
				<input type="button" id="btnFollowListAdd" value="新建跟踪" class="btn_style" />
			</s:if>
		</p>
		</div>

		
		<div id="follow" class="detail mt20 pb30" hidden="hidden">
			<div class="tab">
				<div>
					<a href="javascript:;" ></a>
				</div>
				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display:block;">
						<div class="basic_Info_content p15 info_All">
							<form id="partnerIssuerFollowAdd" style="z-index:9999;">
								<ul>
									<li><span>推荐产品</span> <select id="productNo"
										name="productNo" disabled="disabled"
										class="ml20 data" ></select>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪类型</span> <select id="followType" name="type"
										disabled="disabled" class="ml20 data" ></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>联系人</span> <input id="contacts"
										name="contacts" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>联系人职位</span> <input id="position"
										name="position" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>跟踪时间<em class="color">*</em></span> <input id="time" name="time"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>下次跟踪时间<em class="color">*</em></span> <input id="nexttime"
										name="nexttime" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>跟踪内容<em class="color">*</em></span> <textarea id="content"
										name="content" disabled="disabled"
										class="ml20 data" ></textarea>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪结果<em class="color">*</em></span> <textarea id="result" name="result"
										 disabled="disabled" class="ml20 data" ></textarea>
										<div class="Validform_checktip"></div></li>
								</ul>
								<p id="btn">
									<em id="msg"></em>
										<input type="button" id="editFollow" value="修改"
											class="submit_Btn none btn_style" />
										<input type="submit" id="submitFollow" value="提交"
											class="submit_Btn none btn_style" />
										<input type="button" id="backFollow" value="关闭"
											class="cancel_Btn btn_style" />
								</p>
							</form>
						</div>
					</li>
				</ul>
			</div>
		</div>
		
		<div hidden="hidden" >
			<input id="hideId" type="text" value="0"/>
				<%-- <ul>
					<li><span>机构类型</span> <select id="agentType"
						name="agentType" disabled="disabled"
						class="ml20 data" ></select>
						<div class="Validform_checktip"></div></li>
					<li><span>机构名称</span> <input id="agentNo"
						name="agentNo" type="text" disabled="disabled"
						class="ml20 data" />
						<div class="Validform_checktip"></div></li>
						<li><span>产品类型</span> <input id="productType"
						name="productType" type="text" disabled="disabled"
						class="ml20 data" />
						<div class="Validform_checktip"></div></li>
					<li><span>修改备注</span> <input id="editComment"
						name="editComment" type="text" disabled="disabled"
						class="ml20 data" />
						<div class="Validform_checktip"></div></li>
					</ul> --%>
		</div>
        ${pageVar}
    </m:Content>
</m:ContentPage>