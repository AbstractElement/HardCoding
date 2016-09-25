<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 02.09.2016
  Time: 7:21
  To change this template use File | Settings | File Templates.
--%>

<%--i18--%>
<spring:message code="message.label.signup" var="signup"/>
<spring:message code="message.label.back" var="back"/>
<%--   --%>

<html>
<head>
    <title>StarExpress</title>
    <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<body style="background: url('/resources/images/bg/stardeath.jpg')">
  <div class="form" id="signUp">
    <form:form method="post" action="/account/registration" commandName="userDTO">
      <form:input path="email" type="email" placeholder="E-mail" size="30" cssClass="field"/><br/>
      <span id="reg">
        <form:errors path="email"/>
      </span><br/>
      <form:password path="pass" placeholder="Password" size="30" cssClass="field"/><br/>
      <span id="reg">
        <form:errors path="pass"/>
      </span><br/>
      <form:password path="repeatPassword" placeholder="Repeat password" size="30" cssClass="field"/><br/>
      <span id="reg">
        <form:errors path="repeatPassword"/>
      </span><br/>
      <button type="submit">${signup}</button>
      <button type="submit" formaction="/" formmethod="get">${back}</button>
    </form:form>
  </div>
</body>
</html>
