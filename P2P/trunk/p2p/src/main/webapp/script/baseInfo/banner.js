var Banner = {
	GetBanner:function(obj,displayType,bannerCount,slide,btn){
		var url = $Url.BuildWWWUrl("/baseInfo/banner/getBanner");
		$.ajax({
			type: "post",
			url:url,
			dataTpye: "html",
			timeout: 30000,
			data:{
				pageType:$(".pageAlias").val(),
			    pageNo:$(".pageId").val(),
			    position:obj.attr("value"),
			    displayType:displayType,
			    bannerCount:bannerCount
			},
			success:function(data,textStatus){
				obj.html(data);
				if (slide != undefined && btn != undefined)
				diyou.use('fullSlide', function(dy) {
					dy.banner_slide(slide,btn);
				});
				//alert(obj.find("img"))/*.attr("class")*/
				LazyloadImg.LazyloadImg(obj.find("img"));
			}
		});
	},
	GetCollaborationBanner:function(obj,displayType,bannerCount){
		var url = $Url.BuildWWWUrl("/baseInfo/banner/getBanner");
		$.ajax({
			type: "post",
			url:url,
			dataTpye: "html",
			timeout: 30000,
			data:{
				pageType:$(".pageAlias").val(),
				pageNo:$(".pageId").val(),
				position:obj.attr("value"),
				displayType:displayType,
				bannerCount:bannerCount
			},
			success:function(data,textStatus){
				obj.html(data);
				IndexPage.PartnerScroll("#partnerSlider","p");
				//alert(obj.find("img").length)
				//LazyloadImg.LazyloadImg(obj.find("img"));
			/*	obj.find("img").lazyload({
					//effect:"fadeIn",
					threshold:100
				});*/
				$(".p2pBanner3").find("img").lazyload({
					//effect:"fadeIn",
					threshold:100
				});
				$(".p2pBanner4").find("img").lazyload({
					//effect:"fadeIn",
					threshold:100
				});
				//LazyloadImg.LazyloadImg();
			}
		});
	}
}
