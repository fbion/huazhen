//附件
var FileManage = {
    BindFile: function (pathList) {
        var readOnly = true;
        if (ElementVar.showUploadButton == "query" && $("#empNo").val() == PageVar.UserId) {
            readOnly = false;
        }
        $(".upload").Upload({
            inputID: "uploadInput",
            readOnly: readOnly,
            multiple: true,
            fileType: 1,
            url: $Url.BuildSalesUrl("/upload.action"),
            pathList: (pathList == undefined || pathList == null) ? [] : pathList,
            success: FileManage.SavaFileToDB,
            deleteFile: FileManage.DeleteFile,
            title: "相关文件"
        });
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
                type: 1
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
                    FileManage.BindFile(pathList);
                } else {
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var SalesDetail = {
    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
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
                FileManage.GetFileList();
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                else {
                    $Util.DataToA(data.info, ElementVar);
                    $Link.MakeUrl($("#protocolStatus"), data.info.protocolStatus, "protocolStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#empNo"), data.info.empNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                    $Link.MakeUrl($("#status"), data.info.status, "salesStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#productType"), data.info.productType, "productType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#productNo"), data.info.productNo, "productList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/product/product/detail"));
                    $Link.MakeUrl($("#customerType"), data.info.customerType, "customerType", $Url.BuildSalesUrl("/common/enumList.action"));
                    //$Link.MakeUrl($("#customerNo"), data.info.p2pCustomerNo, "p2pCustomerListRealName", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/customer/customerPersonal/detail"));
                    
                    var url = $Url.BuildCustomerUrl("/customer/p2pCustomer/ajaxGetP2pCustomer");
                    $.ajax({
                        type: "post",
                        url: url,
                        dataType: "json",
                        timeout: 30000,
                        data: {
                            id: data.info.p2pCustomerNo
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
                    
                    if(data.info.isTest==0){
                        $("#isTest").text("否");
                    }else{
                        $("#isTest").text("是");
                    }
                }
                $("#paymentCheck").click(function () {
                	SalesDetail.CheckOk(PageVar.ID);
                });
                $("#paymentCancelRefund").click(function () {
                	SalesDetail.CheckFailed(PageVar.ID);
                });
            }
        });
    },
    CheckOk: function (id) {
        if (confirm("确定进行审核通过吗？")) {
            var url = $Url.BuildSalesUrl("/sales/sales/ajaxUpdateSalesStatus.action");
            $.ajax({
                type: "post",
                url: url,
                data: {
                    id: id
                },
                beforeSend: function () {
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if(data.errCode == "0000") {
                        alert("操作认购成功");
//                        $("#" + id + " td[aria-describedby='gridTable_status']").text("认购成功");
//
//                        $("#" + id + " td[aria-describedby='gridTable_act']").html("");
                    }
                    else{
                        alert("系统异常，请联系系统管理员");
//                        $("#" + id + " td[aria-describedby='gridTable_act']").html("");
                    }

                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        }
    },
    CheckFailed: function (id) {
        if (confirm("确定进行审核失败操作吗？")) {
            var url = $Url.BuildSalesUrl("/sales/sales/ajaxUpdateSalesStatusCancel.action");
            $.ajax({
                type: "post",
                url: url,
                data: {
                    id:id
                },
                beforeSend: function () {
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if(data.errCode == "0000"){
                        alert("操作取消成功");
//                        $("#" + id + " td[aria-describedby='gridTable_status']").text("已取消");
//                        $("#" + id + " td[aria-describedby='gridTable_act']").html("");
                    }
                    else{
                        alert("系统异常，请联系系统管理员");
//                        $("#" + id + " td[aria-describedby='gridTable_act+']").html("");
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        }
    },
    GetSaleCreditor:function(id){
        var url = $Url.BuildSalesUrl("/sales/salesCreditor/ajaxGetSalesCreditorBySaleNo.action");
        $.ajax({
            type: "post",
            url: url,
            data: {
                salesNo:id
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
                var list = data.creditorList;
                for (var a = 0;a<list.length;a++){
                    if(a!=0){
                        $(".testcreditor").append(
                            "<div class='claims mt20 creditor'><input class='id' type='text' value='' style='display: none'/><span class='ml50 pl30'>房屋</span> <select class='creditora data'></select><span class='ml50 mr5'>抵用金额</span><input type='text' class='money data'/> <span class='add'>元</span></div>"
                        );
                        EnumList.GetEnumListToSelect($(".creditora").eq(-1), "creditorList", $Url.BuildSalesUrl("/common/enumList.action"));
                    }
                    $(".creditora").eq(a).val(list[a].creditorNo);
                    $(".money").eq(a).val(list[a].money);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
$(function () {
    EnumList.GetEnumListToSelect($(".creditora"), "creditorList", $Url.BuildSalesUrl("/common/enumList.action"));
    SalesDetail.Resize();
    SalesDetail.GetSalesInfo(PageVar.ID);
    SalesDetail.GetSaleCreditor(PageVar.ID);
    FileManage.GetFileList();
    $("#back").click(function(){
        window.close();
    });
    $("#loanSituation").click(function(){
        window.open($Url.BuildSalesUrl("/sales/loanSituation/list?saleNo="+PageVar.ID));
    });
    $("#confirm").click(function(){
        window.open($Url.BuildSalesUrl("/sales/confirmationLetter/list?saleNo="+PageVar.ID));
    });
});