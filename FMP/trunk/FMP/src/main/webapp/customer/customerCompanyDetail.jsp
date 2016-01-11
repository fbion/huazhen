<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">法人客户</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="customerCompanyDetail" style="z-index:9999;">
                             <ul>
                            <li><span class="fw">企业客户名</span><a id="name" name="name" class="ml20" target="_blank"></a></li>
                            <li><span class="fw">企业类型</span><a id="memberClassType" name="memberClassType" class="ml20" target="_blank"></a></li>
                            </ul>
                            <ul>
    		<li><span class="fw">营业执照</span><a id="cardLicense" name="cardLicense" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">组织机构代码</span><a id="cardNumber" name="cardNumber" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">法人姓名</span><a id="legal" name="legal" class="ml20" target="_blank"></a></li>
		<li><span class="fw">法人身份证</span><a id="legalIdcard" name="legalIdcard" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    				<li><span class="fw">税务证</span><a id="cardTax" name="cardTax" class="ml20" target="_blank"></a></li>
    				<li><span class="fw">开户银行许可证</span><a id="bankLicense" name="bankLicense" class="ml20" target="_blank"></a></li>
</ul>
<ul>
    		<li><span class="fw">公司地址</span><a id="address" name="address" class="ml20" target="_blank"></a></li>
		<li><span class="fw">公司固定电话</span><a id="telephone" name="telephone" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">公司邮箱</span><a id="email" name="email" class="ml20" target="_blank"></a></li>
		<li><span class="fw">所属行业</span><a id="field" name="field" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人姓名</span><a id="contactName" name="contactName" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人固定电话</span><a id="contactTelephone" name="contactTelephone" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">联系人手机1</span><a id="contactCellphone1" name="contactCellphone1" class="ml20" target="_blank"></a></li>
		<li><span class="fw">联系人手机2</span><a id="contactCellphone2" name="contactCellphone2" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">关系等级</span><a id="relationLevel" name="relationLevel" class="ml20" target="_blank"></a></li>
		<li><span class="fw">风险偏好</span><a id="riskHobby" name="riskHobby" class="ml20" target="_blank"></a></li>

</ul>
<ul>
		<li><span class="fw">新增时间</span><a id="findTime" name="findTime" class="ml20" target="_blank"></a></li>
		<li><span class="fw">负责人</span><a id="agentNo" name="agentNo" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">可配置资产</span><a id="wealth" name="wealth" class="ml20" target="_blank"></a>万元</li>
		<li><span class="fw">购买额度</span><a id="tradeTotal" name="tradeTotal" class="ml20" target="_blank"></a>元</li>

</ul>
<ul>
    		<li><span class="fw">修改备注</span><a id="editComment" name="editComment" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">是否测试</span><a id="isTest" name="isTest" class="ml20" target="_blank"></a></li>
</ul>
<ul>

		<li><span class="fw">p2p账户名</span><a id="p2pCustomerNo" name="p2pCustomerNo" class="ml20" target="_blank"></a></li>

</ul>
                                <ul style="display: none">
                                    		<li><span class="fw">来源类型</span><a id="sourceType" name="sourceType" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">企业编号</span><a id="code" name="code" class="ml20" target="_blank"></a></li>
		<li><span class="fw">证件类型</span><a id="cardType" name="cardType" class="ml20" target="_blank"></a></li>

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