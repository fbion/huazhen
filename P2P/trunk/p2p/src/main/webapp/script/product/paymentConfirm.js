/**
 * Created by Administrator on 2015/6/10.
 */
$(function(){

    $("#next").click(function(){
        var investmentMoney = $("#investmentMoney").val();
        var verifyCode = $("#verifyCode").val();
        var p2pProductNo = $("#p2pProductNo").val();
        var contractNo = $("#contractNo").val();
        var url = $Url.BuildWWWUrl("product/ajaxPaymentConfirm");
        if (!($("#next").attr("process") === undefined)) {
            return false;
        }
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                investmentMoney:investmentMoney,
                verifyCode:verifyCode,
                p2pProductNo:p2pProductNo,
                contractNo:contractNo
            },
            beforeSend: function () {
                $("#next").attr("process", "processing");
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("error");
            },
            success: function (data, textStatus) {
                if(data.message=="error"){
                    $("#message").css("display","block");
                }else{
                    //window.location.reload();
                    var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+" method=\"post\"></form>";
                    $("body").first().append(paymentObj);
                    var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
                        "<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
                    $(".pay_data").html(input);
                    $(".pay_data").submit();
                }
            },

            complete: function (XMLHttpRequest, textStatus) {
                $("#next").removeAttr("process");
            }
        });
//            var investmentMoney = $("#investmentMoney").val();
//            var verifyCode = $("#verifyCode").val();
//            window.location.href=$Url.BuildWWWUrl
//            ("product/paymentComplete?investmentMoney="+investmentMoney+"&verifyCode="+verifyCode);
    });

    $VerifyCode.refreshValidator('#imgVerifyCode', '#verifyCode');

})