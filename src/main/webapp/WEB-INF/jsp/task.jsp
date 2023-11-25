<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>Users</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/task/{id}" method="get">
    <div>
        ${requestScope.task}
    </div>
</form>
</body>
</html>