<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE>
<html xmlns:fmt="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
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
                    <div class="container">
                        <div class="row">
                            <div class="col-sm">
                                <span><fmt:message key="date-events"/></span>
                            </div>
                            <div class="col-sm">
                                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/events?page=${pageNumber}&sort=date">⬆</a>
                            </div>
                            <div class="col-sm">
                                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/events?page=${pageNumber}&sort=dateDes">⬇</a>
                            </div>
                        </div>
                    </div>
                </th>
                <th><fmt:message key="description-events"/></th>
                <th>
                    <div class="container">
                        <div class="row">
                            <div class="col-sm">
                                <span><fmt:message key="number-of-participants"/></span>
                            </div>
                            <div class="col-sm">
                                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/events?page=${pageNumber}&sort=users">⬆</a>
                            </div>
                            <div class="col-sm">
                                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/events?page=${pageNumber}&sort=usersDes">⬇</a>
                            </div>
                        </div>
                    </div>
                </th>
                <th>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <span><fmt:message key="number-of-reports"/></span>
                            </div>
                            <div class="col">
                                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/events?page=${pageNumber}&sort=reports">⬆</a>
                            </div>
                            <div class="col">
                                <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/events?page=${pageNumber}&sort=reportsDes">⬇</a>
                            </div>
                        </div>
                    </div>
                </th>
                <th><fmt:message key="reports-events"/></th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty requestScope.eventList}">
                <tr>
                    <td colspan="2"> No events available </td>
                </tr>
            </c:if>
            <c:forEach var="event" items="${requestScope.eventList.content}" >
                <td><span>${event.name}</span></td>
                <td><span>${event.date}</span></td>
                <td><span>${event.description}</span></td>
                <td><span>${fn:length(event.users)}</span></td>
                <td><span>${fn:length(event.reports)}</span></td>
                <c:if test="${requestScope.user.role == 'MODERATOR'}">
                    <td>
                        <a type="button" class="btn btn-primary me-4" href="${pageContext.request.contextPath}/add/report?eventId=${event.id}"><fmt:message key="add-report"/></a>
                        <a type="button" class="btn btn-primary me-4" href="${pageContext.request.contextPath}/edit/event?eventId=${event.id}"><fmt:message key="edit-event"/></a>
                        <a type="button" class="btn btn-primary me-4" href="${pageContext.request.contextPath}/reports?eventId=${event.id}"><fmt:message key="reports"/></a>
                    </td>
                </c:if>
                <c:if test="${requestScope.user.role == 'USER'}">
                    <td>
                        <c:set var="contains" value="false" />
                        <c:forEach var="user" items="${requestScope.users}">
                            <c:if test="${user eq sessionScope.user}">
                                <c:set var="contains" value="true" />
                            </c:if>
                        </c:forEach>
                        <c:if test="${contains}">
                            <a type="button" class="btn btn-primary me-4" href="${pageContext.request.contextPath}/regForEvent?eventId=${event.id}"><fmt:message key="reg-button"/></a>
                        </c:if>
                        <a type="button" class="btn btn-primary me-4" href="${pageContext.request.contextPath}/reports?eventId=${event.id}"><fmt:message key="reports"/></a>
                    </td>
                </c:if>
                <c:if test="${requestScope.user.role == 'SPEAKER'}">
                    <td>
                        <a type="button" class="btn btn-primary me-4" href="${pageContext.request.contextPath}/reports?eventId=${event.id}"><fmt:message key="reports"/></a>
                        <a type="button" class="btn btn-primary me-4" href="${pageContext.request.contextPath}/request?type=new_report&eventId=${event.id}"><fmt:message key="req-new-report"/></a>
                    </td>
                </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            <c:if test="${requestScope.eventList.totalPages > 0}">
                <c:forEach var="pageNumber" items="${requestScope.pageNumbers}">
                    <div class="col">
                        <a type="button" class="btn btn-primary me-4"
                           href="${pageContext.request.contextPath}/events?page=${pageNumber - 1}&sort=${requestScope.sort}">
                            ${pageNumber}
                        </a>
                    </div>
                </c:forEach>
            </c:if>
    </div>
</div>
</body>
</html>