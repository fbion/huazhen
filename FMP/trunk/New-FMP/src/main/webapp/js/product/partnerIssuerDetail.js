
var ManagePage = {
    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
    GetInfo: function (id) {
        var url = $Url.BuildProductUrl("/product/partnerIssuer/ajaxGetPartnerIssuer");
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
                    $Link.MakeUrl($("#relationLevel"), data.info.relationLevel, "dicDataforCustomerCompanyRelationLevel", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#type"), data.info.type, "dicDataforProductpartnerIssuertype", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#importanceLevel"), data.info.importanceLevel, "dicDataforCustomerAgentBussinessImportance", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#isIssuer"), data.info.isIssuer, "isYes", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#isAgent"), data.info.isAgent, "isYes", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#empNo"), data.info.empNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                    if($("#isTest").text()=="0"){
        				$("#isTest").text("否");
        			}else{
        				$("#isTest").text("是");
        			}
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