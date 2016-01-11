//修改手机号
$(function(){
	$("#addTel").click(function(){
		$("#addTelephoneDiv").slideToggle();
		PaymentAccountSecurity.addTelephoneBut($(this));
	});
	var AddTelephone = $(".addTelephoneFrom").Validform({
        tiptype: function (msg, o, cssctl) {
			var objtip=$("#msg");
        	cssctl(objtip,o.type);
        	objtip.text(msg);
        },
        datatype: {
        	"verifyTelephone": function (gets, obj, curform, datatype) {
          		  	var reg=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                    if (!reg.test(gets)){
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
                        },
                        success: function (data, textStatus) {
                            if (data.message.type!=MessageType.Info) {
                            	$("#msg").html(data.message.description)
                            	return false;	                          
                            }
                        }
                    });
                    return true;
          	  },             				 
            "verifySmsCaptchatel": function (gets, obj, curform, datatype) {            	
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
						telephone :$String.Trim($("#tel").val()),
		                smsCaptcha:$String.Trim(gets)
					},
					 error: function (XMLHttpRequest, textStatus, errorThrown) {
		                    Base.Common.PromptText.systemError();
		                    alert(errorThrown);
		                },
					success: function (data, textStatus) {
						if(data.errCode!="0000"){
							$("#msg").html("").show();
							$("#msg").addClass("Validform_wrong").html(data.errCode);
							return false;
						}
					}
				});
				return true;
			}         
        },
        callback: function (form) {
        	if (!($("#verifyCode").attr("process") === undefined)) {
        		return false;
        	}
           $.ajax({//异步发送
                type: "post",
                url: $Url.BuildWWWUrl("customer/personalInfo/ajaxUpdateTelephone"),
                dataType: "json",
                timeout: 30000,
                data: {
                    tel: $String.Trim($("#tel").val()),
                    smsCaptcha:$("#smsCaptchatel").val()
                },
                beforeSend: function () {
                    $("#verifyCode").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    Base.Common.PromptText.systemError();
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                	if(data.message.type==MessageType.Info){
                		$("#editLoginPasswordDiv").hide();
                		window.location.reload()
                	}
                	if (data.message.type == MessageType.Warning){
                		$("#msg").addClass("Validform_wrong").html(data.message.description);
                	}
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#verifyCode").removeAttr("process");
                }
            });
            return false;
        }
    });
	AddTelephone.addRule([            
        {
            ele: "#tel",
            datatype: "verifyTelephone",
            //ignore: "ignore",
            nullmsg: "请输入手机号码",
            errormsg: "请输入正确的手机号码",
            sucmsg: " "
        },
        {
            ele: "#verifyCode",
            datatype: "/^[a-zA-Z0-9]{4}$/",
            //ignore: "ignore",
            nullmsg: "请输入验证码",
            errormsg: "请输入正确的验证码",
            sucmsg: " "
        }, 
		{				
		    ele:"#smsCaptchatel",
		    datatype:"verifySmsCaptchatel",//"/^[0-9]{6}$/",
		    //ignore:"ignore",
		    nullmsg:"请输入手机验证码",
		    errormsg:"请输入6位数字的手机验证码",
		    sucmsg:" "
		}
      
     ]);
	
	$("#authenticationTelOk").slideToggle();
    setTimeout(function(){
    	$("#authenticationTelOk").slideToggle();
    }, 3000);
	 $("#editTel").click(function(){
            $.ajax({
                type: "post",
                url: $Url.BuildWWWUrl("customer/personalInfo/ajaxUpdateMoblie"),
                dataType: "json",
                timeout: 30000,
                data: {
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                	//alert(errorThrown);
                },
                success: function (data) {
                	var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+"></form>";
                	$("body").first().append(paymentObj);
                	var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
                			"<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
                			$(".pay_data").html(input);		
                	$(".pay_data").submit();
                		
                },
                complete: function (XMLHttpRequest, textStatus) {
                }
            });
	 	});
});


var GetSmsCaptcha={
		getSmsCaptcha:function(){
			$("#getSmsCaptcha").click(function(){
				 if (!($("#verifyCode").attr("process") === undefined)) {
				         return false;
				     }
					 $.ajax({
				        type: "post",
				        url: $Url.BuildWWWUrl("/baseInfo/sms/ajaxAddSmsCaptcha"),
				        dataType: "json",
				        timeout: 30000,
				        data: {
				        	telephone:$String.Trim($("#tel").val()),
				        	verifyCode: $String.Trim($("#verifyCode").val())
				        },
				        beforeSend: function () {
				            $("#verifyCode").attr("process", "processing");
				        },
				        error: function (XMLHttpRequest, textStatus, errorThrown) {
				        	alert(errorThrown);
				        },
				        success: function (data) {
				        	if(data.errCode=="0000"){
				        		$("#msg").html("").hide();
				        		if(data.time==0){
				        			countdown=60;//60
				        		}else{
				        			countdown=60-data.time;
				        		}
				        	}else{
				        		countdown=0;
				        		$("#msg").addClass("Validform_wrong").html(data.errCode).show();
				        	}
				        	GetSmsCaptcha.settime(countdown);
				        },
				        complete: function (XMLHttpRequest, textStatus) {
				            $("#verifyCode").removeAttr("process");
				            }
				        });
					});
			
			
		},
		settime	: function (countdown){
			if (countdown == 0) {
				$("#getSmsCaptcha").removeAttr("disabled");
				$("#getSmsCaptcha").val("获取手机验证码");
				return;
			} else {
				$("#getSmsCaptcha").attr("disabled", true);
				$("#getSmsCaptcha").val("(" + countdown + ")后重新获取");
				countdown--;
			}
			setTimeout(function() {GetSmsCaptcha.settime(countdown)},1000)
			}	
}


$(function(){
	GetSmsCaptcha.getSmsCaptcha();
	var countdown=0;
	GetSmsCaptcha.settime(countdown);
/*	$("#getSmsCaptcha").click(function(){
	 if (!($("#verifyCode").attr("process") === undefined)) {
	         return false;
	     }
		 $.ajax({
	        type: "post",
	        url: $Url.BuildWWWUrl("/baseInfo/sms/ajaxAddSmsCaptcha"),
	        dataType: "json",
	        timeout: 30000,
	        data: {
	        	telephone:$String.Trim($("#tel").val()),
	        	verifyCode: $String.Trim($("#verifyCode").val())
	        },
	        beforeSend: function () {
	            $("#verifyCode").attr("process", "processing");
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	        	alert(errorThrown);
	        },
	        success: function (data) {
	        	if(data.errCode=="0000"){
	        		$("#msg").html("").hide();
	        		if(data.time==0){
	        			countdown=60;//60
	        		}else{
	        			countdown=60-data.time;
	        		}
	        	}else{
	        		countdown=0;
	        		$("#msg").addClass("Validform_wrong").html(data.errCode).show();
	        	}
	        	SmsCaptcha.settime();
	        },
	        complete: function (XMLHttpRequest, textStatus) {
	            $("#verifyCode").removeAttr("process");
	            }
	        });
		});*/
	/*var countdown;
	var SmsCaptcha = {
		settime	: function (){
			if (countdown == 0) {
				$("#getSmsCaptcha").removeAttr("disabled");
			$("#getSmsCaptcha").val("获取手机验证码");
			return;
		} else {$("#getSmsCaptcha").attr("disabled", true);
			$("#getSmsCaptcha").val("(" + countdown + ")后重新获取");
			countdown--;
		}
		setTimeout(function() {SmsCaptcha.settime()},1000)
		}
	}*/

});
//重置交易密码
$(document).ready(function () {
	/*if($("#authenticationResetPwdOk").length>0){
		$("#authenticationResetPwdOk").show();
		setTimeout(function(){
			$("#authenticationResetPwdOk").hide();
		}, 3000);
	}*/
	 $("#addPwd").click(function(){alert("实名认证后即可设置交易密码！")});
	 $("#tradePwd").click(function(){
             $.ajax({
                 type: "post",
                 url: $Url.BuildWWWUrl("customer/personalInfo/ajaxUpdatePwd"),
                 dataType: "json",
                 timeout: 30000,
                 data: {
                 },
                 error: function (XMLHttpRequest, textStatus, errorThrown) {
                 	//alert(errorThrown);
                 },
                 success: function (data) {
                 	if(data.message.type==MessageType.Info){
                 		$(".msg").html("<font color='green'>"+data.message.description+"</font>");
                 		var returnUrl = $("#returnUrl").html();
                     	if(returnUrl!=""){
                     		window.location.href = returnUrl;
                     	}
                 	}
                 	if(data.message.type==MessageType.Warning){
                 		$(".card").html("<font color='red'>"+data.message.description+"</font>");
                 	}   
                 	var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+"></form>";
                 	$("body").first().append(paymentObj);
                 	var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
                 			"<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
                 			$(".pay_data").html(input);		
                 	$(".pay_data").submit();
                 		
                 },
                 complete: function (XMLHttpRequest, textStatus) {
                 }
             });
	 	});
     });
//实名认证js
$(document).ready(function () {
	$("#authenticationRealNameOk").show();
    setTimeout(function(){
    	$("#authenticationRealNameOk").hide();
    }, 3000);
	 $("#realNameAut").click(function(){
		alert("实名认证前请先完成邮箱与手机号的认证！");
      });
       var realnameAuthentication = $("#realnameAuthenticationFrom").Validform({
           tiptype:2,
           datatype:{
				"verifySmsCaptcha": function (gets, obj, curform, datatype) {
					//$(".VerCodeTips1").hide();
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
							telephone:$String.Trim($("#tel").val()),
			                smsCaptcha:$String.Trim(gets)
						},
						success: function (data, textStatus) {
							if(data.errCode!="0000"){
								//$(".VerCodeTips1").show();
								//$("#msg").html(data.errCode);
								return data.errCode;
							}else{
								
								return true;
							}
						}
					});
				},
		       "verifyCode": function (gets, obj, curform, datatype) {
		    	   //$(".VerCodeTips1").hide();
		    	   var reg=/^[a-zA-Z0-9]{4}$/;
		    	   if (!reg.test(gets)){
		    		   return false;
		    	   }
		    	   GetSmsCaptcha.getSmsCaptcha();
		       }
           },
           callback: function (form) {
               if (!($("#realname").attr("process") === undefined)) {
                   return false;
               }
               var customer ={realname:$String.Trim($("#realName").val()),
               		cardNumber:$String.Trim($("#cardNumber").val())
               		}
               $.ajax({
                   type: "post",
                   url: $Url.BuildWWWUrl("customer/personalInfo/ajaxPersonalInfo"),
                   dataType: "json",
                   timeout: 30000,
                   data: {
                   	p2pCustomer: JSON.stringify(customer)
                   },
                   beforeSend: function () {
                       $("#realName").attr("process", "processing");
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                   	//alert(errorThrown);
                   },
                   success: function (data) {
                   	if(data.message.type==MessageType.Info){
                   		$("#authenticationNameOk").show();
                        setTimeout(function(){
                        	$("#authenticationNameOk").hide();
                        }, 3000);
                   		var returnUrl = $("#returnUrl").html();
                       	if(returnUrl!=""){
                       		window.location.href = returnUrl;
                       	}
                   	}
                   	if(data.message.type==MessageType.Warning){
                   		$(".card").html("<font color='red'>"+data.message.description+"</font>");
                   	}   
                   	var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+" method=\"post\"></form>";
                   	$("body").first().append(paymentObj);
                   	var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
                   			"<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
                   			$(".pay_data").html(input);		
                   	$(".pay_data").submit();
                   		
                   },
                   complete: function (XMLHttpRequest, textStatus) {
                       $("#realName").removeAttr("process");
                   }
               });

               return false;
           }
       });

       realnameAuthentication.addRule([
           {
           	 ele: "#cardNumber",
                datatype: "idcard",//idcardTest|
                //ignore: "ignore",
                nullmsg: "请填写二代身份证信息",
                errormsg: "请输入正确的身份证号",
                sucmsg: " "
           	 
           },
           {
           ele: "#realName",
           datatype: "/^[\u4e00-\u9fa5]{2,4}$/",
           //ignore: "ignore",
           nullmsg: "请填写中文名",
           errormsg: "请输入2到4个中文字符",
           sucmsg: " "
   		},
   		{
            ele: "#verifyCode",
            datatype: "verifyCode",
            //ignore: "ignore",
            nullmsg: "请输入图形验证码",
            errormsg: "请输入正确的图形验证码",
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
});

//邮箱js安全绑定,修改
$(document).ready(function () {
	/*$("#updateEmail").click(function(){
	    alert("提示：\n        修改邮箱需要用户发送彩色手持身份证照【身份证要求清晰】和用户彩色半身照到\n邮箱：hzjk@bestinvestor.com.cn中，审核通过后变更！");
	});*/
	$("#editEmail").click(function(){
		$("#verifyEmailMind").slideToggle("slow",function(){
			if($(this).is(":hidden"))
				$("#editEmail").text("修改");
			else $("#editEmail").text("取消修改");
		});
	});
	/*$("#editEmail").click(function(){
		$("#verifyEmailMind").slideToggle("slow",function(){
			if($(this).is(":hidden"))
				$("#editEmail").text("修改");
			else $("#editEmail").text("取消修改");
		});
	});*/
	$("#verifyEmail").click(function(){
		$("#editEmailDiv").slideToggle("slow",function(){
			if($(this).is(":hidden"))
				$("#verifyEmail").text("认证");
			else $("#verifyEmail").text("取消认证");
		});
	});
	
	//第一种情况
	  if ($("#valEmail").length > 0) {
	      var valEmail = $("#valEmail").Validform({
	          tiptype: function(msg,o,cssctl){
	        	  if(msg!=" ")
	        		  $("#reSendMsg").html("").css({"color":"red"}).html(msg);
	          },
	          /*usePlugin: {
	              passwordstrength: {
	                  minLen: 6,
	                  maxLen: 20
	              }
	          },*/
	          //ignoreHidden:true,
	          datatype: {
	              "verifyEmail": function (gets, obj, curform, datatype) {
	            	  var reg=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	                  if (!reg.test(gets)){
	                      return false;
	                  }
	                  var url = $Url.BuildWWWUrl("/customer/register/ajaxCheckEmailExist");
	                  $.ajax({
	                      type: "get",
	                      url: url,
	                      dataType: "json",
	                      async:false,
	                      data: { email: $String.Trim(gets) },
	                      success: function (data) {
	                          if (data.message.type == MessageType.Warning){
	                        	  $("#reSendMsg").html("").css({"color":"red"}).html(data.message.description);
	                        	  return false;
	                          }else{
	                        	  return true;
	                          }
	                      }
	                  });
	              }
	          },
	          callback:function(form){
	        	  if (!($("#valEmailBtn").attr("process") === undefined)) {
	                   return false;
	               }
	        	  var customer ={ 
            		  email:$String.Trim($("#email").val())
                  }
                  $.ajax({
                      type: "post",
                      url: $Url.BuildWWWUrl("customer/register/ajaxRegEmail"),
                      dataType: "json",
                      timeout: 30000,
                      data: {
                      	p2pCustomer: JSON.stringify(customer)
                      },
                      beforeSend: function () {
                          $("#valEmailBtn").attr("process", "processing");
                      },
                      error: function (XMLHttpRequest, textStatus, errorThrown) {
                      	//alert(errorThrown);
                      },
                      success: function (data) {
                      	if(data.message.type==MessageType.Info){
                      		$("#reSendMsg").html("").css({"color":"green"}).html(data.message.description);
                      		$("#valEmailBtn").val("重新发送");
                      	}
                      	if(data.message.type==MessageType.Warning){
                      		$("#reSendMsg").html("").css({"color":"red"}).html(data.message.description);
                      	}   
                      		
                      },
                      complete: function (XMLHttpRequest, textStatus) {
                          $("#valEmailBtn").removeAttr("process");
                      }
                  });
	        	  return false;
	          }
	      });
	
	      valEmail.addRule([
	          {
	        	  ele: "#email",
	              datatype: "verifyEmail",
	              //ignore: "ignore",
	              nullmsg: "请填写邮箱",
	              errormsg: "请输入正确的邮箱",
	              sucmsg: " "
	          	 
	          }
	      ]);
	  }
	  //第二种情况
	  if ($("#remindEmail").length > 0) {
		  var valEmail = $("#remindEmail").Validform({
			  tiptype: function(msg,o,cssctl){
				  if(msg!=" ")
					  $("#reSendMsg").html("").css({"color":"red"}).html(msg);
			  },
			  datatype: {
			  },
			  callback:function(form){
				  if (!($("#valEmailBtn").attr("process") === undefined)) {
					  return false;
				  }
				  $.ajax({
					  type: "post",
					  url: $Url.BuildWWWUrl("customer/register/ajaxRemindEmail"),
					  dataType: "json",
					  timeout: 30000,
					  data: {
					  },
					  beforeSend: function () {
						  $("#valEmailBtn").attr("process", "processing");
					  },
					  error: function (XMLHttpRequest, textStatus, errorThrown) {
						  //alert(errorThrown);
					  },
					  success: function (data) {
						  if(data.message.type==MessageType.Info){
							  $("#reSendMsg").html("").css({"color":"green"}).html(data.message.description);
							  $("#valEmailBtn").val("重新提醒");
							  
						  }
						  if(data.message.type==MessageType.Warning){
							  $("#reSendMsg").html("").css({"color":"red"}).html(data.message.description);
						  }   
						  
					  },
					  complete: function (XMLHttpRequest, textStatus) {
						  $("#valEmailBtn").removeAttr("process");
					  }
				  });
				  return false;
			  }
		  });
		  
		  /*
		   * 取消审核
		  $("#cancle").click(function(){
			  if(confirm("确定取消审核？")){
				  $.ajax({
					  type:"post",
					  url:$Url.BuildWWWUrl("/customer/paymentAccountSecurity/ajaxCancleEmailExamine"),
					  dataType:"json",
					  timeout:30000,
					  data:{
						  newEmail:$("#email").val()
					  },
					  beforeSend: function() {
						  $(this).attr("process","processing");
					  },
					  error: function(XMLHttpRequest, textStatus, errorThrown) {},
					  success: function(data) {
						  if(data.message.type==MessageType.Info){
							  alert(data.message.description);
							  setTimeout(function(){window.location.reload();}, 0000);
						  }
						  if(data.message.type==MessageType.Warning){
							  alert(data.message.description);
						  } 
					  },
					  complete: function() {
						  $(this).removeAttr("process");
					  }
				  });
			  }
		  });
		  
		  //修改审核邮箱
		  $("#update").click(function(){
			  if(confirm("确定修改正在审核的邮箱？")){
				  $("#valEmailBtn").hide();
				  $("#mind").hide();
				  $("#emailTitle").html("请输入新邮箱：");
				  $("#email").removeAttr("disabled");
				  $("#updateEmailBtn").show();
				  $("#updateEmailBtn").click(function(){
					  $.ajax({
						  type:"post",
						  url:$Url.BuildWWWUrl("/customer/paymentAccountSecurity/ajaxupdateExamineEmail"),
						  dataType:"json",
						  timeout:30000,
						  data:{
							  newEmail:$("#email").val()
						  },
						  beforeSend: function() {
							  $(this).attr("process","processing");
						  },
						  error: function(XMLHttpRequest, textStatus, errorThrown) {},
						  success: function(data) {
							  if(data.message.type==MessageType.Info){
								  $("#reSendMsg").html("").css({"color":"green"}).html(data.message.description);
								  //setTimeout(function(){window.location.reload();}, 0000);
							  }
							  if(data.message.type==MessageType.Warning){
								  $("#reSendMsg").html("").css({"color":"red"}).html(data.message.description);
							  } 
						  },
						  complete: function() {
							  $(this).removeAttr("process");
						  }
					  });
				  });
			  }
		  });*/
		  
	  }
	  //第三种情况
	  if($("#editEmailForm").length>0){
		  var editEmail = $("#editEmailForm").Validform({
	          tiptype: function(msg,o,cssctl){
	        	  if(msg!=" "){
	        		  $("#editEmailMsg").html("").css({"color":"red"}).html(msg);
	        	  }
	          },
	          datatype: {
	              "verifyOldEmail": function (gets, obj, curform, datatype) {
	            	  if(gets==""){
	            		  $("#editEmailMsg").html("请填写原邮箱").css({"color":"red"});
	            		  return false;
	            	  }
	            	  var reg=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	                  if (!reg.test(gets)){
	                      return false;
	                  }
	                  var url = $Url.BuildWWWUrl("/customer/paymentAccountSecurity/ajaxCheckOldEmailExist");
	                  $.ajax({
	                      type: "get",
	                      url: url,
	                      dataType: "json",
	                      async:false,
	                      data: { oldEmail: $String.Trim(gets) },
	                      success: function (data) {
	                          if (data.message.type == MessageType.Warning){
	                        	  $("#editEmailMsg").html("").css({"color":"red"}).html(data.message.description);
	                        	  return false;
	                          }else{
	                        	  $("#editEmailMsg").html("").css({"color":"red"});
	                        	  return true;
	                          }
	                      }
	                  });
	              },
	              "verifyNewEmail": function (gets, obj, curform, datatype) {
	            	  if(gets==""){
	            		  $("#editEmailMsg").html("请填写新邮箱").css({"color":"red"});
	            		  return false;
	            	  }
	            	  var reg=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	                  if (!reg.test(gets)){
	                      return false;
	                  }
	                  var url = $Url.BuildWWWUrl("/customer/paymentAccountSecurity/ajaxCheckNewEmailExist");
	                  $.ajax({
	                      type: "get",
	                      url: url,
	                      dataType: "json",
	                      async:false,
	                      data: { newEmail: $String.Trim(gets) },
	                      success: function (data) {
	                          if (data.message.type == MessageType.Warning){
	                        	  $("#editEmailMsg").html("").css({"color":"red"}).html(data.message.description)
	                        	  return false;
	                          }else{
	                        	  $("#editEmailMsg").html("").css({"color":"red"});
	                        	  return true;
	                          }
	                      }
	                  });
	              },
	              "verifyCardPath":function (gets, obj, curform, datatype){
	            	  if(gets==""){
	            		  $("#editEmailMsg").html("请上传身份证照片").css({"color":"red"});
	            		  return false;
	            	  }
	            	  var reg=/^(\/+\w+)*(.gif|.jpg|.jpeg|.GIF|.JPG|.JPEG|.png)$/;
	            	  if (!reg.test(gets)){
	            		  $("#editEmailMsg").html("").css({"color":"red"}).html("请上传正确格式的身份证照片");
	                      return false;
	                  }
	            	  return true;
	              },
	              "verifyPortraitPath":function (gets, obj, curform, datatype){
	            	  if(gets==""){
	            		  $("#editEmailMsg").html("请上传头像").css({"color":"red"});
	            		  return false;
	            	  }
	            	  var reg=/^(\/+\w+)*(.gif|.jpg|.jpeg|.GIF|.JPG|.JPEG|.png)$/;
	            	  if (!reg.test(gets)){
	            		  $("#editEmailMsg").html("").css({"color":"red"}).html("请上传正确格式的头像");
	                      return false;
	                  }
	            	  return true;
	              }
	          },
	          callback:function(form){
	        	  if(!confirm("您的新邮箱为："+$("#newEmail").val()+" ？")){
	        		  return false;
	        	  }
	        	  if (!($("#editEmailSubmit").attr("process") === undefined)) {
	                  return false;
	              }
                  $.ajax({
                      type: "post",
                      url: $Url.BuildWWWUrl("/customer/paymentAccountSecurity/ajaxEditEmail"),
                      dataType: "json",
                      timeout: 30000,
                      data: {
                    	  oldEmail: $("#oldEmail").val(),
                    	  newEmail: $("#newEmail").val(),
                    	  cardPath:	$("#cardPath").val(),
                    	  portraitPath:	$("#portraitPath").val()
                      },
                      beforeSend: function () {
                          $("#editEmailSubmit").attr("process", "processing");
                      },
                      error: function (XMLHttpRequest, textStatus, errorThrown) {
                      	//alert(errorThrown);
                      },
                      success: function (data) {
                      	if(data.message.type==MessageType.Info){
                      		//$("#showEmail").html(data.showEmail);
                      		$("#editEmailDiv").hide();
                      		//$("#editEmailMsg").html("").css({"color":"green"}).html(data.message.description);
                      		$("#verifyEmailSuccessDiv").show();
                      		//$("#showVerifyEmail").html(data.message.description);
                      		setTimeout(function(){window.location.reload();}, 3000);
                      	}
                      	if(data.message.type==MessageType.Warning){
                      		$("#editEmailMsg").html("").css({"color":"red"}).html(data.message.description);
                      	}   
                      },
                      complete: function (XMLHttpRequest, textStatus) {
                          $("#editEmailSubmit").removeAttr("process");
                      }
                  });
	        	  return false;
	          }
	      });
	
		  editEmail.addRule([
	          {
	        	  ele: "#oldEmail",
	              datatype: "verifyOldEmail",
	              //ignore: "ignore",
	              nullmsg: "请填写原邮箱",
	              errormsg: "请输入正确的原邮箱",
	              sucmsg: " "
	          	 
	          },
	          {
	        	  ele: "#newEmail",
	        	  datatype: "verifyNewEmail",
	        	  //ignore: "ignore",
	        	  nullmsg: "请填写新邮箱",
	        	  errormsg: "请输入正确的新邮箱",
	        	  sucmsg: " "
	        		  
	          },
	          {
	        	  ele: "#cardPath",
	        	  datatype: "/^(\\/+\\w+)*(.gif|.jpg|.jpeg|.GIF|.JPG|.JPEG|.png)$/",
	        	  //ignore: "ignore",
	        	  nullmsg: "请上传身份证照片",
	        	  errormsg: "请上传正确格式的身份证照片",
	        	  sucmsg: " "
	          },
	          {
	        	  ele: "#portraitPath",
	        	  datatype: "/^(\\/+\\w+)*(.gif|.jpg|.jpeg|.GIF|.JPG|.JPEG|.png)$/",
	        	  //ignore: "ignore",
	        	  nullmsg: "请上传头像",
	        	  errormsg: "请上传正确格式的头像",
	        	  sucmsg: " "
	          }
	      ]);
	  }
});

var PaymentAccountSecurity ={
		editLoginPasswordBut:function(obj){
			if(obj.html()=="修改"){
				obj.html("取消修改")
			}else{
				obj.html("修改")
			}
			$(".Validform_checktip").html("");
			$("#oldPwd").val("");
        	$("#pwd").val("");
        	$("#rePwd").val("");
			/*alert($("#editPasswordFrom input[type=pwd]").length)
        	$(".editPasswordFrom > input").val("");*/
		},
		setLoginPasswordBut:function(obj){
			if(obj.html()=="设置密码"){
				obj.html("取消设置")
			}else{ 
				obj.html("设置密码")
			}
			$(".Validform_checktip").html("");
			$("#pwd2").val("");
			$("#rePwd2").val("");
			/*alert($("#editPasswordFrom input[type=pwd]").length)
        	$(".editPasswordFrom > input").val("");*/
		},
		realnameAuthenticationBut:function(obj){
			if(obj.html()=="认证"){
				obj.html("取消认证")
			}else{
				obj.html("认证")
			}
			$(".Validform_checktip").html("");
			$("#realName").val("");
        	$("#cardNumber").val("");
        	$("#verifyCode").val("");
        	$("#smsCaptcha").val("");
			
		},
		addTelephoneBut:function(obj){
			if(obj.html()=="添加"){
				obj.html("取消添加")
			}else{
				obj.html("添加")
			}
			$("#tel").val("");
        	$("#msg").val("");
        	$("#verifyCode").val("");
        	$("#smsCaptcha").val("");
		}
}

$(function(){
	if($("#pageAlias").val()=="paymentAccountSecurity"){
		$("#paymentAccountSecurity").attr("class", "active");
	}
	$("#editLoginPassword").click(function(){
		$("#editLoginPasswordDiv").slideToggle();
		PaymentAccountSecurity.editLoginPasswordBut($(this));
	});
	$("#setLoginPassword").click(function(){
		$("#setLoginPasswordDiv").slideToggle();
		PaymentAccountSecurity.setLoginPasswordBut($(this));
	});
	$("#open").click(function(){
		$("#realnameAuthenticationDiv").slideToggle();
		PaymentAccountSecurity.realnameAuthenticationBut($(this));
	});
	CardFileManage.BindFile();
	PortraitFileManage.BindFile();
});

var CardFileManage = {
    BindFile: function () {
        var readOnly = false;
        $("#cardPathUpload").Upload({
            inputID: "uploadInput1",
            readOnly: readOnly,
            multiple: false,
            fileType: 2,
            url: $Url.BuildWWWUrl("/upload.action"),
            success: CardFileManage.SaveFileToPage,
            title: "上传身份证照片"
        });
        //$("#uploadInput1").css({"width":'152px',"heigth":'56px',"position":"absolute","opacity":1});
        //$("#uploadInput").addClass("data");
    },
    SaveFileToPage: function (fileName, relativePath) {

    	CardFileManage.ShowPhoto($Url.BuildFileUrl(relativePath));
        $("#cardPath").val(relativePath);
    },
    ShowPhoto: function (path) {
        $("#cardPathImg").attr("src", path);
        //$("#aCardPath").attr("href", path);
    }
}
var PortraitFileManage = {
	BindFile: function () {
		var readOnly = false;
		$("#portraitPathUpload").Upload({
			inputID: "uploadInput2",
			readOnly: readOnly,
			multiple: false,
			fileType: 2,
			url: $Url.BuildWWWUrl("/upload.action"),
			success: PortraitFileManage.SaveFileToPage,
			title: "上传头像"
		});
		//$("#uploadInput2").val("上传头像");
		//$("#uploadInput").addClass("data");
	},
	SaveFileToPage: function (fileName, relativePath) {
		
		PortraitFileManage.ShowPhoto($Url.BuildFileUrl(relativePath));
		$("#portraitPath").val(relativePath);
	},
	ShowPhoto: function (path) {
		$("#portraitPathImg").attr("src", path);
		$("#aPortraitPath").attr("href", path);
	}
}


