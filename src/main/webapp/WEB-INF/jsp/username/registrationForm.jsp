<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InterTechUserName</title>
</head>
<body>
   <h3>UserName form</h3>
   <hr />

   <form:form action="saveUser" method="post" modelAttribute="usernamesuggestion">
      <table>
         <tr>
            <td>User Name</td>
            <td><form:input path="username" /></td>
         </tr>
         <tr>
            <td></td>
            <td><form:button>Submit</form:button></td>
         </tr>
      </table>
   </form:form>

</body>
</html>