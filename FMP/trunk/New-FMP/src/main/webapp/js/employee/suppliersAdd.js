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
        var url = $Url.BuildEmployeeUrl("/employee/suppliers/ajaxGetSuppliers");
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
        //window.location.href = $Url.BuildEmployeeUrl("/employee/suppliers/list");
        $EasyUI.Close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }



    var suppliersAdd = $("#suppliersAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/suppliers/ajaxEditSuppliers");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				supplierName: $("#supplierName").val(),
				contactPerson: $("#contactPerson").val(),
				phone: $("#phone").val(),
				phone2: $("#phone2").val(),
				mail: $("#mail").val(),
				supplierAddr: $("#supplierAddr").val(),
				supplierType: $("#supplierType").val(),
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
                        window.location.href = $Url.BuildEmployeeUrl("/employee/suppliers/edit?id=" + data.errDesc);
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
    suppliersAdd.addRule([
{
	 ele:"#supplierName",
     dataType:"*",
     nullmsg:"请填写供应商名称",
     sucmsg:" ",
     errmsg:""
},
{
	 ele:"#contactPerson",
     dataType:"*",
     nullmsg:"请填写联系人",
     sucmsg:" ",
     errmsg:""
},
{
	 ele:"#phone",
     dataType:"*",
     nullmsg:"请填写联系电话",
     sucmsg:" ",
     errmsg:""
},
{
	 ele:"#supplierAddr",
    dataType:"*",
    nullmsg:"请填写供应商地址",
    sucmsg:" ",
    errmsg:""
},{
    ele : "#mail",
    datatype : "e",// 汉字验证/^[\u4E00-\u9FFF]+$/
    ignore : "ignore",
    nullmsg : " ",
    errormsg : "请填写正确邮箱信息",
    sucmsg : " "
},
{
    ele : "#phone",
    datatype : "phone",
    ignore : "ignore",
    nullmsg : " ",
    errormsg : "请填写正确的手机号",
    sucmsg : " "
},{
    ele : "#phone2",
    datatype : "phone",
    ignore : "ignore",
    nullmsg : " ",
    errormsg : "请填写正确的手机号",
    sucmsg : " "
},
    ]);
})
