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
    	response.sendRedirect("home.jsp");
    }
 %>

<form action="UserController" method="post">

         <table>
         <h3>Edit Page</h3>
         <input type="hidden" name="id" value="<%=u.getId()%>">
             <tr> 
                <td>First Name :</td>
                 <td><input type="text" name="fname" value="<%=u.getFname()%>"></td>
            </tr>
             <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lname" value="<%=u.getLname()%>"></td>
            </tr>
             <tr>
                <td>Email :</td>
                <td><input type="text" name="email" value="<%=u.getEmail()%>"></td>
            </tr>
            <tr>
                <td>Mobile :</td>
                <td><input type="text" name="mobile" value="<%=u.getMobile()%>"></td>
           
            <tr>
                <td>Password :</td>
                <td><input type="text" name="password" value="<%=u.getPassword()%>"></td>
            </tr>
             
                <tr>
                <td><input type="submit" name="action" value="update"></td>
            </tr>
           
              </table>
            </form>

</body>
</html>