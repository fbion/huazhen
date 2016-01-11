<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">个人融资方</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="financierPersonalDetail" style="z-index:9999;">
                                <ul>
    		<li><span class="fw">委托人编号</span><a id="code" name="code" class="ml20" target="_blank"></a></li>
		<li><span class="fw">委托人</span><a id="name" name="name" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">性别</span><a id="sex" name="sex" class="ml20" target="_blank"></a></li>
		<li><span class="fw">邮箱</span><a id="email" name="email" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">微信</span><a id="weixin" name="weixin" class="ml20" target="_blank"></a></li>
		<li><span class="fw">QQ</span><a id="qq" name="qq" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">手机1</span><a id="cellphone1" name="cellphone1" class="ml20" target="_blank"></a></li>
		<li><span class="fw">手机2</span><a id="cellphone2" name="cellphone2" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">固话</span><a id="telephone" name="telephone" class="ml20" target="_blank"></a></li>
		<li><span class="fw">住址</span><a id="address" name="address" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">年龄</span><a id="age" name="age" class="ml20" target="_blank"></a></li>
		<li><span class="fw">婚姻</span><a id="marry" name="marry" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">公司</span><a id="company" name="company" class="ml20" target="_blank"></a></li>
		<li><span class="fw">融资需求额度</span><a id="money" name="money" class="ml20" target="_blank"></a></li>

</ul>
<ul>
		<li><span class="fw">负责人</span><a id="managerNo" name="managerNo" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">融资需求时间</span><a id="requiretime" name="requiretime" class="ml20" target="_blank"></a></li>

</ul>

<ul>
			<li><span class="fw">是否测试</span><a id="isTest" name="isTest" class="ml20" target="_blank"></a></li>
    		<li><span class="fw">修改备注</span><a id="editComment" name="editComment" class="ml20" target="_blank"></a></li>
</ul>
<ul>
    		<li style="display: none"><span class="fw">protocolNo</span><a id="protocolNo" name="protocolNo" class="ml20" target="_blank"></a></li>
		<li><span class="fw">融资需求描述</span><a id="requireComment" name="requireComment" class="ml20" target="_blank"></a></li>
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