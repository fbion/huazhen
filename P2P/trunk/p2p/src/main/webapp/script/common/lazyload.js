/*
$(window).load(function(){
	$("img").lazyload({
		effect:"fadeIn",
		threshold:100
	});
	$(".next").click(function(){  
		setTimeout('$("#partnerSlider").trigger("scroll")',400)
	});
	$(".prev").click(function(){  
		setTimeout('$("#partnerSlider").trigger("scroll")',400)
	});
});*/

var LazyloadImg = {
		LazyloadImg:function(obj){
			obj.lazyload({
				//effect:"fadeIn",
				threshold:100
			});
//			$(".next").click(function(){  
//				setTimeout('$("#partnerSlider").trigger("scroll")',400)
//			});
//			$(".prev").click(function(){  
//				setTimeout('$("#partnerSlider").trigger("scroll")',400)
//			});
			$(document).click(function(){  
				setTimeout('$("#partnerSlider").trigger("scroll")',400)
			});
		}
}