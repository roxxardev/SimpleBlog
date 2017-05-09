<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-04-19
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Projekt PAI</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
        </div>
        <div id="navbar" class="navbar-right">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                    <li><a href="${pageContext.request.contextPath}/registration">Register</a></li>
                </ul>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/welcome">Welcome page</a></li>
                    <li><a href="${pageContext.request.contextPath}/list">User list</a></li>
                    <li><a href="${pageContext.request.contextPath}/profile/${pageContext.request.userPrincipal.name}">User
                        profile</a></li>
                </ul>
                <button onclick="document.forms['logoutForm'].submit()" class="btn btn-primary navbar-btn">
                    Logout
                </button>
            </c:if>
        </div>
        <form id="logoutForm" method="post" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</nav>
