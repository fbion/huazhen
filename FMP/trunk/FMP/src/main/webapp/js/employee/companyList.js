var ManagePage = {
    
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/company/ajaxListCompany.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/company/ajaxEditCompany.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","编码","名称 ","电话","传真","邮编","网址","邮箱","开户银行地址","开户银行","银行账号","公司地址","公司简介","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 10 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 10 },editrules:{required:true}
				},
				{
					name: "telephone", index: "telephone", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 10 },editrules:{required:false,custom:true, custom_func:ManagePage.Mytelephonecheck}
				},
				{
					name: "fax", index: "fax", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "postcode", index: "postcode", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "website", index: "website", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:false,url:true}
				},
				{
					name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },editrules:{required:false,email:true}
				},
				{
					name: "bankAddress", index: "bankAddress", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "bankName", index: "bankName", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "bankAccount", index: "bankAccount", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 }
				},
				{
					name: "comment", index: "comment", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 10, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 20 },hidden:true,editrules:{edithidden:true}
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
            pager: "#gridPager",
            gridComplete: function () {
                var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";

                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail + space + edit });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byName = $("#txtName").val();


            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { "byName": byName },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
             editCaption: "查看记录",
            beforeShowForm: function () {
                $(".DataTD").children().attr("disabled", "disabled");
                $(".EditButton").html("");
            }, afterShowForm: function () {
            }
        });
    },
    GetEdit: function (index) {
        jQuery("#gridTable").jqGrid('editGridRow', index, {
             reloadAfterSubmit: true, closeAfterEdit: true,
            beforeShowForm: function () {
            	ManagePage.ShowPoint();
            	$("#code").attr("disabled","disabled");
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    GetAdd: function () {
        jQuery("#gridTable").jqGrid('editGridRow', "new", {
             reloadAfterSubmit: true, closeAfterAdd: true, editCaption: "添加记录",
            beforeShowForm: function () {
                $("#tr_id").css("visibility","hidden");
                $("#code").attr("disabled","disabled");
                ManagePage.ShowPoint();
            }, afterShowForm: function () {
            }, afterSubmit: function (response, postdata) {
                var res = jQuery.parseJSON(response.responseText), ok = res.errDesc == "";

                return [ok, ok ? '' : res.errDesc];
            }
        });
    },
    ShowPoint:function(){
    	var empName = $("#name").parent().prev().text();
    	$("#name").parent().prev().html(empName + "<em class='color'>*</em>");
    },
    Mytelephonecheck:function(value, telephone) { 
    	//var reg = /^1\d{10}$/ ;
    	var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的电话格式!"]; 
    }
    
  
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    EnumList.GetEnumListToSelect($("#selectEmployeeCompany"), "empCompanylistAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();

    
    
});