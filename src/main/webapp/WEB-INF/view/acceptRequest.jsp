<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <%@include file="jspf/head.jspf"%>
</head>
<body>
<div class="content">
    <%@include file="jspf/navbar.jspf"%>
    <div class="row">
        <h1 class="d-flex justify-content-center"></h1>
    </div>
    <div class="container-fluid me-4">
        <table class="table">
            <thead>
            <tr>
                <th><fmt:message key="type"/></th>
                <th><fmt:message key="acceptRequest"/></th>
                <th><fmt:message key="speaker"/></th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty requestList}">
                <tr>
                    <td colspan="2"> No request available </td>
                </tr>
            </c:if>
            <c:forEach items="${requestList}" var="userRequest">
                <tr>
                    <td><span>${userRequest.type}</span></td>
                    <td><span>${userRequest.report.name}</span></td>
                    <td><span>${userRequest.user.username}</span></td>
                    <td>
                        <a class="btn btn-primary"
                           href="${pageContext.request.contextPath}/acceptRequest?requestId=${userRequest.id}">
                            <fmt:message key="accept"/>
                        </a>
                        <a class="btn btn-primary"
                           href="${pageContext.request.contextPath}/acceptRequest?requestId=${userRequest.id}&reject=reject">
                            <fmt:message key="reject"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>