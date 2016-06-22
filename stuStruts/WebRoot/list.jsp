<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="x.jsp"></jsp:include>
<title>客户列表</title>

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
	<h3 align="center">客户列表</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>系别</th>
			<th>java</th>
			<th>python</th>
			<th>Android</th>
			<c:if test="${sessionScope.io==1 }">
				<th>操作</th>
			</c:if>
		</tr>

		<c:forEach items="${requestScope.cstmList}" var="cstm">
			<tr>
				<td>${cstm.cid }</td>
				<td>${cstm.cname }</td>
				<td>${cstm.sdept }</td>
				<td>${cstm.java }</td>
				<td>${cstm.python }</td>
				<td>${cstm.android }</td>
				<c:if test="${sessionScope.io==1 }">
					<td><a
						href="<c:url value='/CustomerServlet?method=preEdit&cid=${cstm.cid }'/>">编辑</a>
						<a
						href="<c:url value='/CustomerServlet?method=preDel&cid=${cstm.cid }'/>">删除</a>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
