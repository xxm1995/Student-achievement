<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'zhuce.jsp' starting page</title>
<jsp:include page="/x.jsp"></jsp:include>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.io==1 }">
			<form action="${pageContext.request.contextPath}/zhuce" method="post">
				<table border="0" align="center" width="40%"
					style="margin-left: 100px;">
					<font align="center">${sessionScope.message}</font>
					<tr>
						<td>账号:</td>
						<td><input type="text" name="username" value=""></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="password" value="">
						</td>
					</tr>
					<tr>
						<td>权限:</td>
						<td><input type="radio" name="io" value="1" checked>管理员
							<input type="radio" name="io" value="0">用户</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="reset" value="重填"> <input
							type="submit" value="注册"></td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<h1 align="center">只用管理员才可以添加用户</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>
