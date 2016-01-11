/**
* Created by Administrator on 2015/8/7.
*/
var ProductExamine = {
    ShowEditButton: function () {
        if ($("#examine_edit").length > 0)
            $("#examine_edit").show();
        if ($("#examine_submit").length > 0)
            $("#examine_submit").hide();

    },
    HideEditButton: function () {
        if ($("#examine_edit").length > 0)
            $("#examine_edit").hide();
        if ($("#examine_submit").length > 0)
            $("#examine_submit").show();

    },
    EnableInput: function () {
        $.each($(".data1"), function (index, content) {
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
        $(".data1").attr("disabled", "disabled");
    },
    GetInfo: function (productNo) {
        var url = $Url.BuildSalesUrl("/sales/productTask/ajaxGetTaskByProductNo");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                productNo: productNo
            },
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
                $.each(data.productExamineList,function(i,value){
                   if(value.deptNo==10){
                       $(".task_amout1").val(value.taskAmout);
                       $(".sales_policy1").val(value.salesPolicy);
                       $(".sales_cycle").val(value.salesCycle);
                       $(".quota1").val(value.quota);
                       $(".incentive_policy1").val(value.incentivePolicy);
                       $("#id1").val(value.id);
                       $(".currAmout1").val(value.currAmout);
                   }
                   if(value.deptNo==11){
                       $(".task_amout2").val(value.taskAmout);
                       $(".sales_policy2").val(value.salesPolicy);
                       $(".sales_cycle").val(value.salesCycle);
                       $(".quota2").val(value.quota);
                       $(".incentive_policy2").val(value.incentivePolicy);
                       $("#id2").val(value.id);
                       $(".currAmout2").val(value.currAmout);
                   }

                })
                if ($("#id1").val == 0 && $("#id2").val() == 0){
                    ProductExamine.HideEditButton();
                    ProductExamine.EnableInput();
                }else{
                    ProductExamine.ShowEditButton();
                    ProductExamine.DisableInput();
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}

var Audit = {
    StartAudit: function (obj, url, activitiNo) {
        var uri = $Url.BuildProductUrl("/product/product/detail")+"?id="+PageVar.ID+"&activitiNo=";
        var sendData = {
            oper: obj.attr("oper"),
            id: PageVar.ID,
            activitiNo: activitiNo,
            comment: $("#taskCommet").val(),
            uri: uri
        };
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: sendData,
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if(data.errCode == "0000"){
                    if ($String.IsNullOrEmpty(activitiNo)) {
                        alert("提交成功");
                        window.location.href = window.location.href + data.activitiNo;
                    } else {
                        alert("审批成功");
                        $('#w1').window('close');
                        $("#examine").hide();
                        $("#edit").hide();
                        jQuery("#productExamineTable").trigger("reloadGrid");
                    }
                }
                else{
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetWindow: function (activitiNo) {
        if ($String.IsNullOrEmpty(activitiNo)) {
            $("#commitCheck").click(function () {
                if (confirm("您确定要提交审核？")){
                    var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartProductAuditProcess.action');
                    Audit.StartAudit($("#submit1"), url, activitiNo);
                }
            });
        } else {
            $(".examine").click(function () {
                $('#w1').window('open');
            });
            $(".audit").click(function(){
                var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamineWithEmail.action");
                Audit.StartAudit($(this), url, activitiNo);
            });
        }
    },
    GetUrlActivitNo:function(){
        var urlTemp = location.search;
        var theRequest = new Object();
        var strs="";
        if (urlTemp.indexOf("?") != -1) {
            var str = urlTemp.substr(1);
            if(str.indexOf("activitiNo=") != -1){
                strs = str.split("activitiNo=")[1];
            }
        }
        return strs;
    },
    InitGrid: function (activitiNo) {
        $("#productExamineTable").jqGrid({
            url: $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxProductAuditComment"),
            datatype: "json",
            mytype: "GET",
            colNames: ["审核部门", "是否通过", "审核时间", "审核人"],
            colModel: [
                {
                    name: "checkPosition", index: "checkPosition", width: 80, align: "center", formoptions: { rowpos: 1, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                },
                {
                    name: "checkComment", index: "checkComment", width: 80, align: "center",  formoptions: { rowpos: 1, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                },
                {
                    name: "checkTime", index: "checkTime", width: 80, align: "center", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                },
                {
                    name: "checkName", index: "checkName", width: 60, align: "center",  formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                }
            ],
            viewrecords: true,
            altclass: "altRowsColour",
            shrinkToFit: true,
            autowidth: true,
            height: "auto",
            postData: {
                activitiNo: activitiNo
            },
            jsonReader: {
                root: "commentList",
                repeatitems: false
            },
            gridComplete: function () {}
        });
    }
}


$(function () {
    $(".disabled").attr("disabled", "disabled");
    ProductExamine.GetInfo(PageVar.ID);
    if ($("#examine_edit").length > 0) {
        $("#examine_edit").click(function () {
            ProductExamine.EnableInput();
            ProductExamine.HideEditButton();
        });
    }
    $(".back").click(function(){
        window.close();
    });
    $('.trackBtn').on('click',function(){
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
        var activitiNo = Audit.GetUrlActivitNo();
        initAll.GetAuditProcess(url,activitiNo);
    });

    var productExamineAdd = $("#productExamineAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#examine_submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildSalesUrl("/sales/productTask/ajaxEditProductTask");
            var oper = "add";
            if ($("#id1").val != 0 && $("#id2").val() != 0)
                oper = "edit";

            var productExamineList = new Array();

            var info1 = {};
            info1.id = $("#id1").val();
            info1.productNo = $("#productNo").val();
            info1.deptNo = 10;
            info1.taskAmout = $("#task_amout1").val();
            info1.salesPolicy = $("#sales_policy1").val();
            info1.quota = $("#quota1").val();
            info1.incentivePolicy = $("#incentive_policy1").val();
            info1.salesCycle = $("#sales_cycle").val();

            productExamineList.push(info1);

            var info2 = {};
            info2.id = $("#id2").val();
            info2.productNo = $("#productNo").val();
            info2.deptNo = 11;
            info2.taskAmout = $("#task_amout2").val();
            info2.salesPolicy = $("#sales_policy2").val();
            info2.quota = $("#quota2").val();
            info2.incentivePolicy = $("#incentive_policy2").val();
            info2.salesCycle = $("#sales_cycle").val();

            productExamineList.push(info2);

            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    productExamineList: JSON.stringify(productExamineList)
                },
                beforeSend: function () {
                    $("#examine_submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        ProductExamine.DisableInput();
                        ProductExamine.ShowEditButton();
                    } else {
                        $("#msg").text(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#examine_submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    productExamineAdd.addRule([
        {
            ele: "#task_amout1",
            datatype: "*",
            nullmsg: "请输入承销额度",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#task_amout2",
            datatype: "*",
            nullmsg: "请输入承销额度",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#quota1",
            datatype: "*",
            nullmsg: "请输入服务费率",
            errormsg: "",
            sucmsg: " "
        },
        {
            ele: "#quota2",
            datatype: "*",
            nullmsg: "请输入服务费率",
            errormsg: "",
            sucmsg: " "
        }
    ]);

});