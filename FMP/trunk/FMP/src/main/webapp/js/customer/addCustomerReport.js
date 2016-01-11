/**
 * Created by Administrator on 2015/6/16.
 */
var ManagePage ={
	Resize: function () {
		$("#content_center").css('height',$('.datagrid-view').height()+300);
	},
    formatPrice:function(val,row){
        return new Date(val).format("yyyy-MM-dd hh:mm:ss")
    },
    Test:function(){
        $('#tt').treegrid(
            {
                onLoadSuccess : function(data){
                $('#tt').treegrid("collapseAll");
                ManagePage.Resize();
            }
            });
        $('#tt').treegrid(
            {
                onExpand : function(data){
                    ManagePage.Resize();
                }
            });
        $('#tt').treegrid(
            {
                onCollapse : function(data){
                    ManagePage.Resize();
                }
            }
        );

    }
}

$(function () {
    $("#monthTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM'});
    });
    $("#dayTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#weekTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });

    var url = $Url.BuildCustomerUrl("/customer/ajaxList?showAllList="+ElementVar.showAllList);
    $('#tt').treegrid({
        url:url,
        idField:'id',
        treeField:'elementName',
        columns:[[
            {title:'元素名称',field:'elementName',width:280},
            {field:'addA',title:'新增A类客户',width:100,align:'center'},
            {field:'addB',title:'新增B类客户',width:100,align:'center'},
            {field:'addC',title:'新增C类客户',width:100,align:'center'},
            {field:'addD',title:'新增D类客户',width:100,align:'center'},
            {field:'addTotal',title:'新增客户总数',width:100,align:'center'},
            {field:'total',title:'客户总数',width:100,align:'center'},
            {field:'inTime',title:'统计时间',width:140,align:'center',formatter:ManagePage.formatPrice}
        ]]
    });

    $("#collapse").click(function(){
        $('#tt').treegrid("collapseAll");
		ManagePage.Resize();
    });
    $("#expand").click(function(){
        $('#tt').treegrid("expandAll");
        ManagePage.Resize();
    });
    ManagePage.Test();

    var d = new Date();
    d.setTime(d.getTime()-24*60*60*1000);
    $("#time").text(d.getFullYear()+"-" + (d.getMonth()+1) + "-" + d.getDate());
    $("#dayButton").click(function(){
        var dayTime = $("#dayTime").val();
        var type = 1;
        $("#time").text(dayTime);
        url =  $Url.BuildCustomerUrl("/customer/ajaxList?dayTime="+dayTime+"&type="+type+"&showAllList="+ElementVar.showAllList);
        $('#tt').treegrid({
            url:url,
            idField:'id',
            treeField:'elementName',
            columns:[[
                {title:'元素名称',field:'elementName',width:280},
                {field:'addA',title:'新增A类客户',width:100,align:'center'},
                {field:'addB',title:'新增B类客户',width:100,align:'center'},
                {field:'addC',title:'新增C类客户',width:100,align:'center'},
                {field:'addD',title:'新增D类客户',width:100,align:'center'},
                {field:'addTotal',title:'新增客户总数',width:100,align:'center'},
                {field:'total',title:'客户总数',width:100,align:'center'},
                {field:'inTime',title:'统计时间',width:140,align:'center',formatter:ManagePage.formatPrice}
            ]]
        });
        ManagePage.Test();
    });

    $("#monthButton").click(function(){
        var time = $("#monthTime").val();
        var monthTime = $("#monthTime").val()+"-01";
        var type = 3;
        $("#time").text(time);

        url =  $Url.BuildCustomerUrl("/customer/ajaxList?monthTime="+monthTime+"&type="+type+"&showAllList="+ElementVar.showAllList);

        $('#tt').treegrid({
            url:url,
            idField:'id',
            treeField:'elementName',
            columns:[[
                {title:'元素名称',field:'elementName',width:280},
                {field:'addA',title:'新增A类客户',width:100,align:'center'},
                {field:'addB',title:'新增B类客户',width:100,align:'center'},
                {field:'addC',title:'新增C类客户',width:100,align:'center'},
                {field:'addD',title:'新增D类客户',width:100,align:'center'},
                {field:'addTotal',title:'新增客户总数',width:100,align:'center'},
                {field:'total',title:'客户总数',width:100,align:'center'},
                {field:'inTime',title:'统计时间',width:140,align:'center',formatter:ManagePage.formatPrice}

            ]]
        });
        ManagePage.Test();
    });
    $("#weekButton").click(function(){
        var weekTime = $("#weekTime").val();
        var type = 2;
        url =  $Url.BuildCustomerUrl("/customer/ajaxList?weekTime="+weekTime+"&type="+type+"&showAllList="+ElementVar.showAllList);
        $('#tt').treegrid({
            url:url,
            idField:'id',
            treeField:'elementName',
            columns:[[
                {title:'元素名称',field:'elementName',width:280},
                {field:'addA',title:'新增A类客户',width:100,align:'center'},
                {field:'addB',title:'新增B类客户',width:100,align:'center'},
                {field:'addC',title:'新增C类客户',width:100,align:'center'},
                {field:'addD',title:'新增D类客户',width:100,align:'center'},
                {field:'addTotal',title:'新增客户总数',width:100,align:'center'},
                {field:'total',title:'客户总数',width:100,align:'center'},
                {field:'inTime',title:'统计时间',width:140,align:'center',formatter:ManagePage.formatPrice}
            ]]
        });
        ManagePage.Test();
    });
})
