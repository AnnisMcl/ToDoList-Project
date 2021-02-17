<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
    <h1>ToDoList</h1>
<body>
	<h3>Identification</h3>
    <p style="color: red;">${errorString}</p>

<form method="post" action = "${pageContext.request.contextPath}/LoginServlet">
    <input type="text" name="username" placeholder ="Username"/>
    <input type ="password" name="password" placeholder ="Password"/>
    Remember me
    <input type="checkbox" name="rememberMe" value= "Y" /> 
    <input type="submit" value= "Submit" />
	
</form>
</body>
</html>