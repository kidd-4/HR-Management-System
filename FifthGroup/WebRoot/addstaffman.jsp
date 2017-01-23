<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加调配人员信息</title>
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
	<form action="doAddDivision" method="post">
        <table border="1" align="center" width="50%">
            <tr align="center" bgcolor="lightblue">
                <td><h1>增加调配人员信息</h1></td>
            </tr>
            <tr align="center">
                <td>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:<input type="text" name="staffID"   style="width:150px;" />  </td>
          
            <tr>
                <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="Name"    style="width:150px;"/>  </td>
            </tr>
			  <tr>
                <td>变动时间:
                    <input type="text" name="time" style="width:150px" />  
                </td>
            </tr>
			  
                <td>变动原因:
                    <input type="text" name="resaon" style="width:150px" />  
                </td>
            </tr>
			  <tr>
                <td>变动类别:
                <select style="width:150px;"   name="category">
                        <option>开除</option>
                        <option>贬职</option>
                        <option selected="selected">调职</option>
                        <option>退休</option>
                        <option>晋升</option>
                     </select>
            </tr>
            <td>
			  <tr>
			  
            
            <tr bgcolor="lightblue">
                <td>
                    <!--<input type="submit" value="提交" />-->
                     <input type="submit" value="提交" />
                    <input type="reset" value="重置" style="width:60px;" />
                </td>
            </tr>
        </table>
	</form>
 
 
 
 
</body>
</html>