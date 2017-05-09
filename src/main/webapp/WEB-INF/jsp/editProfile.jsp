<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-05-08
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"/>
<body>


<div class="container">

    <form:form method="POST" modelAttribute="user">
        <h2 class="form-signin-heading">Edit profile</h2>
        <spring:bind path="email">
            <div class="form-group">
                <label for="email">Email:</label>
                <form:input path="email" cssClass="form-control" placeholder="Email"/>
            </div>
        </spring:bind>
        <spring:bind path="about">
            <div class="form-group">
                <form:textarea path="about" cssClass="form-control" rows="2" placeholder="About"></form:textarea>
            </div>
        </spring:bind>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
