<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html xmlns:th="http://www.w3.org/1999/xhtml" xmlns:sec="http://www.w3.org/1999/xhtml">
<head th:insert="fragments/head.html :: head">
</head>
<body>
<div class="content">
    <nav th:insert="fragments/navbar.html"></nav>
    <div class="row">
        <h1 class="d-flex justify-content-center"></h1>
    </div>
    <div class="container-fluid me-4">
        <table class="table">
            <thead>
            <tr>
                <th th:text="#{name-events}"></th>
                <th>
                    <div class="container">
                        <div class="row">
                            <div class="col-sm">
                                <span th:text="#{date-events}"></span>
                            </div>
                            <div class="col-sm">
                                <a type="button" class="btn btn-primary" th:href="@{/events(page=${pageNumber},sort=date)}">⬆</a>
                            </div>
                            <div class="col-sm">
                                <a type="button" class="btn btn-primary" th:href="@{/events(page=${pageNumber},sort=dateDes)}">⬇</a>
                            </div>
                        </div>
                    </div>
                </th>
                <th th:text="#{description-events}"></th>
                <th>
                    <div class="container">
                        <div class="row">
                            <div class="col-sm">
                                <span th:text="#{number-of-participants}"></span>
                            </div>
                            <div class="col-sm">
                                <a type="button" class="btn btn-primary" th:href="@{/events(page=${pageNumber},sort=users)}">⬆</a>
                            </div>
                            <div class="col-sm">
                                <a type="button" class="btn btn-primary" th:href="@{/events(page=${pageNumber},sort=usersDes)}">⬇</a>
                            </div>
                        </div>
                    </div>
                </th>
                <th>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <span th:text="#{number-of-reports}"></span>
                            </div>
                            <div class="col">
                                <a type="button" class="btn btn-primary" th:href="@{/events(page=${pageNumber},sort=reports)}">⬆</a>
                            </div>
                            <div class="col">
                                <a type="button" class="btn btn-primary" th:href="@{/events(page=${pageNumber},sort=reportsDes)}">⬇</a>
                            </div>
                        </div>
                    </div>
                </th>
                <th th:text="#{reports-events}"></th>
            </tr>
            </thead>
            <tbody>
            <tr th:if="${eventList.empty}">
                <td colspan="2"> No events available </td>
            </tr>
            <tr th:each="event : ${eventList}">
                <td><span th:text="${event.name}"> Name </span></td>
                <td><span th:text="${#dates.format(event.date,'yyyy-MM-dd')}"> Data </span></td>
                <td><span th:text="${event.description}"> Description </span></td>
                <td><span th:text="${event.users.size()}"> Users </span></td>
                <td><span th:text="${event.reports.size()}"> Reports </span></td>
                <div sec:authorize="hasAuthority('MODERATOR')">
                    <td>
                        <a type="button" class="btn btn-primary me-4" th:href="@{'/add/report?eventId=' + ${event.id}}" th:text="#{add-report}"></a>
                        <a type="button" class="btn btn-primary me-4" th:href="@{'/edit/event?eventId=' + ${event.id}}" th:text="#{edit-event}"></a>
                        <a type="button" class="btn btn-primary me-4" th:href="@{'/reports?eventId=' + ${event.id}}" th:text="#{reports}"></a>
                    </td>
                </div>
                <div sec:authorize="hasAuthority('USER')">
                    <td>
                        <div th:with="users=${event.users},userID=${user}">
                            <div th:unless="${#lists.contains(users,user)}">
                                <a type="button" class="btn btn-primary me-4" th:href="@{'/regForEvent?eventId=' + ${event.id}}" th:text="#{reg-button}"></a>
                            </div>
                        </div>
                        <a type="button" class="btn btn-primary me-4" th:href="@{'/reports?eventId=' + ${event.id}}" th:text="#{reports}"></a>
                    </td>
                </div>
                <div sec:authorize="hasAuthority('SPEAKER')">
                    <td>
                        <a type="button" class="btn btn-primary me-4" th:href="@{/reports(eventId=${event.id})}" th:text="#{reports}"></a>
                        <a type="button" class="btn btn-primary me-4" th:href="@{/request(type=new_report,eventId=${event.id})}" th:text="#{req-new-report}"></a>
                    </td>
                </div>
            </tr>
            </tbody>
        </table>
        <div th:if="${eventList.totalPages > 0}" class="row"
             th:each="pageNumber : ${pageNumbers}">
            <div class="col">
                <a type="button" class="btn btn-primary me-4"
                   th:href="@{/events(page=${pageNumber - 1},sort=${sort})}"
                   th:text=${pageNumber}
                   th:class="${pageNumber==eventList.number + 1} ? active">
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>