<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>合同信息管理系统</title>
</head>

<%
	// 设置请求编码
	request.setCharacterEncoding("UTF-8");
%>

<body bgcolor="lightblue">
		<center>
		
			<h1><br /></h1><h1>合同修改</h1>  
            <form action="doUpdateContact" method="post">
            
                合&nbsp;&nbsp;同&nbsp;&nbsp;编&nbsp;&nbsp;号:
                    <input type="text" style="width:160px;" name="ConID" readonly="readonly" value="<%= request.getParameter("ConID") %>" /><br />
                人&nbsp;&nbsp;员&nbsp;&nbsp;编&nbsp;&nbsp;号:
                    <input type="text" style="width:160px;" name="StaffID"  value="<%= request.getParameter("StaffID") %>" /><br />
                合&nbsp;&nbsp;同&nbsp;&nbsp;时&nbsp;&nbsp;间:
                    <input type="text" style="width:160px;" name="ConTime"  value="<%= request.getParameter("ConTime") %>" /><br />
                合&nbsp;&nbsp;同&nbsp;&nbsp;内&nbsp;&nbsp;容:
                    <input type="text" style="width:160px;" name="ConContent"  value="<%= request.getParameter("ConContent") %>" /><br />
                合&nbsp;&nbsp;同&nbsp;&nbsp;岗&nbsp;&nbsp;位:
                    <input type="text" style="width:160px;" name="ConPos"  value="<%= request.getParameter("ConPos") %>" /><br />        
                
               
                <input type="submit" value="提交" />
                <input type="reset" value="重置" />
            </form>        
		</center>
</body>
</html>

