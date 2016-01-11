/**
 * Created by paul on 15-3-13.
 */
usingNamespace("UI.LogReg")["Login"] = {
    buildWarningMessage: function (jqueryObj, msg) {
    	jqueryObj.parent().parent().siblings().removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show();
    },
    clearWarningMessage: function (jqueryObj) {
        jqueryObj.parent().parent().siblings().removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};

usingNamespace("UI.LogReg")["LoginWithCellphone"] = {
    buildWarningMessage: function (jqueryObj, msg) {
    	jqueryObj.parent().parent().next().removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show();
    },
    clearWarningMessage: function (jqueryObj) {
        jqueryObj.parent().parent().next().removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};

var ManagePage = {
		OnClickElem : function(elem){
			elem.click(function(){
			 $("#verifyCode").val("");
		});
	 }
};

$(document).ready(function () {
	
	if($("#landedStatus").val()=="true"){
		//if loanded true login.jsp redirect index.jsp
		window.location.href=$("#landedUrl").val();
	}
	ManagePage.OnClickElem($(".validator_tips"));
	ManagePage.OnClickElem($("#imgVerifyCode"));
	
    if ($("#needVerifyCode").val() == 0) {
        $("#login_captcha").hide();
    }

    
    
    var login = $("#loginForm").Validform({
        tiptype:function (msg, o, cssctl) {
		   var objtip = o.obj.parent().parent().next(".Validform_checktip");
			 cssctl(objtip, o.type);
			 objtip.text(msg);

		},
        ignoreHidden: true,
        datatype:{
        	"verifyLoginName": function (gets, obj, curform, datatype) {
        		var regUsername = /^(?!^\d+$)(?!^_+$)[0-9a-zA-Z_]{4,20}$/;
        		var regEmail=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        		var regTelephone=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
        		var flag = false;
        		if (regUsername.test(gets)){
        			flag = true;
        		}
        		if (regEmail.test(gets)){
        			flag = true;
        		}
        		if (regTelephone.test(gets)){
        			flag = true;
        		}
        		return flag;  
        	}
        },
        callback: function (form) {
            if (!($("#username").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildWWWUrl("/customer/login/ajaxLogin");

            var customerInfo = {
                verifyCode:$String.Trim($("#verifyCode").val()), // Security Code
                username: $String.Trim($("#username").val()),
                pwd: Base64.encode($String.Trim($("#pwd").val()))
                //code:$String.Trim($("#code").val())
            };
            var auto = 1;

            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    userName: customerInfo.username,
                    password: customerInfo.pwd,
                    verifyCode: customerInfo.verifyCode,
                    isAutoLogin: auto
                    //code:customerInfo.code
                },
                beforeSend: function () {
                    $("#username").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    Base.Common.PromptText.systemError();
                },
                success: function (data, textStatus) {
                    if (data.message.type == MessageType.Error) {
                        var returnInfo = data.message.description.split(':');
                        if (returnInfo.length > 0) {
                            if (Number(returnInfo[2]) > 0) {
                                $("#login_captcha").show();
                            }
                            if (returnInfo[0] == 'userError') {
                               UI.LogReg.Login.buildWarningMessage($("#username"), returnInfo[1]);

                            }
                            else if (returnInfo[0] == 'pwdError') {
                                UI.LogReg.Login.buildWarningMessage($("#pwd"), returnInfo[1]);
                                UI.LogReg.Login.clearWarningMessage($("#verifyCode"));
                            }
                            else if (returnInfo[0] == 'validateError') {
                                UI.LogReg.Login.buildWarningMessage($("#verifyCode"), returnInfo[1]); //验证码
                            }
                        }
                        $("#verifyCode").val("");
                        $VerifyCode.refreshValidator('#imgVerifyCode', '#verifyCode'); //验证码
                    }
                    else {
                        var redirectUrl = $("#redirectUrl").val();
                        if (redirectUrl != undefined && redirectUrl.length > 0) {
                            window.location = redirectUrl;
                        }
                        else
                            window.location.replace(window.location.href);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#username").removeAttr("process");
                }
            });

            return false;
        }
    });

    login.addRule([//给上面的验证的validform对象添加规则
        {
            ele: "#username",//用户名
            datatype: "verifyLoginName",//"/^(?!^\d+$)(?!^_+$)[0-9a-zA-Z_]{4,20}$/",//"c4-20",//自定义的verifyUsername验证方式
            //ignore: "ignore",
            nullmsg: "请填写登录账号",
            errormsg: "请填写正确的登录账号",
            sucmsg: " "
        },
        {
            ele: "#pwd",
            datatype: "pwd",//密码的干活
            //ignore: "ignore",
            nullmsg: "请填写密码",
            errormsg: "请填写正确的密码",
            sucmsg: " "
        },
        {
            ele: "#verifyCode",//验证码的干活
            datatype: "captcha",
            //ignore: "ignore",
            nullmsg: "请输入验证码",
            errormsg: "请输入正确的验证码",
            sucmsg: " "
        }
    ]);
    
    
    var loginWithCellphone = $("#loginWithCellphoneForm").Validform({
        tiptype: function(msg,o,cssctl){
        	var objtip=o.obj.parent().parent().next(".Validform_checktip");
        	cssctl(objtip,o.type);
//        	if(""==msg.trim()){
//        		objtip.hide();
//    		}else{
//    			objtip.show();
//    		}
        	objtip.text(msg);
        	},
        ignoreHidden: true,
        datatype:{
        	"verifyCellphone": function (gets, obj, curform, datatype) {
        		var regTelephone=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
        		var result;
        		if (!regTelephone.test(gets)){
//        			$("msgdemo").html("请输入正确的手机号码").show();
        			return false;
        		}
        		var url = $Url.BuildWWWUrl("/customer/register/ajaxCheckTelephoneExist");
                $.ajax({
                    type: "post",
                    url: url,
                    dataType: "json",
                    async: false,
                    data: {
                        telephone :$String.Trim(gets),
                        isCellphoneLogin:1
                    },
                    success: function (data, textStatus) {
                    	if(data.message.type == MessageType.Warning){
                    		result = data.message.description;
                    		return false;
                    	}
//                    	if (data.message.description == "请输入手机号码") {
//                    		$("#msgdemo").html(data.message.description).show();
//                    		return false;
//                    	}
//                        if (data.message.description == null) {
//                        	$("#msgdemo").html("您还没有注册").show();
//                        	return false;
//                        }
                    }
                });
        		return result;  
        },
        "verifyCaptcha": function (gets, obj, curform, datatype) {
        	var reg=/^[a-zA-Z0-9]{4}$/;
        	if(!reg.test(gets)){
//        		$("#msgdemo").html("请输入正确的验证码").show();
        		return false;
        	}
        	return true;  
        },
        "verifySmsCaptcha": function (gets, obj, curform, datatype) {
        	var reg=/^[0-9]{6}$/;
        	if(!reg.test(gets)){
//        		$("#msgdemo").html("请输入6位数字的短信验证码").show();
        		return false;
        	}
        	return true;  
        }
       },
        callback: function (form) {
            if (!($("#telephone").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildWWWUrl("/customer/login/loginWithCellphone");

            var auto = 1;

            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                	telephone: $String.Trim($("#telephone").val()),
                	verifyCode2: $String.Trim($("#verifyCode2").val()),
                	smsCaptcha: $String.Trim($("#smsCaptcha").val()),
                	isAutoLogin: auto
                },
                beforeSend: function () {
                    $("#telephone").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    Base.Common.PromptText.systemError();
                },
                success: function (data, textStatus) {
                    if (data.message.type == MessageType.Error) {
                        var returnInfo = data.message.description.split(':');
                        if (returnInfo.length > 0) {
                        	if (returnInfo[0] == 'cellphoneError') {
                        		UI.LogReg.LoginWithCellphone.buildWarningMessage($("#telephone"), returnInfo[1]);
                        		$("#telephone").focus();
                        	}
                        	else if (returnInfo[0] == 'validateError') {
                                UI.LogReg.LoginWithCellphone.buildWarningMessage($("#verifyCode2"), returnInfo[1]);
                                $("#verifyCode2").val("").focus();
                            }
                            else if (returnInfo[0] == "smsCaptchaError") {
                            	UI.LogReg.LoginWithCellphone.buildWarningMessage($("#smsCaptcha"), returnInfo[1]);
                            	$("#smsCaptcha").val("").focus();
                            }
                        }
                        $("#verifyCode2").val("");
                        $VerifyCode.refreshValidator('#imgVerifyCode2', '#verifyCode2'); //验证码
                    }
                    else {
                        var redirectUrl = $("#redirectUrl").val();
                        if (redirectUrl != undefined && redirectUrl.length > 0) {
                            window.location = redirectUrl;
                        }
                        else
                        	window.location.reload() ;
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#telephone").removeAttr("process");
                }
            });
            return false;
        }
});
    loginWithCellphone.addRule([//给上面的验证的validform对象添加规则
        {
            ele: "#telephone",
            datatype: "verifyCellphone",
            //ignore: "ignore",
            nullmsg: "请填写手机号码",
            errormsg: "请填写正确的手机号码",
            sucmsg: " "
        },
        {
            ele: "#verifyCode2",
            datatype: "verifyCaptcha",
            //ignore: "ignore",
            nullmsg: "请输入验证码",
            errormsg: "请输入正确的验证码",
            sucmsg: " "
        }, 
        {				
     	    ele:"#smsCaptcha",
     	    datatype:"verifySmsCaptcha",//"/^[0-9]{6}$/",
     	    //ignore:"ignore",
     	    nullmsg:"请输入手机验证码",
     	    errormsg:"请输入6位数字的手机验证码",
     	    sucmsg:" "
        }
    ]);
    
    smsCaptcha.refreshSmsJsp();
    $("#getSmsCaptcha").removeAttr("disabled").bind("click",function(){smsCaptcha.getSmsCaptcha()});  
});


var countdown =0;
var smsCaptcha = {
		refreshSmsJsp : function(){
			$.ajax({
				type: "post",
				url: $Url.BuildWWWUrl("/baseInfo/sms/refreshJsp"),
				dataType: "json",
				timeout: 30000,
				data: {
					telephone : $("#telephone").val()
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
					smsCaptcha.settime();
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
				UI.LogReg.LoginWithCellphone.buildWarningMessage($("#telephone"), "手机号码必须填写");
				$("#telephone").focus();
				flag = false;
				return false;
			}
			var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
			if (!reg.test(tel)){
				UI.LogReg.LoginWithCellphone.buildWarningMessage($("#telephone"), "请输入正确的手机号码");
				flag = false;
				return false;
			}
			var verifyCode2 = $("#verifyCode2").val().trim();
			if(verifyCode2==""){
				UI.LogReg.LoginWithCellphone.buildWarningMessage($("#verifyCode2"), "请输入验证码");
				flag = false;
				return false;
			}
			var reg=/^[a-zA-Z0-9]{4}$/;
			if (!reg.test(verifyCode2)){
				UI.LogReg.LoginWithCellphone.buildWarningMessage($("#verifyCode2"), "请输入正确的验证码");
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
						verifyCode: $String.Trim($("#verifyCode2").val()),
						isCellphoneLogin:1
					},
					beforeSend: function () {
						$("#telephone").attr("process", "processing");
					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						alert(errorThrown);
					},
					success: function (data) {
						if(data.errCode=="0000"){
//							UI.LogReg.LoginWithCellphone.clearWarningMessage($("#verifyCode"));
							if(data.time==0){
								countdown=60;//60
							}else{
								countdown=60-data.time;
							}
						}else{
							countdown=0;
							UI.LogReg.LoginWithCellphone.buildWarningMessage($("#verifyCode2"),data.errCode);
						}
						smsCaptcha.settime();
					},
					complete: function (XMLHttpRequest, textStatus) {
						$("#telephone").removeAttr("process");
					}
				});
		},
		settime	: function (){
			if (countdown == 0) {
				$("#getSmsCaptcha").removeAttr("disabled").val("获取手机验证码");
				return;
			} else {
				$("#getSmsCaptcha").attr("disabled",true).val("(" + countdown + ")后重新获取");
				countdown--;
			}
			setTimeout(function() {smsCaptcha.settime()},1000)
		}
}