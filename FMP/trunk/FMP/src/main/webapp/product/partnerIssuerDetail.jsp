<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">产品发行方</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="partnerIssuerDetail" style="z-index:9999;">
                                <ul>
    		<li><span class="fw">机构编码</span><a id="code" name="code" class="ml20" target="_blank"></a></li>
		<li><span class="fw">机构类型</span><a id="type" name="type" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">机构名称</span><a id="name" name="name" class="ml20" target="_blank"></a></li>
		<li><span class="fw">法人代表</span><a id="owner" name="owner" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人</span><a id="contactPrimary" name="contactPrimary" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人职位</span><a id="contactPosition" name="contactPosition" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">负责人</span><a id="empNo" name="empNo" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人手机1</span><a id="contactCellphone1" name="contactCellphone1" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人手机2</span><a id="contactCellphone2" name="contactCellphone2" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人固话</span><a id="contactTelephone" name="contactTelephone" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人微信</span><a id="contactWeixin" name="contactWeixin" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人QQ</span><a id="contactQq" name="contactQq" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">机构网址</span><a id="website" name="website" class="ml20" target="_blank"></a></li>
		<li><span class="fw">机构地址</span><a id="address" name="address" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">关系等级</span><a id="relationLevel" name="relationLevel" class="ml20" target="_blank"></a></li>
		<li><span class="fw">重要程度</span><a id="importanceLevel" name="importanceLevel" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">机构邮箱</span><a id="email" name="email" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">是否发行机构</span><a id="isIssuer" name="isIssuer" class="ml20" target="_blank"></a></li>
</ul>
<ul>
		<li><span class="fw">是否销售代理</span><a id="isAgent" name="isAgent" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">修改备注</span><a id="editComment" name="editComment" class="ml20" target="_blank"></a></li>
</ul>
<ul>
    				<li><span class="fw">发行机构简介</span><a id="comment" name="comment" class="ml20" target="_blank"></a></li>
		<li><span class="fw">是否测试</span><a id="isTest" name="isTest" class="ml20" target="_blank"></a></li>

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