var ManagePage = {
    Resize: function () {
        $("#content_center").css("min-height", "1360px");
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
    GetInfoListByName :function(){
        var url = $Url.BuildEmployeeUrl("/employee/interviewEvaluationRecord/ajaxGetInfoListByName");
        $.ajax({
            type: "post",
            url: url,
            dataType: "html",
            timeout: 30000,
            data: {name:$("#byName").html(),
                showReTest:$("#showReTest").val()},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                $("#interviewEvaluationConTent").html(data);
                ConTent.GetConTentList();
                if($("#errCode").html()=="0000"){
                    ManagePage.ShowEditButton();
                    ManagePage.DisableInput();
                    if($("#empNo2").length>0){
                        var head = $("#head").find(".data");
                        for(var i=0;i<head.length;i++){
                            $(head[i]).removeClass("data");
                        }
                        var first = $("#first").find(".data");
                        for(var i=0;i<first.length;i++){
                            $(first[i]).removeClass("data");
                        }
                    }
                }else if($("#errCode").html()=="0001"){
                    ManagePage.DisableInput();
                    var head = $("#head").find(".data");
                    for(var i=0;i<head.length;i++){
                        $(head[i]).removeClass("data");
                    }
                    var first = $("#first").find(".data");
                    for(var i=0;i<first.length;i++){
                        $(first[i]).removeClass("data");
                    }
                    var second = $("#second").find(".data");
                    for(var i=0;i<second.length;i++){
                        $(second[i]).removeClass("data");
                        $(second[i]).removeAttr("disabled");
                    }
                    ManagePage.HideEditButton();
                    $("input[id=score2]").val("");
                }
                else{
                    ManagePage.HideEditButton();
                    $("input[id=score1]").val("");
                    $("input[id=score2]").val("");
                }
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
    ManagePage.Resize();
    ManagePage.GetInfoListByName();
    $("#back").click(function () {
//        window.location.href = $Url.BuildEmployeeUrl("/employee/interviewEvaluationRecord/list");
        $EasyUI.Close();
    });

})
var ConTent = {
    GetConTentList:function(){
        EmployeeTreeControl.startTree({
            param: "on",  //on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel",//员工控件框ID
            valInputId: "retestUserNo", //员工值框id
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
        // EnumList.GetEnumListToSelect($("#retestUserNo"), "empListForEmp1", $Url.BuildEmployeeUrl("/common/enumList.action"));

        var hsex = $("#hsex").val();
        $("#sex").find("option[value='" + hsex + "']").attr("selected",true);

        var hdesirePositionNo = $("#hdesirePositionNo").val();
        EnumList.GetEnumListToSelect($("#desirePositionNo"), "positionListAll1", $Url.BuildEmployeeUrl("/common/enumList.action"));
        $("#desirePositionNo").find("option[value='" + hdesirePositionNo + "']").attr("selected",true);

        $("#firstTime").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });

        var hconclusion1 = $("#hconclusion1").val();
        $("#conclusion1").find("option[value='" + hconclusion1 + "']").attr("selected",true);

        var hempNo1 = $("#hempNo1").val();
        if(hempNo1==null||hempNo1=="0"||hempNo1==undefined||hempNo1==""){
            hempNo1 = $("#hempNo11").val();
        }
        EnumList.GetEnumListToSelect($("#empNo1"), "empListForEmp1", $Url.BuildEmployeeUrl("/common/enumList.action"));
        $("#empNo1").find("option[value='" + hempNo1 + "']").attr("selected",true);

        var HhirePositionNo = $("#HhirePositionNo").val();
        EnumList.GetEnumListToSelect($("#hirePositionNo"), "positionListAll1", $Url.BuildEmployeeUrl("/common/enumList.action"));
        $("#hirePositionNo").find("option[value='" + HhirePositionNo + "']").attr("selected",true);

        $("#interviewDate1").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });

        var hconclusion2 = $("#hconclusion2").val();
        $("#conclusion2").find("option[value='" + hconclusion2 + "']").attr("selected",true);

        var hempNo2 = $("#hempNo2").val();
        if(hempNo2==null||hempNo2=="0"||hempNo2==undefined||hempNo2==""){
            hempNo2 = $("#hempNo22").val();
        }
        EnumList.GetEnumListToSelect($("#empNo2"), "empListForEmp1", $Url.BuildEmployeeUrl("/common/enumList.action"));
        $("#empNo2").find("option[value='" + hempNo2 + "']").attr("selected",true);

        $("#interviewDate2").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });

        $("#conclusion2").off().change(function(){
            if($(this).val()==5){
                $("#showhirePositionNo").show();
            }else{
                $("#showhirePositionNo").hide();
            }
        });

        if($("#conclusion2 option:selected").val()==5){
            $("#showhirePositionNo").show();
        }

        var scoreList1 = new Array();
        var s1=$("tr[id=part1]").find("input[id=score1]");
        for(var i=0;i<s1.length;i++){
            scoreList1.push(s1[i].value);
        }

        var scoreList2 = new Array();
        var s2=$("tr[id=part2]").find("input[id=score2]");
        for(var i=0;i<s2.length;i++){
            scoreList2.push(s2[i].value);
        }

        var totalScore1 = $("#totalScore1");
        s1.off().change(function(){
            var total1 = 0;
            for(var i=0;i<s1.length;i++){
                var va = s1[i].value;
                if(va==null||va==""){
                    va = "0";
                }
                total1=parseFloat(total1)+parseFloat(va);
            }
            totalScore1.val(total1);
        });

        var totalScore2 = $("#totalScore2");
        s2.off().change(function(){
            var total2 = 0;
            for(var i=0;i<s2.length;i++){
                var va = s2[i].value;
                if(va==null||va==""){
                    va = "0";
                }
                total2=parseFloat(total2)+parseFloat(va);
            }
            totalScore2.val(total2);
        });

        var interviewEvaluationRecordAdd = $("#interviewEvaluationRecordAdd").Validform({
            tiptype: function (msg, o, cssctl) {
//		            var objtip = o.obj.siblings(".Validform_checktip");
//		            cssctl(objtip, o.type);
//		            objtip.text(msg);

                $("#errMsg").html("");
                $("#errMsg").html(msg);
            },
            datatype:{
                "verifySelect": function (gets, obj, curform, datatype) {
                    if (gets == "0" || gets == "")
                        return false;
                    else
                        return true;
                }
            },
            callback: function (form) {
                if (!($("#submit").attr("process") === undefined)) {
                    return false;
                }
                var url = $Url.BuildEmployeeUrl("/employee/interviewEvaluationRecord/ajaxEditInterviewEvaluationRecord");
                var oper = "add";
                if (Number(PageVar.ID) != 0){
                    if($("#hempNo1").val()!=""&& $("#hempNo1").val()!=null&&$("#hempNo2").length<=0){
                        oper = "edit";
                    }
                    if($("#hempNo1").val()!=""&& $("#hempNo1").val()!=null&&$("#hempNo2").val()!=""&& $("#hempNo2").val()!=null){
                        oper = "edit";
                    }
                }

                var scoreList1 = new Array();
                var s1=$("tr[id=part1]").find("input[id=score1]");
                for(var i=0;i<s1.length;i++){
                    scoreList1.push(s1[i].value);
                }

                var scoreList2 = new Array();
                var s2=$("tr[id=part2]").find("input[id=score2]");
                for(var i=0;i<s2.length;i++){
                    scoreList2.push(s2[i].value);
                }
                var info1 = {
                    id: PageVar.ID,
                    name: $("#name").val(),
                    sex: $("#sex").val(),
                    desirePositionNo: $("#desirePositionNo").val(),
                    firstTime: $("#firstTime").val().toTimetamp(),
                    totalScore: $("#totalScore1").val(),
                    evaluation: $("#evaluation").val(),
                    conclusion: $("#conclusion1").val(),
                    hirePositionNo: $("#hirePositionNo").val(),
                    empNo: $("#empNo1").val(),
                    interviewDate: $("#interviewDate1").val().toTimetamp(),
                    firstEvaluation: $("#firstEvaluation").val(),
                    retestUserNo:$("#retestUserNo").val()
                };
                var info2;
                if($("#interviewDate2").val()!=undefined){
                    info2 = {
                        id: PageVar.ID,
                        name: $("#name").val(),
                        sex: $("#sex").val(),
                        desirePositionNo: $("#desirePositionNo").val(),
                        firstTime: $("#firstTime").val().toTimetamp(),
                        totalScore: $("#totalScore2").val(),
                        evaluation: $("#evaluation").val(),
                        conclusion: $("#conclusion2").val(),
                        hirePositionNo: $("#hirePositionNo").val(),
                        empNo: $("#empNo2").val(),
                        interviewDate: $("#interviewDate2").val().toTimetamp(),
                        secondEvaluation: $("#secondEvaluation").val()
                    };
                }
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    timeout: 30000,
                    data: {
                        oper: oper,
                        info1: JSON.stringify(info1),
                        info2: JSON.stringify(info2),
                        scoreList1:JSON.stringify(scoreList1),
                        scoreList2:JSON.stringify(scoreList2)
                    },
                    beforeSend: function () {
                        $("#submit").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(errorThrown);
                    },
                    success: function (data, textStatus) {
                        if (data.errCode == "0000") {
                            window.location.href = $Url.BuildEmployeeUrl("/employee/interviewEvaluationRecord/edit?id=" + data.errDesc+"&name="+$("#name").val());
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
        interviewEvaluationRecordAdd.addRule([
            {
                ele:"#name",
                dataType:"*",
                nullmsg:"请填写应聘者姓名",
                sucmsg:" ",
                errmsg:"请如实输入姓名"
            },
            {
                ele:"#desirePositionNo",
                datatype:"verifySelect",
                //ignore:"ignore",
                nullmsg:"",
                errormsg:"请选择应聘职位",
                sucmsg:" "
            },
            {
                ele:"#firstTime",
                dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
                //dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/",
                nullmsg:"请填写初试时间",
                errormsg:"请填写正确的时间",
                sucmsg:" "
            },
            {
                ele:"#interviewDate1",
                dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
                nullmsg:"请填写日期",
                errormsg:"请填写正确的日期",
                sucmsg:" "
            },
            {
                ele:".score1",
                datatype:"/^0|[1]0|[1-9]{1}|[1-9]{1,1}?\.[1-9]{1,1}|0\.[1-9]{1,1}?$/",
                //ignore:"ignore",
                nullmsg:"请填写分数",
                errormsg:"请填写正确的分数",
                sucmsg:" "
            },
            {
                ele:"#conclusion1",
                datatype:"verifySelect",
                //ignore:"ignore",
                nullmsg:"",
                errormsg:"请选择初试结论",
                sucmsg:" "
            },
            {
                ele:".score2",
                datatype:"/^0|[1]0|[1-9]{1}|[1-9]{1,1}?\.[1-9]{1,1}|0\.[1-9]{1,1}?$/",
                //ignore:"ignore",
                nullmsg:"请填写分数",
                errormsg:"请填写正确的分数",
                sucmsg:" "
            },
            {
                ele:"#empNo1",
                datatype:"verifySelect",
                //ignore:"ignore",
                nullmsg:"",
                errormsg:"请选择面试官",
                sucmsg:" "
            },
            {
                ele:"#evaluation",
                dataType:"*",
                nullmsg:"请填写综合评价",
                sucmsg:" ",
                errmsg:""
            },
            {
                ele:"#conclusion2",
                datatype:"verifySelect",
                //ignore:"ignore",
                nullmsg:"",
                errormsg:"请选择复试结论",
                sucmsg:" "
            },
            {
                ele:"#interviewDate2",
                dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
                nullmsg:"请填写日期",
                errormsg:"请填写正确的日期",
                sucmsg:" "
            }
        ]);
        $("#conclusion2").change(function(){
            /*if($("#conclusion2 option:selected").val()!=0){
             interviewEvaluationRecordAdd.addRule([
             {
             ele:".score2",
             datatype:"/^[1]0|[1-9]{1}|[1-9]{1,1}?\.[1-9]{1,1}|0\.[1-9]{1,1}?$/",
             //ignore:"ignore",
             nullmsg:"请填写分数",
             errormsg:"请填写正确的分数",
             sucmsg:" "
             }
             ]);
             }*/
            if($("#conclusion2 option:selected").val()==5){//
                interviewEvaluationRecordAdd.addRule([
                    {
                        ele:"#hirePositionNo",
                        datatype:"verifySelect",
                        ignore:"ignore",
                        nullmsg:"",
                        errormsg:"请选择录用职位",
                        sucmsg:" "
                    }
                ]);
            }else{
                $("#hirePositionNo").removeAttr("datatype").removeAttr("nullmsg").removeAttr("errormsg").removeAttr("class");
            }
        });
        /*if(parseFloat($("#totalScore2").val())>0){//
         interviewEvaluationRecordAdd.addRule([
         {
         ele:"#conclusion2",
         datatype:"verifySelect",
         nullmsg:"",
         errormsg:"请选择复试结论",
         sucmsg:" "
         },
         {
         ele:"#interviewDate2",
         dataType:"/^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$/",
         nullmsg:"请填写日期",
         errormsg:"请填写正确的日期",
         sucmsg:" "
         }
         ]);
         }*/
    }

}
