<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InterTechUserName</title>
</head>
<body>
 <table>
      <tr>
         <td>Entered UserName : ${usernamesuggestion.username}</td>
      </tr>
       <tr>
         <td>Result : ${resultvaalues.message}</td>
      </tr>
      <c:forEach  items="${resultvaalues.suggestedUserNames}" var="suggestions">
       <tr>
         <td>Suggested UserNameList : ${suggestions}</td>
      </tr>
      
</c:forEach >
     </table>

  
</body>
</html>