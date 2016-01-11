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
            if($(this).eq("#code")){
                $("#code").attr("disabled","disabled");
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
        var url = $Url.BuildProductUrl("/product/financierPersonal/ajaxGetFinancierPersonal");
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
                if (!$String.IsNullOrEmpty(data.info.requiretime)) {
                    var requiretime = new Date(data.info.requiretime);
                    $("#requiretime").val(requiretime.format("yyyy-MM-dd HH:mm:ss"));
                }


                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();
                        if(ElementVar.updateManagerNo3!="none"){
                            $("#employeeSel").removeAttr("disabled");
                        }
                    });
                }
                EmployeeTreeControl.startTree({
                    param: "on",  //on在职员工，out离职员工，test测试员工
                    treeInputId: "employeeSel",//员工控件框ID
                    valInputId: "managerNo", //员工值框id
                    inputType: "employee",//employee员工，position职位
                    idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
                    chkStyle: "radio",//选框类型checkbox,radio
                    nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
                    chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
                    showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
                    //showSearch: true,   //显示搜索框
                    showLevel:3,         //显示层级
                    sizeAuto:true,		//自动调节大小
                    width:200,			//宽，单位px
                    height:300			//高，单位px
                });
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
$(function () {
    EnumList.GetEnumListToSelect($("#sex"),"dicDicDataForEmployeeSex",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#marry"),"dicDicDataForEmployeeMarry",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#managerNo"),"empManager",$Url.BuildProductUrl("/common/enumList.action"));

    $("#back").click(function () {
        window.close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
        $("#managerNo").val(PageVar.UserId);
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "managerNo", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:3,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:200,			//宽，单位px
        height:300			//高，单位px
    });
    $("#requiretime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });


    var financierPersonalAdd = $("#financierPersonalAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildProductUrl("/product/financierPersonal/ajaxEditFinancierPersonal");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
                code: $("#code").val(),
                name: $("#name").val(),
                sex: $("#sex").val(),
                email: $("#email").val(),
                weixin: $("#weixin").val(),
                qq: $("#qq").val(),
                cellphone1: $("#cellphone1").val(),
                cellphone2: $("#cellphone2").val(),
                telephone: $("#telephone").val(),
                address: $("#address").val(),
                age: $("#age").val(),
                marry: $("#marry").val(),
                company: $("#company").val(),
                money: $("#money").val(),
                requiretime: $("#requiretime").val().toTimetamp(),
                requireComment: $("#requireComment").val(),
                protocolNo: $("#protocolNo").val(),
                managerNo: $("#managerNo").val(),
                editComment: $("#editComment").val(),
                isTest: $("#isTest").val()
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
                success: function (data) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildProductUrl("/product/financierPersonal/detail?id=" + data.errDesc);
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
    financierPersonalAdd.addRule([
        {
            ele: "#name",
            datatype: "*",
            nullmsg: "请填写委托人",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#company",
            datatype: "*",
            nullmsg: "请填写公司名称",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#email",
            datatype: "e",
            nullmsg: "请填写邮箱地址",
            errormsg: "请填写正确的邮箱地址",
            sucmsg: " "
        },
        {
            ele: "#QQ",
            datatype: "/^[1-9][0-9]{4,12}$/",
            ignore: "ignore",
            nullmsg: "",
            errormsg: "请填写正确的qq",
            sucmsg: " "
        },
        {
            ele: "#cellphone1",
            datatype: "m",
            nullmsg: "请填写手机号",
            errormsg: "请填写正确的手机号",
            sucmsg: " "
        },
        {
            ele: "#cellphone2",
            datatype: "m",
            ignore: "ignore",
            nullmsg: "",
            errormsg: "请填写正确的手机号",
            sucmsg: " "
        },
        {
            ele: "#telephone",
            dataType:/^\d{3,4}-\d{7,8}(-\d{3,4})?$/,
            nullmsg: "",
            ignore: "ignore",
            errormsg: "请填写正确的固定电话",
            sucmsg: " "
        },
        {
            ele: "#age",
            dataType:/^\d{1,3}$/,
            nullmsg: "",
            ignore: "ignore",
            errormsg: "请填写1-3位数字",
            sucmsg: " "
        },
        {
            ele: "#money",
            dataType:/^\d*$/,
            nullmsg: "",
            ignore: "ignore",
            errormsg: "请填写数字",
            sucmsg: " "
        }
    ]);
})
/**
 * Created by Administrator on 2015/4/10.
 */
