<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>


<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>问者</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="css/bootstrap.css" media="screen">
<link rel="stylesheet" href="skins/eden.css" media="screen">
<link rel="stylesheet" href="style.css" media="screen">
<link href="fonts/icons/icons.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">

</head>


<body data-spy="scroll" data-target="#topnav" id="top">
<input type="hidden" id="welcomename" value="<s:property value="welcomename"/>"/>
	<section class="header-area-home" id="header-area-home">
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
							<a class="navbar-brand" href="#"><img src="images/indexlogo.png" /></a>
						</div>

						<div class="collapse navbar-collapse" id="main-menu">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#top">信息主页</a></li>
								<li><a href="backwithout.action?logininfor=<s:property value="welcomename"/>">个人中心</a></li>	
								<li><a>您好，<s:property value="welcomename"/></a></li>
								
<!-- 								<li><a><input type="text" placeholder="搜索问卷"/><input type="button" class="btn-success" value="搜索"></a></li>  -->
								
								
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		<div id="featured-slider-container">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div id="featured-slider" class="carousel slide"
							data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#featured-slider" data-slide-to="0"
									class="active"><img src='images/daxue1-x.jpg' alt=''
									class='featured-slide-thumb' /></li>
								<li data-target="#featured-slider" data-slide-to="1"><img
									src='images/jishu1-x.jpg' alt='' class='featured-slide-thumb' /></li>
								<li data-target="#featured-slider" data-slide-to="2"><img
									src='images/xingzuozhuti3-x.jpg' alt='' class='featured-slide-thumb' /></li>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox">
								<div class="item active" id="slide-2">
									<img src='images/daxue3.jpg' alt=''
										class='featured-slide inv' data-animation='animated zoomIn'
										data-delay='0.3s' /> <img src='images/daxue2.jpg' alt=''
										class='featured-slide featured-slide-1 inv'
										data-animation='animated zoomIn' data-delay='0.7s' />
									<div class="carousel-caption">
										<span class="lead slide-cat inv"
											data-animation="animated zoomIn"><a href="#"
											rel="category">问者主题一</a></span>
										<h2 class="slide-title inv" data-animation="animated fadeInUp"
											data-duration="2s" data-delay="1s">大学</h2>
										<div class="slide-excerpt inv"
											data-animation="animated fadeInUp" data-duration="3s"
											data-delay="2s">
											<ul class="row">
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2s'>学习</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.1s'>工作</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.2s'>宿舍</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.3s'>图书馆</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.4s'>青春</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.5s'>情感</li>

											</ul>
										</div>
										<div class="meta">
											<button class="btn inv btn-success slide-btn btn-lg"
												data-animation="animated fadeInUp" data-delay="3s"
												data-duration="2s">
												<a href="huida.action?wenjuanhao=<s:property value="college"/>">点击查看最火问卷</a>
											<i class="tn-arrow-right"></i> 
											</button>
										</div>

									</div>
								</div>
								<div class="item" id="slide-3">
									<img src='images/jishu2.jpg' alt=''
										class='featured-slide inv' data-animation='animated zoomIn'
										data-delay='0.3s' /> <img src='images/jishu3.jpg' alt=''
										class='featured-slide featured-slide-1 inv'
										data-animation='animated zoomIn' data-delay='0.7s' />
									<div class="carousel-caption">
										<span class="lead slide-cat inv"
											data-animation="animated zoomIn"><a href="#"
											rel="category">问者主题二</a></span>
										<h2 class="slide-title inv" data-animation="animated fadeInUp"
											data-duration="2s" data-delay="1s">情感</h2>
										<div class="slide-excerpt inv"
											data-animation="animated fadeInUp" data-duration="3s"
											data-delay="2s">
											<ul class="row">
												<li class="col-lg-6" data-animation='animated fadeInLeft'
													data-delay='2s'>爱情</li>
												<li class="col-lg-6" data-animation='animated fadeInLeft'
													data-delay='2.1s'>友情</li>
												<li class="col-lg-6" data-animation='animated fadeInLeft'
													data-delay='2.2s'>亲情</li>
												<li class="col-lg-6" data-animation='animated fadeInLeft'
													data-delay='2.3s'>感动</li>
												<li class="col-lg-6" data-animation='animated fadeInLeft'
													data-delay='2.4s'>日常</li>
												<li class="col-lg-6" data-animation='animated fadeInLeft'
													data-delay='2.5s'>生活</li>

											</ul>
										</div>
										<div class="meta">
											<button class="btn btn-info inv slide-btn btn-lg"
												data-animation="animated lightSpeedIn" data-delay="3s"
												data-duration="2s">
												<a href="huida.action?wenjuanhao=<s:property value="emotion"/>">点击查看最火问卷</a>
												<i class="tn-arrow-right"></i>
											</button>
										</div>

									</div>
								</div>
								<div class="item" id="slide-4">
									<img src='images/xingzuosucai1.jpg' alt=''
										class='featured-slide inv' data-animation='animated zoomIn'
										data-delay='0.3s' /> <img src='images/xingzuozhuti2.jpg' alt=''
										class='featured-slide featured-slide-1 inv'
										data-animation='animated zoomIn' data-delay='0.7s' />
									<div class="carousel-caption">
										<span class="lead slide-cat inv"
											data-animation="animated zoomIn"><a href="#"
											rel="category">问者主题三</a></span>
										<h2 class="slide-title inv" data-animation="animated fadeInUp"
											data-duration="2s" data-delay="1s">生活</h2>
										<div class="slide-excerpt inv"
											data-animation="animated fadeInUp" data-duration="3s"
											data-delay="2s">
											<ul class="row">
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2s'>学习</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.1s'>工作</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.2s'>家庭</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.3s'>学校</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.4s'>朋友</li>
												<li class="col-lg-6" data-animation='animated zoomIn'
													data-delay='2.5s'>事业</li>

											</ul>
										</div>
										<div class="meta">
											<button class="btn btn-danger inv slide-btn btn-lg"
												data-animation="animated fadeInUp" data-delay="3s"
												data-duration="2s">
												<a href="huida.action?wenjuanhao=<s:property value="life"/>">点击查看最火问卷</a>
												<i class="tn-arrow-right"></i>
											</button>
										</div>

									</div>
								</div>

							</div>


						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!--  
	<section class="featured-content-area" id="featured-content-area">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div
						class="panel panel-success panel-featured-content  text-center" >
						<div class="panel-heading">
							<a href="#emotion"><font color="white">情感专栏 </font></a>
						</div>

						<div class="panel-body">
							<div class="diamond filled bg-success wow zoomIn"
								data-wow-delay="500ms">
								<i class="lineicon tn-paint-roller"></i>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-info panel-featured-content  text-center">
						<div class="panel-heading"><a href="#school"><font color="white">校园专栏 </font></a></div>
						<div class="panel-body">
							<div class="diamond filled bg-info wow zoomIn"
								data-wow-delay="900ms">
								<i class="lineicon tn-world"></i>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div
						class="panel panel-primary panel-featured-content  text-center">
						<div class="panel-heading"><a href="#bussiness"><font color="white">商业专栏 </font></a></div>
						<div class="panel-body">
							<div class="diamond filled  bg-primary wow zoomIn"
								data-wow-delay="1300ms">
								<i class="lineicon tn-android"></i>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div
						class="panel panel-warning panel-featured-content  text-center">
						<div class="panel-heading"><a href="#star"><font color="white">星座专栏 </font></a></div>
						<div class="panel-body">
							<div class="diamond filled bg-warning wow zoomIn"
								data-wow-delay="1700ms">
								<i class="lineicon tn-apple"></i>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	-->
	<section class="why-us" id="why-us">

		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center section-intro">
					<h2 class="header-boxed wow zoomIn" data-wow-iteration="1">
						<span>没找到想看的内容?</span>
					</h2>
					<p class="lead wow fadeInUp" data-wow-delay="600ms">快来看看下面的问题吧，相信里面一定有您喜欢的</p>
				</div>
				<div class="col-md-12 highlight-boxes">
					<div class="col-md-4 wow fadeInLeft" data-wow-delay="500ms">
						<div class="featured-content-box text-center">
							<i class="tn-heart ico-lg text-warning"></i>

							<h3><s:property value="wenjuan1"/></h3>
							
							<button class="btn btn-warning"><a href="huida.action?wenjuanhao=<s:property value="wenjuan1"/>">查看更多</a></button>
						</div>
					</div>
					<div class="col-md-4 wow zoomIn" data-wow-delay="100ms">
						<div class="featured-content-box text-center">
							<i class="tn-server ico-lg text-info"></i>

							<h3><s:property value="wenjuan2"/></h3>
							
							<button class="btn btn-info"><a href="huida.action?wenjuanhao=<s:property value="wenjuan2"/>">查看更多</a></button>
						</div>
					</div>
					<div class="col-md-4 wow fadeInRight" data-wow-delay="500ms">
						<div class="featured-content-box text-center">
							<i class="tn-anchor ico-lg text-success"></i>

							<h3><s:property value="wenjuan3"/></h3>
							
							<button class="btn btn-primary"><a href="huida.action?wenjuanhao=<s:property value="wenjuan3"/>">查看更多</a></button>
						</div>
					</div>
					<div class="col-md-4 wow fadeInUp">
						<div class="featured-content-box text-center">
							<i class="tn-agenda ico-lg text-danger"></i>

							<h3><s:property value="wenjuan4"/></h3>
							
							<button class="btn btn-danger"><a href="huida.action?wenjuanhao=<s:property value="wenjuan4"/>">查看更多</a></button>
						</div>
					</div>
					<div class="col-md-4 wow fadeInUp" data-wow-delay="300ms">
						<div class="featured-content-box text-center">
							<i class="tn-headphone ico-lg text-warning"></i>

							<h3><s:property value="wenjuan5"/></h3>
							
							<button class="btn btn-warning"><a href="huida.action?wenjuanhao=<s:property value="wenjuan5"/>">查看更多</a></button>
						</div>
					</div>
					<div class="col-md-4 wow fadeInUp" data-wow-delay="600ms">
						<div class="featured-content-box text-center">
							<i class="tn-dashboard ico-lg text-info"></i>

							<h3><s:property value="wenjuan6"/></h3>
							
							<button class="btn btn-info"><a href="huida.action?wenjuanhao=<s:property value="wenjuan6"/>">查看更多</a></button>
						</div>
					</div>
				</div>


			</div>
		</div>

	</section>

	<section class="out-team" id="out-team">

		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center section-intro">
					<h2 class="header-boxed wow zoomIn" data-wow-iteration="1">
						<span>还是不感兴趣？</span>
					</h2>
					<p class="lead wow fadeInUp" data-wow-delay="600ms">您可以关注用户，查看更多的问卷</p>
				</div>

				<div class="col-sm-6 col-md-4">
					<div class="panel panel-default panel-card">
						<div class="panel-heading">
							<img
								src="https://unsplash.imgix.net/12/barley.jpg?q=75&fm=jpg&s=f39de5ca1970a13dbe6af6c86b3c47ec" />
							<button class="btn btn-primary btn-sm" role="button">Follow</button>
						</div>
						<div class="panel-figure">
							<img class="img-responsive img-circle"
								src="img/a0.jpg" />
						</div>
						<div class="panel-body text-center">
							<h4 class="panel-header">
								<a class="user"><s:property value="newf1"/></a>
							</h4>
							
						</div>
<!-- 						<div class="panel-thumbnails"> -->
<!-- 							<hr /> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/mzwlj/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/yboaj/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/gv3bp/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="panel panel-default panel-card">
						<div class="panel-heading">
							<img
								src="https://unsplash.imgix.net/41/bXoAlw8gT66vBo1wcFoO_IMG_9181.jpg?q=75&fm=jpg&s=a760fd82863937c841f4b3870cdef011" />
							<button class="btn btn-primary btn-sm" role="button">Follow</button>
						</div>
						<div class="panel-figure">
							<img class="img-responsive img-circle"
								src="img/a0.jpg" />
						</div>
						<div class="panel-body text-center">
							<h4 class="panel-header">
								<a class="user"><s:property value="newf2"/></a>
							</h4>
							
						</div>
<!-- 						<div class="panel-thumbnails"> -->
<!-- 							<hr /> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/dstb9/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/2lsao/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/urcon/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="panel panel-default panel-card">
						<div class="panel-heading">
							<img
								src="https://ununsplash.imgix.net/19/waves.JPG?q=75&fm=jpg&s=6f316bc8e1dc9887a7cebe0841096e99" />
							<button class="btn btn-primary btn-sm" role="button">Follow</button>
						</div>
						<div class="panel-figure">
							<img class="img-responsive img-circle"
								src="img/a0.jpg" />
						</div>
						<div class="panel-body text-center">
							<h4 class="panel-header">
								<a class="user"><s:property value="newf3"/></a>
							</h4>
							
						</div>
<!-- 						<div class="panel-thumbnails"> -->
<!-- 							<hr /> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/7an8e/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/wntpb/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/jrzxa/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="panel panel-default panel-card row2">
						<div class="panel-heading">
							<img
								src="https://ununsplash.imgix.net/26/camera-keys.jpg?q=75&fm=jpg&s=b919d3158053cde8e9f0e37b4876c14f" />
							<button class="btn btn-primary btn-sm" role="button">Follow</button>
						</div>
						<div class="panel-figure">
							<img class="img-responsive img-circle"
								src="img/a0.jpg" />
						</div>
						<div class="panel-body text-center">
							<h4 class="panel-header">
								<a class="user"><s:property value="newf4"/></a>
							</h4>
							
						</div>
<!-- 						<div class="panel-thumbnails"> -->
<!-- 							<hr /> -->
<!-- <!-- 							<div class="row"> --> 
<!-- <!-- 								<div class="col-xs-4"> --> 
<!-- <!-- 									<div class="thumbnail"> --> 
<!-- <!-- 										<img src="http://placemi.com/sqfuk/80x60" /> --> 
<!-- <!-- 									</div> --> 
<!-- <!-- 								</div> --> 
<!-- <!-- 								<div class="col-xs-4"> --> 
<!-- <!-- 									<div class="thumbnail"> --> 
<!-- <!-- 										<img src="http://placemi.com/71mf8/80x60" /> --> 
<!-- <!-- 									</div> --> 
<!-- <!-- 								</div> --> 
<!-- <!-- 								<div class="col-xs-4"> --> 
<!-- <!-- 									<div class="thumbnail"> --> 
<!-- <!-- 										<img src="http://placemi.com/1pdrw/80x60" /> --> 
<!-- <!-- 									</div> --> 
<!-- <!-- 								</div> --> 
<!-- <!-- 							</div> --> 
<!-- 						</div> -->
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="panel panel-default panel-card row2">
						<div class="panel-heading">
							<img
								src="https://ununsplash.imgix.net/19/waves.JPG?q=75&fm=jpg&s=6f316bc8e1dc9887a7cebe0841096e99" />
							<button class="btn btn-primary btn-sm" role="button">Follow</button>
						</div>
						<div class="panel-figure">
							<img class="img-responsive img-circle"
								src="img/a0.jpg" />
						</div>
						<div class="panel-body text-center">
							<h4 class="panel-header">
								<a class="user"><s:property value="newf5"/></a>
							</h4>
							
						</div>
<!-- 						<div class="panel-thumbnails"> -->
<!-- 							<hr /> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/7an8e/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/wntpb/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/jrzxa/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="panel panel-default panel-card row2">
						<div class="panel-heading">
							<img
								src="https://ununsplash.imgix.net/19/waves.JPG?q=75&fm=jpg&s=6f316bc8e1dc9887a7cebe0841096e99" />
							<button class="btn btn-primary btn-sm" role="button">Follow</button>
						</div>
						<div class="panel-figure">
							<img class="img-responsive img-circle"
								src="img/a0.jpg" />
						</div>
						<div class="panel-body text-center">
							<h4 class="panel-header">
								<a class="user"><s:property value="newf6"/></a>
							</h4>
							
						</div>
<!-- 						<div class="panel-thumbnails"> -->
<!-- 							<hr /> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/7an8e/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/wntpb/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-4"> -->
<!-- 									<div class="thumbnail"> -->
<!-- 										<img src="http://placemi.com/jrzxa/80x60" /> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>

			</div>
		</div>
	</section>

	<!--  
	<section class="client-reviews" id="client-reviews">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center section-intro">
					<h2 class="header-boxed wow zoomIn" data-wow-iteration="1">
						<span>用户留言</span>
					</h2>
					<p class="lead wow fadeInUp" data-wow-delay="200ms">简洁而又实用，问者为您而生</p>
				</div>

				<div class="col-md-4">
					<div class="speach">
						用户一留言
						<div class="media person">
							<div class="pull-left">
								<img src="images/user.jpg" class="img-circle">
							</div>
							<div class="media-body">
								<b>用户一</b><br /> 用户一职业
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="speach">
						用户二留言
						<div class="media person">
							<div class="pull-left">
								<img src="images/user.jpg" class="img-circle">
							</div>
							<div class="media-body">
								<b>用户二</b><br /> 用户二职业
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="speach">
						用户三留言
						<div class="media person">
							<div class="pull-left">
								<img src="images/user.jpg" class="img-circle">
							</div>
							<div class="media-body">
								<b>用户三</b><br /> 用户三职业
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>
-->
	<section class="getspeach" id="getspeach">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center section-intro">
					<h2 class="header-boxed wow zoomIn" data-wow-iteration="1">
						<span>联系我们</span>
					</h2>
					<p class="lead">欢迎提出宝贵意见！联系方式：邮箱：yaobingkun2008@126.com 电话：110</p>
				</div>
<!-- 				<div class="col-md-6"> -->
<!-- 					<div class="contact-form wow fadeInLeft"> -->
<!-- 						<form class="row" method="get" action=""> -->
<!-- 							<div class="col-md-6"> -->
<!-- 								<div class="form-group"> -->
<!-- 									<label>请输入您的姓名<i class="fa fa-asterisk"></i></label> <input -->
<!-- 										type="text" name="name" class="form-control"> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="col-md-6"> -->
<!-- 								<div class="form-group"> -->
<!-- 									<label>请输入您的邮件<i class="fa fa-asterisk"></i></label> <input -->
<!-- 										type="email" name="email" class="form-control"> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="col-md-12"> -->
<!-- 								<div class="form-group"> -->
<!-- 									<label>请输入您的留言</label> -->
<!-- 									<textarea name="message" rows="6" class="form-control"></textarea> -->
<!-- 								</div> -->
<!-- 								<div class="send_result"></div> -->
<!-- 							</div> -->
<!-- 							<div class="col-md-12"> -->
<!-- 								<input type="submit" value="提交" -->
<!-- 									class="btn btn-primary btn-lg btn-block" name="submit"> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 					<div class="featured-content-box text-center wow fadeInDown"> -->
<!-- 						<div class="circle feature-icon"> -->
<!-- 							<i class="tn-mobile"></i> -->
<!-- 						</div> -->

<!-- 						<h3>联系我们</h3> -->
<!-- 						<p>18946036722</p> -->

<!-- 					</div> -->

<!-- 					<div class="featured-content-box text-center wow fadeInUp"> -->
<!-- 						<div class="circle feature-icon"> -->
<!-- 							<i class="tn-email"></i> -->
<!-- 						</div> -->

<!-- 						<h3>邮箱</h3> -->
<!-- 						<p>yaobingkun2008@126.com</p> -->

<!-- 					</div> -->

				
			</div>
		</div>
	</section>

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center section-intro">
					<hr />
					<h2>
						<img src="images/indexlogo.png" />
					</h2>
					Copyright &copy;HIT 2016 All Rights Reserved.
				</div>
			</div>
		</div>
		<br /> <br />
	</footer>



	<script src="js/jquery-2.1.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/site.js"></script>
	<script src="js/addFriend.js"></script>

</body>
</html>