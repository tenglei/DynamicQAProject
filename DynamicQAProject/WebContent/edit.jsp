<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编辑问卷</title>
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
						<li class="nav-item"><a class="nav-link" id="xuanze"
							href="#tm-section-1">选择题</a></li>
						<li class="nav-item"><a class="nav-link" href="#tm-section-1"
							id="tiankong">填空题</a></li>
						<li class="nav-item"><a class="nav-link" id="wenda"
							href="#tm-section-1">问答题</a></li>
						<li class="nav-item"><a class="nav-link" id="finish"
						    href="#tm-section-1"
							onclick="location='index.html' ">完成编辑</a></li>
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
				<div class="col-md-12 table-responsive">
				<form action="" method="post" id = "tab_form" name="myform">
					<table class="table table-bordered table-hover table-sortable"
						id="tab_logic">
						<tbody>
							<tr id='bddr0' data-id="0" hidden="hidden">
								<td colspan="5" data-name="ques" align="center"><input
									type="text" name="ques0" class="form-control" placeholder="题目">
								</td>
								<td colspan="5" data-name="kongge" align="center"><input
									type="text" name="kongge0" class="form-control"
									placeholder="关键词"></td>
								<td colspan="5" data-name="score" align="center"><input
									type="text" name="score0" class="form-control" placeholder="分数">
								</td>
							</tr>
						</tbody>
						<tbody>
							<tr id='addr0' data-id="0" hidden="hidden">
								<td colspan="4" data-name="desc"><textarea name="desc0"
										placeholder="问题描述" class="form-control"></textarea></td>
								<td data-name="del">
									<button class="btn row-remove">删除</button>
								</td>
								<td data-name="add">
									<button class="btn row-add">添加</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
					<table class="table table-bordered table-hover table-sortable"
						id="tab_select">

						<tbody>
							<tr id='bddr0' data-id="0" hidden="hidden">
								<td colspan="5" data-name="ques"><input type="text"
									name="ques0" class="form-control" placeholder="题目"></td>
								<td colspan="5" data-name="key" align="center"><input
									type="text" name="key0" class="form-control"
									placeholder="答案"></td>
								<td colspan="5" data-name="score" align="center"><input
									type="text" name="score0" class="form-control" placeholder="分数">
								</td>
							</tr>
						</tbody>
						<tbody>
							<tr id='addr0' data-id="0" hidden="hidden">
								<td data-name="select0"><textarea name="select00"
										placeholder="选项一" class="form-control"></textarea></td>
								<td data-name="select1"><textarea name="select01"
										placeholder="选项二" class="form-control"></textarea></td>
								<td data-name="select2"><textarea name="select02"
										placeholder="选项三" class="form-control"></textarea></td>
								<td data-name="select3"><textarea name="select03"
										placeholder="选项四" class="form-control"></textarea></td>
								<td data-name="del">
									<button class="btn row-remove ">删除</button>

								</td>
								<td data-name="add">
									<button class="btn row-add">添加</button>
								</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-bordered table-hover table-sortable"
						id="tab_tiankong">
						<tbody>
							<tr id='bddr0' data-id="0" hidden="hidden">
								<td colspan="5" data-name="key" align="center"><input
									type="text" name="key0" class="form-control" placeholder="答案">
								</td>
								<td colspan="5" data-name="kongge" align="center"><input
									type="text" name="kongge0" class="form-control"
									placeholder="空格数量"></td>
								<td colspan="5" data-name="score" align="center"><input
									type="text" name="score0" class="form-control"
									placeholder="空格数量"></td>

							</tr>
						</tbody>

						<tbody>
							<tr id='addr0' data-id="0" hidden="hidden">
								<td colspan="4" data-name="select0"><textarea
										name="select00" placeholder="请输入填空题题目（技术限制，需要全部手动输入）"
										class="form-control"></textarea></td>
								<td data-name="del">
									<button class="btn row-remove">删除</button>
								</td>
								<td data-name="add">
									<button class="btn row-add">添加</button>
								</td>
							</tr>
						</tbody>
					</table>

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
	</div>
	<script src="js/myscript.js"></script>
</body>
</html>