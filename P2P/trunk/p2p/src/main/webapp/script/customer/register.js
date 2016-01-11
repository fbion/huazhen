usingNamespace("UI.LogReg")["Register"] = {
    buildWarningMessage: function (jqueryObj, msg) {
    	
    	jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show().siblings(".desc").hide();
    },
    clearWarningMessage: function (jqueryObj) {
    	
    	jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};


$(document).ready(function () {
	Banner.GetBanner($(".p2pBanner1"),2);
    if ($(".validform").length > 0) {
    	var inviteTelephone = $("#inviteTelephone").val();
    	if(""!=inviteTelephone){
    		$("#inviteTelephone").attr("readonly",true);
    	}
        var getInfoObj = function () {
            return $(this).parent().next().find(".info");
        }

        $(".input").focusin(function () {
            if (this.timeout) {	
                clearTimeout(this.timeout);
            }
            var infoObj = getInfoObj.call(this);
            if (infoObj.siblings(".Validform_right").length != 0) {
                return;
            }
            infoObj.show().siblings(".desc").hide();

        }).focusout(function () {
            var infoObj = getInfoObj.call(this);
            this.timeout = setTimeout(function () {
                infoObj.hide().siblings(".Validform_wrong,.Validform_loading").show();
            }, 0);

        });

        var register = $(".validform").Validform({
            tiptype: function (msg, o, cssctl) {
//	            var objtip = o.obj.siblings(".Validform_checktip");
//	            cssctl(objtip, o.type);
//	            objtip.text(msg);

            	if(o.obj.parent().parent().parent().attr("class")=="mt30 choose_area"){
            		var object = o.obj.parent().next().find(".Validform_checktip");
            		if(""==msg.trim()){
            			object.hide();
            		}else{
            			object.show();
            		}
            		object.html(msg);
            	}else{
            		if(""==msg.trim()){
            			//o.obj.removeAttr("style");
            			//$("#errMsg").hide();
            		}else{
            			//o.obj.css("background-color","#ffe7e7");
            			$("#errMsg").show();
            			$("#errMsg").html(msg);
            		}
            	}
	        },
            usePlugin: {
                passwordstrength: {
                    minLen: 6,
                    maxLen: 20
                }
            },
            ignoreHidden:true,
            datatype: {
            	"verifyTelephone": function (gets, obj, curform, datatype) {
            			if(gets==""){
            				$("#errMsg").html("请输入手机号码");
            				return false;
            			}
	          		  	var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
	                    if (!reg.test(gets)){
	                    	$("#errMsg").html("请输入正确的手机号码");
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
	                            isCellphoneLogin:0
	                        },
	                        success: function (data, textStatus) {
	                            if (data.message.type != "Info") {
	                            	$("#errMsg").html(data.message.description).show();
	                            	return false;
	                            }
	                        }
	                    });
	                    return true;
	          	  },
	          	"verifyinviteTelephone": function (gets, obj, curform, datatype) {
        			/*if(gets==""){
        				$("#errMsg").html("请输入手机号码");
        				return false;
        			}*/
	          		if(gets!=""){
	          		  	var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
	                    if (!reg.test(gets)){
	                    	$("#errMsg").html("请输入正确的手机号码");
	                        return false;
	                    }
	                    var url = $Url.BuildWWWUrl("/customer/register/ajaxCheckteinvitelephoneExist");
	                    $.ajax({
	                        type: "post",
	                        url: url,
	                        dataType: "json",
	                        async: false,
	                        data: {
	                        	inviterNo :$String.Trim(gets),
	                        },
	                        success: function (data, textStatus) {
	                            if (data.message.type != "Info") {
	                            	$("#errMsg").html(data.message.description).show();
	                            	return false;
	                            }
	                        }
	                    });
	                    return true;
	          		}

          	  },
	          	  //verifyinviteTelephone
                /*"verifyEmail": function (gets, obj, curform, datatype) {
                    var reg=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                    if (!reg.test(gets)){
                        return false;
                    }

                    var url = $Url.BuildWWWUrl("/customer/register/ajaxCheckEmailExist");
                    var result = true;
                    $.ajax({
                        type: "get",
                        url: url,
                        dataType: "json",
                        async: false,
                        data: { email: $String.Trim(gets) },
                        success: function (data) {
                            if (data.message.type == MessageType.Warning)
                                result = data.message.description;
                        }
                    });

                    return result;
                },*/
               	"verifyUsername": function (gets, obj, curform, datatype) {
               		if(gets==""){
               			$("#errMsg").html("请填写用户名");
               			return false;
               		}
                    var reg = /^(?!^\d+$)(?!^_+$)[0-9a-zA-Z_]{4,20}$/;//字母、数字和下划线组合
                    if (!reg.test(gets)) {
                    	$("#errMsg").html("用户名必须为4~20位字符，支持字母或字母、数字和下划线的组合");
                        return false;
                    }

                    var url = $Url.BuildWWWUrl("/customer/register/ajaxCheckUserExist");//请求到 验证用户存在的action的方法上
                    $.ajax({
                        type: "get",
                        url: url,
                        dataType: "json",
                        async: false,
                        data: { userName: $String.Trim(gets) },
                        success: function (data) {
                            if (data.message.type == MessageType.Warning){
                            	$("#errMsg").show();
                            	$("#errMsg").html(data.message.description);
                            	$("#username").css("background-color","#ffe7e7");
                            	return false;
                            }
                            if(data.message.type == MessageType.Info){
                            	$("#errMsg").hide().html("");
                            	$("#username").removeAttr("style");
                            }
                        }
                    });

                    return true;
                },
                "verifySelect": function (gets, obj, curform, datatype) {
                	if (gets == "0" || gets == "")
                		return false;
                	else
                		return true;
                },
                "verifySmsCaptcha": function (gets, obj, curform, datatype) {
                	if(gets==""){
               			$("#errMsg").html("请输入手机验证码");
               			return false;
               		}
    				var reg=/^[0-9]{6}$/;
    				if (!reg.test(gets)){
    					$("#errMsg").html("请输入6位数字的手机验证码");
    					return false;
    				}
    				var url = $Url.BuildWWWUrl("/baseInfo/sms/ajaxCheckSmsCaptcha");
    				$.ajax({
    					type: "post",
    					url: url,
    					dataType: "json",
    					data: {
    						telephone :$String.Trim($("#telephone").val()),
    		                smsCaptcha:$String.Trim(gets)
    					},
    					success: function (data, textStatus) {
    						if(data.errCode!="0000"){
    							$("#errMsg").html(data.errCode);
    	    					return false;
    						}
    					}
    				});
    				return true;
    			},
                "verifyPwd": function (gets, obj, curform, datatype) {
                	if(gets==""){
               			$("#errMsg").html("请填写密码");
               			return false;
               		}
    				var reg=/^[\w\W]{6,20}$/;
    				if (!reg.test(gets)){
    					$("#errMsg").html("密码必须为6~20位字符");
    					return false;
    				}
    				return true;
    			},
                "verifyCaptcha": function (gets, obj, curform, datatype) {
                	if(gets==""){
               			$("#errMsg").html("请输入验证码");
               			return false;
               		}
    				var reg=/^[a-zA-Z0-9]{4}$/;
    				if (!reg.test(gets)){
    					$("#errMsg").html("请输入正确的验证码");
    					return false;
    				}
    				return true;
    			}
            },
            callback: function (form) {
                if (!($("#submit").attr("process") === undefined)) {
                    return false;
                }
                if($(":radio[name='choose']:checked").val()==0){
                	if($(":radio[name='choose_customers']:checked").length==0){
                		$("#remindEmployee").empty().show();
                		$("#remindEmployee").html("请选择理财经理！");
                		return false;
                	}
                }
                var verifyCode = $("#verifyCode").val();
                if (typeof (verifyCode) == "undefined") {
                    verifyCode = "";
                }
                var customer = { 
                	userName: $String.Trim($("#username").val()),
                    password: Base64.encode($String.Trim($("#pwd").val())),
                    //email:$String.Trim($("#email").val()),
                	provinceNo:$String.Trim($(".province option:selected").val()),
                	cityNo:$String.Trim($(".city option:selected").val()),
                	districtNo:$String.Trim($(".district option:selected").val()),
                	deptNo:$String.Trim($(".department option:selected").val()),
                	//empNo:$String.Trim($(".name").val())
                	empNo:$("input[name='choose_customers']:checked").val(),
                	cellphone : $("#telephone").val()
                }
                $.ajax({//异步发送
                    type: "post",
                    url: $Url.BuildWWWUrl("customer/register/ajaxRegister"),
                    dataType: "json",
                    timeout: 30000,
                    data: {
                        verifyCode: $String.Trim(verifyCode),
                        p2pCustomer: JSON.stringify(customer),
                        smsCaptcha:$("#smsCaptcha").val(),
                        inviterNo:$("#inviteTelephone").val(),
                        activityId:$("#activityId").val()
                        
                    },
                    beforeSend: function () {
                        $("#submit").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        Base.Common.PromptText.systemError();
                        alert(errorThrown);
                    },
                    success: function (data, textStatus) {
                        if (data.message.type == MessageType.Error) {
                            var returnInfo = data.message.description.split(':');
                            if (returnInfo.length > 0) {
                                if (returnInfo[0] == 'validateError') {
                                    UI.LogReg.Register.buildWarningMessage($("#verifyCode"), returnInfo[1]);
                                }
                                else if (returnInfo[0] == 'userError') {
                                    UI.LogReg.Register.buildWarningMessage($("#username"), returnInfo[1]);
                                    UI.LogReg.Register.clearWarningMessage($("#verifyCode"));

                                }
                                else if (returnInfo[0] == 'pwdError') {
                                    UI.LogReg.Register.buildWarningMessage($("#pwd"), returnInfo[1]);
                                    UI.LogReg.Register.clearWarningMessage($("#verifyCode"));
                                }
                                else if (returnInfo[0] == "smsCaptchaError") {
                                	UI.LogReg.Register.clearWarningMessage($("#verifyCode"));
                                	$("#smsCaptcha").focus();
                                }
                                $("#errMsg").html(returnInfo[1]).show();
                            }
                            $("#verifyCode").val("");
                            $VerifyCode.refreshValidator('#imgVerifyCode', '#verifyCode');
                        }
                        else {
                            var redirectUrl = $("#redirectUrl").val();
                            if (redirectUrl.length > 0) {
                                window.location = redirectUrl;
                            }
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#submit").removeAttr("process");
                    }
                });
                return false;
            }
        });
        register.addRule([
            {
                ele: "#username",//用户名
                datatype: "verifyUsername",//"c4-20",
                //ignore: "ignore",
                nullmsg: "请填写用户名",
                errormsg: "用户名必须为4~20位字符，支持字母或字母、数字和下划线的组合",
                sucmsg: " "
            },
            /*{
                ele: "#email",
                datatype: "verifyEmail",
                //ignore: "ignore",
                nullmsg: "请填写邮箱",
                errormsg: "请输入正确的邮箱",
                sucmsg: " "
            },*/
            {
                ele: "#pwd",
                datatype: "verifyPwd",
                //ignore: "ignore",
                nullmsg: "请填写密码",
                errormsg: "密码必须为6~20位字符",
                sucmsg: " ",
                plugin: "passwordStrength"
            },
            {
                ele: "#pwd_confirm",
                datatype: "verifyPwd",
                //ignore: "ignore",
                nullmsg: "请再次输入密码",
                errormsg: "两次输入的密码不一致",
                sucmsg: " ",
                recheck: "pwd"
            },
            {
                ele: "#telephone",
                datatype: "verifyTelephone",
                //ignore: "ignore",
                nullmsg: "请输入手机号码",
                errormsg: "请输入正确的手机号码",
                sucmsg: " "
            },
            {
                ele: "#inviteTelephone",
                datatype: "verifyinviteTelephone",
                //ignore: "ignore",
                nullmsg: "请输入手机号码",
                errormsg: "请输入正确的手机号码",
                sucmsg: " "
            },
            {
                ele: "#verifyCode",
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
    		},
            {
                ele: "#agree",
                datatype: "*",
                //ignore: "ignore",
                nullmsg: "只有接受服务协议的用户才能注册",
                errormsg: "只有接受服务协议的用户才能注册",
                sucmsg: " "
            },
			{
				ele: ".province",
				datatype: "verifySelect",
				//ignore: "ignore",
				nullmsg: "请选择省",
				errormsg: "请选择省",
				sucmsg: " "
			},
			{
				ele: ".city",
				datatype: "verifySelect",
				//ignore: "ignore",
				nullmsg: "请选择市",
				errormsg: "请选择市",
				sucmsg: " "
			},
			{
				ele: ".district",
				datatype: "verifySelect",
				//ignore: "ignore",
				nullmsg: "请选择区/县",
				errormsg: "请选择区/县",
				sucmsg: " "
			},
			{
				ele: ".department",
				datatype: "verifySelect",
				//ignore: "ignore",
				nullmsg: "请选择门店",
				errormsg: "请选择门店",
				sucmsg: " "
			}     
         ]);

    }
    
    regist.registerSelect();
    $("#customerService").click();
    regist.refreshSmsJsp();
    $("#getSmsCaptcha").removeAttr("disabled").bind("click",function(){regist.getSmsCaptcha()});
});

var countdown = 0;
var regist = {
	registerSelect: function () {
		$("#ownChoice").click(function() {
			$("#myChoose").show();
		});
		$("#customerService").click(function() {
			$("#myChoose").hide();
			$(".province").val("");
			$(".province").find("option[value='']").trigger("change");
		});
		var employeeListUrl = $Url.BuildWWWUrl('/baseInfo/ajaxEmlopyee.action');
		
		$.fn.linkage({	//填充下拉框	省 市区部门
	        elements: [$(".province"),$(".city"),$(".district"),$(".department")],
	        dataTypes: ["getProvince","getCity","getDistrict","getDepartment"],//方法
	        actionUrl: $Url.BuildWWWUrl("/common/enumList.action"),//地址
	        all: false
	    });
			
		$(".department").change(function() {
			$(".employee").empty();
			$("#remindEmployee").empty().hide();
			if($(this).val()!=""){
				customerPortrait.GetListToSelectForEmployee(employeeListUrl, $(this).val());
			}
		});
		$(".province").change(function() {
			$(".employee").empty();
			$("#remindEmployee").empty().hide();
		});
		$(".city").change(function() {
			$(".employee").empty();
			$("#remindEmployee").empty().hide();
		});
		$(".district").change(function() {
			$(".employee").empty();
			$("#remindEmployee").empty().hide();
		});
		
	},
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
			$("#errMsg").html("手机号码必须填写").show();
			$("#telephone").focus();
			flag = false;
			return false;
		}
		var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
        if (!reg.test(tel)){
        	$("#errMsg").html("请输入正确的手机号码");
        	flag = false;
        	return false;
        }
        $.ajax({
            type: "post",
            url: $Url.BuildWWWUrl("/customer/register/ajaxChecktelephoneExist"),
            dataType: "json",
            async: false,
            data: {
                telephone :$String.Trim(tel),
            },
            success: function (data, textStatus) {
                if (data.message.type != "Info") {
                	$("#errMsg").html(data.message.description).show();
                	flag = false;
                	return false;
                }else{
                	$("#errMsg").html("").hide();
                }
                
            }
        });
        var verifyCode = $("#verifyCode").val().trim();
        if(verifyCode==""){
   			$("#errMsg").html("请输入验证码").show();
   			flag = false;
   			return false;
   		}
		var reg=/^[a-zA-Z0-9]{4}$/;
		if (!reg.test(verifyCode)){
			$("#errMsg").html("请输入正确的验证码").show();
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
            		$("#errMsg").html("").hide();
            		if(data.time==0){
            			countdown=60;//60
            		}else{
            			countdown=60-data.time;
            		}
            	}else{
            		countdown=0;
            		$("#errMsg").html(data.errCode).show();
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

var customerPortrait = {
	//头像+名字
	GetListToSelectForEmployee : function(listUrl, param) {
		$.ajax({
			type : "post",
			async : false,
			url : listUrl,
			dataType : "html",
			cache : true,
			beforeSend : function(XMLHttpRequest) {
			},
			data : {
				param : param
			},
			success : function(data) {
				$(".employee").html(data);
				$(":radio").click(function(){
					$("#remindEmployee").empty().hide();
				});
				// $(":radio[name='choose_customers']").first().attr("checked","checked");
			},
			complete : function(XMLHttpRequest, textStatus) {
			},
			error : function() {
				// 请求出错处理
				alert("内部错误1");
			}
		});
	}	
}
