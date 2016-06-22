<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="text-align: center;">
	<h1>
		客户关系管理系统
		<c:choose>
			<c:when test="${sessionScope.io==1}">(管理员)</c:when>
			<c:when test="${sessionScope.io==0 }">(用户)</c:when>
			<c:otherwise>???</c:otherwise>
		</c:choose>

	</h1>
	<a href="<c:url value='/sign/zhuce.jsp'/>">添加用户</a> | <a
		href="<c:url value='/add.jsp'/>">添加学生</a> | <a
		href="<c:url value='/CustomerServlet?method=findAll'/>">查询学生</a> | <a
		href="<c:url value='/query.jsp'/>">高级搜索</a> | <a href="#"
		onclick="location.href='tui'">退出</a>
</div>