<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.List,com.pkhomedecores.pojo.Furniture" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%
 String userEmail=(String)session.getAttribute("userEmail");
 String adminEmail=(String)session.getAttribute("adminEmail");
 %> --%>
<jsp:include page="Header.jsp"></jsp:include>
<!-- 
jsp: java server pages
html code and java
we can write the java code in scriplet tag 
 -->
 <div style="color:Browm; font-size:20px;">
 <% 
 List<Furniture> flist = (List<Furniture>)session.getAttribute("FurnitureList");
  String status = (String)request.getAttribute("Success");
  if(status!= null)
	    out.print(status);
 %>
 <body>
<%
String userEmail = (String)session.getAttribute("userEmail");
String adminEmail = (String)session.getAttribute("adminEmail");
%>
<h3>Furniture List</h3>
 <table border="2">
    <thead>
       <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Category</th>
          <th>Price</th>
      </tr>
    </thead>
   <tbody>
     
<% for (Furniture f: flist)  {
     %> 
    <tr>
      <td><%=f.getFurnitureId()%></td>
      <td><%=f.getFurnitureName() %></td>
      <td><%=f.getFurnitureCategory()%></td>
      <td><%=f.getFurniturePrice() %></td>
     
     <!--URL Rewriting "servletName?parameterlist"
always takes us to doGet() of servlet.
servlet doGet() we already have the code for displaying product List
So to differentiate bewteen the operations,we use operation.
-->
<%if(adminEmail != null){ %>
<td><a href="FurnitureServlet?id=<%=f.getFurnitureId()%>&operation=delete">Delete</a></td>
<td><a href="FurnitureServlet?id=<%=f.getFurnitureId()%>&operation=getFurnitureObj">Update</a></td>
<%} %>
<%if(userEmail != null){ %>
<td><a href="CartServlet?FurnitureId=<%=f.getFurnitureId()%>&operation=addToCart">Add To cart</a></td>
<%} %>
</tr>
<%} %>
</tbody>
      </table>
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
       <%-- <jsp:forward page="Home.jsp"></jsp:forward> --%>
</html>