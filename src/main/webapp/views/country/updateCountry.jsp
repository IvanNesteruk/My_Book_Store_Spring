<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.05.2017
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url var="saveUrl" value="/updateCountry/${countryAttribute.id}" />
<form:form modelAttribute="countryAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="nameOfCountry">Name</form:label></td>
            <td><form:input path="nameOfCountry"/></td>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>
</body>
</html>
