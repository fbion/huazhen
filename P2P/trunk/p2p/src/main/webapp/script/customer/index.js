var IndexPage = {
		PartnerScroll:function(slider,ctrl){
			var MAX = 12,
			Slider = $(slider),
			/*Width = Slider.width(),*/
			Width = 1099,
			Ctrl = $(ctrl),
			Prev = Ctrl.find(".prev"),
			Next = Ctrl.find(".next"),
			len = Slider.find("a").length,
			click = true;
			if(len > MAX){
				Ctrl.show();
				var Multiple = len % MAX == 0 ? len / MAX : parseInt(len / MAX) + 1;			
				for(var i = 0;i < Multiple;i++){
					Slider.find(">a:lt("+ MAX +")").wrapAll("<li>");
				}
				Slider.find(">li").width(Width).wrapAll("<ul>");
				var List = Slider.find(">ul");
				List.width(Width * Multiple * 2).find(">li").clone().prependTo(List);
				
				//左移
				var left = 0;
				Prev.on("click",function(){			
					if(click){
						if(Math.abs(List.position().left) == 0){
							left = -Multiple * Width;
							List.css("left", left);					
						}
						left += Width;
						List.stop(true).animate({"left":left},800,function(){
							click = true;
						});	
					}
					click = false;
				});
				
				//右移
				Next.on("click",function(){
					if(click){
						var _t = $(this);				
						if(Math.abs(List.position().left) == (Multiple) * Width){
							left = 0;
							List.css("left", left);
						}
						left -= Width;
						List.stop(true).animate({"left":left},800,function(){
							click = true;
						});	
					}
					click = false;			
				});
			}

		}
}

$(function(){
	Banner.GetBanner($(".p2pBanner1"),1,3,'banner_slide', 'banner_btn');//轮播图
	Banner.GetBanner($(".p2pBanner2"),2);//首页中部
	Banner.GetCollaborationBanner($(".p2pBanner3"),4,12);//机构图
	Banner.GetCollaborationBanner($(".p2pBanner4"),4,12);
	/*Banner.GetBanner($(".p2pBanner5"),4,6);//机构图
	Banner.GetBanner($(".p2pBanner6"),5,6);*/
	Banner.GetBanner($(".p2pBanner7"),2);//热门产品
	
});