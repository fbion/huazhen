<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">员工津贴</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="subsidyTotalAdd" style="z-index:9999;">
                                <ul>
									<li>
										<span>所属部门</span> 
										<select id="deptNo" name="deptNo" type="text" disabled="disabled" class="ml20 data"></select>


                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
										<span>员工职位</span>

										<select id="positionNo" name="positionNo" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                            	<ul>
                            		<li>
										<span>员工姓名</span>
                                        <select id="empNo" name="empName" type="text" disabled="disabled" class="ml20 data"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                               		<li>
										<span>员工编号</span> 
										<input id="empNo1" name="empNo" type="text" disabled="disabled" class="ml20" value="${empNo}"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                
                                 
								<%-- <ul>
									<li>
										<span>津贴比例(%)</span> 
										<input id="subsidyScale" name="subsidyScale" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                
                                    <li>
										<span>销售总额(万元)</span> 
										<input id="salesMoney" name="salesMoney" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                 </ul> --%>
								 <ul>
									<li>
										<span>津贴(元)</span> 
										<input id="subsidy" name="subsidy" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                
                                    <li>
										<span>获得时间</span> 
										<input id="achieveTime" name="achieveTime" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                 </ul>
                                 <ul>
									<li>
										<span>状态</span> 
										<input id="isExamine" name="isExamine" type="text" disabled="disabled" class="ml20" value="新建"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                 </ul>

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