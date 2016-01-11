
var ManagePage = {
    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
    GetInfo: function (id) {
        var url = $Url.BuildCustomerUrl("/customer/agentAdviser/ajaxGetAgentAdviser");
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
                    $Link.MakeUrl($("#product_no"), data.info.product_no, "productListByStatus30ForCustomerFollow", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#followType"), data.info.followType, "cusFollowType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#managerNo"), data.info.managerNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                    $Link.MakeUrl($("#relationLevel"), data.info.relationLevel, "dicDataforCustomerCompanyRelationLevel", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#sourceType"), data.info.sourceType, "customerPersonalSourceTypeList", $Url.BuildSalesUrl("/common/enumList.action"));
//                    EnumList.GetEnumListToSelect($("#managerNo"),"empManager",$Url.BuildCustomerUrl("/common/enumList.action"));
//                	EnumList.GetEnumListToSelect($("#relationLevel"),"dicDataforCustomerCompanyRelationLevel",$Url.BuildCustomerUrl("/common/enumList.action"));
//                	EnumList.GetEnumListToSelect($("#sourceType"), "customerPersonalSourceTypeList", $Url.BuildCustomerUrl("/common/enumList.action"));
//        			EnumList.GetEnumListToSelect($("#product_no"), "productListByStatus30ForCustomerFollow", $Url.BuildCustomerUrl("/common/enumList.action"));
//        			EnumList.GetEnumListToSelect($("#followType"), "cusFollowType", $Url.BuildCustomerUrl("/common/enumList.action"));
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