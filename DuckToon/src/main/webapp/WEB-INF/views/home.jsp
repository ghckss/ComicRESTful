<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="com.triangle.utils.CollabFilter" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form method="post" action="http://http://localhost:8080/rel/images">
	<input type="file" name="dd"/>
	<input type="submit"/>
	
</form>

<img src="/resources/je.jpg"></img>

</body>
</html>
