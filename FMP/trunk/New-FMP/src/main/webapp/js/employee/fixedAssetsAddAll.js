var assetTypes = getAssetTypeList(73);
var locations = getAssetTypeList(74);
var statuses = getAssetTypeList(76);
var depts = getDeptList();
var emps = getEmpList(0);

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
    GetInfo: function (id) {
        var url = $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxGetFixedAssets");
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
                $Util.DataToVal(data.rigInfo, ElementVar);
                

                $(".department").trigger("change");
                $(".userNo").val(data.info.userNo);
                
                
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
    },
    format:function(data){
        var result = [];
        $.each(data.listItems,function(i,item) {
            var row = {};
            row.id = item.value;
            row.text = item.text;
            result.push(row);
            });
        return result;
    },
    isInt : function (a){
        var reg = /^\d+$/;
        return reg.test(a);
    },
    isDouble : function (a){
        var reg = /^\d+(\.\d+)?$/;
        return reg.test(a);
    }
}
function getAssetTypeList(dicNo){
	var tempVal = "";
	$.ajax({
        type: "post",
        url: $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxGetAssetTypeList"),
//        dataType: "json",
        data:{
        	dicNo:dicNo
        },
        async:false,
        timeout: 30000,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
            return false;
        },
        success: function (data, textStatus) {
//        		var tempJsonOb = data.jsonObject.replace("[","[{\"code\":\"0\",\"value\":\"全部\"},");
            	tempVal = $.parseJSON(data.jsonObject);
        },
        complete: function (XMLHttpRequest, textStatus) {
        }
    });
	return tempVal;
}
function getDeptList(){
	var tempVal = "";
	$.ajax({
        type: "post",
        url: $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxGetDeptList"),
        async:false,
        timeout: 30000,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
            return false;
        },
        success: function (data, textStatus) {
    			var tempJsonOb = data.jsonObject.replace("[","[{\"id\":\"0\",\"name\":\"全部\"},");
            	tempVal = $.parseJSON(tempJsonOb);
        },
        complete: function (XMLHttpRequest, textStatus) {
        }
    });
	return tempVal;
}
function getEmpList(deptId){
	var tempVal = "";
	$.ajax({
        type: "post",
        url: $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxGetEmpList"),
        async:false,
        data:{deptId:deptId},
        timeout: 30000,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
            return false;
        },
        success: function (data, textStatus) {
        	var tempJsonOb = "";
//        	if(deptId==0){
	        	tempJsonOb = data.jsonObject.replace("[","[{\"id\":\"0\",\"name\":\"全部\"},");
//        	}else{
//	        	tempJsonOb = data.jsonObject;
//        	}
	        	tempVal = $.parseJSON(tempJsonOb);
        },
        complete: function (XMLHttpRequest, textStatus) {
        }
    });
	return tempVal;
}
var CompanyList = {
	    InitGrid: function () {
	        //默认是通过id倒排序，默认可不写，支持传递多个排序条件
	        //var sortList = [{sort:"in_user_no",order:"desc"},{sort:"id",order:"desc"}];
	        //var sortList = [{sort:"edit_user_no",order:"desc"}];
	        $("#gridTable").datagrid({
	            url: $Url.BuildEmployeeUrl('/employee/company/easyUICompanyList'),
	            method: 'post',
	            resizable: true,
//	            fit: true,
	            multiSort: true,
	            autoRowHeight: false,
	            singleSelect: true,
	            toolbar: "#toolbar",
	            loadMsg: "正在加载，请稍等...",
	            pagination: false,
	            rownumbers: true,
	            pageNumber:15,
	            queryParams: {
	            },
	            columns: [[
   	                {field: 'id', title: 'id',width:80, align: 'center', halign: 'center', hidden: true, sortable: true,editor:'text'},
   	                {field: 'assetType', title: '分类',width:80, align: 'center', halign: 'center', hidden: false,formatter:CompanyList.assetTypeFormatter,
   	                	editor:{
   	                		type:'combobox',
   	                		options:{
   	   	                		valueField:'code',  
   	   	                		textField:'value',  
   	   	                		data:assetTypes,
   	   	                		required:true,
   	   	                		panelHeight:95
   	   	                		}
   	                	}},
	                {field: 'assetId', title: '编号',width:150, align: 'center', halign: 'center', hidden: false, editor:'text'},
	                {field: 'assetName', title: '名称',width:80, align: 'center', halign: 'center', hidden: false, editor:'text'},
	                {field: 'brand', title: '品牌',width:80, align: 'center', halign: 'center', hidden: false, editor:'text'},
	                {field: 'model', title: '型号',width:80, align: 'left', halign: 'center', hidden: false,editor:'text'},
	                {field: 'CPU',title: 'CPU',width:80,lign: 'left', halign: 'center',hidden: false,editor:'text'},
	                {field: 'memory', title: '内存',width:80, align: 'left', halign: 'center', hidden: false,editor:'text'},
	                {field: 'hardDisk', title: '硬盘',width:80, align: 'left', halign: 'center', hidden: false,editor:'text'},
	                {field: 'count', title: '数量',width:80, align: 'left', halign: 'center', hidden: false,editor:'text'},
	                {field: 'price', title: '单价',width:80, align: 'left', halign: 'center', hidden: false,editor:'text'},
	                {field: 'money', title: '金额',width:80, align: 'left', halign: 'center', hidden: true,editor:'text'},
	                {field: 'location', title: '存放位置',width:120, align: 'left', halign: 'center', hidden: false,formatter:CompanyList.locationFormatter,
   	                	editor:{
   	                		type:'combobox',
   	                		options:{
   	   	                		valueField:'code',  
   	   	                		textField:'value',  
   	   	                		data:locations,
   	   	                		required:true  
   	   	                		}
   	                	}},
	                {field: 'department', title: '使用部门',width:120, align: 'left', halign: 'center', hidden: false,formatter:CompanyList.deptFormatter,
   	   	                	editor:{
   	   	                		type:'combobox',
   	   	                		options:{
   	   	   	                		valueField:'id',  
   	   	   	                		textField:'name',  
   	   	   	                		data:depts,
   	   	   	                		required:true,
   	   	   	                		onSelect: function (rec) {
		                               var row = $('#gridTable').datagrid("getSelections");
		                               var rowIndex = $('#gridTable').datagrid('getRowIndex', row[0]);
		                               var target = $('#gridTable').datagrid('getEditor', { 'index': rowIndex, 'field': 'userNo' }).target;
		                               target.combobox('clear');
		                               var empsByDept = getEmpList(rec.id);
		                               target.combobox('loadData', empsByDept);
		                               target.combobox('setValue', 0);
		                           }
   	   	                		}
   	                	}},
	                {field: 'userNo', title: '使用人',width:100, align: 'left', halign: 'center', hidden: false,formatter:CompanyList.empFormatter,
   	   	   	                	editor:{
   	   	   	                		type:'combobox',
   	   	   	                		options:{
   	   	   	   	                		valueField:'id',  
   	   	   	   	                		textField:'name',  
   	   	   	   	                		data:emps,
   	   	   	   	                		required:true  
   	   	   	   	                		}
   	   	   	                	}},
	                {field: 'status',title: '状态',width:80,align: 'left',halign: 'center', hidden: false,formatter:CompanyList.statusFormatter,
   	                	editor:{
   	                		type:'combobox',
   	                		options:{
   	   	                		valueField:'code',  
   	   	                		textField:'value',  
   	   	                		data:statuses,
   	   	                		required:true,
   	   	                		panelHeight:95  
   	   	                		}
   	                	}},
	                {field: 'editComment', title: '备注',width:150, align: 'left', halign: 'center', hidden: false,editor:'text'}
	            ]],
	            onBeforeLoad: function (param) {
	                $.getJSON($Url.BuildEmployeeUrl("/getColumnCookie"), {key: "companyList"}, function (data) {
	                    $.each(JSON.parse(data.value), function (i, item) {
	                        for(var temp in item){
	                            if(item[temp]){
	                                $("#gridTable").datagrid("hideColumn", temp);
	                            }
	                            else {
	                                $("#gridTable").datagrid("showColumn", temp);
	                            }
	                        }
	                    });
	                });
	            },
	            onClickCell: CompanyList.onClickCell
	        }).datagrid("columnMoving");
	    },
	    InitQuery: function () {
	        var name = $("#name").val();

	        $("#gridTable").datagrid("load", {
	            name: name
	        });
	    },
	    onClickCell:function(index, field) { 
	        $('#gridTable').datagrid('beginEdit', index);          
	        var ed =$('#gridTable').datagrid('getEditor', { index: index, field: field }); 
	        var edAssetType =$('#gridTable').datagrid('getEditor', { index: index, field: "assetType" });
	        var edLocation =$('#gridTable').datagrid('getEditor', { index: index, field: "location" });
	        var edDepartment =$('#gridTable').datagrid('getEditor', { index: index, field: "department" });
	        var edUserNo =$('#gridTable').datagrid('getEditor', { index: index, field: "userNo" });
	        var edStatus =$('#gridTable').datagrid('getEditor', { index: index, field: "status" });
//	        $(edAssetType.target).combobox('reload',$Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxGetAssetTypeList")); 
	        $(edAssetType.target).combobox('setValue',1); 
	        $(edLocation.target).combobox('setValue',1);
	        $(edDepartment.target).combobox('setValue',0);
	        $(edUserNo.target).combobox('setValue',0);
	        $(edStatus.target).combobox('setValue',1);
	        var rows=$('#gridTable').datagrid('getRows');
	        for(var i=0;i<rows.length;i++){
	        	if(i!=index){
			        $('#gridTable').datagrid('endEdit', i); 
	        	}
	        }
	    },
	    assetTypeFormatter:function(value){
	    	for(var i=0; i<assetTypes.length; i++){
	    		if (assetTypes[i].code == value) return assetTypes[i].value;
	    	}
	    	return value;
	    },
	    locationFormatter:function(value){
	    	for(var i=0; i<locations.length; i++){
	    		if (locations[i].code == value) return locations[i].value;
	    	}
	    	return value;
	    },
	    statusFormatter:function(value){
	    	for(var i=0; i<statuses.length; i++){
	    		if (statuses[i].code == value) return statuses[i].value;
	    	}
	    	return value;
	    },
	    deptFormatter:function(value){
	    	for(var i=0; i<depts.length; i++){
	    		if (depts[i].id == value) return depts[i].name;
	    	}
	    	return value;
	    },
	    empFormatter:function(value){
	    	for(var i=0; i<emps.length; i++){
	    		if (emps[i].id == value) return emps[i].name;
	    	}
	    	return value;
	    }
}
function cssChange(int,stag){
	$("tr[datagrid-row-index=\""+int+"\"] td[field=\""+stag+"\"]").css("backgroundColor","#ff0000");
}
$(function () {
    $("#back").click(function () {
    	 $EasyUI.Close();
    });
    var empNameByTabs = top.jQuery("#empName").text();
    $("#operator").val(empNameByTabs);
    
    CompanyList.InitGrid();
    
    $.ajax({
        method: "POST",
        url: $Url.BuildEmployeeUrl("/common/enumList.action"),
        data: {
            type: "suppliersList"
        },
        success: function (data) {
            $("#suppliersId").select2({
                width:150,
                placeholder: "请选择",
                data: ManagePage.format(data)
            });
        }
    });
    $("#registrationDate").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });

    EnumList.GetEnumListToSelect($("#type"), "assetsTypeGlobal", $Url.BuildSalesUrl("/common/enumList.action"));
        ManagePage.EnableInput();
        ManagePage.HideEditButton();
    var fixedAssetsAddAll = $("#fixedAssetsAddAll").Validform({
        tiptype: function (msg, o, cssctl) {
            var objtip = o.obj.siblings(".Validform_checktip");
            cssctl(objtip, o.type);
            objtip.text(msg);
        },
        callback: function (form) {
            if (!($("#submit").attr("process") === undefined)) {
                return false;
            }
            var url = $Url.BuildEmployeeUrl("/employee/fixedAssets/ajaxEditFixedAssets");
            var oper = "add";
//            if (Number($("registrationId").val()) != 0)
//                oper = "edit";
            var rows=$('#gridTable').datagrid('getRows');
            for(var i=0;i<rows.length;i++){
			        $('#gridTable').datagrid('endEdit', i); 
	        }
            
            var count=0;
            for (var i = 1; i <=rows.length; i++) {
				if(rows[i-1].assetId!="" && rows[i-1].assetId!=null){
					count++;
				}
			}
            if(count==0){
            	alert("请添加资产信息");
            }else{
	            if(confirm("确定添加这"+count+"条数据嘛")){
	            	var errInfo = "";
	            	for (var i = 1; i <=rows.length; i++) {
	            		if(rows[i-1].assetId!="" && rows[i-1].assetId!=null){
	            			
	            			if(!ManagePage.isInt(rows[i-1].count)){
	            				errInfo = errInfo+"1";
	            				cssChange(Number(i-1),"count");
	            			}
	            			if(!ManagePage.isDouble(rows[i-1].price)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"price");
	            			}
		    				if($String.IsNullOrEmpty(rows[i-1].assetType)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"assetType");
	            			}
	    					if($String.IsNullOrEmpty(rows[i-1].assetId) ){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"assetId");
	            			}
    						if($String.IsNullOrEmpty(rows[i-1].assetName)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"assetName");
	            			} 
							if($String.IsNullOrEmpty(rows[i-1].brand)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"brand");
	            			} 
							if($String.IsNullOrEmpty(rows[i-1].model)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"model");
	            			} 
							if($String.IsNullOrEmpty(rows[i-1].count)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"count");
	            			}
							if($String.IsNullOrEmpty(rows[i-1].price)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"price");
	            			} 
							if($String.IsNullOrEmpty(rows[i-1].location)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"location");
	            			}
							if($String.IsNullOrEmpty(rows[i-1].department)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"department");
	            			} 
							if($String.IsNullOrEmpty(rows[i-1].userNo)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"userNo");
	            			}
							if($String.IsNullOrEmpty(rows[i-1].status)){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"status");
	            			}
	    					if(rows[i-1].assetType==1 &&($String.IsNullOrEmpty(rows[i-1].CPU))){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"CPU");
	            			}
							if(rows[i-1].assetType==1 &&($String.IsNullOrEmpty(rows[i-1].memory))){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"memory");
	            			}
							if(rows[i-1].assetType==1 &&($String.IsNullOrEmpty(rows[i-1].hardDisk))){
	            				errInfo = errInfo+"2";
	            				cssChange(Number(i-1),"hardDisk");
	            			}
	            		}
	            	}
	            	if(!$String.IsNullOrEmpty(errInfo)){
	            		alert("请修改红色错误信息后在提交");
	            		return false;
	            	}
	            	
	            	var rigId = 0;
	            	
	                var rigUrl = $Url.BuildEmployeeUrl("/employee/registration/ajaxEditRegistration");
	                var rigOper = "add";
	            	var rigInfo = {
	                        id: 0,
	                        registrationOrder:$("#registrationOrder").val(),
	                        type:$("#type").val(),
	                        suppliersId:$("#suppliersId").val(),
	                        operator:$("#operator").val(),
	                        registrationDate:$("#registrationDate").val()+" 00:00:00"
	                    }
	            	if($String.IsNullOrEmpty($("#registrationOrder").val()) ||$String.IsNullOrEmpty($("#operator").val()) ||$String.IsNullOrEmpty($("#registrationDate").val())){
	            		alert("请填写完整的采购信息");
	            		return false;
	            	}
	            	
	            	$.ajax({
	                    type: "post",
	                    url: rigUrl,
	                    dataType: "json",
	                    async:false,
	                    timeout: 30000,
	                    data: {
	                        info: JSON.stringify(rigInfo),
	                        oper: rigOper
	                    },
	                    beforeSend: function () {
	//                        $("#submit").attr("process", "processing");
	                    },
	                    error: function (XMLHttpRequest, textStatus, errorThrown) {
	                        alert(errorThrown);
	                        return false;
	                    },
	                    success: function (data, textStatus) {
	                        if (data.errCode == "0000") {
	                        	rigId = data.errDesc;
	                        }
	                    },
	                    complete: function (XMLHttpRequest, textStatus) {
	                    }
	                });
	            	
	            	for (var i = 1; i <=rows.length; i++) {
	            		if(rows[i-1].assetId!="" && rows[i-1].assetId!=null){
	            			
	            			if(!ManagePage.isInt(rows[i-1].count)){
	            				alert("第"+i+"条数量请填写正确的格式");
	            				return false;
	            			}
	            			if(!ManagePage.isDouble(rows[i-1].price)){
	            				alert("第"+i+"条单价请填写正确的格式");
	            				return false;
	            			}
	            			
	    				var info = {
	                            id: 0,
	                            registrationId:rigId,
	            				assetType: rows[i-1].assetType,
	            				assetId: rows[i-1].assetId,
	            				assetName: rows[i-1].assetName,
	            				brand: rows[i-1].brand,
	            				model: rows[i-1].model,
	            				cPU: rows[i-1].CPU,
	            				memory: rows[i-1].memory,
	            				hardDisk: rows[i-1].hardDisk,
	            				count: rows[i-1].count,
	            				price: rows[i-1].price,
	            				money: rows[i-1].count*1*rows[i-1].price*1,
	            				location: rows[i-1].location,
	            				department: rows[i-1].department,
	            				userNo: rows[i-1].userNo,
	            				status: rows[i-1].status,
	            				editComment: rows[i-1].editComment
	                        }
	                        $.ajax({
	                            type: "post",
	                            url: url,
	                            dataType: "json",
	                            timeout: 30000,
	                            async:false,
	                            data: {
	                                oper: oper,
	                                info: JSON.stringify(info)
	                            },
	                            beforeSend: function () {
	                                $("#submit").attr("process", "processing");
	                            },
	                            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                                alert(errorThrown);
	                                return false;
	                            },
	                            success: function (data, textStatus) {
	                            	
	                            },
	                            complete: function (XMLHttpRequest, textStatus) {
	                                $("#submit").removeAttr("process");
	                            }
	                        });
	            		}
	            	}
	            	alert("添加成功");
	            	$tabs = top.jQuery("#center");
	        		$tabs.tabs('close',$tabs.tabs('getSelected').panel('options').title);
	            }
        }
            return false;
        }
    });
    fixedAssetsAddAll.addRule([
    ]);
})
