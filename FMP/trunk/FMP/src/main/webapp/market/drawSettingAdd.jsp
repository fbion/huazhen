<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

<m:ContentPage materPageId="layout">
	<m:Content contentPlaceHolderId="center">
		<div class="detail mt20 -pl20 pb30">
			<div class="tab">
				
				<ul class="tab_content">
					<li class="tab_content1  tabContent" style="display:block;">
						<div class="basic_Info_content p15 info_All">
							<!-- <form id="drawSettingAdd" style="z-index:9999;"> -->
								<ul>
									<li><span>轮次</span> <select id="selRound"></select>
										<div class="Validform_checktip"></div></li>
									<li><span>奖项</span> <input id="drawAwards" name="drawAwards" type="text" disabled="disabled" class="ml20 data" />
										<div class="Validform_checktip"></div></li>
								</ul>
								<ul>
									<li><span>抽奖人数</span> <input id="drawNumber" name="drawNumber" type="text" disabled="disabled" class="ml20 data" />
								    </li>
								</ul>

								<p id="btn">
									<s:if test="showSubmitButton">
										<input type="submit" id="submit" value="保存" class="submit_Btn none btn_style" />
									</s:if>
								</p>
								<p id="btn">
									内定中奖人：<input type="submit" id="addContentUser" value="添加" class="btn_style" />
								</p>
							<!-- </form> -->

							<table id="dg" title="内定中奖人" class="easyui-datagrid "
								style="width:700px;height:250px" url="" toolbar="#toolbar"
								rownumbers="true" fitColumns="true" singleSelect="true">
								<thead>
									<tr>
										<th field="creditorName" width="50">头像</th>
										<th field="money" width="50">用户名</th>
									</tr>
								</thead>
							</table>
							<div id="toolbar">
								<a href="javascript:void(0)" class="easyui-linkbutton"
									iconCls="icon-add" plain="true"
									onclick="SalesDetailForP2pProduct.newUser()">添加</a>

								<!--               新增用户层开始                     activityUsers -->
								<div id="dlg" class="easyui-dialog"
									style="width:400px;height:280px;padding:10px 20px"
									closed="true" buttons="#dlg-buttons">

									<input id="inputNameSearch"> <input id="searchUser"
										type="button" class="btn_style" value="搜索 " />
									<p>
										<input type="checkbox" /> 全选 <input id="ckAllUser"
											type="button" class="btn_style" value="添加 " />

										<s:iterator value="#request.activityUsers" id="item">
											<li class="bd borderBott"><span class="span8"> <input
													type="checkbox" value="<s:property value="#item.id"/>"
													name="ckUser" />
											</span> <span class="span8"> <s:property
														value="#item.userName" />
											</span> <span class="span8"> <s:property value="#item.name" />
											</span></li>
										</s:iterator>
								</div>

								<div id="dlg-buttons">
									<a href="javascript:void(0)" class="easyui-linkbutton c6"
										iconCls="icon-ok"
										onclick="SalesDetailForP2pProduct.saveUser()"
										style="width:90px">保存 </a> <a href="javascript:void(0)"
										class="easyui-linkbutton" iconCls="icon-cancel"
										onclick="javascript:$('#dlg').dialog('close')"
										style="width:90px">取消</a>
								</div>
								<!--               新增用户层结束                                   -->

							</div>


						</div>
					</li>
				</ul>
			</div>
		</div>
        ${pageVar}
    </m:Content>
</m:ContentPage>

