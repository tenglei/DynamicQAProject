/**
 * 
 */
$(document).ready(function() {
	var addNum=0;
	var selNum=0;
	var fillNum=0;
	var ansNum=0;
	selectdiv="<div ";
	selectdiv=selectdiv+ "id='select";
	selectdiv=selectdiv+selNum+"'"+"> ";
	selectdiv=selectdiv+"selectTest"
	
	selectdiv=selectdiv+" </div>";
	$("#addSelect").on("click", function() {
		$("#quesList").append(selectdiv);
		
	});
	$("#addFill").on("click", function() {
		
		
		
	});
	$("#addAnswer").on("click", function() {
		
		
		
	});
	

});