var MoneyDetail = {
	GetMoneyDetailInner:function(){
		var url=$Url.BuildWWWUrl("/customer/moneyDetail/ajaxMoneyDetail");
		$.ajax({
			type: "post",
			url:url,
			dataTpye: "html",
			data:{displayType:$("#displayType").children(".active").attr("value") },
			success:function(data,textStatus){
				$("#moneyDetailCondiction").html(data);
				MoneyDetail.GetMoneyDetail(0);
			}
		});
	},	
    GetMoneyDetail: function (pageIndex) {
        var url=$Url.BuildWWWUrl("/customer/moneyDetail/ajaxMoneyDetailInner");
        
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                async:false,
                data: {
                	"pageIndex":pageIndex+1,
                	displayType:$("#displayType").children(".active").attr("value"),
                	productType:$("#productType").children(".active").attr("value"),
                	//p2pProductNo:$("#p2pProductNo").children(".active").attr("value"),
                	startTime:$("#startTime").val(),
                	endTime:$("#endTime").val()
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $("#moneyDetailInner").html(data);
                    if($("#totalCount").html()!=0){
                    	$("#pagination").pagination($("#totalCount").html(), {//总记录条数
                    		callback: MoneyDetail.GetMoneyDetail,//每次点击分页按钮的时候 执行该操作
                    		items_per_page:5,//每页显示多少条记录
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
                    MoneyDetail.InitDetail();
                }
            }
        )

    },
    InitDetail: function () {
    	$("#productType").children().each(function(i){
    		$(this).off().click(function(){
    			$("#productType").children().removeClass("active");
    			$(this).addClass("active");
    			MoneyDetail.GetMoneyDetail(0);
    		});
    	});
        /*$("#p2pProductNo").children().each(function(i){
        	$(this).off().click(function(){
        		$("#p2pProductNo").children().removeClass("active");
        		$(this).addClass("active");
        		MoneyDetail.GetMoneyDetail(0);
        	});
        });*/
        
        laydate.skin('dahong');
        $("#startTime").off().click(function(){
        	laydate(StartTime);	
         });
        $("#endTime").off().click(function(){
        	laydate(EndTime);	
        });
        $("#seach").off().click(function () {
	    	MoneyDetail.GetMoneyDetail(0);
        });
    }
}




var DateTool = {
	GetDateNow:function(){
		var finalTime= "";
		var tempTime = new Date();
		finalTime = tempTime.format("yyyy-MM-dd");
		return finalTime;
	}
}

var StartTime = {
	    elem: '#startTime',
	    format: 'YYYY-MM-DD',
	    min: '2000-01-01', //设定最小日期为当前日期 laydate.now()
	    max: '2099-06-16', //最大日期
	    istime: true,
	    istoday: false,
	    choose: function(datas){
	    	EndTime.min = datas; //开始日选好后，重置结束日的最小日期
	    	EndTime.start = datas //将结束日的初始值设定为开始日
	    }
};
var EndTime = {
	    elem: '#endTime',
	    format: 'YYYY-MM-DD',
	    min: DateTool.GetDateNow(),//laydate.now()
	    max: '2099-06-16',
	    istime: true,
	    istoday: false,
	    choose: function(datas){
	    	StartTime.max = datas; //结束日选好后，重置开始日的最大日期
	    }
};

/*
var BindMoneyChangeType={
		BindMoneyChangeType:function(){
			EnumList.GetEnumListToSelect($("#moneyChangeType"),"getMoneyChangeTypeAll",$Url.BuildWWWUrl("/common/enumList.action"));
		}
}
*/

$(function () {
	if($("#pageAlias").val()=="moneyDetail"){
		$("#moneyDetail").attr("class", "active");
	}
    MoneyDetail.GetMoneyDetailInner();
    $("a[name='moneyDetail']").each(function(){
    	$(this).click(function(){
    		MoneyDetail.GetMoneyDetailInner();
    	});
    });
 });