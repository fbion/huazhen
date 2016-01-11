var VerificationMode = {
		EmailCheck:function(){
			$("#emailCheck").click(function(){
				$("#emailCheckMsg").html("");
				if (!($("#emailCheck").attr("process") === undefined)) {
		            return false;
		        }
		        $.ajax({
		            type: "post",
		            url: $Url.BuildWWWUrl("customer/forgetPassword/ajaxCheckEmail"),
		            dataType: "json",
		            data: {
		                ci: $QueryString.Get("ci"),//$String.Trim($("#customerInfo").val()),
		                cn: $QueryString.Get("cn"),//$String.Trim($("#customerNo").val()),
		                t: $QueryString.Get("t")//$String.Trim($("#t").val())
		            },
		            beforeSend: function () {
		                $("#emailCheck").attr("process", "processing");
		            },
		            error: function (XMLHttpRequest, textStatus, errorThrown) {
		                //Base.Common.PromptText.systemError();
		            },
		            success: function (data, textStatus) {
		            	 if (data.message.type == MessageType.Error){
		                 	$("#emailCheckMsg").html(data.message.description);
		                 }
		            	 if(data.message.type == MessageType.Warning){
		            		 window.location.reload();
		                 }
		            	 if(data.message.type == MessageType.Info){
		                 
		                	 /*var customerInfo = $String.Trim($("#customerInfo").val());
		                	 var customerNo = $String.Trim($("#customerNo").val());
		                	 var t = $String.Trim($("#t").val());*/
		                	// VerificationMode.SendEmail(customerInfo,customerNo,t);
		                	// var url = $Url.BuildWWWUrl("/customer/byEmailPassword?ci="+customerInfo+"&cn="+customerNo+"&t="+t);
		                	 window.location.href=data.cipherTextUrl;
		                	 VerificationMode.SendEmail(data.ci,data.cn,data.t)
		                	 //window.navigate(url);
		                	 //window.location.replace(url);
		                 }
		            },
		            complete: function (XMLHttpRequest, textStatus) {
		                $("#emailCheck").removeAttr("process");
		            }
		        });
			});
		},
		CellphoneCheck:function(){
			$("#cellphoneCheck").click(function(){
				var ci=$QueryString.Get("ci");
                var cn=$QueryString.Get("cn");
                var t=$QueryString.Get("t");
				var url = $Url.BuildWWWUrl("/customer/byCellphonePassword?ci="+ci+"&cn="+cn+"&t="+t);
				window.location.replace(url);
			});
		},
		SendEmail:function(customerInfo,customerNo,t){
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
                	ci:customerInfo,
                	t:t,
                    cn:customerNo
                },
                beforeSend: function () {
                    $("#emailCheckMsg").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                },
                success: function (data, textStatus) {
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#emailCheckMsg").removeAttr("process");
                }
            });
		}
}
$(function () {
	
	VerificationMode.EmailCheck();
	VerificationMode.CellphoneCheck();
});