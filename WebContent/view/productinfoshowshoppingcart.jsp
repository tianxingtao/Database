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
<title>购物车</title>
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
	function confirmDelete() {
		return confirm("确认删除订单吗");
	}
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
		<div class="container">
		<div class="check-out">
			<h1>所有订单</h1>
			<table>
				<tr>
					<th>商品</th>
					<th>数量</th>
					<th>价格</th>
					<th>总价</th>
				</tr>
				<%
					
				
				    List<Productinfo> productionlist=(List<Productinfo>)request.getAttribute("productlist");    
				    List<Pshoppingcart> numlist=(List<Pshoppingcart>)request.getAttribute("numlist");
					float allTotalPrice = 0;
					if (productionlist != null & productionlist.size() >= 0) {
						String photoPath;
						double totalPrice=0;
						int pid;
						int num;
						int psid;
						for (int i = 0; i < productionlist.size(); i++) {
							psid=numlist.get(i).getPsid();
							photoPath="/img/"+productionlist.get(i).getPicturelocation();
							num=numlist.get(i).getNum();
							totalPrice=numlist.get(i).getNum()*productionlist.get(i).getPrice();
							allTotalPrice+=totalPrice;
							pid=productionlist.get(i).getPid();
							
				%>
				<tr>
					<td class="ring-in"><a
						href="${pageContext.request.contextPath}/productinfo/productinfoshowdetail?uid=${requestScope.uid}&pid=<%=productionlist.get(i).getPid()%>"
						class="at-in"> <img src="<%=photoPath%>"
							class="img-responsive" alt="">
					</a>
						<div class="sed">
							<h5>
								商品名：<%=productionlist.get(i).getPname()%></h5>
							<br>
						</div>
						<div class="clearfix"></div></td>
					<td><%=numlist.get(i).getNum()%></td>
					<td><%=productionlist.get(i).getPrice()%>元</td>
					<td><%=totalPrice%>元</td>
					<td><a
						href="${pageContext.request.contextPath}/productinfo/productinfodeleteshoppingcart?psid=<%=psid%>&uid=${requestScope.uid}"
						onclick="return confirmDelete()">删除</a></td>
										<td><a
						href="${pageContext.request.contextPath}/productinfo/productinfoaddorder?pid=<%=pid%>&uid=${requestScope.uid}&psid=<%=psid%>&buyNumber=<%=num%>"
						onclick="return confirmBuy()">下单</a></td>
				</tr>
				<%
					}
					}
				%>
			</table>
			<a>总计：<%=allTotalPrice%>元
		</div>
	</div>
</body>
</html>















