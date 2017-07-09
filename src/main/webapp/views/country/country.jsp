<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form modelAttribute="country" method="post" action="/saveCountry">
    <form:input path="nameOfCountry"/>
    <input type="submit" name="saveCountry" value="SAVE" />
    <input type="reset" value="RESET">
</form:form>

<table class="border">
    <tr>
        <th>Name of country</th>
    </tr>
    <ol>
        <c:forEach var="country" items="${countries}">
            <tr>
                <td style="border: 1px solid black">${country.nameOfCountry}</td>
                <td style="border: 1px solid black"><a
                        href="/deleteCountry/${country.id}">Delete</a></td>
                <td style="border: 1px solid black "><a
                        href="/updateCountry/${country.id}" target="_blank">Update</a></td>
                <br>
            </tr>
        </c:forEach>
    </ol>
</table>

