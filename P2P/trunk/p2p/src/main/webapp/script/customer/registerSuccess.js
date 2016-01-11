

var countdown;
var RegisterSuccess = {
	settimeToload	: function (){
		if (countdown == 0) {
			window.location.href =  $Url.BuildWWWUrl("/customer/login");
			return;
		} else {
			$("#second").html(countdown);
			countdown--;
		}
		setTimeout(function() {RegisterSuccess.settimeToload()},1000);
	}	
};

$(document).ready(function () {
	Banner.GetBanner($(".p2pBanner1"),2);
	if($("#second").length>0){
		countdown = parseInt($("#second").html());
		RegisterSuccess.settimeToload();
	}
    
});