<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/users/registration" method="post">

    <label>Email:
        <input type="text" name="email">
    </label><br>

    <button type="submit">Send</button>
</form>
</body>
</html>