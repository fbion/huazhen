//var ManagePage = {
//	Resize: function(){
//		$("#content_center").css({"min-height":"803px","height":$(".konwledgeBase").height()+320});
//	},
//    GetDetail: function (index) {
//        window.location.href = $Url.BuildEmployeeUrl("/employee/knowledgeBase/edit?id="+index);
//    },
//    GetAdd: function () {
//        window.location.href = $Url.BuildEmployeeUrl("/employee/knowledgeBase/edit")
//    }
//}
//var BindEnumList={
//	    BindType:function(){
//	        EnumList.GetEnumListToSelect($("#type"),"dicDicDataForKnowledgeAll",$Url.BuildEmployeeUrl("/common/enumList.action"));
//	        var byType = $("#byType").val();
//	    	if(byType!=""){
//	    		$("#type").val(byType);
//	    	}
//	    },
//	    BindAll:function(){
//	        BindEnumList.BindType();
//	    }
//	}
//var select={
//		InitQuery:function(){
//			var byType = $("#type").val();
//		   	var key = $("#key").val();
//		   	window.location.href=$("#pageUrl").val()+"byType="+byType+"&key="+key;
//		}
//}
//var KnowledgeList = {
//	GetKnowledgeList: function (pageIndex) {
//		var byType = $("#type").val();
//	   	var key = $("#key").val();
//	   	if(byType!=null||key!=null){
//	   		window.location.href=$("#pageUrl").val()+"pageIndex="+(pageIndex+1)+"&byType="+byType+"&key="+key;
//	   	}else{
//	   		window.location.href=$("#pageUrl").val()+"pageIndex="+(pageIndex+1);
//	   	}
//		KnowledgeList.Paging();
//    },
//    Paging:function (pageIndex){
//        if($("#totalCount").html()!=0){
//    		$("#pagination").pagination($("#totalCount").html(), {//总记录条数
//    			callback: KnowledgeList.GetKnowledgeList,//每次点击分页按钮的时候 执行该操作
//    			items_per_page:4,//每页显示多少条记录
//    			current_page:pageIndex-1,//当前页
//    			link_to:"javascript:void(0)",//不期望链接到某个目的地，只希望执行回调函数
//    			num_display_entries:3,//显示几个页码
//    			next_text:"下一页",//下一页按钮显示的内容
//    			next_show_always:true,//如果没有下一页  仍然显示按钮  但是灰化
//    			prev_text:"上一页",//上一页按钮显示的内容
//    			prev_show_always:true,//如果没有上一页  不显示按钮
//    			num_edge_entries:1,//页码多的时候...省略
//    			ellipse_text:"..."
//    		});
//    	}
//    }
//
//}
//$(function () {
//	ManagePage.Resize();
//	BindEnumList.BindAll();
//	$("#btnSearch").click(function(){
//		select.InitQuery();
//		});
//	$("#btnAdd").click(function () { ManagePage.GetAdd(); });
//	KnowledgeList.Paging(parseInt($("#pageIndex").val()));
//
// });
var ManagePage = {

    InitGrid: function () {
        //grid start
        $("#gridTable").jqGrid({
            url: $Url.BuildEmployeeUrl('/employee/knowledgeBase/ajaxListKnowledgeBase.action'),
            editurl: $Url.BuildEmployeeUrl("/employee/knowledgeBase/ajaxEditKnowledgeBase.action"),
            datatype: "json",
            mtype: 'GET',
            colNames: ["操作","编号","类型","标题","发布者","发布时间"],
            colModel: [

                {
                    name: "act", index: "act", width: 40, align: "center", sortable: false
                },
                {
                    name: "id", index: "id", width: 20, align: "center", sorttype: "number", formoptions: { rowpos: 1, colpos: 1 }, editable: true, editoptions: { readonly: true, size: 40 }
                },
                {
                    name: "type", index: "type", width: 20, align: "left", formoptions: { rowpos: 2, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("dicDicDataForKnowledge", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
//                {
//                    name: "tag", index: "tag", width: 40, align: "left", formoptions: { rowpos: 2, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
//                },
                {
                    name: "title", index: "title", width: 80, align: "left", formoptions: { rowpos: 3, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
                },
//                {
//                    name: "content", index: "content", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }
//                },
//                {
//                    name: "editComment", index: "editComment", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }
//                },

                {
                    name: "inUserNo", index: "inUserNo", width: 40, align: "left", formoptions: { rowpos: 3, colpos: 2 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "select", edittype: "select", editoptions: { size: 1, value: EnumList.GetEnumListToEdit("empList", $Url.BuildEmployeeUrl("/common/enumList.action"))}
                },
                {
                    name: "inTime", index: "inTime", width: 40, align: "left", formoptions: { rowpos: 6, colpos: 1 }, sortable: false, editable: true, editoptions: { size: 40 }, formatter: "date", formatoptions: { srcformat: 'Y-m-d', newformat: 'Y-m-d' }
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
                var space = "";
                var ids = $("#gridTable").jqGrid('getCol', 'id', true);
                var inUserNos = $("#gridTable").jqGrid('getCol', 'inUserNo', true);
                for (var i = 0; i < ids.length; i++) {
                    var id = ids[i].id;

                    var detail = "";
                    var edit = "";
                    if(inUserNos[i].value==$("#userId").val()){
                    	space = "|";
                    	detail = "<a class=\"blue\" href=\"javascript:ManagePage.GetDetail('" + id + "')\">编辑</a>";
                    }else{
                    	space = "";
                    	detail = "";
                    }
                	edit = "<a class=\"blue\" href=\"javascript:ManagePage.GetEdit('" + id + "')\">查看</a>";
                    $("#gridTable").jqGrid("setRowData", id, { act: detail+space+edit });
                }
            }
        });
    },
    InitQuery: function () {
        $("#btnSearch").click(function () {
            var byType = $("#byType").val();
            var byTitle = $("#byTitle").val();

            $("#gridTable").jqGrid('setGridParam', {
                datatype: "json",
                postData: {
                    "byType": byType,
                    "byTitle":byTitle
                },
                page: 1
            }).trigger("reloadGrid");
        });
    },
    GetDetail: function (index) {
        $EasyUI.NewTab("Detail",$Url.BuildEmployeeUrl("/employee/knowledgeBase/edit?id="+index));
    },
    GetEdit: function (index) {
        $EasyUI.NewTab("Edit",$Url.BuildEmployeeUrl("/employee/knowledgeBase/info?id="+index));
    },
    GetAdd: function () {
        $EasyUI.NewTab("New",$Url.BuildEmployeeUrl("/employee/knowledgeBase/edit"));
    }
}


$(function () {
    $("#btnAdd").click(function () { ManagePage.GetAdd(); });
    EnumList.GetEnumListToSelect($("#byType"),"dicDicDataForKnowledgeAll",$Url.BuildEmployeeUrl("/common/enumList.action"));
    ManagePage.InitGrid();
    ManagePage.InitQuery();
});