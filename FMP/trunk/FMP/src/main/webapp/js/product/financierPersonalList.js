var ManagePage = {
		RequireMoneyTotalFormat: function (cellvalue, options, rowObject) {
	        if (cellvalue == 0){
	            return "";
	        }else{
	        	return cellvalue;
	        }
	    },
	    RequireMoneyTotalUnFormat: function (cellvalue, options, cell) {
	    	if (cellvalue=="") {
	    		return "";
			}else{
				return cellvalue;
			}
	},
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd' }); };//HH:mm:ss
        $(el).addClass("FormElement");
        $(el).addClass("ui-widget-content");
        $(el).addClass("ui-corner-all");
        $(el).css("width", "204px");
        return el;
    },
    DateInputValue: function (elem, operation, value) {
        if (operation === 'get') {
            return $(elem).val();
        } else if (operation === 'set') {
            $(elem).val(value);
        }
    },
    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildProductUrl('/product/financierPersonal/ajaxListFinancierPersonal.action'),
            editurl: $Url.BuildProductUrl("/product/financierPersonal/ajaxEditFinancierPersonal.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","id","委托人编号","委托人","性别","邮箱","微信","QQ","手机1","手机2","固话","住址","年龄","婚姻","公司","融资需求额度","融资需求时间","融资需求描述","负责人","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: false, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },editrules:{required:true}
				},
				{
					name: "sex", index: "sex", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataForEmployeeSex", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 3, colpos: 1 },sortable: false, editable: true,hidden:true,editrules:{edithidden:true}
				},
				{
					name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },editrules:{required:false,email:true}
				},
				{
					name: "weixin", index: "weixin", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "qq", index: "qq", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "cellphone1", index: "cellphone1", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mycellhonecheck}
				},
				{
					name: "cellphone2", index: "cellphone2", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mycellhonecheck}
				},
				{
					name: "telephone", index: "telephone", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true,required:false,number:true,custom:true, custom_func:ManagePage.Mytelehonecheck}
				},
				{
					name: "address", index: "address", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "age", index: "age", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true,required:false,number:true,minValue:0,maxValue:200}
				},
				{
					name: "marry", index: "marry", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataForEmployeeMarry", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 7, colpos: 2 },sortable: false, editable: true,hidden:true,editrules:{edithidden:true}
				},
				{
					name: "company", index: "company", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
				},
				{
					name: "money", index: "money", width: 40, align: "left", formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter: ManagePage.RequireMoneyTotalFormat,unformat: ManagePage.RequireMoneyTotalUnFormat,editrules:{required:false,number:true}
				},
				{
					name: "requiretime", index: "requiretime", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false,formatter:"date",formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 }// H:i:s
				},
				{
					name: "requireComment", index: "requireComment", width: 40, align: "left", formoptions: { rowpos: 9, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },editrules:{required:false}
				},
				{
					name: "managerNo", index: "managerNo", width: 40, align: "left", formatter:$Link.MakeEmployeeUrl, edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildProductUrl("/common/enumList.action"))},formoptions: { rowpos: 12, colpos:1 },sortable: false, editable: true
				},
				{
					name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 12, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },hidden:true,editrules:{edithidden:true}
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
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var detail = "";
                    var edit = "";
                    edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">查看</a>";
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">编辑</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: edit + "|"+detail});
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
    GetAdd:function(){
        window.open($Url.BuildProductUrl("/product/financierPersonal/edit"));
    },
    GetDetail:function(id){
        window.open($Url.BuildProductUrl("/product/financierPersonal/edit?id="+id));
    },
    GetEdit:function(id){
        window.open($Url.BuildProductUrl("/product/financierPersonal/detail?id="+id));
    },
    ShowPoint:function(){
    	var empName = $("#code").parent().next().text();
    	$("#code").parent().next().html(empName + "<em class='color'>*</em>");
    },
    Mytelephonecheck:function(value, telephone) { 
    	//var reg = /^1\d{10}$/ ;
    	var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的电话格式！如：12345678901、1234-12345678-1234"]; 
    },
    Mycellphonecheck:function(value, telephone) { 
    	var reg = /^1\d{10}$/ ;
    	//var reg =  /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    	if (reg.test(value)) 
    		return [true,"OK！"]; 
    	else 
    		return [false,"请输入正确的手机格式！如：12345678901"]; 
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
});