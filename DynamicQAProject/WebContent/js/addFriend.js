/**
 * 
 */
$(document).ready(function() {
	$(".btn-primary").on("click", function() {
		var Name=$(this).parent().parent().find(".panel-header").children(".user").text();	
		var Author=$("#welcomename").val();
		alert(Name);
		alert(Author);
		$(this).attr('disabled',true);
		$(this).text("添加成功");
				$.ajax({
					type:"post",
					url:"add.action",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
					data:{
						name:Name,
						author:Author
          				}
//						,
//					dataType:"json",//设置需要返回的数据类型
//					success:function(data){
//						var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
//						//得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来		
//						$("#s_name").text(""+d.name+"");
//						$("#s_age").text(""+d.age+"");
//						$("#s_position").text(""+d.position+"");
//						var getName=d.name;
//						$(this).parent().parent().find(".panel-header").children(".user").text(""+getName+"");
//					},
//					error:function(){
//						alert("系统异常，请稍后重试！");
//					}//这里不要加","
				});
			});
		
		
		

	
});