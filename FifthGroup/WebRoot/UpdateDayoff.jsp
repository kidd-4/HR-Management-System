<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考勤管理-修改请假记录</title>
<style type="text/css"> 
	tr{
		text-align:center
	}
	input{
		width:150px;
			
	}
 
</style> 
</head>
 

   <%request.setCharacterEncoding("UTF-8"); %>

<body bgcolor="lightblue">
	<form action="doDayoffUpdate" method="post">
        <table border="1" align="center" width="58%">
            <tr align="center" bgcolor="lightblue">
            <br></br>
            <br></br>
            
                <td><h1>修改请假记录</h1></td>
            </tr>
            <tr align="center">
                <td>编&nbsp;&nbsp;&nbsp;&nbsp;号：
                <input type="text" 
                name="staffID" value=<%= request.getParameter("staffID") %>>  </td>
            </tr>
			           <tr align="center">
            </tr>
            <tr>
                <td>姓&nbsp;&nbsp;&nbsp;&nbsp;名：
                <input type="text" name="Name" value=<%= request.getParameter("Name") %>>  </td>
            </tr>
			 <tr>
                <td>请假时间：
                    <input type="text" name="dayofftime" value=<%= request.getParameter("dayofftime") %>>  
                </td>
            </tr>
              <tr>
                <td>请假时长：
                    <input type="char" name="span" value=<%= request.getParameter("span") %>>  
                </td>
            </tr>
			  <tr>
                <td>请假原因：
                    <input type="char" name="reason" value=<%= request.getParameter("reason") %> >  
                </td>
            </tr>
              <tr>
                <td>状&nbsp;&nbsp;&nbsp;&nbsp;态：
                    <input type="char" name="status" value=<%= request.getParameter("status") %> >  
                </td>
            </tr>
            
            <tr bgcolor="lightblue">
                <td>
                    <input type="submit" value="提交" />
                    <input type="reset" value="重置" />
                </td>
            </tr>
        </table>
	</form>
 
 
 
 
</body>
</html>