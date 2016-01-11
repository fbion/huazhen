<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <%-- <s:if test="showAddButton">
          <p class="mt50 pl20"><input type="button" id="btnAdd" value="新建" class="btn_style"/></p>
          </s:if> --%>
        <form id="yearNeedTotalAdd" style="z-index:9999;">
            <div class="detail mt20 pb30 ">
                <div class="tableCenter">

                    <h5 class="tc"><span>
            	<select id="financialYears">
                    <s:iterator value="#request.FinancialYears" id="item">
                        <option><s:property value="#item.financialYear" /></option>
                    </s:iterator>
                </select>
            	</span>年度招聘计划表</h5>
                    <span class="position"></span>
                    <span id="positionList"></span>
                    <div id="btn" class="pt20" ><em id="msg"></em>
                        <s:if test="showEditButton">
                            <input id="edit" name="edit" type="button" value="修改"
                                   class="submit_Btn none btn_style"/>
                            <input id="submit" name="submit" type="submit" value="保存"
                                   class="submit_Btn none btn_style"/>
                        </s:if>
                        <input id="examine"  type="button" value="提交审批" class="submit_Btn btn_style"/>
                        <s:if test="showAuditButton">
                        </s:if>
                        <input  type="button" value="返回" class="cancel_Btn btn_style back"/>
                    </div>
                    <div id="mssage" class="pt20" >
                        <em>部门招聘需求没有审批通过的数据</em>
                        <input type="button" value="返回" class="cancel_Btn btn_style back"/>
                    </div>
                    <table align="center" border="1" id="aduitComment"></table>
                    <div id="w1" class="easyui-window" title="年度需求审批" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
                        <div>
                            <textarea id="taskCommet" style="width:450px; height:100px;"></textarea>
                            <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                                <input id="submit1" name="submit" type="submit" value="通过"class="submit_Btn  btn_style examine"/>
                                <input id="submit2" name="" type="submit" value="不通过" class="submit_Btn  btn_style examine"/>
                            </div>
                        </div>
                    </div>
                        ${pageVar}
                </div>
            </div>
        </form>
    </m:Content>
</m:ContentPage>
