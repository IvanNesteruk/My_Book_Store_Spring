<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/createNewOrder" method="post">

		<c:forEach var="user" items="${users}">
			<input type="radio" name="userId" value="${user.id}">${user.name}
			<a href="/profile/${user.id}">profile</a>
			<br>
		</c:forEach>
		<br>
		<br>
		<br>
		<c:forEach var="book" items="${books}">
			<input type="checkbox" name="bookIds" value="${book.id}">${book.titleOfBook}<br>
		</c:forEach>
		<button>save order</button>
	</form>
</body>
</html>