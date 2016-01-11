var SalesDetailForP2pProduct = {
    BindFile: function (pathMap,type) {
        var fileTypes = [];
        if(type==0){
            fileTypes = [
                {key: 1, name: "身份证"},
                {key: 2, name: "银行卡"},
                {key: 3, name: "打款凭条"},
            ];
        }else{
            fileTypes = [
                {key: 4, name: "续投确认单"}
            ];
        }

        var readOnly = true;
        if (ElementVar.showUploadButton == "query" && $("#empNo").val() == PageVar.UserId) {
            readOnly = false;
        }
        if (ElementVar.showUploadButton == "query") {
            readOnly = false;
        }
        $.each(fileTypes, function (index, content) {
            var div = "<div id=\"div_" + content.key + "\" class=\"upload\"></div>";
            $("#uploadDiv").append(div);

            $("#uploadDiv #div_" + content.key).Upload({
                inputID: "upload" + content.key,
                readOnly: readOnly,
                multiple: true,
                fileType: 1,
                url: $Url.BuildProductUrl("/upload.action"),
                paramList: [content.key],
                pathList: (pathMap == undefined || pathMap == null)?[]:pathMap[content.key],
                title: content.name
            });
        })
    },
    GetFileList: function (type) {
        var url = $Url.BuildSalesUrl("/sales/activityAttachment/ajaxListFile");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                activityNo: PageVar.ID,
                type:1
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    var pathMap = {};
                    $.each(data.resultList, function (index, content) {
                        if (!pathMap[content.type])
                            pathMap[content.type] = [];
                        pathMap[content.type].push({
                            id: content.id,
                            name: content.name,
                            path: $Url.BuildFileUrl(content.path)
                        })
                    });
                    SalesDetailForP2pProduct.BindFile(pathMap,type);
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
        newUser: function () {
            $('#dlg').dialog('open').dialog('center').dialog('setTitle', '添加债权');
            $('#fm').form('clear');
        },
        saveUser: function () {
            var info = {
                creditorNo: $(".creditor").val(),
                salesNo: PageVar.ID,
                money: $(".money").val()
            }

            var url = $Url.BuildSalesUrl("/sales/salesCreditor/ajaxEditSalesCreditor.action");
            $.ajax({
            type: "post",
            url: url,
            data: {
                oper: "add",
                info: JSON.stringify(info)
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    alert(data.errDesc);
                }else{
                    $('#dlg').dialog('close');
                    $('#dg').datagrid('reload');
                    location.reload();
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        },
        destroyUser:function(){
            var row = $('#dg').datagrid('getSelected');
            var url = $Url.BuildSalesUrl("/sales/salesCreditor/ajaxDelSalesCreditor.action");
            if (row){
                $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                    if(r){
                        $.post(url,{infoId:row.id},function(result){
                            if(result.errCode=="0000"){
                                $('#dg').datagrid('reload');
                                location.reload();
                            }else{
                                $.message.show({
                                    title:'Error',
                                    msg:result.errormsg
                                });
                            }
                        },'json');
                    }
                });
            }
        },
        Resize: function () {
            $("#content_center").css('height',$('.detail').height()+200);
        }
        ,
        GetSalesInfo: function (id) {
            var url = $Url.BuildSalesUrl("/sales/sales/ajaxGetSales");
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
                success: function (data) {
                    if (data.errCode != "0000") {
                        $("#msg").text(data.errDesc);
                        return;
                    }
                    else {
                        SalesDetailForP2pProduct.GetFileList(data.info.type);
                        $Util.DataToA(data.info, ElementVar);
                        EnumList.GetEnumListToSelect($(".creditor"), "creditorListByProduct", $Url.BuildSalesUrl("/common/enumList.action"),data.info.productNo);
                        $Link.MakeUrl($("#protocolStatus"), data.info.protocolStatus, "protocolStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                        $Link.MakeUrl($("#empNo"), data.info.empNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"), $Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                        $Link.MakeUrl($("#status"), data.info.status, "salesStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                        $Link.MakeUrl($("#peopleType"), data.info.peopleType, "agentType", $Url.BuildSalesUrl("/common/enumList.action"));
                        $Link.MakeUrl($("#productNo"), data.info.productNo, "productList", $Url.BuildSalesUrl("/common/enumList.action"), $Url.BuildSalesUrl("/product/product/detail"));
                        $Link.MakeUrl($("#customerType"), data.info.customerType, "customerType", $Url.BuildSalesUrl("/common/enumList.action"));
                        if (data.info.peopleType == "1") {
                            $Link.MakeUrl($("#peopleNo"), data.info.peopleNo, "agentBusiness", $Url.BuildSalesUrl("/common/enumList.action"), $Url.BuildSalesUrl("/customer/customerPersonal/detail"));
                        }
                        else if (data.info.peopleType == "2") {
                            $Link.MakeUrl($("#peopleNo"), data.info.peopleNo, "agentAdviser", $Url.BuildSalesUrl("/common/enumList.action"), $Url.BuildSalesUrl("/customer/customerCompany/detail"));
                        } else {
                            $("#peopleNo").remove();
                            $("#peopleNoa").remove();
                        }
                        if (data.info.customerType == "1") {
                            $Link.MakeNewUrl($("#customerNo"),data.info,$Url.BuildSalesUrl("/customer/customerPersonal/detail"));
                        }
                        else if (data.info.customerType == "2") {
                            $Link.MakeUrl($("#customerNo"), data.info, $Url.BuildSalesUrl("/customer/customerCompany/detail"));
                        }else if(data.info.customerType == "3"){
                        	var url = $Url.BuildCustomerUrl("/customer/p2pCustomer/ajaxGetP2pCustomer");
                            $.ajax({
                                type: "post",
                                url: url,
                                dataType: "json",
                                timeout: 30000,
                                data: {
                                    id: data.info.customerNo
                                },
                                beforeSend: function () {
                                },
                                error: function (XMLHttpRequest, textStatus, errorThrown) {
                                    alert(errorThrown);
                                },
                                success: function (data, textStatus) {
                                    if (data.errCode == "0000") {
                                    	$("#customerNo").text(data.realName);
                                    }
                                },
                                complete: function (XMLHttpRequest, textStatus) {
                                }
                            });
                        }
                        if (data.info.isTest == 0) {
                            $("#isTest").text("否");
                        } else {
                            $("#isTest").text("是");
                        }
                        if (data.info.status == 5) {
                            $("#recovery").show();
                            $("#cancelSales").hide();
                        }
                        Audit.GetWindow(data.info.activitiNo);
                        Audit.InitGrid(data.info.activitiNo);
                        if ($("#examine").length > 0) {
                            if (data.info.empNo == PageVar.UserId && !$String.IsNullOrEmpty(data.info.activitiNo)) {
                                $("#examine").val("提交审核");
                            }
                        }
                        SalesDetailForP2pProduct.InitCancelButton();
                        SalesDetailForP2pProduct.UpdateIncome();
                    }
                }

            });
        },
        InitCancelButton: function () {
                $(".cancelSales").click(function () {
                    SalesAdd.CancelSales();
                    $("#w1").window("close");
                    $("#examine").hide();
                });
        },

    UpdateIncome: function () {
        $("#modifyIncome").click(function(){
            $("#income_dialog").window('open');
            $("#ok").unbind().click(function(){
                $("#income_dialog").window('close');
                SalesAdd.ModifyIncome($("#newIncome").val());
            });
        });
    },
    PaymentRefund:function(){
        var url = $Url.BuildSalesUrl("/sales/sales/ajaxPaymentRefund");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                id: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                //alert(XMLHttpRequest.)
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    alert("操作成功");
                    window.location.reload();
                    return;

                }
                alert(data.errDesc);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var Audit = {
        StartAudit: function (obj, url, activitiNo) {
            var uri = window.location.href;
            var sendData = {
                per: obj.val(),
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
                    //alert(request);
                },
                success: function (data, textStatus) {
                    if ($String.IsNullOrEmpty(activitiNo)) {
                        alert("提交成功");
                        window.location.href = $Url.BuildSalesUrl("/sales/sales/detailForP2pProduct?id=" + PageVar.ID + "&activitiNo=" + data.activitiNo);
                    } else {
                        alert("审批成功");
                        location.reload();
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        },
        GetWindow: function (activitiNo) {
            if ($String.IsNullOrEmpty(activitiNo)) {
                $("#submitExamine").click(function () {
                    var url = $Url.BuildWorkFlowUrl('/workFlow/processing/ajaxStartSalesAuditProcess.action');
                    Audit.StartAudit($("#submit1"), url, activitiNo);
                });
            } else {
                $("#examine").click(function () {
                    $('#w1').window('open');
                });
                $(".examine").click(function () {
                    var url = $Url.BuildWorkFlowUrl("/workFlow/auditTask/ajaxAddExamine.action");
                    Audit.StartAudit($(this), url, activitiNo);
                });
            }
        },
        GetUrlActivitNo: function () {
            var urlTemp = location.search;
            var theRequest = new Object();
            var strs = "";
            if (urlTemp.indexOf("?") != -1) {
                var str = urlTemp.substr(1);
                if (str.indexOf("activitiNo=") != -1) {
                    strs = str.split("activitiNo=")[1];
                }
            }
            return strs;
        },
        InitGrid: function (activitiNo) {
            $("#salesExamineTable").jqGrid({
                url: $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxGetAuditComment"),
                datatype: "json",
                mytype: "GET",
                colNames: ["审核人", "审核时间", "审核内容"],
                colModel: [
                    {
                        name: "checkName",
                        index: "checkName",
                        width: 10,
                        align: "center",
                        formoptions: {rowpos: 1, colpos: 1},
                        sortable: false,
                        editable: true,
                        editoptions: {size: 20},
                        editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                    },
                    {
                        name: "checkTime",
                        index: "checkTime",
                        width: 15,
                        align: "center",
                        formoptions: {rowpos: 2, colpos: 1},
                        sortable: false,
                        editable: true,
                        editoptions: {size: 20},
                        editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
                    },
                    {
                        name: "checkComment",
                        index: "checkComment",
                        width: 60,
                        align: "left",
                        formoptions: {rowpos: 2, colpos: 2},
                        sortable: false,
                        editable: true,
                        editoptions: {size: 20},
                        editrules: {required: true, number: true, minValue: 0.01, maxValue: 99}
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
                }
            });
        }
    }
    $(function () {
        SalesDetailForP2pProduct.Resize();
        SalesDetailForP2pProduct.GetSalesInfo(PageVar.ID);
        $("#back").click(function () {
            $EasyUI.Close();
        });
        $("#loanSituation").click(function () {
            window.open($Url.BuildSalesUrl("/sales/loanSituation/list?saleNo=" + PageVar.ID));
        });
        $("#confirm").click(function () {
            window.open($Url.BuildSalesUrl("/sales/confirmationLetter/list?saleNo=" + PageVar.ID));
        });
        $("#collectionConfirm").click(function () {
            window.open($Url.BuildSalesUrl("/sales/collectionConfirm/list?saleNo=" + PageVar.ID));
        });
        $("#repurchaseCommit").click(function () {
            window.open($Url.BuildSalesUrl("/sales/repurchaseCommit/list?saleNo=" + PageVar.ID));
        });
        $("#build").click(function () {
            SalesAdd.buildPaymentRefund();
        });
        $("#paymentRefund").click(function(){
            SalesDetailForP2pProduct.PaymentRefund();
        });
		$('.trackBtn').on('click',function(){
            var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
            var activitiNo = Audit.GetUrlActivitNo();
            initAll.GetAuditProcess(url,activitiNo);
        });
        $("#recovery").click(function(){
            if(confirm("确定需要恢复该订单？")){
                var url = $Url.BuildSalesUrl("/sales/sales/ajaxRecoveryBySalesNo.action");
                $.ajax({
                    type: "post",
                    url: url,
                    async: false,
                    data: {
                        salesNo: PageVar.ID
                    },
                    beforeSend: function () {
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(errorThrown);
                    },
                    success: function (data, textStatus) {
                        if(data.errCode!="failed"){
                            alert("操作成功");
                            location.reload();
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                    }
                });
            }

        });
    });