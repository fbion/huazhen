<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">销售代理商</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1 tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="agentBusinessAdd" style="z-index:9999;">
                                <ul>
                                    <li>
                                        <span>企业名称<em class='color'>*</em></span>
                                        <input id="name" name="name" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
									 <li>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>企业邮箱<em class='color'>*</em></span>
                                        <input id="email" name="email" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>企业电话<em class='color'>*</em></span>
                                        <input id="telephone" name="telephone" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>企业法人</span>
                                        <input id="owner" name="owner" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>企业网址</span>
                                        <input id="website" name="website" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>企业地址</span>
                                        <input id="address" name="address" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>联系人<em class='color'>*</em></span>
                                        <input id="contactPrimary" name="contactPrimary" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>联系人职位</span>
                                        <input id="contactPosition" name="contactPosition" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>联系人微信</span>
                                        <input id="contactWeixin" name="contactWeixin" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>联系人QQ</span>
                                        <input id="contactQq" name="contactQq" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>联系人手机<em class='color'>*</em></span>
                                        <input id="contactCellphone1" name="contactCellphone1" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>联系人手机2</span>
                                        <input id="contactCellphone2" name="contactCellphone2" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>联系人电话</span>
                                        <input id="contactTelephone" name="contactTelephone" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>联系人住址</span>
                                        <input id="contactAddress" name="contactAddress" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>重要等级</span>
                                        <select id="contactImportance" name="contactImportance"  disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>关系等级</span>
                                        <select id="relationLevel" name="relationLevel" disabled="disabled" class="ml20 data"></select>
                                    </li>

                                    <li>
                                        <span>信息来源</span>
                                        <select id="sourceType" name="sourceType" disabled="disabled" class="ml20 data"></select>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
                                        <span>负责人</span>
                                        <input id="employeeSel" type="text" value="" class="ml20" disabled="disabled"/>
                                        <input type="text" id="managerNo" value="" style="display: none" />
                                        <%--<select id="managerNo" name="managerNo"  disabled="disabled" class="ml20 data"></select>--%>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li><span>是否测试</span>
                                        <select id="isTest" name="isTest" class="ml20 data" disabled="disabled">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
                                <ul>
                                	<li>
                                        <span>企业描述</span>
                                       <!-- <input id="comment" name="comment" type="text" disabled="disabled" class="ml20 data"/>-->
                                       <textarea  class="ml20 data" id="comment" name="comment" disabled="disabled" ></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>

                                 <p id="btn" class="mt10 pt50">
                                    <em id="msg"></em>
                                    <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <s:if test="showSubmitButton">
                                        <input type="submit" id="submit" value="提交" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回" class="cancel_Btn btn_style"/>
                                </p>
                            </form>
                            
                            <hr />
                            
                            
                            <!-- JQgrid -->
							<div class="pic mt20 pl20">
								<table id="gridTableFollow" class="gridTable">
								</table>
								<div id="gridPagerFollow" class="gridPager"></div>
							</div>
							<br>
							 <p class="pl20">
								<input type="button" id="btnAddFollow" value="新建跟踪"
									class="btn_style" />
							</p>
                            
                            <form id="Follow" hidden="hidden" style="z-index:9999;">
                            	<input type="text" id="hideId" hidden="hidden" />
								<ul>
									<li><span>推荐产品<em class='color'>*</em></span> 
									<select id="product_no" name="product_no" class="ml20"></select>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪类型</span> <select id="followType"
										name="followType"  class="ml20"></select>
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
									<li><span>联系人</span> <input id="contacts"
										name="contacts" type="text" class="ml20" />
										<div class="Validform_checktip"></div></li>
									<li><span>联系人职位</span> <input id="position" name="position"
										type="text" class="ml20" />
										<div class="Validform_checktip"></div></li>
								</ul>
								
								
								<ul>
									<li><span>跟踪内容<em class='color'>*</em></span> <textarea
										id="contentFollow" name="contentFollow"
										class="ml20" ></textarea>
										<div class="Validform_checktip"></div></li>
									<li><span>跟踪结果<em class='color'>*</em></span> <textarea
										id="result" name="result" class="ml20" ></textarea>
										<div class="Validform_checktip"></div></li>
								</ul>
								<%-- <ul>
									<li><span>跟踪结果<em class='color'>*</em></span> <input
										id="result" name="result" type="text" class="ml20" />
										<div class="Validform_checktip"></div></li>
									<li><span style="vertical-align: top">修改备注</span> <input
										id="edit_comment_follow" name="edit_comment" type="text"
										class="ml20" /></li>
								</ul> --%>
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