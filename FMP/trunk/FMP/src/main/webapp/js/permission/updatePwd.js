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
		window.location.href = $Url.BuildLoginUrl("/index.action");
	});
	
});


var Login = {
    loginSubmit: function () {
        var url = $Url.BuildLoginUrl('/updatePwdSubmit.action');
        $.ajax({
                type: "POST",
                url: url,
                data: {
                    passwordOld: $("#pwdOld").val(),
                    password: $("#pwd").val(),
                    passwordRe:$("#pwdRe").val()
                },
                error: function (request) {
                    alert(request);
                },
                success: function (data) {
                    if (data.msg == ""||data.msg == null){
                        window.location.href = $Url.BuildLoginUrl("/index");
                    }else{
                    	if(data.msg == "<div style='color:green'>恭喜您密码修改成功！</div>"){
                    		$("#checkPwd").text();
                        	$("#checkPwd").html(data.msg);
                    		$(".pr10").hide();
                    		$(".btn_style").hide();
                    		$(".pwd").hide();
                    		var input =$("<input>");
                    		input.attr({type:"button",value:"返回"});
                    		input.addClass("btn_style");
                    		$(".edit_passwordEdit").append(input);
                    		input.click(function(){
                    			window.location.href = "index.action";
                    		});
                    	}
      
                    	else{
                    		$("#checkPwd").text();
                        	$("#checkPwd").html(data.msg);
                    		$(".pwd").val("");
                    	}
                    }
                    	
                }
            }
        )
        return false;
    }
}

