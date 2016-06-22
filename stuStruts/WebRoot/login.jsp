<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	<h1>登陆</h1>
	${sessionScope.message}
	<form action="${pageContext.request.contextPath}/login" method="post">
		账号:<input type="text" name="username"><br> 密码:<input
			type="password" name="password"><br> <input type="reset"
			value="重填">
		</r>
		<input type="submit" value="登录">
	</form>
</body>
</html>
