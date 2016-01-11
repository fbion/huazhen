
var ManagePage = {
    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
    GetInfo: function (id) {
        var url = $Url.BuildCustomerUrl("/customer/agentBusiness/ajaxGetAgentBusiness");
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
                    $Link.MakeUrl($("#managerNo"), data.info.managerNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                    $Link.MakeUrl($("#sourceType"), data.info.sourceType, "customerPersonalSourceTypeList", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#contactImportance"), data.info.contactImportance, "dicDataforCustomerAgentBussinessImportance", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#product_no"), data.info.product_no, "productListByStatus30ForCustomerFollow", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#followType"), data.info.followType, "cusFollowType", $Url.BuildSalesUrl("/common/enumList.action"));
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
    	window.close();
    });
});