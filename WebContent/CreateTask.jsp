<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Task</title>
</head>
<body>
	<h3>Create Task</h3>     
    <p style="color: red;">${errorString}</p>
	<form method="post" action="${pageContext.request.contextPath}/CreateTask">
		<table border="0">
            <tr>
               <td>Titre</td>
               <td><input type="text" name="Titre" value="${Task.id}" /></td>
            </tr>
            <tr>
               <td>Descriptif</td>
               <td><input type="text" name="Descriptif" value="${Task.descriptif}" /></td>
            </tr>
            
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="GetList">Cancel</a>
               </td>
            </tr>
         </table>
     </form>
</body>
</html>