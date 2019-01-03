<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" 
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	String uid = (String)request.getAttribute("uid");
   // int pnum=(int)request.getAttribute("pnum");
   int pnum=0;
    if(pnum==0){
    	pnum=88888;
    }
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/another_style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/responsiveslides.min.js"></script>
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script type="text/javascript">
	function key() {
		return confirm("确定退出吗？");
	}
</script>
<script>
	function showtime() {
		var myDate = new Date();
		document.getElementById("time").innerHTML = myDate.getHours() + "点"
				+ myDate.getMinutes() + "分" + myDate.getSeconds() + "秒";
		setTimeout("showtime()", 1000);
	}
</script>

</head>
<body>

	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="col-sm-4 world">
					<ul>
						<li></li>
					</ul>
				</div>
				<div class="col-sm-4 logo">
					<a href="index.jsp"><img src="images/logo.png" alt=""></a>
				</div>
				<div class="col-sm-4 header-left">
					<p class="log">
						<%
							if (uid != null&&!uid.equals("")) {
												out.print("<a>" + uid + ",欢迎登录" + "</a>");
												out.print("<a href=\"${pageContext.request.contextPath}/productinfo/neww\" target=\"_blank\">"
														+ "个人信息" + "</a>");
												out.print("<a href=\"view/index.jsp\" onClick=\"return key()\">"
														+ "退出" + "</a>");
											}else{
												out.print("<a href=\"view/loginuid.jsp\">用户登录</a>");
												out.print("<a>or</a>");
												out.print("<a href=\"view/registeruid.jsp\">用户注册</a>");
												out.print("<br>");
												out.print("<a href=\"view/logincid.jsp\">公司登陆</a>");
												out.print("<a>or</a>");
												out.print("<a href=\"view/registercid.jsp\">公司注册</a>");
											}
						%>
						<a id="time"><script type="text/javascript">
							showtime();
						</script> </a><!--  <a>商品总数:<%=pnum%></a> -->
					</p>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-8 h_menu4">
					<ul class="memenu skyblue">
						<li class=" grid"><a href="${pageContext.request.contextPath}/productinfo/indexx?uid=<%=uid%>">首页</a></li>
						<li><a>分类</a>
							<div class="mepanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>图书</h4>
											<ul>
												<li><a
													href="${pageContext.request.contextPath}/productinfo/productinfoshowdetailbytype?type=java&uid=${requestScope.uid}"
													>java</a></li>
											</ul>
											<ul>
												<li><a
													href="${pageContext.request.contextPath}/productinfo/productinfoshowdetailbytype?type=python&uid=${requestScope.uid}"
													>python</a></li>
											</ul>
										</div>
										<div class="h_nav">
											<h4>电子产品</h4>
											<ul>
												<li><a
													href="${pageContext.request.contextPath}/productinfo/productinfoshowdetailbytype?type=phone&uid=${requestScope.uid}"
													>手机</a></li>
											</ul>
											<ul>
												<li><a
													href="${pageContext.request.contextPath}/productinfo/productinfoshowdetailbytype?type=computer&uid=${requestScope.uid}"
													>电脑</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div></li>

						   <li><a href="${pageContext.request.contextPath}/productinfo/productinfoshow?uid=${requestScope.uid}">全部商品</a></li>
                           <li><a href="${pageContext.request.contextPath}/productinfo/productinfoshowshoppingcart?uid=${requestScope.uid}">购物车</a></li>
                           <li><a href="${pageContext.request.contextPath}/productinfo/productinfoordershow?uid=${requestScope.uid}">已购买</a></li>
            
					</ul>
				</div>
				<form action="${pageContext.request.contextPath}/productinfo/productinfoshowdetailbyname?uid=${requestScope.uid}" method="post" >
                                <input type="text" width="30" name="name">
                                <input type="submit" value="搜索" >
                                </form>
			</div>
		</div>
	</div>

</body>
</html>


















