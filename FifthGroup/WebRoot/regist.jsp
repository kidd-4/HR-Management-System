<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="lightblue">
    <center>
		
			<h1>用户注册</h1>
            
            
            <form action="doRegist" method="post">
            
                账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:
                    <input type="text" style="width:160px;" name="userID" /><br />
                密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:
                    <input type="password" style="width:160px;" name="userPassword1" /><br />
                确认密码:
                    <input type="password" style="width:160px;" name="userPassword2"/><br />
                姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
                    <input type="text" style="width:160px;" name="userName" /><br />
                性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
                    <input type="radio" name="userSex" value="男" style="width:40px;" /> 男
                    <input type="radio" name="userSex" value="女"  style="width:40px;"/> 女
                    
                    <br />
                 电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:
                    <input type="text" style="width:160px;" name="userTel" /><br />
                出生年月:
                    <input type="text" style="width:160px;" name="userBirth" /><br /> 
                邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:
                    <input type="text" style="width:160px;"  name="userMail" /><br /> 
                 地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:
                    <input type="text" style="width:160px;" name="userAdd"  /><br />
                 身&nbsp;&nbsp;&nbsp;份&nbsp;&nbsp;&nbsp;证:
                    <input type="text" style="width:160px;" name="userCard"  /><br />
                 部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:
                    <input type="text" style="width:160px;" name="userDep"  /><br />
                 职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:
                    <input type="text" style="width:160px;" name="userPos"  /><br />
                 描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:
                    <input type="text" style="width:160px;" name="userDesc"  /><br />
                
                <input type="submit" value="提交" />
                <input type="reset" value="重置" />
            </form>
            
            
            
		</center>
  </body>
</html>
