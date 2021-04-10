<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.List,com.pkhomedecores.pojo.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "Header.jsp"></jsp:include>
<div style="color:Brown; font-size:25px">
<%
List<Customer> clist = (List<Customer>)session.getAttribute("custlist");
String status = (String)request.getAttribute("Success");
if(status!=null)
	out.print(status);
%>
</div>
<div style="color:Brown; font-size:25px">
<%
status=(String)request.getAttribute("Failure");
if(status!=null)
	out.print(status);
%>
</div>
<!-- 
jsp: java server pages
-->
<%
String userEmail = (String)session.getAttribute("userEmail");
String adminEmail = (String)session.getAttribute("adminEmail");
%>
<form>
<h3>Customer List</h3>
<table>
<thead>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Contact</th>
<th>Address</th>
</tr>
</thead>
<tbody>
<% for(Customer c : clist)
{
%>
<tr>
<td><%=c.getCustId()%></td>
<td><%=c.getCustName()%></td>
<td><%=c.getCustEmail()%></td>
<td><%=c.getCustPass()%></td>
<td><%=c.getCustContact()%></td>
<td><%=c.getCustAddress()%></td>
<%if(userEmail!=null || adminEmail != null){ %>
<td><a href="CustomerServlet?id=<%=c.getCustId()%>&operation=delete">Delete</a></td>
<%} %>
<%if(userEmail!=null || adminEmail == null){ %>
<td><a href="CustomerServlet?id=<%=c.getCustId()%>&operation=update">Update</a></td>

<%
}
%>
</tr>
<%
}
%>

</tbody>
</table>
</form>

</body>
</html>