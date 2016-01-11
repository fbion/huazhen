<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">

            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">员工信息</a><s:if test="showCommonView"><a
                        href="javascript:void(0)">个人信息登记表</a></s:if><s:if test="showCommonView"><a
                        href="javascript:void(0)">员工其他信息</a></s:if>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1 tabContent" style="display: block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="employeeAdd">
                                <ul>
                                    <li><span class="span1">姓名<em class='color'>*</em></span> <input
                                            id="name" name="name" type="text" class="ml20 data name"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li style="position:relative;">
                                        <span class="span1"></span>
                                        <a id="aEmpHead">
                                            <img alt="员工头像" id="emphead" class="ml20 emphead" src="" height="100" width="100">
                                        </a>
                                        <input type="hidden" id="portraitPath" name="portraitPath" />
                                        <div class="upload uploadW"> </div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span class="span1">状态</span>
                                        <select id="status" name="status" class="ml20 data">
                                        </select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">编号</span> <input id="code" name="code"
                                                                             type="text" class="ml20 code"/></li>
                                    <li></li>
                                </ul>
                                <ul>
                                    <li><span class="span1">性别</span> <select id="sex" name="sex"
                                                                              class="ml20 data sex">
                                    </select></li>
                                    <li><span class="span1">公司邮箱</span> <input id="email" name="email"
                                                                             type="text" class="ml20 data email"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">微信</span> <input id="weixin" name="weixin"
                                                                             type="text" class="ml20 data weixin"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span class="span1">QQ</span> <input id="qq" name="qq" type="text"
                                                                             class="ml20 data qq"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">电话</span> <input id="telephone" name="telephone"
                                                                             type="text" class="ml20 data telephone"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span class="span1">手机1</span> <input id="cellphone1"
                                                                              name="cellphone1" type="text"
                                                                              class="ml20 data cellphone1">

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">手机2</span> <input id="cellphone2"
                                                                              name="cellphone2" type="text"
                                                                              class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span class="span1">住址</span> <input id="address" name="address"
                                                                             type="text" class="ml20 data address"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">公司</span> <select id="companyNo"
                                                                              name="companyNo"
                                                                              class="ml20 data"></select>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span class="span1">婚姻</span> <select id="marry" name="marry"
                                                                              class="ml20 data marry">
                                    </select>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">部门</span> <select id="deptNo" name="deptNo"
                                                                              class="ml20 data"></select>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li><span class="span1">职位</span> <select id="positionNo"
                                                                              name="positionNo"
                                                                              class="ml20 data"></select>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li style="visibility: hidden"><span class="span1">部门类型</span> <select
                                            id="deptType" name="deptType" class="ml20"></select></li>
                                    <li><span class="span1">职称</span> <input id="positionTitle"
                                                                             name="positionTitle" class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">员工上级</span>
                                        <input id="employeeSel" type="text" value="" class="ml20 data" disabled="disabled"/>
                                        <input type="text" id="parentNo" value=""  style="display: none"/>
                                        <%--<select id="parentNo"--%>
                                                                                <%--name="parentNo"--%>
                                                                                <%--class="ml20 data"></select>--%>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                            <%-- <span>职级</span> <select id="position_level_no"
                                            name="position_level_no" class="ml20">
                                        </select>
                                            <div class="Validform_checktip"></div> --%>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">新建用户<em class='color'>*</em></span> <input
                                            id="sysUser" name="user_no" class="ml20"/>

                                        <div id="errorMsg" class="Validform_checktip"></div>
                                    </li>
                                    <li><span class="span1">系统用户</span> <select id="userNo" name="userNo"
                                                                                class="ml20 data"/></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li><span class="span1">新建密码<em class='color'>*</em></span> <input
                                            id="sysPwd" type="text" name="pwd" class="ml20" />

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li></li>
                                </ul>
                                <ul>
                                    <li><span class="span1">是否测试</span> <select id="isTest" name="isTest"
                                                                                class="ml20 data">
                                        <option value="0">否</option>
                                        <option value="1">是</option>
                                    </select>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <div style="margin-left: 43px">
                                    <span style="vertical-align:top" class="span1">修改备注</span>
                                    <textarea id="description" name="description" cols="109"
                                              rows="5" class="ml20 data"></textarea>
                                    <br/> <br/> <br/> <br/> <br/>

                                    <p id="btn">
                                        <em id="showMsg" class='color'></em><em id="msg"></em>
                                        <s:if test="showEditButton">
                                            <input type="submit" id="submit" value="保存" class="submit_Btn btn_style submit"/>
                                            <input type="button" id="edit" value="修改" class="submit_Btn btn_style edit"/>
                                        </s:if>
                                        <s:if test="showSubmitButton">
                                            <input type="button" id="submitCheck" value="提交审核" class="btn_style"/>
                                        </s:if>
                                        <s:if test="showCheckButton">
                                            <input type="button" id="checkOk" value="审核通过" class="btn_style "/>
                                            <input type="button" id="checkFailed" value="审核失败" class="btn_style"/>
                                        </s:if>
                                        <input type="button" id="goBack" value="返回" class="submit_Btn btn_style back"/>
                                    </p>
                                </div>
                            </form>
                        </div>
                    </li>
                    <s:if test="showCommonView">
                        <li class="tab_content2 tabContent"><s:include
                                value="employeeDetailAdd.jsp"></s:include></li>
                    </s:if>
                    <s:if test="showCommonView">
                        <li class="tab_content3 tabContent"><s:include
                                value="employeeOtherInfoAdd.jsp"></s:include></li>
                    </s:if>
                </ul>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>