<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login",method="post">
	<p align="center">用户名：<input type="text" name="userName">
	<p align="center">密码：   <input type="password" name="password">
	<p align="center"><input type="submit" value="提交">
</form>
</body>
</html>