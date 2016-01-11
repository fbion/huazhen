var countdown = 0;
var regist = {
	refreshSmsJsp : function(){
		$.ajax({
            type: "post",
            url: $Url.BuildWWWUrl("/baseInfo/sms/refreshJsp"),
            dataType: "json",
            timeout: 30000,
            data: {
            	"telephone" : $("#telephone").val()
            },
            beforeSend: function () {
                //$("#realName").attr("process", "processing");
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            	//alert(errorThrown);
            },
            success: function (data) {
            	if(data.errCode=="0000"){
            		if(data.time==0){
            			countdown=60;//60
            		}else{
            			countdown=60-data.time;
            		}
            	}else{
            		countdown=0;
            	}
            	regist.settime();
            },
            complete: function (XMLHttpRequest, textStatus) {
               // $("#realName").removeAttr("process");
            }
        });
	},
	getSmsCaptcha: function(){
		var flag = true;
		var tel = $("#telephone").val().trim();
		if(tel==null||tel==undefined||tel==""){
			UI.LogReg.Register.buildWarningMessage($("#telephone"), "手机号码必须填写");
			$("#telephone").focus();
			flag = false;
			return false;
		}
		var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
        if (!reg.test(tel)){
        	UI.LogReg.Register.buildWarningMessage($("#telephone"), "请输入正确的手机号码");
        	flag = false;
        	return false;
        }
        $.ajax({
            type: "post",
            url: $Url.BuildWWWUrl("/customer/register/ajaxCheckTelephoneExist"),
            dataType: "json",
            async: false,
            data: {
                telephone :$String.Trim(tel),
            },
            success: function (data, textStatus) {
//            	if (data.message.type == MessageType.Warning) {
    				result = data.message.description;
//    			}
                
            }
        });
        var verifyCode = $("#verifyCode").val().trim();
        if(verifyCode==""){
        	UI.LogReg.Register.buildWarningMessage($("#verifyCode"), "请输入验证码");
   			flag = false;
   			return false;
   		}
		var reg=/^[a-zA-Z0-9]{4}$/;
		if (!reg.test(verifyCode)){
			UI.LogReg.Register.buildWarningMessage($("#verifyCode"), "请输入正确的验证码");
			flag = false;
			return false;
		}
		 if (!($("#telephone").attr("process") === undefined)) {
             return false;
         }
		 if(flag)
		 $.ajax({
            type: "post",
            url: $Url.BuildWWWUrl("/baseInfo/sms/ajaxAddSmsCaptcha"),
            dataType: "json",
            timeout: 30000,
            data: {
            	telephone: $String.Trim($("#telephone").val()),
            	verifyCode: $String.Trim($("#verifyCode").val()),
            	isCellphoneLogin:0
            },
            beforeSend: function () {
                $("#telephone").attr("process", "processing");
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            	alert(errorThrown);
            },
            success: function (data) {
            	if(data.errCode=="0000"){
            		UI.LogReg.Register.clearWarningMessage($("#verifyCode"));
            		if(data.time==0){
            			countdown=60;//60
            		}else{
            			countdown=60-data.time;
            		}
            	}else{
            		countdown=0;
            		UI.LogReg.Register.buildWarningMessage($("#verifyCode"), data.errCode);
            	}
            	regist.settime();
            },
            complete: function (XMLHttpRequest, textStatus) {
                $("#telephone").removeAttr("process");
            }
        });
	},
	settime	: function (){
		if (countdown == 0) {
			$("#getSmsCaptcha").removeAttr("disabled");
			$("#getSmsCaptcha").val("获取手机验证码");
			return;
		} else {
			$("#getSmsCaptcha").attr("disabled",true);
			$("#getSmsCaptcha").val("(" + countdown + ")后重新获取");
			countdown--;
		}
		setTimeout(function() {regist.settime()},1000)
	}
}