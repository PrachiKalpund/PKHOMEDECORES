<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=2.0">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<div style="color:Brown;font-size:25px;">
<%
String status1 = (String)request.getAttribute("Success");
if(status!=null)
	out.print(status);
%>
</div>
 <h2> 
        <span style="color: brown;">WELCOME TO PK HOMEDECORES</span> 
      </h2>
<tr>
            <td>
              <br>
              Contact:


              +91 1235424214
              <br>
              &emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;+91 2345287400
              <br><br>
              <span class="footer_headtext"> Email:</span>
              <a style=" color:brown; text-decoration: none;" href="mailto:pkhomedecores@gmail.com">pkhomedecores@gmail.com </a>

            </td>
          </tr>
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