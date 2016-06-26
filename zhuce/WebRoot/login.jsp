<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  	String msg = (String)request.getAttribute("msg");
  	if(msg==null){
  		msg="";
  	}
  	String name = "";
  	Cookie[] c = request.getCookies();
  	if(c!=null){
  		for(Cookie cook:c){
  			if(cook.getName().equals("name")){
  				name=cook.getValue();
  			}
  		}
  	}
   %>
  <body>
  <h1>登陆</h1>
  <%=msg %>
    <form action="/zhuce/Login" method="post">
    	账号:<input type="text" name="name" value="${name}">
    	<br>
    	密码:<input type="password" name="pswd" value="">
    	<br>
    	<input type="button" value="注册" onclick="window.location.href='zhuce.jsp'">
    	<input type="submit" value="登陆" >
    </form>
  </body>
</html>
