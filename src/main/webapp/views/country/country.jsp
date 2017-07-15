<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="country" method="post" action="/saveCountry">
    ${CountryNameException}
    <form:input path="nameOfCountry"/>
    <input type="submit" name="saveCountry" value="SAVE" />
    <input type="reset" value="RESET">
</form:form>

<table class="border">
    <tr>
        <th>Name of country</th>
        <th>Delete</th>
        <th>Update</th>
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

