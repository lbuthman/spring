<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring 4 MVC with Maven</title>
        <link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />
    </head>
    <body>
        <h1>Maven + Spring MVC Web Project Example</h1>
        <h2>Message : ${message}</h2>
        <h2>Counter : ${counter}</h2>
    </body>
</html>
