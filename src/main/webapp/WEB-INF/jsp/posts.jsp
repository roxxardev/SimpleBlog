<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eryk
  Date: 2017-05-07
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"/>
<body>

<div class="container">

    <div class="row">
        <div class="col-md-8">
            <h1 class="page-header">
                Posts
                <small>PAI 2017</small>
            </h1>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/posts/create">Create new post</a>
            <c:forEach var="post" items="${posts.getContent()}">
                <h2>
                    <a href="${pageContext.request.contextPath}/posts/${post.id}">${post.title}</a>
                </h2>
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
                <p>${post.tease}</p>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/posts/${post.id}">Read more <span
                        class="glyphicon glyphicon-chevron-right"></span> </a>
                <hr>
            </c:forEach>

            <ul class="pager">
                <li class="previous">
                    <a href="${pageContext.request.contextPath}/posts/?page=${param.page +1}">&larr; Older</a>
                </li>
                <li class="next">
                    <c:if test="${param.page > 0}">
                        <a href="${pageContext.request.contextPath}/posts/?page=${param.page - 1}">Newer &rarr;</a>
                    </c:if>
                </li>
            </ul>

        </div>
        <div class="col-md-4">

            <!-- Blog Search Well -->
            <div class="well">
                <h4>Blog Search</h4>
                <div class="input-group">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
                            <button class="btn btn-default" type="button">
                                <span class="glyphicon glyphicon-search"></span>
                        </button>
                        </span>
                </div>
                <!-- /.input-group -->
            </div>

            <!-- Blog Categories Well -->
            <div class="well">
                <h4>Blog Categories</h4>
                <div class="row">
                    <div class="col-lg-6">
                        <ul class="list-unstyled">
                            <li><a href="#">Category Name</a>
                            </li>
                            <li><a href="#">Category Name</a>
                            </li>
                            <li><a href="#">Category Name</a>
                            </li>
                            <li><a href="#">Category Name</a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.col-lg-6 -->
                    <div class="col-lg-6">
                        <ul class="list-unstyled">
                            <li><a href="#">Category Name</a>
                            </li>
                            <li><a href="#">Category Name</a>
                            </li>
                            <li><a href="#">Category Name</a>
                            </li>
                            <li><a href="#">Category Name</a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.col-lg-6 -->
                </div>
                <!-- /.row -->
            </div>

            <!-- Side Widget Well -->
            <div class="well">
                <h4>Side Widget Well</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus
                    laudantium odit aliquam repellat tempore quos aspernatur vero.</p>
            </div>

        </div>

    </div>
    <!-- /.row -->

    <hr>

</div>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
