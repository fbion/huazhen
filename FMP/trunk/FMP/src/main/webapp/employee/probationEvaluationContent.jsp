<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<div class="detail mt20 pb30 ">
  <div class="tableCenter">
    <div id="errCode" hidden="hidden"><s:property value="#request.errCode"/></div>
	<h5 class="tc">员工试用期转正评估表</h5>
    <div class="tableCenter_assessment">
        <input type="hidden" id="activitiNo"  value="<s:property value="info.activitiNo"/>">
        <input type="hidden" id="empName" value="<s:property value="empName"/>"/>
    	公司：<span style="width:100px;">
                <input type="hidden" id="hcompanyNo" value="<s:property value="info.companyNo"/>"/>
                <span class="DivSelects" style="display:inline-block;">
                    <select type="text" style="width:130px;" id="companyNo" name="companyNo" disabled="disabled" class="SelectLists"></select>
                    <div class="Validform_checktip"></div>
                </span>
            </span>
    	部门：<span class="sectionspan">
            <input type="hidden" id="hdeptNo" value="<s:property value="info.deptNo"/>"/>
            <span class="DivSelects" style="display:inline-block;">
            <select type="text" style="width:192px;" id="deptNo" name="deptNo" type="text" disabled="disabled" class="SelectLists"></select>
            <div class="Validform_checktip"></div>
            </span>
        </span>
    	职位：<span style="width:130px;">
            <input type="hidden" id="hpositionNo" value="<s:property value="info.positionNo"/>"/>
            <span class="DivSelects" style="display:inline-block;">
            <select type="text" style="width:130px;" id="positionNo" name="positionNo" type="text" disabled="disabled" class="SelectLists"></select>
            <div class="Validform_checktip"></div>
            </span>
        </span>
   		姓名：<span style="width:100px;">
        	<input type="hidden" id="hempNo" value="<s:property value="info.empNo"/>"/>
            <span class="DivSelects" style="display:inline-block;">
            <select type="text" style="width:130px;" id="empNo" name="empNo" type="text" disabled="disabled" class="SelectLists"></select>
            <div class="Validform_checktip"></div>
            </span>
        </span>

    </div>
    <div class="tableCenter_assessment">
        <input type="hidden" id="activitiNo"  value="<s:property value="info.activitiNo"/>">
        <input type="hidden" id="empName" value="<s:property value="empName"/>"/>
      入职日期：<span class="mt5" style="width:130px;">
            <input type="text" style="width:100px;" id="startTime" name="startTime" type="text" disabled="disabled" value='<s:date name="info.startTime" format="yyyy-MM-dd"/>' class="SelectLists data"/>
            <div class="Validform_checktip"></div>
        </span>

        转正日期：<span class="mt5" style="width:130px;">
            <input type="text" style="width:100px;" id="probationDate" name="probationDate" disabled="disabled" value='<s:date name="info.probationDate" format="yyyy-MM-dd"/>' class="SelectLists data"/>

            <div class="Validform_checktip"></div>
        </span>
    </div>

    <table align="center" border="1"  id="aduitComment" class="aduittable">
      <tr>
        <td width="80" height="30" valign="center" colspan="2" >工作能力</td>
        <td width="376" valign="center" colspan="2" >评分标准</td>
        <td width="91" valign="center" >得分</td>
      </tr>
      <s:if test="info!=null">
      	<s:iterator value="info.probationEvaluationContentTemplateList" status="index" var="contentTemplate">
      		<s:if test="#contentTemplate.type==1">
	      		<tr id="part1">
			        <td width="105" valign="center" colspan="2" ><s:property value="#contentTemplate.content"/></td>
			        <s:if test="#index.first"><td width="376" valign="center" colspan="2" rowspan='<s:property value="#request.count1"/>' >基本满足工作要求为3分，略高于一般水平为4分，远远高于一般水平为5分，略低于一般水平为2分，远低于一般水平为1分。</td></s:if>
			        <td width="91" valign="top" ><input type="text" style="width:70px;" id="score1" disabled="disabled" class="data score1" value="<s:property value="#contentTemplate.score"/>"/><div class="Validform_checktip"></div></td>
		      	</tr>
	      	</s:if>
      	</s:iterator>
      </s:if>
      
      <tr>
        <td width="552" valign="top" colspan="5" class="tl">*得分小计等于各项的算术平均值&nbsp;&nbsp;&nbsp;&nbsp;得分小计：<input type="text" id="totalScore1" disabled="disabled"/></td>
      </tr>
      <tr>
        <td width="80" height="30" valign="center" colspan="2" >日常表现</td>
        <td width="376" valign="center" colspan="2" >评分标准</td>
        <td width="91" valign="center" >得分</td>
      </tr>
      <s:if test="info!=null">
      	<s:iterator value="info.probationEvaluationContentTemplateList" status="index" var="contentTemplate">
      		<s:if test="#contentTemplate.type==2">
		      	<tr id="part2">
			        <td width="105" valign="center" colspan="2" ><s:property value="#contentTemplate.content"/></td>
			        <s:if test="#index.count==#request.count1+1"><td width="376" valign="center" colspan="2" rowspan="<s:property value="#request.count2"/>" >基本满足工作要求为3分，略高于一般水平为4分，远远高于一般水平为5分，略低于一般水平为2分，远低于一般水平为1分。</td></s:if>
			        <td width="91" valign="top" ><input type="text" style="width:70px;" id="score2" disabled="disabled" class="data score2" value="<s:property value="#contentTemplate.score"/>"/><div class="Validform_checktip"></div></td>
		      	</tr>
	      	</s:if>
      	</s:iterator>
      </s:if>
      <tr>
        <td width="552" valign="top" colspan="5" class="tl" >*得分小计等于各项的算术平均值&nbsp;&nbsp;&nbsp;&nbsp;得分小计：<input type="text" id="totalScore2" disabled="disabled"/></td>
      </tr>
      <tr>
        <td width="397" height="30" valign="center" colspan="3" >工作业绩</td>
        <td width="84" valign="center" >比例</td>
        <td width="91" valign="center" >得分</td>
      </tr>
      <s:if test="info!=null">
      	<s:iterator value="info.probationEvaluationContentList" status="index" var="content">
      		<tr id="part3">
		        <td width="397" valign="top" colspan="3" ><input type="text" style="width:470px;" id="content" disabled="disabled" class="data" value="<s:property value="#content.content"/>"/><div class="Validform_checktip"></div></td>
		        <td width="84" valign="top" ><input type="text" style="width:60px;" id="scale" disabled="disabled" class="data scale" value="<s:property value="#content.scale"/>"/>%<div class="Validform_checktip"></div></td>
		        <td width="91" valign="top" ><input type="text" style="width:70px;" id="score3" disabled="disabled" class="data score3" value="<s:property value="#content.score"/>"/><div class="Validform_checktip"></div></td>
	      	</tr>
      	</s:iterator>
      </s:if>
      <tr>
        <td width="552" height="30" valign="center" colspan="5" class="tl">*得分小计等于各项得分与权重比例数字的乘积之和&nbsp;&nbsp;&nbsp;&nbsp;得分小计：<input type="text" id="totalScore3" disabled="disabled"/></td>
      </tr>
      <tr>
        <td width="552" height="30" valign="center" colspan="5" class="tl">*总分：&nbsp;&nbsp;&nbsp;&nbsp;工作能力得分*20%+日常表现得分*20%+工作业绩得分*60%：<input type="text"  id="totalScore" name="totalScore" type="text" disabled="disabled" class="" value="<s:property value="#info.totalScore"/>"/></td>
      </tr>
    </table>
    <div class="tc">
    	<span style="display:inline-block; text-align:left; width:602px;">说明：请附被评估人《试用期工作总结表》；单项及总分采取5分制。在试用期结束前由部门负责人及以上级别的直属管理人员对被评估人进行评价，若符合提前转正条件的，则提前安排评估。总分低于3.5分视为不符合录用条件，结束试用。</span>
    </div>
	<div id="errMsg" style="color: red"></div>
	</div>
</div>    
