<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="x.jsp"></jsp:include>
<title>添加客户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- jquery是js的框架，它封装很多功能，用起来比js方便很多！ -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/jquery/jquery.datepick.css'/>">
<script type="text/javascript"
	src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>

<script type="text/javascript">
	$(function() {
		$("#birthday").datepick({dateFormat:"yy-mm-dd"});
	});
	
	function add() {
		$(".error").text("");
		var bool = true;
		if(!$(":text[name=cid]").val()) {
			$("#cidError").text("客户名称不能为空");
			bool = false;
		}
		if(!$(":text[name=cname]").val()) {
			$("#cnameError").text("客户名称不能为空");
			bool = false;
		}
		if(!$(":text[name=sdept]").val()) {
			$("#sdeptError").text("客户名称不能为空");
			bool = false;
		}
		if(!$(":text[name=java]").val()) {
			$("#javaError").text("客户名称不能为空");
			bool = false;
		}
		if(!$(":text[name=python]").val()) {
			$("#pythonError").text("客户名称不能为空");
			bool = false;
		}
		if(!$(":text[name=android]").val()) {
			$("#androidError").text("客户名称不能为空");
			bool = false;
		}
		if(bool) {
			$("form").submit();
		}
	}
	
</script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>

<body>
	<c:choose>
		<c:when test="${sessionScope.io==1 }">
			<h3 align="center">添加客户</h3>
			<form action="<c:url value='/CustomerServlet'/>" method="post">
				<!-- 向servlet传递一个名为method的参数，其值表示要调用servlet的哪一个方法 -->
				<input type="hidden" name="method" value="add" />
				<table border="0" align="center" width="40%"
					style="margin-left: 100px;">
					<tr>
						<td width="100px">学号</td>
						<td width="40%"><input type="text" name="cid" /></td>
						<td align="left"><label id="cidError" class="error">&nbsp;</label>
						</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="cname" /></td>
						<td><label id="cnameError" class="error">&nbsp;</label></td>
					</tr>
					<tr>
						<td>系别</td>
						<td><input type="text" name="sdept" /></td>
						<td><label id="sdeptError" class="error">&nbsp;</label></td>
					</tr>
					<tr>
						<td>java</td>
						<td><input type="text" name="java" /></td>
						<td><label id="javaError" class="error">&nbsp;</label></td>
					</tr>
					<tr>
						<td>python</td>
						<td><input type="text" name="python" /></td>
						<td><label id="pythonError" class="error">&nbsp;</label></td>
					</tr>
					<tr>
						<td>android</td>
						<td><input type="text" name="android" /></td>
						<td><label id="androidError" class="error">&nbsp;</label></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="button" value="添加" onclick="add()" /> <input
							type="reset" value="重置" /></td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<h1 align="center">只用管理员才可以添加学生</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>
