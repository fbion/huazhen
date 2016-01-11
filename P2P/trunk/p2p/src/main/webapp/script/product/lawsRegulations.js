$(function () {
	if($("#pageAlias").val()=="lawsRegulations"||$("#pageAlias").val()=="lawsRegulationsContent"){
		$("#lawsRegulations").attr("class", "active");
	}
	$("#header").find("a").removeClass("active");
	$("#security").attr("class", "active");
 });