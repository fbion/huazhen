<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">销售代理商</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="agentBusinessDetail" style="z-index:9999;">
                                <ul>
    		<li style="display: none"><span class="fw">企业编号</span><a id="code" name="code" class="ml20" target="_blank"></a></li>
		<li><span class="fw">企业名称</span><a id="name" name="name" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">企业邮箱</span><a id="email" name="email" class="ml20" target="_blank"></a></li>
		<li><span class="fw">企业电话</span><a id="telephone" name="telephone" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">法人代表</span><a id="owner" name="owner" class="ml20" target="_blank"></a></li>
		<li><span class="fw">企业网址</span><a id="website" name="website" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">企业地址</span><a id="address" name="address" class="ml20" target="_blank"></a></li>
		<li><span class="fw">主要联系人</span><a id="contactPrimary" name="contactPrimary" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人职位</span><a id="contactPosition" name="contactPosition" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人微信</span><a id="contactWeixin" name="contactWeixin" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人QQ</span><a id="contactQq" name="contactQq" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人手机1</span><a id="contactCellphone1" name="contactCellphone1" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人手机2</span><a id="contactCellphone2" name="contactCellphone2" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人电话</span><a id="contactTelephone" name="contactTelephone" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人住址</span><a id="contactAddress" name="contactAddress" class="ml20" target="_blank"></a></li>
		<li><span class="fw">重要程度</span><a id="contactImportance" name="contactImportance" class="ml20" target="_blank"></a></li>

</ul>
<ul>
		<li><span class="fw">关系等级</span><a id="relationLevel" name="relationLevel" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">信息来源</span><a id="sourceType" name="sourceType" class="ml20" target="_blank"></a></li>
</ul>
<ul>
		<li><span class="fw">负责人</span><a id="managerNo" name="managerNo" class="ml20" target="_blank"></a></li>
				<li><span class="fw">是否测试</span><a id="isTest" name="isTest" class="ml20" target="_blank"></a></li>
</ul>
<ul style="display: none">
    		<li><span class="fw">累计销售额</span><a id="saleTotal" name="saleTotal" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">修改备注</span><a id="editComment" name="editComment" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">企业描述</span><a id="comment" name="comment" class="ml20" target="_blank"></a></li>
</ul>

                                <p id="btn" class="mt50">
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