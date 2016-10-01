<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<%--i18--%>
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
<spring:message text="/resources/images/avatar/1.jpg" var="img1"/>
<spring:message text="/resources/images/avatar/2.jpg" var="img2"/>
<spring:message text="/resources/images/avatar/3.jpg" var="img3"/>
<spring:message text="/resources/images/avatar/4.jpg" var="img4"/>
<spring:message text="/resources/images/avatar/5.jpg" var="img5"/>
<spring:message text="/resources/images/avatar/6.jpg" var="img6"/>
<spring:message text="/resources/images/avatar/7.jpg" var="img7"/>
<spring:message text="/resources/images/avatar/8.jpg" var="img8"/>
<spring:message text="/resources/images/avatar/9.jpg" var="img9"/>
<%----%>

<html>
<head>
    <title>StarExpress</title>
    <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<c:if test="${sessionScope.idUser != null}">
    <body style="background: url('/resources/images/bg/soldier-left.jpg');
    background-size: cover; background-attachment: fixed; background-repeat: no-repeat">
    <div class="inline" id="menu">
        <myTags:leftMenu/>
    </div>
    <form:form action="/profile/saveEdit" method="post" commandName="editProfile">
        <form:input path="idProfile"/>
        <%--<form:input path="currentUser"/>--%>
        <div class="inline" id="mainColumn">
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
            </table>
            <form:radiobutton path="avatar" value="1.jpg"/><img style="width: 100px" src="${img1}"/>
            <form:radiobutton path="avatar" value="2.jpg"/><img style="width: 100px" src="${img2}"/>
            <form:radiobutton path="avatar" value="3.jpg"/><img style="width: 100px" src="${img3}"/><br/>
            <form:radiobutton path="avatar" value="4.jpg"/><img style="width: 100px" src="${img4}"/>
            <form:radiobutton path="avatar" value="5.jpg"/><img style="width: 100px" src="${img5}"/>
            <form:radiobutton path="avatar" value="6.jpg"/><img style="width: 100px" src="${img6}"/><br/>
            <form:radiobutton path="avatar" value="7.jpg"/><img style="width: 100px" src="${img7}"/>
            <form:radiobutton path="avatar" value="8.jpg"/><img style="width: 100px" src="${img8}"/>
            <form:radiobutton path="avatar" value="9.jpg"/><img style="width: 100px" src="${img9}"/><br/>
            <button type="submit">${submit}</button>
               <%--<button type="button" onclick="history.back()">${back}</button>--%>
        </div>
    </form:form>
    </body>
</c:if>
<c:if test="${sessionScope.idUser == null}">
    <body background="/resources/images/error/error-page.jpg">
        <div id="mes">Power to see this page, you not have</div>
    </body>
</c:if>
</html>
