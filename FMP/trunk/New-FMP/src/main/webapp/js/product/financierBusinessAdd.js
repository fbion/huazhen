/**
 * Created by Administrator on 2015/4/13.
 */
var ManagePage = {
	Resize: function () {
        $("#content_center").css("min-height", "1200px");
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
            if($(this).eq("#code")){
                $("#code").attr("disabled","disabled");
            }
            if($(this).eq("#requireComment")){
                $("#requireComment").attr("disabled","disabled");
            }
            if($(this).eq("#editComment")){
                $("#editComment").attr("disabled","disabled");
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
        var url = $Url.BuildProductUrl("/product/financierBusiness/ajaxGetFinancierBusiness");
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
                if (!$String.IsNullOrEmpty(data.info.requireTime)) {
                    var requireTime = new Date(data.info.requireTime);
                    $("#requireTime").val(requireTime.format("yyyy-MM-dd HH:mm:ss"));
                }


                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();
                        if(ElementVar.updateManagerNo2!="none"){
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
    EnumList.GetEnumListToSelect($("#managerNo"),"empManager",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#relationLevel"),"dicDataforCustomerCompanyRelationLevel",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#contactImportance"),"dicDataforCustomerAgentBussinessImportance",$Url.BuildProductUrl("/common/enumList.action"));
    $("#back").click(function () {
        $EasyUI.Close();
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
    $("#requireTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });

	ManagePage.Resize();
    var financierBusinessAdd = $("#financierBusinessAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildProductUrl("/product/financierBusiness/ajaxEditFinancierBusiness");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
                code: $("#code").val(),
                name: $("#name").val(),
                owner: $("#owner").val(),
                telephone: $("#telephone").val(),
                relationLevel: $("#relationLevel").val(),
                contactImportance: $("#contactImportance").val(),
                fax: $("#fax").val(),
                postcode: $("#postcode").val(),
                website: $("#website").val(),
                email: $("#email").val(),
                bankName: $("#bankName").val(),
                bankAddress: $("#bankAddress").val(),
                bankAccount: $("#bankAccount").val(),
                address: $("#address").val(),
                contactPrimary: $("#contactPrimary").val(),
                contactCellphone1: $("#contactCellphone1").val(),
                contactCellphone2: $("#contactCellphone2").val(),
                contactTelephone: $("#contactTelephone").val(),
                contactPosition: $("#contactPosition").val(),
                contactWeinxin: $("#contactWeinxin").val(),
                contactQq: $("#contactQq").val(),
                contactAddress: $("#contactAddress").val(),
                requireMoneyTotal: $("#requireMoneyTotal").val(),
                requireTime: $("#requireTime").val().toTimetamp(),
                requireComment: $("#requireComment").val(),
                permitNumber: $("#permitNumber").val(),
                organizationNumber: $("#organizationNumber").val(),
                comment: $("#comment").val(),
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
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildProductUrl("/product/financierBusiness/detail?id=" + data.errDesc);
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
    financierBusinessAdd.addRule([
        {
            ele: "#name",
            datatype: "*",
            nullmsg: "请填写公司名称",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#telephone",
            dataType:/^\d{3,4}-\d{7,8}(-\d{3,4})?$/,
            nullmsg: "请填写公司电话",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#email",
            datatype: "e",
            nullmsg: "请填写公司邮箱",
            errormsg: "",
            sucmsg: " "
        },

        {
            ele: "#address",
            datatype: "*",
            nullmsg: "请填写公司地址",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#contactPrimary",
            datatype: "*",
            nullmsg: "请填写主要联系人",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#contactCellphone1",
            datatype: "m",
            nullmsg: "请填写联系人手机",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#contactPosition",
            datatype: "*",
            nullmsg: "请填写联系人职位",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#permitNumber",
            datatype: "*",
            nullmsg: "请填写公司执照编号",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#contactQq",
            datatype: "/^[1-9][0-9]{4,12}$/",
            ignore: "ignore",
            nullmsg: "",
            errormsg: "请填写正确的qq",
            sucmsg: " "
        },
        {
            ele: "#contactTelephone",
            dataType:/^\d{3,4}-\d{7,8}(-\d{3,4})?$/,
            ignore: "ignore",
            nullmsg: "",
            errormsg: "请填写正确的电话号码",
            sucmsg: " "
        },
        {
            ele: "#contactCellphone2",
            datatype: "m",
            ignore: "ignore",
            nullmsg: "",
            errormsg: "请填写正确的手机号",
            sucmsg: " "
        },
        {
            ele: "#postcode",
            datatype: /^\d{6}$/,
            ignore: "ignore",
            nullmsg: "",
            errormsg: "请填写正确邮编",
            sucmsg: " "
        },
        {
            ele: "#requireMoneyTotal",
            datatype: /^\d*$/,
            ignore: "ignore",
            nullmsg: "",
            errormsg: "请填写数字",
            sucmsg: " "
        }
    ]);
})
