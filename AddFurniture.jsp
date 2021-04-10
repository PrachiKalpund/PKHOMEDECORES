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
<div style="color:Brown; font-size:20px;">

 <% 
  String status = (String)request.getAttribute("Success");
  if(status!= null)
	    out.print(status);
 %>
 </div>
<form action="FurnitureServlet" method="post">
<input type= "hidden" name="operation" value= "addFurniture"> 
<table>
    <tr>
    <td>Name</td>
    <td><input type="text" name="FurnitureName"></td>
    </tr>
    <tr>
    <td>Category</td>
    <td><input type="text" name="FurnitureCat"></td>
    </tr>
     <tr>
    <td>Prize</td>
    <td><input type="text" name="FurniturePrice"></td>
    </tr>
    <tr>
    <td><input type="submit" name="Add Furniture"></td>
    <td><input type="Reset" value="Cancel"></td>
    </tr>
</table>
</form>
 <!-- Footer start -->
    <div class="footer grid_20">
    

     	 <br><br> <span class="footer_headtext">Quick Links:</span> <br>

      <a href="Home.jsp">HOME</a> &nbsp;| &nbsp;
      <a href="FurnitureServlet.html">FURNITURE MENU</a>&nbsp;| &nbsp;
      <a href="Login.jsp">LOGIN</a> &nbsp;| &nbsp;
      <a href="AddCustomer.jsp">REGISTER</a> &nbsp;| &nbsp;
      <a href="ContactUs.jsp">CONTACT</a>
      <br> 
     <span style="color: BLACK;"> Copyright &copy; 2021 PRACHI KALPUND</span>
    </div>
    <!-- Footer End -->
</body>
</html>
