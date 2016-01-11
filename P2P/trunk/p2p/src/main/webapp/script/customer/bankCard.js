$(function(){
	$("#bind").click(function(){
    		if (!($("#pageAlias").attr("process") === undefined)) {
                return false;
            }
    		var url = $Url.BuildWWWUrl("/customer/cancel/ajaxBindBankCard");
    		$.ajax({
    			type: "post",
    			url: url,
    			dataType: "json",
    			data: {},
    			beforeSend: function () {
    				$("#pageAlias").attr("process", "processing");
    				 $("#bind").html("跳转中");
    				/*var result = true;
    				$.ajax({
    		            type: "post",
    		            url: $Url.BuildWWWUrl("/customer/cancel/ajaxCheckRealnameAuthentication"),
    		            dataType: "json",
    		            timeout: 30000,
    		            data: {},
    		            error: function (XMLHttpRequest, textStatus, errorThrown) {
    		                alert(errorThrown);
    		            },
    		            success: function (data, textStatus) {
    		            	if(data.realnameStatus==0){
    		            		alert("请先到安全设置进行实名认证！")
    		            		result =false;
    		            	}
    		                //window.location.reload();
    		            }
    		        });
    				return result;*/
    			},
    			error: function (XMLHttpRequest, textStatus, errorThrown) {
    				alert(errorThrown);
    			},
    			success: function (data, textStatus) {
    				//window.location.reload();
    				if(data.realnameStatus==0){
	            		alert("请先到安全设置进行实名认证！")
	            	}
    				if(data.realnameStatus==1){
    					var	paymentObj = "<form class=\"pay_data\" method=\"post\" action="+data.paymentData.url+ "></form>";
    					$("body").first().append(paymentObj);
    					var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
    					"<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
    					$(".pay_data").html(input);
    					$(".pay_data").submit();
    				}
    			},
    			complete: function (XMLHttpRequest, textStatus) {
    				 $("#pageAlias").removeAttr("process");
    			}
    		});
    	})
    $("#cancel_bind").click(function(){
        var url = $Url.BuildWWWUrl("/customer/cancel/ajaxUnBindBankCard");
        if (!($("#pageAlias").attr("process") === undefined)) {
            return false;
        }
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {},
            beforeSend: function () {
                $("#pageAlias").attr("process", "processing");
               
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                //window.location.reload();
                var	paymentObj = "<form class=\"pay_data\" method=\"post\" action="+data.paymentData.url+ "></form>";
                $("body").first().append(paymentObj);
                var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
                    "<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
                $(".pay_data").html(input);
                $(".pay_data").submit();
            },
            complete: function (XMLHttpRequest, textStatus) {
            	 $("#pageAlias").removeAttr("process");
            }
        });
    })
    if($("#pageAlias").val()=="bankCard"){
		$("#bankCard").addClass("active");
	}
});