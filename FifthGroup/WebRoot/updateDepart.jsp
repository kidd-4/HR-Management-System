<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门信息管理系统</title>
</head>

<%
	// 设置请求编码
	request.setCharacterEncoding("UTF-8");
%>

<body bgcolor="lightblue">
		<center>
		
			<h1><br /></h1><h1>部门修改</h1>  
            <form action="doUpdateDepart" method="post">
            
                部&nbsp;&nbsp;门&nbsp;&nbsp;名&nbsp;&nbsp;称:
                    <input type="text" style="width:160px;" name="name" readonly="readonly" value="<%= request.getParameter("name") %>" /><br />
                部&nbsp;&nbsp;门&nbsp;&nbsp;编&nbsp;&nbsp;号:
                    <input type="text" style="width:160px;" name="ID"  value="<%= request.getParameter("ID") %>" /><br />
                部&nbsp;&nbsp;门&nbsp;&nbsp;职&nbsp;&nbsp;位:
                    <input type="text" style="width:160px;" name="Pos"  value="<%= request.getParameter("Pos") %>" /><br />
                工&nbsp;&nbsp;作&nbsp;&nbsp;职&nbsp;&nbsp;能:
                    <input type="text" style="width:160px;" name="workContent"  value="<%= request.getParameter("workContent") %>" /><br />
                <input type="submit" value="提交" />
                <input type="reset" value="重置" />
            </form>        
		</center>
</body>
</html>
