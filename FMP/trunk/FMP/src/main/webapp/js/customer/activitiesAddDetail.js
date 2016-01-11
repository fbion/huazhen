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
    GetActivitiesInfo: function (id) {
    	var actType = 0;
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxGetActivities");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            async:false,
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
                actType = data.info.activityType;
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return actType;
    },
    GetInfo: function (id) {
    	var actType = 0;
        var url = $Url.BuildCustomerUrl("/customer/activityCondition/ajaxGetActivityCondition");
        $.ajax({
            type: "post",
            url: url,
            async:false,
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
                actType = data.actType;
                $Util.DataToVal(data.info, ElementVar);
                $("#productType").trigger("change");
                $("#productType").val(data.info.productType);
                $("#productName").trigger("change");
                $("#productName").val(data.info.productName);
                ManagePage.ShowEditButton();
                if ($("#edit").length > 0) {
                    $("#edit").click(function () {
                        ManagePage.EnableInput();
                        ManagePage.HideEditButton();

                    });
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return actType;
    },
    GetInfos: function (id) {
    	var actType = 0;
        var url = $Url.BuildCustomerUrl("/customer/activityCondition/ajaxGetActivityCondition");
        $.ajax({
            type: "post",
            url: url,
            async:false,
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
                actType = data.actType;
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return actType;
    },
    isInt : function (a){
        var reg = /^\d+$/;
        return reg.test(a);
    },
    isDouble : function (a){
        var reg = /^\d+(\.\d+)?$/;
        return reg.test(a);
    },
    isDate : function (a){
        var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
        return reg.test(a);
    },
    addGrid:function(gridId){
    	if(Number(PageVar.ID)!=0){
    		var count = ManagePage.getBouns(Number(PageVar.ID));
        	if(count>=1){
        		alert("只允许有一个奖励");
        		return ;
        	}
    	}
    	
        	 var ids = jQuery('#'+gridId).jqGrid('getDataIDs');
        	 var rowid = Math.max.apply(null, ids) + 1;
    	        var dataRow = {
    	        		id:1,
    	        		a:"",
    	        		b:"",
    	        		c:"",
    	        		d:""
    	        };    
    	     jQuery('#'+gridId).jqGrid("addRowData", 1, dataRow, "last");
    	     jQuery('#'+gridId).editRow(1, true);
    	     
    	     jQuery('#'+gridId).setGridParam().hideCol("editComment");
    	     $("#1_activityRewardType").trigger(ManagePage.selectChange(1));
    },
    saveGrid:function(gridId,id){
    	if (Number(PageVar.ID) == 0){
    		alert("请先进行提交操作后在添加奖励");
    		return ;
    	}
    	var url = "";
//        var oper = "add";
//        if (Number(PageVar.ID) != 0)
            oper = "add";
            var datas = {};
            if(gridId=="rowed4"){
            	var acInfo = {
                        id: id,
                        conditionType: 0,
                        conditionDescription: $("#"+id+"_conditionDescription").val(),
                        conditionValue: $("#"+id+"_conditionValue").val(),
                        conditionRelation: $("#"+id+"_conditionRelation").val(),
                        productType: $("#"+id+"_productType").val(),
                        productName:$("#"+id+"_productName").val(),
                        editComment: "",
                        isTest: 0
                    }
            	
            	url = $Url.BuildCustomerUrl("/customer/activities/ajaxSaveGridActivities");

            	datas = {
                    oper: oper,
                    acInfo: JSON.stringify(acInfo)
                }
            }else if(gridId=="rowed3"){
            	var aarInfo = {
                        id: id,
                        conditionId: $("#"+id+"_conditionId").val(),
                        activityRewardType: $("#"+id+"_activityRewardType").val(),
                        relatedNo: $("#"+id+"_relatedNo").val(),
                        editComment: ""
                    }
            	if($("#"+id+"_activityRewardType").val()==1){//double,int
            		if(($("#"+id+"_a").val()==null || $("#"+id+"_a").val()=="")
            				||($("#"+id+"_b").val()==null || $("#"+id+"_b").val()=="")){
            			alert("请提供体验金奖励方式的面值,天数");
            			return ;
            		}
            		if(!ManagePage.isDouble($("#"+id+"_a").val()) || !ManagePage.isInt($("#"+id+"_b").val())){
        				alert("请填写正确的格式");
        				return ;
        			}
            	}else if($("#"+id+"_activityRewardType").val()==2){//double
            		if(($("#"+id+"_a").val()==null || $("#"+id+"_a").val()=="")){
            			alert("请提供现金奖励方式的面值");
            			return ;
            		}
            		if(!ManagePage.isDouble($("#"+id+"_a").val())){
        				alert("请填写正确的格式");
        				return ;
        			}
            	}else if($("#"+id+"_activityRewardType").val()==3){//int,int,Timestamp,Timestamp
            		if(($("#"+id+"_a").val()==null || $("#"+id+"_a").val()=="")
            				||($("#"+id+"_b").val()==null || $("#"+id+"_b").val()=="")
            				||($("#"+id+"_c").val()==null || $("#"+id+"_c").val()=="")
            				||($("#"+id+"_d").val()==null || $("#"+id+"_d").val()=="")){
            			alert("请提供优惠券奖励方式的面值,张数,有效期开始,有效期结束");
            			return ;
            		}
            		if(!ManagePage.isInt($("#"+id+"_a").val()) || !ManagePage.isInt($("#"+id+"_b").val())|| !ManagePage.isDate($("#"+id+"_c").val())|| !ManagePage.isDate($("#"+id+"_d").val())){
        				alert("请填写正确的格式");
        				return ;
        			}
            		$("#"+id+"_c").val($("#"+id+"_c").val()+" 00:00:00");
            		$("#"+id+"_d").val($("#"+id+"_d").val()+" 00:00:00");
            	}else if($("#"+id+"_activityRewardType").val()==4){//int,Timestamp,Timestamp
            		if(($("#"+id+"_a").val()==null || $("#"+id+"_a").val()=="")
            				||($("#"+id+"_b").val()==null || $("#"+id+"_b").val()=="")
            				||($("#"+id+"_c").val()==null || $("#"+id+"_c").val()=="")){
            			alert("请提供积分奖励方式的每人积分个数,有效期开始,有效期结束");
            			return ;
            		}
            		if(!ManagePage.isInt($("#"+id+"_a").val()) || !ManagePage.isDate($("#"+id+"_b").val())|| !ManagePage.isDate($("#"+id+"_c").val())){
        				alert("请填写正确的格式");
        				return ;
        			}
            		$("#"+id+"_b").val($("#"+id+"_b").val()+" 00:00:00");
            		$("#"+id+"_c").val($("#"+id+"_c").val()+" 00:00:00");
            	}else if($("#"+id+"_activityRewardType").val()==5){//不为空,double,int,Timestamp
            		if(($("#"+id+"_a").val()==null || $("#"+id+"_a").val()=="")
            				||($("#"+id+"_b").val()==null || $("#"+id+"_b").val()=="")
            				||($("#"+id+"_c").val()==null || $("#"+id+"_c").val()=="")
            				||($("#"+id+"_d").val()==null || $("#"+id+"_d").val()=="")){
            			alert("请提供礼品奖励方式的礼包名称,礼品价值,礼包个数,日期");
            			return ;
            		}
            		if(!ManagePage.isDouble($("#"+id+"_b").val()) || !ManagePage.isInt($("#"+id+"_c").val())|| !ManagePage.isDate($("#"+id+"_d").val())){
        				alert("请填写正确的格式");
        				return ;
        			}
            		$("#"+id+"_d").val($("#"+id+"_d").val()+" 00:00:00");
            	}
            	
            	url = $Url.BuildCustomerUrl("/customer/activities/ajaxSaveGridTwoActivities");
            	
            	datas = {
                        oper: oper,
                        a:$("#"+id+"_a").val(),
                        b:$("#"+id+"_b").val(),
            			c:$("#"+id+"_c").val(),
            			d:$("#"+id+"_d").val(),
                        aarInfo: JSON.stringify(aarInfo),
                        condID:PageVar.ID,
                        actID:PageVar.AID
                    }
            }
    	$.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data:datas,
            beforeSend: function () {
                $("#submit").attr("process", "processing");
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errCode == "0000") {
                	$('#'+gridId).trigger("reloadGrid");
                	jQuery('#'+gridId).saveRow(id, false); 
                	jQuery('#'+gridId).setGridParam().showCol("editComment").trigger("reloadGrid");
                } else {
                    $("#msg").text(data.errDesc);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
                $("#submit").removeAttr("process");
            }
        });
    },
    deleteGrid:function(gridId,id){
    	 if(!id){
    	      alert("请选择要删除的行");
    	      return;
    	     }else{
    	    	 if(confirm("确认要删除吗")){
    	    		 var datas = {};
    	    		 var url = "";
    	    		 if(gridId=="rowed4"){
        	    		 url = $Url.BuildCustomerUrl("/customer/activities/ajaxDeleteGridActivities");
        	    		 datas={
        	    			oper: "delete",
     	    	            gridId: id
        	    		 };
    	    		 }else if(gridId=="rowed3"){
        	    		 url = $Url.BuildCustomerUrl("/customer/activities/ajaxDeleteGridTwoActivities");
        	    		 datas={
        	    				oper: "delete",
     	    	                gridId: id,
     	    	                activityRewardType: $("#"+id+"_activityRewardType").val(),
     	                        relatedNo: $("#"+id+"_relatedNo").val()
             	    		 };
    	    		 }
    	    		 $.ajax({
    	    	            type: "post",
    	    	            url: url,
    	    	            dataType: "json",
    	    	            timeout: 30000,
    	    	            data:datas,
    	    	            beforeSend: function () {
    	    	                $("#submit").attr("process", "processing");
    	    	            },
    	    	            error: function (XMLHttpRequest, textStatus, errorThrown) {
    	    	                alert(errorThrown);
    	    	            },
    	    	            success: function (data, textStatus) {
    	    	                if (data.errCode == "0000") {
    	    	    	    		 jQuery('#'+gridId).jqGrid("delRowData", id); 
    	    	                } else {
    	    	                    $("#msg").text(data.errDesc);
    	    	                }
    	    	            },
    	    	            complete: function (XMLHttpRequest, textStatus) {
    	    	                $("#submit").removeAttr("process");
    	    	            }
    	    	        });
    	    	 }
    	  }  
    },
    editGrid:function(gridId,id){
    	jQuery('#'+gridId).editRow(id, true);
    	
    	jQuery('#'+gridId).setGridParam().hideCol("editComment");
    	
    	$('#'+id+"_activityRewardType").trigger(ManagePage.selectChange(id));
    	
    	
    	
    },
    selectChange:function(id){
    	if($('#'+id+"_activityRewardType").val()==1){
    		$("#jqgh_rowed3_a").text("元");
        	$("#jqgh_rowed3_b").text("天");
        	$("#jqgh_rowed3_c").text("");
        	$("#jqgh_rowed3_d").text("");
    	}else if($('#'+id+"_activityRewardType").val()==2){
    		$("#jqgh_rowed3_a").text("元");
    		$("#jqgh_rowed3_b").text("");
        	$("#jqgh_rowed3_c").text("");
        	$("#jqgh_rowed3_d").text("");
    	}else if($('#'+id+"_activityRewardType").val()==3){
    		$("#jqgh_rowed3_a").text("面值");
        	$("#jqgh_rowed3_b").text("限制张数<=");
        	$("#jqgh_rowed3_c").text("有效期开始");
        	$("#jqgh_rowed3_d").text("有效期结束");
    	}else if($('#'+id+"_activityRewardType").val()==4){
    		$("#jqgh_rowed3_a").text("每人积分数");
    		$("#jqgh_rowed3_b").text("有效期开始");
        	$("#jqgh_rowed3_c").text("有效期结束");
        	$("#jqgh_rowed3_d").text("");
    	}else if($('#'+id+"_activityRewardType").val()==5){
    		$("#jqgh_rowed3_a").text("礼品名称");
    		$("#jqgh_rowed3_b").text("礼品价值");
        	$("#jqgh_rowed3_c").text("礼包个数");
        	$("#jqgh_rowed3_d").text("领取时间");
    	}
    	$('#'+id+"_activityRewardType").change(function(){
    		if($('#'+id+"_activityRewardType").val()==1){
        		$("#jqgh_rowed3_a").text("元");
            	$("#jqgh_rowed3_b").text("天");
            	$("#jqgh_rowed3_c").text("");
            	$("#jqgh_rowed3_d").text("");
        	}else if($('#'+id+"_activityRewardType").val()==2){
        		$("#jqgh_rowed3_a").text("元");
        		$("#jqgh_rowed3_b").text("");
            	$("#jqgh_rowed3_c").text("");
            	$("#jqgh_rowed3_d").text("");
        	}else if($('#'+id+"_activityRewardType").val()==3){
        		$("#jqgh_rowed3_a").text("面值");
            	$("#jqgh_rowed3_b").text("限制张数<=");
            	$("#jqgh_rowed3_c").text("有效期开始");
            	$("#jqgh_rowed3_d").text("有效期结束");
        	}else if($('#'+id+"_activityRewardType").val()==4){
        		$("#jqgh_rowed3_a").text("每人积分数");
        		$("#jqgh_rowed3_b").text("有效期开始");
            	$("#jqgh_rowed3_c").text("有效期结束");
            	$("#jqgh_rowed3_d").text("");
        	}else if($('#'+id+"_activityRewardType").val()==5){
        		$("#jqgh_rowed3_a").text("礼品名称");
        		$("#jqgh_rowed3_b").text("礼品价值");
            	$("#jqgh_rowed3_c").text("礼包个数");
            	$("#jqgh_rowed3_d").text("领取时间");
        	}
        });
    },
    getBouns:function(id){
    	var count = 0;
        var url = $Url.BuildCustomerUrl("/customer/activities/ajaxGetBouns");
        $.ajax({
            type: "post",
            url: url,
            async : false,
            dataType: "json",
            timeout: 30000,
            data: {condID:id},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
            	count = data.count;
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
        return count;
    }
}
$(function () {
    $("#back").click(function () {
        //window.location.href = $Url.BuildCustomerUrl("/customer/activities/list");
        window.close();
    });
	EnumList.GetEnumListToSelect($("#conditionRelation"),"conditionRelation",$Url.BuildCustomerUrl("/common/enumList.action"));
    $.fn.linkage({
        elements: [$("#productType"), $("#productName")],
        dataTypes: ["productType", "productNo"],
        actionUrl: $Url.BuildSalesUrl("/common/enumList.action"),
        all: false
    });
    if (Number(PageVar.ID) == 0) {
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
        var acType = 0;
        acType = ManagePage.GetActivitiesInfo(Number(PageVar.AID));
    	EnumList.GetEnumListToSelect($("#conditionDescription"),"conditionDescription"+acType,$Url.BuildCustomerUrl("/common/enumList.action"));
    }
    else {
    	var acType = 0;
    	EnumList.GetEnumListToSelect($("#conditionDescription"),"conditionDescription5",$Url.BuildCustomerUrl("/common/enumList.action"));
        acType = ManagePage.GetInfos(PageVar.ID);
    	EnumList.GetEnumListToSelect($("#conditionDescription"),"conditionDescription"+acType,$Url.BuildCustomerUrl("/common/enumList.action"));
    	ManagePage.GetInfo(PageVar.ID);
    }
    jQuery("#rowed4").jqGrid({ 
    	url: $Url.BuildCustomerUrl('/customer/activityCondition/ajaxListActivityCondition.action'),
        datatype: "json",
        mtype: 'GET',
        colNames: ["操作","id","conditionType","conditionDescription","conditionValue","conditionRelation","productType","productName","editComment","isTest"],
        colModel: [
            {
   				name: "act", index: "act", width: 60, align: "center", sortable: false
			},
			{
				name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
			},
			{
				name: "conditionType", index: "conditionType", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "conditionDescription", index: "conditionDescription", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "conditionValue", index: "conditionValue", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "conditionRelation", index: "conditionRelation", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true,edittype:"select",editoptions:{value:"1:>;2:<;3:=;4:>=;5:<="}
			},
			{
				name: "productType", index: "productType", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true,edittype:"select",editoptions:{value:"1:FedEx;2:InTime;3:TNT;4:ARAMEX"}
			},
			{
				name: "productName", index: "productName", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true,edittype:"select",editoptions:{value:"1:FedExx;2:InTimex;3:TNTx;4:ARAMEXx"}
			},
			{
				name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "isTest", index: "isTest", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
			}                
        ],
    	rowNum:10, 
    	rowList:[10,20,30], 
    	pager: '#prowed4', sortname: 'id', viewrecords: true, sortorder: "asc", 
    	caption: "Using navigator", autowidth: true,
        height: "auto",jsonReader: {
            root: "resultList",
            page: "pageIndex",
            total: "pageCount",
            records: "recordCount",
            repeatitems: false
        },prmNames: {
            search: "search",
            page: "pageIndex",
            rows: "pageSize"
        },
//        editurl: "a.php",
        gridComplete: function(){
//        	$("#rowed4").setGridParam({cellEdit:true});
        	var ids = jQuery("#rowed4").jqGrid('getDataIDs');
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			ae = "<a class=\"blue\" href=\"javascript:ManagePage.addGrid('rowed4')\">增加</a>";
    			be = "<a class=\"blue\" href=\"javascript:ManagePage.editGrid('rowed4','" + id + "')\">修改</a>";
    			se = "<a class=\"blue\" href=\"javascript:ManagePage.saveGrid('rowed4','" + id + "')\">保存</a>";
    			ce = "<a class=\"blue\" href=\"javascript:ManagePage.deleteGrid('rowed4','" + id + "')\">删除</a>";
    			
//    			ae = "<input style='height:22px;width:20px;' type='button' value='增' onclick=\"editRow('"+id+"');\"  />";
//    			be = "<input style='height:22px;width:20px;' type='button' value='改' onclick=\"editRow('"+id+"');\"  />"; 
//    			se = "<input style='height:22px;width:20px;' type='button' value='存' onclick=\"jQuery('#rowed2').saveRow('"+id+"');\"  />"; 
//    			ce = "<input style='height:22px;width:20px;' type='button' value='删' onclick=\"jQuery('#rowed2').restoreRow('"+id+"');\" />"; 
    			jQuery("#rowed4").jqGrid('setRowData',id,{act:ae+"|"+be+"|"+se+"|"+ce});
    		}
    		if(ids.length==0){
    			var dataRow = {
    	        		id:1
    	        }; 
       	     	jQuery('#rowed4').jqGrid("addRowData", 1, dataRow, "last");
    		}
    	}
    }); 
    jQuery("#rowed4").jqGrid('navGrid',"#prowed4",{edit:false,add:false,del:false}); 
    jQuery("#rowed4").jqGrid('inlineNav',"#prowed4");
    
    jQuery("#rowed3").jqGrid({ 
    	url: $Url.BuildCustomerUrl('/customer/activityAwardRelation/ajaxListActivityAwardRelation.action'),
        datatype: "json",
        mtype: 'GET',
        colNames: ["操作","id","conditionId","奖励方式","relatedNo","描述","条件1","条件2","条件3","条件4"],
        colModel: [

			{
				name: "act", index: "act", width: 30, align: "center", sortable: false
			},
			{
				name: "id", index: "id", width: 20,hidden:true, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
			},
			{
				name: "conditionId", index: "conditionId",hidden:true, width: 20, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "activityRewardType", index: "activityRewardType", width: 20, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true,edittype:"select",editoptions: { size: 1, value: EnumList.GetEnumListToEdit("activityRewardType", $Url.BuildCustomerUrl("/common/enumList.action")) }
			},
			{
				name: "relatedNo",hidden:true, index: "relatedNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "editComment", index: "editComment", width: 80, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "a", index: "a", width: 20, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "b", index: "b", width: 20, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "c", index: "c", width: 20, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
			},
			{
				name: "d", index: "d", width: 20, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions:{ size: 40 }
			}
        ],
    	rowNum:10, 
    	rowList:[10,20,30], 
    	pager: '#prowed3', sortname: 'id', viewrecords: true, sortorder: "asc", 
    	caption: "Using navigator", autowidth: true,
    	postData:{
    		conditionID:PageVar.ID
    	},
        height: "auto",jsonReader: {
            root: "resultList",
            page: "pageIndex",
            total: "pageCount",
            records: "recordCount",
            repeatitems: false
        },prmNames: {
            search: "search",
            page: "pageIndex",
            rows: "pageSize"
        },
//        editurl: "a.php",
        gridComplete: function(){
//        	$("#rowed4").setGridParam({cellEdit:true});
        	var ids = jQuery("#rowed3").jqGrid('getDataIDs');
        	var bs = $("#rowed3").jqGrid('getCol', 'b', true);
        	var cs = $("#rowed3").jqGrid('getCol', 'c', true);
        	var ds = $("#rowed3").jqGrid('getCol', 'd', true);
        	var activityRewardTypes = $("#rowed3").jqGrid('getCol', 'activityRewardType', true);
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			var b = bs[i].value;
    			var c = cs[i].value;
    			var d = ds[i].value;
    			var activityRewardType = activityRewardTypes[i].value;
    			ae = "<a class=\"blue\" href=\"javascript:ManagePage.addGrid('rowed3')\">增加</a>";
    			be = "<a class=\"blue\" href=\"javascript:ManagePage.editGrid('rowed3','" + id + "')\">修改</a>";
    			se = "<a class=\"blue\" href=\"javascript:ManagePage.saveGrid('rowed3','" + id + "')\">保存</a>";
    			ce = "<a class=\"blue\" href=\"javascript:ManagePage.deleteGrid('rowed3','" + id + "')\">删除</a>";
    			
    			jQuery("#rowed3").jqGrid('setRowData',id,{act:ae+"|"+be+"|"+se+"|"+ce});
    			if(b.indexOf(" ")>-1){
    				$("#rowed3 #"+id+" td[aria-describedby='rowed3_b']").text(b.split(" ")[0]);
    			}
    			if(c.indexOf(" ")>-1){
    				$("#rowed3 #"+id+" td[aria-describedby='rowed3_c']").text(c.split(" ")[0]);
    			}
    			if(d.indexOf(" ")>-1){
    				$("#rowed3 #"+id+" td[aria-describedby='rowed3_d']").text(d.split(" ")[0]);
    			}
    			if(activityRewardType==1){
    				$("#rowed3 #"+id+" td[aria-describedby='rowed3_activityRewardType']").text("体验金");
    			}else if(activityRewardType==2){
    				$("#rowed3 #"+id+" td[aria-describedby='rowed3_activityRewardType']").text("现金");
    			}else if(activityRewardType==3){
    				$("#rowed3 #"+id+" td[aria-describedby='rowed3_activityRewardType']").text("优惠券");
    			}else if(activityRewardType==4){
    				$("#rowed3 #"+id+" td[aria-describedby='rowed3_activityRewardType']").text("积分");
    			}else if(activityRewardType==5){
    				$("#rowed3 #"+id+" td[aria-describedby='rowed3_activityRewardType']").text("礼包");
    			}
    		}
    		if(ids.length==0){
    			var dataRow = {
    	        		id:1
    	        }; 
       	     	jQuery('#rowed3').jqGrid("addRowData", 1, dataRow, "last");
    		}
    	}
    }); 
    jQuery("#rowed3").jqGrid('navGrid',"#prowed3",{edit:false,add:false,del:false}); 
    jQuery("#rowed3").jqGrid('inlineNav',"#prowed3");
    
    var activitiesAddDetail = $("#activitiesAddDetail").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildCustomerUrl("/customer/activities/ajaxEditActivitiesAddDetail");
            var oper = "add";
            if (Number(PageVar.ID) != 0)
                oper = "edit";
            var acInfo = {
                    id: Number(PageVar.ID),
                    conditionType: 0,
                    conditionDescription: $("#conditionDescription").val(),
                    conditionValue: $("#conditionValue").val(),
                    conditionRelation: $("#conditionRelation").val(),
                    productType: $("#productType").val(),
                    productName:$("#productName").val(),
                    editComment: "",
                    isTest: 0
            }
            var ids = jQuery("#rowed3").jqGrid('getDataIDs');
            var ides = "";
    		for(var i=0;i < ids.length;i++){
    			var id = ids[i];
    			ides = ides+"@"+id;
    		}
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    oper: oper,
                    acInfo: JSON.stringify(acInfo),
                    ids : ides,
                    aId : PageVar.AID
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    if (data.errCode == "0000") {
                        window.location.href = $Url.BuildCustomerUrl("/customer/activities/addDetail?id=" + data.errDesc);
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
    activitiesAddDetail.addRule([
	{
	    ele: "#conditionDescription",
	    datatype: "*",
	
	    nullmsg: "请填写条件描述",
	    errormsg: "",
	    sucmsg: " "
	},{
	    ele: "#conditionValue",
	    datatype: "n",
	
	    nullmsg: "请填写条件正确的值",
	    errormsg: "",
	    sucmsg: " "
	}
    ]);
})