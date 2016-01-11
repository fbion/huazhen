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
                            <form id="fixedAssetsAdd" style="z-index:9999;">
                            <ul>
                                    <li>
										<span>采购单号</span> 
										<input id="registrationOrder" name="registrationOrder" type="text" disabled="disabled" class="ml20"/>
                                    </li>
<li>
										<span>资产类型</span> 
										<select id="type" name="type" class="ml20 d157"  disabled="disabled" ></select>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
										<span>供应商</span> 
										<select id="suppliersId" name="suppliersId" class="ml20 d157"  disabled="disabled" ></select>
                                    </li>
<li>
										<span>操作员</span> 
										<input id="operator" name="operator" type="text" disabled="disabled" class="ml20"/>
                                    </li>
                                    </li>
<li>
										<span>登记时间</span> 
										<input id="registrationDate" name="registrationDate" type="text" disabled="disabled" class="ml20"/>
                                    </li>
                                 	<li style="display:none;">
										<span>ID</span> 
										<input id="registrationId" name="registrationId" type="text" disabled="disabled" class="ml20"/>
                                    </li>

                                </ul>
                                <ul>
                                    <li>
										<span>分类</span> 
										<select id="assetType" name="assetType" disabled="disabled"  class="ml20 data d157"></select>
										
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>编号</span> 
										<input id="assetId" name="assetId" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>名称</span> 
										<input id="assetName" name="assetName" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>品牌</span> 
										<input id="brand" name="brand" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>型号</span> 
										<input id="model" name="model" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>CPU</span> 
										<input id="CPU" name="CPU" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>内存</span> 
										<input id="memory" name="memory" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>硬盘</span> 
										<input id="hardDisk" name="hardDisk" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>数量</span> 
										<input id="count" name="count" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>单价</span> 
										<input id="price" name="price" type="text" disabled="disabled" class="ml20 data"datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/" nullmsg="不能为空" errormsg="必须为数字，可以有小数"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>金额</span> 
										<input id="money" name="money" type="text" disabled="disabled" class="ml20 data" datatype="/^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/" nullmsg="不能为空" errormsg="必须为数字，可以有小数"/>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>存放位置</span> 
										<select id="location" name="location" disabled="disabled"  class="ml20 data d157"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>使用部门</span> 
   										<select id="department" name="department"  disabled="disabled"  class="ml20 data d157"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li>
										<span>使用人</span> 
										<!-- <input id="userNo" name="userNo" type="text" disabled="disabled" class="ml20 data"/> -->
										<select id="userNo" name="userNo"  disabled="disabled"  class="ml20 data d157"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>
<ul>
                                    <li>
										<span>状态</span> 
										<select id="status" name="status"  disabled="disabled"  class="ml20 data d157"></select>
                                        <div class="Validform_checktip"></div>
                                    </li>
<li  style="width:100%;">
										<span>备注</span> 
										<input id="editComment" name="editComment" type="text" disabled="disabled" class="ml20 data"/>
                                        <div class="Validform_checktip"></div>
                                    </li>

                                </ul>

                                <p id="btn" style="height:50px;">
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