<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-04-19
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"/>
<body>

<div class="container">

    <h1>All Users</h1>

    <table class="table table-striped" style="width: auto;">
        <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Actions</th>
        </tr>
        </thead>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>
                    <button class="btn btn-info" onclick="location.href='${pageContext.request.contextPath}/profile/${user.username}'">Show profile</button>
                    <button class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/profile/${user.username}/delete'">Delete user</button>
                </td>
            </tr>
        </c:forEach>

    </table>

</div>

<jsp:include page="footer.jsp"/>
</body>

</html>
