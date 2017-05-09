<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-05-08
  Time: 01:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"/>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-8">

            <h1>${post.title}</h1>

            <p class="lead">
                by <a
                    href="${pageContext.request.contextPath}/profile/${post.author.username}">${post.author.username}</a>
            </p>

            <p><span class="glyphicon glyphicon-time"></span> ${post.postDate}</p>

            <hr>
            <img class="img-responsive"
                 src="https://prod-university-library.s3.amazonaws.com/uploads/activity/hero_image/10/post-it.png"
                 alt="">
            <hr>

            <p class="lead">
                ${post.postText}
            </p>


            <c:if test="${pageContext.request.userPrincipal.name == post.author.username}">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/posts/${post.id}/delete">Delete post</a>
            </c:if>

            <hr>

            <div class="well">
                <h4>Leave a comment:</h4>

                <form:form method="post" modelAttribute="comment">
                    <div class="form-group">
                        <form:textarea path="commentText" cssClass="form-control" rows="3"></form:textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form:form>

                <%--<form role="form">--%>
                <%--<div class="form-group">--%>
                <%--<textarea class="form-control" rows="3"></textarea>--%>
                <%--</div>--%>
                <%--<button type="submit" class="btn btn-primary">Submit</button>--%>
                <%--</form>--%>
            </div>
            <hr>

            <c:forEach var="comment" items="${post.comments}">
                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object" src="http://www.downvids.net/images/buffer.png" alt="">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading">
                            <a href="${pageContext.request.contextPath}/profile/${comment.user.username}">${comment.user.username}</a>
                            <small>${comment.commentDate}</small>
                        </h4>
                            ${comment.commentText}
                    </div>
                </div>
            </c:forEach>

        </div>


    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
