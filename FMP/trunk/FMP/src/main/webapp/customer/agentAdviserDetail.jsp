<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">兼职投顾</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="agentAdviserDetail" style="z-index:9999;">
                                <ul>
    		<li style="display: none"><span class="fw">编号</span><a id="code" name="code" class="ml20" target="_blank"></a></li>
		<li><span class="fw">姓名</span><a id="name" name="name" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">邮箱</span><a id="email" name="email" class="ml20" target="_blank"></a></li>
		<li><span class="fw">微信</span><a id="weixin" name="weixin" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">QQ</span><a id="qq" name="qq" class="ml20" target="_blank"></a></li>
		<li><span class="fw">手机1</span><a id="cellphone1" name="cellphone1" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">手机2</span><a id="cellphone2" name="cellphone2" class="ml20" target="_blank"></a></li>
		<li><span class="fw">电话</span><a id="telephone" name="telephone" class="ml20" target="_blank"></a></li>

</ul>
<ul>
		<li><span class="fw">公司</span><a id="company" name="company" class="ml20" target="_blank"></a></li>
		    		<li><span class="fw">职位</span><a id="position" name="position" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">累计销售额</span><a id="saleTotal" name="saleTotal" class="ml20" target="_blank"></a></li>
		<li><span class="fw">个人住址</span><a id="address" name="address" class="ml20" target="_blank"></a></li>

</ul>
<ul>
		<li><span class="fw">关系等级</span><a id="relationLevel" name="relationLevel" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">信息来源</span><a id="sourceType" name="sourceType" class="ml20" target="_blank"></a></li>
</ul>
<ul>
    		<li><span class="fw">负责人</span><a id="managerNo" name="managerNo" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">是否测试</span><a id="isTest" name="isTest" class="ml20" target="_blank"></a></li>
</ul>
<ul  style="display: none">
    				<li><span class="fw">修改备注</span><a id="editComment" name="editComment" class="ml20" target="_blank"></a></li>
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