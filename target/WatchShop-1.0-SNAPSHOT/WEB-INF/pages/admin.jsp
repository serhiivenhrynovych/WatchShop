<%--
  Created by IntelliJ IDEA.
  User: serhii
  Date: 27.05.18
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title>adminPage</title>
    <link rel="stylesheet" href="/css/headStyle.css">
    <link rel="stylesheet" href="/css/footStyle.css">
    <link rel="stylesheet" href="/css/admStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div class="wrapper">
    <%@include file="header.jsp" %>

    <div class="main-wrapper adm-main">
        <h1>Привіт admin</h1>
        <h3>добавити новий продукт</h3>

        <form action="saveProduct" method="post" enctype="multipart/form-data">
            <input class="adm-type" type="text" name="productName" placeholder="Ім'я продукту" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Бренд" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Країна" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Тип ремінця" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Циферблад" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Додаткові особливості" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Тип роботи" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Форма" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Розмір" required>
            <br>
            <input class="adm-type" type="text" name="productName" placeholder="Стиль" required>
            <br>
            <input class="adm-type" type="number" name="price" placeholder="Price" required>
            <br>
            <input class="adm-type" type="file" name="image" placeholder="image" required>
            <br>
            <input class="adm-add-button" type="submit" value="Add product">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>
        <h3>Видалити продукт за ідентифікатором</h3>
        <form action="removeProduct" method="post">
            <input class="adm-type" type="number" name="id" placeholder="id of product">
            <br>
            <input class="adm-delete-button" type="submit" value="Delete product">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>
        <br>
        <br>
        <h3>Видалити користувача за ідентифікатором</h3>
        <form action="removeUser" method="post">
            <input class="adm-type" type="number" name="id" placeholder="id of user">
            <br>
            <input class="adm-delete-button" type="submit" value="Delete user">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>
    </div>

    <%@include file="footer.jsp" %>

</div>
</body>
</html>
