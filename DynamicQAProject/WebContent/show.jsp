<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷填写</title>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/show.css" rel="stylesheet" />
<link rel="stylesheet" href="css/templatemo-style.css">
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
						id="ath">作者姓名：<s:property value="author" /></a></li>
					<li class="nav-item"><a class="nav-link" id="finish"
						href="">提交</a></li>
					<!--  <li class="nav-item"><a class="nav-link" id="back"
						href="#tm-section-1" onclick="location='index.html' ">返回主页</a></li>-->
				</ul>
			</div>
			</nav>

			<button class="navbar-toggler hidden-lg-up" type="button"
				data-toggle="collapse" data-target="#tmNavbar">&#9776;</button>
		</div>
	</div>
	<div class="container">
	<input type="hidden" id="seleth"
						name="<s:property value="choiceques.size()"/>" /> <input
						type="hidden" id="fillth"
						name="<s:property value="fillques.size()"/>" /> <input
						type="hidden" id="qath" name="<s:property value="ques.size()"/>" />
		<div class="row">
			<div class="contact-form">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<input type="text" class="form-control" value="" />
							<p></p>
							<br>
						</div>
					</div>
				</div>
			</div>
				<s:iterator value="choiceques" status="st">
			<div class="row">
					<div class="contact-form">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<textarea name="choiceques" class="form-control "
										style="height: 75px" readonly="true"><s:property /></textarea>
									<p><s:property value="choicescore[#st.index]" />分</p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input type="radio" checked="checked" name="as<s:property value="#st.index"/>" value="A"
										readonly="true" /> A <input type="text" name="Aques"
										class="form-control" value="<s:property value="ansA[#st.index]" />" readonly="true"/>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="radio" name="as<s:property value="#st.index"/>" value="B" readonly="true" /> B<input
										type="text" name="Bques" class="form-control" value="<s:property value="ansB[#st.index]" />" readonly="true"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input type="radio" name="as<s:property value="#st.index"/>" value="C" readonly="true" /> C <input
										type="text" name="Cques" class="form-control" value="<s:property value="ansC[#st.index]" />" readonly="true"/>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="radio" name="as<s:property value="#st.index"/>" value="D" readonly="true" /> D <input
										type="text" name="Dques" class="form-control" value="<s:property value="ansD[#st.index]" />" readonly="true"/>
								</div>
							</div>
						</div>

					</div>
			</div>
						<p></p>
						<br>
				</s:iterator>
	<s:iterator value="fillques" status="st">
			<div class="row">
				<div class="contact-form">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<textarea name="fillques" class="form-control"
									style="height: 75px" readonly="true" ><s:property /></textarea>
								<p><s:property value="fillscore[#st.index]" />分</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<textarea name="fillquesans" class="form-control textarea"
									rows="3" id="fillans<s:property value="#st.index"/>" placeholder="请输入答案"></textarea>

							</div>
						</div>
					</div>
				</div>
				<p></p>
				<br>
			</div>
			</s:iterator>
		  <s:iterator value="ques" status="st">
			<div class="row">
				<div class="contact-form">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<textarea name="qause" class="form-control"
									style="height: 75px" readonly="true" ><s:property /></textarea>
								<p><s:property value="quesscore[#st.index]" />分</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<textarea name="qauesans" class="form-control textarea" rows="3"
									id="quesans<s:property value="#st.index"/>" placeholder="请输入答案"></textarea>
							</div>
						</div>
					</div>
				</div>
			
			<p></p>
			<br>
			</div>
		</s:iterator>
		</div>
		<input type="text" name="answer" id="answerp" placeholder="请输入您的称呼">
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