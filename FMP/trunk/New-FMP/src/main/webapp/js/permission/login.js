//登陆页改变js计算元素在不同浏览器中居中显示
$(function(){
	$('#box').css({
		width: $(document).innerWidth(),
		height:$(document).innerHeight()
	});
	$('.wrapp').css({
		left:($(window).innerWidth() - $('.wrapp').outerWidth())/2,
		top:($(window).innerHeight() - $('.wrapp').outerHeight())/2 
	});
});
	
$(window).on('resize',function(){
	$('#box').css({
		width: $(document).innerWidth(),
		height:$(document).innerHeight()
	});

	$('.wrapp').css({
		left:($(window).innerWidth() - $('.wrapp').outerWidth())/2 + $(window).scrollLeft(),
		top:($(window).innerHeight() - $('.wrapp').outerHeight())/2 + $(window).scrollTop() 
	});
});
$(function() {
	$("#name").focus();
});
$(function() {
	$(".loginSubmit").on("click", function() {
		Login.loginSubmit();
	});
	$("#pwd").bind("keyup", function(e) {
		var e = e || event;
		var keycode = e.which || e.keyCode;
		if (keycode == 13) {
			Login.loginSubmit();
		}
	});
	$("#pwd").focus(function(){
		$("#error").hide();
	});
});


var Login = {
    loginSubmit: function () {
        var url = $Url.BuildNewIndexUrl('/loginSubmit.action');
        $.ajax({
                success: function (data) {
                    if (data.msg == ""){
                        if($("#redirectUrl").val() == "")
                            window.location.href = $Url.BuildNewIndexUrl("/main.action");
                        else
                            window.location.href = $("#redirectUrl").val();
                    }
                    else
                    $("#error").html(data.msg).show();
                },
                type: "POST",
                url: url,
                data: {
                    name: $("#name").val(),
                    password: $("#pwd").val()
                },
                error: function (request) {
                    //alert(request);

                }
            }
        )
        return false;
    }
}

