<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 02.09.2016
  Time: 7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StarExpress</title>
    <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<body style="background: url('/resources/images/stardeath.jpg')">
  <div class="form" id="signUp">
    <form:form method="post" action="/account/registration" commandName="userDTO">
      <form:input path="email" type="email" placeholder="E-mail" size="30" cssClass="field"/><br/>
        <form:errors path="email"/><br/>
      <form:password path="pass" placeholder="Password" size="30" cssClass="field"/><br/>
        <form:errors path="pass"/><br/>
      <form:password path="repeatPassword" placeholder="Repeat password" size="30" cssClass="field"/><br/>
        <form:errors path="repeatPassword"/><br/>
      <button type="submit"><spring:message code="message.label.signup"/></button>
      <button type="submit" formaction="/" formmethod="get">Back</button>
    </form:form>
  </div>
</body>
</html>
