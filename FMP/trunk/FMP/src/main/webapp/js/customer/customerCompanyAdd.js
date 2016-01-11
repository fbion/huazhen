var BindEnumList={
	BindAll:function(){
		BindEnumList.BindRelationLevel();
		BindEnumList.BindRiskHobby();
		BindEnumList.BindEmpManager();
		BindEnumList.BindCusFollowType();
		BindEnumList.BindProduct();
	},
	BindRelationLevel:function(){
		EnumList.GetEnumListToSelect($("#relationLevel"), "dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action"));
	},
	BindRiskHobby:function(){
		EnumList.GetEnumListToSelect($("#riskHobby"), "dicDataforCustomerCompanyRiskHobby", $Url.BuildCustomerUrl("/common/enumList.action"));
	},
	BindEmpManager:function(){
		EnumList.GetEnumListToSelect($("#agentNo"),"empManager",$Url.BuildCustomerUrl("/common/enumList.action"));
	},
	BindProduct:function(){
		EnumList.GetEnumListToSelect($("#product_no"), "productListByStatus30ForCustomerFollow", $Url.BuildCustomerUrl("/common/enumList.action"));
	},
	BindCusFollowType:function(){
		EnumList.GetEnumListToSelect($("#followType"), "cusFollowType", $Url.BuildCustomerUrl("/common/enumList.action"));
	}
}

var InitValue = {
		InitValueforDetail:function(thisId){
			var info = DataManager.getInfo(thisId);
			if (info==null) {
				return;
			}
			
			$Util.DataToVal(info, ElementVar);
			if (info.findTime!=null) {
				var findTime = new Date(info.findTime);
	            $("#findTime").val(findTime.format("yyyy-MM-dd HH:mm:ss"));	
			}else{
				$("#findTime").val("");
			}
			ElementManager.Elementformatter();

		},
		InitMemberClassType:function(){
			var memberClassTypes = ["0","1","2"];
			var memberClassNames = ["请选择","企业借款人","担保公司"];
			for(var i=0;i<memberClassTypes.length;i++){
				var op=$("<option>").text(memberClassNames[i]).val(memberClassTypes[i]);
				$("#memberClassType").append(op);
			}
		}
}

var DataManager={
		getInfo:function(thisId){
				var result;
				var url = $Url.BuildCustomerUrl("/customer/customerCompany/ajaxGetInfoById");
			    	$.ajax({
			    		type:"post",
			    		url:url,
			    		async:false,
			    		data:{
			    			customerId:thisId
			    		},
			    		beforeSend:function(){},
			    		error:function(XMLHttpRequest,textStatus,errorThrown){
			    			alert(errorThrown);
			    		},
			    		success:function(data,textStatus){
			    			result = data.customerCompany;
			    			if (data.errCode == "0000") {
			    				ElementManager.ShowEditButton();
			    	                if ($("#edit").length > 0) {
			    	                    $("#edit").click(function () {
			    	                        ManagePage.EnableInput();
			    	                        ElementManager.HideEditButton();
                                            if(ElementVar.updateAgentNo2!="none"){
                                                $("#employeeSel").removeAttr("disabled");
                                            }

			    	                    });
			    	                }
			    			}
                            EmployeeTreeControl.startTree({
                                param: "on",  //on在职员工，out离职员工，test测试员工
                                treeInputId: "employeeSel",//员工控件框ID
                                valInputId: "agentNo", //员工值框id
                                inputType: "employee",//employee员工，position职位
                                idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
                                chkStyle: "radio",//选框类型checkbox,radio
                                nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
                                chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
                                showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
                                //showSearch: true,   //显示搜索框
                                showLevel:3,         //显示层级
                                sizeAuto:true,		//自动调节大小
                                width:200,			//宽，单位px
                                height:300			//高，单位px
                            });
			    			
			    		},
			    		complete:function(XMLHttpRequest,textStatus){}
			    	});
			    	return result;
			    },
		getFollowInfo:function(id){
			var result;
			var url = $Url.BuildCustomerUrl("/customer/customerFollow/ajaxGetFollowInfoById");
		    	$.ajax({
		    		type:"post",
		    		url:url,
		    		async:false,
		    		data:{
		    			followId:id
		    		},
		    		beforeSend:function(){},
		    		error:function(XMLHttpRequest,textStatus,errorThrown){
		    			alert(errorThrown);
		    		},
		    		success:function(data,textStatus){
		    			result = data.customerFollow;
		    		},
		    		complete:function(XMLHttpRequest,textStatus){}
		    	});
		    	return result;
		}
}

var ElementManager={
		ElementDisable:function(){
			$(".data").attr("disabled", "disabled");
		},
		ElementUnDisable:function(){
			$.each($(".data"), function (index, content) {
	            var id = $(this).attr("id");
//	            $(".data").attr("disabled", 'true');
	            if (ElementVar[id] == undefined) {
	                $(this).removeAttr("disabled");
	            }
	            if (ElementVar[id] == TagPermissionType.edit) {
	                $(this).removeAttr("disabled");
	            }
	            if (PageVar.ID == 0 && ElementVar[id] == TagPermissionType.none) {
	                $(this).parent().remove();
	            }
	        });
		},
		Elementformatter:function(){
			if ($("#wealth").val()=="0") {
				$("#wealth").val("");
			}
			if ($("#tradeTotal").val()=="0") {
				$("#tradeTotal").val("");
			}
			
		},
		ElementFollowDisable:function(){
			$("#product_no").attr('disabled','true');
			$("#followType").attr('disabled','true');
			$("#followTime").attr('disabled','true');
			$("#nexttime").attr('disabled','true');
			$("#contentFollow").attr('disabled','true');
			$("#result").attr('disabled','true');
			$("#edit_comment_follow").attr('disabled','true');
		},
		ElementFollowUnDisable:function(){
			$("#product_no").removeAttr("disabled");
			$("#followType").removeAttr("disabled");
			$("#followTime").removeAttr("disabled");
			$("#nexttime").removeAttr("disabled");
			$("#contentFollow").removeAttr("disabled");
			$("#result").removeAttr("disabled");
			$("#edit_comment_follow").removeAttr("disabled");
		},
		ElementFollowClean:function(){
			$("#hideId").val("");
			$("#product_no").val(0);
			$("#followType").val(1);
            $("#followTime").val("");
			$("#nexttime").val("");
			$("#contentFollow").val("");
			$("#result").val("");
			$("#edit_comment_follow").val("");
		},
  		ShowEditButton: function () {
	        if ($("#edit").length > 0)
	            $("#edit").show();
	        if ($("#submit").length > 0)
	            $("#submit").hide();

	    },
    	HideEditButton: function () {
	        if ($("#edit").length > 0)
	            $("#edit").hide();
	        if ($("#submit").length > 0)
	            $("#submit").show();
	    }
		
}

var JqGridManage={
		DateInputElem : function(value, options) {
			var el = document.createElement("input");
			el.type = "text";
			el.value = value;
			el.onclick = function() {el.focus();el.select(); WdatePicker({dateFmt : 'yyyy-MM-dd  HH:mm:ss'	});	};
			$(el).addClass("FormElement");
			$(el).addClass("ui-widget-content");
			$(el).addClass("ui-corner-all");
			$(el).css("width", "204px");
			return el;
		},
		DateInputValue : function(elem, operation, value) {
			if (operation === 'get') {
				return $(elem).val();
			} else if (operation === 'set') {
				$(elem).val(value);
			}
		},
		InitGrid : function() {
			if ($String.Trim($("#gridTableFollow").html()) != "") {
				$("#gridTableFollow").jqGrid('setGridParam', {datatype : "json",postData : {
					"customerFollowId" : PageVar.ID,
					"customerType":PageVar.CustomerType
					}, page : 1}).trigger("reloadGrid");
			} else {
				// grid start
				$("#gridTableFollow").jqGrid({
					url : $Url.BuildCustomerUrl('/customer/customerFollow/ajaxListCustomerFollow.action'),
					editurl : $Url.BuildCustomerUrl("/customer/customerFollow/ajaxEditCustomerFollow.action"),
					datatype : "json",
					postData : {
						"customerFollowId" : PageVar.ID,
						"customerType":PageVar.CustomerType
						},
					mtype : 'GET',
					colNames : [ "操作", "编号", "推荐产品", "客户类型", "客户","跟踪类型", "跟踪时间", "下次跟踪时间", "跟踪内容","跟踪结果", "备注" ],
					colModel : [
								{
									name : "act",index : "act",	width : 60, align : "center",sortable : false
								},
								{
									name : "id",index : "id",width : 20,align : "center",sorttype : "number",formoptions : {rowpos : 1,	colpos : 1},editable : false,editoptions : {readonly : true,size : 20},hidden : true,editrules : {edithidden : true}
								},
								{
									name : "productNo",index : "productNo",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("productListByStatus30ForCustomerFollow",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 2,colpos : 2},sortable : false,editable : true,hidden : true,editrules : {edithidden : true}
								},
								{
									name : "customerType",index : "customerType",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("customerType",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 3,colpos : 1},sortable : false,editable : true,hidden : true,editrules : {edithidden : true}
								},
								{
									name : "customerNo",index : "customerNo",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("customerPerson",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 3,colpos : 2},sortable : false,	editable : true,hidden : true,editrules : {edithidden : true}
								},
								{
									name : "type",index : "type",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("cusFollowType",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 4,colpos : 1},sortable : false,editable : true
								},
								{ 
									name : "time",index : "time",width : 40,align : "left",formoptions : {rowpos : 4,colpos : 2},sortable : false,formatter : "date",formatoptions : {srcformat : 'Y-m-d H:i:s',newformat : 'Y-m-d H:i:s'},editable : true,edittype : 'custom',editoptions : {custom_element : JqGridManage.DateInputElem,custom_value : JqGridManage.DateInputValue,size : 20}
								},
								{
									name : "nexttime",index : "nexttime",width : 40,align : "left",formoptions : {rowpos : 5,colpos : 1},sortable : false,formatter : "date",formatoptions : {srcformat : 'Y-m-d H:i:s',newformat : 'Y-m-d H:i:s'},editable : true,edittype : 'custom',editoptions : {custom_element : JqGridManage.DateInputElem,custom_value : JqGridManage.DateInputValue,size : 20}
								},
								{
									name : "content",index : "content",width : 40,align : "left",formoptions : {rowpos : 6,colpos : 1},sortable : false,editable : true,edittype : 'textarea',editoptions : {size : 40},hidden : true,editrules : {edithidden : true}
								},
								{
									name : "result",index : "result",width : 40,align : "left",formoptions : {rowpos : 6,colpos : 2},sortable : false,editable : true,edittype : 'textarea',editoptions : {size : 20}
								}, 
								{	
									name : "editComment",index : "editComment",width : 20,align : "left",formoptions : {rowpos : 5,colpos : 2},sortable : false,editable : true,edittype : 'textarea',editoptions : {size : 20},hidden : true,editrules : {edithidden : true}
								} 
								],
									sortname : "id",
									sortorder : "desc",
									pager : "#gridPagerFollow",
									viewrecords : true,
									rowNum : 5,
									rowList : [ 5 ],
									altclass : "altRowsColour",
									shrinkToFit : true,
									autowidth : true,
									height : "auto",
									multiselect : true,
									prmNames : {
										search : "search",
										page : "pageIndex",
										rows : "pageSize"
									},
									jsonReader : {
										root : "resultList",
										page : "pageIndex",
										total : "pageCount",
										records : "recordCount",
										repeatitems : false
									},
									pager : "#gridPagerFollow",
									gridComplete : function() {
										var space = "|";
										var ids = $("#gridTableFollow").jqGrid(
												'getCol', 'id', true);
										for (var i = 0; i < ids.length; i++) {
											var id = ids[i].id;
											var detail = "";
											var edit = "";
											detail = "<a class=\"blue\" href=\"javascript:JqGridManage.GetDetail('" + id + "')\">查看</a>";
											$("#gridTableFollow").jqGrid("setRowData", id, {act : detail});
										}
									}
								});
			}
		},
		GetDetail : function(index) {
			$("#Follow").show();
			$("#hideId").val(index);
			var result = DataManager.getFollowInfo(index);
			$("#product_no").val(result.productNo);
			$("#followType").val(result.type);
			if (result.time!=null) {
				var followTime = new Date(result.time);
	            $("#followTime").val(followTime.format("yyyy-MM-dd hh:mm:ss"));	
			}else{
				$("#followTime").val("");
			}
			 
			if (result.nexttime!=null) {
				var nexttime = new Date(result.nexttime);
				$("#nexttime").val(nexttime.format("yyyy-MM-dd hh:mm:ss"));
			}else{
				$("#nexttime").val("");
			}
			 
			$("#contentFollow").val(result.content);
			$("#result").val(result.result);
			$("#edit_comment_follow").val(result.editComment);
			ElementManager.ElementFollowDisable();
			
		}	
	}
		

var thisAdd;
var ValidEmployee ={
		Validform:function(){
            thisAdd = $("#customerCompanyAdd").Validform({
			tiptype: function (msg, o, cssctl) {
	            var objtip = o.obj.siblings(".Validform_checktip");
	            cssctl(objtip, o.type);
	            objtip.text(msg);
	        },
	        datatype:{
	        	"verifyCardNumber": function (gets, obj, curform, datatype) {
	        		 var result;
	        		if (gets=="") {
						return true;
					}
	        		var url = $Url.BuildCustomerUrl("/customer/customerCompany/cardCheck.action");
                   
                    $.ajax({
                        type: "post",
                        url: url,
                        dataType: "json",
                        async: true,
                        data: { 
                        	cardNumber: $String.Trim(gets),
                            id:Number(PageVar.ID)
                        	},
                        success: function (data) {
                        	if (data.errCode=="failed") {
                            	result = data.errDesc;
							}
                        }
                    });
					return result;
                },
                "verifyTel": function (gets, obj, curform, datatype) {

                    var reg = /^\d{3,4}-\d{7,8}(-\d{3,4})?$/;
                    if (!reg.test(gets)) {
                        return false;
                    }
                    	return true;
                }
	        },
	        callback: function (form) {	    
	        	if(!$("#submit").attr("process") == undefined)
	                return false;
	            var url = $Url.BuildCustomerUrl("/customer/customerCompany/ajaxSetInfo");
	            $.ajax({
	                type: "post",
	                url: url,
	                datatype: "json",
	                timeout: 30000,
	                data: {
	                	customerId:Number(PageVar.ID),
	                	findTime:$("#findTime").val(),
		    			name:$("#name").val(),
		    			code:$("#code").val(),
		    			cardLicense:$("#cardLicense").val(),
		    			cardNumber:$("#cardNumber").val(),
		    			cardTax:$("#cardTax").val(),
		    			address:$("#address").val() ,
		    			telephone:$("#telephone").val(),
		    			email:$("#email").val(),
		    			field:$("#field").val(),
		    			contactName:$("#contactName").val(),
		    			contactTelephone:$("#contactTelephone").val() ,
		    			contactCellphone1:$("#contactCellphone1").val(),
		    			contactCellphone2:$("#contactCellphone2").val(),
		    			relationLevel:$("#relationLevel").val() ,
		    			riskHobby:$("#riskHobby").val() ,
		    			agentNo:$("#agentNo").val(), 
		    			deptNo:$("#deptNo").val() ,
		    			wealth:$("#wealth").val(),
		    			tradeTotal:$("#tradeTotal").val(), 
		    			editComment:$("#editComment").val(),
		    			isTest:$("#isTest").val(),
		    			memberClassType:$("#memberClassType").val(),
		    			legal:$("#legal").val(),
		    			legalIdcard:$("#legalIdcard").val(),
		    			bankLicense:$("#bankLicense").val()
	                },
	                beforeSend: function () {
	                    $("#submit").attr("process", "processing");
	                },
	                error: function (XMLHttpRequest, textStatus, errorThrown) {
	                    alert(errorThrown);
	                },
	                success: function (data, textStatus) {
	                    if (data.errCode == "OK") {
	                    	window.location.href = $Url.BuildCustomerUrl("/customer/customerCompany/edit?id=")+data.customerId;
	                    } else {
	                        alert(data.errDesc)
	                    }
	                },
	                complete: function (XMLHttpRequest, textStatus) {
	                    $("#submit").removeAttr("process");
	                }
	            });

	            return false;
	        }
	    });
		thisAdd.addRule([
			{
				 ele:"#cardNnumber",
			     dataType:"verifyCardNumber",
			     ignore:"ignore",
			     nullmsg:"",
			     sucmsg:" ",
			     errmsg:"证件已经存在或者错误"
			},
			{
				 ele:"#cardLicense",
				 ignore:"ignore",
				 dataType:"n",
			     nullmsg:"请填写组织机构代码",
			     sucmsg:" ",
			     errmsg:"请填写正确的组织机构代码（全数字）"
			},
			{
				 ele:"#cardNumber",
				 ignore:"ignore",
				 dataType:"*",
			     nullmsg:"请填写营业执照",
			     sucmsg:" ",
			     errmsg:"请填写正确的营业执照"
			},
			{
				 ele:"#cardTax",
				 ignore:"ignore",
				 dataType:"n",
			     nullmsg:"请填写税务证",
			     sucmsg:" ",
			     errmsg:"请填写正确的税务证（全数字）"
			},
			{
				 ele:"#wealth",
				 ignore:"ignore",
			     dataType:"n",
			     nullmsg:"",
			     sucmsg:" ",
			     errmsg:"请填写数字"
			},
			{
				 ele:"#tradeTotal",
				 ignore:"ignore",
			     dataType:"n",
			     nullmsg:"",
			     sucmsg:" ",
			     errmsg:"请填写数字"
			},
	        {
	        	 ele:"#name",
	             dataType:"s1-18",
	             nullmsg:"请填写名称",
	             sucmsg:"",
	             errmsg:"请填写正确的名称"
	        },
	        {
	            ele:"#email",
	            datatype:"e",//  汉字验证/^[\u4E00-\u9FFF]+$/
	            ignore:"ignore",
	            nullmsg:"请填写邮箱",
	            errormsg:"请填写正确的邮箱信息",
	            sucmsg:" "
	        },//
	        {				
	            ele:"#telephone",
	            datatype:"verifyTel",
	            ignore:"ignore",
	            nullmsg:" ",
	            errormsg:"电话格式000-xxxxyyyy",
	            sucmsg:" "
	        },
	        {				
	            ele:"#contactTelephone",
	            datatype:"verifyTel",
	            ignore:"ignore",
	            nullmsg:" ",
	            errormsg:"电话格式000-xxxxyyyy",
	            sucmsg:" "
	        },
	        {
	            ele:"#contactCellphone1",
	            datatype:"m",
	            ignore:"ignore",
	            nullmsg:"请填写手机号",
	            errormsg:"请填写正确的手机号",
	            sucmsg:" "
	        },
	        {
	            ele:"#contactCellphone2",
	            datatype:"m",
	            ignore:"ignore",
	            nullmsg:" ",
	            errormsg:"请填写正确的手机号",
	            sucmsg:" "
	        }
	        ]);
	    },
	    ValidFollow:function(){
	    	var thisFollow = $("#Follow").Validform({
				tiptype: function (msg, o, cssctl) {
		            var objtip = o.obj.siblings(".Validform_checktip");
		            cssctl(objtip, o.type);
		            objtip.text(msg);
		        },
		        datatype:{
		        },
		        callback: function (form) {	    
		        	if(!$("#submit").attr("process") == undefined)
					return false;
		            var url = $Url.BuildCustomerUrl("/customer/customerFollow/ajaxSetFollowInfo");
		            $.ajax({
		                type: "post",
		                url: url,
		                datatype: "json",
		                timeout: 30000,
		                data: {
		                	hideId:$("#hideId").val(),
		                	customerId:Number(PageVar.ID),
		                	customerType:Number(PageVar.CustomerType),
		                	productNo:$("#product_no").val(),
		                	followType:$("#followType").val(),
			    			followTime:$("#followTime").val(),
			    			nexttime:$("#nexttime").val(),
			    			contentFollow:$("#contentFollow").val() ,
			    			result:$("#result").val(),
			    			editComment:$("#edit_comment_follow").val()
		                },
		                beforeSend: function () {
		                    $("#submit").attr("process", "processing");
		                },
		                error: function (XMLHttpRequest, textStatus, errorThrown) {
		                    alert(errorThrown);
		                },
		                success: function (data, textStatus) {
		                    if (data.errCode == "OK") {
		                    	JqGridManage.InitGrid();
		                    	$("#Follow").hide();
		                    } else {
		                        alert(data.errDesc)
		                    }
		                },
		                complete: function (XMLHttpRequest, textStatus) {
		                    $("#submit").removeAttr("process");
		                }
		            });

		            return false;
		        }
		    });
	    	thisFollow.addRule([
		        {
		        	 ele:"#contentFollow",
		             dataType:"*",
		             nullmsg:"请描述跟踪",
		             sucmsg:" ",
		             errmsg:""
		        },
		        {
		        	 ele:"#result",
		             dataType:"*",
		             nullmsg:"请描述结果",
		             sucmsg:" ",
		             errmsg:""
		        }
		        ]);
	    }
	    
}



var ManagePage = {
	    EnableInput: function () {
	        $.each($(".data"), function (index, content) {
	            var id = $(this).attr("id");
	            if (ElementVar[id] == undefined) {
	                $(this).removeAttr("disabled");
	            } else {
	                if (Number(PageVar.ID) == 0){
	                    if (ElementVar[id] != TagPermissionType.none){
	                        $(this).removeAttr("disabled");
	                    }
	                }else if (Number(PageVar.ID) != 0){
	                    if (ElementVar[id] == TagPermissionType.edit)
	                        $(this).removeAttr("disabled");
	                }
	            }

	        });
	    },
	    DisableInput: function () {
	        $(".data").attr("disabled", "disabled");
	    },
	    DoundP2pCustomer:function (id,inputUserName) {
	    	if(confirm("确定要绑定p2p客户？")){
	    		var url = $Url.BuildCustomerUrl("/customer/customerCompany/ajaxDoundP2pCustomer");
		        $.ajax({
		                type: "POST",
		                url: url,
		                async:false,
		                data: {
		                    id:id,
		                    inputUserName:$String.Trim(inputUserName)
		                },
		                error: function(XMLHttpRequest, textStatus, errorThrown) {
		                        alert(XMLHttpRequest.status);
		                        alert(XMLHttpRequest.readyState);
		                        alert(textStatus);
		                    },
		                success: function (data) {
		                	if(data.errCode=="OK"){
		                		if(data.paymentData.url==undefined){
	    							alert("绑定失败！");
	    							return;
	    						}
		                		//alert(data.errDesc);
		                		var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+" method=\"post\"></form>";
	    		                $("body").first().append(paymentObj);
	    		                var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
	    		                    "<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
	    		                $(".pay_data").html(input);
	    		                $(".pay_data").submit();
		                		//window.location.href=$Url.BuildCustomerUrl("/customer/customerCompany/detail?id=")+id;
		                	}else{
		                		alert(data.errDesc);
		                	}
		                }
		            }
		        );
	    	}
	        
	    },
	    GetP2pCustomer: function (id) {
	        var url = $Url.BuildCustomerUrl("/customer/p2pCustomer/ajaxGetP2pCustomer");
	        $.ajax({
	            type: "post",
	            url: url,
	            dataType: "json",
	            timeout: 30000,
	            data: { id: id },
	            beforeSend: function () {
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert(errorThrown);
	            },
	            success: function (data, textStatus) {
	                if (data.errCode == "0000") {
	                	$("#customerName").val(data.userName);
	                }
	                
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
	    }
}

$(function(){
	var thisId = Number(PageVar.ID);
	BindEnumList.BindAll();
	
	if (thisId>0) {
		JqGridManage.InitGrid();
		$("#btnAddFollow").show();
	}else{
		$("#btnAddFollow").hide();
		$("hr").hide();
	}
	InitValue.InitMemberClassType();
	if (thisId!=0) {
		InitValue.InitValueforDetail(thisId);	
		ElementManager.ElementDisable();
		
	}else{
		ElementManager.ElementUnDisable();
		$Util.InitElement(ElementVar);
		ElementManager.HideEditButton();
        $("#agentNo").val(PageVar.UserId)
	}
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "agentNo", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:3,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:200,			//宽，单位px
        height:300			//高，单位px
    });
	var i = 0;
	$("#edit").click(function(){
		if (i%2==0) {
			ElementManager.ElementUnDisable();
			ElementManager.HideEditButton();
		}
		if (i%2==1) {
			ElementManager.ElementDisable();
			ElementManager.ShowEditButton();
		}
		i=i+1;
	});
	
	
	var j = 0;
	$("#editFollow").click(function(){
		if (j%2==0) {
			ElementManager.ElementFollowUnDisable();	
		}
		if (j%2==1) {
			ElementManager.ElementFollowDisable();
		}
		j=j+1;
	});
	
	$("#back").click(function(){
		window.close();
	});
    
    $("#btnAddFollow").click(function(){
    	$("#Follow").show();
    	ElementManager.ElementFollowClean();
    	ElementManager.ElementFollowUnDisable();
	});
    
    $("#followTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#nexttime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#findTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    
    ValidEmployee.Validform();
    ValidEmployee.ValidFollow();
    if(thisId>0){
    	$("#showP2pCustomer").show();
    	if($("#customerNo").val()==0){
    		$("#customerName").val("绑定p2p客户").addClass("ml20 data").attr("type","button");
    		$("#customerName").attr("disabled",true);
    		$("#customerName").click(function(){
    			////////
    			thisAdd.unignore("#cardNumber,#cardLicense,#cardTax,#email,#contactCellphone1");//重置表单验证规则
    			thisAdd.addRule([
	     			{
	     				 ele:"#memberClassType",
	     			     dataType:"*",
	     			     nullmsg:"请填写企业类型",
	     			     sucmsg:" ",
	     			     errmsg:""
	     			},
	     			{
	     				 ele:"#bankLicense",
	     				 dataType:"*",
	     			     nullmsg:"请填写开户银行许可证",
	     			     sucmsg:" ",
	     			     errmsg:""
	     			},
	     			{
	     				 ele:"#cardLicense",
	     				 dataType:"*",
	     			     nullmsg:"请填写组织机构代码",
	     			     sucmsg:" ",
	     			     errmsg:""
	     			},
	     			{
	     				 ele:"#cardNumber",
	     				 dataType:"*",
	     			     nullmsg:"请填写营业执照",
	     			     sucmsg:" ",
	     			     errmsg:""
	     			},
	     			{
	     				 ele:"#cardTax",
	     			     dataType:"*",
	     			     nullmsg:"请填写税务证",
	     			     sucmsg:" ",
	     			     errmsg:""
	     			},
	     			{
	     				 ele:"#legal",
	     			     dataType:"*",
	     			     nullmsg:"请填写法人姓名",
	     			     sucmsg:" ",
	     			     errmsg:""
	     			},
	     	        {
	     	        	 ele:"#legalIdcard",
	     	             dataType:"IDCard",
	     	             nullmsg:"请填写法人身份证",
	     	             sucmsg:"",
	     	             errmsg:"请填写正确的法人身份证"
	     	        },
	     	        {
	     	            ele:"#contactName",
	     	            datatype:"*",//  汉字验证/^[\u4E00-\u9FFF]+$/
	     	            nullmsg:"请填写联系人姓名",
	     	            errormsg:"",
	     	            sucmsg:" "
	     	        },
	     	        {
	     	            ele:"#email",
	     	            datatype:"e",//  汉字验证/^[\u4E00-\u9FFF]+$/
	     	            nullmsg:"请填写邮箱",
	     	            errormsg:"请填写正确的邮箱信息",
	     	            sucmsg:" "
	     	        },
	     	        {				
	     	            ele:"#contactCellphone1",
	     	            datatype:"/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/",
	     	            nullmsg:"请填写联系人手机号码",
	     	            errormsg:"请填写正确的手机号码",
	     	            sucmsg:" "
	     	        }
     	        ]);
    			if($("#name").val()==null||$("#name").val()==""){alert("请填写企业客户名");$("#name").focus();return;}
    			if($("#memberClassType").val()==null||$("#memberClassType").val()==""){alert("请填写企业类型");$("#memberClassType").focus();return;}
    			if($("#cardLicense").val()==null||$("#cardLicense").val()==""){alert("请填写营业执照");$("#cardNumber").focus();return;}
    			if($("#cardNumber").val()==null||$("#cardNumber").val()==""){alert("请填写组织机构代码");$("#cardLicense").focus();return;}
    			if($("#legal").val()==null||$("#legal").val()==""){alert("请填写法人姓名");$("#legal").focus();return;}
    			if($("#legalIdcard").val()==null||$("#legalIdcard").val()==""){alert("请填写法人身份证");$("#legalIdcard").focus();return;}
    			if($("#cardTax").val()==null||$("#cardTax").val()==""){alert("请填写税务证");$("#cardTax").focus();return;}
    			if($("#bankLicense").val()==null||$("#bankLicense").val()==""){alert("请填写开户银行许可证");$("#bankLicense").focus();return;}
    			if($("#email").val()==null||$("#email").val()==""){alert("请填写公司邮箱");$("#email").focus();return;}
    			if($("#contactName").val()==null||$("#contactName").val()==""){alert("请填写联系人姓名");$("#contactName").focus();return;}
    			if($("#contactCellphone1").val()==null||$("#contactCellphone1").val()==""){alert("请填写联系人手机");$("#contactCellphone1").focus();return;}
    			var inputUserName = prompt('请为该企业用户设定p2p用户名：');
    	    	if(inputUserName==null||inputUserName==""){
    	    		alert("设定p2p用户名后才能进行绑定！");
    	    		return;
	    		}else{
	    			var reg = /^[a-zA-Z0-9]{4,20}$/;
	                if (!reg.test(inputUserName)) {
	                    alert("p2p用户名为4~20位字符，支持数字、字母，不能有特殊字符、下划线");//false;
	                    return;
	                }

	                var url1 = $Url.BuildCustomerUrl("/customer/p2pCustomer/ajaxCheckUserExist");//请求到 验证用户存在的action的方法上
	                var flag = true;
	                $.ajax({
	                    type: "get",
	                    url: url1,
	                    dataType: "json",
	                    async: false,
	                    data: { userName: $String.Trim(inputUserName) },
	                    success: function (data) {
	                        if (data.errCode!= "0000"){
	                        	alert(data.errDesc);
	                        	flag = false;
	                        }
	                    }
	                });
	                if(!flag){return;}
	                ManagePage.DoundP2pCustomer(thisId,inputUserName);
	    		}
        	});
    	}else{
    		ManagePage.GetP2pCustomer($("#customerNo").val());
    	}
        
    }else{
    	$("#showP2pCustomer").hide();
    }
    
});






