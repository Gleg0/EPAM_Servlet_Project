<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<html >
<head>
    <%@include file="jspf/head.jspf"%>
</head>
<body>
<div class="content">
    <nav>
        <%@include file="jspf/navbar.jspf"%>
    </nav>
    <div class="container mt-4">
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="row mb-2">
                <h1><fmt:message key="log-in"/></h1>
            </div>
            <div class="row col-4">
                <input class="form-control mb-2" name="username" placeholder="Login">
            </div>
            <div class="row col-4">
                <input class="form-control mb-2" type="password" name="password" placeholder="Password">
            </div>
            <div class="row col-4">
                <button type="submit" class="btn btn-primary"><fmt:message key="log-in"/></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>