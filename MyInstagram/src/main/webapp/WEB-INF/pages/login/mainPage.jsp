<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--i18--%>
<spring:message code="message.label.login" var="login"/>
<spring:message code="message.label.signup" var="signup"/>
<%--i18--%>

<html>
<head>
	<title>
		StarExpress
	</title>
	<link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<body style="background: url('/resources/images/bg/r2d2-bg-mainpage.jpg'); background-size: cover">
	<div class="form" id="mainPage">
		<span style="float: right; margin-top: 220px; margin-right: 10px;">
		<a href="?lang=en"><img src="/resources/images/flags/us.png"></a>
		<a href="?lang=ru"><img src="/resources/images/flags/ru.png"></a>
	</span>
		<form:form method="post" commandName="userDTO">
			<form:input path="email" type="email" placeholder="E-mail" size="30" cssClass="field"/><br/>
			<span id="login">
				<form:errors path="email"/>
			</span><br/>
			<form:password path="pass" placeholder="Password" size="30" cssClass="field"/><br/>
			<span id="login">
				<form:errors path="pass"/>
			</span><br/>
			<button type="submit" formaction="/account/login">${login}</button>
			<button type="submit" formmethod="get" formaction="/signup">${signup}</button>
		</form:form>
	</div>
</body>
</html>