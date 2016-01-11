var EnumList = {
    GetEnumListToSelect: function (jqueryObj, listName, listUrl, param1) {
        $.ajax({
            type: "post",
            async: false,
            url: listUrl,
            dataType: "json",
            cache: true,
            beforeSend: function (XMLHttpRequest) {
            },
            data: { type: listName,
                param1: param1
            },
            success: function (data, textStatus) {
                data = data.listItems;
                if (data != null) {
                    jqueryObj.empty();
                    for (var i = 0; i < data.length; i++) {
                        var op = $("<option></option>").text(data[i].text).val(data[i].value);
                        jqueryObj.append(op);
                    }
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            },
            error: function () {
                //请求出错处理
                alert("内部错误");
            }
        });
    },
    GetEnumListToEdit: function (listName, listUrl) {
        var str = "";
        $.ajax({
                type: "post",
                async: false,
                url: listUrl,
                dataType: "json",
                data: { type: listName },
                success: function (data) {
                    if (data != null) {
                        var jsonobj = data.listItems;
                        if (jsonobj != null) {

                            var length = jsonobj.length;

                            for (var i = 0; i < length; i++) {
                                if (i != length - 1) {
                                    str += jsonobj[i].value + ":" + jsonobj[i].text + ";";
                                } else {
                                    str += jsonobj[i].value + ":" + jsonobj[i].text;
                                }
                            }
                        }
                    }
                }
            });
        return str;
    },
    GetJsonEnumList: function (listName, listUrl) {
        var str = "";

        $.ajax({
                type: "post",
                async: false,
                url: listUrl,
                dataType: "json",
                data: { type: listName },
                success: function (data) {
                    if (data != null) {
                        var jsonobj = data.listItems;
                        if (jsonobj != null) {

                            var length = jsonobj.length;

                            for (var i = 0; i < length; i++) {
                                if (i != length - 1) {
                                    str += "\"" + jsonobj[i].value + "\"" + ":" + "\"" + jsonobj[i].text + "\"" + ",";
                                } else {
                                    str += "\"" + jsonobj[i].value + "\"" + ":" + "\"" + jsonobj[i].text + "\"";
                                }
                            }
                        }
                    }
                }

            }
        )
        ;

        return $.parseJSON("{" + str + "}");
    },
    
    //分配角色 mengchong 2015/2/10
    AssignRole: function (srcId,destId,listUrl,userId){
    	
		var sendData = "param1="+userId+"&params=";
		var roleIdArray=[];
		$.each($("option:selected",$("#"+srcId)),function(i,n){
			roleIdArray.push(this.value);	
		});
		sendData = sendData +roleIdArray.join("&params=");
		//alert(sendData);
		$.ajax({
			type:"POST",
			date:"json",
			url: listUrl,
			data:sendData,
			beforeSend:function(){
				return true;
			},
			success:function(date){
				 $("option:selected",$("#"+srcId)).appendTo("#"+destId);	
			}
		});
	},
	//修改负责人（客户分配）
	 ChangeManager: function (srcId,destId){
			var roleIdArray=[];
			$.each($("option:selected",$("#"+srcId)),function(i,n){
				roleIdArray.push(this.value);	
			});
			$("option:selected",$("#"+srcId)).appendTo("#"+destId);	
	},
	GetEnumListToTree: function (listName, param1, listUrl,param2) {
		var dataList = null;
        $.ajax({
            type: "post",
            async:false, 
            url: listUrl,
            dataType: "json",
            cache: true,
            beforeSend: function (XMLHttpRequest) {
            },
            data: { type: listName,
                param1: param1,
                param2: param2
                
            },
            success: function (data, textStatus) {
            	dataList =  data.listItems;
            },
            complete: function (XMLHttpRequest, textStatus) {
            },
            error: function () {
                //请求出错处理
                alert("内部错误");
            }
        });
        return dataList;
    },
    GetValueToInputById: function (listName,param1,listUrl,param2){
    	var value="";
    	$.ajax({
            type: "post",
            async:false, 
            url: listUrl,
            dataType: "json",
            cache: true,
            beforeSend: function (XMLHttpRequest) {
            },
            data: { type: listName,
                param1: param1,
                param2:param2
                
            },
            success: function (data, textStatus) {
            	value=data.value;
            },
            complete: function (XMLHttpRequest, textStatus) {
            },
            error: function () {
                //请求出错处理
                alert("内部错误");
            }
        });
    	return value;
    },
    autoComplete: function (jqueryObj,listName,url) {
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {type:listName},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                jqueryObj.autocomplete(data.listItems,{
                    max: 12,    //列表里的条目数
                    minChars: 0,    //自动完成激活之前填入的最小字符
                    width: 150,     //提示的宽度，溢出隐藏
                    scrollHeight: 300,   //提示的高度，溢出显示滚动条
                    matchContains: true,    //包含匹配，就是data参数里的数据，是否只要包含文本框里的数据就显示
                    autoFill: false,    //自动填充
                    formatItem: function (row) {
                        return row.text;
                    },
                    formatMatch: function (row) {
                        return row.text + row.value;
                    },
                    formatResult: function (row) {
                        return row.text+ "@"+row.value;
                    }
                }).result(function (event,row,formatted) {});
                if(jqueryObj.val() == "0"){
                    jqueryObj.val("")
                }
                else{
                    for(var i=0;i<data.listItems.length;i++){
                        if(jqueryObj.val() == data.listItems[i].value){
                            jqueryObj.val(data.listItems[i].text+"@"+data.listItems[i].value);
                        }
                    }
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}
var EnumListWithEasyUI = {
    EnumListCache : {},
    SelEnumCache :function(k,v){
        if (typeof v== "undefined"){
            return (typeof EnumListWithEasyUI.EnumListCache[k] != "undefined") ?EnumListWithEasyUI.EnumListCache[k]:false;
        }else{
            EnumListWithEasyUI.EnumListCache[k] = v;
        }
    },
    GetEnumListToGrid: function(value,listName,listUrl){
        if (!EnumListWithEasyUI.SelEnumCache(listName)){
            $.ajax({
                type:"post",
                url:listUrl,
                dataType:"json",
                data:{type:listName},
                async:false,
                success:function(data){
                    if(data.listItems != null && data.listItems.length > 0){
                        var listDic = {}
                        $.each(data.listItems,function (i,element) {
                            listDic[element.value] = element.text;
                        });
                        EnumListWithEasyUI.SelEnumCache(listName,listDic);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                }
            });
        }
        return EnumListWithEasyUI.SelEnumCache(listName)[value];
    }
}
