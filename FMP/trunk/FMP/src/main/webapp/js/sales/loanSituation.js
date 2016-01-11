var ManagePage = {
		readyProfitFunction:function(){

			var arr = new Array();
			var laber = $("#tableDitales .trDitales");
			var labers = laber.children();
		    for(var i=0;i<labers.length;i++){
		    	if(i%2==0 && i%4!=0){
		    		if(i==2){
		    			labers.eq(i).text(parseFloat(labers.eq(i-1).text()).toFixed(2));
		    		}else{
		    			var profitText=parseFloat(labers.eq(i-1).text())+parseFloat(labers.eq(i-4).text());
		    			labers.eq(i).text(profitText.toFixed(2));
		    		}
		    	}
		    	if(i%4==3){
		    		var salesText=parseFloat($("#salesMoneyTd").text())+parseFloat(labers.eq(i-1).text());
		    		labers.eq(i).text(salesText.toFixed(2));
		    	}
		    	if(i%4==1){
		    		labers.eq(i).text(parseFloat(labers.eq(i).text()).toFixed(2));
		    	}
		    } 

		},
		HandleXiaoshu:function(){
			$("#salesMoneyTd").text(parseFloat($("#salesMoneyTd").text()).toFixed(2));
			$("#incomeTd").text(parseFloat($("#incomeTd").text()).toFixed(0)+"%");
		}
};
$(function () {
	$("#title").attr("src",$Url.BuildImgUrl("/picv.jpg"));
	ManagePage.readyProfitFunction();
	ManagePage.HandleXiaoshu();
	var datePurch=("86"+$("#purchDateTemp").text().substring(2)).replace(/\-/g,"");
	$("#purchDateTemp").text(datePurch);
	var obj = $("#tableDitales").find("td").last();
	obj.html($("#sumprofits").text());
})