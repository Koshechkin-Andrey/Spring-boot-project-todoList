<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/users/{id}" method="get">
    <div>
        <a href="${pageContext.request.contextPath}/task/${user.id}">${requestScope.user.email}</a>

    </div>
</form>
</body>
</html>