<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/users" method="get">
    <div>
        ${requestScope.users}
    </div>
</form>
</body>
</html>