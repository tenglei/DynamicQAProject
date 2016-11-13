<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="css/show.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/main.css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷填写</title>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- load stylesheets -->
<!-- Google web font "Open Sans" -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Bootstrap style -->
<link rel="stylesheet" href="css/templatemo-style.css">
<!-- Templatemo style -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->

</head>
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.sticky.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/site.js"></script>
<body>


	<div class="row navbar-row">
		<div
			class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 navbar-container">

			<a href="javascript:void(0)" class="navbar-brand" id="go-to-top">问者</a>

			<nav class="navbar navbar-full">

			<div class="collapse navbar-toggleable-md" id="tmNavbar">

				<ul class="nav navbar-nav">
					<li class="nav-item"><a class="nav-link" id="wenjuan"
						href="#tm-section-1"><s:property value="wenjuanhao" /></a></li>
					<li class="nav-item"><a class="nav-link" href="#tm-section-1"
						id="ath"><s:property value="author" /></a></li>
					<li class="nav-item"><a class="nav-link" id="finish"
						href="#tm-section-1">完成修改</a></li>
					<li class="nav-item"><a class="nav-link" id="back"
						href="#tm-section-1" onclick="location='index.html' ">返回主页</a></li>
				</ul>

			</div>

			</nav>

			<button class="navbar-toggler hidden-lg-up" type="button"
				data-toggle="collapse" data-target="#tmNavbar">&#9776;</button>
		</div>
	</div>
	<div class="container">
		<div class="tm-page-content">

			<div class="row clearfix">
				
					<input type="hidden" id="seleth"
						name="<s:property value="choiceques.size()"/>" /> <input
						type="hidden" id="fillth"
						name="<s:property value="fillques.size()"/>" /> <input
						type="hidden" id="qath" name="<s:property value="ques.size()"/>" />
					<div class="row">
						<s:iterator value="choiceques" status="st">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input type="text" name="choiceques" class="form-control"
											value="<s:property />" />
										<p>
											<s:property value="choicescore[#st.index]" />分
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<input type="radio" checked="checked"
											name="as<s:property value="#st.index"/>" value="A" /> A
										<s:property value="ansA[#st.index]" />
										<input type="radio" checked="checked"
											name="as<s:property value="#st.index"/>" value="B" /> B
										<s:property value="ansB[#st.index]" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<input type="radio" checked="checked"
											name="as<s:property value="#st.index"/>" value="C" /> C
										<s:property value="ansC[#st.index]" />
										<input type="radio" checked="checked"
											name="as<s:property value="#st.index"/>" value="D" /> D
										<s:property value="ansD[#st.index]" />
									</div>
								</div>
							</div>
						</s:iterator>
					</div>
					<div class="row">
						<s:iterator value="fillques" status="st">
							<div class="row">

								<div class="col-md-12">
									<div class="form-group">
										<input type="text" name="fillques" class="form-control"
											value="<s:property />" />
										<p>
											<s:property value="fillscore[#st.index]" />分
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input type="text" name="fillquesans" class="form-control"
											id="fillans<s:property value="#st.index"/>" />
									</div>
								</div>
							</div>
						</s:iterator>
					</div>

					<div class="row">
						<s:iterator value="ques" status="st">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input type="text" name="qause" class="form-control"
											value="<s:property />" />
										<p>
											<s:property value="quesscore[#st.index]" />分
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input type="text" name="qauesans" class="form-control"
											id="quesans<s:property value="#st.index"/>" />
									</div>
								</div>
							</div>
						</s:iterator>
					</div>

				</div>
			</div>
		</div>

		<!-- #home -->


		<!-- load JS files -->

		<script src="js/jquery-1.11.3.min.js"></script>
		<!-- jQuery (https://jquery.com/download/) -->
		<script src="js/tether.min.js"></script>
		<!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
		<script src="js/bootstrap.edit.js"></script>
		<!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
		<script src="js/jquery.singlePageNav.min.js"></script>
		<!-- Single Page Nav (https://github.com/ChrisWojcik/single-page-nav) -->

		<!-- Templatemo scripts -->

		<script>
			var bigNavbarHeight = 90;
			var smallNavbarHeight = 68;
			var navbarHeight = bigNavbarHeight;

			$(document).ready(function() {

				var topOffset = 180;

				$(window).scroll(function() {

					if ($(this).scrollTop() > topOffset) {
						$(".navbar-container").addClass("sticky");
					} else {
						$(".navbar-container").removeClass("sticky");
					}

				});

				/* Single page nav
				-----------------------------------------*/

				if ($(window).width() < 992) {
					navbarHeight = smallNavbarHeight;
				}

				$('#tmNavbar').singlePageNav({
					'currentClass' : "active",
					offset : navbarHeight
				});

				$('#tmNavbar').on("click", "a", null, function() {
					$('#tmNavbar').collapse('hide');
				});

				// Handle nav offset upon window resize
				$(window).resize(function() {
					if ($(window).width() < 992) {
						navbarHeight = smallNavbarHeight;
					} else {
						navbarHeight = bigNavbarHeight;
					}

					$('#tmNavbar').singlePageNav({
						'currentClass' : "active",
						offset : navbarHeight
					});
				});

				$('#go-to-top').each(function() {
					$(this).click(function() {
						$('html,body').animate({
							scrollTop : 0
						}, 'slow');
						return false;
					});
				});

			});
		</script>
	
	<script src="js/show.js"></script>
</body>
</html>