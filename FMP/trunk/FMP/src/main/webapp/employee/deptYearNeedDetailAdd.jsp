<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<form id="deptYearNeedAdd" method="post">
    <table align="center" border="1" class="tc data" >	
                 <thead>
                  <tr>
                    <td width="0" height="30" valign="center"  style="display:none;" ></td>
                    <td width="60" valign="center" >职位编号</td>
                    <td width="115" valign="center" colspan="2" >职位名称</td>
                    <td width="60" valign="center" >现有人数</td>
                    <td width="60" valign="center" >拟增人数</td>
                    <td width="130" valign="center" >需求原因</td>
                    <td width="200" valign="center" >人员要求</td>
                    <td width="70" valign="center" >到岗时间</td>
                    <td valign="center"style='width:30px;'>备注</td>
                  </tr>
                  </thead>
                  <tbody id="aduitComment">
             <s:iterator value="#request.positionList" id="item" status="index">
              <input type="hidden" value="<s:property value="#item.deptNo"/>"  id="deptNo">
					<tr class="deptYearListClass" > 
					<td width="0"  style="display:none;" height="50" valign="center"><input style='width:0px;' class="id data" readonly="readonly" type="hidden" id="id"/></td>
						
						<td width="60" height="50" valign="center"><input style='width:30px;' class="positionNo data" readonly="readonly" type="text" value="<s:property value="#item.id"/>"/></td>
						<td width="115" valign="center" colspan="2" ><input type="text" class="name data" readonly="readonly" value="<s:property value="#item.name"/>"></td>
						<td width="60" valign="center"><input type="text" class="nowEmp data" readonly="readonly"  value="<s:property value="#item.nowPositionEmp"/>"  style='width:30px;'/> </td>
						<td width="60" valign="center"><input type="text" value="0" class="addEmp data" id="addEmp"  style='width:30px;'/><div class="Validform_checktip"></div></td>
						<td valign="center"><textarea  class="requireReason data"   style="width:130px; height: 45px;"></textarea></td>
						<td width="200" valign="center"><textarea class="empRequire data"  style="width:180px; height: 45px;"></textarea></td>
						<td width="70" valign="center"><input type="text"  class="data dateYMD workDate"  style="width:90px; height: 45px;"/></td>
						<td width="60" valign="top"><textarea class="mark data"  style="width:110px; height: 45px;"></textarea></td>
				 
					</tr>
				</s:iterator> 
                       <tr class="data">
                        <td width="163" height="30" valign="center" colspan="3">合计</td>
                        <td width="60" valign="center"><input type="text" id="nowEmpTotal" class="data" readonly="readonly" style='width:30px; height:30px;'/></td>
                        <td width="60" valign="center"><input type="text" id="addEmpTotal" class="data" readonly="readonly" style='width:30px; height:30px;'/></td>
                        <td width="376" valign="top" colspan="4"></td>
                      </tr>
                     
                 </tbody> 
                </table>
        </form>
 <strong>说明：本表格用于部门年度人员需求计划填报，请部门根据现有人员填写增补需求，对于新增岗位请详细说明任职条件等要求。 </strong>
            ${pageVar}