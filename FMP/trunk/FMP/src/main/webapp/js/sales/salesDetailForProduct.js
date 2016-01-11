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
                SalesAdd.GetFileList();
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                else {
                    if(data.info.status==1) {
                        $("#sales_ok").removeClass("none");
                        $("#sales_failed").removeClass("none");
                    }
                    if(data.info.status==2){
                        $(".status").removeClass("none");
                    }
                    $Util.DataToA(data.info, ElementVar);
                    $Link.MakeUrl($("#protocolStatus"), data.info.protocolStatus, "protocolStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#empNo"), data.info.empNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                    $Link.MakeUrl($("#status"), data.info.status, "salesStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#peopleType"), data.info.peopleType, "agentType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#productType"), data.info.productType, "productType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#productNo"), data.info.productNo, "productList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/product/product/detail"));
                    $Link.MakeUrl($("#customerType"), data.info.customerType, "customerType", $Url.BuildSalesUrl("/common/enumList.action"));
                    if(data.info.peopleType == "1"){
                        $Link.MakeUrl($("#peopleNo"), data.info.peopleNo, "agentBusiness", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/customer/customerPersonal/detail"));
                    }
                    else if(data.info.peopleType == "2"){
                        $Link.MakeUrl($("#peopleNo"), data.info.peopleNo, "agentAdviser", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/customer/customerCompany/detail"));
                    }else{
                        $("#peopleNo").remove();
                        $("#peopleNoa").remove();
                    }
                    if(data.info.customerType == "1"){
                        $Link.MakeNewUrl($("#customerNo"),data.info,$Url.BuildSalesUrl("/customer/customerPersonal/detail"));
                    }
                    else if(data.info.customerType == "2"){
                        $Link.MakeNewUrl($("#customerNo"), data.info, $Url.BuildSalesUrl("/customer/customerCompany/detail"));
                    }
                    if(data.info.isTest==0){
                        $("#isTest").text("否");
                    }else{
                        $("#isTest").text("是");
                    }
                }
            }
        });
    },
    UpdateSalesStatus: function (nextStatus) {
        var url = $Url.BuildSalesUrl("/sales/sales/ajaxEditSalesStatus");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                id: PageVar.ID,
                status: nextStatus
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                    $("#status").val(nextStatus);
                    location.reload();
                    return;
                }
                $("#msg").text(data.errDesc);

            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    CheckOk: function (id) {
        if (confirm("确定进行审核通过吗？")) {
            var url = $Url.BuildSalesUrl("/sales/sales/ajaxUpdateSalesStatusForProduct.action");
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
                    if(data.errCode == "0000") {
                        alert("操作成功");
                    }
                    else{
                        alert("操作失败，请联系系统管理员");
                    }
                    location.reload();
                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        }
    },
    CheckFailed: function (id) {
        if (confirm("确定进行审核失败操作吗？")) {
            var url = $Url.BuildSalesUrl("/sales/sales/ajaxUpdateSalesStatusCancelForProduct.action");
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
                        alert("操作成功");
                    }
                    else{
                        alert("操作失败，请联系系统管理员");
                    }
                    location.reload();
                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
        }
    }
}
$(function () {
    SalesDetail.Resize();
    SalesDetail.GetSalesInfo(PageVar.ID);
//    FileManage.GetFileList();
    $("#back").click(function(){
        window.close();
    });
    $("#sales_ok").click(function(){
        SalesDetail.CheckOk(PageVar.ID);
        $(this).remove();
        $(this).next().remove();
    });
    $("#sales_failed").click(function(){
        SalesDetail.CheckFailed(PageVar.ID);
        $(this).prev().remove();
        $(this).remove();
    });
    if ($(".status").length > 0) {
        $(".status").click(function () {
            var nextStatus;
            if ($(this).attr("id") == "success") {
                nextStatus = PageVar.StatusSuccess;
            }
            else {
                nextStatus = PageVar.StatusRefund;
            }
            SalesDetail.UpdateSalesStatus(nextStatus);
        });
    }

});