var Bulletin = {
		GetBulletinList:function (pageIndex) {
			window.location.href=$("#pageUrl").val()+"&pageIndex="+(pageIndex+1);
			Bulletin.Paging();
	    },
	    Paging:function (pageIndex){
	        if($("#totalCount").html()!=0){
	    		$("#pagination").pagination($("#totalCount").html(), {//总记录条数
	    			callback: Bulletin.GetBulletinList,//每次点击分页按钮的时候 执行该操作
	    			items_per_page:8,//每页显示多少条记录
	    			current_page:pageIndex-1,//当前页
	    			link_to:"javascript:void(0)",//不期望链接到某个目的地，只希望执行回调函数
	    			num_display_entries:3,//显示几个页码
	    			next_text:"下一页",//下一页按钮显示的内容
	    			next_show_always:true,//如果没有下一页  仍然显示按钮  但是灰化 
	    			prev_text:"上一页",//上一页按钮显示的内容
	    			prev_show_always:true,//如果没有上一页  不显示按钮 
	    			num_edge_entries:1,//页码多的时候...省略
	    			ellipse_text:"..."
	    		});
	    	}
	    }
	}

	$(function () {
		$("#header").find("a").removeClass("active");
		$("#storeList").addClass("active");
		if($("#pageAlias").val()=="storeList"||$("#pageAlias").val()=="storeDetail"){
			$("#store").attr("class", "active");
		}
		if($("#pageAlias").val()=="storeDetail"){
			Banner.GetBanner($(".p2pBanner1"),2);
		}
		if($("#pageAlias").val()=="storeList"){
			Banner.GetBanner($(".p2pBanner1"),2);
			Bulletin.Paging(parseInt($("#pageIndex").val()));
			$("#allStoreList").find("a").each(function(){
				$(this).click(function(){
					window.location.href=$Url.BuildWWWUrl("customer/store/ajaxGetStore")+"?id="+$(this).attr("value")
				});
			});
		}
	 });