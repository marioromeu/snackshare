<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>User Registration</title>
    </head>
    <body>
        <form action="#" th:action="@{/register}" 
          th:object="${user}" method="post">
            Email:<input type="text" th:field="*{email}" />
            Password:<input type="password" th:field="*{password}" />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>