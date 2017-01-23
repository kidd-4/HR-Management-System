<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加合同</title>
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
	<form action="doAddContact" method="post">
        <table border="1" align="center" width="58%">
            <tr align="center" bgcolor="lightblue">
                <td><h1>添加合同</h1></td>
            </tr>
            <tr align="center">
                <td>合同编号:
                  <input type="text" name="ConID" style="width:150px;" />  </td>
            </tr>
            <tr>
                <td >人员编号:
                  <input type="text" name="StaffID" style="width:150px;" />  </td>
            </tr>
            <tr>
                <td>合同时间:
                    <input type="text" name="ConTime" style="width:150px" />  
                </td>
            </tr>
			  <tr>
                <td>合同内容:
                    <input type="text" name="ConContent" style="width:150px" />  
                </td>
            </tr>
            
            <tr>
                <td>合同岗位:
                    <input type="text" name="ConPos" style="width:150px" />  
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