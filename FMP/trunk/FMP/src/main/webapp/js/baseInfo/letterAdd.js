var ManagePage = {
	Resize: function () {
		$("#content_center").css("min-height", "1000px");
	},
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            } else {
                if (Number(PageVar.ID) == 0){
                    if (ElementVar[id] != TagPermissionType.none){
                        $(this).removeAttr("disabled");
                    }
                }else if (Number(PageVar.ID) != 0){
                    if (ElementVar[id] == TagPermissionType.edit)
                        $(this).removeAttr("disabled");
                }
            }
        });

        $(".disabled").attr("disabled","disabled");
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
    ClickHandel:function(){
        ManagePage.HideButton();
        $("#status").val(2);
        $("#submit").trigger("click");
        $("#comment").removeAttr("disabled");
    },
    ClickSolve:function(){
        ManagePage.HideButton();
        $("#status").val(3);
        $("#submit").show();
        $("#solveUserNo").val(PageVar.UserId);
        $("#solvePlan").removeAttr("disabled");
        $("#comment").removeAttr("disabled");
    },
    ClickClose:function(){
        ManagePage.HideButton();
        $("#status").val(4);
        $("#submit").show();
        $("#closeUserNo").val(PageVar.UserId);
        $("#comment").removeAttr("disabled");
    },
    HideButton:function(){
        $("#handel").hide();
        $("#solve").hide();
        $("#close").hide();
        $("#edit").hide();
    },
    GetInfo: function (id) {
        var url = $Url.BuildBaseInfoUrl("/baseInfo/letter/ajaxGetLetter");
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
                $("#inTime").val(new Date(data.info.inTime).format("yyyy-MM-dd HH:mm:ss"));
                if(data.info.solveTime!=null){
                    $("#solveTime").val(new Date(data.info.solveTime).format("yyyy-MM-dd HH:mm:ss"));
                }
                if(data.info.closeTime!=null){
                    $("#closeTime").val(new Date(data.info.closeTime).format("yyyy-MM-dd HH:mm:ss"));
                }
                ManagePage.HideButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();
                    });
                }
                if(Number(PageVar.UserId)==Number($("#inUserNo").val())) {
                    $("#edit").show();
                    $("#close").show();
                }
                if(Number(PageVar.UserId)==Number($("#recipient").val())){
                    $("#handel").show();
                    $("#solve").show();
                }
                if($("#status").val()==2){
                    $("#handel").hide();
                    $("#edit").hide();
                }
                if($("#status").val()==3){
                    $("#handel").hide();
                    $("#solve").hide();
                    $("#edit").hide();
                }
                if($("#status").val()==4){
                    ManagePage.HideButton();
                }
                if($("#type").val()==1){
                    $(".hide").show();
                    $(".isRead").hide();
                }
                else{
                    ManagePage.HideButton();
                    $(".hide").hide();
                }
                if($("#type").val()==2){
                    $(".isRead").hide();
                }
                ManagePage.Tree();
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    Tree:function(){
        EmployeeTreeControl.startTree({
            param: "on",  //on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel",//员工控件框ID
            valInputId: "recipient", //员工值框id
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
        EmployeeTreeControl.startTree({
            param: "on",  //on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel1",//员工控件框ID
            valInputId: "sendDeplicate", //员工值框id
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
    }
}
$(function () {
	ManagePage.Resize();
    EnumList.GetEnumListToSelect($("#solveUserNo"), "empListJq", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#inUserNo"), "empListJq", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#closeUserNo"), "empListJq", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#isRead"), "isYes", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#importantDegree"), "dicDataforCustomerAgentBussinessImportance", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#type"), "letterType", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#status"), "letterStatus", $Url.BuildBaseInfoUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#isRead"), "remindType", $Url.BuildBaseInfoUrl("/common/enumList.action"));

    $("#expectFinishTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#back").click(function () {
        window.close();
    });
    $("#checkBox").change(function(){
        if($("input[type='checkbox']").is(':checked')==true){
            $(".hide").hide();
            $("#type").val(2);
        }else{
            $("#type").val(1);
            $(".hide").show();
        }
    });
    if(ElementVar.showAllEmp != "query"){
        $("#checkBox").hide();
        $("#checkBox").prev().hide();
    }
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
        ManagePage.HideButton();
        $("#inUserNo").val(PageVar.UserId);
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
    }
    ManagePage.Tree();
    $("#handel").click(function(){
        ManagePage.ClickHandel();
    });
    $("#solve").click(function(){
        ManagePage.ClickSolve();
        letterAdd.addRule([
            {
                ele: "#solvePlan",
                datatype: "*",
                nullmsg: "解决方案不能为空",
                errormsg:"",
                sucmsg: " "
            }
        ]);
    });
    $("#close").click(function(){
       ManagePage.ClickClose();
    });
    var letterAdd = $("#letterAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        ignoreHidden:true,
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildBaseInfoUrl("/baseInfo/letter/ajaxEditLetter");
            var oper = "add";
            if (Number(PageVar.ID) != 0){
                oper = "edit";
                if($("#status").val()==3){
                    oper = "solve";
                }
                if($("#status").val()==4){
                    oper = "close";
                }
            }
            var info = {
                id: PageVar.ID,
                recipient: $("#recipient").val(),
                subject: $("#subject").val(),
                content: $("#content").val(),
                isRead: $("#isRead").val(),
                importantDegree:$("#importantDegree").val(),
                level:$("#level").val(),
                sendDeplicate:$("#sendDeplicate").val(),
                type:$("#type").val(),
                status:$("#status").val(),
                solveUserNo:$("#solveUserNo").val(),
                solvePlan:$("#solvePlan").val(),
                closeUserNocloseUserNo:$("#closeUserNo").val(),
                expectFinishTime:$("#expectFinishTime").val(),
                inUserNo:$("#inUserNo").val()
                }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info),
                    comment:$("#comment").val()
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildBaseInfoUrl("/baseInfo/letter/edit?id=" + data.errDesc);
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
    letterAdd.addRule([
        {
            ele: "#subject",
            datatype: /^.{1,15}$/,
            nullmsg: "主题不可为空",
            errormsg:"请输入少于15位的字符",
            sucmsg: " "
        },
        {
            ele: "#expectFinishTime",
            datatype: "*",
            nullmsg: "预期完成时间不能为空",
            errormsg:"",
            sucmsg: " "
        },
        {
            ele: "#level",
            datatype: /^\d$/,
            ignore:"ignore",
            nullmsg: "",
            errormsg:"请填写数字",
            sucmsg: " "
        }
    ]);
})
