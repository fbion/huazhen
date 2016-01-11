<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="detail mt20 -pl20 pb30">
			<div class="tab">

				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display:block;">
						<div class="basic_Info_content p15 info_All screendraw">
							<form id="drawSettingAdd" style="z-index:9999;">
							<ul>
								<li><span>轮　　次：</span> <select id="round" class="ml20 data"  disabled="disabled"></select>
									<div class="Validform_checktip"></div></li>
								<li><span>奖　　项：</span> <input id="drawAwards"
									name="drawAwards" type="text" disabled="disabled"
									class="ml20 data" />
									<div class="Validform_checktip"></div><p  style="color: #ab1e1e" ></p> </li>
							</ul>
							<ul>
								<li><span>抽奖人数：</span> <input id="drawNumber"
									name="drawNumber" type="text" disabled="disabled"
									class="ml20 data" value="" /><div class="Validform_checktip"></div><p  style="color: #ab1e1e" ></li>
							</ul>

							<!-- 中奖列表  -->
							<table id="dg" title="对应债权" class="easyui-datagrid "
								style="width:700px;height:250px"
								url="" toolbar="#toolbar"
								rownumbers="true" fitColumns="true" singleSelect="true">
								<thead>
									<div id="toolbar">
										<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="addDrawUser">添加内定中奖人</a>
										<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="ManagePage.destroyUser()">删除人员</a>
										<div class="Validform_checktip"></div>
										<input  type="hidden" id="hidUserIdList" name="hidUserIdList" value='${checkValue}' >
										<input type="hidden" id="hidRoundSetting" name="hidRoundSetting" value='${hidRoundSetting}' >
										<%-- <input type="hidden" id="hidselSetting" name="hidselSetting" value='${hidselSetting}' > --%>
										
										
									</div>
								</thead>
							</table>
							<!-- 添加人员对话  -->
							<div id="dlg" class="easyui-dialog" closed="true"
								style="width:700px;height:500px;padding:20px 20px;" closed="false">
										<input id="inputNameSearch"  >
										 <input id="searchUser" type="submit" class="btn_style" value="搜索 " /><p id="drawTip" style="color: #ab1e1e" ></p>
										<p>
											 <input id="addSelctUser" type="button" class="btn_style" value="添加 " />
											 <ul class="mt20" id="reservation">  </ul>
							</div>
							
							<!-- 添加人员对话  -->
                            <div class="twoaddbtns">
                                <input type="button" id="edit" value="修改" style="display: none;" class="submit_Btn none btn_style"/>       
								<input id="drawSettingAddBtn" type="submit"style="display: none;"  value="保存"  class="btn_style"/>
								<input id="back" type="button" value="取消"  class="btn_style"/>
                            </div>
							</form>
						</div>
					</li>
				</ul>
			</div>
		</div>
        ${pageVar}
    </m:Content>
</m:ContentPage>

