/**
 * 
 */
$(document).ready(function() {
	var friendsNum = document.getElementById("friendsNum");
	var questionsNum = document.getElementById("questionsNum");
	var addNum=0;
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
	$("#myCircle").on("click", function() {
		for (var i = 1; i < friendsNum.value; i++) {
			var friend = "friend";
			var block = "block";
			friend = friend + i;
			block = block + 1;
			$("#friend"+i).css("display", "none");
			$("#block"+i).css("display", "none");
		}
		for (var i = 1; i < questionsNum.value; i++) {
			var userQ = "userQ";
			userQ = userQ + i;
			$("#userQ"+i).css("display", "none");
		}
		$("#userHome").css("display", "block");
		$("#userDy").css("display", "block");
		$("#mypadder").css("display", "block");
		
		

	});
	//排名，需调整放入循环
//	var numberOrder=document.getElementById("numberFirst");
//	var First = "第一名:";
//	var Second = "第二名:";
//	var Third = "第三名：";
//	numberOrder.innerHTML=First+"superman";
	//排名，需要在jsp中嵌入
	
//	<script>  
//	var order=new Array();
//	var i=0;	 
//  var li="";
//    <s:iteraor value="#suoyoupaiming" var = "eachOrder">  
//         order[i] = <s:porperty value="#eachOrder" />  
//         i++;  
//    </s:iterator>      //order有可能赋值不成功
//	$(".btn-success").on("click", function() {
//		var name=$(this).attr("name");
//		var listGroup=$("#listGroup")[0];
//		for(i=order[name].size()-1;i>=0;i--){    	
//			li=li+"<li class='list-group-item'><p>" +"第" +
//			i  + "名:  "+
//			order[name][i] +                 //该访问方式可能出错 
//			"</p> " +
//			"<small class='block text-muted'><iclass='fa fa-fw fa-clock-o'></i> 两分钟前</small></li>";
//		}
//		listGroup.innerHTML=li;	
//	});
//	</script>
	
//	var listGroup=$("#listGroup")[0];
//   	
//		li="<li class='list-group-item'><p>" +"第" +
//		"A"  + "名:  "+
//		"</p> " +
//		"<small class='block text-muted'><iclass='fa fa-fw fa-clock-o'></i> 两分钟前</small></li>";
//		
//		
//		li= li+"<li class='list-group-item'><p>" +"第" +
//		"B"  + "名:  "+
//		"</p> " +
//		"<small class='block text-muted'><iclass='fa fa-fw fa-clock-o'></i> 两分钟前</small></li>";
//	 listGroup.innerHTML=li;	

	
	$(".btn-danger").on("click", function() {
		$(this).parent().parent().parent().parent().remove();
	});
	
	
	

});