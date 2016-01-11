$(function () {
	$("#getSmsCaptcha").click(function(){
		
		$(".VerCodeTips").hide();
		$(".VerCodeTips1").hide();
	 if (!($("#tel").attr("process") === undefined)) {
             return false;
         }
		 $.ajax({
            type: "post",
            url: $Url.BuildWWWUrl("/baseInfo/sms/ajaxAddSmsCaptcha"),
            dataType: "json",
            timeout: 30000,
            data: {
            	ci:$QueryString.Get("ci"),
                cn:$QueryString.Get("cn"),
                t:$QueryString.Get("t"),
            	verifyCode: $String.Trim($("#verifyCode").val())
            },
            beforeSend: function () {
                $("#tel").attr("process", "processing");
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            	alert(errorThrown);
            },
            success: function (data) {
            	if(data.errCode=="0000"){
            		$("#msg").html("");
            		if(data.time==0){
            			countdown=60;//60
            		}else{
            			countdown=60-data.time;
            		}
            		$(".VerCodeTips").show();
            	}else{
            		countdown=0;
            		$("#msg").text(data.errCode);
            		$(".VerCodeTips1").show();
            	}
            	SmsCaptcha.settime();
            },
            complete: function (XMLHttpRequest, textStatus) {
                $("#tel").removeAttr("process");
            }
        });
	});
	 var countdown;
	 var SmsCaptcha = {
	 	settime	: function (){
	 		if (countdown == 0) {
	 			$("#getSmsCaptcha").removeAttr("disabled");
	 			$("#getSmsCaptcha").val("获取手机验证码");
	 			return;
	 		} else {
	 			$("#getSmsCaptcha").attr("disabled", true);
	 			$("#getSmsCaptcha").val("(" + countdown + ")后重新获取验证码");
	 			countdown--;
	 		}
	 		setTimeout(function() {SmsCaptcha.settime()},1000)
	 	},
		 addSmsCaptcha : function(){
					countdown=0;
					SmsCaptcha.settime();
				 
		 }
	 }
	 SmsCaptcha.addSmsCaptcha();
	 var valTel = $("#valTel").Validform({
			tiptype:function(msg,o,cssctl){
	        	var objtip=$("#msg");
	        	cssctl(objtip,o.type);
	        	objtip.text(msg);},
	      datatype:{
				"verifySmsCaptcha": function (gets, obj, curform, datatype) {
					
					$(".VerCodeTips").hide();
					$(".VerCodeTips1").hide();
					
					var reg=/^[0-9]{6}$/;
					if (!reg.test(gets)){
						$(".VerCodeTips1").show();
						return false;
					}
					var url = $Url.BuildWWWUrl("/baseInfo/sms/ajaxCheckSmsCaptcha");
					$.ajax({
						type: "post",
						url: url,
						dataType: "json",
						data: {
							ci:$QueryString.Get("ci"),
			                cn:$QueryString.Get("cn"),
			                t:$QueryString.Get("t"),
			                smsCaptcha:$String.Trim(gets)
						},
						success: function (data, textStatus) {
							if(data.errCode!="0000"){
								$("#msg").html(data.errCode);
								$(".VerCodeTips1").show();
								return false;
							}else{
								return true;
							}
						}
					});
				}
	      },
	      callback: function (form) {
	    	  if (!($("#smsCaptcha").attr("process") === undefined)) {
	              return false;
	          }
	          var url = $Url.BuildWWWUrl("/customer/forgetPassword/AjaxGetResetPasswordUrl");
	          $(".VerCodeTips").hide();
	          $(".VerCodeTips1").hide();
	          $.ajax({
	              type: "post",
	              url: url,
	              dataType: "json",
	              timeout: 30000,
	              data: {
	            	  ci:$QueryString.Get("ci"),
	                  cn:$QueryString.Get("cn"),
	                  t:$QueryString.Get("t"),
	                  smsCaptcha:$("#smsCaptcha").val()
	              },
	              beforeSend: function () {
	                  $("#smsCaptcha").attr("process", "processing");
	              },
	              error: function (XMLHttpRequest, textStatus, errorThrown) {
	                  alert(errorThrown);
	              },
	              success: function (data, textStatus) {
	            	  if (data.message.type == MessageType.Error){
	            		  $(".VerCodeTips1").show();
	            		  $("#msg").html(data.message.description);
		                 }
	            	  if (data.message.type == MessageType.Warning){
	            		  window.location.reload();
	            	  }
	            	  if (data.message.type == MessageType.Info){
		                	 window.location.href=data.cipherTextUrl;
		                 }
	              },
	              complete: function (XMLHttpRequest, textStatus) {
	                  $("#smsCaptcha").removeAttr("process");
	              }
	          });
	          return false;
	      }
		});
		valTel.addRule([
			{				
			    ele:"#smsCaptcha",
			    datatype:"verifySmsCaptcha",//"/^[0-9]{6}$/",
			    //ignore:"ignore",
			    nullmsg:"请输入验证码",
			    errormsg:"请输入6位数字的验证码",
			    sucmsg:" "
			}
	    ]);
});