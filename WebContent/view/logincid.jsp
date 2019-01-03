<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>用户登录</title>
<script src="js/kit.js"></script>
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-30210234-1' ]);
	_gaq.push([ '_trackPageview' ]);
	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
<script src="js/dom.js"></script>
<script src="js/form.js"></script>
<link rel="stylesheet" href="css/css.css" />
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="css/validator.css" />
<!--validator-->
<script src="js/validator.js"></script>
<script src="js/autowired.validator.js"></script>
<style>
table td {
	font-size: 19px;
}

label {
	cursor: pointer;
	margin-right: 1em;
}
</style>
</head>
<body>
    <h1>公司登录</h1>
	<div id="regist-main">
		<form id="registForm" action="${pageContext.request.contextPath}/productinfo/logincid" method="post">
			<ol>
				<li><label for="uname"> </label>
				<li><label for="uname"> </label>
				<li><label for="uname">用户名： <span
						class="kitjs-validator" for="@uname"
						rules="[{notNull:true, message:'用户名不能为空'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="uname"
					data-valmsg-replace="true"></span> <input id="uname" name="cid"
					type="text" value=""></li>
				<li><label for="uname"> </label>
				<li><label for="uname"> </label>
				<li><label for="passwd">密码： <span
						class="kitjs-validator" for="@passwd"
						rules="[{notNull:true, message:'密码不能为空'},{minLength:'6',message:'密码长度最短为6位'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="passwd"
					data-valmsg-replace="true"></span> <input id="passwd" name="password"
					type="password"></li>
			</ol>
			<div class="registError"></div>
			<input type="submit" value="登录" class="btn-submit">
		</form>
	</div>

</body>
</html>


















