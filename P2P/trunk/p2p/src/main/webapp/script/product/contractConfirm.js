/**
 * Created by Administrator on 2015/6/10.
 */
$(function(){
    $("#next").click(function(){
        if($("input[type='checkbox']").is(':checked')==true){
            //alert("ok");
            var investmentMoney = $("#investmentMoney").val();
            var p2pProduct = $("#p2pProductNo").val();
            var contractNo = $("#contractNo").val();
            window.location.href=$Url.BuildWWWUrl
            ("product/paymentConfirm?p2pProductNo="+p2pProduct+"&investmentMoney="+investmentMoney+"&contractNo="+contractNo);
        }else{
            alert("您必须同意合同内容");
        }

    });

})