<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<%--<script src="http://code.jquery.com/jquery-2.0.3.min.js" data-semver="2.0.3" data-require="jquery"></script>--%>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" data-semver="3.1.1" data-require="bootstrap"></script>
<script src="http://bootboxjs.com/bootbox.js"></script>

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
		
		<c:forEach var="a" items="${authors.content}">
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


<div style="display: flex; justify-content: center; margin-left: 10%">
	<div class="col-md-12 col-xs-12">
		<div class="row">
			<div class="col-md-2 col-xs-6">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name"/>
						<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-12 text-center">
				<custom:pageable page="${authors}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
			</div>
			<div class="col-md-2 col-xs-6">
				<custom:size posibleSizes="1,2,5,10" size="${authors.size}"/>
			</div>
		</div>
	</div>
</div>
</div>
</div>

<input type="hidden" name="csrf_name"
	   value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
	   value="${_csrf.token}"/>

