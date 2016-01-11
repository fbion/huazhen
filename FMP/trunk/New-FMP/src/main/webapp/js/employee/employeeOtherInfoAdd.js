var EmpOtherInfoAdd = {
    GetInfo: function (id) {
        var url = $Url.BuildEmployeeUrl("/employee/employeeOtherInfo/ajaxGetEmployeeOtherInfo");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {empNo: PageVar.ID},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#otherInfoMsg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.empOtherInfo, ElementVar);
                for(var i= 1;i<data.certificateInfoList.length;i++){
                    AddNewElement.AddElement();
                }
                EmployeeDetailAdd.DisableInput();
                $.each(data.certificateInfoList,function(i,value){
                    var ele = $(".getCertificate").eq(i).find("input");
                    ele.eq(0).val(value.id);
                    ele.eq(1).val(value.credential);
                    ele.eq(2).val(new Date(value.credentialDate).format("yyyy-MM-dd"));
                });

                EmployeeDetailAdd.ShowEditButton();
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}

var AddNewElement = {
    AddEvent: function () {
        $(".addCertificate:last").off().on("click", function () {
            AddNewElement.AddElement();
        });
    },
    AddElement:function(){
        $("#employeeOtherInfoAdd ul:last").after(
            "<ul class='getCertificate'><input name='id' type='text' style='display: none' /><li><span>任职资格证书</span><input name='credential' type='text' class='ml20 data certificate' /><div class='Validform_checktip'></div></li><li><span>获证日期</span><input name='credentialDate' onclick=\"WdatePicker({dateFmt: 'yyyy-MM-dd'});\" type='text' class='ml20 data certificate'><div class='Validform_checktip'></div><input type='button' value='+' onclick=\"AddNewElement.AddElement();\" class='btn_style f16 data addCertificate' /></li></ul>"
        );
        $(".getCertificate").prev().find('.addCertificate').hide();
    }
}


$(function () {
    $("#otherInfoBack").click(function () {
        $EasyUI.Close();
    });
    AddNewElement.AddEvent();
    if (Number(PageVar.ID) == 0) {
        EmployeeDetailAdd.EnableInput();
        EmployeeDetailAdd.HideEditButton();
    }
    else {
        EmployeeDetailAdd.ShowEditButton();
        EmpOtherInfoAdd.GetInfo(PageVar.ID);
    }

    var employeeOtherInfoAdd = $("#employeeOtherInfoAdd").Validform({
            tiptype: function (msg, o, cssctl) {
                var objtip = o.obj.siblings(".Validform_checktip");
                cssctl(objtip, o.type);
                objtip.text(msg);
            },
            callback: function (form) {
                if (!($("#otherInfoSubmit").attr("process") === undefined)) {
                    return false;
                }
                var url = $Url.BuildEmployeeUrl("/employee/employeeOtherInfo/ajaxEditEmployeeOtherInfo");
                var empOtherInfo = {
                    empNo: PageVar.ID,
                    bankAddress: $("#bankAddress").val(),
                    bankAccount: $("#bankAccount").val(),
                    computerLevel: $("#computerLevel").val(),
                    startTime: $("#startTime").val(),
                    workExperience: $("#workExperience").val(),
                    contractStartTime: $("#contractStartTime").val(),
                    contractEndTime: $("#contractEndTime").val(),
                    protocolStartTime: $("#protocolStartTime").val(),
                    protocolEndTime: $("#protocolEndTime").val()
                }
                var certificateInfoList = new Array();
                $.each($(".getCertificate"),function(){
                        var info = {};
                        info.id = $(this).find("input").eq(0).val();
                        info.empNo = PageVar.ID;
                        info.credential=$(this).find("input").eq(1).val();
                        info.credentialDate=$(this).find("input").eq(2).val();
                        certificateInfoList.push(info);
                })
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    timeout: 30000,
                    data: {
                        empOtherInfo: JSON.stringify(empOtherInfo),
                        certificateInfoList: JSON.stringify(certificateInfoList)
                    },
                    beforeSend: function () {
                        $("#otherInfoSubmit").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(errorThrown);
                    },
                    success: function (data, textStatus) {
                        if (data.errCode == "0000") {
                            window.location.href = $Url.BuildEmployeeUrl("/employee/employee/edit?id=" + data.errDesc);
                        } else {
                            $("#otherInfoMsg").text(data.errDesc);
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#otherInfoSubmit").removeAttr("process");
                    }
                });
                return false;
            }
        })
        ;
    employeeOtherInfoAdd.addRule([
        {
            ele: "#bankAccount",
            ignore: "ignore",
            datatype: "/^(\\d{16}|\\d{19})$/",
            errormsg: "请填写16或19位的银行卡号",
            sucmsg: " "
        },
        {
            ele: "#workExperience",
            ignore: "ignore",
            datatype: "n",
            errormsg: "请填写数字",
            sucmsg: " "
        }
    ]);
})
