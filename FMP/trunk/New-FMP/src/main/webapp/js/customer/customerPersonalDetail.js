var BindEnumList = {
	BindAll : function() {
		EnumList.GetEnumListToSelect($("#product_no"),
				"productListByStatus30ForCustomerFollow", $Url
						.BuildCustomerUrl("/common/enumList.action"));
		EnumList.GetEnumListToSelect($("#followType"), "cusFollowType", $Url
				.BuildCustomerUrl("/common/enumList.action"));
		EnumList.GetEnumListToSelect($("#resultStatus"),
				"customerFollowResultStatus", $Url
						.BuildCustomerUrl("/common/enumList.action"));
	}
}
var ManagePage = {
    Resize: function () {
        $("#content_center").css("min-height", 850);
    },
    GetInfo: function (id) {
        var url = $Url.BuildCustomerUrl("/customer/customerPersonal/ajaxGetCustomerPersonal");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {id: id},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data) {
                if (data.errCode != "0000") {
                    $("#msg").text(data.errDesc);
                    return;
                }
                else {
                	$Util.DataToA(data.info, ElementVar);
                    $Link.MakeUrl($("#relationLevel"), data.info.relationLevel, "dicDataforCustomerCompanyRelationLevel", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#agentNo"), data.info.agentNo, "empList", $Url.BuildSalesUrl("/common/enumList.action"),$Url.BuildBaseInfoUrl("/baseInfo/mailList/list"));
                    $Link.MakeUrl($("#riskHobby"), data.info.riskHobby, "dicDataforCustomerCompanyRiskHobby", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#product_no"), data.info.product_no, "productListByStatus30ForCustomerFollow", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#followType"), data.info.followType, "cusFollowType", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#sex"), data.info.sex, "dicDicDataForEmployeeSex", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#marry"), data.info.marry, "dicDicDataForEmployeeMarry", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#sourceType"), data.info.sourceType, "customerPersonalSourceTypeList", $Url.BuildSalesUrl("/common/enumList.action"));
                    $Link.MakeUrl($("#resultStatus"), data.info.resultStatus, "customerFollowResultStatus", $Url.BuildSalesUrl("/common/enumList.action"));
                    if($("#isTest").text()=="0"){
        				$("#isTest").text("否");
        			}else{
        				$("#isTest").text("是");
        			}
                }
            }

        });
    }
};
var JqGridManager = {
	    DateInputElem: function (value, options) {
	        var el = document.createElement("input");
	        el.type = "text";
	        el.value = value;
	        el.onclick = function () {
	            el.focus();
	            el.select();
	            WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
	        };
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
	            $("#gridTableFollow").jqGrid('setGridParam', {
	                datatype: "json", postData: {
	                    "customerFollowId": PageVar.ID,
	                    "customerType": PageVar.CustomerType
	                }, page: 1
	            }).trigger("reloadGrid");
	        } else {
	            // grid start
	            $("#gridTableFollow").jqGrid({
	                url: $Url.BuildCustomerUrl('/customer/customerFollow/ajaxListCustomerFollow.action'),
	                editurl: $Url.BuildCustomerUrl("/customer/customerFollow/ajaxEditCustomerFollow.action"),
	                datatype: "json",
	                postData: {
	                    "customerFollowId": PageVar.ID,
	                    "customerType": PageVar.CustomerType
	                },
	                mtype: 'GET',
	                colNames: ["操作", "编号", "推荐产品", "客户类型", "跟踪类型", "跟踪时间", "下次跟踪时间", "跟踪内容", "跟踪结果", "备注"],
	                colModel: [
	                    {
	                        name: "act", index: "act", width: 60, align: "center", sortable: false
	                    },
	                    {
	                        name: "id",
	                        index: "id",
	                        width: 20,
	                        align: "center",
	                        sorttype: "number",
	                        formoptions: {rowpos: 1, colpos: 1},
	                        editable: false,
	                        editoptions: {readonly: true, size: 20},
	                        hidden: true,
	                        editrules: {edithidden: true}
	                    },
	                    {
	                        name: "productNo",
	                        index: "productNo",
	                        width: 40,
	                        align: "left",
	                        formatter: "select",
	                        edittype: "select",
	                        editoptions: {
	                            size: 1,
	                            value: EnumList.GetEnumListToEdit("productListByStatus30ForCustomerFollow", $Url.BuildCustomerUrl("/common/enumList.action"))
	                        },
	                        formoptions: {rowpos: 2, colpos: 2},
	                        sortable: false,
	                        editable: true,
	                        hidden: true,
	                        editrules: {edithidden: true}
	                    },
	                    {
	                        name: "customerType",
	                        index: "customerType",
	                        width: 40,
	                        align: "left",
	                        formatter: "select",
	                        edittype: "select",
	                        editoptions: {
	                            size: 1,
	                            value: EnumList.GetEnumListToEdit("customerTypeAll", $Url.BuildCustomerUrl("/common/enumList.action"))
	                        },
	                        formoptions: {rowpos: 3, colpos: 1},
	                        sortable: false,
	                        editable: true,
	                        hidden: true,
	                        editrules: {edithidden: true}
	                    },
	                    {
	                        name: "type",
	                        index: "type",
	                        width: 40,
	                        align: "left",
	                        formatter: "select",
	                        edittype: "select",
	                        editoptions: {
	                            size: 1,
	                            value: EnumList.GetEnumListToEdit("cusFollowType", $Url.BuildCustomerUrl("/common/enumList.action"))
	                        },
	                        formoptions: {rowpos: 4, colpos: 1},
	                        sortable: false,
	                        editable: true
	                    },
	                    {
	                        name: "time",
	                        index: "time",
	                        width: 40,
	                        align: "left",
	                        formoptions: {rowpos: 4, colpos: 2},
	                        sortable: false,
	                        formatter: "date",
	                        formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'},
	                        editable: true,
	                        edittype: 'custom',
	                        editoptions: {
	                            custom_element: JqGridManager.DateInputElem,
	                            custom_value: JqGridManager.DateInputValue,
	                            size: 20
	                        }
	                    },
	                    {
	                        name: "nexttime",
	                        index: "nexttime",
	                        width: 40,
	                        align: "left",
	                        formoptions: {rowpos: 5, colpos: 1},
	                        sortable: false,
	                        formatter: "date",
	                        formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'},
	                        editable: true,
	                        edittype: 'custom',
	                        editoptions: {
	                            custom_element: JqGridManager.DateInputElem,
	                            custom_value: JqGridManager.DateInputValue,
	                            size: 20
	                        }
	                    },
	                    {
	                        name: "content",
	                        index: "content",
	                        width: 40,
	                        align: "left",
	                        formoptions: {rowpos: 6, colpos: 1},
	                        sortable: false,
	                        editable: true,
	                        edittype: 'textarea',
	                        editoptions: {size: 40},
	                        hidden: true,
	                        editrules: {edithidden: true}
	                    },
	                    {
	                        name: "resultStatus",
	                        index: "resultStatus",
	                        width: 40,
	                        align: "left",
	                        formatter:"select",
	                        formoptions: {rowpos: 6, colpos: 2},
	                        sortable: false,
	                        editable: true,
	                        edittype: 'textarea',
	                        editoptions: {size: 20,value: EnumList.GetEnumListToEdit("customerFollowResultStatus",$Url.BuildCustomerUrl("/common/enumList.action"))}
	                    },
	                    {
	                        name: "editComment",
	                        index: "editComment",
	                        width: 20,
	                        align: "left",
	                        formoptions: {rowpos: 5, colpos: 2},
	                        sortable: false,
	                        editable: true,
	                        edittype: 'textarea',
	                        editoptions: {size: 20},
	                        hidden: true,
	                        editrules: {edithidden: true}

	                    }
	                ],
	                sortname: "id",
	                sortorder: "desc",
	                pager: "#gridPagerFollow",
	                viewrecords: true,
	                rowNum: 5,
	                rowList: [5],
	                altclass: "altRowsColour",
	                shrinkToFit: true,
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
	                    var space = "|";
	                    var ids = $("#gridTableFollow").jqGrid(
	                        'getCol', 'id', true);
	                    for (var i = 0; i < ids.length; i++) {
	                        var id = ids[i].id;
	                        var detail = "";
	                        var edit = "";
	                        detail = "<a class=\"blue\" href=\"javascript:JqGridManager.GetDetail('" + id + "')\">查看</a>";
	                        $("#gridTableFollow").jqGrid("setRowData", id, {act: detail});
	                    }
	                }
	            });
	        }
	    },
	    GetDetail: function (index) {
	        $("#Follow").show();
	        $("#hideId").val(index);
	        var result = DataManager.getFollowInfo(index);
	        $("#product_no").val(result.productNo);
	        $("#followType").val(result.type);
	        if (result.time != null) {
	            var followTime = new Date(result.time);
	            $("#followTime").val(followTime.format("yyyy-MM-dd hh:mm:ss"));
	        } else {
	            $("#followTime").val("");
	        }

	        if (result.nexttime != null) {
	            var nexttime = new Date(result.nexttime);
	            $("#nexttime").val(nexttime.format("yyyy-MM-dd hh:mm:ss"));
	        } else {
	            $("#nexttime").val("");
	        }

	        $("#contentFollow").val(result.content);
	        $("#result").val(result.result);
	        $("#edit_comment_follow").val(result.editComment);
	        ElementManager.ElementFollowDisable();

	    }
}
var DataManager = {
		getInfo : function(thisId) {
			var result;
			$
					.ajax({
						type : "post",
						url : $Url
								.BuildCustomerUrl("/customer/customerPersonal/ajaxGetInfoById"),
						async : false,
						data : {
							customerId : thisId
						},
						beforeSend : function() {
						},
						error : function(XMLHttpRequest, textStatus, errorThrown) {
							alert(errorThrown);
						},
						success : function(data, textStatus) {
							var info = data.customerPersonal;
							$Util.DataToVal(info, ElementVar);
							// $("#empName").val(data.empName);

							if (info.findTime != null) {
								var findTime = new Date(info.findTime);
								$("#findTime").val(
										findTime.format("yyyy-MM-dd HH:mm:ss"));
							} else {
								$("#findTime").val("");
							}
							if (info.birthday != null) {
								var birthday = new Date(info.birthday);
								$("#birthday").val(
										birthday.format("yyyy-MM-dd HH:mm:ss"));
							} else {
								$("#birthday").val("");
							}

							if (info.sourceType != null) {
								$("#sourceType").val(info.sourceType);
							} else {
								$("#sourceType").val(0);
							}

							EmployeeTreeControl.startTree({
								param : "on", // on在职员工，out离职员工，test测试员工
								treeInputId : "employeeSel",// 员工控件框ID
								valInputId : "agentNo", // 员工值框id
								inputType : "employee",// employee员工，position职位
								idType : "userNo", // 员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
								chkStyle : "radio",// 选框类型checkbox,radio
								nochecks : [ true, true, false ], // 逐级不显示单或复选框,true不显示，false显示
								chkboxType : {
									Y : "ps",
									N : "ps"
								}, // Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
								showPreBut : true, // 显示全部员工，在职员工按钮,离职员工，test测试员工
								// showSearch: true, //显示搜索框
								showLevel : 3, // 显示层级
								sizeAuto : true, // 自动调节大小
								width : 200, // 宽，单位px
								height : 300
							// 高，单位px
							});

						},
						complete : function(XMLHttpRequest, textStatus) {
						}
					});
			return result;
		},
		getFollowInfo : function(id) {
			var result;
			var url = $Url
					.BuildCustomerUrl("/customer/customerFollow/ajaxGetFollowInfoById");
			$.ajax({
				type : "post",
				url : url,
				async : false,
				data : {
					followId : id
				},
				beforeSend : function() {
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
				},
				success : function(data, textStatus) {
					result = data.customerFollow;
				},
				complete : function(XMLHttpRequest, textStatus) {
				}
			});
			return result;
		}
	}
var ElementManager = {
		Resize : function() {
			$("#content_center").css("min-height", "1200px");
		},
		ElementDisable : function() {
			$("#sourceType").attr('disabled', 'true');
			$("#findTime").attr('disabled', 'true');
			$("#code").attr('disabled', 'true');
			$("#name").attr('disabled', 'true');
			$("#sex").attr('disabled', 'true');
			$("#cardType").attr('disabled', 'true');
			$("#cardLicense").attr('disabled', 'true');
			$("#cardTax").attr('disabled', 'true');
			$("#cardNumber").attr('disabled', 'true');
			$("#address").attr('disabled', 'true');
			$("#phone").attr('disabled', 'true');
			$("#email").attr('disabled', 'true');
			$("#weixin").attr('disabled', 'true');
			$("#qq").attr('disabled', 'true');
			$("#field").attr('disabled', 'true');
			$("#marry").attr('disabled', 'true');
			$("#companyName").attr('disabled', 'true');

			$("#birthday").attr('disabled', 'true');
			$("#cellphone1").attr('disabled', 'true');
			$("#cellphone2").attr('disabled', 'true');
			$("#relationLevel").attr('disabled', 'true');
			$("#riskHobby").attr('disabled', 'true');
			$("#wealth").attr('disabled', 'true');
			$("#tradeTotal").attr('disabled', 'true');
			$("#editComment").attr('disabled', 'true');
			$("#agentNo").attr('disabled', 'true');
			$("#isTest").attr('disabled', 'true');

		},
		ElementUnDisable : function() {
			if (Number(PageVar.ID) == 0) {
				$("#findTime").removeAttr('disabled');
			}
			$("#sourceType").removeAttr("disabled");
			$("#name").removeAttr("disabled");
			$("#sex").removeAttr("disabled");
			$("#weixin").removeAttr("disabled");
			$("#qq").removeAttr("disabled");
			$("#cardType").removeAttr("disabled");
			$("#cardLicense").removeAttr("disabled");
			$("#cardTax").removeAttr("disabled");
			$("#cardNumber").removeAttr("disabled");
			$("#address").removeAttr("disabled");
			$("#phone").removeAttr("disabled");
			$("#marry").removeAttr("disabled");
			$("#companyName").removeAttr("disabled");
			$("#email").removeAttr("disabled");
			$("#field").removeAttr("disabled");
			$("#birthday").removeAttr("disabled");
			$("#cellphone1").removeAttr("disabled");
			$("#cellphone2").removeAttr("disabled");
			$("#relationLevel").removeAttr("disabled");
			$("#riskHobby").removeAttr("disabled");
			$("#wealth").removeAttr("disabled");
			$("#tradeTotal").removeAttr("disabled");
			$("#editComment").removeAttr("disabled");
			$("#description").removeAttr("disabled");
			$("#agentNo").removeAttr("disabled");
			$("#isTest").removeAttr("disabled");
		},
		Elementformatter : function() {
			if ($("#wealth").val() == "0") {
				$("#wealth").val("");
			}
			if ($("#tradeTotal").val() == "0") {
				$("#tradeTotal").val("");
			}
		},
		ElementFollowDisable : function() {
			$("#product_no").attr('disabled', 'true');
			$("#followType").attr('disabled', 'true');
			$("#followTime").attr('disabled', 'true');
			$("#nexttime").attr('disabled', 'true');
			$("#contentFollow").attr('disabled', 'true');
			$("#resultStatus").attr('disabled', 'true');
			$("#edit_comment_follow").attr('disabled', 'true');
		},
		ElementFollowUnDisable : function() {
			$("#product_no").removeAttr("disabled");
			$("#followType").removeAttr("disabled");
			$("#followTime").removeAttr("disabled");
			$("#nexttime").removeAttr("disabled");
			$("#contentFollow").removeAttr("disabled");
			$("#resultStatus").removeAttr("disabled");
			$("#edit_comment_follow").removeAttr("disabled");
		},
		ElementFollowClean : function() {
			$("#hideId").val("");
			$("#product_no").val(0);
			$("#followType").val(1);
			$("#followTime").val("");
			$("#nexttime").val("");
			$("#contentFollow").val("");
			$("#resultStatus").val("");
			$("#edit_comment_follow").val("");
		},
		ShowEditButton : function(currStatus) {
			if ($("#edit").length > 0)
				$("#edit").show();
			if ($("#submit").length > 0)
				$("#submit").hide();

		},
		HideEditButton : function() {
			if ($("#edit").length > 0)
				$("#edit").hide();
			if ($("#submit").length > 0)
				$("#submit").show();
		}
	}
var SalesList = {
		DateInputElem : function(value, options) {
			var el = document.createElement("input");
			el.type = "text";
			el.value = value;
			el.onclick = function() {
				el.focus();
				el.select();
				WdatePicker({
					dateFmt : 'yyyy-MM-dd HH:mm:ss'
				});
			};
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
			// grid start
			$("#gridTable")
					.jqGrid(
							{
								url : $Url
										.BuildSalesUrl('/sales/sales/ajaxListSalesByCustomerNo.action'),
								editurl : $Url
										.BuildSalesUrl("/sales/sales/ajaxEditSales.action"),
								datatype : "json",
								postData : {
									"customerNo" : Number(PageVar.ID)
								},
								mtype : 'GET',
								colNames : [ "操作", "id", "产品类型", "产品名称", "客户类型",
										"客户", "订单状态", "订单金额", "部门", "理财经理", "购买日期" ],
								colModel : [

										{
											name : "act",
											index : "act",
											width : 60,
											align : "center",
											sortable : false
										},
										{
											name : "id",
											index : "id",
											width : 20,
											align : "center",
											sorttype : "number",
											formoptions : {
												rowpos : 1,
												colpos : 1
											},
											editable : true,
											editoptions : {
												readonly : true,
												size : 40
											}
										},
										{
											name : "productType",
											index : "productType",
											width : 40,
											align : "left",
											formatter : "select",
											edittype : "select",
											editoptions : {
												size : 1,
												value : EnumList
														.GetEnumListToEdit(
																"productType",
																$Url
																		.BuildSalesUrl("/common/enumList.action"))
											},
											formoptions : {
												rowpos : 3,
												colpos : 1
											},
											sortable : false,
											editable : true
										},
										{
											name : "productNo",
											index : "productNo",
											width : 40,
											align : "left",
											formatter : "select",
											edittype : 'select',
											editoptions : {
												size : 1,
												value : EnumList
														.GetEnumListToEdit(
																"productList",
																$Url
																		.BuildSalesUrl("/common/enumList.action"))
											},
											formoptions : {
												rowpos : 3,
												colpos : 2
											},
											sortable : false,
											editable : true
										},
										{
											name : "customerType",
											index : "customerType",
											width : 40,
											align : "left",
											formatter : "select",
											edittype : "select",
											editoptions : {
												size : 1,
												value : EnumList
														.GetEnumListToEdit(
																"customerType",
																$Url
																		.BuildSalesUrl("/common/enumList.action"))
											},
											formoptions : {
												rowpos : 4,
												colpos : 1
											},
											sortable : false,
											editable : true
										},
										{
											name : "customerNo",
											index : "customerNo",
											width : 40,
											align : "left",
											formatter : ManagePage.CustomerNoFormat,
											unformat : ManagePage.CustomerNoUnFormat,
											edittype : "select",
											editoptions : {
												size : 1,
												value : EnumList
														.GetEnumListToEdit(
																"",
																$Url
																		.BuildSalesUrl("/common/enumList.action"))
											},
											formoptions : {
												rowpos : 4,
												colpos : 2
											},
											sortable : false,
											editable : true
										},
										{
											name : "status",
											index : "status",
											width : 40,
											align : "left",
											formatter : "select",
											edittype : "select",
											editoptions : {
												size : 1,
												value : EnumList
														.GetEnumListToEdit(
																"salesStatus",
																$Url
																		.BuildSalesUrl("/common/enumList.action"))
											},
											formoptions : {
												rowpos : 5,
												colpos : 1
											},
											sortable : false,
											editable : true
										},
										{
											name : "money",
											index : "money",
											width : 40,
											align : "left",
											formoptions : {
												rowpos : 6,
												colpos : 1
											},
											sortable : false,
											editable : true,
											editoptions : {
												size : 40
											}
										},
										{
											name : "deptNo",
											index : "deptNo",
											width : 40,
											align : "left",
											formatter : "select",
											edittype : "select",
											editoptions : {
												size : 1,
												value : EnumList
														.GetEnumListToEdit(
																"dept",
																$Url
																		.BuildSalesUrl("/common/enumList.action"))
											},
											formoptions : {
												rowpos : 7,
												colpos : 1
											},
											sortable : false,
											editable : true
										},
										{
											name : "empNo",
											index : "empNo",
											width : 40,
											align : "left",
											hidden : false,
											editrules : {
												edithidden : false
											},
											formatter : "select",
											edittype : 'select',
											editoptions : {
												size : 1,
												value : EnumList
														.GetEnumListToEdit(
																"empList",
																$Url
																		.BuildSalesUrl("/common/enumList.action"))
											},
											formoptions : {
												rowpos : 7,
												colpos : 2
											},
											sortable : false,
											editable : true
										},
										{
											name : "purchaseDate",
											index : "purchaseDate",
											width : 40,
											align : "left",
											formatter : "date",
											formoptions : {
												rowpos : 9,
												colpos : 2
											},
											sortable : false,
											formatoptions : {
												srcformat : 'Y-m-d',
												newformat : 'Y-m-d'
											},
											editable : true,
											edittype : 'custom',
											editoptions : {
												custom_element : ManagePage.DateInputElem,
												custom_value : ManagePage.DateInputValue,
												size : 20
											}
										} ],
								sortname : "id",
								sortorder : "desc",
								viewrecords : true,
								rowNum : 10,
								rowList : [ 10 ],
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
								pager : "#gridPager",
								gridComplete : function() {
									// var space = "|";
									var ids = $("#gridTable").jqGrid('getCol',
											'id', true);
									for (var i = 0; i < ids.length; i++) {
										var id = ids[i].id;
										var detail = "";
										detail = "<a class=\"blue\" href=\"javascript:SalesList.GetDetail('"
												+ id + "')\">查看</a>";
										$("#gridTable").jqGrid("setRowData", id, {
											act : detail
										});
									}
								}
							});
		},
		InitQuery : function() {
			$("#btnSearch").click(function() {
				var byProductType = $("#selectProductType").val();
				var byProduct = $("#selectProduct").val();
				var byAgentType = $("#selectAgentType").val();
				var byAgent = $("#selectAgent").val();
				var byStatus = $("#selectStatus").val();

				$("#gridTable").jqGrid('setGridParam', {
					datatype : "json",
					postData : {
						"byProductType" : byProductType,
						"byProduct" : byProduct,
						"byAgentType" : byAgentType,
						"byAgent" : byAgent,
						"byStatus" : byStatus
					},
					page : 1
				}).trigger("reloadGrid");
			});
		},
		GetDetail : function(index) {
			$EasyUI.NewTab("Detail", $Url.BuildSalesUrl("/sales/sales/edit?id=" + index));
		},
		GetAdd : function() {
			$EasyUI.NewTab("New", $Url.BuildSalesUrl("/sales/sales/edit"))

		}
	}
$(function () {
    ManagePage.Resize();
    ManagePage.GetInfo(PageVar.ID);
    JqGridManager.InitGrid();
    BindEnumList.BindAll();
    $("#back").click(function () {
    	$EasyUI.Close();
    });
    $("#btnAddSales").click(function() {
		SalesList.GetAdd();
	});

	SalesList.InitGrid();
	SalesList.InitQuery();
	EnumList.GetEnumListToSelect($("#selectStatus"), "salesStatusAll", $Url
			.BuildSalesUrl("/common/enumList.action"));
	$.fn.linkage({
		elements : [ $("#selectProductType"), $("#selectProduct") ],
		dataTypes : [ "productType", "productNo" ],
		actionUrl : $Url.BuildSalesUrl("/common/enumList.action"),
		all : true
	});
	$.fn.linkage({
		elements : [ $("#selectAgentType"), $("#selectAgent") ],
		dataTypes : [ "agentType", {
			0 : "",
			1 : "myAgentBusiness",
			2 : "myAgentAdviser",
			3 : "zhixiaoEmp"
		} ],// zhixiaoEmpAll
		actionUrl : $Url.BuildSalesUrl("/common/enumList.action"),
		all : true
	});
});