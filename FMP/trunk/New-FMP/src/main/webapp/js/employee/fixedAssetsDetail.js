
var ManagePage = {
    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
    GetInfo: function (id) {
        var url = $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxGetFixedAssets");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async:false,
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
                	$Util.DataToA(data.rigInfo, ElementVar);
                	
                    $Link.MakeUrl($("#department"), data.info.department, "deptAll", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#userNo"), data.info.userNo, "empListByIdAll", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#type"), data.rigInfo.type, "assetsTypeGlobal", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#assetType"), data.info.assetType, "assetsType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#status"), data.info.status, "assetsStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#location"), data.info.location, "assetsLocation", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#suppliersId"), data.rigInfo.suppliersId, "suppliersList", $Url.BuildSalesUrl("/common/enumList.action"));
                }
            }

        });
    }
}
$(function () {
    ManagePage.Resize();
    ManagePage.GetInfo(PageVar.ID);
    $("#back").click(function () {
    	$EasyUI.Close();
    });
});