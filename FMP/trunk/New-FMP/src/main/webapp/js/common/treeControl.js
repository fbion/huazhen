
$.fn.EmployeeTree = function (options) {
    var opts = $.extend({}, $.fn.EmployeeTree.defaults, options);

    var employeeNameFormat = '<a href="javascript:void(0)" id="{0}">{1}</a><input id="{2}" type="hidden" value="{3}"/>'
    if (opts.id == 0) {
        $(this).append(employeeNameFormat.format("a_" + opts.inputId, "请选择", opts.inputId, 0))
    } else {
        var empName = "";//todo userId or employeeId? is single?
        var no = 0;//todo
        $(this).append(employeeNameFormat.format("a_" + opts.inputId, empName, opts.inputId, no))
    }

    $.showBox = function (opt, obj) {
        /*默认*/
        var defaults = {
            title: '员工',
            content: '内容',
            ctype: 'common',
            width: 260,
            height: 600,
            mask: true,
            drag: true,
            pos: 'center',
            fix: true,
            singleSel: true,
            url: "",
            params: {}
        };

        /*合并选项*/
        var config = $.extend(defaults, opt);

        popout();
        /*弹出*/
        function popout() {
            maskLayer();

            /*模板*/
            var tpl = '<div class="popbox"><div id="popboxtop"><span id="popboxtopclose">&times;</span>' +
                '<span id="popboxtoptitle"></span><div style="clear:both;"></div></div><div id="popboxcontent"><div>' +
                '<input type="button" id="allEmployee" value="全部员工"  style="cursor:pointer"/>' +
                '<input type="button" id="onEmployee" value="在职员工" style="cursor:pointer"/></div>' +
                '<div id="treeboxbox_tree" class="dhtmlxTree" style="width: 30%; height: 800px;float:left"></div></div></div>';

            $("body").prepend(tpl);
            /*挂载*/
            position();
            /*调整位置*/
            content();
            /*填充内容*/
            closed();
            /*绑定关闭*/
        };

        /*调整位置*/
        function position() {
            var isIe6 = $.browser.msie && ($.browser.version == "6.0");

            if (isIe6) {
                var fix = 'absolute';
            } else {
                var fix = config.fix ? 'fixed' : 'absolute';
            }
            if (config.pos == 'center') {/*居中*/
                var left = ($(window).scrollLeft() + $(window).width() / 2 - (config.width / 2)) + 'px';
                var top = ($(window).scrollTop() + $(window).height() / 2 - (config.height / 2)) + 'px';
                $('.popbox').css({'position': fix, 'top': top, 'left': left, 'width': config.width, 'height': config.height});
            }
            $('#popboxcontent').css({height: (config.height - 31) + 'px'});
        };
        /*填充内容*/
        function content() {
            $('#popboxtoptitle').html(config.title);
            tree = new dhtmlXTreeObject($("#treeboxbox_tree").get(0), "100%", "100%", 0);
            var xml = $Url.BuildImgUrl("/dhtmlxTree/imgs/csh_bluefolders/");
            tree.setImagePath(xml);
            var url = $Url.BuildNewIndexUrl("/makeTree?id=" + 1);
            tree.loadXML(url);
            tree.setOnClickHandler(function () {
                alert(111);
            });
        }

        /*遮罩层*/
        function maskLayer(color) {
            if (!color) {
                color = '#e7e527';
            }
            var tmpMask = new String;
            tmpMask = '<div id="maskLayer"></div>';
            $("body").prepend(tmpMask);
            $('#maskLayer').css({
                /*'width':$(document).width()+'px',*/
                'width': '100%',
                'height': $(document).height() + 'px',
                'position': 'absolute',
                'top': '0px',
                'left': '0px',
                'z-index': '60',
                'filter': 'alpha(opacity=50)',
                'opacity': '0.5'
            });
        };
        /*关闭*/
        function closed() {
            $('#popboxtopclose').bind('click', function () {
                setTimeout("$('#maskLayer').fadeOut(500)", 0);
                setTimeout("$('.popbox').fadeOut(500)", 0);
                setTimeout("$('#maskLayer').remove()", 500);
                setTimeout("$('.popbox').remove()", 500);
            });
        }

        /*拖拽*/
        var mouse = {x: 0, y: 0};

        function moveDialog(event) {
            var e = window.event || event;
            var top = parseInt($('.popbox').css('top')) + (e.clientY - mouse.y);
            var left = parseInt($('.popbox').css('left')) + (e.clientX - mouse.x);
            if (top < 1) {
                top = 0;
            }
            /*上*/
            if (left < 1) {
                left = 0;
            }
            /*左*/
            bt = $(window).height() - config.height;
            if (top > bt) {
                top = bt;
            }
            /*下*/
            rt = $(window).width() - config.width;
            if (left > rt) {
                left = rt;
            }
            /*右*/
            $('.popbox').css({top: top, left: left});
            mouse.x = e.clientX;
            mouse.y = e.clientY;
        };
        $('#popboxtop').mousedown(function (event) {
            if (!config.drag || config.pos == 'rightdown') {
                return;
            }
            var e = window.event || event;
            mouse.x = e.clientX;
            mouse.y = e.clientY;
            $(document).bind('mousemove', moveDialog);
        });
        $(document).mouseup(function (event) {
            $(document).unbind('mousemove', moveDialog);
        });
        /*结束*/
    }

    $(this).on("click","a",function(){
        $.showBox(opts,this)
    })
}
$.fn.EmployeeTree.defaults = {
    id: 0,
    singleSel: true,
    isUserId:true,
    url: "",
    inputId: "empNo",
    params: {}
}

var setting = {
    check: {
        //Y被勾选时：p关联父，s关联子
        //N取消勾选时：p关联父，s关联子
        enable: true,
        chkboxType: {"Y":"", "N":""},
        chkDisabledInherit: true,
        //chkStyle: "radio",
        radioType: "all"
    },
    view: {
        dblClickExpand: false,
        fontCss: getFontCss
    },
    data: {
        key: {
            //title: "t"
        },
        simpleData: {
            enable: true
        }
    },
    callback: {
        beforeClick: beforeClick,
        onCheck: onCheck
    }
};


function beforeClick(treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("employeeTree");
    zTree.checkNode(treeNode, !treeNode.checked, null, true);
    return false;
}
//写cookies 
function setCookie(name,value) 
{ 
    var Days = 30; 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString(); 
} 
//读取cookies 
function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]); 
    else 
        return null; 
} 
function onCheck(e, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("employeeTree"),
        nodes = zTree.getCheckedNodes(true),
        v = "";
    iid = "";
    for (var i=0, l=nodes.length; i<l; i++) {
        v += nodes[i].name + ",";
        iid += nodes[i].iid + ",";
    }
    if (v.length > 0 ) v = v.substring(0, v.length-1);
    if (iid.length > 0 ) iid = iid.substring(0, iid.length-1);
    $("#"+optT.treeInputId).val(v);
    $("#"+optT.valInputId).val(iid);
    if(optT.showLevel==2){
    	setCookie("deptName",v);
        setCookie("deptId",iid);
    }else if(optT.showLevel==3){
    	setCookie("userNameTree",v);
        setCookie("userIdTree",iid);
    }
    
}

function showMenu() {
    //initTree(optT);
    var employeeObj = $("#"+optT.treeInputId);
    if(employeeObj.length<=0) {alert(optT.treeInputId+"不存在！");return;}
    employeeObj.css({color: "black"});
    var employeeOffset = $("#"+optT.treeInputId).offset();
    $("#menuContent").css({left:employeeOffset.left + "px", top:employeeOffset.top + employeeObj.outerHeight()+10 + "px"}).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
    //$("#menuContent").remove();
    //$("#menuBtn").remove();
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == optT.treeInputId || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
        hideMenu();
    }
}

var optT;
var zNodes =[];
var preBut;
var cookieFlag=false;
function initTree(optT){
    zNodes =[];

    setting.check.chkStyle = optT.chkStyle;
    setting.check.chkboxType.Y = optT.chkboxType.Y;
    setting.check.chkboxType.N = optT.chkboxType.N;
    if($("#"+optT.treeInputId).length<=0) return;
    $("#"+optT.treeInputId).bind('input propertychange',function(){
    	$("#"+optT.valInputId).val("");
    });


    var companys;//公司
    var depts;//部门
    var positions;//职位
    var employees;//员工
    if(optT.showLevel == 1){
        companys = EnumList.GetEnumListToTree("empCompanylistToTree",optT.param, $Url.BuildEmployeeUrl("/common/enumList.action"));
    }
    if(optT.showLevel == 2){
        companys = EnumList.GetEnumListToTree("empCompanylistToTree",optT.param, $Url.BuildEmployeeUrl("/common/enumList.action"));
        depts = EnumList.GetEnumListToTree("deptlistToTree",optT.param, $Url.BuildEmployeeUrl("/common/enumList.action"));
    }
    if(optT.showLevel == 3){
        companys = EnumList.GetEnumListToTree("empCompanylistToTree",optT.param, $Url.BuildEmployeeUrl("/common/enumList.action"));
        depts = EnumList.GetEnumListToTree("deptlistToTree",optT.param, $Url.BuildEmployeeUrl("/common/enumList.action"));
        if(optT.inputType=="position")
            positions = EnumList.GetEnumListToTree("positionlistToTree",optT.param, $Url.BuildEmployeeUrl("/common/enumList.action"));
        if(optT.inputType=="employee")
            employees = EnumList.GetEnumListToTree("employeeListToTree",optT.param, $Url.BuildEmployeeUrl("/common/enumList.action"),optT.idType);
    }
    //chkDisabled:false取消禁用
    //open:false默认不打开
    //checked:false默认不被选中
    //nocheck:true显示复选框
    /*var zNodes =[
     { id:1, pId:0, name:"随意勾选 1",chkDisabled:true, open:false},
     { id:11, pId:1, name:"随意勾选 1-1", open:false},
     { id:111, pId:11, name:"随意勾选 1-1-1"},
     { id:112, pId:11, name:"随意勾选 1-1-2"},
     { id:12, pId:1, name:"随意勾选 1-2", open:false},
     { id:121, pId:12, name:"随意勾选 1-2-1"},
     { id:122, pId:12, name:"随意勾选 1-2-2"},
     { id:2, pId:0, name:"随意勾选 2", checked:false, open:false},
     { id:21, pId:2, name:"随意勾选 2-1"},
     { id:22, pId:2, name:"随意勾选 2-2", open:false},
     { id:221, pId:22, name:"随意勾选 2-2-1", checked:false},
     { id:222, pId:22, name:"随意勾选 2-2-2"},
     { id:23, pId:2, name:"随意勾选 2-3"}
     ];*/


    if(companys!=undefined)
        for(var i=0;i<companys.length;i++){
            var obj = new Object();
            obj.id = companys[i].id;
            obj.pId = companys[i].pId;
            obj.name = companys[i].name;
            obj.iid = companys[i].id;
            if(optT.nochecks.length>0)
                obj.nocheck = optT.nochecks[0];
            obj.open=true;
            zNodes.push(obj);
        }
    var newPositions = [];
    var iarr = [];
    var jarr = [];
    if(depts!=undefined){
    	for(var i=0;i<depts.length;i++){
    		var oid = depts[i].id;
    		var nid = i+companys[companys.length-1].id+depts[depts.length-1].id;
    		depts[i].id = nid;
    		if(depts[i].parentNo!=0){
    			for(var j=0;j<depts.length;j++){
    				if(i==j) continue;
    				//当前部门的id==其他部门的parentNo
    				if(depts[j].parentNo==oid) depts[j].pId = depts[i].id;
    				//当前部门的parentNo==其他部门的id
    				if(depts[i].parentNo==depts[j].id) {
    					iarr.push(i);
    					jarr.push(j);
    				}
    			}
    		}
    		if(positions!=undefined){
    			for(var j=0;j<positions.length;j++){
    				if(positions[j].pId==depts[i].type){
    					var object = new Object();
    					object.pId = nid;
    					object.name = positions[j].name;
    					object.iid = positions[j].id;
    					object.id = positions[j].id+newPositions.length;
    					newPositions.push(object);
    					//positions[j].pId = nid;
    				}
    			}
    		}
    		if(employees!=undefined)
    			for(var j=0;j<employees.length;j++){
    				if(employees[j].pId==oid) employees[j].pId = nid;
    			}
    		depts[i].oid = oid;
    		/*var obj = new Object();
            obj.id = depts[i].id;
            obj.pId = depts[i].pId;
            obj.name = depts[i].name;
            obj.iid = oid;
            if(optT.nochecks.length>1)
                obj.nocheck = optT.nochecks[1];
            zNodes.push(obj);*/
    	}
    	if(iarr.length>0&&jarr.length>0){
    		for(var i=0;i<iarr.length;i++){
    			depts[iarr[i]].parentNo = depts[jarr[i]].id
    		}
    	}
    	for(var i=0;i<depts.length;i++){
    		var obj = new Object();
    		obj.id = depts[i].id;
    		obj.pId = depts[i].pId;
    		obj.name = depts[i].name;
    		obj.iid = depts[i].oid;
    		if(optT.nochecks.length>1)
    			obj.nocheck = optT.nochecks[1];
    		//alert(getCookie("deptId"));
    		if(optT.showLevel==2){
    			if(getCookie("deptName")==null || getCookie("deptName")==""){
        			if(obj.pId==1){
            			obj.open=true;
            		}
        		}else{
        			cookieFlag=true;
        		}
    		}else if(optT.showLevel==3){
    			if(getCookie("userNameTree")==null || getCookie("userNameTree")==""){
        			if(obj.pId==1){
            			obj.open=true;
            		}
        		}else{
        			cookieFlag=true;
        		}
    		}
    		
    		zNodes.push(obj);
    	}
    }
    /*if(positions!=undefined)
     for(var i=0;i<positions.length;i++){
     var obj = new Object();
     obj.pId = positions[i].pId;
     obj.name = positions[i].name;
     obj.iid = positions[i].id;
     positions[i].id = i+depts[depts.length-1].id+positions[positions.length-1].id;
     obj.id = positions[i].id;
     if(optT.nochecks.length>2)
     obj.nocheck = optT.nochecks[2];

     zNodes.push(obj);
     }*/
    for(var i=0;i<newPositions.length;i++){
        var obj = new Object();
        obj.pId = newPositions[i].pId;
        obj.name = newPositions[i].name;
        obj.iid = newPositions[i].id;
        newPositions[i].id = i+depts[depts.length-1].id+newPositions[newPositions.length-1].id;
        obj.id = newPositions[i].id;
        if(optT.nochecks.length>2)
            obj.nocheck = optT.nochecks[2];

        zNodes.push(obj);
    }
    if(employees!=undefined)
        for(var i=0;i<employees.length;i++){
            var obj = new Object();
            obj.pId = employees[i].pId;
            obj.name = employees[i].name;
            obj.iid = employees[i].id;
            employees[i].id = i+depts[depts.length-1].id+employees[employees.length-1].id;
            obj.id = employees[i].id;
            if(optT.nochecks.length>2)
                obj.nocheck = optT.nochecks[2];

            zNodes.push(obj);
        }
    if(optT.sizeAuto)
        $("#employeeTree").css({width:"auto", height: "auto"});
    else
        $("#employeeTree").css({width:optT.width+"px", height: optT.height+"px"});
    $.fn.zTree.init($("#employeeTree"), setting, zNodes);
    addPreBut();
    $("#"+optT.treeInputId).click(function(){
        showMenu();
    });
    initSearch();
    if(cookieFlag==true && optT.showLevel==2){
    	var zTree = $.fn.zTree.getZTreeObj("employeeTree");

        updateNodes(false);
        nodeList = zTree.getNodesByParamFuzzy("name", getCookie("deptName"));
        if(nodeList.length==1){
        	var nodeLists=new Array();
        	nodeLists=nodeList;
        	$("#"+optT.treeInputId).val(nodeLists[0].name);
        	$("#"+optT.valInputId).val(nodeLists[0].iid);
        }
        updateNodes(true);
        
    	cookieFlag=false;
    }else if(cookieFlag==true && optT.showLevel==3){
    	var zTree = $.fn.zTree.getZTreeObj("employeeTree");

        updateNodes(false);
        nodeList = zTree.getNodesByParamFuzzy("name", getCookie("userNameTree"));
        if(nodeList.length==1){
        	var nodeLists=new Array();
        	nodeLists=nodeList;
        	$("#"+optT.treeInputId).val(nodeLists[0].name);
        	$("#"+optT.valInputId).val(nodeLists[0].iid);
        }
        updateNodes(true);
        
    	Flag=false;
    }
}
function addPreBut(){
    if(optT.showPreBut&&optT.inputType=="employee"){
        preBut = /*'<input type="button" id="allEmployee" value="全部员工"  style="cursor:pointer"/>' +*/
            '<input type="button" id="onEmployee" value="在职员工" style="cursor:pointer"/>'+
            '<input type="button" id="outEmployee" value="离职员工" style="cursor:pointer"/>'+
            '<input type="button" id="testEmployee" value="测试员工" style="cursor:pointer"/>'+
            '<input type="button" id="clearEmployee" value="清空" style="cursor:pointer"/>'+
            '</br>';
        //var searchInput = '搜索<input type="text" id="key" value="" class="empty" style="width:100px;"/>';
//		if(optT.showSearch)
//			$("#employeeTree").prepend(searchInput);
        $("#employeeTree").prepend(preBut);
        if(optT.param == "all"){
            $("#allEmployee").addClass("cur");
            $("#onEmployee").removeClass("cur");
            $("#outEmployee").removeClass("cur");
            $("#testEmployee").removeClass("cur");
        }
        if(optT.param == "on"){
            $("#allEmployee").removeClass("cur");
            $("#onEmployee").addClass("cur");
            $("#outEmployee").removeClass("cur");
            $("#testEmployee").removeClass("cur");
        }
        if(optT.param == "out"){
            $("#allEmployee").removeClass("cur");
            $("#onEmployee").removeClass("cur");
            $("#outEmployee").addClass("cur");
            $("#testEmployee").removeClass("cur");
        }
        if(optT.param == "test"){
            $("#allEmployee").removeClass("cur");
            $("#onEmployee").removeClass("cur");
            $("#outEmployee").removeClass("cur");
            $("#testEmployee").addClass("cur");
        }
        $("input").removeClass("cur");
        $("#"+optT.param+"Employee").addClass("cur");
        if($("#allEmployee").length>0){
            $("#allEmployee").off().click(function(){
                optT.param = "all";
                initTree(optT);
            });
        }
        if($("#onEmployee").length>0){
            $("#onEmployee").off().click(function(){
                optT.param = "on";
                initTree(optT);
            });
        }
        if($("#outEmployee").length>0){
            $("#outEmployee").off().click(function(){
                optT.param = "out";
                initTree(optT);
            });
        }
        if($("#testEmployee").length>0){
            $("#testEmployee").off().click(function(){
                optT.param = "test";
                initTree(optT);
            });
        }
        $("#clearEmployee").click(function(){
        	$("#"+optT.valInputId).val("");
        	$("#"+optT.treeInputId).val("");
        });
    }
}
function focusKey(e) {
    if (key.hasClass("empty")) {
        key.removeClass("empty");
    }
}
function blurKey(e) {
    if (key.get(0).value === "") {
        key.addClass("empty");
    }
}
var lastValue = "", nodeList = [], fontCss = {};
function clickRadio(e) {
    lastValue = "";
    searchNode(e);
}
function searchNode(e) {
    var zTree = $.fn.zTree.getZTreeObj("employeeTree");

    var value = $.trim(key.get(0).value);
    var keyType = "name";
    if (key.hasClass("empty")) {
        value = "";
    }
    if (lastValue === value) return;
    lastValue = value;
    if (value === "") return;
    updateNodes(false);
    nodeList = zTree.getNodesByParamFuzzy(keyType, value);
    if(nodeList.length==1){
    	var nodeLists=new Array();
    	nodeLists=nodeList;
    	$("#"+optT.treeInputId).val(nodeLists[0].name);
    }

    updateNodes(true);
    
}
var flagN = false;
var preNodeList = [];
function updateNodes(highlight) {
    var zTree = $.fn.zTree.getZTreeObj("employeeTree");
    flagN = false;
    for(var i=0;i<preNodeList.length;i++){
        openAgain(preNodeList[i]);
    }
    $.fn.zTree.init($("#employeeTree"), setting, zNodes);
    flagN = true;
    for( var i=0, l=nodeList.length; i<l; i++) {
        openAgain(nodeList[i]);
    }
    preNodeList = nodeList;
    $.fn.zTree.init($("#employeeTree"), setting, zNodes);
    for( var i=0, l=nodeList.length; i<l; i++) {
        nodeList[i].highlight = highlight;
        //nodeList[i].open = true;
        zTree.updateNode(nodeList[i]);
    }
    addPreBut();
}
function openAgain(arr){
    if(arr.pId==0) return;
    for(var j=0;j<zNodes.length;j++){
        if(arr.pId==zNodes[j].id) {
            zNodes[j].open = flagN;
            openAgain(zNodes[j]);
        }
    }
}
function getFontCss(treeId, treeNode) {
    return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
}
function filter(node) {
    return !node.isParent && node.isFirstNode;
}

var key;
function initSearch(){
    key = $("#"+optT.treeInputId);
    key.bind("focus", focusKey)
        .bind("blur", blurKey)
        .bind("propertychange", searchNode)
        .bind("input", searchNode);
}
var idObj = new Object();
var EmployeeTreeControl = {
    startTree:function (options){
        /*默认*/
        var defaultsObj = {
            param: "on",  //all全体员工,on在职员工，out离职员工，test测试员工
            treeInputId: "employeeSel",//员工控件框ID
            valInputId: "",    //员工值框id
            inputType: "employee",//employee员工，position职位
            idType: "empNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
            chkStyle: "radio",//选框类型checkbox,radio
            chkDisabled:[],   //取消禁用
            nochecks:[],      //逐级不显示单或复选框
            chkboxType:{"Y":"", "N":""},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
            showPreBut: false,   //显示全部员工，在职员工按钮
            //showSearch: false,   //显示搜索框
            showLevel:3,          //显示层级
            sizeAuto:true,		//自动调节大小
            width:180,			//宽，单位px
            height:300			//高，单位px
            //showMenuBtn: false //不显示‘请选择’
        }
        optT = $.extend({}, defaultsObj, options);
        if($("#"+optT.valInputId).length>0&&$("#"+optT.valInputId).val().trim()!=""&&$("#"+optT.valInputId).val().trim()!=null) {
            $("#"+optT.treeInputId).val(EnumList.GetValueToInputById("valueToInputById",$("#"+optT.valInputId).val().trim(), $Url.BuildEmployeeUrl("/common/enumList.action"),optT.idType));
        }
        var val = optT.treeInputId;
        //var obj = {""+optT.treeInputId:optT};
        idObj[val] =optT;
        $("#"+optT.treeInputId).focus(function(){
            /*var optT;
             var array=[];
             for(var o in idObj){//遍历idArr
             array.push(o);//存入数组
             }
             for(var i=0;i<array.length;i++){
             if($(this).attr("id")==array[i]){
             optT = idObj[array[i]];
             }
             }*/
            optT = idObj[$(this).attr("id")];
            initTree(optT);
        });
        $("#"+optT.treeInputId).after('<div id="menuContent" class="menuContent" style="display:none; position: absolute;z-index:200">'+
            '<ul id="employeeTree" class="ztree" style="margin-top:0;"></ul></div>');
        //$("#"+optT.treeInputId).after('<a id="menuBtn" href="#" onclick="showMenu(); return false;">请选择</a>');
    }
};


/*$(document).ready(function(){
	 EmployeeTreeControl.startTree({
		 param: "on",  //on在职员工，out离职员工，test测试员工
		 treeInputId: "employeeSel",//员工控件框ID
		 valInputId: "itemId", //员工值框id
		 inputType: "employee",//employee员工，position职位
		 idType: "empNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
		 chkStyle: "checkbox",//选框类型checkbox,radio
		 nochecks:[false,false,false],      //逐级不显示单或复选框,true不显示，false显示
		 chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
		 showPreBut: true,   //显示全部员工，在职员工按钮,离职员工，test测试员工
		 //showSearch: true,   //显示搜索框
		 showLevel:3,         //显示层级
		 sizeAuto:true,		//自动调节大小
		 width:200,			//宽，单位px
		 height:300			//高，单位px
	 });
	 EmployeeTreeControl.startTree({
		 param: "on",  //on在职员工，out离职员工，test测试员工
		 treeInputId: "employeeSel1",//员工控件框ID
		 valInputId: "itemId1", //员工值框id
		 inputType: "employee",//employee员工，position职位
		 idType: "empNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
		 chkStyle: "checkbox",//选框类型checkbox,radio
		 nochecks:[false,false,false],      //逐级不显示单或复选框,true不显示，false显示
		 chkboxType:{Y:"ps", N:"ps"},  //Y被勾选时关联父类子类ps，N取消被勾选时关联父类子类ps
		 showPreBut: false,   //显示全部员工，在职员工按钮,离职员工，test测试员工
		 //showSearch: true,   //显示搜索框
		 showLevel:3,         //显示层级
		 sizeAuto:true,		//自动调节大小
		 width:200,			//宽，单位px
		 height:300			//高，单位px
	 });
	 EmployeeTreeControl.startTree({
		 param: "on",  //on在职员工，out离职员工，test测试员工
		 treeInputId: "employeeSel2",//员工控件框ID
		 valInputId: "itemId2", //员工值框id
		 inputType: "position",//employee员工，position职位
		 idType: "positionNo",        //员工empNo，userNo,职位positionNo,部门deptNo，公司companyNo
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
	 
	 $('#username').bind('input propertychange', function() {  
		 $('#result').html($(this).val().length + ' characters');  
	 });
 });*/