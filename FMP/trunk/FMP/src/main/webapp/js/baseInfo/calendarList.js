var nowTime = "";
var ManagePage = {
    init: function () {
        scheduler.config.xml_date = "%Y-%m-%d %H:%i";
        scheduler.config.prevent_cache = true;
        scheduler.config.first_hour = 4;
        scheduler.config.limit_time_select = true;
        scheduler.locale.labels.section_location = "Location";
        scheduler.config.details_on_create = true;
        scheduler.config.details_on_dblclick = true;
        scheduler.config.prevent_cache = true;

        scheduler.config.lightbox.sections = [
            {name: "主题", height: 43, map_to: "text", type: "textarea", focus: true},
            {name: "详细", height: 130, type: "textarea", map_to: "details"},
            {
                name: "类型", height: 21, map_to: "type", type: "select", options: [
                {key: 1, label: "私有"},
                {key: 2, label: "公开"}
            ]
            },
            {name: "时间", height: 72, type: "time", map_to: "auto"}
        ];

//	scheduler.init('scheduler_here', new Date(2014, 10, 1), "day");
        scheduler.config.multi_day = true;

//	scheduler.config.xml_date="%Y-%m-%d %H:%i";

    },
    inity: function (date) {
        scheduler.init('scheduler_here', new Date(date), "month");
        $.ajax({
            type: "post",
            url: $Url.BuildEmployeeUrl('/baseInfo/calendar/ajaxListCalendar'),
            dataType: "json",
            timeout: 30000,
            data: {},
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                scheduler.parse(data.xml);
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    inityx: function () {
        scheduler.attachEvent("onBeforeEventDelete", function (event_id, event_object) {
            //var url = "YOUR-URL";
            var id = event_object.id;
            var text = event_object.text;
            // date 需要实现格式化，这里需要和server端相互交互
            var convert = scheduler.date.date_to_str("%Y-%m-%d %H:%i");
            var start_date =
                convert(event_object.start_date);
            var end_date = convert(event_object.end_date);
            var details = event_object.details;
            var type = event_object.type;
            var pars = "id=" + id +
                "&start_date=" + start_date +
                "&end_date=" + end_date +
                "&text=" + text +
                "&details=" + details +
                "&type=" + type;
            var sendData = {
                "id": id,
                "startTime": start_date + ":00",
                "endTime": end_date + ":00",
                "theme": text,
                "content": details,
                "state": type
            };
            ManagePage.deleteFunction(sendData);
            return true;
        });
        scheduler.attachEvent("onEventChanged", function (event_id, event_object) {
            // 得到数据
            //var url = "YOUR-URL";
            var id = event_object.id;
            var text = event_object.text;
            // date 需要实现格式化
            var convert = scheduler.date.date_to_str("%Y-%m-%d %H:%i");
            var start_date =
                convert(event_object.start_date);
            var end_date = convert(event_object.end_date);
            var details = event_object.details;
            var type = event_object.type;
            var pars = "id=" + id +
                "&start_date=" + start_date +
                "&end_date=" + end_date +
                "&text=" + text +
                "&details=" + details +
                "&type=" + type;
            var sendData = {
                "id": id,
                "startTime": start_date + ":00",
                "endTime": end_date + ":00",
                "theme": text,
                "content": details,
                "state": type
            };
            ManagePage.editFunction(sendData);
        });

        // 添加事件event
        scheduler.attachEvent("onEventAdded", function (event_id, event_object) {
            var id = event_object.id;
            var text = event_object.text;
            // date 需要实现格式化
            var convert = scheduler.date.date_to_str("%Y-%m-%d %H:%i");
            var start_date =
                convert(event_object.start_date);
            var end_date = convert(event_object.end_date);
            var details = event_object.details;
            var type = event_object.type;
            var sendData = {
                "startTime": start_date + ":00",
                "endTime": end_date + ":00",
                "theme": text,
                "content": details,
                "state": type
            };
            ManagePage.addFunction(sendData,event_object);
        });
    },
    addFunction: function (sendData,event_object) {
        var info = sendData;
        var url = $Url.BuildBaseInfoUrl("/baseInfo/calendar/ajaxEditCalendar");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                info: JSON.stringify(info),
                oper: "add"
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                window.location.href = $Url.BuildBaseInfoUrl("/baseInfo/calendar/list?navSub=日历");
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    editFunction: function (sendData) {
        var info = sendData;
        var url = $Url.BuildBaseInfoUrl("/baseInfo/calendar/ajaxEditCalendar");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                info: JSON.stringify(info),
                oper: "edit"
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                alert(errorThrown);
            },
            success: function (data, textStatus) {
                if (data.errDesc != null && data.errDesc != "") {
                    if (data.errDesc.indexOf("@") > 0) {
                        alert(data.errDesc.split("@")[0]);
                        nowTime = data.errDesc.split("@")[1];
                        ManagePage.inity(nowTime.split(" ")[0]);
                    } else {
                        nowTime = data.errDesc;
                        ManagePage.inity(nowTime.split(" ")[0]);
                    }
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    },
    deleteFunction: function (sendData) {
        var info = sendData;
        var url = $Url.BuildBaseInfoUrl("/baseInfo/calendar/ajaxEditCalendar");
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            timeout: 30000,
            data: {
                info: JSON.stringify(info),
                oper: "delete"
            },
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown, request) {
                alert(errorThrown, request);
                //alert(request);
            },
            success: function (data, textStatus) {
                if (data.errDesc != null && data.errDesc != "") {
                    if (data.errDesc.indexOf("@") > 0) {
                        alert(data.errDesc.split("@")[0]);
                        nowTime = data.errDesc.split("@")[1];
                        ManagePage.inity(nowTime.split(" ")[0]);
                    } else {
                        nowTime = data.errDesc;
                        ManagePage.inity(nowTime.split(" ")[0]);
                    }
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
            }
        });
    }
}

$(function () {
    ManagePage.init();
    var tDate = new Date().toLocaleDateString();
    ManagePage.inity(tDate);
    ManagePage.inityx();
});
