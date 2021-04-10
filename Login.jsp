<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form action="LoginServlet" method="post">
<!-- Default method is get so all the parameters are visible so we us post -->
<table>
<div style="color:Brown;font-size:20px;">

<%
String status = (String)request.getAttribute("Failure");
if(status!=null)
	out.print(status);
%>
</div>
<tr>
<td>Type: </td>
<td><input type="radio" name="type" value="user">User
    <input type="radio" name="type" value="admin">Admin
</td>
</tr>
<tr>
<td>Email: </td>
<td><input type="text" name="custEmail"></td>
</tr>
<tr>
<td>Password: </td>
<td><input type="password" name="custPass"></td>
</tr>

<tr>
<td><input type="submit" value="Login"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>

</body>
</html>