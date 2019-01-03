<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" 
    pageEncoding="UTF-8"%>
    
<%@ page import="com.ssh.entity.Productinfo"%>
<%@ page import="com.ssh.entity.Pcomment"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
    Productinfo productinfo=(Productinfo)request.getAttribute("production");
    List<Pcomment> pcomment=(List<Pcomment>)request.getAttribute("pcomment");
    int pid=productinfo.getPid();
    String uid=(String)request.getAttribute("uid");
    String name=productinfo.getPname();
    String described=productinfo.getIntroduce();
    String piclocation= "/img/"+productinfo.getPicturelocation();
    int num=productinfo.getPnum();
    int vnum=productinfo.getPview();
    double price=productinfo.getPrice();
    int bnum=productinfo.getPbuynum();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/another_style.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/imagezoom.js"></script>
<script type="text/javascript" src="js/memenu.js"></script>
<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script type="text/javascript">
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			controlNav : "thumbnails"
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		var menu_ul = $('.menu-drop > li > ul'), menu_a = $('.menu-drop > li > a');
		menu_ul.hide();
		menu_a.click(function(e) {
			e.preventDefault();
			if (!$(this).hasClass('active')) {
				menu_a.removeClass('active');
				menu_ul.filter(':visible').slideUp('normal');
				$(this).addClass('active').next().stop(true, true).slideDown(
						'normal');
			} else {
				$(this).removeClass('active');
				$(this).next().stop(true, true).slideUp('normal');
			}
		});

	});
</script>
<script type="text/javascript">
	function editHref() {
		var number = document.getElementById("buyNumber").value;
		if (number >
<%=num%>
	) {
			alert("要购买的数量大于库存，请重新选择");
			return false;
		}
		document.getElementById("carthref").href = document
				.getElementById("carthref").href
				+ number;
	}
</script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<div class="single">
		<div class="container">
			<div class="col-md-9">
				<div class="col-md-5 grid">
					<div class="flexslider">
						<ul class="slides">
							
								<div class="thumb-image">
									<img src="<%=piclocation%>" data-imagezoom="true"
										class="img-responsive">
								</div>
						</ul>
					</div>
				</div>
				<div class="col-md-7 single-top-in">
					<div class="single-para simpleCart_shelfItem">
						<h1><%=name%></h1>
						<p><%=described%></p>
						<div class="star-on">
							<div class="review">
							  <a>库存：<%=num%></a>
							  <br>
							   <a>被查看次数：<%=vnum%></a>
							    <br>
							   <a>被购买次数：<%=bnum%></a>
							</div>
							<div class="clearfix"></div>
						</div>
						<label class="add-to item_price"><%=price%>元</label>
						<div class="available">
							<h6>购买数量 :</h6>
							<input name="buyNumber" type="number" min="1" max=<%=num%>
								value="1" id="buyNumber">
						</div>
						<a id="carthref" href="${pageContext.request.contextPath}/productinfo/productinfoaddshoppingcart?uid=<%=uid%>&pid=<%=pid%>&buyNumber="
							class="cart item_add" onclick="return editHref()">加入购物车</a>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</body>
</body>
</html>


























