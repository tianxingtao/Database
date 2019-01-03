<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.ssh.entity.Productinfo"%>
<%@ page import="com.ssh.entity.Pshoppingcart"%>
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
<title>确认订单</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/another_style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/memenu.js"></script>
<script type="text/javascript" src="js/simpleCart.min.js"></script>
<script type="text/javascript">
	function confirmBuy() {
		return confirm("确定支付吗？");
	}
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
				<h1>所有订单</h1>
			<table>
				<tr>
					<th>商品名</th>
					<th>数量</th>
					<th>价格</th>
					<th>填写地址</th>
				</tr>
				</table>
				
     <form action="${pageContext.request.contextPath}/productinfo/p"
	    method="post" enctype="multipart/form-data">
	 	<input type="hidden" name="pid" value="${requestScope.pid}"/>
	   	<input type="hidden" name="uid" value="${requestScope.uid}"/>
	   	<input type="hidden" name="psid" value="${requestScope.psid}"/>
	    
	   	<input  type="text" name="pname" value="${requestScope.pname}"/>
	    <input type="text" name="num" value="${requestScope.num}"/>
	    <input  type="text" name="price" value="${requestScope.price}"/>
	   	<input  type="text" name="address" value=""/>
	   	<INPUT TYPE="SUBMIT" value="添加订单">
	   </form>
				
				
				
</body>
</html>










