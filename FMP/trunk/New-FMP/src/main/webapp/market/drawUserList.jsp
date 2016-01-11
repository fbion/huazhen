<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="m" uri="/hz-tags"%>

		<!--               新增用户层开始                     activityUsers -->




<%-- 			  <s:iterator value="#request.activityUsers" id="item">
					<li class="turndraw">
						<span class="spancheckbox"> <input type="checkbox" value="<s:property value="#item.id"/>" name="ckUser" /></span> 
						<span class="spanimg"> <img alt="用户头像" id="userimg<s:property value="#item.id" />" class="userimg" src="<s:property value="#item.userImgPath" />" style="width:82px;height:82px;"  ></img> </span>
						<script>
						 var str = "userimg"+"<s:property value="#item.id" />";
						 var strlength = $("#"+str).attr("src").length;
						 var subStr =  $("#"+str).attr("src").substr(42, strlength); 
						  $("#"+str).attr("src",subStr);//2015/7/9/20150709150307197_m3w306h230q85lt_original_7edU_5b030001405e118c.jpg
						</script>
						<!-- http://upload.chineseinvestor.com.cn/files -->
						<span class="spanengname"> <s:property value="#item.userName" /></span>
						<span class="span8"> <s:property value="#item.name" /></span>
						<!--<span class="span8">-->
				   
					</li>
				</s:iterator> --%>
				<s:iterator value="#request.activityUsers" id="item">
					<li class="turndraw">
						<span class="spancheckbox"> <input type="checkbox" value="<s:property value="#item.id"/>" name="ckUser" /></span> 
						<span class="spanimg"> <img alt="用户头像" id="userimg" class="userimg" src="<s:property value="#item.userImgPath" />" style="width:82px;height:82px;"  ></img> </span>
						<span class="spanengname"> <s:property value="#item.userName" /></span>
						<span class="span8"> <s:property value="#item.name" /></span>
						<!--<span class="span8">-->
				   
					</li>
				</s:iterator> 

<!--               新增用户层结束                                   -->


		
<script>
$(function () {
 });
$("#addSelctUser").click(function () {
		$("#drawTip").html("");
		$("#inputNameSearch").val("");
	    var chk_value =""; //选定人
	    var drawNumber=$("#drawNumber").val();//设置的抽奖人数
	    var ckuserVal = $("#hidUserIdList").val();
	    
	    var cheNo = 0;//新增的抽奖人数
		$('input[name="ckUser"]:checked').each(function(){ 
			chk_value += $(this).val()+",";
			cheNo++;
		});   
		if(cheNo==0){
		   $("#drawTip").html("请选择抽奖人！");
		   return;
		}
		if(drawNumber == ""){
			$("#drawTip").html("请添加抽奖人数！");
			return;
		}
		if(ckuserVal!=""){
		  var laststr = ckuserVal.substring(ckuserVal.length-1, ckuserVal.length);
		  if(laststr != ","){
		     ckuserVal = ckuserVal+",";
		  }
		}
		var ckuserValarr = ckuserVal.split(",");
	    var  ckuserValCount =0;
 	    for (i=0;i<ckuserValarr.length ;i++)   
	    {   
	        ckuserValCount++;
	    }   
	    ckuserValCount =ckuserValCount-1;////已经选中的父页id(隐藏域)  3，4，5
		var addCount = drawNumber - ckuserValCount;
		if(addCount ==0){
			$("#drawTip").html("已达到最大加抽奖人数！");
			return;
		}
		if(addCount>0){
			   if(cheNo >addCount){
			   		   $("#drawTip").html("当前选定人数大于抽奖人数!");
				return;
			   }else{
			      chk_value = chk_value+ckuserVal;
			   }
		}

		
		var url = $Url.BuildMarketUrl("/market/drawSetting/ajaxGetDrawSettingInfo");
 		$.ajax({
		       type: "POST",
		       url: url,
		       data: {
		       	checkValue : chk_value
		       },
		       success: function (data) {
		           $("#drawTip").html("");
		           $('#dlg').dialog('close');
		           $('#dg').datagrid('reload');
		           $("#hidUserIdList").val(data.checkValue);
		          $('#dg').datagrid({
            		remoteSort: false,
            		data:data.activityUsers,
            		columns: [[
            			{
            				field:'name',title:'姓名',width:20,sortable:true,align:'center'
            			},
            			{
            				field:'userName',title:'用户名',width:20,sortable:true,align:'center'
            			}
            		]]
            	});
		          
		          
		       }
		   } 
		)  

});
    

</script>