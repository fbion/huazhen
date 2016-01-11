$(function() {
	$(".comConfirm_btn").on("click", function() {
		Login.loginSubmit();
	});
	$("#pwdRe").bind("keyup", function(e) {
		var e = e || event;
		var keycode = e.which || e.keyCode;
		if (keycode == 13) {
			Login.loginSubmit();
		}
	});
	$(".backHome_btn").on("click", function() {
//		window.location.href = $Url.BuildPermissionUrl("/index.action");
		$EasyUI.Close();
	});
	
});


var Login = {
    loginSubmit: function () {
        var url = $Url.BuildPermissionUrl('/permission/user/ajaxEditUserSelf.action');
        if($("#pwd").val() != $("#pwdRe").val()){
        	alert("两次密码输入不一致");
        	return false;
        }
        if($String.IsNullOrEmpty($("#pwd").val()) || $String.IsNullOrEmpty($("#pwdOld").val()) || $String.IsNullOrEmpty($("#pwdRe").val())){
        	alert("请输入完整的信息");
        	return false;
        }
        $.ajax({
                type: "POST",
                url: url,
                data: {
                    passwordOld: $("#pwdOld").val(),
                    password: $("#pwd").val(),
                    passwordRe:$("#pwdRe").val(),
                    oper:"edit"
                },
                error: function (request) {
                    alert(request);
                },
                success: function (data) {
//                    if (data.msg == ""||data.msg == null){
//                        window.location.href = $Url.BuildPermissionUrl("/index");
//                    }else{
//                    	if(data.msg == "<div style='color:green'>恭喜您密码修改成功！</div>"){
                	if (data.errDesc != ""&&data.errDesc != null){
                		alert(data.errDesc);
                		return false;
                	}
                	
                    		$("#checkPwd").text();
                        	$("#checkPwd").html("<div style='color:green'>恭喜您密码修改成功！</div>");
                    		$(".pr10").hide();
                    		$(".btn_style").hide();
                    		$(".pwd").hide();
//                    		var input =$("<input>");
//                    		input.attr({type:"button",value:"返回"});
//                    		input.addClass("btn_style");
//                    		$(".edit_passwordEdit").append(input);
//                    		input.click(function(){
//                    			window.location.href = "index.action";
//                    		});
//                    	}
      
//                    	else{
//                    		$("#checkPwd").text();
//                        	$("#checkPwd").html(data.msg);
//                    		$(".pwd").val("");
//                    	}
//                    }
                    	
                }
            }
        )
        return false;
    }
}

