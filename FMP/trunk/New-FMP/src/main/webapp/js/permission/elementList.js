var ManagePage = {
	GetElementInfo : function(id) {
		var url = $Url
				.BuildPermissionUrl("/permission/element/ajaxGetInfoElement.action");
		// alert(url);
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			timeout : 30000,
			data : {
				parentNo : id
			},
			beforeSend : function() {
				// alert(id);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			},
			success : function(data, textStatus) {
				$("#elementDetailName").html(data.elementInfo.name);
				$("#elementDetailValue").html(data.elementInfo.value);
				$("#elementDetailAlias").html(data.elementInfo.alias);
				$("#elementDetailPriority").html(data.elementInfo.priority);
				$("#elementDetailIsShow").html(data.elementInfo.switchIsShow);
				$("#elementEditTime").html(
						new Date(data.elementInfo.editTime)
								.format("yyyy-MM-dd hh:mm:ss"));
				$("#elementDetailInTime").html(
						new Date(data.elementInfo.inTime)
								.format("yyyy-MM-dd hh:mm:ss"));
				$("#elementDetailEditComment").html(
						data.elementInfo.editComment);
				$("#elementDetailLevel").html(data.elementInfo.level);
				$("#isShow").html(data.elementInfo.isShow);
			}
		});
	},

	ElementAdd : function() {
		$("#elementAdd").click(function() {
			$("#element").show();
			$("#elementAddDiv").show();
			$("#elementEditDiv").hide();
			$("#elementDetail").hide();
			$("#elementUpdateSubmit").hide();
			$("#elementAddSubmit").show();

		});
	},

	ElementEdit : function(id) {
		$("#elementEdit").click(
				function() {
					$("#elementName").val($("#elementDetailName").html());
					$("#elementValue").val($("#elementDetailValue").html());
					$("#elementAlias").val($("#elementDetailAlias").html());
					$("#elementPriority").val(
							$("#elementDetailPriority").html());
					$("#elementEditComment").val(
							$("#elementDetailEditComment").html());
					$("#elementLevel").val($("#elementDetailLevel").html());
					if ($("#isShow").html() == 1) {
						$("#elementIsShow").prop("checked", true);
					} else {
						$("#elementIsShow").prop("checked", false);
					}
					$("#elementAddDiv").hide();
					$("#elementEditDiv").show();
					$("#element").show();
					$("#elementDetail").hide();
					$("#elementUpdateSubmit").show();
					$("#elementAddSubmit").hide();
					ManagePage.GetElementInfo(id);

				});
	},
	ElementDelete : function(id) {
		$("#elementDelete")
				.click(
						function() {
							if (window.confirm("是否删除"
									+ $("#elementDetailName").html() + "？")) {
								var url = $Url
										.BuildPermissionUrl("permission/element/ajaxDeleteElement.action");
								$.ajax({
									type : "get",
									url : url,
									dataType : "json",
									timeout : 30000,
									data : {
										elementId : $("#elementId").val(),
									},
									beforeSend : function() {
									},
									error : function(XMLHttpRequest,
											textStatus, errorThrown) {
										alert(errorThrown);
									},
									success : function(data, textStatus) {
										window.location.reload();
									},
									complete : function(XMLHttpRequest,
											textStatus) {
									}
								});
							}

						});
	},
	MakeTree : function(id) {
		tree = new dhtmlXTreeObject($("#treeboxbox_tree").get(0), "100%",
				"100%", 0);
		var xml = $Url.BuildImgUrl("/dhtmlxTree/imgs/csh_bluefolders/");
		tree.setImagePath(xml);
		var url = $Url
				.BuildPermissionUrl("permission/element/getElementTree.action?elementId="
						+ id);
		tree.loadXML(url);
		tree.setOnClickHandler(function(id) {
			$("#elementId").val(tree.getSelectedItemId());
			ManagePage.GetElementInfo(tree.getSelectedItemId());
			$("#element").hide();
			$("#elementDetail").show();
			ManagePage.ElementEdit(tree.getSelectedItemId());
			ManagePage.ElementDelete(tree.getSelectedItemId());
		});
	}

}

$(function() {
	$("#element").hide();
	$("#elementDetail").hide();
	var id = 1;
	ManagePage.ElementAdd();
	ManagePage.MakeTree(id);
	var ElementAdd = $("#elementFrom")
			.Validform(
					{// 验证控件
						tiptype : 3,
						ignoreHidden : true,
						datatype : {
							"verifyAlias" : function(gets, obj, curform,
									datatype) {
								var reg = /[\w\W]+/;
								if (!reg.test($.trim(gets))) {
									return false;
								}
								if (!$("#elementUpdateSubmit").is(":hidden")) {
									if (obj.val() == $("#elementDetailAlias")
											.html()) {
										return true;
									}
								}
								var url = $Url
										.BuildPermissionUrl("/permission/element/ajaxCheckAliasExist");
								var result;
								$.ajax({
									type : "post",
									url : url,
									dataType : "json",
									async : false,
									data : {
										alias : $String.Trim(gets)
									},
									success : function(data) {
										if (data.errCode == "已存在")
											result = data.errDesc;
									}
								});
								return result;
							}
						},
						callback : function(form) {
							if (!($("#submit").attr("process") === undefined)) {
								return false;
							}
							var url = $Url
									.BuildPermissionUrl("/permission/element/ajaxEditElement");

							if (!$("#elementUpdateSubmit").is(":hidden")) {
								var oper = "edit";

								var name = $.trim($("#elementName").val());
								var value = $.trim($("#elementValue").val());
								var alias = $("#elementAlias").val();
								var priority = $.trim($("#elementPriority")
										.val());
								var editComment = $.trim($(
										"#elementEditComment").val());
								var elementLevel = $.trim($("#elementLevel")
										.val());
								var isShow = 0;
								if ($('#elementIsShow').is(':checked'))
									var isShow = 1;
							}
							if (!$("#elementAddSubmit").is(":hidden")) {
								var oper = "add";

								var name = $.trim($("#elementAddName").val());
								var value = $.trim($("#elementAddValue").val());
								var alias = $.trim($("#elementAddAlias").val());
								var priority = $.trim($("#elementAddPriority")
										.val());
								var editComment = $.trim($(
										"#elementAddEditComment").val());
								var elementLevel = $.trim($("#elementAddLevel")
										.val());
								var isShow = 0;
								if ($('#elementAddIsShow').is(':checked'))
									var isShow = 1;

							}
							$
									.ajax({
										type : "post",
										url : url,
										dataType : "json",
										timeout : 30000,
										data : {
											oper : oper,
											elementId : $("#elementId").val(),
											name : name,
											value : value,
											alias : alias,
											priority : priority,
											editComment : editComment,
											level : elementLevel,
											isShow : isShow

										},
										beforeSend : function() {

											$("#submit").attr("process",
													"processing");
										},
										error : function(XMLHttpRequest,
												textStatus, errorThrown) {
											alert(errorThrown);
										},
										success : function(data, textStatus) {
											$("#elementAddName").val("");
											$("#elementAddValue").val("");
											$("#elementAddAlias").val("");
											$("#elementAddPriority").val("");
											$("#elementAddEditComment").val("");
											$("#elementAddLevel").val("");
											$("#elementAddIsShow").prop(
													"checked", false);
											// alert($("#elementId").val());
											alert("元素保存成功！");

											$("#treeboxbox_tree").empty();
											ManagePage.MakeTree($("#elementId")
													.val());
											$("#element").hide();
										},
										complete : function(XMLHttpRequest,
												textStatus) {
											$("#submit").removeAttr("process");
										}
									});
							return false;
						}
					});

	ElementAdd.addRule([ {
		ele : "#elementAddAlias",
		datatype : "verifyAlias",// "/^[\u4E00-\u9FA5\uf900-\ufa2d\\w\\.\\s]{1,20}$/",
		// ignore: "ignore",
		nullmsg : "不能为空",
		errormsg : "",
		sucmsg : " "
	}, {
		ele : "#elementAlias",
		datatype : "verifyAlias",// "/^[\u4E00-\u9FA5\uf900-\ufa2d\\w\\.\\s]{1,20}$/",
		// ignore: "ignore",
		nullmsg : "别名不能为空",
		errormsg : "",
		sucmsg : " "
	} ]);
});