
var ManagePage = {
		 GetList: function (pageIndex) {
			 var url = $Url.BuildWorkFlowUrl("/sales/activity/myCustomer");
			 $.ajax({
		            type: "POST",
		            url: url,
		            dataType: "html",
		            data: {
		            	"activityNo": PageVar.ID,
		            	"pageIndex":pageIndex+1
		            },
		            error: function (request) {
		                //alert(request);
		            },
		            success: function (data) {
		                $("#Comment").html(data);
		                if($("#totalCount").html()!=0){
		            		$("#pagination").pagination($("#totalCount").html(), {//总记录条数
		            			callback: ManagePage.GetList,//每次点击分页按钮的时候 执行该操作
		            			items_per_page:6,//每页显示多少条记录
		            			current_page:pageIndex,//当前页
		            			link_to:"javascript:void(0)",//不期望链接到某个目的地，只希望执行回调函数
		            			num_display_entries:2,//显示几个页码
		            			next_text:"下一页",//下一页按钮显示的内容
		            			next_show_always:true,//如果没有下一页  仍然显示按钮  但是灰化 
		            			prev_text:"上一页",//上一页按钮显示的内容
		            			prev_show_always:true,//如果没有上一页  不显示按钮 
		            			num_edge_entries:1,//页码多的时候...省略
		            			ellipse_text:"..."
		            		});
		            	}
		            }
		        })
		    },
		    GetSaleList: function (pageIndex) {
		    		 var url = $Url.BuildWorkFlowUrl("/sales/activity/mySale");
					 $.ajax({
				            type: "POST",
				            url: url,
				            dataType: "html",
				            data: {
				            	"activityNo": PageVar.ID,
				            	"pageIndex":pageIndex+1
				            },
				            error: function (request) {
				                //alert(request);
				            },
				            success: function (data) {
				                $("#sale").html(data);
				                if($("#saleTotalCount").html()!=0){
				            		$(".salePagination").pagination($("#saleTotalCount").html(), {//总记录条数
				            			callback: ManagePage.GetSaleList,//每次点击分页按钮的时候 执行该操作
				            			items_per_page:6,//每页显示多少条记录
				            			current_page:pageIndex,//当前页
				            			link_to:"javascript:void(0)",//不期望链接到某个目的地，只希望执行回调函数
				            			num_display_entries:2,//显示几个页码
				            			next_text:"下一页",//下一页按钮显示的内容
				            			next_show_always:true,//如果没有下一页  仍然显示按钮  但是灰化 
				            			prev_text:"上一页",//上一页按钮显示的内容
				            			prev_show_always:true,//如果没有上一页  不显示按钮 
				            			num_edge_entries:1,//页码多的时候...省略
				            			ellipse_text:"..."
				            		});
				            	}
				            }
				        })
				
			    },
			    GetRecordList: function (pageIndex) {
		    		 var url = $Url.BuildWorkFlowUrl("/sales/activity/recordList");
					 $.ajax({
				            type: "POST",
				            url: url,
				            dataType: "html",
				            data: {
				            	"activityNo": PageVar.ID,
				            	"pageIndex":pageIndex+1
				            },
				            error: function (request) {
				                //alert(request);
				            },
				            success: function (data) {
				            	//$("#selectRelationLevel").val($("#level").val());
				            	$("#record").html(data);
				            	//EnumList.GetEnumListToSelect($("#selectRelationLevel"),"dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action"));
				                if($("#totalCount1").html()!=0){
				            		$("#pagination1").pagination($("#totalCount1").html(), {//总记录条数
				            			callback: ManagePage.GetRecordList,//每次点击分页按钮的时候 执行该操作
				            			items_per_page:6,//每页显示多少条记录
				            			current_page:pageIndex,//当前页
				            			link_to:"javascript:void(0)",//不期望链接到某个目的地，只希望执行回调函数
				            			num_display_entries:2,//显示几个页码
				            			next_text:"下一页",//下一页按钮显示的内容
				            			next_show_always:true,//如果没有下一页  仍然显示按钮  但是灰化 
				            			prev_text:"上一页",//上一页按钮显示的内容
				            			prev_show_always:true,//如果没有上一页  不显示按钮 
				            			num_edge_entries:1,//页码多的时候...省略
				            			ellipse_text:"..."
				            		});
				            	}
				                
				              //导出Excel
				            	$("#btnExcel").click(function () {
				                    var url = $Url.BuildSalesUrl("/sales/applyEmployee/ajaxExportExcel?activityNo="+PageVar.ID);
				                    location.href= url;
				                });
				              //活动开始开始签到
			            		$("#updateStatus3").click(function(){
			            			if(confirm('确定可以开始签到了吗？')){
			            				var url = $Url.BuildSalesUrl("/sales/activity/ajaxReleaseActivity");
			            				 $.ajax({
			            		            type: "post",
			            		            url: url,
			            		            dataType: "json",
			            		            timeout: 30000,
			            		            data: {
			            		           	 releaseId: PageVar.ID,
			            		                status:3
			            		            },
			            		            beforeSend: function () {
			            		                $("#submit").attr("process", "processing");
			            		            },
			            		            error: function (XMLHttpRequest, textStatus, errorThrown) {
			            		                alert(errorThrown);
			            		            },
			            		            success: function (data, textStatus) {
			            		                if (data.errCode == "0000") {
			            		               	 alert("活动开始签到了！");
			            		               	var pageIndex=0;
			            		               	 ManagePage.GetRecordList(pageIndex);
			            		                } else {
			            		                    $("#msg").text(data.errDesc);
			            		                }
			            		            },
			            		            complete: function (XMLHttpRequest, textStatus) {
			            		                $("#submit").removeAttr("process");
			            		            }
			            		        });
			            			}else{}
			            		});
			            		$("#updateStatus4").click(function(){
			            			if(confirm('确定结束签到吗？')){
			            				var url = $Url.BuildSalesUrl("/sales/activity/ajaxReleaseActivity");
			            		   		 $.ajax({
			            		                type: "post",
			            		                url: url,
			            		                dataType: "json",
			            		                timeout: 30000,
			            		                data: {
			            		               	 releaseId: PageVar.ID,
			            		                    status:4
			            		                },
			            		                beforeSend: function () {
			            		                    $("#submit").attr("process", "processing");
			            		                },
			            		                error: function (XMLHttpRequest, textStatus, errorThrown) {
			            		                    alert(errorThrown);
			            		                },
			            		                success: function (data, textStatus) {
			            		                    if (data.errCode == "0000") {
			            		                   	 alert("活动结束签到了！");
			            		                   	 var pageIndex=0;
			            		                   	 ManagePage.GetRecordList(pageIndex);
			            		                    } else {
			            		                        $("#msg").text(data.errDesc);
			            		                    }
			            		                },
			            		                complete: function (XMLHttpRequest, textStatus) {
			            		                    $("#submit").removeAttr("process");
			            		                }
			            		            });
			            			}else{}
			            		});
				                
				                
				                
				            }
				        })
				
			    },
			    GetApplyList: function (pageIndex) {
			    	var url = $Url.BuildMarketUrl("/market/activityApply/applyList");
			    	$.ajax({
			    		type: "POST",
			    		url: url,
			    		dataType: "html",
			    		data: {
			    			"activityNo": PageVar.ID,
			    			"pageIndex":pageIndex+1
			    		},
			    		error: function (request) {
			    			//alert(request);
			    		},
			    		success: function (data) {
			    			//$("#selectRelationLevel").val($("#level").val());
			    			$("#apply").html(data);
			    			//EnumList.GetEnumListToSelect($("#selectRelationLevel"),"dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action"));
			    			if($("#applyTotalCount").html()!=0){
			    				$("#applyPagination").pagination($("#applyTotalCount").html(), {//总记录条数
			    					callback: ManagePage.GetApplyList,//每次点击分页按钮的时候 执行该操作
			    					items_per_page:10,//每页显示多少条记录
			    					current_page:pageIndex,//当前页
			    					link_to:"javascript:void(0)",//不期望链接到某个目的地，只希望执行回调函数
			    					num_display_entries:2,//显示几个页码
			    					next_text:"下一页",//下一页按钮显示的内容
			    					next_show_always:true,//如果没有下一页  仍然显示按钮  但是灰化 
			    					prev_text:"上一页",//上一页按钮显示的内容
			    					prev_show_always:true,//如果没有上一页  不显示按钮 
			    					num_edge_entries:1,//页码多的时候...省略
			    					ellipse_text:"..."
			    				});
			    			}
			    			
//			    			//导出Excel
//			    			$("#btnExcel").click(function () {
//			    				var url = $Url.BuildSalesUrl("/sales/applyEmployee/ajaxExportExcel?activityNo="+PageVar.ID);
//			    				location.href= url;
//			    			});
			    			
			    		}
			    	})
			    	
			    },
		InitQuery: function () {
	        $("#btnSearch").click(function () {
	        	var pageIndex = 0;
	            ManagePage.GetList(pageIndex);
		        
	        });
	    },
		Resize1: function(){
			//$("#content_center").css({"min-height":"803px","height":$("#Comment").height()+320});
			$("#content_center").css({"min-height":"803px","height":$(".activityTheme").height()+320});
		},
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
        if ($("#submit").length > 0)
            $("#submit").hide();

    },
    HideEditButton: function () {
        if ($("#edit").length > 0)
            $("#edit").hide();
        if ($("#submit").length > 0)
            $("#submit").show();

    },
    GetInfo: function (id) {
        var url = $Url.BuildSalesUrl("/sales/activity/ajaxGetActivity");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
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
                var activityUrl ="http://market.52touzi.com/baseInfo/activityDetails?id="+id;
                $('#qrcode').qrcode({width: 150,height: 150,text: activityUrl});
                if(data.showSignButton==true){
                $("#sign").removeAttr("type");
                $("#sign").attr("type","button");
            	}
                if(data.info.status==2&&data.showSignButton==false){
            	$(".registration").show();
            	}
				if (!$String.IsNullOrEmpty(data.info.activityTime)) {
					var activityTime = new Date(data.info.activityTime);
					$("#activityTime").val(activityTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.publisherTime)) {
					var publisherTime = new Date(data.info.publisherTime);
					$("#publisherTime").val(publisherTime.format("yyyy-MM-dd HH:mm:ss"));
					}
				FileManage.GetFileList();
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
    				if(data.info.status==1||data.info.status==5){
    					$("#release").show();
    				}else{
    					$("#release").hide();
    				}
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
	$("#activityNo").val(PageVar.ID);
	$("#btnSearch").click(function(){
		select.InitQuery();
		});
	$("#btnAdd").click(function () { ManagePage.GetAdd(); });
	
	$(".registration").hide();
	$("#sign").attr("type","hidden");
	$("#invite").click(function(){
		window.open=$Url.BuildSalesUrl("/sales/activity/list");
	});
    $("#back").click(function () {
//        window.location.href = $Url.BuildSalesUrl("/sales/activity/list");
        $EasyUI.Close();
    });
    $("#release").click(function(){
    	if(window.confirm('你确定要发布吗？')){
    		 var url = $Url.BuildSalesUrl("/sales/activity/ajaxReleaseActivity");
    		 $.ajax({
                 type: "post",
                 url: url,
                 dataType: "json",
                 timeout: 30000,
                 data: {
                	 releaseId: PageVar.ID,
                     status:2
                 },
                 beforeSend: function () {
                     $("#submit").attr("process", "processing");
                 },
                 error: function (XMLHttpRequest, textStatus, errorThrown) {
                     alert(errorThrown);
                 },
                 success: function (data, textStatus) {
                     if (data.errCode == "0000") {
                    	 alert("发布成功！");
                         window.location.href = $Url.BuildSalesUrl("/sales/activity/edit?id=" + data.errDesc);
                     } else {
                         $("#msg").text(data.errDesc);
                     }
                 },
                 complete: function (XMLHttpRequest, textStatus) {
                     $("#submit").removeAttr("process");
                 }
             });
            return true;
         }else{
            //alert("取消");
            return false;
        }

    });
//报名
    $("#sign").click(function(){
    	if(window.confirm('你确定要报名吗？')){
    		 var url = $Url.BuildSalesUrl("/sales/applyEmployee/ajaxSignApplyEmployee");
    		 $.ajax({
                 type: "post",
                 url: url,
                 dataType: "json",
                 timeout: 30000,
                 data: {
                	 activityNo: PageVar.ID,
                 },
                 beforeSend: function () {
                     $("#submit").attr("process", "processing");
                 },
                 error: function (XMLHttpRequest, textStatus, errorThrown) {
                     alert(errorThrown);
                 },
                 success: function (data, textStatus) {
                     if (data.errCode == "0000") {
                    	 alert("报名成功,希望准时参加活动！");
                         window.location.href = $Url.BuildSalesUrl("/sales/activity/edit?id=" + PageVar.ID);
                     } else {
                         $("#msg").text(data.errDesc);
                     }
                 },
                 complete: function (XMLHttpRequest, textStatus) {
                     $("#submit").removeAttr("process");
                 }
             });
            return true;
         }else{
            return false;
        }
    });
    
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }

	$("#activityTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
	$("#publisherTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});


    var activityAdd = $("#activityAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildSalesUrl("/sales/activity/ajaxEditActivity");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				title: $("#title").val(),
				activityTime: $("#activityTime").val().toTimetamp(),
				empName: $("#empName").val(),
				peopleNum: $("#peopleNum").val(),
				address: $("#address").val(),
				content: $String.Trim(CKEDITOR.instances.content.getData()),
				url: $("#url").val(),
				status: $("#status").val(),
				mark: $("#mark").val(),
				longitude: $("#longitude").val(),
				latitude: $("#latitude").val()
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info)
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildSalesUrl("/sales/activity/edit?id=" + data.errDesc);
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
    activityAdd.addRule([
    ]);
    
    
    	ManagePage.Resize1();
    	$('.tab_title>a').on("click",function() {
			if($(this).text()=='客户登记'){
				$("#content_center").css({"min-height":"803px","height":$("#record").height()+320});
			}else{
				ManagePage.Resize1();
			}
		});
        ManagePage.InitQuery();
        var pageIndex = 0;
        //我的客户ajax
        ManagePage.GetList(pageIndex);
        //销售人员情况
        ManagePage.GetSaleList(pageIndex);
        //签到登记表
        ManagePage.GetRecordList(pageIndex);
        //活动报名表
        ManagePage.GetApplyList(pageIndex);
        //客户等级
        EnumList.GetEnumListToEdit( "dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action"))
        //风险偏好
        EnumList.GetEnumListToEdit( "dicDataforCustomerCompanyRiskHobby", $Url.BuildCustomerUrl("/common/enumList.action"))
})

//邀请
function invit(customerNo){
	var url = $Url.BuildSalesUrl("/sales/applyCustomer/ajaxInvitApplyCustomer");
	 $.ajax({
         type: "POST",
         url: url,
         dataType: "json",
         data: {
         	activityNo:PageVar.ID,
         	customerNo:customerNo
         },
         error: function (request) {
             //alert(request);
         },
         success: function (data) {
        	 //我的客户ajax
        	 var pageIndex = 0;
             ManagePage.GetList(pageIndex);
             //销售人员情况
             ManagePage.GetSaleList(pageIndex);
             //签到登记表
             ManagePage.GetRecordList(pageIndex);
            alert("邀请成功已发短信！");
         }
     })
};

//员工签到
function empSign(id){
	if(confirm('确定本人已到达并签到吗？')){
		var url = $Url.BuildSalesUrl("/sales/applyEmployee/ajaxArriveApplyEmployee");
		 $.ajax({
	        type: "POST",
	        url: url,
	        dataType: "json",
	        data: {
	        	empId:id
	        },
	        error: function (request) {
	            //alert(request);
	        },
	        success: function (data) {
	        var pageIndex = 0;
	        //签到登记表
	        ManagePage.GetRecordList(pageIndex);
	        alert("签到成功！");
	        }
	    })
     }else{
    }
	
}

//客户签到
function customerSign(id){
	if(confirm('确定本人已到达并签到吗？')){
		var url = $Url.BuildSalesUrl("/sales/applyCustomer/ajaxSignApplyCustomer");
		 $.ajax({
	        type: "POST",
	        url: url,
	        dataType: "json",
	        data: {
	        	activityNo:PageVar.ID,
	        	customerId:id
	        },
	        error: function (request) {
	            //alert(request);
	        },
	        success: function (data) {
	           var pageIndex = 0;
	 	        //签到登记表
	 	       ManagePage.GetRecordList(pageIndex);
	           alert("签到成功！");
	        }
	    })
	}else{
    }
}


//附件
var FileManage = {
    BindFile: function (pathList) {
      if($("#edit").val()=="修改"){
    	  var readOnly = false;
      }else{
    	  var readOnly = true;
      }
            $(".upload").Upload({
                inputID: "uploadInput",
                readOnly: readOnly,
                multiple: true,
                fileType: 1,
                url: $Url.BuildSalesUrl("/upload.action"),
                pathList: (pathList == undefined || pathList == null)?[]:pathList,
                success: FileManage.SavaFileToDB,
                deleteFile: FileManage.DeleteFile,
                title: "活动附件"
            });
        
    },
    DeleteFile: function (o) {
        if (confirm("是否要删除当前文件")) {
            var id = $(o).attr("id").split("_")[1];
            var url = $Url.BuildSalesUrl("/sales/activityAttachment/ajaxDeleteFile");
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {id: id
                },
                beforeSend: function () {
                    $(o).after("<p></p>");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        $(o).parent().remove();
                    } else {
                        alert(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $(o).next().remove();
                }
            });
        }
    },
    SavaFileToDB: function (fileName, relativePath) {
        var url = $Url.BuildSalesUrl("/sales/activityAttachment/ajaxSaveFilePath");

        var fileID = 0;
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async: false,
            data: {id: PageVar.ID,
                name: fileName,
                path: relativePath
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    //ProductAdd.Resize();
                    fileID = data.errDesc;
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });

        return fileID;
    },
    GetFileList: function () {
        var url = $Url.BuildSalesUrl("/sales/activityAttachment/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {activityNo: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    var pathList = [];
                    $.each(data.resultList, function (index, content) {
                    	pathList.push({
                    		id: content.id,
                    		name: content.name,
                    		path: $Url.BuildFileUrl(content.path)
                        });
                    })
                    FileManage.BindFile(pathList);
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}


    
