<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'z.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	String msg = (String) request.getAttribute("msg");
  	if (msg == null) {
  		msg = "";
  	}
  %>
  <body>
  <h1>添加信息</h1>
  <font color="red">${msg}</font>
    <form action="Z" method="get">
    	姓名:<input type="text" name="name" ><br>
    	性别:<input type="text" name="sex"><br>
    	地址:<input type="text" name="add"><br> 
    	<input type="submit" value="添加">
    	<input type="button" value="返回" onclick="location.href='/zhuce/dlh.jsp'"><br>
    </form>
  </body>
</html>
