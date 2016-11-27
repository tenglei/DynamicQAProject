/**
 * 
 */
$(document).ready(function() {
	var friendsNum = document.getElementById("friendsNum");
	var questionsNum = document.getElementById("questionsNum");
	for (var i = 1; i < friendsNum.value; i++) {
		var friend = "friend";
		var block = "block";
		friend = friend + i;
		block = block + 1;
		$("#friend"+i).css("display", "none");
		$("#block"+i).css("display", "none");
		
	}
	$("#myques").on("click", function() {
		for (var i = 1; i < friendsNum.value; i++) {
			var friend = "friend";
			var block = "block";
			friend = friend + i;
			block = block + 1;
			$("#friend"+i).css("display", "none");
			$("#block"+i).css("display", "none");
		}
		$("#userHome").css("display", "block");
		$("#userDy").css("display", "block");
		$("#mypadder").css("display", "block");
		for (var i = 1; i < questionsNum.value; i++) {
			var userQ = "userQ";
			userQ = userQ + i;
			$("#userQ"+i).css("display", "block");
		}
	});
	$("#myfriends").on("click", function() {

		$("#userHome").css("display", "none");
		$("#userDy").css("display", "none");
		$("#mypadder").css("display", "none");
		for (var i = 1; i < questionsNum.value; i++) {
			var userQ = "userQ";
			userQ = userQ + i;
			$("#userQ"+i).css("display", "none");
		}
		for (var i = 1; i < friendsNum.value; i++) {
			var friend = "friend";
			var block = "block";
			friend = friend + i;
			block = block + 1;
			$("#friend"+i).css("display", "block");
			$("#block"+i).css("display", "block");
		}

	});

});