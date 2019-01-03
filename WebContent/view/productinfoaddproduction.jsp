<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" 
    pageEncoding="UTF-8"%>
    <%@ page import="com.ssh.entity.Productinfo"%>
<%@ page import="java.util.List"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	String cid = (String)request.getAttribute("cid");
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
							if (cid != null) {
												out.print("<a>" + cid + ",欢迎登录" + "</a>");
												out.print("<a href=\"view/showMessage.jsp\" target=\"_blank\">"
														+ "个人信息" + "</a>");
												out.print("<a href=\"${pageContext.request.contextPath}/productinfo/neww\" onClick=\"return key()\">"
														+ "退出" + "</a>");
											} else {
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
						</script> </a> 
					</p>
				</div>
			</div>
		</div>
</div>
<div class="content">
		<div class="container">
			<div class="content-top">
			<h1>添加商品</h1>

	   <form action="${pageContext.request.contextPath}/productinfo/productinfoaddproduction"
	    method="post" enctype="multipart/form-data">
	   	<input type="hidden" name="cid" value="${requestScope.cid}"/>
	   	<input type="hidden" name="pview" value="0"/>
	   	<input type="hidden" name="pbuynum" value="0"/>
	   	名字：<input type="text" name="pname" value=""/>
	   	<br>类型：<input type="text" name="type" value="" />
	   	<br>价格：<input type="text" name="price" value=""/>
	   	<br>介绍：<input type="text" name="introduce" value=""/>
	   	<br>库存：<input type="text" name="pnum" value=""/>
	   	<br>照片：<input type="file" name="imgFile" >
	   	<INPUT TYPE="SUBMIT" value="添加">
	   </form>
			</div>
		</div>
	</div>


</body>
</html>