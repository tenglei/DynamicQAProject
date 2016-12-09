<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta charset="UTF-8">
<title>编辑问题</title>
<link rel="stylesheet" type="text/css" href="css/dist/css/bootstrap.css" />
<link rel="stylesheet" href="skins/eden.css" media="screen">
<link rel="stylesheet" href="style.css" media="screen">
<link href="fonts/icons/icons.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
</head>
<body id="featured-slider-container-edit" > 
<input type="hidden" id="wenjuanname" value=""/>
<input type="hidden" id="choiceques" value="qq,aa"/>
<input type="hidden" id="ansA" value="qq,qq"/>
<input type="hidden" id="ansB" value="qq,qq"/>
<input type="hidden" id="ansC" value="qq,qq"/>
<input type="hidden" id="ansD" value="qq,qq"/>
<input type="hidden" id="choicescore" value="2,3"/>
<input type="hidden" id="fillques" value="qq,qq"/>
<input type="hidden" id="fillscore" value="3,4"/>
<input type="hidden" id="fillAns" value="qq,qq"/>
<input type="hidden" id="ques" value="qq,qq"/>
<input type="hidden" id="quesscore" value="5,6"/>
<input type="hidden" id="listTmp" value="1,2,3,1,2,3"/>
<input type="hidden" id="wenjuanclass" value="学校"/>
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
								<li class="active"><a href="#top">您好,XXX</a></li>
								<li><a ></a></li>
								<li><a ></a></li>
								<li><a ></a></li>
								<li><a ></a></li>
								<li><a href="#finish" id="finish">完成</a></li>																										
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</section>
	<form action="editAction" method="post" id = "tab_form" name="myform" class="form-inline">
	<div style="position:relative;left:400px;bottom:-100px;">
	<input class="form-control" type="text" id="answerName" style='width:500px;' placeholder="请输入您的称呼" /><br>
	<br>
	问卷类型：  
	</div>
	<fieldset>
	<div id="quesList" style="position:relative;left:350px;bottom:-150px;">
	<br>
	</div>
	</fieldset>
	</form>
<script src="css/dist/js/jquery.min.js"></script>
<script src="js/newShow.js"></script>
<script src="css/dist/js/bootstrap.min.js"></script>
<script src="js/jquery.sticky.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/site.js"></script>
</body>
</html>