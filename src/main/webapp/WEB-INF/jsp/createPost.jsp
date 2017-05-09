<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-05-08
  Time: 03:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"/>

<body>

<div class="container">
    <form:form method="POST" modelAttribute="post">
        <h2 class="form-signin-heading">Create new post</h2>
        <spring:bind path="title">
            <div class="form-group">
                <label for="title">Title:</label>
                <form:input path="title" cssClass="form-control" placeholder="Title"/>
            </div>
        </spring:bind>
        <spring:bind path="tease">
            <div class="form-group">
                <form:textarea path="tease" cssClass="form-control" rows="2" placeholder="Tease"></form:textarea>
            </div>
        </spring:bind>
        <spring:bind path="postText">
            <div class="form-group">
                <form:textarea path="postText" cssClass="form-control" rows="5" placeholder="Post text"></form:textarea>
            </div>
        </spring:bind>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
