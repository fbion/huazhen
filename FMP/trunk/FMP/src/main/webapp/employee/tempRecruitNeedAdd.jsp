<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="detail mt20 pb30">
			<div class="tab">
				<div class="tab_title">
					<a href="javascript:;" class="active">临时招聘管理</a>
				</div>
				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display: block;">
						<div class="basic_Info_content p15 info_All">

							<div class="detail mt20 pb30 ">
								<div class="tableCenter">
									<h5 class="tc">招聘需求表</h5>
									<%-- <input type="hidden" id="activitiStatus" value="${activitiStatus}" />
                                    <input type="hidden" id="backUrl" value="${backUrl}" /> --%>
                                    <input id="activitiNo" type="hidden"
										value="">

									<form id="tempRecruitNeedAdd">
										<p style="height: auto;">
											编号:<span class="demandTable"><input type="text"
												id="code" class="data tl fl" style="width: 110px;" />
											<%--<span class="Validform_checktip fr" style="border-bottom:none;"></span>--%></span>
											年度:<span class="demandTable"><input type="text"
												id="financialYear" class="data tl fl" /><span
												class="Validform_checktip fl" style="border-bottom: none;"></span></span>
										</p>
										<table align="center" border="1" id="aduitComment">
											<tr>
												<td width="83" valign="center">需求部门</td>
												<td width="152" valign="center" colspan="2">
													<div class="DivSelects">
														<select disabled="disabled" class='SelectLists tc'
															id="deptNo" style="width: 130px;"></select>
													</div>
												</td>
												<td width="90" valign="center">需求岗位</td>
												<td width="107" valign="center" colspan="4">
													<div class="DivSelects">
														<select class='SelectLists tc data' id="positionNo"></select>
													</div>
												</td>
												<td width="79" valign="center">需求人数</td>
												<td width="98" valign="center" colspan="1"><input
													type="text" class="data" id="addPeople"
													style="width: 80px;" /><span class="Validform_checktip"></span></td>
											</tr>
											<tr>
												<td width="83" valign="center">需求原因</td>
												<td width="629" valign="center" colspan="9"><input
													id="needCause" class="data" type="text"
													style="width: 650px; text-align: left;" /><span
													class="Validform_checktip"></span></td>
											</tr>
											<tr>
												<td width="83" valign="center">工作职责</td>
												<td width="629" valign="center" colspan="9"><textarea
														id="jobDuties" class="data"
														style="width: 650px; height: 96px;"></textarea><span
													class="Validform_checktip"></span></td>
											</tr>
											<tr>
												<td width="83" valign="center" rowspan="7">申请内容</td>
												<td width="68" valign="center">性别</td>
												<td width="174" align="center" colspan="2">
													<div class="DivSelect data">
														<select id="sex" class="SelectList data"
															style="width: 70px;">
															<option value="0">不限</option>
															<option value="1">男</option>
															<option value="2">女</option>
														</select>
													</div>
												</td>
												<td width="58" valign="center">学历</td>
												<td width="98" align="center" colspan="1">
													<div class="DivSelect data">
														<select id="education" class="SelectList data"
															style="width: 70px;">
															<option value="1">高中</option>
															<option value="2">专科</option>
															<option value="3">本科</option>
															<option value="4">硕士</option>
															<option value="5">博士</option>
														</select>
													</div>
												</td>
												<td width="53" valign="center">专业</td>
												<td width="139" valign="top" colspan="3"><input
													type="text" class="data" id="major" style="width: 170px;" />
												</td>
											</tr>
											<tr>
												<td width="68" valign="center">年龄</td>
												<td width="174" valign="top" colspan="2"><input
													id="age" type="text" class="data" /></td>
												<td width="58" valign="center">语言</td>
												<td width="135" valign="top" colspan="1"><input
													type="text" id="language" class="data" /></td>
												<td width="53" valign="center">证书</td>
												<td width="139" valign="top" colspan="3"><input
													type="text" id="certificate" class="data"
													style="width: 170px;" /></td>
											</tr>
											<tr>
												<td width="68" valign="center">专业<br />技能
												</td>
												<td width="561" valign="top" colspan="8">
													<!--<textarea style="width:550px; height:50px;"></textarea>-->
													<input type="text" id="skill"
													style="width: 550px; height: 30px;" class="data" />

													<div class="Validform_checktip"></div>
												</td>
											</tr>
											<tr>
												<td width="68" valign="center">工作<br />经验
												</td>
												<td width="561" valign="top" colspan="8"><input
													id="experience" class="data" type="text"
													style="width: 550px; height: 30px;" />

													<div class="Validform_checktip"></div></td>
											</tr>
											<tr>
												<td width="68" valign="center">能力</td>
												<td width="561" valign="top" colspan="8"><input
													id="ability" class="data" value="" type="text"
													style="width: 550px; height: 30px;" />

													<div class="Validform_checktip"></div></td>
											</tr>
											<tr>
												<td width="68" valign="center">其他</td>
												<td width="561" valign="top" colspan="8"><input
													type="text" id="other" style="width: 550px; height: 30px;"
													class="data" /></td>
											</tr>
											<tr>
												<td width="68" valign="center">希望到岗时间</td>
												<td width="561" valign="top" colspan="8"><input
													type="text" id="workDate" class="data dateYMD"
													style="width: 550px; height: 30px;" />

													<div class="Validform_checktip"></div></td>
											</tr>
											<!-- <tr >
                                              <td width="83" valign="center" >申请人</td>
                                              <td width="629" valign="center" colspan="9" >
                                                  <textarea style="width:650px; height:90px;" id="comment3" ></textarea>
                                                  <div>签字：<input type="text"id="commentName3"/>时间：<input type="text" id="commentTime3"/></div></td>
                                            </tr>
                                            <tr >
                                              <td width="83" valign="center" >部门负责人意见</td>
                                              <td width="629" valign="center" colspan="9" >
                                                  <textarea style="width:650px; height:90px;" id="comment2"  ></textarea>
                                                  <div>签字：<input type="text" id="commentName2"/>时间：<input type="text" id="commentTime2"/></div></td>
                                            </tr>
                                            <tr >
                                              <td width="83" valign="center" >HR意见</td>
                                              <td width="629" valign="center" colspan="9" >
                                                  <textarea style="width:650px; height:90px;" id="comment1"></textarea>
                                                  <div>签字：<input type="text"id="commentName1"/>时间：<input type="text" id="commentTime1"/></div></td>
                                            </tr>
                                            <tr >
                                              <td width="83" valign="center" >公司领导<br />意见</td>
                                              <td width="629" valign="center" colspan="9" >
                                                  <textarea style="width:650px; height:90px;"id="comment0"></textarea>
                                                  <div>签字：<input type="text" id="commentName0"/>时间：<input type="text" id="commentTime0"/></div></td>
                                            </tr> -->
										</table>
										<div id="btn" class="pt20">
											<em id="msg"></em>
											<s:if test="showEditButton">
											<input id="submitExamine" type="button" value="提交审批" class="submit_Btn btn_style"/>
												<input id="edit" name="edit" type="button" value="修改"
													class="submit_Btn none btn_style" />
												<input id="submit" name="submit" type="submit" value="保存"
													class="submit_Btn none btn_style" />
											</s:if>

											<s:if test="showExamineButton">
                                                <input id="examine"  type="button" value="审批" class="submit_Btn btn_style"/>
                                            </s:if>
											<input id="back" name="back" type="button" value="返回"
												class="cancel_Btn btn_style" />
										</div>
										<div class="trackBtn"></div>
										<div id="w1" class="easyui-window" title="临时招聘表审批"
											data-options="modal:true,closed:true,iconCls:'icon-save'"
											style="width: 500px; height: 200px; padding: 10px;">
											<div>
												<textarea id="taskCommet"
													style="width: 450px; height: 100px;"></textarea>

												<div data-options="region:'south',border:false"
													style="text-align: right; padding: 5px 0 0;">
													<input id="submit1" name="submit" type="submit" value="通过"
														class="submit_Btn  btn_style examine" /> <input
														id="submit2" name="" type="submit" value="不通过"
														class="submit_Btn  btn_style examine" />
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>

						</div>
					</li>
				</ul>
			</div>
		</div>
        ${pageVar}
    </m:Content>
</m:ContentPage>