var ManagePage = {
    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
    GetInfo: function (id) {
        var url = $Url.BuildCustomerUrl("/customer/customerCompany/ajaxGetCustomerCompany");
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
                    $Link.MakeUrl($("#riskHobby"), data.info.riskHobby, "dicDataforCustomerCompanyRiskHobby", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#agentNo"), data.info.agentNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                    $Link.MakeUrl($("#product_no"), data.info.product_no, "productListByStatus30ForCustomerFollow", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#followType"), data.info.followType, "cusFollowType", $Url.BuildSalesUrl("/common/enumList.action"));
        			if($("#memberClassType").text()=="1"){
        				$("#memberClassType").text("企业借款人");
        			}else if($("#memberClassType").text()=="2"){
        				$("#memberClassType").text("担保公司");
        			}else{
        				$("#memberClassType").text("请选择");
        			}
        			if($("#isTest").text()=="0"){
        				$("#isTest").text("否");
        			}else{
        				$("#isTest").text("是");
        			}
        			$("#p2pCustomerNo").text("绑定p2p客户");
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