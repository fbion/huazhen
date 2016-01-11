var ManagePage = {
    Tree:function(){
        EmployeeTreeControl.startTree({
            param: "on",  //on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel",//员工控件框ID
            valInputId: "parentNo", //员工值框id
            inputType: "employee",//employee员工，position职位
            idType: "empNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
            chkStyle: "radio",//选框类型checkbox,radio
            nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
            chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
            showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
            showLevel:3,         //显示层级
            sizeAuto:true,		//自动调节大小
            width:200,			//宽，单位px
            height:300			//高，单位px
        });
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
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none) {
                $(this).parent().remove();
            }

        });
        if ($(this).eq("#code")) {
            $("#code").attr("disabled", "disabled");
        }
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
        var url = $Url.BuildEmployeeUrl("/employee/employee/ajaxGetEmployee");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: id},
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
                $("#detailName").val(data.info.name);
                $("#detailSex").val(data.info.sex);
                $("#detailWeixin").val(data.info.weixin);
                //$("#detailEmail").val(data.info.email);
                $("#detailQq").val(data.info.qq);
                $("#detailCellphone1").val(data.info.cellphone1);
                $("#detailTelephone").val(data.info.telephone);
                $("#detailMarry").val(data.info.marry);
                $("#detailAddress").val(data.info.address);
                $("#detailCode").val(data.info.code);


                if (!$String.IsNullOrEmpty($("#portraitPath").val())) {
                    FileManage.ShowPhoto($Url.BuildFileUrl($("#portraitPath").val()));
                } else {
                    $("#emphead").attr("src", $Url.BuildImgUrl("head/TestImg.jpg"));
                }

                $("#deptNo").trigger("change");
                $("#parentNo").val(data.info.parentNo);
                $("#positionNo").val(data.info.positionNo);

                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#F").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();
                        $("#submitCheck").remove();
                    });
                }
                ManagePage.Tree();
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    UpdateCheck: function (id, status) {
        if(confirm("请确认进行此操作!"))
        var url = $Url.BuildEmployeeUrl("/employee/employee/ajaxUpdateCheck");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                id: id,
                status: status
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if(data.errCode != "0000"){
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var FileManage = {
    BindFile: function () {
        var readOnly = false;
        $(".upload").Upload({
        	weiXinPhoto:1,
            inputID: "uploadInput",
            readOnly: readOnly,
            multiple: false,
            fileType: 2,
            url: $Url.BuildEmployeeUrl("/upload.action"),
            success: FileManage.SaveFileToPage,
            title: ""
        });
        $("#uploadInput").addClass("data");
    },
    SaveFileToPage: function (fileName, relativePath) {

        FileManage.ShowPhoto($Url.BuildFileUrl(relativePath));
        $("#portraitPath").val(relativePath);
    },
    ShowPhoto: function (path) {
        $(".emphead").attr("src", path);
        $("#aEmpHead").attr("href", path);
    }
}

$(function () {
    $("#code").attr("disabled", "disabled");
    EnumList.GetEnumListToSelect($(".sex"), "dicDicDataForEmployeeSex", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($(".marry"), "dicDicDataForEmployeeMarry", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#status"), "employeeStatusAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#userNo"), "user", $Url.BuildEmployeeUrl("/common/enumList.action"));
    ManagePage.Tree();
    $.fn.linkage({
        elements: [$("#companyNo"), $("#deptNo")],
        dataTypes: ["empCompanylist", "deptListByCompany"],//["role",{1:"table1",2:"table2"}] ["role","table1","table2"]
        actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
        all: false
    });
    $.fn.linkage({
        elements: [$("#companyNo"), $("#deptNo"), $("#positionNo")],
        dataTypes: ["empCompanylist", "deptListByCompany", "positionListBydeptType1"],//["role",{1:"table1",2:"table2"}] ["role","table1","table2"]
        actionUrl: $Url.BuildEmployeeUrl("/common/enumList.action"),
        all: false
    });

    $("#goBack").click(function () {
        $EasyUI.Close();
    });

    if($("#submitCheck").length > 0){
        $("#submitCheck").click(function () {
            ManagePage.UpdateCheck(PageVar.ID,1)
            $(this).remove();
            $("#edit").remove();
        });
    }
    
    if($("#checkOk").length > 0){
        $("#checkOk").click(function () {
            ManagePage.UpdateCheck(PageVar.ID,2);
            $(this).next().remove();
            $(this).remove();
        });
    }

    if($("#checkFailed").length > 0){
        $("#checkFailed").click(function(){
            ManagePage.UpdateCheck(PageVar.ID,0)
            $(this).prev().remove();
            $(this).remove();
        });
    }

    FileManage.BindFile();
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();

        if ($("#userNo").length > 0) {//原来绑定的系统用户隐藏
            $("#userNo").parent().first().remove();
            $("#userNo").remove();
        }
        $("#emphead").attr("src", $Url.BuildImgUrl("head/TestImg.jpg"));

    }
    else {
        if ($("#sysPwd").length > 0) {//新建用户隐藏
            $("#sysPwd").parent().first().remove();
            $("#sysPwd").remove();
        }
        if ($("#sysUser").length > 0) {//密码隐藏
            $("#sysUser").parent().first().remove();
            $("#sysUser").remove();
        }
        ManagePage.GetInfo(PageVar.ID);
    }


    var employeeAdd = $("#employeeAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        datatype: {
            "verifyUsername": function (gets, obj, curform, datatype) {
                var reg = /^[a-zA-Z0-9]{4,20}$/;
                if (!reg.test(gets)) {
                    return "4~20位字符，支持数字、字母，不能有特殊字符、下划线";//false;
                }

                var url = $Url.BuildEmployeeUrl("/employee/employee/ajaxCheckUserExist");
                var result = true;
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    async: false,
                    data: {sysUser: $String.Trim(gets)},
                    success: function (data) {
                        if (data.msgType == "NO") {
                            result = data.msgDescribe;
                        }
                    }
                });

                return result;
            },
            "verifyTel": function (gets, obj, curform, datatype) {
                var reg = /^\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                if (!reg.test(gets)) {
                    return false;
                }
                return true;
            }
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/employee/ajaxEditEmployee");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
                code: $("#code").val(),
                name: $("#name").val(),
                sex: $("#sex").val(),
                weixin: $("#weixin").val(),
                qq: $("#qq").val(),
                telephone: $("#telephone").val(),
                cellphone1: $("#cellphone1").val(),
                cellphone2: $("#cellphone2").val(),
                address: $("#address").val(),
                userNo: $("#userNo").val(),
                marry: $("#marry").val(),
                deptNo: $("#deptNo").val(),
                companyNo: $("#companyNo").val(),
                parentNo: $("#parentNo").val(),
                positionNo: $("#positionNo").val(),
                positionTitle: $("#positionTitle").val(),
                positionLevelNo: $("#positionLevelNo").val(),
                editComment: $("#editComment").val(),
                portraitPath: $("#portraitPath").val(),
                status: $("#status").val(),
                isTest: $("#isTest").val(),
                isSendEmail: $("#isSendEmail").val()
            }

            var sysPwd = 0;
            var sysUser = 0;

            if ($("#sysPwd").length > 0) {//新建用户隐藏
                sysPwd = $("#sysPwd").val();
            }
            if ($("#sysUser").length > 0) {//密码隐藏
                sysUser = $("#sysUser").val();
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info),
                    sysUser: sysUser,
                    sysPwd: sysPwd
                },
                beforeSend: function () {
                    addMask();
                    $("#submit").attr("process", "processing");
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
                    removeMask();
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    employeeAdd.addRule([
        {
            ele: "#name",
            datatype: "*",
            nullmsg: "请如实输入员工姓名",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#email",
            datatype: "e",//  汉字验证/^[\u4E00-\u9FFF]+$/
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请填写正确邮箱信息",
            sucmsg: " "
        },//
        {
            ele: "#telephone",
            datatype: "m|verifyTel",
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请填写正确的电话号",
            sucmsg: " "
        },
        {
            ele: "#cellphone1",
            datatype: "/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/",
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请填写正确的手机号",
            sucmsg: " "
        },
        {
            ele: "#cellphone2",
            datatype: "/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/",
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请填写正确的手机号",
            sucmsg: " "
        },
        {
            ele: "#qq",
            datatype: "n",
            ignore: "ignore",
            nullmsg: " ",
            errormsg: "请填写正确QQ号",
            sucmsg: " "
        },
        {
            ele: "#sysUser",
            datatype: "verifyUsername",
            nullmsg: "请输入系统用户名",
            errormsg: " ",
            sucmsg: " "
        },
        {
            ele: "#sysPwd",
            datatype: "*",
            nullmsg: "请输入用户密码",
            errormsg: "密码错误",
            sucmsg: " "
        }
    ]);
})
