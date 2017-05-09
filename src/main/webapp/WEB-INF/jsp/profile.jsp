<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-05-07
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"/>
<body>

<div class="container">

    <h1>User: ${user.username} profile</h1>
    <br/>
    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${user.id}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Username</label>
        <div class="col-sm-10">${user.username}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Registration date</label>
        <div class="col-sm-10">${user.registrationDate}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Email</label>
        <div class="col-sm-10">${user.email}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">About</label>
        <div class="col-sm-10">${user.about}</div>
    </div>

    <c:if test="${pageContext.request.userPrincipal.name == user.username}">
        <button class="btn btn-danger"
                onclick="location.href='${pageContext.request.contextPath}/profile/${user.username}/delete'">Delete user
        </button>
    </c:if>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
