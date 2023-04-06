<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %> 
<%@page import="helper.Datahelper" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>View Student Records</h1>
<table border="1">
<tr><th>Rno</th><th>Name</th><th>Branch</th><th>Fees</th></tr>
<%
//Class.forName("com.mysql.jdbc.Driver");
//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","nidhi@123");
//Statement st = conn.createStatement();
//ResultSet res = st.executeQuery("select * from student");
Datahelper obj = new Datahelper();
obj.makeConnection();
ResultSet res = obj.dqlRecord("select * from student");
while(res.next())
{ %>
	
	<tr><td><%= res.getString(1) %></td><td><%= res.getString(2) %></td><td><%= res.getString(3) %></td><td><%= res.getString(4) %></td>
	<td><a href="edit.jsp?q=<%= res.getString(1) %>"><img src="edit.png" width="50" height="50"></a> | <a href="delete.jsp?q=<%= res.getString(1) %>"><img src="delete.png" width="50" height="50"/></a></td>
	</tr>
<%}



%>
</table>
<a href="Student.jsp">New Student Record </a>
</body>
</html>