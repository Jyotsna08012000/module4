<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% String email =(String)request.getAttribute("email");%>
            <%int otp1=(Integer)request.getAttribute("otp"); %>
              
<form action="UserController" method="post">
         <table>
         <tr>
         <td> <input type="hidden" name="email" value="<%=email%>"></td>
		 <td><input type="hidden" name="otp1" value="<%=otp1%>"></td>
         </tr>  
             <tr>
                <td>Enter OTP :</td>
                <td><input type="text" name="otp2"></td>
            </tr>   
           
            
            <tr>
                <td><input type="submit" name="action" value="verify"></td>
            </tr>
            
            </table>
            </form>


</body>
</html>