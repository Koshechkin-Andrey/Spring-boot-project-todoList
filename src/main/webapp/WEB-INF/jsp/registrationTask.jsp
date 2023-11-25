<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/task/registrationTask" method="post">

    <textarea name="description" cols="50" rows="5">description:</textarea><br>

    <label>Date:
        <input type="datetime-local" name="date">
    </label><br>

    <label>User:
        <input type="number" name="userId">
    </label><br>



    <button type="submit">Send</button>
</form>
</body>
</html>