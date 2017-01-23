<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.icss.java.data.dao.divisionEntity"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<%
	// 设置请求编码
	request.setCharacterEncoding("UTF-8");
%>


<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD id=Head1><TITLE>人事调配管理</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8"><LINK 
href="YHChannelApply.files/Style.css" type=text/css rel=stylesheet><LINK 
href="YHChannelApply.files/Manage.css" type=text/css rel=stylesheet>
<SCRIPT language=javascript src="YHChannelApply.files/FrameDiv.js"></SCRIPT>

<SCRIPT language=javascript src="YHChannelApply.files/Common.js"></SCRIPT>

<SCRIPT language=javascript></SCRIPT>

<script type="text/javascript">
	 function goDelete(sId){
		// 弹出选择提示框 
		if(confirm("是否删除用户"+sId+"?")){
			// 跳转到删除Action
			location.href='doDeleteDivision?staffID='+sId;		
		}
	}


</script>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR></HEAD>
<BODY>


<%
	//　获得请求中绑定的数据信息--用户集合 
	List<divisionEntity> list = (List<divisionEntity>)request.getAttribute("stuList");
%>



<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15><IMG src="YHChannelApply.files/new_019.jpg" border=0></TD>
    <TD width="100%" background=YHChannelApply.files/new_020.jpg height=20></TD>
    <TD width=15><IMG src="YHChannelApply.files/new_021.jpg" 
  border=0></TD></TR></TBODY></TABLE>
  
  
  
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15 background=YHChannelApply.files/new_022.jpg><IMG 
      src="YHChannelApply.files/new_022.jpg" border=0> </TD>
    <TD vAlign=top width="100%" bgColor=#ffffff>
      <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
        <TR>
          <TD class=manageHead>当前位置：管理首页 &gt;人事调配&gt;调配人员信息</TD></TR>
        <TR>
          <TD height=2></TD></TR></TABLE>
      <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" 
      align=center border=0>
        <TBODY>
        <TR>
          <TD height=25>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD>&nbsp;</TD>
                <TD></TD>
                <TD>&nbsp;</TD>
                <TD></TD>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD>
            <TABLE id=grid 
            style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" 
            cellSpacing=1 cellPadding=2 rules=all border=0>
              <TBODY>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
              	<th>账号</th>
                    
                    <th>姓名</th>
                    <th>变动时间</th>
                     <th>变动原因</th>
                    <th>变动类别</th>
                     <th>操作</th>
                </TR>
                <%
                		for(int i=0;i<list.size();i++){
                		divisionEntity di = list.get(i);
                %>
                <form action="updateDivision.jsp" method="post">                                   
              <TR 
              style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
               <td>
								<%= di.getStaffID() %>
								<input type="hidden" name="staffID" value="<%= di.getStaffID() %>" />
							</td> 
							<td>
								<%= di.getName() %>
								<input type="hidden" name="Name" value="<%= di.getName() %>" />
							</td>
							<td>
								<%= di.getTime() %>
								<input type="hidden" name="time" value="<%= di.getTime() %>" />
							</td>
							<td>
				                <%= di.getResaon() %>
								<input type="hidden" name="resaon" value="<%= di.getResaon() %>" />
							</td>
							<td>
								<%= di.getCategory() %>
								<input type="hidden" name="stucategory" value="<%= di.getCategory() %>" />
							</td>
							  <td>
							  
							  <input type="submit" value="修改" />
	                        	<button type="button" onclick="goDelete('<%= di.getStaffID() %>')">删除</button>
							</td>
				
				
                </TR>
                </form>
                
                 <%	
                	}
                %>
              </TBODY></TABLE></TD></TR>
              
              
              
        <TR>
          <TD align=right height=25><button onclick="location.href='addstaffman.jsp'">添加人员调配信息</button>   &nbsp;&nbsp; </TD></TR>
        <TR>
          <TD><SPAN id=pagelink>
            <DIV 
            style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right"></DIV></SPAN></TD></TR></TBODY></TABLE></TD>
    <TD width=15 background=YHChannelApply.files/new_023.jpg><IMG 
      src="YHChannelApply.files/new_023.jpg" border=0> </TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15><IMG src="YHChannelApply.files/new_024.jpg" border=0></TD>
    <TD align=middle width="100%" background=YHChannelApply.files/new_025.jpg 
    height=15></TD>
    <TD width=15><IMG src="YHChannelApply.files/new_026.jpg" 
  border=0></TD></TR></TBODY></TABLE>
</BODY></HTML>
