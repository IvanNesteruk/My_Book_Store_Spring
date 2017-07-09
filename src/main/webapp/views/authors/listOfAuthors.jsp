<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/styles/main.css" rel="stylesheet"/>






<div style="text-align: center; margin-top: 1%">
	<form:form modelAttribute="author" method="post" action="saveAuthor">
		${AuthorNameException}
		<form:input path="name" placeholder="nameOfAuthor"/>
		<form:input path="surname" placeholder="surnameOfAuthor"/>

		<form:select path="country" items="${coutries}" itemLabel="nameOfCountry" itemValue="id"/>

		<input type="submit" name="saveAuthor" value="SAVE" />
		<input type="reset" value="RESET">
	</form:form>
	</div>
	
	<table style="border: 1px solid black">
		<tr>
			<th style="border: 1px solid black">Name of Author</th>
			<th style="border: 1px solid black">Surname of Author</th>
			<th style="border: 1px solid black">Country</th>
			<th style="border: 1px solid black">Delete</th>
			<th style="border: 1px solid black">Update</th>	
		</tr>
		
		<c:forEach var="a" items="${authors}">
			<tr>
				<td style="border: 1px solid black">${a.name}</td>
				<td style="border: 1px solid black">${a.surname}</td>
				<td style="border: 1px solid black">${a.country.nameOfCountry}</td>
				<td style="border: 1px solid black"><a href="/deleteAuthor/${a.id}">Delete</a></td>
				<td style="border: 1px solid black "><a	href="/updateAuthor/${a.id}" target="_blank">Update</a></td>
					 <br>
			</tr>
		</c:forEach>
	</table>
