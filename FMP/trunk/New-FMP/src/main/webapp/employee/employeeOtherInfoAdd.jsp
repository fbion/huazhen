<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<ul class="tab_content">
    <li class="tab_content1 tabContent" style="display: block;">
        <div class="basic_Info_content p15 info_All">
            <form id="employeeOtherInfoAdd">
                <ul>
                    <li>
                    	<span>开户行</span><input id="bankAddress" name="bankAddress" type="text" class="ml20 data" />

                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                    	<span>银行账号</span><input id="bankAccount" name="bankAccount" type="text" class="ml20 data" />
                        <div class="Validform_checktip"></div>
                    </li>
                </ul>
                <ul>
                    <li>
                    	<span>计算机水平</span><input id="computerLevel" name="computerLevel" type="text" class="ml20 data" />
                    </li>
                </ul>

                <ul>
                    <li>
                    	<span>入职时间</span><input id="startTime" name="startTime" type="text" class="ml20 data dateYMD" />
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                    	<span>工作经验</span><input id="workExperience" name="workExperience" type="text" class="ml20 data" />年
                        <div class="Validform_checktip"></div>
                    </li>
                </ul>
                <ul>
                    <li>
                    	<span>合同起始日期</span><input id="contractStartTime" name="contractStartTime" type="text" class="ml20 data dateYMD" />
                    </li>
                    <li>
                    	<span>合同到期日期</span><input id="contractEndTime" name="contractEndTime" type="text" class="ml20 data dateYMD" />
                    </li>
                </ul>
                <ul>
                    <li>
                    	<span>协议起始日期</span><input id="protocolStartTime" name="protocolStartTime" type="text" class="ml20 data dateYMD" />
                    </li>
                    <li>
                    	<span>协议到期日期</span><input id="protocolEndTime" name="protocolEndTime" type="text" class="ml20 data dateYMD" />
                    </li>
                </ul>
                <ul class="getCertificate">
                    <input name="id" type="text" style="display: none" />
                    <li>
                    	<span>任职资格证书</span><input name="credential" type="text" class="ml20 data certificate" />
                        <div class="Validform_checktip"></div>
                    </li>
                    <li>
                    	<span>获证日期</span><input name="credentialDate" type="text" class="ml20 data dateYMD certificate">
                        <div class="Validform_checktip"></div>
                        <input type="button" value="+" class="btn_style f16 data addCertificate" />
                    </li>
                </ul>
                <p id="btn" class="mt30">
                    <em id="showMsg" class='color'></em><em id="otherInfoMsg"></em>
                    <s:if test="showEditButton">
                        <input type="submit" id="otherInfoSubmit" value="保存" class="submit_Btn btn_style submit" />
                        <input type="button" id="otherInfoEdit" value="修改" class="submit_Btn btn_style edit" />
                    </s:if>
                    <input type="button" id="otherInfoBack" value="返回" class="submit_Btn btn_style back" />
                </p>
            </form>
        </div>
    </li>
</ul>