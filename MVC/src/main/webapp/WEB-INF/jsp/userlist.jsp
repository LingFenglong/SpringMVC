<%--
  User: LingFenglong
  Date: 2023/10/11
  Time: 15:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.servletContext.contextPath}"/>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

    <div class="container-sm">
        <table class="table">
            <tr>
                <td colspan="3" align="center">用户列表</td>
            </tr>
            <tr>
                <td>id</td>
                <td>username</td>
                <td>password</td>
            </tr>
            <c:forEach var="userInfo" items="${list}">
                <tr>
                    <td>${userInfo.id}</td>
                    <td>${userInfo.username}</td>
                    <td>${userInfo.password}</td>
                </tr>
            </c:forEach>
        </table>
        <a class="link-primary" href="${context}/user/adduser">添加</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/mhDoLbDldZc3qpsJHpLogda//BVZbgYuw6kof4u2FrCedxOtgRZDTHgHUhOCVim" crossorigin="anonymous"></script>
</body>
</html>
