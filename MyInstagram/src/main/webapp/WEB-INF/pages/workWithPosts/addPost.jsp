<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<%--i18--%>
<spring:message code="message.label.submit" var="submit"/>
<spring:message code="message.label.back" var="back"/>
<%--   --%>

<html>
<head>
    <title>StarExpress</title>
    <link rel="stylesheet" href="/resources/styles/my_styles.css" type="text/css">
</head>
<c:if test="${sessionScope.idUser != null}">
    <body style="background: url('/resources/images/bg/down-left.jpg');
        background-size: cover; background-attachment: fixed">
    <div class="inline" id="menu">
        <myTags:leftMenu/>
    </div>
    <div class="inline" id="mainColumn">
        <form:form action="/posts/newPost" method="post" commandName="post">
          <form:textarea path="message" cols="40" rows="5"/><br/>
            <form:errors path="message"/><br/>
          <button type="submit">${submit}</button>
          <%--<button type="button" onclick="history.back()">${back}</button>--%>
        </form:form>
    </div>
    </body>
</c:if>
<c:if test="${sessionScope.idUser == null}">
    <body background="/resources/images/error/error-page.jpg">
        <div id="mes">Power to see this page, you not have</div>
    </body>
</c:if>
</html>
