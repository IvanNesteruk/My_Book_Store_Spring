<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="/css/main.css" rel="stylesheet"/>

<div style="text-align: center; margin-top: 10px">

    <form:form modelAttribute="genre" method="post" action="/saveGenre">
        <div class="container">
            <div class="form-group">
                <label for="genreOfBook">Genre:</label>
                <form:input class="form-control" path="genreOfBook"
                            placeholder="genreOfBook"></form:input>
            </div>

            <input type="submit" name="saveGenre" value="SAVE"/>
            <input type="reset" value="RESET"></div>
    </form:form>


</div>

<table style="border: 1px solid black">
    <tr>
        <th style="border: 1px solid black">Genre of book</th>
        <th style="border: 1px solid black">Delete</th>
        <th style="border: 1px solid black">Update</th>
    </tr>

    <c:forEach var="g" items="${genres}">
        <tr>
            <td style="border: 1px solid black">${g.genreOfBook}</td>
            <td style="border: 1px solid black"><a href="/deleteGenre/${g.id}">Delete</a></td>
            <td style="border: 1px solid black "><a href="/updateGenre/${g.id}" target="_blank">Update</a></td>
        </tr>
    </c:forEach>
</table>