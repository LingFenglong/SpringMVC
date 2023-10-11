<%--
  User: LingFenglong
  Date: 2023/10/11
  Time: 15:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.servletContext.contextPath}"/>

<html>
<head>
    <title>Add</title>
</head>
<body>
    <form method="post" target="${context}/user/add">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="text" name="password"><br/>
        <input type="submit"><br/>
    </form>
</body>
</html>
