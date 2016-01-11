var WorkExperienceAdd = {
    GetInfo: function (empNo) {
        var url = $Url.BuildEmployeeUrl("/employee/workExperience/ajaxGetWorkExperience");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {empNo: empNo},
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

                $.each(data.workExperienceInfoList, function (i, value) {
                    var td = $(".workExperienceTable").eq(i).find("td");
                    td.eq(0).children().val(value.id);
                    td.eq(1).children().eq(0).val(value.workStartTime);
                    td.eq(1).children().eq(1).val(value.workEndTime);
                    td.eq(2).children().val(value.workDepartment);
                    td.eq(3).children().val(value.position);
                    td.eq(4).children().val(value.monthIncome);
                    td.eq(5).children().val(value.contactPerson);
                    td.eq(6).children().val(value.contactCellphone);
                })
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    WorkExperienceAdd: function () {
        var url = $Url.BuildEmployeeUrl("/employee/workExperience/ajaxEditWorkExperience");
        var workExperienceInfoList = new Array();
        $.each($(".workExperienceTable"), function () {
            if ($Util.IsNullRow($(this))) {
                return false;
            }
            var info = {};
            info.empNo = PageVar.ID;
            info.id = $(this).children().eq(0).children().val();
            info.workStartTime = $(this).children().eq(1).children().eq(0).val();
            info.workEndTime = $(this).children().eq(1).children().eq(1).val();
            info.workDepartment = $(this).children().eq(2).children().val();
            info.position = $(this).children().eq(3).children().val();
            info.monthIncome = $(this).children().eq(4).children().val();
            info.contactPerson = $(this).children().eq(5).children().val();
            info.contactCellphone = $(this).children().eq(6).children().val();
            workExperienceInfoList.push(info);
        });
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async: false,
            data: {
                workExperienceInfoList: JSON.stringify(workExperienceInfoList)
            },
            beforeSend: function () {
                $("#submit").attr("process", "processing");
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
                $("#submit").removeAttr("process");
            }
        });
        return false;
    }
}