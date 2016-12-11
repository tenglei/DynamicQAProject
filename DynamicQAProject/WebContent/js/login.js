/**
 * 
 */
$(document).ready(function() {
	var name;
	var email;
	var pw;
	var rpw;
	var test1=0;
	var test2=0;
	var test3=0;
	var test4=0;
	$('#loginName').bind('input propertychange', function() {  
		name =$(this).val();
		if($(this).val()==""){
			$("#submitBtn").attr('disabled',true);
			$('#submitBtn').val('请输入姓名和邮箱');
			test1=0;
		}
		else{
			test1=1;
			if(test1==1&&test2==1&&test3==1&&test4==1){
				$("#submitBtn").attr('disabled',false);
				$('#submitBtn').val('注册');
			}
		}
	});
	$('#loginEmail').bind('input propertychange', function() {  
		email = $(this).val();
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		var email=$(this).val();
		if($(this).val()==""){
			$("#submitBtn").attr('disabled',true);
			$('#submitBtn').val('请输入姓名和邮箱');
			test2=0;
		}
		else{
			if(!reg.test(email)){
				$("#submitBtn").attr('disabled',true);
				$('#submitBtn').val('邮箱格式错误');
				test2=0;
			}
			else{
				test2=1;
				if(test1==1&&test2==1&&test3==1&&test4==1){
					$("#submitBtn").attr('disabled',false);
					$('#submitBtn').val('注册');
				}
			}
		}
	});
	$('#loginPW').bind('input propertychange', function() {  
		pw = $(this).val();
		if($(this).val()==""){
			$("#submitBtn").attr('disabled',true);
			$('#submitBtn').val('请输入密码');
			test3=0;
		}
		else if(rpw==""){
			$("#submitBtn").attr('disabled',true);
			$('#submitBtn').val('请再次输入密码');
		}
		else{
			test3=1;
			if(test1==1&&test2==1&&test3==1&&test4==1){
				$("#submitBtn").attr('disabled',false);
				$('#submitBtn').val('注册');
			}
		}
	});
	$('#repeatPW').bind('input propertychange', function() {  
		rpw = $(this).val();
		if($(this).val()==""){
			$("#submitBtn").attr('disabled',true);
			$('#submitBtn').val('请再次输入密码');
			test4=0;
		}
		else if(pw!=rpw){
			$("#submitBtn").attr('disabled',true);
			$('#submitBtn').val('两次输入密码不一致，请重新输入');
			test4=0;
		}
		else{
			test4=1;
			if(test1==1&&test2==1&&test3==1&&test4==1){
				$("#submitBtn").attr('disabled',false);
				$('#submitBtn').val('注册');
			}
		}
	});
	$("#submitBtn").on("click", function() {
		if(test1==1&&test2==1&&test3==1&&test4==1){
			$.ajax({
				type:"post",
				url:"excuteAjaxJsonAction",
				data:{
					Name:name,
					Email:email,
				    Password:pw,
				    RPassword:rpw
				},
				dataType:"json",
				success:function(data){
					alert("注册成功");
					$('#signUp').trigger("click");
				},
				error:function(){
					alert("系统异常，请稍后重试！");
				}//这里不要加","
			});
		}
	});
	var signTest1=0;
	var signTest2=0;
	var signName;
	var signPW;
	$('#signName').bind('input propertychange', function() {
		signName=$(this).val();
		if($(this).val()==""){
			$("#signBtn").attr('disabled',true);
			$('#signBtn').val('请输入姓名或邮箱');
			signTest1=0;
		}
		else{
			signTest1=1;
			if(signTest1==1&&signTest2==1){
				$("#signBtn").attr('disabled',false);
				$('#signBtn').val('登录');
			}
		}
	});
	$('#signPW').bind('input propertychange', function() { 
		signPW=$(this).val();
		if($(this).val()==""){
			$("#signBtn").attr('disabled',true);
			$('#signBtn').val('请输入密码');
			signTest2=0;
		}
		else{
			signTest2=1;
			if(signTest1==1&&signTest2==1){
				$("#signBtn").attr('disabled',false);
				$('#signBtn').val('登录');
			}
		}
		
	});
	$("#signBtn").on("click", function() {
		if(signTest1==1&&signTest2==1){
			
			$.ajax({
				type:"post",
				url:"excuteAjaxJsonAction",
				data:{
					Name:signName,
					Password:signPW,
				},
				dataType:"json",
				success:function(data){
					
				},
				error:function(){
					alert("系统异常，请稍后重试！");
				}//这里不要加","
			});
		}
		
	});
	
});