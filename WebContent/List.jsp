<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToDoList</title>
</head>
<body>
	<h1>ToDo List</h1>
	 
	  
	  <p style="color: red;">${errorString}</p>
	 
 <c:choose>
 <c:when test="${sessionScope.statut == 'professeur'}">
     <h3>Welcome to the updatable ToDoList </h3>
    <table border="1" cellpadding="4" cellspacing="1" >
       <tr>
          <th>Titre</th>
          <th>Descriptif</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${List}" var="task" >
          <tr>
             <td>${task.id}</td>
             <td>${task.descriptif}</td>
             <td>
                <a href="EditTask?id=${task.id}&descriptif=${task.descriptif}">Edit</a>
             </td>
             <td>
                <a href="DeleteTask?id=${task.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>

 
    <a href="CreateTask" >Create Task</a>
    <a href="LoginServlet" >Log-out</a>
    </c:when>
    <c:otherwise>
    <h3>Welcome, here's your homeworks :)</h3>
    <table border="1" cellpadding="4" cellspacing="1" >
       <tr>
          <th>Titre</th>
          <th>Descriptif</th>
          
       </tr>
       <c:forEach items="${List}" var="task" >
          <tr>
             <td>${task.id}</td>
             <td>${task.descriptif}</td>
           </tr>  
       </c:forEach>
        <a href="LoginServlet" >Log-out</a>
    </c:otherwise>
</c:choose>
</body>
</html>