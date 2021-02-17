<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Task</title>
</head>
<body>
<h3>Edit Task</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty task}">
         <form method="post" action="${pageContext.request.contextPath}/EditTask">
            <input type="hidden" name="Titre" value="${task.id}" />
            <table border="0">
               <tr>
                  <td>Titre</td>
                  <td style="color:red;">${task.id}</td>
               </tr>
               <tr>
                  <td>Descriptif</td>
                  <td><input type="text" name="Descriptif" value="${task.descriptif}" /></td>
               </tr>
               
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/GetList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>

</body>
</html>