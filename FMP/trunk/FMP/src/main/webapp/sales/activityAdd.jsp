<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
        <div class="detail mt20 pb30">
            <div class="tab">
                <div class="tab_title">
                         <a href="javascript:;" class="active">活动详情</a>
                         <a href="javascript:;" class="registration">我的客户</a>
                         <a href="javascript:;" id="invitation">我的邀请</a>
                         <a href="javascript:;">销售人员情况</a>
                         <s:if test="showEditButton">
                         <a href="javascript:void(0);">客户登记</a>
                         </s:if>
                    </div>
                <ul class="tab_content mt30">
                        <li class="tab_content1 tabContent" style="display: block;">
                 <form id="activityAdd" style="z-index:9999;">
                        	<table border="1" width="70%" class="activityTheme tc">
                            	<thead>
                                	<tr>
                                    	<th height="36" valign="middle" class="tc">活动主题</th>
                                        <th class="tc">活动时间</th>
                                        <th class="tc">主讲嘉宾</th>
                                        <th class="tc">嘉宾人数</th>
                                        <th class="tc">活动地点</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<tr>
                                    	<td height="30"><input id="title" name="title" type="text" disabled="disabled" class="data ml20 mr20 w200"/>
                                        <div class="Validform_checktip"></div></td>
                                        <td><input id="activityTime" name="activityTime" type="text" disabled="disabled" class="data w150"/>
                                        <div class="Validform_checktip"></div></td>
                                        <td><input id="empName" name="empName" type="text" disabled="disabled" class="data w150"/>
                                        <div class="Validform_checktip"></div></td>
                                        <td><input id="peopleNum" name="peopleNum" type="text" disabled="disabled" class="data w150"/>
                                        <div class="Validform_checktip"></div></td>
                                        <td><input id="address" name="address" type="text" disabled="disabled" class="data w300"/>
                                        <div class="Validform_checktip"></div></td>
                                    </tr>
                                    <tr>
                                    	<td colspan='4' height="100" class="tl">活动链接 <input id="url" size="50" name="url" type="text" disabled="disabled" class="ml20 data w200"/>
                                        <div class="Validform_checktip"></div>
                                        <div class="example mt10">例如：输入www.baidu.com即可</div></td>
                                        <td><img id="codeUrl"/></td>
                                    </tr>
                                    <tr>
                                    	<td height="336">活动内容</td>
                                        <td colspan='4' class="tl">
                                        <textarea cols="133" rows="20" id="content" disabled="disabled" class="data"></textarea>
                                        <div class="Validform_checktip"></div></td>
                                    </tr>
                                    <tr>
                                    	<td height="112">备注</td>
                                        <td colspan='4' class="tl">
                                        <textarea cols="133" rows="5" id="mark" disabled="disabled" class="data"></textarea>
                                        <div class="Validform_checktip"></div></td>
                                    </tr>
                                    <tr>
                                    	<td height="162">相关详情</td>
                                        <td colspan='4'>  
                        				<div class="details_Info_content p15 info_All" id="uploadDiv">
                           	 			<div class="upload"></div>
                        				</div>
                    					</td>
                                    </tr>
                                </tbody>
                            </table>
                            <input type="hidden"  id="status"/>
                        	<div class="btn mt50 tc" style="width:70%;">
                                    <s:if test="showSubmitButton">
                                        <input type="submit" id="submit" value="提交" class="mr15 btn_style"/>
                                    </s:if>
                                     <s:if test="showEditButton">
                                        <input type="button" id="edit" value="修改"
                                               class="mr15 btn_style"/>  
                                      <input type="button" id="release" value="发布" class="mr15 btn_style"/>
                                    </s:if>
                                     <input type="button" id="sign" value="我要报名" class="mr15 btn_style"/>
                                    <input type="button" id="back" value="返回" class="mr15 btn_style"/>
                                    <p class="registration" style="color: red">本活动您已报名！如果您是销售人员，您还可以邀请客户!</p>
                            </div>
                        </form>
                        </li>
                        
                         <li class="tab_content2 tabContent">
                         <div  id="Comment"></div>
                         </li>
                         <li class="tab_content3 tabContent" id="cusJsp">
                        <jsp:include page="/sales/applyCustomerList.jsp"></jsp:include> 
                         </li>
                         <li class="tab_content4 tabContent">
                         <div  id="sale"></div>
                         </li>
                         <li class="tab_content5 tabContent">
                         <div  id="record"></div>
                         </li>
                    </ul>

            </div>
        </div>
        ${pageVar}
    </m:Content>
</m:ContentPage>