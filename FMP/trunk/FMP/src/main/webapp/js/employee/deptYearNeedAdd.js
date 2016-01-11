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
    ShowEditButton: function () {
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").show();
                $("#submitExamine").hide();
                $("#submit").hide();
            }
//            if ($("#submit").length > 0)
//                $("#submit").hide();
    	}else{
    		 if ($("#edit").length > 0) {
    	            $("#edit").show();
    	            $("#submitExamine").show();
    	        }
    	        if ($("#submit").length > 0)
    	            $("#submit").hide();
    	}
    },
    HideEditButton: function () {
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#submitExamine").hide();
//                $("#examine").hide();
            }
            if ($("#submit").length > 0){
            	 $("#submit").show();
            	 $("#examine").hide();
            }
               
    	}else{
    		if ($("#edit").length > 0) {
                $("#edit").hide();
                $("#submitExamine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
    	}
    },
    GetInfo: function (id) {
    	var activityNo = ManagePage.GetUrlActivitNo();
        var url = $Url.BuildEmployeeUrl("/employee/deptYearNeed/ajaxGetDeptYearNeed");
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
                ManagePage.DisableInput();
                ManagePage.ShowEditButton();
                ManagePage.GetAuditComment(activityNo,data.empName);
                ManagePage.GetWindow(activityNo);
                $("#deptNo").val(data.info.deptNo);
                $("#financialYear").val(data.info.financialYear);
                $("#code").val(data.info.code);
                $("#deptNo").trigger("change");
                $("#nowEmpTotal").val(data.info.nowEmpTotal);
                $("#addEmpTotal").val(data.info.addEmpTotal);
                $.each(data.deptYearNeedDetails,function(i,value){
                	var td=$(".deptYearListClass").eq(i).find("td");
                	td.eq(0).children().val(value.id);
                	td.eq(1).children().val(value.positionNo);
                	td.eq(2).children().val(value.positionName);
                	td.eq(3).children().val(value.nowEmp);
                	td.eq(4).children().val(value.addEmp);
                	td.eq(5).children().val(value.requireReason);
                	td.eq(6).children().val(value.empRequire);
                	if(value.workDate!=null){
                    td.eq(7).children().val(new Date(value.workDate).format("yyyy-MM-dd"));
                    };
                    td.eq(8).children().val(value.mark);
                });
                /*ManagePage.DisableInput();
                ManagePage.ShowEditButton();*/
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();  
                    });
                }
                /*ManagePage.GetAuditComment(data.info.activitiNo);
                ManagePage.GetWindow(data.info.activitiNo);*/
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
	InitView:function(){
		$("#content_center").css({"min-height":"803px","height":$(".wrappContent").height()+300});
	},
	GetAuditComment: function (activitiNo,empName) {
    	var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditComment");
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                	"activitiNo":activitiNo
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                	if(empName!=null&&empName!=""&&data.indexOf(empName)>-1){
//                		$("#examine").hide();
                	}
                    $("#aduitComment").append(data);
                }
            })
    },
    StartAudit:function(obj,url,activitiNo){
    	var uri=window.location.href;
		var sendData={
				per:obj.val(),
				id: PageVar.ID,
				activitiNo:activitiNo,
				comment:$("#taskCommet").val(),
				uri:uri
		};
		$.ajax({
			type: "post",
			url: url,
			dataType: "json",
			timeout: 30000,
			data: sendData,
			beforeSend: function () {
			},
			error: function (XMLHttpRequest, textStatus, errorThrown,request) {
				alert(errorThrown);
				//alert(request);
			},
			success: function (data, textStatus) {
				if ($String.IsNullOrEmpty(activitiNo)) {
					alert("提交成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/deptYearNeed/edit?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
				} else {
					alert("审批成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/deptYearNeed/edit?id=" + PageVar.ID+"&activitiNo=" + activitiNo);
				}
			},
			complete: function (XMLHttpRequest, textStatus) {
			}
		});
    },
	GetWindow: function (activitiNo) {
		if ($String.IsNullOrEmpty(activitiNo)) {
			$("#submitExamine").click(function () {
				var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartDeptYearNeedProcess.action');
				ManagePage.StartAudit($("#submit1"), url, activitiNo);
			});
		} else {
			$("#examine").click(function () {
				$('#w1').window('open');
			});
			$(".examine").click(function(){
				var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
				ManagePage.StartAudit($(this), url, activitiNo);
			});
		}
	},
    GetUrlActivitNo:function(){
    	var urlTemp = location.search;
        var theRequest = new Object();
        var strs="";
        if (urlTemp.indexOf("?") != -1) {
           var str = urlTemp.substr(1);
           if(str.indexOf("activitiNo=") != -1){
        	   strs = str.split("activitiNo=")[1];
           }
        }
        return strs;
    }
}

$(function () {
	ManagePage.InitView();
	  EnumList.GetEnumListToSelect($("#deptNo"), "dept", $Url.BuildProductUrl("/common/enumList.action"));
	
    $("#back").click(function () {
        window.close();
    });
	$('.trackBtn').on('click',function(){
		var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
		var activitiNo = ManagePage.GetUrlActivitNo();
		initAll.GetAuditProcess(url,activitiNo);
	});
   $("#deptNo").change(function () {
    	EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),$("#deptNo").val());
    	var positionListUrl = $Url.BuildProductUrl('/employee/deptYearNeedDetail/ajaxListDeptYearNeedDetail');
    	$(".position").empty();
		$("#positionList").empty();
		deptPositionList.GetPositionListToSelect(positionListUrl, $("#deptNo").val()); 
		ManagePage.InitView();
   });
   var deptPositionList = {
		GetPositionListToSelect : function(listUrl, param) {
   		$.ajax({
   			type : "post",
   			async : false,
   			url : listUrl,
   			dataType : "html",
   			cache : true,
   			beforeSend : function(XMLHttpRequest) {
   			},
   			data : {
   				param : param
   			},
   			success : function(data) {
   				$(".position").html(data);
   				/*ManagePage.GetAuditComment(data.info.activitiNo);
                ManagePage.GetWindow(data.info.activitiNo);*/
   				
	   			$(".workDate").click(function () {
	   				WdatePicker({dateFmt: 'yyyy-MM-dd'});
	   			});
				ManagePage.InitView();
   				var deptYearNeedAdd = $("#deptYearNeedAdd").Validform({
   			        tiptype:function (msg, o, cssctl) {
   			            var objtip = o.obj.siblings(".Validform_checktip");
   			            cssctl(objtip, o.type);
   			            objtip.text(msg);
   			        },
   			        callback: function (form) {
   			            if (!($("#submit").attr("process") === undefined)) {
   			                return false;
   			            }
   			            var deptYearNeedDetails = [];
   			            var url = $Url.BuildEmployeeUrl("/employee/deptYearNeed/ajaxEditDeptYearNeed");
   			            var oper = "add";
   			            if (Number(PageVar.ID) != 0)
   			                oper = "edit";

   			            var info = {
   			                id: PageVar.ID,
   							code: $("#code").val(),
   							financialYear: $("#financialYear").val(),
   							companyNo: $("#companyNo").val(),
   							deptNo: $("#deptNo").val(),
   							//activitiNo: $("#activitiNo").val(),
   							editComment: $("#editComment").val()
   			            }
			             if(info.id>0){
		            		$(".deptYearListClass").each(function(index,element){
			            	deptYearNeedDetails.push({
			            		id:$(element).find(".id").val(),
			            		positionNo:$(element).find(".positionNo").val(),
			            		nowEmp:$(element).find(".nowEmp").val(),
			            		addEmp:$(element).find(".addEmp").val(),
			            		requireReason:$(element).find(".requireReason").val(),
			            		empRequire:$(element).find(".empRequire").val(),
	   							workDate:$(element).find(".workDate").val(),
			            		mark:$(element).find(".mark").val()
			            		})
			            		
			                  });
		            		}else{
				             $(".deptYearListClass").each(function(index,element){
				            	deptYearNeedDetails.push({
				            		positionNo:$(element).find(".positionNo").val(),
				            		nowEmp:$(element).find(".nowEmp").val(),
				            		addEmp:$(element).find(".addEmp").val(),
				            		requireReason:$(element).find(".requireReason").val(),
				            		empRequire:$(element).find(".empRequire").val(),
		   							workDate:$(element).find(".workDate").val(),
				            		mark:$(element).find(".mark").val()
				            		})
				            		
				            });
		            	}
   			         var strs=ManagePage.GetUrlActivitNo();
   			            $.ajax({
   			                type: "post",
   			                url: url,
   			                dataType: "json",
   			                timeout: 30000,
   			                data: {
   			                	activitiID:strs,
   			                    oper: oper,
   			                    info: JSON.stringify(info),
   			                    deptYearNeedDetails:JSON.stringify(deptYearNeedDetails)
   			                },
   			                beforeSend: function () {
   			                    $("#submit").attr("process", "processing");
   			                },
   			                error: function (XMLHttpRequest, textStatus, errorThrown) {
   			                    alert(errorThrown);
   			                },
   			                success: function (data, textStatus) {
   			                    if (data.errCode == "0000") {
   			                        window.location.href = $Url.BuildEmployeeUrl("/employee/deptYearNeed/edit?id=" + data.errDesc+"&activitiNo="+strs);
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
   			    deptYearNeedAdd.addRule([
   			                       {
   			                           ele:".financialYear",
   			                           datatype:"n",
   			                           //ignore:"ignore",
   			                           errormsg:"请输入数字类型",
   			                           sucmsg:" "
   			                       },
   			                       {
   			                           ele:".addEmp",
   			                           datatype:"n",
   			                           //ignore:"ignore",
   			                           errormsg:"请填数字",
   			                           sucmsg:" "
   			                       }
   			                    
   			    ]);
   			},
   			complete : function(XMLHttpRequest, textStatus) {
   			},
   			error : function() {
   				// 请求出错处理
   				alert("内部错误1");
   			}
   		});
   	}	
   }
   if (Number(PageVar.ID) == 0) {
	   ManagePage.EnableInput();
       ManagePage.HideEditButton();
       var url = $Url.BuildEmployeeUrl("/employee/employee/ajaxExtendEmp");
  	 $.ajax({
           type: "post",
           url: url,
           dataType: "json",
           timeout: 30000,
           data: {},
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
               $Util.DataToVal(data.employee,ElementVar);
               $("#deptNo").val(data.employee.deptNo);
               $("#code").val("");
               EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),data.employee.deptNo);
	           	var positionListUrl = $Url.BuildProductUrl('/employee/deptYearNeedDetail/ajaxListDeptYearNeedDetail');
	    	   	$(".position").empty();
	    	   	$("#positionList").empty();
	    	   	deptPositionList.GetPositionListToSelect(positionListUrl,data.employee.deptNo);
           
             }
           
           });
       }
   else {
       ManagePage.GetInfo(PageVar.ID);
       ManagePage.DisableInput();
   }
    
})
