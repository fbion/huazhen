

var countdown;
var EmailValidation = {
	settimeToload	: function (){
		if (countdown == 0) {
			window.location.href =  $Url.BuildWWWUrl("/index");
			return;
		} else {
			$("#second").html(countdown);
			countdown--;
		}
		setTimeout(function() {EmailValidation.settimeToload()},1000);
	}	
};

$(document).ready(function () {
	if($("#second").length>0){
		countdown = parseInt($("#second").html());
		EmailValidation.settimeToload();
	}
    
});