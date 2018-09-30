<%--
  Created by IntelliJ IDEA.
  User: serhii
  Date: 27.05.18
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="nav">
    <div class="container">
        <div class="logo">
            <a href="#">
                <img class="header-logo-img" src="/img/logo.png">
            </a>
        </div>
        <div class="header-numbers">
            <div class="header-number">
                +38 (099) 5521395
            </div>
            <div class="header-number">
                +38 (096) 8381538
            </div>
        </div>
        <div id="mainListDiv" class="main_list">
            <ul class="navlinks">
                <li class="menu1"><a href="main">Головна</a></li>
                <li class="menu2"><a href="#">Новини</a></li>
                <li class="menu3"><a href="#">Контакти</a></li>
                <li class="goright dropdown menu4">
                    <a href="javascript:void(0)" class="dropbtn">Кабінет</a>
                    <div class="dropdown-content">
                        <sec:authorize access="isAuthenticated()">
                            <a href="basket">Корзина</a>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <a href="<c:url value="/logout" />"> Вихід</a>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <a href="login"> Вхід</a>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <a href="registration"> Реєстрація</a>
                        </sec:authorize>
                    </div>

                </li>
            </ul>
        </div>
        <span class="navTrigger">
                <i></i>
                <i></i>
                <i></i>
            </span>
    </div>
</nav>

<section class="home">
</section>
<div class="main-before-slider"></div>


<script>
    $('.navTrigger').click(function () {
        $(this).toggleClass('active1');
        console.log("Clicked menu");
        $("#mainListDiv").toggleClass("show_list");
        $("#mainListDiv").fadeIn();

    });

    $(window).scroll(function () {
        if ($(document).scrollTop() > 0) {
            $('.nav').addClass('affix');

        } else {
            $('.nav').removeClass('affix');
        }
    });
</script>
