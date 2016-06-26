<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'qdl.jsp' starting page</title>
    
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
  	String name=(String)request.getSession().getAttribute("name");
  	if(name==null){
  		request.setAttribute("msg", "不要试图强行登陆!");
  		request.getRequestDispatcher("login.jsp").forward(request, response);
  		return;
  	}
   %>
  <body>
    <h1>欢迎${name}先生登陆
    <input type="button" value="登出" onclick="location.href='tui'">
    </h1>
    
    
    <table >
    	<tr><th ><a href="zsgc/z.jsp">增</a></th></tr>
    	<tr><th ><a href="dlh.jsp">删</a></th></tr>
    	<tr><th ><a href="dlh.jsp">改</a></th></tr>
    	<tr><th ><a href="zsgc/c.jsp">查</a></th></tr>
    </table>
  </body>
</html>
