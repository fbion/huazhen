<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="m" uri="/hz-tags" %>
<m:ContentPage materPageId="layout">
    <m:Content contentPlaceHolderId="center">
<%-- <input type="button"  value="居中" onclick="mybox({pos:'center'})" />
 
<input type="button"  value="右下角" onclick="mybox({width:400,height:200,pos:'rightdown'})" />
 
<input type="button"  value="ajax调用" onclick="mybox({width:400,height:200,ctype:'url',url:'echo.php'})" />    
			      <select id="selectCompany">
					<option value="0">全部</option>
					<option value="1">华镇金控集团</option>
					<option value="2">北京华镇</option>
					<option value="3">上海华镇</option>
					<option value="17">深圳华镇</option>
					<option value="18">济南华镇</option>
				  	</select>
			       <input type="text" id="text" onclick="showmenu(event)" value="" />
				  	<div id="lightmenu" class="daohang" >
						<a href="http://www.ablanxue.com">首页</a>
						<a href="#" onclick="hidemenu()">关闭</a>
					</div>
					
			<div id="employeeCtrl">	11	
			<!-- <div class="easyui-window" title="员工" data-options="closed:true" style="width:226;height:500px;padding:5px;"> -->
			</div>
			
		<script>
			$(function(){
				$("#employeeCtrl").EmployeeTree({
					singleSel:true,
					url:"",
					paramList: {}
				});		
			})
			</script>  --%>
			
			
			<SCRIPT type="text/javascript">
		
		//-->
	</SCRIPT>
	<style type="text/css">
	</style>
 
 </HEAD>

<br>
<br>
<br>
<br>
<br>
Test: <input id="employeeSel" type="text"  value="" style="width:120px;" />
	  <input type="text" id="itemId" value="2"/>
Test1: <input id="employeeSel1" type="text"  value="" style="width:120px;" />
	  <input type="text" id="itemId1" value="3"/>
Test2: <input id="employeeSel2" type="text"  value="" style="width:120px;" />
	  <input type="text" id="itemId2" value="9"/>

 <input type="text" id="username" autoComplete='off'>  
        <div id="result"></div>
    </m:Content>
</m:ContentPage>
