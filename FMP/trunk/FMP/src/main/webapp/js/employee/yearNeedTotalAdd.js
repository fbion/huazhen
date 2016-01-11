var ManagePage = {
    Resize: function () {
        $("#content_center").css({"min-height":"803px","height":$('.wrappContent').height()+100});
    },
    EnableInput : function() {
        $.each($(".data"), function(index, content) {
            var id = $(this).attr("id");
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
    },
    DisableInput : function() {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").show();
            }
//            if ($("#submit").length > 0)
//                $("#submit").hide();
    	}else{
    		 if ($("#edit").length > 0) {
    	            $("#edit").show();
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
                $("#examine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
    	}else{
    		if ($("#edit").length > 0) {
                $("#edit").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
    	}
    },
    GetInfo : function(id) {
        var url = $Url
            .BuildEmployeeUrl("/employee/yearNeedTotal/ajaxGetYearNeedTotal");
        $.ajax({
            type : "post",
            url : url,
            dataType : "json",
            timeout : 30000,
            data : {
                id : id
            },
            beforeSend : function() {
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success : function(data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);

                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function() {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();
                    });
                }
                
//                if(data.info.activitiNo==""){
//                	$("#examine").val("提交审批");
//                	if($("#submit").css("display")=="inline"){
//                		$("#examine").hide();
//                	}else{
//                		$("#examine").show();
//                	}
//                }else{
//                	$("#examine").val("审批");
//                	if($("#activitiStatus").val()=="1"){//申请人查看
//                		$("#edit").hide();
//                		$("#submit").hide();
//                		$("#examine").hide();
//                	}else if($("#activitiStatus").val()=="2"){//申请人修改
//                		$("#examine").hide();
//                	}else if($("#activitiStatus").val()=="3"){//审核人审核
//                		$("#edit").hide();
//                		$("#submit").hide();
//                		$("#examine").show();
//                	}else{
//                		$("#edit").hide();
//                		$("#submit").hide();
//                		$("#examine").hide();
//                	}
//                }
                ManagePage.GetAuditComment(data.info.activitiNo,$("#fmpEmpName").html());
                ManagePage.GetWindow(data.info.activitiNo);
            },
            complete : function(XMLHttpRequest, textStatus) {
            }
        });
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
                   // alert(request);
                },
                success: function (data) {
                	if(empName!=null&&empName!=""&&data.indexOf(empName)>-1){
                		$("#examine").hide();
                	}
                    $("#aduitComment").append(data);
                    $("#proposerName").val($("#checkName1").val());
                    $("#submTime").val($("#checkTime1").val());
                    $("#check1").hide();
                }
            })
    },
    StartAudit:function(obj,url,activitiNo){
    	var uri=window.location.href;
    	
		var sendData={
				per:obj.val(),
				id: $("#yearNeedTotalId").val(),
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
//					alert("提交成功");
					window.location.href = $Url.BuildEmployeeUrl("/employee/yearNeedTotal/edit?id=" + $("#yearNeedTotalId").val()+"&activitiNo=" + data.activitiNo);
				}else{
					alert("审批成功");
//					$("#examine").hide();
					window.location.href = $Url.BuildEmployeeUrl("/employee/yearNeedTotal/edit?id=" + $("#yearNeedTotalId").val()+"&activitiNo=" + activitiNo);
				}
//				$("#taskCommet").val("");
//				$('#w1').window('close');
//				window.location.reload();
			},
			complete: function (XMLHttpRequest, textStatus) {
			}
		});
    },
    GetWindow:function(activitiNo){
    	if ($String.IsNullOrEmpty(activitiNo)) {
			$("#submitExamine").click(function () {
				var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartYearNeedProcess.action');
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
$(function() {
	
    $("#mssage").hide();
    if($("#financialYears").val()!=null){
        var yearNeedList = {
            GetYearNeedListToSelect : function(yearNeedUrl, param) {
                $.ajax({
                    type : "post",
                    async : false,
                    url : yearNeedUrl,
                    dataType : "html",
                    cache : true,
                    data : {
                        param : param
                    },
                    beforeSend : function(XMLHttpRequest) {
                    },
                    success : function(data) {
                        $(".position").html(data);
                        var i = 0;
                        $(".addEmpTotal").each(function(index) {
                            i = parseInt(i) + parseInt($(this).val());
                        });
                        $("#AllEmp").val(i);
                        ManagePage.Resize();
                        ManagePage.DisableInput();
                        ManagePage.ShowEditButton();
                        if ($("#edit").length > 0) {
                            $("#edit").click(function () {
                                ManagePage.EnableInput();
                                ManagePage.HideEditButton();
                            });
                        }
                    },
                    complete : function(XMLHttpRequest, textStatus) {
                    },
                    error : function() {
                        alert("内部错误1");
                    }
                });
            }
        }
        var yearNeedUrl = $Url.BuildEmployeeUrl('/employee/yearNeed/ajaxListYearNeed');
        yearNeedList.GetYearNeedListToSelect(yearNeedUrl, $("#financialYears").val());
    }
    else{
        $("#btn").hide();
        $("#mssage").show();
    }
    var yearNeedTotalAdd = $("#yearNeedTotalAdd")
        .Validform(
        {
            tiptype : function(msg, o, cssctl) {
                var objtip = o.obj.siblings(".Validform_checktip");
                cssctl(objtip, o.type);
                objtip.text(msg);
            },
            callback : function(form) {
                if (!($("#submit").attr("process") === undefined)) {
                    return false;
                }
                var strs=ManagePage.GetUrlActivitNo();
                var url = $Url
                    .BuildEmployeeUrl("/employee/yearNeedTotal/ajaxEditYearNeedTotal");
                var oper = "add";
                var info = {
                    id : PageVar.ID,
                    code : $("#totalCode").val(),
                    financialYear : $("#financialYears").val(),
                    total : $("#AllEmp").val(),
                    activitiNo : $("#activitiNo").val(),
                    editComment : $("#editComment").val()
                }
                $.ajax({
                    type : "post",
                    url : url,
                    dataType : "json",
                    timeout : 30000,
                    data : {
                        oper : oper,
                        activitiID:strs,
                        info : JSON.stringify(info)
                    },
                    beforeSend : function() {
                        $("#submit").attr("process","processing");
                    },
                    error : function(XMLHttpRequest,textStatus, errorThrown) {
                        alert(errorThrown);
                    },
                    success : function(data, textStatus) {
                        if (data.info.financialYear > 0) {
                            var yearNeedUrl = $Url.BuildProductUrl('/employee/yearNeed/ajaxListYearNeed');
                            $(".position").empty();
                            $("#positionList").empty();
                            yearNeedList.GetYearNeedListToSelect(yearNeedUrl,data.info.financialYear);
                            $("#totalCode").val(data.info.code);
                        } else {
                            $("#msg").text(data.errDesc);
                        }

                    },
                    complete : function(XMLHttpRequest,
                                        textStatus) {
                        $("#submit").removeAttr("process");
                    }
                });
                return false;
            }
        });
    yearNeedTotalAdd.addRule([ {
        ele : ".totalCode",
        datatype : "*",
        //ignore:"ignore",
        nullmsg : "请输入编制编号！",
        sucmsg : " "
    } ]);

   
    $(".back").click(function (){ 
  	  window.open($Url.BuildEmployeeUrl("/employee/yearNeedTotal/list"));
   });
    ManagePage.GetInfo(PageVar.ID);
})
