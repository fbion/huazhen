var FamilyMembersAdd = {
    GetInfo: function (empNo) {
        var url = $Url.BuildEmployeeUrl("/employee/familyMembers/ajaxGetFamilyMembers");
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
                $.each(data.familyMembersInfoList,function(i,value){
                    var td = $(".familyMemberTable").eq(i).find("td");
                    td.eq(0).children().val(value.id);
                    td.eq(1).children().val(value.familyName);
                    td.eq(2).children().val(value.appellation);
                    td.eq(3).children().val(value.familyAge);
                    td.eq(4).children().val(value.familyWorkDepartment);
                    td.eq(5).children().val(value.familyPosition);
                    td.eq(6).children().val(value.familyCellphone);
                });
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    FamilyMembersAdd: function () {
        var url = $Url.BuildEmployeeUrl("/employee/familyMembers/ajaxEditFamilyMembers");
        /*var familyMembersInfo = {
            empNo: PageVar.ID,
            id: tr.find("td").eq(0).children().val(),
            familyName: tr.find("td").eq(1).children().val(),
            appellation: tr.find("td").eq(2).children().val(),
            familyAge: tr.find("td").eq(3).children().val(),
            familyWorkDepartment: tr.find("td").eq(4).children().val(),
            familyPosition: tr.find("td").eq(5).children().val(),
            familyCellphone: tr.find("td").eq(6).children().val()
        }*/
        var familyMembersInfoList = new Array();
        $.each($(".familyMemberTable"), function () {
            if ($Util.IsNullRow($(this))) {
                return false;
            }
            var info = {};
            info.empNo = PageVar.ID;
            info.id = $(this).children().eq(0).children().val();
            info.familyName = $(this).children().eq(1).children().val();
            info.appellation = $(this).children().eq(2).children().val();
            info.familyAge = $(this).children().eq(3).children().val();
            info.familyWorkDepartment = $(this).children().eq(4).children().val();
            info.familyPosition = $(this).children().eq(5).children().val();
            info.familyCellphone = $(this).children().eq(6).children().val();
            familyMembersInfoList.push(info);
        });
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async:false,
            data: {
                familyMembersInfoList: JSON.stringify(familyMembersInfoList)
            },
            beforeSend: function () {
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
            }
        });
        return false;
    }
}
