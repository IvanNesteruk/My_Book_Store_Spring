<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link rel="stylesheet" type="text/css" href="/styles/signUp.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/signUp.js"></script>

<div class="form-wrap">
    <div class="tabs">
        <h3 class="signup-tab"><a class="active" href="#signup-tab-content">Sign Up</a></h3>
        <h3 class="login-tab"><a href="#login-tab-content">Login</a></h3>
    </div><!--.tabs-->

    <div class="tabs-content">
        <div id="signup-tab-content" class="active">
            <form:form modelAttribute="user" class="signup-form" method="post">

                <h3 style="text-align: center;color: red">${UserNameException}</h3>
                <form:input path="name" type="text" class="input" id="user_name" autocomplete="off"
                            placeholder="Username"/>

                <h3 style="text-align: center;color: red">${UserEmailException}</h3>
                <form:input path="email" type="text" class="input" id="user_email" autocomplete="off"
                            placeholder="Email"/>

                <h3 style="text-align: center;color: red">${UserPasswordException}</h3>
                <form:input path="password" type="password" class="input" id="user_pass" autocomplete="off"
                            placeholder="Password"/>
                <input type="submit" class="button" value="Sign Up">

            </form:form>
        </div>

        <div id="login-tab-content">

            <form:form class="login-form" action="/login" method="post">

                <h3 style="text-align: center;color: red">${exception}</h3>

                <h3 style="text-align: center;color: red">${UserNameException}</h3>

                <input name="username" type="text" class="input" id="user_login" autocomplete="off"
                       placeholder="Username">

                <h3 style="text-align: center;color: red">${UserPasswordException}</h3>
                <input name="password" type="password" class="input" id="user_pass" autocomplete="off"
                       placeholder="Password">

                <input type="submit" class="button" value="Login">

            </form:form>
        </div>
    </div>
</div>

<table style="border: 1px solid black">
    <tr>
        <th style="border: 1px solid black">username</th>
        <th style="border: 1px solid black">email</th>
        <th style="border: 1px solid black">role</th>
        <th style="border: 1px solid black">delete</th>
        <th style="border: 1px solid black">update</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td style="border: 1px solid black">${user.name}</td>
            <td style="border: 1px solid black">${user.email}</td>
            <td style="border: 1px solid black">${user.role}</td>
            <td style="border: 1px solid black"><a
                    href="/deleteUser/${user.id}">delete</a></td>
            <td style="border: 1px solid black "><a
                    href="/updateUser/${user.id}" target="_blank">update</a></td>
            <br>
        </tr>
    </c:forEach>
</table>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>
