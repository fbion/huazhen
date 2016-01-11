var ManagePage = {
		InputFocus:function(){
			$("#name").focus(function(){
				$("#nameMsg").html("");
			}); 
			$("#telephone").focus(function(){
				$("#telMsg").html("");
			}); 
		},
		RegularExpName:function(){
			nameExp=/^[\u4e00-\u9fa5]{2,4}$/
				var name=$String.Trim($("#name").val());
				if(!nameExp.test(name)){
					$("#nameMsg").html("请输入正确的姓名！").css("color","red");
					return false;
				}else{
					$("#nameMsg").html("");
					return true;
				}
		},
		RegularExpTel:function(){
			var telephone=$String.Trim($("#telephone").val());
			telExp=/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/
			if(!telExp.test(telephone)||telephone.length!=11){
				$("#telMsg").html("请输入正确的手机号！").css("color","red");
				return false;
			}else{
				$("#telMsg").html("");
				return true;
			}
		},
		InputBlur:function(){
			$("#name").blur(function(){
				ManagePage.RegularExpName();
			}); 
			$("#telephone").blur(function(){
				ManagePage.RegularExpTel();
			}); 
		}
}
$(function () {	
	ManagePage.InputBlur();
	ManagePage.InputFocus();
	$("#submit").click(function(){
		if (!($("#submit").attr("process") === undefined)) {
			return false;
		}
		$.ajax({
			type: "post",
			url: $Url.BuildWWWUrl("activityUsers/ajaxActivityUsers"),
			dataType: "json",
			timeout: 30000,
			data: {
				openid:$("#openid").html(),
				nickname:$("#nickname").html(),
				headImgUrl:$("#headImgUrl").html(),
          		name:$String.Trim($("#name").val()),
          		telephone:$String.Trim($("#telephone").val()),
			},
			beforeSend: function () {
				$("#submit").attr("process", "processing");
				if(ManagePage.RegularExpName&&ManagePage.RegularExpTel()){
					return true;
				}else{
					return false;
				}
			},
			success: function (data) {
		        $('.informations').hide().next().show();
			},
			complete: function (XMLHttpRequest, textStatus) {
				$("#submit").removeAttr("process");
			}
		});
	});
});