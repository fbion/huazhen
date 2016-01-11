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
            if($(this).eq("#code")){
                $("#code").attr("disabled","disabled");
            }
            if($(this).eq("#editComment")){
                $("#editComment").attr("disabled","disabled");
            }
        });
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
    },
    ShowEditButton: function (currStatus) {
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

    },
    GetInfo: function (id) {
        var url = $Url.BuildCustomerUrl("/customer/agentBusiness/ajaxGetAgentBusiness");
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
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                $Util.DataToVal(data.info, ElementVar);


                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();
                        if(ElementVar.updateManagerNo1!="none"){
                            $("#employeeSel").removeAttr("disabled");
                        }
                    });
                }
                EmployeeTreeControl.startTree({
                    param: "on",  //on在职员工，out离职员工，test测试员工
                    treeInputId: "employeeSel",//员工控件框ID
                    valInputId: "managerNo", //员工值框id
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
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}

var Bind ={
		BindAll:function(){
		EnumList.GetEnumListToSelect($("#managerNo"),"empManager",$Url.BuildCustomerUrl("/common/enumList.action"));
	    EnumList.GetEnumListToSelect($("#relationLevel"),"dicDataforCustomerCompanyRelationLevel",$Url.BuildCustomerUrl("/common/enumList.action"));
		EnumList.GetEnumListToSelect($("#sourceType"), "customerPersonalSourceTypeList", $Url.BuildCustomerUrl("/common/enumList.action"));
	    EnumList.GetEnumListToSelect($("#contactImportance"),"dicDataforCustomerAgentBussinessImportance",$Url.BuildCustomerUrl("/common/enumList.action"));
	    Bind.BindProduct();
	    Bind.BindCusFollowType();
		},
		BindProduct:function(){
			EnumList.GetEnumListToSelect($("#product_no"), "productListByStatus30ForCustomerFollow", $Url.BuildCustomerUrl("/common/enumList.action"));
		},
		BindCusFollowType:function(){
			EnumList.GetEnumListToSelect($("#followType"), "cusFollowType", $Url.BuildCustomerUrl("/common/enumList.action"));
		}
}


var ElementManager={
		ElementFollowDisable:function(){
			$("#product_no").attr('disabled','true');
			$("#followType").attr('disabled','true');
			$("#followTime").attr('disabled','true');
			$("#nexttime").attr('disabled','true');
			$("#contentFollow").attr('disabled','true');
			$("#result").attr('disabled','true');
			$("#edit_comment_follow").attr('disabled','true');
			$("#contacts").attr('disabled','true');
			$("#position").attr('disabled','true');
			$("#isTest").attr('disabled','true');
		},
		ElementFollowUnDisable:function(){
			$("#product_no").removeAttr("disabled");
			$("#followType").removeAttr("disabled");
			$("#followTime").removeAttr("disabled");
			$("#nexttime").removeAttr("disabled");
			$("#contentFollow").removeAttr("disabled");
			$("#result").removeAttr("disabled");
			$("#edit_comment_follow").removeAttr("disabled");
			$("#contacts").removeAttr("disabled");
			$("#position").removeAttr("disabled");
			$("#isTest").removeAttr("disabled");
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
			$("#contacts").val("");
			$("#position").val("");
		}
		
}



var JqGridManage={
		DateInputElem : function(value, options) {
			var el = document.createElement("input");
			el.type = "text";
			el.value = value;
			el.onclick = function() {el.focus();el.select(); WdatePicker({dateFmt : 'yyyy-MM-dd  HH:mm:ss'	});	};// HH:mm:ss
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
				$("#gridTableFollow").jqGrid('setGridParam', {datatype : "json",
					postData : {
						"agentId" : Number(PageVar.ID),
						"agentType":Number(PageVar.AgentType)
						}, page : 1})
						.trigger("reloadGrid");
			} else {
				// grid start
				$("#gridTableFollow").jqGrid({
					url : $Url.BuildCustomerUrl('/customer/agentFollow/ajaxListAgentFollow.action'),
					editurl : $Url.BuildCustomerUrl("/customer/agentFollow/ajaxEditAgentFollow.action"),
					datatype : "json",
					postData : {
						"agentId" : Number(PageVar.ID),
						"agentType":Number(PageVar.AgentType)
						},
					mtype : 'GET',
					colNames: ["操作","id","产品","跟踪类型","本次联系人","联系人职位","跟踪类型","跟踪时间","下次跟踪时间","跟踪内容","跟踪结果","修改备注"],//,"产品类型"
					colModel: [

								{
									name: "act", index: "act", width: 60, align: "center", sortable: false
								},
								{
									name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }, hidden : true, editrules : {edithidden : true}
								},
//								{
//									name: "productType", index: "productType", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
//								},
								{
									name : "productNo",index : "productNo",width : 40,align : "left",formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("productListByStatus30ForCustomerFollow",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 2,colpos : 2},sortable : false,editable : true,hidden : true,editrules : {edithidden : true}
								},
								{
									name: "agentType", index: "agentType", width: 40, align: "left", formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("customerTypeAll",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 3,colpos : 1},sortable : false,editable : true,hidden : true,editrules : {edithidden : true}
								},
								{
									name: "contacts", index: "contacts", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden : true, editrules : {edithidden : true}
								},
								{
									name: "position", index: "position", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden : true, editrules : {edithidden : true}
								},
								{
									name: "type", index: "type", width: 40, align: "left", formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("cusFollowType",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 5,colpos : 1},sortable : false,editable : true
								},
								{
									name: "time", index: "time", width: 40, align: "left", formatter:"date" ,formoptions: { rowpos: 5, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: JqGridManage.DateInputElem, custom_value: JqGridManage.DateInputValue, size: 40 }
								},
								{
									name: "nexttime", index: "nexttime", width: 40, align: "left", formatter:"date" , formoptions: { rowpos: 6, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: JqGridManage.DateInputElem, custom_value: JqGridManage.DateInputValue, size: 40 }
								},
								{
									name: "content", index: "content", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden : true, editrules : {edithidden : true}
								},
								{
									name: "result", index: "result", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
								},
								{
									name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, hidden : true, editrules : {edithidden : true}
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
			$("#contacts").val(result.contacts);
			$("#position").val(result.position);
			$("#contentFollow").val(result.content);
			$("#result").val(result.result);
			$("#edit_comment_follow").val(result.editComment);
			ElementManager.ElementFollowDisable();
			
		}	
}


var DataManager={
		getFollowInfo:function(id){
			var result;
			var url = $Url.BuildCustomerUrl("/customer/agentFollow/ajaxGetFollowInfoById");
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
		    			result = data.agentFollow;
		    		},
		    		complete:function(XMLHttpRequest,textStatus){}
		    	});
		    	return result;
		}
}


var Valid={
		ValidAdd:function(){
			   var agentBusinessAdd = $("#agentBusinessAdd").Validform({
			        tiptype: function (msg, o, cssctl) {
			            var objtip = o.obj.siblings(".Validform_checktip");
			            cssctl(objtip, o.type);
			            objtip.text(msg);
			        },
			        callback: function (form) {
			            if (!($("#submit").attr("process") === undefined)) {
			                return false;
			            }
			            var url = $Url.BuildCustomerUrl("/customer/agentBusiness/ajaxEditAgentBusiness");
			            var oper = "add";
			            if (Number(PageVar.ID) != 0)
			                oper = "edit";

			            var info = {
			                id: PageVar.ID,
			                code: $("#code").val(),
			                name: $("#name").val(),
			                email: $("#email").val(),
			                telephone: $("#telephone").val(),
			                owner: $("#owner").val(),
			                website: $("#website").val(),
			                address: $("#address").val(),
			                contactPrimary: $("#contactPrimary").val(),
			                contactPosition: $("#contactPosition").val(),
			                contactWeixin: $("#contactWeixin").val(),
			                contactQq: $("#contactQq").val(),
			                contactCellphone1: $("#contactCellphone1").val(),
			                contactCellphone2: $("#contactCellphone2").val(),
			                contactTelephone: $("#contactTelephone").val(),
			                contactAddress: $("#contactAddress").val(),
			                contactImportance: $("#contactImportance").val(),
			                comment: $("#comment").val(),
			                relationLevel: $("#relationLevel").val(),
			                saleTotal: $("#saleTotal").val(),
			                managerNo: $("#managerNo").val(),
			                editComment: $("#editComment").val(),
			                isTest: $("#isTest").val(),
							sourceType:$("#sourceType").val()
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
			                        window.location.href = $Url.BuildCustomerUrl("/customer/agentBusiness/detail?id=" + data.errDesc);
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
			    agentBusinessAdd.addRule([
			        {
			            ele:"#name",
			            dataType:"s1-18",
			            nullmsg:"请填写公司名称",
			            sucmsg:" ",
			            errmsg:"请填写正确的公司名称"
			        },
			        {
			            ele:"#website",
			            dataType:"url",
			            ignore:"ignore",
			            errormsg:"请填写正确格式的网站",
			            sucmsg:" "
			        },
			        {
			            ele:"#email",
			            dataType:"e",
			            nullmsg:"请填写邮箱地址",
			            errormsg:"请填写正确的邮箱地址",
			            sucmsg:" "
			        },
			        {
			            ele:"#contactPrimary",
			            dataType:"s1-18",
			            nullmsg:"请填写联系人",
			            sucmsg:" ",
			            errmsg:"请填写正确的联系人"
			        },
			        {
			            ele:"#telephone",
			            dataType:/^\d{3,4}-\d{7,8}(-\d{3,4})?$/,
			            nullmsg:"请填写企业电话",
			            errormsg:"请填写正确的企业电话（区号-电话）",
			            sucmsg:" "
			        },
			        {
			            ele:"#contactCellphone1",
			            dataType:"m",
			            nullmsg:"请填写手机号",
			            errormsg:"请填写正确的手机号",
			            sucmsg:" "
			        },
			        {
			            ele:"#contactCellphone2",
			            dataType:"m",
			            ignore:"ignore",
			            errormsg:"请填写正确的手机号",
			            sucmsg:" "
			        },
			        {
			            ele:"#contactTelephone",
			            dataType:/^\d{3,4}-\d{7,8}(-\d{3,4})?$/,
			            ignore:"ignore",
			            errormsg:"请填写正确的企业电话（区号-电话）",
			            sucmsg:" "
			        },
			        {
			            ele:"#contactQq",
			            dataType:"n",
			            ignore:"ignore",
			            errormsg:"请填写正确格式的QQ号",
			            sucmsg:" "
			        }
			    ]);
		},
		ValidFollow:function(){
	    	var employeeAdd = $("#Follow").Validform({
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
		            var url = $Url.BuildCustomerUrl("/customer/agentFollow/ajaxSetFollowInfo");
		            $.ajax({
		                type: "post",
		                url: url,
		                datatype: "json",
		                timeout: 30000,
		                data: {
		                	hideId:$("#hideId").val(),
		                	agentId:Number(PageVar.ID),
		                	agentType:Number(PageVar.AgentType),
		                	productNo:$("#product_no").val(),
		                	followType:$("#followType").val(),
			    			followTime:$("#followTime").val(),
			    			nexttime:$("#nexttime").val(),
			    			contentFollow:$("#contentFollow").val() ,
			    			result:$("#result").val(),
			    			editComment:$("#edit_comment_follow").val(),
			    			contacts:$("#contacts").val(),
			    			position:$("#position").val(),
			                isTest: $("#isTest").val()
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
			employeeAdd.addRule([
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




$(function () {
	Bind.BindAll();
	
	$("#back").click(function () {
        $EasyUI.Close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
        $("#btnAddFollow").hide();
        $("hr").hide();
        $("#managerNo").val(PageVar.UserId);
    }else {
    	ManagePage.GetInfo(PageVar.ID);
    	JqGridManage.InitGrid();
    }

    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "managerNo", //员工值框id
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
    $("#btnAddFollow").click(function () {
    		 $("#Follow").show();
    		 ElementManager.ElementFollowClean();
    		 ElementManager.ElementFollowUnDisable();	
    });
    
    $("#editFollow").click(function () {
    		ElementManager.ElementFollowUnDisable();	
    });
    
    
    $("#followTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#nexttime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    
    
    Valid.ValidAdd();
    Valid.ValidFollow();
 
})
