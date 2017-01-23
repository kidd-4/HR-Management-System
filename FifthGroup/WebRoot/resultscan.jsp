<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.icss.java.data.dao.*"%>
<%@ page import="com.icss.java.lyy.MyClass"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD id=Head1><TITLE>模板</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8"><LINK 
href="YHChannelApply.files/Style.css" type=text/css rel=stylesheet><LINK 
href="YHChannelApply.files/Manage.css" type=text/css rel=stylesheet>
<SCRIPT language=javascript src="YHChannelApply.files/FrameDiv.js"></SCRIPT>

<SCRIPT language=javascript src="YHChannelApply.files/Common.js"></SCRIPT>

<SCRIPT language=javascript>
        function selectallbox()
        {
            var list = document.getElementsByName('setlist');
            var listAllValue='';
             if(document.getElementById('checkAll').checked)
             {
                  for(var i=0;i<list.length;i++)
                  {
                    list[i].checked = true;
                    if(listAllValue=='')
                        listAllValue=list[i].value;
                    else
                        listAllValue = listAllValue + ',' + list[i].value;
                  }
                  document.getElementById('boxListValue').value=listAllValue;
             }
             else 
             {
                  for(var i=0;i<list.length;i++)
                  {
                    list[i].checked = false;
                  }
                  document.getElementById('boxListValue').value='';
             }
         } 
    </SCRIPT>
<script type="text/javascript">
	/**
		js方法:点击删除时用于确认方法
	*/
	function godelete(trainid,workerid){
		// 弹出选择提示框 
		if(confirm("真的要删除吗？考虑一下？")){
			// 跳转到删除Action
			location.href='doResultDelete?trainid='+trainid+'&workerid='+workerid;		
		}
	}

</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR></HEAD>
<BODY>

<SCRIPT type=text/javascript>
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</SCRIPT>

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
          <TD class=manageHead>当前位置：培训成绩查看</TD></TR>
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
              
              
              <form action="doResultSearch" method="post">
              
              
                <TD>筛选数据：</TD>
                
    
                <TD>培训项目编号</TD>
                <TD>
                
                
                <INPUT class=textbox id=trainid style="WIDTH: 80px" 
                  maxLength=50 name=trainid></TD>
                  
                  
                  
                <TD>姓名</TD>
                <TD>
                <INPUT class=textbox style="WIDTH: 80px" 
                  maxLength=50 name=name></TD>

                <TD><input type="submit" value="提交" />
                	<input type="reset" value="重置" />
                	
               </TD>
              
               </form>
              <td>
               <input type="button" onclick="location.href='resultupdate.jsp?id=<%="add"%>'" value="添加"/>
               
               </td>
              
              
              
              </TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD>
            <TABLE id=grid 
            style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" 
            cellSpacing=1 cellPadding=2 rules=all border=0>
              <TBODY>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <TD>姓名</TD>
                <TD>培训项目编号</TD>
                <TD>培训项目类别</TD>
                <TD>成绩</TD>
                <TD>操作</TD>
                <% 
                	String strSearch=(String)request.getAttribute("isSearched");
                	if(strSearch==null) strSearch="0";
                	if(strSearch.compareTo("1")!=0)
                		MyClass.getListResult();
                	TrainResult tr=new TrainResult();
                	for(int i=0;i<MyClass.listResult.size();i++)
                	{	
                		tr=MyClass.listResult.get(i);
                		String name=LyyDao.getUserName(tr.getWorkerid());
                %>
                
               
                
                
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
              
                <TD><%=name %></TD>
                <TD><%=tr.getTrainid()%></TD>
                <TD><%=LyyDao.getCategoryName(tr.getTrainid(),TrainPro.class) %></TD>
                <TD><%=tr.getScore() %></TD>      
                <TD>
               	 	<input type="button" onclick="location.href='resultupdate.jsp?id=<%=i%>'" value="修改"/>
                	<input type="button" onclick="godelete('<%=tr.getTrainid()%>','<%=tr.getWorkerid()%>')" value="删除"/>
                </TD>
              </TR>
              <% 
                	}
                	
                	
             %>
              
</TBODY></TABLE></TD></TR>


		
         
            
            </TBODY></TABLE></TD>
            
            
            
            
    <TD width=15 background=YHChannelApply.files/new_023.jpg><IMG 
      src="YHChannelApply.files/new_023.jpg" border=0> </TD></TR></TBODY></TABLE>
      
      
      
      
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  
  <TR>
    <TD width=15><IMG src="YHChannelApply.files/new_024.jpg" border=0></TD>
    <TD align=middle width="100%" background=YHChannelApply.files/new_025.jpg 
    height=15></TD>
    <TD width=15><IMG src="YHChannelApply.files/new_026.jpg" 
  border=0></TD></TR>

  </TBODY></TABLE>
</BODY></HTML>
