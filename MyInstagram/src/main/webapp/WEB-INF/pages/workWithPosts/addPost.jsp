<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 09.09.2016
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%--i18--%>
<spring:message code="message.label.submit" var="submit"/>
<spring:message code="message.label.back" var="back"/>
<%--   --%>

<html>
<head>
    <title>StarExpress</title>
</head>
<c:if test="${sessionScope.idUser != null}">
    <body>
        <form:form action="/posts/newPost" method="post" commandName="post">
          <form:textarea path="message" cols="40" rows="5"/><br/>
            <form:errors path="message"/>
          <button type="submit">${submit}</button>
        </form:form>
        <button type="button" onclick="history.back()">${back}</button>
    </body>
</c:if>
</html>
