var Investment = {
		GetInvestment: function (pageIndex) {
        var url=$Url.BuildWWWUrl("customer/investment/investment");
        $.ajax({
                type: "POST",
                url: url,
                dataType: "html",
                data: {
                	pageIndex:pageIndex+1,
                	productType:$("#productType").children(".active").attr("value"),
                	//p2pProductNo:p2pProductNo,
                	statusStr:$("#statusStr").children(".active").attr("value")
                },
                error: function (request) {
                    //alert(request);
                },
                success: function (data) {
                    $("#investment").html(data);
                    if($("#totalCount").html()!=0){
                		$("#pagination").pagination($("#totalCount").html(), {//总记录条数
                			callback: Investment.GetInvestment,//每次点击分页按钮的时候 执行该操作
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
                   /* $(".tradeRecord li i").click(function(){
                  	  $(this).toggleClass("on");
                  	  $(this).parent().parent().find('.repayDetails').slideToggle();
                  	});*/
                }
            })

    }
}
$(function () {
	Investment.GetInvestment(0);
	if($("#pageAlias").val()=="myInvestment"){
		$("#myInvestment").attr("class", "active");
	}
	
	/*$("#productType").children().removeClass("active");
	$("#productType").children().each(function(i){
		if($("#hProductType").val()==$(this).attr("value")) {
			$(this).addClass("active");
			alert($("#hProductType").val()==$(this).attr("value"));
		}
	});*/
	$("#productType").children().each(function(i){
		$(this).click(function(){
			$("#productType").children().removeClass("active");
			$(this).addClass("active");
			Investment.GetInvestment(0)
		});
	});
	/*$("#p2pProductNo").children().each(function(i){
		$(this).click(function(){
			$("#p2pProductNo").children().removeClass("active");
			$(this).addClass("active");
			Investment.GetInvestment(0,$(this).attr("value"),$("#investStatus").children(".active").attr("value"))
		});
	});*/
	$("#statusStr").children().each(function(i){
		$(this).click(function(){
			$("#statusStr").children().removeClass("active");
			$(this).addClass("active");
			Investment.GetInvestment(0)
		});
	});
	
 });
