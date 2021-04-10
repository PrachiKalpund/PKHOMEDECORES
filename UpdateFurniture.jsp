<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.pkhomedecores.pojo.Furniture" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div style="color:Brown;font-size:20px;">
<% Furniture f = (Furniture)session.getAttribute("FurnitureToUpdate");
String status = (String)request.getAttribute("Failure");
if(status!=null)
	out.print(status);
%>
</div>
<form action="FurnitureServlet" method="post">
<input type="hidden" name ="operation" value="updateFurniture">
<input type="hidden" name="FurnitureId" value=<%=f.getFurnitureId()%>> 
<table>
<tr>
<td>Name:</td>
<td><input type="text" name="FurnitureName" value=<%=f.getFurnitureName()%>></td>
</tr>
<tr>
<td>Category:</td>
<td><input type="text" name="FurnitureCategory" value=<%=f.getFurnitureCategory()%>></td>
</tr>
<tr>
<td>Price:</td>
<td><input type="text" name="FurniturePrice" value=<%=f.getFurniturePrice()%>></td>
</tr>
<tr>
<td><input type="submit" value="Update"></td>
<td><input type="Reset" value="Clear"></td>
</tr>
</table>
</form>
</body>
</html>