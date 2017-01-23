<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>缺勤记录增加</title>
<style type="text/css"> 
	tr{
		text-align:center
	}
	input{
		width:150px;
			
	}
 
</style>

</head>
 
<body bgcolor="lightblue">
	<form action="doAddAbsent" method="post">
        <table border="1" align="center" width="50%">
            <tr align="center" bgcolor="lightblue">
                <td><h1>添加缺勤记录</h1></td>
            </tr>
            <tr align="center">
                <td>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="staffID" style="width:150px;" />  </td>
            </tr>
			           <tr align="center">
            </tr>
            <tr>
                <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="Name" style="width:150px;"/>  </td>
            </tr>
           
			
			  <tr>
                <td>缺勤时间：
                    <input type="text" name="absenttime" style="width:150px" />  
                </td>
            </tr>
              
			  <tr>
                <td>缺勤原因：
                    <input type="char" name="reason" style="width:150px" >  
                </td>
            </tr>
              
          
            <tr bgcolor="lightblue">
                <td>
                  <button type="submit" style="width:60px;">提交</button>
                    <input type="reset" value="重置" style="width:60px;" />
                </td>
            </tr>
        </table>
	  </form>
 
 
 
 
</body>
</html>
