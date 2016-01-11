<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>

<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
	   <div class="basic_Info_content p15 info_All">
		   <h2></h2>
		   <ul>
			   <li>
			       <input type="button" id="showData" value="显示测试数据" class="btn_style" style="cursor:pointer"/>
			       <span id="showDataSuccess"style="color:green;" ></span>
			   </li>
			<br/>
			   <li>
			       <input type="button" id="hideData" value="不显示测试数据" class="btn_style"style="cursor:pointer"/>
			       <span id="hideDataSuccess" style="color:green;"></span>
			   </li>
			 <br/>   
			   <li>
			       <input type="button" id="flushBaseInfoCache" value="刷新缓存--BaseInfo" class="btn_style"style="cursor:pointer"/>
			       <span id="hideflushBaseInfoCache" style="color:green;"></span>
			   </li>
			   <br/>   
			   <li>
			       <input type="button" id="flushCustomerCache" value="刷新缓存--Customer" class="btn_style"style="cursor:pointer"/>
			       <span id="hideflushCustomerCache" style="color:green;"></span>
			   </li>
			   <br/>   
			   <li>
			       <input type="button" id="flushDictionaryCache" value="刷新缓存--Employee" class="btn_style"style="cursor:pointer"/>
			       <span id="hideflushDictionaryCache" style="color:green;"></span>
			   </li>
			   <br/>   
			   <li>
			       <input type="button" id="flushPermissionCache" value="刷新缓存--Permission" class="btn_style"style="cursor:pointer"/>
			       <span id="hideflushPermissionCache" style="color:green;"></span>
			   </li>
			   <br/>   
			   <li>
			       <input type="button" id="flushProductCache" value="刷新缓存--Product" class="btn_style"style="cursor:pointer"/>
			       <span id="hideflushProductCache" style="color:green;"></span>
			   </li>
			   <br/>   
			   <li>
			       <input type="button" id="flushSalesCache" value="刷新缓存--Sales" class="btn_style"style="cursor:pointer"/>
			       <span id="hideflushSalesCache" style="color:green;"></span>
			   </li>
			   <br/>   
			   <li>
			       <input type="button" id="flushWorkflowCache" value="刷新缓存--Workflow" class="btn_style"style="cursor:pointer"/>
			       <span id="hideflushWorkflowCache" style="color:green;"></span>
			   </li>
			   
			<br/>   
			   <li>
			       <input type="button" id="flushAllCache" value="刷新缓存--全部" class="btn_style"style="cursor:pointer"/>
			       <span id="hideflushAllCache" style="color:green;"></span>
			   </li>
			   
		</ul>
	   </div>
    </m:Content>
</m:ContentPage>
