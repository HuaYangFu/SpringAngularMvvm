<%--
  Created by IntelliJ IDEA.
  User: 傅華暘
  Date: 2016/9/28
  Time: 下午 06:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <div>
            <h1>Model</h1>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
                <c:forEach items="${userList}" var="emp">
                    <tr>
                        <th><c:out value="${emp.id}"/></th>
                        <th><c:out value="${emp.name}"/></th>
                        <th><c:out value="${emp.age}"/></th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
