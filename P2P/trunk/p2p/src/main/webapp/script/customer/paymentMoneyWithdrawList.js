var ManagePage = {
    GetList: function (pageIndex) {
    	var byCreateTime = $("#createTime").val();
        var state0 = "";
        var state1 = "";
        var state2 = "";
        var state3 = "";
        var state4 = "";
        var state5 = "";
        
    	if($("input[id=state0]").is(':checked')){
    		state0=$("input[id=state0]").val();
		}
    	if($("input[id=state1]").is(':checked')){
    		state1=$("input[id=state1]").val();
    	}
    	if($("input[id=state2]").is(':checked')){
    		state2=$("input[id=state2]").val();
    	}
    	if($("input[id=state3]").is(':checked')){
    		state3=$("input[id=state3]").val();
    	}
    	if($("input[id=state4]").is(':checked')){
    		state4=$("input[id=state4]").val();
    	}
    	if($("input[id=state5]").is(':checked')){
    		state5=$("input[id=state5]").val();
    	}
    	if(byCreateTime==undefined) byCreateTime="";
    	if(state0==undefined) state0="";
    	if(state1==undefined) state1="";
    	if(state2==undefined) state2="";
    	if(state3==undefined) state3="";
    	if(state4==undefined) state4="";
    	if(state5==undefined) state5="";
        var url=$Url.BuildWWWUrl("customer/paymentMoneyWithdraw/ajaxListPaymentMoneyWithdraw?byCreateTime="+byCreateTime+"&state0="+state0+"&state1="+state1+"&state2="+state2+"&state3="+state3+"&state4="+state4+"&state5="+state5);
        $.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            data: {
            	"pageIndex":pageIndex+1/*,
            	byCreateTime:byCreateTime,
            	state0:state0,
            	state1:state1,
            	state2:state2*/
            },
            error: function (request) {
                //alert(request);
            },
            success: function (data) {
                $("#paymentMoneyWithdrowList").html(data);
                if($("#totalCount").html()!=0){
            		$("#pagination").pagination($("#totalCount").html(), {//总记录条数
            			callback: ManagePage.GetList,//每次点击分页按钮的时候 执行该操作
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
    InitQuery: function () {
        $("#btnSearch").click(function () {
            ManagePage.GetList(0);
	        
        });
    },
    GetTime:function(obj){
    	var arr = ["全部","最近三个月","最近一个月","最近7天"]
    	for (var i=0;i<arr.length;i++){
    		var op = $("<option></option>").text(arr[i]).val(i);
    		if(i==0){
    			op.attr("selected",true);
    		}
    		obj.append(op);
    	}
    }
}


$(function () {
    ManagePage.InitQuery();
    $("#withDrawRecord").click(function(){
    	ManagePage.GetList(0);
    });
    ManagePage.GetTime($("#createTime"));
	if($("#pageAlias").val()=="myPaymentMoneyWithdrawList"){
		$("#myPaymentMoneyWithdrawList").attr("class", "active");
	}
	$(".withdrawBtn").click(function(){
		$("#rechargeForm").submit();
	});
    var withdraw = $("#rechargeForm").Validform({
        tiptype: 3,
        datatype: {
            "verifywithdrawMoney": function (gets, obj, curform, datatype) {
                var reg=/^[1-9]\d{0,7}$/;
                if (!reg.test(gets)){
                    return false;
                }
                var result;
                if(parseInt(obj.val())>parseInt($("#canWithdrawMoney").html()))
                	result="提现金额要小于可提现金额！";
                return result;
            }
        },
        callback: function (form) {
            if (!($("#comfirSubmit").attr("process") === undefined)) {
                return false;
            }
            $.ajax({
                type: "post",
                url: $Url.BuildWWWUrl("customer/paymentMoneyWithdraw/ajaxPaymentWithdraw"),
                dataType: "json",
                timeout: 30000,
                data: {
                	amount: $String.Trim($(".withdrawMoney").val())
                },
                beforeSend: function () {
                    $("#comfirSubmit").attr("process", "processing");
                    if($("#bankLogoImg").length==0){
                    	alert("银行卡未绑定");
                    	return false;
                    };
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                },
                success: function (data) {
                	var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+" method=\"post\"></form>";
                	$("body").first().append(paymentObj);
                	var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
                			"<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
                			$(".pay_data").html(input);		
                	$(".pay_data").submit();
                		
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#comfirSubmit").removeAttr("process");
                }
            });

            return false;
        }
    });

    withdraw.addRule([
        {
        	 ele: ".withdrawMoney",
             datatype: "verifywithdrawMoney",//"/^[1-9]\\d{0,7}$/",//idcardTest| ^\d+(.\d{1,2})?$
             //ignore: "ignore",
             nullmsg: "请填写提现金额！",
             errormsg: "请填写正确的提现金额！(整数)",
             sucmsg: " "
        	 
        }
    ]);
});