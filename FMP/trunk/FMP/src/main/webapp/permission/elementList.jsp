<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
<m:Content contentPlaceHolderId="center">

<div class="detail mt20 pb30">

	<div class="basic_Info_content p15 info_All">
         <div id="treeboxbox_tree" class="dhtmlxTree" style="width: 20%; height: 700px; background-color: #f5f5f5; border: 1px solid Silver;float:left">
         
		</div>
		
		<div class="dhtmlxTreeContent" style="float:left; border:1px solid red; width:70%; height:700px;">
		<p id="btn1" style="text-align:right;">
             <em id="msg"></em>
                 <input type="button" id="elementAdd" value="增加" class="submit_Btn -none btn_style" />
                 <input type="button" id="elementEdit" value="修改" class="submit_Btn -none btn_style" />
                 <input type="button" id="elementDelete" value="刪除" class="submit_Btn -none btn_style" />
             <!-- <input type="button" id="back" value="返回" class="cancel_Btn btn_style" /> -->
         </p>
		<div id="element" style="display: none;" class="basic_Info_content p15 info_All">
		 	<form id="elementFrom">
		 			<div id="elementAddDiv">
			            <ul>
                            <li><span>元素名称：</span>
                                <input id="elementAddName" name="elementAddName" type="text" class="ml20" />
                                <div class="Validform_checktip"></div>
                            </li>
                            <li ><span>元素地址：</span>
                               <input id="elementAddValue" name="elementAddValue" type="text" class="ml20" />
                                <div class="Validform_checktip"></div>
                            </li>
                            </ul><ul>
                            <li><span>别名：</span>
                                <input id="elementAddAlias" name="elementAddAlias" type="text" class="ml20" />
                                <div class="Validform_checktip"></div>
                            </li>
                            <li><span>优先级：</span>
                            <input id="elementAddPriority" name="elementAddPriority" type="text" class="ml20" />
                            <div class="Validform_checktip"></div>
                            </li>
                            </ul><ul>
                            <li><span>层级：</span>
                            <input id="elementAddLevel" name="elementAddLevel" type="text" class="ml20" />
                            <div class="Validform_checktip"></div>
                            </li>
                            <li>
                            <span>显示：</span>
                            <input id="elementAddIsShow" name="elementAddIsShow" type="checkbox" class="ml20" />
                            <div class="Validform_checktip"></div></li>
                            </ul><ul>
                            <li><span>备注：</span>
                            <input id="elementAddEditComment" name="elementEditAddComment" type="text" class="ml20" />
                            <div class="Validform_checktip"></div>
                            </li>
                            <li>
                            </li>
                            
                        </ul>
		 			</div>
                        
                        <div id="elementEditDiv">
                        
			            <ul>
                            <li><span>元素名称：</span>
                                <input id="elementName" name="elementName" type="text" class="ml20" />
                                <div class="Validform_checktip"></div>
                            </li>
                            <li ><span>元素地址：</span>
                               <input id="elementValue" name="elementValue" type="text" class="ml20" />
                                <div class="Validform_checktip"></div>
                            </li>
                            </ul><ul>
                            <li><span>别名：</span>
                                <input id="elementAlias" name="elementAlias" type="text" class="ml20" />
                                <div class="Validform_checktip"></div>
                            </li>
                            <li><span>优先级：</span>
                            <input id="elementPriority" name="elementPriority" type="text" class="ml20" />
                            <div class="Validform_checktip"></div>
                            </li>
                            </ul><ul>
                            <li><span>层级：</span>
                            <input id="elementLevel" name="elementLevel" type="text" class="ml20" />
                            <div class="Validform_checktip"></div>
                            </li>
                            <li><span>显示：</span>
                            <input id="elementIsShow" name="elementIsShow" type="checkbox" class="ml20" />
                            <div class="Validform_checktip"></div>
                            </li>
                            </ul><ul>
                            <li>
                            <span>备注：</span>
                            <input id="elementEditComment" name="elementEditComment" type="text" class="ml20" />
                            <div class="Validform_checktip"></div>
                            </li>
                            <li>
                            </li>
                        </ul>
                        </div>
                        <p id="btn1">
                            <em id="msg"></em>
                                <input type="submit" id="elementUpdateSubmit" value="保存" class="submit_Btn btn_style" />
                                <input type="submit" id="elementAddSubmit" value="保存" class="submit_Btn none btn_style" />
                        </p>
                        <input id="elementId" name="elementId" type="text" class="ml20" hidden="hidden" />
            </form>
		</div>
		<div id="elementDetail" style="display: -none;" >
           <ul>
               <li><span>元素名称：</span>
                   <a id="elementDetailName"></a>
               </li>
               <li ><span>元素地址：</span>
                  <a id="elementDetailValue"></a>
               </li>
               </ul><ul>
               <li><span>层级：</span>
               <a id="elementDetailLevel" ></a>
               </li>
               <li></li>
               </ul><ul>
               <li><span>别名：</span>
                   <a id="elementDetailAlias"></a>
               </li>
               <li><span>优先级：</span>
               <a id="elementDetailPriority" ></a>
               </li>
               </ul><ul>
               <li><span>是否显示：</span>
               <a id="elementDetailIsShow" ></a>
               <a id="isShow" hidden="hidden" ></a>
               </li>
               <li><span>编辑时间：</span>
               <a id="elementEditTime" ></a>
               </li>
               </ul><ul>
               <li><span>录入时间：</span>
               <a id="elementDetailInTime" ></a>
               </li>
               <li><span>备注：</span>
               <a id="elementDetailEditComment" ></a>
               </li>
           </ul>
		</div>
		
		<div>
		</div>
		
           
		</div>
   </div>
</div>
</m:Content>
</m:ContentPage>