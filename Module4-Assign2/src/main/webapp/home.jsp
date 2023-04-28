<%@page import="model.User"%>
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
 User u = null;
    if(session.getAttribute("data")!=null){
    	u = (User)session.getAttribute("data");
    }
    else{
    	response.sendRedirect("Register.jsp");
    }
 %>



 
         <table>
         <h3>Home Page</h3>
             <tr> 
                <td>First Name : <%=u.getFname() %></td>
                
            </tr>
             <tr>
                <td>Last Name : <%=u.getLname() %></td>
                
            </tr>
             <tr>
                <td>Email : <%=u.getEmail() %></td>
               
            </tr>
            <tr>
                <td>Mobile : <%=u.getMobile() %></td>
                
           
            <tr>
                <td>Password :  <%=u.getPassword()%></td>
               
            </tr>
             
               <tr>
               <form action="UserController" method="post">
               <input type="hidden" name="id" value="<%=u.getId()%>">
                <td><input type="submit" name="action" value="edit"></td>
            </tr>
           
           
              </table>
            </form>


</body>
</html>