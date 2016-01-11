usingNamespace("UI.EditPwd")["EditPwd"] = {
    buildWarningMessage: function (jqueryObj, msg) {
    	//传入jquery对象的|父级元素|的同级元素|当中找到.Validform_checktip类的元素|移除所有样式|并且把样式换成|.desc .Valideform_wrong .Validform_checktip|并且把这个元素的内容文本换成msg|显示|兄弟节点并且样式是.desc的元素隐藏
    	jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text(msg).show().siblings(".desc").hide();
    },
    clearWarningMessage: function (jqueryObj) {
    	jqueryObj.parent().siblings().find(".Validform_checktip").removeClass().addClass("desc Validform_wrong Validform_checktip").text("").hide();
    }
};

$(document).ready(function () {
    if ($(".validform").length > 0) {
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
                infoObj.hide().siblings(".Validform_wrong,.Validform_loading").show();//本身隐藏，兄弟中带有2个样式的显示。
            }, 0);

        });    
        var editPassword = $(".editPasswordFrom").Validform({
            tiptype: function (msg, o, cssctl) {

            		var object = o.obj.parent().next().find(".Validform_checktip");
            		if(""==msg.trim()){
            			object.hide();
            		}else{
            			object.show();
            		}
            		object.html(msg);
	        },
            usePlugin: {
                passwordstrength: {
                    minLen: 6,
                    maxLen: 20
                }
            },
            datatype: {
                "verifyOldPwd": function (gets, obj, curform, datatype) {
                	
                    var reg=/^[\w\W]{6,20}$/;
                    if (!reg.test(gets)){
                        return false;
                    }
                    var result;
                    var url = $Url.BuildWWWUrl("/customer/editPwd/ajaxCheckOldPwd");
                    $.ajax({
                        type: "get",
                        url: url,
                        dataType: "json",
                        async: false,
                        data: { oldPwd: Base64.encode($String.Trim(gets)) },
                        success: function (data) {
                            if (data.message.type == MessageType.Warning)
                                result = data.message.description;
                        }
                    });

                    return result;
                }
            },
            callback: function (form) {
                if (!($("#pwd").attr("process") === undefined)) {
                    return false;
                }
                $.ajax({
                    type: "post",
                    url:$Url.BuildWWWUrl("/customer/editPwd/ajaxEditPwd"),
                    dataType: "json",
                    timeout: 30000,
                    data: {
                    	oldPwd: Base64.encode($String.Trim($("#oldPwd").val())),
                    	pwd: Base64.encode($String.Trim($("#pwd").val()))
                    },
                    beforeSend: function () {
                        $("#pwd").attr("process", "processing");
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        Base.Common.PromptText.systemError();
                    },
                    success: function (data, textStatus) {
                    	
                        if (data.message.type == MessageType.Error) {
                            var returnInfo = data.message.description.split(':');
                            if (returnInfo.length > 0) {
                            	if (returnInfo[0] == 'oldPwdError') {
                                    UI.EditPwd.EditPwd.buildWarningMessage($("#oldPwd"), returnInfo[1]);
                                }
                                else if (returnInfo[0] == 'pwdError') {
                                    UI.EditPwd.EditPwd.buildWarningMessage($("#pwd"), returnInfo[1]);
                                }
                            }
                        }
                        else {
                            $("#editPwdOk").show();
                            setTimeout(function(){
                            	$("#editPwdOk").hide();
                            }, 3000);
                        }
                        $("#oldPwd").val("").click(function (){$("#editPwdOk").hide()});
                    	$("#pwd").val("").click(function (){$("#editPwdOk").hide()});
                    	$("#rePwd").val("").click(function (){$("#editPwdOk").hide()});
                    	$("#editLoginPasswordDiv").hide();
                    	$("#editLoginPassword").html("修改");
                    	$("#editLoginPasswordSuccessDiv").show();
                    	function editLoginPasswordSuccesscodefans(){
	        		        $("#editLoginPasswordSuccessDiv").slideToggle();
	        				PaymentAccountSecurity.editLoginPasswordBut();  
	        		    }
	        		    setTimeout(editLoginPasswordSuccesscodefans,3000);//3秒
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                        $("#pwd").removeAttr("process");
                    }
                });

                return false;
            }
        });

        editPassword.addRule([
            {
                ele: "#oldPwd",
                datatype: "verifyOldPwd",
                //ignore: "ignore",
                nullmsg: "请填写密码",
                errormsg: "6-20位字符，可使用字母、数字或符号的组合",
                sucmsg: " "
                //plugin: "passwordStrength"
            },
            {
                ele: "#pwd",
                datatype: "pwd",//密码的干活
                //ignore: "ignore",
                nullmsg: "请填写密码",
                errormsg: "6-20位字符，可使用字母、数字或符号的组合",
                sucmsg: " ",
                //plugin: "passwordStrength"
            },
            {
                ele: "#rePwd",//复验密码
                datatype: "pwd",
                //ignore: "ignore",
                nullmsg: "请再次输入密码",
                errormsg: "两次输入的密码不一致",
                sucmsg: " ",
                recheck: "pwd"
            }
        ]);
        
        var setPassword = $("#setPasswordFrom").Validform({
        	tiptype: function (msg, o, cssctl) {
        		var object = o.obj.parent().next().find(".Validform_checktip");
        		if(""==msg.trim()){
        			object.hide();
        		}else{
        			object.show();
        		}
        		object.html(msg);
        	},
        	usePlugin: {
        		passwordstrength: {
        			minLen: 6,
        			maxLen: 20
        		}
        	},
        	datatype: {
//        		"verifyOldPwd": function (gets, obj, curform, datatype) {
//        			
//        			var reg=/^[\w\W]{6,20}$/;
//        			if (!reg.test(gets)){
//        				return false;
//        			}
//        			var result;
//        			var url = $Url.BuildWWWUrl("/customer/editPwd/ajaxCheckOldPwd");
//        			$.ajax({
//        				type: "get",
//        				url: url,
//        				dataType: "json",
//        				async: false,
//        				data: { oldPwd: Base64.encode($String.Trim(gets)) },
//        				success: function (data) {
//        					if (data.message.type == MessageType.Warning)
//        						result = data.message.description;
//        				}
//        			});
//        			
//        			return result;
//        		}
        	},
        	callback: function (form) {
        		if (!($("#pwd2").attr("process") === undefined)) {
        			return false;
        		}
        		$.ajax({
        			type: "post",
        			url:$Url.BuildWWWUrl("/customer/editPwd/ajaxSetPwd"),
        			dataType: "json",
        			timeout: 30000,
        			data: {
        				pwd: Base64.encode($String.Trim($("#pwd2").val()))
        			},
        			beforeSend: function () {
        				$("#pwd2").attr("process", "processing");
        			},
        			error: function (XMLHttpRequest, textStatus, errorThrown) {
        				Base.Common.PromptText.systemError();
        			},
        			success: function (data, textStatus) {
        				if (data.message.type == MessageType.Error) {
        					var returnInfo = data.message.description.split(':');
        					if (returnInfo.length > 0) {
        						if (returnInfo[0] == 'pwdError') {
        							UI.EditPwd.EditPwd.buildWarningMessage($("#pwd2"), returnInfo[1]);
        						}
        					}
        				}
        				else {
        					$("#setLoginPassword").parent("p").css("color","#5CD756").children().replaceWith("设置完成");
        					$("#editPwdOk").show();
        					setTimeout(function(){
        						$("#editPwdOk").hide();
        					}, 3000);
        				}
        				$("#pwd2").val("").click(function (){$("#editPwdOk").hide()});
        				$("#rePwd2").val("").click(function (){$("#editPwdOk").hide()});
        				$("#setLoginPasswordDiv").hide();
        				$("#editLoginPasswordSuccessDiv").show();
        				function editLoginPasswordSuccesscodefans(){
        					        $("#editLoginPasswordSuccessDiv").slideToggle();
        					PaymentAccountSecurity.editLoginPasswordBut();  
        					    }
        				    setTimeout(editLoginPasswordSuccesscodefans,3000);//3秒
        			},
        			complete: function (XMLHttpRequest, textStatus) {
        				$("#pwd").removeAttr("process");
        			}
        		});
        		
        		return false;
        	}
        });
        setPassword.addRule([
                              {
                            	  ele: "#pwd2",
                            	  datatype: "pwd",//密码的干活
                            	  //ignore: "ignore",
                            	  nullmsg: "请填写密码",
                            	  errormsg: "6-20位字符，可使用字母、数字或符号的组合",
                            	  sucmsg: " ",
                            	  //plugin: "passwordStrength"
                              },
                              {
                            	  ele: "#rePwd2",//复验密码
                            	  datatype: "pwd",
                            	  //ignore: "ignore",
                            	  nullmsg: "请再次输入密码",
                            	  errormsg: "两次输入的密码不一致",
                            	  sucmsg: " ",
                            	  recheck: "pwd"
                              }
                              ]);
    }
    
});

