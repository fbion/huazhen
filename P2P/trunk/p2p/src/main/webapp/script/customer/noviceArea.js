var NoviceArea = {
	verifyMoney:function(){
		var flag = true;
		var money = $("#money").val().trim();
		if(money!=null&&money!=""){
			var regx = /^[1-9][0-9]{1,9}$/;
			if(!regx.test(money)){
				flag = false;
			}
			if(money%50!=0){
				flag = false;
			}
		}else{
			flag = false;
		}
		if(!flag){
			$("#error").show();
		}else{
			$("#error").hide();
		}
		return flag;
	},
	Count:function(){
		if(!NoviceArea.verifyMoney()){
			return;
		}
		var money = $("#money").val().trim();
		var month = $("#month").children(".selected").attr("data");
		$("#how").text(money+"元");
		$("#time").text(month+"个月");
		var count1 = parseInt(money)*0.35*parseInt(month)/12/100;
		var count2 = parseInt(money)*(5+parseInt(month)/3-1)/100*parseInt(month)/12;
		var count3 = parseInt(money)*(9+parseInt(month)/3-1)/100*parseInt(month)/12;
		var count = count1+count2+count3;
		$("#count1").text(count1.toFixed(2));
		$("#count2").text(count2.toFixed(2));
		$("#count3").text(count3.toFixed(2));
		$(".huoqi").css({height:count1/count*200+"px"});
		$(".baobao").css({height:count2/count*200+"px"});
		$(".rrd").css({height:count3/count*200+"px"});
		$(".huoqi label").css({"left":-$('#count1').width()/2+"px"});
		$(".baobao label").css({"left":-$('#count2').width()/2+"px"});
		$(".rrd label").css({"left":-$('#count3').width()/2+"px"});
	},
	KeyDown:function(event){
		if (event.keyCode == 13){
			NoviceArea.Count();
		}
	}
}

$(function(){
	NoviceArea.Count();
	if($("#scrollScreen").val()=="1")
		$('html,body').animate({scrollTop:$('.mainProduct').offset().top}, 800);
	$("#month").children("span").each(function(){
		$(this).click(function(){
			$("#month").children("span").removeClass("selected");
			$(this).addClass("selected");
		});
	});
	$("#count").click(function(){
		NoviceArea.Count();
	});
})