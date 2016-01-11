var EmployeeEducationAdd = {
    GetInfo: function (empNo) {
        var url = $Url.BuildEmployeeUrl("/employee/employeeEducation/ajaxGetEmployeeEducation");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: { empNo: empNo },
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
                $.each(data.employeeEducationInfoList,function(i,value){
                    var td = $(".employeeEducationTable").eq(i).find("td");
                    td.eq(0).children().val(value.id);
                    td.eq(1).children().eq(0).val(value.admissionTime);
                    td.eq(1).children().eq(1).val(value.graduationTime);
                    td.eq(2).children().val(value.graduationSchool);
                    td.eq(3).children().val(value.major);
                    td.eq(4).find("select").val(value.education);
                    td.eq(5).find("select").val(value.degree);
                })
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    EmployeeEducationAdd:function(){
        var url = $Url.BuildEmployeeUrl("/employee/employeeEducation/ajaxEditEmployeeEducation");
        var employeeEducationInfoList = new Array();
        $.each($(".employeeEducationTable"), function () {
            if ($Util.IsNullRow($(this))) {
                return false;
            }
            var info = {};
            info.empNo = PageVar.ID;
            info.id = $(this).children().eq(0).children().val();
            info.admissionTime = $(this).children().eq(1).children().eq(0).val();
            info.graduationTime = $(this).children().eq(1).children().eq(1).val();
            info.graduationSchool = $(this).children().eq(2).children().val();
            info.major = $(this).children().eq(3).children().val();
            info.education = $(this).children().eq(4).find("select").val();
            info.degree = $(this).children().eq(5).find("select").val();
            employeeEducationInfoList.push(info);
        });
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async:false,
            data: {
                employeeEducationInfoList: JSON.stringify(employeeEducationInfoList)
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