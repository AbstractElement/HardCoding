<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 01.09.2016
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successful</title>
</head>
<body>
    <spring:message code="message.label.successful"/> <br/>
    <form method="get" action="/">
        <button type="submit">
            <spring:message code="message.label.submit"/>
        </button>
    </form>
</body>
</html>
