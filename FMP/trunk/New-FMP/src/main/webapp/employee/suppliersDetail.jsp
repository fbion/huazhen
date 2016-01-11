<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">供应商管理</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="suppliersDetail" style="z-index:9999;">
                                <ul>
    		<li><span class="fw">供应商名称</span><a id="supplierName" name="supplierName" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人</span><a id="contactPerson" name="contactPerson" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系电话</span><a id="phone" name="phone" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系电话2</span><a id="phone2" name="phone2" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">邮箱</span><a id="mail" name="mail" class="ml20" target="_blank"></a></li>
		<li><span class="fw">供应商地址</span><a id="supplierAddr" name="supplierAddr" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">供应种类</span><a id="supplierType" name="supplierType" class="ml20" target="_blank"></a></li>
		<li><span class="fw">备注</span><a id="editComment" name="editComment" class="ml20" target="_blank"></a></li>

</ul>

                                <p id="btn">
                                    <em id="msg"></em>
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