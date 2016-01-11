var ManagePage = {
    DateInputElem: function (value, options) {
        var el = document.createElement("input");
        el.type = "text";
        el.value = value;
        el.onclick = function () { el.focus(); el.select(); WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' }); };
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
            url: $Url.BuildEmployeeUrl('/employee/recruitAskRecord/ajaxListRecruitAskRecord.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/recruitAskRecord/ajaxEditRecruitAskRecord.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","序号","姓名","简历来源","简历附件","首次联系时间","现公司（行业）和职位","应聘职位","移动电话","邮箱地址","邀约初试时间","面试与否","复试时间","是否录用","首次联系情况","回访记录","负责人","后续联系记录","修改备注"],
            colModel: [

				{
					name: "act", index: "act", width: 60, align: "center", sortable: false
				},
				{
					name: "id", index: "id", width: 20, align: "center", sorttype: "number",hidden:true, formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
				},
				{
					name: "name", index: "name", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "resumeSource", index: "resumeSource", width: 40, align: "center", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 20 }, editrules: {edithidden: true, required: true}, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("resumeSource", $Url.BuildEmployeeUrl("/common/enumList.action"))}
				},
				{
					name: "resumeAttachment", index: "resumeAttachment", width: 40, align: "center", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "firstContactTime", index: "firstContactTime", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "workCondition", index: "workCondition", width: 40, align: "left", formoptions: { rowpos: 4, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "positionNo", index: "positionNo", width: 40, align: "left", formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("positionList", $Url.BuildEmployeeUrl("/common/enumList.action"))}, formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true
				},
				{
					name: "cellphone", index: "cellphone", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "email", index: "email", width: 40, align: "left", formoptions: { rowpos: 5, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "firstTime", index: "firstTime", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "isInterview", index: "isInterview", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.FmatterIsOrNo
				},
				{
					name: "secondTime", index: "secondTime", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 1 }, sortable: false, formatoptions: { srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s' }, editable: true, edittype: 'custom', editoptions: { custom_element: ManagePage.DateInputElem, custom_value: ManagePage.DateInputValue, size: 40 },formatter:ManagePage.ToDDMMMYYYY
				},
				{
					name: "isEmploy", index: "isEmploy", width: 40, align: "left", formoptions: { rowpos: 7, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 },formatter:ManagePage.FmatterIsOrNo
				},
				{
					name: "firstContactSituation", index: "firstContactSituation",hidden:true, width: 40, align: "left", formoptions: { rowpos: 8, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "visitRecord", index: "visitRecord", width: 40, align: "left",hidden:true, formoptions: { rowpos: 8, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
                {
                    name: "inUserNo", index: "inUserNo", width: 40, align: "left", formoptions: { rowpos: 11, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter:"select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
					name: "laterContactRecord", index: "laterContactRecord",hidden:true, width: 40, align: "left", formoptions: { rowpos: 9, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
				},
				{
					name: "editComment", index: "editComment",hidden:true, width: 40, align: "left", formoptions: { rowpos: 11, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
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
            postData: {showAllList:ElementVar.showAllList},
            gridComplete: function () {
                var space = " | ";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var resumeAttachments = $("#gridTable").jqGrid('getCol', 'resumeAttachment', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;
                    var resumeAttachment = resumeAttachments[i].value;

                    var detail = "";
                    var edit = "";
                    var download = "";
                    //var preview = "";
                    var loadStr ="下载";
                    if(resumeAttachment =="" ||resumeAttachment==null){
                    	loadStr ="还没有上传";
                    }else{
                    	resumeAttachment = $Url.BuildFileUrl(resumeAttachment);
                    }
                    
                    detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">查看</a>";
                    sms = "<a class=\"blue\" href=\"javascript:ManagePage.Sms('" + id + "')\">面试邀请（短信）</a>";
                    //edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">编辑</a>";
                    download = "<a class='blue' href='"+resumeAttachment+"'>"+loadStr+"</a>";
                    //preview = "<a class=\"blue\" href=\"javascript:ManagePage.Preview('" + id + "')\">预览</a>";

                    $("#gridTable").jqGrid("setRowData", id, { act: detail+space+sms });
                    $("#gridTable").jqGrid("setRowData", id, { resumeAttachment: download });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
        	var byName = $("#txtName").val().trim();
            var bySelectPositionNo = $("#selectPositionNo").val();
            var byIsInterview = $("#isInterview").val();
            var byIsEmploy = $("#isEmploy").val();
            var byYear = $("#year").val();
            var byMonth = $("#month").val();
            var byInUserNo = $("#byInUserNo").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: { 
                	"byName": byName,
                	"bySelectPositionNo": bySelectPositionNo,
                	"byIsInterview": byIsInterview,
                	"byIsEmploy": byIsEmploy,
                	"byYear":byYear,
                	"byMonth":byMonth,
                    "byInUserNo":byInUserNo,
                	"showAllList":ElementVar.showAllList
                	},
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
       window.open($Url.BuildEmployeeUrl("/employee/recruitAskRecord/edit?id="+index));
    },
    Sms: function (index) {
        $('#w').window('open');
        $("#ok").click(function(){
            var invitationTime = $("#invitationTime").val();
//            var month = $("#byMonth").val();
//            var day = $("#byDay").val();
            var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecord/ajaxSms");
            $.ajax({
                type: "post",
                url: url,
                dataType: "json",
                timeout: 30000,
                data: {
                    id:index,
                    invitationTime:invitationTime
//                    month:month,
//                    day:day
                },
                beforeSend: function () {
                    $("#submit").attr("process", "processing");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                },
                success: function (data, textStatus) {
                    $('#w').window('close');
                    alert("发送成功");
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#submit").removeAttr("process");
                }
            });
        });

    },
    GetAdd: function () {
        window.open($Url.BuildEmployeeUrl("/employee/recruitAskRecord/edit"));
    },
    ToDDMMMYYYY:function(date, options, rowObject) {
    	if(date!=null){
    		var d = new Date(date);  
    		var dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate().toString(); 
    		var mm = d.getMonth()+1< 10 ? "0" + (d.getMonth()+1):(d.getMonth()+1).toString();  
    		var yyyy = d.getFullYear().toString();  
    		return yyyy +"-"+ mm+"-"+dd;  
    	}
    	return "";
    },
    GetDate:function(strat,end,obj){
    	var op = $("<option></option>").text("全部").val(0);
    	obj.append(op);
    	for (var i=strat;i<=end;i++){
    		var op = $("<option></option>").text(i).val(i);
    		obj.append(op);
    	}
    },
    FmatterIsOrNo:function(cellvalue, options, rowObject){
    	if(cellvalue==0){
    		return "否";
    	}else if(cellvalue==1){
    		return "是";
    	}
    }
}


$(function () {
    EmployeeTreeControl.startTree({
        param: "on",  //on在职员工，out离职员工，test测试员工
        treeInputId: "employeeSel",//员工控件框ID
        valInputId: "byInUserNo", //员工值框id
        inputType: "employee",//employee员工，position职位
        idType: "userNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
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
    $("#invitationTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:00'});
    });
    ManagePage.GetDate(2014,2020,$("#byYear"));
    ManagePage.GetDate(1,12,$("#byMonth"));
    ManagePage.GetDate(1,31,$("#byDay"));

    $("#btnAdd").click(function () { ManagePage.GetAdd(); });

    ManagePage.InitGrid();
    ManagePage.InitQuery();
    ManagePage.GetDate(2014,new Date().getUTCFullYear(),$("#year"));
    $("#year").off().change(function(){
    	if($("#year").val()!='0'){
    		$("#showMonth").show();
    		$("#month").html("");
    		ManagePage.GetDate(1,12,$("#month"));
    	}else{
    		$("#showMonth").hide();
    		$("#month").html("");
    	}
    	
    });
    
    EnumList.GetEnumListToSelect($("#selectPositionNo"), "positionListAll", $Url.BuildEmployeeUrl("/common/enumList.action"));
    $("#btnExcel").off().click(function () {
    	var byName = $("#txtName").val().trim();
        var bySelectPositionNo = $("#selectPositionNo").val();
        var byIsInterview = $("#isInterview").val();
        var byIsEmploy = $("#isEmploy").val();
        var byYear = $("#year").val();
        var byMonth = $("#month").val();
        var url = $Url.BuildEmployeeUrl("/employee/recruitAskRecord/ajaxExportExcel");
        location.href= url+"?"+
		"showAllList="+ElementVar.showAllList+"&"+
		"sord=desc"+"&"+
		"sidx=id"+"&"+
		"byName="+ byName+"&"+
        "bySelectPositionNo="+ bySelectPositionNo+"&"+
        "byIsInterview="+ byIsInterview+"&"+
        "byIsEmploy="+ byIsEmploy+"&"+
		"byYear="+byYear+"&"+
		"byMonth="+byMonth;
    });
});
