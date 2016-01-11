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
    $("#startTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    $("#endTime").click(function () {
        WdatePicker({dateFmt: 'yyyy-MM-dd'});
    });
    EnumList.GetEnumListToSelect($("#status"), "salesStatusAll", $Url.BuildSalesUrl("/common/enumList.action"));
//    $("#time").val("昨日");
    var url = $Url.BuildSalesUrl("/sales/report/ajaxList?showAllList="+ElementVar.showAllList+"&showDirectList="+ElementVar.showDirectList+"&showShopList="+ElementVar.showShopList);
    $('#tt').treegrid({
        url:url,
        idField:'id',
        treeField:'elementName',
        columns:[[
            {title:'元素名称',field:'elementName',width:280},
            {field:'p2pSalesMoney',title:'新增现房宝打款金额',width:140,align:'center'},
            {field:'otherSalesMoney',title:'新增普通产品打款金额',width:140,align:'center'},
            {field:'addTotalMoney',title:'新增总打款金额',width:140,align:'center'},
        ]]
    });
    ManagePage.Test();
    $("#btnSearch").click(function(){
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var status = $("#status").val();
        var url = $Url.BuildSalesUrl("/sales/report/ajaxList?showAllList="+ElementVar.showAllList+"&startTime="+startTime+"&endTime="+endTime+"&showDirectList="+ElementVar.showDirectList+"&showShopList="+ElementVar.showShopList+"&status="+status);
        $('#tt').treegrid({
            url:url,
            idField:'id',
            treeField:'elementName',
            columns:[[
                {title:'元素名称',field:'elementName',width:280},
                {field:'p2pSalesMoney',title:'新增现房宝打款金额',width:140,align:'center'},
                {field:'otherSalesMoney',title:'新增普通产品打款金额',width:140,align:'center'},
                {field:'addTotalMoney',title:'新增总打款金额',width:140,align:'center'},
            ]]
        });
        ManagePage.Test();
    });
    $("#collapse").click(function(){
        $('#tt').treegrid("collapseAll");
        ManagePage.Resize();
    });
    $("#expand").click(function(){
        $('#tt').treegrid("expandAll");
        ManagePage.Resize();
    });
})
