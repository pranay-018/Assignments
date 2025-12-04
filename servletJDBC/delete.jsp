<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter the Id to delete</h1>
	<form action="DeleteServlet" method="get">

		<label for="idnum">ID Number:</label><br> <input type="number"
			id="idnum" name="idnum" required><br> <br>
		<button type="submit">Submit</button>

	</form>
</body>
</html>