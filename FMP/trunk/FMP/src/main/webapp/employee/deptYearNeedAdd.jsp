<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab mt20">
                <div class="tab_title">
                    <a href="javascript:;" class="active">部门年度需求管理</a>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1  tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="deptYearNeedAdd" method="post">
                                    <div class="tableCenter">
                                        <h5>
                                            <div class="DivSelects1">
                                                <select disabled="disabled" id="deptNo" class="SelectLists tc"
                                                        style="width:130px;"></select>
                                            </div>
                                            部门<input type="text" id="financialYear" class='tc data financialYear'/>年度人员需求计划表
                                            <div class="Validform_checktip"></div>
                                        </h5>
                                        <p>编号:<span style="border-bottom:1px solid #333;">
                                        <input type="text" class='tc data' id="code"/></span></p>
                                        <span class="position data"></span>
                                        <span id="positionList" class="data"></span>
                                        <table align="center" border="1" id="aduitComment"></table>
                                        <div id="btn" style="padding-top: 20px"><em id="msg"></em>
                                            <s:if test="showEditButton">
                                                <input id="submitExamine" type="button" value="提交审批" class="submit_Btn btn_style"/>
                                                <input id="edit" name="edit" type="button" value="修改"
                                                       class="submit_Btn none btn_style"/>
                                                <input id="submit" name="submit" type="submit" value="保存"
                                                       class="submit_Btn none btn_style"/>
                                            </s:if>
                                            <s:if test="showExamineButton">
                                                <input id="examine"  type="button" value="审批" class="submit_Btn btn_style"/>
                                            </s:if>
                                            <input id="back" name="back" type="button" value="返回"
                                                   class="cancel_Btn btn_style"/>
                                        </div>
                                            ${pageVar}
                                    </div>
                                <div class="trackBtn"></div>
                                <div id="w1" class="easyui-window" title="年度需求表审批"
                                     data-options="modal:true,closed:true,iconCls:'icon-save'"
                                     style="width:500px;height:200px;padding:10px;">
                                    <div>
                                        <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>

                                        <div data-options="region:'south',border:false"
                                             style="text-align:right;padding:5px 0 0;">
                                            <input id="submit1" name="submit" type="submit" value="通过"
                                                   class="submit_Btn  btn_style examine"/>
                                            <input id="submit2" name="" type="submit" value="不通过"
                                                   class="submit_Btn  btn_style examine"/>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </m:Content>
</m:ContentPage>