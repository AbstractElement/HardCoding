<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 09.09.2016
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StarExpress</title>
</head>
<body>
    <form:form action="/posts/newPost" method="post" commandName="post">
      <form:textarea path="message" cols="40" rows="5"/><br/>
        <form:errors path="message"/>
      <button type="submit">
          <spring:message code="message.label.submit" />
      </button>
      <button type="button" onclick="history.back()">
          <spring:message code="message.label.back"/>
      </button>
    </form:form>
</body>
</html>
