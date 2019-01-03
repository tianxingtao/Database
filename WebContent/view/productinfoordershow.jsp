<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.ssh.controller.Orderproduct"%>
<%@page import="java.util.List"%>
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
<title>已购买</title>
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
		return confirm("确定支付订单吗？");
	}
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="container">
		<div class="check-out">
			<h1>购买历史</h1>
			<table>
				<tr>
					<th>商品</th>
					<th>数量</th>
					<th>价格</th>
					<th>地址</th>
					<th>总价</th>
					<th>购买时间</th>
				</tr>
				<%
				List<Orderproduct> orderproduct=(List<Orderproduct>)request.getAttribute("orderproduct");
					if (orderproduct != null & orderproduct.size() > 0) {
						String photoPath;
						int pid;
						
						for (int i = 0; i < orderproduct.size(); i++) {
							photoPath="/img/"+orderproduct.get(i).getProductinfo().getPicturelocation();
							pid=orderproduct.get(i).getProductinfo().getPid();
							orderproduct.get(i).getOrderinfo().getNum();
				%>
				<tr>
					<td class="ring-in"><a
						href="${pageContext.request.contextPath}/productinfo/productinfoshowdetail?uid=${requestScope.uid}&pid=<%=pid%>"
						class="at-in"> <img src="<%=photoPath%>"
							class="img-responsive" alt="">
					</a>
						<div class="sed">
							<h5>
								<%=orderproduct.get(i).getProductinfo().getPname()%></h5>
							<br>
						</div>
						<div class="clearfix"></div></td>
					<td><%=orderproduct.get(i).getOrderinfo().getNum()%></td>
					<td><%=orderproduct.get(i).getProductinfo().getPrice()%>元</td>
					<td><%=orderproduct.get(i).getOrderinfo().getAddress()%></td>
					<td><%=orderproduct.get(i).getOrderinfo().getPrice()%>元</td>
					<td><%=orderproduct.get(i).getOrderinfo().getTime()%></td>
				</tr>
				<%
					}
					}
				%>
			</table>
		</div>
	</div>
</body>
</body>
</html>
















