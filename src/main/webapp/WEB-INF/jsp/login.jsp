<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-04-14
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<html>
<jsp:include page="header.jsp" />
<body>

<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="form-signin-heading">Login form</h2>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username" autofocus>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="btn btn-lg btn-primary btn-block" type="submit">log in</button>
            <h4 class="text-center"><a href="${pageContext.request.contextPath}/registration">Create new account</a> </h4>
        </div>
    </form>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
