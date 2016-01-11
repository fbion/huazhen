var ManagePage = {
		InitGrid: function () {
	        //grid start
	        $("#gridTable").jqGrid({
	            url: $Url.BuildEmployeeUrl('/employee/recruitFollow/ajaxListRecruitFollow.action'),
	            editurl: $Url.BuildEmployeeUrl("/employee/recruitFollow/ajaxEditRecruitFollow.action"),
	            datatype: "json",
	            mtype: 'GET',
	            colNames: ["操作","id","recruitId","内容","备注","录入时间"],
	            colModel: [

					{
						name: "act", index: "act", width: 60, align: "center", sortable: false
					},
					{
						name: "id", index: "id",hidden:true,width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
					},
					{
						name: "recruitId", index: "recruitId",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
					},
					{
						name: "content", index: "content", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
					},
					{
						name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
					},
					{
						name: "inTime", index: "inTime", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
					} 
	            ],
	            sortname: "id",
	            sortorder: "desc",
	            viewrecords: true,
	            rowNum: 10,
	            rowList: [10],
	            altclass: "altRowsColour",
	            shrinkToFit:true,
	            autowidth: true,
	            height: "auto",
	            multiselect: true,
	            prmNames: {
	                search: "search",
	                page: "pageIndex",
	                rows: "pageSize"
	            },
	            jsonReader: {
	                root: "resultList",
	                page: "pageIndex",
	                total: "pageCount",
	                records: "recordCount",
	                repeatitems: false
	            },
	            postData:{rid:PageVar.ID},
	            pager: "#gridPager",
	            gridComplete: function () {
	                //var space = "|";
	                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
	                var inTimes = $("#gridTable").jqGrid('getCol', 'inTime', true);
	                for (var i = 0; i < ids.length; i++) {
	                    var id = ids[i].id;
	                    var inTime = inTimes[i].value;
	                    var detail = "";
	                    var edit = "";

	                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
	                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

	                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
	                    $("#gridTable").jqGrid("setRowData", id, {inTime:inTime.replace("T"," ")});
	                }
	            }
	        });
	    },
		Resize : function() {
			$("#content_center").css("min-height", "1200px");
		},
	    InitQuery: function () {
	        $("#btnSearch").click(function () {

	            $("#gridTable").jqGrid('setGridParam', {
	                datatype: "json",
	                //postData: { "byName": byName },
	                page: 1
	            }).trigger("reloadGrid");
	        });
	    },
	    GetDetail: function (index) {
	    	$("#Follow").show();
			var result = ManagePage.getFollowInfo(index);
			$("#inContent").val(result.content);
			$("#inEditComment").val(result.editComment);
			$("#inID").val(result.id);
			$("#inContent").attr("disabled","disabled");
			$("#inEditComment").attr("disabled","disabled");
	    },
	    GetAdd: function () {
            $EasyUI.NewTab("Add",$Url.BuildEmployeeUrl("/employee/recruitFollow/edit"));
	    },
		getFollowInfo : function(id) {
			var result;
			var url = $Url
					.BuildEmployeeUrl("/employee/recruitFollow/ajaxGetRecruitFollow");
			$.ajax({
				type : "post",
				url : url,
				async : false,
				data : {
					id : id
				},
				beforeSend : function() {
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
				},
				success : function(data, textStatus) {
					result = data.info;
				},
				complete : function(XMLHttpRequest, textStatus) {
				}
			});
			return result;
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
        var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecord/ajaxGetRecruitAskRecord");
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
                $("#resumeSource").val(data.info.resumeSource);
                $("#positionNo").val(data.info.positionNo);

                $("#isInterview").val(data.info.isInterview);
                $("#isEmploy").val(data.info.isEmploy);
				if (!$String.IsNullOrEmpty(data.info.firstContactTime)) {
					var firstContactTime = new Date(data.info.firstContactTime);
					$("#firstContactTime").val(firstContactTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.firstTime)) {
					var firstTime = new Date(data.info.firstTime);
					$("#firstTime").val(firstTime.format("yyyy-MM-dd"));
					}
				if (!$String.IsNullOrEmpty(data.info.secondTime)) {
					var secondTime = new Date(data.info.secondTime);
					$("#secondTime").val(secondTime.format("yyyy-MM-dd"));
					}

				$("#inUserNo").val(data.inEmpName);
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
//                    $("#edit").click(function () {
                        ManagePage.EnableInput();
//                        ManagePage.HideEditButton();
                        $("#edit").hide();
                        $("#submit").show();
//                    });
                }
                $.ajax({
                    method: "POST",
                    url: $Url.BuildEmployeeUrl("/common/enumList.action"),
                    data: {
                        type: "positionList"
                    },
                    success: function (data) {
                        $("#positionNo").select2({
                            width:150,
                            placeholder: "请选择",
                            data: ManagePage.format(data)
                        });
                    }
                });
                FileManage.GetFileList();
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
        format:function(data){
        var result = [];
        $.each(data.listItems,function(i,item) {
            var row = {};
            row.id = item.value;
            row.text = item.text;
            result.push(row);
        });
        return result;
    }
}
$(function () {
	ManagePage.Resize();
    $("#back").click(function () {
        $EasyUI.Close();
    });
    $.ajax({
        method: "POST",
        url: $Url.BuildEmployeeUrl("/common/enumList.action"),
        data: {
            type: "positionList"
        },
        success: function (data) {
            $("#positionNo").select2({
                width:150,
                placeholder: "请选择",
                data: ManagePage.format(data)
            });
        }
    });
    EnumList.GetEnumListToSelect($("#resumeSource"), "resumeSource", $Url.BuildEmployeeUrl("/common/enumList.action"));
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();

        FileManage.BindFile();
        //EnumList.autoComplete($("#positionNo"),"positionList",$Url.BuildEmployeeUrl("/common/enumList.action"));
        $("#inUserNo").val($("#fmpEmpName").text());
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }

	$("#firstContactTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
	$("#firstTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});
	$("#secondTime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd'});
	});

	$("#btnAdd").click(function () {
//		ManagePage.GetAdd();
		$("#Follow").show();
		$("#inContent").val("");
		$("#inEditComment").val("");
		$("#inID").val("");
	});
	$("#editFollow").click(function () {
		$("#inContent").removeAttr("disabled");
		$("#inEditComment").removeAttr("disabled");
	});
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    var recruitAskRecordAdd = $("#recruitAskRecordAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        datatype:{
        	"verifyEmail": function (gets, obj, curform, datatype) {
                var reg=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                if (!reg.test(gets)){
                    return false;
                }
            },
            "verifyTel": function (gets, obj, curform, datatype) {

                var reg = /^\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                if (!reg.test(gets)) {
                    return false;
                }
                	return true;
            },
            "verifySelect": function (gets, obj, curform, datatype) {
            	if (gets == "0" || gets == "")
            		return false;
            	else
            		return true;
            }
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecord/ajaxEditRecruitAskRecord");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				name: $("#name").val(),
				resumeSource: $("#resumeSource").val(),
				resumeAttachment: $("#upLoadPath").html(),
				firstContactTime: $("#firstContactTime").val().toTimetamp(),
				workCondition: $("#workCondition").val(),
				positionNo: $("#positionNo").val(),
				cellphone: $("#cellphone").val(),
				email: $("#email").val(),
				firstTime: $("#firstTime").val().toTimetamp(),
				isInterview: $("#isInterview").val(),
				secondTime: $("#secondTime").val().toTimetamp(),
				isEmploy: $("#isEmploy").val(),
				firstContactSituation: $("#firstContactSituation").val(),
				visitRecord: $("#visitRecord").val(),
				laterContactRecord: $("#laterContactRecord").val(),
				editComment: $("#editComment").val()
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
                    	if (confirm("提交成功，是否继续修改？")){
                    		window.location.href = $Url.BuildEmployeeUrl("/employee/recruitAskRecord/edit?id=" + data.errDesc);
                    	}else{
                    		window.location.href = $Url.BuildEmployeeUrl("/employee/recruitAskRecord/list");
                    	}
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
    var recruitFollowAdd = $("#recruitFollowAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/recruitFollow/ajaxEditRecruitFollow");
            var oper = "add";
            if ($("#inID").val()!= null && $("#inID").val()!="")
                oper = "edit";

            var info = {
                id: $("#inID").val(),
				recruitId: PageVar.ID,
				content: $("#inContent").val(),
				editComment: $("#inEditComment").val()
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
                        //window.location.href = $Url.BuildEmployeeUrl("/employee/recruitFollow/edit?id=" + data.errDesc);
                    	 location.reload();
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
    recruitAskRecordAdd.addRule([
		{
			ele:"#name",
		    dataType:"*",
		    nullmsg:"请填写姓名",
		    sucmsg:" ",
		    errmsg:"请如实输入姓名"
		},
		{
			ele:"#firstContactTime",
			dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
			//dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
			nullmsg:"请填写首次联系时间",
			sucmsg:" ",
			errmsg:"请填写正确的时间"
		},
		{				
		    ele:"#cellphone",
            datatype: "m",
		    ignore:"ignore",
		    nullmsg:"",
		    errormsg:"请填写正确的手机号码",
		    sucmsg:" "
		},
        {
            ele: "#email",
            datatype: "verifyEmail",//邮箱的干活
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请输入正确的邮箱",
            sucmsg: " "
        }                        
    ]);
    
    $("#isInterview").off().change(function(){
    	if($("#isInterview option:selected").val()==1){
    		recruitAskRecordAdd.addRule([
				{				
				    ele:"#positionNo",
				    datatype:"verifySelect",
				    //ignore:"ignore",
				    nullmsg:"",
				    errormsg:"请选择应聘职位",
				    sucmsg:" "
				} 
         	]);
    	}
    });
    $("#isEmploy").off().change(function(){
    	if($("#isEmploy option:selected").val()==1){
    		recruitAskRecordAdd.addRule([
				{				
				    ele:"#positionNo",
				    datatype:"verifySelect",
				    //ignore:"ignore",
				    nullmsg:"",
				    errormsg:"请选择应聘职位",
				    sucmsg:" "
				} 
	      ]);
    	}
    });

    /*RecruitAskRecordFileManage.GetFileList();//显示上传文件名
	if ($("#upload").length > 0) {
        $("#upload").off().on("change", function () {
        	var url = $Url.BuildEmployeeUrl("/upload.action");
            Upload.UploadFile($(this).attr("id"),url, "<p></p>", RecruitAskRecordFileManage.ShowUploadFiles);
        });
    }*/
})

var RecruitAskRecordFileManage = {
    ShowUploadFile: function (o, path, fileName) {
    	if(fileName==""||fileName==null){
    		$(o).html("您还没有上传简历");
    	}else{
    		var f;
    		f = "<span class=\"upload_end1\"><em class='tl'><a href=\"{0}\">{1}</a></em></span>";
    		$(o).html(f.format(path, fileName));
    		$("#upLoadPath").html(path);
    	}
    },
    ShowUploadFiles: function (msg, fileObj) {
        if (msg.message == "0") {
            $(fileObj).parent().find("p").remove();
            $(fileObj).after("上传失败请联系管理员");
        }
        else {
            var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecordAttachment/ajaxSaveFilePath");
            var fileID = $(fileObj).attr("id");
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {id: PageVar.ID,
                    fileName: msg.fileFileName,
                    filePath: msg.relativePath,
                    fileType: fileID[fileID.length - 1]
                },
                beforeSend: function () {
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "1") {
                        $(fileObj).parent().next().find("span").remove();
                        var o =$(fileObj).next();
                        RecruitAskRecordFileManage.ShowUploadFile(o, msg.message, msg.fileFileName);
                    } else {
                        $(fileObj).after(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $(fileObj).parent().find("p").remove();
                }
            });
        }
    },
    GetFileList: function () {
        var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecordAttachment/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    if (data.recruitAskRecordFile.resumeAttachment != null) {
                        var arr = data.recruitAskRecordFile.resumeAttachment.split("_");
                        RecruitAskRecordFileManage.ShowUploadFile($("#upload").next(), data.recruitAskRecordFile.resumeAttachment, arr[arr.length - 1]);
                    }
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}

var FileManage = {
    BindFile: function (pathMap) {
        var readOnly = false;
        var div = "<div id=\"div1\" class=\"upload fl\"></div>";
        $("#uploadDiv").append(div);
        $("#uploadDiv #div1").Upload({
            inputID: "upload",
            readOnly: readOnly,
            multiple: false,
            fileType: 1,
            url: $Url.BuildEmployeeUrl("/upload.action"),
            paramList: [1],
            pathList: (pathMap == undefined || pathMap == null)?[]:pathMap[0],
            success: FileManage.SavaFileToDB,
            deleteFile: FileManage.DeleteFile,
            title: ""
        });
        FileManage.ShowFile(pathMap);
    },
    ShowFile:function(pathMap){
    	if(pathMap != undefined && pathMap != null){
        	var arr = pathMap[0].split("_");
        	var f;
        	f = "<span class=\"upload_end1 fl\"><em class='tl'><a href=\"{0}\">{1}</a></em></span>";
        	$("#div1").next().html(f.format($Url.BuildFileUrl(pathMap[0]), arr[arr.length - 1]));
        	$("#upload").addClass("data");
        	$("#upLoadPath").html(pathMap[0]);
        }
    },
    DeleteFile: function (o) {
        if (confirm("是否要删除当前文件")) {
            var id = $(o).attr("id").split("_")[1];
            var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecordAttachment/ajaxDeleteFile");
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
    SavaFileToDB: function (fileName, relativePath, paramList) {
    	var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecordAttachment/ajaxSaveFilePath");
        var fileID = 0;
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async: false,
            data: {id: PageVar.ID,
            	fileName: fileName,
            	filePath: relativePath,
            	fileType: paramList[0]
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
            	var pathMap = [];
                pathMap.push(relativePath);
                FileManage.ShowFile(pathMap);
                fileID = data.errDesc;
                //alert(data.errDesc);

            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });

        return fileID;
    },
    GetFileList: function () {
        var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecordAttachment/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    var pathMap = [];
                    pathMap.push(data.recruitAskRecordFile.resumeAttachment);
                    FileManage.BindFile(pathMap);
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}