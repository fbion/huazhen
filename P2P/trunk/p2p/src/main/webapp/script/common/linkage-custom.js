//defaults attribute
var optsDefaults = {
	    elements: [],
	    urls: [],
	    defVal: [],
	    status: -5
};
var LinkageForSelect ={
	getListForSelect : function(options) {
		var opts = $.extend(optsDefaults,options);
		var objList = opts.elements;
		var urlList = opts.urls;
		var status = opts.status;
		
		if(objList.length<=0) return;
		if(urlList.length<=0) return;
		if(status==-5) return;
		
		LinkageForSelect.getListByAjax(objList[0],urlList[0],0,status);
		for(var i = 1 ; i<objList.length;i++){
			objList[i].append('<option value="">请选择</option>');
			objList[i-1].change(function() {
				var num = 0;
                for (var i = 0; i < objList.length; i++) {
                    if($(this).val()==objList[i].val()) {
                        num = i;
                        break;
                    }
                }
				for(var j=num+1 ; j<objList.length;j++){
					objList[j].empty();
					objList[j].append('<option value="">请选择</option>');
				}
				LinkageForSelect.getListByAjax(objList[num+1],urlList[num+1],$(this).val(),status);
			});
		}
	},
	getListByAjax : function (jqueryObj, url, param, status){
		$.ajax({
			type : "post",
			async : false,
			url : url,
			dataType : "json",
			cache : true,
			beforeSend : function(XMLHttpRequest) {
			},
			data : {
				param : param,
				enabled : status
			},
			success : function(data) {
				data = data.resultList;
				if (data != null) {
					jqueryObj.empty();
					jqueryObj.append('<option value="">请选择</option>');
					for (var i = 0; i < data.length; i++) {
						var option = $('<option value="' + data[i].id + '" >' + data[i].name + '</option>');
						jqueryObj.append(option);
					}
				}else{
					alert("内部错误");
				}
			},
			complete : function(XMLHttpRequest, textStatus) {
			},
			error : function() {
				alert("内部错误");
			}
		});
	},
	setSelected : function (options){
		var opts = $.extend(optsDefaults,options);
		var objList = opts.elements;
		var urlList = opts.urls;
		var supNoList = opts.defVal;
		var status = opts.status;
		
		if(objList.length<=0) return;
		if(urlList.length<=0) return;
		if(supNoList.length<=0) return;
		if(status==-5) return;
		
		for(var i = 0 ; i<objList.length;i++){
			var supNo = "";
			if(i!=0) supNo = supNoList[i-1];
			LinkageForSelect.getListByAjax(objList[i],urlList[i],supNo,status);
			objList[i].find("option[value='" + supNoList[i] + "']").attr("selected",true);
		}
	 }
}