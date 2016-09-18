<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 05.09.2016
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StarExpress</title>
</head>
<body>
    <form:form action="/profile/saveEdit" method="post" commandName="editProfile">
        <table>
            <tr>
                <td><spring:message code="message.label.firstName"/>:</td>
                <td><form:input path="firstName" size="30" placeholder = "First Name"/></td>
            </tr>
            <tr>
                <td><spring:message code="message.label.secondName"/>:</td>
                <td><form:input path="lastName" size="30" placeholder = "Last Name"/></td>
            </tr>
            <tr>
                <td><spring:message code="message.label.currentCity"/>:</td>
                <td><form:input path="currentCity" size="30" placeholder = "Current City"/></td>
            </tr>
            <tr>
                <td><spring:message code="message.label.phone"/>:</td>
                <td><form:input path="phoneNumber" size="30" placeholder = "+375XXXXXXXXXX"/></td>
            </tr>
            <tr>
                <td><spring:message code="message.label.age"/>:</td>
                <td><form:input type="number" min="1" max="101" path="age" size="2"/></td>
            </tr>
            <tr>
                <td><spring:message code="message.label.sex"/>:</td>
                <td>
                    <form:radiobutton path="sex" value="Male"/><spring:message code="message.label.sex.male"/>
                    <form:radiobutton path="sex" value="Female" name="Female"/><spring:message code="message.label.sex.female"/>
                    <form:radiobutton path="sex" value="Other" name="Other"/><spring:message code="message.label.sex.other"/>
                </td>
            </tr>
        </table>
        <button type="submit">
            <spring:message code="message.label.submit"/>
        </button>
        <button type="button" onclick="history.back()">
            <spring:message code="message.label.back"/>
        </button>
    </form:form>
</body>
</html>
