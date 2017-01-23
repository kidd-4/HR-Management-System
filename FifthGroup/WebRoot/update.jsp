<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息管理系统</title>
    
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
	// 设置请求编码
	request.setCharacterEncoding("UTF-8");
%>

  <body bgcolor="lightblue">
     <center>
		
			<h1>用户修改</h1>
            
            
            <form action="doUpdate" method="post">
            
                账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:
                    <input type="text" style="width:160px;" name="userID" readonly="readonly" 
                    value="<%= request.getParameter("userID") %>" /><br />
                密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:
                    <input type="password" style="width:160px;" name="userPassword1" /><br />
                确认密码:
                    <input type="password" style="width:160px;" name="userPassword2"/><br />
                姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
                    <input type="text" style="width:160px;" name="userName" value="<%= request.getParameter("userName") %>"/><br />
                性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
                    <input type="radio" name="userSex" value="男" style="width:40px;" /> 男
                    <input type="radio" name="userSex" value="女"  style="width:40px;"/> 女
                   
                    <br />
                 电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:
                    <input type="text" style="width:160px;" name="userTel" value="<%= request.getParameter("userTel") %>"/><br />
                出生年月:
                    <input type="text" style="width:160px;" name="userBirth" /><br /> 
                邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:
                    <input type="text" style="width:160px;"  name="userMail" value="<%= request.getParameter("userMail") %>"/><br /> 
                 地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:
                    <input type="text" style="width:160px;" name="userAdd" value="<%= request.getParameter("userAdd") %>" /><br />
                 身&nbsp;&nbsp;份&nbsp;&nbsp;证:
                    <input type="text" style="width:160px;" name="userCard"  value="<%= request.getParameter("userCard") %>"/><br />
                 部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:
                    <input type="text" style="width:160px;" name="userDep"  value="<%= request.getParameter("userDep") %>"/><br />
                 职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:
                    <input type="text" style="width:160px;" name="userPos" value="<%= request.getParameter("userPos") %>" /><br />
                 描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:
                    <input type="text" style="width:160px;" name="userDesc" value="<%= request.getParameter("userDesc") %>" /><br />
                
                <input type="submit" value="提交" />
                <input type="reset" value="重置" />
            </form>
            
            
            
		</center>
  </body>
</html>
