<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 -pl20 pb30">
            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:;" class="active">固定资产管理</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="fixedAssetsDetail" style="z-index:9999;">
                            <ul>
    		<li><span class="fw">采购单号</span><a id="registrationOrder" name="registrationOrder" class="ml20" target="_blank"></a></li>
		<li><span class="fw">资产类型</span><a id="type" name="type" class="ml20" target="_blank"></a></li>
</ul>
<ul>
    		<li><span class="fw">供应商</span><a id="suppliersId" name="suppliersId" class="ml20" target="_blank"></a></li>
		<li><span class="fw">操作员</span><a id="operator" name="operator" class="ml20" target="_blank"></a></li>
		<li><span class="fw">登记时间</span><a id="registrationDate" name="registrationDate" class="ml20" target="_blank"></a></li>
</ul>
                                <ul>
    		<li><span class="fw">分类</span><a id="assetType" name="assetType" class="ml20" target="_blank"></a></li>
		<li><span class="fw">编号</span><a id="assetId" name="assetId" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">名称</span><a id="assetName" name="assetName" class="ml20" target="_blank"></a></li>
		<li><span class="fw">品牌</span><a id="brand" name="brand" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">型号</span><a id="model" name="model" class="ml20" target="_blank"></a></li>
		<li><span class="fw">CPU</span><a id="CPU" name="CPU" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">内存</span><a id="memory" name="memory" class="ml20" target="_blank"></a></li>
		<li><span class="fw">硬盘</span><a id="hardDisk" name="hardDisk" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">数量</span><a id="count" name="count" class="ml20" target="_blank"></a></li>
		<li><span class="fw">单价</span><a id="price" name="price" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">金额</span><a id="money" name="money" class="ml20" target="_blank"></a></li>
		<li><span class="fw">存放位置</span><a id="location" name="location" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">使用部门</span><a id="department" name="department" class="ml20" target="_blank"></a></li>
		<li><span class="fw">使用人</span><a id="userNo" name="userNo" class="ml20" target="_blank"></a></li>

</ul>
<ul>
    		<li><span class="fw">状态</span><a id="status" name="status" class="ml20" target="_blank"></a></li>
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