<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编辑问题</title>
<link rel="stylesheet" type="text/css" href="css/dist/css/bootstrap.css" />
<link rel="stylesheet" href="skins/eden.css" media="screen">
<link rel="stylesheet" href="style.css" media="screen">
<link href="fonts/icons/icons.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
</head>
<body id="featured-slider-container-edit" > 
<input type="hidden" id="author" name="<s:property value="authorname"/>"/>
<input type="hidden" id="base" name="<s:property value="basename"/>"/>
<section class="header-area-home" id="header-area-home" >
		<div id="main-nav-container">
			<div class="container">
				<nav class="navbar navbar-eden" id="topnav">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#main-menu">
								<span class="sr-only">Toggle navigation</span> <i
									class="tn-menu"></i>
							</button>
							<a class="navbar-brand" href="#" id="go-to-top"><img src="images/indexlogo.png" /></a>
						</div>

						<div class="collapse navbar-collapse" id="main-menu">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#top">您好<s:property value="authorname"/></a></li>
								<li><a ></a></li>
								<li><a ></a></li>
								<li><a ></a></li>
								<li><a ></a></li>
								<li ><a href="#selectQ" id="addSelect">选择题</a></li>
								<li><a href="#fillQ" id="addFill">填空题</a></li>	
								<li><a href="#answerQ" id="addAnswer">问答题</a></li>		
								<li><a href="#finish" id="finish">完成编辑</a></li>																										
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</section>
	<form action="finishedit.action" method="post" id = "tab_form" name="myform" class="form-inline">
	<div style="position:relative;left:400px;bottom:-100px">
	<input class="form-control" type="text" name="wenjuanname" placeholder="请输入问卷名称" style="width:500px;" /><br>
	<br>
	请选择问卷类型：<select class="form-control" id="selectKind" name="selectKind" style='width:100px;'>
        <option value="college" selected="selected">大学</option>   
        <option value="emotion">情感</option>   
        <option value="life">生活</option>         
      </select>   
	</div>
	<fieldset>
	<div id="quesList" style="position:relative;left:200px;bottom:-150px;">
	<br>
	</div>
	</fieldset>
	</form>
<script src="css/dist/js/jquery.min.js"></script>
<script src="js/newEdit.js"></script>
<script src="css/dist/js/bootstrap.min.js"></script>
<script src="js/jquery.sticky.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/site.js"></script>
</body>
</html>