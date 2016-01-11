var arr = new Array();//lyh
$.fn.linkage = function (options) {
    var opts = $.extend({}, $.fn.linkage.defaults, options);

    var elements = opts.elements;
    var dataTypes = opts.dataTypes;
    arr = elements;//lyh
    if (elements.length > 1 && elements.length == dataTypes.length) {
        var suffix = "";
        if (opts.all)
            suffix = "All";
        EnumList.GetEnumListToSelect($(elements[0]), dataTypes[0] + suffix, opts.actionUrl);
        for (i = 1; i < elements.length; i++) {
            var op = {
                prev: elements[i - 1],
                dataType: dataTypes[i],
                actionUrl: opts.actionUrl,
                all: opts.all
            }
            $(elements[i]).linkageForJqGrid(op);
        }
    }
};

$.fn.linkage.defaults = {
    elements: [],
    dataTypes: [],//["role",{1:"table1",2:"table2"}] ["role","table1","table2"]
    actionUrl: "",
    all: true
};

$.fn.linkageForJqGrid = function (options) {
    var opts = $.extend({}, $.fn.linkageForJqGrid.defaults, options);

    if (opts.prev == null || $(opts.prev).length == 0)
        return;
    if ($(this).length == 0)
        return;

    var suffix = "";
    if (opts.all)
        suffix = "All";

    var o = $(this);

    var curVal = $(opts.prev).val();
    if (curVal == null)
        curVal = "0";

    if (opts.dataType instanceof Object) {
        EnumList.GetEnumListToSelect($(o), opts.dataType[curVal] + suffix, opts.actionUrl);
        $(opts.prev).change(function () {
        	Linkage.emptyAfterSelect($(this));//lyh
            EnumList.GetEnumListToSelect($(o), opts.dataType[$(this).val()] + suffix, opts.actionUrl);
        })
    }
    else {
        EnumList.GetEnumListToSelect($(o), opts.dataType + suffix, opts.actionUrl, curVal);
        $(opts.prev).change(function () {
        	Linkage.emptyAfterSelect($(this));//lyh
            EnumList.GetEnumListToSelect($(o), opts.dataType + suffix, opts.actionUrl, $(this).val());
        })
    }

};

$.fn.linkageForJqGrid.defaults = {
    prev: null,
    dataType: "",//{1:"table1",2:"table2"} ,"table"
    actionUrl: "",
    all: true
};

var Linkage = {
    emptyAfterSelect: function(curObj){//lyh
    	var num = 0;
        for (var i = 0; i < arr.length; i++) {
            if(curObj.val()==arr[i].val()) {
                num = i;
                break;
            }
        }
		for(var j=num+1 ; j<arr.length;j++){
			var fisrtOptVal = arr[j].find("option[value='']").text();
			arr[j].empty();
			arr[j].append('<option value="">'+fisrtOptVal+'</option>');
		}
    }
}
