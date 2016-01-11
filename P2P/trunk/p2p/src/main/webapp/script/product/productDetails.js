var ProductDetails = {
	Paging:function (pageIndex){
		if($("#pageIndex")==undefined) pageIndex=0;
        var url=$Url.BuildWWWUrl("product/ajaxListProductRecord");
        $.ajax({
            type: "POST",
            url: url,
            dataType: "html",
            data: {
            	"pageIndex":pageIndex+1,
            	p2pProductNo:parseInt($("#p2pProductNo").val().trim())
            },
            error: function (request) {
                //alert(request);
            },
            success: function (data) {
                $("#investRecordList").html(data);
                if(parseInt($("#totalCount").html())!=0){
            		$("#pagination").pagination(parseInt($("#totalCount").html()), {//总记录条数
            			callback: ProductDetails.Paging,//每次点击分页按钮的时候 执行该操作
            			items_per_page:20,//每页显示多少条记录
            			current_page:pageIndex,//当前页
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
        })
    },
    copyUrl:function (){  
    	var clipBoardContent="";
        clipBoardContent+=window.location.href;
        if(window.clipboardData){
            window.clipboardData.clearData();
            window.clipboardData.setData("Text", clipBoardContent);
        }else if(navigator.userAgent.indexOf("Opera") != -1){
            window.location = clipBoardContent;
        }else if (window.netscape){
            try{
                    netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
            }catch (e){
                    alert("您的当前浏览器设置已关闭此功能！请按以下步骤开启此功能：\n在浏览器地址栏输入'about:config'并回车，然后找到'signed.applets.codebase_principal_support'项，双击后设置为'true'。\n声明：本功能不会危极您计算机或数据的安全！");
            }
            var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
            if (!clip) return;
            var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
            if (!trans) return;
            trans.addDataFlavor('text/unicode');
            var str = new Object();
            var len = new Object();
            var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
            var copytext = clipBoardContent;
            str.data = copytext;
            trans.setTransferData("text/unicode",str,copytext.length*2);
            var clipid = Components.interfaces.nsIClipboard;
            if (!clip) return;
            clip.setData(trans,null,clipid.kGlobalClipboard);
        }
        alert("复制成功");
    }
}

$(function(){
	$("#investRecord").click(function(){
		if($("#productRecordFlag").length<=0){
			ProductDetails.Paging(0);
		}
    });
	$("#amount").click(function(){
		$("#msg").html("");
	});
    $(".my_invest").click(function(){
    	if($('.noLogin_layer').length>0){//没有登录
    		Banner.GetBanner($("#noLoginPic"),2);
    		initAll.layer($('.noLogin_layer'));
    		return;
    	}
    	if($(".unfinished_layer").length>0){//没有完成信息认证
    		initAll.layer($('.unfinished_layer'));
    		return;
    	}

    	$("#msg").html("");
        var investmentMoney = $String.Trim($("#amount").val());;
        var p2pProductNo = $("#p2pProductNo").val();
        
        if (!($(".my_invest").attr("process") === undefined)) {
            return false;
        }
        $.ajax({
            type: "post",
            url: $Url.BuildWWWUrl("/product/ajaxProductDetail"),
            dataType: "json",
            data: {
            	p2pProductNo: p2pProductNo,
            	amount: investmentMoney
            },
            beforeSend: function () {
                
                var amount = $String.Trim(investmentMoney);
                if(amount==""){
                	$("#msg").html("请输入投资金额!");
            		return false;
                }
            	var reg =/^[1-9]\d{0,9}$/g;///^[1-9]\d*$/g;
            	if(!reg.test(amount)){
            		$("#msg").html("请输入正确的投资金额!");
            		return false;
            	}
            	$(".my_invest").attr("process", "processing");
            	return true;
            },
            success: function (data) {
            	if(data.message.type==MessageType.Info){
            		$("#msg").html(data.message.description);
            	}else{
            		window.location.href=$Url.BuildWWWUrl
            		("product/confirmInfo?p2pProductNo="+p2pProductNo+"&investmentMoney="+investmentMoney);
            	}
            },
            complete: function (XMLHttpRequest, textStatus) {
                $(".my_invest").removeAttr("process");
            }
        });
        
    });
	
    $(".my_appointment").click(function(){
	      if($('.noLogin_layer').length>0){
    		  initAll.layer($('.noLogin_layer'));
    		  return;
	      }
    	  if (!($("#submit").attr("process") === undefined)) {
              return false;
          }
          $("#msg").html("");
          $.ajax({
              type: "post",
              url: $Url.BuildWWWUrl("customer/p2pSubscribe/ajaxp2pSubscribe"),
              dataType: "json",
              timeout: 30000,
              data: {
              	p2pProductNo: $("#p2pProductNo").val(),
              	amount: $("#amount").val()
              },
              beforeSend: function () {
                  
                var amount = $String.Trim($("#amount").val());
                if(amount==""){
                	$("#msg").html("请输入预约金额!");
            		return false;
                }  
              	var reg =/^[1-9]\d{0,9}$/g; // /^[1-9]\\d{0,9}$/
              	if(!reg.test(amount)){
              		$("#msg").html("请输入正确的预约金额!");
              		return false;
              	}
              	$("#submit").attr("process", "processing");
              	return true;
              },
              error: function (XMLHttpRequest, textStatus, errorThrown) {
              	alert(errorThrown);
              },
              success: function (data) {
              	if(data.message.type==MessageType.Info){
              		if(data.message.description=="预约成功！"){
              			/*$(".reservation_success").css("display","block");
              			$(".appointment").css("display","none");
              			$("#amountMoney").html($("#amount").val());*/
              			initAll.layer($('.layer'));
              		}else{
              			$("#msg").html(data.message.description);
              		}
              	}else if(data.message.type==MessageType.Error){
              		var returnUrl = window.location.href;
              		window.location.href=$Url.BuildWWWUrl("customer/personalInfo?returnUrl="+returnUrl +"");
              	}
              },
              complete: function (XMLHttpRequest, textStatus) {
                  $("#submit").removeAttr("process");
              }
          });
    });
    
    $("#qqZUrl").attr("href","http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url="+$Url.BuildWWWUrl("product/p2pProductList")+"&title=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html()+"&desc=&summary=华镇社区金融，您身边的一个优秀理财社区&site=52touzi");
    $("#tengxunUrl").attr("href","http://share.v.t.qq.com/index.php?c=share&a=index&url="+window.location.href+"&title=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html()+"&appkey=1343713053&searchPic=true");
    $("#renrenUrl").attr("href","http://widget.renren.com/dialog/share?resourceUrl="+window.location.href+"&srcUrl=&title=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html()+"&description=");
    //$("#wangyiUrl").attr("href","http://widget.renren.com/dialog/share?resourceUrl="+window.location.href+"&srcUrl=&title=华镇社区金融&description=");
    $("#qqFUrl").attr("href","http://connect.qq.com/widget/shareqq/index.html?url="+window.location.href+"&title=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html()+"&desc=&summary=&site=52touzi");
    $("#feixinUrl").attr("href","http://i.feixin.10086.cn/apps/share/share?url="+window.location.href+"&title=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html()+"&content=&comment=&pic=");
    $("#xinlangUrl").attr("href","http://v.t.sina.com.cn/share/share.php?url="+window.location.href+"&title=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html());
    $('#weixinUrl').attr("src","http://qr.liantu.com/api.php?&bg=ffffff&fg=000000&&w=220&m=10&text="+window.location.href);
    $("#weixin").click(function(){
    	$("#weixinlayer").attr("style","display:block");
    });
    $("#winxinClose").click(function(){
		$("#weixinlayer").attr("style","display:none");
	});
    //$("#yixinUrl").attr("href","http://v.t.sina.com.cn/share/share.php?url="+window.location.href+"&title=华镇社区金融");
    $("#shouhuUrl").attr("href","http://t.sohu.com/third/post.jsp?url="+window.location.href+"&title=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html());
    $("#kaixinUrl").attr("href","http://www.kaixin001.com/login/open_login.php?flag=1&url="+window.location.href+"&title=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html());
    $("#doubanUrl").attr("href","http://www.douban.com/share/service?href=&name="+window.location.href+"华镇社区金融&text=华镇社区金融--理财从这里开始    分享产品："+$("#p2pProductName").html());

	/*var appointment = $("#transactionForm").Validform({
        tiptype: 3,
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            $("#msg").html("");
            $.ajax({
                type: "post",
                url: $Url.BuildWWWUrl("customer/p2pSubscribe/ajaxp2pSubscribe"),
                dataType: "json",
                timeout: 30000,
                data: {
                	p2pProductNo: $("#p2pProductNo").val(),
                	amount: $("#amount").val()
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                    var amount = $String.Trim($("#amount").val());
                    
                	var reg =/^[1-9]\d{0,9}$/g; // /^[1-9]\\d{0,9}$/
                	if(!reg.test(amount)){
                		$("#msg").html("请填写正确的预约金额!");
                		return false;
                	}
                	return true;
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                	alert(errorThrown);
                },
                success: function (data) {
                	if(data.message.type==MessageType.Info){
                		if(data.message.description=="预约成功！"){
                			$(".reservation_success").css("display","block");
                			$(".appointment").css("display","none");
                			$("#amountMoney").html($("#amount").val());
                		}else{
                		$("#msg").html(data.message.description);
                		}
                	}else if(data.message.type==MessageType.Error){
                		var returnUrl = window.location.href;
                		window.location.href=$Url.BuildWWWUrl("customer/personalInfo?returnUrl="+returnUrl +"");
                	}
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                }
            });

            return false;
        }
    });*/
    var subscribe = $("#callSubscribeForm").Validform({
		tiptype: function(msg,o,cssctl){
			var objtip=$("#msgdemo");
			cssctl(objtip,o.type);
            if(""==msg.trim()){
                objtip.hide();
            }else{
                objtip.show();
            }
			objtip.text(msg);},
			ignoreHidden: true,
			callback: function (form) {
				if (!($("#submit").attr("process") === undefined)) {
					return false;
				}
				var url = $Url.BuildWWWUrl("/customer/p2pSubscribe/ajaxp2pSubscribeWithoutLogin");
				$.ajax({
					type: "post",
					url: url,
					dataType: "json",
					timeout: 30000,
					data: {
						callName:$String.Trim($("#callName").val()),
						callPhone: $String.Trim($("#callPhone").val()),
						p2pProductNo: $String.Trim($("#p2pProductNo").val()),
//						amount: $String.Trim($("#amount").val()),
					},
					beforeSend: function () {
						$("#submit").attr("process", "processing");
					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						Base.Common.PromptText.systemError();
					},
					success: function (data, textStatus) {
						if (data.message.type == MessageType.Info) {
							$(".noLogin_layer").hide();
							initAll.layer($('.layer'));
						}else{
							$("#msgdemo").text(data.message.description).show();
						}
					},
					complete: function (XMLHttpRequest, textStatus) {
						$("#submit").removeAttr("process");
					}
				});
				
				return false;
			}
	});
	subscribe.addRule([//给上面的验证的validform对象添加规则
       {
           ele: "#callName",
           datatype: "/^[\u4e00-\u9fa5]{2,4}$/",
           //ignore: "ignore",
           nullmsg: "请填写姓名",
           errormsg: "请填写正确的姓名",
           sucmsg: " "
       },
       {
           ele: "#callPhone",
           datatype: "/^1[3|7|9][0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}|\d{3,4}-\d{7,8}(-\d{3,4})?$/",
           //ignore: "ignore",
           nullmsg: "请填写手机号码",
           errormsg: "请填写正确格式的手机号码",
           sucmsg: " "
       }
   ]);
});