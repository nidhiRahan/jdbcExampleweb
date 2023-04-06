<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.sql.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","nidhi@123");
Statement st = conn.createStatement();
ResultSet res = st.executeQuery("select * from student where rno='"+request.getParameter("q")+"'");
if(res.next())
{
%>
<form action="StudentUpdateSer" method="post">
<input type="text" name="txtrno" placeholder="Enter rno" value="<%= res.getString(1) %>" readonly="true" />
<br><br>
<input type="text" name="txtname" placeholder="Enter name" value="<%= res.getString(2) %>" />
<br><br>
<input type="text" name="txtbranch" placeholder="Enter branch" value="<%= res.getString(3) %>" />
<br><br>
<input type="text" name="txtfees" placeholder="Enter fees" value="<%= res.getString(4) %>"/>
<br><br>
<input type="submit" name="btnsubmit" value="Update" />



</form>

<%
}
%>

</body>
</html>