var ProductDetails = {
	Paging:function (pageIndex){
		if($("#pageIndex")==undefined) pageIndex=0;
        var url=$Url.BuildWWWUrl("product/ajaxListProductRecord");
        $.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            data: {
            	"pageIndex":pageIndex+1,
            	p2pProductNo:parseInt($("#p2pProductNo").val().trim())
            },
            error: function (request) {
               // alert(request);
            },
            success: function (data) {
                $("#investRecordList").append(data);
                if($("input[value='0']").length>0){
                	$("#loadMore").off().html("亲，没有更多了").attr("disabled","disabled");
                }else{
                	$("#loadMore").off().click(function(){
                    	pageIndex=pageIndex+1;
                    	ProductDetails.Paging(pageIndex);
                    });
                }                    
            }
         }
        )
    }
}

   function loginInvest(){
	   if($("#invest").css("display")=="none"){
   $("#invest").show();
   }else{
	   $("#invest").hide();
	   }
		 
   } 


var ManagePage = {
		OnClickElem : function(){
			
		}
	};

$(function(){	

	
	if($("#productRecordFlag").length<=0){
			ProductDetails.Paging(0);
	}
   

	$(".my_appointment").click(function(){
		$.ajax({
            type: "post",	
            async: false,
            url: $Url.BuildWWWUrl("customer/p2pSubscribe/ajaxp2pSubscribe"),
            dataType: "json",
            timeout: 30000,
            data: {
            	p2pProductNo: $("#p2pProductNo").val(),
            	amount: $("#amount").val()
            	
            },
            beforeSend: function () {
            	//alert(${personalInfoUrl});
            	var amount = $("#amount").val();
            	//var re = /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/;
            	var re1 =/^[1-9]\d*$/; //匹配正整数
            	var re2 =/^\d{0,9}$/;
            	if(!re1.test(amount)){
            		$("#msg").html("请填写正确的预约金额!(不为0的正整数)");
            		return false;
            	}
            	if(!re2.test(amount)){
            		$("#msg").html("预约金额需小于产品剩余金额！");
            		return false;
            	}
            	return true;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                Base.Common.PromptText.systemError();
                alert(errorThrown);
            },
            success: function (data) {
            	//alert(data);
            	if(data.message.type==MessageType.Info){
            		if(data.message.description=="预约成功！"){
            			$(".reservation_success").css("display","block");
            			$(".appointment").css("display","none");
            			$("#amountMoney").html($("#amount").val());
            			$("#reservation_form").hide();
            		}else{
            		$("#msg").html(data.message.description);
            		}
            	}else if(data.message.type==MessageType.Error){
            		var returnUrl = window.location.href;
            		window.location.href=$Url.BuildWWWUrl("customer/personalInfo?returnUrl="+returnUrl +"");
            	}
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
	});
	

});