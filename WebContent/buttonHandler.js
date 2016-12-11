$( document ).ready(function() {
	
	//$(this).parent().css("background-color", "white");
	//$(this).parent().css("color", "black");
	
	$(".checkToHide").change(function(){
		if($(this).is(":checked")){
			$(this).parent().css("background-color", "white");
			$(this).parent().css("color", "black");
		}else{
			$(this).parent().css("background-color", "green");
			$(this).parent().css("color", "white");
		}
	});
});