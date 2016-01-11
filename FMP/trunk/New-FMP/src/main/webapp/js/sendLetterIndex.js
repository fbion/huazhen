var LetterPageManage = {
		getAgentBusinessPage:function(){
			var url = $Url.BuildBaseInfoUrl('/sendLetterForAgentBusiness');
	        $.ajax({
	                type: "POST",
	                url: url,
	                async:false,  
	                dataType: "html",
	                data: {
	                },
	                error: function (request) {
	                },
	                success: function (data) {
	                    $("#letterIndex").html(data);
	                    LetterPageManage.bindProduct();
	                }
	            }
	        );
		},
		bindProduct:function(){
			$.fn.linkage({
		        elements: [$("#productType"), $("#productNo")],
		        dataTypes: ["productType", "productNo"],
		        actionUrl: $Url.BuildBaseInfoUrl("/common/enumList.action"),
		        all: false
		    });
		},
		checkBoxInit:function(){
			$("input[type='checkbox']").off().on("click",function(){
					if ($(this).attr("checked")=="checked"||$(this).attr("checked")=="true") {
						$(this).removeAttr("checked");
					}
					else{
						$(this).attr("checked","true").prop('checked',true);
					}
			});
			
		},
		checkBoxSelectAll:function(){
			$("#allckecked").click(function(){
				if ($(this).attr("checked")=="checked"||$(this).attr("checked")=="true") {
					$(".checkAgentBusiness").attr("checked","true").prop('checked',true);
				}else{
					$(".checkAgentBusiness").removeAttr("checked");
					
				}
			});
			
			$("#fileschecked").click(function(){
				if ($(this).attr("checked")=="checked"||$(this).attr("checked")=="true") {
					$(".checkfiles").attr("checked","true").prop('checked',true);
				}else{
					$(".checkfiles").removeAttr("checked");
				}
			});
		},
		getProductFliesById:function(id){
			if (id!=0) {
				var url = $Url.BuildProductUrl("/product/productAttachment/ajaxListFile");
				 $.ajax({
		                type: "POST",
		                url: url,
		                async:false,  
		                dataType: "json",
		                timeout: 30000,
		                data: {
		                	productNo: id
		                    },
		                error: function (request) {
		                },
		                success: function (data) {
		                	var length = data.resultList.length
		                	$(".moveCheck").remove();
		                	for (var i = 0; i < length; i++) {
		                		var tempName = data.resultList[i].name;
		                		if (tempName.length>5) {
									tempName = tempName.substring(0,4);
									tempName = tempName+"....";
								}
		                		if (data.resultList[i].type==1) {
		                			$("#getLi1").append(
											"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
		                		if (data.resultList[i].type==2) {
		                			$("#getLi2").append(
		                					"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
		                		if (data.resultList[i].type==3) {
		                			$("#getLi3").append(
		                					"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
		                		if (data.resultList[i].type==4) {
		                			$("#getLi4").append(
		                					"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
		                		if (data.resultList[i].type==5) {
		                			$("#getLi5").append(
		                					"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
		                		if (data.resultList[i].type==6) {
		                			$("#getLi6").append(
		                					"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
		                		if (data.resultList[i].type==7) {
		                			$("#getLi7").append(
		                					"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
		                		if (data.resultList[i].type==8) {
		                			$("#getLi8").append(
		                					"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
		                		if (data.resultList[i].type==9) {
		                			$("#getLi9").append(
		                					"<a class='moveCheck' title='"+data.resultList[i].name+"'><input type='checkbox' class='checkfiles' fileName='"+data.resultList[i].name+"' filesUrl='"+data.resultList[i].path+"'/>"+tempName+"</a>");	
								}
								
							}
		                }
		            });	
			}
			LetterPageManage.checkBoxInit();
			LetterPageManage.checkBoxSelectAll();
		},
		setAgentBusinessLetterInfo:function(){
			var temp = $(".checkAgentBusiness");
			var emailString = "";
			temp.each(function(){
				if ($(this).attr("checked")=="checked") {
					emailString +=$(this).attr("email")+';' ;
				}
			  });
			
			var emailTheme = $("#emailTheme").val();
			var emailContext = $("#emailContext").val();
			var tempFiles = $(".checkfiles");
			
			var json = new Array();
			for (var i = 0; i < tempFiles.length; i++) {
				if (tempFiles.eq(i).attr("checked")=="checked") {
					var info = {}; 
					info.path = tempFiles.eq(i).attr("filesUrl");
					info.name = tempFiles.eq(i).attr("fileName");
					json.push(info);	
				}
			}

			var checkedfiles = JSON.stringify(json);
			var url = $Url.BuildBaseInfoUrl('/sendLetterGo');
	        $.ajax({
	                type: "POST",
	                url: url,
	                async:false,  
	                dataType: "json",
	                timeout: 30000,
	                data: {
	                	emailTo:emailString,
	                	checkedfiles:checkedfiles,
	                	emailTheme:emailTheme,
	                	emailContext:emailContext
	                },
	                error: function (request) {
	                },
	                success: function (data) {
	                   alert(data.msg);
	                  window.location.href = $Url.BuildBaseInfoUrl("/customer/agentBusiness/list");
	                }
	            }
	        );
			
		}
		
}






$(function () {
	if (PageVar.LetterType==TagLetterType.agentBusiness) {
		LetterPageManage.getAgentBusinessPage();
	}

	LetterPageManage.checkBoxInit();
	LetterPageManage.checkBoxSelectAll();
	$("#productNo").change(function(){
		var id = $("#productNo").val();
		if (id>0) {
			LetterPageManage.getProductFliesById(id);
		
		}
	});
	$("#productType").change(function(){
		var id = $("#productNo").val();
		if (id>0) {
			LetterPageManage.getProductFliesById(id);
		
		}
	});
	
	$("#sendLetterSubmit").click(function(){
		LetterPageManage.setAgentBusinessLetterInfo();
		
	});	
	
	$("#backBtn").click(function(){
		window.location.href = $Url.BuildBaseInfoUrl("/customer/agentBusiness/list");
	});
	
})