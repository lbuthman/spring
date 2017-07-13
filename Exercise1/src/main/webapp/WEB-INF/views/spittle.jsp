<%--
  simple view of a single spittle
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Spittle</title>
        <link
                rel="stylesheet"
                type="text/css"
                href="<c:url value="/resources/css/style.css" />" />
    </head>
</head>
<body>
    <div class="spittleView">
        <div class="spittleMessage"><c:out value="${spittle.message}"/></div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}"/></span>
        </div>
    </div>
</body>
</html>
