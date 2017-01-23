<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>档案注册</title>
    
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
		
			<h1>档案注册</h1>
            
            
            <form action="doRegist2" method="post">
            
                
                档案编号:
                    <input type="text" style="width:160px;" name="docID"/><br />
                 人员编号:
                    <input type="text" style="width:160px;" name="staffID"/><br />
                 档案内容:
                    <input type="text" style="width:160px;" name="docCon"/><br />
                 档案时间:
                    <input type="text" style="width:160px;" name="docTime"/><br />
                
                
                <input type="submit" value="提交" />
                <input type="reset" value="重置" />
            </form>
            
            
            
		</center>
  </body>
</html>
