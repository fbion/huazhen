var P2pProductList = {
	GetP2pProductList: function (pageIndex) {
		window.location.href=$("#pageUrl").val()+"&pageIndex="+(pageIndex+1);
	    P2pProductList.Paging();
    },
    Paging:function (pageIndex){
        if($("#totalCount").html()!=0){
    		$("#pagination").pagination($("#totalCount").html(), {//总记录条数
    			callback: P2pProductList.GetP2pProductList,//每次点击分页按钮的时候 执行该操作
    			items_per_page:5,//每页显示多少条记录
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
	P2pProductList.Paging(parseInt($("#pageIndex").val()));
	/*$('.investmentStateTitle li').click(function(){
		$('.investmentStateTitle li').removeClass("current");
		//$('.productList .investmentState').hide();
		$(this).addClass("current");
		$('.productList .investmentState').eq($(this).index('.investmentStateTitle li')).show();
	});*/
	var dom = "";
	for (var i = 1; i<3; i++) {
		dom = ".productState" + i + " a"; 
		productState(dom);
	};	
	function productState(a){
	//alert($('.productPeriod dd').find('a').length);
		$(a).click(function(){
			$(a).removeClass('selected');
			$(this).addClass('selected');
		});
    }
	
	if($("#byProductType").val()!=""&&$("#byProductType").val()!=null){
		$("#productType").children().each(function(){
			if($(this).attr("value")==$("#byProductType").val()){
				$(this).addClass("selected");
			}
		});
		//$("#productType").children("value="+$("#byProductType").val()).addClass("selected");
	}else{
		$("#productType").children().first().addClass("selected");
	}
	
	if($("#byStatus").val()=="20"){
		$("#status1").removeClass('current');
		$("#status2").addClass('current');
	}
	if($("#byStatus").val()=="40"){
		$("#status1").removeClass('current');
		$("#status3").addClass('current');
	}
	if($("#byStatus").val()=="50"){
		$("#status1").removeClass('current');
		$("#status4").addClass('current');
	}
	
	$(".sort").children("span").each(function(i){
		$(this).children("a").removeAttr("style");
		if(i==$("#sort").val()){
			$(this).children("a").css({color: "#e94a49"});
			if($("#sortByIncomeOn").val()=="true"||$("#sortByDurationOn").val()=="true")
				$(this).children("a").children("span").removeClass("on");
		}
	})
	
    if($("#byDuration").val()=="3"){
    	$("#state11").removeClass('selected');
    	$("#state12").addClass('selected');
    }
    if($("#byDuration").val()=="6"){
    	$("#state11").removeClass('selected');
    	$("#state13").addClass('selected');
    }
    if($("#byDuration").val()=="12"){
    	$("#state11").removeClass('selected');
    	$("#state14").addClass('selected');
    }
    if($("#byDuration").val()=="1000"){
    	$("#state11").removeClass('selected');
    	$("#state15").addClass('selected');
    }
    
    
    if($("#byIncome").val()=="7"){
    	$("#state21").removeClass('selected');
    	$("#state22").addClass('selected');
    }
    if($("#byIncome").val()=="12"){
    	$("#state21").removeClass('selected');
    	$("#state23").addClass('selected');
    }
    if($("#byIncome").val()=="15"){
    	$("#state21").removeClass('selected');
    	$("#state24").addClass('selected');
    }
    if($("#byIncome").val()=="1000"){
    	$("#state21").removeClass('selected');
    	$("#state25").addClass('selected');
    }
//	var pageIndex = 0;
//	P2pProductList.GetP2pProductList(pageIndex);
	
	/*$("#byStatus").val("");
	$("#status1").click(function(){
		$("#byStatus").val("");
		pageIndex = 0;
		P2pProductList.GetP2pProductList(pageIndex);
	});
	$("#status2").click(function(){
		$("#byStatus").val("20");
		pageIndex = 0;
		P2pProductList.GetP2pProductList(pageIndex);
	});
	$("#status3").click(function(){
		$("#byStatus").val("40");
		pageIndex = 0;
		P2pProductList.GetP2pProductList(pageIndex);
	});
	if($("#byStatus").val()==""){
		$("#status1").click();
	}
	if($("#byStatus").val()=="20"){
		$("#status2").click();
	}
	if($("#byStatus").val()=="40"){
		$("#status3").click();
	}
	
	$("#byDuration").val("");
	$("#byIncome").val("");
	$(".productState1").click(function(){
		$(this).find()
	});
	
	for(var i=1;i<6;i++){
		$("#state1"+i).click(function(){
			$("#byDuration").val($(this).html());
			pageIndex = 0;
			P2pProductList.GetP2pProductList(pageIndex);
		});
		$("#state2"+i).click(function(){
			$("#byIncome").val($(this).html());
			pageIndex = 0;
			P2pProductList.GetP2pProductList(pageIndex);
		});
	}
	
	$("#orderByIncome").val("");
	$("#sortIncomeUp").click(function(){
		$("#orderByIncome").val("asc");
		pageIndex = 0;
		P2pProductList.GetP2pProductList(pageIndex);
	});
	$("#sortIncomeDown").click(function(){
		$("#orderByIncome").val("desc");
		pageIndex = 0;
		P2pProductList.GetP2pProductList(pageIndex);
	});
	
	$("#orderByDuration").val("");
	$("#sortDurationUp").click(function(){
		$("#orderByDuration").val("asc");
		pageIndex = 0;
		P2pProductList.GetP2pProductList(pageIndex);
	});
	$("#sortDurationDown").click(function(){
		$("#orderByDuration").val("desc");
		pageIndex = 0;
		P2pProductList.GetP2pProductList(pageIndex);
	});*/
    Banner.GetBanner($(".p2pBanner1"),2);
 });
