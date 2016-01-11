<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"
	language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<!-- 视图窗口，移动端特属的标签。 -->
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
<!-- 是否启动webapp功能，会删除默认的苹果工具栏和菜单栏。 -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- 这个主要是根据实际的页面设计的主体色为搭配来进行设置。 -->
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<!-- 忽略页面中的数字识别为电话号码,email识别 -->
<meta name="format-detection" content="telephone=no, email=no" />
<!-- 启用360浏览器的极速模式(webkit) -->
<meta name="renderer" content="webkit">
<!-- 避免IE使用兼容模式 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
<meta name="HandheldFriendly" content="true">
<!-- 微软的老式浏览器 -->
<meta name="MobileOptimized" content="320">
<!-- uc强制竖屏 -->
<meta name="screen-orientation" content="portrait">
<!-- QQ强制竖屏 -->
<meta name="x5-orientation" content="portrait">
<!-- UC强制全屏 -->
<meta name="full-screen" content="yes">
<!-- QQ强制全屏 -->
<meta name="x5-fullscreen" content="true">
<!-- UC应用模式 -->
<meta name="browsermode" content="application">
<!-- QQ应用模式 -->
<meta name="x5-page-mode" content="app">
<!-- windows phone 点击无高光 -->
<meta name="msapplication-tap-highlight" content="no">

<meta name="keywords" content="百度地图,百度地图API，百度地图自定义工具，百度地图所见即所得工具" />
<meta name="description" content="百度地图API自定义地图，帮助用户在可视化操作下生成百度地图" />
${pageHead}
<title>${activity.title}</title>

<style type="text/css">
html, body {
	padding: 0;
}

.iw_poi_title {
	color: #CC5522;
	font-size: 14px;
	font-weight: bold;
	overflow: hidden;
	padding-right: 13px;
	white-space: nowrap
}

.iw_poi_content {
	font: 12px arial, sans-serif;
	overflow: visible;
	padding-top: 4px;
	white-space: -moz-pre-wrap;
	word-wrap: break-word
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
</head>
<body class="regbody">
<header class="header">
        <h2>${activity.title}</h2>
     <p>
         <span class="enname">${publisher}</span>
         <span class="endate">${publishDay}</span>
         <span class="entime">${publishTime}</span>

     </p> 
    </header>

    <div class="enrollcontent">
        <ul>
            <li class="registration_time">
                	${activityTime}  ${activityDay}
                	<%-- <br/>
                <span class="cutoff_time">报名截止时间：2015-12-09</span> --%>
             </li>
             <li  class="registration_place">
                <a href="#">${activity.address}</a>
             </li>
             <li class="registration_number">
                邀请参加人数${activity.peopleNum}人
             </li>
        </ul>
    </div>

    <div class="activity_details">
        <p>
            <strong class="actititle">活动详情</strong>
            
        </p>
        <s:iterator value="activityAttachmentList" var="activityAttachment">
        <p> 
            <img src="${activityAttachment.path}" alt=""  style="width:100%; display:block;margin:0 auto;">
        </p>
		</s:iterator>
        <p>
            <a href="#" class="active_content">【活动内容】：${activity.content}</a>
        </p>
    </div>
    
    <footer class="footer">
        <%-- <a href="#" class="goshares">
           <span class="shareimg"></span>
            分享
        </a> --%>
        <a href="#" class="goenlist">
             <span class="enlistimg"></span>
            我要报名
        </a>
    </footer>
     <div class="mask"></div>
    <div class="informations">
       <span class="closeBtn">
        </span>
        <form id="activityApplyForm">
        <div class="info">
            <ul>
                <li>
                    <span class="infoleft"><span class="redstar">*</span>
                    姓名：</span><input type="text" id="name">
                </li>
                <li>
                    <span class="infoleft"><span class="redstar">*</span>
                    手机：</span><input type="text" id="cellphone">
                </li>
                <li>
                    <span class="infoleft">邮箱：</span><input type="text" id="email">
                </li>
                 <li>
                    <span class="infoleft"><span class="redstar">*</span>
                    单位：</span><input type="text" id="unit">
                </li>
                <li>
                    <span class="infoleft">职务：</span><input type="text" id="job">
                </li>
                <p class="negate Validform_checktip" id="message"></p>
                <li class="get_submit">
                    <input type="submit" value="提交">
                </li>
            </ul>
        </div>
            </form>
     </div>
 
    <div class="enterinto">
        <span class="closeBtn">
        </span>
       
        <a href="#" class="copylinks">
            <i class="icon1"></i>复制链接
        </a>
        <a href="#" id="share">
            <i class="icon2"></i>分享
        </a>
    </div> 
    
    <div class="map">
    	<span class="closeBtn">
        </span>
    	<ul>
        	<li  class="registration_place">
                活动地址：${activity.address}
             </li>
             <li class="mapimg" >
        		<div class="ditu" width="100%" style="border:#ccc solid 1px;" id="dituContent"></div>
             </li>
        </ul>
    </div>
    
			<input readonly="readonly" type="hidden" value="${activity.title}" id="title" /> 
			<input readonly="readonly" type="hidden"value="${activity.address}" id="address" /> 
			<input readonly="readonly" type="hidden"value="${activity.longitude}" id="longitude" /> 
			<input readonly="readonly" type="hidden"value="${activity.latitude}" id="latitude" />
			<input readonly="readonly" type="hidden"value="${id}" id="id" />
</body>
<script type="text/javascript">
	var title = document.getElementById("title").value;
	var latitude = document.getElementById("latitude").value;
	var longitude = document.getElementById("longitude").value;
	//var telephone = document.getElementById("telephone").value;
	var address = document.getElementById("address").value;
	//创建和初始化地图函数：
	function initMap() {
		createMap();//创建地图
		setMapEvent();//设置地图事件
		addMapControl();//向地图添加控件
		addMarker();//向地图中添加marker
	}

	//创建地图函数：
	function createMap() {

		var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
		var point = new BMap.Point(longitude, latitude);//定义一个中心点坐标
		map.centerAndZoom(point, 18);//设定地图的中心点和坐标并将地图显示在地图容器中
		window.map = map;//将map变量存储在全局
	}

	//地图事件设置函数：
	function setMapEvent() {
		map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
		map.enableScrollWheelZoom();//启用地图滚轮放大缩小
		map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
		map.enableKeyboard();//启用键盘上下左右键移动地图
	}

	//地图控件添加函数：
	function addMapControl() {
		//向地图中添加缩放控件
		var ctrl_nav = new BMap.NavigationControl({
			anchor : BMAP_ANCHOR_TOP_LEFT,
			type : BMAP_NAVIGATION_CONTROL_ZOOM
		});
		map.addControl(ctrl_nav);
		//向地图中添加缩略图控件
		var ctrl_ove = new BMap.OverviewMapControl({
			anchor : BMAP_ANCHOR_BOTTOM_RIGHT,
			isOpen : 1
		});
		map.addControl(ctrl_ove);
		//向地图中添加比例尺控件
		var ctrl_sca = new BMap.ScaleControl({
			anchor : BMAP_ANCHOR_TOP_LEFT
		});
		map.addControl(ctrl_sca);
	}

	//标注点数组
	var markerArr = [ {
		title : title,
		content :  "地址：" + address,
		point : longitude + "|" + latitude,
		isOpen : 0,
		icon : {
			w : 23,
			h : 26,
			l : 45,
			t : 20,
			x : 6,
			lb : 5
		}
	} ];
	//创建marker
	function addMarker() {
		for (var i = 0; i < markerArr.length; i++) {
			var json = markerArr[i];
			var p0 = json.point.split("|")[0];
			var p1 = json.point.split("|")[1];
			var point = new BMap.Point(p0, p1);
			var iconImg = createIcon(json.icon);
			var marker = new BMap.Marker(point, {
				icon : iconImg
			});
			var iw = createInfoWindow(i);
			var label = new BMap.Label(json.title, {
				"offset" : new BMap.Size(json.icon.lb - json.icon.x + 10, -20)
			});
			marker.setLabel(label);
			map.addOverlay(marker);
			label.setStyle({
				borderColor : "#808080",
				color : "#333",
				cursor : "pointer"
			});

			(function() {
				var index = i;
				var _iw = createInfoWindow(i);
				var _marker = marker;
				_marker.addEventListener("click", function() {
					this.openInfoWindow(_iw);
				});
				_iw.addEventListener("open", function() {
					_marker.getLabel().hide();
				})
				_iw.addEventListener("close", function() {
					_marker.getLabel().show();
				})
				label.addEventListener("click", function() {
					_marker.openInfoWindow(_iw);
				})
				if (!!json.isOpen) {
					label.hide();
					_marker.openInfoWindow(_iw);
				}
			})()
		}
	}
	//创建InfoWindow
	function createInfoWindow(i) {
		var json = markerArr[i];
		var iw = new BMap.InfoWindow(
				"<b class='iw_poi_title' title='" + json.title + "'>"
						+ json.title + "</b><div class='iw_poi_content'>"
						+ json.content + "</div>");
		return iw;
	}
	//创建一个Icon
	function createIcon(json) {
		var icon = new BMap.Icon(
				"http://app.baidu.com/map/images/us_mk_icon.png",
				new BMap.Size(json.w, json.h), {
					imageOffset : new BMap.Size(-json.l, -json.t),
					infoWindowOffset : new BMap.Size(json.lb + 5, 1),
					offset : new BMap.Size(json.x, json.h)
				})
		return icon;
	}

	//initMap();//创建和初始化地图
</script>
</html>

