var EnumList = {
	GetEnumListToSelect : function(jqueryObj, listName, listUrl, param1) {
		$.ajax({
			type : "post",
			async : false,
			url : listUrl,
			dataType : "json",
			cache : true,
			beforeSend : function(XMLHttpRequest) {
			},
			data : {
				type : listName,
				param1 : param1
			},
			success : function(data, textStatus) {
				data = data.listItems;
				if (data != null) {
					jqueryObj.empty();
					for (var i = 0; i < data.length; i++) {
						var op = $("<option></option>").text(data[i].text).val(
								data[i].value);
						jqueryObj.append(op);
					}
				}
			},
			complete : function(XMLHttpRequest, textStatus) {
		    	
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				// 请求出错处理
				Base.Common.PromptText.systemError();
				alert(errorThrown);
			}
		});
	},
	GetEnumListToEdit : function(listName, listUrl) {
		var str = "";

		$.ajax({
					type : "post",
					async : false,
					url : listUrl,
					dataType : "json",
					data : {
						type : listName
					},
					success : function(data) {
						if (data != null) {
							var jsonobj = data.listItems;
							if (jsonobj != null) {

								var length = jsonobj.length;

								for (var i = 0; i < length; i++) {
									if (i != length - 1) {
										str += jsonobj[i].value + ":"
												+ jsonobj[i].text + ";";
									} else {
										str += jsonobj[i].value + ":"
												+ jsonobj[i].text;
									}
								}
							}
						}
					}

				});

		return str;
	},
	GetJsonEnumList : function(listName, listUrl) {
		var str = "";

		$.ajax({
			type : "post",
			async : false,
			url : listUrl,
			dataType : "json",
			data : {
				type : listName
			},
			success : function(data) {
				if (data != null) {
					var jsonobj = data.listItems;
					if (jsonobj != null) {

						var length = jsonobj.length;

						for (var i = 0; i < length; i++) {
							if (i != length - 1) {
								str += "\"" + jsonobj[i].value + "\"" + ":"
										+ "\"" + jsonobj[i].text + "\"" + ",";
							} else {
								str += "\"" + jsonobj[i].value + "\"" + ":"
										+ "\"" + jsonobj[i].text + "\"";
							}
						}
					}
				}
			}

		});

		return $.parseJSON("{" + str + "}");
	}
}
