
var BindEnumList={
	    BindType:function(){
	        EnumList.GetEnumListToSelect($("#type"),"dicDicDataForKnowledge",$Url.BuildEmployeeUrl("/common/enumList.action"));
	    },
	    BindAll:function(){
	        BindEnumList.BindType();
	    }
	}


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
        var url = $Url.BuildEmployeeUrl("/employee/knowledgeBase/ajaxGetKnowledgeBase");
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
                BindEnumList.BindType();
                $("#type").val(data.info.type);
                FileManage.GetFileList();

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
    $("#back").click(function () {
        window.location.href = $Url.BuildEmployeeUrl("/employee/knowledgeBase/list");
    });
    if (Number(PageVar.ID) == 0) {
    	BindEnumList.BindAll();
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }



    var knowledgeBaseAdd = $("#knowledgeBaseAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/knowledgeBase/ajaxEditKnowledgeBase");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				type: $("#type").val(),
				title: $("#title").val(),
				content:$String.Trim(CKEDITOR.instances.content.getData()),
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/knowledgeBase/edit?id=" + data.errDesc);
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
    
    knowledgeBaseAdd.addRule([
		 {
	         ele:"#title",
	         datatype:"*",
	         //ignore:"ignore",
	         sucmsg:" "
	      }/*,
      	{
	         ele:"#content",
	         datatype:"*",
	         //ignore:"ignore",
	         sucmsg:" "
	      }*/
    ]);
})


//附件
var FileManage = {
    BindFile: function (pathList) {
    	
    	var readOnly = false;
            $(".upload").Upload({
                inputID: "uploadInput",
                readOnly: readOnly,
                multiple: true,
                fileType: 1,
                url: $Url.BuildEmployeeUrl("/upload.action"),
                pathList: (pathList == undefined || pathList == null)?[]:pathList,
                success: FileManage.SavaFileToDB,
                deleteFile: FileManage.DeleteFile,
                title: "知识附件"
            });
        
    },
    DeleteFile: function (o) {
        if (confirm("是否要删除当前文件")) {
            var id = $(o).attr("id").split("_")[1];
            var url = $Url.BuildEmployeeUrl("/employee/knowledgeAttachment/ajaxDeleteFile");
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
        var url = $Url.BuildEmployeeUrl("/employee/knowledgeAttachment/ajaxSaveFilePath");

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
        var url = $Url.BuildEmployeeUrl("/employee/knowledgeAttachment/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {knowledgeNo: PageVar.ID
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
