<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

          <div class="detail mt20 pb30 ">
            <div class="tableCenter">
            <div id="errCode" hidden="hidden"><s:property value="#request.errCode"/></div>
          	<h5 class="tc">面试评估记录表</h5>

          	<div id="head">
              <strong>应聘者姓名：<span><input type="text" class="data" id="name" value='<s:property value="#request.interviewEvaluationRecord1.name"/>'/><div class="Validform_checktip"></div></span>
              		      性别：<input type="hidden" id="hsex" value="<s:property value="#request.interviewEvaluationRecord1.sex"/>">
                          <div class="DivSelect" style="display:inline-block;">
                          	<select id="sex" class="SelectList data"><option value="0">女</option><option value="1">男</option></select>
                          </div>
              		      应聘职位：<input type="hidden" id="hdesirePositionNo" value="<s:property value="#request.interviewEvaluationRecord1.desirePositionNo"/>">

                                 <!-- <span>
                                  <select class="data" id="desirePositionNo"></select>
                                  <div class="Validform_checktip"></div>
                                  </span>-->
                                  <div class="DivSelects" style="display:inline-block;">
                                    <select class="SelectLists data" id="desirePositionNo" style="width:130px;"></select>
                                    <div class="Validform_checktip"></div>
                                  </div>
              		      初试时间：<span><input type="text" class="data" id="firstTime"  value='<s:date name="#request.interviewEvaluationRecord1.firstTime" format="yyyy-MM-dd"/>'/><div class="Validform_checktip"></div></span></strong>
              </div>

              <table align="center" border="1">
               <tbody id="first">
                <tr>
                  <td width="718" height="40" valign="center" colspan="8" >初试评价记录&#8212;&#8212;人力资源部</td>
                </tr>
                <tr >
                  <td width="216" height="30" valign="center" colspan="5" >评估项目</td>
                  <td width="47" valign="center" >分值</td>
                  <td width="378" valign="center" >评分要点</td>
                  <td width="76" valign="center" >得分</td>
                </tr>
                <s:if test="#request.evaluationContentList1!=null">
                  <s:iterator value="#request.evaluationContentList1" var="evaluationContent">
                    <tr id="part1">
                      <s:if test="#evaluationContent.parentNo==0">
                      	<td width="36" valign="center" colspan="2" rowspan='<s:if test="#evaluationContent.id==1">7</s:if><s:else>5</s:else>'><s:property value="#evaluationContent.item"/>
                      	</td>
                      </s:if>

                      <s:else>
                       <td width="179" valign="center" colspan="3" class="tl" ><s:property value="#evaluationContent.item"/>&nbsp;</td>
                       <td width="47" valign="center" ><s:property value="#evaluationContent.grade"/></td>
                       <td width="378" valign="center" class="tl" ><s:property value="#evaluationContent.point"/></td>
                       <td width="76" valign="top" ><input type="text" style="width:50px; " class="data score1" id="score1"  value="<s:property value="#evaluationContent.score"/>"/><div class="Validform_checktip"></div></td>
                      </s:else>
                    </tr>
                  </s:iterator>
                </s:if>
                <tr>
                  <td width="641" valign="center" colspan="7" >评分合计</td>
                  <td width="76" valign="top" ><input type="text" style="width:50px; " disabled="disabled" id="totalScore1"  value="<s:property value="#request.totalScore1"/>"/></td>
                </tr>
                <tr >
                  <td width="102" valign="center" colspan="3" >关键信息记录<br />及整体评价</td>
                  <td width="615" valign="center" colspan="5" >
                  	<textarea style="width:720px; height:60px;" class="data" id="firstEvaluation"><s:property value="#request.interviewEvaluationRecord1.firstEvaluation"/></textarea>
                  </td>
                </tr>
                <tr >
                  <td width="102" valign="center" colspan="3" >初试结论</td>
                  <td width="615" valign="center" colspan="5" >
                  <ul>
                    <input type="hidden" id="hconclusion1" value="<s:property value="#request.interviewEvaluationRecord1.conclusion"/>">
                    <li>
                        <div class="DivSelects mt5">
                           <select id="conclusion1" class="data SelectLists" style="width:130px;">
                             <option value="0">请选择初试结论</option>
                             <option value="1">可以试用</option>
                             <option value="2">可以复试</option>
                             <option value="3">可以考虑</option>
                             <option value="4">不予考虑</option>
                           </select><div class="Validform_checktip"></div>
                        </div>
                    </li>
                  </ul>
                  <!--<strong class="mt15">面试官：<div hidden="hidden" id="hempNo1"><s:property value="#request.interviewEvaluationRecord1.empNo"/></div><select id="empNo1" class="data"></select>日期：<input type="text" style=""  class="data" id="interviewDate1" value="<s:date name="#request.interviewEvaluationRecord1.interviewDate" format="yyyy-MM-dd"/>"/><div class="Validform_checktip"></div></strong>-->
                  <strong class="mt15">
                  		面试官：<input type="hidden" id="hempNo1" value="<s:property value="#request.interviewEvaluationRecord1.empNo"/>"><input type="hidden" id="hempNo11" value="<s:property value="#request.empNo1"/>">
                  	  <span class="DivSelects mt5" style="display:inline-block;">
                  	  <select id="empNo1" class="SelectLists" style="width:130px;" disabled="disabled"></select><div class="Validform_checktip"></div>
                      </span>
                      	日期：<span><input type="text" style=""  class="data" id="interviewDate1" value="<s:date name="#request.interviewEvaluationRecord1.interviewDate" format="yyyy-MM-dd"/>"/>
                      <div class="Validform_checktip"></div></span>

                  </strong>
                  </td>
                </tr>
                <tr>
                    <td>选择复试人：
                        <input id="employeeSel" class="w80 data" type="text"  />
                        <input type="text" id="retestUserNo" style="display: none"value="<s:property value="#request.interviewEvaluationRecord1.retestUserNo"/>"/>
                    </td>
                </tr>

                </tbody>

                <tbody id="second">
                <s:if test="#request.evaluationContentList2.size>0">
                <tr >
                  <td width="718" height="30" valign="center" colspan="8" >复试评价记录&nbsp;&#8212;&#8212;&nbsp;用人部门</td>
                </tr>
                <tr >
                  <td width="206" height="30" valign="center" colspan="4" >评估项目</td>
                  <td width="56" valign="center" colspan="2" >分值</td>
                  <td width="378" valign="center" >评分要点</td>
                  <td width="76" valign="center" >得分&nbsp;</td>
                </tr>
                <s:if test="#request.evaluationContentList2!=null">
                  <s:iterator value="#request.evaluationContentList2" var="evaluationContent" begin="0" end="1">
                    <tr id="part2">
	                    <td width="206" valign="center" colspan="4" ><s:property value="#evaluationContent.item"/></td>
	                    <td width="56" valign="center" colspan="2" ><s:property value="#evaluationContent.grade"/></td>
	                    <td width="378" valign="center" class="tl" ><s:property value="#evaluationContent.point"/></td>
	                    <td width="76" valign="top" ><input type="text" class="data score2" id="score2" style="width:50px;" value="<s:property value="#evaluationContent.score"/>"/><div class="Validform_checktip"></div></td>
                  	</tr>
                  </s:iterator>
                  <s:iterator value="#request.evaluationContentList2" var="evaluationContent" begin="2">
                    <tr id="part2">
                      <s:if test="#evaluationContent.parentNo==0">
                      	<td width="36" valign="center" colspan="2" rowspan="5" ><s:property value="#evaluationContent.item"/></td>
                      </s:if>
                      <s:else>
                       <td width="179" valign="center" colspan="2" class="tl" ><s:property value="#evaluationContent.item"/>&nbsp;</td>
                       <td width="47" valign="center" colspan="2"><s:property value="#evaluationContent.grade"/></td>
                       <td width="378" valign="center" class="tl" ><s:property value="#evaluationContent.point"/></td>
                       <td width="76" valign="top" ><input type="text" class="data score2"  style="width:50px; " id="score2" value="<s:property value="#evaluationContent.score"/>"/><div class="Validform_checktip"></div></td>
                      </s:else>
                    </tr>
                  </s:iterator>
                </s:if>
                <tr>
                  <td width="641" valign="center" colspan="7" >评分合计</td>
                  <td width="76" valign="top" ><input type="text" style="width:50px;" id="totalScore2" disabled="disabled" value="<s:property value="#request.totalScore2"/>"/></td>
                </tr>
                <tr>
                  <td width="102" valign="center" colspan="3" >管理能力评价<br />（管理岗位） </td>
                  <td width="615" valign="center" colspan="5" >
                  	<textarea style="width:723px; height:70px;" class="data" id="secondEvaluation"><s:property value="#request.interviewEvaluationRecord2.secondEvaluation"/></textarea>
                  </td>
                </tr>
                <tr >
                  <td width="102" valign="center" colspan="3" >综合评价</td>
                  <td width="615" valign="center" colspan="5" >
                  	<textarea style="width:723px; height:70px;" class="data"  id="evaluation"><s:property value="#request.interviewEvaluationRecord2.evaluation"/></textarea>
                  </td>
                </tr>
                <tr >
                  <td width="102" valign="center" colspan="3" >复试结论</td>
                  <td width="615" valign="center" colspan="5" >
                  <ul>

                  	<input type="hidden" id="hconclusion2" value="<s:property value="#request.interviewEvaluationRecord2.conclusion"/>">
                  	<li>
                        <div class="DivSelects data mt5" style="display:inline-block; float:left;">
                           <select id="conclusion2" class="SelectLists data ml10" style="width:160px;">
                           <!--<select id="conclusion2" class="data">-->
                             <option value="0">请选择复试结论</option>
                             <option value="5">建议录用</option>
                             <option value="6">可作储备</option>
                             <option value="7">不予考虑</option>
                           </select>
                           <div class="Validform_checktip"></div>
                        </div>
                  		<div hidden="hidden" id="showhirePositionNo" style="float:left;">，岗位:<div class="DivSelects data mt5" style="display:inline-block;"><select id="hirePositionNo" class="data" style="width:130px;"></select><div class="Validform_checktip"></div></div>
                    	<input type="hidden" id="HhirePositionNo" value="<s:property value="#request.interviewEvaluationRecord2.hirePositionNo"/>">

                    </li>
                  </ul>
                  <!--<strong class="mt15">面试官：<div hidden="hidden" id="hempNo2"><s:property value="#request.interviewEvaluationRecord2.empNo"/></div><select id="empNo2" class="data"></select>日期：<input type="text" style="" class="data" id="interviewDate2" value="<s:date name="#request.interviewEvaluationRecord2.interviewDate" format="yyyy-MM-dd"/>"/></strong><div class="Validform_checktip"></div>-->
                  <strong class="mt15">
                  	面试官：<input type="hidden" id="hempNo2" value="<s:property value="#request.interviewEvaluationRecord2.empNo"/>"><input type="hidden" id="hempNo22" value="<s:property value="#request.empNo2"/>">
                    <div class="DivSelects data mt5" style="display:inline-block;">
                  		<select id="empNo2" class="SelectLists" style="width:130px;" disabled="disabled"></select><span class="Validform_checktip"></span>
                    </div>
                   	 日期：<input type="text" style="" class="data" id="interviewDate2" value="<s:date name="#request.interviewEvaluationRecord2.interviewDate" format="yyyy-MM-dd"/>"/>
                    <div class="Validform_checktip"></div>
                  </strong>
                  </td>
                </tr>
                </s:if>
                </div>
              </table>
              <strong>说明：岗位能力应根据不同岗位进行定义。评分标准：85-100%分值为优秀分数段，70-84%为良好分数段，60-69%为一般分数段，60%以下为较差。</strong>
              <div id="errMsg" style="color: red"></div>
          	</div>
          </div>
      
