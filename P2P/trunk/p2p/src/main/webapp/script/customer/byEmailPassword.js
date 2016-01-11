/*$(function () {
	if (!($("#emailCheckMsg").attr("process") === undefined)) {
        return false;
    }
    $.ajax({
        type: "post",
        url: $Url.BuildWWWUrl("customer/forgetPassword/ajaxSendFindPwdEmail"),
        dataType: "json",
        timeout: 30000,
        async: false,
        data: {
        	ci: $QueryString.Get("ci"),
            cn: $QueryString.Get("cn"),
            t: $QueryString.Get("t")
        },
        beforeSend: function () {
            $("#emailCheckMsg").attr("process", "processing");
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            
        },
        success: function (data, textStatus) {
        	if(data.message.type == MessageType.Error){
        		$("#msg").html("");
        		$("#msg").html(data.message.description);
            }
        },
        complete: function (XMLHttpRequest, textStatus) {
            $("#emailCheckMsg").removeAttr("process");
        }
    });
});*/