<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>
		StarExpress
	</title>
	<link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<body style="background: url('/resources/images/r2d2-bg-mainpage.jpg')">
	<span style="float: right">
		<a href="?lang=en">en</a>
		<a href="?lang=ru">ru</a>
    </span>
	<div class="form" id="mainPage">
		<form:form method="post" commandName="userDTO">
			<form:input path="email" type="email" placeholder="E-mail" size="30" cssClass="field"/><br/>
			<span id="login"><form:errors path="email"/></span><br/>
			<form:password path="pass" placeholder="Password" size="30" cssClass="field"/><br/>
			<span id="login"><form:errors path="pass"/></span><br/>
			<button formaction="/account/login" type="submit">
				<spring:message code="message.label.login"/>
			</button>
			<button type="submit" formmethod="get" formaction="/signup">
				<spring:message code="message.label.signup"/>
			</button>
		</form:form>
	</div>
</body>
</html>