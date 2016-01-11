var ManagePage = {
	Resize: function () {
        $("#content_center").css("min-height", "1100px");
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
    	var activitID=ManagePage.GetUrlActivitNo();
    	if(!$String.IsNullOrEmpty(activitID)){
    		if ($("#edit").length > 0) {
                $("#edit").show();
                $("#submitExamine").hide();
                $("#examine").show();
                $("#submit").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").hide();
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
                $("#examine").hide();
            }
            if ($("#submit").length > 0)
                $("#submit").show();
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
        var url = $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/ajaxGetTempRecruitNeed");
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
                $Util.DataToVal(data.info,ElementVar);
                $Util.DataToVal(data.detailInfo,ElementVar);
                $("#workDate").val(new Date(data.detailInfo.workDate).format("yyyy-MM-dd"));
                $("#deptNo").val(data.detailInfo.deptNo);
                $("#deptNo").trigger("change");
                $("#positionNo").val(data.detailInfo.positionNo);
                $("#financialYear").val(data.info.financialYear);
                $("#addPeople").val(data.detailInfo.addPeople);
                $("#activitiNo").val(data.info.activitiNo);
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                };
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
                ManagePage.GetAuditComment(data.info.activitiNo,data.empName);
                ManagePage.GetWindow(data.info.activitiNo);
            },
            complete: function (XMLHttpRequest, textStatus) {
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
					window.location.href = $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/edit?id=" + PageVar.ID+"&activitiNo=" + data.activitiNo);
				}else{
					alert("审批成功");
//					$("#examine").hide();
					window.location.href = $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/edit?id=" + PageVar.ID+"&activitiNo=" + activitiNo);
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
				var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartTempRecruitNeedProcess.action');
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
     ManagePage.Resize();
	 $("#workDate").click(function () {
			WdatePicker({dateFmt: 'yyyy-MM-dd'});
		});
	 EnumList.GetEnumListToSelect($("#deptNo"), "dept", $Url.BuildProductUrl("/common/enumList.action"));
	 
	 $("#deptNo").change(function () {	
		 EnumList.GetEnumListToSelect($("#positionNo"), "positionListBydeptType1", $Url.BuildProductUrl("/common/enumList.action"),$("#deptNo").val());
		  });
	 $("#deptNo").trigger("change");
	 $("#back").click(function () {
		 //history.go(-1);
         //window.location.href = $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/list");
//		 var urlArr = $("#backUrl").val().split(",");
//	    	if(urlArr.length==2){
//	    		window.location.href = urlArr[1];
//	    	}else{
//	    		window.location.href = urlArr[0];
//	    	}
	    	//window.location.href = $("#backUrl").val();
         $EasyUI.Close();
    });

	    $("#edit").click(function(){
	          
	            ManagePage.EnableInput();
                ManagePage.HideEditButton();
	    });
	    $("#submit").click(function(){
	      
	        ManagePage.EnableInput();
            ManagePage.ShowEditButton();
	});
    $('.trackBtn').on('click',function(){
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
        var activitiNo = ManagePage.GetUrlActivitNo();
        initAll.GetAuditProcess(url,activitiNo);
    });
	    
    if (Number(PageVar.ID) == 0) {
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
               }
             
             });
    	
    	ManagePage.EnableInput();
        ManagePage.HideEditButton();
        }
    else {
        ManagePage.GetInfo(PageVar.ID);
        ManagePage.DisableInput();
    }
    

    
    
    var tempRecruitNeedAdd = $("#tempRecruitNeedAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/ajaxEditTempRecruitNeed");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";
            var strs=ManagePage.GetUrlActivitNo();
            var info = {
                id: PageVar.ID,
				code: $("#code").val(),
				financialYear: $("#financialYear").val(),
				//companyNo: $("#companyNo").val()
				//activitiNo: $("#activitiNo").val(),
				//editComment: $("#editComment").val()
            }
            var detailInfo = {
                    id: PageVar.ID,
    				//tempRecruitNeedNo: $("#tempRecruitNeedNo").val(),
    				deptNo: $("#deptNo").val(),
    				positionNo: $("#positionNo").val(),
    				addPeople: $("#addPeople").val(),
    				needCause: $("#needCause").val(),
    				jobDuties: $("#jobDuties").val(),
    				sex: $("#sex").val(),
    				education: $("#education").val(),
    				major: $("#major").val(),
    				age: $("#age").val(),
    				language: $("#language").val(),
    				certificate: $("#certificate").val(),
    				skill: $("#skill").val(),
    				experience: $("#experience").val(),
    				ability: $("#ability").val(),
    				other: $("#other").val(),
    				workDate: $("#workDate").val().toTimetamp()
                }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    activitiID:strs,
                    info: JSON.stringify(info),
                    detailInfo: JSON.stringify(detailInfo)
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/edit?id=" + data.errDesc+"&activitiNo="+strs);
                        
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
    tempRecruitNeedAdd.addRule([
    //{
     //   ele:"#code",
     //   datatype:"*",
        //ignore:"ignore",
    //    sucmsg:" "
    // }, 
     {
       ele:"#financialYear",
       datatype:"n",
       //ignore:"ignore",
       errormsg:"请填数字",
       sucmsg:" "
      },
      {
         ele:"#addPeople",
         datatype:"n",
         //ignore:"ignore",
         errormsg:"请填数字",
         sucmsg:" "
      },
      {
          ele:"#needCause",
          datatype:"*",
          //ignore:"ignore",
          sucmsg:" "
       },
      {
          ele:"#jobDuties",
          datatype:"*",
          //ignore:"ignore",
          sucmsg:" "
       },
       {
           ele:"#skill",
           datatype:"*",
           //ignore:"ignore",
           sucmsg:" "
        },
        {
            ele:"#experience",
            datatype:"*",
            //ignore:"ignore",
            sucmsg:" "
         },
         {
             ele:"#ability",
             datatype:"*",
             //ignore:"ignore",
             sucmsg:" "
          },
          {
              ele:"#workDate",
              datatype:"*",
              //ignore:"ignore",
              sucmsg:" "
           }
        
    ]);
})
