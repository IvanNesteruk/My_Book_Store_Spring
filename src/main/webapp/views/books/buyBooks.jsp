<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/styles/buyBooks.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<script type='text/javascript' src="<c:url value="/js/buyBooks.js"/>"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="<c:url value="/js/index.js"/>"></script>
<script src="<c:url value="/js/search.js"/>"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<input type="number" id="myInput" onkeyup="loadBookPrices()" placeholder="Search for prices.." title="Type in a price">

<div style="margin-bottom: 10px; margin-top: 10px; width: 20%; float: right; padding-right: 10px">
    <div data-role="rangeslider">
        <p>
            <label for="amount">Price range:</label>
            <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
        </p>
        <label for="price-min">Min:</label>
        <input type="range" name="price-min" id="price-min" value="200" min="0" max="1000" onchange="changeLabel()"
               oninput="searchPrices()">
        <label for="price-max">Max:</label>
        <input type="range" name="price-max" id="price-max" value="800" min="0" max="1000" onchange="changeLabel()"
               oninput="searchPrices()">
    </div>
    <%--<input style="margin-top: 5px" type="text" class="form-control" id="searchIn" oninput="searchItems()"--%>
           <%--placeholder="Search..."/>--%>
</div>

<%--<div id="slider-range"></div>--%>

<script type="text/javascript">
    $(document).ready(function () {
        $('.add-to-cart').on('click', function () {
            //Scroll to top if cart icon is hidden on top
            $('html, body').animate({
                'scrollTop': $(".cart_anchor").position().top
            });
            //Select item image and pass to the function
            var itemImg = $(this).parent().find('img').eq(0);
            flyToElement($(itemImg), $('.cart_anchor'));
        });
    });
</script>

<div class="wrapper">
    <span><i class="cart_anchor"></i></span>

    <div class="clear"></div>
    <div class="items" id="searchDiv">
        <c:forEach items="${books}" var="book">
            <div class="item">
                <img src="${book.pathImage}" alt="NO IMAGE" width="150px" height="150px">
                <h2>${book.titleOfBook}
                    <p style="float: right">${book.priceOfBook}<em>$</em></p></h2>
                <sec:authorize access="isAuthenticated() && hasRole('ROLE_USER')">
                    <button style="margin: auto; display: block" class="add-to-cart"
                            onclick="window.location.href='/addIntoBasket/${book.id}'">Add to cart
                    </button>
                </sec:authorize>
            </div>
        </c:forEach>
    </div>
</div>


<!DOCTYPE html>
<html>
<head>
    <style>
        * {
            box-sizing: border-box;
        }

        #myInput {
            background-position: 10px 12px;
            background-repeat: no-repeat;
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 40px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }

        #myUL {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        #myUL li a {
            border: 1px solid #ddd;
            margin-top: -1px; /* Prevent double borders */
            background-color: #f6f6f6;
            padding: 12px;
            text-decoration: none;
            font-size: 18px;
            color: black;
            display: block
        }

        #myUL li a.header {
            background-color: #e2e2e2;
            cursor: default;
        }

        #myUL li a:hover:not(.header) {
            background-color: #eee;
        }
    </style>
</head>
<body>


<script>
    function loadBookPrices() {
        var prices = [];
        var massive = [];

        $.ajax({
            url: '/book?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'GET',
            success: function (res) {
                for (var i in res) {
                    prices.push((res[i].priceOfBook).toString());
                }
                console.log("prices = " + prices);
                var input, filter, i, div, div_2;

                input = document.getElementById("myInput");
                filter = input.value;
                div = document.getElementById("searchDiv");
                div_2 = div.getElementsByTagName("div");

                for (i = 0; i < div_2.length; i++) {
                    for (j = 0; j < prices.length; j++) {
                        if (prices[j].match(new RegExp(filter, 'gi'))) {
                            div_2[j].style.display = "";
                        } else {
                            div_2[j].style.display = "none";
                        }
                    }
                }
            },
            error: function (err) {
                console.log(err)
            }
        })


    }


</script>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>
</body>
</html>
