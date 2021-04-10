<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String userEmail=(String)session.getAttribute("userEmail");
String adminEmail=(String)session.getAttribute("adminEmail");
String status = (String)request.getAttribute("Success");
if(status!=null)
	out.print(status);
%>
<div style="clear:both; width:960px;">
<ul>

<li><a href="Home.jsp">Home</a></li>
<li> <a href="FurnitureServlet">Furniture Menu</a></li>

<%if(userEmail==null && adminEmail == null){ %>
<li> <a href="Login.jsp">Login</a></li>
<li> <a href="AddCustomer.jsp">Register</a></li>
<%} %>
<%if(userEmail==null && adminEmail != null){ %>
<li><a href="AddFurniture.jsp">Add Furniture</a></li>
<li><a href="CustomerServlet">Customers</a></li>
<%} %>
<%if(userEmail!=null && adminEmail == null){ %>
<li><a href="CustomerServlet?operation=getCust">Edit Profile</a></li>
<li><a href="CartServlet">MyCart</a></li>
<li><a href="CartList.jsp">Order</a></li>
<%} %>
<%if(userEmail!=null || adminEmail != null){ %>
<li><a href="LoginServlet">Logout</a></li>
<%} %>
<li><a href="ContactUs.jsp">Contact</a></li>
<!-- <li> <a href="ChangePassword.jsp">Change Password</a></li>
<li> <a href="FurnitureList.jsp">Furniture List</a></li>
 -->


 </ul>
<hr>
</div>
<!-- End Of Furniture Menu -->
 <!-- Footer start -->
    <div class="footer grid_20">
   
     <span style="color: BLACK;"> Copyright &copy; 2021 PRACHI KALPUND</span>
    </div>
    <!-- Footer End -->
</body>
</html>
