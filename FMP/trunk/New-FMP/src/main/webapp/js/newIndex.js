/**
 * Created by 磊 on 2015/11/11.
 */
var ProductModel = {
    Product: function (jQuery, type) {
        jQuery.datagrid({
            url: $Url.BuildNewIndexUrl('/product/product/easyUIProductList'),
            method: 'post',
            fit: true,
            fitColumns: true,
            singleSelect: true,
            loadMsg: "正在加载，请稍等...",
            pagination: true,
            queryParams: {
                type: type,
                status: 30,
            },
            columns: [[
                {field: 'id', title: 'ID', align: 'left',halign: 'center',width:'5%'},
                {field: 'type', title: '产品类型', align: 'left', halign: 'center',width:'5%', formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "productType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                {field: 'name', title: '产品名称', align: 'left', halign: 'center',width:'15%', formatter: function (value, row) {
                    var url = $Url.BuildNewIndexUrl("/product/product/detail?id=") + row.id;
                    return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                    }
                },
                {field: 'sumMoney', title: '募集规模(元)', align: 'left',halign: 'center',width:'9%'},
                {field: 'remainAmount', title: '剩余额度(元)', align: 'left',halign: 'center',width:'9%'},
                {field: 'remainSmall', title: '剩余小额', align: 'left',halign: 'center',width:'8%'},
                {field: 'payType', title: '付息方式', align: 'left', halign: 'center',width:'5%', formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "payType", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                {field: 'deadLine', title: '存续期（月）', align: 'left',halign: 'center',width:'7%'},
                {field: 'issuerNo', title: '发行机构', align: 'left', halign: 'center',width:'15%', formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "issuerNo", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                {field: 'status', title: '状态', align: 'left', halign: 'center',width:'6%', formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "productStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                },
                {field: 'empNo', title: '产品经理', align: 'left', halign: 'center',width:'8%', formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "empList", $Url.BuildNewIndexUrl("/common/enumList.action"));
                    }
                }
            ]]
        });
        var page = jQuery.datagrid("getPager");
        if (page) {
            page.pagination({
                pageSize: 10,//每页显示的记录条数，默认为10
                pageList: [5, 10, 15],//可以设置每页记录条数的列表
                beforePageText: "第",//页数文本框前显示的汉字
                afterPageText: "页    共 {pages} 页",
                displayMsg: "当前显示 {from} - {to} 条记录   共 {total} 条记录"
            });
        }
    },
    P2p: function (jQuery, type) {
        jQuery.datagrid({
            url: $Url.BuildNewIndexUrl('/product/p2pProduct/easyUIP2pProductList'),
            method: 'post',
            fit: true,
            fitColumns: true,
            singleSelect: true,
            loadMsg: "正在加载，请稍等...",
            pagination: true,
            queryParams: {
                status: 30,
            },
            columns: [[
                {field: 'id', title: 'ID', align: 'left', halign: 'center',width:'5%'},
                {
                    field: 'name', title: '产品名称', align: 'left', halign: 'center',width:'15%', formatter: function (value, row) {
                    var url = $Url.BuildNewIndexUrl("/product/p2pProduct/detail?id=") + row.id;
                    return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                }
                },
                {field: 'income', title: '收益(%)', align: 'left', halign: 'center',width:'5%'},
                {field: 'duration', title: '项目期限(天)', align: 'left', halign: 'center',width:'8%'},
                {field: 'editComment', title: '剩余天数', align: 'left', halign: 'center',width:'5%'},
                {
                    field: 'repaymentIssue', title: '还款周期', align: 'left', halign: 'center',width:'7%', formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "p2pProductRepayIssue", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
                },
                {field: 'totalAmout', title: '总额度', align: 'left', halign: 'center',width:'8%'},
                {field: 'progress', title: '进度(%)', align: 'left', halign: 'center',width:'5%'},
                {field: 'remainAmout', title: '剩余额度', align: 'left', halign: 'center',width:'7%'},
                {field: 'orderCount', title: '打款个数', align: 'left', halign: 'center',width:'5%'},
                {
                    field: 'status', title: '状态', align: 'left', halign: 'center',width:'5%', formatter: function (value) {
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "productStatus", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }
                },
                {
                    field: 'start', title: '成立日期', align: 'left', halign: 'center',width:'8%', formatter: function (value) {
                    return new Date(value).format("yyyy-MM-dd");
                }
                },
                {
                    field: 'end', title: '债权到期日', align: 'left', halign: 'center',width:'8%', formatter: function (value) {
                    return new Date(value).format("yyyy-MM-dd");
                }
                }
            ]]
        });
        var page = jQuery.datagrid("getPager");
        if (page) {
            page.pagination({
                pageSize: 10,//每页显示的记录条数，默认为10
                pageList: [5, 10, 15],//可以设置每页记录条数的列表
                beforePageText: "第",//页数文本框前显示的汉字
                afterPageText: "页    共 {pages} 页",
                displayMsg: "当前显示 {from} - {to} 条记录   共 {total} 条记录"
            });
        }
    }
}
var KnowledgeBaseModel = {
    KnowledgeBase: function (jQuery, type) {
        jQuery.datagrid({
            url: $Url.BuildNewIndexUrl('/employee/knowledgeBase/easyUIKnowledgeBaseList'),
            method: 'post',
            fit: true,
            fitColumns: true,
            singleSelect: true,
            loadMsg: "正在加载，请稍等...",
            pagination: false,
            showHeader: false,
            queryParams: {
                type: type,
                pageSize: 6,
                page: 1
            },
            columns: [[
                {field: 'title', title: '标题', align: 'left', halign: 'center',width:'50%',formatter:function(value,row){
                    var url = $Url.BuildNewIndexUrl("/employee/knowledgeBase/info?id=") + row.id;
                    return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                }},
                {field: 'inUserNo', title: '发布人', align: 'left', halign: 'center',width:'20%',formatter:function(value){
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "empList", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }},
                {
                    field: 'inTime', title: '发布时间', align: 'left', halign: 'center',width:'30%', formatter: function (value) {
                    return new Date(value).format("yyyy-MM-dd");
                }
                }
            ]]
        });
    }
}
var ActivityModel = {
    Activity: function (jQuery) {
        jQuery.datagrid({
            url: $Url.BuildNewIndexUrl('/sales/activity/easyUIActivityList'),
            method: 'post',
            fit: true,
            fitColumns: true,
            singleSelect: true,
            loadMsg: "正在加载，请稍等...",
            pagination: false,
            showHeader: false,
            queryParams: {
                pageSize: 6,
                page: 1
            },
            columns: [[
                {field: 'title', title: '活动名称', align: 'left', halign: 'center',width:'50%',formatter:function(value,row){
                    var url = $Url.BuildNewIndexUrl("/sales/activity/edit?id=") + row.id;
                    return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                }},
                {field: 'inUserNo', title: '发布人', align: 'left', halign: 'center',width:'20%',formatter:function(value){
                    return EnumListWithEasyUI.GetEnumListToGrid(value, "empList", $Url.BuildNewIndexUrl("/common/enumList.action"));
                }},
                {
                    field: 'activityTime', title: '发布时间', align: 'left', halign: 'center',width:'30%', formatter: function (value) {
                    return new Date(value).format("yyyy-MM-dd");
                }
                }
            ]]
        });
    }
}
var Echarts = {
    EconfigSales: function (url, ele) {
        var sumMoney;
        var xDate;
        $.ajaxSettings.async = false;
        $.getJSON(url,{showAllList:ElementVar.showAllList}, function (data) {
            sumMoney = data.sumMoney;
            xDate = data.xDate;
        });
        var echartsPath = $Url.BuildImgUrl("../js/echarts/dist")
        require.config({
            paths: {echarts: echartsPath}
        });
        require(
            [
                "echarts",
                "echarts/chart/line",
                "echarts/chart/bar"
            ],
            function (ec) {
                var myChart = ec.init(document.getElementById(ele));
                option = {
                    title: {
                        text: '本周打款量',
                        //subtext: '单位：元'
						x:'center',
                        y:'bottom'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    toolbox: {
                        show: true,
						x:'center',
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            magicType: {show: true, type: ['line', 'bar']},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    xAxis: [
                        {
                            type: 'category',
                            data: xDate
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name: '打款量',
                            type: 'bar',
                            data: sumMoney
                        }
                    ]
                };
                myChart.setOption(option);
            }
        );
    },
    EconfigCustomerPerson: function (url, ele) {
        var aCustomerPersonal;
        var bCustomerPersonal;
        var cCustomerPersonal;
        var dCustomerPersonal;
        var xDate;
        $.ajaxSettings.async = false;
        $.getJSON(url,{showAllList:ElementVar.showAllList}, function (data) {
            aCustomerPersonal = data.aCustomerPersonal;
            bCustomerPersonal = data.bCustomerPersonal;
            cCustomerPersonal = data.cCustomerPersonal;
            dCustomerPersonal = data.dCustomerPersonal;
            xDate = data.xDate;
        });
        var echartsPath = $Url.BuildImgUrl("../js/echarts/dist")
        require.config({
            paths: {echarts: echartsPath}
        });
        require(
            [
                "echarts",
                "echarts/chart/line",
                "echarts/chart/bar"
            ],
            function (ec) {
                var myChart = ec.init(document.getElementById(ele));
                option = {
                    title: {
                        text: '本周新增客户量',
						x:'center',
                        y:'bottom'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['A类客户', 'B类客户', 'C类客户', 'D类客户'],
						x:'left',
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            magicType: {show: true, type: ['line', 'bar']},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    xAxis: [
                        {
                            type: 'category',
                            data: xDate
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name: 'A类客户',
                            type: 'line',
                            data: aCustomerPersonal
                        },
                        {
                            name: 'B类客户',
                            type: 'line',
                            data: bCustomerPersonal
                        },
                        {
                            name: 'C类客户',
                            type: 'line',
                            data: cCustomerPersonal
                        },
                        {
                            name: 'D类客户',
                            type: 'line',
                            data: dCustomerPersonal
                        }
                    ]
                };
                myChart.setOption(option);
            }
        );
    }
}
$(function () {
    $("#product").tabs({
        onSelect: function (title, index) {
            var productTable = $('#product').tabs('getSelected').find("table");
            if (productTable.html() == "") {
                ProductModel.Product(productTable, productTable.attr("status"));
            }
            return true;
        }
    });
    ProductModel.P2p($("#xianFangBaoList"), $("#xianFangBaoList").attr("status"));
    $("#knowledgeBase").tabs({
        onSelect: function (title, index) {
            var knowledgeBaseTable = $('#knowledgeBase').tabs('getSelected').find("table");
            if (knowledgeBaseTable.html() == "") {
                KnowledgeBaseModel.KnowledgeBase(knowledgeBaseTable, knowledgeBaseTable.attr("status"));
            }
            return true;
        }
    });
    KnowledgeBaseModel.KnowledgeBase($("#noticeList"), $("#noticeList").attr("status"));
    ActivityModel.Activity($("#activityList"));
    Echarts.EconfigSales($Url.BuildNewIndexUrl("/getIndexSales"), "salesMain");
    Echarts.EconfigCustomerPerson($Url.BuildNewIndexUrl("/getIndexCustomerPerson"), "customerPersonalMain");
    $("#knowledgeBaseMore").click(function(){
        $EasyUI.NewEmptyTab("知识库",$Url.BuildNewIndexUrl("employee/knowledgeBase/list"));
    });
    $("#activityMore").click(function(){
        $EasyUI.NewEmptyTab("活动通知",$Url.BuildNewIndexUrl("/sales/activity/list"));
    });
    $("#productMore").click(function(){
        $EasyUI.NewEmptyTab("产品",$Url.BuildNewIndexUrl("/product/product/list"));
    });

});
