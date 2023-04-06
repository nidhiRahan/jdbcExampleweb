<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminSer" method="post">
<input type="text" name="txtuid" placeholder="Enter Userid" />
<br><br>
<input type="text" name="txtpass" placeholder="Enter Password" />

<br><br>
<input type="submit" name="btnsubmit" value="Login" />

</form>
<%
if(request.getParameter("q")!=null)
{
	out.print(request.getParameter("q"));
}


%>
</body>
</html>