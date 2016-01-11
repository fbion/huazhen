var ManagePage = {
	BindEmpNo : function() {								
		$("#selectEmpNo").html("");
		$("#selectEmpNo").linkageForJqGrid({
			prev : $("#selectDepartment"),
			dataType : "empManagerListByDept",
			actionUrl : $Url.BuildCustomerUrl("/common/enumList.action"),
			all : false
		});
	},
	InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildCustomerUrl('/customer/customerCompany/ajaxListCustomerCompany.action'),
            editurl: $Url.BuildCustomerUrl("/customer/customerCompany/ajaxEditCustomerCompany.action"),
            datatype: "json",
            mtype: 'GET',				
            colNames: ["操作","编号","编码","组织机构代码","营业执照","税务证","企业名称","企业地址","企业电话","企业邮箱","所属行业","联系人","联系人固话","联系人手机1","联系人手机2","关系等级","风险偏好","负责人","可配置资产","累计购买额","备注","新增时间","p2p客户id","法人姓名","法人身份证","企业类型","开户银行许可证"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 1, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "cardNumber", index: "cardNumber", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true,custom_func:ManagePage.MyCardCheck}
				},
				{
					name: "cardLicense", index: "cardLicense", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true,custom_func:ManagePage.MyCardCheck}
				},
				{
					name: "cardTax", index: "cardTax", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true,custom_func:ManagePage.MyCardCheck}
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:true}
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "telephone", index: "telephone", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:false,editrules:{edithidden:true,required:false,custom:true,custom_func:ManagePage.Mytelephonecheck}
				},
				{
					name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,email:true}
				},
				{
					name: "field", index: "field", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:false,editrules:{edithidden:true}
				},
				{
					name: "contactName", index: "contactName", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "contactTelephone", index: "contactTelephone", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,custom:true,custom_func:ManagePage.MycontactTelephonecheck}
				},
				{
					name: "contactCellphone1", index: "contactCellphone1", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,custom:true,custom_func:ManagePage.Mycellphone1check}				
				},
				{
					name: "contactCellphone2", index: "contactCellphone2", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true,required:false,custom:true,custom_func:ManagePage.Mycellphone2check}
				},
				{
					name: "relationLevel", index: "relationLevel", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyRelationLevel", $Url.BuildCustomerUrl("/common/enumList.action"))},formoptions: { rowpos: 6, colpos: 1 },sortable: false, editable: true
				},
				{
					name: "riskHobby", index: "riskHobby", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDataforCustomerCompanyRiskHobby", $Url.BuildCustomerUrl("/common/enumList.action"))},formoptions: { rowpos: 6, colpos: 2 },sortable: false, editable: true
				},
				{
					name: "agentNo", index: "agentNo", width: 40, align: "left", formatter:$Link.MakeEmployeeUrl, edittype: "select",editoptions: {size: 1,value: EnumList.GetEnumListToEdit("empList", $Url.BuildCustomerUrl("/common/enumList.action"))}, formoptions: { rowpos: 6, colpos: 3 }, sortable: false, editable: true
				},
				{
					name: "wealth", index: "wealth", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "tradeTotal", index: "tradeTotal", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 3 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
                {
                    name: "findTime", index: "findTime", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' },hidden:false,editrules:{edithidden:true}
                },
				{
					name: "customerNo", index: "customerNo",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:true}
				},
				{
					name: "legal", index: "legal",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:true}
				},
				{
					name: "legalIdcard", index: "legalIdcard",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:true}
				},
				{
					name: "memberClassType", index: "memberClassType",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:true}
				},
				{
					name: "bankLicense", index: "bankLicense",hidden:true, width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{edithidden:true,required:true}
				}
            ],
            sortname: "id",
            sortorder: "desc",
            pager: "#gridPager",
            viewrecords: true,
            rowNum: 10,
            rowList: [10],
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
            postData:{
                showAllList:ElementVar.showAllList
            },
            pager: "#gridPager",
            gridComplete: function () {
                
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var customerNos = $("#gridTable").jqGrid('getCol', 'customerNo', true);
                for (var i = 0; i < ids.length; i++) {
                	var space = "";
                    var id = ids[i].id;
                    var customerNo = customerNos[i].value;
                    var detail = "";
                    var edit = "";
                    var boundP2pCustomer = "";
                    var detail = "";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    editAdd = "<a class=\"blue\" href=\"javascript:ManagePage.GetEditAdd('" + id + "')\">编辑</a>";
                    if(customerNo==0||customerNo==""){
                    	space = " | ";
                    	boundP2pCustomer = "<a class=\"blue\" href=\"javascript:ManagePage.DoundP2pCustomer('" + id + "')\">绑定p2p客户</a>";
                    }
                    $("#gridTable").jqGrid("setRowData", id, { act:  detail +space+editAdd+space +boundP2pCustomer}); 
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();
            var byEmpNo = $("#selectEmpNo").val();
            var byRelationLevel = $("#selectRelationLevel").val();
            var byRiskHobby = $("#selectRiskHobby").val();
            var byCardType = $("#selectCardType").val();
            var byFindTimeUp = $("#findTimeUp").val();
			var byFindTimeDown = $("#findTimeDown").val();
            
            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                    "byEmpNo":byEmpNo,
                	"byRelationLevel": byRelationLevel,
                	"byRiskHobby": byRiskHobby,
                	"byCardType": byCardType,
                	"byFindTimeUp":byFindTimeUp,
					"byFindTimeDown":byFindTimeDown
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
    	$EasyUI.NewTab("Detail", $Url.BuildCustomerUrl("/customer/customerCompany/detail?id="+index));
    },
    GetEditAdd:function (id) {
    	$EasyUI.NewTab("Edit", $Url.BuildCustomerUrl("/customer/customerCompany/edit?id=")+id);
    },
    GetAddAdd:function () {
    	$EasyUI.NewTab("New", $Url.BuildCustomerUrl("/customer/customerCompany/edit"));
    },
    DoundP2pCustomer:function (id) {
    	var inputUserName = prompt('请为该企业用户设定p2p用户名：');
    	if(inputUserName!=null&&inputUserName!=""){
    		var reg = /^[a-zA-Z0-9]{4,20}$/;
            if (!reg.test(inputUserName)) {
                alert("p2p用户名为4~20位字符，支持数字、字母，不能有特殊字符、下划线");//false;
                return;
            }

            var url1 = $Url.BuildCustomerUrl("/customer/p2pCustomer/ajaxCheckUserExist");//请求到 验证用户存在的action的方法上
            var flag = true;
            $.ajax({
                type: "get",
                url: url1,
                dataType: "json",
                async: false,
                data: { userName: $String.Trim(inputUserName) },
                success: function (data) {
                    if (data.errCode!= "0000"){
                    	alert(data.errDesc);
                    	flag = false;
                    }
                }
            });
            if(!flag){return;}
    		if(confirm("确定要绑定p2p客户？")){
    			var url = $Url.BuildCustomerUrl("/customer/customerCompany/ajaxDoundP2pCustomer");
    			$.ajax({
    				type: "POST",
    				url: url,
    				async:false,
    				data: {
    					id:id,
    					inputUserName:$String.Trim(inputUserName)
    				},
    				error: function(XMLHttpRequest, textStatus, errorThrown) {
    					alert(XMLHttpRequest.status);
    					alert(XMLHttpRequest.readyState);
    					alert(textStatus);
    				},
    				success: function (data) {
    					if(data.errCode=="OK"){
    						if(data.paymentData.url==undefined){
    							alert("绑定失败！");
    							return;
    						}
    						//alert(data.errDesc);
    						var	paymentObj = "<form class=\"pay_data\" action="+data.paymentData.url+" method=\"post\"></form>";
    		                $("body").first().append(paymentObj);
    		                var input = "<input name=\"sign\" value=\"" + data.paymentData.sign+ "\"  type=\"text\" />" +
    		                    "<textarea name=\"req\" >"+data.paymentData.xml+"</textarea>"
    		                $(".pay_data").html(input);
    		                $(".pay_data").submit();
    						var ids = $("#gridTable").jqGrid('getCol', 'id', true);
    						for (var i = 0; i < ids.length; i++) {
    							var gid = ids[i].id;
    							if(id==gid){
    								var editAdd = "";
    								editAdd = "<a class=\"blue\" href=\"javascript:ManagePage.GetEditAdd('" + gid + "')\">查看</a>";
    								$("#gridTable").jqGrid("setRowData", gid, { act:  editAdd}); 
    							}
    						}
    					}else{
    						alert(data.errDesc);
    						////
    					}
    				}
    			});
    		}
    	}else{
    		alert("设定p2p用户名后才能进行绑定！");
    	}
    },
    //2015 2 14  by Tony
    MyCardCheck:function(value,cardNumber){
		var url = $Url.BuildCustomerUrl("/customer/customerCompany/cardCheck.action");
		var cusId = $("#id").val();
        $.ajax({
                type: "POST",
                url: url,
                async:false,
                data: {
                    cardNumber: value,
                    id:cusId
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.status);
                        alert(XMLHttpRequest.readyState);
                        alert(textStatus);
                    },
                success: function (data) {
                	out_data = data;
                }
            }
        );
        	if(out_data.errCode=="failed"){
				return [false,"组织机构代码重复录入,请从新输入！"];
			}
			else if(out_data.errCode=="ok"){
				return [true,"OK！"]; 
			}
			else{
				return [true,"OK！"];
			}
        
    },
    GetAgentFollow : function(index) {
		$('#agentFollow').window('open');
		$("#agentId").val(index);
		$(".window").css("z-index", "940");
		$(".window-shadow").css("z-index", "900");
		ManageFollow.InitGrid();
		var h = $("div[class='panel-body panel-body-noheader layout-body']").css("height", "auto");
		$("#btnAddFollow").click(function() { ManageFollow.GetAdd(); });
	}
}

$(function () {
    $("#btnAdd").click(function () { 
    	ManagePage.GetAddAdd();
    });
    
    EnumList.GetEnumListToSelect($("#selectRelationLevel"), "dicDataforCustomerCompanyRelationLevelAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectRiskHobby"), "dicDataforCustomerCompanyRiskHobbyAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectCardType"), "cusCompanyCardTypeAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    EnumList.GetEnumListToSelect($("#selectDepartment"),"deptForCustomerAll", $Url.BuildCustomerUrl("/common/enumList.action"));
    $("#findTimeUp").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    $("#findTimeDown").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'});
    });
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "departmentSel",//员工控件框ID
        valInputId: "selectDepartment", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "deptNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
        chkStyle: "radio",//选框类型checkbox,radio
        nochecks:[true,false],      //逐级不显示单或复选框,true不显示，false显示
        chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
        showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
        //showSearch: true,   //显示搜索框
        showLevel:2,         //显示层级
        sizeAuto:true,		//自动调节大小
        width:200,			//宽，单位px
        height:300			//高，单位px
    });
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "selectEmpNo", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "empNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
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
//    ManagePage.BindEmpNo();
    ManagePage.InitGrid();
    ManagePage.InitQuery();
    
    
    
    $("#btnExcel").click(function () {
    	var byName = $("#txtName").val();
        var byEmpNo = $("#selectEmpNo").val();
        var byRelationLevel = $("#selectRelationLevel").val();
        var byRiskHobby = $("#selectRiskHobby").val();
        var byFindTimeUp = $("#findTimeUp").val();
		var byFindTimeDown = $("#findTimeDown").val();
    	
        var url = $Url.BuildCustomerUrl("/customer/customerCompany/ajaxExportExcel");
    	location.href= url+"?"+
    		"showAllList="+ElementVar.showAllList+"&"+
    		"sord=desc"+"&"+
    		"sidx=id"+"&"+
    		"byName="+ byName+"&"+
            "byEmpNo="+byEmpNo+"&"+
            "byRelationLevel="+ byRelationLevel+"&"+
    		"byRiskHobby="+byRiskHobby+"&"+
    		"byFindTimeUp="+byFindTimeUp+"&"+
    		"byFindTimeDown="+byFindTimeDown;
    });
});