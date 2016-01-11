
/**
 * Created by paul on 15-3-13.
 */
$(document).ready(function () {
	if($("#pageAlias").val()=="login"||$("#pageAlias").val()=="productDetails")
		Banner.GetBanner($(".p2pBanner1"),2);
    if ($("#needVerifyCode").val() == 0) {
        $("#login_captcha").hide();
    }

    
    
    var login = $(".loginValidform").Validform({
        tiptype: function(msg,o,cssctl){
        	var objtip=$("#msgdemo2");
        	cssctl(objtip,o.type);
        	if(""==Base.Utils.String.Trim(msg)){
        		objtip.hide();
    		}else{
    			objtip.show();
    		}
        	objtip.text(msg);},
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
            };
            var auto = 0;

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
                            	$("#msgdemo2").text(returnInfo[1]).removeClass("Validform_right").addClass("Validform_wrong").show();
                            }
                            else if (returnInfo[0] == 'pwdError') {
                            	$("#msgdemo2").text(returnInfo[1]).removeClass("Validform_right").addClass("Validform_wrong").show();
                            }
                            else if (returnInfo[0] == 'validateError') {
                            	$("#msgdemo2").text(returnInfo[1]).removeClass("Validform_right").addClass("Validform_wrong").show();
                            }
                        }
                        $("#verifyCode").val("");
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
                    $("#username").removeAttr("process");
                }
            });

            return false;
        }
    });

    login.addRule([//给上面的验证的validform对象添加规则
        {
            ele: "#username",//用户名
            datatype: "verifyLoginName",//"c4-20",//自定义的verifyUsername验证方式
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
        	var objtip=$("#msgdemo");
        	cssctl(objtip,o.type);
        	if(""==Base.Utils.String.Trim(msg)){
        		objtip.hide();
    		}else{
    			objtip.show();
    		}
        	objtip.text(msg);},
        ignoreHidden: true,
        datatype:{
        	"verifyCellphone": function (gets, obj, curform, datatype) {
        		var regTelephone=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
        		if (!regTelephone.test(gets)){
        			$("#msgdemo").html("请输入正确的手机号码").show();
        			return false;
        		}
        		var url = $Url.BuildWWWUrl("/customer/register/ajaxChecktelephoneExist");
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
                    	if(data.message.type == "Error"){
                    		$("#msgdemo").html(data.message.description).show();
                    		return false;
                    	}
                    	if (data.message.description == "请输入手机号码") {
                    		$("#msgdemo").html(data.message.description).show();
                    		return false;
                    	}
                        if (data.message.description == null) {
                        	$("#msgdemo").html("您还没有注册").show();
                        	return false;
                        }
                    }
                });
        		return true;  
        },
        "verifyCaptcha": function (gets, obj, curform, datatype) {
        	var reg=/^[a-zA-Z0-9]{4}$/;
        	if(!reg.test(gets)){
        		$("#msgdemo").html("请输入正确的验证码").show();
        		return false;
        	}
        	return true;  
        },
        "verifySmsCaptcha": function (gets, obj, curform, datatype) {
        	var reg=/^[0-9]{6}$/;
        	if(!reg.test(gets)){
        		$("#msgdemo").html("请输入6位数字的短信验证码").show();
        		return false;
        	}
        	return true;  
        }
       },
        callback: function (form) {
            if (!($("#cellphone").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildWWWUrl("/customer/login/loginWithCellphone");

            var customerInfo = {
                verifyCode2:$String.Trim($("#verifyCode2").val()), // Security Code
                cellphone: $String.Trim($("#cellphone").val()),
                smsCaptcha: $String.Trim($("#smsCaptcha").val())
            };
            var auto = 0;

            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                	cellphone: customerInfo.cellphone,
                	verifyCode2: customerInfo.verifyCode2,
                	smsCaptcha: customerInfo.smsCaptcha,
                	isAutoLogin: auto
                },
                beforeSend: function () {
                    $("#cellphone").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    Base.Common.PromptText.systemError();
                },
                success: function (data, textStatus) {
                    if (data.message.type == MessageType.Error) {
                        var returnInfo = data.message.description.split(':');
                        if (returnInfo.length > 0) {
                        	if (returnInfo[0] == 'cellphoneError') {
                        		$("#msgdemo").addClass("Validform_checktip Validform_wrong").html(returnInfo[1]).show();
                        		$("#cellphone").focus();
                        	}
                        	else if (returnInfo[0] == 'validateError') {
                                $("#msgdemo").addClass("Validform_checktip Validform_wrong").html(returnInfo[1]).show();
                                $("#verifyCode2").val("").focus();
                            }
                            else if (returnInfo[0] == "smsCaptchaError") {
                            	$("#msgdemo").addClass("Validform_checktip Validform_wrong").html(returnInfo[1]).show();
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
                    $("#cellphone").removeAttr("process");
                }
            });
            return false;
        }
});
    loginWithCellphone.addRule([//给上面的验证的validform对象添加规则
        {
            ele: "#cellphone",
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
    $("#getSmsCaptcha").bind("click",function(){smsCaptcha.getSmsCaptcha()});
    
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
					telephone : $("#cellphone").val()
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
			var tel = $("#cellphone").val().trim();
			if(tel==null||tel==undefined||tel==""){
				$("#msgdemo").addClass("Validform_checktip Validform_wrong").html("手机号码必须填写").show();
				$("#cellphone").focus();
				flag = false;
				return false;
			}
			var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
			if (!reg.test(tel)){
				$("#msgdemo").html("请输入正确的手机号码");
				flag = false;
				return false;
			}
			var verifyCode = $("#verifyCode2").val().trim();
			if(verifyCode==""){
				$("#msgdemo").html("请输入验证码").show();
				flag = false;
				return false;
			}
			var reg=/^[a-zA-Z0-9]{4}$/;
			if (!reg.test(verifyCode)){
				$("#msgdemo").html("请输入正确的验证码").show();
				flag = false;
				return false;
			}
			if (!($("#cellphone").attr("process") === undefined)) {
				return false;
			}
			if(flag)
				$.ajax({
					type: "post",
					url: $Url.BuildWWWUrl("/baseInfo/sms/ajaxAddSmsCaptcha"),
					dataType: "json",
					timeout: 30000,
					data: {
						telephone: $String.Trim($("#cellphone").val()),
						verifyCode: $String.Trim($("#verifyCode2").val()),
						isCellphoneLogin:1
					},
					beforeSend: function () {
						$("#cellphone").attr("process", "processing");
					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						alert(errorThrown);
					},
					success: function (data) {
						if(data.errCode=="0000"){
							$("#msgdemo").html("").hide();
							if(data.time==0){
								countdown=60;//60
							}else{
								countdown=60-data.time;
							}
						}else{
							countdown=0;
							$("#msgdemo").addClass("Validform_checktip Validform_wrong").html(data.errCode).show();
						}
						smsCaptcha.settime();
					},
					complete: function (XMLHttpRequest, textStatus) {
						$("#cellphone").removeAttr("process");
					}
				});
		},
		settime	: function (){
			if (countdown == 0) {
				$("#getSmsCaptcha").bind("click",function(){smsCaptcha.getSmsCaptcha()}).html("获取验证码");
				return;
			} else {
				$("#getSmsCaptcha").unbind("click").html("(" + countdown + ")后重新获取");
				countdown--;
			}
			setTimeout(function() {smsCaptcha.settime()},1000)
		}
}

function qqtoLogin()
{
	$.ajax({
		type: "post",
       url: $Url.BuildWWWUrl("/customer/login/qqAuthorizattion"),
       dataType: "json",
       timeout: 30000,
       data: {
       },
       success: function (data, textStatus) {
    	   //以下为按钮点击事件的逻辑。注意这里要重新打开窗口
    	   //否则后面跳转到QQ登录，授权页面时会直接缩小当前浏览器的窗口，而不是打开新窗口
    	   var A=window.open(data.qqLoginUrl,"TencentLogin","width=550,height=420,menubar=0,scrollbars=1,resizable=1,status=1,titlebar=0,toolbar=0,location=1");
       }
	});
} 

