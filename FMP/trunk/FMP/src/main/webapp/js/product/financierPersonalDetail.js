
var ManagePage = {
    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
    GetInfo: function (id) {
        var url = $Url.BuildProductUrl("/product/financierPersonal/ajaxGetFinancierPersonal");
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
                    $Link.MakeUrl($("#sex"), data.info.sex, "dicDicDataForEmployeeSex", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#marry"), data.info.marry, "dicDicDataForEmployeeMarry", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#managerNo"), data.info.managerNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
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