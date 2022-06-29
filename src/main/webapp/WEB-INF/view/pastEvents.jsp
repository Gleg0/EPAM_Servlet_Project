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
                <th>
                    <fmt:message key="name-events"/>
                </th>
                <th>
                    <fmt:message key="date-events"/>
                </th>
                <th>
                    <fmt:message key="description-events"/>
                </th>
                <th>
                    <fmt:message key="number-of-participants"/>
                </th>
                <th>
                    <fmt:message key="number-of-reports"/>
                </th>
                <th>
                    <fmt:message key="reports-events"/>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty requestScope.eventList}">
                <tr>
                    <td colspan="2"> No events available </td>
                </tr>
            </c:if>
            <c:forEach var="event" items="${requestScope.eventList.content}" >
                <tr>
                    <td><span>${event.name}</span></td>
                    <td><span>${event.date}</span></td>
                    <td><span>${event.description}</span></td>
                    <td><span>${fn:length(event.users)}</span></td>
                    <td><span>${fn:length(event.reports)}</span></td>
                    <td>
                        <a type="button" class="btn btn-primary me-4" href="${pageContext.request.contextPath}/reports?eventId=' + ${event.id}}">
                            <fmt:message key="reports"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${requestScope.eventList.totalPages > 0}">
            <c:forEach var="pageNumber" items="${requestScope.pageNumbers}">
                <div class="col">
                    <a type="button" class="btn btn-primary me-4"
                       href="${pageContext.request.contextPath}/before?page=${pageNumber - 1}&sort=${requestScope.sort}">
                        ${pageNumber}
                    </a>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
</body>
</html>