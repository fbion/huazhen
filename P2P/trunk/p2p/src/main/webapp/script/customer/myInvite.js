var Reservation = {
    GetReservation: function (pageIndex) {
        var url=$Url.BuildWWWUrl("customer/getInviteInfo");
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                	"pageIndex":pageIndex+1
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $("#reservation").html(data);
                    if($("#totalCount").html()!=0){
                    	
                    	$("#pagination").pagination($("#totalCount").html(), {//总记录条数
                    		callback: Reservation.GetReservation,//每次点击分页按钮的时候 执行该操作
                    		items_per_page:8,//每页显示多少条记录
                    		current_page:pageIndex,//当前页
                    		link_to:"javascript:void(0)",//不期望链接到某个目的地，只希望执行回调函数
                    		num_display_entries:2,//显示几个页码
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
        )

    }
}


$(function(){
	
	 Reservation.GetReservation(0);
	$("#xinlangUrl").click(function(){
		$.ajax({
			type: "post",
	       url: $Url.BuildWWWUrl("/customer/addSahreActivity"),
	       dataType: "json",
	       timeout: 30000,
	       data: {
	       },
	       success: function (data, textStatus) {
	    	   
	    	   
	       }
		});
	});
	var regurl = "customer/register?inviterNo="+$("#inviterNo").val()+","+$("#activityId").val();

    $("#qqZUrl").attr("href","http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url="+$Url.BuildWWWUrl(regurl)
    		+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融：");
    $("#tengxunUrl").attr("href","http://share.v.t.qq.com/index.php?c=share&a=index&url="+window.location.href+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融："
    		+$Url.BuildWWWUrl(regurl));
    $("#renrenUrl").attr("href","http://widget.renren.com/dialog/share?resourceUrl="+window.location.href+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融："
    		+$Url.BuildWWWUrl(regurl));
    $("#qqFUrl").attr("href","http://connect.qq.com/widget/shareqq/index.html?url="+window.location.href+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融："
    		+$Url.BuildWWWUrl(regurl));
    $("#feixinUrl").attr("href","http://i.feixin.10086.cn/apps/share/share?url="+window.location.href+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融："
    		+$Url.BuildWWWUrl(regurl));
    $("#xinlangUrl").attr("href","http://v.t.sina.com.cn/share/share.php?url="+window.location.href+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融："
    		+$Url.BuildWWWUrl(regurl));
    
    $('#weixinUrl').attr("src","http://qr.liantu.com/api.php?&bg=ffffff&fg=000000&&w=220&m=10&text="+$Url.BuildWWWUrl(regurl));
    $("#weixin").click(function(){
    	$("#weixinlayer").attr("style","display:block");
    });
    $("#winxinClose").click(function(){
		$("#weixinlayer").attr("style","display:none");
	});
    $("#shouhuUrl").attr("href","http://t.sohu.com/third/post.jsp?url="+window.location.href+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融："
    		+$Url.BuildWWWUrl(regurl));
    $("#kaixinUrl").attr("href","http://www.kaixin001.com/login/open_login.php?flag=1&url="+window.location.href+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融："
    		+$Url.BuildWWWUrl(regurl));
    $("#doubanUrl").attr("href","http://www.douban.com/share/service?href=&name="+window.location.href+"&title=（新人红包求带走）好友快注册，红包齐分享；华镇来理财，收益赚到嗨；——华镇社区金融："
    		+$Url.BuildWWWUrl(regurl));    
    
    

});



