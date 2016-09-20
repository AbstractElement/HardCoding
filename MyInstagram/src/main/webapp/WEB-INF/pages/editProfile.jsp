<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 05.09.2016
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>

<%----%>
<spring:message code="message.label.firstName" var="firstName"/>
<spring:message code="message.label.secondName" var="secondName"/>
<spring:message code="message.label.currentCity" var="currentCity"/>
<spring:message code="message.label.phone" var="phone"/>
<spring:message code="message.label.age" var="age"/>
<spring:message code="message.label.sex" var="sex"/>
<spring:message code="message.label.sex.male" var="male"/>
<spring:message code="message.label.sex.female" var="female"/>
<spring:message code="message.label.sex.other" var="other"/>
<spring:message code="message.label.submit" var="submit"/>
<spring:message code="message.label.back" var="back"/>
<%----%>

<html>
<head>
    <title>StarExpress</title>
    <link href="/resources/styles/my_styles.css">
</head>
<body>
    <form:form action="/profile/saveEdit" method="post" commandName="editProfile">
        <table>
            <tr>
                <td>${firstName}:</td>
                <td><form:input path="firstName" size="30" placeholder = "First Name"/></td>
            </tr>
            <tr>
                <td>${secondName}:</td>
                <td><form:input path="lastName" size="30" placeholder = "Last Name"/></td>
            </tr>
            <tr>
                <td>${currentCity}:</td>
                <td><form:input path="currentCity" size="30" placeholder = "Current City"/></td>
            </tr>
            <tr>
                <td>${phone}:</td>
                <td><form:input path="phoneNumber" size="30" placeholder = "+375XXXXXXXXXX"/></td>
            </tr>
            <tr>
                <td>${age}:</td>
                <td><form:input type="number" min="1" max="101" path="age" size="2"/></td>
            </tr>
            <tr>
                <td>${sex}:</td>
                <td>
                    <form:radiobutton path="sex" value="male.png"/>${male}
                    <form:radiobutton path="sex" value="female.png"/>${female}
                    <form:radiobutton path="sex" value="other.png"/>${other}
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:radiobutton path="avatar" value="1.jpg"/><img style="width: 100px" src="/resources/images/avatar/1.jpg"/>
                    <form:radiobutton path="avatar" value="2.jpg"/><img style="width: 100px" src="/resources/images/avatar/2.jpg"/>
                    <form:radiobutton path="avatar" value="3.jpg"/><img style="width: 100px" src="/resources/images/avatar/3.jpg"/>
                    <form:radiobutton path="avatar" value="4.jpg"/><img style="width: 100px" src="/resources/images/avatar/4.jpg"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:radiobutton path="avatar" value="5.jpg"/><img style="width: 100px" src="/resources/images/avatar/5.jpg"/>
                    <form:radiobutton path="avatar" value="6.jpg"/><img style="width: 100px" src="/resources/images/avatar/6.jpg"/>
                    <form:radiobutton path="avatar" value="7.jpg"/><img style="width: 100px" src="/resources/images/avatar/7.jpg"/>
                    <form:radiobutton path="avatar" value="8.jpg"/><img style="width: 100px" src="/resources/images/avatar/8.jpg"/>
                </td>
            </tr>
        </table>
        <button type="submit">${submit}</button>
        <button type="button" onclick="history.back()">${back}</button>
    </form:form>
</body>
</html>
