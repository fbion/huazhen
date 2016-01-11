<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="newLayout">
    <m:Content contentPlaceHolderId="center">

        <div id="toolbar">
            <div>
                <label>客户姓名:</label>
                <input id="name" class="easyui-searchbox" data-options="prompt:'',searcher:CustomerPersonalList.InitQuery"/>
                <label>客户来源:</label>
                <input id="sourceType" class="easyui-combobox" data-options="prompt:'',searcher:CustomerPersonalList.InitQuery"/>
                <label>手机号:</label>
                <input id="cellphone" class="easyui-searchbox" data-options="prompt:'',searcher:CustomerPersonalList.InitQuery"/>
                <label>关系等级:</label>
                <input id="relationLevel" class="easyui-combobox" data-options="prompt:'',searcher:CustomerPersonalList.InitQuery"/>
                <label>偏好</label>:</label>
                <input id="riskHobby" class="easyui-combobox" data-options="prompt:'',searcher:CustomerPersonalList.InitQuery"/>
                <label>负责人:</label>
                <input id="employeeSel" type="text" value="" class="w80 rounded"/>
                <input type="text" id="agentNo" style="display: none"/>
                <label>新增时间:</label>
                <input id="startTime" class="wdate rounded"/>--
                <input id="endTime" class="wdate rounded"/>
                <br />
                <label>跟踪结果:</label>
                <input id="resultStatus" class="easyui-combobox" data-options="prompt:'',searcher:CustomerPersonalList.InitQuery"/>
                <label>是否打款:</label>
                <input id="isSales" class="easyui-combobox" data-options="prompt:'',searcher:CustomerPersonalList.InitQuery"/>
                <a id="btnSearch" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                <s:if test="showExcelButton">
                    <a id="btnExcel" href="javascript:void(0)" class="easyui-linkbutton" iconCls="">导出</a>
                </s:if>


            </div>

            <s:if test="showAddButton">
                <a id="btnAdd" href="javascript:void(0)" class="easyui-linkbutton" text="New" data-options="iconCls:'icon-add',plain:true"></a>
            </s:if>
            <s:if test="showEditButton">
                <a id="btnEdit" href="javascript:void(0)" class="easyui-linkbutton" text="Edit" data-options="iconCls:'icon-edit',plain:true"></a>
            </s:if>
            <s:if test="showDetailButton">
                <a id="btnDetail" href="javascript:void(0)" class="easyui-linkbutton" text="Detail" data-options="iconCls:'icon-remove',plain:true"></a>
            </s:if>
            <s:if test="establishP2pUser">
                <a id="establishP2pUser" href="javascript:void(0)" class="easyui-linkbutton" text="创建网站客户" data-options="iconCls:'icon-man',plain:true"></a>
            </s:if>

            <s:if test="showUpdateManagerNo">
                <a id="btnChangeManager" href="javascript:void(0)" class="easyui-linkbutton" text="修改负责人" data-options="iconCls:'icon-man',plain:true"></a>
           </s:if>
        </div>
        <table id="gridTable"></table>
        <div id="w1" class="easyui-window mt200" title="根据记录" data-options="closed:true,iconCls:'icon-save'" style="width:800px;height:400px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <table border="1" cellpadding="0" cellspacing="0" class="accordrecord">
                        <thead>
                            <tr>
                                <th width="180" valign="center" align="center">推荐产品</th>
                                <th width="70" valign="center" align="center" >跟踪类型</th>
                                <th width="80" valign="center" align="center" >跟踪时间</th>
                                <th width="80" valign="center" align="center" >下次跟踪</th>
                                <th width="220" valign="center" align="center" >跟踪内容</th>
                                <th width="130" valign="center" align="center" >跟踪结果</th>
                            </tr>
                        </thead>
                        <tbody id="followList">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="w" class="easyui-window mt200" title="客户分配" data-options="closed:true,iconCls:'icon-save'" style="width:800px;height:400px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'" style="padding:10px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="42%">
                                <span id="id" hidden="hidden" ></span>
                                <div class="list_tit">&nbsp;离职下属的客户</div>
                                <select  id="empStatus0" style="width: 100%">
                                </select>
                            </td>
                            <td width="15%">&nbsp;</td>
                            <td width="43%">
                                <div class="list_tit">&nbsp;在职下属的客户</div>
                                <select id="empStatus1" style="width: 100%">
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <select  id="empStatus0CustomerList"  size="20" style="width: 100%" multiple="multiple">
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
                                <select id="empStatus1CustomerList" name="destList" size="20" multiple="multiple"  style="width: 100%">
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <span id="" style="width:80px"></span>
                    <a class="easyui-linkbutton" id="ok"  style="width:80px">确定</a>
                    <a class="easyui-linkbutton"  href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>
