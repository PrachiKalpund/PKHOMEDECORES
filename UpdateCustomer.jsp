<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.pkhomedecores.pojo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Customer c = (Customer)session.getAttribute("Custtoupdate");
String status = (String)request.getAttribute("Failure");
if(status!=null)
	out.print(status);
%>
<jsp:include page ="Header.jsp"></jsp:include>
<form method="post" action="CustomerServlet">
<input type="hidden" name="operation" value="updateCust">
<input type="hidden"  name="CustId" value=<%=c.getCustId()%>>
<table>

<tr>
<td>Name:</td>
<td><input type="text" name="custName" value=<%=c.getCustName() %>></td>
</tr>

<tr>
<td>Email:</td>
<td><input type="text" name="custEmail" value=<%=c.getCustEmail() %>></td>
</tr>

<tr>
<td>Password:</td>
<td><input type="text" name="custPassword" value=<%=c.getCustPass() %>></td>
</tr>

<tr>
<td>Contact:</td>
<td><input type="text" name="custContact" value=<%=c.getCustContact() %>></td>
</tr>

<tr>
<td>Address:</td>
<td><input type="text" name="custAddress" value=<%=c.getCustAddress() %>></td>
</tr>

<tr>
<td><input type="submit" value="Submit"></td>
<td><input type="Reset" value="Clear"></td>
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