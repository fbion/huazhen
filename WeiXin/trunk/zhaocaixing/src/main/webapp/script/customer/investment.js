$(function() {
	var pageIndex = 1;
	var tzStatus = $("#tzStatus").val().trim();
	$("#status2").click(function(){
		window.location.href=$Url.BuildWWWUrl("customer/myReservation");
    });
	$("#status3").click(function(){
		window.location.href=$Url.BuildWWWUrl("customer/myInvestment");
    });
});
var Investment = {
		GetInvestment: function (pageIndex) {
        var url=$Url.BuildWWWUrl("customer/investment/investment");
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                	"pageIndex":pageIndex,
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $("#investment").append(data);
                    if($("input[value='0']").length>0){
                    	$("#loadMore").off().html("亲，没有更多了").attr("disabled","disabled");
                    }else{
                    	$("#loadMore").off().click(function(){
                        	pageIndex=pageIndex+1;
                        	Investment.GetInvestment(pageIndex);
                        });
                    }
                }
            })

    }
}
$(function () {
	var pageIndex = 1;
	Investment.GetInvestment(pageIndex);
 });
