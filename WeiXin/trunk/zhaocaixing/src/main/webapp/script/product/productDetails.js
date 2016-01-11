usingNamespace("UI.LogReg")["Subscribe"] = {
    buildWarningMessage: function (jqueryObj, msg) {
    	jqueryObj.parent().parent().next().removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show();
    },
    clearWarningMessage: function (jqueryObj) {
        jqueryObj.parent().parent().next().removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};

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
/*		if($("#productRecordFlag").length<=0){
			ProductDetails.Paging(0);
		}
   */
	$("#invest").hide();

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
	
	var subscribe = $("#callSubscribeForm").Validform({
		tiptype: function(msg,o,cssctl){
			var objtip=o.obj.parent().parent().next(".Validform_checktip");
			cssctl(objtip,o.type);
            if(""==msg.trim()){
                objtip.hide();
            }else{
                objtip.show();
            }
			objtip.text(msg);},
			ignoreHidden: true,
			callback: function (form) {
				if (!($("#callName").attr("process") === undefined)) {
					return false;
				}
				var url = $Url.BuildWWWUrl("/customer/p2pSubscribe/ajaxp2pSubscribeWithoutLogin");
				$.ajax({
					type: "post",
					url: url,
					dataType: "json",
					timeout: 30000,
					data: {
						callName:$String.Trim($("#callName").val()),
						callPhone: $String.Trim($("#callPhone").val()),
						p2pProductNo: $String.Trim($("#p2pProductNo").val()),
//						amount: $String.Trim($("#amount").val()),
					},
					beforeSend: function () {
						$("#callName").attr("process", "processing");
					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						Base.Common.PromptText.systemError();
					},
					success: function (data, textStatus) {
						if (data.message.type == MessageType.Error) {
							var returnInfo = data.message.description.split(':');
							if (returnInfo.length > 0) {
								if (returnInfo[0] == 'nameError') {
									UI.LogReg.Subscribe.buildWarningMessage($("#callName"), returnInfo[1]);
								}
								else if (returnInfo[0] == 'phoneError') {
									UI.LogReg.Subscribe.buildWarningMessage($("#callPhone"), returnInfo[1]);
								}
							}
						}
						if (data.message.type == MessageType.Info) {
							$("#invest").hide();
							alert(data.message.description);
						}
					},
					complete: function (XMLHttpRequest, textStatus) {
						$("#callName").removeAttr("process");
					}
				});
				
				return false;
			}
	});
	subscribe.addRule([//给上面的验证的validform对象添加规则
       {
           ele: "#callName",
           datatype: "/^[\u4e00-\u9fa5]{2,4}$/",
           //ignore: "ignore",
           nullmsg: "请填写姓名",
           errormsg: "请填写正确的姓名",
           sucmsg: " "
       },
       {
           ele: "#callPhone",
           datatype: "/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/",
           //ignore: "ignore",
           nullmsg: "请填写手机号码",
           errormsg: "请填写正确格式的手机号码",
           sucmsg: " "
       }
   ]);
});