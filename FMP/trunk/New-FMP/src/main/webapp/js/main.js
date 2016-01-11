/**
 * Created by 磊 on 2015/11/2.
 */
var Main = {
    AddTab: function (jQuery, title, url) {
        var url = $Url.BuildNewIndexUrl(url);
        var content = '<iframe src="' + url + '" allowTransparency="true" style="border: 0; width: 100%; height: 100%;" frameBorder="0"></iframe>'
        var mainOpts = {
            title: title,
            closable: false,
            content: content
        };
        jQuery.tabs('add', mainOpts);
    },
    AuditModel: function (jQuery, url) {
        jQuery.datagrid({
            url: $Url.BuildNewIndexUrl(url),
            method: 'post',
            fit: true,
            fitColumns: true,
            singleSelect: true,
            loadMsg: "正在加载，请稍等...",
            pagination: false,
            showHeader: false,
            queryParams: {

            },
            columns: [[
                {field: 'title', align: 'left',width:'60%',formatter:function(value,row){
                    var url =$Url.BuildNewIndexUrl(row.uri+row.id);
                    return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                }},
                {field: 'status', align: 'left',width:'40%',formatter:function(value){
                        return "<span style='color: #ab1e1e'>"+value+"</span>";
                }}
            ]]
        });
    },
    TaskModel: function (jQuery, url) {
        jQuery.datagrid({
            url: $Url.BuildNewIndexUrl(url),
            method: 'post',
            fit: true,
            fitColumns: true,
            singleSelect: true,
            loadMsg: "正在加载，请稍等...",
            pagination: false,
            showHeader: false,
            queryParams: {

            },
            columns: [[
                {field: 'title', align: 'left',width:'60%',formatter:function(value,row){
                    var url =$Url.BuildNewIndexUrl(row.uri+row.id);
                    return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                }},
                {field: 'taskDate', align: 'left',width:'40%',}
            ]]
        });
    },
    MessageModel: function (jQuery, url) {
        jQuery.datagrid({
            url: $Url.BuildNewIndexUrl(url),
            method: 'post',
            fit: true,
            fitColumns: true,
            singleSelect: true,
            loadMsg: "正在加载，请稍等...",
            pagination: false,
            showHeader: false,
            queryParams: {
            },
            columns: [[
                {field: 'subject', title: '标题', align: 'left',width:'60%',formatter:function(value,row){
                    var url = $Url.BuildNewIndexUrl("/baseInfo/letter/edit?id=") + row.id;
                    return "<a href=\"javascript:void(0)\" onclick=\"$EasyUI.AddTab('" + value + "','" + url + "')\">" + value + "</a>";
                }},
                {field: 'inTime', title: '发布时间', align: 'left',width:'40%',formatter:function(value){
                    return new Date(value).format("yyyy-MM-dd");
                }}
            ]]
        });
    },
    GetAccordion: function () {
        var url = $Url.BuildNewIndexUrl("/getMenuAccordion");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            async: false,
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                $.each(data.menuList, function (i, element) {
                    var content = "<ul class='easyui-tree' id='" + element.id + "'></ul>"
                    $("#menuTree").accordion('add', {
                        title: element.name,
                        content: content
                    });
                });
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        })
    },
    GetMenuTree: function () {
        $("#menuTree").accordion({
            onSelect:function(title,index){
                var panel = $(this).accordion('getPanel',index);
                var tree = $(panel).find("ul")
                if(tree.html() == ""){
                    var id = tree.attr("id");
                    var url = $Url.BuildNewIndexUrl("/getMenuTree") + "?id=" + id;
                    $.getJSON(url,function(data){
                        $("#" + id).tree({
                            data: data.easyUITree
                        });
                    });
                }
                return;
            }
        });
    },
    Init:function(){
        $(".easyui-tree").tree({
            onClick: function (node) {
                var opts = {
                    title: node.text,
                    closable: true,
                    iconCls: node.iconCls,
                    content: '<iframe src="' + node.url + '" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>',
                    border: false,
                    fit: true
                };
                if ($("#center").tabs("exists", opts.title)) {
                    $("#center").tabs("select", opts.title)
                }
                else {
                    $("#center").tabs("add", opts)
                }
                //window.open(node.url);
            }
        });
        // 选项卡菜单
        var tabsMenu = $('#tabsMenu').menu(
            {
                onClick : function(item) {
                    var curTabTitle = $(this).data('tabTitle');
                    var type = $(item.target).attr('type');
                    if (type === 'refresh') {
                        refreshTab(curTabTitle);
                        return;
                    }
                    if (type === 'close') {
                        var t = $("#center").tabs('getTab', curTabTitle);
                        if (t.panel('options').closable) {
                            $("#center").tabs('close', curTabTitle);
                        }
                        return;
                    }
                    var allTabs = $("#center").tabs('tabs');
                    var closeTabsTitle = [];
                    $.each(allTabs, function() {
                        var opt = $(this).panel('options');
                        if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
                            closeTabsTitle.push(opt.title);
                        } else if (opt.closable && type === 'closeAll') {
                            closeTabsTitle.push(opt.title);
                        }
                    });
                    for ( var i = 0; i < closeTabsTitle.length; i++) {
                        $("#center").tabs('close', closeTabsTitle[i]);
                    }
                }
            });
        // 初始化选项卡
        $("#center").tabs({
            fit : true,
            border : false,
            tools : [{
                text : '刷新',
                iconCls : 'icon-reload',
                handler : function() {
                    $(".indexTable").datagrid("reload");
                    var panel = $("#center").tabs('getSelected').panel('panel');
                    var frame = panel.find('iframe');
                    try {
                        if (frame.length > 0) {
                            for ( var i = 0; i < frame.length; i++) {
                                frame[i].contentWindow.document.write('');
                                frame[i].contentWindow.close();
                                frame[i].src = frame[i].src;
                            }
                            if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
                                try {
                                    CollectGarbage();
                                } catch (e) {
                                }
                            }
                        }
                    } catch (e) {
                    }
                }
            } ],
            onContextMenu : function(e, title) {
                e.preventDefault();
                tabsMenu.menu('show', {
                    left : e.pageX,
                    top : e.pageY
                }).data('tabTitle', title);
            }
        });
    },
}
$(function () {
    Main.AddTab($("#center"), "首页", "/newIndex");
    Main.TaskModel($("#myTaskList"), "/workFlow/auditTask/easyUIAuditTaskList");
    Main.AuditModel($("#myApplyList"), "/workFlow/processing/easyUIProcessingList");
    Main.MessageModel($("#letterList"), "/baseInfo/letter/easyUILetterList");
    Main.GetAccordion();
    Main.GetMenuTree();
    Main.Init();
    $("#calendar").click(function(){
        $EasyUI.NewEmptyTab("日历",$Url.BuildNewIndexUrl("/baseInfo/calendar/list"));
    });
    $("#contacts").click(function(){
        $EasyUI.NewEmptyTab("通讯录",$Url.BuildNewIndexUrl("/baseInfo/mailList/list"));
    });
    $("#knowledge").click(function(){
        $EasyUI.NewEmptyTab("知识库",$Url.BuildNewIndexUrl("/employee/knowledgeBase/list"));
    });
    $("#message").click(function(){
        $EasyUI.NewEmptyTab("站内信",$Url.BuildNewIndexUrl("/baseInfo/letter/list"));
    });
    $("#remind").click(function(){
        $EasyUI.NewEmptyTab("提醒",$Url.BuildNewIndexUrl("/baseInfo/letter/remindList"));
    });
    $("#updatePwd").click(function(){
        $EasyUI.NewEmptyTab("修改密码",$Url.BuildNewIndexUrl("/updatePwd"));
    });
    $("#logout").attr("href",$Url.BuildNewIndexUrl("/logout"));
    $("#taskMore").click(function(){
        $EasyUI.NewEmptyTab("我的任务",$Url.BuildNewIndexUrl("/workFlow/auditTask/list"));
    });
    $("#applyMore").click(function(){
        $EasyUI.NewEmptyTab("我的申请",$Url.BuildNewIndexUrl("/workFlow/processing/list"));
    });
    $.getJSON($Url.BuildNewIndexUrl("/employee/employee/ajaxGetEmployeeForIndex"),function(data){
        if(data.errCode == "failed"){
            $("#empName").val("");
            return;
        }
        $("#empName").html(data.info.name);
    });
});