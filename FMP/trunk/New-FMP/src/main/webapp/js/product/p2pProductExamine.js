/**
* Created by Administrator on 2015/8/7.
*/
var Audit = {
    StartAudit: function (obj, url, activitiNo) {
        var uri = $Url.BuildProductUrl("/product/p2pProduct/detail")+"?id="+PageVar.id+"&activitiNo=";
        var sendData = {
            oper: obj.attr("oper"),
            id: PageVar.id,
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
                    var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartP2pProductAuditProcess.action');
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
        $("#p2pProductExamineTable").jqGrid({
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
            gridComplete: function () {
                //ManagePage.Resize();
            }
        });
    }
    /*InitGrid: function (activitiNo) {
        $("#p2pProductExamineTable").datagrid({
            url:$Url.BuildWorkFlowUrl("/workFlow/processing/ajaxProductAuditComment"),
            queryParams:{activitiNo:activitiNo},
            columns:[[
                {field:'checkPosition',title:'审核部门',width:200,align:'center'},
                {field:'checkComment',title:'审核内容',width:200,align:'center'},
                {field:'checkTime',title:'审核时间',width:200,align:'center'},
                {field:'checkName',title:'审核人',width:200,align:'center'}
            ]],
            fitColumns : true,
            singleSelect : true,
            fit:true,
            rownumbers:true
        });
    }*/
}