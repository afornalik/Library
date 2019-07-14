<%--
  Created by IntelliJ IDEA.
  User: Andrzej
  Date: 2019-07-13
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library | Author</title>
</head>
<body>
    <form method="post" action="AddAuthor">
        <h2>Author</h2>
        <label> name <br>
            <input type="text" name="firstName">
        </label>
        <br>
        <label> surname <br>
            <input type="text" name="lastName">
        </label>
        <input type="submit" value="add author">


    </form>
</body>
</html>
