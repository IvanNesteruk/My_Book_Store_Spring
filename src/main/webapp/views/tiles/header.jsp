<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">

                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/signUp" target="_blank"><spring:message code="label.sign_up"/> </a></li>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/listOfBooks" target="_blank"><spring:message code="label.books"/></a></li>
                    <li><a href="/listOfAuthors" target="_blank"><spring:message
                            code="label.authors"></spring:message></a></li>
                    <li><a href="/listOfGenres" target="_blank"><spring:message
                            code="label.genres"></spring:message></a></li>
                    <li><a href="/country" target="_blank"><spring:message code="label.countries"/></a></li>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_USER')">
                    <li><a href="/buyBooks" target="_blank"><spring:message code="label.buyBook"/></a></li>
                    <li><a href="/profile" target="_blank"><spring:message code="label.profile"/></a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="/openCityView" target="_blank"><spring:message code="label.magazines"/></a></li>
                    <li><a href="/openUserView" target="_blank"><spring:message code="label.users"/></a></li>
                    <li><a href="/history/" target="_blank"><spring:message code="label.history"/></a></li>
                    <li>
                        <form:form action="/logout" method="post">
                            <button class="btn btn-default"><spring:message code="label.logout"/></button>
                        </form:form>
                    </li>
                </sec:authorize>

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        <spring:message code="label.lang"/> <span class="caret"></span>
                        <ul class="dropdown-menu">
                            <li><a href="?lang=ua">ua</a></li>
                            <li><a href="?lang=en">en</a></li>
                        </ul>
                    </a>
                </li>

            </ul>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-8 col-md-8 col-sm-6 col-xs-4">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-6 hidden-sx"></div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/js/bootstrap.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<br>
<br>
<br>
<br>
<br>
