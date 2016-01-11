var ManagePage = {
		CleckElem:function(obj,value){
			$("#"+obj+"").click(function(){
					var url=$Url.BuildPermissionUrl("permission/dataManage/ajaxDataManage");
					 $.ajax({
				            type: "get",
				            url: url,
				            dataType: "json",
				            timeout: 30000,
				            data: {
				                isTest:value
				            },
				            beforeSend: function () {
				            },
				            error: function (XMLHttpRequest, textStatus, errorThrown) {
				                alert(errorThrown);
				            },
				            success: function (data, textStatus) {
				            	if(value==1){
				            		$("#showDataSuccess").html("√");
				            		$("#hideDataSuccess").html("");
				            	}else{
				            		$("#hideDataSuccess").html("√");
				            		$("#showDataSuccess").html("");
				            	}
				            },
				            complete: function (XMLHttpRequest, textStatus) {
				            }
				        });
			});
			
		},
		FlushAllCache:function(obj){
			$("#"+obj+"").click(function(){
				var url=$Url.BuildPermissionUrl("permission/dataManage/flushAllCache");
				 $.ajax({
			            type: "get",
			            url: url,
			            dataType: "json",
			            timeout: 500000,
			            data: {
			            },
			            beforeSend: function () {
			            },
			            error: function (XMLHttpRequest, textStatus, errorThrown) {
//			                alert(errorThrown);
			            	alert("刷新失败，请从新尝试");
			            },
			            success: function (data, textStatus) {
			            	if (data.errCode=="OK") {
			            		$("#hideflushAllCache").html("√");
							}else{
								$("#hideflushAllCache").html("");
							}
			            },
			            complete: function (XMLHttpRequest, textStatus) {
			            }
			        });
			});
			
		},
		FlushBaseInfoCache:function(obj){
			$("#"+obj+"").click(function(){
				var url=$Url.BuildPermissionUrl("permission/dataManage/flushBaseInfoCache");
				 $.ajax({
			            type: "get",
			            url: url,
			            dataType: "json",
			            timeout: 30000,
			            data: {
			            },
			            beforeSend: function () {
			            },
			            error: function (XMLHttpRequest, textStatus, errorThrown) {
//			                alert(errorThrown);
			            	alert("刷新失败，请从新尝试");
			            },
			            success: function (data, textStatus) {
			            	if (data.errCode=="OK") {
			            		$("#hideflushBaseInfoCache").html("√");
							}else{
								$("#hideflushBaseInfoCache").html("");
							}
			            },
			            complete: function (XMLHttpRequest, textStatus) {
			            }
			        });
			});
			
		},
		FlushCustomerCache:function(obj){
			$("#"+obj+"").click(function(){
				var url=$Url.BuildPermissionUrl("permission/dataManage/flushCustomerCache");
				 $.ajax({
			            type: "get",
			            url: url,
			            dataType: "json",
			            timeout: 30000,
			            data: {
			            },
			            beforeSend: function () {
			            },
			            error: function (XMLHttpRequest, textStatus, errorThrown) {
//			                alert(errorThrown);
			            	alert("刷新失败，请从新尝试");
			            },
			            success: function (data, textStatus) {
			            	if (data.errCode=="OK") {
			            		$("#hideflushCustomerCache").html("√");
							}else{
								$("#hideflushCustomerCache").html("");
							}
			            },
			            complete: function (XMLHttpRequest, textStatus) {
			            }
			        });
			});
			
		},
		FlushEnumListForDictionary:function(obj){
			$("#"+obj+"").click(function(){
				var url=$Url.BuildPermissionUrl("permission/dataManage/flushEnumListForDictionary");
				 $.ajax({
			            type: "get",
			            url: url,
			            dataType: "json",
			            timeout: 30000,
			            data: {
			            },
			            beforeSend: function () {
			            },
			            error: function (XMLHttpRequest, textStatus, errorThrown) {
//			                alert(errorThrown);
			            	alert("刷新失败，请从新尝试");
			            },
			            success: function (data, textStatus) {
			            	if (data.errCode=="OK") {
			            		$("#hideflushDictionaryCache").html("√");
							}else{
								$("#hideflushDictionaryCache").html("");
							}
			            },
			            complete: function (XMLHttpRequest, textStatus) {
			            }
			        });
			});
			
		},
		FlushPermissionCache:function(obj){
			$("#"+obj+"").click(function(){
				var url=$Url.BuildPermissionUrl("permission/dataManage/flushPermissionCache");
				 $.ajax({
			            type: "get",
			            url: url,
			            dataType: "json",
			            timeout: 30000,
			            data: {
			            },
			            beforeSend: function () {
			            },
			            error: function (XMLHttpRequest, textStatus, errorThrown) {
//			                alert(errorThrown);
			            	alert("刷新失败，请从新尝试");
			            },
			            success: function (data, textStatus) {
			            	if (data.errCode=="OK") {
			            		$("#hideflushPermissionCache").html("√");
							}else{
								$("#hideflushPermissionCache").html("");
							}
			            },
			            complete: function (XMLHttpRequest, textStatus) {
			            }
			        });
			});
			
		},
		FlushProductCache:function(obj){
			$("#"+obj+"").click(function(){
				var url=$Url.BuildPermissionUrl("permission/dataManage/flushProductCache");
				 $.ajax({
			            type: "get",
			            url: url,
			            dataType: "json",
			            timeout: 30000,
			            data: {
			            },
			            beforeSend: function () {
			            },
			            error: function (XMLHttpRequest, textStatus, errorThrown) {
//			                alert(errorThrown);
			            	alert("刷新失败，请从新尝试");
			            },
			            success: function (data, textStatus) {
			            	if (data.errCode=="OK") {
			            		$("#hideflushProductCache").html("√");
							}else{
								$("#hideflushProductCache").html("");
							}
			            },
			            complete: function (XMLHttpRequest, textStatus) {
			            }
			        });
			});
			
		},
		FlushSalesCache:function(obj){
			$("#"+obj+"").click(function(){
				var url=$Url.BuildPermissionUrl("permission/dataManage/flushSalesCache");
				 $.ajax({
			            type: "get",
			            url: url,
			            dataType: "json",
			            timeout: 30000,
			            data: {
			            },
			            beforeSend: function () {
			            },
			            error: function (XMLHttpRequest, textStatus, errorThrown) {
//			                alert(errorThrown);
			            	alert("刷新失败，请从新尝试");
			            },
			            success: function (data, textStatus) {
			            	if (data.errCode=="OK") {
			            		$("#hideflushSalesCache").html("√");
							}else{
								$("#hideflushSalesCache").html("");
							}
			            },
			            complete: function (XMLHttpRequest, textStatus) {
			            }
			        });
			});
			
		},
		FlushWorkflowCache:function(obj){
			$("#"+obj+"").click(function(){
				var url=$Url.BuildPermissionUrl("permission/dataManage/flushWorkflowCache");
				 $.ajax({
			            type: "get",
			            url: url,
			            dataType: "json",
			            timeout: 30000,
			            data: {
			            },
			            beforeSend: function () {
			            },
			            error: function (XMLHttpRequest, textStatus, errorThrown) {
//			                alert(errorThrown);
			            	alert("刷新失败，请从新尝试");
			            },
			            success: function (data, textStatus) {
			            	if (data.errCode=="OK") {
			            		$("#hideflushWorkflowCache").html("√");
							}else{
								$("#hideflushWorkflowCache").html("");
							}
			            },
			            complete: function (XMLHttpRequest, textStatus) {
			            }
			        });
			});
			
		}
}

$(function () {
	ManagePage.CleckElem("showData",1);
	ManagePage.CleckElem("hideData",0);
	
	ManagePage.FlushBaseInfoCache("flushBaseInfoCache");
	ManagePage.FlushCustomerCache("flushCustomerCache");
	ManagePage.FlushEnumListForDictionary("flushDictionaryCache");
	ManagePage.FlushPermissionCache("flushPermissionCache");
	ManagePage.FlushProductCache("flushProductCache");
	ManagePage.FlushSalesCache("flushSalesCache");
	ManagePage.FlushWorkflowCache("flushWorkflowCache");
	ManagePage.FlushAllCache("flushAllCache");
});
