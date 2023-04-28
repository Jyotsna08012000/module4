
<%@page import="model.StudentModel"%>
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
 StudentModel s = null;
    if(session.getAttribute("data")!=null){
    	s = (StudentModel)session.getAttribute("data");
    }
    else{
    	response.sendRedirect("Register.jsp");
    }
 %>

<form action="Student" method="post">
         <table>
         <h3>Student Information</h3>
             <tr> 
                <td>First Name :</td>
                 <td><input type="text" name="fname" value="<%=s.getFname()%>"></td>
            </tr>
             <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lname" value="<%=s.getLname()%>"></td>
            </tr>
             <tr>
                <td>Email :</td>
                <td><input type="text" name="email" value="<%=s.getEmail()%>"></td>
            </tr>
            <tr>
                <td>Mobile :</td>
                <td><input type="text" name="mobile" value="<%=s.getMobile()%>"></td>
            </tr>
            <tr>
                <td>Gender :</td>
                <td><input type="text" name="gender" value="<%=s.getGender()%>"></td>
            </tr>
           
            <tr>
                <td>Password :</td>
                <td><input type="text" name="password" value="<%=s.getPassword()%>"></td>
            </tr>
            <tr>
              </table>
            </form>
            

</body>
</html>