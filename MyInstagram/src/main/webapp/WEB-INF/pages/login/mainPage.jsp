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
	<%---<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/jquery.jqplot.js"></script>
	<script type="text/javascript" src="/resources/plugins/jqplot.dateAxisRenderer.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/jquery.jqplot.css" />
	<script>
		$(document).ready(function(){
			var line1=[['2008-08-12 4:00PM',4], ['2008-09-12 4:00PM',6.5], ['2008-10-12 4:00PM',5.7],
				['2008-11-12 4:00PM',9], ['2008-12-12 4:00PM',8.2]];
			var plot1 = $.jqplot('chart1', [line1], {
				title:'Default Date Axis',
				axes:{
					xaxis:{
						renderer:$.jqplot.DateAxisRenderer
					}
				},
				series:[{lineWidth:4, markerOptions:{style:'square'}}]
			});
		});
	</script>--%>
</head>
<body style="background: url('/resources/images/bg/r2d2-bg-mainpage.jpg'); background-size: cover">
	<div class="form" id="mainPage">
		<span style="float: right; margin-top: 220px; margin-right: 10px;">
			<a href="/?lang=en"><img src="/resources/images/flags/us.png"></a>
			<a href="/?lang=ru"><img src="/resources/images/flags/ru.png"></a>
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