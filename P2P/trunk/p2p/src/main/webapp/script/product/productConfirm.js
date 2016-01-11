/**
 * Created by Administrator on 2015/6/10.
 */
$(function(){
    $("#next").click(function(){
        var p2pProduct = $("#p2pProductNo").val();
        var investmentMoney = $("#investmentMoney").val();

        window.location.href=$Url.BuildWWWUrl
        ("product/contractConfirm?p2pProductNo="+p2pProduct+"&investmentMoney="+investmentMoney);
    });
})