<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="detail mt20 pb30">
			<div class="tab">
				<div class="tab_title">
					<a href="javascript:;" class="active">部门管理</a>
				</div>
				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display: block;">
						<div class="basic_Info_content p15 info_All">
							<form id="departmentAdd" style="z-index: 9999;">
								<ul>
									<li><span>部门名称<em class="color">*</em></span> <input id="name" name="name"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>部门类型</span> <select id="deptType"
										name="deptType" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div></li>
									<li><span>负责人</span>
                                        <%--<select id="empNo" name="empNo"--%>
										<%--type="text" disabled="disabled" class="ml20 data"></select>--%>

                                        <input id="employeeSel" type="text" value="" class="ml20 data" disabled="disabled"/>
                                        <input type="text" id="empNo" value=""  style="display: none"/>

										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>电话</span> <input id="telephone" name="telephone"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>上级部门</span> <select id="parentNo"
										name="parentNo" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>

									<li><span>部门职能</span> <input id="duty" name="duty"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>是否直营</span> <select id="directStatus"
										name="directStatus" type="text" disabled="disabled"
										class="ml20 data"><option value="0">否</option>
											<option value="1">是</option></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>传真</span> <input id="fax" name="fax" type="text"
										disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>所属公司</span> <select id="companyNo"
										name="companyNo" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>备注</span> <input id="comment" name="comment"
										type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>省</span> <select id="provinceNo"
										name="provinceNo" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div></li>

								</ul>
								<ul>
									<li><span>修改备注</span> <input id="editComment"
										name="editComment" type="text" disabled="disabled"
										class="ml20 data" />
										<div class="Validform_checktip"></div></li>
									<li><span>市</span> <select id="cityNo" name="cityNo"
										type="text" disabled="disabled" class="ml20 data"></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>是否测试</span>
                                        <select id="isTest" name="isTest" class="ml20 data"  disabled="disabled">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                        <div class="Validform_checktip"></div></li>
									<li><span>区</span> <select id="districtNo"
										name="districtNo" type="text" disabled="disabled"
										class="ml20 data"></select>
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
                                    <%-- <li>
										<span>部门图片路径</span> 
										<input id="departmentImagePath" name="departmentImagePath" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li> --%>
                                    <li style="position:relative;">
                                        <span class="mr20">部门图片路径</span>
                                        <a id="aEmpHead">
                                            <img alt="部门图片" id="emphead" class="ml20 emphead" src="" height="100" width="100">
                                        </a>
                                        <input type="hidden" id="departmentImagePath" name="departmentImagePath" />
                                        <div id="a"style="margin-left:200px;margin-top:-120px;"><div class="upload uploadW"> </div></div>
                                    </li>
									 <%-- <li>
										<span>地理位置图片路径</span> 
										<input id="locationImagePath" name="locationImagePath" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li> --%>
                                    <li style="position:relative;">
                                        <span class="mr20">地理位置图片路径</span>
                                        <a id="aEmpHead2">
                                            <img alt="地理位置图片" id="emphead2" class="ml20 emphead2" src="" height="100" width="100">
                                        </a>
                                        <input type="hidden" id="locationImagePath" name="locationImagePath" />
                                        <div id="b"style="margin-left:240px;margin-top:-120px;"><div class="upload uploadW"> </div></div>
                                    </li>

                                </ul>
<ul style="margin-top: 80px;">
<li>
										<span>部门地址</span> 
										<input id="address" name="address" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>经度</span> 
										<input id="longitude" name="longitude" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>纬度</span> 
										<input id="latitude" name="latitude" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
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
						</div>
					</li>
				</ul>
			</div>
		</div>
        ${pageVar}
    </m:Content>
</m:ContentPage>