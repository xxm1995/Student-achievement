<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
  <h1 align="center">结果</h1>
    <table border="1" width="70%" align="center">
	<tr>
		<th>学生姓名</th>
		<th>性别</th>
		<th>地址</th>
	</tr>
	<% 
		ArrayList list = (ArrayList)session.getAttribute("list");
		for(int i=0;i<list.size();i++){
		String[] s=(String[])list.get(i);
	%>
	<tr>
		<th><%= s[0]%></th>
		<th><%= s[1]%></th>
		<th><%= s[2]%></th>
	</tr>
	<%} %>
	</table>
  </body>
</html>
