<%--
  Created by IntelliJ IDEA.
  User: serhii
  Date: 27.05.18
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title>productPage</title>
    <link rel="stylesheet" href="/css/headStyle.css">
    <link rel="stylesheet" href="/css/footStyle.css">
    <link rel="stylesheet" href="/css/productStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>

<div class="wrapper">
    <%@include file="header.jsp" %>
    <div class="main-wrapper">
        <h1>Watch detail</h1>
        <h3>Детальна інформація про продукт</h3>

        <div class="prodLeft">
            <img class="prod-img" src="${product.image}" alt="image">
        </div>
        <div class="prodRight">
            <div class="prod-name center">${product.productName}</div>
            <div class="prod-price center">
                $${product.price}
            </div>
            <div class="center prod-buy">
                <sec:authorize access="isAuthenticated()">
                    <a class="none" href="addToBasket"><div class="prod-buy-button">Перейти до оплати</div></a>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <a class="none" href="login"><div class="prod-buy-button">Перейти до оплати</div></a>
                </sec:authorize>

                <br>
                <a class="none" href=""><div class="prod-buy-button">Добавити в корзину</div></a>
            </div>
        </div>

        <br>

        <div class="prodEnd">
            <h2>Description</h2>
            <p>Bulova 96A120 is a super special Gents watch. Case material is Stainless Steel while the dial colour is Brown. This watch is market as water resistant. It means it can withstand slight splashes and rain, but is NOT to be immersed in water. We ship it with an original box and a guarantee from the manufacturer.</p>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</div>

</body>
</html>
