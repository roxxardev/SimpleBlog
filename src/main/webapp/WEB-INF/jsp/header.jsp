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
<link rel='stylesheet' href='webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
<link rel="stylesheet" href="../../css/common.css">
</head>

<nav class="navbar navbar-inverse" >
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="welcome">Home</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/login">Login</a> </li>
                <li><a href="${pageContext.request.contextPath}/list">User list</a> </li>
                <li><a href="${pageContext.request.contextPath}/registration">Register</a> </li>
            </ul>
        </div>
    </div>
</nav>
