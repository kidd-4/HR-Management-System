<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.icss.java.data.dao.*"%>
<%@ page import="com.icss.java.lyy.MyClass"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	String st="";
	String id = request.getParameter("id");
	if(id.compareTo("add")!=0){
		st="当前位置：培训项目修改";
	}
	else st="当前位置：培训项目添加";
	
	
	
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
  border=0></TD></TR></TBODY>
  
  
  </TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15 background=YHChannelApply.files/new_022.jpg><IMG 
      src="YHChannelApply.files/new_022.jpg" border=0> </TD>
    <TD vAlign=top width="100%" bgColor=#ffffff>
      <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
        <TR>
          <TD class=manageHead><%=st %></TD></TR>
        <TR>
          <TD height=2></TD></TR></TABLE>
      <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" 
      align=center border=0>
        <TBODY>
        <TR>
          <TD height=25>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              </TBODY></TABLE></TD></TR>
        <TR>
          <TD>
            <TABLE id=grid 
            style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" 
            cellSpacing=1 cellPadding=2 rules=all border=0>
              <TBODY>
              
              <% if(id.compareTo("add")!=0){
              		TrainPro tp=MyClass.listPro.get(Integer.parseInt(id));
              
              
              %>
              <FORM id=form1 name=form1 action="doProUpdate?change=1"  method="post">
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	培训项目id：<input name="id" type="text" readonly="readonly" value= <%=tp.getId()%> />  
                </center>
              </TR>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	类别名称：
                	<SELECT name=categoryid > 
                	<%
                	MyClass.getListCategory();
                	TrainCategory tc=new TrainCategory();
                	String str="";
                	for(int i=0;i<MyClass.listCategory.size();i++)
                	{	
                		tc=MyClass.listCategory.get(i);
                		str=tc.getName(); 
 
                	%>
                	
                    <OPTION value=<%=tc.getId()%>>  <%=str%></OPTION> 
                    
                    
                    <%} %>
                    </SELECT>
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	<!--  
                	<input name="category" type="text" value= <%//=LyyDao.getCategoryName(tp.getCategory(),tp.getClass())%> />               
                	 -->	
                	
                	</center>
              </TR>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	开始时间：<input name="startdate" type="text" value= <%=tp.getStartdate()%>>      
                </center>
              </TR>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	结束时间：<input name="enddate" type="text" value= <%=tp.getEnddate()%>>      
                </center>
              </TR>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	<input type="submit" value="提交" />
                	<input type="reset" value="重置" />
                </center>
              </TR>
              
  </form>
              <%}else{ %>
         <FORM action="doProUpdate?change=0"  method="post">
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	培训项目id：<input name="id" type="text"  />  
                </center>
              </TR>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	类别名称：
                	<SELECT name=categoryid> 
                	<%
                	MyClass.getListCategory();
                	TrainCategory tc=new TrainCategory();
                	String str="";
                	for(int i=0;i<MyClass.listCategory.size();i++)
                	{	
                		tc=MyClass.listCategory.get(i);
                		str=tc.getName(); 
 
                	%>
                	
                    <OPTION value=<%=tc.getId()%>>  <%=str%></OPTION> 
                    
                    
                    <%} %>
                    </SELECT>
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	<!--  
                	<input name="category" type="text" value= <%//=LyyDao.getCategoryName(tp.getCategory(),tp.getClass())%> />               
                	 -->	
                	
                	</center>
              </TR>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	开始时间：<input name="startdate" type="text" >      
                </center>
              </TR>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	结束时间：<input name="enddate" type="text" >      
                </center>
              </TR>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <center>
                	<input type="submit" value="提交" />
                	<input type="reset" value="重置" />
                </center>
              </TR>
              
  </form>
              <%} %>
	</TBODY>
</TABLE>



</TD></TR>


		
         
            
            </TBODY></TABLE></TD>
            
            
            
            
    <TD width=15 background=YHChannelApply.files/new_023.jpg><IMG 
      src="YHChannelApply.files/new_023.jpg" border=0> </TD></TR></TBODY>
      </TABLE>
      
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  
  <TR>
    <TD width=15><IMG src="YHChannelApply.files/new_024.jpg" border=0></TD>
    <TD align=middle width="100%" background=YHChannelApply.files/new_025.jpg 

    height=15></TD>
    <TD width=15><IMG src="YHChannelApply.files/new_026.jpg" 
  border=0></TD></TR>

  </TBODY></TABLE>
  
  
  
  </FORM>
  
  
  
</BODY></HTML>
