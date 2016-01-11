var ManagePage = {
    GetList: function (pageIndex) {
    	var byCreateTime = $("#createTime").val();
        var state0 = "";
        var state1 = "";
        var state2 = "";
        
    	if($("input[id=state0]").is(':checked')){
    		state0=$("input[id=state0]").val();
		}
    	if($("input[id=state1]").is(':checked')){
    		state1=$("input[id=state1]").val();
    	}
    	if($("input[id=state2]").is(':checked')){
    		state2=$("input[id=state2]").val();
    	}
        var url=$Url.BuildWWWUrl("customer/paymentMoneyRecharge/ajaxListPaymentMoneyRecharge?byCreateTime="+byCreateTime+"&state0="+state0+"&state1="+state1+"&state2="+state2);
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
                $("#paymentMoneyRechargeList").html(data);
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
    Init: function () {
        $("#btnSearch").click(function () {
            ManagePage.GetList(0);
        });
        $("#rechargeRecord").click(function () {
        	ManagePage.GetList(0);
        });
    },
    GetTime:function(obj){
    	var arr = ["全部","最近三个月","最近一个月","最近7天"];
    	for (var i=0;i<arr.length;i++){
    		var op = $("<option></option>").text(arr[i]).val(i);
    		if(i==0){
    			op.attr("selected",true);
    		}
    		obj.append(op);
    	}
    },
    Recharge:function(){
    	$(".rechargeButton").click(function(){
    		
    	});
    },
    RefreshPage:function(){
		$("#closeWindow").click(function(){
			location.reload();
		});
	}
  
    
}

$(function () {
	if($("#pageAlias").val()=="myPaymentMoneyRechargeList"){
		$("#myPaymentMoneyRechargeList").attr("class", "active");
	}
	ManagePage.RefreshPage();
    ManagePage.Init();
    ManagePage.GetTime($("#createTime"));
    var recharge = $(".validform").Validform({
        tiptype: 3,
        callback: function (form) {
            if (!($(".comfirSubmit").attr("process") === undefined)) {
                return false;
            }
            $.ajax({
                type: "post",
                url: $Url.BuildWWWUrl("customer/paymentMoneyRecharge/ajaxPaymentRecharge"),
                dataType: "json",
                timeout: 30000,
                data: {
                	amount: $String.Trim($(".rechargeMoney").val())
                },
                beforeSend: function () {
                    $(".comfirSubmit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                },
                success: function (data) {
                	
                	
                	//$(".rechargeBtn").click();
                	if(data.errCode=="Not AuthenticationName"){
                		$("#msg1").html(data.errDesc);
                	}else{
                		var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+" method=\"post\" ></form>";//target=\"_blank\"
                		$("body").first().append(paymentObj);
                		var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
                		"<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
                		$(".pay_data").html(input);		
                		$(".pay_data").submit();
                	}
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $(".comfirSubmit").removeAttr("process");
                }
            });

            return false;
        }
    });

    recharge.addRule([
        {
        	 ele: ".rechargeMoney",
             datatype: "/^[1-9]\\d{0,7}$/",//idcardTest|
             //ignore: "ignore",
             nullmsg: "请填写充值金额！",
             errormsg: "请填写正确的充值金额！",
             sucmsg: " "
        	 
        }
    ]);
});