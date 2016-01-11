var ManagePage = {
	Resize: function () {
        $("#content_center").css("min-height", "1100px");
    },
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
        });
    },
    DisableInput: function () {
        $(".data").attr("disabled", "disabled");
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

    },
    GetInfo: function (id) {
        var url = $Url.BuildProductUrl("/product/partnerIssuer/ajaxGetPartnerIssuer");
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
                        if(ElementVar.updateAgentNo=="none"){
                            return;
                        }
                        $("#employeeSel").removeAttr("disabled");
                    });
                }
                EmployeeTreeControl.startTree({
                    param: "on",  //on在职员工，out离职员工，test测试员工
                    treeInputId: "employeeSel",//员工控件框ID
                    valInputId: "empNo", //员工值框id
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


//List for follow  ===============================================================================
var ManagePageFollowList = {
	    DateInputElem: function (value, options) {
	        var el = document.createElement("input");
	        el.type = "text";
	        el.value = value;
	        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' }); };
	        $(el).addClass("FormElement");
	        $(el).addClass("ui-widget-content");
	        $(el).addClass("ui-corner-all");
	        $(el).css("width", "204px");
	        return el;
	    },
	    DateInputValue: function (elem, operation, value) {
	        if (operation === 'get') {
	            return $(elem).val();
	        } else if (operation === 'set') {
	            $(elem).val(value);
	        }
	    },
	    InitGrid: function () {
	    	if ($String.Trim($("#gridTableFollow").html()) != "") {
				$("#gridTableFollow").jqGrid('setGridParam', {datatype : "json",
					postData : {
						"agentId" : Number(PageVar.ID),
						"agentType":Number(PageVar.AgentType)
						}, page : 1})
						.trigger("reloadGrid");
			} else {
	        //grid start
	        $("#gridTableFollow").jqGrid({
	            url: $Url.BuildProductUrl('/product/partnerIssuerFollow/ajaxListPartnerIssuerFollow.action'),
	            editurl: $Url.BuildProductUrl("/product/partnerIssuerFollow/ajaxEditPartnerIssuerFollow.action"),
	            datatype: "json",
	            postData : {
					"agentId" : Number(PageVar.ID),
					"agentType":Number(PageVar.AgentType)
					},
	            mtype: 'GET',
	            colNames: ["操作","id","推荐产品","跟踪类型","跟踪的客户","本次联系人","联系人职位","跟踪类型","跟踪时间","下次跟踪时间","跟踪内容","跟踪结果","修改备注"],//,"产品类型"
	            colModel: [

					{
						name: "act", index: "act", width: 60, align: "center", sortable: false
					},
					{
						name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 },hidden : true,editrules : {edithidden : true}
					},
//					{
//						name: "productType", index: "productType", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
//					},
					{
						name: "productNo", index: "productNo", width: 40, align: "left", formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("productListByStatus30ForCustomerFollow",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 2,colpos : 2},sortable : false,editable : true,hidden : true,editrules : {edithidden : true}
					},
					{
						name: "agentType", index: "agentType", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden : true,editrules : {edithidden : true}
					},
					{
						name: "agentNo", index: "agentNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden : true,editrules : {edithidden : true}
					},
					{
						name: "contacts", index: "contacts", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden : true,editrules : {edithidden : true}
					},
					{
						name: "position", index: "position", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden : true,editrules : {edithidden : true}
					},
					{
						name: "type", index: "type", width: 40, align: "left", formatter : "select",edittype : "select",editoptions : {size : 1,value : EnumList.GetEnumListToEdit("cusFollowType",$Url.BuildCustomerUrl("/common/enumList.action"))},formoptions : {rowpos : 5,colpos : 1},sortable : false,editable : true
					},
					{
						name: "time", index: "time", width: 40, align: "left",formatter:"date", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePageFollowList.DateInputElem, custom_value: ManagePageFollowList.DateInputValue, size: 40 }
					},
					{
						name: "nexttime", index: "nexttime", width: 40, align: "left",formatter:"date", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePageFollowList.DateInputElem, custom_value: ManagePageFollowList.DateInputValue, size: 40 }
					},
					{
						name: "content", index: "content", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden : true,editrules : {edithidden : true}
					},
					{
						name: "result", index: "result", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
					},
					{
						name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden : true,editrules : {edithidden : true}
					}                
	            ],
	            sortname: "id",
	            sortorder: "desc",
	            viewrecords: true,
	            rowNum: 5,
	            rowList: [5],
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
	            jsonReader: {
	                root: "resultList",
	                page: "pageIndex",
	                total: "pageCount",
	                records: "recordCount",
	                repeatitems: false
	            },
	            pager: "#gridPagerFollow",
	            gridComplete: function () {
	                var ids = $("#gridTableFollow").jqGrid('getCol', 'id', true);
	                for (var i = 0; i < ids.length; i++) {
	                    var id = ids[i].id;
	                    var detail = "";
	                    detail = "<a class=\"blue\" href=\"javascript:ManagePageFollowList.GetDetail('" + id + "')\">查看</a>";
	                    $("#gridTableFollow").jqGrid("setRowData", id, { act: detail });
	                }
	            }
	        });
			}
	    },
	    InitQuery: function () {
	        $("#btnSearch").click(function () {
	            //var byName = $("#byName").val();
	            $("#gridTable").jqGrid('setGridParam', {
	                datatype: "json",
	                //postData: { "byName": byName },
	                page: 1
	            }).trigger("reloadGrid");
	        });
	    },
	    GetDetail: function (index) {
	    	
	    	$("#hideId").val(index);
//	        window.location.href = $Url.BuildProductUrl("/product/partnerIssuerFollow/edit?id="+index);
	    	if ($("#follow").attr("hidden")=="hidden") {
	    		$("#follow").show();
	    		$("#follow").removeAttr("hidden")
	    		ManagePageFollowAdd.DisabledInput();
	    		ManagePageFollowAdd.GetInfo(index);
	    		
	    		
			}else{
				$("#follow").hide();
				$("#follow").attr("hidden","hidden");
			}
	    },
	    GetAdd: function () {
	    	$("#hideId").val(0);
	    	if ($("#follow").attr("hidden")=="hidden") {
	    		$("#follow").show();
	    		$("#follow").removeAttr("hidden")
	    		ManagePageFollowAdd.UnDisabledInput();
	    		ManagePageFollowAdd.CleanElement();
			}else{
				$("#follow").hide();
				$("#follow").attr("hidden","hidden");
			}
	    	ManagePageFollowAdd.HideEditButton();
	    	
	    }
	}


//Add for follow   ===============================================================================
var ManagePageFollowAdd = {
	    UnDisabledInput: function () {
	    	$("#productType").removeAttr("disabled");
			$("#productNo").removeAttr("disabled");
			$("#agentType").removeAttr("disabled");
			$("#agentNo").removeAttr("disabled");
			$("#contacts").removeAttr("disabled");
			$("#position").removeAttr("disabled");
			$("#followType").removeAttr("disabled");
			$("#time").removeAttr("disabled");
			$("#nexttime").removeAttr("disabled");
			$("#content").removeAttr("disabled");
			$("#result").removeAttr("disabled");
			$("#editComment").removeAttr("disabled");
	    },
	    DisabledInput:function(){
	    	$("#productType").attr("disabled","disabled");
			$("#productNo").attr("disabled","disabled");
			$("#agentType").attr("disabled","disabled");
			$("#agentNo").attr("disabled","disabled");
			$("#contacts").attr("disabled","disabled");
			$("#position").attr("disabled","disabled");
			$("#followType").attr("disabled","disabled");
			$("#time").attr("disabled","disabled");
			$("#nexttime").attr("disabled","disabled");
			$("#content").attr("disabled","disabled");
			$("#result").attr("disabled","disabled");
			$("#editComment").attr("disabled","disabled");
	    },
	    CleanElement:function(){
	    	$("#productType").val("");
			$("#productNo").val("");
			$("#agentType").val("");
			$("#agentNo").val("");
			$("#contacts").val("");
			$("#position").val("");
			$("#type").val("");
			$("#time").val("");
			$("#nexttime").val("");
			$("#content").val("");
			$("#result").val("");
			$("#editComment").val("");
	    },
	    ShowEditButton: function (currStatus) {
	        if ($("#editFollow").length > 0)
	            $("#editFollow").show();
	        if ($("#submitFollow").length > 0)
	            $("#submitFollow").hide();

	    },
	    HideEditButton: function () {
	        if ($("#editFollow").length > 0)
	            $("#editFollow").hide();
	        if ($("#submitFollow").length > 0)
	            $("#submitFollow").show();

	    },
	    GetInfo: function (id) {
	        var url = $Url.BuildProductUrl("/product/partnerIssuerFollow/ajaxGetPartnerIssuerFollow");
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
	                	alert(data.errDesc);
	                    $("#msg").text(data.errDesc);
	                    return;
	                }
	                $Util.DataToVal(data.info, ElementVar);
					if (!$String.IsNullOrEmpty(data.info.time)) {
						var time = new Date(data.info.time);
						$("#time").val(time.format("yyyy-MM-dd HH:mm:ss"));
						}
					if (!$String.IsNullOrEmpty(data.info.nexttime)) {
						var nexttime = new Date(data.info.nexttime);
						$("#nexttime").val(nexttime.format("yyyy-MM-dd HH:mm:ss"));
						}


	                ManagePageFollowAdd.ShowEditButton();
	                if ($("#editFollow").length > 0) {
	                    $("#editFollow").click(function () {
	                        ManagePageFollowAdd.UnDisabledInput();
	                        ManagePageFollowAdd.HideEditButton();

	                    });
	                }
	            },
	            complete: function (XMLHttpRequest, textStatus) {
	            }
	        });
	    }
	}


$(function () {
	ManagePage.Resize();
	EnumList.GetEnumListToSelect($("#type"),"dicDataforProductpartnerIssuertype",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#relationLevel"),"dicDataforCustomerCompanyRelationLevel",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#importanceLevel"),"dicDataforCustomerAgentBussinessImportance",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#isIssuer"),"isYes",$Url.BuildProductUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#isAgent"),"isYes",$Url.BuildProductUrl("/common/enumList.action"));
    
    $("#back").click(function () {
        $EasyUI.Close();
    });

    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
        $("#followList").hide();//如果新建隐藏跟踪相关元素
        $("#follow").hide();
        $("hr").hide();
        $("#empNo").val(PageVar.UserId);
    }
    else {
    	ManagePage.GetInfo(PageVar.ID);
    }
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "empNo", //员工值框id
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
    var partnerIssuerAdd = $("#partnerIssuerAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildProductUrl("/product/partnerIssuer/ajaxEditPartnerIssuer");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";

            var info = {
                id: PageVar.ID,
				code: $("#code").val(),
				type: $("#type").val(),
				name: $("#name").val(),
				owner: $("#owner").val(),
				contactPrimary: $("#contactPrimary").val(),
				contactPosition: $("#contactPosition").val(),
				empNo: $("#empNo").val(),
				contactCellphone1: $("#contactCellphone1").val(),
				contactCellphone2: $("#contactCellphone2").val(),
				contactTelephone: $("#contactTelephone").val(),
				contactWeixin: $("#contactWeixin").val(),
				contactQq: $("#contactQq").val(),
				website: $("#website").val(),
				address: $("#address").val(),
				relationLevel: $("#relationLevel").val(),
				importanceLevel: $("#importanceLevel").val(),
				email: $("#email").val(),
				comment: $("#comment").val(),
				isIssuer: $("#isIssuer").val(),
				isAgent: $("#isAgent").val(),
				editComment: $("#editComment").val(),
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
                        window.location.href = $Url.BuildProductUrl("/product/partnerIssuer/detail?id=" + data.errDesc);
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
    partnerIssuerAdd.addRule([
	{
	    ele: "#name",
	    datatype: "*",
	    nullmsg: "请填写机构名称",
	    errormsg: "",
	    sucmsg: " "
	},
	{
	    ele: "#comment",
	    datatype: "*",
	    nullmsg: "请填写发行机构简介",
	    errormsg: "",
	    sucmsg: " "
	},
	{
	    ele: "#contactPrimary",
	    datatype: "*",
	    nullmsg: "请填写联系人",
	    errormsg: "",
	    sucmsg: " "
	},
	{
	    ele: "#contactPosition",
	    datatype: "*",
	    nullmsg: "请填写联系人职位",
	    errormsg: "",
	    sucmsg: " "
	},
	{
	    ele: "#email",
	    datatype: "e",
	    ignore: "ignore",
	    nullmsg: "",
	    errormsg: "请填写正确的邮箱地址",
	    sucmsg: " "
	},
	{
	    ele: "#contactQq",
	    datatype: "/^[1-9][0-9]{4,12}$/",
	    ignore: "ignore",
	    nullmsg: "",
	    errormsg: "请填写正确的qq",
	    sucmsg: " "
	},
	{
	    ele: "#contactCellphone1",
	    datatype: "m",
	    nullmsg: "请填写手机号",
	    errormsg: "请填写正确的手机号",
	    sucmsg: " "
	},
	{
	    ele: "#contactCellphone2",
	    datatype: "m",
	    ignore: "ignore",
	    nullmsg: "",
	    errormsg: "请填写正确的手机号",
	    sucmsg: " "
	},
	{
	    ele: "#contactTelephone",
	    dataType:/^\d{3,4}-\d{7,8}(-\d{3,4})?$/,
	    nullmsg: "",
	    ignore: "ignore",
	    errormsg: "请填写正确的电话",
	    sucmsg: " "
	}

    ]);

    	$("#btnFollowListAdd").click(function () { ManagePageFollowList.GetAdd(); });

	    ManagePageFollowList.InitGrid();
	    

	    EnumList.GetEnumListToSelect($("#managerNo"),"empManager",$Url.BuildCustomerUrl("/common/enumList.action"));
	    EnumList.GetEnumListToSelect($("#relationLevel"),"dicDataforCustomerCompanyRelationLevel",$Url.BuildCustomerUrl("/common/enumList.action"));
	    EnumList.GetEnumListToSelect($("#contactImportance"),"dicDataforCustomerAgentBussinessImportance",$Url.BuildCustomerUrl("/common/enumList.action"));
	    EnumList.GetEnumListToSelect($("#productNo"), "productListByStatus30ForCustomerFollow", $Url.BuildCustomerUrl("/common/enumList.action"));
	    EnumList.GetEnumListToSelect($("#followType"), "cusFollowType", $Url.BuildCustomerUrl("/common/enumList.action"));
	
    $("#backFollow").click(function () {
    	$("#follow").hide();
	});
	$("#time").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});
	$("#nexttime").click(function () {
		WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	});


    var partnerIssuerFollowAdd = $("#partnerIssuerFollowAdd").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submitFollow").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildProductUrl("/product/partnerIssuerFollow/ajaxEditPartnerIssuerFollow");
            var id=$("#hideId").val();
            var agentNo =Number(PageVar.ID) ;
            var oper = "add";
            if ( id != 0)
                oper = "edit";
            var info = {
                id: id,
//				productType: $("#productType").val(),
				productNo: $("#productNo").val(),
//				agentType: $("#agentType").val(),
				agentNo: agentNo,
				contacts: $("#contacts").val(),
				position: $("#position").val(),
				type: $("#followType").val(),
				time: $("#time").val().toTimetamp(),
				nexttime: $("#nexttime").val().toTimetamp(),
				content: $("#content").val(),
				result: $("#result").val(),
				editComment: $("#editComment").val()
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
                    $("#submitFollow").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
//                        window.location.href = $Url.BuildProductUrl("/product/partnerIssuerFollow/edit?id=" + data.errDesc);
                    	$("#follow").hide();
                    	ManagePageFollowList.InitGrid();
                    } else {
                    	alert(data.errDesc);
                    	$("#msg").text(data.errDesc);
                        
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submitFollow").removeAttr("process");
                }
            });
            return false;
        }
    });
    partnerIssuerFollowAdd.addRule([
		{
			ele:"#content",
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
		},
		{
			ele:"#time",
		    dataType:"*",
		    nullmsg:"请填写跟踪时间",
		    sucmsg:" ",
		    errmsg:""
		},
		{
			ele:"#nexttime",
		    dataType:"*",
		    nullmsg:"请填写下次跟踪时间",
		    sucmsg:" ",
		    errmsg:""
		},
    ]);
    
    
})
