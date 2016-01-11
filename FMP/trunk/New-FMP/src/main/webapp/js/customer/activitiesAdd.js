var ManagePage = {
    EnableInput: function () {
        $.each($(".data"), function (index, content) {
            var id = $(this).attr("id");
            if (ElementVar[id] == undefined) {
                $(this).removeAttr("disabled");
            }
            if (ElementVar[id] == TagPermissionType.edit) {
                $(this).removeAttr("disabled");
            }
            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none){
                $(this).parent().remove();
            }
        });
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
        if ($("#edit").length > 0){
        	$("#edit").show();
        	$("#publish").show();
        }
        if ($("#submit").length > 0)
            $("#submit").hide();

    },
    HideEditButton: function () {
        if ($("#edit").length > 0){
        	$("#edit").hide();
        	$("#publish").hide();
        }
        if ($("#submit").length > 0)
            $("#submit").show();

    },
	Resize:function(){
		$("#content_center").css('height',$('.detail').height()+200);
	},
	GetInfoOnlyActType: function (id) {
    	var actType = 0;
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxGetActivities");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            async:false,
            timeout: 30000,
            data: { id: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                actType = data.info.activityType;
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return actType;
    },
    GetInfo: function (id) {
    	var actType = 0;
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxGetActivities");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            async:false,
            timeout: 30000,
            data: { id: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);
                if(data.info.status==0){
                	$("#publish").val("发布");
                }else{
                	$("#publish").val("取消发布");
                }
                if(data.info.startTime.indexOf("T")>-1){
                	$("#startTime").val(data.info.startTime.replace("T"," ").substring(0,13));
                }
                if(data.info.endTime.indexOf("T")>-1){
                	$("#endTime").val(data.info.endTime.replace("T"," ").substring(0,13));
                }
                if($("#startTime").val()=="2000-01-01 00" && $("#endTime").val()=="2025-12-31 23" ){
                	$("#radioDate1").attr("checked","checked");
                	$("#radioDate2").removeAttr("checked");
                }
                actType = data.info.activityType;
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return actType;
    },
    GetInfos: function (id) {
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxGetActivityAwardRelationByCondId");
        $.ajax({
            type: "post",
            url: url,
            async : false,
            dataType: "json",
            timeout: 30000,
            data: { condID: id },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
            	if(data.editComment!=null && data.editComment!=""){
                	$("#contentDiv").append(data.editComment.substring(4,data.editComment.length)+"<br />");
            	}else{
            		$("#contentDiv").append("<br />");
            	}
            	if ($("#edit").length <= 0 || $("#submit").length <= 0){
                	$(".icon1").css("display","none");
                	$(".icon2").css("display","none");
                	$("#addCondition").css("display","none");
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    pic2Click:function(id){
    	$("#icon2"+id).click(function () {
    		$EasyUI.NewTab("条件奖励", $Url.BuildCustomerUrl("/customer/activities/addDetail?id=" + id));
    	});
    },
    pic1Click:function(id){
    	$("#icon1"+id).click(function () {
    		if(confirm("确定删除该条件和奖励嘛")){
    			var url = $Url.BuildCustomerUrl("/customer/activities/ajaxDeleteContentByCondId");
    	        $.ajax({
    	            type: "post",
    	            url: url,
    	            async : false,
    	            dataType: "json",
    	            timeout: 30000,
    	            data: { condID: id },
    	            beforeSend: function () {
    	            },
    	            error: function (XMLHttpRequest, textStatus, errorThrown) {
    	                alert(errorThrown);
    	            },
    	            success: function (data, textStatus) {
    	    			location.reload();
    	            },
    	            complete: function (XMLHttpRequest, textStatus) {
    	            }
    	        });
    		}
    	});
    },
    updatePubStatus: function (id,status) {
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxUpdateActivitiesByIdAndStatus");
        $.ajax({
            type: "post",
            url: url,
            async : false,
            dataType: "json",
            timeout: 30000,
            data: { actID: id,status:status },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
            	if(status==0){
            		alert("取消发布成功");
            		$("#publish").val("发布");
            	}else{
            		alert("发布成功");
            		$("#publish").val("取消发布");
            	}
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    payment : function(type,id,trueID){
    	if (confirm("确定进行打款操作吗？")) {
	        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxUpdateActivityCustomerCashBonusById");
	        $.ajax({
	            type: "post",
	            url: url,
	            async : false,
	            dataType: "json",
	            timeout: 30000,
	            data: {type:type, accID: id,aciID:trueID},
	            beforeSend: function () {
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	            	var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+" method=\"post\" ></form>";//target=\"_blank\"
	            	$("body").first().append(paymentObj);
	            	var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
	            			"<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
	            			$(".pay_data").html(input);		
	            	$(".pay_data").submit();
	//            	alert("打款成功");
	            	$("#gridTable").trigger("reloadGrid");
	            	
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
    	}
    },
    paymentConfirm : function(type,id,trueID){
    	if (confirm("确定进行审核通过操作吗？")) {
	        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxCheckPayment");
	        $.ajax({
	            type: "post",
	            url: url,
	            async : false,
	            dataType: "json",
	            timeout: 30000,
	            data: {type:type, accID: id,aciID:trueID},
	            beforeSend: function () {
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	//            	alert("打款成功");
	            	$("#gridTable").trigger("reloadGrid");
	            	
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
    	}
    },
    paymentCancel : function(type,id,trueID){
    	if(confirm("确定进行取消打款操作吗？")){
	        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxCancelRefundPayment");
	        $.ajax({
	            type: "post",
	            url: url,
	            async : false,
	            dataType: "json",
	            timeout: 30000,
	            data: {type:type, accID: id,aciID:trueID},
	            beforeSend: function () {
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	//            	alert("打款成功");
	            	$("#gridTable").trigger("reloadGrid");
	            	
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
    	}
    },
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildCustomerUrl('/customer/activityCustomerInvitation/ajaxListActivityCustomerInvitation.action'),
            editurl: $Url.BuildCustomerUrl("/customer/activityCustomerInvitation/ajaxEditActivityCustomerInvitation.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","用户名称","邀请时间","被邀请用户","registerTime","实名认证时间","奖励","打款金额","奖励类型","relatedNo","inviteTime","打款人","activityNo","status","activityCustomerCashBonusNo"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id",hidden:true, width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
                    name: "p2pCustomerNo", index: "p2pCustomerNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("p2pCustomerList", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "inviteTime", index: "inviteTime", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
                    name: "invitedNo", index: "invitedNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("p2pCustomerList", $Url.BuildSalesUrl("/common/enumList.action"))}, formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true
				},
				{
					name: "registerTime", index: "registerTime",hidden:true, width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "authenticationTime", index: "authenticationTime", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "money", index: "money", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "trueMoney", index: "trueMoney", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "type", index: "type",hidden:true, width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "relatedNo", index: "relatedNo",hidden:true, width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "inviteTime", index: "inviteTime",hidden:true, width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }
				},
				{
					name: "approverNo", index: "approverNo", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true,  formatter: "select", edittype: "select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildCustomerUrl("/common/enumList.action")) }
				},
				{
					name: "activityNo", index: "activityNo",hidden:true, width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "status", index: "status",hidden:true, width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "activityCustomerCashBonusNo",hidden:true, index: "activityCustomerCashBonusNo", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				}
            ],
            sortname: "id",
            sortorder: "desc",
            viewrecords: true,
            rowNum: 10,
            rowList: [10],
            altclass: "altRowsColour",
            shrinkToFit:true,
            autowidth: true,
            height: "auto",
            multiselect: true,
            prmNames: {
                search: "search",
                page: "pageIndex",
                rows: "pageSize"
            },
            postData:{
            	actID : PageVar.ID,
            	status :1
            },
            jsonReader: {
                root: "resultList",
                page: "pageIndex",
                total: "pageCount",
                records: "recordCount",
                repeatitems: false
            },
            pager: "#gridPager",
            gridComplete: function () {
                //var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var inviteTimes = $("#gridTable").jqGrid('getCol', 'inviteTime', true);
                var authenticationTimes = $("#gridTable").jqGrid('getCol', 'authenticationTime', true);
                var trueMoneys = $("#gridTable").jqGrid('getCol', 'trueMoney', true);
                var types = $("#gridTable").jqGrid('getCol', 'type', true);
                var relatedNos = $("#gridTable").jqGrid('getCol', 'relatedNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var inviteTime = inviteTimes[i].value;
                    var authenticationTime = authenticationTimes[i].value;
                    var trueMoney = trueMoneys[i].value;
                    var type = types[i].value;
                    var relatedNo = relatedNos[i].value;
                    var detail = "";
                    var edit = "";
                    
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.payment('" + type + "','" + relatedNo + "','"+id+"')\">打款</a>";
                    if(inviteTime.indexOf("T")>-1){
                    	$("#gridTable #"+id+" td[aria-describedby='gridTable_inviteTime']").text(inviteTime.replace("T"," "));
                    }
                    if(authenticationTime.indexOf("T")>-1){
                    	$("#gridTable #"+id+" td[aria-describedby='gridTable_authenticationTime']").text(authenticationTime.replace("T"," "));
                    }
                    if(trueMoney!=null && trueMoney!="" && trueMoney!=0){
                    	var url = "";
                    	if(type==1){
                    		var url = $Url.BuildCustomerUrl("/customer/activityCustomerExperienceGold/ajaxGetActivityCustomerExperienceGold");
                    	}else if(type==2){
                    		var url = $Url.BuildCustomerUrl("/customer/activityCustomerCashBonus/ajaxGetActivityCustomerCashBonus");
                    	}
                    	if(url!="" && url!=null){
                    		$.ajax({
                                type: "post",
                                url: url,
                                async : false,
                                dataType: "json",
                                timeout: 30000,
                                data: { id: relatedNo},
                                beforeSend: function () {
                                },
                                error: function (XMLHttpRequest, textStatus, errorThrown) {
                                    alert(errorThrown);
                                },
                                success: function (data, textStatus) {
                                	if(data.info.status==0 || data.info.status==1){
                                		$("#gridTable #"+id+" td[aria-describedby='gridTable_approverNo']").text("无");
                                		if(ElementVar.activitiesPayment!="query"){
                                			detail = "<a class=\"blue\">"+"待打款"+"</a>";
                                		}
                                	}else if(data.info.status==2){
                                		if(ElementVar.activitiesPayment!="query"){
                                			detail = "<a class=\"blue\">"+"审核中"+"</a>";
                                		}else{
                                			detail = "<a class=\"blue\" href=\"javascript:ManagePage.paymentConfirm('" + type + "','" + relatedNo + "','"+id+"')\">打款通过</a>"
                                    		+"|"+    "<a class=\"blue\" href=\"javascript:ManagePage.paymentCancel('" + type + "','" + relatedNo + "','"+id+"')\">取消打款</a>";
                                		}
                                	}else if(data.info.status==3){
                                		detail = "<a class=\"blue\">"+"已打款"+"</a>";
                                	}else if(data.info.status==4){
                                		detail = "<a class=\"blue\">"+"打款取消"+"</a>";
                                	}
                                },
                                complete: function (XMLHttpRequest, textStatus) {
                                }
                            });
                    	}
                    }
                    
                    
                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byIsPayment = $("#byIsPayment").val();
            var byIsType = $("#byIsType").val();
            
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "byIsPayment": byIsPayment,"byIsType":byIsType},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    getP2pName:function(id){

        var url = $Url.BuildCustomerUrl("/customer/p2pCustomer/ajaxGetP2pCustomer");
        $.ajax({
            type: "post",
            url: url,
            async : false,
            dataType: "json",
            timeout: 30000,
            data: { id: id},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
            	return data.userName;
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    getActivityType:function(){
    	var count = 0;
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxGetActivitiesType");
        $.ajax({
            type: "post",
            url: url,
            async : false,
            dataType: "json",
            timeout: 30000,
            data: {},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
            	count = data.count;
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return count;
    },
    getConds:function(id){
    	var count = 0;
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxGetConds");
        $.ajax({
            type: "post",
            url: url,
            async : false,
            dataType: "json",
            timeout: 30000,
            data: {id:id},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
            	count = data.count;
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return count;
    }
}
$(function () {
	ManagePage.Resize();
	EnumList.GetEnumListToSelect($("#activityType"),"activityType",$Url.BuildCustomerUrl("/common/enumList.action"));
	EnumList.GetEnumListToSelect($("#isDisplay"),"isDisplay",$Url.BuildCustomerUrl("/common/enumList.action"));

    $("#back").click(function () {
        //window.location.href = $Url.BuildCustomerUrl("/customer/activities/list");
        $EasyUI.Close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
//        if(ManagePage.getActivityType()>=1){
//        	document.getElementById("activityType").options.remove(0); 
//        }
    }
    else {
        ManagePage.GetInfo(PageVar.ID);
//        if(actType!=1){
//        	if(ManagePage.getActivityType()>=1){
//            	document.getElementById("activityType").options.remove(0); 
//            }
//        }
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxEditActivitiesShowConditions");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async:false,
            data: {
            	actID: PageVar.ID
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                	var condIDs = new Array();
                	var condDescriptions = new Array();
                	if(data.condID!="" && data.condID!=null && data.condID!="0"){
                		condIDs = data.condID.split("@");
                		condDescriptions = data.condDescription.split("@");
                		for (var i = 1; i < condIDs.length; i++) {
							$("#contentDiv").append("<i id=\"icon1"+condIDs[i]+"\" class=\"icon1\"></i><i id=\"icon2"+condIDs[i]+"\" class=\"icon2\"></i>条件："+condDescriptions[i]+"<br />");
							ManagePage.pic1Click(condIDs[i]);
							ManagePage.pic2Click(condIDs[i]);
							ManagePage.GetInfos(condIDs[i]);
						}
                	}
                }
				ManagePage.Resize();
            },
            complete: function (XMLHttpRequest, textStatus) {
                $("#submit").removeAttr("process");
            }
        });
    }
    $("#publish").click(function () {
        if($("#publish").val()=="发布"){
        	ManagePage.updatePubStatus(PageVar.ID,1);
        }else{
        	ManagePage.updatePubStatus(PageVar.ID,0);
        }
    });
	
	$("#startTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH'});
    });
    $("#endTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH'});
    });

    var activitiesAdd = $("#activitiesAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
        	if($("#radioDate1").is(':checked') == true){
        		$("#startTime").val("2000-01-01 00");
        		$("#endTime").val("2025-12-31 23");
        	}else if(($("#startTime").val()==null ||  $("#startTime").val()=="")
        			||(($("#endTime").val()==null ||  $("#endTime").val()==""))){
        		alert("请输入活动的有效期");
        		return false;
        	}
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildCustomerUrl("/customer/activities/ajaxEditActivities");
            var oper = "add";
            
            if (Number(PageVar.ID) != 0){
              oper = "edit"; 
              
              var actType = ManagePage.GetInfoOnlyActType(PageVar.ID);
              if(actType!=Number($("#activityType").val())){
            	  
            	  var count = 0;
            	  var url = $Url.BuildCustomerUrl("/customer/activityRuleRelation/ajaxGetActivityRuleRelationByActId");
                  $.ajax({
                      type: "post",
                      url: url,
                      dataType: "json",
                      timeout: 30000,
                      async:false,
                      data: {
                      	id: PageVar.ID
                      },
                      error: function (XMLHttpRequest, textStatus, errorThrown) {
                          alert(errorThrown);
                      },
                      success: function (data, textStatus) {
                          if (data.errCode == "0000") {
                        	  count = data.count;
                          }
                      },
                      complete: function (XMLHttpRequest, textStatus) {
                      }
                  });
            	  if(count>0){
            		  alert("请在修改类型之前删除条件和奖励");
                	  return false;
            	  }
              }
            }else{
//            	if(ManagePage.getActivityType()>=1){
//            		alert("普通邀请活动类型的活动只允许有一个");
//                	return false;
//                }        	
        	}
            var info = {
                id: PageVar.ID,
				activityName: $("#activityName").val(),
				activityStatus: "",
				activityType: $("#activityType").val(),
				startTime: ($("#startTime").val()+":00:00").toTimetamp(),
				endTime: ($("#endTime").val()+":00:00").toTimetamp(),
				status: $("#status").val(),
				isDisplay: $("#isDisplay").val(),
				activityRule: $("#activityRule").val(),
				editComment: "",
				isTest: $("#isTest").val()
            }
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    info: JSON.stringify(info)
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildCustomerUrl("/customer/activities/edit?id=" + data.errDesc);
                    } else {
                        $("#msg").text(data.errDesc);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                }
            });
            return false;
        }
    });
    $("#addCondition").click(function () {
    	if (Number(PageVar.ID) == 0 || $("#submit").css("display")=="inline") {
            alert("请先进行提交操作");
        }
        else {
        	if($("#activityType").val()==1){
        		var count = ManagePage.getConds(Number(PageVar.ID));
            	if(count>=1){
            		alert("只允许有一个条件");
            		return false;
            	}
        	}
        	$EasyUI.NewTab("条件奖励", $Url.BuildCustomerUrl("/customer/activities/addDetail?aId=" + Number(PageVar.ID)));
        	
        }
	});
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    activitiesAdd.addRule([
     {
	    ele: "#activityName",
	    datatype: "*",
	
	    nullmsg: "请填写活动名称",
	    errormsg: "",
	    sucmsg: " "
     },
     {
 	    ele: "#activityRule",
 	    datatype: "*",
 	
 	    nullmsg: "请填写活动规则",
 	    errormsg: "",
 	    sucmsg: " "
      }/*,
      {
   	    ele: "#startTime",
   	    datatype: "*",
   	
   	    nullmsg: "请填写活动开始时间",
   	    errormsg: "",
   	    sucmsg: " "
      },
      {
 	    ele: "#endTime",
 	    datatype: "*",
 	
 	    nullmsg: "请填写活动结束时间",
 	    errormsg: "",
 	    sucmsg: " "
      }*/
    ]);
})
