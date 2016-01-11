var ManagePage = {
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            }
            if (ElementVar[id] == TagPermissionType.edit) {
                $(this).removeAttr("disabled");
            }
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none){
                $(this).parent().remove();
            }
        });
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
        if ($("#edit").length > 0)
            $("#edit").show();
        if ($("#drawSettingAddBtn").length > 0)
            $("#drawSettingAddBtn").hide();

    },
    HideEditButton: function () {
        if ($("#edit").length > 0)
            $("#edit").hide();
        if ($("#drawSettingAddBtn").length > 0)
            $("#drawSettingAddBtn").show();

    },
    GetInfoList: function (id) {
        var url = $Url.BuildMarketUrl("/market/drawSetting/ajaxGetDrawSettingInfo");
        $.ajax({
        	type: "POST",
		       url: url,
		       data: {
		       	checkValue :  $("#hidUserIdList").val()
		       },
           
            success: function (data, textStatus) {
            	$("#hidRoundSetting").val(data.hidRoundSetting);
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
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetInfoByUsername: function (name) {
        var url = $Url.BuildMarketUrl("/market/drawSetting/getInfoListByUsername");
        var hidcheckValue = $("#hidUserIdList").val();
        $.ajax({
            type: "post",
            url: url,
            dataType: "html",
            timeout: 30000,
            data: { userName: name,checkValue:hidcheckValue },
            beforeSend: function () {
            }, 
           
            success: function (data, textStatus) {
            	$("#reservation").html(data);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    destroyUser:function(){
    	var chk_value =$("#hidUserIdList").val(); //选定人
        var row = $('#dg').datagrid('getSelected');
        var url = $Url.BuildSalesUrl("/market/drawSetting/ajaxDeldrawUser");
        if (row){
           $.messager.confirm('确认','确认删除该用户?',function(r){
                if(r){
                    $.ajax({
                        type: "post",
                        url: url,
                        dataType: "json",
                        timeout: 30000,
                        data: { 
                        	delUserid: row.id,checkValue:chk_value
                        },
                        beforeSend: function () {
                        },
                        success: function (data, textStatus) {       
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
                    });
                }
            });
            
            
        }
    },
    GetInfo: function (id) {
        var url = $Url.BuildMarketUrl("/market/drawSetting/ajaxGetDrawSetting");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async:false,
            data: { id: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);
                
            	var rounds = 9;
            	for(i=0;i<rounds;i++){
            		 var round = i+1;
            		 jQuery("#round").append("<option value='"+round+"'>"+  round  +"</option>");  
            	}
            	
                $("#round").val(data.info.round);

                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
$(function () {
	
	var rounds = 9;
	for(i=0;i<rounds;i++){
		 var round = i+1;
		 jQuery("#round").append("<option value='"+round+"'>"+  round  +"</option>");  
	}
	
	ManagePage.GetInfoList();
	
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }
    
    $("#addContentUser").click(function () {
    	getUserInfo();
    });
    $("#addDrawUser").click(function () {
    	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '用户');
    	ManagePage.GetInfoByUsername();
    });
    $("#searchUser").click(function () {
    	ManagePage.GetInfoByUsername($("#inputNameSearch").val());
    });
    $("#back").click(function () {
    	
        $EasyUI.Close();
    });
    $("#edit").click(function () {
    	
    	$.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
//            $(".data").attr("disabled", 'true');
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            }
            if (ElementVar[id] == TagPermissionType.edit) {
                $(this).removeAttr("disabled");
            }
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none) {
                $(this).parent().remove();
            }
        });
    	
    	$("#drawSettingAddBtn").show();
    });
    

    var drawSettingAdd = $("#drawSettingAdd").Validform({
    	
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        datatype: {
        	"verifySettingSel": function (gets, obj, curform, datatype) {
        		var selval = $("#round").val();
            	var hidRoundSetting = $("#hidRoundSetting").val();
            	var settingArr = hidRoundSetting.split(",");
         	    for (i=0;i<settingArr.length ;i++)   
        	    {   
        	        if(settingArr[i]==selval){
        	        	if (Number(PageVar.ID) == 0) {
        	        		return "已经添加过该轮，不能重复添加！";
        	              }

        	        }
        	    } 
        	},
        	"verifyDrawCount": function (gets, obj, curform, datatype) {
        		var drawNumber=$("#drawNumber").val();//设置的抽奖人数
        		var ckuserVal = $("#hidUserIdList").val();
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
        			if(addCount < 0){
        				return "已超过最大加抽奖人数！";
        			}
        		
        	}
        
        
        	
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildMarketUrl("/market/drawSetting/ajaxEditDrawSetting");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				round: $("#round").val(),
				drawAwards: $("#drawAwards").val(),
				drawNumber: $("#drawNumber").val(),
				mark: $("#mark").val(),
				status:1
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info),checkValue: $("#hidUserIdList").val()
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {

                    $("#hidUserIdList").val(data.checkValue);
                    //$("#hidUserId").val(data.id);
                    
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
              	if (data.errCode == "0000") {
	                    window.location.href = $Url.BuildMarketUrl("/market/drawSetting/edit?id=" + data.errDesc+"&checkValue=" + data.checkValue);
	                    
	                } else {
	                    $("#msg").text(data.errDesc);
	                }
                	
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    drawSettingAdd.addRule([
				{
				    ele:"#round",
				    dataType:"verifySettingSel",
				    nullmsg:"已经添加过该轮，不能重复添加",
				    sucmsg:" ",
				    errormsg:"round"
				},
                {
                    ele:"#drawAwards",
                    dataType:"*",
                    nullmsg:"请填写奖项",
                    sucmsg:" ",
                    errormsg:" "
                },
                {
                    ele:"#drawNumber",
                    dataType:"/^[0-9]*$/",
                    nullmsg:"请填写抽奖人数",
                    sucmsg:" ",
                    errormsg:"请填写数字"
                },
                {
                    ele:"#hidUserIdList",
                    dataType:"verifyDrawCount",
                    nullmsg:"请添加内定中奖人",
                    sucmsg:" ",
                    errormsg:"round"
                },
                
    ]);
    
    
})


