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
	 },
	 registerSelect: function () {
			var employeeListUrl = $Url.BuildWWWUrl('/baseInfo/ajaxEmlopyee');
			$("#department").change(function() {
				//$(".employee").empty();
				//$("#remindEmployee").empty().hide();
				if($(this).val()!=""){
					$(".employee").show();
					ManagePage.GetListToSelectForEmployee(employeeListUrl, $(this).val());
				}else{
					$(".employee").hide();
					$("#employeeMsg").removeClass().text("");
				}
			});
		},
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
		},
		GetDepartmentList:function(){
			EnumList.GetEnumListToSelect($("#department"), "getDepartmentList", $Url.BuildWWWUrl('/common/enumList'))
		},
		CheckEmployee:function(){
			if($("input[name='choose_customers']:checked").val()==undefined){
				$("#employeeMsg").addClass("desc Validform_wrong Validform_checktip").text("请选择理财经理");
				return false;
			}
		}
};

$(document).ready(function () {//文档加载好了之后
	
	ManagePage.OnClickElem($(".validformRegister_tips"));
	ManagePage.OnClickElem($("#imgVerifyCode"));
    if ($(".validform").length > 0) {//判断这个元素存在否？如果存在之后的一切开始发生
    	
    	
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

        var register = $(".newregisterInfo").Validform({//添加验证控件 简历一个验证对象（validform对象）
           // tiptype: 2,//显示验证信息显示位置
			
			tiptype:function (msg, o, cssctl) {
	           var objtip = o.obj.parent().parent().next(".Validform_checktip");
           		 cssctl(objtip, o.type);
            	objtip.text(msg);

			},
            ignoreHidden:true,
            datatype: {
                "verifyTelephone": function (gets, obj, curform, datatype) {
                	var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                	if (!reg.test(gets)){
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
                "verifySmsCaptcha": function (gets, obj, curform, datatype) {
    				var reg=/^[0-9]{6}$/;
    				if (!reg.test(gets)){
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
                var customer = { 
                		realName: $String.Trim($("#username").val()),
                    	deptNo:$String.Trim($("#department option:selected").val()),
                    	empNo:$("input[name='choose_customers']:checked").val(),
                    	//weixin:$String.Trim($("#code").val()),
                    	cellphone:$("#telephone").val()
                    }
                $.ajax({//异步发送
                    type: "post",//post方式
                    url: $Url.BuildWWWUrl("customer/register/ajaxNewRegister"),
                    dataType: "json",
                    timeout: 50000,
                    data: {
                        p2pCustomer: JSON.stringify(customer),
                        verifyCode: $String.Trim(verifyCode),
                        smsCaptcha:$String.Trim($("#smsCaptcha").val())
                    },
                    beforeSend: function () {
                    	return  ManagePage.CheckEmployee();
                        $("#username").attr("process", "processing");
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
                                else if (returnInfo[0] == 'smsCaptchaError') {
                                	UI.LogReg.Register.buildWarningMessage($("#smsCaptcha"), returnInfo[1]);
                                	UI.LogReg.Register.clearWarningMessage($("#verifyCode"));
                                }
                                else if(returnInfo[0] == 'weixinError'){
                                	alert(returnInfo[1]);
                                }
                            }
                            $("#verifyCode").val("");
                            $VerifyCode.refreshValidator('#imgVerifyCode', '#verifyCode'); 
                        }
                        else {//如果没有返回的错误信息
                            var redirectUrl = $("#redirectUrl").val();//找到页面的跳转Url的值
                            if (redirectUrl.length > 0) {//如果存在的话
                            	var redirectUrl=redirectUrl+"?newRegister=1";
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
                ele: "#username",
                datatype: "/^[\u4e00-\u9fa5]{2,4}$/",
                //ignore: "ignore",
                nullmsg: "请填写中文名",
                errormsg: "请输入2到4个中文字符",
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
            	ele: "#smsCaptcha",
            	datatype: "verifySmsCaptcha",
            	nullmsg: "请输入手机验证码",
            	errormsg: "请输入6位数字的手机验证码",
            	sucmsg: " "
            },
            {
                ele: "#verifyCode",
                datatype: "captcha",
                //ignore: "ignore",
                nullmsg: "请输入验证码",
                errormsg: "请输入正确的验证码",
                sucmsg: " "
            },     
            {
            	ele: "#department",
            	datatype: "*",
            	//ignore: "ignore",
            	nullmsg: "请选择门店",
            	errormsg: "请选择门店",
            	sucmsg: " "
            } 
         ]);

    }
    ManagePage.registerSelect();
    regist.refreshSmsJsp();
    $("#getSmsCaptcha").removeAttr("disabled").bind("click",function(){regist.getSmsCaptcha()});
    ManagePage.GetDepartmentList();
});

