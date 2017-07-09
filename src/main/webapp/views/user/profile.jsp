<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <c:if test="${userBasket.books.size() != 0}">
                <th>Title</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>delete from basket</th>
                <th>
                        <%--<form:form action="/buy" method="post">--%>
                        <%--<button class="btn btn-default">buy</button>--%>
                        <%--</form:form>--%>
                </th>
            </c:if>
            <c:if test="${userBasket.books.size() == 0}">
                <th>
                    don't have any books in basket
                </th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <form:form action="/buy" method="post">
            <button class="btn btn-default">buy</button>
            <c:forEach var="book" items="${userBasket.books}">
                <tr>
                    <td>
                            ${book.titleOfBook}
                    </td>
                    <td>
                            ${book.priceOfBook}
                    </td>
                    <td>
                        <input name="quantity" placeholder="quantity" type="number" min="1" value="1"
                               required="required"/>
                    </td>
                    <td>
                        <a href="/deleteFromBasket/${userBasket.id}/${book.id}">delete</a>
                    </td>
                    <td>

                    </td>
                </tr>
            </c:forEach>
        </form:form>
        </tbody>
    </table>
</div>