//附件
var SalesAdd = {
    BindFile: function (pathList) {
        var readOnly = true;
        if (ElementVar.showUploadButton == "query" && $("#empNo").val() == PageVar.UserId) {
            readOnly = false;
        }
        if (ElementVar.showUploadButton == "query") {
            readOnly = false;
        }
        $(".upload").Upload({
            inputID: "uploadInput",
            readOnly: readOnly,
            multiple: true,
            fileType: 1,
            url: $Url.BuildSalesUrl("/upload.action"),
            pathList: (pathList == undefined || pathList == null) ? [] : pathList,
            success: SalesAdd.SavaFileToDB,
            deleteFile: SalesAdd.DeleteFile,
            title: "相关文件"
        });
    },
    DeleteFile: function (o) {
        if (confirm("是否要删除当前文件")) {
            var id = $(o).attr("id").split("_")[1];
            var url = $Url.BuildSalesUrl("/sales/activityAttachment/ajaxDeleteFile");
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {id: id
                },
                beforeSend: function () {
                    $(o).after("<p></p>");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        $(o).parent().remove();
                    } else {
                        alert(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $(o).next().remove();
                }
            });
        }
    },
    SavaFileToDB: function (fileName, relativePath) {
        var url = $Url.BuildSalesUrl("/sales/activityAttachment/ajaxSaveFilePath");

        var fileID = 0;
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async: false,
            data: {id: PageVar.ID,
                type:1,
                name: fileName,
                path: relativePath
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    //ProductAdd.Resize();
                    fileID = data.errDesc;
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });

        return fileID;
    },
    GetFileList: function () {
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
                    var pathList = [];
                    $.each(data.resultList, function (index, content) {
                        pathList.push({
                            id: content.id,
                            name: content.name,
                            path: $Url.BuildFileUrl(content.path)
                        });
                    })
                    SalesAdd.BindFile(pathList);
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },

    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
    HideStatusButton: function () {
        if ($(".status").length == 0)
            $(".status").hide();
    },
    ShowStatusButton: function (currStatus) {
        if ($(".status").length == 0)
            return;
        var nextStatus, nextName;
        switch (currStatus) {
            case PageVar.StatusAccount:
                $(".status").show();
                break;
            default:
                $(".status").remove();
                return;
        }
    },
    ShowEditButton: function (currStatus) {
        if ($("#edit").length == 0)
            return;
        $("#submit").hide();
        switch (currStatus) {
            case PageVar.StatusCheck:
            case PageVar.StatusAccount:
            case PageVar.StatusSuccess:
                $("#edit").show();
                break;
        }
    },
    GetCurrentStatus: function () {
        return $("#status").val();
    },
    HideEditButton: function () {
        if ($("#edit").length == 0)
            return;
        $("#submit").show();
        $("#edit").hide();
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
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
        $(".creditora").attr("disabled", "disabled")
        $(".money").attr("disabled", "disabled");
        $(".creditora").eq(-1).removeAttr("disabled");
        $(".money").eq(-1).removeAttr("disabled");
        $("#deptNo").attr("disabled", "disabled");
    },
    GetPermission: function (currStatus) {
        switch (currStatus + "") {
            case PageVar.StatusRefund:
                ElementVar.contractCode = SalesAdd.getTagPermission(ElementVar.contractCode, TagPermissionType.query);
            case PageVar.StatusSuccess:
                ElementVar.protocolStatus = SalesAdd.getTagPermission(ElementVar.protocolStatus, TagPermissionType.query);
                ElementVar.purchaseDate = SalesAdd.getTagPermission(ElementVar.purchaseDate, TagPermissionType.query);
                ElementVar.bankAddress = SalesAdd.getTagPermission(ElementVar.bankAddress, TagPermissionType.query);
                ElementVar.bankName = SalesAdd.getTagPermission(ElementVar.bankName, TagPermissionType.query);
                ElementVar.accountNumber = SalesAdd.getTagPermission(ElementVar.accountNumber, TagPermissionType.query);
            case PageVar.StatusAccount:
                ElementVar.productType = SalesAdd.getTagPermission(ElementVar.productType, TagPermissionType.query);
                ElementVar.productNo = SalesAdd.getTagPermission(ElementVar.productNo, TagPermissionType.query);
                ElementVar.customerType = SalesAdd.getTagPermission(ElementVar.customerType, TagPermissionType.query);
                ElementVar.customerNo = SalesAdd.getTagPermission(ElementVar.customerNo, TagPermissionType.query);
                ElementVar.peopleType = SalesAdd.getTagPermission(ElementVar.peopleType, TagPermissionType.query);
                ElementVar.peopleNo = SalesAdd.getTagPermission(ElementVar.peopleNo, TagPermissionType.query);
                ElementVar.agentRateReal = SalesAdd.getTagPermission(ElementVar.agentRateReal, TagPermissionType.query);
                ElementVar.money = SalesAdd.getTagPermission(ElementVar.money, TagPermissionType.query);
                ElementVar.purchaseDate = SalesAdd.getTagPermission(ElementVar.purchaseDate, TagPermissionType.query);
                ElementVar.agentRate = SalesAdd.getTagPermission(ElementVar.agentRate, TagPermissionType.query);
            case PageVar.StatusCheck:
                break;
        }
    },
    getTagPermission: function (DBPermission, TagPermission) {
        var ElementVarToNumber = function (val) {
            if (val == TagPermissionType.none) {
                return 0;
            }
            else if (val == TagPermissionType.query) {
                return 1;
            }
            else {
                return 2;
            }
        }
        return ElementVarToNumber(DBPermission) < ElementVarToNumber(TagPermissionType) ? DBPermission : TagPermission;
    },
    buildPaymentRefund:function(){
        var url = $Url.BuildSalesUrl("/sales/sales/ajaxBuildPaymentRefundForP2pProduct");
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
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    alert("匹配债券成功");
                    window.location.reload();
                    return;

                }
                alert(data.errDesc);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    CancelSales: function () {
        var url = $Url.BuildSalesUrl("/sales/sales/ajaxCancelSalesForP2pProduct");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            async: false,
            timeout: 30000,
            data: {
                id: PageVar.ID
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    alert("完成操作");
                    $("#status").text("已取消");
                    $("#cancelSales").hide();
                    $("#recovery").show();
                    return;
                }
                alert(data.errDesc);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    ModifyIncome: function (income) {
        var url = $Url.BuildSalesUrl("/sales/sales/ajaxModifyIncomeForP2pProduct");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 300000,
            data: {
                id: PageVar.ID,
                income:income
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    $("#income").text(income);
                    alert("已修改利率为"+income);
                    return;
                }
                alert(data.errDesc);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}

var InitValue = {
    FormatAgent: function () {
        $("#peopleType").change(function () {
            if ($("#peopleType").val() == 1) {
                $("#peopleNo").parent().show();
                $("#peopleNo").prev().html("渠道");
            }
            else if ($("#peopleType").val() == 2) {
                $("#peopleNo").parent().show();
                $("#peopleNo").prev().html("投顾");
            } else {
                $("#peopleNo").parent().hide();
            }
        });
    },
    InitTriggerSelect: function () {
        $("#productType").trigger("change");
        $("#peopleType").trigger("change");
        $("#customerType").trigger("change");
    }

}
