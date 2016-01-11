var Reservation = {
    GetReservation: function (pageIndex) {
        var url=$Url.BuildWWWUrl("customer/getInviteInfo");
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                	"pageIndex":pageIndex+1
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $("#reservation").append(data);
                    if($("input[value='0']").length>0){
                    	$("#loadMore").off().html("亲，没有更多了").attr("disabled","disabled");
                    }else{
                    	$("#loadMore").off().click(function(){
                        	pageIndex=pageIndex+1;
                        	Reservation.GetReservation(pageIndex);
                        });
                    }                    
                    

                }
            }
        )

    }
}
$(function(){
	
	 Reservation.GetReservation(0);
	$("#xinlangUrl").click(function(){
		$.ajax({
			type: "post",
	       url: $Url.BuildWWWUrl("/customer/addSahreActivity"),
	       dataType: "json",
	       timeout: 30000,
	       data: {
	       },
	       success: function (data, textStatus) {
	       }
		});
	});
	var regurl = "customer/register?inviterNo="+$("#inviterNo").val()+","+$("#activityId").val();
	$('#weixinUrl').attr("src","http://qr.liantu.com/api.php?&bg=ffffff&fg=000000&&w=220&m=10&text="+$Url.BuildWWWUrl(regurl));
    $("#weixin").click(function(){
    	$("#weixinlayer").attr("style","display:block");
    });
    $("#winxinClose").click(function(){
		$("#weixinlayer").attr("style","display:none");
	});

});



