var EmployeeDetailAdd = {
    Resize: function () {
        $("#content_center").css("min-height", "1500px");
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
    ShowEditButton: function () {
        /*if ($("#employeeDetailEdit").length > 0)
            $("#employeeDetailEdit").show();
        if ($("#employeeDetailSubmit").length > 0)
            $("#employeeDetailSubmit").hide();*/
        if ($(".edit").length > 0)
            $(".edit").show();
        if ($(".submit").length > 0)
            $(".submit").hide();

    },
    HideEditButton: function () {
        if ($(".edit").length > 0)
            $(".edit").hide();
        if ($(".submit").length > 0)
            $(".submit").show();

    },
    GetInfo: function (id) {
        var url = $Url.BuildEmployeeUrl("/employee/employeeDetail/ajaxGetEmployeeDetail");
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
                if(data.info == null){
                    return;
                }
                if(data.info.accept == "1"){
                    $("#accept").prop("checked",true);
                }
                if($String.IsNullOrEmpty(data.info)){
                    $Util.DataToVal(data.info, ElementVar);
                    $("#detailEmail").val(data.info.remark);
                    if (!$String.IsNullOrEmpty(data.info.birthday)) {
                        var birthday = new Date(data.info.birthday);
                        $("#birthday").val(birthday.format("yyyy-MM-dd"));
                    }
                    if (!$String.IsNullOrEmpty(data.info.workTime)) {
                        var workTime = new Date(data.info.workTime);
                        $("#workTime").val(workTime.format("yyyy-MM"));
                    }
                }
                EmployeeDetailAdd.ShowEditButton();
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
$(function(){
    $("#detailCode").attr("disabled","disabled");

    EmployeeDetailAdd.Resize();
    EnumList.GetEnumListToSelect($(".education"),"empEducationList",$Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#politicalStatus"),"politicalStatus",$Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($(".degree"),"empDegreeList",$Url.BuildEmployeeUrl("/common/enumList.action"));
    $("#employeeDetailBack").click(function () {
        window.close()
        //window.location.href = $Url.BuildEmployeeUrl("/employee/employee/list?navSub=员工管理");
    });

    EmployeeDetailAdd.DisableInput();
    EmployeeDetailAdd.ShowEditButton();
    EmployeeDetailAdd.GetInfo(PageVar.ID);
    FamilyMembersAdd.GetInfo(PageVar.ID);
    EmployeeEducationAdd.GetInfo(PageVar.ID);
    //WorkExperience.MainGet();
    WorkExperienceAdd.GetInfo(PageVar.ID);
    if ($(".edit").length > 0) {
        $(".edit").click(function () {
            EmployeeDetailAdd.EnableInput();
            EmployeeDetailAdd.HideEditButton();

        });
    }

    $(".dateYMD").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $(".dateYMLine").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM  --'});
    });
    $(".dateYM").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM'});
    });

    var employeeDetailAdd = $("#employeeDetailAdd").Validform({
        tiptype: function (msg) {
            if(msg != " " && !$String.IsNullOrEmpty(msg)){
                alert(msg);
            }
        },
        callback: function (form) {

            if(!$("#accept").prop("checked")){
                alert("您必须同意该声明，否则不允许录入数据！");
                return false;
            }
            if (!($("#employeeDetailSubmit").attr("process") === undefined)) {
                return false;
            }
            FamilyMembersAdd.FamilyMembersAdd();
            EmployeeEducationAdd.EmployeeEducationAdd();
            WorkExperienceAdd.WorkExperienceAdd();
            //WorkExperience.MainAdd();
            var url = $Url.BuildEmployeeUrl("/employee/employeeDetail/ajaxEditEmployeeDetail");
            var employeeInfo = {
                id: PageVar.ID,
                code: $("#detailCode").val(),
                name:$("#detailName").val(),
                sex:$("#detailSex").val(),
                marry:$("#detailMarry").val(),
                email:$("#email").val(),
                telephone:$("#detailTelephone").val(),
                cellphone1:$("#detailCellphone1").val(),
                qq:$("#detailQq").val(),
                weixin:$("#detailWeixin").val(),
                address:$("#detailAddress").val()
            }
            var info = {
                empNo: PageVar.ID,
                remark:$("#detailEmail").val(),
                birthday: $("#birthday").val().toTimetamp(),
                nation: $("#nation").val(),
                politicalStatus: $("#politicalStatus").val(),
                workTime: $("#workTime").val(),
                birthPlace: $("#birthPlace").val(),
                isPregnant: $("#isPregnant").val(),
                childrenSituation: $("#childrenSituation").val(),
                IDCard:$("#IDCard").val(),
                highestDegree: $("#highestDegree").val(),
                profession: $("#profession").val(),
                permanentPlace: $("#permanentPlace").val(),
                height: $("#height").val(),
                weight: $("#weight").val(),
                healthSituation: $("#healthSituation").val(),
                firstForeignLanguage: $("#firstForeignLanguage").val(),
                firstForeignLanguageLevel: $("#firstForeignLanguageLevel").val(),
                secondForeignLanguage: $("#secondForeignLanguage").val(),
                secondForeignLanguageLevel: $("#secondForeignLanguageLevel").val(),
                homeTelephone: $("#homeTelephone").val(),
                permanentAddress: $("#permanentAddress").val(),
                permanentAddressPostcode: $("#permanentAddressPostcode").val(),
                addressPostcode:$("#addressPostcode").val(),
                emergencyContactName: $("#emergencyContactName").val(),
                emergencyContactCellphone: $("#emergencyContactCellphone").val(),
                reward:$("#reward").val(),
                generalSituation: $("#generalSituation").val(),
                skill: $("#skill").val(),
                hobby: $("#hobby").val(),
                advantage: $("#advantage").val(),
                disadvantage: $("#disadvantage").val(),
                educationExperience: $("#educationExperience").val(),
                accept: "1"
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                async:false,
                data: {
                    employeeInfo:JSON.stringify(employeeInfo),
                    info: JSON.stringify(info)
                },
                beforeSend: function () {
                    $("#employeeDetailSubmit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildEmployeeUrl("/employee/employee/edit?id=" + data.errDesc);
                    } else {
                        $("#msg").text(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#employeeDetailSubmit").removeAttr("process");
                }
            });
            return false;
        }
    });
    employeeDetailAdd.addRule([
        {
            ele:".cellphone",
            datatype:"/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/",
            ignore:"ignore",
            errormsg:"请输入正确格式的手机号",
            sucmsg:" "
        },
        {
            ele:".number",
            datatype:"n",
            ignore:"ignore",
            errormsg:"请输入数字类型",
            sucmsg:" "
        },
        {
            ele:".tel",
            datatype:"m|verifyTel",
            ignore:"ignore",
            errormsg:"请输入正确格式的固定电话",
            sucmsg:" "
        },
        {
            ele:".phone",
            datatype:"phone",
            ignore:"ignore",
            errormsg:"请输入正确格式的手机号或固定电话(010-12345678)",
            sucmsg:" "
        },
        {
            ele:"#IDCard",
            datatype:"IDCard",
            ignore:"ignore",
            errormsg:"请输入正确格式的身份证号",
            sucmsg:" "
        },
        {
            ele:".email",
            datatype:"e",
            ignore:"ignore",
            errormsg:"请输入正确格式的邮箱",
            sucmsg:" "
        },
        {
            ele:".postCode",
            datatype:"p",
            ignore:"ignore",
            errormsg:"请输入正确格式的邮编",
            sucmsg:" "
        }
    ]);
});
