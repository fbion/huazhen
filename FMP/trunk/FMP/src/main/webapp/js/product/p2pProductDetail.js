var ManagePage = {
    Resize: function () {
        var height = $(".detail").height()+200;
        $("#content_center").css("min-height", height);
    },
    UpdateStatus: function (status) {
        var url = $Url.BuildProductUrl("/product/p2pProduct/ajaxUpdateP2pProductStatus");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: PageVar.id,
                byStatus: status},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if(data.errCode == "0000"){
                    $("#updateToDuration").hide();
                    $("#status").html(status);
                    $Link.MakeUrl($("#status"), status, "p2pProductPartStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                }
                else{
                    alert(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    GetInfo: function (id) {
        var url = $Url.BuildProductUrl("/product/p2pProduct/ajaxGetP2pProduct");
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
                    $Util.DataToA(data.info, ElementVar);
                    $Link.MakeUrl($("#productNo"), data.info.productNo, "productList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildSalesUrl("/product/product/detail"));
                    $Link.MakeUrl($("#status"), data.info.status, "p2pProductPartStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#repaymentIssue"), data.info.repaymentIssue, "p2pProductRepayIssue", $Url.BuildSalesUrl("/common/enumList.action"));
                    if(data.info.isTest==0){
                        $("#isTest").text("否");
                    }else{
                        $("#isTest").text("是");
                    }
                    Audit.GetWindow(data.info.activitiNo);
                    Audit.InitGrid(data.info.activitiNo);
                }
            }
        });
    }
}
$(function () {
    ManagePage.Resize();
    ManagePage.GetInfo(PageVar.id);
    $("#back").click(function(){
        window.close();
    });
    $('.trackBtn').on('click',function(){
        var url = $Url.BuildWorkFlowUrl("/workFlow/processing/ajaxAuditProcess");
        var activitiNo = Audit.GetUrlActivitNo();
        initAll.GetAuditProcess(url,activitiNo);
    });
    if($("#updateToDuration").length > 0){
        $("#updateToDuration").click(function(){
            ManagePage.UpdateStatus(PageVar.StatusDuration);
        });
    }
});