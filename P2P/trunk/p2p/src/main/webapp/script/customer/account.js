var CheckElement ={
		ckeckLogoElement:function(){
			var ckeckLogoElement = $("li[zorro='zorroLogo']");
			ckeckLogoElement.each(function(){
				if ( $(this).attr("value")=="1") {
					var temp = $(this).attr("class");
					$(this).attr("class",temp+"s");
				}
				}); 
		},
		ckeckElement:function(){
			var ckeckElement = $("i[zorro='zorro']");
			ckeckElement.each(function(){
				if ( $(this).attr("value")=="0") {
					$(this).attr("class","wrong");
					
				}else{
					$(this).removeAttr("class");
				}
				}); 
		}
}
var Account = {
		getBalanceInfo: function () {
	        var url=$Url.BuildWWWUrl("customer/account/ajaxGetBalanceInfo");
	        $.ajax({
                type: "POST",
                url: url,
                dataType: "json",
                error: function (request) {
                    // alert(request);
                },
                success: function (data) {
                	
                	$("#ibalance").hide(); 
                	$("#iavailableAmount").hide(); 
                	$("#ifreezeAmount").hide(); 
                	$("#balance").html(data.balance);
                	$("#availableAmount").html(data.availableAmount);
                	$("#freezeAmount").html(data.freezeAmount);
                	
            		}
            	});
	        },
		GetInvestmentIncome: function () {
	        var url=$Url.BuildWWWUrl("customer/account/ajaxInvestmentIncome");
	        $.ajax({
                type: "POST",
                url: url,
                dataType: "json",
                error: function (request) {
                    // alert(request);
                },
                success: function (data) {
                	$("#iincome").hide(); 
                	$("#iunIncome").hide(); 
                	
                	$("#income").html(data.income);
                	$("#unIncome").html(data.unIncome);
            		}
            	});
	        },
	        GetTransactionRecord: function (pageIndex) {
	            var url=$Url.BuildWWWUrl("customer/account/ajaxTransactionRecord");
	           // alert($("a[name='moneyChangeType']").length)
	            //alert($("a[name='moneyChangeType'][class='active']").attr("value"));
	            var moneyChangeType = $("a[name='moneyChangeType'][class='active']").attr("value");
	            $.ajax({
	                    type: "POST",
	                    url: url,
	                    dataType: "html",
	                    data: {
	                    	pageIndex:pageIndex+1,
	                    	moneyChangeType:moneyChangeType
	                    },
	                    error: function (request) {
	                        //alert(request);
	                    },
	                    success: function (data) {
	                        $("#transactionRecord").html(data);
	                        if($("#totalCount").html()!=0){
	                    		$("#pagination").pagination($("#totalCount").html(), {//总记录条数
	                    			callback: Account.GetTransactionRecord,//每次点击分页按钮的时候 执行该操作
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
	                    }
	                })
	        },
	        GetMoneyChangeTypeElement:function(){
	        	$("a[name='moneyChangeType']").click(function(){
	        		/*$("a[name='moneyChangeType']").each(function(){
	        			$("a[name='moneyChangeType']").removeAttr("class");
	        			$(this).attr("class","active");
	        		});*/
	        		$("a[name='moneyChangeType']").removeAttr("class");
	        		$(this).attr("class","active");
	        		/*var a = $(this).attr("class");
	        		alert(a=="active");*/
	        		Account.GetTransactionRecord(0);
	        	});
	        }
	        
}

$(function () {
	CheckElement.ckeckLogoElement();
	CheckElement.ckeckElement();
	Account.GetInvestmentIncome();
	$("#formatMoney").html(parseFloat($("#formatMoney").html()).toFixed(2));
	var pageIndex = 0;
	Account.GetTransactionRecord(pageIndex);
	Account.GetMoneyChangeTypeElement();
	Account.getBalanceInfo();
	if($("#pageAlias").val()=="account"){
		$("#account").attr("class", "active");
	}
 });