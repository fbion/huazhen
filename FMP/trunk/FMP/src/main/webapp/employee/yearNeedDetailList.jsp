<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

      <s:if test="showAddButton">
        <p class="mt50 pl20"><input type="button" id="btnAdd" value="新建" class="btn_style"/></p>
        </s:if>
   
            <div class="detail mt20 pl20 pb30 ">
              <div class="tableCenter">
              	<input type="hidden" id="yearNeedTotalId" value="<s:property value="yearNeedTotal.id"/>">
                <table align="center" border="1">
                  <tr >
                    <td width="91" height="30" valign="center">招聘部门</td>
                    <td width="96" valign="center">招聘岗位</td>
                    <td width="108" valign="center">招聘人数</td>
                    <td width="96" valign="center">到岗时间</td>
                    <td width="307" valign="center">岗位需求描述</td>
                  </tr>
                  <s:if test="#request.yearNeedTotal==null">
                  <p>编号:<span><input type="text"  class="data totalCode"  id="totalCode"/><span class="Validform_checktip"></span></span></p>  
                  </s:if>
                  <s:else>
                 <p>编号:<span ><s:iterator value="#request.yearNeedTotal" id="yearNeedTotal">
                 <input type="text" class="data totalCode" id="totalCode" value="<s:property value="yearNeedTotal.code"/>"/></s:iterator>
                 </span></p>
                  </s:else>
                  <s:iterator value="#request.yearNeeds" id="item" status="index"> 
                     <tr><td width="91" valign="center" id="rowspan<s:property value="#index.index+1"/>"  rowspan=""><a href=""><s:property value="#item.deptName"/></a></td></tr>
                   <s:iterator value="#request.yearNeedDetails" id="detail" >
                   <s:if test="#item.id == #detail.yearNeedNo">
	                  <tr class="rowspan<s:property value="#index.index+1"/>">
	                    <td width="96" valign="center"><s:property value="#detail.positionName"/></td>
	                    <td width="108" valign="center"><input class="data"  id="addEmpNum" readonly="readonly" type="text" value="<s:property value="#detail.addEmp"/>" /></td>
	                    <td width="96" valign="center"><input  class="data"  type="text" readonly="readonly" id="workDate" class="dateYMD" value="<s:date name='#detail.workDate' format='yyyy-MM-dd'/>"/></td>
	                    <td width="307" valign="top"><textarea  class="data"  readonly="readonly" style="width:296px; height:52px;"><s:property value="#detail.empRequire"/></textarea></td>
	                  </tr>
                  </s:if> 
                   </s:iterator>
                   <tr class="num">
                    <td width="91" valign="center" >小计</td>
                    <td width="96" valign="top" ><input type="text" /></td>
                    <td width="108" valign="top" ><input type="text" readonly="readonly" class="addEmpTotal data" value="<s:property value="#item.addEmpTotal"/>"/></td>
                    <td width="96" valign="top" ><input type="text" /></td>
                    <td width="307" valign="top" ></td>
                  </tr> 
                   <script>
                   
                   var rowNum=$('.rowspan<s:property value="#index.index+1"/>').size()+1;
                   $("#rowspan<s:property value="#index.index+1"/>").first().attr("rowspan",rowNum);
                   </script>
                 </s:iterator> 
                  <tr>
                    <td width="91" valign="center" >总计</td>
                    <td width="96" valign="top" ><input type="text" style="height:30px;" /></td>
                    <td width="108" valign="top" ><input type="text" readonly="readonly" style="height:30px;" class="data" id="AllEmp" /></td>
                    <td width="96" valign="top" ><input type="text" style="height:30px;" /></td>
                    <td width="307" valign="top" ></td>
                  </tr> 
                
                </table>
                  
                <strong>制表：<input readonly="readonly" type="text" id="proposerName"/><!-- 审批dddd：<input type="text" /> -->时间：<input type="text"  readonly="readonly" id="submTime"/></strong>
                <table align="center" border="1" id="aduitComment"></table>
            	</div>
            </div>    

 ${pageVar}
 
