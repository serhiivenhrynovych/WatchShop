<%--
  Created by IntelliJ IDEA.
  User: serhii
  Date: 28.05.18
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/css/headStyle.css">
    <link rel="stylesheet" href="/css/footStyle.css">
    <link rel="stylesheet" href="/css/logStyle.css">
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet'>
    <link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>

<%@include file="header.jsp" %>


<div class="container-fluid content-wrapper loginpol" id="content">
    <div class="title">
        Registration in "Magic Time"
    </div>
    <br>
    <br>

    <div class="col-65">
        <form action="createUser" method="post">

            <label for="fname">Username</label>
            <br>
            <input type="text" pattern="^[a-zA-Z]{3,15}$" id="fname" name="username" placeholder="Username" required>
            <br>
            <label for="inputMail">Email</label>
            <br>
            <input type="email" id="inputMail" name="email" placeholder="example@gmail.com" required>
            <br>
            <label for="inputPass">Password</label>
            <br>
            <input type="password" id="inputPass" name="password" placeholder="********" required>
            <br>
            <label for="address">Address</label>
            <br>
            <input type="text" id="address" name="address" placeholder="Address">
            <br>
            <label for="phone">Last Name</label>
            <br>
            <input type="text" id="phone" name="phone" placeholder="Phone number">
            <br>
            <br>
            <input type="submit" value="Register">

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>

        </form>
    </div>
    <div class="bottom">
        <a href="login" class="btn1">Log in</a>
    </div>
</div>

<%@include file="footer.jsp" %>

</body>
</html>
