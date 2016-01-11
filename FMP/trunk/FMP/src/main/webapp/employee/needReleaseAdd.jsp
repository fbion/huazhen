<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">招聘需求发布</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="needReleaseAdd" style="z-index:9999;">
                                <ul>
                                    <li>
										<span>分公司</span> 
                                         <select id="companyNo"	name="companyNo" disabled="disabled" 
										class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>部门</span>
                                        <%--<input id="employeeSel" type="text" value="" class="w80"/>--%>
                                        <%--<input type="text" id="deptNo" style="display: none"/>--%>
					                    <select  class='ml20 data' id="deptNo" disabled="disabled" style="width:130px;"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
                                    <li>
										<span>职位</span> 
					                     <select class='ml20 data' disabled="disabled" id="positionNo" ></select>
                                         <div class="Validform_checktip"></div>
                                    </li>
									<li>
										<span>需加人数</span> 
										<input id="addEmp" name="addEmp" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
								<ul>
									<li>
										<span>到岗时间</span> 
										<input id="workTime" name="workTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ol class="mt5">
                                    <li>
										<span>岗位职责</span> 
										 <textarea rows="18" cols="60"  id="workProperty" name="workProperty" disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
								</ol>
                                <ol>
                                    <li>
										<span>人员需求</span> 
										 <textarea rows="30" cols="60" id="empRequire" name="empRequire" disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                             	<ol>
									<li>
										<span>备注</span> 
                                       <textarea rows="13" cols="60" id="mark" name="mark" disabled="disabled" class="ml20 data"></textarea>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ol>
                                <p id="btn">
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
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>