<%--
  Created by IntelliJ IDEA.
  User: serhii
  Date: 27.05.18
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>basket</title>
    <link rel="stylesheet" href="/css/headStyle.css">
    <link rel="stylesheet" href="/css/footStyle.css">
    <link rel="stylesheet" href="/css/basketStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div class="wrapper">
    <%@include file="header.jsp" %>

    <div class="main-wrapper">
        <h1>Ваша Корзина</h1>

        <div class="basket-product">
            <div class="basket-img">
                <img class="b-img" src="/img/watch1.jpg" alt="">
            </div>
            <div class="basket-product-name">
                Назва товару: test 1
            </div>
            <div class="basket-quantity">
                Кількість: 1
            </div>
            <div class="basket-price">
                <div class="price">Ціна товару:</div>
                250$
            </div>
        </div>
        <div class="basket-product">
            <div class="basket-img">
                <img class="b-img" src="/img/watch4.jpg" alt="">
            </div>
            <div class="basket-product-name">
                Назва товару: test 3
            </div>
            <div class="basket-quantity">
                Кількість: 1
            </div>
            <div class="basket-price">
                <div class="price">Ціна товару:</div>
                400$
            </div>
        </div>

        <div class="basket-pay">
            <div class="basket-total">
                <div class="price1">Загальна сума:</div>
                650$
            </div>
        </div>
        <div class="basket-button">
            <sec:authorize access="isAuthenticated()">
                <a class="none" href="addToBasket">
                    <div class="prod-buy-button">Перейти до оплати</div>
                </a>
            </sec:authorize>
        </div>


    </div>


    <%@include file="footer.jsp" %>

</div>
</body>
</html>
