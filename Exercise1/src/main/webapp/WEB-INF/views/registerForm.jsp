<%--
  Created by IntelliJ IDEA.
  User: lbuthman
  Date: 7/13/17
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link
            rel="stylesheet"
            type="text/css"
            href="<c:url value="/resources/css/style.css" />" />
</head>
<body>
    <h1>Register</h1>

    <form method="post">
        First name: <input type="text" name="firstName"/><br/>
         Last name: <input type="text" name="lastName"/><br/>
          Username: <input type="text" name="username"/><br/>
          Password: <input type="text" name="password"/><br/>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>
