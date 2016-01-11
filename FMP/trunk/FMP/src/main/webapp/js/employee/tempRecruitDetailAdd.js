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
        var url = $Url.BuildEmployeeUrl("/employee/tempRecruitDetail/ajaxGetTempRecruitDetail");
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
				if (!$String.IsNullOrEmpty(data.info.workDate)) {
					var workDate = new Date(data.info.workDate);
					$("#workDate").val(workDate.format("yyyy-MM-dd HH:mm:ss"));
					}


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
        window.location.href = $Url.BuildEmployeeUrl("/employee/tempRecruitDetail/list");
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }

	$("#workDate").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});


    var tempRecruitDetailAdd = $("#tempRecruitDetailAdd").Validform({
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

            var detailInfo = {
                id: PageVar.ID,
				tempRecruitNeedNo: $("#tempRecruitNeedNo").val(),
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
				//workDate: $("#workDate").val().toTimetamp(),
				//editComment: $("#editComment").val()
            }
            
            
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/tempRecruitDetail/edit?id=" + data.errDesc);
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
    tempRecruitDetailAdd.addRule([
    ]);
})
