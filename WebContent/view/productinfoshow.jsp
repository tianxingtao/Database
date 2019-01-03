<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ssh.entity.Productinfo"%>
<%@ page import="java.util.List"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/another_style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
	function showtime(){
		var myDate = new Date();
		document.getElementById("time").innerHTML = myDate.getHours() + "时" + myDate.getMinutes() + "分"+ myDate.getSeconds() + "秒" ;
		setTimeout("showtime()",1000);
	}
</script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="content">
		<div class="container">
			<div class="content-top">
				<%
				    List<Productinfo> productionlist=(List<Productinfo>)request.getAttribute("productionlist");
					if (productionlist != null && productionlist.size() > 0) {
						for (int i = 0; i < productionlist.size(); i++) {
							if (i % 4 == 0) {
				%>
				<div class="content-top1">
					<%
						}
					%>
					<div class="col-md-3 col-md2">
						<div class="col-md1 simpleCart_shelfItem">
							<a
								href="${pageContext.request.contextPath}/productinfo/productinfoshowdetail?pid=<%=productionlist.get(i).getPid()%>&uid=${requestScope.uid}"               
								> <%
 	String photoPath = "/img/" + productionlist.get(i).getPicturelocation();
 %> <img class="img-responsive" src=<%=photoPath%> alt="图片" />
							</a>
							<h3>
								<a
									href="${pageContext.request.contextPath}/productinfo/productinfoshowdetail?uid=${requestScope.uid}&pid=<%=productionlist.get(i).getPid()%>"
									><%=productionlist.get(i).getPname()%></a>
							</h3>
							<div class="price">
								<h5 class="item_price"><%=productionlist.get(i).getPrice()%>元
								</h5>
								<a
									href="${pageContext.request.contextPath}/productinfo/productinfoaddshoppingcart?pid=<%=productionlist.get(i).getPid()%>&uid=${requestScope.uid}&buyNumber=1"
									class="item_add">加入购物车</a>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<%
						if (i % 4 == 3) {
					%>
					<div class="clearfix"></div>
				</div>
				<%
					}
						}
					}
				%>
				
			</div>
		</div>
	</div>
</body>
</html>











