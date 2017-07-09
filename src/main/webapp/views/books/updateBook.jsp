<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<title>Book update</title>

<c:url var="saveUrl" value="/updateBook/${bookAttribute.id}?${_csrf.parameterName}=${_csrf.token}"/>
<form:form modelAttribute="bookAttribute" method="POST" action="${saveUrl}" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="titleOfBook">Title of book</form:label></td>
            <td><form:input path="titleOfBook"/></td>
        </tr>

        <tr>
            <td><form:label path="priceOfBook">Price of book</form:label></td>
            <td><form:input path="priceOfBook"/></td>
        </tr>

        <tr>
            <td><form:label path="nameOfAuthor">Name of author</form:label></td>
            <td><form:input path="nameOfAuthor"/></td>
        </tr>

        <tr>
            <td><form:label path="surnameOfAuthor">Surname of author</form:label></td>
            <td><form:input path="surnameOfAuthor"/></td>
        </tr>

        <tr>
            <td><form:label path="yearOfPublishing">Year of publishing</form:label></td>
            <td><form:input path="yearOfPublishing"/></td>
        </tr>

        <tr>
            <td><form:label path="genre">Genre</form:label></td>
            <td><form:select path="genre" items="${genres}" itemLabel="genreOfBook" itemValue="id"/></td>
        </tr>

        <tr>
            <td><form:label path="pathImage">Image</form:label></td>
            <td><form:input path="pathImage" type="hidden"/></td>
            <td>
                <img src="/${bookAttribute.pathImage}" alt="NO IMAGE" width="20%" height="20%">
            </td>
        </tr>

        <tr>
            <input name="image" type="file">
        </tr>

    </table>
    <input type="submit" value="Save"/>
</form:form>
