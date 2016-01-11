$(function () {
	if($("#pageAlias").val()=="contactUs"){
		$("#contactUs").attr("class", "active");
	}
	Banner.GetBanner($(".p2pBanner1"),2);
 });