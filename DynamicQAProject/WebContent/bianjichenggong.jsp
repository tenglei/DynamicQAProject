<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷编辑成功</title>
<link rel="stylesheet" href="assets/css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link href="css/404style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<!-----start-wrap--------->
	<div class="wrap">
		<!-----start-content--------->
		<div class="content">
			<!-----start-logo--------->
			<div class="logo">
				<h1><a href="#"><img src="images/logo.png"/></a></h1>
				<span><img src="images/signal.png"/>问卷编辑成功，可以邀请朋友来回答！</span>
			</div>
			<!-----end-logo--------->
			<!-----start-search-bar-section--------->
			<div class="buttom">
				<div class="seach_bar">
					<p>问卷回答链接：<s:property value="lianjie"/></p>
					<!-----start-sear-box--------->								
					   <button onclick="location.href='backwithout.action?logininfor=<s:property value="welcomename"/>'"  class="button style2 scrolly-middle">回到主页</button>
				</div>
			</div>
			<!-----end-sear-bar--------->
		</div>
		<!----copy-right-------------->
	</div>
	
	<!---------end-wrap---------->
</body>
</html>