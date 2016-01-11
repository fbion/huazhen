var ManagePage = {
 DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd' }); };
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
            url: $Url.BuildEmployeeUrl('/employee/tempRecruitNeed/ajaxListTempRecruitNeed.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/ajaxEditTempRecruitNeed.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","编制编号","年度","公司名称","审核编号"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "code", index: "code", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "financialYear", index: "financialYear", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					 name: "companyNo", index: "companyNo", width: 40, align: "left", formatter: "select", edittype: "select", editoptions: {size: 1, value: EnumList.GetEnumListToEdit("empCompanylist", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true
			    },
				{
					name: "activitiNo", index: "activitiNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				}              
            ],
            sortname: "id",
            sortorder: "desc",
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
                //var space = "|";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var activitiNos = $("#gridTable").jqGrid('getCol', 'activitiNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";
                    var activitiNo = activitiNos[i].value;
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id +"','" +activitiNo+"')\">查看</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail });
                }
            }
        });
    },
    InitQuery: function () {
    	 $("#btnSearch").click(function () {
        	 var bySelectDepartment = $("#selectDepartment").val();
        	 var byYear = $("#byYear").val();
        	 var byCode = $("#byCode").val();
        	 $("#gridTable").jqGrid('setGridParam', {
                 datatype: "json",
                 postData: { 
                	"byCode":byCode,
                 	"byYear": byYear,
                 	"bySelectDepartment": bySelectDepartment
                 	},
                 page: 1
             }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index,activitiNo) {
        $EasyUI.NewTab("Detail", $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/edit?id="+index+"&activitiNo="+activitiNo));
    },
   
    GetAdd: function () {
        $EasyUI.NewTab("New", $Url.BuildEmployeeUrl("/employee/tempRecruitNeed/edit"));
    }
}


$(function () {
    $("#btnAdd").click(function () { 
    	ManagePage.GetAdd();
    });
    EnumList.GetEnumListToSelect($("#selectDepartment"), "deptAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
	 
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});