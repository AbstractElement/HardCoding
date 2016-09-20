<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 01.09.2016
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>

<%--i18--%>
<spring:message code="message.label.successful" var="success"/>
<spring:message code="message.label.submit" var="submit"/>
<%--   --%>

<html>
<head>
    <title>StarExpress</title>
</head>
<body>
    ${success}<br/>
    <form method="get" action="/">
        <button type="submit">${submit}</button>
    </form>
</body>
</html>
