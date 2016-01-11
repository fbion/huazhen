usingNamespace("UI.LogReg")["Register"] = {
    buildWarningMessage: function (jqueryObj, msg) {
    	
    	jqueryObj.parent().parent().next().removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show().siblings(".desc").hide();
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

$(document).ready(function () {//文档加载好了之后

	if($("#landedStatus").val()=="true"){
		//if loanded true login.jsp redirect index.jsp
		window.location.href=$("#landedUrl").val();
	}
	ManagePage.OnClickElem($(".validformRegister_tips"));
	ManagePage.OnClickElem($("#imgVerifyCode"));
    if ($(".validform").length > 0) {//判断这个元素存在否？如果存在之后的一切开始发生
    	
    	
    	var inviteTelephone = $("#inviteTelephone").val();
    	if(""!=inviteTelephone){
    		$("#inviteTelephone").attr("readonly",true);
    	}
        var getInfoObj = function () {//定义一个能找到本元素的父元素的第一个元素中的带有（.info）的元素
            return $(this).parent().next().find(".info");
        }

        $(".input").focusin(function () {//设计一个触发事件 带有样式（.input） 的元素的焦点移动上
            if (this.timeout) {	//如果这个元素的timeout 是true
                clearTimeout(this.timeout); //清除
            }
            var infoObj = getInfoObj.call(this);//上面定义的函数的调用
            if (infoObj.siblings(".Validform_right").length != 0) {//之后判断这个元素的兄弟节点存在否？
                return;//不存在这个函数就不用执行了
            }
            infoObj.show().siblings(".desc").hide();//在上边的元素存在的时候。隐藏带有.desc样式元素

        }).focusout(function () {//当焦点移出的时候
            var infoObj = getInfoObj.call(this);//上面定义的函数的调用
            this.timeout = setTimeout(function () {//如果超时
                infoObj.hide().siblings(".Validform_wrong,.Validform_loading").show();//本身隐藏，兄弟中带有2个样式的显示。
            }, 0);

        });

        var register = $(".validform").Validform({//添加验证控件 简历一个验证对象（validform对象）
           // tiptype: 2,//显示验证信息显示位置
			
			tiptype:function (msg, o, cssctl) {
	           var objtip = o.obj.parent().parent().next(".Validform_checktip");
           		 cssctl(objtip, o.type);
            	objtip.text(msg);

			},
            /*usePlugin: {//密码强度控件
                passwordstrength: {
                    minLen: 6,
                    maxLen: 20
                }
            },*/
            ignoreHidden:true,
            datatype: {
                
               	"verifyUsername": function (gets, obj, curform, datatype) {//这个函数是验证用户名输入格式是否正确

                    var reg = /^(?!^\d+$)(?!^_+$)[0-9a-zA-Z_]{4,20}$/;
                    if (!reg.test(gets)) {//不通过就跳出并且返回
                        return false;
                    }
                    //如果验证通过之后，发送请求
                    var url = $Url.BuildWWWUrl("/customer/register/ajaxCheckUserExist");//请求到 验证用户存在的action的方法上
                    var result;//定义一个返回对象
                    $.ajax({//同步请求
                        type: "get",//get 方式
                        url: url,//访问地址如上
                        dataType: "json",//请求格式为json
                        async: false,//同步
                        data: { userName: $String.Trim(gets) },//传入的参数为用户名
                        success: function (data) {//请求发送OK，返回data
                            if (data.message.type == MessageType.Warning)//如果data中的message的类型是Waring
                                result = data.message.description;//就把信息内容放入result中间
                        }
                    });

                    return result;//作为整个dateType的返回结果（一条报错信息）;
                },
                "verifyTelephone": function (gets, obj, curform, datatype) {
//                	if(gets==""){
//                		$("#errMsg").html("请输入手机号码");
//                		return false;
//                	}
                	var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                	if (!reg.test(gets)){
//                		$("#errMsg").html("请输入正确的手机号码");
                		return false;
                	}
                	var url = $Url.BuildWWWUrl("/customer/register/ajaxCheckTelephoneExist");
                	var result
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
                			if (data.message.type == MessageType.Warning) {
                				result = data.message.description;
                			}
                		}
                	});
                	return result;
                },
	          	"verifyinviteTelephone": function (gets, obj, curform, datatype) {
	          		if(gets!=""){
	          		  	var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
	                    if (!reg.test(gets)){
	                    	$("#errMsg").html("请输入正确的邀请手机号码");
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
	                            	UI.LogReg.Register.buildWarningMessage($("#inviteTelephone"),data.message.description);
	                            	return false;
	                            }
	                        }
	                    });
	                    return true;
	          		}

          	  },
                "verifySmsCaptcha": function (gets, obj, curform, datatype) {
//                	if(gets==""){
//               			$("#errMsg").html("请输入手机验证码");
//               			return false;
//               		}
    				var reg=/^[0-9]{6}$/;
    				if (!reg.test(gets)){
//    					$("#errMsg").html("请输入6位数字的手机验证码");
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
                "verifySelect": function (gets, obj, curform, datatype) {
                	if (gets == "0" || gets == "")
                		return false;
                	else
                		return true;
                }
            },
            callback: function (form) {//验证控件的回调
                if (!($("#username").attr("process") === undefined)) {//如果用户名的process属性木有
                    return false;//返回
                }

                var verifyCode = $("#verifyCode").val();//验证码的值
                if (typeof (verifyCode) == "undefined") {//没有输入的时候来个空字符串
                    verifyCode = "";
                }
                var customer = { //客户对象
                	userName: $String.Trim($("#username").val()),//用户名
                    password: Base64.encode($String.Trim($("#pwd").val())),//加密后的密码
                    code:$String.Trim($("#code").val()),//为了获取微信号openID先获取code
                    telephone:$String.Trim($("#telephone").val()),
                    smsCaptcha:$String.Trim($("#smsCaptcha").val())
                	}
                $.ajax({//异步发送
                    type: "post",//post方式
                    url: $Url.BuildWWWUrl("customer/register/ajaxRegister"),//地址
                    dataType: "json",//数据类型为json
                    timeout: 50000,//超时时间为
                    data: {//发送数据为一个验证码和用户对象（json）
                        verifyCode: $String.Trim(verifyCode),
                        p2pCustomer: JSON.stringify(customer),
                        userName: $String.Trim($("#username").val()),
                        code:$String.Trim($("#code").val()),
                        telephone:$String.Trim($("#telephone").val()),
                        inviterNo:$("#inviteTelephone").val(),
                        activityId:$("#activityId").val(),
                        smsCaptcha:$String.Trim($("#smsCaptcha").val())
                    },
                    beforeSend: function () {//在发送之前放一新个属性作为标记
                        $("#username").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        Base.Common.PromptText.systemError();//错了就错了
                        alert(errorThrown);
                    },
                    success: function (data, textStatus) {//如果ok 取回data
                        if (data.message.type == MessageType.Error) {//当type 是Error的时候
                            var returnInfo = data.message.description.split(':');//返回的报错内容切割它
                            if (returnInfo.length > 0) {//切割成功
                                if (returnInfo[0] == 'validateError') {//第一条信息调用最上方的命名空间定义的创建一个警告提示信息的方法并且把这个returninfo[1]放到函数中
                                    UI.LogReg.Register.buildWarningMessage($("#verifyCode"), returnInfo[1]);//$("#verifyCode")是用来定位的jquery对象
                                }
                                else if (returnInfo[0] == 'userError') {//同理
                                    UI.LogReg.Register.buildWarningMessage($("#username"), returnInfo[1]);
                                    UI.LogReg.Register.clearWarningMessage($("#verifyCode"));

                                }
                                else if (returnInfo[0] == 'emailError') {//同理
                                    UI.LogReg.Register.buildWarningMessage($("#email"), returnInfo[1]);
                                    UI.LogReg.Register.clearWarningMessage($("#verifyCode"));

                                }
                                else if (returnInfo[0] == 'pwdError') {//同理
                                    UI.LogReg.Register.buildWarningMessage($("#pwd"), returnInfo[1]);
                                    UI.LogReg.Register.clearWarningMessage($("#verifyCode"));
                                }
                                else if (returnInfo[0] == 'smsCaptchaError') {//同理
                                	UI.LogReg.Register.buildWarningMessage($("#smsCaptcha"), returnInfo[1]);
                                	UI.LogReg.Register.clearWarningMessage($("#verifyCode"));
                                }
                                else if(returnInfo[0] == 'weixinError'){
                                	alert(returnInfo[1]);
                                }
                            }
                            $("#verifyCode").val("");//最后呢，把验证码干掉！
                            $VerifyCode.refreshValidator('#imgVerifyCode', '#verifyCode'); //刷新验证码吧骚年！
                        }
                        else {//如果没有返回的错误信息
                            var redirectUrl = $("#redirectUrl").val();//找到页面的跳转Url的值
                            if (redirectUrl.length > 0) {//如果存在的话
                            	var redirectUrl=redirectUrl+"?userName="+$("#username").val();
                                window.location = redirectUrl;//页面跳转吧！
                            }
                        }
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#username").removeAttr("process");//最后的最后，把这个临时工属性process 开除
                    }
                });

                return false;//这是整个回调callback的返回
            }
        });

        register.addRule([//给上面的验证的validform对象添加规则
            {
                ele: "#username",//用户名
                datatype: "verifyUsername",//"c4-20",//自定义的verifyUsername验证方式
                //ignore: "ignore",
                nullmsg: "请填写登录账号",
                errormsg: "用户名必须为4~20位字符，支持字母或字母、数字和下划线的组合",
                sucmsg: " "
            },
            {
            	ele: "#telephone",
            	datatype: "verifyTelephone",
            	nullmsg: "请输入手机号码",
            	errormsg: "请输入正确的手机号码",
            	sucmsg: " "
            },
            {
                ele: "#inviteTelephone",
                datatype: "verifyinviteTelephone",
                errormsg: "请输入正确的邀请人手机号码",
                sucmsg: " "
            },
            {
            	ele: "#smsCaptcha",
            	datatype: "verifySmsCaptcha",
            	nullmsg: "请输入手机验证码",
            	errormsg: "请输入6位数字的手机验证码",
            	sucmsg: " "
            },
            {
                ele: "#pwd",
                datatype: "pwd",//密码的干活
                //ignore: "ignore",
                nullmsg: "请填写密码",
                errormsg: "6~20位字符，可使用字母、数字或符号的组合，不建议使用纯数字，纯字母，纯符号",
                sucmsg: " "
            },
            {
                ele: "#pwd_confirm",//密码的干活double
                datatype: "pwd",
                //ignore: "ignore",
                nullmsg: "请再次输入密码",
                errormsg: "两次输入的密码不一致",
                sucmsg: " ",
                recheck: "pwd"
            },
            {
                ele: "#verifyCode",//验证码的干活
                datatype: "captcha",
                //ignore: "ignore",
                nullmsg: "请输入验证码",
                errormsg: "请输入正确的验证码",
                sucmsg: " "
            },
            {
                ele: "#agree",//这个是用来验证协议是否选中
                datatype: "*",
                //ignore: "ignore",
                nullmsg: "只有接受服务协议的用户才能注册",
                errormsg: "只有接受服务协议的用户才能注册",
                sucmsg: " "
            }         
         ]);

    }
    
    regist.refreshSmsJsp();
    $("#getSmsCaptcha").removeAttr("disabled").bind("click",function(){regist.getSmsCaptcha()});
});

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

