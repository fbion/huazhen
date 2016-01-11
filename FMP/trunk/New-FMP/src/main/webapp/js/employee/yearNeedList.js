var ManagePage = {
    Resize: function () {
        $("#content_center").css({"min-height":"803px","height":$('.wrappContent').height()+100});
    },
    EnableInput : function() {
        $.each($(".data"), function(index, content) {
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
    },
    DisableInput : function() {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton : function(currStatus) {
        if ($("#edit").length > 0)
            $("#edit").show();
        if ($("#submit").length > 0)
            $("#submit").hide();

    },
    HideEditButton : function() {
        if ($("#edit").length > 0)
            $("#edit").hide();
        if ($("#submit").length > 0)
            $("#submit").show();

    },
    GetInfo : function(id) {
        var url = $Url
            .BuildEmployeeUrl("/employee/yearNeedTotal/ajaxGetYearNeedTotal");
        $.ajax({
            type : "post",
            url : url,
            dataType : "json",
            timeout : 30000,
            data : {
                id : id
            },
            beforeSend : function() {
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success : function(data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);

                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function() {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
                ManagePage.GetAuditComment(data.info.activitiNo);
                ManagePage.GetWindow(data.info.activitiNo);
            },
            complete : function(XMLHttpRequest, textStatus) {
            }
        });
    },
    GetAuditComment: function (activitiNo) {
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditComment");
        $.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            data: {
                "activitiNo":activitiNo
            },
            error: function (request) {
                alert(request);
            },
            success: function (data) {
                $("#aduitComment").append(data);
            }
        })
    },
    GetWindow:function(activitiNo){
        $("#examine").click(function(){
            $('#w1').window('open')
        });

        $(".examine").click(function(){
            var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
            if($(this).val()=="通过"){
                //if($("#activitiStatus").val()=="1")
                //alert(activitiNo)
                if(activitiNo==0)
                    var  url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartYearNeedProcess.action');
                else
                    var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
            }
            //var projectName=window.location.pathname.substring(0,window.location.pathname.substr(1).indexOf('/')+1);
            var uri=window.location.href;//window.location.pathname.replace(projectName,"")+window.location.search ;
            var sendData={
                per:$(this).val(),
                id: PageVar.ID,
                activitiNo:activitiNo,
                comment:$("#taskCommet").val(),
                uri:uri
            };
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: sendData,
                beforeSend: function () {
                },
                error: function (XMLHttpRequest, textStatus, errorThrown,request) {
                    alert(errorThrown);
                    //alert(request);
                },
                success: function (data, textStatus) {
                    alert("审批成功");
                    $("#taskCommet").val("");
                    $('#w1').window('close');
                    window.location.reload();
                    $("#examine").hide();

                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        });
    }
}
$(function() {
    $("#mssage").hide();
    if($("#financialYears").val()!=null){
        $("#financialYears").trigger("change");
        $("#financialYears").change(function() {
            var yearNeedUrl = $Url.BuildProductUrl('/employee/yearNeed/ajaxListYearNeed');
            $(".position").empty();
            $("#positionList").empty();

            yearNeedList.GetYearNeedListToSelect(yearNeedUrl, $(this).val());

            ManagePage.Resize();
            if ($("#totalCode").val() == "") {
                ManagePage.EnableInput();
                ManagePage.HideEditButton();
            } else {
                ManagePage.DisableInput();
                ManagePage.ShowEditButton();
            }
        });
    }
    if($("#financialYears").val()!=null){
        var yearNeedList = {
            GetYearNeedListToSelect : function(yearNeedUrl, param) {
                $.ajax({
                    type : "post",
                    async : false,
                    url : yearNeedUrl,
                    dataType : "html",
                    cache : true,
                    beforeSend : function(XMLHttpRequest) {
                    },
                    data : {
                        param : param
                    },
                    success : function(data) {
                        $(".position").html(data);
                        var i = 0;
                        $(".addEmpTotal").each(function(index) {
                            i = parseInt(i) + parseInt($(this).val());
                        });
                        $("#AllEmp").val(i);
                        ManagePage.Resize();
                    },
                    complete : function(XMLHttpRequest, textStatus) {
                    },
                    error : function() {
                        // 请求出错处理
                        alert("内部错误1");
                    }
                });
            }
        }
        var yearNeedUrl = $Url.BuildEmployeeUrl('/employee/yearNeed/ajaxListYearNeed');
        yearNeedList.GetYearNeedListToSelect(yearNeedUrl, $("#financialYears").val());
    }else{
        $("#btn").hide();
        $("#mssage").show();
    }
    // ManagePage.InitGrid();
    // ManagePage.InitQuery();

    var yearNeedTotalAdd = $("#yearNeedTotalAdd")
        .Validform(
        {
            tiptype : function(msg, o, cssctl) {
                var objtip = o.obj.siblings(".Validform_checktip");
                cssctl(objtip, o.type);
                objtip.text(msg);
            },
            callback : function(form) {
                if (!($("#submit").attr("process") === undefined)) {
                    return false;
                }
                var url = $Url
                    .BuildEmployeeUrl("/employee/yearNeedTotal/ajaxEditYearNeedTotal");
                var oper = "add";
                /* if (Number(PageVar.ID) != 0)
                 oper = "edit";*/
                var info = {
                    id : PageVar.ID,
                    code : $("#totalCode").val(),
                    financialYear : $("#financialYears").val(),
                    total : $("#AllEmp").val(),
                    activitiNo : $("#activitiNo").val(),
                    editComment : $("#editComment").val()
                }
                $.ajax({
                    type : "post",
                    url : url,
                    dataType : "json",
                    timeout : 30000,
                    data : {
                        oper : oper,
                        info : JSON.stringify(info)
                    },
                    beforeSend : function() {
                        $("#submit").attr("process","processing");
                    },
                    error : function(XMLHttpRequest,textStatus, errorThrown) {
                        alert(errorThrown);
                    },
                    success : function(data, textStatus) {
                        if (data.info.financialYear > 0) {
                            var yearNeedUrl = $Url.BuildProductUrl('/employee/yearNeed/ajaxListYearNeed');
                            $(".position").empty();
                            $("#positionList").empty();
                            yearNeedList.GetYearNeedListToSelect(yearNeedUrl,data.info.financialYear);
                            $("#totalCode").val(data.info.code);
                        } else {
                            $("#msg").text(data.errDesc);
                        }
                    },
                    complete : function(XMLHttpRequest,
                                        textStatus) {
                        $("#submit").removeAttr("process");
                    }
                });
                return false;
            }
        });
    yearNeedTotalAdd.addRule([ {
        ele : ".totalCode",
        datatype : "*",
        //ignore:"ignore",
        nullmsg : "请输入编制编号！",
        sucmsg : " "
    } ]);

    $(".back").click(
        function() {
            window.location.href = $Url.BuildEmployeeUrl("/employee/deptYearNeed/list");
        });
    if ($("#totalCode").val() == "") {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
        $("#edit").click(function() {

            ManagePage.EnableInput();
            ManagePage.HideEditButton();
        });
        $("#submit").click(function() {

            ManagePage.EnableInput();
            ManagePage.ShowEditButton();
        });
    } else {
        ManagePage.DisableInput();
        ManagePage.ShowEditButton();
        $("#edit").click(function() {
            ManagePage.EnableInput();
            ManagePage.HideEditButton();
        });
        $("#submit").click(function() {
            ManagePage.EnableInput();
            ManagePage.ShowEditButton();
        });
    }

})
