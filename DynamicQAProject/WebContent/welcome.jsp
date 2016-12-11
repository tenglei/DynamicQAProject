<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<title>问者</title>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->


</head>
<body>

	<!-- Header -->
	<section id="header">
		<header>
			<h1>问者时代</h1>
			<p>BY HIT</p>
		</header>
		<footer>
			<a href="#banner" class="button style2 scrolly-middle">何为问者</a>
		</footer>
	</section>

	<!-- Banner -->
	<section id="banner">
		<header>
			<h2>路漫漫而修远兮</h2>
		</header>
		<p>
			<br />你还在为找不到调查网站而烦恼吗？ <br />
		</p>
		<footer>
			<a href="#first" class="button style2 scrolly">然而</a>
		</footer>
	</section>

	<!-- Feature 1 -->
	<article id="first" class="container box style1 right">
		<a href="#" class="image fit"><img src="images/pic01.jpg" alt="" /></a>
		<div class="inner">
			<header>
				<h2>
					在这里<br /> 您能自定义自己的问卷
				</h2>
			</header>
			<p>问者提供了丰富多样的问卷形式，面对各个群体，您可以按照您的喜好自定义问卷内容</p>
		</div>
	</article>

	<!-- Feature 2 -->
	<article class="container box style1 left">
		<a href="#" class="image fit"><img src="images/pic02.jpg" alt="" /></a>
		<div class="inner">
			<header>
				<h2>
					在这里<br /> 您能选择投放问卷的人群
				</h2>
			</header>
			<p>总是烦恼如何高效地投放问卷？不用担心，问者可以将您的问卷精确地投放至相应的群体，保证问卷的高效率</p>
		</div>
	</article>

	<!-- Portfolio -->
	<article class="container box style2">
		<header>
			<h2>使用场景</h2>
			<p>许多时候我们需要对特定的人群进行调查问卷，比如：</p>
		</header>
		<div class="inner gallery">
			<div class="row 0%">
				<div class="3u 12u(mobile)">
					<a href="images/fulls/01.jpg" class="image fit"><img
						src="images/thumbs/01.jpg" alt="" title="学生" /></a>
				</div>
				<div class="3u 12u(mobile)">
					<a href="images/fulls/02.jpg" class="image fit"><img
						src="images/thumbs/02.jpg" alt="" title="农民" /></a>
				</div>
				<div class="3u 12u(mobile)">
					<a href="images/fulls/03.jpg" class="image fit"><img
						src="images/thumbs/03.jpg" alt="" title="游乐园" /></a>
				</div>
				<div class="3u 12u(mobile)">
					<a href="images/fulls/04.jpg" class="image fit"><img
						src="images/thumbs/04.jpg" alt=""
						title="小商店" /></a>
				</div>
			</div>
			<div class="row 0%">
				<div class="3u 12u(mobile)">
					<a href="images/fulls/05.jpg" class="image fit"><img
						src="images/thumbs/05.jpg" alt="" title="白领" /></a>
				</div>
				<div class="3u 12u(mobile)">
					<a href="images/fulls/06.jpg" class="image fit"><img
						src="images/thumbs/06.jpg" alt="" title="企业" /></a>
				</div>
				<div class="3u 12u(mobile)">
					<a href="images/fulls/07.jpg" class="image fit"><img
						src="images/thumbs/07.jpg" alt="" title="高校" /></a>
				</div>
				<div class="3u 12u(mobile)">
					<a href="images/fulls/08.jpg" class="image fit"><img
						src="images/thumbs/08.jpg" alt=""
						title="艺术家" /></a>
				</div>
			</div>
		</div>
	</article>

	<!-- Contact -->
	<article class="container box style3">
		<header>
			<h2>立马开始问者之旅</h2>
			<p>请输入相应信息完成注册</p>
		</header>
		<form method="get" action="registe.action" id="loginClick">
			<div class="row 50%">

				<div class="6u 12u$(mobile)" style="align:center">
					<input type="text" id="loginName" class="text" name="name" placeholder="请输入姓名" style="text-align:center"/>
				</div>
				<div class="6u$ 12u$(mobile)">
					<input type="text" id="loginEmail" class="text" name="email" placeholder="请输入邮箱" style="text-align:center"/>
				</div>
				<div class="6u 12u$(mobile)">
					<input type="password" id="loginPW" class="text" name="password" placeholder="请输入密码" style="text-align:center"/>
				</div>
				<div class="6u$ 12u$(mobile)">
					<input type="password" id="repeatPW" class="text" name="confirmpassword"
						placeholder="再次输入确认密码" style="text-align:center"/>
				</div>
			</div>
			<p></p>
			<div class="12u$">
				<ul class="actions">
					<li><input type="button" value="注册" id="submitBtn" /></li>
				</ul>

				<p></p>
				<p></p>
				<ul class="actions">
					<a href="#login" class="button scrolly">已有账号？</a>
				</ul>

			
			</div>
		</form>

	</article>
			
			
			
    <article id = "login" class="container box style3">
		<header>
			<p>赶紧来登录吧！</p>
		</header>
		<form method="post" action="login.action" id="signUp">
			<div class="row 50%">
				<div class="6u 12u$(mobile)" style="align:center">
					<input type="text" class="text" id="signName" name="logininfor"  placeholder="请输入注册名" style="text-align:center"/>
				</div>
				<div class="6u$ 12u$(mobile)">
					<input type="password" class="text" id="signPW" name="loginpassword" placeholder="请输入密码" style="text-align:center"/>
				</div>
			</div>
			<p></p>
			<div class="12u$">
				<ul class="actions">
					<li><input type="button" id="signBtn" value="登录"  /></li>
				</ul>
			</div>
			
		</form>

	</article>
	
	
	

	<section id="footer">
		
		<div class="copyright">
			<ul class="menu">
				<li>&copy; 版权所有</li>
			</ul>
		</div>
	</section>
<%-- 	<script > --%>
<!-- // // 	$("#clickBtn").on("click", function() { -->
<!-- // // 		alert($("#logName").val()); -->
<!-- // // 	}); -->
<%-- 	</script> --%>
	

	<!-- Scripts -->
	
	
	<script src="assets/js/jquery-1.7.1.min.js"></script>
	<script src="assets/js/slicy.js"></script>
	<script src="js/prettify.js"></script>
	<script src="js/docs.js"></script>
	
	
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.poptrox.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

<%-- <script type="text/javascript"> --%>
<!-- $(document).ready(function() { -->
<!-- 	alert("ready"); -->
<!-- }); -->
<!-- // function validate_required(field,alerttxt) -->
<!-- // { -->
<!-- // 	with (field) -->
<!-- // 	{ -->
<!-- // 		if(value==null||value=="") -->
<!-- // 		{ -->
<!-- // 			alert(alerttxt); -->
<!-- // 			return false; -->
<!-- // 		} -->
<!-- // 		else -->
<!-- // 		{ -->
<!-- // 			return true;	 -->
<!-- // 		} -->
<!-- // 	} -->
<!-- // } -->
<!-- // function validate_form(thisform) -->
<!-- // { -->
<!-- // 	with(thisform) -->
<!-- // 	{ -->
<!-- // 		if(validate_required(logininfor,"用户名或者密码不能是空的！")==false) -->
<!-- // 		{ -->
<!-- // 			return false; -->
<!-- // 		} -->
<!-- // 		else if(validate_required(loginpassword,"用户名或者密码不能是空的！")==false) -->
<!-- // 		{ -->
<!-- // 			return false;	 -->
<!-- // 		} -->
<!-- // 	} -->
<!-- // } -->
<!-- // function validate_form2(thisform) -->
<!-- // { -->
<!-- // 	with(thisform) -->
<!-- // 	{ -->
		
		
<!-- // 		if(validate_required(name,"请确认所有信息不为空！")==false) -->
<!-- // 		{ -->
<!-- // 			return false; -->
<!-- // 		} -->
<!-- // 		else if(validate_required(email,"请确认所有信息不为空！")==false) -->
<!-- // 		{ -->
<!-- // 			alert("in"); -->
<!-- // 			var testName=$("#logName").val(); -->
<!-- // 			alert(testName); -->
<!-- // 			alert("out"); -->
<!-- // 			return false;	 -->
<!-- // 		} -->
<!-- // 		else if(validate_required(password,"请确认所有信息不为空！")==false) -->
<!-- // 		{ -->
<!-- // 			return false;	 -->
<!-- // 		} -->
<!-- // 		else if(validate_required(confirmpassword,"请确认所有信息不为空！")==false) -->
<!-- // 		{ -->
<!-- // 			return false;	 -->
<!-- // 		} -->
		
<!-- // 		alert("注册成功！快快登录吧！"); -->
<!-- // 	} -->
<!-- // } -->

<%-- </script> --%>
<script src="js/login.js"></script>
</body>
</html>