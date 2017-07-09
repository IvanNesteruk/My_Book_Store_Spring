<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/8/2017
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>order date</th>
            <th>books</th>
            <th>total price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${user.orders}">
            <tr>
                <td>
                        ${order.localDateTime}
                </td>
                <td>
                    <c:forEach items="${order.books}" var="book">
                        ${book.titleOfBook} <br>
                        ${book.priceOfBook} <br>
                    </c:forEach>
                </td>
                <td>
                    <c:out value="${order.totalPrice}">Total price</c:out>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>