<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="wrappSearch mt30">
            <h3></h3> 
            <div class="wrappSearchContent">
                ####todo
                <input id="btnSearch" type="button" value="查询" class="btn_style"/>
            </div>
        </div>
        <p class="mt50"> 
			<s:if test="showAddButton">
                <input type="button" id="btnAdd" value="新建" class="btn_style"/>
            </s:if><</p>
        <div class="pic mt20">
            <table id="gridTable" class="gridTable">
            </table>
            <div id="gridPager" class="gridPager">
            </div>
        </div>
        	<!-- 用户组分配 -->
					<div id="w" class="easyui-window" title="流程用户组分配" data-options="closed:true" style="width:800;height:400px;padding:5px;">
						<div class="easyui-layout" data-options="fit:true">
							<div data-options="region:'center'" style="padding:10px;">
												<table width="100%" border="0" cellspacing="0" cellpadding="0">
													<tr>
														<td width="42%">
															<span id="id" hidden="hidden" ></span>
															<div class="list_tit"><span id="userName" ></span>&nbsp;未分用户组列表</div>
														</td>
														<td width="15%">&nbsp;</td>
														<td width="43%">
															<div class="list_tit"><span id="userName1" ></span>&nbsp;已分配用户组列表</div>
														</td>
													</tr>
													<tr>
														<td>
															<select size="20"  id="unAssignGroupList" style="width: 100%" multiple="multiple">
															</select>
														</td>
														<td>
															<p align="center">
																<input type="button" name="Submit1" id="leftToRigth" value="&gt;&gt;"  />
															</p>
															<p align="center">
																<input type="button" name="Submit2" id="rigthToLeft" value="&lt;&lt;" />
															</p>
														</td>
														<td>
															<select name="destList" size="20" multiple="multiple" id="assignGroupList" style="width: 100%">
															</select>
														</td>
													</tr>
												</table>
							</div>
							<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
								<span id="message" style="width:80px"></span>
								<a class="easyui-linkbutton"  href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">关闭</a>
							</div>
						</div>
					</div> 
    </m:Content>
</m:ContentPage>
