var countdown;
var ForgetPassword = {
	settimeToload	: function (){
		if (countdown == 0) {
			window.location.href =  $Url.BuildWWWUrl("/customer/login");
			return;
		} else {
			$("#second").html(countdown);
			countdown--;
		}
		setTimeout(function() {ForgetPassword.settimeToload()},1000);
	}	
};

$(document).ready(function () {

	if($("#second").length>0){
		countdown = parseInt($("#second").html());
		ForgetPassword.settimeToload();
	}
    if ($(".create_password").length > 0) {
        var sendMail = $(".create_password").Validform({
            tiptype:function(msg,o,cssctl){
	        	var objtip=$("#msg");
	        	cssctl(objtip,o.type);
	        	objtip.text(msg);
	        	if(""!=msg.trim())
	        		objtip.show();
	        	else 
	        		objtip.hide();
	        },
            datatype: {
                "verifyCustomerInfo": function (gets, obj, curform, datatype) {
                    var emailReg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                    var nameReg= /^(?!^\d+$)(?!^_+$)[0-9a-zA-Z_]{4,20}$/;
                    var cellphoneReg = /^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                    if (!nameReg.test(gets)&&!cellphoneReg.test(gets)&&!emailReg.test(gets)) {
                    	return false;
                    }
                    var result;
                    var url = $Url.BuildWWWUrl("/customer/forgetPassword/ajaxCheckCustomerInfoExist");
                    $.ajax({
                        type: "get",
                        url: url,
                        dataType: "json",
                        async: false,
                        data: { userInfo: $String.Trim(gets) },
                        success: function (data) {
                            if (data.message.type == MessageType.Info){
                            	$("#customerNo").val(data.cn);
                            	$("#customerInfo").val(data.ci);
                            	$("#t").val(data.t);
                            	return true;
                            }
                            if(data.message.type == MessageType.Error){
                            	result = data.message.description;
                            }
                        }
                    });
                    return result;
                }
            },
            callback: function (form) {
            	if (!($("#submit").attr("process") === undefined)) {
  	              return false;
            	}
  	          var url = $Url.BuildWWWUrl("/customer/forgetPassword/AjaxchooseWayPassword");
  	          $.ajax({
  	              type: "post",
  	              url: url,
  	              dataType: "json",
  	              timeout: 30000,
  	              data: {
  	            	  ci: $String.Trim($("#customerInfo").val()),
  		              cn: $String.Trim($("#customerNo").val()),
  		              t: $String.Trim($("#t").val()),
  		              verifyCode: $String.Trim($("#verifyCode").val())
  	              },
  	              beforeSend: function () {
  	                  $("#submit").attr("process", "processing");
  	              },
  	              error: function (XMLHttpRequest, textStatus, errorThrown) {
  	                  alert(errorThrown);
  	              },
  	              success: function (data, textStatus) {
  	            	if (data.message.type == MessageType.Error) {
  	            		$("#msg").html(data.message.description);
                        $("#verifyCode").val("");
                        $VerifyCode.refreshValidator('#imgVerifyCode', '#verifyCode'); 
                    }else{
  		                	window.location.href=data.cipherTextUrl;
  		             }
  	              },
  	              complete: function (XMLHttpRequest, textStatus) {
  	                  $("#submit").removeAttr("process");
  	              }
  	          });
  	          return false;
            }
        });

        sendMail.addRule([
            {
                ele: "#userInfo",
                datatype: "verifyCustomerInfo",
                //ignore: "ignore",
                nullmsg: "请填写账号",
                errormsg: "请输入正确的账号",
                sucmsg: " "
            },
            {
                ele: "#verifyCode",
                datatype: "captcha",
                //ignore: "ignore",
                nullmsg: "请输入验证码",
                errormsg: "请输入正确的验证码",
                sucmsg: " "
            }
        ]);
    }
    
    
    
});