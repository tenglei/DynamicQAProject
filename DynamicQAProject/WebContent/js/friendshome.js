/**
 * 
 */
$(document).ready(function() {
	
	var friendsNum = document.getElementById("friendsNum");
	var questionsNum = document.getElementById("questionsNum");
	var circleTmp=$("#circleTmp").val();
	circleTmp = circleTmp.substring(1,circleTmp.length-1);
	//alert("circleTmp");
	//alert(circleTmp);
	var addNum=0;
	var myQuesNum =$("#myQuesNum").val();
	//alert(myQuesNum);
	var newQA = document.createElement("form");
	document.body.appendChild(newQA);
	newQA.action="addnewqa.action";
	newQA.method="post";
	////alert("ready");
	$("#newQA").on("click", function() {
	////alert("inqa");
	var welcomename = $("#comename").text();
//	////alert(welcomename);
	
	var tmp = document.createElement("input");
	tmp.setAttribute("name", "authorname");
	tmp.setAttribute("type", "hidden");
	tmp.setAttribute("value", welcomename); //有可能只是一个内存地址，解决办法，拼接字符串即可，待定
	newQA.appendChild(tmp);
	newQA.submit();
	});
	
	for (var i = 0; i < friendsNum.value; i++) {
		var friend = "friend";
		var block = "block";
		friend = friend + i;
		block = block + 1;
		$("#friend"+i).css("display", "none");
		$("#block"+i).css("display", "none");
		
	}
	if(myQuesNum==0){
		//alert("hidden");
		for (var i = 0; i <=questionsNum.value; i++) {
			var userQ = "userQ";
			userQ = userQ + i;
			$("#userQ"+i).css("display", "none");
		}
	}
	else{
		$("#initQues").css("display", "none");
	}
	$("#circleQues").css("display", "none");
	$("#myques").on("click", function() {
		if(myQuesNum==1){		
			$("#circleQues").css("display", "none");
			for (var i = 0; i < friendsNum.value; i++) {
				var friend = "friend";
				var block = "block";
				friend = friend + i;
				block = block + 1;
				$("#friend"+i).css("display", "none");
				$("#block"+i).css("display", "none");
			}
			$("#initQues").css("display", "none");
			$("#userHome").css("display", "block");
			$("#userDy").css("display", "block");
			$("#mypadder").css("display", "block");
			for (var i = 0; i <=questionsNum.value; i++) {
				var userQ = "userQ";
				userQ = userQ + i;
				$("#userQ"+i).css("display", "block");
			}
		}
		else{
			$("#circleQues").css("display", "none");
			for (var i = 0; i < friendsNum.value; i++) {
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
			for (var i = 0; i <=questionsNum.value; i++) {
				var userQ = "userQ";
				userQ = userQ + i;
				$("#userQ"+i).css("display", "none");
			}
			$("#initQues").css("display", "block");
		
		}
	});
	$("#myfriends").on("click", function() {
		$("#circleQues").css("display", "none");
		$("#userHome").css("display", "none");
		$("#userDy").css("display", "none");
		$("#mypadder").css("display", "none");
		for (var i = 0; i <=questionsNum.value; i++) {
			var userQ = "userQ";
			userQ = userQ + i;
			$("#userQ"+i).css("display", "none");
		}
		$("#initQues").css("display", "none");
		for (var i = 0; i < friendsNum.value; i++) {
			var friend = "friend";
			var block = "block";
			friend = friend + i;
			block = block + 1;
			$("#friend"+i).css("display", "block");
			$("#block"+i).css("display", "block");
		}

	});
	$("#myCircle").on("click", function() {
//		//alert("sss");
		for (var i = 0; i < friendsNum.value; i++) {
			var friend = "friend";
			var block = "block";
			friend = friend + i;
			block = block + 1;
			$("#friend"+i).css("display", "none");
			$("#block"+i).css("display", "none");
		}
		for (var i = 0; i <= questionsNum.value; i++) {
			var userQ = "userQ";
			userQ = userQ + i;
			$("#userQ"+i).css("display", "none");
		}
		$("#userHome").css("display", "block");
		$("#userDy").css("display", "block");
		$("#mypadder").css("display", "block");
		if(myQuesNum==1){
			$("#circleQues").css("display", "block");
			$("#initQues").css("display", "none");
		}
		else{
			$("#initQues").css("display", "block");
		}
//		//alert("ppp");

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
//			"<small class='block text-muted'><iclass='fa fa-fw fa-clock-o'></i>  </small></li>";
//		}
//		listGroup.innerHTML=li;	
//	});
//	</script>
	
//	var listGroup=$("#listGroup")[0];
//   	
//		li="<li class='list-group-item'><p>" +"第" +
//		"A"  + "名:  "+
//		"</p> " +
//		"<small class='block text-muted'><iclass='fa fa-fw fa-clock-o'></i>  </small></li>";
//		
//		
//		li= li+"<li class='list-group-item'><p>" +"第" +
//		"B"  + "名:  "+
//		"</p> " +
//		"<small class='block text-muted'><iclass='fa fa-fw fa-clock-o'></i>  </small></li>";
//	 listGroup.innerHTML=li;	
	var orderTmp=$("#orderList").val();
	
	orderTmp=orderTmp.substring(1,orderTmp.length-1);
	var orderList = new Array();
	var n=0;
	for(i=0;i<orderTmp.length;i++){		
		if(orderTmp[i]=='['){
			i++;
			orderList[i]=new Array();
			var tmp="";
			while(orderTmp[i]!=']'){
				tmp = tmp+orderTmp[i];
				i++;
			}
			orderList[n]=tmp;
			n++;			
		}
	}
	var tmp = new Array();
	for(i=0;i<n;i++){
		tmp[i] = new Array();
		tmp[i] = orderList[i].split(',');
	}
	var mycircleTmp= new Array();
	mycircleTmp=circleTmp.split(',');
	//alert(mycircleTmp);
	$(".btn-success").on("click", function() {
		var li = "";
		var name=$(this).attr("name");
		
		if(name=="circleOrder"){
			$("#listGroup").children().remove();
			for(i=0;i<mycircleTmp.length;i++){
				i++;
				li=li+"<li class='list-group-item' id='order'" + i+
				"><p>" +"第" +
				i + "名:  "+
				mycircleTmp[i-1] +                 //该访问方式可能出错 
				"</p> " +
				"</li>";
				i--;
			}
			$("#listGroup").append(li);
		}
		else{	
			$("#listGroup").children().remove();
			//alert(tmp[name]);
			if(tmp[name]==""){
				$("#listGroup").children().remove();
			}
			else{
				
				for(i=0;i<tmp[name].length;i++){
					i++;
					li=li+"<li class='list-group-item' id='order'" + i+
					"><p>" +"第" +
					i + "名:  "+
					tmp[name][i-1] +                 //该访问方式可能出错 
					"</p> " +
					"</li>";
					i--;
				}
				$("#listGroup").append(li);
			}
		}
	});
	
	
	
	
	
	$(".btn-danger").on("click", function() {
		var delName = $(this).attr("name");
//		//alert(delName);
		$(this).parent().parent().parent().parent().remove();	
		$.ajax({
			type:"post",
			url:"deleteqa.action",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
			data:{
				name:delName
  				}
		});
	});
	
	var f = document.createElement("form");
	document.body.appendChild(f);
	$("#logout1").on("click", function() {
		f.appdenChild(i);
		f.submit();
	});
	
	$("#lookAround").on("click", function() {
		////alert("in lookAround");
		var user = document.createElement("form");
		var welcomename=$("#mylookAround").text();
		document.body.appendChild(user);
		user.method = 'post';
		user.action = 'goindex.action';
		var tmp = document.createElement("input");
		tmp.setAttribute("name", "welcomename");
		tmp.setAttribute("type", "hidden");
		tmp.setAttribute("value", welcomename); //有可能只是一个内存地址，解决办法，拼接字符串即可，待定
		////alert(welcomename);
		user.appendChild(tmp);
		user.submit()
	});
});