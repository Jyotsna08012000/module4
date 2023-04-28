<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserController" method="post">
         <table>
         
             <tr>
                <td>First Name :</td>
                <td><input type="text" name="fname"></td>
            </tr>
             <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lname"></td>
            </tr>
             <tr>
                <td>Email :</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Mobile :</td>
                <td><input type="text" name="mobile"></td>
            </tr>   
           
            <tr>
                <td>Password :</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="register"></td>
            </tr>
            
            </table>
            </form>


</body>
</html>