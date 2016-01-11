<%--
  Created by IntelliJ IDEA.
  User: paul
  Date: 15-1-15
  Time: 上午9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">

            <div class="tab">
                <div class="tab_title">
                    <a href="javascript:void(0);" class="active">基本信息</a><s:if test="showCommonView"><a
                        href="javascript:void(0)">视频上传</a></s:if>
                </div>
                <ul class="tab_content">
                    <li class="tab_content1 tabContent" style="display:block;">
                        <div class="basic_Info_content p15 info_All">
                            <form id="p2pProductAdd">
                                <ul>
                                    <li>
                                        <span>产品</span>
                                        <select id="productNo" name="productNo" class="ml20 data dis"></select>
                                    </li>
                                    <li>
                                        <span>产品名称</span>
                                        <input id="name" name="name" type="text" class="ml20 data dis"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>收益<em class='color'>*</em></span>
                                        <input id="income" name="income" type="text" class="ml20 data"/>&nbsp;%
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>浮动收益</span>
                                        <input id="floatingIncome" name="floatingIncome" type="text" class="ml20 data"/>&nbsp;%
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>总额度</span>
                                        <input id="totalAmout" name="totalAmout" type="text" class="ml20 data dis"/>&nbsp;元
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>剩余额度</span>
                                        <input id="remainAmout" name="remainAmout" type="text" class="ml20 data">&nbsp;元
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>优先级</span>
                                        <input id="level" name="level" type="text" class="ml20 data"/>&nbsp;

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>打款个数</span>
                                        <input id="orderCount" name="orderCount" type="text" class="ml20" disabled="disabled"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>项目期限</span>
                                        <input id="duration" name="duration" type="text" class="ml20 data"/>天

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>状态</span>
                                        <select id="status" name="status" class="ml20 data"></select>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>成立日期<em class='color'>*</em></span>
                                        <input id="start" name="start" type="text" class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>债权到期日<em class='color'>*</em></span>
                                        <input id="end" name="end" type="text" class="ml20 data"/>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>起步价</span>
                                        <input id="minMoney" name="minMoney" type="text" class="ml20 data dis"/>元

                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>付息方式<em class='color'>*</em></span>
                                        <select id="repaymentIssue" name="repaymentIssue" class="ml20 data">
                                        </select>
                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <span>新增时间<em class='color'>*</em></span>
                                        <input id="inTime" name="inTime" class="ml20 data" />
                                        <div class="Validform_checktip"></div>
                                    </li>
                                    <li>
                                        <span>测试产品</span>
                                        <select id="isTest" name="isTest" class="ml20 data">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>

                                        <div class="Validform_checktip"></div>
                                    </li>
                                </ul>
                                <span class="mt20" style="display:block; line-height: 30px; margin-left: 40px;">产品描述</span>
                                <textarea id="description" name="description" cols="128" rows="5" class="ckeditor"></textarea>
                                <span class="mt20" style="display:block; line-height: 30px; margin-left: 40px;">产品合同</span>
                                <textarea id="contract" name="contract" cols="128" rows="5" class="ckeditor"></textarea>
                                <span class="mt20" style="display:block; line-height: 30px; margin-left: 40px;">产品优势</span>
                                <textarea id="productAdvantage" name="productAdvantage" cols="128" rows="5" class="ckeditor"></textarea>

                                <p id="btn"><em id="msg"></em>
                                    <em id="msg"></em>
                                    <s:if test="showEditAmount">
                                        <input type="button" id="editAmout" value="修改产品额度" class="submit_Btn  none btn_style"/>
                                        <input type="button" id="submitAmout" value="保存" class="submit_Btn  none btn_style"/>
                                    </s:if>

                                    <s:if test="showExamineButton">
                                        <input id="examine"  type="button" value="审批" class="examine submit_Btn btn_style"/>
                                    </s:if>

                                    <s:if test="showEditButton">
                                        <input type="button" id="commitCheck" value="提交审核" class="submit_Btn  none btn_style"/>
                                        <input type="button" id="edit" value="修改" class="submit_Btn none btn_style"/>
                                        <input type="submit" id="submit" value="保存" class="submit_Btn none btn_style"/>
                                    </s:if>
                                    <input type="button" id="back" value="返回"
                                           class="cancel_Btn btn_style" />
                                </p>
                            </form>
                            <div class="trackBtn"></div>
                        </div>
                        <div class="pic mt20 detail_pic">
                            <table id="p2pProductExamineTable" class="gridTable">
                            </table>
                        </div>
                    </li>
                    <div id="w1" class="easyui-window" title="新金融产品发布审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
                        <div>
                            <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
                            <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                                <input id="submit1" name="submit" type="submit" value="下一步" oper="next"class="submit_Btn  btn_style audit"/>
                                <input id="submit2" name="" type="submit" value="驳回" oper="back" class="submit_Btn  btn_style audit"/>
                            </div>
                        </div>
                    </div>
                    <s:if test="showCommonView">
                        <li class="tab_content2  tabContent">
                            <div class="details_Info_content p15 info_All">
                                <div class="upload">
                                    <span>上传视频文件</span>
                                    <s:if test="showUploadButton"><input id="upload1" name="file" type="file"/></s:if>
                                    <s:else><input id="upload1" name="file" type="hidden"/></s:else>
                                </div>
                            </div>
                            <div id="video"></div>
                            
                            
                                        <span class="span1"></span>
                                        <a id="aEmpHead" style="position:relative;margin-left:-120px;">
                                            <img alt="logo图片" id="emphead" class="ml20 emphead" src="" height="100" width="100">
                                        </a>
                                        <input type="hidden" id="portraitPath" name="portraitPath" />
                                        <div id ="a" style="margin-top: -50px; margin-left: 120px;"><div class="upload uploadW"> </div></div>
                        </li>
                    </s:if>
                </ul>
            </div>
        </div>
        ${pageVar}


    </m:Content>
</m:ContentPage>