<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="/resources/styles/my_styles.css" type="text/css">
</head>
<body background="/resources/images/bg/posts-page.jpg" style="background-size: cover">
    <div>
        <form id="success" method="get" action="/">
            <span>${success}<br/></span>
            <button type="submit">${submit}</button>
        </form>
    </div>
</body>
</html>
