<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List,com.pkhomedecores.pojo.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String userEmail = (String)session.getAttribute("userEmail");
String adminEmail = (String)session.getAttribute("adminEmail");
%>
<jsp:include page="Header.jsp" ></jsp:include>
 <div style="color:Browm; font-size:20px;">
 <% 
List<Cart> ctlist = (List<Cart>)session.getAttribute("MyCart");
String status = (String)request.getAttribute("Success");
if(status!=null)
	out.print(status);
String status_f = (String)request.getAttribute("Failure");
if(status!=null)
	out.print(status_f);
%>
<h3>Product List</h3>
<form action="CartServlet" method="post">
<table>
<thead><tr><th>Id</th>
           <th>Name</th>
           <th>Price</th>
           <th>Quantity</th>
       </tr>
</thead>
</tbody>
<%
for (Cart ct:ctlist) {
%>
  <tr>
<td><%=ct.getCartId()%></td>
<td><%=ct.getFurnitureName()%></td>
<td><input type="text" name="Price" value="<%=ct.getFurniturePrice()%>" readonly></td>
<td><input type="number" name="Quantity" value="<%=ct.getQuantity()%>" min=1></td>
<td><a href="CartServlet?id=<%=ct.getCartId()%>&operation=delete">Delete</a></td>
</tr>
<%
}
 %>
</tbody>
</table>
<input type="submit" value="Place My Order">
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