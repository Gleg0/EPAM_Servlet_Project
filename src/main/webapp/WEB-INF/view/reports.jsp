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
    <%@include file="jspf/navbar.jspf"%><div class="row">
    <h1 class="d-flex justify-content-center"></h1>
</div>
    <div class="container-fluid me-4">
        <table class="table">
            <thead>
            <tr>
                <th>
                    <fmt:message key="name-reports"/>
                </th>
                <th>
                    <fmt:message key="name-of-speaker"/>
                </th>
                <th>
                    <fmt:message key="description-reports"/>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty requestScope.reportList}">
                <tr>
                    <td colspan="2"> No events available </td>
                </tr>
            </c:if>
            <c:forEach items="${reportList}" var="report">
                <tr>
                    <td><span>${report.name}</span></td>
                    <c:if test="${requestScope.user.role == 'SPEAKER'}">
                        <c:if test="${report.speaker != null}">
                            <td><span>${report.speaker.username}</span></td>
                        </c:if>
                        <c:if test="${report.speaker == null}">
                            <c:set var="contains" value="false" />
                            <c:forEach var="user" items="${requestScope.listsOfReqId}">
                                <c:if test="${user eq report.id}">
                                    <c:set var="contains" value="true" />
                                </c:if>
                            </c:forEach>
                            <c:if test="${contains}">
                                <td>
                                    <a type="button disable" class="btn btn-primary me-4">
                                        <fmt:message key="request-new-speaker"/>
                                    </a>
                                </td>
                            </c:if>
                            <c:if test="${!contains}">
                                <td>
                                    <a type="button " class="btn btn-primary me-4" th:href="@{/request(type=new_speaker,reportId=${report.id})}" th:text="#{request-new-speaker}"></a>
                                </td>
                            </c:if>
                        </c:if>
                    </c:if>
                    <c:if test="${requestScope.user.role == 'USER'}">
                        <div th:if="${report.speaker != null}">
                            <td><span th:text="${report.speaker.username}"> Speaker </span></td>
                        </div>
                        <div th:unless="${report.speaker != null}">
                            <td>
                                <span th:text="#{no-speaker}"> Speaker </span>
                            </td>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.user.role == 'MODERATOR'}">
                        <c:if test="${report.speaker != null}">
                            <td><span>${report.speaker.username}</span></td>
                        </c:if>
                        <c:if test="${report.speaker == null}">
                            <td>
                                <span><fmt:message key="no-speaker"/></span>
                            </td>
                        </c:if>
                    </c:if>
                    <td><span>${report.description}</span></td>
                    <td>
                        <c:if test="${requestScope.user.role == 'MODERATOR'}">
                            <a class="btn btn-primary"
                               href="${pageContext.request.contextPath}/edit/report?reportId=${report.id}">
                                <fmt:message key="edit-report"/>
                            </a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>