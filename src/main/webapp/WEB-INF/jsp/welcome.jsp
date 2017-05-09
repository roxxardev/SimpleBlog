<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-04-17
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"/>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome ${pageContext.request.userPrincipal.name} |
            <button onclick="document.forms['logoutForm'].submit()" class="btn btn-primary">Logout</button>
        </h2>
    </c:if>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
